package javaee.grammerTest;

public class VarInit {
    int memberInt;
    Integer memberInteger;
    float memberFloat;
    boolean memberBoolean;
    char memberChar;
    String memberString;
    boolean[] memberBoolArr=new boolean[5];

    static int staticInt;
    static float staticFloat;
    static boolean staticBoolean;
    static char staticChar;
    static String staticString;
    static boolean[] staticBoolArr=new boolean[5];

    public static void main(String[] args) {
        VarInit varInit=new VarInit();
        System.out.println("varInit.memberInt "+varInit.memberInt);
        System.out.println("varInit.memberInteger "+varInit.memberInteger);
        System.out.println("varInit.memberFloat "+varInit.memberFloat);
        System.out.println("varInit.memberBoolean "+varInit.memberBoolean);
        System.out.println("varInit.memberChar "+varInit.memberChar);
        System.out.println("varInit.memberString "+varInit.memberString);
        for (int i = 0; i < 5; i++) {
            System.out.println("varInit.memberBoolArr[i]"+varInit.memberBoolArr[i]);
        }


        System.out.println("varInit.staticInt "     +staticInt);
        System.out.println("varInit.staticFloat "+   staticFloat);
        System.out.println("varInit.staticBoolean "+ staticBoolean);
        System.out.println("varInit.staticChar "+    staticChar);
        System.out.println("varInit.staticString "+  staticString);
        for (int i = 0; i < 5; i++) {
            System.out.println("memberBoolArr"+i+"  "+staticBoolArr[i]);
        }

        boolean[] localBoolArr=new boolean[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("localBoolArr[i]"+localBoolArr[i]);
        }

    }
}
