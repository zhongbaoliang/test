package newcoder.company.ali;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
     static int n,m;
     static int edge[][];
     static String[] people = {"Alice","Bob"};
    static String cur;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T= scanner.nextInt();
        while(T-->0){
            n= scanner.nextInt();
            n+=1;
            m= scanner.nextInt();
            edge =new int[n][n];
            for(int i=0;i<m;i++){
                edge[scanner.nextInt()][scanner.nextInt()]=1;
            }

            scanner.nextLine();
            cur = scanner.nextLine();
            System.out.println(cur);
        }
    }



    public static String solve(){

        //getSteps();

        int pos=1;
        while(pos!=n){

            pos=findNext(pos);
        }

        return cur;
    }

    /*public void getSteps(){
        LinkedList<Integer> start = new LinkedList<>();
        start.add(0);
        steps[n-1][n-1]=start;
        for(int i=n-1;i>0;i--){
            //steps[i][]
        }

    }
*/

    public static int findNext(int pos){
        for(int i=pos+1;i<n;i++)
            if(edge[pos][i]==1)
                return i;
        return n;
    }


}
