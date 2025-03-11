<%-- 
    Document   : login
    Created on : 8 mar 2025, 7:26:38 p.m.
    Author     : guindous
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Iniciar Sesión</h2>
        
        <!-- Mensaje de error -->
        <% 
            String error = request.getParameter("error");
            if (error != null && error.equals("1")) {
        %>
            <div class="alert alert-danger" role="alert">
                ¡Error! Las credenciales no son válidas.
            </div>
        <% } %>

        <form action="LoginServlet" method="post">
            <div class="mb-3">
                <label>Nombre de Usuario</label>
                <input type="text" name="nombreUsuario" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Contraseña</label>
                <input type="password" name="contrasena" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-success">Iniciar Sesión</button>
            <a href="index.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
