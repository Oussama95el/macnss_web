<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 07/12/2022
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agent Dashboard</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
    <jsp:include page="../../components/dashboardNav.jsp" flush="true"/>

    <div class="flex flex-col items-center justify-center h-screen">
        <div class="flex flex-col items-center justify-center w-1/2 h-1/2">
            <h1 class="text-4xl font-bold">Agent Dashboard</h1>
            <div class="flex flex-col items-center justify-center w-1/2 h-1/2">
                <a href="agentDashboard.jsp" class="text-2xl font-bold">View All Tickets</a>
                <a href="agentDashboard.jsp" class="text-2xl font-bold">View All Tickets</a>
                <a href="agentDashboard.jsp" class="text-2xl font-bold">View All Tickets</a>
            </div>
        </div>
    </div>


</body>
</html>
