import  java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        String implementacionSelecionada;
        System.out.println("Bienvenidod:\n");
        System.out.println("Ingrese una de las siguientes abreviaturas para seleccionar la implementacion SET a utilizar ");
        System.out.println("HS)HashSet \nTS)TreeSet, \nLHS)LinkedHashSet");
        implementacionSelecionada = entrada.nextLine();
    }
}
