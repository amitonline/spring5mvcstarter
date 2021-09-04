<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ include file="components/header.jsp" %>
<%@ page session="false" %>

<?php require_once($g_docRoot . "components/header.php"); ?>


  <div class="container mt-3">	
	<div class="jumbotron">
	  <h1 class="display-4">Mailing List!</h1>
	  <p class="lead">We are getting ready... Please drop your email id below to be notified when we go LIVE.</p>
	  <hr class="my-4">
	  <form name=frmEmail id=frmEmail method=post onsubmit="return doValidate(this);">
	  <div class="row">
		<div class="col-md-5 offset-md-2 text-right mt-3">
			<input class="form-control" maxlength=75 name=email id=email type="email"
				placeholder="Enter your email id">		
		</div>
		
		<div class="col-md-2 text-center mt-3">
			<button type=submit class="btn btn-lg btn-secondary" id="btnSubmit">Submit</button>
		</div>
	  </div> <!--row-->
	  <div class="row mt-2" id="rowMsg" style="display:none;">
		<div class="alert alert-success col-md-12 text-center">
			Thank you. Your email id has been added to our mailing list.
		</div>
	  </div> <!--row-->
	 </form>
	</div>


 </div> <!--container-->
 
 <%@ include file="components/footer.jsp" %>
 <%@ include file="components/scripts.jsp" %>
 
<script>
	 
	
</script>
	<script src="/js/home.js"></script>

</body>
</html>