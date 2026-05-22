
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class gauss17 {
    public static void main(String[] args) {
        int fp = 17;
        int g = 3;//primitive wurzel für alle fermat primzahlen >3
        int pow2 = Integer.numberOfTrailingZeros(fp-1)+1;

        
        long[][] N_unterkörper = new long[1][fp];
        for (int i = 1; i < fp; i++) N_unterkörper[0][i] = 1;
        String[] N_unterkörper_repr     = { "-1" };

        for (int i = 1; i < pow2 - 1; i++) {
            int prd_anzahl = 1<<i;
            int prd_length = (fp-1)>>i;

            // generiren der Gauss-perioden
            long[][] N = new long[prd_anzahl][fp];
            for (int j = 0; j < prd_length; j++) {
                for (int k = 0; k < prd_anzahl; k++) {
                    int element = powm(g, k+j*prd_anzahl, fp);
                    N[k][element] = 1;
                }
            }

          
            double[] N_numerisch = new double[prd_anzahl];
            for (int k = 0; k < prd_anzahl; k++) {
                for (int j = 1; j < fp; j++) {
                    if (N[k][j] != 0)
                        N_numerisch[k] += Math.cos(2*Math.PI*j/fp);
                }
            }

            // produkt der conjugate
            int half = prd_anzahl >> 1;
            String[] products_repr = new String[half];

            for (int k = 0; k < half; k++) {
                long[] prod = product(N[k], N[k+half], fp);


                
                long[] coefs = new long[half];
                for (int m = 0; m < half; m++) {
                    int idx = firstNonZero(N_unterkörper[m]);
                    coefs[m] = prod[idx];
                }
                
                long const_term = prod[0];

                for (int index = 0; index < half; index++) {
                    if (coefs[0]!=coefs[index]) {
                        break;
                    }
                    if (index==half-1) {
                        const_term-=coefs[0];
                        for (int j = 0; j < coefs.length; j++) {
                            coefs[j]=0;
                        }
                    }
                }
               

           
                StringBuilder sb = new StringBuilder();
                if (const_term != 0) sb.append(const_term);
                for (int m = 0; m < half; m++) {
                    if (coefs[m] != 0) {
                        if (sb.length() > 0) sb.append(" + ");
                        if (coefs[m] == 1) {
                            sb.append("(").append(N_unterkörper_repr[m]).append(")");
                        } else {
                            sb.append(coefs[m]).append("*(").append(N_unterkörper_repr[m]).append(")");
                        }

                    }
                }
                products_repr[k] = sb.toString();

                //minimalpolynom ausgeben
                if (k==0) {
                    sb.setLength(0);
                if (const_term != 0) sb.append(const_term);
                for (int m = 0; m < half; m++) {
                    if (coefs[m] != 0) {
                        if (sb.length() > 0) sb.append(" + ");
                        if (coefs[m] == 1) {
                            sb.append("N"+m);
                        } else {
                            sb.append(coefs[m]).append("N"+m);
                        }

                    }
                }
               System.out.println("x²-N0*x+"+sb.toString());
                }
            }

            
           
            String[] sum_repr      = new String[prd_anzahl];
            for (int k = 0; k < prd_anzahl; k++) {
                sum_repr[k]      = N_unterkörper_repr[k % half];
            }

            
            String[] N_repr = new String[prd_anzahl];
            for (int k = 0; k < prd_anzahl; k++) {
                String sign = (N_numerisch[k] > N_numerisch[(k+half)%prd_anzahl])
                              ? "+" : "-";
                String p_str = sum_repr[k];
                String q_str = products_repr[k % half];
                N_repr[k] = "(((" + p_str + ") " + sign + " sqrt((" + p_str + ")^2 - 4*(" + q_str + "))) / 2)";
            }

            
            System.out.println("Stufe " + i + " e=" + prd_anzahl + ", f=" + prd_length);
            System.out.println(N_repr[0]);
            System.out.println("numerisch= "+N_numerisch[0]);
            System.out.println();
            
            try (PrintWriter out = new PrintWriter(new FileWriter("output.txt"))) {
                out.print(N_repr[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Vererben
            N_unterkörper          = N;
            N_unterkörper_repr     = N_repr;
        }

    }

    static int firstNonZero(long[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] != 0) return i;
        return -1;
    }

    static long[] product(long[] p, long[] q, int fp) {
        long[] result = new long[fp];
        for (int i = 0; i < fp; i++)
            for (int j = 0; j < fp; j++)
                result[(i + j) % fp] += p[i] * q[j];
        return result;
    }

    static int powm(int base, int exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (int)(((long) base * base) % mod);
            exp >>= 1;
        }
        return (int) result;
    }
}
