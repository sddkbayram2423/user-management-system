<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>    
<head>    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"/>  
	   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/> 
<title>
	<tiles:insertAttribute name="title" ignore="true" />
</title>    
</head>    
<body>   
        <div>
        	<tiles:insertAttribute name="header" />
        </div>  
         <div class="row mb-1"></div>
        
         <div class="row">
        	<div class="col-md-2" style="margin-bottom:10px;"><tiles:insertAttribute name="menu" /></div>
        	<div class="col-md-10" style="margin-bottom:10px"><tiles:insertAttribute name="body" /></div>
        </div>
          
        <div>
        	<tiles:insertAttribute name="footer" />
        </div>    
</body>    
</html>      