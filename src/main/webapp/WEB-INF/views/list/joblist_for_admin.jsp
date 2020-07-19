<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jobs</title>
</head>
<body>


<div class="container">
	<div class="col nav justify-content-center mb-3">
		<font color="black" size="6">JOB LIST</font>
	</div>
	<c:if test="${empty jobs}">
  	<h3>There are any job!!!</h3>
  </c:if>  
  
  <c:if test="${not empty jobs}"> 
    <hr>  
  <table  class="table table-responsive ">
    <thead>
      <tr>
        <th>ID</th>
        <th>MAX SALARY</th>
        <th>MIN SALARY</th>
        <th>JOB TITLE</th>
      </tr>
    </thead>
    <c:forEach items="${jobs}" var="job">
    <tbody>
      <tr>
        <td>${job.id}</td>
        <td>${job.maxSalary}</td>
        <td>${job.minSalary}</td>
        <td>${job.title}</td>
         <td><a href="/controller/job/detailJob?id= <c:out value="${job.id}"/> "> <i>Details</i></a></td>
      </tr>
    </tbody>
    </c:forEach>
  </table>
    <hr> <a href="/controller/job/addNewJob">Add Job</a>
  </c:if>
</div>


</body>
</html>