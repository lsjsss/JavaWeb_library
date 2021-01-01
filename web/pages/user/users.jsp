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
<title>图书管理系统 - 用户管理</title>
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

<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>
<body class="linear">
	<jsp:include page="/pages/layout/head.jsp" />
	<!-- 主体内容开始 -->
	<div class="container bs-docs-container">
		<div class="row">
			<h3 style="text-align: center;">用户列表</h3>
			<c:if test="${not empty loginUser}">
				<p>
					<a class="btn btn-success" href="${ctx}/pages/user/adduser.jsp">新增</a>
				</p>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>编号</th>
							<th>账号</th>
							<th>姓名</th>
							<th>属性</th>
							<th>最大借阅数</th>
							<th>最大借天数</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userList}" var="obj">
							<tr>
								<th scope="row">${obj.id}</th>
								<td>${obj.loginName}</td>
								<td>${obj.realName}</td>
								<td>${obj.value}</td>
								<td>${obj.maxLendNumber }</td>
								<td>${obj.maxLendDays}</td>
								<td><c:if test="${obj.roleId eq 1}">
										<a class="btn btn-warning btn-sm disabled">管理员账户禁止操作</a>
									</c:if> <c:if test="${obj.id eq 2}">
										<a class="btn btn-warning btn-sm disabled">学生测试账户禁止操作</a>
									</c:if> <c:if test="${obj.id eq 3}">
										<a class="btn btn-warning btn-sm disabled">教师测试账户禁止操作</a>
									</c:if> <c:if test="${obj.roleId ne 1}">
										<c:if test="${obj.id ne 2}">
											<c:if test="${obj.id ne 3}">
												<a class="btn btn-warning btn-sm"
													href="${ctx}/user.do?type=get&id=${obj.id}">编辑</a>
												<a class="btn btn-danger btn-sm"
													href="${ctx}/user.do?type=delete&id=${obj.id}"
													onclick="return confirm('确实要删除${obj.value}账户 ${obj.realName} 吗?');">删除</a>
											</c:if>
										</c:if>
									</c:if></td>
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
	<!-- 主体内容结束 -->
	<jsp:include page="/pages/layout/foot.jsp" />
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="${ctx}/bootstrap/js/jquery1.12.4.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>