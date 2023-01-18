
import java.util.*;
import java.lang.*;
import java.io.*;
class Solution{
     public static int countSubstrings(String s) {
        //Write your code here 
		 int n= s.length();
		 boolean[][] dp = new boolean[n][n];
		 int count = 0;
		 
		 for(int g = 0;g<n;g++){
			 for(int i = 0,j=g;j<n;i++,j++){
				 if(g == 0) dp[i][j] = true;
				 else if(g == 1) dp[i][j] = s.charAt(i) == s.charAt(j);
				 else{
					 dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
				 }
				 count += dp[i][j]?1:0;
			 }
		 }		 
		 return count;
		 
    }
}
/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(Solution.countSubstrings(str));
	}
}

