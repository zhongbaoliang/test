package leetcode.editor.cn.algorism.search.binarySearch;

public class Main {
    public static void main(String[] args) {
        int nums[] = new int[]{2,3,4,4,4,6,7,8};
        Main main = new Main();
        System.out.println(main.searchNum(nums,4));
        System.out.println(main.searchLeft(nums,4));
        System.out.println(main.searchRight(nums,4));

    }

    int searchNum(int nums[],int target){
        int left = 0,right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)return mid;
            if(nums[mid]>target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }

    int searchLeft(int nums[],int target){
        int left = 0,right = nums.length-1;
        while(left<right){
            int mid =(left+right)/2;
            if(nums[mid]>=target)
                right = mid;
            else
                left = mid+1;
        }
        return nums[right]==target?right:-1;
    }

    int searchRight(int nums[],int target){
        int left = 0,right = nums.length-1;
        while(left<right){
            int mid = (left+right+1)/2;
            if(nums[mid]>target){
                right = mid-1;
            }
            else{
                left = mid;
            }
        }
        return nums[left]==target?left:-1;
    }
}
