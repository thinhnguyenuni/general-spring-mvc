<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row d-flex justify-content-center">
	<div class="col-12">
		<h2 class="col-12 text-center text-success text-uppercase mb-3">Danh
			sách khách hàng sử dụng dịch vụ</h2>
		<div class="col-12 d-flex justify-content-center">
			<a href="${pageContext.request.contextPath}/home"
				class="btn btn-success">Quay về trang chủ</a>
		</div>
		<div class="col-12">
			<div class="row d-flex justify-content-end">
				<!-- Form tìm kiếm -->
				<form action="list" method="get" class="w-25">
					<!-- Input ẩn để truyền pageSize -->
					<input type="hidden" name="pageSize" value="${pageSize}">
					<div class="search input-group">
						<!-- Ô nhập dữ liệu tìm kiếm -->
						<input type="text" name="search"
							class="form-control search-input border-success"
							placeholder="Search" autocomplete="off" value="${search}">
						<!-- Nút tìm kiếm -->
						<button class="btn btn-outline-success search-btn" type="submit">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</form>
				<!-- Biểu tượng tìm kiếm -->
				<i class="far fa-search"></i>
			</div>

			<div class="table-responsive">
				<table id="listSumInfoTable"
					class="table table-hover table-striped table-content">
					<thead>
						<tr>
							<th>Mã KH</th>
							<th>Tên KH</th>
							<th>Mã máy</th>
							<th>Vị trí</th>
							<th>Trạng thái</th>
							<th>Ngày sử dụng máy</th>
							<th>Giờ sử dụng máy</th>
							<th>Thời gian dùng máy</th>
							<th>Mã dịch vụ</th>
							<th>Ngày sử dụng dịch vụ</th>
							<th>Giờ sử dụng dịch vụ</th>
							<th>Số lượng</th>
							<th>Tổng tiền</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<!-- Sử dụng vòng lặp forEach để duyệt qua danh sách sumInfos -->
						<c:forEach var="sumInfo" items="${sumInfos}" varStatus="status">
							<tr>
								<!-- Hiển thị thông tin của mỗi sumInfo -->
								<td>${sumInfo.customerId}</td>
								<td>${sumInfo.customerName}</td>
								<td>${sumInfo.computerID}</td>
								<td>${sumInfo.location}</td>
								<td>${sumInfo.status}</td>
								<td>${sumInfo.usingComputerDate}</td>
								<td>${sumInfo.usingComputerTime}</td>
								<td>${sumInfo.duration}</td>
								<td>${sumInfo.serviceID}</td>
								<td>${sumInfo.usingServiceDate}</td>
								<td>${sumInfo.usingServiceTime}</td>
								<td>${sumInfo.quantity}</td>
								<td>${sumInfo.totalCost}</td>
								<td>
									<!-- Kiểm tra nếu sumInfo có serviceID không --> <c:if
										test="${sumInfo.serviceID != null}">
										<!-- Nút thanh toán -->
										<button type="button" class="btn btn-danger ms-3"
											data-bs-toggle="modal"
											data-bs-target="#computer${sumInfo.computerID}">
											<i class="fab fa-cc-visa"></i>
										</button>
										<!-- Modal thanh toán -->
										<div class="modal fade" id="computer${sumInfo.computerID}"
											tabindex="-1" aria-labelledby="exampleModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">Thanh
															toán</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-body">
														<!-- Hiển thị thông báo xác nhận thanh toán -->
														Bạn có muốn thanh toán máy <span class="text-danger">${sumInfo.computerID}</span>
														này không ?
													</div>
													<div class="modal-footer">
														<!-- Nút hủy -->
														<button type="button" class="btn btn-secondary"
															data-bs-dismiss="modal">Hủy</button>
														<!-- Nút thanh toán -->
														<a
															href="${pageContext.request.contextPath}/suminfo/pay?id=${sumInfo.computerID}"
															class="btn btn-danger">Có </a>
													</div>
												</div>
											</div>
										</div>
									</c:if> <!-- Kiểm tra nếu sumInfo không có serviceID --> <c:if
										test="${sumInfo.serviceID == null}">
										<!-- Nút hiển thị thông báo khi không có dịch vụ -->
										<button type="button" class="btn btn-danger ms-3"
											data-bs-toggle="modal" data-bs-target="#note">
											<i class="fab fa-cc-visa"></i>
										</button>
										<!-- Modal thông báo -->
										<div class="modal fade" id="note" tabindex="-1"
											aria-labelledby="exampleModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel1">Thông
															báo</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-body">Máy này chưa có dịch vụ!</div>
													<div class="modal-footer">
														<!-- Nút hủy -->
														<button type="button" class="btn btn-secondary"
															data-bs-dismiss="modal">Hủy</button>
													</div>
												</div>
											</div>
										</div>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
			<div class=row>
				<div class="col-5">
					<!-- Phần chọn số lượng hàng hiển thị trên mỗi trang và hiển thị tổng số hàng -->
					<div class="input-group mb-3">
						<!-- Nhãn cho phần chọn số lượng hàng -->
						<label for="pageSizeSelect">Show </label>
						<!-- Dropdown để chọn số lượng hàng hiển thị -->
						<select class="select mx-2 rounded px-1" id="pageSizeSelect">
							<!-- Sử dụng vòng lặp forEach để duyệt qua danh sách các lựa chọn số lượng hàng trên trang -->
							<c:forEach var="page" items="${pageSizes}">
								<!-- Kiểm tra nếu lựa chọn này trùng với số lượng hàng hiện tại được chọn, đánh dấu là đã chọn -->
								<c:if test="${page == pageSize }">
									<option value="${page}" selected="selected">${page}</option>
								</c:if>
								<!-- Nếu không, hiển thị lựa chọn bình thường -->
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
					<!-- Kiểm tra nếu trang hiện tại lớn hơn 1 thì hiển thị nút Previous -->
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

					<!-- Kiểm tra nếu trang hiện tại nhỏ hơn tổng số trang thì hiển thị nút Next -->
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