<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>图书管理系统-图书管理</title>

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
    	<div class="row">
    		<h3 style="text-align:center;">图书列表</h3>
	    	<table class="table table-bordered table-hover">
		      <thead>
		        <tr>
		          <th>编号</th>
		          <th>主题</th>
		          <th>内容</th>
		          <th>发布时间</th>
		          <th>发布者</th>
		          <th>操作</th>
		        </tr>
		      </thead>
		      <tbody>
		        <tr>
		          <th scope="row">1</th>
		          <td>新人报到</td>
		          <td>大家好</td>
		          <td>2020-11-19</td>
		          <td>Tom</td>
		          <td>回复 编辑 删除 查看</td>		          
		        </tr>
		        <tr>
		          <th scope="row">2</th>
		          <td>新人报到</td>
		          <td>大家好</td>
		          <td>2020-11-19</td>
		          <td>Tom</td>
		          <td>回复 编辑 删除 查看</td>		          
		        </tr>	
		        <tr>
		          <th scope="row">3</th>
		          <td>新人报到</td>
		          <td>大家好</td>
		          <td>2020-11-19</td>
		          <td>Tom</td>
		          <td>回复 编辑 删除 查看</td>		          
		        </tr>			        
		      </tbody>
		    </table>    	
	    	<nav aria-label="Page navigation" style="text-align:center;">
  			  <ul class="pagination">
			    <li>
			      <a href="#" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <li><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
			    <li>
			      <a href="#" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
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