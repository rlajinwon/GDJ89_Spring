<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="/WEB-INF/views/templates/boot_css.jsp"></c:import>

</head>
<body>
<c:import url="/WEB-INF/views/templates/layout_header.jsp"></c:import>


<div class = "continer-fluid my-5">
	<div class ="row col-md-8 offset-md-2">


				<form action="./login" method="post">
						
			<div class="mb-3">
				<label for="userName" class="form-label">아이디
					</label> <input type="text" name="userName" class="form-control"
					id="userName" placeholder="아이디 입력하세요">
			</div>
			
			<div class="mb-3">
				<label for="passWord" class="form-label">비밀번호
					</label> <input type="password" name="passWord" class="form-control"
					id="passWord" placeholder="비밀번호 입력하세요">
			</div>
			
					  <button id="btn1" type="button" class="btn btn-dark">로그인</button>
					
			
				</form>


		</div>
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>


<script src="/resources/js/login.js"></script>
</body>
</html>