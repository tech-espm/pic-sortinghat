package paes.training.c2.sigmoid;

import java.util.Random;

public class SigmoidTrainingC2 {
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

        double[] hli1 = new double[n];
        double[] hlo1 = new double[n];

        double[] hli2 = new double[n];
        double[] hlo2 = new double[n];

        double[] eli = new double[3];
        double[] elo = new double[3];

        double[][] wl1 = new double[15][n];
        double[][] wl2 = new double[n][n];
        double[][] wl3 = new double[3][n];

        double[] gradientL3 = new double[3];
        double[] gradientL2 = new double[n];
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
            System.out.println("");
        }

        //Random values for Layer's 3 weights' matrix;
        System.out.println("\nLayer 3 Weights (Before Training):");
        for (int i = 0; i < wl3.length; i++) {
            for (int j = 0; j < wl3[i].length; j++) {
                wl3[i][j] = random.nextDouble();
                System.out.print(wl3[i][j] + " ");
            }
            System.out.println("");
        }

        do {
            sumE = 0;
            for (int i = 0; i < hli1.length; i++) {
                hli1[i] = 0;
                hlo1[i] = 0;
            }

            for (int i = 0; i < hli2.length; i++) {
                hli2[i] = 0;
                hlo2[i] = 0;
            }

            for (int i = 0; i < eli.length; i++) {
                eli[i] = 0;
                elo[i] = 0;
            }

            if (cont == 84) {
                cont = 0;
                minValue = 0;

                hli1 = ponderationL1(n, inputValues, minValue, hli1, wl1);
                hlo1 = activationFunctionL1(hlo1, hli1);

                hli2 = ponderationL2(hli2, wl2, hlo1);
                hlo2 = activationFunctionL2(hlo2, hli2);

                eli = ponderationL3(eli, wl3, hlo2);
                elo = activationFunctionL3(elo, eli);

                globalError = errorCalculation(elo, desired, sumE, cont);

                gradientL3 = gradientCalculationL3(gradientL3, eli, cont, desired, elo);
                gradientL2 = gradientCalculationL2(gradientL2, gradientL3, hlo2, wl3, elo);
                gradientL1 = gradientCalculationL1(gradientL1, gradientL2, hlo1, wl2);

                wl3 = weightsUpdateL3(wl3, alpha, eta, gradientL3, hlo2);
                wl2 = weightsUpdateL2(wl2, alpha, eta, gradientL2, hlo1);
                wl1 = weightsUpdateL1(inputValues, minValue, wl1, alpha, eta, gradientL1);

                age++;
            }

            else {
                hli1 = ponderationL1(n, inputValues, minValue, hli1, wl1);
                hlo1 = activationFunctionL1(hlo1, hli1);

                hli2 = ponderationL2(hli2, wl2, hlo1);
                hlo2 = activationFunctionL2(hlo2, hli2);

                eli = ponderationL3(eli, wl3, hlo2);
                elo = activationFunctionL3(elo, eli);

                globalError = errorCalculation(elo, desired, sumE, cont);

                gradientL3 = gradientCalculationL3(gradientL3, eli, cont, desired, elo);
                gradientL2 = gradientCalculationL2(gradientL2, gradientL3, hlo2, wl3, elo);
                gradientL1 = gradientCalculationL1(gradientL1, gradientL2, hlo1, wl2);

                wl3 = weightsUpdateL3(wl3, alpha, eta, gradientL3, hlo2);
                wl2 = weightsUpdateL2(wl2, alpha, eta, gradientL2, hlo1);
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

        System.out.println("\nLayer 3 Weights (After Training):");
        for (int i = 0; i < wl3.length; i++) {
            for (int j = 0; j < wl3[i].length; j++) {
                System.out.print(wl3[i][j] + ", ");
            }
            System.out.println("");
        }

    }

    public static double[] ponderationL1(int n, double[][] inputValues, int minValue, double[] hli1, double[][] wl1) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < inputValues[i].length; j++) {
                hli1[i] += inputValues[minValue][j] * wl1[j][i];
            }
        }
        return hli1;
    }

    public static double[] activationFunctionL1(double[] hlo1, double[] hli1) {
        for (int i = 0; i < hlo1.length; i++) {
            hlo1[i] = 1/(1 + Math.exp(-hli1[i]));
        }
        return hlo1;
    }

    public static double[] ponderationL2(double[] hli2, double[][] wl2, double[] hlo1) {
        for (int i = 0; i < wl2.length; i++) {
            for (int j = 0; j < wl2[i].length; j++) {
                hli2[i] += wl2[i][j] * hlo1[j];
            }
        }
        return hli2;
    }

    public static double[] activationFunctionL2(double[] hlo2, double[] hli2) {
        for (int i = 0; i < hlo2.length; i++) {
            hlo2[i] = 1/(1 + Math.exp(-hli2[i]));
        }
        return hlo2;
    }

    public static double[] ponderationL3(double[] eli, double[][] wl3, double[] hlo2) {
        for (int i = 0; i < wl3.length; i++) {
            for (int j = 0; j < wl3[i].length; j++) {
                eli[i] += wl3[i][j] * hlo2[j];
            }
        }
        return eli;
    }

    public static double[] activationFunctionL3(double[] elo, double[] eli) {
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

    public static double[] gradientCalculationL3(double[] gradientL3, double[] eli, int cont, int[][] desired, double[] elo) {
        for (int i = 0; i < gradientL3.length; i++) {
            gradientL3[i] = elo[i] * (1-elo[i]) * (desired[cont][i] - elo[i]);
        }
        return  gradientL3;
    }

    public static double[] gradientCalculationL2(double[] gradientL2, double[] gradientL3, double[] hlo2, double[][] wl3, double[] elo) {
        for (int i = 0; i < gradientL2.length; i++) {
            for (int j = 0; j < elo.length; j++) {
                gradientL2[i] += (wl3[j][i] * gradientL3[j]);
            }
            gradientL2[i] *= hlo2[i] * (1-hlo2[i]);
        }
        return gradientL2;
    }

    public static double[] gradientCalculationL1(double[] gradientL1, double[] gradientL2, double[] hlo1, double[][] wl2) {
        for (int i = 0; i < gradientL2.length; i++) {
            for (int j = 0; j < hlo1.length; j++) {
                gradientL1[i] += (wl2[j][i] * gradientL2[j]);
            }
            gradientL1[i] *= hlo1[i] * (1-hlo1[i]);
        }
        return gradientL1;
    }

    public static double[][] weightsUpdateL3(double[][] wl3, double alpha, double eta, double[] gradientL3, double[] hlo2) {
        for (int i = 0; i < wl3.length; i++) {
            for (int j = 0; j < wl3[i].length; j++) {
                wl3[i][j] = wl3[i][j] + (alpha * wl3[i][j]) + (eta * gradientL3[i] * hlo2[j]);
            }
        }
        return wl3;
    }

    public static double[][] weightsUpdateL2(double[][] wl2, double alpha, double eta, double[] gradientL2, double[] hlo1) {
        for (int i = 0; i < wl2.length; i++) {
            for (int j = 0; j < wl2[i].length; j++) {
                wl2[i][j] = wl2[i][j] + (alpha * wl2[i][j]) + (eta * gradientL2[i] * hlo1[j]);
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