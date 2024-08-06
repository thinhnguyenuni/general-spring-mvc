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
		<table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Start date</th>
                <th>Salary</th>
            </tr>
        </tfoot>
    </table>
                </div>
                	<jsp:include page="../base/footer.jsp" />
            </div>
            
        </div>
	<script>
// $('#example').DataTable({
//     ajax: 'https://datatables.net/examples/server_side/scripts/objects.php',
//     columns: [
//         { data: 'first_name' },
//         { data: 'last_name' },
//         { data: 'position' },
//         { data: 'office' },
//         { data: 'start_date' },
//         { data: 'salary' }
//     ],
//     processing: true,
//     serverSide: true
// });

$(document).ready(function () {
    $('#listDv').dataTable({
        "dom": 'lrtip',
        "lengthChange": false,
        "pageLength": 3
    });
});
</script>
    </body>
</html>