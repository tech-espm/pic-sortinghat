package paes.propagation;

public class PonderationL1 {
    public double[] ponderationL1(int n, double[][] inputValues, int minValue, double[] hli, double[][] wl1) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < inputValues[i].length; j++) {
                hli[i] += inputValues[minValue][j] * wl1[j][i];
            }
        }
        return hli;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}