<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>图书管理系统 - 角色管理</title>
<style type="text/css">
.linear {
	width: 100%;
	height: 100%;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(gradientType=0,
		startColorStr=#5faddb, endColorStr=#fafafa); /*IE*/
	background: -moz-linear-gradient(top, #5faddb, #fafafa); /*火狐*/
	background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#5faddb),
		to(#fafafa)); /*谷歌*/
	background-image: -webkit-gradient(linear, left bottom, left top, color-start(0, #5faddb),
		color-stop(1, #fafafa)); /* Safari & Chrome*/
	filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,
		startColorstr='#5faddb', endColorstr='#fafafa'); /*IE6 & IE7*/
	-ms-filter:
		"progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#5faddb', endColorstr='#fafafa')";
	/* IE8 */
}
</style>
<!-- Bootstrap -->
<link href="${ctx}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/bootstrap/css/docs.min.css" rel="stylesheet">

<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>
<body class="linear">
	<!-- 页面导航开始 -->
	<%@ include file="/pages/layout/head.jsp"%>
	<!-- 页面导航结束 -->

	<!-- 页面主体部分开始 -->
	<div class="container bs-docs-container">
		<div class="row">
			<h3 style="text-align: center;">角色列表</h3>
			<c:if test="${not empty loginUser}">
				<p>
					<a class="btn btn-success" href="${ctx}/pages/role/addrole.jsp">新增</a>
				</p>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>编号</th>
							<th>角色名称</th>
							<th>描述信息</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${roleList}" var="obj">
							<tr>
								<th scope="row">${obj.id}</th>
								<td>${obj.roleName}</td>
								<td>${obj.remark}</td>
								<td><a class="btn btn-warning btn-sm"
									href="${ctx}/role.do?type=get&id=${obj.id}">编辑</a> <a
									class="btn btn-danger btn-sm"
									href="${ctx}/role.do?type=delete&id=${obj.id}"
									onclick="return confirm('确实要删除角色 ${obj.roleName} : ${obj.remark} 吗?');">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${empty loginUser}">
				<h3 style="text-align: center; color: red;">非法访问！</h3>
			</c:if>
		</div>
	</div>
	<!-- 页面主体部分结束 -->

	<!-- 页脚部分开始 -->
	<%@ include file="/pages/layout/foot.jsp"%>
	<!-- 页脚部分结束 -->

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="${ctx}/bootstrap/js/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ctx}/bootstrap/js/docs.min.js"></script>
</body>
</html>