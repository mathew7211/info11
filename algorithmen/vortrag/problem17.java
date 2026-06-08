public class problem17 {

    //https://projecteuler.net/problem=17
    public static void main(String[] args) {
        long result =0;
        for (int i = 1; i < 1000; i++) {
            result+= value(i);
            if(i%100==0) result-=3;//200and
        }
        result+= "onethousand".length();
        System.out.println(result);
        System.out.println(value(115));
    }

    public static int value(int i){
        int i_2digit = i%100;
        int i_3digit = i/100;
        String word="";
            if (i_3digit!=0) {
                switch (i_3digit) {
                    case 1:
                        word += "one";
                        break;
                    case 2:
                        word += "two";
                        break;
                    case 3:
                        word += "three";
                        break;
                    case 4:
                        word += "four";
                        break;
                    case 5:
                        word += "five";
                        break;
                    case 6:
                        word += "six";
                        break;
                    case 7:
                        word += "seven";
                        break;
                    case 8:
                        word += "eight";
                        break;
                    case 9:
                        word += "nine";
                        break;
                }
                word+="hundredand";
            }


            if (i_2digit<20) {

            switch (i_2digit) {
                    case 1:
                        word += "one";
                        break;
                    case 2:
                        word += "two";
                        break;
                    case 3:
                        word += "three";
                        break;
                    case 4:
                        word += "four";
                        break;
                    case 5:
                        word += "five";
                        break;
                    case 6:
                        word += "six";
                        break;
                    case 7:
                        word += "seven";
                        break;
                    case 8:
                        word += "eight";
                        break;
                    case 9:
                        word += "nine";
                        break;
                    case 10:
                        word += "ten";
                        break;
                    case 11:
                        word += "eleven";
                        break;
                    case 12:
                        word += "twelve";
                        break;
                    case 13:
                        word += "thirteen";
                        break;
                    case 14:
                        word += "fourteen";
                        break;
                    case 15:
                        word += "fifteen";
                        break;
                    case 16:
                        word += "sixteen";
                        break;
                    case 17:
                        word += "seventeen";
                        break;
                    case 18:
                        word += "eighteen";
                        break;
                    case 19:
                        word += "nineteen";
                        break;
                }

        
            }
            else{
                int first = i_2digit/10;
                int second = i_2digit%10;
                 switch (first) {
                    case 2:
                        word += "twenty";
                        break;
                    case 3:
                        word += "thirty";
                        break;
                    case 4:
                        word += "forty";
                        break;
                    case 5:
                        word += "fifty";
                        break;
                    case 6:
                        word += "sixty";
                        break;
                    case 7:
                        word += "seventy";
                        break;
                    case 8:
                        word += "eighty";
                        break;
                    case 9:
                        word += "ninety";
                        break;
                }

                switch (second) {
                    case 1:
                        word += "one";
                        break;
                    case 2:
                        word += "two";
                        break;
                    case 3:
                        word += "three";
                        break;
                    case 4:
                        word += "four";
                        break;
                    case 5:
                        word += "five";
                        break;
                    case 6:
                        word += "six";
                        break;
                    case 7:
                        word += "seven";
                        break;
                    case 8:
                        word += "eight";
                        break;
                    case 9:
                        word += "nine";
                        break;
                }


            }
     
            return word.length();

    }
}
