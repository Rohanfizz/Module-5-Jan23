//https://course.acciojob.com/idle?question=adf548b4-b1e3-48ab-a427-579fa50c0571
import java.util.*;

class Solution {
    boolean checkHeap(int arr[]) {
        int n = arr.length;
        for (int i = 0; i <= (n - 2) / 2; i++) {
            if (arr[2 * i + 1] < arr[i]) {
                return false;
            }

            if (2 * i + 2 < n && arr[2 * i + 2] < arr[i]) {
                return false;
            }
        }
        return true;
    }
	void swap(int arr[],int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	void downheapify(int arr[],int pi){
		int lci = 2*pi+1;
		int rci = 2*pi+2;
		int mini = pi;
		if(lci<arr.length && arr[lci] < arr[mini]) mini = lci;
		if(rci<arr.length && arr[rci] < arr[mini]) mini = rci;
		if(mini != pi){
			swap(arr,pi,mini);
			downheapify(arr,mini);
		}
	}
	
    void buildHeap(int arr[]) {
        //Write code here
		for(int i = arr.length-1;i>=0;i--){
			downheapify(arr,i);
		}
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.buildHeap(arr);
        if (Obj.checkHeap(arr)) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }
        sc.close();
    }
}