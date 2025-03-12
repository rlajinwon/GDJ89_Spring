<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="/WEB-INF/views/templates/boot_css.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/summernote.jsp"></c:import>

</head>
<body>
<c:import url="/WEB-INF/views/templates/layout_header.jsp"></c:import>


<div class = "continer-fluid my-5">
	<div class ="row col-md-8 offset-md-2">
				
			
			<form id="product_add" action="./add" method="post">
						
			<div class="mb-3">
				<label for="productName" class="form-label">상품명
					</label> <input type="text" name="productName" class="form-control"
					id="productName" placeholder="상품명 입력">
			</div>
			
			<div class="mb-3">
				<label for="productRate" class="form-label">이자율
					</label> <input type="text" name="productRate" class="form-control"
					id="productRate" placeholder="x.xx">
			</div>

				<div class="mb-3">
				<label for="productDate" class="form-label">만가일
					</label> <input type="date" name="productDate" class="form-control"
					id="productDate" placeholder="값을 입력하세요">
			</div>
			<div class="mb-3">
  			<label for="productDetail" class="form-label">상품설명</label>
 			 <textarea class="form-control" name="productDetail" id="detail" rows="10"></textarea>
				</div>
				
			  <button id="product_btn" type="button" class="btn btn-dark">Submit</button>
			
			
			</form>
			
		</div>
		
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
<script src="/resources/js/add.js"></script>
<script src="/resources/js/files/summernote.js"></script>
</body>
</html>