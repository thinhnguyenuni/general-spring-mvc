<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <div class="border-end bg-white" id="sidebar-wrapper">
        <div class="list-group list-group-flush vh-100 bg-primary">
            <a class="list-group-item list-group-item-action list-group-item-light p-3 bg-primary text-white" href="${pageContext.request.contextPath}/computer/create">Tạo mới máy</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3 bg-primary text-white" href="${pageContext.request.contextPath}/customer/create">Tạo mới
                khách hàng</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3 bg-primary text-white" href="${pageContext.request.contextPath}/service/create">Tạo mới dịch
                vụ</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3 bg-primary text-white" href="${pageContext.request.contextPath}/computer/list">Danh
                sách máy</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3 bg-primary text-white" href="${pageContext.request.contextPath}/customer/list">Danh
                sách khách hàng</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3 bg-primary text-white" href="${pageContext.request.contextPath}/service/list">Danh
                sách dịch vụ</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3 bg-primary text-white" href="${pageContext.request.contextPath}/usingcomputer/register">Đăng ký
                sử dụng máy</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3 bg-primary text-white" href="${pageContext.request.contextPath}/usingservice/register">Đăng ký
                sử dụng dịch vụ</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3 bg-primary text-white" href="${pageContext.request.contextPath}/suminfo/list">Thông tin
                khách hàng đang sử dụng dịch vụ</a>
        </div>
    </div>






