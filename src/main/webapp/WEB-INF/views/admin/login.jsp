<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ include file="../components/admin-header.jsp" %>
<%@ page session="false" %>


  <div class="container mt-3">	 
	  <div class="row">
            <div class="col-md-5 offset-md-3">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Administrator Sign In</h3>
                    </div>
                    <div class="panel-body">
 			 
						<c:if test= "${error ne null}">
						   <div class="text-center"><b>${error}</b></div>
					    </c:if>  
		 	 

                        <form role="form" name=frmLogin id=frmLogin  method=post action="/admin/dologin">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Admin Username" name="userid" id="userid"
						 autofocus maxlength=30 required>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="pwd" id="pwd"
						type="password" value="" required>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button class="btn btn-lg btn-secondary btn-block">Login</button>
                            </fieldset>
                        </form>
                    </div>
                </div>

				<div class="clearfix"></div><br>
				
            </div> <!--col-md-4-->
        </div> <!--row-->
	
 </div> <!--container-->
 
 <%@ include file="../components/admin-footer.jsp" %>
 <%@ include file="../components/admin-scripts.jsp" %>
 
<script>
	 
	
</script>

</body>
</html>