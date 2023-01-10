import java.util.*;
class Solution {

	public void solve(int[] nums,int tar,int i,List<List<Integer>> ans,List<Integer> curr){
		if(tar == 0){
			ans.add(new ArrayList<>(curr));
			return;
		}
		if(tar<0) return;
		if(i==nums.length) return;

		curr.add(nums[i]);
		solve(nums,tar-nums[i],i,ans,curr);
		curr.remove(curr.size()-1);
		solve(nums,tar,i+1,ans,curr);
	}

	
    public List<List<Integer>> combinationSum(int[] nums, int target){
        //write your code here
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();
		solve(nums,target,0,ans,curr);
		return ans;
    } 
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int []nums = new int[n];
        for(int i = 0 ; i < n ; ++i){
            nums[i] = sc.nextInt();
        }
        Solution ob = new Solution();
        List<List<Integer>> ans = ob.combinationSum(nums,target);
        for(int i = 0 ; i < ans.size() ; ++i){
            Collections.sort(ans.get(i));
        }
        Collections.sort(ans, (o1, o2) -> {
                int m = Math.min(o1.size(), o2.size());
                for (int i = 0; i < m; i++) {
                    if (o1.get(i) == o2.get(i)){
                        continue;
                    }else{
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 1;
            });
        for (int i = 0; i < ans.size (); i++)
            {
                for (int j = 0; j < ans.get(i).size (); j++)
                {
                    System.out.print(ans.get(i).get(j)+" ");
                }
                System.out.println();

            }


    }
}