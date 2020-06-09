<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<style>
    .ui-jqgrid .ui-userdata {
        padding: 13px 94px;
        overflow: hidden;
        min-height: 32px;
    }

    .modal-body {
        position: relative;
        padding: 21px 130px;
    }

    #myH2 {
        margin-top: -39px;
        margin-bottom: 10px;
    }
</style>
<script>
    $(function () {
        $("#albums").jqGrid({
            url: "${pageContext.request.contextPath}/album/albumPager",
            datatype: "json",
            styleUI: "Bootstrap",
            autowidth: true,
            pager: "#albumPager",
            colNames: ["编号", "标题", "分数", "作者", "播音员", "章节数", "专辑简介", "发行时间", "状态", "插图"],
            rowNum: 3,
            rowList: [3, 6, 9],
            caption: "专辑",       //表格标题
            viewrecords: true,
            height: 400,
            colModel: [
                {name: "id"},
                {name: "title"},
                {name: "score"},
                {name: "author"},
                {name: "broadcaster"},
                {name: "count"},
                {name: "brief"},
                {name: "createDate"},
                {name: "status"},
                {
                    name: "img",
                    formatter: function (cellValue) {
                        return "<img style=\"height: 60px;width: 100%\" src='${pageContext.request.contextPath}/img/" + cellValue + "' />"
                    }
                }
            ],
            subGrid: true,       //子表格
            subGridRowExpanded: function (subGridId, albumId) {
                //添加子表格的方法
                addSubGrid(subGridId, albumId);
            }
        }).jqGrid("navGrid", "#albumPager",
            {search: false},             //隐藏搜索按钮
        );
    });

    //添加子表格
    function addSubGrid(subGridId, albumId) {
        //动态子表格id
        var subGridTableId = subGridId + "table";
        //动态divid
        var subGridDivId = subGridId + "div";
        //动态添加子表格
        $("#" + subGridId).html("<table id='" + subGridTableId + "'></table>" +
            "<div id='" + subGridDivId + "' style='height: 50px;'></div>"
        )
        $("#" + subGridTableId).jqGrid({
            url: "${pageContext.request.contextPath}/chapter/chapterPager?albumId=" + albumId,
            editurl: "${pageContext.request.contextPath}/chapter/edit?albumId=" + albumId,
            datatype: "json",
            styleUI: "Bootstrap",
            autowidth: true,
            records: true,
            rowNum: 2,
            rowList: [2, 4, 6],
            caption: "章节",
            pager: "#" + subGridDivId,
            multiselect: true,
            toolbar: [true, "top"],
            colNames: ["Id", "标题", "大小", "时长", "音频", "状态"],
            colModel: [
                {name: "id"},
                {name: "title", editable: true},
                {name: "size"},
                {name: "duration"},
                {name: "src", editable: true, edittype: "file"},
                {
                    name: "status", editable: true, edittype: "select",
                    editoptions: {value: "展示:展示;不展示:不展示"}
                }
            ]
        }).jqGrid("navGrid", "#" + subGridDivId, {},
            {//修改
                closeAfterEdit: true,
                afterSubmit: function (response) {
                    var msg = response.responseJSON.msg;
                    //获取chapterId
                    var chapterId = response.responseJSON.chapterId;
                    //当chapterId为空时   则证明没有修改音频文件
                    if (chapterId != null) {
                        //上传
                        $.ajaxFileUpload({
                            url: "${pageContext.request.contextPath}/chapter/uploadChapter",
                            type: "post",
                            data: {chapterId: chapterId},
                            fileElementId: "src",          //后台接收上传文件
                            success: function () {
                                //刷新表格
                                $("#" + subGridTableId).trigger("reloadGrid")
                                //提示信息回显
                                $("#myMsg").html(msg).show();
                                setTimeout(function () {
                                    $("#myMsg").hide();
                                }, 3000)
                            }
                        })
                    }
                    //刷新表格
                    $("#" + subGridTableId).trigger("reloadGrid")
                    //提示信息回显
                    $("#myMsg").html(msg).show();
                    setTimeout(function () {
                        $("#myMsg").hide();
                    }, 3000)
                    return response;
                }
            },
            {//添加
                closeAfterAdd: true,
                afterSubmit: function (response) {
                    var msg = response.responseJSON.msg;
                    //获取chapterId
                    var chapterId = response.responseJSON.chapterId;
                    //上传
                    $.ajaxFileUpload({
                        url: "${pageContext.request.contextPath}/chapter/uploadChapter",
                        type: "post",
                        data: {chapterId: chapterId},
                        fileElementId: "src",          //后台接收上传文件
                        success: function () {
                            //刷新表格
                            $("#" + subGridTableId).trigger("reloadGrid")
                            //提示信息回显
                            $("#myMsg").html(msg).show();
                            setTimeout(function () {
                                $("#myMsg").hide();
                            }, 3000)
                        }
                    })
                    return response;
                }
            },
            {//删除
                afterComplete: function (response) {
                    var msg = response.responseJSON.msg;
                    //获取chapterId
                    var chapterId = response.responseJSON.chapterId;
                    //刷新表格
                    $("#" + subGridTableId).trigger("reloadGrid")
                    //提示信息回显
                    $("#myMsg").html(msg).show();
                    setTimeout(function () {
                        $("#myMsg").hide();
                    }, 3000)
                }
            }
        )
        //播放下载按钮
        $("#t_" + subGridTableId).html(
            "<button class='btn btn-lg btn-primary' onclick=\"play('" + subGridTableId + "')\"><span class='glyphicon glyphicon-play-circle'></span></button>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
            + "<button class='btn btn-lg btn-primary' onclick=\"downLoad('" + subGridTableId + "')\"><span class='glyphicon glyphicon-save'></span></button>"
        )
    }

    //播放
    function play(subGridTableId) {
        // 判断 用户是否选中一行  未选中->null         选中->被选中行的id
        var gr = $("#" + subGridTableId).jqGrid('getGridParam', 'selrow');
        if (gr == null) {
            alert("请选中要播放的音频");
        } else {
            //1.请求后台
            //2.jqgrid 提供的方法 根据id拿到对应的值
            var data = $("#" + subGridTableId).jqGrid('getRowData', gr);        //获取当前行的所有信息
            $('#myModal').modal('show');
            //为src添加值
            $("#myAudio").attr("src", "${pageContext.request.contextPath}/upload/audio/" + data.src);
        }
    }

    //音频下载
    function downLoad(subGridTableId) {
        // 判断 用户是否选中一行  未选中->null         选中->被选中行的id
        var gr = $("#" + subGridTableId).jqGrid('getGridParam', 'selrow');
        if (gr == null) {
            alert("请选中要下载的音频");
        } else {
            var data = $("#" + subGridTableId).jqGrid('getRowData', gr);
            //获取当前行音频文件名
            var src = data.src;
            location.href = '${pageContext.request.contextPath}/chapter/downLoadChapter?src=' + src;
        }
    }
</script>
<div class="page-header">
    <h2 id="myH2">专辑管理</h2>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active">
        <a href="#home" aria-controls="home" role="tab" data-toggle="tab">专辑信息</a>
    </li>
</ul>
<div>
    <table id="albums"></table>
</div>
<div id="albumPager" style="height: 50px;"></div>
<div id="myMsg" class="alert alert-success" style="display: none"></div>

<%--模态框--%>
<div class="modal fade" tabindex="-1" role="dialog" id="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">播放器</h4> <%--莫泰框标题--%>
            </div>
            <div class="modal-body">
                <audio controls src="" id="myAudio"></audio>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
