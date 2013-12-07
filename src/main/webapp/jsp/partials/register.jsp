<%@taglib prefix="s" uri="/struts-tags" %>

<div class="modal-header">
  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
  <h4 class="modal-title" id="myModalLabel">Register</h4>
</div>
<div class="modal-body">
    <s:url action="postRegister" var="#postResUrl"></s:url>
	<form id="register-form" class="form-horizontal" action="<s:property value='#postResUrl' />" role="form">
	  <div class="form-group">
	    <label for="email" class="col-sm-2 control-label">Email</label>
	    <div class="col-sm-10">
	      <input name="email" type="email" class="form-control" id="email" placeholder="Email">
	    </div>
	  </div>

	  <div class="form-group">
	    <label for="password" class="col-sm-2 control-label">Password</label>
	    <div class="col-sm-10">
	      <input name="password" type="password" class="form-control" id="password" placeholder="Password">
	    </div>
	  </div>

	  <div class="form-group">
	    <label for="username" class="col-sm-2 control-label">Username</label>
	    <div class="col-sm-8">
	      <input name="username" type="text" class="form-control" id="username" placeholder="Username">
	    </div>
	  </div>

	</form>
</div>
<div class="modal-footer">
  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
  <button type="button" class="btn btn-primary" id="register">Register</button>
 </div>