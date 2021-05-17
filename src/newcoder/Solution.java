package newcoder;
//Arrays.copyOfRange(arr,from,to) 起始位置，结束位置（+1）


import java.util.Scanner;
import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
public class Solution {

    //NC22 合并两个有序数组
    public static void merge(int A[], int m, int B[], int n) {
        int i=m-1,j=n-1,k=m+n-1;
        while(k>=0){
            if(i<0||j<0)
                break;
            if(A[i]>B[j])
                A[k--]=A[i--];
            else
                A[k--]=B[j--];

        }
        while(j>=0)
            A[k--]=B[j--];
    }
    public static void testNC22(){
        int m,n;
        Scanner scanner=new Scanner(System.in);
        m=scanner.nextInt();
        n=scanner.nextInt();
        int nums1[]=new int[m+n],nums2[]=new int[n];

        for(int i=0;i<m;i++){
            nums1[i]= scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            nums2[i]= scanner.nextInt();
        }

        merge(nums1,m,nums2,n);
        for(int i=0;i<n+m;i++){
            System.out.println(nums1[i]+" ");
        }
    }

    //NC105 二分查找
    public static int search (int[] nums, int target) {
        // write code here
        /*if(nums.length==0)
            return -1;
        int idx=(nums.length-1)/2;
        if(nums.length==1){
            if(nums[idx]==target)
                return idx;
            else
                return -1;
        }
        if(nums[idx]>=target)
            idx=search(Arrays.copyOfRange(nums,0,idx+1),target);
        else
            idx=idx+1+search(Arrays.copyOfRange(nums,idx+1,nums.length),target);
        return idx;*/

        int l=0,h=nums.length-1,ans=-1;
        while(l<h){
            int mid=(h-l)/2+l;
            if(nums[mid]>=target)
                h=mid;
            else
                l=mid+1;
        }
        return l==h?l:-1;
    }

    public static void testNC105(){
        /*
        5
        1 2 4 4 5
        4
        */
        Scanner scanner=new Scanner(System.in);
        int n;
        n=scanner.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]= scanner.nextInt();
        }
        int target=scanner.nextInt();
        System.out.println(search(nums,target));
    }
    public static void testNC3(){

    }

    public static void main(String[] args) {
        //testNC22();

        //testNC105();



    }
}
