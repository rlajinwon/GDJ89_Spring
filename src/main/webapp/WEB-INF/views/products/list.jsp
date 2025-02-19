<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
	
		<!-- contents 내용 작성 -->
	
		
		<table class="table table-striped-columns">
 			<thead>
 				<tr>
 					<th>Num</th> <th>상품명</th> <th>이자율</th>
 				</tr>
 			</thead>
 			
 			<tbody>
 			
 				<c:forEach items="${list}" var ="v">
 					<tr>
 						<td>${v.productNum}</td>
 						<td><a href="./detail?productNum=${v.productNum}" class="link-secondary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">${v.productName}</a></td>
 						<td>${v.productRate}</td>
 					</tr>
 					
 				</c:forEach>
 					
 			
 			</tbody>
		</table>
		
	
		
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
  			<a href ="/products/add" ><button class="btn btn-dark me-md-2" type="button">추가</button></a>
		</div>
	
	</div>
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		