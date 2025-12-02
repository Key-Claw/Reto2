/**B. ORDENANDO LOS APUNTES
 * Mala época la de los exámenes cuando eres estudiante. Diana sabe
 * muy bien lo que es eso porque está estudiando 2a Bachillerato y el
 * miércoles tiene examen de Historia.
 *
 * Ella es muy aplicada y ya ha empezado a estudiar. Pero justo cuando
 * empezaba, se ha dado cuenta de que tiene los apuntes totalmente
 * desordenados. Sabe cuál es el primer tema del examen y ha
 * encontrado, entre sus papeles, anotaciones desordenadas de qué
 * tema va después del tema justo anterior.
 *
 * Así que su primera labor antes de ponerse a estudiar va a ser saber en qué orden debería estudiarse
 * todo. Le gusta la programación y se estaba ahora mismo preguntando si ya existirá un programa que
 * permita introducir el primer tema y todos esos fragmentos desordenados de parejas de temas, para que
 * le muestre el orden de todos ellos. Sería muy práctico ahora mismo. ¿Valdrá la pena hacerlo en lugar de
 * ordenar a mano todo ese jaleo?
 *
 * Entrada:
 * Como entrada se recibe el primer tema en la primera línea. A continuación se recibe el número de
 * fragmentos desordenados de parejas de temas. Después de eso, se reciben las parejas de temas que
 * sabe que van seguidos. Una de esas parejas de temas siempre tendrá, como primer tema, el que se ha
 * indicado en la primera línea de la entrada.
 *
 * Salida:
 * La salida mostrará el orden correcto de todos los temas en una sola línea
 * Entrada de ejemplo
 * LA EDAD MEDIA
 * 4
 * GUERRA COLONIAL-LA SEGUNDA REPUBLICA
 * EL SEXENIO REVOLUCIONARIO-GUERRA COLONIAL
 * REVOLUCION LIBERAL-EL SEXENIO REVOLUCIONARIO
 * LA EDAD MEDIA-REVOLUCION LIBERAL
 *
 * Salida de ejemplo:
 * LA EDAD MEDIA,REVOLUCION LIBERAL,EL SEXENIO REVOLUCIONARIO,GUERRA
 * COLONIAL,LA SEGUNDA REPUBLICA
 * * La salida de ejemplo es una sola línea
 */

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el primer tema
        String primerTema = scanner.nextLine();
        int numerosPares = Integer.parseInt(scanner.nextLine());

        // Array para almacenar el orden de los temas
        String[] temaAnterior = new String[numerosPares];
        String[] temaSiguiente = new String[numerosPares];

        // Leer los pares de temas y construir el orden
        for (int i = 0; i < numerosPares; i++) {
            String line = scanner.nextLine();
            String[] pares = line.split("-", 2);

            temaAnterior[i] = pares[0];
            temaSiguiente[i] = (pares.length > 1) ? pares[1] : ""; // Manejar caso donde no hay segundo tema
        }

        // Array para almacenar el orden completo de los temas
        String[] temaOrdenados = new String[numerosPares + 1];
        temaOrdenados[0] = primerTema;

        // Construir el orden completo de los temas
        boolean continuar = true;

        for (int posicion = 0; posicion < numerosPares && continuar; posicion++) {

            String temaActual = temaOrdenados[posicion];
            int indiceEncontrado = -1;
            boolean encontrado = false; // Romper el bucle interno cuando se encuentra el tema

            // Buscar el siguiente tema correspondiente al tema actual
            for (int i = 0; i < numerosPares; i++) {

                if (temaAnterior[i] != null && temaAnterior[i].equals(temaActual) && !encontrado) {
                    indiceEncontrado = i;
                    encontrado = true; // Romper el bucle interno
                }
            }

            // Detenemos proceso si no se encuentra el siguiente tema
            if (indiceEncontrado == -1) {
                continuar = false; // Romper el bucle exterior
            } else{
                temaOrdenados[posicion + 1] = temaSiguiente[indiceEncontrado];
            }

        }

        // Construir la salida en el formato requerido
        StringBuilder salida = new StringBuilder(); // StringBuilder sirve para construir cadenas de texto de forma eficiente
        boolean esPrimero = true;

        for (String tema : temaOrdenados) {
            if (tema != null) { // Evitar temas nulos
                if (esPrimero) {
                    salida.append(tema);
                    esPrimero = false; // Ya no es el primero
                } else {
                    salida.append(",").append(tema);
                    esPrimero = false; // Ya no es el primero
                }
            }
        }

        System.out.println(salida.toString());

        scanner.close();
    }
}
