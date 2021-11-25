package newcoder.wait.bianlifeng;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().solve();

    }
    int d[][] = new int [201][201];
    int ans = 0,n=0;
    int step[][]={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
    public void solve(){
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String str1S[] = str1.split(";");
        n=str1S.length;
        for(int i=0;i<str1S.length;i++){
            StringBuilder sb = new StringBuilder(str1S[i]);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length()-1);
            String[] ss = sb.toString().split(",");
            int x=Integer.parseInt(ss[0]),y=Integer.parseInt(ss[1]);
            d[x+100][y+100]=1;
        }
        String str2S[] = str2.split(",");
        int start[] = {Integer.parseInt(str2S[0])+100,Integer.parseInt(str2S[1])+100};
        bfs(start);
        System.out.println(ans);

    }
    public void bfs(int start[]){
        if(n==0)return;
        int cur[]=null;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                cur = queue.poll();
                if(d[cur[0]][cur[1]]==1){
                    n--;
                    d[cur[0]][cur[1]]=0;
                    queue.clear();
                    break;
                }
                else{
                    for(int i=0;i<8;i++){
                        int next[] = new int[2];
                        next[0]=cur[0]+step[i][0];
                        next[1]=cur[1]+step[i][1];
                        if(next[0]<0||next[0]>200||next[1]<0||next[1]>200)
                            continue;
                        queue.offer(next);
                    }
                }
            }
            if(!queue.isEmpty())
                ans++;
        }
        bfs(cur);
    }
}
