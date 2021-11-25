package newcoder.wait.honor;

import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] instructs = line1.split("\\|");
        LinkedList<String> text = new LinkedList<>();
        int len = instructs.length;
        int lines = 1;
        for (int i = 0; i < len; i++) {
            String instructi[] = instructs[i].split(" ");
            if("i".equals(instructi[1])){
                int line = Integer.parseInt(instructi[0]);
                if(line<=lines){
                    StringBuilder sb = new StringBuilder();
                    for(int j=2;j<instructi.length;j++)
                        sb.append(instructi[j]+" ");
                    sb.deleteCharAt(sb.length()-1);
                    text.add(line-1,sb.toString());
                    lines++;
                    continue;
                }

            }
            if("a".equals(instructi[1])){
                int line = Integer.parseInt(instructi[0]);
                if(line<lines){
                    StringBuilder sb = new StringBuilder();
                    for(int j=2;j<instructi.length;j++)
                        sb.append(instructi[j]+" ");
                    sb.deleteCharAt(sb.length()-1);
                    text.add(line,sb.toString());
                    lines++;
                    continue;
                }
            }
            if("r".equals(instructi[1])){
                int line = Integer.parseInt(instructi[0]);
                if(line<=lines){
                    StringBuilder sb = new StringBuilder();
                    for(int j=2;j<instructi.length;j++)
                        sb.append(instructi[j]+" ");
                    sb.deleteCharAt(sb.length()-1);
                    text.set(line-1,sb.toString());
                    continue;
                }
            }
            if("d".equals(instructi[1])){
                int line = Integer.parseInt(instructi[0]);
                if(line<lines){
                    text.remove(line-1);
                    lines--;
                    continue;
                }
            }
            System.out.println("error");
            return ;
        }

        for (String s : text) {
            System.out.println(s);
        }
    }
}
