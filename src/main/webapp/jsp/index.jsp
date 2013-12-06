<!DOCTYPE html>
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html class="full" lang="en"><!-- The full page image background will only work if the html has the custom class set to it! Don't delete it! -->
  <head>
  </head>

  <body>
      
    <nav class="navbar navbar-fixed-bottom navbar-inverse" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".default-navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/">Place me</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse default-navbar">
          <ul class="nav navbar-nav navbar-left">
            <li><a href="#about">About</a></li>
            <li><a href="#services">Services</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
          
          <ul class="nav navbar-nav navbar-right">
               <s:url namespace='/ajax' action="register" var="registerUrl"> </s:url>
	          <li><a id="user-signup" href="#" data-href="<s:property value='#registerUrl' />"><i class="fa fa-users icon-white"></i>&nbsp;&nbsp;Sign Up</a></li>
               <s:url namespace='/ajax' action="login" var="loginUrl"> </s:url>
	          <li><a id="user-signin" href="#" data-href="<s:property value='#loginUrl' />"><i class="fa fa-sign-in icon-white"></i>&nbsp;&nbsp;Log In</a></li>
           </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav>
    
    <div id="map" class="header">
    </div>

    <div class="float-box">
     <h1>Halu</h1>
     <h3>Go with us</h3>
     <a href="#" class="btn btn-default btn-lg">Find Out More</a>
    </div>

  </body>

</html>