package newcoder.over.kedaxunfei;

import java.util.ArrayList;
import java.util.Arrays;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
      this.val = val;
    }
  }

public class Main {
    public int[] minimumNumber (int[] target) {
        // write code here
        int ans[] = new int[target.length];
        for (int i = 0; i < target.length; i++) {
            int rest = target[i]-10;
            ans[i]=4;
            if(rest<0) {
                ans[i] = -1;
                continue;
            }
            double d = ((double) (rest))/4;
            ans[i] += (int) Math.ceil(d);
        }
        return ans;
    }








    int ans = 0,len;
    int arr[],arr2[],edgeIdx[] = new int[3],edgeNum = 0;
    public int happyTriangle (int[] length) {
        // write code here
        arr = length;

        len = length.length;
        Arrays.sort(length);
        arr2=Arrays.copyOf(arr,len);
        for (int i = 0; i < len; i++) {
            arr2[i]*=arr2[i];
        }

        dfs(0);


        return ans;
    }
    public void dfs(int begin){
        if(edgeNum==3){
            if(check())
                ans++;
            return;
        }


        for(int i=begin;i<len;i++) {
            edgeIdx[edgeNum] = i;
            edgeNum++;
            dfs(i+1);
            edgeNum--;
            if(edgeNum==2&&arr[edgeIdx[0]]+arr[edgeIdx[1]]<=arr[edgeIdx[2]])break;

        }

    }

    public boolean check(){
        if(arr[edgeIdx[0]]+arr[edgeIdx[1]]<=arr[edgeIdx[2]]
            || arr2[edgeIdx[0]]+arr2[edgeIdx[1]]==arr2[edgeIdx[2]]
            ||(arr[edgeIdx[0]]==arr[edgeIdx[1]]&&arr[edgeIdx[0]]==arr[edgeIdx[2]]))return false;
        return true;
    }




    public TreeNode shiftTree (TreeNode root, int k) {
        // write code here
        //
        ArrayList<ArrayList<TreeNode>> layerLeaves = new ArrayList<>();

        return root;
    }

    public static void main(String[] args) {
        int[] target = {5,3,4,6,6,1};
        System.out.println(new Main().happyTriangle(target));
    }
}
