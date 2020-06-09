<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="app"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <%--bootstrap核心css--%>
    <link rel="stylesheet" href="${app}/boot/css/bootstrap.min.css">
    <%--jgGrid核心css--%>
    <link rel="stylesheet" href="${app}/jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
    <%--jquery核心js--%>
    <script src="${app}/boot/js/jquery-2.2.1.min.js"></script>
    <%--bootstrap核心js--%>
    <script src="${app}/boot/js/bootstrap.min.js"></script>
    <%--jqGrid核心js--%>
    <script src="${app}/jqgrid/js/trirand/jquery.jqGrid.min.js"></script>
    <%--国际化--%>
    <script src="${app}/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <%--ajaxFileupload--%>
    <script src="${app}/boot/js/ajaxfileupload.js"></script>
</head>
<body>
<%--
    导航条
--%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- data-toggle="collapse"可折叠 -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">持明法洲后台管理系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">欢迎<b>小黑</b></a></li>
                <li><a href="#">退出登录 <span class="glyphicon glyphicon-log-out"></span></a></li>
            </ul>
        </div>
    </div>
</nav>
<%--导航菜单--%>
<div class="container-fluid">
    <div class="row">
        <%--菜单栏--%>
        <div class="col-sm-2">
            <div class="panel-group" id="accordion">
                <%--用户相关--%>
                <div class="panel panel-default text-center">
                    <div class="panel-heading" id="headingOne">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                <h4><b>用户管理</b></h4>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse" role="tabpanel">
                        <div class="panel-body">
                            <button class="btn btn-primary">用户列表</button>
                        </div>
                    </div>
                </div>
                <%--上师相关--%>
                <div class="panel panel-default text-center">
                    <div class="panel-heading" role="tab" id="headingTwo">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseTwo">
                                <h4><b>上师管理</b></h4>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <div class="panel-body">
                            <button class="btn btn-primary">上师列表</button>
                        </div>
                    </div>
                </div>
                <%--文章管理--%>
                <div class="panel panel-default text-center">
                    <div class="panel-heading" role="tab" id="headingThree">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseThree">
                                <h4><b>文章管理</b></h4>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingThree">
                        <div class="panel-body">
                            <a href="javascript:$('#myContext').load('article.jsp')" class="btn btn-primary">文章列表</a>
                        </div>
                    </div>
                </div>
                <%--专辑管理--%>
                <div class="panel panel-default text-center">
                    <div class="panel-heading" role="tab" id="headingFour">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseFour">
                                <h4><b>专辑管理</b></h4>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingThree">
                        <div class="panel-body">
                            <a href="javascript:$('#myContext').load('album.jsp')" class="btn btn-primary">专辑列表</a>
                        </div>
                    </div>
                </div>
                <%--轮播图管理--%>
                <div class="panel panel-default text-center">
                    <div class="panel-heading" role="tab" id="headingFive">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseFive">
                                <h4><b>轮播图管理</b></h4>
                            </a>
                        </h4>
                    </div>
                    <div id="collapseFive" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingThree">
                        <div class="panel-body">
                            <a href="javascript:$('#myContext').load('banner.jsp')" class="btn btn-primary">轮播图列表</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--巨幕  轮播图--%>
        <div id="myContext" class="col-sm-10">
            <div class="jumbotron">
                <h2>欢迎来到持明法洲后台管理系统！</h2>
            </div>
            <%--轮播图--%>
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="${app}/img/shouye.jpg" style="width: 100%;height: 480px">
                    </div>
                    <div class="item">
                        <img src="${app}/img/2.jpg" style="width: 100%;height: 480px">
                    </div>
                    <div class="item">
                        <img src="${app}/img/3.jpg" style="width: 100%;height: 480px">
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
</div>
<%--页脚--%>
<nav class="navbar navbar-default navbar-fixed-bottom">
    <div class="container text-center" style="padding-top: 10px">
        <h4>百知教育@180</h4>
    </div>
</nav>
</body>
</html>
