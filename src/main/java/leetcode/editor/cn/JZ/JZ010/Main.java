package leetcode.editor.cn.JZ.JZ010;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int subarraySum1(int[] nums, int k) {
        int len = nums.length,ans=0,sum=0,arr[] = new int[len+1];

        for(int i=1;i<len+1;i++){
            arr[i]=arr[i-1]+nums[i-1];
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=1;i<len+1;i++){
            int target = arr[i]-k;
            Integer count = map.get(target);
            if(count!=null)
                ans+=count;
            count = map.get(arr[i]);
            if(count==null){
                map.put(arr[i],1);
            }
            else
                map.put(arr[i],count+1);


        }
        return ans;

    }

    public int subarraySum(int[] nums, int k) {
        int len = nums.length,ans=0,sum=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<len;i++){
            sum+=nums[i];
            int target = sum-k;
            Integer count = map.get(target);
            if(count!=null)
                ans+=count;
            count = map.get(sum);
            if(count==null){
                map.put(sum,1);
            }
            else
                map.put(sum,count+1);
        }
        return ans;
    }
}
