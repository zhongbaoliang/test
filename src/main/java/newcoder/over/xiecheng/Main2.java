package newcoder.over.xiecheng;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        new Main2().solve();
    }
    int arr[];
    public void solve(){
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt(),k = scanner.nextInt();
        arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = scanner.nextInt();


        System.out.println(dfs(k,0));
    }


    public int dfs(int k,int begin){
        if(k==1)
            return getdef(begin,arr.length);
        int min = Integer.MAX_VALUE;

        for(int i=begin;i<arr.length - k +1;i++){
            int cur = getdef(begin,i+1);
            if(cur>min)break;
            cur = Math.max(dfs(k-1,i+1),cur);
            min = Math.min(min,cur);
        }
        return min;
    }
    public int getdef(int begin,int end){
        int min = arr[begin],max = arr[begin];
        for(int i=begin+1;i<end;i++){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        return max-min;
    }

}
