package leetcode.editor.cn.leetcode.lc0084;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int start[] = new int[len],end[] = new int[len];
        Stack<Integer> stack = new Stack<>();//严格单调递增栈
        for(int i = 0;i<len;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            start[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        int max = 0;
        for(int i = len-1;i>=0;i--){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            end[i] = stack.isEmpty()?(len-1):(stack.peek()-1);
            stack.push(i);
            max = Math.max(max,heights[i]*(end[i]-start[i]));
        }
        return max;
    }

    public static void main(String[] args) {
        int heights[] = new int[]{3,3,3,3};
        System.out.println(new Main().largestRectangleArea(heights));

    }
}
