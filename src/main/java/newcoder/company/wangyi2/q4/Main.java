package newcoder.company.wangyi2.q4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),a = scanner.nextInt(),b = scanner.nextInt();
        char[][] arr = new char[n][n];
        scanner.nextLine();
        for(int i=0;i<n;i++){
            String line = scanner.nextLine();
            arr[i] = line.toCharArray();
        }
        int step[][] = new int[n][n];
        int direct[][] = new int[2][2],didx = 0;
        if(arr[0][0]=='*') {
            direct[didx][0] = 0;
            direct[didx][1] = 0;
            didx++;
        }
        for(int i=1;i<n;i++){
            step[0][i] = step[0][i-1];
            if(arr[0][i]=='#')
                step[0][i] += a;
            else{
                if(arr[0][i]=='*') {
                    direct[didx][0] = 0;
                    direct[didx][1] = i;
                    didx++;
                }
            }
            step[i][0] = step[0][i-1];
            if(arr[i][0]=='#')
                step[i][0] += a;
            else{
                if(arr[i][0]=='*') {
                    direct[didx][0] = i;
                    direct[didx][1] = 0;
                    didx++;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                step[i][j] = Math.min(step[i-1][j] ,step[i][j-1] );
                if(arr[i][j]=='#')
                    step[i][j] += a;
                else{
                    if(arr[i][j]=='*') {
                        direct[didx][0] = i;
                        direct[didx][1] = j;
                        didx++;
                    }
                }
            }
        }
        if(didx==2){
            int ans1 = step[direct[0][0]][direct[0][1]] + b + step[n-1][n-1] - step[direct[1][0]][direct[1][1]];
            int ans2 = step[direct[1][0]][direct[1][1]] + b + step[n-1][n-1] - step[direct[0][1]][direct[0][1]];
            step[n-1][n-1] = Math.min(step[n-1][n-1],Math.min(ans1,ans2));
        }
        System.out.println(step[n-1][n-1]);

    }
}
