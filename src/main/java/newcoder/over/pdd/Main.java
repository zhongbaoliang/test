package newcoder.over.pdd;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        scanner.nextLine();
        String string=scanner.nextLine();
        String [] strs=string.split(" ");
        Arrays.sort(strs);
        int ans=0,single=0,triple=0;
        for (int i = 1; i < strs.length+1; i++) {
            int num=1;
            while(i < strs.length && strs[i].equals(strs[i-1])){
                num++;
                i++;
            }//101036666AJJJQ
            if(num==2||num==4)
                ans++;
            else if(num==1)
                single++;
            else
                triple++;
        }
        ans+=single>triple?single:triple;
        System.out.println(ans);
    }
}
