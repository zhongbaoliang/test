package newcoder.over.zijie.zijie1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//特征提取
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            System.out.println(solve());
        }
    }
    public static int solve(){
        int ans = 0;
        int M = sc.nextInt();
        Map<String,Integer> cur = new HashMap<>(), pre = new HashMap<>();
        for(int i = 0;i<M;i++){
            int k = sc.nextInt();
            while(k-->0){
                String key = sc.nextInt() + "," + sc.nextInt();
                int value = pre.getOrDefault(key,0)+1;
                cur.put(key,value);
                ans = value>ans?value:ans;
            }
            pre.clear();
            pre.putAll(cur);
            cur.clear();
        }
        return ans;
    }
}
