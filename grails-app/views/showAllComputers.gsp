<%--
  Created by IntelliJ IDEA.
  User: Damia
  Date: 11.10.2022
  Time: 20:24
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<html>
<head>
    <title></title>
</head>

<body>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Nazwa</th>
            <th scope="col">Data ksiegowania</th>
            <th scope="col">Koszt USD</th>
            <th scope="col">Koszt PLN</th>
        </tr>
        </thead>
        <tbody>
            <g:each in="${computerList}" var="computer">
                <tr>
                    <td>${computer.nazwa}</td>
                    <td>${computer.data_ksiegowania}</td>
                    <td>${computer.koszt_USD}</td>
                    <td>${computer.koszt_PLN}</td>
                </tr>
            </g:each>
        </tbody>
    </table>
</body>
</html>