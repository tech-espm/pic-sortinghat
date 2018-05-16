package paes.test.c1.tanh;

public class TanhTestC1 {
    public static void main(String[] args) {
        int n = 4, minValue = 0;
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
                {181.82276584498837, 198.0316168248592, -12.137148859853307, 25.039781515684485},
                {261.04071190406825, -256.9188120405446, 91.07815042742074, 54.4319949506164},
                {30.194312360094905, 96.775211025406, 97.8851104048463, -11.983984276246748},
                {113.58709999605387, -98.9108787298049, 36.68750391566982, 58.638436121530795},
                {-69.65074823260052, -36.26880828458513, 40.50525207300449, 15.874690042646229},
                {34.371044328873865, 11.432125277873444, 30.672556362268413, 62.42702587410705},
                {-20.724015599066313, 400.8027036793761, -86.00951722936651, 36.77512302057425},
                {238.786546895565, -317.8479863830941, 38.22167327529381, 35.629505582749545},
                {-321.3853177807249, 104.35007205883365, 6.558994769413169, 9.626712777494776},
                {-16.201588566809725, -91.98721132442903, 4.42518953184811, -32.40346281235968},
                {30.368110030115805, 33.786892711668436, 16.239721965557077, -22.52313420577403},
                {226.47456845464916, 159.53545798086697, -7.339894458148847, -15.986843878104171},
                {-176.82479957746622, 127.86413894191497, 26.987999364247045, 52.023814351354375},
                {-120.13768543797993, 144.6535829015448, 73.64787748066814, -14.563975915397323},
                {156.94665658889866, -244.7549664171656, 52.7742717328221, 60.534311122496355}};

        double[][] wl2 = {
                {-184.67072748885033, 63.550371894560115, 96.74984745597679, 22.31976921750174},
                {163.6182926888338, 2.959639431067239, -114.97303966767994, -50.14365321476203},
                {17.685929765527536, -51.077689444814524, -16.968555554294852, 0.2502689162788421}};

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
            hlo[i] = (2/(1 + Math.exp(-2 * hli[i])));
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
            elo[i] = (2/(1 + Math.exp(-2 * eli[i])));
        }
        return elo;
    }
}
