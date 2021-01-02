<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<c:set var="roleId" value="${roleId}"></c:set>
<c:set var="userId" value="${userId}"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>图书管理系统 - 借阅管理</title>
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
	<!-- 主题内容开始 -->
	<div class="container bs-docs-container">
		<div class="row">
			<h3 style="text-align: center;">借阅列表</h3>
			<c:if test="${not empty loginUser}">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>借阅编号</th>
							<th>读者姓名</th>
							<th>书名</th>
							<th>借阅日期</th>
							<th>预计归还日期</th>
							<th>实际归还日期</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${roleId eq 1}">
							<c:forEach items="${lendList}" var="lendList">
								<tr>
									<th scope="row">${lendList.id}</th>
									<td><c:forEach items="${userList}" var="userList">
											<c:if test="${userList.id eq lendList.userId}">
										${userList.realName}
									</c:if>
										</c:forEach></td>
									<td><c:forEach items="${bookList}" var="bookList">
											<c:if test="${bookList.id eq lendList.bookId}">
										${bookList.bookName}
									</c:if>
										</c:forEach></td>
									<td>${lendList.lendDate}</td>
									<td>${lendList.estimateReturnDate}</td>
									<td>${lendList.actualDeturnDate}</td>
									<td><c:if test="${lendList.status eq 0}">
											<c:if test="${roleId eq 1}">
												<c:if test="${lendList.userId eq userId}">
													<a class="btn btn-success btn-sm"
														href="${ctx}/lend.do?type=return&lendId=${lendList.id}&userId=${lendList.userId}&bookId=${lendList.bookId}">归还</a>
												</c:if>
											</c:if>

											<c:forEach items="${userList}" var="userList">
												<c:if test="${userList.id eq lendList.userId}">
													<c:if test="${userList.roleId ne 1}">
														<a class="btn btn-danger btn-sm"
															href="${ctx}/lend.do?type=ForcedreturnBook&lendId=${lendList.id}&userId=${lendList.userId}&bookId=${lendList.bookId}&roleId=${roleId}&adminUserId=${userId}">强制归还</a>
													</c:if>

												</c:if>
											</c:forEach>
										</c:if> <c:if test="${lendList.status eq 11}">
											<a class="btn btn-warning btn-sm disabled" href="">已归还</a>
										</c:if></td>
								</tr>
							</c:forEach>
						</c:if>
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