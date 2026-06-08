package es.ies.dam.biblioteca.repositorio;

import es.ies.dam.biblioteca.modelo.Prestamo;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio de préstamos en memoria.
 */
public class PrestamoRepositorio {

    /** Lista interna de préstamos. */
    private List<Prestamo> prestamos = new ArrayList<>();

    /** Contador autoincremental de IDs. */
    private int siguienteId = 1;

    /**
     * Guarda un préstamo y le asigna un ID único.
     * @param prestamo préstamo a guardar
     */
    public void guardar(Prestamo prestamo) {
        if (prestamo != null) {
            prestamos.add(prestamo);
            siguienteId++;
        }
    }

    /**
     * Busca un préstamo por su ID.
     * @param id identificador del préstamo
     * @return préstamo encontrado o null
     */
    public Prestamo buscarPorId(int id) {
        for (Prestamo p : prestamos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    /**
     * Devuelve los préstamos activos de un usuario.
     * @param email email del usuario
     * @return lista de préstamos activos
     */
    public List<Prestamo> listarActivosPorUsuario(String email) {
        List<Prestamo> resultado = new ArrayList<>();
        for (Prestamo p : prestamos) {
            if (p.isActivo() && p.getUsuario().getEmail().equals(email)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    /**
     * Devuelve todos los préstamos vencidos y activos.
     * @return lista de préstamos vencidos
     */
    public List<Prestamo> listarVencidos() {
        List<Prestamo> resultado = new ArrayList<>();
        for (Prestamo p : prestamos) {
            if (p.isActivo() && p.estaVencido()) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    /**
     * Devuelve el siguiente ID disponible.
     * @return siguiente ID
     */
    public int getSiguienteId() {
        return siguienteId;
    }

    /**
     * Devuelve el número de préstamos almacenados.
     * @return tamaño
     */
    public int tamanio() {
        return prestamos.size();
    }
}
