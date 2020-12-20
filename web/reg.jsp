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
<style type="text/css">
.shortselect {
	background: #fafdfe;
	height: 28px;
	width: 180px;
	line-height: 28px;
	border: 1px solid #9bc0dd;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
}
</style>
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>图书管理系统-用户注册</title>
<!-- Bootstrap -->
<link href="${ctx}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
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
	<div class="container bs-docs-container">
		<div class="col-md-6"></div>
		<div class="row col-md-6">
			<form method="post" action="${ctx}/user.do?type=reg"
				class="form-horizontal">
				<div class="form-group">
					<label for="loginName" class="col-sm-2 control-label">用&ensp;户&ensp;名</label>
					<div class="col-sm-5">
						<input class="form-control" id="loginName" name="loginName"
							placeholder="username">
					</div>
				</div>
				<div class="form-group">
					<label for="realName" class="col-sm-2 control-label">真实姓名</label>
					<div class="col-sm-5">
						<input class="form-control" id="realName" name="realName"
							placeholder="name">
					</div>
				</div>
				<div class="form-group">
					<label for="roleId" class="col-sm-2 control-label">用户属性</label>
					<div class="col-sm-5">
						<select name="roleId" id="roleId" class="shortselect form-control">
							<option value="" style="display: none;">---请选择---</option>
							<option value="3">学生</option>
							<option value="2">教师</option>
						</select>
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
					<label for="confirmPassword" class="col-sm-2 control-label">确认密码</label>
					<div class="col-sm-5">
						<input type="password" class="form-control" id="confirmPassword"
							name="confirmPassword" placeholder="password">
					</div>
				</div>
				<div class="form-group">
					<label for="confirmPassword" class="col-sm-5 control-label"></label>
					<div class="col-sm-2">
						<button type="submit" class="btn btn-default">注册</button>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-1"></div>
	</div>
	<!-- 主体内容结束 -->
	<jsp:include page="/pages/layout/foot.jsp" />
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="${ctx}/bootstrap/js/jquery1.12.4.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>