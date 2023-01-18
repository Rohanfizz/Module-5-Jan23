
import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
{
	public static class Box{
		int l;
		int b;
		int h;
		Box(int l,int b,int h){
			this.l = l;
			this.b = b;
			this.h = h;
		}
	}
	public static boolean isValid(Box me,Box below){
		// it checks if box "me" can be placed above box "below"
		return below.l > me.l && below.b > me.b;
	}
    public static int maxHeight(int[] height, int[] width, int[] length, int n){
        //Write your code here 


		// Step 1: We need to calculate all the possible rotations of a box
		ArrayList<Box> all = new ArrayList<>();

		for(int i = 0;i<n;i++){
			// Here we'll consider length>=breadth to remove permutations
			all.add(new Box(Math.max(length[i],width[i]),Math.min(length[i],width[i]),height[i]));
			all.add(new Box(Math.max(height[i],width[i]),Math.min(height[i],width[i]),length[i]));
			all.add(new Box(Math.max(height[i],length[i]),Math.min(height[i],length[i]),width[i]));
		}
		
		//Step 2: Sort all the boxes in decreasing order of base area
		Collections.sort(all,(a,b)->{
			return (b.l*b.b) - (a.l*a.b);
		});

		//Step 3.1: Maximum Sum Increasing Subsequence on heights by using isValid function
		int[] dp = new int[3*n];
		for(int i = 0;i<3*n;i++){
			Box me = all.get(i);
			int prevBestHeight = 0;
			for(int j = i-1;j>=0;j--){
				Box prev = all.get(j);
				if(isValid(me,prev)) prevBestHeight = Math.max(prevBestHeight,dp[j]);
			}
			dp[i] = me.h + prevBestHeight;
		}

		//Step 3.2: Answer can be present on any index of dp, return maximum number
		int maxi = 0;
		for(int x: dp) maxi = Math.max(maxi,x);
		return maxi;
    }
}
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        int[] width = new int[n];
        int [] length = new int[n];
        for(int i = 0 ; i < n ; ++i){
            height[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n ; ++i){
            width[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n ; ++i){
            length[i] = sc.nextInt();
        }
        System.out.print(Solution.maxHeight(height,width,length,n));
	}
}

