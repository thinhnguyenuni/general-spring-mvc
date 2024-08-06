<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row w-100 d-flex justify-content-center">
	<div class="col-sm-12 col-md-6 bg-custom p-3 rounded">
		<div class="col-12 text-uppercase h2 text-center text-success ">Tạo
			mới dịch vụ</div>
		<div class="p-4">
			<form:form id="inputForm"
				action="${pageContext.request.contextPath}/service/create"
				method="post" modelAttribute="service">
				<div class="form-group row">
					<form:label path="id" for="inputID" class="col-sm-3 col-form-label">Mã dịch vụ</form:label>
					<div class="col">
						<form:input path="id" type="text" class="form-control"
							id="inputID" placeholder="Mã dịch vụ (DVxxx)" autocomplete="off" />
						<form:errors path="id" />
						<div class="error text-danger" id="errorID"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="name" for="inputName"
						class="col-sm-3 col-form-label">Tên dịch vụ</form:label>
					<div class="col">
						<form:input path="name" type="text" class="form-control"
							id="inputName" placeholder="Tên dịch vụ" autocomplete="off" />
						<form:errors path="name" />
						<div class="error text-danger" id="errorName"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="unit" for="inputUnit"
						class="col-sm-3 col-form-label">Đơn vị tính</form:label>
					<div class="col">
						<form:input path="unit" type="text" class="form-control"
							id="inputUnit" placeholder="Đơn vị tính" autocomplete="off" />
						<form:errors path="unit" />
						<div class="error text-danger" id="errorUnit"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="price" for="inputPrice"
						class="col-sm-3 col-form-label">Đơn giá</form:label>
					<div class="col">
						<form:input path="price" type="text" class="form-control"
							id="inputPrice" placeholder="Đơn giá" autocomplete="off" />
						<form:errors path="price" />
						<div class="error text-danger" id="errorPrice"></div>
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



