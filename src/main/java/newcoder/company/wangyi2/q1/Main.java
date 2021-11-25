package newcoder.company.wangyi2.q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),num = n;
        int cur = num%10,ans = 0;
        num = num/10;
        while(cur!=0||num!=0){
            if(cur!=0&&n%cur==0){
                ans++;
            }
            cur = num%10;
            num = num/10;
        }
        System.out.println(ans);
    }


}
