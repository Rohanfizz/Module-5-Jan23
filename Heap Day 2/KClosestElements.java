class Solution {

    public class Helper{
        int val;
        int dist;
        Helper(int val,int dist){
            this.val = val;
            this.dist = dist;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Helper> pq = new PriorityQueue<>((a,b)->{
            if(a.dist == b.dist) return b.val-a.val;
            return b.dist-a.dist;
        });
        for(int num: arr){
            pq.add(new Helper(num,Math.abs(num-x)));
            if(pq.size()>k) pq.remove();
        }
        List<Integer> ans = new ArrayList<>();
        while(pq.size() > 0){
            Helper top = pq.remove();
            ans.add(top.val);
        }
        // Collections.sort(ans);
        return ans;
    }
}