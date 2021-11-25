package newcoder.company.BIGO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public List<int[]> solve(int nums[]){
        Arrays.sort(nums);
        List<int[]> ans = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(i>0&&nums[i]==nums[i-1])continue;
            int sum = -nums[i];
            int left = i+1,right = len-1;
            while(left<right) {
                int sumi = nums[left] + nums[right];
                if (sumi == sum) {
                    ans.add(new int[]{nums[i], nums[left], nums[right]});
                    left++;
                    right--;
                    while(left<right){
                        if(nums[left]!=nums[left-1])break;
                        left++;
                    }
                    while(left<right){
                        if(nums[right]!=nums[right+1])break;
                        right--;
                    }
                }
                else if(sumi>sum){
                    right--;
                }
                else
                    left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<int[]> list = new Main().solve(new int[]{-1,0,1,2,-1,-4});
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[0]+" "+list.get(i)[1]+" "+list.get(i)[2]);
        }
    }
}
