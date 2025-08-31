/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author ibane
 */
public abstract class Persona {
protected Integer id; // #
protected String nit; // #
protected String nombres; // #
protected String apellidos; // #
protected String direccion; // #
protected String telefono; // #
protected LocalDate fechaNacimiento; // #
protected Boolean genero; // #


protected Persona() {}


protected Persona(Integer id, String nit, String nombres, String apellidos,
String direccion, String telefono, LocalDate fechaNacimiento,
Boolean genero) {
this.id = id; this.nit = nit; this.nombres = nombres; this.apellidos = apellidos;
this.direccion = direccion; this.telefono = telefono; this.fechaNacimiento = fechaNacimiento;
this.genero = genero;
}


// Getters/Setters
public Integer getId() { return id; }
public void setId(Integer id) { this.id = id; }
public String getNit() { return nit; }
public void setNit(String nit) { this.nit = nit; }
public String getNombres() { return nombres; }
public void setNombres(String nombres) { this.nombres = nombres; }
public String getApellidos() { return apellidos; }
public void setApellidos(String apellidos) { this.apellidos = apellidos; }
public String getDireccion() { return direccion; }
public void setDireccion(String direccion) { this.direccion = direccion; }
public String getTelefono() { return telefono; }
public void setTelefono(String telefono) { this.telefono = telefono; }
public LocalDate getFechaNacimiento() { return fechaNacimiento; }
public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
public Boolean getGenero() { return genero; }
public void setGenero(Boolean genero) { this.genero = genero; }
}
