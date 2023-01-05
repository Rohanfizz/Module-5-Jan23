import java.util.*;
import java.lang.*; 
import java.io.* ;
class Solution{

	public static void printKthSmallest(int arr[],int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0;i<arr.length;i++){
			pq.add(arr[i]);
			if(pq.size()>k) pq.remove();
		}
		System.out.println(pq.peek());
	}
	public static void printKthLargest(int arr[],int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<arr.length;i++){
			pq.add(arr[i]);
			if(pq.size()>k) pq.remove();
		}
		System.out.println(pq.peek());
	}
	
    public static void kSmallLarge( int arr [], int n, int k){
       //Write your code and print here
		printKthSmallest(arr,k);
		printKthLargest(arr,k);
    }
}
public class Main{
   public static void main(String args[]){
      
      int n;
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      int arr[]=new int[n]; 
      for(int i=0; i<n; i++){
         arr[i]=sc.nextInt();
      }

      int k; 
      k=sc.nextInt(); 

      Solution obj= new Solution();
      obj.kSmallLarge(arr,n, k);


   }
}