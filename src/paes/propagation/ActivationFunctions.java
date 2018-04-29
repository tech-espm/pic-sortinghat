package paes.propagation;

public class ActivationFunctions {
    public double sigmoidActivation(double input) {
        double output = 1/(1 + Math.exp(-input));

        return output;
    }
}
