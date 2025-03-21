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
	
	
	<h1>${kind} Detail Page</h1>
	
		<table class="table table-dark ">
			<thead>
				<tr >
					<th>TITLE</th>
					<th>WRITER</th>
					<th>DATE</th>
					<th>HIT</th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td>${dto.boardTitle}</td>
					<td>${dto.userName}</td>
					<td>${dto.boardDate}</td>
					<td>${dto.boardHit}</td>
				</tr>

		
		</table>
		
		
		<div>
		<c:forEach items="${dto.boardFileDTO}" var ="f">
			<a href="./fileDown?fileNum=${f.fileNum}">${f.oldName}</a>	
		</c:forEach>
		
		
		</div>
		
		
		
		
		
		
		
		<div class="alert alert-dark" role="alert" style="min-height: 60vh">
		  ${dto.boardContents}
		</div>
	
	
		<form id="frm" action="/test" method="">
					<input type="hidden" name="boardNum" value="${dto.boardNum}">
					<c:if test="${dto.userName eq user.userName}">
					<button type="button" id="btn1">수정</button> 
					<button type="button" id="btn2">삭제</button> 
					</c:if>
					<button type="button" id="btn3">답글</button> 
					

				</form>

				




	</div>
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
<script src="/resources/js/detail.js"></script>
</body>
</html>