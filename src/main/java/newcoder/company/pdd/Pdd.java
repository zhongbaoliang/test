package newcoder.company.pdd;

import java.util.Scanner;

public class Pdd {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        if("".equals(string))
            return ;
        String strs[]=string.split(" ");
        StringBuilder stringBuilder=new StringBuilder(),stringBuilder1=new StringBuilder();


        for (int i = 0; i < strs.length; i++) {
            stringBuilder1.append('a');
            if(!"".equals(strs[i]))
                stringBuilder.append(set(strs[i],String.valueOf(stringBuilder1)));
            stringBuilder.append(' ');
        }
        System.out.println(stringBuilder);
    }

    public static String set(String str,String tail){
        StringBuilder stringBuilder=new StringBuilder();
        if(check(str.charAt(0))){
            stringBuilder.append(str);
        }
        else{
            if (str.length()>1)
                stringBuilder.append(str.substring(1,str.length()));
            stringBuilder.append(str.charAt(0));
        }
        stringBuilder.append("pdd");
        stringBuilder.append(tail);
        return String.valueOf(stringBuilder);
    }
    public static boolean check(char a){
        String str="aeiouAEIOU";
        int i = 0;
        for (; i < str.length(); i++) {
            if(a==str.charAt(i))
                return true;
        }
        return false;
    }
}
