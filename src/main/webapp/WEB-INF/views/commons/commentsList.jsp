<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<table class="table table-striped">

    <thead>
        <tr>
            <th>
                작성자
            </th>
            <th>
                내용
            </th>
            <th>
                작성일
            </th>
            <th>

            </th>
     
        </tr>
    </thead>
    <tbody>

  <c:forEach items="${list}" var="c">
        	<tr>
        		<td>${c.userName}</td>
        		<td>${c.boardContents}</td>
        		<td>${c.boardDate}</td>
                <td>
                    <button class="btn btn-dark deleteComments commentUpdate">수정</button>    
                    <button class="btn btn-dark deleteComments commentDelete">삭제</button>
                </td>
        	</tr>
        </c:forEach>

    </tbody>


</table>    



            <nav aria-label="Page navigation example">
                <ul class="pagination">
                <li class="page-item">
                    <button class="page-link pages" href="./list?page${pager.start-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    </button>
                </li>
                
                <c:forEach begin="${pager.start}" end="${pager.end}" var="i">
                <li class="page-item"><button class="page-link pages" href="./list?page=${i}">${i}</button></li>
                </c:forEach>
                <li class="page-item ${pager.endCheck?'disabled':''}">
                    <button class="page-link pages" href="./list?page=${pager.end+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    </button>
                </li>
                </ul>
            </nav>



            