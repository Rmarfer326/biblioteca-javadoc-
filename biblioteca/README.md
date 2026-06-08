# Biblioteca — Proyecto de análisis estático
## Entornos de Desarrollo · 2.º DAM

---

## Cómo abrir en IntelliJ IDEA

1. **File → Open** → selecciona la carpeta `biblioteca/`
2. IntelliJ detecta el `pom.xml` y configura Maven automáticamente
3. Espera a que terminen las descargas (barra inferior)

---

## Ejecutar los tests

```
mvn test
```

> ⚠️ El test `libroNuevoEstaDisponible` **falla a propósito** hasta que corrijas el primer bug.

---

## Errores que debes encontrar y corregir

### 🔴 SonarLint — Bugs (los más graves, corrígelos primero)

| Fichero | Método | Qué está mal | Cómo corregirlo |
|---|---|---|---|
| `Libro.java` | `estaDisponible()` | Compara Strings con `==` | Usar `.equals()` |
| `LibroRepositorio.java` | `buscarPorTitulo()` | Compara Strings con `==` | Usar `.equals()` |
| `LibroRepositorio.java` | `eliminar()` | Modifica la lista dentro del `for-each` | Usar `removeIf()` |
| `BibliotecaControlador.java` | `prestar()` | Usa `libro` sin comprobar si es `null` | Añadir `if (libro == null)` |
| `BibliotecaControlador.java` | `devolver()` | Usa `libro` y `usuario` sin comprobar `null` | Añadir null-checks |

### 🟠 SonarLint — Code smells (corrígelos después)

| Fichero | Qué está mal | Cómo corregirlo |
|---|---|---|
| `Libro.java` | `titulo`, `autor`, `paginas` son `public` | Hacerlos `private` y añadir getters |
| `Usuario.java` | `nombre`, `email` son `public` | Hacerlos `private` y añadir getters |
| `Libro.java` | `estaDisponible()` con `if/else` innecesario | Simplificar a `return estado.equals(DISPONIBLE)` |
| `Usuario.java` | `puedePedir()` con `if/else` innecesario | Simplificar a `return numPrestamos < MAX_PRESTAMOS` |
| `Usuario.java` | Variable `resultado` innecesaria en `nombreEnMayusculas()` | Devolver directamente |

### 🟡 CheckStyle — Convenciones (corrígelos al final)

| Fichero | Qué está mal | Cómo corregirlo |
|---|---|---|
| `Libro.java` | `import java.util.ArrayList` sin usar | Borrarlo |
| `Libro.java` | Constantes `disponible` y `prestado` en minúsculas | Renombrar a `DISPONIBLE` y `PRESTADO` |
| `Usuario.java` | Variable `NumPrestamos` con mayúscula | Renombrar a `numPrestamos` |
| `Usuario.java` | Constante `maxPrestamos` en minúsculas | Renombrar a `MAX_PRESTAMOS` |
| `Libro.java` | Magic number `100` en `resumen()` | Crear constante `private static final int MIN_PAGINAS_LARGO = 100` |

---

## Verificación final

Tras corregirlo todo:

```
mvn test              → todos los tests en verde
mvn checkstyle:check  → sin errores de estilo
```

Y en SonarLint → *Analyze All Files* → 0 avisos rojos o naranjas.
