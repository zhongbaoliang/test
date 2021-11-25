package newcoder.wait.shangtang;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public int[][] setZeros (int[][] matrix) {
        // write code here
        Set<Integer> row = new HashSet<>(),col = new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                        row.add(i);
                        col.add(j);
                }
            }
        }
        for(Integer i : row){
            for (int k = 0; k < matrix[0].length; k++)
                matrix[i][k] = 0;
        }
        for(Integer j : col){
            for (int k = 0; k < matrix.length; k++)
                matrix[k][j] = 0;
        }
        return matrix;
    }


    public int firstMissingAge (int[] ages) {
        // write code here
        int len = ages.length;
        boolean arr[] = new boolean[50];//小孩年龄不会超过49岁吧
        for(int i=0;i<len;i++){
            if (ages[i] > 0 && ages[i] < 50) {
                arr[ages[i]]=true;
            }
        }
        for(int i=1;i<50;i++){
            if(!arr[i])return i;
        }
        return 50;

    }
}
