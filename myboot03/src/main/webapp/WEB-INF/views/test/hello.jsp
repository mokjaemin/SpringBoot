<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"  %>
<%
  request.setCharacterEncoding("UTF-8");
%>   
 
<html>
<head>
 <script src="${contextPath}/js/scriptTest.js" type="text/javascript"></script>
 <meta  charset="utf-8">
<title>hello.JSP 페이지</title>
</head>
<body> 
  안녕하세요 드디어 인사드립니다.<br>
  <h2>${message}</h2>
  <img width=200 height=200  src="${contextPath}/image/duke3.png" /> <br/>
  <input type="button" name="테스트" value="테스트" onClick="test();">
</body>
</html>
