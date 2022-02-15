package javaee.collections;

public class MathTest {
    public static void main(String[] args) {
        Float f=1.123456f;
        //(Math.round(f*100))/100;保留两位小数
        System.out.println(Float.floatToIntBits(f));
        float f1=(float) (Math.round(f*100))/100;//四舍五入
        float f2=(float) (Math.ceil(f*100))/100;//向上取整
        float f3=(float) (Math.floor(f*100))/100;//向下取整
        int f4 = (int) Math.sqrt(1);
        double c =  Math.ceil(124/(10+0.0));
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(c);
        Math.random();
    }
}
