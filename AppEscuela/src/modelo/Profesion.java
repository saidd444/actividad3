/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ibane
 */
public class Profesion {
private Integer idProfesion;
private String profesion;


public Profesion() {}
public Profesion(Integer idProfesion, String profesion) {
this.idProfesion = idProfesion; this.profesion = profesion;
}


public Integer getIdProfesion() { return idProfesion; }
public void setIdProfesion(Integer idProfesion) { this.idProfesion = idProfesion; }
public String getProfesion() { return profesion; }
public void setProfesion(String profesion) { this.profesion = profesion; }
}
