package paes.test.c1.sigmoid;

public class SigmoidTestC1 {
    public static void main(String[] args) {
        int n = 3, minValue = 0;
        String result = "";

        double[][] inputValues = {
                {0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0}, {1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0}, {0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0}};

        double[] hli = new double[n];
        double[] hlo = new double[n];

        double[] eli = new double[3];
        double[] elo = new double[3];

        double[][] wl1 = {
                {1.08844640574164624E17, 1.25630742364504176E17, 4.0851644457703416E16},
                {8.3622871598854576E16, 4.5123308356370816E16, 3.1591913133028973E17},
                {1.1694528460519968E17, 6.6060488947126176E16, -3.5949410716144955E15},
                {1.2869511060586034E16, 7.8285930050312448E16, 1.1813757130454576E17},
                {5.0248664531387232E16, 1.03210953633926048E17, 1.7041098017061922E15},
                {1.07873129591924416E17, 5.4088031610171824E16, 2.8219122369631064E16},
                {1.13846404303609472E17, 1.00775866543178032E17, -5.4618866914325888E16},
                {2.7288746217493588E16, 2.8807925466872752E16, 2.12218545423017728E17},
                {1.00033353559165232E17, 1.6059576807168298E16, -3.1226315020903021E17},
                {1.32150752660531008E17, 1.16756940525637904E17, -1.35660907871301872E17},
                {7.655857047463516E15, 4.4155704535782424E16, -8.550674616565804E15},
                {-9.293500618219878E15, 3.6313086902571016E16, 1.1692124771064296E17},
                {7.6730719112171488E16, 6.386361249652908E16, -1.33360554474492288E17},
                {3.4381982177774248E16, 9.5555544268052816E16, -2.30358218541735296E17},
                {7.7851262638151504E16, -4.3072858282765624E16, 2.44538159812646528E17}};

        double[][] wl2 = {
                {1.0038626337626448E16, -1.0038626337626432E16, -1.9705445331316256E17},
                {-4.2642159907365912E16, 4.264215990736564E16, 309.0502537147503},
                {-1.07647965566172E16, -1.20238708898990624E17, 1.31003505455606608E17}};

        while(minValue <= 20) {
            for (int i = 0; i < hli.length; i++) {
                hli[i] = 0;
                hlo[i] = 0;
            }

            for (int i = 0; i < hli.length; i++) {
                hli[i] = 0;
                hlo[i] = 0;
            }

            for (int i = 0; i < eli.length; i++) {
                eli[i] = 0;
                elo[i] = 0;
            }

            hli = ponderationL1(n, inputValues, minValue, hli, wl1);
            hlo = activationFunctionL1(hlo, hli);

            eli = ponderationL2(eli, wl2, hlo);
            elo = activationFunctionL2(elo, eli);

            for (int i = 0; i < elo.length; i++) {
                result += Math.round(elo[i]) + " ";
            }

            if (result.equals("0 0 1 ")) System.out.println(result + " BI");
            else if (result.equals("0 1 0 ")) System.out.println(result + " DEV");
            else if (result.equals("1 0 0 ")) System.out.println(result + " Games");
            else System.out.println(result + " Unindentified-Specialisation field Detected!");

            minValue++;
            result = "";

        }
    }

    public static double[] ponderationL1(int n, double[][] inputValues, int minValue, double[] hli, double[][] wl1) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < inputValues[i].length; j++) {
                hli[i] += inputValues[minValue][j] * wl1[j][i];
            }
        }
        return hli;
    }

    public static double[] activationFunctionL1(double[] hlo, double[] hli) {
        for (int i = 0; i < hlo.length; i++) {
            hlo[i] = 1/(1 + Math.exp(-hli[i]));
        }
        return hlo;
    }

    public static double[] ponderationL2(double[] eli, double[][] wl2, double[] hlo) {
        for (int i = 0; i < wl2.length; i++) {
            for (int j = 0; j < wl2[i].length; j++) {
                eli[i] += wl2[i][j] * hlo[j];
            }
        }
        return eli;
    }

    public static double[] activationFunctionL2(double[] elo, double[] eli) {
        for (int i = 0; i < elo.length; i++) {
            elo[i] = 1/(1 + Math.exp(-eli[i]));
        }
        return elo;
    }
}
