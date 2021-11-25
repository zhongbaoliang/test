package leetcode.editor.cn.JZ.JZ002;

public class Main {
    public int divide(int a, int b) {
        if(a==Integer.MIN_VALUE&&b==-1)return Integer.MIN_VALUE;
        int sign = ((a>0 && b>0)||(a<0 && b<0))?1:-1;
        int ans = 0;
        a = Math.abs(a);
        b = Math.abs(b);
        while (a>=b){
            a-=b;
            ans++;
        }
        return sign*ans;

    }

    public static void main(String[] args) {
        System.out.println(new Main().divide(7,-3));
    }
}
