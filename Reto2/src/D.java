// D. PREPARANDO LA COMIDA

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        try { // capturar errores
            Scanner sc = new Scanner(System.in);

            System.out.println("=== PREPARANDO LA COMIDA ===");
            System.out.println("Introduce la hora de inicio en formato H:MM (ejemplo: 15:30):");
            String horaInicio = sc.nextLine().trim();

            System.out.println("¿Cuántos pasos tiene la receta?");
            int numPasos = Integer.parseInt(sc.nextLine().trim());

            int puntos = horaInicio.indexOf(':'); // encontrar el índice de los dos puntos
            int h = Integer.parseInt(horaInicio.substring(0, puntos));
            int m = Integer.parseInt(horaInicio.substring(puntos + 1));
            int inicioMin = h * 60 + m; // convertir a minutos desde medianoche

            // Tiempos actuales de cada persona
            int tiempoPersona1 = inicioMin;
            int tiempoPersona2 = inicioMin;

            System.out.println("Ahora introduce cada paso en una línea.");
            System.out.println("Descripción (con espacios) y duración al final, en minutos.");
            System.out.println("Ejemplo: cocer la pasta 15");

            int contador = 0;
            while (contador < numPasos) {  // leer cada paso
                System.out.println("Paso " + (contador + 1) + ":");
                String linea = sc.nextLine();
                String[] partes = linea.trim().split("\\s+"); // \\s+ para separar por espacios
                String ultima = partes[partes.length - 1];
                int duracion = Integer.parseInt(ultima);

                if (tiempoPersona1 <= tiempoPersona2) { // asignar al que termine antes
                    tiempoPersona1 = tiempoPersona1 + duracion;
                } else {
                    tiempoPersona2 = tiempoPersona2 + duracion;
                }

                contador = contador + 1; // aumentar el contador
            }

            // Calcular la hora de finalización
            int fin = tiempoPersona1;
            if (tiempoPersona2 > fin) {
                fin = tiempoPersona2;
            }

            int horaFin = fin / 60; // horas
            int minFin = fin % 60;  // minutos

            System.out.println();
            System.out.println("La comida estará lista a las: " + horaFin + ":" + String.format("%02d", minFin));

        } catch (Exception e) { // capturar errores
            System.out.println("Error en los datos introducidos: " + e.getMessage()); // mostrar mensaje de error
        }
    }
}
