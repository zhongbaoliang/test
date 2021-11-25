package newcoder.over.xiecheng;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(int i=0;i<n;i++){
            String linei = scanner.nextLine();
            if("cd".equals(linei.substring(0,2))){
                if(linei.length()==5&&linei.charAt(3)=='.'&&linei.charAt(4)=='.'){
                    if(!stack.isEmpty()) {
                        String cur = stack.pop();
                        int idx = sb.length()-cur.length();
                        sb.delete(idx,sb.length());
                    }
                }
                else{
                    String cur = new StringBuilder("\\").append(linei.substring(3,linei.length())).toString();
                    sb.append(cur);
                    stack.push(cur);
                }
            }
            else{
                if(sb.length()==0)
                    System.out.println("\\");
                else
                    System.out.println(sb);
            }
        }
    }
}
