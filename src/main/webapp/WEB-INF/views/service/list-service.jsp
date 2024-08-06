<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row d-flex justify-content-center">
	<div class="col-md-6">
		<h2 class="col-12 text-center text-success text-uppercase mb-3">Danh
			sách dịch vụ</h2>
		<div class="col-12 d-flex justify-content-center">
			<a href="${pageContext.request.contextPath}/service/create"
				class="btn btn-success">Tạo mới dịch vụ</a>
		</div>
		<div class="col-12">
			<div class="row d-flex justify-content-end">
				<form action="list" method="get" style="width: 35%;">
					<input type="hidden" name="pageSize" value="${pageSize}">
					<div class="search input-group">
						<input type="text" name="search"
							class="form-control search-input border-success"
							placeholder="Search" autocomplete="off" value="${search}">
						<button class="btn btn-outline-success search-btn" type="submit">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</form>
				<i class="far fa-search"></i>
			</div>

			<table id="listServiceTable"
				class="table table-hover table-striped table-responsive table-content">
				<thead>
					<!-- Tiêu đề của bảng -->
					<tr>
						<th>Mã dịch vụ</th>
						<th>Tên dịch vụ</th>
						<th>Đơn vị tính</th>
						<th>Đơn giá</th>
						<th></th>
						<!-- Cột trống dành cho các nút hoạt động -->
					</tr>
				</thead>
				<tbody>
					<!-- Sử dụng vòng lặp forEach để duyệt qua danh sách các dịch vụ -->
					<c:forEach var="service" items="${services}" varStatus="status">
						<tr>
							<!-- Hiển thị thông tin của dịch vụ -->
							<td>${service.id}</td>
							<td>${service.name}</td>
							<td>${service.unit}</td>
							<td>${service.price}</td>
							<td>
								<!-- Nút chỉnh sửa và nút xóa cho mỗi dịch vụ --> <a
								href="update?id=${service.id}"><i
									class="fas fa-edit text-success mx-3"></i></a>
								<button type="button" class="btn" data-bs-toggle="modal"
									data-bs-target="#service${service.id}">
									<i class="fas fa-trash-alt text-danger"></i>
								</button> <!-- Modal xác nhận xóa dịch vụ -->
								<div class="modal fade" id="service${service.id}" tabindex="-1"
									aria-labelledby="exampleModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">Xóa dịch
													vụ</h5>
												<button type="button" class="btn-close"
													data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											<div class="modal-body">
												<!-- Hiển thị thông báo xác nhận xóa dịch vụ -->
												Bạn có muốn xóa dịch vụ <span class="text-danger">${service.id}</span>
												này không ?
											</div>
											<div class="modal-footer">
												<!-- Nút hủy xóa -->
												<button type="button" class="btn btn-secondary"
													data-bs-dismiss="modal">Hủy</button>
												<!-- Nút xác nhận xóa -->
												<a href="delete/${service.id}" class="btn btn-danger">Có</a>
											</div>
										</div>
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class=row>
				<div class="col-5">
					<!-- Phần chọn số lượng hàng hiển thị trên mỗi trang và hiển thị tổng số hàng -->
					<div class="input-group mb-3">
						<!-- Nhãn cho phần chọn số lượng hàng -->
						<label for="pageSizeSelect">Show </label>
						<!-- Dropdown để chọn số lượng hàng hiển thị -->
						<select class="select mx-2 rounded px-1" id="pageSizeSelect">
							<!-- Sử dụng vòng lặp forEach để duyệt qua danh sách các lựa chọn số lượng hàng trên trang -->
							<!-- Kiểm tra nếu lựa chọn này trùng với số lượng hàng hiện tại được chọn, đánh dấu là đã chọn -->
							<!-- Nếu không, hiển thị lựa chọn bình thường -->

							<c:forEach var="page" items="${pageSizes}">

								<c:if test="${page == pageSize }">
									<option value="${page}" selected="selected">${page}</option>
								</c:if>

								<c:if test="${page != pageSize }">
									<option value="${page}">${page}</option>
								</c:if>
							</c:forEach>
						</select>
						<!-- Nhãn cho phần chọn số lượng hàng -->
						<label for="pageSizeSelect"> rows per page </label>
					</div>
					<!-- Hiển thị tổng số hàng -->
					<div class="fw-bold">
						Total: <span class="text-success"> ${totalRows} </span> rows
					</div>
				</div>

				<ul class="col-7 pagination d-flex justify-content-end">
					<!-- Kiểm tra nếu trang hiện tại không phải là trang đầu tiên thì hiển thị nút Previous -->
					<c:if test="${pageNumber > 1}">
						<li class="page-item"><a class="page-link"
							href="list?pageNumber=${pageNumber-1}&pageSize=${pageSize}&search=${search}">Previous</a>
						</li>
					</c:if>

					<!-- Sử dụng vòng lặp forEach để tạo ra các nút trang -->
					<!-- Nếu đây là trang hiện tại, đánh dấu là active -->
					<!-- Nếu không, hiển thị nút trang thông thường -->
					<c:forEach begin="1" end="${totalPages}" var="i">
						<c:choose>

							<c:when test="${pageNumber eq i}">
								<li class="page-item"><a
									class="page-link active text-white">${i}</a></li>
							</c:when>

							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="list?pageNumber=${i}&pageSize=${pageSize}&search=${search}">${i}</a>
								</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<!-- Kiểm tra nếu trang hiện tại không phải là trang cuối cùng thì hiển thị nút Next -->
					<c:if test="${pageNumber lt totalPages}">
						<li class="page-item"><a class="page-link"
							href="list?pageNumber=${pageNumber+1}&pageSize=${pageSize}&search=${search}">Next</a>
						</li>
					</c:if>
				</ul>

			</div>
		</div>
	</div>
</div>