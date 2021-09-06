package newcoder.company.tengxun;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n= scanner.nextLong();
        int l= scanner.nextInt(),r= scanner.nextInt() ;
        String s=solve(n);
        int count = 0,start = Math.max(0,l-1),end = Math.min(r-1,s.length()-1);

        for(int i=start;i<=end;i++){
            if(s.charAt(i)=='1')count++;
        }
        System.out.println(count);
    }
    public static String solve(long n){
        StringBuilder sb = new StringBuilder();
        if(n==0||n==1)return sb.append(n).toString();
        long del = n/2,mod = n%2;
        String child = solve(del);
        sb.append(child);
        sb.append(mod);
        sb.append(child);
        return sb.toString();
    }
}
