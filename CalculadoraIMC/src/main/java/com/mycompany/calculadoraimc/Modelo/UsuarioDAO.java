/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoraimc.Modelo;

/**
 *
 * @author guindous
 */

import java.sql.*;

public class UsuarioDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/calculadora_imc";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "1234";

    public static boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombreCompleto, edad, sexo, estatura, nombreUsuario, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getNombreCompleto());
            stmt.setInt(2, usuario.getEdad());
            stmt.setString(3, usuario.getSexo());
            stmt.setDouble(4, usuario.getEstatura());
            stmt.setString(5, usuario.getNombreUsuario());
            stmt.setString(6, usuario.getContrasena());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean autenticar(String usuario, String contrasena) {
        String sql = "SELECT * FROM usuarios WHERE nombreUsuario = ? AND contrasena = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();
            
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static double obtenerEstatura(String nombreUsuario) {
        String sql = "SELECT estatura FROM usuarios WHERE nombreUsuario = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nombreUsuario);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getDouble("estatura");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

