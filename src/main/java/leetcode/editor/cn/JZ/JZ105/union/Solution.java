package leetcode.editor.cn.JZ.JZ105.union;

class Solution {
    class UnionFind{
        int father[],rank[],count;
        public UnionFind(char grid[][]){
            int m = grid.length,n = grid[0].length,len = m*n;
            father = new int[len];
            rank = new int[len];
            count = 0;
            for(int i =0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]=='1'){
                        count++;
                        father[i*n+j] = i*n+j;
                        rank[i*n+j] = 1;
                    }
                }
            }
        }

        public int findRoot(int cur){
            return cur==father[cur]?cur:(father[cur]=findRoot(father[cur]));
        }

        public void merge(int a,int b){
            int aRoot = findRoot(a),bRoot = findRoot(b);
            if(aRoot!=bRoot) {
                if (rank[aRoot] > rank[bRoot]) {
                    father[bRoot] = aRoot;
                } else if (rank[aRoot] == rank[bRoot]) {
                    father[bRoot] = aRoot;
                    rank[aRoot]++;
                } else {
                    father[aRoot] = bRoot;
                }
                count--;
            }
        }
        public int getNumIslands(){
            return count;
        }
    }




    public int numIslands(char[][] grid) {
        int m = grid.length,n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        //int step[] = new int[]{-1,0,1,0,-1};
        int step[] = new int[]{1,0,1};//right ,bottom
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]=='1'){
                    //grid[i][j] = '0';
                    for(int k=0;k<2;k++){
                        int nxti = i+step[k],nxtj = j+step[k+1];
                        if(nxti>=0&&nxti<m&&nxtj>=0&&nxtj<n&&grid[nxti][nxtj]=='1'){
                            uf.merge(i*n+j,nxti*n+nxtj);
                        }
                    }
                }
            }
        }
        return uf.getNumIslands();
    }


    public static void main(String[] args) {
        char grid[][] = new char[][]{{'1', '1','1','1','0'},
                    {'1', '1', '0', '1', '0'},
                {  '1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new Solution().numIslands(grid));
    }
}