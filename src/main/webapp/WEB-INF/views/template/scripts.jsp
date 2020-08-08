<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!-- CSS -->
<link rel="shortcut icon" type="image/x-icon" href="<c:url value="/images/fav-icon.png"/>" />
<link rel="stylesheet"    type="text/css"     href="<c:url value="/css/style.css"/>" />
<link rel="stylesheet"    type="text/css"     href="<c:url value="/css/slider-style.css"/>" />
<link rel="stylesheet"    type="text/css"     href="<c:url value="/css/jquery.mmenu.all.css"/>" />
<link rel="stylesheet"    type="text/css"     href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" />

<!-- JS -->
<script type="application/x-javascript">
	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
</script>
<!---strat-slider---->
<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/modernizr.custom.28468.js"/>"></script>
<!---//strat-slider---->
<!---start-login-script--->
<script src="<c:url value="/js/login.js"/>"></script>
<!---//End-login-script--->
<!-----768px-menu----->
<script type="text/javascript" src="<c:url value="/js/jquery.mmenu.js"/>"></script>
<script type="text/javascript">
	//	The menu on the left
	$(function() {
		$('nav#menu-left').mmenu();
	});
</script>
<!-----//768px-menu----->
