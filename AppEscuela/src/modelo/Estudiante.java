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
public class Estudiante extends Persona {
private String carnet;


public Estudiante() {}


public Estudiante(Integer id, String nit, String nombres, String apellidos,
String direccion, String telefono, LocalDate fechaNacimiento,
Boolean genero, String carnet) {
super(id, nit, nombres, apellidos, direccion, telefono, fechaNacimiento, genero);
this.carnet = carnet;
}


public String getCarnet() { return carnet; }
public void setCarnet(String carnet) { this.carnet = carnet; }
}