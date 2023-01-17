class Solution {
    public int maxEnvelopes(int[][] a) {
        Arrays.sort(a,(x,y)->{
            if(x[0] == y[0]) return y[1] - x[1];
            return x[0] - y[0];
        });

        TreeSet<Integer> ts = new TreeSet<>();
        for(int i = 0;i<a.length;i++){
            int me = a[i][1];
            Integer top = ts.ceiling(me);
            if(top != null) ts.remove(top);
            ts.add(me);
        }
        return ts.size();
    }
}