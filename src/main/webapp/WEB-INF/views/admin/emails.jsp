<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ include file="../components/admin-header.jsp" %>
<%@ page session="false" %>


  <div class="container mt-3">	 
	        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="panel panel-default">
                    <div class="panel-heading text-center">
                        <h3 class="panel-title">BROWSE EMAIL IDS</h3>
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
                    </div> <!--panel-body-->
		</div> <!--panel-->
	    </div> <!--col-md-6-->
	</div>	<!--row-->

	 <div class="row mt-4">
	   <div class="col-md-6 offset-md-3 text-center">
			<form name=frmEmail id=frmEmail onsubmit="return doValidate(this);">
			 <div class="row">
				<input type=hidden name=p id=p value="${p}">

					<div class="col-md-6">
					  <input name=xemailid id=xemailid class="form-control" maxlength=75
						placeholder="Emailid " value="${emailid}">
					</div>
					<div class="col-sm-3 text-left">
						<button class="btn btn-default">Submit</button>
					</div>

			 </div>
			</form>
                       <div class="panel panel-default mt-2">
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th class="col-sm-5">Email (${count})</th>
                                    </tr>
                                </thead>
                                <tbody>
								   <c:forEach items="${list}" var ="ls">
				             			      <tr>
												     <td>
													    <div class="col-sm-5 text-left">
															${ls.email}
													     </div>
													 </td>
				                               </tr>
								 	</c:forEach>
				</tbody>
			  </table>

			  <div class="row mt-4">
                            <div class="col">
                                
                               <nav aria-label="...">
                                  <ul class="pagination">
                                  	<c:set var="currPage" value="${startPage}" />
                                  	<c:set var="totalPages" value="${pages}" />
                                  	
                                  	<c:if test="${currPage > 1 }">
                                  	  <li class="page-item ">
                                  	  		<a class="page-link" href="/admin/emails?p=${currPage-1}">Previous</a>
                                   	 </li>
                                  	</c:if>
                                  	
                                  	<c:forEach var="i" begin="1" end="${pages}">
                                  		<c:set var="thisPage" value="${i}" />
                                  		<c:if test="${thisPage ==  currPage}">
                                  		  <li class="page-item active"><span class="page-link">
                                        		${i}<span class="sr-only">(current)</span>
                                      			</span>
                                   		  </li>
                                   		</c:if>
                                   		<c:if test="${thisPage != currPage}">  
                                  	   		<li class="page-item"><a class="page-link" href="/admin/emails?p=${i}">${i}</a></li>
                                      	</c:if>  
			          				</c:forEach>
                               	  	 <c:if test="${currPage < totalPages}">
                                  		  <li class="page-item ">
                                  	   		   <a class="page-link" href="/admin/emails?p=${currPage+1}">Next</a>
                                  	 	 </li>
                                  	  </c:if>
                                    
                                  </ul>
                                </nav>
                              
                            </div>
		
  			  	  </div>	<!-- row -->
			    
			</div> <!--panel-body-->
	    	   </div> <!--panel-->	
		</div> <!--row-->		
				
            </div> <!--col-md-6-->
        </div> <!--row-->
    </div> <!--container-->
	
	  
 <%@ include file="../components/admin-footer.jsp" %>
 <%@ include file="../components/admin-scripts.jsp" %>
 

	<script src="../js/admin-emails.js"></script>
	
 
<script>
	 
	
</script>

</body>
</html>