<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>图书管理系统 - 欢迎</title>
<style type="text/css">
body {
	background-image:
		url("https://img-blog.csdnimg.cn/20210101185241248.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDM0MDEyOQ==,size_16,color_FFFFFF,t_70#pic_center");
	overflow-x: hidden;
}
</style>
<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<jsp:include page="/pages/layout/head.jsp" />
	<!-- 主体内容开始 -->
	<div class="container bs-docs-container"
		style="position: absolute; top: 40%; left: 10%;">
		<div class="row col-md-6">
			<div class="form-group">
				<h1>Web图书管理系统</h1>
			</div>
		</div>
		<c:if test="${empty loginUser}">
			<div class="row col-md-6">
				<form method="post" action="${ctx}/user.do?type=login"
					class="form-horizontal">
					<div class="form-group">
						<label for="loginName" class="col-sm-2 control-label">登录名称</label>
						<div class="col-sm-5">
							<input class="form-control" id="loginName" name="loginName"
								placeholder="username">
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">密&ensp;&ensp;&ensp;&ensp;码
						</label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="password">
						</div>
					</div>
					<div class="form-group">
						<label for="login" class="col-sm-5 control-label"></label>
						<div class="col-sm-2">
							<button type="submit" class="btn btn-default">登录</button>
						</div>
					</div>
				</form>
			</div>
		</c:if>
	</div>
	<!-- 主体内容结束 -->
</body>
</html>