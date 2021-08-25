package newcoder.company.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[][] offset = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
    public static int m,n,startX,startY,endX,endY;
    public static int map[][],grid[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m=sc.nextInt();
        n=sc.nextInt();
        map=new int[m][n];
        grid=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(map[i],Integer.MAX_VALUE);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        startX = sc.nextInt();
        startY = sc.nextInt();
        endX = sc.nextInt();
        endY=sc.nextInt();
        grid[startX][startY]=0;
        grid[endX][endY]=0;
        dfs(startX,startY,0);
        System.out.println(map[endX][endY]);
    }

    public static void dfs(int x,int y,int cost){
        if(x<0||x>=m||y<0||y>=n||cost>=map[x][y])
            return;
        map[x][y]=cost;
        if(grid[x][y]!=0||(x==endX&&y==endY))return;
        for(int[] off:offset){
            int x1 = x+off[0];
            int y1 = y+off[1];
            dfs(x1,y1,cost+1);
        }
    }


}
