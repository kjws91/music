<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="wrap"> 
	<h1><span>음악 리스트</span> 수정</h1>
	<form id="musicForm" name="musicForm">
		<input type="hidden" name="id" value="${param.id}"/>
		<div class="form-group">
			<label for="title" class="col-sm-2 control-label">노래 제목</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="title" name="title" />
			</div>
		</div>
		<div class="form-group">
			<label for="singer" class="col-sm-2 control-label">가수</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="singer" name="singer"/>
			</div>
		</div>
		<div class="form-group">
			<label for="content" class="col-sm-2 control-label">가사</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="content" name="content"/>
			</div>
		</div>
		<div class="form-group">
			<label for="year" class="col-sm-2 control-label">출시 년도</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="year" name="year"/>
			</div>
		</div>
		<div class="form-group text-right">
			<button type="button" class="btn btn-primary" onclick="modifyMusic();">수정</button>
			<button type="button" class="btn btn-primary" onclick="deleteMusic();">삭제</button>
			<button type="button" class="btn" onclick="location.href='<c:url value="/music/pageDetail.do?id=${param.id}'"/>">취소</button>
		</div>
	</form>
</div>

<script>
	function getMusic(){
		var request = $.ajax({
			method : "GET",
			url    : MY_CTX + "/music/get.do",
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
	function modifyMusic(){
		if(!confirm("수정하시겠습니까?")) return;
		
		var formData = $("#musicForm").serializeJson();
		
		var request = $.ajax({
			method      : "PUT",
			url         : MY_CTX + "/music/modify.do",
			contentType : "application/json",
			data        : formData,
		});
		
		request.done(function(data){
			alert("수정되었습니다.");
			location.href = MY_CTX + `/music/pageDetail.do?id=${param.id}`;
		});
		
		request.fail(console.log);
	}
	function deleteMusic(){
		if(!confirm("삭제하시겠습니까?")) return;
		var request = $.ajax({
			method      : "DELETE",
			url         : MY_CTX + "/music/remove.do",
			contentType : "application/json",
			data        : JSON.stringify({
				id : "${param.id}",
			}),
		});
		
		request.done(function(data){
			alert("삭제되었습니다.");
			location.href = MY_CTX + "/music/pageList.do";
		});
		
		request.fail(console.log);
	}
	$(function(){
		getMusic();
	});
</script>
