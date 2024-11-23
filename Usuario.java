package Proyecto_final_biblioteca;

public class Usuario extends Persona{

    private int idUsuario;
    private String correo;

    public Usuario(String nombre, String apellido, int edad, int idUsuario, String correo) {
        super(nombre, apellido, edad);
        this.idUsuario = idUsuario;
        this.correo = correo;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return
                "idUsuario: " + idUsuario + '\n' +
                "Correo: " + correo
                ;
    }
}
