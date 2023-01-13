import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(boolean[] boxes, int ci, int ti, int lb){
    // write your code here
  }

	public static void solve(int boxes,int items,String asf){

		if(boxes<items) return;
		if(boxes == 0){
			System.out.println(asf);
			return;
		}
		
		// i want to place an item here
		if(items>0)solve(boxes-1,items-1,asf+"i");
		// i dont want to place an item here
		solve(boxes-1,items,asf+"-");
	}
	
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int R = Integer.parseInt(br.readLine());
    // combinations(new boolean[N], 1, R, -1);
	  solve(N,R,"");
  }

}

//ci - current index of item
//ti - total index of items
//lb - last box index