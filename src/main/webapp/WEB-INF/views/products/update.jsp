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
	
		
		
		
			<form action="./update" method="post">
		
			<input type="hidden" name="productNum" value="${dto.productNum }">
			
		  <div class="mb-3 col-3">
		    <label for="product_Name" class="form-label">상품 이름</label>
		    <input type="text" class="form-control" id="productName" name="productName" value="${dto.productName }">
		  </div>
		  <div class="mb-3 col-3">
		    <label for="product_Rate" class="form-label">상품 이율</label>
		    <input type="text" class="form-control" id="productRate" name="productRate" value="${dto.productRate }">
		  </div>
		  <div class="mb-3 col-3">
		    <label for="product_Date" class="form-label">가입일</label>
		    <input type="date" class="form-control" id="productDate" name="productDate" value="${dto.productDate }">
		  </div>
		  <div class="mb-3 col-3">
		    <label for="product_Detail" class="form-label">상세 설명</label>
		    <input type="text" class="form-control" id="productDetail" name="productDetail" value="${dto.productDetail }">
		  </div>
		  
		  <button type="submit" class="btn btn-dark">상품 수정</button>
		</form>
		
	
	</div>
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>