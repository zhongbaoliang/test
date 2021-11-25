package newcoder.over.xiecheng;

import java.util.Arrays;

public class Solution {
    public void solve(int arr[],int sum){
        Arrays.sort(arr);
        int left = 0,right = arr.length-1;
        while(left<right){
            int sumi = arr[left]+arr[right];
            if(sumi==sum){
                System.out.println(arr[left]+" + "+arr[right]);
                return;
            }
            if(sumi<sum)
                left++;
            else
                right--;
        }
    }

    public static void main(String[] args) {
        int arr[] = {9,1,2,3,8,7};
        int sum = 17;
        new Solution().solve(arr,sum);
    }
}
