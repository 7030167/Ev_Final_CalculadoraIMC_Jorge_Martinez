<%-- 
    Document   : registro
    Created on : 8 mar 2025, 7:25:36 p.m.
    Author     : guindous
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registro de Usuario</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Registro de Usuario</h2>
        <form action="RegistroServlet" method="post">
            <div class="mb-3">
                <label>Nombre Completo</label>
                <input type="text" name="nombreCompleto" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Edad</label>
                <input type="number" name="edad" class="form-control" min="15" required>
            </div>
            <div class="mb-3">
                <label>Sexo</label>
                <select name="sexo" class="form-control" required>
                    <option value="">Seleccione</option>
                    <option value="Masculino">Masculino</option>
                    <option value="Femenino">Femenino</option>
                </select>
            </div>
            <div class="mb-3">
                <label>Estatura (m)</label>
                <input type="number" name="estatura" step="0.01" class="form-control" min="1" max="2.5" required>
            </div>
            <div class="mb-3">
                <label>Nombre de Usuario</label>
                <input type="text" name="nombreUsuario" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Contraseña</label>
                <input type="password" name="contrasena" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Registrarse</button>
            <a href="index.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
