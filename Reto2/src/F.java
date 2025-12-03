// F. ORGANIZANDO VUELTAS CICLISTAS

import java.util.HashMap;   // para usar HashMap
import java.util.Map;       // para usar Map
import java.util.Scanner;   // para leer entrada

public class F {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("=== ORGANIZANDO VUELTAS CICLISTAS ===");
            System.out.println("Primero introduce la etapa PROLOGO (tipo y kilómetros).");
            System.out.println("Ejemplo: PROLOGO 50");

            String lineaPrologo = sc.nextLine().trim();
            String[] partesPrologo = lineaPrologo.split("\\s+");
            String tipoPrologo = partesPrologo[0];
            int kmPrologo = Integer.parseInt(partesPrologo[1]);

            int totalKm = kmPrologo;
            int etapasAceptadas = 0; // sin contar PROLOGO y FIN
            Map<String, Integer> kmPorTipo = new HashMap<>(); // clave: tipo, valor: kms acumulados

            boolean finIntroducido = false;

            System.out.println("Ahora ve introduciendo el resto de etapas, una por línea.");
            System.out.println("Formato: TIPO KMS (ej: PLANA 120)");
            System.out.println("Cuando quieras indicar la última etapa, escribe FIN 50 (por ejemplo).");

            while (!finIntroducido) {
                System.out.println("Introduce una etapa (o FIN 50 para terminar):");
                String linea = sc.nextLine().trim();

                if (linea.length() == 0) {
                    // línea vacía, simplemente pedimos otra
                } else {
                    String[] partes = linea.split("\\s+");
                    String tipo = partes[0];
                    int kms = Integer.parseInt(partes[1]);

                    if (tipo.equals("FIN")) {
                        totalKm = totalKm + kms;
                        finIntroducido = true;
                    } else {
                        boolean ok = true;

                        if (kms > 200) {
                            ok = false;
                        }

                        int ya = 0;
                        if (kmPorTipo.containsKey(tipo)) {  // si ya hay kms de este tipo
                            ya = kmPorTipo.get(tipo);
                        }

                        if (ok) {
                            int nuevoTotalTipo = ya + kms;
                            if (nuevoTotalTipo > 300) {
                                ok = false;
                            }
                        }

                        if (ok) {
                            int totalEtapasSiAcepto = etapasAceptadas + 1 + 2; // + PROLOGO y FIN
                            if (totalEtapasSiAcepto > 10) {
                                ok = false;
                            }
                        }

                        if (ok) {
                            System.out.println("Esta etapa se ACEPTA (OK).");
                            kmPorTipo.put(tipo, ya + kms);
                            etapasAceptadas = etapasAceptadas + 1;
                            totalKm = totalKm + kms;
                        } else {
                            System.out.println("Esta etapa se RECHAZA (KO).");
                        }
                    }
                }
            }

            int totalEtapas = etapasAceptadas + 2; // PROLOGO y FIN

            System.out.println();
            System.out.println("Kilómetros totales (incluyendo PROLOGO y FINAL aceptados): " + totalKm);
            System.out.println("Número total de etapas (incluyendo PROLOGO y FINAL): " + totalEtapas);

        } catch (Exception e) {
            System.out.println("Error en la entrada: " + e.getMessage());
        }
    }
}
