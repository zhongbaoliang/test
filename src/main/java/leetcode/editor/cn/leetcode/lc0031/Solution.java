package leetcode.editor.cn.leetcode.lc0031;

public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length,idx = len-2;
        while(idx>=0&&nums[idx]>=nums[idx+1]){
            idx--;
        }

        if(idx>=0){
            int num = nums[idx],idx2 = find(nums,idx+1,len-1,num);
            nums[idx] = nums[idx2];
            nums[idx2] = num;
        }
        reverse(nums,idx+1,len-1);
    }

    public int find(int nums[],int begin,int end,int target){
        int left = begin,right = end;
        while(left<right){
            int mid = (left + right + 1)/2;
            if(nums[mid]>target)
                left = mid;
            else
                right = mid-1;

        }
        return left;
    }

    public void reverse(int []nums,int begin,int end){
        while(begin<end){
            int num = nums[begin];
            nums[begin] = nums[end];
            nums[end] = num;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        int [] nums = new int[]{5,4,7,5,3,2};
        new Solution().nextPermutation(nums);
        System.out.println(nums);
    }
}
