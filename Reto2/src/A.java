//A. SIEMPRE CON PRISA

//Importamos el Scanner y el InputMismatchException (Para el try catch)
import java.util.Scanner;
import java.util.InputMismatchException;

public class A {
    public static void A (String[] args) {

        //Inicializamos variables
        Scanner scanner = new Scanner(System.in);
        int contador = 0; //Para llevar la cuenta del numero de comprobaciones realizadas
        int casos = 0; //El numero total de casos
        int pisos = 0; //El numero de pisos introducido por el usuario
        int altura = 0; //La altura entre pisos introducida por el ususairo
        int escalones = 0; //Los escalones entre pisos introducidos por el usuasrio
        boolean pasar;

        //Bucle para preguntarle al usuario cuantos casos quiere comprobar
        do {
            System.out.print("Introduce el numero de casos que quieres comprobar: ");
            //Convertimos pasar a true para marcar el fin del try si no hay erroes.
            pasar = true;
            //Try catch para evitar errores
            try {
                casos = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido. Introduce un número entero.");
                //Convertimos pasar a falso para que se repita el bucle en caso de error encontrado.
                pasar = false;
                //Limpiamos el scanner
                scanner.nextLine();
            }
        }
        while (pasar != true);

        //Creamos el String para almacenar los casos
        String[] numerodecasos = new String[casos];

        //Bucle para almacenar los resultados dentro del String
        do {
            //Bucle para preguntarle al usuario los datos necesarios.
            do {

                //Convertimos pasar a falso para marcar el fin del try si no hay erroes.
                pasar = false;

                //Try catch para evitar errores
                try {
                    scanner.nextLine();
                    System.out.println("Introduce el numero de pisos, la altura de cada piso en metros y el numero de escalones entre 2 pisos : ");
                    pisos = scanner.nextInt();
                    altura = scanner.nextInt();
                    escalones = scanner.nextInt();

                } catch (InputMismatchException e) {
                    System.out.println("Valor no válido. Introduce un número entero.");
                    //Convertimos pasar a true para que se repita el bucle en caso de error encontrado.
                    pasar = true;
                    //Limpiamos el scanner
                    scanner.nextLine();
                }
            }
            //Cerramos el bucle de las preguntas bucle
            while (pasar != false);

            //Aquí hacemos una serie de ifs para determinar que respuesta hay que darle al usuario
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
        //Cerramos el bucle de los casos una vez el contardor supera a los casos
        while (contador < casos);

        //Bucle para mostrar los resultados
        for (int j = 0; j < casos; j++) {
            System.out.println(numerodecasos[j]);
        }
    }

}
