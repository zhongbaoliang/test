package newcoder.wait.bianlifeng;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine(),line2 = scanner.nextLine();
        String strs[] = line1.split(",");
        int skuW[] = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            skuW[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(skuW);
        int c = Integer.parseInt(line2);
        int ans = 0;
        for(int i=0;i<skuW.length;i++){
            if(skuW[i]<=c){
                c-=skuW[i];
                ans++;
            }
            else
                break;
        }
        System.out.println(ans);
    }
}
