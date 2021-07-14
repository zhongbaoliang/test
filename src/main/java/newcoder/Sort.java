package newcoder;

import java.util.Arrays;

public class Sort {
    public static class QuickSort{
        public void quickSort(int arr[]){
            qs(arr,0,arr.length-1);
            //Arrays.stream(arr).forEach(num-> System.out.println(num));
        }
        public void qs(int arr[],int left,int right){
            if(left>=right)return ;
            int idx=left,l=left,r=right;
            while(l!=r){
                if(idx==l){
                    if(arr[r]<arr[idx]){
                        swap(arr,r,idx);
                        idx=r;
                        l++;
                    }
                    else{
                        r--;
                    }
                }
                else{
                    if(arr[l]>arr[idx]){
                        swap(arr,l,idx);
                        idx=l;
                        r--;
                    }
                    else{
                        l++;
                    }
                }
            }
            qs(arr,left,idx-1);
            qs(arr,idx+1,right);

        }

        public void swap(int arr[],int i,int j){
            int num=arr[i];
            arr[i]=arr[j];
            arr[j]=num;
        }
    }



    public static void main(String[] args) {
        int arr[]={5,6,9,20,1,5,3,7,6,9};
        new Sort.QuickSort().quickSort(arr);
        Arrays.stream(arr).forEach(num-> System.out.println(num));
    }
}
