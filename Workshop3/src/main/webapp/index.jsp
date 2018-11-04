<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<%@ include file="header.jsp"%>
<br/>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Acceptace</th>
            <th>Employee Id</th>
            <th>Vehicle Id</th>
            <th>Details of problem</th>
            <th>Details of repair</th>
            <th>Status</th>
            <th>Repair Cost</th>
            <th>Hours</th>
        </tr>
      <c:forEach items="${orders}" var="order" >
          <tr>
              <td>${order.id}</td>
              <td>${order.acceptanceForRepair}</td>
              <td>${order.employeeId}</td>
              <td>${order.vehicleId}</td>
              <td>${order.detailsOfProblem}</td>
              <td>${order.detailsOfRepair}</td>
              <td>${order.status}</td>
              <td>${order.repairCost}</td>
              <td>${order.numberOfHours}</td>
          </tr>
      </c:forEach>
    </table>
<br/>
<%@ include file="footer.jsp"%>
</body>
</html>
