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
	

			<h1>${kind}</h1>
				
			<form action="" method="post">
		
			<input type="hidden" name="boardNum" value="${dto.boardNum}">
			
		  <div class="mb-3">
		    <label for="boardTitle" class="form-label">제목</label>
		    <input type="text" class="form-control" id="boardTitle" name="boardTitle" value="${dto.boardTitle}">
		  </div>
		  <div class="mb-3">
		    <label for="boardContents" class="form-label">내용</label>
		     <textarea class="form-control" name="boardContents" id="boardContents" rows="10">${dto.boardContents}</textarea>
		  </div>
	
		  
		  <button type="submit" class="btn btn-dark">글작성</button>
		</form>
		
		
		
		


	
	</div>
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>