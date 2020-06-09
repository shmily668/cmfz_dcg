<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<style>
    #myh {
        margin-top: -39px;
        margin-bottom: 10px;
    }
</style>
<script>
    $(function () {
        $("#Myarticle").jqGrid({
            url: "${pageContext.request.contextPath}/article/artilceByPager",
            editurl: "${pageContext.request.contextPath}/article/edit",
            datatype: "json",
            autowidth: true,
            styleUI: "Bootstrap",
            rowNum: 2,
            rowList: [2, 4, 6],
            multiselect: true,
            height: 300,
            pager: "#articlePager",
            viewrecords: true,
            colNames: ["ID", "标题", "作者", "上传时间", "状态"],
            colModel: [
                {name: "id"},
                {name: "title"},
                {name: "author"},
                {name: "createDate"},
                {name: "status"}
            ]
        }).jqGrid("navGrid", "#articlePager",
            {search: false},
            {},
            {},
            {//删除
                afterComplete: function (response) {
                    var msg = response.responseJSON.msg;
                    //表格刷新
                    $("#Myarticle").trigger("reloadGrid");
                    $("#MyMsg").html(msg).show();
                    setTimeout(function () {
                        $("#MyMsg").hide();
                    }, 2000)
                }
            }
        );
    })
</script>
<div class="page-header">
    <h2 id="myh">文章管理</h2>
</div>
<ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active">
        <a href="#home" aria-controls="home" role="tab" data-toggle="tab">文章信息</a>
    </li>
</ul>
<div>
    <table id="Myarticle"></table>
</div>
<div id="articlePager" style="height: 50px"></div>
<%--提示信息--%>
<div id="MyMsg" class="alert alert-success" style="height: 50px"></div>
