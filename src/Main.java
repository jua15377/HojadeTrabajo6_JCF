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
    }
}
