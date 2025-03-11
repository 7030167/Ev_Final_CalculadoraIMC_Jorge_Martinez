/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.calculadoraimc.Controlador;
import com.mycompany.calculadoraimc.Modelo.IMC;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
/**
 *
 * @author guindous
 */

/**
 * Servlet para manejar el cálculo del IMC y mostrar el historial.
 */
@WebServlet("/IMCServlet")
public class IMCServlet extends HttpServlet {

    // Maneja las solicitudes GET redirigiendo a la página principal del cálculo de IMC.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("imc.jsp");
    }

    // Maneja las solicitudes POST para el cálculo del IMC.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtiene los parámetros del formulario
        String usuario = (String) request.getSession().getAttribute("nombreUsuario");
        String masa = request.getParameter("masa");

        if (usuario == null || masa == null || masa.isEmpty()) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            // Llama al servicio REST para calcular el IMC
            Client client = ClientBuilder.newClient();
            Response restResponse = client
                .target("http://localhost:8080/CalculadoraIMC/api/imc/calcular")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity("usuario=" + usuario + "&masa=" + masa, MediaType.APPLICATION_FORM_URLENCODED));

            if (restResponse.getStatus() == 200) {
                // Convierte la respuesta JSON a un objeto IMC
                IMC imc = restResponse.readEntity(IMC.class);

                // Guarda el IMC calculado y redirige al JSP
                request.setAttribute("imc", imc);
                request.getRequestDispatcher("calcularIMC.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Error al calcular el IMC.");
                request.getRequestDispatcher("calcularIMC.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "No se pudo conectar con el servicio IMC.");
            request.getRequestDispatcher("calcularIMC.jsp").forward(request, response);
        }
    }
}


