import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

	public static void solve(ArrayList<Integer> a,int tar,int i,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> curr){
		if(tar == 0){
			ans.add(new ArrayList<>(curr));
			return;
		}
		if(tar<0) return;
		if(i == a.size()) return;

		curr.add(a.get(i));
		solve(a,tar-a.get(i),i+1,ans,curr);
		curr.remove(curr.size()-1);
		int currVal = a.get(i);
		while(i<a.size() && a.get(i) == currVal) i++;
		solve(a,tar,i,ans,curr);
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int sum){
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> curr = new ArrayList<>();
        Collections.sort(a);	
		solve(a,sum,0,ans,curr);
        return ans;
    }
    
    // public static void solver(ArrayList<ArrayList<Integer>> al, ArrayList<Integer> in, ArrayList<Integer> op, int i, int sum){
        
    //     if(sum < 0)     return;
        
    //     if(i == in.size()){
            
    //         if(sum == 0)      al.add(op);
    //         return;
    //     }
        
    //     ArrayList<Integer> op1 = new ArrayList<Integer>(op);
    //     op1.add(in.get(i));
    //     solve(al, in, op1, i + 1, sum - in.get(i));
        
    //     if(!(op.size() != 0 && in.get(i) == op.get(op.size() - 1))){
            
    //         ArrayList<Integer> op2 = new ArrayList<Integer>(op);
    //         solve(al, in, op2, i + 1, sum);
    //     }
    // }
  
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    
	    	int n = sc.nextInt();
			ArrayList<Integer> a=new ArrayList<Integer>();
			for(int i=0;i<n;i++)
			{
				a.add(sc.nextInt());
			}
			int sum = sc.nextInt();

	    	ArrayList<ArrayList<Integer>> ans = combinationSum(a, sum);
			Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
				public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
					for(int i=0;i<Math.min(o1.size(),o2.size());i++)
					if(o1.get(i)!=o2.get(i))
					return o1.get(i).compareTo(o2.get(i));
					
					return o1.size()>o2.size()?1:0;
				}
				
			});
			for(ArrayList<Integer> A : ans)
			{
				for(Integer B : A)
				{
					System.out.print(B+" ");
				}
				System.out.println();
			}
		
	}
}