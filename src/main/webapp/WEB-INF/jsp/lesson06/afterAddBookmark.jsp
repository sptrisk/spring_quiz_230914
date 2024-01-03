<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북마크 추가 성공</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>즐겨찾기 목록</h1>
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookmarkList}" var="List">
				<tr>
					<td>${List.id}</td>
					<td>${List.name}</td>
					<td><a href="${List.url}">${List.url}</td>
							<%-- 1) value로 값 넣기 --%>
					<%-- <button type="button" class="del-btn btn btn-danger" value="${List.id}">삭제</button> --%>
						<%-- data로 값 넣기 --%>
					<td><button type="button" class="del-btn btn btn-danger" data-list-id="${List.id}">삭제</button></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<script>
	$(document).ready(function() {
		// 삭제 버튼 클릭
		$('.del-btn').on('click', function(e) {
			// alert("클릭");
			// 1) button value에 담은 값 가져오기
			// let id = $(this).val();
			// let id = $(this).attr("value");
			// let id = e.target.value;
			
			
			// 2) data를 이용해서 값 가져오기
			// 태그 영역 : data-list-id
			// 스크립트 영역 : .data('list-id')
			let id = $(this).data('list-id');
			// alert(id);
			$.ajax({
				// request
				type:"delete"
				, url:"/lesson06/delete-bookmark"
				, data:{"id":id}
			
				//response
				, success:function(data){
					if (data.code == 200){
						// 성공
						location.reload(true);  // 새로고침
					} else if (data.code == 500) {
						// 실패
						alert(data.error_mesage);
					}
				}
				, error:function(request, status, error){
					alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.");
				}
			})
		});
		
	});
</script>
</body>
</html>