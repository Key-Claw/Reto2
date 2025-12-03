//D. PREPARANDO LA COMIDA

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("=== PREPARANDO LA COMIDA ===");
            System.out.println("Introduce la hora de inicio en formato H:MM (por ejemplo, 15:30):");
            String horaInicio = sc.nextLine().trim();

            System.out.println("¿Cuántos pasos tiene la receta?");
            int numPasos = Integer.parseInt(sc.nextLine().trim());

            int puntos = horaInicio.indexOf(':');
            int h = Integer.parseInt(horaInicio.substring(0, puntos));
            int m = Integer.parseInt(horaInicio.substring(puntos + 1));
            int inicioMin = h * 60 + m;

            int tiempoPersona1 = inicioMin;
            int tiempoPersona2 = inicioMin;

            System.out.println("Ahora introduce cada paso en una línea.");
            System.out.println("Formato: descripción (con espacios) y duración al final, en minutos.");
            System.out.println("Ejemplo: cocer la pasta 15");

            int contador = 0;
            while (contador < numPasos) {
                System.out.println("Paso " + (contador + 1) + ":");
                String linea = sc.nextLine();
                String[] partes = linea.trim().split("\\s+"); // \\s+ para separar por espacios
                String ultima = partes[partes.length - 1];
                int duracion = Integer.parseInt(ultima);

                if (tiempoPersona1 <= tiempoPersona2) {
                    tiempoPersona1 = tiempoPersona1 + duracion;
                } else {
                    tiempoPersona2 = tiempoPersona2 + duracion;
                }

                contador = contador + 1;
            }

            int fin = tiempoPersona1;
            if (tiempoPersona2 > fin) {
                fin = tiempoPersona2;
            }

            int horaFin = fin / 60;
            int minFin = fin % 60;

            System.out.println();
            System.out.println("La comida estará lista a las: " + horaFin + ":" + String.format("%02d", minFin));

        } catch (Exception e) {
            System.out.println("Error en los datos introducidos: " + e.getMessage());
        }
    }
}
