package javaee.grammerTest;

import org.junit.Test;

import static java.lang.Math.pow;

public class Constructor {
    int id=1;
    static String company;
    Constructor(int id){
        this.id=id;
    }

    public static void test(){
        //this.id=0;//静态方法不能使用this
    }



     public static int cuttingRope(int n) {
        //尽可能多3
        if(n<=3)
            return n-1;
        int a=n/3,b=n%3;
        if(b==1) return (int) (pow(3,a-1)*4);
        if(b==2) return (int) (pow(3,a)*2);
        return (int) pow(3,a);
    }
    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }
}
