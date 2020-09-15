<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="wrap"> 
	<h1><span>음악 검색</span> 등록</h1>
	<form id="searchForm" name="searchForm">
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
			<button type="button" class="btn btn-primary" onclick="createSearch();">등록</button>
			<button type="button" class="btn" onclick="location.href='<c:url value="/search/pageList.do'"/>">목록</button>
		</div>
	</form>
</div>

<script>
	function createSearch(){
		if(!confirm("등록하시겠습니까?")) return;
		
		var formData = $("#searchForm").serializeObject();
		
		var request = $.ajax({
			method : "POST",
			url    : MY_CTX + "/search/create.do",
			data   : formData,
		});
		
		request.done(function(data){
			alert("등록되었습니다.");
			location.href = MY_CTX + "/search/pageList.do";
		});
		
		request.fail(console.log);
	}
</script>
