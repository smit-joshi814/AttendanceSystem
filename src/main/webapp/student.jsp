<%@page import="com.attendance.system.model.Student"%>
<%@page import="com.attendance.system.model.Batch"%>
<%@page import="com.attendance.system.model.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.attendance.system.model.StudentWrapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>eAttendance | Manage Students</title>

<jsp:include page="components/head-imports.jsp"></jsp:include>

</head>

<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- SideBar -->
		<jsp:include page="components/sidebar.jsp"></jsp:include>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<!-- Topbar -->
				<jsp:include page="components/topbar.jsp"></jsp:include>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Outer Row -->

					<%
					StudentWrapper studentWrapper = (StudentWrapper) request.getAttribute("studentWrapper");
					%>
					<!-- Nested Row within Card Body -->
					<div class="row">
						<!-- Page Heading -->
						<h1 class="h3 mb-4 text-gray-800">Add Student</h1>
						<div class="col-md-6">
							<div class="p-5">
								<form class="user" id="addStudent">
									<div class="form-group">
										<input type="text" class="form-control form-control-user"
											id="studentEnrollment" name="studentEnrollment"
											placeholder="Enter Enrollment Id" required />
									</div>
									<div class="form-group">
										<input type="text" class="form-control form-control-user"
											id="studentName" name="studentName"
											placeholder="Enter Student Name" required />
									</div>
									<div class="form-group">
										<input type="text" class="form-control form-control-user"
											id="studentEmail" name="studentEmail"
											placeholder="Enter Student Email" required />
									</div>
									<div class="form-group">
										<input type="text" class="form-control form-control-user"
											id="studentDivision" name="studentDivision"
											placeholder="Enter Student Division" required />
									</div>
									<div class="form-group">
										<input type="text" class="form-control form-control-user"
											id="studentPassword" name="studentPassword"
											placeholder="Enter Student Password" required />
									</div>
									<div class="form-group">
										<select name="studentCourse" id="studentCourse"
											class="form-control custom-select" required>
											<option value>Select Course</option>
											<%
											List<Course> courses = studentWrapper.getCourses();
											for (Course course : courses) {
											%>
											<option value="<%=course.getCourseId()%>"><%=course.getCourseName()%></option>
											<%
											}
											%>
										</select>
									</div>
									<div class="form-group">
										<select name="studentBatch" id="studentBatch"
											class="form-control custom-select" required>
											<option value>Select Batch</option>
											<%
											List<Batch> batchs = studentWrapper.getBatchs();
											for (Batch batch : batchs) {
											%>
											<option value="<%=batch.getId()%>"><%=batch.getBatchName()%></option>
											<%
											}
											%>
										</select>
									</div>
									<div class="mt-2 mb-2" id="studentResponse"></div>
									<button type="submit"
										class="btn btn-primary btn-user btn-block">Add
										Student</button>
								</form>
							</div>
						</div>
					</div>
					<hr />
					<div class="row">
						<h1 class="h3 mb-4 text-gray-800">Available Students</h1>
						<div class="col-md-12">
							<div class="p-5">
								<div class="table-responsive">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<thead>
											<tr>
												<th>Student Id</th>
												<th>Student Enrollment</th>
												<th>Student Name</th>
												<th>Student Email</th>
												<th>Student Division</th>
												<th>Student Course</th>
												<th>Student Batch</th>
												<th>Edit</th>
												<th>Delete</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th>Student Id</th>
												<th>Student Enrollment</th>
												<th>Student Name</th>
												<th>Student Email</th>
												<th>Student Division</th>
												<th>Student Course</th>
												<th>Student Batch</th>
												<th>Edit</th>
												<th>Delete</th>
											</tr>
										</tfoot>
										<tbody>
											<%
											List<Student> students = studentWrapper.getStudents();
											for (Student student : students) {
											%>
											<tr>
												<td><%=student.getStudentId()%></td>
												<td><%=student.getStudentEnrollment()%></td>
												<td><%=student.getStudentName()%></td>
												<td><%=student.getStudentEmail()%></td>
												<td><%=student.getStudentDivision()%></td>
												<td><%=student.getStudentCourse().getCourseName()%></td>
												<td><%=student.getStudentBatch().getBatchName()%></td>
												<td><button type="button"
														class="btn btn-warning updStudent"
														data-sid="<%=student.getStudentId()%>" data-toggle="modal"
														data-target="#editStudent">
														<i class="fas fa-edit"></i>
													</button></td>
												<td><button type="button"
														class="btn btn-danger updStudent"
														data-sid="<%=student.getStudentId()%>">
														<i class="fas fa-trash"></i>
													</button></td>
											</tr>
											<%
											}
											%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<jsp:include page="components/footer.jsp"></jsp:include>
			<!-- End of Footer -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<jsp:include page="components/models.jsp"></jsp:include>

	<jsp:include page="components/js-imports.jsp"></jsp:include>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#side-students").addClass("active")
		});
	</script>
</body>
</html>
