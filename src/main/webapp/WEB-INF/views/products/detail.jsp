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
	
	
		<c:choose>
		<c:when test="${not empty dto}">
		<h3>상품번호: ${dto.productNum}</h3>
		<h3>상품이름: ${dto.productName}</h3>
		<h3>이자율: ${dto.productRate}</h3>
		<h3>만기일: ${dto.productDate}</h3>
		<h3>상세정보: ${dto.productDetail}</h3>
		
			</c:when>
		
		<c:otherwise>
		<h3>부서 정보가 없다</h3>
		
		</c:otherwise>
		</c:choose>
	
	
		
	
	</div>
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>