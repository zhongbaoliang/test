package newcoder.company.wangyi;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static StringBuilder str;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String strs[] = line.split(" ");
        str = new StringBuilder(strs[0]);
        int k = Integer.parseInt(strs[1]),len = str.length();
        ArrayList<Integer> zeroIdx = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(str.charAt(i)=='0')zeroIdx.add(i);
        }
        int zeroNum = zeroIdx.size();
        if(zeroNum<=k) {
            System.out.println(len);
            return;
        }
        for(int i=0;i<k;i++){
            str.setCharAt(zeroIdx.get(i),'1');
        }
        int ans = getLen(0);
        for(int i=1;i<zeroNum-k;i++){
            str.setCharAt(zeroIdx.get(i-1),'0');
            str.setCharAt(zeroIdx.get(i+k-1),'1');
            ans = Math.max(ans,getLen(zeroIdx.get(i+k-1)));

        }
        System.out.println(ans);
    }
    public static int getLen(int cur){
        int ans = 1;
        int left=cur-1,right=cur+1;
        while(left>=0){
            if(str.charAt(left)=='1') {
                left--;
                ans++;
            }
            else break;
        }
        while(right<str.length()){
            if(str.charAt(right)=='1') {
                right++;
                ans++;
            }
            else break;
        }
        return ans;
    }


}
