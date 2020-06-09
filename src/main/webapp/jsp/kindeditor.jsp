<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/kindeditor-all-min.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/lang/zh-CN.js"></script>
    <script>
        KindEditor.ready(function (K) {
            K.create('#editor_id', {
                width: '1000px',
                height: '500px',
                resizeType: 0,       //不可改变大小
                allowFileManager: true,      //历史上传空间
                filePostName: 'img',         //后台文件名
                uploadJson: '${pageContext.request.contextPath}/kindeditor/uploadImg'               //上传请求路径
            });
        });
    </script>
</head>
<body>
<textarea id="editor_id" name="content" style="width:700px;height:300px;">

    </textarea>
</body>
</html>