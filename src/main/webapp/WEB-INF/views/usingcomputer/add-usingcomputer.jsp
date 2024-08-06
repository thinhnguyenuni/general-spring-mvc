<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row w-100 d-flex justify-content-center">
	<div class="col-sm-12 col-md-6 bg-custom p-3 rounded">
		<div class="col-12 text-uppercase h2 text-center text-success ">Đăng
			ký sử dụng máy</div>
		<div class="p-4">
			<form:form id="inputForm"
				action="${pageContext.request.contextPath}/usingcomputer/register"
				method="post" modelAttribute="usingcomputer">
				
				<div class="form-group row mt-3">
					<!-- Nhóm hộp nhập với dòng trên cách nhau một khoảng trống -->
					<form:label path="usingComputerPK.customer.id" for="inputCustomer"
						class="col-sm-4 col-form-label">Tên khách hàng</form:label>
					<!-- Cột dữ liệu -->
					<div class="col">
						<!-- Hộp chọn dữ liệu từ danh sách khách hàng -->
						<form:select class="form-control select2"
							path="usingComputerPK.customer.id">
							<!-- Tạo các tùy chọn từ danh sách khách hàng -->
							<form:options items="${customers}" itemValue="id"
								itemLabel="name" />
						</form:select>
					</div>
				</div>

				<div class="form-group row mt-3">
					<!-- Nhóm hộp nhập với dòng trên cách nhau một khoảng trống -->
					<form:label path="usingComputerPK.computer.id" for="inputComputer"
						class="col-sm-4 col-form-label">Mã máy tính</form:label>
					<!-- Cột dữ liệu -->
					<div class="col">
						<!-- Hộp chọn dữ liệu từ danh sách máy tính -->
						<form:select class="form-control select2"
							path="usingComputerPK.computer.id">
							<!-- Tạo các tùy chọn từ danh sách máy tính -->
							<form:options items="${computers}" itemValue="id" itemLabel="id" />
						</form:select>
					</div>
				</div>

				<div class="form-group row mt-3">
					<!-- Nhãn cho trường nhập ngày bắt đầu -->
					<form:label path="usingComputerPK.date" for="inputDate"
						class="col-sm-4 col-form-label">Ngày bắt đầu</form:label>
					<div class="col">
						<!-- Ô nhập ngày bắt đầu -->
						<form:input path="usingComputerPK.date" type="date"
							class="form-control" id="inputDate"
							placeholder="Ngày bắt đầu sử dụng" autocomplete="off" />
						<!-- Hiển thị thông báo lỗi nếu có -->
						<form:errors path="usingComputerPK.date" />
						<!-- Hiển thị thông báo lỗi trong trường hợp JavaScript bị vô hiệu hóa -->
						<div class="error text-danger" id="errorDate"></div>
					</div>
				</div>

				<div class="form-group row mt-3">
					<!-- Nhãn cho trường nhập giờ bắt đầu -->
					<form:label path="usingComputerPK.time" for="inputHour"
						class="col-sm-4 col-form-label">Giờ bắt đầu</form:label>
					<div class="col">
						<!-- Ô nhập giờ bắt đầu -->
						<form:input path="usingComputerPK.time" type="time"
							class="form-control" id="inputHour"
							placeholder="Giờ bắt đầu sử dụng" autocomplete="off" />
						<!-- Hiển thị thông báo lỗi nếu có -->
						<form:errors path="usingComputerPK.time" />
						<!-- Hiển thị thông báo lỗi trong trường hợp JavaScript bị vô hiệu hóa -->
						<div class="error text-danger" id="errorHour"></div>
					</div>
				</div>

				<div class="form-group row mt-3">
					<form:label path="duration" for="inputDuration"
						class="col-sm-4 col-form-label">Thời gian sử dụng</form:label>
					<div class="col">
						<form:input path="duration" class="form-control"
							id="inputDuration" placeholder="Thời gian sử dụng"
							autocomplete="off" />
						<form:errors path="duration" />
						<div class="error text-danger" id="errorDuration"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<div class="col"></div>
					<div class="col-sm-12 col-md-6 mr-2 d-flex justify-content-end">
						<button type="reset" class="btn btn-success">Reset</button>
						<button type="submit" class="btn btn-success mx-3">Add</button>
						<a href="${pageContext.request.contextPath}/home"
							class="btn btn-danger">Cancel</a>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>




