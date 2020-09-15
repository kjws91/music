<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="wrap"> 
	<h1><span>자유게시판</span> 수정</h1>
	<form id="boardForm" name="boardForm">
		<input type="hidden" name="id" value="${param.id}"/>
		<div class="form-group">
			<label for="title" class="col-sm-2 control-label">제목</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="title" name="title" />
			</div>
		</div>
		<div class="form-group">
			<label for="content" class="col-sm-2 control-label">내용</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="content" name="content"/>
			</div>
		</div>
		<div class="form-group text-right">
			<button type="button" class="btn btn-primary" onclick="modifyBoard();">수정</button>
			<button type="button" class="btn btn-primary" onclick="deleteBoard();">삭제</button>
			<button type="button" class="btn" onclick="location.href='<c:url value="/board/pageDetail.do?id=${param.id}'"/>">취소</button>
		</div>
	</form>
</div>

<script>
	function getBoard(){
		var request = $.ajax({
			method : "GET",
			url    : MY_CTX + "/board/get.do",
			data   : {
				id: "${param.id}",
			}
		});
		
		request.done(function(data){
			for(var key in data){
				$(`#${'${key}'}`).val(data[key]);
			}
		});
		
		request.fail(console.log);
	}
	function modifyBoard(){
		if(!confirm("수정하시겠습니까?")) return;
		
		var formData = $("#boardForm").serializeJson();
		
		var request = $.ajax({
			method      : "PUT",
			url         : MY_CTX + "/board/modify.do",
			contentType : "application/json",
			data        : formData,
		});
		
		request.done(function(data){
			alert("수정되었습니다.");
			location.href = MY_CTX + `/board/pageDetail.do?id=${param.id}`;
		});
		
		request.fail(console.log);
	}
	function deleteBoard(){
		if(!confirm("삭제하시겠습니까?")) return;
		var request = $.ajax({
			method      : "DELETE",
			url         : MY_CTX + "/board/remove.do",
			contentType : "application/json",
			data        : JSON.stringify({
				id : "${param.id}",
			}),
		});
		
		request.done(function(data){
			alert("삭제되었습니다.");
			location.href = MY_CTX + "/board/pageList.do";
		});
		
		request.fail(console.log);
	}
	$(function(){
		getBoard();
	});
</script>
