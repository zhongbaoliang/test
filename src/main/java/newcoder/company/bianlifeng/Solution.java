package newcoder.company.bianlifeng;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String strS[] = str.split(",");
        int ans=0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i< strS.length;i++){
            int cur=Integer.parseInt(strS[i]);
            while(set.contains(cur)){
                cur++;
                ans++;
            }
            set.add(cur);
        }
        System.out.println(ans);
    }
}
