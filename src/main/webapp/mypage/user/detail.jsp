<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head><title>MyPage</title></head>
<body>
<h1>[정보수정]</h1>
<table border='1'>
<form action = 'update' method = 'post'>

이름: <input type='text' name='name' value='${user.name}' readonly><br>
닉네임: <input type='text' name='nick' value='${user.nick}'><br>
이메일: <input type='text' name='email' value= '${user.email}' readonly><br>
비밀번호: <input type='text' name='password' value= '${user.password}'><br>
우편번호: <input type='text' name='postno' value= '${user.postNo}'><br>
기본주소: <input type='textarea' name='addr' value= '${user.address}'><br>
세부주소: <input type='det_addr' name='det_addr' value= '${user.detailAddress}'><br>
<p>
  <button>변경</button>
  </form>
  <a href='../index.jsp'><button>취소</button></a>
  </p>
</table>
<hr>

<a href=../index.html>뒤로가기</a><br>

<a href=../../index.jsp>홈으로</a><br>

</body>
</html>
