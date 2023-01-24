import java.util.*;
public class Main{

	public static class Pair{
		int idx;
		String psf;
		Pair(int idx,String psf){
			this.idx = idx;
			this.psf = psf;
		}
	}
    
    public static void solution(int []arr){
        //write your code here
		int n = arr.length;
		int[] dp = new int[n];
		int maxLisValue = 0;
		for(int i = 0;i<n;i++){
			int maxi = 0;
			for(int j = i-1;j>=0;j--){
				if(arr[i] >= arr[j]) maxi = Math.max(maxi,dp[j]);
			}
			dp[i] = maxi + 1;
			maxLisValue = Math.max(maxLisValue,dp[i]);
		}

		System.out.println(maxLisValue);
		Queue<Pair> q = new LinkedList<>();
		ArrayList<String> ans = new ArrayList<>();
		for(int i = 0;i<n;i++){
			if(dp[i] == maxLisValue) q.add(new Pair(i,arr[i] + ""));
		}

		while(q.size()>0){
			Pair p = q.remove();
			int idx = p.idx;
			String psf = p.psf;

			int myVal = arr[idx];
			int dpVal = dp[idx];

			if(dpVal == 1){
				ans.add(psf);
				continue;
			}

			for(int i = idx-1;i>=0;i--){
				if(arr[i] <= myVal && dp[i]==dpVal-1){
					q.add(new Pair(i,arr[i]+" "+psf));
				}
			}
		}
		Collections.sort(ans);
		for(String s: ans){
			System.out.println(s);
		}
		
    }
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}