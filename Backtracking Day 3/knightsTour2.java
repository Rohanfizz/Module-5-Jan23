import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception     {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] chess = new int[n][n];
        f(chess, r, c, 1);
    }

	public static int[] di ={-2,-1,1,2,2,1,-1,-2};
	public static int[] dj ={1,2,2,1,-1,-2,-2,-1};
	
    public static void f(int[][] chess, int i, int j, int move) {
        // Write your code here
		int n = chess.length;
		if(i<0 || j<0 || i>=n || j>=n || chess[i][j] != 0) return;
		if(move == (n*n)){
			chess[i][j] = move;
			displayBoard(chess);
			chess[i][j] = 0;
			return;
		}
		
		chess[i][j] = move;
		// f(chess,i-2,j+1,move+1);
		// f(chess,i-1,j+2,move+1);
		// f(chess,i+1,j+2,move+1);
		// f(chess,i+2,j+1,move+1);
		// f(chess,i+2,j-1,move+1);
		// f(chess,i+1,j-2,move+1);
		// f(chess,i-1,j-2,move+1);
		// f(chess,i-2,j-1,move+1);
		for(int d = 0;d<8;d++){
			int ni = i+di[d];
			int nj = j+dj[d];
			f(chess,ni,nj,move+1);
		}
		chess[i][j] = 0;
		
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}