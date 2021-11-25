package newcoder.company.meituan.q1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),m = scanner.nextInt() ,k = scanner.nextInt();
        int want[][] = new int[n][3],real[][] = new int[m][3];
        for (int i = 0; i < n; i++) {
            want[i][0] = scanner.nextInt();
            want[i][1] = scanner.nextInt();
            want[i][2] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            real[i][0] = scanner.nextInt();
            real[i][1] = scanner.nextInt();
            real[i][2] = scanner.nextInt();
        }
        int beginTime = Math.min(want[0][0],real[0][0]),endTime = Math.max(want[n-1][1],real[m-1][1]);
        int len = endTime-beginTime,arr[][] = new int[len][3];
        for (int i = 0; i < n; i++) {
            for(int j=want[i][0];j<want[i][1];j++)
                arr[j][0] = want[i][2] + 1;//动作1,2
        }
        for (int i = 0; i < m; i++) {
            for(int j=real[i][0];j<real[i][1];j++)
                arr[j][1] = real[i][2] + 1;
        }
        int ans = 0,error = 1;
        for(int i=0;i<len;i++){
            if((arr[i][0]==0&&arr[i][1]!=0)||(arr[i][0]!=0&&arr[i][1]!=0&&arr[i][1]!=arr[i][0]))
                arr[i][2] = error;
            else
                error++;
        }
        int cnt = 1,bef = arr[0][2];
        for(int i=1;i<len;i++){
            if(arr[i][2]!=0){
                if(bef==0||bef==arr[i][2])
                    cnt++;
                else{
                    if(cnt<k)
                        ans++;
                    cnt = 1;

                }
                bef = arr[i][2];
            }
            else{
                if(bef!=0){
                    if(cnt<k)
                        ans++;
                    cnt = 0;
                    bef = 0;
                }
            }
        }
        System.out.println(ans);

    }
}
