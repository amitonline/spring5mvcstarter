<!DOCTYPE HTML> 

	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>

	<title>${pageTitle}</title>
	<meta name="viewport" content="initial-scale=1.0, width=device-width, user-scalable=0" />
	<meta name="viewport" content="initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, width=device-width, height=device-height, target-densitydpi=device-dpi, user-scalable=no" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta charset="utf-8">
	
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	


	<%@ include file="admin-styles.jsp" %>
</head>


<body>
<div class="navbar navbar-expand-md navbar-dark bg-dark">
   <div class="container">
      <a href="/" class="navbar-brand">MAILING LIST</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="/">Home</a>
            </li>
          </ul>

        </div>
      </div>
  </div> <!--navbar-->


