package leetcode.editor.cn.leetcode.lc0008;

class Solution {
    public int myAtoi(String s) {
        if(s==null||s.length()==0)return 0;
        int ans = 0,len = s.length(),idx=0,sign = -1;
        while(idx<len&&s.charAt(idx)==' ')idx++;
        if(s.charAt(idx)=='-'){
            sign = 1;
            idx++;
        }
        else if(s.charAt(idx)=='+'){
            sign = -1;
            idx++;
        }
        while(idx<len){
            char ch = s.charAt(idx++);
            if(ch>='0'&&ch<='9'){
                int cur = '0'-ch;
                if(sign>0&&ans<(Integer.MIN_VALUE-cur)/10)
                    return Integer.MIN_VALUE;
                if(sign<0&&sign*ans>(Integer.MAX_VALUE+cur)/10)
                    return Integer.MAX_VALUE;
                ans=ans*10+cur;
            }
            else
                break;
        }
        return ans*sign;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("-123456789123"));
    }
}
