<%@taglib prefix="s" uri="/struts-tags" %>

<div class="modal-header">
  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
  <h4 class="modal-title" id="myModalLabel">Login</h4>
</div>
<div class="modal-body">
    <s:url action="postSignin" var="#postSigninUrl"></s:url>
	<form class="form-horizontal" action="<s:property value='#postSigninUrl' />" role="form">
	  <div class="form-group">
	    <label for="userEmail" class="col-sm-2 control-label">Email</label>
	    <div class="col-sm-10">
	      <input name="userEmail" type="email" class="form-control" id="user-email" placeholder="Email">
	    </div>
	  </div>

	  <div class="form-group">
	    <label for="userPassword" class="col-sm-2 control-label">Password</label>
	    <div class="col-sm-10">
	      <input name="userPassword" type="password" class="form-control" id="user-password" placeholder="Password">
	    </div>
	  </div>

	    <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <div class="checkbox">
	        <label>
	          <input type="checkbox"> Remember me
	        </label>
	      </div>
	    </div>
	  </div>
	  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">Sign in</button>
		    </div>
		  </div>
	</form>
</div>