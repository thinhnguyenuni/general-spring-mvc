<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <div class="row w-100 d-flex justify-content-center">
 <div class ="col-sm-12 col-md-6 bg-custom p-3 rounded">
 <div class="col-12 text-uppercase h2 text-center text-success ">Đăng ký sử dụng dịch vụ</div>
          <div class="p-4">
              <form:form action="${pageContext.request.contextPath}/usingservice/register" method="post" modelAttribute="usingservice">
              <div class="form-group row mt-3">
               <label for="inputCustomer" class="col-sm-3 col-form-label">Tên khách hàng</label>
               <div class="col">
                     <form:select id="inputCustomer" class="form-control select2" path="usingServicePK.customer.id">
						 <c:choose>
        <c:when test="${empty customers}">
            <form:option value="">No data found</form:option>
        </c:when>
        <c:otherwise>
            <form:options items="${customers}" itemValue="id" itemLabel="name"/>
        </c:otherwise>
    </c:choose>
					</form:select>
					</div>
                  </div>
                 <div class="form-group row mt-3">
               <label for="inputService" class="col-sm-3 col-form-label">Tên dịch vụ</label>
               <div class="col">
                     <form:select id="inputService" class="form-control select2" path="usingServicePK.service.id">
    <c:choose>
        <c:when test="${empty services}">
            <form:option value="">No data found</form:option>
        </c:when>
        <c:otherwise>
            <form:options items="${services}" itemValue="id" itemLabel="name"/>
        </c:otherwise>
    </c:choose>
</form:select>
					</div>
                  </div>
                  <div class="form-group row mt-3">
                      <label for="inputDate" class="col-sm-3 col-form-label">Ngày bắt đầu</label>
                      <div class="col">
                          <form:input path="usingServicePK.date" type="date" class="form-control" id="inputDate" placeholder="Ngày bắt đầu" autocomplete="off"/>
                          <div class="error text-danger"></div>
                      </div>
                  </div>
                  <div class="form-group row mt-3">
                      <label for="inputHour" class="col-sm-3 col-form-label">Giờ bắt đầu</label>
                      <div class="col">
                          <form:input path="usingServicePK.time" type="time" class="form-control" id="inputHour" placeholder="Giờ bắt đầu" autocomplete="off"/>
                           <div class="error text-danger"></div>
                      </div>
                  </div>
                    <div class="form-group row mt-3">
                      <label for="inputQuantity" class="col-sm-3 col-form-label">Số lượng</label>
                      <div class="col">
                          <form:input path="quantity" type="number" class="form-control" id="inputQuantity" placeholder="Số lượng" autocomplete="off"/>
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
   
       


  