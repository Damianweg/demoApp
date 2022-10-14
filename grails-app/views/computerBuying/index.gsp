<%--
  Created by IntelliJ IDEA.
  User: Damia
  Date: 11.10.2022
  Time: 20:49
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<table>
    Lista
    <g:each in="${computerList}" var="computer">
        <tr>
            <td>${computer.nazwa}</td>
            <td>${computer.data_ksiegowania}</td>
        </tr>
    </g:each>
</table>
</body>
</html>