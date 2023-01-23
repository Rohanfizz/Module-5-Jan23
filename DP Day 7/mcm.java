import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    sc.close();
    System.out.println(MatrixChainOrder(arr, n));
  }

	static int recur(int[] a,int i,int j){
		if(i+1 == j) return 0;
		int best = Integer.MAX_VALUE;

		for(int cut = i+1;cut<j;cut++){
			int left = recur(a,i,cut);
			int right = recur(a,cut,j);
			int mergingCost = a[i] * a[cut] * a[j];
			int totalCost = left + right + mergingCost;
			best = Math.min(best,totalCost);
		}
		return best;
	}

	static int mcm_tab(int[] p){
		int n = p.length;
		int[][] dp = new int[n][n];
		for(int g = 1;g<n;g++){
			for(int i = 0,j = g;j<n;i++,j++){
				if(i+1 == j){
					dp[i][j] = 0;
					continue;
				}
				int best = Integer.MAX_VALUE;
				for(int cut = i+1;cut<j;cut++){
					int totalCost = dp[i][cut] + dp[cut][j] + (p[i]*p[cut]*p[j]);
					best = Math.min(totalCost,best);
				}
				dp[i][j] = best;
			}
		}
		return dp[0][n-1];
	}
	
  static int MatrixChainOrder(int p[], int n) {
    // your code here
	  // return recur(p,0,n-1);
	  return mcm_tab(p);
  }
}

