package es.ies.dam.biblioteca.modelo;
/**
 * Biblioteca con una capacidad máxima de libros.
 * Gestiona el inventario básico añadiendo y retirando libros,
 * así como consultar su estado de ocupación y espacio disponible.
 * * @author Ricardo 
 * @version 1.0
 * @since 1.0
 */
public class Biblioteca {

    /**
     * El nombre de la biblioteca. 
     */
    private String nombre;

    /**
     * La ciudad donde esta ubicada la biblioteca.
     */
    private String ciudad;

    /**
     * El número de libros que la biblioteca tiene.
     */
    private int capacidad;

    /**
     * El número de libros que la biblioteca tiene almacenados actualmente.
     */
    private int librosActuales;

    /**
     * Construye una nueva Biblioteca con el nombre, ciudad y capacidad especificados.
     * El número de libros actuales se inicializa por defecto en 0.
     * * @param nombre    El nombre de la biblioteca.
     * @param ciudad    La ciudad donde se ubica la biblioteca.
     * @param capacidad La capacidad máxima de libros que puede albergar.
     */
    public Biblioteca(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.librosActuales = 0;
    }

    /**
     * Añade una cantidad específica de libros a la biblioteca.
     * * @param cantidad El número de libros a añadir. Debe ser mayor que 0.
     * @return true si los libros se añadieron, false si la cantidad es nula.
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
     * Retira una cantidad específica de libros de la biblioteca.
     * * @param cantidad El número de libros a retirar. Debe ser mayor que 0.
     * @return true si los libros se retiraron con éxito, false si la cantidad es nula
     * o si se intenta retirar más libros de los que hay disponibles.
     */
    public boolean retirarLibro(int cantidad) {
        if (cantidad <= 0 || cantidad > librosActuales) {
            return false;
        }
        librosActuales -= cantidad;
        return true;
    }

    /**
     * Calcula y devuelve el espacio disponible para nuevos libros en la biblioteca.
     * * @return El número de espacios libres para libros.
     */
    public int getEspacioDisponible() {
        return capacidad - librosActuales;
    }

    /**
     * Calcula y devuelve el porcentaje de ocupación actual de la biblioteca.
     * * @return El porcentaje de capacidad que está ocupado (de 0.0 a 100.0).
     */
    public double getPorcentajeOcupacion() {
        if (capacidad == 0) return 0.0;
        return (librosActuales * 100.0) / capacidad;
    }

    /**
     * Comprueba si la biblioteca ha alcanzado su capacidad máxima.
     * * @return true si los libros actuales son iguales o superan la capacidad, false en caso contrario.
     */
    public boolean estaLlena() {
        return librosActuales >= capacidad;
    }

    /**
     * Obtiene el nombre de la biblioteca.
     * * @return El nombre de la biblioteca.
     */
    public String getNombre()        { return nombre; }

    /**
     * Obtiene la ciudad donde se ubica la biblioteca.
     * * @return La ciudad de la biblioteca.
     */
    public String getCiudad()        { return ciudad; }

    /**
     * Obtiene la capacidad máxima de la biblioteca.
     * * @return La capacidad de la biblioteca.
     */
    public int getCapacidad()        { return capacidad; }

    /**
     * Obtiene el número de libros actuales en la biblioteca.
     * * @return La cantidad de libros actuales.
     */
    public int getLibrosActuales()   { return librosActuales; }

    /**
     * Devuelve una representación en formato de cadena de texto (String) de la biblioteca.
     * * @return Una cadena con el formato "Nombre (Ciudad) - Actuales/Capacidad libros".
     */
    @Override
    public String toString() {
        return nombre + " (" + ciudad + ") - " + librosActuales + "/" + capacidad + " libros";
    }
}