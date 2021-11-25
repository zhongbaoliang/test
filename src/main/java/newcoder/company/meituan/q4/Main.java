package newcoder.company.meituan.q4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),a[] = new int[n],f[] = new int[n-1];
        for(int i=0;i<n;i++)
            a[i] = scanner.nextInt();
        for (int i = 0; i < n-1; i++) {
            f[i] = scanner.nextInt();
        }
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            int max = a[i],idx = i;
            for (int j = i; j < n; j++) {
                if(a[j]>max){
                    idx = j;
                    max = a[j];
                }
                ans[idx]++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]+" ");
        }


    }
}
