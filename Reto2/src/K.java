//k. numeros harshad

import java.util.Scanner;
import java.util.InputMismatchException;

public class K {

    public static void K(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = 0;
        int M = 0;
        boolean terminar = false;
        boolean pasar;

        // este bucle permite ir metiendo varios rangos hasta poner 0 0
        do {

            pasar = true;
            System.out.println("introduce dos números n y m (0 0 para terminar):");

            try {
                N = scanner.nextInt();
                M = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("entrada no válida, escribe números enteros");
                pasar = false;
                scanner.nextLine();
            }

            if (pasar == true) {

                // si el usuario pone 0 0, ya no se hace nada más
                if (N == 0 && M == 0) {
                    terminar = true;
                } else {

                    // aquí guardaremos la mejor secuencia encontrada
                    int mejorInicio = -1;
                    int mejorLongitud = 0;

                    // aquí tenemos la secuencia que estamos contando ahora mismo
                    int actualInicio = -1;
                    int actualLongitud = 0;

                    // revisamos cada número entre n y m
                    for (int x = N; x <= M; x++) {

                        // sumamos las cifras del número
                        int temp = x;
                        int suma = 0;
                        while (temp > 0) {
                            suma += (temp % 10);
                            temp /= 10;
                        }

                        // comprobamos si es harshad
                        boolean esHarshad = false;
                        if (suma != 0) {
                            if (x % suma == 0) {
                                esHarshad = true;
                            }
                        }

                        // si el número es harshad, seguimos aumentando la secuencia
                        if (esHarshad == true) {

                            // si empezamos una secuencia nueva
                            if (actualLongitud == 0) {
                                actualInicio = x;
                            }

                            actualLongitud = actualLongitud + 1;

                        } else {

                            // si deja de ser harshad, comprobamos si la secuencia era la mejor
                            if (actualLongitud > 0) {

                                if (actualLongitud > mejorLongitud) {
                                    mejorLongitud = actualLongitud;
                                    mejorInicio = actualInicio;
                                } else if (actualLongitud == mejorLongitud) {
                                    // si son iguales, nos quedamos con la que empieza antes
                                    if (actualInicio < mejorInicio) {
                                        mejorInicio = actualInicio;
                                    }
                                }

                                // reiniciamos la secuencia actual
                                actualLongitud = 0;
                                actualInicio = -1;
                            }
                        }
                    }

                    // por si la secuencia más larga termina justo al final del rango
                    if (actualLongitud > 0) {

                        if (actualLongitud > mejorLongitud) {
                            mejorLongitud = actualLongitud;
                            mejorInicio = actualInicio;
                        } else if (actualLongitud == mejorLongitud) {
                            if (actualInicio < mejorInicio) {
                                mejorInicio = actualInicio;
                            }
                        }
                    }

                    // mostramos el resultado
                    if (mejorLongitud == 0) {
                        System.out.println("no hay ninguno");
                    } else {
                        int fin = mejorInicio + mejorLongitud - 1;

                        for (int z = mejorInicio; z <= fin; z++) {
                            System.out.print(z);
                            if (z < fin) {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                }
            }

        } while (terminar == false);
    }
}
