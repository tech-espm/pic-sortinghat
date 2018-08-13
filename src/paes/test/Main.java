package paes.test;

import paes.test.testValues.TestValues;
import paes.training.controlValues.ControlValues;
import paes.training.propagation.activation.ActivationFunctions;
import paes.training.propagation.ponderation.Ponderation;
import paes.training.controlMethods.Printing;

public class Main {
    public static void main(String[] args) {

        ControlValues cv = new ControlValues();

        TestValues testValues = new TestValues();

        Printing p = new Printing();
        Ponderation lp = new Ponderation();
        ActivationFunctions sigmoidActivation = new ActivationFunctions();

        double[][] inputValues = testValues.getInputValues();

        double[] hli = new double[cv.getN()];
        double[] hlo = new double[cv.getN()];

        double[] eli = new double[3];
        double[] elo = new double[3];

        double[][] wl1;
        double[][] wl2;

        wl1 = testValues.getWl1();
        wl2 = testValues.getWl2();

       while (cv.getMinValue() <= 38) {
           hli = lp.ponderationL1(cv.getN(), inputValues, cv.getMinValue(), hli, wl1);
           hlo = sigmoidActivation.activation(hlo, hli);

           eli = lp.ponderationL2(eli, wl2, hlo);
           elo = sigmoidActivation.activation(elo, eli);

           cv.setMinValue(cv.getMinValue() + 1);
           cv.setCont(cv.getCont() + 1);

           p.printingTest(elo);
       }
    }
}