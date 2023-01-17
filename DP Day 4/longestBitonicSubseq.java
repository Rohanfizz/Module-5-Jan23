import java.io.*;
import java.util.*; 

class Main{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; ++i){
            array[i] = sc.nextInt();
        }
        Solution ob = new Solution();
        System.out.println(ob.bitonicSequence(n,array));
    } 
} 

class Solution 
{
	static int[] dp1fun(int[] a){
		int[] dp = new int[a.length];
		TreeSet<Integer> ts = new TreeSet<>();
		for(int i = 0;i<a.length;i++){
			Integer top = ts.ceiling(a[i]);
			if(top != null) ts.remove(top);
			ts.add(a[i]);
			dp[i] = ts.size();
		}
		return dp;
	}
	static int[] dp2fun(int[] a){
		int[] dp = new int[a.length];
		TreeSet<Integer> ts = new TreeSet<>();
		for(int i = a.length-1;i>=0;i--){
			Integer top = ts.ceiling(a[i]);
			if(top != null) ts.remove(top);
			ts.add(a[i]);
			dp[i] = ts.size();
		}
		return dp;
	}
	
	
    static int bitonicSequence(int n, int arr[]){
        // code here
		int[] dp1 = dp1fun(arr);
		int[] dp2 = dp2fun(arr);
		int ans = 0;
		for(int i = 0;i<n;i++){
			ans = Math.max(ans,dp1[i] + dp2[i] - 1);
		}
		return ans;
    }
} 







