package paes.errorCalc;

public class globalError {
    public static double errorCalculation(double[] elo, int[][] desired, double sumE, int cont) {
        double error = 0;

        for (int i = 0; i < elo.length; i++) {
            sumE += Math.abs(desired[cont][i] - elo[i]);
        }
        return error = sumE/3;
    }
}
