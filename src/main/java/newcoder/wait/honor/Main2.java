package newcoder.wait.honor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String decompression = scanner.nextLine();
        String compression = decompression;
        StringBuilder ans = new StringBuilder("@"),before = new StringBuilder();
        Map<String ,Integer> map = new HashMap<>();
        int code = 1;
        char cur = decompression.charAt(0);
        for(int i=1;i<decompression.length();i++){
            if(cur==decompression.charAt(i)) {
                before.append(cur);
            }
            else{
                if(before.length()>=4){
                    String str = before.toString();
                    Integer codei = map.get(str);
                    if(codei!=null){
                        ans.append("[").append(codei).append("]");
                    }
                    else{
                        map.put(str,code);
                        StringBuilder sb = new StringBuilder();
                        int idx = ans.indexOf("@");
                        sb.append(ans.substring(0,idx));
                        sb.append(code).append(str);
                        sb.append(ans.substring(idx,ans.length()));
                        ans=sb;
                        ans.append("[").append(code).append("]");
                        code++;
                    }
                }
                else{
                    ans.append(before);
                }
                cur = decompression.charAt(i);
                before = new StringBuilder(cur);
            }
        }
        if(map.isEmpty())
            System.out.println(decompression);
        else{
            System.out.println("compress:"+ans);
            System.out.println("decompression:"+decompression);
        }
    }
}
