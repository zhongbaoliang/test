package newcoder.company.threeSixZero;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt(),m= scanner.nextInt(),x= scanner.nextInt(),k= scanner.nextInt();
        int arr[]=new int[n];

        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            arr[i]= scanner.nextInt();
            min = min < arr[i] ? min : arr[i];
        }
        if(x>=n/2) {
            System.out.println(min+k*m);
            return;
        }
        else{
            System.out.println(min+k*m);
        }

    }


}
