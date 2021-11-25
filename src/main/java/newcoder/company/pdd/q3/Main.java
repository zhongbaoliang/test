package newcoder.company.pdd.q3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            String strs[] = new String[n];
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                strs[i] = scanner.nextLine();
            }
            int min = 0, i = 0;
            for (; i < n; i++) {
                int leni = strs[i].length();
                int cur = 0;


                for (int j = 0; j < leni; j++) {
                    cur=cur*10;
                    if(strs[i].charAt(j)!='?')
                        cur+=(strs[i].charAt(j)-'0');
                    else{
                        cur+=9;
                    }
                }
                if(cur<=min){
                    System.out.println("NO");
                    break;
                }
                min = cur;
            }
            if(i==n)
                System.out.println("YES");
        }
    }
}
