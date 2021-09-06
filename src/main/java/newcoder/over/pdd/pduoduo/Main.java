package newcoder.over.pdd.pduoduo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String strs[] = new String[n];
        scanner.nextLine();
        for(int i=0;i<n;i++){
            strs[i]= scanner.nextLine();
        }
        for(int i=1;i<n;i++){
            String cur = strs[i];
            int j=i-1;
            for(;j>=0;j--){
                if(cmp(strs[j],cur)){
                    strs[j+1]=strs[j];
                }
                else {
                    break;
                }
            }
            strs[j+1]=cur;
        }
        for(int i=0;i<n;i++){
            System.out.println(strs[i]);
        }
    }
    public static boolean cmp(String pre,String cur){//cur小时返回true
        int len = pre.length(),len1=cur.length();
        for(int j=0;j<len1/2;j++){
            String curStr1 = cur;
            int i=0;
            for(;i<len/2;i++){
                String s1=pre;
                //System.out.println(cur.compareTo(s1));
                if(curStr1.compareTo(s1)>=0)break;
                char chs[]=s1.toCharArray();
                char ch=chs[i];
                chs[i]=chs[len-i-1];
                chs[len-i-1]=ch;
                String s2 = new String(chs);
                if(curStr1.compareTo(s2)>=0)break;
            }
            if(i<len/2-1)return true;
            i=0;
            char chsCur[]=curStr1.toCharArray();
            char chCur=chsCur[j];
            chsCur[j]=chsCur[len1-j-1];
            chsCur[len1-j-1]=chCur;
            String curStr2 = new String(chsCur);
            for(;i<len/2;i++){
                String s1=pre;
                //System.out.println(cur.compareTo(s1));
                if(curStr2.compareTo(s1)>=0)break;
                char chs[]=s1.toCharArray();
                char ch=chs[i];
                chs[i]=chs[len-i-1];
                chs[len-i-1]=ch;
                String s2 = new String(chs);
                if(curStr2.compareTo(s2)>=0)break;
            }
            if(i<len/2-1)return true;
        }

        return false;
    }
}
