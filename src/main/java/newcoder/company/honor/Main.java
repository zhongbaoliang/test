package newcoder.company.honor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String data[] = line1.split(" ");
        int start = scanner.nextInt(),len = scanner.nextInt(),dataNum = data.length;
        StringBuilder sb = new StringBuilder();
        int end = Math.min(start+len-1,dataNum);
        for(int i=start-1;i<end;i++){
            sb.append(data[i]+";");
            if(i!=(start-1)&&(i-start+2)%20==0){
                sb.deleteCharAt(sb.length()-1);
                System.out.println(sb);
                sb = new StringBuilder();
            }
        }
        if(sb.length()!=0){
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
        }

    }
}
