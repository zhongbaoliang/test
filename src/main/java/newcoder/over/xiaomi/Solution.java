package newcoder.over.xiaomi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public int[][] step = {{-1,0},{1,0},{0,-1},{0,1}};
    public int maze(){
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt(),h = scanner.nextInt();
        char[][] arr = new char[h][w];
        boolean visited[][] = new boolean[h][w];
        scanner.nextLine();
        for(int i=0;i<h;i++) {
            String linei = scanner.nextLine();
            String strs[] = linei.split(" ");
            for (int j = 0; j < w; j++)
                arr[i][j] = strs[j].charAt(0);
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<h;i++) {
            for (int j = 0; j < w; j++)
                if(arr[i][j]=='@'){
                    queue.offer(new int[]{i,j});
                    break;
                }
        }
        int ans = 0;

        while(!queue.isEmpty()){
            ans++;
            int len = queue.size();
            for(int i=0;i<len;i++){
                int cur[] = queue.poll();
                if(arr[cur[0]][cur[1]]=='$')
                    return ans;
                visited[cur[0]][cur[1]]=true;
                for(int j=0;j<4;j++){
                    int[] next = new int[2];
                    next[0] = cur[0] + step[j][0];
                    next[1] = cur[1] + step[j][1];
                    if(next[0]>=0&&next[0]<h&&next[1]>=0&&next[1]<w) {
                        if ((arr[next[0]][next[1]] == '$' || arr[next[0]][next[1]] == '.' )&& !visited[next[0]][next[1]])
                            queue.offer(next);
                        else
                            visited[next[0]][next[1]] = true;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maze());
    }
}

