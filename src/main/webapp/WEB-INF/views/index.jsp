<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./templates/boot_css.jsp"></c:import>

</head>
<body>
	<c:import url="./templates/layout_header.jsp"></c:import>
	<img alt="" src="">
	
	<div class="continer-fluid my-5">
		<div class="row col-md-8 offset-md-2">

			<div id="carouselExampleAutoplaying" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="/resources/images/a1.jpg" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="../../resources/images/a2.jpg" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="/resources/images/a3.jpg" class="d-block w-100" alt="...">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>

		</div>
	</div>

	<c:import url="./templates/layout_footer.jsp"></c:import>
	<c:import url="./templates/boot_js.jsp"></c:import>
</body>
</html>