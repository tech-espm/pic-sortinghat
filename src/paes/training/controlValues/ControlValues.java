package paes.training.controlValues;

public class ControlValues {

    private int n = 3, minValue = 0, cont = 0, age = 1;
    double sumE = 0, globalError = 0;
    private double alpha = 0.0001, eta = 0.1;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSumE() {
        return sumE;
    }

    public void setSumE(double sumE) {
        this.sumE = sumE;
    }

    public double getGlobalError() {
        return globalError;
    }

    public void setGlobalError(double globalError) {
        this.globalError = globalError;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getEta() {
        return eta;
    }

    public void setEta(double eta) {
        this.eta = eta;
    }
}
