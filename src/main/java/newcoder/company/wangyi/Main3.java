package newcoder.company.wangyi;

import java.util.*;

public class Main3 {
    int step[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    boolean dp[][] ;
    public void solve(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),c = scanner.nextInt();
        scanner.nextLine();
        String str;
        dp = new boolean[n][9];
        List<int[]> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            str = scanner.nextLine();
            for(int j=0;j<9;j++)
                if(str.charAt(j)=='.') {
                    dp[i][j] = true;
                    lst.add(new int[]{i,j});
                }
        }
        LinkedList<int[]> list = new LinkedList<>();
        int idx=0;
        for (int i = 0; i < c; i++) {
            if(idx==lst.size()){
                System.out.println("FAILED");
                return;
            }
            int cur[] = lst.get(idx);
            list.add(cur);

        }
        for(int[] cur:list){
            char ch=' ';
            if(cur[1]<3)ch = (char) (cur[1]+'A');
            else ch = (char) (cur[1]+'A'-3);
            System.out.println((cur[0]+1) + ch);
        }



    }

    public static void main(String[] args) {
        new Main3().solve();

    }
}
