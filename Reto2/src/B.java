// B. ORDENANDO LOS APUNTES

import java.util.HashMap;               // para usar mapas de hash que se usan en memoria para relacionar temas
import java.util.Map;                   // para usar mapas de clave-valor que se usan en memoria para relacionar temas
import java.util.Scanner;               // para leer entrada

public class B {

    public static void main(String[] args) {
        try {   // manejo de excepciones
            Scanner sc = new Scanner(System.in);

            System.out.println("=== ORDENANDO LOS APUNTES ===\n");
            System.out.println("Este programa reconstruye el orden correcto de los temas.");
            System.out.println("Vas a introducir los datos en tres pasos:");
            System.out.println("  1) El primer tema.");
            System.out.println("  2) El numero de parejas de temas.");
            System.out.println("  3) Cada pareja en formato TEMA1-TEMA2.\n");

            // Primer tema
            System.out.println("Escribe el PRIMER tema del examen");
            System.out.println("Ejemplo: LA EDAD MEDIA");
            System.out.print("Primer tema: ");
            String primerTema = sc.nextLine().trim(); // puede contener espacios

            // Fragmentos
            System.out.println();
            System.out.println("Escribe cuantas parejas de temas tienes");
            System.out.println("Debe ser un numero entero positivo.");
            System.out.print("Numero de parejas: ");
            int n = Integer.parseInt(sc.nextLine().trim());

            // Mapa que relaciona un tema con el siguiente
            Map<String, String> siguiente = new HashMap<>(); // clave: tema1, valor: tema2

            // Pareja de temas
            System.out.println();
            System.out.println("Introduce cada pareja de temas.");
            System.out.println("Formato obligatorio: TEMA1-TEMA2");
            System.out.println("Ejemplo: LA EDAD MEDIA-REVOLUCION LIBERAL");
            System.out.println();

            int contador = 0;
            while (contador < n) { // leer cada pareja
                System.out.println("Pareja " + (contador + 1) + ":");
                String par = sc.nextLine().trim();

                // Comprobacion basica de formato
                if (!par.contains("-")) {
                    System.out.println("Error: la pareja debe contener un guion '-' entre los dos temas.");
                    System.out.println("Vuelve a escribir la pareja con el formato correcto.");
                    System.out.println();
                    continue; // no aumento contador, repetimos esta pareja
                }

                int pos = par.indexOf('-');
                String t1 = par.substring(0, pos).trim();
                String t2 = par.substring(pos + 1).trim();

                if (t1.isEmpty() || t2.isEmpty()) { // comprobar que ambos temas tienen texto
                    System.out.println("Error: los dos temas deben tener texto a ambos lados del guion.");
                    System.out.println("Vuelve a escribir la pareja con el formato correcto.");
                    System.out.println();
                    continue;
                }

                // Almacenar la relacion t1 -> t2
                siguiente.put(t1, t2);
                contador = contador + 1;
            }

            System.out.println("\nReconstruyendo el orden de los temas...\n");

            // Reconstruir la secuencia de temas
            String temaActual = primerTema;
            StringBuilder resultado = new StringBuilder();

            boolean continuar = true;
            boolean primero = true;

            while (continuar) {
                // Añadimos el tema actual al resultado
                if (!primerTema.equals(temaActual) || primero) {
                    if (!primero) {
                        resultado.append(",");
                    }
                    resultado.append(temaActual);
                    primero = false;
                }

                // Pasamos al siguiente tema si existe
                if (siguiente.containsKey(temaActual)) {
                    temaActual = siguiente.get(temaActual);
                } else {
                    continuar = false; // ya no hay mas temas
                }
            }

            System.out.println("Orden correcto de los temas:");
            System.out.println(resultado.toString());

            sc.close();
        } catch (Exception e) { // captura de cualquier error
            System.out.println("Ha ocurrido un error leyendo los datos: " + e.getMessage()); // mensaje de error
        }
    }
}


/*
 En este ejercicio se reconstruye el orden correcto de los temas de un examen a partir de parejas de temas desordenadas.
 Ha requerido un exceso de busqueda de información y muchas ayudas dada mi falta de experiencia en el manejo de estructuras de datos como mapas.
 */