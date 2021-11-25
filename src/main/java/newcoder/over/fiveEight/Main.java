package newcoder.over.fiveEight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public int[] find (int[] arg) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arg.length;i++){
            Integer count = map.get(arg[i]);
            if(count==null)
                map.put(arg[i],1);
            else
                map.put(arg[i],2);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<arg.length;i++){
            if(map.get(arg[i])==1)arr.add(arg[i]);
        }

        return arr.stream().mapToInt(k->k).toArray();


    }

    public int[] subArraySum (int[] Array, int arrayLen, int subArrayLen) {
        // write code here

        int sum=0;
        for(int i=0;i<subArrayLen;i++){
            sum+=Array[i];
        }
        int max = sum,begin = 0;
        for(int i=subArrayLen;i<arrayLen;i++){
            sum+=Array[i];
            sum-=Array[i-subArrayLen];
            if(sum>max){
                max=sum;
                begin=i-subArrayLen+1;
            }
        }
        return new int[]{begin,max};
    }

    public int getTeams (int[] heros) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<5;i++)
            map.put(i,0);
        for (int i = 0; i < heros.length; i++) {
            map.put(heros[i],map.get(heros[i])+1);
        }
        int ans=1;
        for(Map.Entry entry : map.entrySet()){
            ans*=(Integer)entry.getValue();
        }
        return ans;
    }

}
