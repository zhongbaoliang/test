package leetcode.editor.cn.JZ.JZ007;

import java.util.*;

public class Main {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len-2;i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            int sum = -nums[i];
            int left = i+1,right = len-1;
            while(left<right){
                int sumi = nums[left] + nums[right];
                if(sum == sumi){

                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    left++;
                    right--;
                    while(left<right){
                        if(nums[left]==nums[left-1])left++;
                        else break;
                    }
                    while(left<right){
                        if(nums[right]==nums[right+1])right--;
                        else break;
                    }
                }
                else if(sum>sumi){
                    left++;
                }
                else
                    right--;
            }
        }
        return ans;
    }
}
