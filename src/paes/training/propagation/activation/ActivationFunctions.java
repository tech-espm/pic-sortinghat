package paes.training.propagation.activation;

public class ActivationFunctions {

    public double[] activation(double[] xlo, double[] xli) {
        for (int i = 0; i < xlo.length; i++) {
            xlo[i] = 1/(1 + Math.exp(-xli[i]));
        }
        return xlo;
    }
}
