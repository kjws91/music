<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="wrap"> 
	<h1><span>회원</span> 가입</h1>
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
		<div class="form-group">
			<label for="content" class="col-sm-2 control-label">비밀번호 확인</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="password2" name="password2"/>
			</div>
		</div>
		<div class="form-group text-right">
			<button type="button" class="btn btn-primary" onclick="createMember();">등록</button>
			<button type="button" class="btn btn-primary" onclick="checkMember();">중복 체크</button>
		</div>
	</form>
</div>

<script>


$(function(){
	
});
function checkMember(){
	var userId = $("#userId").val();
	var request = $.ajax({
		method : "GET",
		url    : MY_CTX + "/member/get.do",
		data   : {
			userId: userId
		}
	});
	
	request.done(function(data){
		if(data) {
			alert("아이디가 중복됩니다.");
		}else{
			alert("중복안됩니다");
		}
	});
}

function createMember(){
	var formData = $("#memberForm").serializeObject();
	
	if(!formData.userId) {
		alert("아이디는 빈 값일 수 없습니다.");
		return;
	} else if(!formData.password || !formData.password2) {
		alert("비밀번호는 빈 값일 수 없습니다.");
		return;
	} else if(formData.password !== formData.password2) {
		alert("비밀번호가 다릅니다.");
		return;
	}
		
	if(!confirm("가입 하시겠습니까?")) return;
	
	var request = $.ajax({
		method : "POST",
		url    : MY_CTX + "/member/create.do",
		data   : formData
	});
	
	request.done(function(data){
		alert("회원가입이 완료 되었습니다.");
		location.href = MY_CTX + "/";

	});
	request.fail(console.log);
}
</script>
