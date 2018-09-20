package usonsonate.com.encuestarestaurante;

import java.io.Serializable;
import java.util.Date;

public class Encuestado implements Serializable {

    private String Nombre;
    private int Edad;
    private String Apellido;
    private Date FechaNac;

    public Encuestado(String nombre, int edad, String apellido, Date fechaNac) {
        Nombre = nombre;
        Edad = edad;
        Apellido = apellido;
        FechaNac = fechaNac;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Date getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        FechaNac = fechaNac;
    }
}
