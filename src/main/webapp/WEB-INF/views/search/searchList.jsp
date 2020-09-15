<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="wrap"> 
	<h1><span>음악 </span> 검색</h1>
	<table class="table table-searchs table-hover">
		<thead>
			<tr>
				<th width="10%">#</th>
				<th width="*">노래 제목</th>
				<th width="20%">작성자</th>
				<th width="30%">작성일</th>
			</tr>
		</thead>
		<tbody id="searchList">
			<tr><td colspan="4">게시물이 존재하지 않습니다.</td></tr>
		</tbody>
	</table>
	<button type="button" class="btn btn-primary" onclick="location.href='<c:url value="/search/pageRegist.do'"/>">등록</button>
</div>
<script>
function getSearchList(){
	var request = $.ajax({
		method: "GET",
		url: "/search/getList.do",
		data: {}
	});
	
	request.done(function(data){
		var list = data.list;
		var $searchList = $("#searchList").empty();
		
		if(list.length === 0){
			$searchList.append('<tr><td colspan="4">게시물이 존재하지 않습니다.</td></tr>');
		}
		
		list.forEach(function(search){
			var detailPageUrl = MY_CTX + `/search/pageDetail.do?id=${'${search.id}'}`;
			
			$searchList.append(`
			<tr>
				<th scope="row">${'${search.id}'}</th>
				<td><a href="${'${detailPageUrl}'}">${'${search.title}'}</a></td>
				<td>${'${search.regId}'}</td>
				<td>${'${search.regDt}'}</td>
			</tr>
			`);
		});
	});
	
	request.fail(console.log);
}

$(function(){
	getSearchList();
});
</script>
