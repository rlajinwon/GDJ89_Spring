

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
		
		
		<div>
				<form id="frm" action="/test" method="">
					<input type="hidden" name="productNum" value="${dto.productNum}">
					<button type="button" id="btn1">수정</button> 
					<button type="button" id="btn2">삭제</button> 
			
				</form>
				<button type="button" id="addCart" data-product-num="${dto.productNum}">장바구니</button>
		</div>




<!-- 
		<div class="d-flex gap-3">
    <a href="/products/update?productNum=${dto.productNum}">
        <button class="btn btn-dark" type="button">수정</button>
    </a>
    
    <a href="/products/delete?productNum=${dto.productNum}">
        <button class="btn btn-dark" type="button">삭제</button>
    </a>
</div> -->


<body class="bg-light">
    <div class="mt-2 p-3 bg-body rounded shadow-sm">
        <h2 class="fs-6">댓글 쓰기</h2>
        <input id="comment_input" class="form-control" type="text">
        <div class="d-flex justify-content-end">
            <button id="btn_add" class="btn btn-dark">등록</button>
        </div>
    </div>
</body>

	<div class="mb-3" id="commentsListResult"></div>


	</div>
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>\
<script src="/resources/js/products/detail.js"></script>

</body>
</html>

