<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="wrap"> 
	<h1><span>음악 리스트</span> 등록</h1>
	<form id="musicForm" name="musicForm">
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
			<button type="button" class="btn btn-primary" onclick="createMusic();">등록</button>
			<button type="button" class="btn" onclick="location.href='<c:url value="/music/pageList.do'"/>">목록</button>
		</div>
	</form>
</div>

<script>
	function createMusic(){
		if(!confirm("등록하시겠습니까?")) return;
		
		var formData = $("#musicForm").serializeObject();
		
		var request = $.ajax({
			method : "POST",
			url    : MY_CTX + "/music/create.do",
			data   : formData,
		});
		
		request.done(function(data){
			alert("등록되었습니다.");
			location.href = MY_CTX + "/music/pageList.do";
		});
		
		request.fail(console.log);
	}
</script>
