<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<name>즐겨찾기 추가</name>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 JQUERY 원본 필요 --%>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1 class="font-weight-bold">즐겨찾기 추가하기</h1>
		<div class="mt-3">
		제목
		<input class="form-control" id="name">
		</div>
		주소
		<div class="d-flex mt-3">
		<input class="form-control col-10" id="url">
		<button class="btn btn-info col-1 ml-3" id="urlCheckbtn">중복확인</button>
		</div>
		<small id="urlStatus" class="text-danger d-none">중복된 url입니다.</small>
		<small id="availableUrlStatus" class="text-danger d-none">저장 가능한 url입니다.</small>
		<input type="button" id="addBtn" value="추가" class="form-control mt-3 btn btn-success">
	</div>
	
<script>
	$(document).ready(function() {
		// 중복확인
		$("#urlCheckbtn").click('on', function(){
			// alert("중복");
			let url = $("#url").val().trim();
			
			if (!url) {
				alert("url을 입력하세요.");
				return;
			}
			
			// AJAX 통신 - DB 중복 확인
			$.ajax({
				//request
				type:"POST" // url같은 긴 String을 보낼때는 post 방식
				, url:"/lesson06/is-duplicated-url"
				, data:{"url":url}
				
				//response
				, success:function(data) { // data : JSON => dictionary
					// {"code":200, "is_duplicated":true}
					if (data.is_duplicated) {
						// 중복
						$("#urlStatus").removeClass("d-none");
						$("#availableUrlStatus").addClass("d-none");
					} else {
						// 중복아님 => 사용 가능
						$("#availableUrlStatus").removeClass("d-none");
						$("#urlStatus").addClass("d-none");
					}
					
				}
				, error:function(request, status, error){
					alert("중복 확인에 실패했습니다.");
				}
			});
			
			
			
		});
		
		
		
		$("#addBtn").click('on', function() {
			
			// validation
			let name = $("#name").val().trim();
			if (name == ""){
				alert("제목을 입력하세요.");
				return;
			}
			
			let url = $("#url").val().trim();
			if (url.length < 1){
				alert("주소를 입력하세요.");
					return;
			}if (!url.startWith("http://") && !url.startWith("https://")){
				alert("주소를 제대로 입력하세요. http, https 포함");
				return;
			}

			
			$.ajax({
				//request
				type:"POST"
				,url:"/lesson06/quiz01/add-bookmark"
				,data:{"name":name, "url":url}
				
				//response
				,success:function(data){   // data => JSON String => parsing(jquery ajax함수) => dictionary
					alert(data);
					if (data.code == 200){
						location.href="/lesson06/quiz01/after-add-bookmark";
					}
				}
				,error:function(request,status,error){
					alert(request);
					alert(status);
					alert(error);
				}
			});
		});
	});
</script>
	
</body>
</html>