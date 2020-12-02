package com.company;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * <p>
 * <h1>GESTIÓN DE DICCIONARIO</h1>
 * </p>
 *
 * <p>
 * El programa contiene palabras en una hashtable utilizada como diccionario y
 * como se escriben en diferentes idiomas
 * </p>
 * <p>
 * Contiene un menu para poder mostrar ciertas palabras como se escriben en el
 * mismo idioma
 * </p>
 * <p>
 * Podremos borrar las palabras que queramos en diferentes idiomas
 * </p>
 * <p>
 * Podremos borrar una palabra en todos los idiomas
 * </p>
 * <p>
 * Tambien podremos ostrar las palabras en un determinado idioma
 * </p>
 * <br>
 *
 * @author Ramon Torres Carrero
 * @version 1.0
 * @since 01/12/2020
 */

public class Main {

    /**
     * Funcion que comprueba si es un numero lo que hemos introducido por teclado
     *
     * @param cadena es un String que obtenemos al escribir por teclado
     * @return <ul>
     *         <li>true: nos devuelve este valor cuando hemos introducido un numero
     *         <li>false: nos devuelve este valor cuando no hemos introducido un
     *         numero
     *         <ul>
     */
    public static boolean esNumero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * Método que imprime el menu de las opciones de nuestro programa principal
     */
    public static void printMenu() {
        System.out.println("\n****** MENU *******\n");
        System.out
                .println("1. Añadir palabra\n" + "2. Eliminar palabra por código\n" + "3. Eliminar palabra por nombre\n"
                        + "4. Mostrar palabras por idioma\n" + "5. Modificar palabra\n" + "6. Salir\n");
    }

    /**
     * Método que imprime el menu de los idiomas que hay en el diccionario
     */
    public static void printMenuIdioma() {
        System.out.println("\n****** Idioma *******\n");
        System.out.println("1. Castellano\n" + "2. Ingles\n" + "3. Frances\n" + "4. Italiano\n" + "5. Aleman\n");
    }

    /**
     * Este procedimiento añade a la hashtable una palabra en sus diferentes idiomas
     *
     * @param diccionario es una hashtable que contiene las diferentes palabras en
     *                    sus idiomas
     */
    public static void annadirPalabra(Hashtable<Integer, String> diccionario) {
        Scanner sc = new Scanner(System.in);
        String castellano = "";
        String ingles = "";
        String frances = "";
        String italiano = "";
        String aleman = "";
        System.out.println("introduce el numero de palabra que vas a ingresar");
        String cadena = sc.nextLine();

        // comprobamos que hemos introducido un numero, de no ser asi le pedimos de
        // nuevo q lo inserte
        while (!esNumero(cadena)) {
            System.out.println("no has insertado un numero, prueba de nuevo: ");
            cadena = sc.nextLine();
        }
        // el numero introducido por cadena lo pasamos a entero para introducirlo
        // despues en la hashtable
        int numero = Integer.parseInt(cadena);

        // pedimos y rellenamos las palabras en los diferentes idiomas
        System.out.println("introduce la palabra en castellano:");
        castellano = sc.nextLine();
        System.out.println("introduce la palabra en ingles:");
        ingles = sc.nextLine();
        System.out.println("introduce la palabra en frances:");
        frances = sc.nextLine();
        System.out.println("introduce la palabra en italiano:");
        italiano = sc.nextLine();
        System.out.println("introduce la palabra en aleman:");
        aleman = sc.nextLine();
        // si hay alguna palabra en su idioma vacía nos salimos al meno
        if (castellano.equals("") || ingles.equals("") || frances.equals("") || italiano.equals("")
                || aleman.equals("")) {
            System.out.println("las palabras se han introducido de forma errónea");
        } else {
            String informacion = castellano + ";" + ingles + ";" + frances + ";" + italiano + ";" + aleman;
            // añadimos a la hashtable las palabras en diferentes idiomas
            diccionario.put(numero, informacion);
        }

    }

    /**
     * Procedimiento que elimina todas las palabras en sus diferentes idiomas
     * asociadas al numero que insertamos
     *
     * @param diccionario es una hashtable que contiene las diferentes palabras en
     *                    sus idiomas
     */
    public static void eliminarCodigo(Hashtable<Integer, String> diccionario) {
        Scanner sc = new Scanner(System.in);
        if (diccionario.isEmpty()) {
            System.out.println("el diccionario esta vacío, no se puede eliminar palabras");
        } else {
            System.out.println("introduce el numero de de las palabras a eliminar");
            String cadena = sc.nextLine();
            while (!esNumero(cadena)) {
                System.out.println("no has insertado un numero, prueba de nuevo: ");
                cadena = sc.nextLine();
            }
            // el numero introducido por cadena lo pasamos a entero para introducirlo
            // después en la hashtable
            int numero = Integer.parseInt(cadena);
            if (!diccionario.containsKey(numero)) {
                System.out.println("ese número no existe en la hashtable");
            } else {
                diccionario.remove(numero);
                System.out.println("las palabras se han borrado correctamente");
            }

        }
    }

    /**
     * En este procedimiento introducimos el numero de las palabras asociadas y
     * modificamos según el idioma elegido
     *
     * @param diccionario es una hashtable que contiene las diferentes palabras en
     *                    sus idiomas
     */

    public static void modPalabra(Hashtable<Integer, String> diccionario) {
        Scanner sc = new Scanner(System.in);
        if (diccionario.isEmpty()) {
            System.out.println("no hay palabras para modificar");
        } else {
            System.out.println("introduce el numero donde se encuentran las palabras");
            String cadena = sc.nextLine();
            while (!esNumero(cadena)) {

                System.out.println("no has insertado un numero, prueba de nuevo: ");
                cadena = sc.nextLine();
            }
            // el numero introducido por cadena lo pasamos a entero para obtener las
            // palabras en la hashtable
            int numero = Integer.parseInt(cadena);

            if (!diccionario.containsKey(numero)) {
                System.out.println("no existen palabras asociadas a ese numero");
            } else {
                System.out.println("introduce el numero del idioma al que vas a modificar la palabra");
                try {
                    String castellano = "";
                    String ingles = "";
                    String frances = "";
                    String italiano = "";
                    String aleman = "";
                    printMenuIdioma();
                    int opcion = Integer.parseInt(sc.nextLine());
                    String informacion = diccionario.get(numero);
                    if (opcion > 0 && opcion < 6) {
                        StringTokenizer st = new StringTokenizer(informacion, ";");
                        castellano = st.nextToken();
                        ingles = st.nextToken();
                        frances = st.nextToken();
                        italiano = st.nextToken();
                        aleman = st.nextToken();
                        switch (opcion) {
                            case 1 -> {
                                System.out.println("introduce el nuevo significado");
                                castellano = sc.nextLine();
                                informacion = castellano + ";" + ingles + ";" + frances + ";" + italiano + ";" + aleman;
                                diccionario.remove(numero);
                                diccionario.put(numero, informacion);
                            }
                            case 2 -> {
                                System.out.println("introduce el nuevo significado");
                                ingles = sc.nextLine();
                                informacion = castellano + ";" + ingles + ";" + frances + ";" + italiano + ";" + aleman;
                                diccionario.remove(numero);
                                diccionario.put(numero, informacion);
                            }
                            case 3 -> {
                                System.out.println("introduce el nuevo significado");
                                frances = sc.nextLine();
                                informacion = castellano + ";" + ingles + ";" + frances + ";" + italiano + ";" + aleman;
                                diccionario.remove(numero);
                                diccionario.put(numero, informacion);
                            }
                            case 4 -> {
                                System.out.println("introduce el nuevo significado");
                                italiano = sc.nextLine();
                                informacion = castellano + ";" + ingles + ";" + frances + ";" + italiano + ";" + aleman;
                                diccionario.remove(numero);
                                diccionario.put(numero, informacion);
                            }
                            case 5 -> {
                                System.out.println("introduce el nuevo significado");
                                aleman = sc.nextLine();
                                informacion = castellano + ";" + ingles + ";" + frances + ";" + italiano + ";" + aleman;
                                diccionario.remove(numero);
                                diccionario.put(numero, informacion);
                            }
                        }
                    } else {
                        System.out.println("no has introducido la opción correcta");
                    }

                } catch (Exception e) {
                    System.out.println("datos introducidos incorrectamente");
                }

            }

        }
    }

    /**
     * Procedimiento que busca la palabra que le insertamos por teclado y si la
     * encuentra es borrada junto al resto de idiomas
     *
     * @param diccionario es una hashtable que contiene las diferentes palabras en
     *                    sus idiomas
     */
    public static void eliminaNombre(Hashtable<Integer, String> diccionario) {
        Scanner sc = new Scanner(System.in);
        int key;
        String informacion = "";
        String stPalabra = "";
        if (diccionario.isEmpty()) {
            System.out.println("el diccionario esta vacío");
        } else {
            System.out.println("introduce la palabra que quieres borrar");
            String palabra = sc.nextLine();

            List<Integer> lista = new ArrayList<Integer>(diccionario.keySet());
            for (int i = lista.size() - 1; i >= 0; i--) {
                // obtengo la key del diccionario
                key = lista.get(i);
                // obtengo los datos de esa key
                informacion = diccionario.get(key);
                StringTokenizer st = new StringTokenizer(informacion, ";");
                while (st.hasMoreTokens()) {
                    stPalabra = st.nextToken();
                    if (stPalabra.equals(palabra)) {
                        diccionario.remove(key);
                        System.out.println("las palabras se borraron correctamente");
                        break;
                    }
                }

            }
            System.out.println("la palabra no se encuentra en el diccionario");
        }
    }

    /**
     * Procedimiento donde elegimos un idioma y nos muestra solo las palabras de ese
     * idioma que se encuentran en el diccionario
     *
     * @param diccionario es una hashtable que contiene las diferentes palabras en
     *                    sus idiomas
     */
    public static void mostrarIdioma(Hashtable<Integer, String> diccionario) {
        Scanner sc = new Scanner(System.in);
        int key;
        String informacion = "";
        if (diccionario.isEmpty()) {
            System.out.println("el diccionario esta vacío");
        } else {
            try {
                printMenuIdioma();
                System.out.println("introduce el numero del idioma:");
                int opcion = Integer.parseInt(sc.nextLine());
                if (opcion > 0 && opcion < 6) {
                    switch (opcion) {
                        case 1:

                            List<Integer> lista = new ArrayList<Integer>(diccionario.keySet());
                            for (int i = lista.size() - 1; i >= 0; i--) {
                                // obtengo la key del diccionario
                                key = lista.get(i);
                                // obtengo los datos de esa key
                                informacion = diccionario.get(key);
                                StringTokenizer st = new StringTokenizer(informacion, ";");
                                String castellano = st.nextToken();
                                String ingles = st.nextToken();
                                String frances = st.nextToken();
                                String italiano = st.nextToken();
                                String aleman = st.nextToken();
                                System.out.println(castellano);
                            }
                            break;
                        case 2:
                            lista = new ArrayList<Integer>(diccionario.keySet());
                            for (int i = lista.size() - 1; i >= 0; i--) {
                                // obtengo la key del diccionario
                                key = lista.get(i);
                                // obtengo los datos de esa key
                                informacion = diccionario.get(key);
                                StringTokenizer st = new StringTokenizer(informacion, ";");
                                String castellano = st.nextToken();
                                String ingles = st.nextToken();
                                String frances = st.nextToken();
                                String italiano = st.nextToken();
                                String aleman = st.nextToken();
                                System.out.println(ingles);
                            }
                            break;
                        case 3:
                            lista = new ArrayList<Integer>(diccionario.keySet());
                            for (int i = lista.size() - 1; i >= 0; i--) {
                                // obtengo la key del diccionario
                                key = lista.get(i);
                                // obtengo los datos de esa key
                                informacion = diccionario.get(key);
                                StringTokenizer st = new StringTokenizer(informacion, ";");
                                String castellano = st.nextToken();
                                String ingles = st.nextToken();
                                String frances = st.nextToken();
                                String italiano = st.nextToken();
                                String aleman = st.nextToken();
                                System.out.println(frances);
                            }
                            break;
                        case 4:
                            lista = new ArrayList<Integer>(diccionario.keySet());
                            for (int i = lista.size() - 1; i >= 0; i--) {
                                // obtengo la key del diccionario
                                key = lista.get(i);
                                // obtengo los datos de esa key
                                informacion = diccionario.get(key);
                                StringTokenizer st = new StringTokenizer(informacion, ";");
                                String castellano = st.nextToken();
                                String ingles = st.nextToken();
                                String frances = st.nextToken();
                                String italiano = st.nextToken();
                                String aleman = st.nextToken();
                                System.out.println(italiano);
                            }
                            break;
                        case 5:
                            lista = new ArrayList<Integer>(diccionario.keySet());
                            for (int i = lista.size() - 1; i >= 0; i--) {
                                // obtengo la key del diccionario
                                key = lista.get(i);
                                // obtengo los datos de esa key
                                informacion = diccionario.get(key);
                                StringTokenizer st = new StringTokenizer(informacion, ";");
                                String castellano = st.nextToken();
                                String ingles = st.nextToken();
                                String frances = st.nextToken();
                                String italiano = st.nextToken();
                                String aleman = st.nextToken();
                                System.out.println(aleman);
                            }
                            break;

                    }
                } else {
                    System.out.println("introduccion no valida");
                }

            } catch (Exception e) {
                System.out.println("los datos se han introducido de manera erronea");
            }
        }
    }

    /**
     * Programa principal donde aparece un menu para elegir las diferentes opciones
     * que hemos creado y despues realizarlas
     */
    public static void main(String[] args) {

        Scanner sl = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        String apagar = "";
        boolean salir = false;
        int opcion;
        Hashtable<Integer, String> diccionario = new Hashtable<Integer, String>();

        while (!salir) {

            printMenu();
            try {
                System.out.print("Elije una opcion: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        annadirPalabra(diccionario);
                        break;
                    case 2:
                        eliminarCodigo(diccionario);
                        break;
                    case 3:
                        eliminaNombre(diccionario);
                        break;
                    case 4:
                        mostrarIdioma(diccionario);
                        break;
                    case 5:
                        modPalabra(diccionario);
                        break;
                    case 6:
                        System.out.println("¿Estas seguro de querer salir? s/n");
                        apagar = sl.nextLine();
                        while (!apagar.equals("s") && !apagar.equals("n")) {
                            System.out.println("la respuesta es incorrecta, prueba de nuevo s/n");
                            apagar = sl.nextLine();
                        }
                        if (apagar.equals("s")) {
                            salir = true;
                        }
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Error, elije una opcion del 1 al 6");
                sc.next();
            }
        }

    }

}
