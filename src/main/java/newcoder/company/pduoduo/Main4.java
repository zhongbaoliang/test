package newcoder.company.pduoduo;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int n=sc.nextInt();
            int arr[] = new int[n];
            int max=0;
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                max=Math.max(max,arr[i]);
            }
            int dp[][] = new int[n][max];
            for(int i=0;i<n;i++){
                for(int j=0;j<arr[i];j++)
                    dp[i][j]=1;
            }
            int ans=0;
            for(int j=0;j<max;j++){
                ans++;
                int i=0;
                while(i<n){
                    while(i<n&&dp[i][j]==0)i++;
                    while(i<n&&dp[i][j]==1){
                        dp[i][j]=0;
                        i++;
                    }
                    while(i<n&&dp[i][j]==0)i++;
                    if(i>=n-1)break;
                    ans++;

                }

            }
            System.out.println(ans);
        }

    }
}
