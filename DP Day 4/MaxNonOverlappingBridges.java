import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] bridges = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bridges[i][0] = Integer.parseInt(st.nextToken());
            bridges[i][1] = Integer.parseInt(st.nextToken());
        }
        Solution s = new Solution();
        System.out.println(s.maxPossibleBridges(bridges));
    }
}

class Solution {

	public int lis(int[][] a){
		TreeSet<Integer> ts = new TreeSet<>();
		for(int i = 0;i<a.length;i++){
			int me= a[i][1];
			Integer top = ts.ceiling(me);
			if(top != null) ts.remove(top);
			ts.add(me);
		}
		return ts.size();
	}
	
    public int maxPossibleBridges(int[][] a) {
		Arrays.sort(a,(x,y)->{
			return x[0]-y[0];
		});
		return lis(a);
    }
}

