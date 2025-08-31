/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import modelo.Estudiante;
import java.sql.*;

/**
 *
 * @author ibane
 */
public class EstudianteDAO {
    private final PersonaDAO personaDAO = new PersonaDAO();

    public int crear(Estudiante e) throws SQLException {
        int idPersona = personaDAO.crear(e);
        String sql = "INSERT INTO estudiante(id_persona,carnet) VALUES (?,?)";
        try (Connection cn = Conexion.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idPersona);
            ps.setString(2, e.getCarnet());
            ps.executeUpdate();
        }
        return idPersona;
    }
}