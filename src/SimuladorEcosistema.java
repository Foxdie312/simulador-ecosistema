import java.util.Random;

public class SimuladorEcosistema {
    public static void main(String[] args) {
        char[][] ecosistema = new char[20][20];
        Random random = new Random();

        // Inicializar ecosistema
        for (int lector1 = 0; lector1 < 20; lector1++) {
            for (int lector2 = 0; lector2 < 20; lector2++) {
                double prob = random.nextDouble();
                if (prob < 0.1) ecosistema[lector1][lector2] = 'A'; // Árbol
                else if (prob < 0.2) ecosistema[lector1][lector2] = 'H'; // Hierba
                else ecosistema[lector1][lector2] = ' '; // Vacío
            }
        }

        // Simulación por 20 días
        for (int dia = 1; dia <= 20; dia++) {
            System.out.println("Día " + dia);
            
            // Mostrar ecosistema
            for (int lector3 = 0; lector3 < 20; lector3++) {
                for (int lector4 = 0; lector4 < 20; lector4++) {
                    System.out.print(ecosistema[lector3][lector4] + " ");
                }
                System.out.println();
            }

            // Actualizar ecosistema
            char[][] nuevoEcosistema = new char[20][20];
            for (int lector5 = 0; lector5 < 20; lector5++) {
                for (int lector6 = 0; lector6 < 20; lector6++) {
                    // Contar vecinos (integrado directamente aquí)
                    int vecinos = 0;
                    for (int relector1 = -1; relector1 <= 1; relector1++) {
                        for (int relector2 = -1; relector2 <= 1; relector2++) {
                            if (relector1 == 0 && relector2 == 0) continue;
                            int vecino1 = (lector5 + relector1 + 20) % 20;
                            int vecino2 = (lector6 + relector2 + 20) % 20;
                            if (ecosistema[vecino1][vecino2] == 'A') vecinos++;
                        }
                    }

                    if (ecosistema[lector5][lector6] == 'A') {
                        if (vecinos < 2 || vecinos > 3) nuevoEcosistema[lector5][lector6] = 'H';
                        else nuevoEcosistema[lector5][lector6] = 'A';
                    } else if (ecosistema[lector5][lector6] == 'H') {
                        if (vecinos == 3) nuevoEcosistema[lector5][lector6] = 'A';
                        else nuevoEcosistema[lector5][lector6] = 'H';
                    } else {
                        if (random.nextDouble() < 0.01) nuevoEcosistema[lector5][lector6] = 'H';
                        else nuevoEcosistema[lector5][lector6] = ' ';
                    }
                }
            }
            ecosistema = nuevoEcosistema;

            // Pausa entre días
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
