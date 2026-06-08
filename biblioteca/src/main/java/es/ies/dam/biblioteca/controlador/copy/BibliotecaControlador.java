package es.ies.dam.biblioteca.controlador.copy;

import es.ies.dam.biblioteca.modelo.Libro;
import es.ies.dam.biblioteca.modelo.Usuario;
import es.ies.dam.biblioteca.repositorio.LibroRepositorio;
import es.ies.dam.biblioteca.repositorio.UsuarioRepositorio;

/**
 * Controlador principal de la biblioteca.
 */
public class BibliotecaControlador {

    private LibroRepositorio libroRepo;
    private UsuarioRepositorio usuarioRepo;

    /**
     * Crea el controlador inicializando los repositorios.
     */
    public BibliotecaControlador() {
        this.libroRepo = new LibroRepositorio();
        this.usuarioRepo = new UsuarioRepositorio();
    }

    /**
     * Registra un nuevo libro en el sistema.
     *
     * @param titulo  título del libro
     * @param autor   autor del libro
     * @param paginas número de páginas
     */
    public void registrarLibro(String titulo, String autor, int paginas) {
        Libro libro = new Libro(titulo, autor, paginas);
        libroRepo.guardar(libro);
    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param nombre nombre del usuario
     * @param email  correo electrónico
     */
    public void registrarUsuario(String nombre, String email) {
        Usuario usuario = new Usuario(nombre, email);
        usuarioRepo.guardar(usuario);
    }

    /**
     * Realiza el préstamo de un libro a un usuario.
     *
     * @param titulo título del libro
     * @param email  email del usuario
     */
    public void prestar(String titulo, String email) {
        // SONARLINT: buscarPorTitulo puede devolver null — NPE si no se comprueba
        Libro libro = libroRepo.buscarPorTitulo(titulo);

        // SONARLINT: buscarPorEmail puede devolver null — NPE si no se comprueba
        Usuario usuario = usuarioRepo.buscarPorEmail(email);

        if (!libro.estaDisponible()) {
            System.out.println("El libro no está disponible.");
            return;
        }

        if (!usuario.puedePedir()) {
            System.out.println("El usuario ha alcanzado el límite de préstamos.");
            return;
        }

        libro.setEstado(Libro.prestado);
        usuario.incrementarPrestamos();

        // SONARLINT: acceso directo a campo público libro.titulo
        System.out.println("Préstamo realizado: " + libro.titulo);
    }

    /**
     * Procesa la devolución de un libro.
     *
     * @param titulo título del libro devuelto
     * @param email  email del usuario que devuelve
     */
    public void devolver(String titulo, String email) {
        Libro libro = libroRepo.buscarPorTitulo(titulo);
        Usuario usuario = usuarioRepo.buscarPorEmail(email);

        // SONARLINT: no se comprueba null antes de usar libro y usuario
        libro.setEstado(Libro.disponible);
        usuario.decrementarPrestamos();

        System.out.println("Devolución registrada.");
    }

    /**
     * Muestra por consola el estado actual de la biblioteca.
     */
    public void mostrarEstado() {
        System.out.println("Libros registrados: " + libroRepo.tamanio());
        System.out.println("Usuarios registrados: " + usuarioRepo.tamanio());

        System.out.println("--- Libros ---");
        for (Libro l : libroRepo.listarTodos()) {
            // SONARLINT: acceso directo a campos públicos
            System.out.println(l.titulo + " | " + l.autor + " | " + l.getEstado());
        }

        System.out.println("--- Usuarios ---");
        for (Usuario u : usuarioRepo.listarTodos()) {
            // SONARLINT: acceso directo a campos públicos
            System.out.println(u.nombre + " | " + u.email);
        }
    }
}
