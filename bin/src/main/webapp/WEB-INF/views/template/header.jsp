<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!------start-768px-menu---->
<div id="page">
		<div id="header">
			<a class="navicon" href="#menu-left"> </a>
		</div>
		<nav id="menu-left">
			<ul>
				<li><a href="<c:url value="/"/>">홈</a></li>
				<li><a href="<c:url value="/board/pageList.do"/>">게시판</a></li>
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
			<a href="<c:url value="/"/>">추천 음악 검색 프로젝트</a>
		</div>
	</div>
	<div class="header-right">
		<div class="top-nav">
		<ul>
			<li><a href="<c:url value="/"/>">홈</a></li>
			<li><a href="<c:url value="/board/pageList.do"/>">게시판</a></li>
		</ul>
	</div>
	<div class="sign-ligin-btns">
		<ul>
			<li id="signupContainer"><a class="signup" id="signupButton" onclick="location.href='<c:url value="/member/pageRegist.do'"/>"><span>회원가입</span></a></li>
			<li id="loginContainer"><a class="login" id="loginButton" href="#"><span>로그인</span></i></a>
				 <div class="clear"> </div>
	                <div id="loginBox">                
	                    <form id="loginForm">
	                        <fieldset id="body">
	                            <fieldset>
	                                <label for="email">아이디</label>
	                                <input type="text" name="email" id="email" />
	                            </fieldset>
	                            <fieldset>
	                                <label for="password">비밀번호</label>
	                                <input type="password" name="password" id="password" />
	                            </fieldset>
	                            <input type="submit" id="login" value="로그인" />
	                        </fieldset>
	                    </form>
	                </div>
	            <!-- Login Ends Here -->
			</li>
			<div class="clear"> </div>
		</ul>
	</div>
	<div class="clear"> </div>
	</div>
	<div class="clear"> </div>
</div>
</div>
<!---//End-header---->