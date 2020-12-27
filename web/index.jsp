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
<title>图书管理系统</title>

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
	<!-- 主题内容开始 -->
	<div class="container bs-docs-container">
		<div class="row">
			<c:if test="${loginUser.roleId eq 1}">
				<p>
					<a class="btn btn-success" href="${ctx}/pages/book/addbook.jsp">新增</a>
				</p>
			</c:if>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>编号</th>
						<th>书名</th>
						<th>作者</th>
						<th>出版社</th>
						<th>图书数量</th>
						<th>借出数量</th>
						<th>剩余数量</th>
						<c:if test="${not empty loginUser}">
							<th>操作</th>
						</c:if>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bookList}" var="obj">
						<tr>
							<th scope="row">${obj.id}</th>
							<td>${obj.bookName}</td>
							<td>${obj.author}</td>
							<td>${obj.publisher}</td>
							<td>${obj.bookNumbers}</td>
							<td>${obj.lendedNumber}</td>
							<td>${obj.bookNumbers - obj.lendedNumber}</td>
							<c:if test="${not empty loginUser}">
								<td><c:if
										test="${(obj.bookNumbers-obj.lendedNumber) gt 0 }">
										<a class="btn btn-success btn-sm" href="${ctx}/lend.do?type=lend&id=${obj.id}">借阅</a>
									</c:if> <c:if test="${(obj.bookNumbers-obj.lendedNumber) le 0}">
										<a class="btn btn-danger btn-sm disabled" href="">不可借阅</a>
									</c:if> <c:if test="${loginUser.roleId eq 1}">
										<a class="btn btn-danger btn-sm" href="${ctx}/book.do?type=get&id=${obj.id}">编辑</a>
										<a class="btn btn-warning btn-sm" href="${ctx}/book.do?type=delete&id=${obj.id}" onclick="return confirm('确实要删除编号为 【 ${obj.id}】 的记录吗?');">删除</a>
									</c:if></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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