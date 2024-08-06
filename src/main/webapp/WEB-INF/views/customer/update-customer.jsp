<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row w-100 d-flex justify-content-center">
	<div class="col-sm-12 col-md-6 bg-custom p-3 rounded">
		<div class="col-12 text-uppercase h2 text-center text-success ">Cập
			nhật khách hàng</div>
		<div class="p-4">
			<form:form
				action="${pageContext.request.contextPath}/customer/update"
				method="post" modelAttribute="customer" id="inputForm">
				<div class="form-group row">
					<form:label path="id" for="inputID" class="col-sm-3 col-form-label">Mã khách hàng</form:label>
					<div class="col">
						<form:input path="id" type="text" class="form-control"
							id="inputID" placeholder="Mã khách hàng (KHxxxxx)"
							autocomplete="off" readonly="true" />
						<form:errors path="id" />
						<div class="error text-danger" id="errorID"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="name" for="inputName"
						class="col-sm-3 col-form-label">Tên khách hàng</form:label>
					<div class="col">
						<form:input path="name" type="text" class="form-control"
							id="inputName" placeholder="Tên khách hàng" autocomplete="off" />
						<form:errors path="name" />
						<div class="error text-danger" id="errorName"></div>

					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="address" for="inputStatus"
						class="col-sm-3 col-form-label">Địa chỉ</form:label>
					<div class="col">
						<form:input path="address" type="text" class="form-control"
							id="inputAddress" placeholder="Địa chỉ" autocomplete="off" />
						<form:errors path="address" />
						<div class="error text-danger" id="errorAddress"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="phone" for="inputPhone"
						class="col-sm-3 col-form-label">Số điện thoại</form:label>
					<div class="col">
						<form:input path="phone" type="text" class="form-control"
							id="inputPhone" placeholder="Số điện thoại" autocomplete="off" />
						<form:errors path="phone" />
						<div class="error text-danger" id="errorPhone"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="email" for="inputEmail"
						class="col-sm-3 col-form-label">Địa chỉ email</form:label>
					<div class="col">
						<form:input path="email" type="text" class="form-control"
							id="inputEmail" placeholder="Địa chỉ email" autocomplete="off" />
						<form:errors path="email" />
						<div class="error text-danger" id="errorEmail"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<div class="col"></div>
					<div class="col-sm-12 col-md-6 mr-2 d-flex justify-content-end">
						<button type="reset" class="btn btn-success">Reset</button>
						<button type="submit" class="btn btn-success mx-3">Update</button>
						<a href="${pageContext.request.contextPath}/home"
							class="btn btn-danger">Cancel</a>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>



