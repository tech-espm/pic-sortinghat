package paes.training.controlMethods;

public class Printing {

    public void printingTraining(int age, double[][] wl1, double[][] wl2) {
        System.out.println("\n" + age + " Ages\n");

        System.out.println("Layer 1 Weights (After Training):");
        for (int i = 0; i < wl1.length; i++) {
            for (int j = 0; j < wl1[i].length; j++) {
                System.out.print(wl1[i][j] + ", ");
            }
            System.out.println("");
        }

        System.out.println("\nLayer 2 Weights (After Training):");
        for (int i = 0; i < wl2.length; i++) {
            for (int j = 0; j < wl2[i].length; j++) {
                System.out.print(wl2[i][j] + ", ");
            }
            System.out.println("");
        }
    }

    public void printingTest(double[] elo) {

        String result = "";

        for (int i = 0; i < elo.length; i++) {
            result += Math.round(elo[i]) + " ";
        }

        if (result.equals("0 0 1 ")) System.out.println(result + " BI");
        else if (result.equals("0 1 0 ")) System.out.println(result + " DEV");
        else if (result.equals("1 0 0 ")) System.out.println(result + " Games");
        else System.out.println(result + " Unindentified-Specialisation field Detected!");
    }
}
