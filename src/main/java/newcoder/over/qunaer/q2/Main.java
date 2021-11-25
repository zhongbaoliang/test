package newcoder.over.qunaer.q2;

import java.util.*;

class Solution {
    /* Write Code Here */
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int max = 0,mul=1;
        for(int i=0;i< arr.length;i++) {
            int maxi = arr[i]*mul;
            max = Math.max(max,maxi);
            mul++;
            for(int j=i+1;j<arr.length;j++){
                maxi += arr[j]*mul;
                mul++;
                max = Math.max(max,maxi);
            }
            mul=1;
        }

        return max;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = new Solution().solution(_arr);
        System.out.println(String.valueOf(res));

    }
}
