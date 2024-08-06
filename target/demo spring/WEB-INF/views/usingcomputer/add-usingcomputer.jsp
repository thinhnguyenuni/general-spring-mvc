<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <div class="row w-100 d-flex justify-content-center">
 <div class ="col-sm-12 col-md-6 bg-custom p-3 rounded">
 <div class="col-12 text-uppercase h2 text-center text-success ">Đăng ký sử dụng máy</div>
          <div class="p-4">
              <form:form action="${pageContext.request.contextPath}/usingcomputer/register" method="post" modelAttribute="usingcomputer">
              <div class="form-group row mt-3">
               <label for="inputCustomer" class="col-sm-3 col-form-label">Tên khách hàng</label>
               <div class="col">
                     <form:select class="form-control select2" path="usingComputerPK.customer.id">
						<form:options items="${customers}" itemValue="id" itemLabel="name"/>
					</form:select>
					</div>
                  </div>
                 <div class="form-group row mt-3">
               <label for="inputComputer" class="col-sm-3 col-form-label">Mã máy tính</label>
               <div class="col">
                     <form:select class="form-control select2" path="usingComputerPK.computer.id">
						<form:options items="${computers}" itemValue="id" itemLabel="id"/>
					</form:select>
					</div>
                  </div>
                  <div class="form-group row mt-3">
                      <label for="inputDate" class="col-sm-3 col-form-label" >Ngày bắt đầu</label>
                      <div class="col">
                          <form:input path="usingComputerPK.date" type="date" class="form-control" id="inputDate" placeholder="Ngày bắt đầu sử dụng" autocomplete="off"/>
                          <div class="error text-danger"></div>
                      </div>
                  </div>
                  <div class="form-group row mt-3">
                      <label for="inputHour" class="col-sm-3 col-form-label">Giờ bắt đầu</label>
                      <div class="col">
                          <form:input path="usingComputerPK.time" type="time" class="form-control" id="inputHour" placeholder="Giờ bắt đầu sử dụng" autocomplete="off"/>
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
<!--        <script src="../resources/jquery/jquery-3.7.1.min.js"></script> -->
   
       


  