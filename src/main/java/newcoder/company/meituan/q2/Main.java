package newcoder.company.meituan.q2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),m = scanner.nextInt(),arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for(int j=i+1;j<n;j++){
                if((arr[i]+arr[j])<=m)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}
