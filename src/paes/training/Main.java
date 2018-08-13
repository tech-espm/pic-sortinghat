package paes.training;

import paes.training.backPropagation.WeightsUpdate.WeigthsUpdate;
import paes.training.backPropagation.gradientCalculation.GradientsCalc;
import paes.training.controlValues.ControlValues;
import paes.training.controlMethods.AlgorithmControl;
import paes.training.dataset.Dataset;
import paes.training.errorCalculation.ErrorCalc;
import paes.training.propagation.activation.ActivationFunctions;
import paes.training.propagation.ponderation.Ponderation;
import paes.training.weights.Weights;
import paes.training.controlMethods.Printing;

public class Main {
    public static void main(String[] args) {

        AlgorithmControl ac = new AlgorithmControl();
        ControlValues cv = new ControlValues();

        Weights weights = new Weights();

        Printing p = new Printing();
        Ponderation lp = new Ponderation();
        ActivationFunctions sigmoidActivation = new ActivationFunctions();
        ErrorCalc errorCalc = new ErrorCalc();
        GradientsCalc gl = new GradientsCalc();
        WeigthsUpdate wu = new WeigthsUpdate();

        Dataset dataset = new Dataset();

        double[][] inputValues = dataset.getInputValues();
        int[][] desired = dataset.getDesired();

        double[] hli = new double[cv.getN()];
        double[] hlo = new double[cv.getN()];

        double[] eli = new double[3];
        double[] elo = new double[3];

        double[] gradientL2 = new double[3];
        double[] gradientL1 = new double[cv.getN()];

        double[][] wl1 = new double[15][cv.getN()];
        double[][] wl2 = new double[3][cv.getN()];

        weights.wl1(wl1);
        weights.wl2(wl2);

        do {
            ac.sumE();
            hli = ac.hli(eli);
            hlo = ac.hlo(hlo);

            eli = ac.eli(eli);
            elo = ac.elo(elo);

            if (cv.getCont() == 155) {
                cv.setCont(0);
                cv.setMinValue(0);

                hli = lp.ponderationL1(cv.getN(), inputValues, cv.getMinValue(), hli, wl1);
                hlo = sigmoidActivation.activation(hlo, hli);

                eli = lp.ponderationL2(eli, wl2, hlo);
                elo = sigmoidActivation.activation(elo, eli);

                cv.setGlobalError(errorCalc.errorCalculation(elo, desired, cv.getSumE(), cv.getCont()));

                gradientL2 = gl.gradientCalculationL2(gradientL2, eli, cv.getCont(), desired, elo);
                gradientL1 = gl.gradientCalculationL1(gradientL1, gradientL2, hlo, wl2, elo);

                wl2 = wu.weightsUpdateL2(wl2, cv.getAlpha(), cv.getEta(), gradientL2, hlo);
                wl1 = wu.weightsUpdateL1(inputValues, cv.getMinValue(), wl1, cv.getAlpha(), cv.getEta(), gradientL1);

                cv.setAge(cv.getAge() + 1);
            } else {
                hli = lp.ponderationL1(cv.getN(), inputValues, cv.getMinValue(), hli, wl1);
                hlo = sigmoidActivation.activation(hlo, hli);

                eli = lp.ponderationL2(eli, wl2, hlo);
                elo = sigmoidActivation.activation(elo, eli);

                cv.setGlobalError(errorCalc.errorCalculation(elo, desired, cv.getSumE(), cv.getCont()));

                gradientL2 = gl.gradientCalculationL2(gradientL2, eli, cv.getCont(), desired, elo);
                gradientL1 = gl.gradientCalculationL1(gradientL1, gradientL2, hlo, wl2, elo);

                wl2 = wu.weightsUpdateL2(wl2, cv.getAlpha(), cv.getEta(), gradientL2, hlo);
                wl1 = wu.weightsUpdateL1(inputValues, cv.getMinValue(), wl1, cv.getAlpha(), cv.getEta(), gradientL1);
            }

            cv.setMinValue(cv.getMinValue() + 1);
            cv.setCont(cv.getCont() + 1);

        } while (cv.getGlobalError() >= 1E-30);

        p.printingTraining(cv.getAge(), wl1, wl2);
    }
}