package paes.training.c1.sigmoid;

import java.util.Random;

public class SigmoidTrainingC1 {
    public static void main(String[] args) {
        Random random = new Random(2412);

        int n = 10, minValue = 0, cont = 0, age = 1;
        double sumE = 0, globalError = 0;
        double alpha = 0.0001, eta = 0.05;

        double[][] inputValues = {
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1}, {0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
            {0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1}, {1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1}, {0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1},
            {0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1}, {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0},
            {1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1}, {1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1}, {1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1},
            {0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1}, {1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
            {1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0}, {1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0},
            {1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1}, {1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
            {0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0}, {1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1}, {0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0}, {0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1},
            {1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0}, {1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1}, {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0}, {1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1},
            {0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0}, {0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
            {0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, {0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0}, {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
            {1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1}, {0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1}, {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}};

        int[][] desired = {
            {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1},
            {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1},
            {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 0, 1}, {0, 1, 0}, {0, 1, 0},
            {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0},
            {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0},
            {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0},
            {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0},
            {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0},
            {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}};

        double[] hli = new double[n];
        double[] hlo = new double[n];

        double[] eli = new double[3];
        double[] elo = new double[3];

        double[][] wl1 = new double[15][n];
        double[][] wl2 = new double[3][n];

        double[] gradientL2 = new double[3];
        double[] gradientL1 = new double[n];

        //Random values for Layer's 1 weights' matrix;
        System.out.println("Layer 1 Weights (Before Training):");
        for (int i = 0; i < wl1.length; i++) {
            for (int j = 0; j < wl1[i].length; j++) {
                wl1[i][j] = random.nextDouble();
                System.out.print(wl1[i][j] + " ");
            }
            System.out.println("");
        }

        //Random values for Layer's 2 weights' matrix;
        System.out.println("\nLayer 2 Weights (Before Training):");
        for (int i = 0; i < wl2.length; i++) {
            for (int j = 0; j < wl2[i].length; j++) {
                wl2[i][j] = random.nextDouble();
                System.out.print(wl2[i][j] + " ");
            }
            System.out.println();
        }

        do {
            sumE = 0;
            for (int i = 0; i < hli.length; i++) {
                hli[i] = 0;
                hlo[i] = 0;
            }

            for (int i = 0; i < eli.length; i++) {
                eli[i] = 0;
                elo[i] = 0;
            }

            if (cont == 84) {
                cont = 0;
                minValue = 0;

                hli = ponderationL1(n, inputValues, minValue, hli, wl1);
                hlo = activationFunctionL1(hlo, hli);

                eli = ponderationL2(eli, wl2, hlo);
                elo = activationFunctionL2(elo, eli);

                globalError = errorCalculation(elo, desired, sumE, cont);

                gradientL2 = gradientCalculationL2(gradientL2, eli, cont, desired, elo);
                gradientL1 = gradientCalculationL1(gradientL1, gradientL2, hlo, wl2, elo);

                wl2 = weightsUpdateL2(wl2, alpha, eta, gradientL2, hlo);
                wl1 = weightsUpdateL1(inputValues, minValue, wl1, alpha, eta, gradientL1);

                age++;
            }

            else {

                hli = ponderationL1(n, inputValues, minValue, hli, wl1);
                hlo = activationFunctionL1(hlo, hli);

                eli = ponderationL2(eli, wl2, hlo);
                elo = activationFunctionL2(elo, eli);

                globalError = errorCalculation(elo, desired, sumE, cont);

                gradientL2 = gradientCalculationL2(gradientL2, eli, cont, desired, elo);
                gradientL1 = gradientCalculationL1(gradientL1, gradientL2, hlo, wl2, elo);

                wl2 = weightsUpdateL2(wl2, alpha, eta, gradientL2, hlo);
                wl1 = weightsUpdateL1(inputValues, minValue, wl1, alpha, eta, gradientL1);
            }
            minValue++;
            cont++;
        } while(globalError > 1E-30);

        System.out.println("\n" + age + " Ages\n");

        System.out.println("Layer 1 Weights (After Training):");
        for (int i = 0; i < wl1.length; i++) {
            for (int j = 0; j < wl1[i].length; j++) {
                System.out.print(wl1[i][j] + ", ");
            }
            System.out.println("");
        }

        System.out.println("\nLayer 2 Weights (After Training):");
        for (int i = 0; i < wl2.length; i++) {
            for (int j = 0; j < wl2[i].length; j++) {
                System.out.print(wl2[i][j] + ", ");
            }
            System.out.println("");
        }
    }

    public static double[] ponderationL1(int n, double[][] inputValues, int minValue, double[] hli, double[][] wl1) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < inputValues[i].length; j++) {
                hli[i] += inputValues[minValue][j] * wl1[j][i];
            }
        }
        return hli;
    }

    public static double[] activationFunctionL1(double[] hlo, double[] hli) {
        for (int i = 0; i < hlo.length; i++) {
            hlo[i] = 1/(1 + Math.exp(-hli[i]));
        }
        return hlo;
    }

    public static double[] ponderationL2(double[] eli, double[][] wl2, double[] hlo) {
        for (int i = 0; i < wl2.length; i++) {
            for (int j = 0; j < wl2[i].length; j++) {
                eli[i] += wl2[i][j] * hlo[j];
            }
        }
        return eli;
    }

    public static double[] activationFunctionL2(double[] elo, double[] eli) {
        for (int i = 0; i < elo.length; i++) {
            elo[i] = 1/(1 + Math.exp(-eli[i]));
        }
        return elo;
    }

    public static double errorCalculation(double[] elo, int[][] desired, double sumE, int cont) {
        double error = 0;

        for (int i = 0; i < elo.length; i++) {
            sumE += Math.abs(desired[cont][i] - elo[i]);
        }
        return error = sumE/3;
    }

    public static double[] gradientCalculationL2(double[] gradientL2, double[] eli, int cont, int[][] desired, double[] elo) {
        for (int i = 0; i < gradientL2.length; i++) {
            gradientL2[i] = elo[i] * (1 - elo[i]) * (desired[cont][i] - elo[i]);
        }
        return  gradientL2;
    }

    public static double[] gradientCalculationL1(double[] gradientL1, double[] gradientL2, double[] hlo, double[][] wl2, double[] elo) {
        for (int i = 0; i < gradientL1.length; i++) {
            for (int j = 0; j < elo.length; j++) {
                gradientL1[i] += (wl2[j][i] * gradientL2[j]);
            }
            gradientL1[i] *= hlo[i] * (1-hlo[i]);
        }
        return gradientL1;
    }

    public static double[][] weightsUpdateL2(double[][] wl2, double alpha, double eta, double[] gradientL2, double[] hlo) {
        for (int i = 0; i < wl2.length; i++) {
            for (int j = 0; j < wl2[i].length; j++) {
                wl2[i][j] = wl2[i][j] + (alpha * wl2[i][j]) + (eta * gradientL2[i] * hlo[j]);
            }
        }
        return wl2;
    }

    public static double[][] weightsUpdateL1(double[][] inputValues, int minValue, double[][] wl1, double alpha, double eta, double[] gradientL1) {

        double[] aux = new double[15];

        aux[0] = inputValues[minValue][0];
        aux[1] = inputValues[minValue][1];
        aux[2] = inputValues[minValue][2];
        aux[3] = inputValues[minValue][3];
        aux[4] = inputValues[minValue][4];
        aux[6] = inputValues[minValue][5];
        aux[7] = inputValues[minValue][6];
        aux[8] = inputValues[minValue][7];
        aux[9] = inputValues[minValue][9];
        aux[10] = inputValues[minValue][10];
        aux[11] = inputValues[minValue][11];
        aux[12] = inputValues[minValue][12];
        aux[13] = inputValues[minValue][13];
        aux[14] = inputValues[minValue][14];

        for (int i = 0; i < wl1.length; i++) {
            for (int j = 0; j < wl1[i].length; j++) {
                wl1[i][j] = wl1[i][j] + (alpha * wl1[i][j]) + (eta * gradientL1[j] * aux[i]);
            }
        }
        return wl1;
    }
}