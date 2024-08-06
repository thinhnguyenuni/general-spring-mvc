<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
      <div class="container-fluid">
          <button class="btn btn-success" id="sidebarToggle">Menu</button>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
<!--                   <li class="nav-item active"><a class="nav-link" href="#!">Home</a></li> -->
<!--                   <li class="nav-item"><a class="nav-link" href="#!">Link</a></li> -->
                  
                  <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" id="navbarNew" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Tạo mới</a>
                      <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                          <a class="dropdown-item" href="${pageContext.request.contextPath}/computer/create">Tạo mới máy</a>
                          <a class="dropdown-item" href="${pageContext.request.contextPath}/customer/create">Tạo mới khách hàng</a>
<!--                           <div class="dropdown-divider"></div> -->
                          <a class="dropdown-item" href="${pageContext.request.contextPath}/service/create">Tạo mới dịch vụ</a>
                      </div>
                  </li>
                  <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" id="navbarList" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Danh sách</a>
                      <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                          <a class="dropdown-item" href="${pageContext.request.contextPath}/computer/list">Danh sách máy</a>
                          <a class="dropdown-item" href="${pageContext.request.contextPath}/customer/list">Danh sách khách hàng</a>
                          <a class="dropdown-item" href="${pageContext.request.contextPath}/service/list">Danh sách dịch vụ</a>
                      </div>
                  </li>
                  <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" id="navbarRegister" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Đăng ký</a>
                      <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                          <a class="dropdown-item" href="${pageContext.request.contextPath}/usingcomputer/register">Đăng ký sử dụng máy</a>
                          <a class="dropdown-item" href="${pageContext.request.contextPath}/usingservice/register">Đăng ký sử dụng dịch vụ</a>
                      </div>
                  </li>
                   <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/usingservice/list">Dịch vụ đang sử dụng</a></li>
              </ul>
          </div>
      </div>
  </nav>
               