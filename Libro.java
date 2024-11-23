package Proyecto_final_biblioteca;

public class Libro {
    private String titulo, autor, isbn;
    private int anioPublicacion;
    public boolean libroEnBiblioteca;


    public Libro(String titulo, String autor, String isbn, boolean libroEnBiblioteca, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.libroEnBiblioteca = libroEnBiblioteca;
        this.anioPublicacion = anioPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    //metodo usado para cambiar la disponibilidad del libro
    public void prestarLibro(){
        this.libroEnBiblioteca = false;
    }

    public void devolverLibro(){
        this.libroEnBiblioteca = true;
    }

    //comprobar el estado del libro
    public boolean disponible(){
        if(this.libroEnBiblioteca){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return
                "Titulo: " + titulo + '\n' +
                "Autor: " + autor + '\n' +
                "ISBN: " + isbn + '\n' +
                "Anio Publicacion: " + anioPublicacion
                ;
    }
}
