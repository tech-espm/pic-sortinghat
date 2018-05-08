package paes.training;

import paes.propagation.ActivationFunctions;
import paes.propagation.PonderationL1;

import java.util.Random;

public class Training {
    public static void main(String[] args) {
        Random random = new Random();

        int n = 3, minValue = 0, cont = 0, age = 1;
        double sumE = 0, globalError = 0;
        double alpha = 0.0001, eta = 0.1;

        double[] hli = new double[n];
        double[] hlo = new double[n];

        double[] eli = new double[3];
        double[] elo = new double[3];

        double[][] wl1 = new double[4][n];
        double[][] wl2 = new double[3][n];

        double[] gradientL2 = new double[3];
        double[] gradientL1 = new double[n];

        double[][] inputValues = {{0.620, 0.682, 0.203, 0.080}};

        PonderationL1 ponderationL1 = new PonderationL1();
        ActivationFunctions activationFunctions = new ActivationFunctions();

        hli = ponderationL1.ponderationL1(n, inputValues, minValue, hli, wl1);

    }
}