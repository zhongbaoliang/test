package newcoder.company.wangyi2.q3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long s = scanner.nextLong(),num = s;
        long ans = 0;
        long minC = 1,subAns = 1;
        while(minC<=num){
            if((minC&num)!=0)
                ans += minC&num;
            minC = minC<<1;
        }
        long cur = minC>>1,sub = minC;
        while(sub>num){
            if(sub-cur>=num) {
                sub = sub - cur;
                subAns++;
            }
            cur = cur>>1;
        }


        System.out.println(Math.min(ans,subAns));
    }
}
