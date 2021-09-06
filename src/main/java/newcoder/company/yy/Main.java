package newcoder.company.yy;

import java.util.ArrayList;

public class Main {
    public ArrayList<Double> findPoints (double[] data) {
        // write code here
        ArrayList<Double> arrayList = new ArrayList<>();
        int len = data.length;
        double dp[][] = new double[2][len];
        dp[0][len-1]=data[len-1];
        dp[1][len-1]=len-1;
        for(int i=len-2;i>=0;i--){

            if(data[i]<dp[0][i+1]){
                dp[0][i]=data[i];
                dp[1][i]=i;
            }
            else{
                dp[0][i]=dp[0][i+1];
                dp[1][i]=dp[1][i+1];
            }
        }
        for(int i=1;i<len-1;i++){
            if(dp[0][i]==data[i]&&dp[1][i]==i)
                arrayList.add(data[i]);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        double arr[] = {-5, -2.2, 19, 28, 19, -1.5};
        System.out.println(new Main().findPoints(arr));
    }
}
