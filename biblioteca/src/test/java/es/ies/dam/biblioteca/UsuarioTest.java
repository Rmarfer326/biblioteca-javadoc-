package es.ies.dam.biblioteca;

import es.ies.dam.biblioteca.modelo.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para la clase Usuario.
 */
class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Ana García", "ana@ies.es");
    }

    @Test
    @DisplayName("Un usuario nuevo puede pedir libros")
    void usuarioNuevoPuedePedir() {
        assertTrue(usuario.puedePedir());
    }

    @Test
    @DisplayName("Con 3 préstamos ya no puede pedir más")
    void usuarioConLimitNoPuedePedir() {
        usuario.incrementarPrestamos();
        usuario.incrementarPrestamos();
        usuario.incrementarPrestamos();
        assertFalse(usuario.puedePedir());
    }

    @Test
    @DisplayName("nombreEnMayusculas devuelve el nombre en mayúsculas")
    void nombreEnMayusculasEsCorrecto() {
        assertEquals("ANA GARCÍA", usuario.nombreEnMayusculas());
    }
}
