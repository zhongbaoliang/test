package javaee.grammerTest;

public class TryCatchFinallyTest {
    public static String output ="";
    public static void Method(int i){
        try{
            if(i==1){
                throw new Exception();
            }
            output+="A";
        }
        catch (Exception e){
            output+="B";
            return;
        }
        finally {
            output+="C";
        }
        output+="D";
    }
    public static void main(String[] args) {
        Method(1);
        Method(2);
        System.out.println(output);
    }
}
