package leetcode.editor.cn.leetcode.lc0139;

import java.util.*;

public class Solution {
    class TreeNode{
        char val;
        TreeNode child[];
        boolean isEnd;
        TreeNode(char val){
            this.val = val;
            child = new TreeNode[26];
            isEnd = false;
        }
    }
    TreeNode root = new TreeNode(' ');
    private void build(String word){
        TreeNode ptr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            int idx = ch-'a';
            if(ptr.child[idx]==null){
                TreeNode nxt = new TreeNode(ch);
                ptr.child[idx] = nxt;
            }
            ptr = ptr.child[idx];
        }
        ptr.isEnd=true;
    }
    private void buildTree(List<String> wordDict){
        for(String s : wordDict){
            build(s);
        }
    }
    private boolean check(String s){
        Deque<Integer> stack = new LinkedList<>();
        TreeNode ptr = root;
        int idx = 0,len = s.length();
        while(!stack.isEmpty()||ptr!=null){
            if(idx==len&&ptr!=null&&ptr.isEnd)
                return true;
            if(ptr.isEnd)
                stack.push(idx);
            if(ptr==null||idx==len){
                idx = stack.pop();
                ptr = root;
            }

            int nxt = s.charAt(idx)-'a';
            if(ptr.child[nxt]!=null){
                ptr = ptr.child[nxt];
                idx++;
            }
            else{
                if(stack.isEmpty())return false;
                ptr = root;
                idx = stack.pop();
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        buildTree(wordDict);
        return check(s);
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String > list = Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"});
        Set<String> set = new HashSet<>(list);
        System.out.println(new Solution().wordBreak(s,list));
    }
}