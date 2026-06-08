package es.ies.dam.biblioteca;

/*
 * Representa una biblioteca que almacena libros y controla su capacidad máxima.
 * Permite agregar y retirar libros, consultar el espacio disponible,
 * el porcentaje de ocupación y comprobar si la biblioteca está llena.
 *
 * @author Ricardo Martin Fernandez
 * @version 1.0
 * @since 1.0
 */
public class Libro {

    /**
     * Nombre de la biblioteca.
     */
    private String nombre;

    /**
     * Ciudad donde se encuentra la biblioteca.
     */
    private String ciudad;

    /**
     * Capacidad máxima de libros que puede almacenar la biblioteca.
     */
    private int capacidad;

    /**
     * Cantidad actual de libros almacenados.
     */
    private int librosActuales;

    /**
     * Crea una nueva biblioteca con una capacidad determinada.
     *
     * @param nombre nombre de la biblioteca
     * @param ciudad ciudad donde se encuentra la biblioteca
     * @param capacidad capacidad máxima de libros
     */
    public Libro(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.librosActuales = 0;
    }

    /**
     * Agrega una cantidad de libros a la biblioteca.
     *
     * @param cantidad número de libros a agregar
     * @return true si los libros se agregan correctamente, false en caso contrario
     */
    public boolean agregarLibro(int cantidad) {
        if (cantidad <= 0) {
            return false;
        }
        if (librosActuales + cantidad > capacidad) {
            return false;
        }
        librosActuales += cantidad;
        return true;
    }

    /**
     * Retira una cantidad de libros de la biblioteca.
     *
     * @param cantidad número de libros a retirar
     * @return true si los libros se retiran correctamente, false en caso contrario
     */
    public boolean retirarLibro(int cantidad) {
        if (cantidad <= 0 || cantidad > librosActuales) {
            return false;
        }
        librosActuales -= cantidad;
        return true;
    }

    /**
     * Obtiene el espacio disponible para almacenar más libros.
     *
     * @return número de espacios libres en la biblioteca
     */
    public int getEspacioDisponible() {
        return capacidad - librosActuales;
    }

    /**
     * Calcula el porcentaje de ocupación de la biblioteca.
     *
     * @return porcentaje de ocupación respecto a la capacidad máxima
     */
    public double getPorcentajeOcupacion() {
        if (capacidad == 0) return 0.0;
        return (librosActuales * 100.0) / capacidad;
    }

    /**
     * Comprueba si la biblioteca ha alcanzado su capacidad máxima.
     *
     * @return true si la biblioteca está llena, false en caso contrario
     */
    public boolean estaLlena() {
        return librosActuales >= capacidad;
    }

    /**
     * Obtiene el nombre de la biblioteca.
     *
     * @return nombre de la biblioteca
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la ciudad de la biblioteca.
     *
     * @return ciudad donde se encuentra la biblioteca
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Obtiene la capacidad máxima de la biblioteca.
     *
     * @return capacidad máxima de libros
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Obtiene la cantidad actual de libros almacenados.
     *
     * @return número actual de libros
     */
    public int getLibrosActuales() {
        return librosActuales;
    }

    /**
     * Devuelve una representación textual de la biblioteca.
     *
     * @return cadena con la información principal de la biblioteca
     */
    @Override
    public String toString() {
        return nombre + " (" + ciudad + ") - " + librosActuales + "/" + capacidad + " libros";
    }
}