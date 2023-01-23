import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        Solution obj=new Solution();
        obj.solve(n,values,wts,cap);

    }
}

class Solution {
	public static class Pair{
		int i;
		int j;
		String psf;
		Pair(int i,int j,String psf){
			this.i = i;
			this.j = j;
			this.psf = psf;
		}
	}
	public static int recur(int[] val,int[] wts,int idx,int cap){
		if(idx < 0 || cap == 0) return 0;
		
		//pick
		int pick = cap-wts[idx] >=0?recur(val,wts,idx-1,cap - wts[idx]) + val[idx]:0;
		//not pick
		int notPick = recur(val,wts,idx-1,cap);
		return Math.max(pick,notPick);
	}

	public static void tab(int[] val,int[] wts,int n,int cap){
		int[][] dp = new int[n+1][cap+1];
		for(int i =1;i<=n;i++){
			for(int j=1;j<=cap;j++){
				// if i not pick
				int notpick = dp[i-1][j];
				int pick = j-wts[i-1]>=0? val[i-1] + dp[i-1][j-wts[i-1]]:0;
				dp[i][j] = Math.max(pick,notpick);
			}
		}
		System.out.println(dp[n][cap]) ;

		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(n,cap,""));
		
		while(q.size()>0){
			Pair p = q.remove();
			int i = p.i;
			int j = p.j;
			String psf = p.psf;

			if(i == 0 || j == 0){
				System.out.println(psf);
				continue;
			}
			
			//not picked
			if(dp[i-1][j] == dp[i][j]) q.add(new Pair(i-1,j,psf));
			//picked
			if(j-wts[i-1]>=0){
				int dpValOfRemaining = dp[i-1][j-wts[i-1]];
				if(dp[i][j] == val[i-1] + dpValOfRemaining){
					q.add(new Pair(i-1,j-wts[i-1],(i-1)+" "+psf));
				}
			}
		}
		
	}
	
    public static void solve(int n,int values[],int wts[],int cap) {
        // your code here
		// System.out.println(recur(values,wts,n-1,cap));
		tab(values,wts,n,cap);
    }
}

