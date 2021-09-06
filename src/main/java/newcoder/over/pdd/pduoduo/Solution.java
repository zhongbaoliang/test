package newcoder.over.pdd.pduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T=scanner.nextInt();
        while(T-->0){
            int n = scanner.nextInt(),m= scanner.nextInt(),k= scanner.nextInt();
            int red[] = new int[n],blue[] = new int[m];
            for(int i=0;i<n;i++)
                red[i]= scanner.nextInt();
            for(int j=0;j<m;j++)
                blue[j]= scanner.nextInt();
            //Arrays.sort(red);
            //Arrays.sort(blue);
            int dp[][] = new int[2][m+1];
            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    dp[1][j]=(Math.abs(red[i-1]-blue[j-1])<=k)?(dp[0][j-1]+1):dp[0][j-1];
                    dp[1][j] = Math.max(dp[1][j],Math.max(dp[0][j],dp[1][j-1]));
                }
                dp[0]=Arrays.copyOf(dp[1],m+1);
            }
            System.out.println(dp[1][m]);
        }
    }
}
