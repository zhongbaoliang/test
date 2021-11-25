package newcoder.wait.bilibili;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    int step[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();


        while(true){
            String line = scanner.nextLine();
            if(line.charAt(line.length()-1)==']')break;
            sb.append(line);

        }
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        String strs[] = sb.toString().split("], ");
        int m = strs.length,n = strs[0].length()/2;
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for(int j=0;j<n;j++)
                arr[i][j] = strs[i].charAt(2*j+1)-'0';
        }
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    int ansi = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int []{i,j});
                    while(!queue.isEmpty()){
                        int cur[] = queue.poll();
                        if(arr[cur[0]][cur[1]]!=1)continue;
                        arr[cur[0]][cur[1]] = -1;
                        ansi++;
                        for(int k=0;k<4;k++){
                            int nextX = cur[0] + step[k][0],nextY = cur[1] + step[k][1];
                            if(nextX<0||nextX>=m||nextY<0||nextY>n
                                ||arr[nextX][nextY]!=1)
                                continue;
                            queue.offer(new int[]{nextX,nextY});
                        }
                    }
                    ans= Math.max(ans,ansi);
                }
            }
        }
        System.out.println(ans);

    }
    public static void main(String[] args) {
        new Main().solve();
    }
}
