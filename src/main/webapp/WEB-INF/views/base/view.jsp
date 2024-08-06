<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="./head.jsp" />
<body>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<jsp:include page="./menu.jsp" />
		<!-- Page content wrapper-->
		<div id="page-content-wrapper">
			<!-- Top navigation-->
			<jsp:include page="./header.jsp" />
			<!-- Page content-->
			<div class="container-fluid mt-4 mb-3">
				<jsp:include page="../${urlPage}.jsp" />
			</div>
			<jsp:include page="./footer.jsp" />
		</div>
	</div>

	<jsp:include page="./script.jsp" />
	<c:if test="${not empty jqPage}">
		<script
			src="${pageContext.request.contextPath}/resources/jquery/${jqPage}.js" /></script>
	</c:if>
</body>
</html>


