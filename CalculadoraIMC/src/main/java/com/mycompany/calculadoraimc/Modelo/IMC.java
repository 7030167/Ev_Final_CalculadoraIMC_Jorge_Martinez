/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoraimc.Modelo;

/**
 *
 * @author guindous
 */
public class IMC {
    private String nombreUsuario;
    private double masaCorporal;
    private double imc;

    public IMC(String nombreUsuario, double masaCorporal) {
        this.nombreUsuario = nombreUsuario;
        this.masaCorporal = masaCorporal;
        this.imc = calcularIMC();
    }

    private double calcularIMC() {
        return this.masaCorporal / Math.pow(UsuarioDAO.obtenerEstatura(nombreUsuario), 2);
    }

    // Getters y Setters
}
