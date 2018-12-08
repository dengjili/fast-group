<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页测试</title>
</head>
<body>

	<a href=addPage>添加</a>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<th>用户ID</th>
			<th>用户名称</th>
			<th>用户姓名</th>
			<th>用户电话</th>
			<th>用户地址</th>
			<th>用户生日</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
		<c:forEach var="person" items="${persons}">
			<tr>
				<td>${person.id}</td>
				<td>${person.display}</td>
				<td>${person.name}</td>
				<td>${person.phone}</td>
				<td>${person.address}</td>
				<td>${person.birthdate}</td>
				<td>${person.remark}</td>
				<td>
					<a href="updatePage/${person.id}">修改</a>
					<a href="delete/${person.id}">删除</a>
					<a href="get/${person.id}">详细信息</a>
				</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>