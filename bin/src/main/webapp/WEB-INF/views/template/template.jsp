<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
	<head>
		<title>Runkeeper Website Template | Home :: w3layouts</title>
		<tiles:insertAttribute name="meta"/>
		<tiles:insertAttribute name="scripts"/>
	</head>
	<body>
		<!---start-wrap---->
		<tiles:insertAttribute name="header"/>
		<!----start-content--->
		<div class="content">
			<div class="content-feature-grids">
				<tiles:insertAttribute name="content"/>
			</div>
			<tiles:insertAttribute name="footer"/>
		</div>
		<!----//End-content--->
		<!---//End-wrap---->
	</body>
</html>

