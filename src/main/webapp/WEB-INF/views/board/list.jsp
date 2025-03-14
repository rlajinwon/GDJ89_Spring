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

		
		
			<h1>${kind} List Page</h1>
		
		<table class="table table-striped-columns">
 			<thead>
 				<tr>
 					<th>Num</th> <th>제목</th> <th>작성일</th><th>조회수</th><th>작성자</th>
 				</tr>
 			</thead>
 			
 			<tbody>
 			
 				<c:forEach items="${list}" var ="v">
 					<tr>
 						<td>${v.boardNum}</td>
 						<td><a href="./detail?boardNum=${v.boardNum}" class="link-secondary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
 							<c:catch>
 							<c:forEach begin="1" end="${v.boardDepth}">--</c:forEach>
 							</c:catch>
 							 ${v.boardTitle}
 						</a></td>
 						<td>${v.boardDate}</td>
 						<td>${v.boardHit}</td>
 						<td>${v.userName}</td>
 					</tr>
 					
 				</c:forEach>
 					
 			
 			</tbody>
		</table>
		
		
					<nav aria-label="Page navigation example">
					  <ul class="pagination">
					    <li class="page-item">
					      <a class="page-link" href="./list?page${pager.start-1}" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    
					    <c:forEach begin="${pager.start}" end="${pager.end}" var="i">
					    <li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
						</c:forEach>
					    <li class="page-item ${pager.endCheck?'disabled':''}">
					      <a class="page-link" href="./list?page=${pager.end+1}" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					  </ul>
					</nav>
		
		<c:if test="${kind eq 'notice' and not empty user and user.userName eq 'FFF'}">
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
  			<a href ="./add" ><button class="btn btn-dark me-md-2" type="button">글 작성</button></a>
		</div>
	
	</c:if>
	
				
		<c:if test="${kind ne 'notice' and not empty user}">
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
  			<a href ="./add" ><button class="btn btn-dark me-md-2" type="button">글 작성</button></a>
		</div>
	
	</c:if>
	
	</div>
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
<script src="./resources/js/list.js"></script>
</body>
</html>