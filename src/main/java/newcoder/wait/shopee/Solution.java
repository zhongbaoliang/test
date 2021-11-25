package newcoder.wait.shopee;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pStr = scanner.nextLine(),str = scanner.nextLine();
        int height = pStr.length()+1,width = str.length()+1;
        boolean dp[][] = new boolean[height][width];
        dp[0][0]=true;
        for(int i=1;i<height;i++){
            for(int j=1;j<width;j++){

                if(pStr.charAt(i-1)=='#'){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-1];
                    continue;
                }
                if(pStr.charAt(i-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                    continue;
                }
                if(pStr.charAt(i-1)=='?'||pStr.charAt(i-1)==str.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                    continue;
                }
            }
        }
        if(dp[height-1][width-1]) System.out.println(1);
        else System.out.println(0);
    }
}
