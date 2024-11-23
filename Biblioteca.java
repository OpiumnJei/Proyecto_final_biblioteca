package Proyecto_final_biblioteca;

import java.util.ArrayList;
import java.util.List;

/// LA MAQUINA DEL TIEMPO MY NEGGAA
public class Biblioteca {
    private String nombreBiblioteca;
    private List<Empleado> empleados = new ArrayList<>();
    private List<Libro> libros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();


    public Biblioteca() {
    }

    public Biblioteca(String nombreBiblioteca, List<Empleado> empleados, List<Usuario> usuarios, List<Libro> libros) {
        this.nombreBiblioteca = nombreBiblioteca;
        this.empleados = empleados;
        this.usuarios = usuarios;
        this.libros = libros;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void contrarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void pedirLibroPrestado(String isbnLibro, int usuarioId) {

        //verificar si el libro o el usuario se encuentran almacenados en sus respectivas lista jeje
        if (encontrarLibro(isbnLibro) && encontrarUsuario(usuarioId)) {
            System.out.println("Libro prestado al usuario: " + usuarioId);
        } else {
            System.out.println("El usuario o el libro actualmente no se encuentran disponibles.");
        }
    }

    //metodo para verificar si el libro esta disponible o prestado
    public void libroDisponible(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                if (l.disponible()) {
                    System.out.println("Libro disponible");
                } else {
                    System.out.println("El libro se encuentra prestado actualmente!");
                }
            } else {
                System.out.println("El libro no existe en la biblioteca");
            }
        }

    }

    //metodo para devolver el libro a la biblioteca
    public void devolverLibro(String isbn) {

        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {//corrobar si hay un libro con ese mismo isbn en la biblioteca(si existe en la biblioteca)
                if (!l.disponible()) { //se verifica el estado del libro, es decir, si esta disponible o prestado
                    System.out.println("Libro devuelto con exito!");
                    l.devolverLibro();
                }
            } else {
                System.out.println("""
                        El libro no puede ser devuelto por varias razones: 
                                                
                        1. El libro no se encuentra en la biblioteca
                        2. El libro aun no se ha solicitado, por lo que no puede ser devuelto.
                        """);

            }
        }
    }


    //imprimir todos los libros no bulto
    public void imprimirLibros() {
        if (libros.isEmpty()) {
            System.out.println("Aun no hay libros almacenados en la biblioteca, intente en otro momento.");
        }

        int i = 0;
        for (Libro l : libros) {
            System.out.println("Libro: " + (i + 1));
            System.out.println("");
            System.out.println(l);
        }
    }

    //imprimir usuarios
    public void imprimirUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Aun no hay usuarios registrados en la biblioteca, intente en otro momento.");
        }
        int i = 0;
        for (Usuario u : usuarios) {
            System.out.println("Usuario: " + (i + 1));
            System.out.println(u);
        }
    }

    //imprimir empleados
    public void imprimirEmpleados() {
        if (libros.isEmpty()) {
            System.out.println("Aun no hay empleados contratados en la biblioteca, intente en otro momento.");
        }
        int i = 0;
        for (Empleado e : empleados) {
            System.out.println("Empleado: " + (i + 1));
            System.out.println(e);
        }
    }

    //metodo para verificar que el libro exista en la lista
    public boolean encontrarLibro(String isbn) {

        //corrobar si el libro se encuentra en la lista
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                l.prestarLibro(); // si el isbn de la lista coincide con el isbn enviado por el usuario se presta automaticamente
                return true;
            }
        }
        return false;
    }

    //metodo para verificar que el usuario exista en la lista
    public boolean encontrarUsuario(int usuario) {

        //corrobar si el id del usuario se encuentra en la lista
        for (Usuario u : usuarios) { //se van a iterar los datos de la lista usuarios
            if (u.getIdUsuario() == usuario) { //se toma cada id de la lista y se compara con el id enviado por usuario
                return true; // retorna true si se encuentra coincidencias
            }
        }
        return false;
    }

}



