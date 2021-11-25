package newcoder.wait.jindong;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),q= scanner.nextInt();
        Map<Integer,Set<Integer>> map1 = new HashMap<>();
        Map<Integer,Set<Integer>> map2 = new HashMap<>();
        for(int i=1;i<n+1;i++){
            map2.put(i,new HashSet<>());
        }
        for(int i=1;i<n+1;i++){
            int c = scanner.nextInt();
            Set<Integer> list = new HashSet<>();
            for(int j=0;j<c;j++){
                int need = scanner.nextInt();
                list.add(need);
                map2.get(need).add(i);
            }
            map1.put(i,list);
        }
        Set<Integer> alive = new HashSet<>();
        for(int i=0;i<q;i++){
            int cmd = scanner.nextInt(),server = scanner.nextInt();
            if(cmd==0){
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(server);
                while(!queue.isEmpty()){
                    int cur = queue.poll();
                    alive.remove(cur);
                    Set<Integer> set = map2.get(cur);
                    for(Integer need:set){
                        if(alive.contains(need))
                            queue.offer(need);
                    }
                }
            }
            else{

                Queue<Integer> queue = new LinkedList<>();
                queue.offer(server);
                while(!queue.isEmpty()){
                    int cur = queue.poll();
                    alive.add(cur);
                    Set<Integer> set = map1.get(cur);
                    for(Integer need:set){
                        if(!alive.contains(need))
                            queue.offer(need);
                    }
                }
            }
            System.out.println(alive.size());
        }
    }
}
