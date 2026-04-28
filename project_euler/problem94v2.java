package problems;
import java.math.BigInteger;

public class problem94v2{

    /*
    funktioniert zwar aber efizente were pythagoreische trippel zu erzeugen und zu filtern */

    public static void main(String[] args) {
        BigInteger n = BigInteger.TWO;
        BigInteger sum = BigInteger.ZERO;
        BigInteger bound = new BigInteger("1000000000");
        BigInteger three = new BigInteger("3");
        BigInteger two = BigInteger.TWO;
        BigInteger one = BigInteger.ONE;
        BigInteger four = new BigInteger("4");

        while (true) {
            if (n.multiply(three).compareTo(bound) > 0) {
                break;
            }
            int nm = n.mod(four).intValue();

            if ((3*nm*nm-2*nm-1)%4==0) {

                // (3*n*n - 2*n - 1) 
                BigInteger expr1 = n.multiply(n).multiply(three)
                        .subtract(n.multiply(two))
                        .subtract(one);

                if (isPerfectSquare(expr1)) {
                    sum = sum.add(n.multiply(three).add(one));
                }
            }if ((3*nm*nm+2*nm-1)%4==0) {

                // (3*n*n + 2*n - 1) / 2
                BigInteger expr2 = n.multiply(n).multiply(three)
                        .add(n.multiply(two))
                        .subtract(one);

                if (isPerfectSquare(expr2)) {
                    sum = sum.add(n.multiply(three).subtract(one));
                }
            }

            n = n.add(one);
        }

        System.out.println(sum);
    }

    public static boolean isPerfectSquare(BigInteger n) {
        BigInteger root = n.sqrt();
        return root.multiply(root).equals(n);
        
    }
}
