package leetcode.editor.cn.JZ105;

import java.util.*;
//并查集
class Solution1 {
    List<Set<Integer>> sets = new LinkedList<>();
    Map<Integer,Integer> map = new HashMap<>();
    int max=0;
    public int maxAreaOfIsland(int[][] grid) {

        int idx=1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    if ((i > 0 && grid[i - 1][j] != 0) && (j > 0 && grid[i][j - 1] != 0)) {//左、上都被标记
                        if(grid[i - 1][j] == grid[i][j - 1]) {
                            grid[i][j] = grid[i - 1][j];
                            addOne(grid[i][j]);
                        }
                        else {
                            int minKey = grid[i - 1][j] < grid[i][j - 1] ? grid[i - 1][j] : grid[i][j - 1];
                            int key = grid[i - 1][j] > grid[i][j - 1] ? grid[i - 1][j] : grid[i][j - 1];
                            grid[i][j] = minKey;
                            //addOne(grid[i][j]);
                            map.put(minKey, map.get(minKey) + 1);
                            merge(minKey, key);//标记不同
                        }
                        continue;
                    }
                    if (i > 0 && grid[i - 1][j] != 0) {//上边被标记
                        grid[i][j] = grid[i - 1][j];
                        addOne(grid[i][j]);
                        continue;
                    }
                    if (j > 0 && grid[i][j - 1] != 0) {//左边被标记
                        grid[i][j] = grid[i][j - 1];
                        addOne(grid[i][j]);

                    }
                    else {//左、上都没有被标记
                        idx++;
                        Set<Integer> seti = new HashSet<>();
                        seti.add(idx);
                        sets.add(seti);
                        map.put(idx,1);
                        grid[i][j] = idx;
                        max=max>1?max:1;
                    }
                }
            }
        }
        return max;
    }
    public void addOne(int key){
        map.put(key,map.get(key) + 1);

        Set<Integer> setOfKey = new HashSet<>();
        for(Set<Integer> seti:sets){
            if(seti.contains(key)) {
                setOfKey = seti;
                break;
            }
        }
        int size = 0;
        for(Integer keyi:setOfKey){
            size+=map.get(keyi);
        }
        max=max>size?max:size;
    }

    public void merge(int minKey,int key){//合并集合
        Set<Integer> setOfMinKey = new HashSet<>(),setOfKey = new HashSet<>();
        for(Set<Integer> seti:sets){
            if(seti.contains(minKey))setOfMinKey = seti;
            if(seti.contains(key)) setOfKey = seti;
        }
        if(setOfKey!=setOfMinKey) {//两个key不在同一个集合
            setOfMinKey.addAll(setOfKey);
            sets.remove(setOfKey);
        }
        int size = 0;
        for(Integer keyi:setOfMinKey){
            size+=map.get(keyi);
        }
        max=max>size?max:size;

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,1,1,1,1,0,0},
                {0,0,0,0,0,0,1,1,1,0,0},
                {0,0,0,0,1,1,0,0,1,1,1},
                {1,0,1,1,1,1,1,0,1,1,0},
                {1,1,1,0,1,1,1,1,1,0,0},
                {1,0,0,0,0,0,1,0,0,0,0},
                {1,1,0,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0}


        };
        System.out.println(new Solution1().maxAreaOfIsland(arr));
    }
}