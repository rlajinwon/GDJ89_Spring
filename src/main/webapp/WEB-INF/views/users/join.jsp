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
	
	
		<form action="./join" method="post">
						
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

				<div class="mb-3">
				<label for="name" class="form-label">이름
					</label> <input type="text" name="name" class="form-control"
					id="name" placeholder="이름을 입력하세요">
			</div>
			
					<div class="mb-3">
				<label for="phone" class="form-label">폰 번호
					</label> <input type="text" name="phone" class="form-control"
					id="phone" placeholder="폰 번호를 입력하세요">
			</div>
			
							<div class="mb-3">
				<label for="email" class="form-label">이메일
					</label> <input type="text" name="email" class="form-control"
					id="email" placeholder="이메일을 입력하세요">
			</div>
		
				
			  <button type="submit" class="btn btn-dark">회원가입</button>
			
			
			</form>
			
		
	
	</div>
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>