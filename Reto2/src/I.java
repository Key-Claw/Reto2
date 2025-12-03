//I. EL AMIGO ALEMAN

//importamos el scanner y el inputmismatchexception
import java.util.Scanner;
import java.util.InputMismatchException;

public class I {

    public static void I(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int casos = 0;
        boolean pasar;

        // pedimos al usuario cuántas frases va a introducir
        do {
            pasar = true;
            try {
                System.out.print("introduce el número de casos: ");
                casos = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("valor no válido, escribe un número entero");
                pasar = false;
                scanner.nextLine();
            }
        } while (pasar == false);

        scanner.nextLine(); // limpiamos el salto de línea

        String[] resultados = new String[casos];
        int contadorCasos = 0;

        // procesamos cada caso
        while (contadorCasos < casos) {

            System.out.println("introduce la frase del caso " + (contadorCasos + 1) + ":");
            String frase = scanner.nextLine();

            // separamos la frase en palabras
            String[] palabras = frase.split(" ");

            String salida = "";
            int longitud;

            // revisamos cada palabra
            for (int i = 0; i < palabras.length; i++) {

                String palabraOriginal = palabras[i];
                String palabraMayus = palabraOriginal.toUpperCase(); // se mostrará en mayúsculas

                longitud = palabraMayus.length();

                boolean añadir = false;

                // contadores para vocales seguidas y consonantes seguidas
                int seguidasV = 0;
                int seguidasC = 0;

                // revisamos cada letra de la palabra
                for (int j = 0; j < longitud; j++) {

                    char letra = palabraMayus.charAt(j);

                    // comprobamos si es vocal
                    boolean esVocal =
                            letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U';

                    // comprobamos si es una letra del abecedario
                    boolean esLetra =
                            (letra >= 'A' && letra <= 'Z');

                    // si es letra, actualizamos contadores
                    if (esLetra) {
                        if (esVocal) {
                            seguidasV = seguidasV + 1;
                            seguidasC = 0;      // al ser vocal, reiniciamos consonantes
                        } else {
                            seguidasC = seguidasC + 1;
                            seguidasV = 0;      // al ser consonante, reiniciamos vocales
                        }
                    } else {
                        // si no es letra, reiniciamos todo
                        seguidasV = 0;
                        seguidasC = 0;
                    }

                    // si aparecen 4 vocales seguidas o 4 consonantes seguidas, la palabra se guarda
                    if (seguidasV >= 4 || seguidasC >= 4) {
                        añadir = true;
                    }
                }

                // añadimos la palabra a la salida si cumple la condición
                if (añadir == true) {

                    if (salida.equals("")) {
                        salida = palabraMayus;
                    } else {
                        salida = salida + " " + palabraMayus;
                    }
                }
            }

            // si ninguna palabra cumple, se indica
            if (salida.equals("")) {
                salida = "Ninguna";
            }

            // guardamos el resultado del caso
            resultados[contadorCasos] = salida;
            contadorCasos++;
        }

        // mostramos todos los resultados
        for (int i = 0; i < casos; i++) {
            System.out.println(resultados[i]);
        }
    }
}
