//H. DENTRO DEL LABERINTO

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("=== DENTRO DEL LABERINTO ===");
            System.out.println("Introduce el número de filas y columnas del laberinto (por ejemplo: 3 5):");
            int filas = sc.nextInt();
            int columnas = sc.nextInt();
            sc.nextLine(); // limpiar salto de línea

            char[][] lab = new char[filas][columnas];

            System.out.println("Ahora introduce el laberinto, una fila por línea.");
            System.out.println("Usa '.' para camino y 'X' para pared, sin espacios.");
            int f = 0;
            while (f < filas) {
                System.out.println("Fila " + (f + 1) + ":");
                String linea = sc.nextLine().trim();
                lab[f] = linea.toCharArray();
                f = f + 1;
            }

            boolean sePuedeSalir = hayCamino(lab);

            if (sePuedeSalir) {
                System.out.println("Resultado: SI se puede salir del laberinto.");
            } else {
                System.out.println("Resultado: NO se puede salir del laberinto.");
            }

        } catch (Exception e) {
            System.out.println("Error en los datos del laberinto: " + e.getMessage());
        }
    }

    // Método que determina si hay camino desde (0,0) hasta (F-1,C-1)
    private static boolean hayCamino(char[][] lab) {
        int F = lab.length;
        int C = lab[0].length;

        // Comprobar si inicio o fin están bloqueados
        if (lab[0][0] == 'X') {
            return false;
        }
        if (lab[F - 1][C - 1] == 'X') {
            return false;
        }

        // BFS para encontrar camino desde (0,0) hasta (F-1,C-1)
        boolean[][] visitado = new boolean[F][C];
        Queue<int[]> cola = new LinkedList<>();

        visitado[0][0] = true;
        cola.add(new int[]{0, 0});

        // Movimientos posibles: abajo, arriba, derecha, izquierda
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        boolean encontrado = false;

        // Bucle principal de BFS siglas de Breadth-First Search que hace referencia a un algoritmo de búsqueda en grafos o árboles que explora todos los nodos vecinos en el nivel actual antes de pasar al siguiente nivel.
        while (!cola.isEmpty() && !encontrado) {
            int[] pos = cola.poll();
            int r = pos[0];
            int c = pos[1];

            if (r == F - 1 && c == C - 1) {
                encontrado = true;
            } else {
                int i = 0;
                while (i < 4) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr >= 0 && nr < F && nc >= 0 && nc < C) {
                        if (!visitado[nr][nc] && lab[nr][nc] == '.') {
                            visitado[nr][nc] = true;
                            cola.add(new int[]{nr, nc});
                        }
                    }
                    i = i + 1; // siguiente dirección
                }
            }
        }

        return encontrado; // si se ha encontrado camino hasta la salida
    }
}
