package javaee.collections;

import org.junit.Test;

public class StringTest {
    public static void main(String[] args) {
        String s1 = new String("b") + new String("a");
        String intern1 = s1.intern();
        System.out.println(s1 == intern1);
        String s2 = "ba";
        System.out.println(intern1 == s2);
        String str="wufanfan is sb";
        String str1=str.substring(5,14);
        str.length();
        System.out.println(str1);
        String numStr="123";

        str.compareTo(str1);
        String s=str.substring(0,1);
        StringBuilder sb=new StringBuilder();
        sb.append(' ');

        if(sb.length()!=0){
            sb.deleteCharAt(sb.length()-1);
        }
        StringBuilder sb1=new StringBuilder(str);
        String str2=new String(sb1);
    }

    @Test
    public void test(){
        String s1 = new String("b") + new String("a");
        String intern1 = s1.intern();
        System.out.println(s1 == intern1);
        String s2 = "ba";
        System.out.println(intern1 == s2);
    }
}
