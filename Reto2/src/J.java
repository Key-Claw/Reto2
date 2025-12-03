// J. FELIZ 2024

import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("=== FELIZ 2025 - NÚMEROS CÚBICOS ===");

            boolean continuar = true; // variable boleana para controlar el bucle en vez de usar brack

            while (continuar) { // Primer acepta la información para que entre
                System.out.println("Introduce un año entre 2000 y 2999 (0 para salir):");
                int anio = sc.nextInt();

                if (anio == 0) {
                    continuar = false;
                } else {
                    procesarAnio(anio);
                }
            }

            System.out.println("Programa terminado.");

        } catch (Exception e) {
            System.out.println("Error en la entrada: " + e.getMessage());
        }
    }


    private static void procesarAnio(int n) {
        boolean encontrado = false;
        int inicio = -1;
        int fin = -1;

        int a = 1;
        while (a * a * a <= n && !encontrado) {  // mientras el cubo de a sea menor o igual a n
            int suma = 0;
            int b = a;
            boolean terminarInterno = false;

            while (!terminarInterno) { // mientras no se haya terminado el bucle interno
                int cubo = b * b * b;
                suma = suma + cubo;

                if (suma == n) {
                    encontrado = true;
                    inicio = a;
                    fin = b;
                    terminarInterno = true;
                } else if (suma > n) {
                    terminarInterno = true;
                } else {
                    b = b + 1;
                }
            }

            if (!encontrado) { // solo incrementa a si no se ha encontrado la solución
                a = a + 1;
            }
        }

        if (encontrado) { // si se ha encontrado una solución
            System.out.println("El año " + n + " ES cúbico: " + inicio + " ... " + fin);
        } else {
            System.out.println("El año " + n + " NO es cúbico (NO CUBICO).");
        }
    }
}
