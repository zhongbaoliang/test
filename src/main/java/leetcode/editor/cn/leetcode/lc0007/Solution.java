package leetcode.editor.cn.leetcode.lc0007;

public class Solution {
    public int reverse(int x) {
        if(x>0)return -reverse(-x);
        int ans = 0;
        while(x!=0){
            int mod = x%10;
            x = x/10;
            if(ans<Integer.MIN_VALUE/10||ans*10<Integer.MIN_VALUE-mod)
                return 0;
            ans = ans*10+mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-123));
    }
}
