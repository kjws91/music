<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="wrap"> 
	<h1><span>자유게시판</span> 목록</h1>
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th width="10%">#</th>
				<th width="*">제목</th>
				<th width="20%">작성자</th>
				<th width="30%">작성일</th>
			</tr>
		</thead>
		<tbody id="boardList">
			<tr><td colspan="4">게시물이 존재하지 않습니다.</td></tr>
		</tbody>
	</table>
	<button type="button" class="btn btn-primary" onclick="location.href='<c:url value="/board/pageRegist.do'"/>">등록</button>
</div>
<script>
function getBoardList(){
	var request = $.ajax({
		method: "GET",
		url: "/board/getList.do",
		data: {}
	});
	
	request.done(function(data){
		var list = data.list;
		var $boardList = $("#boardList").empty();
		
		if(list.length === 0){
			$boardList.append('<tr><td colspan="4">게시물이 존재하지 않습니다.</td></tr>');
		}
		
		list.forEach(function(board){
			var detailPageUrl = MY_CTX + `/board/pageDetail.do?id=${'${board.id}'}`;
			
			$boardList.append(`
			<tr>
				<th scope="row">${'${board.id}'}</th>
				<td><a href="${'${detailPageUrl}'}">${'${board.title}'}</a></td>
				<td>${'${board.regId}'}</td>
				<td>${'${board.regDt}'}</td>
			</tr>
			`);
		});
	});
	
	request.fail(console.log);
}

$(function(){
	getBoardList();
});
</script>
