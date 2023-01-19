import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1 = sc.next(), s2 = sc.next();
    sc.close();
    System.out.println(editDistance(s1, s2));
  }

	public static int recur(String s1,String s2,int i,int j){

		if(i == s1.length() && j == s2.length()) return 0;
		if(i == s1.length()) return s2.length()-j;
		if(j == s2.length()) return s1.length()-i;
		
		if(s1.charAt(i) == s2.charAt(j)){
			return recur(s1,s2,i+1,j+1);
		}else{
			int insert = 1 + recur(s1,s2,i,j+1);
			int replace = 1 + recur(s1,s2,i+1,j+1);
			int delete = 1 + recur(s1,s2,i+1,j);
			return Math.min(insert,Math.min(replace,delete));
		}
	}

	public static int tab(String s1,String s2){
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n+1][m+1];

		for(int i = n;i>=0;i--){
			for(int j = m;j>=0;j--){
				if(i == s1.length() && j == s2.length()) dp[i][j] = 0;
				else if(i == s1.length()) dp[i][j] = s2.length()-j;
				else if(j == s2.length()) dp[i][j] = s1.length()-i;
				else if(s1.charAt(i) == s2.charAt(j)){
					dp[i][j] = dp[i+1][j+1];// recur(s1,s2,i+1,j+1);
				}else{
					int insert = 1 +dp[i][j+1];     // recur(s1,s2,i,j+1);
					int replace = 1 + dp[i+1][j+1]; //recur(s1,s2,i+1,j+1);
					int delete = 1 + dp[i+1][j];    //recur(s1,s2,i+1,j);
					dp[i][j] = Math.min(insert,Math.min(replace,delete));
				}
			}
		}
		return dp[0][0];
		
	}
	
  public static int editDistance(String s1, String s2) {
    // your code here
	  // return recur(s1,s2,0,0);
	  return tab(s1,s2);
  }

}