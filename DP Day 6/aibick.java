
import java.util.*;
import java.lang.*;
import java.io.*;
class Solution{
    public static int fun(String s){
        //write your code here
		int md = (int) 1e9 + 7;
		int prevA = 0;
		int prevB = 0;
		int prevC = 0;
		for(int i = 0;i<s.length();i++){
			char c = s.charAt(i);
			if(c == 'a'){
				prevA = (((2%md)*(prevA%md))%md + 1)%md;
			}else if(c == 'b'){
				prevB = (((2%md)*(prevB%md))%md + prevA)%md;
			}else{
				prevC = (((2%md)*(prevC%md))%md + prevB)%md;
			}
		}
		return prevC%md;
    }

}
/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        String s = sc.next() ; 
        System.out.print(Solution.fun(s));
        
	}
}

