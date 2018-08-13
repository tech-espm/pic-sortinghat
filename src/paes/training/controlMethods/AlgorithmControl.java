package paes.training.controlMethods;

import paes.training.controlValues.ControlValues;

public class AlgorithmControl {

    public ControlValues cv = new ControlValues();

    public void sumE() {
        cv.setSumE(0);
    }

    public double[] hli(double[] hli) {
        for (int i = 0; i < hli.length; i++) {
            hli[i] = 0;
        }

       return hli;
    }

    public double[] hlo(double[] hlo) {
        for (int i = 0; i < hlo.length; i++) {
            hlo[i] = 0;
        }

        return hlo;
    }

    public double[] eli(double[] eli) {
        for (int i = 0; i < eli.length; i++) {
            eli[i] = 0;
        }

        return eli;
    }

    public double[] elo(double[] elo) {
        for (int i = 0; i < elo.length; i++) {
            elo[i] = 0;
        }

        return elo;
    }
}
