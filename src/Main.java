import  java.util.*;

/**
 * Clase principal,
 * @author Eric Mendoza 15002
 * @author Jonnathan Juarez 15377
 * @since 03/09/2016
 * @version 1.0
 */

public class Main {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        String implementacionSelecionada = "";  // Tipo de set que se desea utilizar

        System.out.println("Bienvenido:\n");
        System.out.println("Ingrese la implementacion SET a utilizar (utilice las abreviaturas):");
        System.out.println("1) HashSet (HS) \n2) TreeSet (TS) \n3) LinkedHashSet (LHS)");
        if (entrada.hasNext()){
            implementacionSelecionada = entrada.nextLine();
        }

        // Crear conjuntos de developers
        Set<String> developersSet = Factory.getSet(implementacionSelecionada);  // Conjunto de todos los developers
        Set<String> javaSet = Factory.getSet(implementacionSelecionada);
        Set<String> webSet = Factory.getSet(implementacionSelecionada);
        Set<String> cellSet = Factory.getSet(implementacionSelecionada);

        // Ingreso de los programadores
        String continuar = "Y";
        String nombre = "", respuesta = "";
        while (continuar.equalsIgnoreCase("Y")){
            // Ingresar nombre de developer
            System.out.println("Ingrese el nombre del desarrollador:");
            if (entrada.hasNext()){
                nombre = entrada.nextLine();
                nombre = nombre.toLowerCase();  // Colocarlo en minusculas para comparacion
                assert developersSet != null;
                developersSet.add(nombre);
            }


            // Ingresar si sabe programar java
            System.out.println("Indique si ha desarrollado en Java (Y/N): ");
            if (entrada.hasNext()){
                respuesta = entrada.nextLine();
            }
            if (respuesta.equalsIgnoreCase("Y")) {
                assert javaSet != null;
                javaSet.add(nombre);
            }


            // Ingresar si sabe programar web
            System.out.println("Indique si ha desarrollado en Web (Y/N): ");
            if (entrada.hasNext()){
                respuesta = entrada.nextLine();
            }
            if (respuesta.equalsIgnoreCase("Y")) {
                assert webSet != null;
                webSet.add(nombre);
            }


            // Ingresar si sabe programar celulares
            System.out.println("Indique si ha desarrollado en celulares (Y/N): ");
            if (entrada.hasNext()){
                respuesta = entrada.nextLine();
            }
            if (respuesta.equalsIgnoreCase("Y")) {
                assert cellSet != null;
                cellSet.add(nombre);
            }


            // Indicar si se ingresara otro usuario
            System.out.println("Desea ingresar otro desarrollador (Y/N)? ");
            if (entrada.hasNext()){
                continuar = entrada.nextLine();
            }
        }

        // INCISO NUMERO 1: Interseccion entre los tres ambientes de desarrollo
        List<String> resultado1 = obtenerDevelopersJWC(developersSet, javaSet, webSet, cellSet);
        System.out.println("1) Los desarrolladores que han programado en Java, Web y Moviles son:");
        for (String developer: resultado1
             ) {
            System.out.println(" - " + developer);
        }
        if (resultado1.isEmpty()) System.out.println(" - Ninguno");


        // INCISO NUMERO 2: Desarrolladores de Java, pero no de Web
        List<String> resultado2 = obtenerDevelopersJSinW(developersSet, javaSet, webSet, cellSet);
        System.out.println("2) Los desarrolladores que han programado en Java y no en Web son:");
        for (String developer: resultado2
                ) {
            System.out.println(" - " + developer);
        }
        if (resultado2.isEmpty()) System.out.println(" - Ninguno");


        // INCISO NUMERO 3: Web y Movil sin experiencia en Java
        List<String> resultado3 = obtenerDevelopersWyMSinJ(developersSet, javaSet, webSet, cellSet);
        System.out.println("3) Los desarrolladores que han programado en Web y Moviles, pero no en Java son:");
        for (String developer: resultado3
                ) {
            System.out.println(" - " + developer);
        }
        if (resultado3.isEmpty()) System.out.println(" - Ninguno");

        // INCISO NUMERO 4: Web o Movil sin experiencia en Java
        List<String> resultado4 = obtenerDevelopersWoMSinJ(developersSet, javaSet, webSet, cellSet);
        System.out.println("4) Los desarrolladores que han programado en Web o en Moviles, pero no en Java son:");
        for (String developer: resultado4
                ) {
            System.out.println(" - " + developer);
        }
        if (resultado4.isEmpty()) System.out.println(" - Ninguno");


        // INCISO NUMERO 5: Verificacion si los desarrolladores java son subconjunto de los web
        boolean resultado5 = verificarJavaSubWeb(javaSet, webSet);
        System.out.println("5) Es el conjunto de desarrolladores Java un subconjunto de los desarrolladores Web?");
        if (resultado5){
            System.out.println(" - Verdadero");
        } else {
            System.out.println(" - Falso");
        }


        // INCISO NUMERO 6: Obtener el conjunto con mas desarrolladores
        String resultado6 = obtenerMayorDevelopers(javaSet, webSet, cellSet);
        System.out.println("6) El conjunto de desarrolladores mas grande es '" + resultado6 + "' contiene a: ");
        Set<String> resultado6_1;
        if (resultado6.equalsIgnoreCase("java")) resultado6_1 = javaSet;
        else if (resultado6.equalsIgnoreCase("web")) resultado6_1 = webSet;
        else resultado6_1 = cellSet;

        for (String developer: resultado6_1) {
            System.out.println(" - " + developer);
        }


        // INCISO NUMERO 7: Imprimir a los desarrolladores del grupo mas grande en orden
        List<String> sortedList = new ArrayList<String>(resultado6_1);
        System.out.println("7) El conjunto dmas grande ordenado en orden ascendente es: ");
        Collections.sort(sortedList);
        for (String developer: sortedList) {
            System.out.println(" - " + developer);
        }

    }


    // Inciso 1
    /**
     * Este metodo devuelve la inteseccion de los desarolladores que programan en Java, Web y Moviles
     * @param developersSet Es el listado de todos los desarrolladores
     * @param javaSet Son los desarrolladores de Java
     * @param webSet Son los desarrolladores de Web
     * @param cellSet Son los desarrolladores de Moviles
     * @return Devuelve una lista de los que cumplen con la condicion
     */
    private static List<String> obtenerDevelopersJWC(Set<String> developersSet, Set<String> javaSet, Set<String> webSet, Set<String> cellSet){
        List<String> resultado = new ArrayList<String>();
        for (String developer: developersSet
             ) {
            if (javaSet.contains(developer) && webSet.contains(developer) && cellSet.contains(developer)){
                resultado.add(developer);
            }
        }
        return resultado;
    }

    // Inciso 2
    /**
     * Este metodo devuelve a los programadores de Java que no saben web
     * @param developersSet Es el listado de todos los desarrolladores
     * @param javaSet Son los desarrolladores de Java
     * @param webSet Son los desarrolladores de Web
     * @param cellSet Son los desarrolladores de Moviles
     * @return Devuelve una lista de los que cumplen con la condicion
     */
    private static List<String> obtenerDevelopersJSinW(Set<String> developersSet, Set<String> javaSet, Set<String> webSet, Set<String> cellSet) {
        List<String> resultado = new ArrayList<String>();
        for (String developer: developersSet
                ) {
            if (javaSet.contains(developer) && !webSet.contains(developer)){
                resultado.add(developer);
            }
        }
        return resultado;
    }


    // Inciso 3
    /**
     * Este metodo devuelve a los programadores de Web y Moviles, pero sin saber Java
     * @param developersSet Es el listado de todos los desarrolladores
     * @param javaSet Son los desarrolladores de Java
     * @param webSet Son los desarrolladores de Web
     * @param cellSet Son los desarrolladores de Moviles
     * @return Devuelve una lista de los que cumplen con la condicion
     */
    private static List<String> obtenerDevelopersWyMSinJ(Set<String> developersSet, Set<String> javaSet, Set<String> webSet, Set<String> cellSet) {
        List<String> resultado = new ArrayList<String>();
        for (String developer: developersSet
                ) {
            if (!javaSet.contains(developer) && webSet.contains(developer) && cellSet.contains(developer)){
                resultado.add(developer);
            }
        }
        return resultado;
    }

    // Inciso 4
    /**
     * Este metodo devuelve a los programadores de Web o Moviles, pero sin saber Java
     * @param developersSet Es el listado de todos los desarrolladores
     * @param javaSet Son los desarrolladores de Java
     * @param webSet Son los desarrolladores de Web
     * @param cellSet Son los desarrolladores de Moviles
     * @return Devuelve una lista de los que cumplen con la condicion
     */
    private static List<String> obtenerDevelopersWoMSinJ(Set<String> developersSet, Set<String> javaSet, Set<String> webSet, Set<String> cellSet) {
        List<String> resultado = new ArrayList<String>();
        for (String developer: developersSet
                ) {
            if (!javaSet.contains(developer) && (webSet.contains(developer) || cellSet.contains(developer))){
                resultado.add(developer);
            }
        }
        return resultado;
    }


    // Inciso 5
    /**
     * Este metodo verifica si todos los que saben programar en Java, saben Web
     * @param javaSet Son los desarrolladores de Java
     * @param webSet Son los desarrolladores de Web
     * @return Devuelve true si se cumple la condicion
     */
    private static boolean verificarJavaSubWeb(Set<String> javaSet, Set<String> webSet) {
        boolean resultado = true;
        for (String developer: javaSet
                ) {
            if (!webSet.contains(developer)){
                resultado = false;
            }
        }
        return resultado;
    }


    // Inciso 6
    /**
     * Este metodo sirve para encontrar el conjunto de desarrolladores mas grande
     * @param javaSet Son los desarrolladores de Java
     * @param webSet Son los desarrolladores de Web
     * @param cellSet Son los desarrolladores de Moviles
     * @return El nombre del conjunto de desarrolladores mas grande
     */
    private static String obtenerMayorDevelopers(Set<String> javaSet, Set<String> webSet, Set<String> cellSet) {
        String resultado = "";
        int max = 0, maxSet = 0;
        int[] tamanos = {javaSet.size(), webSet.size(), cellSet.size()};

        for (int i = 0; i < tamanos.length; i++) {
            if (tamanos[i] > max){
                max = tamanos[i];   // Actualizar el maximo
                maxSet = i;  // Guardar el indice del mayor
            }
        }

        if (maxSet == 0) resultado = "Java";
        else if (maxSet == 1) resultado = "Web";
        else if (maxSet == 2) resultado = "Movil";

        return resultado;
    }

}
