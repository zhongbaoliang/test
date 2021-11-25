package newcoder.company.meituan.q3;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ConcurrentSkipListMap;

public class Main {
    static int gift[],m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),friend[] = new int[n],friendNeed[] = new int[n];
        m = scanner.nextInt();
        gift = new int[m];
        for (int i = 0; i < n; i++) {
            friend[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            gift[i] = scanner.nextInt();
        }
        Arrays.sort(gift);
        for (int i = 0; i < n; i++) {
            friendNeed[i] = scanner.nextInt();
        }
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            int j = 0;
            j = search(friendNeed[i]);
           /* while (j<m){
                if(gift[j]<friendNeed[i])j++;
                else break;
            }*/
            if((m-j)<friend[i])
                ans[i] = -1;
            else {
                for(int k=0;k<friend[i];k++){
                    ans[i]+=gift[j++];
                }
            }
            System.out.print(ans[i]+" ");
        }


    }

    public static int search(int target){
        int left = 0,right = m-1;
        while(left<right-1){
            int mid = (left+right)/2;
            if(target<=gift[mid])
                right = mid-1;
            else
                left = mid;
        }

        return left;
    }
    public void test(){


        byte b;
        short s;
        int i;
        long l;

        boolean bool;
        char c;
        float f;
        double d;
    }
}
