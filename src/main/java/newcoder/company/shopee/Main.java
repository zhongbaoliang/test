package newcoder.company.shopee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(;i<str.length();i++){
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z') {
                sb.append((char) (str.charAt(i) + 32));
                break;
            }
            if((str.charAt(i)>='a'&&str.charAt(i)<='z')||(str.charAt(i)>='0'&&str.charAt(i)<='9')) {
                sb.append(str.charAt(i));
                break;
            }
        }

        boolean tag = false;
        for(i=i+1;i<str.length();i++){

            if((str.charAt(i)<'0')||(str.charAt(i)>'9'&&(str.charAt(i)<'A'))
                    ||(str.charAt(i)>'Z'&&(str.charAt(i)<'a'))||(str.charAt(i)>'z')) {
                tag = true;
                continue;
            }
            if(tag){
                tag=false;
                if(str.charAt(i)>='a'&&str.charAt(i)<='z')
                    sb.append((char) (str.charAt(i)-32));
                else sb.append(str.charAt(i));
                continue;
            }
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z')
                sb.append((char) (str.charAt(i)+32));
            else if((str.charAt(i)>='a'&&str.charAt(i)<='z')||(str.charAt(i)>='0'&&str.charAt(i)<='9'))
                sb.append(str.charAt(i));

        }
        System.out.println(sb);
    }
}
