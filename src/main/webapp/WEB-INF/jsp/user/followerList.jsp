<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/header.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head><title>사용자 레시피</title></head>
<body>
<h1>[${user.nick}님의 Follower 목록]</h1>
<table border='1'>
<thead>
<tr>
  <th>번호</th>
  <th>이름</th>
  <th>닉네임</th>
</tr>
</thead>

<tbody>
<c:forEach items="${followerList}" var="fwer">
<tr>
  <td>${fwer.user.userNo}</td>
  <td>${fwer.user.name}</td>
  <td>${fwer.user.nick}</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>