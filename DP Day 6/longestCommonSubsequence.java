import java.util.*;

class Main {
    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);
        
        int p=sc.nextInt();             // Take size of both the strings as input
        int q=sc.nextInt();
        
        String a=sc.next();            // Take both the string as input
        String b=sc.next();
        
        Solution obj = new Solution();
        
        System.out.println(obj.lcs(p, q, a, b));

        sc.close();
    
    }
}


class Solution
{
    //Function to find the length of longest common subsequence in two strings.

	static int recur(String a,String b,int i,int j){
		if(i == a.length() || j == b.length()) return 0;
		if(a.charAt(i) == b.charAt(j)){
			return 1 + recur(a,b,i+1,j+1);
		}else{
			return Math.max(recur(a,b,i+1,j),recur(a,b,i,j+1));
		}
	}
	
    static int lcs(int x, int y, String a, String b){
        // your code here
		// return recur(a,b,0,0);
		int n = a.length();
		int m= b.length();
		int[][] dp= new int[n+1][m+1];
		for(int i = a.length();i>=0;i--){
			for(int j = b.length();j>=0;j--){
				if(i == a.length() || j == b.length()){
					dp[i][j] = 0;
					continue;
				}
				if(a.charAt(i) == b.charAt(j)){
					dp[i][j] = 1 + dp[i+1][j+1];//recur(a,b,i+1,j+1);
				}else{
					dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
				}
			}
		}
		return dp[0][0];
        
    }
    
}