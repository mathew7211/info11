import java.math.BigInteger;



public class trunktierbareprimzahlen {

    static BigInteger p= BigInteger.TWO;
    static int lenght = 1;

    public static void generateLtrunkeble(BigInteger start,int depth){
        for (int i = 1; i <= 9; i++) {
            BigInteger next = start.add(BigInteger.TEN.pow(depth).multiply(BigInteger.valueOf(i)));
            if(next.isProbablePrime(5)){
                if (lenght<depth) {
                    lenght = depth;
                    p= next;
                }
                generateLtrunkeble(next, depth+1);
            }
        }

    }
    
    public static void main(String[] args) {
        generateLtrunkeble(BigInteger.valueOf(3), 1);
        generateLtrunkeble(BigInteger.valueOf(7), 1);
        System.out.println(lenght);
        System.out.println(p.toString());

    }
}
