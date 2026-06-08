import java.util.ArrayList;

public class knot {
    public static void main(String[] args) {
        String gcode = "-r1 +l2 -r3 +l1 -r2 +l3";// extended Gauss code erstes muss - und 1 sei
        String[] parts = gcode.split(" ");
        ArrayList<Integer> segment = new ArrayList<>();//segment festgelegt durch startpunkt und index
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].charAt(0)=='-') {
                segment.add(Integer.parseInt(parts[i].substring(2)));
            }
        }

        StringBuilder sb = new StringBuilder("<");
        for (int i = 0; i < segment.size(); i++) {
                sb.append(reps(i));
                sb.append(", ");
        }
        sb.append("|  ");

        
        int current_segment =0;
        for (int i = 1; i < parts.length; i++) {
            if (parts[i].charAt(0)=='+') {
                int u1 = segment.indexOf(Integer.parseInt(parts[i].substring(2)));
                int u = (u1-1+segment.size())%segment.size();
                if (parts[i].charAt(1)=='l') {
                    sb.append(reps(u1)+"*"+reps(current_segment)+"*"+reps(u)+"^-1*"+reps(current_segment)+"^-1  ");
                }
                else{
                    sb.append(reps(current_segment)+"*"+reps(u1)+"*"+reps(current_segment)+"^-1*"+reps(u)+"^-1  ");
                }
            }
            else{
                ++current_segment;
            }
        }
        sb.append(">");
        System.out.println(sb.toString());


    }
    public static String reps(int n){
        return ""+(char)('a'+n);
    }
}

