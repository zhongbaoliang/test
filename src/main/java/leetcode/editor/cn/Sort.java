package leetcode.editor.cn;

public class Sort {
    public  static void quickS(int[] arr,int begin,int end){
        int i=begin,j=end,k=begin;
        if(begin>=end)
            return ;
        boolean tag=true;
        while(i<j){
            if(tag){
                while(arr[j]>arr[k])
                    j--;
                if(j>k){
                    int num=arr[j];
                    arr[j]=arr[k];
                    arr[k]=num;
                    k=j;
                    tag=false;
                }
            }
            else{
                while(arr[i]<arr[k])
                    i++;
                if(i<k){
                    int num=arr[i];
                    arr[i]=arr[k];
                    arr[k]=num;
                    k=i;
                    tag=true;
                }
            }
        }

        quickS(arr,begin,k-1);
        quickS(arr,k+1,end);
    }

    public static void main(String[] args) {
        int arr[]={7,9,5,3,4,2,1,6,8};
        quickS(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
