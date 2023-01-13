class Solution {

    public int[] di = {-1,0,1,0};
    public int[] dj = {0,-1,0,1};

    public int findPaths(int[][] grid,int i,int j,int validPlaces,boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;

        if(i<0 || i>=n || j<0 || j>=m || vis[i][j]) return 0;
        if(grid[i][j] == 2) {
            if(validPlaces == 1) return 1;
            return 0;
        }
        if(grid[i][j] == -1) return 0;

        int myAns = 0;
        vis[i][j] = true;
        for(int d = 0;d<4;d++){
            int ni = i+di[d];
            int nj = j+dj[d];
            myAns+=findPaths(grid,ni,nj,validPlaces-1,vis);
        }
        vis[i][j] = false;
        return myAns;
    }

    public int uniquePathsIII(int[][] grid) {
        int si = -1, sj = -1;
        int validPlaces = 0;
        for(int i= 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1) {si = i;sj = j;}
                if(grid[i][j]>-1) validPlaces++;
            }
        }

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        return findPaths(grid,si,sj,validPlaces,vis);
    }
}