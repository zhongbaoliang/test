package newcoder.wait.baidu.q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().solve());

    }
    public int solve(){
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt(),k= scanner.nextInt(),max = 0;
        for (int i = 1; i <= k; i++) {
            max = Math.max(max,reverse(i*n));
        }
        return max;

    }

    public int reverse(int num){
        int reNum = 0,mul=1;
        while(mul<=num){
            mul*=10;
        }
        mul/=10;
        while(num!=0){
            int mod = num%10;
            num = num/10;
            reNum+=mod*mul;
            mul/=10;
        }
        return reNum;

    }

}
