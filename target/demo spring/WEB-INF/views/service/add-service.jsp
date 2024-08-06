<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <div class="row w-100 d-flex justify-content-center">
 <div class ="col-sm-12 col-md-6 bg-custom p-3 rounded">
 <div class="col-12 text-uppercase h2 text-center text-success ">Tạo mới dịch vụ</div>
          <div class="p-4">
              <form:form action="${pageContext.request.contextPath}/service/create" method="post" modelAttribute="service">
                  <div class="form-group row">
                      <label for="inputID" class="col-sm-3 col-form-label">Mã dịch vụ</label>
                      <div class="col">
                          <form:input path="id" type="text" class="form-control" id="inputID" placeholder="Mã dịch vụ (DVxxx)"/>
                           <div class="error text-danger"></div>
                      </div>
                  </div>
                  <div class="form-group row mt-3">
                      <label for="inputName" class="col-sm-3 col-form-label">Tên dịch vụ</label>
                      <div class="col">
                          <form:input path="name" type="text" class="form-control" id="inputName" placeholder="Tên dịch vụ"/>
                           <div class="error text-danger"></div>
                      </div>
                  </div>
                  <div class="form-group row mt-3">
                      <label for="inputUnit" class="col-sm-3 col-form-label">Đơn vị tính</label>
                      <div class="col">
                          <form:input path="unit" type="text" class="form-control" id="inputUnit" placeholder="Đơn vị tính"/>
                           <div class="error text-danger"></div>
                      </div>
                  </div>
                   <div class="form-group row mt-3">
                      <label for="inputPrice" class="col-sm-3 col-form-label">Đơn giá</label>
                      <div class="col">
                          <form:input path="price" type="text" class="form-control" id="inputPrice" placeholder="Đơn giá"/>
                           <div class="error text-danger"></div>
                      </div>
                  </div>
                  <div class="form-group row mt-3">
                      <div class="col"></div>
                      <div class="col-sm-12 col-md-6 mr-2 d-flex justify-content-end">
                          <button type="reset" class="btn btn-success">Reset</button>
                           <button type="submit" class="btn btn-success mx-3">Add</button>
                           <a href ="${pageContext.request.contextPath}/home" class="btn btn-danger">Cancel</a>
                      </div>
                  </div>

              </form:form>
          </div>
          </div>
      </div>
       


  