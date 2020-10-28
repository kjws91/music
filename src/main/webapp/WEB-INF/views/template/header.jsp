<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!------start-768px-menu---->
<div id="page">
		<div id="header">
			<a class="navicon" href="#menu-left"> </a>
		</div>
		<nav id="menu-left">
			<ul>
				<li><a href="<c:url value="/"/>">홈</a></li>
				<li><a href="<c:url value="/board/pageList.do"/>">게시판</a></li>
				<li><a href="<c:url value="/search/pageList.do"/>">음악 검색</a></li>
				<li><a href="<c:url value="/music/pageList.do"/>">음악 리스트</a></li>
				<div class="clear"> </div>
			</ul>
		</nav>
</div>
<!------start-768px-menu---->
<!---start-header---->
<div class="header">
	<div class="wrap">
	<div class="header-left">
		<div class="logo">
			<a href="<c:url value="/"/>">음악 검색 및 재생 웹사이트 프로젝트</a>
		</div>
	</div>
	<div class="header-right">
		<div class="top-nav">
		<ul>
			<li><a href="<c:url value="/"/>">홈</a></li>
			<li><a href="<c:url value="/board/pageList.do"/>">게시판</a></li>
			<li><a href="<c:url value="/search/pageList.do"/>">음악 검색</a></li>
			<li><a href="<c:url value="/music/pageList.do"/>">음악 리스트</a></li>
		</ul>
	</div>
	<div class="sign-ligin-btns">
		<ul>
			<c:if test="${sessionScope.userInfo==null}">
					<li id="signupContainer"><a class="signup" id="signupButton" onclick="location.href='<c:url value="/member/pageRegist.do"/>'"><span>회원가입</span></a></li>
					<li id="loginContainer"><a class="login" id="loginButton" onclick="location.href='<c:url value="/member/pageLogin.do"/>'"><span>로그인</span></a></li>  
			</c:if>
			<c:if test="${sessionScope.userInfo!=null}">
					<li id="logoutContainer"><a class="login" id="logoutButton" onclick="location.href='<c:url value="/member/logout.do"/>'"><span>로그아웃</span></a></li>
			</c:if>
		</ul>
	</div>
	<div class="clear"> </div>
	</div>
	<div class="clear"> </div>
</div>
</div>
<!---//End-header---->