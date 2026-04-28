package tools;
import java.util.Scanner;

public class tiktaktoeminimax {
        static char x = 'X';
        static char o = 'O';
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        Scanner s = new Scanner(System.in);
    
        while (isterminal(flattenBoard(board))==null) { 
            int best = bestmove(flattenBoard(board));
            board[(best-1)/3][(best-1)%3] = x;

            printBoard(board);
            if (!(isterminal(flattenBoard(board))==null)) {
                break;
            }
            System.out.println("dein Zug");
            int c = s.nextInt();
            int r = s.nextInt();
            if (board[c-1][r-1] != ' ') {
            System.out.println("Feld bereits belegt");
            continue;
            }
            board[c-1][r-1]= o;
        }
        System.out.println("das Ergebnis ist:"+ isterminal(flattenBoard(board)));
        printBoard(board);
    
    }

  public static int minimax(char[] board, boolean myturn,int depth, int alpha, int beta) {
    String result = isterminal(board);
    if (result != null) {
        if (result.equals("X"))    return 10-depth;  
        if (result.equals("O"))    return depth-10;  
        if (result.equals("draw")) return 0;
    }
    if (myturn) {
        int value = -100;
        for (int i = 1; i < 10; i++) {
            if (board[i]==' ') {
              char [] nextmove = board.clone();
              nextmove[i] = x;
              value = Math.max(value,minimax(nextmove,!myturn,depth+1, alpha,beta));
              alpha = Math.max(alpha, value);
              if (alpha>beta){
                break;
              }

            }
        }
        return value;
    }
    else{
        int value = 100;
        for (int i = 1; i < 10; i++) {
            if (board[i]==' ') {
              char [] nextmove = board.clone();
              nextmove[i] = o;
              value = Math.min(value,minimax(nextmove,!myturn,depth+1,alpha,beta));
              beta = Math.min(beta, value);
              if (alpha>beta){
                break;
              }

            }
        }
        return value;
    }

    }
    public static int bestmove(char[] board){
        int bestvalue = -100;
        int bestindex = 0;
        for (int i = 1; i < 10; i++) {
            if (board[i]==' ') {
              char [] nextmove = board.clone();
              nextmove[i] = x;
              int value = minimax(nextmove,false,0,-100,100);
              System.out.println("index " + i + " = " + value);
              if (value > bestvalue) {
                bestvalue = value;
                bestindex = i;
            }

            }
        }
        return bestindex;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            System.out.println("  "+board[i][0] + " |  " + board[i][1] + "  | " + board[i][2]+"  ");
            if (i < 2) System.out.println("----+-----+----");
        }
        System.out.println("");
    }

    public static String isterminal(char[] linear) {
        int[][] winning = {{1,2,3}, {4,5,6}, {7,8,9},
         {1,4,7}, {2,5,8}, {3,6,9}, {1,5,9}, {3,5,7} };
        for (int i = 0; i < 8; i++) {
            if (linear[winning[i][0]] != ' ' 
            && linear[winning[i][0]] == linear[winning[i][1]] 
            && linear[winning[i][0]] == linear[winning[i][2]]) {
                return String.valueOf(linear[winning[i][0]]);
            }
        }
        for (int k = 1; k <= 9; k++) {
            if (linear[k] == ' ') return null; 
        }
        return "draw";

    }

    public static char[] flattenBoard(char[][] board) {
        char[] linear = new char[10];
        int index = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                linear[index++] = board[i][j];
            }
        }
        return linear;
    }
}