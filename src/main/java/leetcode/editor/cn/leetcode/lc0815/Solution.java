package leetcode.editor.cn.leetcode.lc0815;

import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)return 0;
        Map<Integer,List<Integer>> map = new HashMap<>();//站点，经过该站点的所有车次
        int m = routes.length,ans = 1;
        boolean[] visit = new boolean[m];
        Queue<Integer> busQ = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<routes[i].length;j++){
                List<Integer> list = map.getOrDefault(routes[i][j],new LinkedList<>());
                list.add(i);
                map.put(routes[i][j],list);
                if(routes[i][j]==source){
                    busQ.offer(i);
                    visit[i] = true;
                }
            }
        }
        while(!busQ.isEmpty()){
            int len = busQ.size();
            while(len-->0){
                Integer bus = busQ.poll();
                for(int j=0;j<routes[bus].length;j++){
                    if(routes[bus][j]==target)return ans;
                    List<Integer> list = map.get(routes[bus][j]);
                    for(Integer busi : list){
                        if(!visit[busi]){
                            busQ.offer(busi);
                            visit[busi] = true;
                        }
                    }

                }
            }
            ans++;
        }
        return -1;

    }

    public static void main(String[] args) {
        int [][] routes = {{1,2,7},{3,6,7}};
        System.out.println(new Solution().numBusesToDestination(routes,1,6));
    }
}
