package newcoder.over.xiecheng;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {
    int arr[][];
    public void solve(){
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt(),m = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        arr = new int[m][2];
        for(int i=0;i<m;i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //double rate1 = (double) (o1[1])/o1[0],rate2 = (double) (o2[1])/o2[0];
                //return rate2>rate1?1:-1;
                return o1[0]-o2[0];
            }
        });
        int max = 0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='1'){
                int len = i;
                while(i<n&&str.charAt(i)=='1')
                    i++;
                len = i-len;
                max+=dpSolve(len);
                //System.out.println(max);

            }
        }
        System.out.println(max);
    }

    public int dpSolve(int len){
        int dp[][] = new int[len+1][arr.length+1];
        for(int i=arr[0][0];i<len+1;i++){
            for(int j=1;j<arr.length+1;j++){
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                for(int k=1;k<=i/arr[j-1][0];k++){
                    dp[i][j]=Math.max(dp[i][j],dp[i-arr[j-1][0]*k][j]+arr[j-1][1]);
                }
            }
        }
        return dp[len][arr.length];
    }

    public static void main(String[] args) {
        new Main3().solve();
    }
}
