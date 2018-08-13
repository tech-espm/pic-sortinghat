package paes.training.backPropagation.WeightsUpdate;

public class WeigthsUpdate {
    public double[][] weightsUpdateL2(double[][] wl2, double alpha, double eta, double[] gradientL2, double[] hlo) {
        for (int i = 0; i < wl2.length; i++) {
            for (int j = 0; j < wl2[i].length; j++) {
                wl2[i][j] = wl2[i][j] + (alpha * wl2[i][j]) + (eta * gradientL2[i] * hlo[j]);
            }
        }
        return wl2;
    }

    public double[][] weightsUpdateL1(double[][] inputValues, int minValue, double[][] wl1, double alpha, double eta, double[] gradientL1) {

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
