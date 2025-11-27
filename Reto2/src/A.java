//A. SIEMPRE CON PRISA

import java.util.Scanner;
import java.util.InputMismatchException;

public class A {
    public static void A (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        int casos = 0;
        int pisos = 0;
        int altura = 0;
        int escalones = 0;
        boolean pasar = false;

        while (pasar != true) {
            System.out.print("Introduce el numero de casos que quieres comprobar: ");
            pasar = true;
            try {
                casos = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido. Introduce un número entero.");
                pasar = false;
                scanner.nextLine();
            }
        }
        String[] numerodecasos = new String[casos];

        do {
            while (pasar != false) {
                pasar = false;
                try {
                    scanner.nextLine();
                    System.out.println("Introduce el numero de pisos, la altura de cada piso en metros y el numero de escalones entre 2 pisos : ");
                    pisos = scanner.nextInt();
                    altura = scanner.nextInt();
                    escalones = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Valor no válido. Introduce un número entero.");
                    pasar = true;
                    scanner.nextLine();
                }
            }
            if (pisos * altura > Math.ceil(pisos * escalones / 2.0) + pisos) {
                numerodecasos[contador] = "Andando";
                contador++;
                scanner.nextLine();
            } else if (pisos * altura < Math.ceil(pisos * escalones / 2.0) + pisos) {
                numerodecasos[contador] = "Ascensor";
                contador++;
                scanner.nextLine();
            } else {
                numerodecasos[contador] = "Daría igual";
                contador++;
                scanner.nextLine();
            }
        }
        while (contador < casos);
        for (int j = 0; j < casos; j++) {
            System.out.println(numerodecasos[j]);
        }
    }

}
