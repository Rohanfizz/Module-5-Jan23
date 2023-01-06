import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[]){
         Scanner sc = new Scanner(System.in);
         int num = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[num];
            for(int i = 0; i < num; i++)
                arr[i] = sc.nextInt();
            
            ArrayList <Integer> res = new Solution().nearlySorted(arr, num, k);
            for (int i = 0; i < res.size (); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        
    }
}


class Solution{
    ArrayList <Integer> nearlySorted(int arr[], int num, int k){
        // your code here
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int i = 0;
		while(i<arr.length && i<=k) pq.add(arr[i++]);
		ArrayList<Integer> ans = new ArrayList<>();
		while(i<arr.length){
			ans.add(pq.remove());
			pq.add(arr[i++]);
		}
		while(pq.size()>0) ans.add(pq.remove());
		return ans;
    }
}



