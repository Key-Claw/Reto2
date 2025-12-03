//E. QUIERO SER UNA ESTRELLA DE ROCK

//Importamos Scanner e IME (Pa acortar ImputMismatchException)
import java.util.Scanner;
import java.util.InputMismatchException;

public class E {

    public static void E(String[] args) {

        //Inicializamos scanner
        Scanner scanner = new Scanner(System.in);
        boolean pasar = true;

        //Sonidos válidos
        String[] sonidosValidos = {"TARARA", "TERERE", "TIRIRI", "TORORO", "TURURU"};

        String entrada = "";

        //Leemos la canción
        do {
            pasar = true;
            try {
                System.out.println("Introduce la canción tarareada:");
                entrada = scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error en la entrada, vuelve a introducirla");
                pasar = false;
                scanner.nextLine();
            }
        } while (pasar == false);

        //Separamos palabras
        String[] palabras = entrada.split(" ");

        //Array para almacenar la canción corregida
        String[] salida = new String[palabras.length];
        int contador = 0;

        for (int i = 0; i < palabras.length; i++) {

            boolean esValida = false;

            //Comprobamos si es uno de los sonidos válidos
            for (int j = 0; j < sonidosValidos.length; j++) {
                if (palabras[i].equals(sonidosValidos[j])) {
                    esValida = true;
                }
            }

            //Solo se procesa si es un sonido permitido
            if (esValida == true) {

                boolean sePuedeAñadir = true;

                //Si ya hay al menos 2 palabras, comprobamos repetición
                if (contador >= 2) {

                    String p1 = salida[contador - 1];
                    String p2 = salida[contador - 2];

                    //Si ya existen dos iguales seguidas, no añadimos la tercera
                    if (p1.equals(palabras[i]) && p2.equals(palabras[i])) {
                        sePuedeAñadir = false;
                    }
                }

                //Si se puede añadir, se guarda en el array salida
                if (sePuedeAñadir == true) {
                    salida[contador] = palabras[i];
                    contador++;
                }
            }
        }

        //Enseñamos el resultado
        for (int i = 0; i < contador; i++) {
            System.out.print(salida[i]);
            if (i < contador - 1) {
                System.out.print(" ");
            }
        }
    }
}
