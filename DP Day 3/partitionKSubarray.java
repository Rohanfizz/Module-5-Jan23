import java.util.*;

class Solution {

	public int recur(int n,int k){
		int md = 100007;
		if(n == k) return 1;
		if(k == 1) return 1;
		if(n<k) return 0;

		int newGroup = recur(n-1,k-1);
		int mergeGroup = recur(n-1,k);
		return (newGroup%md + ((k%md)*(mergeGroup%md))%md)%md;
	}
	
    public int kSubarrayWay(int n, int k) {
        //write your code here
		return recur(n,k);
		
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int K= sc.nextInt();

        
        Solution Obj = new Solution();
        System.out.println(Obj.kSubarrayWay(N,K));

    }
}