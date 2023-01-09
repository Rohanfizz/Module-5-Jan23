import java.util.*;

public class Main {

	public static void fill(int[][] w,int i,int j,int c,int pc){
		if(i<0 || i>=w.length || j<0 || j>=w[0].length) return;
		if(w[i][j] != pc) return;
		
		w[i][j] = c;
		fill(w,i-1,j,c,pc);
		fill(w,i,j-1,c,pc);
		fill(w,i+1,j,c,pc);
		fill(w,i,j+1,c,pc);
		
	}
	
    public static void FloodFill(int[][] w, int x, int y, int c) {
        // write code here
		int pc = w[x][y];
		if(pc == c) return;
		fill(w,x,y,c,pc);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] w = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; ++j)
                w[i][j] = sc.nextInt();
        }
        int x = sc.nextInt(), y = sc.nextInt(), c = sc.nextInt();
	    FloodFill(w, x, y, c);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(w[i][j] + " ");
            System.out.println();
        }
    }
}