<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ include file="../components/admin-header.jsp" %>
<%@ page session="false" %>


  <div class="container mt-3">	 
	    <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="panel panel-default">
                    <div class="panel-heading text-center">
                        <h3 class="panel-title">ADMINISTRATION DASHBOARD</h3>
                    </div>
		    <div class="panel-body ">
			<div class="row">
			   <div class="col-md-6 offset-md-3 text-center">
				   <button type=button onclick="window.location='/admin/logout';"
					class="btn btn-sm btn-secondary mr-2">Logout</button>
				   <button type=button onclick="window.location='/admin/emails';" 
					class="btn btn-sm btn-secondary">Email Ids</button>
			   </div>
			</div>
                    </div>
                </div>

				<div class="clearfix"></div><br>
				
            </div> <!--col-md-6-->
        </div> <!--row-->
    </div> <!--container-->
	  
 <%@ include file="../components/admin-footer.jsp" %>
 <%@ include file="../components/admin-scripts.jsp" %>
 
<script>
	 
	
</script>

</body>
</html>