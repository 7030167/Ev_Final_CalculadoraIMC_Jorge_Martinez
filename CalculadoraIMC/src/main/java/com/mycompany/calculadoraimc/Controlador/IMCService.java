/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoraimc.Controlador;

/**
 *
 * @author guindous
 */

import com.mycompany.calculadoraimc.Modelo.IMC;
import com.mycompany.calculadoraimc.Modelo.UsuarioDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/imc")
public class IMCService {

    @POST
    @Path("/calcular")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public IMC calcularIMC(@FormParam("usuario") String usuario, 
                           @FormParam("masa") double masa) {
        if (masa <= 0) {
            throw new WebApplicationException("Masa corporal no válida.", 400);
        }
        return new IMC(usuario, masa);
    }
}
