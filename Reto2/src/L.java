// L. QUEDANDO CON LA CUADRILLA

import java.util.Scanner;

public class L {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("=== QUEDANDO CON LA CUADRILLA ===");
            System.out.println("¿Cuántos amigos sois en la cuadrilla? ");
            int n = sc.nextInt();

            long[] dias = new long[n];
            int i = 0;
            while (i < n) { // leemos cada cuánto libra cada amigo
                System.out.println("Introduce cada cuántos días libra el amigo " + (i + 1) + ":");
                dias[i] = sc.nextLong();
                i = i + 1;
            }

            long resultado = dias[0];
            int j = 1;
            while (j < n) {  // calculamos el mcm de todos los días
                resultado = mcm(resultado, dias[j]);
                j = j + 1;
            }

            if (resultado > 365L) { // límite razonable la "L" es para indicar que es un long
                System.out.println("La cuadrilla al completo no va a poder quedar...");
            } else {
                System.out.println("Podréis volver a quedar todos juntos dentro de " + resultado + " días.");
            }

        } catch (Exception e) {
            System.out.println("Error al introducir los datos: " + e.getMessage());
        }
    }

    private static long mcm(long a, long b) { // mínimo común múltiplo
        long g = mcd(a, b);
        long res = a / g * b;
        return res;
    }

    private static long mcd(long a, long b) { // máximo común divisor
        long x = a; // long para evitar overflow el -> overflow es cuando el número es demasiado grande para el tipo de dato
        long y = b;
        boolean seguir = true;

        while (seguir) { // algoritmo de Euclides significa que el mcd de a y b es igual al mcd de b y el resto de a dividido entre b
            if (y == 0) {
                seguir = false;
            } else {
                long temp = x % y;
                x = y;
                y = temp;
            }
        }

        return x;
    }
}
