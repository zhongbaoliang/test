package newcoder.over.huawei;
//int arr[] = new int[]{1,2,3,1,1,1};
//int k=6;和等于k,长度最长的子数组长度
//
public class Solution {
    public int getMaxLength(int[] arr,int k){
        int max = 0,sum = arr[0],left = 0,right = 0;
        while(right<arr.length){

            if(sum>=k){
                if(sum==k)
                    max = Math.max(max,right-left+1);
                sum-=arr[left];
                if(left==right) {

                    right++;
                    sum+=arr[right];
                }
                left++;
            }
            else {
                sum+=arr[right];
                right++;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,6,2,1,1,1,1};
        int k=6;
        System.out.println(new Solution().getMaxLength(arr,k));
    }
}
