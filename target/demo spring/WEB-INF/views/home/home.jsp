<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<jsp:include page="../base/head.jsp" />
    <body>
        <div class="d-flex" id="wrapper">
<!--             Sidebar -->
  			<jsp:include page="../base/menu.jsp" />
<!--             Page content wrapper -->
            <div id="page-content-wrapper">
<!--                 Top navigation -->
                <jsp:include page="../base/header.jsp" />
<!--                  Page content -->
                <div class="container-fluid">
					<div class="text-center mt-3 text-uppercase">
		Vui lòng chọn chức năng
               		 </div>
                </div>
                	<jsp:include page="../base/footer.jsp" />
            </div>
            
        </div>
	
<%-- 		<jsp:include page="./base/script.jsp" /> --%>
    </body>
</html>



