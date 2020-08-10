<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="wrap"> 
	<h1><span>자유게시판</span> 상세</h1>
	<fieldset disabled>
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
		<div class="form-group">
			<label for="regId" class="col-sm-2 control-label">작성자</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="regId" name="regId"/>
			</div>
		</div>
		<div class="form-group">
			<label for="regDt" class="col-sm-2 control-label">작성일</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="regDt" name="regDt"/>
			</div>
		</div>
	</fieldset>
	<div class="form-group text-right">
		<button type="button" class="btn btn-primary" onclick="location.href='<c:url value="/board/pageModify.do?id=${param.id}'"/>">수정</button>
		<button type="button" class="btn" onclick="location.href='<c:url value="/board/pageList.do'"/>">목록</button>
	</div>
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
	
	$(function(){
		getBoard();
	});
</script>
