package leetcode.editor.cn.JZ.JZ004;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m = nums1.length,n = nums2.length,len = m+n;
        int left = 0,right = m;//[0,m]
        int leftNums = len/2;
        int idx1 = (left+right)/2 ,idx2 = leftNums-idx1;
        while(left<right){
            idx1 = (left+right)/2;
            idx2 = leftNums-idx1;
            if(nums1[idx1]<nums2[idx2-1]){//[idx1+1,right]
                left = idx1 + 1;
            }
            else {
                right = idx1 ;//[left,idx1]
            }
        }

        idx1 = left;
        idx2 = leftNums-idx1;
        int l1 = idx1==0?Integer.MIN_VALUE:nums1[idx1-1];
        int l2 = idx2==0?Integer.MIN_VALUE:nums2[idx2-1];
        int r1 = idx1==m?Integer.MAX_VALUE:nums1[idx1];
        int r2 = idx2==n?Integer.MAX_VALUE:nums2[idx2];
        if((m+n)%2==1){
            return Math.min(r1,r2);
        }
        else{
            return (double) (Math.max(l1,l2)
                    +Math.min(r1,r2))/2;
        }
    }


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays2(nums2,nums1);
        }
        int m = nums1.length,n = nums2.length,len = m+n;
        int left = 0,right = m;//[0,m]
        int leftNums = len/2;
        int idx1 = (left+right)/2 ,idx2 = leftNums-idx1;
        while(left<right){
            idx1 = (left+right)/2;
            idx2 = leftNums-idx1;
            if(nums1[idx1-1]>nums2[idx2]){//[left,idx1-1]
                right = idx1 - 1;
            }
            else{//[idx1,right]
                left = idx1;
            }
        }



        idx1 = left;
        idx2 = leftNums-idx1;
        int l1 = idx1==0?Integer.MIN_VALUE:nums1[idx1-1];
        int l2 = idx2==0?Integer.MIN_VALUE:nums2[idx2-1];
        int r1 = idx1==m?Integer.MAX_VALUE:nums1[idx1];
        int r2 = idx2==n?Integer.MAX_VALUE:nums2[idx2];
        if((m+n)%2==1){
            return Math.min(r1,r2);
        }
        else{
            return (double) (Math.max(l1,l2)
                    +Math.min(r1,r2))/2;
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays1(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }



    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(
                new int[]{3,4},new int[]{1,2}));
    }
}
