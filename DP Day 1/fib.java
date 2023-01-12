import java.io.*;
import java.util.*;
public class Main {
    public static int fib(int n,int[] memo){
        //Write code here
		if(n<=1) return n;
		if(memo[n] > 0) return memo[n];
		
		int prev = fib(n-1,memo);
		int prevprev = fib(n-2,memo);
		
		memo[n] = prev + prevprev;
		
		return memo[n];
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
		int[] memo = new int[n+1];
        System.out.println(fib(n,memo));
    }
}