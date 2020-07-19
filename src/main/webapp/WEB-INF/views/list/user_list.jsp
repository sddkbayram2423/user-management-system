<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


     	<div class="col nav justify-content-center mt-3">
   			<font color="black" size="4" >USER LIST</font>
  	 </div>
  <c:if test="${empty users}">
  	<h3>There are any user!!!</h3>
  </c:if>  
  
  <c:if test="${not empty users}">        
   <hr> 
  <table  class="table  ">
    <thead>
      <tr>
        <th>ID</th>
        <th>FISTNAME</th>
        <th>LASTNAME</th>
        <th>USERNAME</th>
        <th>EMAIL</th>
        <th>ROLE</th>
        <th>ACCOUNT NONEXPİRED</th>
        <th>ACCOUNT NONLOCKED</th>
        <th>CREDENTIALS NONEXPİRED</th>
        <th>ENABLED</th>
      </tr>
    </thead>
    <c:forEach items="${users}" var="user">
    <tbody>
      <tr>
        <td>${user.id}</td>
        <td>${user.fistname}</td>
        <td>${user.lastname}</td>
        <td>${user.username}</td>
        <td>${user.email}</td>
        <td>${user.role.name}</td>
        <td>${user.accountNonExpired}</td>
        <td>${user.accountNonLocked}</td>
        <td>${user.credentialsNoneExpired}</td>
        <td>${user.enabled}</td>
        <td><a href="/controller/user/editUserForAdmin?id= <c:out value="${user.id}"/> "> <i>Edit</i></a></td>
<%--         <td><a href="/controller/user/deleteUser?id= <c:out value="${user.id}"/> "> <i style="color: red;">Delete</i></a></td> --%>
      </tr>
    </tbody>
    </c:forEach>
  </table>
  </c:if>
  <hr> <a href="/controller/user/newUserForAdmin">Add User</a>


</body>
</html>