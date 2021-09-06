package newcoder.company.guanglianda;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),m= scanner.nextInt();
        int tasty[] = new int[n];
        for(int i=0;i<n;i++){
            tasty[i]= scanner.nextInt();
        }
        int nums[] = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i]= scanner.nextInt();
        }
        int dp[] = new int[n];
        dp[n-1]=1;
        Set<Integer> set = new HashSet<>();
        set.add(tasty[n-1]);
        for(int i=n-2;i>=0;i--){
            if(set.contains(tasty[i]))
                dp[i]=dp[i+1];
            else{
                set.add(tasty[i]);
                dp[i]=dp[i+1]+1;
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(dp[nums[i]-1]);
        }

    }
}
