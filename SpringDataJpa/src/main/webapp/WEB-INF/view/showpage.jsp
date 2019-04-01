<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.pagination a {
  color: black;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
}

.pagination a.active {
  background-color: dodgerblue;
  color: white;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
table, th, td {
  border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<h1 align="center">Show All Records</h1>
<table align="center">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
  </tr>
  <c:forEach var="var1" items="${showallrecords}">
  <tr>
    <td>${var1.userid}</td>
    <td>${var1.username}</td>
    <td>${var1.userage}</td> 
  </tr>
</c:forEach>
</table>         <br><br>
<h1 align="center">Show All Records Sort By Name</h1>
<table align="center">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
  </tr>
  <c:forEach var="var11" items="${showallrecordssortbyname}">
  <tr>
    <td>${var11.userid}</td>
    <td>${var11.username}</td>
    <td>${var11.userage}</td> 
  </tr>
</c:forEach>
</table>         <br><br>

     <br><br>
<h1 align="center">Show All Records Sort By Name And Pagination</h1>
<table align="center">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
  </tr>
  <c:forEach var="var111" items="${showallrecordssortbynameget.content}">
  <tr>
    <td>${var111.userid}</td>
    <td>${var111.username}</td>
    <td>${var111.userage}</td> 
  </tr>
</c:forEach>
</table> <br><br>
<div class="pagination" align="center">
  <a href="#">&laquo;</a>
  <c:choose >
      <c:when test="${showallrecordssortbynameget.getTotalElements()>0}">
          <a href="${pageContext.request.contextPath}/User/ShowUserRecordsSortByNameGetMethods?i=0" name="i">0</a>
          <a href="${pageContext.request.contextPath}/User/ShowUserRecordsSortByNameGetMethods?i=1" name="i">1</a>
          <a href="${pageContext.request.contextPath}/User/ShowUserRecordsSortByNameGetMethods?i=2" name="i">2</a>
           <a href="${pageContext.request.contextPath}/User/ShowUserRecordsSortByNameGetMethods?i=3" name="i">3</a>
      </c:when>
      <c:otherwise>
        <a href="${pageContext.request.contextPath}/User/ShowUserRecordsSortByNameGetMethods?i=2" name="i">2</a>
        <a href="${pageContext.request.contextPath}/User/ShowUserRecordsSortByNameGetMethods?i=3" name="i">3</a>
        <a href="${pageContext.request.contextPath}/User/ShowUserRecordsSortByNameGetMethods?i=4" name="i">4</a>
      </c:otherwise>
   </c:choose>
   <a href="#">&raquo;</a>
</div>
      <br><br>

<h1 align="center">Show One Record</h1>
 <table align="center">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
  </tr>
  <tr>
    <td>${printonestudent.userid}</td>
    <td>${printonestudent.username}</td>
    <td>${printonestudent.userage}</td> 
  </tr>
</table>
                 <br><br>
<h1 align="center">Show Specific Records</h1>
<table align="center">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
  </tr>
  <c:forEach var="var3" items="${showoneplus}">
  <tr>
    <td>${var3.userid}</td>
    <td>${var3.username}</td>
    <td>${var3.userage}</td> 
  </tr>
</c:forEach>
</table>  
                  <br><br>
<h1 align="center">Searched By Name</h1>
<table align="center">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
  </tr>
  <c:forEach var="var4" items="${cheack22}">
  <tr>
    <td>${var4.userid}</td>
    <td>${var4.username}</td>
    <td>${var4.userage}</td> 
  </tr>
</c:forEach>
</table>  
       <br><br>
<h1 align="center">Searched By Name With Pagination using one page 5 each</h1>
<table align="center">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
  </tr>
  <c:forEach var="var44" items="${cheack223}">
  <tr>
    <td>${var44.userid}</td>
    <td>${var44.username}</td>
    <td>${var44.userage}</td> 
  </tr>
</c:forEach>
</table>  
      <br><br>
<h1 align="center">Searched By Name And Age</h1>
<table align="center">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
  </tr>
  <c:forEach var="var5" items="${cheack23}">
  <tr>
    <td>${var5.userid}</td>
    <td>${var5.username}</td>
    <td>${var5.userage}</td> 
  </tr>
</c:forEach>
</table>  
</body>
</html>