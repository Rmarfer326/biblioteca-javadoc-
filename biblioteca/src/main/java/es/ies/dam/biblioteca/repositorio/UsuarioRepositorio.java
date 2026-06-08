package es.ies.dam.biblioteca.repositorio;

import es.ies.dam.biblioteca.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio de usuarios en memoria.
 */
public class UsuarioRepositorio {

    private List<Usuario> usuarios = new ArrayList<>();

    /**
     * Añade un usuario al repositorio.
     *
     * @param usuario usuario a guardar
     */
    public void guardar(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Busca un usuario por su email.
     *
     * @param email email del usuario
     * @return usuario encontrado o null
     */
    public Usuario buscarPorEmail(String email) {
        for (Usuario u : usuarios) {
            if (u.email.equals(email)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Devuelve todos los usuarios.
     *
     * @return lista de usuarios
     */
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    /**
     * Devuelve el número de usuarios registrados.
     *
     * @return tamaño de la lista
     */
    public int tamanio() {
        return usuarios.size();
    }
}
