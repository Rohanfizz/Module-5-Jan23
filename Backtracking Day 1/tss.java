import java.util.*;

public class Main {

	public static void getAllSubsets(int[] arr,int i,int tar,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> curr){
		if(tar == 0){
			ArrayList<Integer> nans =new ArrayList<>();
			for(int x: curr) nans.add(x);
			ans.add(nans);
			return;
		}
		if(tar<0) return;
		if(i == arr.length)  return;
		curr.add(arr[i]);
		getAllSubsets(arr,i+1,tar-arr[i],ans,curr);
		curr.remove(curr.size()-1);
		getAllSubsets(arr,i+1,tar,ans,curr);
	}
	
    public static ArrayList<ArrayList<Integer>> findSubsets(int[] arr, int tar) {
        // write code here
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> curr= new ArrayList<>();
		getAllSubsets(arr,0,tar,ans,curr);
		return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, tar;
        n = sc.nextInt();
        tar = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        ArrayList<ArrayList<Integer>> subsets = findSubsets(arr, tar);
        Collections.sort(subsets, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        if (subsets.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < subsets.size(); i++) {
                for (int j = 0; j < subsets.get(i).size(); j++)
                    System.out.print(subsets.get(i).get(j) + " ");
                System.out.println();
            }
        }
        sc.close();
    }
}