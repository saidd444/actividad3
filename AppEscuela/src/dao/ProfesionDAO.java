/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import modelo.Profesion;
import java.sql.*;
import java.util.*;
/**
 *
 * @author ibane
 */
public class ProfesionDAO {
    public void crear(Profesion p) throws SQLException {
        String sql = "INSERT INTO profesion (profesion) VALUES (?)";
        try (Connection cn = Conexion.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, p.getProfesion());
            ps.executeUpdate();
        }
    }

    public List<Profesion> listar() throws SQLException {
        String sql = "SELECT id_profesion, profesion FROM profesion ORDER BY profesion";
        List<Profesion> out = new ArrayList<>();
        try (Connection cn = Conexion.getConnection(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) out.add(new Profesion(rs.getInt(1), rs.getString(2)));
        }
        return out;
    }

    public void actualizar(Profesion p) throws SQLException {
        String sql = "UPDATE profesion SET profesion=? WHERE id_profesion=?";
        try (Connection cn = Conexion.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, p.getProfesion());
            ps.setInt(2, p.getIdProfesion());
            ps.executeUpdate();
        }
    }

    public void borrar(int idProfesion) throws SQLException {
        String sql = "DELETE FROM profesion WHERE id_profesion=?";
        try (Connection cn = Conexion.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idProfesion);
            ps.executeUpdate();
        }
    }
}