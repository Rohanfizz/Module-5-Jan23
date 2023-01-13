import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int[] boxes, int ci, int ti){
    if(ci > ti){
		// print boxes and return 
		for(int j=0; j<boxes.length; j++){
			System.out.print(boxes[j]);
		}
		System.out.println();
		return;
	}

	  for(int i=0; i<boxes.length; i++){
		  if(boxes[i]==0){
			  boxes[i] = ci;
			  permutations(boxes, ci + 1, ti);
			  boxes[i] = 0;
		  }
	  }
  }

	public static void solve(int boxes,int items,boolean[] vis,String asf){

		if(boxes<items) return;
		if(boxes == 0){
			System.out.println(asf);
			return;
		}
		
		// we will try to place an item here
		for(int i = 1;i<vis.length;i++){
			if(vis[i]) continue;
			vis[i] = true;
			solve(boxes-1,items-1,vis,asf+(i));
			vis[i] = false;
		}
		// we will try to skip placing an item here
		solve(boxes-1,items,vis,asf+"0");
	}
	
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int R = Integer.parseInt(br.readLine());
	  boolean[] vis = new boolean[R+1];
	  solve(N,R,vis,"");
    // permutations(new int[N], 1, R);
  }

}

//ti = total items
//ci = current item