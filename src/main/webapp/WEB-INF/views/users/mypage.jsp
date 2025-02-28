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

				<div class="alert alert-secondary" role="alert">
				${sessionScope.user.userName}
				</div>
				
				<div class="alert alert-secondary" role="alert">
				${sessionScope.user.name}
				</div>
				
				<div class="alert alert-secondary" role="alert">
				${sessionScope.user.email}
				</div>
				
				<div class="alert alert-secondary" role="alert">
					<img alt="" src="/resources/images/profiles/${user.userFileDTO.fileName}">
				</div>
				
				

		</div>
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>