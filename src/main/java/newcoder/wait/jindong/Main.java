package newcoder.wait.jindong;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),m = scanner.nextInt(),x = scanner.nextInt(),y = scanner.nextInt(),z = scanner.nextInt();
        Map<Character,int[]> map = new HashMap<>();
        scanner.nextLine();
        char cur = ' ';
        for(int i=0;i<n;i++){
            String linei = scanner.nextLine();
            if(i==0)cur = linei.charAt(0);
            for(int j=0;j<m;j++){
                map.put(linei.charAt(j),new int[]{i,j});
            }
        }
        String text = scanner.nextLine();
        int ans = 0;
        for(int i=0;i<text.length();i++){
            char next = text.charAt(i);
            int curP[] = map.get(cur), nextP[] = map.get(next);
            int step1 = Math.abs(curP[0]-nextP[0]),step2 = Math.abs(curP[1]-nextP[1]);
            int step = step1+step2;
            ans+=step*x;
            if(step1!=0&&step2!=0)ans+=y;
            ans+=z;
            cur = next;
        }
        System.out.println(ans);
    }
}
