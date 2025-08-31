/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
/**
 *
 * @author ibane
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/escuela?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "Maybelline-1";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}