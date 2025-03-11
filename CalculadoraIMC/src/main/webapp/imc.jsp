<%-- 
    Document   : imc
    Created on : 8 mar 2025, 7:27:25 p.m.
    Author     : guindous
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calcular IMC</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Calcular IMC</h2>
        <form action="IMCServlet" method="post">
            <div class="mb-3">
                <label>Masa Corporal (kg)</label>
                <input type="number" name="masa" step="0.1" min="0.1" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Calcular IMC</button>
            <a href="index.jsp" class="btn btn-secondary">Cerrar Sesión</a>
        </form>

        <h3 class="mt-5">Historial de Cálculos IMC</h3>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Fecha</th>
                    <th>Masa Corporal (kg)</th>
                    <th>IMC</th>
                </tr>
            </thead>
            <tbody>
                <!-- Aquí se cargarán los datos del historial desde el servicio REST -->
                <c:forEach var="registro" items="${historial}">
                    <tr>
                        <td>${registro.fecha}</td>
                        <td>${registro.masaCorporal}</td>
                        <td>${registro.imc}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>

