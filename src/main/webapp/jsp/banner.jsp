<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<style>
    #myh2 {
        margin-top: -39px;
        margin-bottom: 10px;
    }
</style>
<script>
    $(function () {
        $("#list").jqGrid({
            url: "${pageContext.request.contextPath}/banner/querybannerByPager",
            editurl: "${pageContext.request.contextPath}/banner/editBanner",
            datatype: "json",
            styleUI: "Bootstrap",
            colNames: ["ID", "标题", "创建时间", "状态", "图片"],
            rowNum: 5,               //每页展示的条数
            rowList: [3, 5, 10],
            viewrecords: true,       //是否记录总条数
            autowidth: true,        //适应父容器
            multiselect: true,       //多选框
            height: '400px',
            pager: "#myPager",
            colModel: [
                {name: "id"},
                {name: "title", editable: true},
                {name: "createDate", editable: true, edittype: "date"},
                {
                    name: "status", editable: true, edittype: "select",
                    editoptions: {value: "展示:展示;不展示:不展示"}
                },
                {
                    name: "img", editable: true, edittype: "file",
                    formatter: function (cellValue) {
                        return "<img style='width:100%;height:100px' src='${pageContext.request.contextPath}/upload/img/" + cellValue + "'/>"
                    }
                }
            ]
        }).jqGrid("navGrid", "#myPager",
            {search: false},
            {//修改
                closeAfterEdit: true,
                afterSubmit: function (response) {
                    //接收后台响应
                    var msg = response.responseJSON.msg;
                    var bannerId = response.responseJSON.bannerId;
                    if (bannerId != null) {
                        //上传部分
                        $.ajaxFileUpload({
                            url: "${pageContext.request.contextPath}/banner/bannerUpload",
                            type: "post",
                            fileElementId: "img",
                            data: {bannerId: bannerId},
                            success: function () {
                                //刷新数据表格
                                $("#list").trigger("reloadGrid");
                                //提示信息回显
                                $("#myMsg").html(msg).show();
                                setTimeout(function () {
                                    $("#myMsg").hide();
                                }, 3000)
                            }
                        });
                    }
                    return response;
                }
            },
            {//添加
                closeAfterAdd: true,
                afterSubmit: function (response) {
                    //接收后台响应
                    var msg = response.responseJSON.msg;
                    var bannerId = response.responseJSON.bannerId;
                    $.ajaxFileUpload({
                        url: "${pageContext.request.contextPath}/banner/bannerUpload",
                        type: "post",
                        fileElementId: "img",
                        data: {bannerId: bannerId},
                        success: function () {
                            //刷新数据表格
                            $("#list").trigger("reloadGrid");
                            //提示信息回显
                            $("#myMsg").html(msg).show();
                            setTimeout(function () {
                                $("#myMsg").hide();
                            }, 3000)
                        }
                    });
                    return response;
                }
            },
            {//删除
                afterComplete: function (response) {
                    var msg = response.responseJSON.msg;
                    //刷新数据表格
                    $("#list").trigger("reloadGrid");
                    //提示信息回显
                    $("#myMsg").html(msg).show();
                    setTimeout(function () {
                        $("#myMsg").hide();
                    }, 3000)
                }
            }
        );      //jqGrid结束
    })
</script>
<div class="page-header">
    <h2 id="myh2">轮播图管理</h2>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active">
        <a href="#home" aria-controls="home" role="tab" data-toggle="tab">轮播图信息</a>
    </li>
</ul>
<div>
    <table id="list"></table>
</div>
<div id="myPager" style="height: 50px"></div>
<div id="myMsg" class="alert alert-success" style="display: none"></div>