package Proyecto_final_biblioteca;

public class Empleado extends Persona{
    private int idEmpleado;
    private String puesto;

    public Empleado(String nombre, String apellido, int edad, int idEmpleado, String puesto) {
        super(nombre, apellido, edad);
        this.idEmpleado = idEmpleado;
        this.puesto = puesto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getPuesto() {
        return puesto;
    }

    @Override
    public String toString() {
        return
                "idEmpleado:  " + idEmpleado +'\n'
                +"Puesto: " + puesto
                ;
    }
}
