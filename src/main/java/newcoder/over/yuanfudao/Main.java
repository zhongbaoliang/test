package newcoder.over.yuanfudao;

import java.util.*;
class Relation {
    int parent;
    int child;
}

class TreeNode {
    int val;
    List<TreeNode> children;
    TreeNode(int v){
        val=v;
        children = new LinkedList<>();
    }
}

public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
       // solve(new int[][]{{2,3},{2,4},{2,5},{1,2},{1,6},{6,7},{6,8},{8,9}});
        System.out.println("Hello World!");
    }
/*
    public static TreeNode solve(int[][] arr){
        if(arr==null||arr.length==0)return null;
        int len = arr.length;
        TreeNode root = null;
        Set<Integer> pa = new HashSet<>(), chi = new HashSet<>();
        for(int i=0;i<len;i++){
            pa.add(arr[i][0]);
            chi.add(arr[i][1]);
        }
        for(Integer integer:chi)
            pa.remove(integer);
        int rootVal = 0;
        for(Integer integer: pa)
            rootVal=integer;
        root = new TreeNode(rootVal);

        Map<Integer,LinkedList<Integer>> map = new HashMap<>();
        map.put(rootVal,new LinkedList<>());
        for(int i=0;i<len;i++){
            LinkedList<Integer> list = null;
            if(map.get(arr[i][0])!=null){
                list = map.get(arr[i][0]);
            }
            else{
                list = new LinkedList();
            }
            map.put(arr[i][0],list);
        }
        return build(map,rootVal);


    }*/

    public static TreeNode build(Map<Integer,LinkedList>map, int rootVal){
        return null;
    }

}