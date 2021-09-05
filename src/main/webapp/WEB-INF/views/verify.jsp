<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ include file="components/header.jsp" %>
<%@ page session="false" %>

  <div class="container mt-3">	
	<div class="col-sm-12 text-center">
		<h2>Verify Signup</h2>
		</div>
		<div class="clearfix"></div><br>
		<div class="col-sm-12">
			<c:if test= "${error}">
				<div class="alert alert-danger text-center">
			</c:if>
			<c:if test = "${not error}">
				<div class="alert alert-success text-center">
			</c:if>
			  <h6> ${msg}</h6>
			
			</div>
		</div>


 </div> <!--container-->
 

 
 <%@ include file="components/footer.jsp" %>
 <%@ include file="components/scripts.jsp" %>
 
<script>
	 
	
</script>
	<script src="/js/verify-signup.js"></script>

</body>
</html>