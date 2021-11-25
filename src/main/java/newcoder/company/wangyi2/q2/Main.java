package newcoder.company.wangyi2.q2;

import java.util.Scanner;

public class Main {
    public static int getDef(char a,char b){
        return Math.min((a-b + 26)%13,(b-a + 26)%13);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int m = scanner.nextInt();
        int len = str.length();
        long min = 1;
        for(int i=1;i<len;i++){
            min += getDef(str.charAt(i),str.charAt(i-1))+1;
        }

        for(int i=1;i<=len-m;i++){
            long cur = 1;
            for(int j=1;j<i;j++){
                cur += getDef(str.charAt(j),str.charAt(j-1)) + 1;
            }
            cur += m*2;
            for(int j=i+m;j<len;j++){
                cur += getDef(str.charAt(j),str.charAt(j-1)) + 1;
            }
            min = Math.min(min,cur);
        }
        System.out.println(min);
    }
}
