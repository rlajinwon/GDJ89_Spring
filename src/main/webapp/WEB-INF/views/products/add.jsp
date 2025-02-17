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

			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label">테이블1값
					</label> <input type="text" class="form-control"
					id="formGroupExampleInput" placeholder="값을 입력하세요">
			</div>
			
			<div class="mb-3">
				<label for="formGroupExampleInput2" class="form-label">테이블2값
					</label> <input type="text" class="form-control"
					id="formGroupExampleInput2" placeholder="값을 입력하세요">
			</div>

				<div class="mb-3">
				<label for="formGroupExampleInput2" class="form-label">테이블3값
					</label> <input type="text" class="form-control"
					id="formGroupExampleInput2" placeholder="값을 입력하세요">
			</div>
			
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
  			<a href ="#" ><button class="btn btn-dark me-md-2" type="button">입력</button></a>
			</div>
			
			
		</div>
		
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>