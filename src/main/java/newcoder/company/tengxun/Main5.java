package newcoder.company.tengxun;


import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i]= scanner.nextInt();
        int ans = 0;
        int dp[][] = new int[3][n];
        for(int i=0;i<n;i++) {
            dp[0][i] = arr[i];
        }
        for(int i=0;i<n-1;i++) {
            dp[1][i+1] = Math.min(arr[i+1],arr[i]);
            ans++;
        }

        for(int i=2;i<n;i++){//斜行
            for(int j=0;j<n-i;j++){//行
                dp[2][i+j]=Math.min(arr[i], Math.min(arr[j],dp[0][i+j-1]));
                if(arr[i]<=dp[0][i+j-1]&&arr[j]<=dp[0][i+j-1]){
                    ans++;
                }
            }
            dp[0]= Arrays.copyOf(dp[1],n);
            dp[1]=Arrays.copyOf(dp[2],n);
        }


        System.out.println(ans);

    }
}
