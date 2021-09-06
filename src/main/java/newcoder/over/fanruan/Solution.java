package newcoder.over.fanruan;


import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 寻找两点之间的最短路径
     * @param start int整型一维数组 起点, 数组长度2，位置0为x轴，位置1为y轴
     * @param end int整型一维数组 终点 ，数组长度2，位置0为x轴，位置1为y轴
     * @return int整型
     */
    public int[][] value = new int[][]{
            {0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0},
            {0,1,1,1,0,0,0,0,1,0,0},
            {0,1,0,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,0,1,0,0,0},
            {0,0,0,1,1,1,1,1,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0}
    };
    public boolean tag[][]=new boolean[11][11];
    public int nexts[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public int findMinPath (int[] start, int[] end) {
        // write code here
        Queue<int[]> queue = new LinkedList<>();
        if(start[0]==end[0]&&start[1]==end[1])return 0;
        queue.offer(start);
        int step = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            step++;
            for(int i=0;i<len;i++){
                int[] cur = queue.poll();
                tag[cur[0]][cur[1]]=true;

              //  if(cur[0]==end[0]&&cur[1]==end[1])return step;
               // if(cur[0]==end[0]&&cur[1]==end[1])return step;
                for(int j=0;j<4;j++){
                    int nextX = cur[0]+nexts[j][0];
                    int nextY = cur[1]+nexts[j][1];
                    if(nextX<0||nextX>10||nextY<0||nextY>10)continue;
                    if(nextX==end[0]&&nextY==end[1])return step;
                    if(!tag[nextX][nextY]&&value[nextX][nextY]==0){
                        queue.offer(new int[]{nextX,nextY});
                    }

                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinPath(new int[]{1,1},new int[]{2,3}));
    }


}