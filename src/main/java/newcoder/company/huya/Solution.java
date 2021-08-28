package newcoder.company.huya;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public int[] matrixChange (int[][] matrix) {
        // write code here
        if(matrix==null||matrix.length==0)return new int[0];
        int height = matrix.length,width = matrix[0].length;
        int len = height*width,ans[] = new int[len];
        int firstRow = 0,lastRow = height-1,firstCol = 0,lastCol=width-1;
        int idx = 0;
        while(idx<len){
            for(int col=firstCol;col<=lastCol;col++)ans[idx++]=matrix[firstRow][col];
            firstRow++;
            if(idx==len)break;
            for(int row=firstRow;row<=lastRow;row++)ans[idx++]=matrix[row][lastCol];
            lastCol--;
            if(idx==len)break;
            for(int col=lastCol;col>=firstCol;col--)ans[idx++]=matrix[lastRow][col];
            lastRow--;
            if(idx==len)break;
            for(int row=lastRow;row>=firstRow;row--)ans[idx++]=matrix[row][firstCol];
        }
        return ans;
    }

    public int transform(String str){
        int mul=1,ans=0;
        for(int i=str.length()-1;i>=0;i--){
            char ch = str.charAt(i);
            int cur = 0;
            if(ch>='0'&&ch<='9')
                cur = (str.charAt(i)-'0')*mul;
            else if(ch>='a'&&ch<='z')
                cur = (str.charAt(i)-'a'+10)*mul;
            else
                cur = (str.charAt(i)-'A'+10)*mul;
            ans+=cur;
            mul*=16;
        }
        return ans;
    }
    public int predictOrder (int[] nums) {
        // write code here
        if(nums==null||nums.length==0)return 0;
        int len = nums.length;
        int[] dp = new int[len];
        for(int i=0;i<len;i++)dp[i]=nums[i];
        for(int i=len-2;i>=0;i--){
            for(int j=i+1;j<len;j++){
                dp[j] = Math.max(nums[i]-dp[j],nums[j]-dp[j-1]);
            }
        }
        if(dp[len-1]>0)return 1;
        if(dp[len-1]==0)return 0;
        return -1;


    }

    public int[][] step = {{-1,0},{1,0},{0,-1},{0,1}};

    public int getExitCount (char[][] maze) {
        // write code here
        int ans=0;
        Stack<int[]> stack = new Stack<>();
        int height = maze.length,width=maze[0].length;
        boolean visited[][] = new boolean[height][width];

        for(int row=0;row<height;row++){
            if(maze[row][0]=='S'){
                stack.push(new int[]{row,0});
                break;
            }
            if(maze[row][width-1]=='S'){
                stack.push(new int[]{row,width-1});
                break;
            }
        }
        if(stack.isEmpty()){
            for(int col=0;col<width;col++){
                if(maze[0][col]=='S'){
                    stack.push(new int[]{0,col});
                    break;
                }
                if(maze[height-1][col]=='S'){
                    stack.push(new int[]{height-1,col});
                    break;
                }
            }
        }
        while(!stack.isEmpty()){
            int[] cur = stack.pop();
            if(visited[cur[0]][cur[1]])continue;
            if(maze[cur[0]][cur[1]]=='E')ans++;
            visited[cur[0]][cur[1]] = true;
            for(int k=0;k<4;k++)
            {
                int next[]=new int[] {cur[0]+step[k][0],cur[1]+step[k][1]};
                if (next[0]>=0&&next[0]<height&&next[1]>=0&&next[1]<width&&
                        maze[next[0]][next[1]] == 'E' || maze[next[0]][next[1]] == 'O') {
                    stack.push(next);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new Solution().transform(scanner.nextLine()));

    }
}
