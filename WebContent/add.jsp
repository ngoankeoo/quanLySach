<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add.css">

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>
	<div id="container">
		<h3>Add sinh vien</h3>
		<form action="sinhvienControllerServlet" method="GET">
			<input type="hidden" name="command" value="ADD" />
			<table>
				<tbody>
				
				
					<tr>
						<td><label>masv:</label></td>
						<td><input type="text" name="masv" /></td>
					</tr>

					<tr>
						<td><label>hoten:</label></td>
						<td><input type="text" name="hoten" /></td>
					</tr>

					<tr>
						<td><label>tenkhoa:</label></td>
						<td><input type="text" name="tenkhoa" /></td>
					</tr>
					<tr>
						<td><label>gioitinh:</label></td>
						<td><input type="text" name="gioitinh" /></td>
					</tr>
					<tr>
						<td><label>diemtin:</label></td>
						<td><input type="text" name="diemtin" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form>
		<div style="clear: both;"></div>
		<p>
			<a href="sinhvienControllerServlet">Back to List</a>
		</p>
	</div>

</body>
</html>