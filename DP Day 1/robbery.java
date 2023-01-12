import java.util.*;

class Solution {
	public int recur(int[] a,int idx){
		if(idx>=a.length) return 0;
		int include = a[idx] + recur(a,idx+2);
		int exclude = recur(a,idx+1);
		return Math.max(include,exclude);
	}
	public int optimizedCode(int[] a){
		int prevInc = a[0];
		int prevExc = 0;
		for(int i = 1;i<a.length;i++){
			int meInc = a[i] + prevExc;
			int meExc = Math.max(prevInc,prevExc);
			prevInc = meInc;
			prevExc = meExc;
		}
		return Math.max(prevInc,prevExc);
	}
	
    public int maxAmount(int[] a) {
        //write code here
		// return recur(a,0);
		return optimizedCode(a);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.maxAmount(a));
        sc.close();
    }
}
