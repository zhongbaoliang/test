package newcoder.company.wangyi;

public class Main4 {
    public int find_kth (int[] arr1, int[] arr2, int k) {
        // write code here
        int l1 = 0,r1 = arr1.length,  l2 = 0,r2 = arr2.length;
        int mid1 = (l1+r1)/2,mid2 = (l2+r2)/2;
        int count = 0;
        while(count<k){
            count++;
            if(l1==r1){
                l2++;
                continue;
            }
            if(l2==r2){
                l1++;
                continue;
            }
            if(arr1[l1]<=arr2[l2])l1++;
            else l2++;
        }
        if(l1==r1)
            return arr2[l2-1];
        if(l2==r2){
            return arr1[l1-1];
        }
        return arr1[l1-1]<arr2[l2-1]?arr2[l2-1]:arr1[l1-1];
    }

    public static void main(String[] args) {
        int arr1[]={1,2,3},arr2[] = {4,5,6};

        System.out.println(new Main4().find_kth(arr1,arr2,4));
    }
}
