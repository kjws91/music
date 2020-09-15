<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="wrap"> 
	<h1><span>음악 </span> 리스트</h1>
	<table class="table table-musics table-hover">
		<thead>
			<tr>
				<th width="10%">#</th>
				<th width="*">노래 제목</th>
				<th width="20%">작성자</th>
				<th width="30%">작성일</th>
			</tr>
		</thead>
		<tbody id="musicList">
			<tr><td colspan="4">게시물이 존재하지 않습니다.</td></tr>
		</tbody>
	</table>
	<button type="button" class="btn btn-primary" onclick="location.href='<c:url value="/music/pageRegist.do'"/>">등록</button>
</div>
<script>
function getMusicList(){
	var request = $.ajax({
		method: "GET",
		url: "/music/getList.do",
		data: {}
	});
	
	request.done(function(data){
		var list = data.list;
		var $musicList = $("#musicList").empty();
		
		if(list.length === 0){
			$musicList.append('<tr><td colspan="4">게시물이 존재하지 않습니다.</td></tr>');
		}
		
		list.forEach(function(music){
			var detailPageUrl = MY_CTX + `/music/pageDetail.do?id=${'${music.id}'}`;
			
			$musicList.append(`
			<tr>
				<th scope="row">${'${music.id}'}</th>
				<td><a href="${'${detailPageUrl}'}">${'${music.title}'}</a></td>
				<td>${'${music.regId}'}</td>
				<td>${'${music.regDt}'}</td>
			</tr>
			`);
		});
	});
	
	request.fail(console.log);
}

$(function(){
	getMusicList();
});
</script>
