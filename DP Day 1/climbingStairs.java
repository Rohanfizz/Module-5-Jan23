import java.util.*;
import static java.lang.Math.ceil;

class Accio {

	public int recur(int n,int[] memo){
		if(n<=1) return 1;
		if(memo[n]>0) return memo[n];
		int a = recur(n-1,memo);
		int b = recur(n-2,memo);
		return memo[n] = a+b;
	}

	public int tabulation(int n,int[] dp){
		int N=n;
		for(n=0;n<=N;n++){
			if(n<=1){
				dp[n] = 1;
				continue;
			}		
			int a =dp[n-1]; //recur(n-1,memo);
			int b =dp[n-2]; //recur(n-2,memo);
			dp[n] = a+b;
		}
		return dp[N];
	}
	
    public int ClimbingStairs(int n) {
        // Write your code here
		int[] memo = new int[n+1];
		// return recur(n,memo);
		return tabulation(n,memo);

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Accio Obj = new Accio();
        System.out.println(Obj.ClimbingStairs(n));
    }
}