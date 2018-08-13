package paes.training.weights;

import java.util.Random;

public class Weights {
    Random random = new Random();

    public double[][] wl1(double[][] wl1) {
        System.out.println("Layer 1 Weights (Before Training):");
        for (int i = 0; i < wl1.length; i++) {
            for (int j = 0; j < wl1[i].length; j++) {
                wl1[i][j] = random.nextDouble();
                System.out.print(wl1[i][j] + " ");
            }
            System.out.println("");
        }

        return wl1;
    }

    public double[][] wl2(double[][] wl2) {

        System.out.println("\nLayer 2 Weights (Before Training):");
        for (int i = 0; i < wl2.length; i++) {
            for (int j = 0; j < wl2[i].length; j++) {
                wl2[i][j] = random.nextDouble();
                System.out.print(wl2[i][j] + " ");
            }
            System.out.println();
        }
        return wl2;
    }
}
