import java.util.*;

class Solution {

      public static int uniqueBST_rec(int n){
        if(n<=1){
            return 1;
        }

        int ans=0;
        for(int i=1; i<=n; i++){
            int left = uniqueBST(i-1);
            int right = uniqueBST(n-i);
            // int curr_ans = uniqueBST_rec(i-1) * uniqueBST_rec(n-i);

            ans+=(left*right);
        }

        return ans;
    }
    public static int uniqueBST(int n) {
        // return uniqueBST_rec(n);
		
		int[] dp= new int[n+1];
		dp[0] = 1;
		dp[1] = 1;

		for(int i = 2;i<=n;i++){
			int left = 0;
			int right = i-1;
			while(left<i){
				dp[i] += dp[left]*dp[right];
				left++;
				right--;
			}
		}
		return dp[n];
     }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.uniqueBST(N));

    }
} 