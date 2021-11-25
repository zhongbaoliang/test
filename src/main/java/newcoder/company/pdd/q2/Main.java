package newcoder.company.pdd.q2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        int left = 0,right = 1,len = str.length();
        while(right<len){
            if(str.charAt(left)=='a'&&str.charAt(right)=='b'){
                if(right==(len-1)||str.charAt(right+1)=='a')
                {
                    sb.append('b');
                    left = ++right;
                }

            }else{
                sb.append(str.charAt(left));
                left = right;
            }
            right++;
        }
        if(left<len)
            sb.append(str.charAt(left));

        str = sb.toString();
        sb = new StringBuilder();
        len = str.length();
        left = len-2;
        right = len-1;

        while(left>=0){
            if(str.charAt(left)=='a'&&str.charAt(right)=='b'){
                if(left==0||str.charAt(left-1)=='b')
                {
                    sb.append('b');
                    right = --left;
                }

            }else{
                sb.append(str.charAt(right));
                right = left;
            }
            left--;
        }
        if(right>=0)
            sb.append(str.charAt(right));

        System.out.println(sb.reverse().toString());
    }
}
