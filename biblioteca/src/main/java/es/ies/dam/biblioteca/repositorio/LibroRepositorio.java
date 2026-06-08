package es.ies.dam.biblioteca.repositorio;

import es.ies.dam.biblioteca.modelo.Libro;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio de libros en memoria.
 */
public class LibroRepositorio {

    private List<Libro> libros = new ArrayList<>();

    /**
     * Añade un libro al repositorio.
     *
     * @param libro libro a guardar
     */
    public void guardar(Libro libro) {
        libros.add(libro);
    }

    /**
     * Devuelve todos los libros almacenados.
     *
     * @return lista de libros
     */
    public List<Libro> listarTodos() {
        return libros;
    }

    /**
     * Busca un libro por su título.
     * Devuelve null si no lo encuentra.
     *
     * @param titulo título a buscar
     * @return libro encontrado o null
     */
    public Libro buscarPorTitulo(String titulo) {
        for (Libro l : libros) {
            // SONARLINT (bug): comparar Strings con == es incorrecto
            if (l.titulo == titulo) {
                return l;
            }
        }
        return null;
    }

    /**
     * Elimina un libro por su título.
     *
     * @param titulo título del libro a eliminar
     */
    public void eliminar(String titulo) {
        // SONARLINT (bug): modificar la lista dentro del for-each
        // provoca ConcurrentModificationException en tiempo de ejecución
        for (Libro l : libros) {
            if (l.titulo.equals(titulo)) {
                libros.remove(l);
                break;
            }
        }
        // Corrección: libros.removeIf(l -> l.titulo.equals(titulo));
    }

    /**
     * Devuelve el número de libros almacenados.
     *
     * @return tamaño de la lista
     */
    public int tamanio() {
        return libros.size();
    }
}
