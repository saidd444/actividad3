/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.math.BigDecimal;
import java.time.LocalDate;
/**
 *
 * @author ibane
 */
public class Docente extends Persona {
private String codigo;
private BigDecimal salario;
private Integer idProfesion; // FK a profesion


public Docente() {}


public Docente(Integer id, String nit, String nombres, String apellidos,
String direccion, String telefono, LocalDate fechaNacimiento,
Boolean genero, String codigo, BigDecimal salario, Integer idProfesion) {
super(id, nit, nombres, apellidos, direccion, telefono, fechaNacimiento, genero);
this.codigo = codigo; this.salario = salario; this.idProfesion = idProfesion;
}


public String getCodigo() { return codigo; }
public void setCodigo(String codigo) { this.codigo = codigo; }
public BigDecimal getSalario() { return salario; }
public void setSalario(BigDecimal salario) { this.salario = salario; }
public Integer getIdProfesion() { return idProfesion; }
public void setIdProfesion(Integer idProfesion) { this.idProfesion = idProfesion; }
}