<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="wrap"> 
	<h1><span>로그</span>인</h1>
	<form id="memberForm" name="memberForm">
		<div class="form-group">
			<label for="title" class="col-sm-2 control-label">아이디</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="userId" name="userId" />
			</div>
		</div>
		<div class="form-group">
			<label for="content" class="col-sm-2 control-label">비밀번호</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password" name="password"/>
			</div>
		</div>
		<div class="form-group text-right">
			<button type="button" class="btn btn-primary" onclick="loginMember();">로그인</button>
			<button type="button" class="btn btn-primary" onclick="location.href='<c:url value="/member/pageRegist.do'"/>">회원 가입</button>
		</div>
	</form>
</div>

<script>


$(function(){
	
});
function loginMember(){
	var formData = $("#memberForm").serializeObject();
	
	if(!formData.userId) {
		alert("아이디는 빈 값일 수 없습니다.");
		return;
	} else if(!formData.password) {
		alert("비밀번호는 빈 값일 수 없습니다.");
		return;
	}	
	var userId = $("#userId").val(); 
	var password = $("#password").val();
	var request = $.ajax({
		method : "GET",
		url    : MY_CTX + "/member/login.do",
		data   : {userId: userId,
				  password: password
		}
	});
request.done(function(data){
	if(data.resultCode==999) {
		 alert(data.resultMsg);
	}
	else{
		 alert(data.resultMsg);
	location.href = MY_CTX + "/";
}
});
	request.fail(console.log);
}
</script>
