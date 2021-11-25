package leetcode.editor.cn.JZ.JZ105;

import java.util.*;
//回溯
class Solution {
    Map<Integer,List<int[]>> map = new HashMap<>();
    List<Set<Integer>> sets = new LinkedList<>();
    int max=0;
    int[][] arr=null;
    public int maxAreaOfIsland(int[][] grid) {
        this.arr=grid;
        int idx=1;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1) {
                    if ((i > 0 && arr[i - 1][j] != 0) && (j > 0 && arr[i][j - 1] != 0)) {//左、上都被标记
                        if (arr[i - 1][j] == arr[i][j - 1]) {//标记相同
                            arr[i][j] = arr[i - 1][j];
                            addOne(arr[i - 1][j], new int[]{i, j});
                        } else {
                            //arr[i][j] = arr[i - 1][j] < arr[i][j - 1] ? arr[i - 1][j] : arr[i][j - 1];
                            merge(i, j);//标记不同
                        }
                        continue;
                    }
                    if (i > 0 && arr[i - 1][j] != 0) {//左边被标记
                        arr[i][j] = arr[i - 1][j];
                        addOne(arr[i - 1][j], new int[]{i, j});
                        continue;
                    }
                    if (j > 0 && arr[i][j - 1] != 0) {//上边被标记
                        arr[i][j] = arr[i][j - 1];
                        addOne(arr[i][j - 1], new int[]{i, j});
                    } else {//左、上都没有被标记
                        List<int[]> listi = new LinkedList<int[]>();
                        listi.add(new int[]{i, j});
                        idx++;
                        map.put(idx, listi);
                        arr[i][j] = idx;
                        if (listi.size() > max) max = listi.size();
                    }
                }
            }
        }
        return max;

    }


    public void addOne(int key,int[] pair){
        List<int[]> listi = map.get(key);
        listi.add(pair);
        if(listi.size()>max)max=listi.size();

    }

    public void merge(int i,int j){
        if(arr[i - 1][j] < arr[i][j - 1]){
            arr[i][j] = arr[i - 1][j];
            addTomMin(arr[i - 1][j] , arr[i][j - 1],new int[]{i,j});

        }
        else{
            arr[i][j] = arr[i][j-1];
            addTomMin(arr[i][j-1] , arr[i-1][j],new int[]{i,j});

        }
    }
    public void addTomMin(int minKey,int key,int[] pair){
        List<int[]> des = map.get(minKey);
        List<int[]> list = map.get(key);
        for(int[] it:list){
            arr[it[0]][it[1]]=minKey;
        }
        des.add(pair);
        des.addAll(map.get(key));
        map.remove(key);
        if(des.size()>max)max=des.size();
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                /*{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}*/
                {0,1},
                {1,1},
                {1,0}

        };
        System.out.println(new Solution().maxAreaOfIsland(arr));
    }
}