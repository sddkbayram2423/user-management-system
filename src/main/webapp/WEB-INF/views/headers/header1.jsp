<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="jumbotron text-center" style="margin-bottom:0">

	<font color="black" size="6">Management System</font>
	
	<nav class="nav justify-content-end">
        <a class="nav-link" href="/controller/">Logout</a>
        <a class="nav-link" href="/controller/user/showProfile?id= <c:out value="${user.id}"/>">MyProfile</a>
    </nav>
</div>




