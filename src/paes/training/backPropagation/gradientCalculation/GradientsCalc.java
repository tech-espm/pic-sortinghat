package paes.training.backPropagation.gradientCalculation;

public class GradientsCalc {

    public double[] gradientCalculationL1(double[] gradientL1, double[] gradientL2, double[] hlo, double[][] wl2, double[] elo) {
        for (int i = 0; i < gradientL1.length; i++) {
            for (int j = 0; j < elo.length; j++) {
                gradientL1[i] += (wl2[j][i] * gradientL2[j]);
            }
            gradientL1[i] *= hlo[i] * (1-hlo[i]);
        }
        return gradientL1;
    }

    public double[] gradientCalculationL2(double[] gradientL2, double[] eli, int cont, int[][] desired, double[] elo) {
        for (int i = 0; i < gradientL2.length; i++) {
            gradientL2[i] = elo[i] * (1 - elo[i]) * (desired[cont][i] - elo[i]);
        }
        return  gradientL2;
    }
}
