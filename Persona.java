package Proyecto_final_biblioteca;

public class Persona {

    //atributos
    private String nombre, apellido;
    private int edad;

    //constructor
    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                "apellido='" + apellido + '\'' +
                "edad=" + edad
                ;
    }

}



