package newcoder;

import java.util.Scanner;

public class MergeArray {
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

    public static void main(String[] args) {
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
}
