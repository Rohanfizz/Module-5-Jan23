import java.io.*;
import java.util.*;

public class Main {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair(String psf, int i, int j) {
         this.psf = psf;
         this.i = i;
         this.j = j;
      }
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            arr[i][j] = sc.nextInt();
         }
      }

		int[][] dp = new int[n][m];
	   for(int i= n-1;i>=0;i--){
		   for(int j = m-1;j>=0;j--){
			   if(i == n-1 && j == m-1) dp[i][j] = arr[i][j];
			   else if(i == n-1) dp[i][j] = arr[i][j] + dp[i][j+1];
			   else if(j == m-1) dp[i][j] = arr[i][j] + dp[i+1][j];
			   else{
				   dp[i][j] = arr[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
			   }
		   }
	   }
	   System.out.println(dp[0][0]);
	   Queue<Pair> q = new LinkedList<>();
	   q.add(new Pair("",0,0));

	   while(q.size() > 0){
		   Pair front = q.remove();
		   int i = front.i;
		   int j = front.j;
		   String psf = front.psf;
		   if(i == n-1 && j == m-1){
			   System.out.println(psf);
			   continue;
		   }
		   if(i+1<n && dp[i+1][j] == dp[i][j] - arr[i][j]) q.add(new Pair(psf+"V",i+1,j));
		   if(j+1<m && dp[i][j+1]== dp[i][j]+ arr[i][j] ) q.add(new Pair(psf+"H",i,j+1));
	   }
   }
}

