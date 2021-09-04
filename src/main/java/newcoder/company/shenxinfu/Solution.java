package newcoder.company.shenxinfu;

import java.util.*;
class Node{
    String beginStr,endStr;
    public Node(String beginStr,String endStr){
        this.beginStr=beginStr;
        this.endStr=endStr;
    }
}

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        input.add("1.2.3.2-1.2.3.7");
        input.add("1.2.3.1");

        //String[] strs={"1.2.3.4","1.2.3.2-1.2.3.7"};
        System.out.println(new Solution().merge(input));
    }

    List<Node> list = new LinkedList<>();
    public ArrayList<String> merge (ArrayList<String> input) {
        // write code here


        for(int i=0;i<input.size();i++){
            String cur = input.get(i);
            addIP(cur);
        }
        ArrayList<String> ans = new ArrayList<>();
        for(Node node:list){
            StringBuilder sb = new StringBuilder();
            sb.append(node.beginStr);
            if(!node.endStr.equals(node.beginStr)){
                sb.append("-").append(node.endStr);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
    public void addIP(String cur){
        Node curNode=null ;
        if(cur.contains("-")){
            String strs[] = cur.split("-");
            curNode = new Node(strs[0],strs[1]);
        }
        else{
            curNode = new Node(cur,cur);
        }

        int i=0;
        for(Node node:list){
            int cmpB2B = curNode.beginStr.compareTo(node.beginStr),cmpE2E = curNode.endStr.compareTo(node.endStr),
                cmpB2E = curNode.beginStr.compareTo(node.endStr),  cmpE2B = curNode.endStr.compareTo(node.beginStr);
            if(cmpE2B<-1){
                list.add(i,curNode);
                return;
            }
            if(cmpB2B<=0&&cmpE2E<=0){
                node.beginStr=curNode.beginStr;
                return;
            }
            if(cmpB2B<=0&&cmpE2E>=0){
                node.beginStr=curNode.beginStr;
                node.endStr=curNode.endStr;
                return;
            }
            if(cmpB2E<=0&&cmpE2E<=0){
                //node.endStr=curNode.endStr;
                return;
            }
            if(cmpB2E<=1&&cmpE2E>=0){
                node.endStr=curNode.endStr;
                return;
            }
            i++;
        }
        list.add(i,new Node(cur,cur));
    }

}
