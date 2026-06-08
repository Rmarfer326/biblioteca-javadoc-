package es.ies.dam.biblioteca.modelo;

/**
 * Modelo que representa un usuario de la biblioteca.
 */
/**
 * 
 */
public class Usuario {

    // SONARLINT: campo público — debería ser privado
    public String nombre;

    // SONARLINT: campo público — debería ser privado
    public String email;

    // CHECKSTYLE: nombre de variable con mayúscula (no camelCase)
    private int NumPrestamos;

    // CHECKSTYLE: magic number — debería ser constante MAX_PRESTAMOS
    private static final int MAX_PRESTAMOS = 3; 

    /**
     * Crea un usuario con nombre y email.
     *
     * @param nombre nombre del usuario
     * @param email  correo electrónico
     */
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.NumPrestamos = 0;
    }

    /**
     * Devuelve el número de préstamos activos.
     *
     * @return número de préstamos
     */
    public int getNumPrestamos() {
        return NumPrestamos;
    }

    /**
     * Registra un nuevo préstamo al usuario.
     */
    public void incrementarPrestamos() {
        NumPrestamos++;
    }

    /**
     * Registra la devolución de un libro.
     */
    public void decrementarPrestamos() {
        NumPrestamos--;
    }

    /**
     * Indica si el usuario puede pedir más libros.
     *
     * @return true si no ha alcanzado el límite
     */
    public boolean puedePedir() {
        // SONARLINT: simplificable — return NumPrestamos < maxPrestamos;
        if (NumPrestamos < MAX_PRESTAMOS) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve el nombre del usuario en mayúsculas.
     *
     * @return nombre en mayúsculas
     */
    public String nombreEnMayusculas() {
        // SONARLINT: variable local innecesaria
        String resultado = nombre.toUpperCase();
        return resultado;
    }

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the maxprestamos
	 */
	public static int getMaxprestamos() {
		return MAX_PRESTAMOS;
	}

	/**
	 * @param numPrestamos the numPrestamos to set
	 */
	public void setNumPrestamos(int numPrestamos) {
		NumPrestamos = numPrestamos;
	}
    
    
}
