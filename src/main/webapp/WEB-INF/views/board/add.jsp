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
		
		
			
			<form action="" method="post">
						
						
						
						
						
			<div class="mb-3">
				<label for="boardTitle" class="form-label">제목
					</label> <input type="text" name="boardTitle" class="form-control"
					id="boardTitle" placeholder="제목 입력">
			</div>
			
			
			<div class="mb-3">
  			<label for="boardContents" class="form-label">내용 입력</label>
 			 <textarea class="form-control" name="boardContents" id="boardContents" rows="10"></textarea>
				</div>
				
				
				
											<div class="mb-3">
				<label for="profile" class="form-label">첨부파일
					</label> <input type="file" name="attaches" class="form-control"
					id="profile" placeholder="">
			</div>
					
										<div class="mb-3">
				<label for="profile" class="form-label">첨부파일
					</label> <input type="file" name="attaches" class="form-control"
					id="profile" placeholder="">
			</div>
					
										<div class="mb-3">
				<label for="profile" class="form-label">첨부파일
					</label> <input type="file" name="attaches" class="form-control"
					id="profile" placeholder="">
			</div>
	
				
				
				
				
			  <button type="submit" class="btn btn-dark">추가</button>
			
			
			</form>
			
		
		
		
		
		
		
	
	</div>
</div>


<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>