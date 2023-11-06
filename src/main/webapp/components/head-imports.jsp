<%@page import="com.attendance.system.model.Faculty"%>
<%@page import="com.attendance.system.model.Admin"%>
<%
Admin admin = (Admin) session.getAttribute("admin");
Faculty faculty = (Faculty) session.getAttribute("faculty");
String loginType = "";
if (admin != null) {
	loginType = "Admin";
}
if (faculty != null) {
	loginType = "Faculty";
}
if (loginType == "") {
	response.sendRedirect("login");
}
%>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />


<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet" />

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet" />

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet" />