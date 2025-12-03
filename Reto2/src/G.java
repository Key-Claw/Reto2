//G. CUANTOS AÑOS TIENES

//Importamos Scanner e IME
import java.util.Scanner;
import java.util.InputMismatchException;

public class G {

    public static void G(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nacimiento = 0;
        int actual = 0;
        boolean terminar = false;
        boolean pasar;

        //Bucle principal
        do {
            pasar = true;
            try {
                nacimiento = scanner.nextInt();
                actual = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Introduce dos enteros.");
                pasar = false;
                scanner.nextLine(); // limpiamos
            }

            //Si la lectura fue inválida, repetimos
            if (pasar == true) {

                //Comprobamos si es la línea final
                if (nacimiento == 0 && actual == 0) {
                    terminar = true;   //finalizar programa
                } else {

                    //Cálculo de edades
                    int edadMax = actual - nacimiento;
                    int edadMin = edadMax - 1;

                    if (edadMin < 0) {
                        edadMin = 0;
                    }

                    //Salida
                    System.out.println(edadMin + "-" + edadMax);
                }
            }

        } while (terminar == false);
    }
}
