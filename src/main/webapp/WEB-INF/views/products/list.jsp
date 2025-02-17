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
 					<td>일</td> <td>이</td> <td>삼</td>
 				</tr>
 			</thead>
 			
 			<tbody>
 				<tr>
 					<td>1</td> <td>1</td> <td>1</td>
 				</tr>
 				
 					<tr>
 					<td>1</td> <td>1</td> <td>1</td>
 				</tr>
 				
 					<tr>
 					<td>1</td> <td>1</td> <td>1</td>
 				</tr>
 				
 					<tr>
 					<td>1</td> <td>1</td> <td>1</td>
 				</tr>
 				
 					<tr>
 					<td>1</td> <td>1</td> <td>1</td>
 				</tr>
 			
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
