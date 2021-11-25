package javaee.collections;

public class StringTest {
    public static void main(String[] args) {
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
}
