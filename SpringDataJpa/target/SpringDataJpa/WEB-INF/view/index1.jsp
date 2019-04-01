<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="color: purple;">
<div align="center"  style=" border: dotted; padding-left: 1ex; color: green;">
   <br><br>
      <form action="${pageContext.request.contextPath}/User/ShowUserRecords" method="post">
       <table style="border: 1ex 1ex" bordercolor="Black">
        <tr>
         <th>
         <input type="submit" value="Show All Records" >
         </th>
        </tr>
       </table>
     </form> 
     
<%--      <a href="${pageContext.request.contextPath}/User/ShowUserRecords">Show All Records</a> --%>
   <br><br>
   <form:form action="${pageContext.request.contextPath}/User/ShowOneRecord" method="Post" modelAttribute="one">
<h1>Search Single Record</h1>
   ${inserted}<br>
 <table style="border: 1ex 1ex" bordercolor="Black">
  <tr>
    <td>ID<br>
        <input type="text" name="userid">
    </td>
  </tr>
   <tr>
     <td>Submit<br>
        <input type="submit">
    </td>
  </tr>
</table>
</form:form>
<br><br>
 <form:form action="${pageContext.request.contextPath}/User/ShowOneMoreStudentRecords" method="Post" modelAttribute="onemore">
<h1>Search Multiple Records</h1>
   ${inserted}<br>
 <table style="border: 1ex 1ex" bordercolor="Black">
  <tr>
    <td>ID : 1<br>
        <input type="text" name="user_id1">
    </td>
  </tr>
  <tr>
  <td>ID : 2<br>
        <input type="text" name="user_id2">
    </td>
   </tr> 
   <tr>
     <td>Submit<br>
        <input type="submit">
    </td>
  </tr>
</table>
</form:form>
     <br><br>
     <form:form action="${pageContext.request.contextPath}/User/InsertStudentRecord" method="Post" modelAttribute="insert">
<h1>Insert Student Record</h1>
   ${inserted}<br>
 <table style="border: 1ex 1ex" bordercolor="Black">
  <tr>
    <td>ID<br>
        <input type="text" name="userid">
    </td>
  </tr>
  <tr>
    <td>Name<br>
        <input type="text" name="username">
    </td>
  </tr>
  <tr>
     <td>Age<br>
        <input type="text" name="userage">
    </td>
  </tr>
  </tr>
   <tr>
     <td>Submit<br>
        <input type="submit">
    </td>
  </tr>
</table>
</form:form>
     <br><br>
     <form:form action="${pageContext.request.contextPath}/User/DeleteStudentRecord" method="Post" modelAttribute="delete">
<h1>Delete Student Record</h1>
   ${deleted}<br>
 <table style="border: 1ex 1ex" bordercolor="Black">
  <tr>
    <td>ID<br>
        <input type="text" name="userid">
    </td>
  </tr>
  <tr>
     <td>Submit<br>
        <input type="submit">
    </td>
  </tr>
</table>
</form:form>
     <br><br>
     <form:form action="${pageContext.request.contextPath}/User/UpdateStudentRecord" method="Post" modelAttribute="update">
<h1>Update Student Record</h1>
   ${update}<br>
 <table style="border: 1ex 1ex" bordercolor="Black">
  <tr>
    <td>ID<br>
        <input type="text" name="userid">
    </td>
  </tr>
  <tr>
    <td>Name<br>
        <input type="text" name="username">
    </td>
  </tr>
  <tr>
     <td>Age<br>
        <input type="text" name="userage">
    </td>
  </tr>
  <tr>
     <td>Submit<br>
        <input type="submit">
    </td>
  </tr>
</table>
</form:form>
 <br><br>
     <form:form action="${pageContext.request.contextPath}/User/FindStudentName" method="Post" modelAttribute="find">
<h1>Find by name</h1>
   ${find}<br>
 <table style="border: 1ex 1ex" bordercolor="Black">
  <tr>
    <td>Name<br>
        <input type="text" name="username">
    </td>
  </tr>
  <tr>
     <td>Submit<br>
        <input type="submit">
    </td>
  </tr>
</table>
</form:form>
<br><br>
     <form:form action="${pageContext.request.contextPath}/User/FindStudentWithNameAndAge" method="Post" modelAttribute="findnameage">
<h1>Find by name And age</h1>
   ${cheack23}<br>
 <table style="border: 1ex 1ex" bordercolor="Black">
  <tr>
    <td>Name<br>
        <input type="text" name="username">
    </td>
  </tr>
  <tr>
    <td>Age<br>
        <input type="text" name="userage">
    </td>
  </tr>
  <tr>
     <td>Submit<br>
        <input type="submit">
    </td>
  </tr>
</table>
</form:form>
</div>
</body>
</html>