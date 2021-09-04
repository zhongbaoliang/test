package newcoder.company.xiaomi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine(),line2 = scanner.nextLine(),line3 = scanner.nextLine();
        String str1S[] = line1.split(",");
        String ms = str1S[0].substring(2,str1S[0].length()),ns=str1S[1].substring(2,str1S[1].length());
        int m = Integer.parseInt(ms),n=Integer.parseInt(ns);
        String str2S[] = line2.split(","),str3S[] = line3.split(",");
        int arr1[] = new int[m],arr2[] = new int[n];
        for(int i=0;i<m;i++)
            arr1[i]=Integer.parseInt(str2S[i]);
        for (int i = 0; i < n; i++) {
            arr2[i]=Integer.parseInt(str3S[i]);

        }
        int ans[] = new int[m+n];
        int idx1=0,idx2=0,idx=0;
        while(idx1<m&&idx2<n){
            if(arr1[idx1]<arr2[idx2]){
                ans[idx++]=arr1[idx1++];
            }
            else{
                ans[idx++]=arr2[idx2++];
            }
        }
        while(idx1<m){
            ans[idx++]=arr1[idx1++];
        }
        while(idx2<n){
            ans[idx++]=arr2[idx2++];
        }
        for(int i=0;i<m+n;i++){
            System.out.print(ans[i]+" ");
        }

    }
}
