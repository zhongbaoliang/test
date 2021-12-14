package leetcode.editor.cn.JZ.JZ105.union;

class Solution4 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind u = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                if (grid[i][j] == 0) {
                    u.area[index] = 0;
                } else {
                    u.maxArea = Math.max(u.maxArea, 1);
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        u.merge(index, (i - 1) * n + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        u.merge(index, i * n + j - 1);
                    }
                }
            }
        }
        return u.maxArea;
    }
    public class UnionFind {
        int fa[];
        int rank[];
        int area[];
        int maxArea = 0;
        public UnionFind(int n) {
            fa = new int[n];
            rank = new int[n];
            area = new int[n];
            for(int i = 0; i < n; ++i){
                fa[i] = i;
                rank[i] = 1;
                area[i] = 1;
            }
        }
        public int find(int x) {
            return fa[x] == x ? x : (fa[x] = find(fa[x]));

        }
        public void merge(int p, int q) {
            int pRoot = find(p), qRoot = find(q);
            if (pRoot != qRoot) {
                if (rank[pRoot] > rank[qRoot]) {
                    fa[qRoot] = pRoot;
                    area[pRoot] += area[qRoot];
                } else if (rank[pRoot] < rank[qRoot]) {
                    fa[pRoot] = qRoot;
                    area[qRoot] += area[pRoot];
                } else {
                    fa[pRoot] = qRoot;
                    rank[qRoot]++;
                    area[qRoot] += area[pRoot];
                }
                maxArea = Math.max(maxArea, Math.max(area[pRoot], area[qRoot]));
            }
        }
    }
}
