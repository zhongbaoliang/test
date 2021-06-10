package newcoder;
//Arrays.copyOfRange(arr,from,to) 起始位置，结束位置（+1）


import org.junit.Test;

import java.util.Scanner;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {

    //NC22 合并两个有序数组
    public static void merge(int A[], int m, int B[], int n) {
        int i=m-1,j=n-1,k=m+n-1;
        while(k>=0){
            if(i<0||j<0)
                break;
            if(A[i]>B[j])
                A[k--]=A[i--];
            else
                A[k--]=B[j--];

        }
        while(j>=0)
            A[k--]=B[j--];
    }
    public static void testNC22(){
        int m,n;
        Scanner scanner=new Scanner(System.in);
        m=scanner.nextInt();
        n=scanner.nextInt();
        int nums1[]=new int[m+n],nums2[]=new int[n];

        for(int i=0;i<m;i++){
            nums1[i]= scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            nums2[i]= scanner.nextInt();
        }

        merge(nums1,m,nums2,n);
        for(int i=0;i<n+m;i++){
            System.out.println(nums1[i]+" ");
        }
    }

    //NC105 二分查找
    public static int search (int[] nums, int target) {
        // write code here
        /*if(nums.length==0)
            return -1;
        int idx=(nums.length-1)/2;
        if(nums.length==1){
            if(nums[idx]==target)
                return idx;
            else
                return -1;
        }
        if(nums[idx]>=target)
            idx=search(Arrays.copyOfRange(nums,0,idx+1),target);
        else
            idx=idx+1+search(Arrays.copyOfRange(nums,idx+1,nums.length),target);
        return idx;*/

        int l=0,h=nums.length-1,ans=-1;
        while(l<h){
            int mid=(h-l)/2+l;
            if(nums[mid]>=target)
                h=mid;
            else
                l=mid+1;
        }
        return l==h?l:-1;
    }
    public static void testNC105(){
        /*
        5
        1 2 4 4 5
        4
        */
        Scanner scanner=new Scanner(System.in);
        int n;
        n=scanner.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]= scanner.nextInt();
        }
        int target=scanner.nextInt();
        System.out.println(search(nums,target));
    }

    //JZ03 数组中的重复元素
    public static int findRepeatNumber(int[] nums) {
        int num=-1;
        for(int i=0;i<nums.length;){
            if(nums[i]!=i){
                num=nums[nums[i]];
                if(num==nums[i])
                    break;
                nums[nums[i]]=nums[i];
                nums[i]=num;
            }
            else
                i++;
        }
        return num;
    }
    public static int findRepeatNumber1(int[] nums){
        int num=-1;
        HashMap<Integer,Integer> hashMap=new HashMap();
        for(int i=0;i<nums.length;i++){
            if(hashMap.get(nums[i])!=null)
                return nums[i];
            else
                hashMap.put(nums[i],1);
        }

        return num;
    }



    //JZ04二维数组中的查找
    public static boolean Find(int target, int [][] array) {
        for(int i=array.length-1,j=0;i>=0&&j<array[0].length;){
            if(array[i][j]==target)
                return true;
            else if(array[i][j]<target)
                j++;
            else
                i--;
        }

        return false;
    }
    public static void JZ01(){
        int target=7,array[][]={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(target,array));;
    }

    //JZ05 替换空格
    public static String replaceSpace(String s) {
        int blankNum=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')
                blankNum++;
        }
        char[] chars=new char[s.length()+blankNum*2];
        for(int i=0,j=0;i<s.length();i++){
            if(s.charAt(i)!=' ')
                chars[j++]=s.charAt(i);
            else {
                chars[j++]='2';
                chars[j++]='0';
                chars[j++]='%';
            }
        }
        return String.valueOf(chars);
    }
    public static String replaceSpace1(String s){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0,j=0;i<s.length();i++){
            if(s.charAt(i)!=' ')
                stringBuilder.append(s.charAt(i));
            else {
                stringBuilder.append("%20");
            }
        }
        return String.valueOf(stringBuilder);
    }
    public static String replaceSpace2(String s){
        return s.replaceAll(" ","%20");
    }

    //JZ06 从尾到头打印链表
    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int arr[]=new int[stack.size()];
        int i=0;
        while (!stack.empty()){
            arr[i++]=stack.pop();
        }
        return arr;

    }

    //JZ07 重建二叉树
    public HashMap<Integer,Integer> hashMap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //可以通过hashMap对查找过程进行优化，注意map中下标是原始数组下标，因此必须使用原始数组作为参数传递
        if(preorder.length==0)
            return null;
        TreeNode treeNode=new TreeNode(preorder[0]);
        int leftNodeNum=0;
        for (; leftNodeNum < inorder.length; leftNodeNum++) {
            if(inorder[leftNodeNum]==preorder[0])
                break;
        }
        treeNode.left=buildTree(Arrays.copyOfRange(preorder,1,leftNodeNum+1),
                Arrays.copyOfRange(inorder,0,leftNodeNum) );

        treeNode.right=buildTree(Arrays.copyOfRange(preorder,leftNodeNum+1,preorder.length),
                Arrays.copyOfRange(inorder,leftNodeNum+1,inorder.length));
        return treeNode;
    }
    public TreeNode build(int[] preorder, int[] inorder){
        //可以通过hashMap对查找过程进行优化，注意map中下标是原始数组下标，因此必须使用原始数组作为参数传递
        if(preorder.length==0)
            return null;
        TreeNode treeNode=new TreeNode(preorder[0]);
        int leftNodeNum=0;
        for (; leftNodeNum < inorder.length; leftNodeNum++) {
            if(inorder[leftNodeNum]==preorder[0])
                break;
        }
        treeNode.left=buildTree(Arrays.copyOfRange(preorder,1,leftNodeNum+1),
                Arrays.copyOfRange(inorder,0,leftNodeNum) );

        treeNode.right=buildTree(Arrays.copyOfRange(preorder,leftNodeNum+1,preorder.length),
                Arrays.copyOfRange(inorder,leftNodeNum+1,inorder.length));
        return treeNode;
    }
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    //JZ09 两个栈实现队列
    class CQueue {

        Stack<Integer> in,out;
        public CQueue() {
            in=new Stack<>();
            out=new Stack<>();
        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {
            if(!out.empty())
                return out.pop();
            else{
                if(!in.empty()){
                    while(!in.empty())
                        out.push(in.pop());
                    return out.pop();
                }
            }
            return -1;
        }
    }
    public static void JZ07(){
        int pre[]={3,9,20,15,7};
        int in[]={9,3,15,20,7};
        new Solution().buildTree(pre,in);
    }



    //JZ12 矩阵中的路径
    public static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                if(test(board,word,i,j,0))
                    return true;
            }
        return false;
    }
    public static boolean test(char[][] board,String word,int i,int j,int k){
        if(k==word.length())
            return true;
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(k))
            return false;
        board[i][j]='0';
        boolean ans= test(board,word,i-1,j,k+1)||test(board,word,i+1,j,k+1)||
                test(board,word,i,j-1,k+1)||test(board,word,i,j+1,k+1);
        board[i][j]=word.charAt(k);
        return ans;
    }

    //JZ15 二进制1的个数
    private final long arr[]=new long[32];
    @Test
    public void test15(){
        System.out.println(hammingWeight(-1));
    }
    public int hammingWeight(int n) {
        //return Integer.toBinaryString(n).replaceAll("0","").length();
        int ans=0;
        while(n!=0){
            if((n&1)==1)
                ans++;
            n=n>>>1;
        }
        return ans;
    }

    //JZ16 数值的整数次方
    //快速幂算法
    @Test
    public void test16(){
        System.out.println(myPow(2,5));

    }
    public double myPow(double x, int n) {
        if(x==0)return 0;
        double ans=1,b=x;
        int a=n;
        if(a<0){
            a=-a;
            b=1/b;
        }

        while(a!=0){
            if((a&1)==1)
                ans*=b;
            a=a>>>1;
            b*=b;
        }

        /*while(a--!=0){//O(n)
            ans*=x;
        }*/

        return ans;
    }


    //JZ19 正则表达式匹配

    public boolean isMatch(String s, String p) {
        int i=0;

        while(i!=s.length()){
            if(s.charAt(i)==p.charAt(i))
                i++;
            else{

            }

        }
        return true;
    }


    public static void main(String[] args) {
        //testNC22();

        //testNC105();

        //JZ01();

        char arr[][]={{'a'}};
        System.out.println(exist(arr,"ab"));

    }

}
