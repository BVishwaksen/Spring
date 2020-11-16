<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<table>
<tr>
<th>Policy Number</th>
<th>Name</th>
<th>Tenure</th>
<th>Amount</th>
</tr>

	<c:forEach items="${policies}" var="item">
	<tr>
	<td>${item.getPolicyNumber() }</td>
	<td>${item.getName() }</td>
	<td>${item.getTensure() }</td>
	<td>${item.getAmount() }</td>
    	</tr>
	</c:forEach>
	</table>
