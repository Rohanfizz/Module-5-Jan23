import java.util.*;

class Solution {

	public int recur(ArrayList<Integer> cost,int i,int j){
		if(i>j) return 0;
		int best = Integer.MAX_VALUE;
		int len = cost.get(j+1) - cost.get(i-1);
		for(int cut = i;cut<=j;cut++){
			int leftPartCost = recur(cost,i,cut-1);
			int rightPartCost = recur(cost,cut+1,j);
			int myCuttingCost = leftPartCost + len + rightPartCost;
			best = Math.min(best,myCuttingCost);
		}
		return best;
	}
	
     public int minCost(int n, int[] cuts) {
      // Write your code here
		 Arrays.sort(cuts);
		 ArrayList<Integer> cost = new ArrayList<>();
		 cost.add(0);
		for(int x: cuts) cost.add(x);
		 cost.add(n);
		 return recur(cost,1,cuts.length);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();
        int arr[] = new int[M];
        for(int i=0; i<M; i++){
            arr[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.minCost(N,arr));

    }
}