import java.io.*;
import java.util.*;
class Solution{

	static int recur(int n,int m){
		if(n <= 0) return 0;
		if(n < m) return 1;
		if(n == m) return 2;
		int verti = recur(n-1,m);
		int hori = recur(n-m,m);
		return verti + hori;
	}
	
    static int tiles(int n, int m){
        // Your code here
		if(n == 1) return 1;
		return recur(n,m);
    }
}
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        System.out.println(new Solution().tiles(n, m));
    }
}