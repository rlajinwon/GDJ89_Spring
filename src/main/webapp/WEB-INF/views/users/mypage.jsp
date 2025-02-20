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



			<div>
				<fieldset>
					<legend>아이디</legend>
					<h3>${dto.userName}</h3>
				</fieldset>
				
				<fieldset>
					<legend>비밀번호</legend>
					<h3>${dto.passWord}</h3>
				</fieldset>
			

				<fieldset>
					<legend>이름</legend>
					<h3>${dto.name}</h3>
				</fieldset>

				<fieldset>
					<legend>폰번호</legend>
					<h3>${dto.phone}</h3>
				</fieldset>

				<fieldset>
					<legend>이메일</legend>
					<h3>${dto.email}</h3>
				</fieldset>

			</div>


		</div>
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>