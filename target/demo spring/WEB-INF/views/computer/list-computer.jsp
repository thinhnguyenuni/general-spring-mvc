<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <div class="row d-flex justify-content-center">
 <div class ="col-md-6">
<h2 class="col-12 text-center text-success text-uppercase mb-3">Danh sách máy</h2>
<div class="col-12">
<div class="float-right search btn-group">
     <input class="form-control search-input" type="search" aria-label="Search" placeholder="Search" autocomplete="off">
        </div>
<div class="d-flex flex-row">
<label>Show <select class="form-select" id="pageSizeSelect">
            <c:forEach var="pageSize" items="${pageSizes}">
                <option value="${pageSize}">${pageSize}</option>
            </c:forEach>
        </select>
       rows per page
</label></div>
</div>
	<table id="listComputerTable" class="table table-hover table-striped table-responsive table-content">
        <thead>
            <tr>
                <th>Mã máy</th>
                <th>Vị trí</th>
                <th>Trạng thái</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="computer" items="${computers}" varStatus="status">
					<tr>
						<td>${computer.id}</td>
						<td>${computer.location}</td>
						<td>${computer.status}</td>
						<td>
						 <a
							href="update?id=${computer.id}"><i class="fas fa-edit text-success mx-3"></i></a>
						<a href="delete?id=${computer.id}"><i class="fas fa-trash-alt text-danger"></i></a>
						</td>
					</tr>
			</c:forEach>
        </tbody>
    </table>
    <div class="d-flex justify-content-end">
    <ul class="pagination">
			<c:if test="${currentPage > 1}">
			<li class="page-item"><a class="page-link" href="list?page=${currentPage-1}">Previous</a></li>
				
			</c:if>
			<c:forEach begin="1" end="${totalPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<li class="page-item"><a class="page-link active text-white"> ${i} </a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link" href="list?page=${i}">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${currentPage lt totalPages}">
				<li class="page-item"><a class="page-link" href="list?page=${currentPage+1}">Next</a></li>
			</c:if>
			</ul>
		</div>
    </div>
    </div>