package es.ies.dam.biblioteca.modelo;

import java.time.LocalDate;

/**
 * Representa un préstamo de un libro a un usuario.
 */
public class Prestamo {

    /** Identificador único del préstamo. */
    private int id;

    /** Libro prestado. */
    private Libro libro;

    /** Usuario que recibe el préstamo. */
    private Usuario usuario;

    /** Fecha en que se realizó el préstamo. */
    private LocalDate fechaPrestamo;

    /** Fecha máxima de devolución. */
    private LocalDate fechaDevolucion;

    /** Indica si el préstamo sigue activo. */
    private boolean activo;

    // CheckStyle: magic number — días de préstamo deberían ser una constante
    /** Número de días por defecto de un préstamo. */
    private static final int DIAS_PRESTAMO = 15;

    /**
     * Crea un nuevo préstamo a partir de hoy.
     * @param id identificador del préstamo
     * @param libro libro que se presta
     * @param usuario usuario que recibe el préstamo
     */
    public Prestamo(int id, Libro libro, Usuario usuario) {
        this.id = id;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = LocalDate.now().plusDays(DIAS_PRESTAMO);
        this.activo = true;
    }

    /**
     * Devuelve el id del préstamo.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve el libro del préstamo.
     * @return libro
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Devuelve el usuario del préstamo.
     * @return usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Devuelve la fecha del préstamo.
     * @return fechaPrestamo
     */
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Devuelve la fecha de devolución.
     * @return fechaDevolucion
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Indica si el préstamo está activo.
     * @return true si activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Finaliza el préstamo.
     */
    public void cerrar() {
        this.activo = false;
    }

    /**
     * Comprueba si el préstamo está vencido.
     * @return true si la fecha actual supera la de devolución
     */
    public boolean estaVencido() {
        return LocalDate.now().isAfter(fechaDevolucion);
    }
}
