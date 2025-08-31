/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import modelo.Docente;
import java.sql.*;
import java.math.BigDecimal;
/**
 *
 * @author ibane
 */
public class DocenteDAO {
    private final PersonaDAO personaDAO = new PersonaDAO();

    public int crear(Docente d) throws SQLException {
        int idPersona = personaDAO.crear(d);
        String sql = "INSERT INTO docente(id_persona,codigo,salario,id_profesion) VALUES (?,?,?,?)";
        try (Connection cn = Conexion.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idPersona);
            ps.setString(2, d.getCodigo());
            ps.setBigDecimal(3, d.getSalario()==null? new BigDecimal("0"): d.getSalario());
            if (d.getIdProfesion()==null) ps.setNull(4, Types.INTEGER); else ps.setInt(4, d.getIdProfesion());
            ps.executeUpdate();
        }
        return idPersona;
    }
}