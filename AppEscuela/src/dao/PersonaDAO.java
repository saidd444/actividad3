/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import modelo.Persona;
import java.sql.*;
/**
 *
 * @author ibane
 */
public class PersonaDAO {
    public int crear(Persona p) throws SQLException {
        String sql = "INSERT INTO persona(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento,genero) VALUES (?,?,?,?,?,?,?)";
        try (Connection cn = Conexion.getConnection(); PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNit());
            ps.setString(2, p.getNombres());
            ps.setString(3, p.getApellidos());
            ps.setString(4, p.getDireccion());
            ps.setString(5, p.getTelefono());
            ps.setDate(6, p.getFechaNacimiento()==null? null : Date.valueOf(p.getFechaNacimiento()));
            if (p.getGenero()==null) ps.setNull(7, Types.TINYINT); else ps.setBoolean(7, p.getGenero());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) { if (keys.next()) return keys.getInt(1); }
        }
        return -1;
    }
}