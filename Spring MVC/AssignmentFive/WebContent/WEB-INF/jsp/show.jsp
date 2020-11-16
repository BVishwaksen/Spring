<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	

	<table>
		<tr>
			<th>Student Id</th>
			<th>Name</th>
			<th>Branch</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${students}" var="item">
			<tr>
				<td>${item.getId() }</td>
				<td>${item.getName() }</td>
				<td>${item.getBranch() }</td>
				<td>${item.getAddress() }</td>
			</tr>
		</c:forEach>
	</table><br>
	<hr>
	<a href="read">Perform CRUD Operations</a><br><br>