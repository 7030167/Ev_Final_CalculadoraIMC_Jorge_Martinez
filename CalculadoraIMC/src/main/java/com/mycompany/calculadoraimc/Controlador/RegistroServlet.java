/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.calculadoraimc.Controlador;

import com.mycompany.calculadoraimc.ConexionBD;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author guindous
 */

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String nombreCompleto = request.getParameter("nombreCompleto");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        double estatura = Double.parseDouble(request.getParameter("estatura"));
        String nombreUsuario = request.getParameter("nombreUsuario");
        String contrasena = request.getParameter("contrasena");

        // Validar los datos (por ejemplo, edad mínima)
        if (edad < 15) {
            request.setAttribute("error", "La edad debe ser mayor o igual a 15 años.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }

        // Intentar registrar al usuario en la base de datos
        try (Connection conn = ConexionBD.obtenerConexion()) {
            // SQL para insertar el nuevo usuario
            String sql = "INSERT INTO usuarios (nombre_completo, edad, sexo, estatura, nombre_usuario, contrasena) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                // Asignar los valores a la sentencia SQL
                stmt.setString(1, nombreCompleto);
                stmt.setInt(2, edad);
                stmt.setString(3, sexo);
                stmt.setDouble(4, estatura);
                stmt.setString(5, nombreUsuario);
                
                // Ejecutar la consulta
                int filasInsertadas = stmt.executeUpdate();

                // Si el usuario fue insertado correctamente, redirigir a login
                if (filasInsertadas > 0) {
                    response.sendRedirect("login.jsp");  // Redirige a la página de login
                } else {
                    // Si no se insertó correctamente, mostrar mensaje de error
                    request.setAttribute("error", "Hubo un problema al registrar el usuario.");
                    request.getRequestDispatcher("registro.jsp").forward(request, response);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Si ocurre un error en la base de datos, mostrar mensaje
            request.setAttribute("error", "Error al conectar con la base de datos.");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
}

