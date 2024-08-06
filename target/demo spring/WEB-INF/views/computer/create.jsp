<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <div class="row w-100 d-flex justify-content-center">
 <div class ="col-sm-12 col-md-6 bg-custom p-3 rounded">
 <div class="col-12 text-uppercase h2 text-center text-success ">Tạo mới máy</div>
          <div class="p-4">
              <form:form action="${pageContext.request.contextPath}/computer/create" method="post" modelAttribute="computer">
                  <div class="form-group row">
                      <label for="inputID" class="col-sm-2 col-form-label">Mã máy</label>
                      <div class="col-sm-10">
                          <form:input path="id" type="text" class="form-control" id="inputID" placeholder="Mã máy (MMxxx)"/>
                      </div>
                  </div>
                  <div class="form-group row mt-3">
                      <label for="inputLocation" class="col-sm-2 col-form-label">Vị trí</label>
                      <div class="col-sm-10">
                          <form:input path="location" type="text" class="form-control" id="inputLocation" placeholder="Vị trí"/>
                      </div>
                  </div>
                  <div class="form-group row mt-3">
                      <label for="inputStatus" class="col-sm-2 col-form-label">Trạng thái</label>
                      <div class="col-sm-10">
                          <form:input path="status" type="text" class="form-control" id="inputStatus" placeholder="Trạng thái"/>
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
       

<jsp:include page="../base/script.jsp" />
  