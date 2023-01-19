import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        String p = br.readLine();
        Solution sol = new Solution();
        System.out.println(sol.numberOfOccurrences(s, p));
    }
}

class Solution {
    public int numberOfOccurrences(String s, String p) {
		int n= s.length();
		int m = p.length();
		int md = (int)1e9 + 7;
		int[][] dp = new int[n+1][m+1];
		for(int i = n;i>=0;i--){
			for(int j = m;j>=0;j--){
				if(j == m) dp[i][j] = 1;
				else if(i == n) dp[i][j] = 0;
				else if(s.charAt(i) == p.charAt(j)){
					int use = dp[i+1][j+1];
					int notuse = dp[i+1][j];
					dp[i][j] = (use%md + notuse%md)%md;
				}else{
					dp[i][j] = dp[i+1][j]%md;
				}
			}
		}
		return dp[0][0]%md;
    }
}