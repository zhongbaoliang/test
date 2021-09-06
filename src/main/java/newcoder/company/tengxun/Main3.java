package newcoder.company.tengxun;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        int num1=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1')num1++;
        }
        int num0 = n-num1;
        int max = Math.max(num1,num0),min = Math.min(num1,num0);
        int ans=0;
        for(int i=1;i<max+1;i++)
            ans+=i;
        System.out.println(ans+1);


    }
}
