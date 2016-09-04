import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Clase principal,
 * @author Eric Mendoza 15002
 * @author Jonnathan Juarez 15377
 * @since 03/09/2016
 * @version 1.0
 */

public class Factory{
    /**
     * Metodo que devuelve un tipo de set segun lo indicado por el usuario
     * @param tipoSet Es el tipo de set que se desea
     * @return Devuelve un Set
     */
    public static <E> Set<E> getSet(String tipoSet) {

        if (tipoSet.equalsIgnoreCase("HS")) {
            return new HashSet<E>();

        } else if (tipoSet.equalsIgnoreCase("TS")) {
            return new TreeSet<E>();

        } else if (tipoSet.equalsIgnoreCase("LHS")) {
            return new LinkedHashSet<E>();
        }
        return null;
    }
}