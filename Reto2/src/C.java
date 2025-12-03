//C. HACIENDO EQUIPO

//Importamos Scanner
import java.util.Scanner;

public class C {

    public static void C (String[] args) {

        //Inicializamos variables
        Scanner scanner = new Scanner(System.in); //El Scanner
        String lineaProfesores; //Para guardar los nombres de los profesores
        String actividad; //Para guardar las actuvidades
        String[] profesores; //Los nombres de los profesores con espacios
        int totalProfesores = 0; //El numero de profesores

        //Variables para almacenar actividades y votos
        String[] actividades = new String[100];
        int[] votos = new int[100];
        int contadorActividades = 0;

        //Primero leemos la línea de profesores
        System.out.println("Introduce los nombres de los profesores (separados por espacios): ");
        lineaProfesores = scanner.nextLine();
        profesores = lineaProfesores.split(" ");
        totalProfesores = profesores.length;

        //Leemos las actividades
        System.out.println("Introduce las actividades en formato:");
        System.out.println("Actividad - Nombre Nombre Nombre");
        System.out.println("Cuando no quieras introducir más actividades escribe FIN");

        do {
            actividad = scanner.nextLine();

            if (!actividad.equalsIgnoreCase("FIN")) {

                //Separamos actividad de lista de profesores
                String[] partes = actividad.split(" - ");

                //Control de formato
                if (partes.length != 2) {
                    System.out.println("Formato incorrecto. Usa: Actividad - Profesor Profesor");
                    continue;
                }

                actividades[contadorActividades] = partes[0];

                //Contamos cuantos profesores votaron la actividad
                String[] votosProfes = partes[1].split(" ");
                votos[contadorActividades] = votosProfes.length;

                contadorActividades++;
            }

        } while (!actividad.equalsIgnoreCase("FIN"));

        //Comprobamos si han votado todos
        int votosTotales = 0;
        for (int i = 0; i < contadorActividades; i++) {
            votosTotales += votos[i];
        }

        if (votosTotales != totalProfesores * 2) {
            System.out.println("AUN NO HAN TERMINADO LAS VOTACIONES");
            return; //Finaliza el programa
        }

        //Elegimos las 2 actividades ganadoras
        int primero = -1, segundo = -1;

        for (int i = 0; i < contadorActividades; i++) {
            if (primero == -1 || votos[i] > votos[primero]) {
                segundo = primero;
                primero = i;
            } else if (segundo == -1 || votos[i] > votos[segundo]) {
                segundo = i;
            }
        }

        //Mostramos resultados
        System.out.println(actividades[primero]);
        System.out.println(actividades[segundo]);
    }
}
