package Proyecto_final_biblioteca;

import java.util.Scanner;

public class BibliotecaMain {

    //instanciasd estaticas
    static Scanner sc = new Scanner(System.in);
    static Biblioteca b = new Biblioteca();

    public static void main(String[] args) {

        System.out.print("ELija el nombre de la biblioteca: ");
        String nombreBiblioteca = sc.nextLine();
        b.setNombreBiblioteca(nombreBiblioteca.toUpperCase());

//        valores de prueba:
//        Usuario u = new Usuario("jerlinson", "gonzalez", 13, 123, "jer@gmail.com");
//        Libro l = new Libro("abc", "abc", "1344", true, 1999);
//
//        b.agregarLibro(l);
//        b.registrarUsuario(u);
        while (true) {

            System.out.printf("""
                    ---------------------------
                    BIENVENIDO A %s!!
                    ---------------------------
                                        
                    Selecciona una opcion: 
                                        
                    1 -> Registar un usuario.
                    2 -> Listar usuarios
                    3 -> Contratar un empleado
                    4 -> Listar Empleados
                    5 -> Agregar libro
                    6 -> Listar libros
                    7 -> Solicitar un libro
                    8 -> Devolver un libro
                    9 -> Consultar disponibilidad de un libro
                    10 -> Salir del sistema
                    
                    ---------------------------           
                    """, b.getNombreBiblioteca());

            System.out.print("Elija una opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Consumimos el salto de línea
            switch (opcion) {
                case 1:
                    registarUsuario();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    contratarEmpleado();
                    break;
                case 4:
                    listarEmpleados();
                    break;
                case 5:
                    agregarLibro();
                    break;
                case 6:
                    listarLibros();
                    break;
                case 7:
                    solicitarLibroPrestado();
                    break;
                case 8:
                    devolverLibro();
                    break;
                case 9:
                    consultarDisponiblidad();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }

    static void registarUsuario() {
        String nombre, apellido, correo;
        int edad, idUsuario;

        System.out.print("Ingresa el nombre: ");
        nombre = sc.nextLine();
        System.out.print("Ingresa el apellido: ");
        apellido = sc.nextLine();
        System.out.print("Ingresa la edad: ");
        edad = sc.nextInt();
        sc.nextLine(); //consume el salto de linea (\n) residual dejado en el buffer por el nextInt
        System.out.print("Ingresa el id: ");
        idUsuario = sc.nextInt();
        sc.nextLine(); //consume el salto de linea (\n) residual dejado en el buffer por el nextInt
        System.out.print("Ingrese el correo electronico: ");
        correo = sc.nextLine();

        //guardar el usuario en la biblioteca
        b.registrarUsuario(new Usuario("jerlinson", "gonzalez", 21, 123, "jerGonzalez@gmail.com"));

        System.out.println("Usuario registrado con exito!!");
    }

    static void listarUsuarios() {
        b.imprimirUsuarios();
    }

    static void contratarEmpleado() {

        String nombre, apellido, puesto;
        int edad, idEmpleado;

        System.out.print("Ingresa el nombre: ");
        nombre = sc.nextLine();
        System.out.print("Ingresa el apellido: ");
        apellido = sc.nextLine();
        System.out.print("Ingresa la edad: ");
        edad = sc.nextInt();
        sc.nextLine(); //consume el salto de linea (\n) residual dejado en el buffer por el nextInt
        System.out.print("Ingresa el id: ");
        idEmpleado = sc.nextInt();
        sc.nextLine(); //consume el salto de linea (\n) residual dejado en el buffer por el nextInt
        System.out.print("Ingrese el puesto del empleado: ");
        puesto = sc.nextLine();

        //contrar empleado  en la biblioteca
        b.contrarEmpleado(new Empleado(nombre, apellido, edad, idEmpleado, puesto));
    }

    static void listarEmpleados() {
        b.imprimirEmpleados();
    }

    static void agregarLibro() {

        String titulo, autor, isbn;
        int anioPublicacion;

        System.out.print("Ingresa el titulo: ");
        titulo = sc.nextLine();
        System.out.print("Ingresa el autor: ");
        autor = sc.nextLine();
        System.out.print("Ingresa el isbn: ");
        isbn = sc.nextLine();
        System.out.print("Anio publicacion:  ");
        anioPublicacion = sc.nextInt();
        sc.nextLine(); //consume el salto de linea (\n) residual dejado en el buffer por el nextInt

        //agregar libro a la biblioteca
        b.agregarLibro(new Libro(titulo, autor, isbn, true, anioPublicacion));
    }

    static void listarLibros() {
        b.imprimirLibros();
    }

    //pedir prestado un libro
    static void solicitarLibroPrestado() {
        String isbn;
        int idUsuario;

        System.out.print("Ingresa el isbn: ");
        isbn = sc.nextLine();

        System.out.print("Ingresa el id del usuario:  ");
        idUsuario = sc.nextInt();
        sc.nextLine(); //consume el salto de linea (\n) residual dejado en el buffer por el nextInt

        b.pedirLibroPrestado(isbn, idUsuario);
    }

    //retornar un libro a la biblioteca
    static void devolverLibro() {
        System.out.print("Digita el isbn del libro ha devolver: ");
        String isbn = sc.nextLine();
        b.devolverLibro(isbn);
    }

    //consultar si un libro se encuentra disponible o no
    static void consultarDisponiblidad() {
        String isbn;
        System.out.print("Digita el isbn del libro ha conultar: ");
        isbn = sc.nextLine();

        b.libroDisponible(isbn);
    }
}
