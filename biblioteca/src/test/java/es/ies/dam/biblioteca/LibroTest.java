package es.ies.dam.biblioteca;

import es.ies.dam.biblioteca.modelo.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para la clase Libro.
 * El test libroNuevoEstaDisponible FALLA hasta corregir el bug de ==.
 */
class LibroTest {

    private Libro libro;

    @BeforeEach
    void setUp() {
        libro = new Libro("Clean Code", "Robert C. Martin", 431);
    }

    @Test
    @DisplayName("Un libro nuevo debe estar disponible")
    void libroNuevoEstaDisponible() {
        // Este test FALLA antes de corregir el bug de ==
        assertTrue(libro.estaDisponible());
    }

    @Test
    @DisplayName("Un libro prestado no debe estar disponible")
    void libroPrestadoNoEstaDisponible() {
        libro.setEstado("PRESTADO");
        assertFalse(libro.estaDisponible());
    }

    @Test
    @DisplayName("resumen incluye el título")
    void resumenContieneTitulo() {
        assertTrue(libro.resumen().contains("Clean Code"));
    }
}
