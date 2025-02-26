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
	
		<!-- contents 내용 작성 -->

        <form action="./add" method="post">
		 <div class="mt-2 p-3 bg-body rounded shadow-sm">
     
   			  <div class="mb-3">
  			<label for="boardContents" class="form-label">댓글</label>
 			 <textarea class="form-control" name="boardContents" id="boardContents" rows="1"></textarea>
				</div>
				
				  <button type="submit" class="btn btn-dark">작성</button>
		
    </div>
</form>
	
	</div>
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>