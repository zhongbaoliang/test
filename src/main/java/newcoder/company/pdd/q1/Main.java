package newcoder.company.pdd.q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int h = scanner.nextInt(),w = scanner.nextInt();
            char arr[][] = new char[h][w];
            int centerX = 1,centerY = 1,count = 0;
            boolean tag = false;
            scanner.nextLine();
            for (int i = 0; i < h; i++) {

                String line = scanner.nextLine();
                //System.out.println(line);
                arr[i] = line.toCharArray();
                for (int i1 = 0; i1 < w; i1++) {
                    if(arr[i][i1]=='*')count++;
                }
            }
            for(;centerX<(h-1);centerX++){
                for (centerY = 1;centerY<(w-1);centerY++){
                    if(arr[centerX][centerY]=='*')
                        if(arr[centerX-1][centerY]=='*'&&arr[centerX][centerY-1]=='*'&&
                                arr[centerX+1][centerY]=='*'&&arr[centerX][centerY+1]=='*') {
                            tag=true;
                            break;
                        }
                }
                if(tag)break;
            }
            if(centerX==(h-1)||centerY==(w-1)) {
                System.out.println("NO");
                continue;
            }
            int beginY = -1,endX = -1,beginX = -1,endY = -1;
            for(beginY = centerY;beginY>=0;beginY--) {
                if (arr[centerX][beginY] != '*') {
                    break;
                }
            }
            for(endY = centerY;endY<w;endY++) {
                if (arr[centerX][endY] != '*') {
                    break;
                }
            }
            for(beginX = centerX;beginX>=0;beginX--) {
                if (arr[beginX][centerY] != '*') {
                    break;
                }
            }
            for(endX = centerX;endX<h;endX++) {
                if (arr[endX][centerY] != '*') {
                    break;
                }
            }
            beginX++;
            beginY++;
            endX--;
            endY--;

            if(centerX==beginX||centerY==beginY||(centerX-beginX)!=(endX-centerX)||(endY-centerY)!=(centerY-beginY)||(endX-beginX+endY-beginY+1)!=count){
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");



        }
    }
}
