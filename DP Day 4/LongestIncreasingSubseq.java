import java.io.*;
import java.util.*; 

class Main{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; ++i){
            array[i] = sc.nextInt();
        }
        Solution ob = new Solution();
        System.out.println(ob.longestIncreasingSubsequence(n,array));
    } 
} 

class Solution 
{

	static int recur(int[] a, int idx){
		if(idx == 0) return 1;
		int myAns = 0;
		for(int j = 0;j<idx;j++){
			if(a[j] >= a[idx]) continue;
			int theirAns = recur(a,j);
			myAns = Math.max(myAns,theirAns + 1);
		}
		return myAns;
	}

	static int bceil(ArrayList<Integer> a,int x){
		int l = 0;
		int r = a.size()-1;
		while(l<=r){
			int mid = l+(r-l)/2;
			if(a.get(mid) == x) return mid;
			else if(a.get(mid) < x) l= mid+1;
			else r = mid-1;
		}
		return l;
	}
	
	static int solve(int[] a){
		ArrayList<Integer> decks = new ArrayList<>();
		for(int i = 0;i<a.length;i++){
			int deckIdx = bceil(decks,a[i]);
			if(deckIdx != decks.size()){
				decks.set(deckIdx,a[i]);
			}else decks.add(a[i]);
		}
		return decks.size();
	}
	
    static int longestIncreasingSubsequence(int size, int a[]){
        // code here

		return solve(a);
		
    }
} 

