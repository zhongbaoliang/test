package newcoder;
//Arrays.copyOfRange(arr,from,to) 起始位置，结束位置（+1）


import org.junit.Test;

import java.util.Scanner;
import java.util.*;

class MinStack {

    /** initialize your data structure here. */

    Stack<Integer> s;
    Stack<Integer> min;
    public MinStack() {
        s=new Stack<Integer>();
        min=new Stack<Integer>();
    }

    public void push(int x) {
        if(!min.isEmpty()&&x>min.peek())
            min.push(min.peek());
        else
            min.push(x);
        s.push(x);

    }

    public void pop() {
        s.pop();
        min.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return min.peek();
    }
}

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
    public static void JZ19(){
        System.out.println(isMatch("aaa","ab*a*c*a"));

    }
    public static boolean isMatch(String s, String p) {
        int m=s.length(),n=p.length();
        boolean dp[][]=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=2;i<n+1;i+=2)
            if(p.charAt(i-1)=='*'&&dp[0][i-2])
                dp[0][i]=true;
        for(int i=1;i<m+1;i++)
            for(int j=1;j<n+1;j++){
                if(p.charAt(j-1)=='*'){
                    if((j>1&&dp[i][j-2])||
                            //(dp[i-1][j-1]&&(p.charAt(j-2)=='.'||p.charAt(j-2)==s.charAt(i-1)))
                            //把模式串的* 和 主串的对应的字符去掉；注意此处仅仅是将前一字符匹配两次（*一次，字符本身一次）

                            (dp[i-1][j]&&(p.charAt(j-2)=='.'||p.charAt(j-2)==s.charAt(i-1)))
                            //主串前移一位；匹配前一字符至少一次
                            )
                        dp[i][j]=true;

                }
                else{
                    if(dp[i-1][j-1]&&(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.'))
                        dp[i][j]=true;
                }
            }
        return dp[m][n];
    }

    //JZ20 表示数值的字符串——词法分析
    //正则语言的三种形式：文法，正则式，自动机
    //根据描述写出正则式，根据正则式画有限自动机，转换为DNF，即去空化，确定化（只有一个起始状态）
    public static boolean isNumber(String s) {
        int state=0;
        Map[] map = {
                new HashMap<Character, Integer>() {{ put(' ',0); put('s',1); put('d',2); put('.',8);}}, // 0.
                new HashMap<Character, Integer>() {{ put('d',2); put('.',8);}},                           // 1.
                new HashMap<Character, Integer>() {{ put('d',2); put('.',3); put('e',4); put(' ',7);}}, // 2.
                new HashMap<Character, Integer>() {{ put('d', 3); put('e', 4); put(' ', 7); }},              // 3.
                new HashMap<Character, Integer>() {{ put('s', 5); put('d',6);}},                                        // 4.
                new HashMap<Character, Integer>() {{ put('d', 6);}},                           // 5.
                new HashMap<Character, Integer>() {{ put('d', 6); put(' ',7);}},                                        // 6.
                new HashMap<Character, Integer>() {{ put(' ', 7); }},                           // 7.
                new HashMap<Character, Integer>() {{ put('d', 3); }}                                         // 8.
        };
        int len=s.length(), i=0;
        while(i<len){
            char ch=s.charAt(i++);
            if(ch>='0'&&ch<='9')ch='d';
            else if(ch=='e'||ch=='E') ch='e';
            else if(ch=='+'||ch=='-') ch='s';
            Object obj= map[state].get(ch);
            if(obj==null)return false;
            state=(int)obj;

        }

        if(state==2||state==3||state==6||state==7)
            return true;
        return false;
    }
    public static void JZ20(){
        System.out.println(isNumber("+12.23e+456"));
    }


    //JZ56 newCode 删除链表中重复的结点
    //
    public ListNode deleteDuplication1(ListNode pHead) {
        if(pHead==null||pHead.next==null)
            return pHead;
        ListNode pre=pHead, ptr=pHead.next;
        while(ptr!=null){
            if(pre.val==ptr.val){
                while(pre.val==ptr.val){
                    if(ptr.next==null)return null;
                    ptr=ptr.next;
                }
                pHead=ptr;
                pre=pHead;
                ptr=pHead.next;
            }
            else{
                break;
            }
        }
        while(ptr!=null&&ptr.next!=null){
            if(ptr.val==ptr.next.val){
                ptr=ptr.next;
            }
            else {
                if(ptr!=pre.next){
                    pre.next=ptr.next;
                    //pre=pre.next;
                    ptr=pre.next;
                }
                else{
                    pre=ptr;
                    ptr=ptr.next;
                }
            }

        }
        if(ptr!=pre.next)//pre.next到ptr都相等，且ptr.next==null
            pre.next=null;
        return pHead;

    }

    //设置虚拟头节点，避免头结点额外处理，也可递归来简化
    public ListNode deleteDuplication(ListNode pHead){
        ListNode vHead=new ListNode(-1);
        vHead.next=pHead;
        ListNode pre=vHead,ptr=pHead;
        while(ptr!=null){
            if(ptr.next!=null){
                if (ptr.val != ptr.next.val) {
                    if (ptr == pre.next) {
                        pre = ptr;
                    } else {
                        pre.next = ptr.next;
                    }
                }
                ptr=ptr.next;
            }
            else{
                if (ptr != pre.next) {
                    pre.next = null;
                }
                ptr=null;
            }

        }
        return vHead.next;
    }
    public static void JZ29(){
        int[][] arr={{1,2},{3,4}};
        printMatrix(arr);
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        //边界指针

        if(matrix==null||matrix.length==0||matrix[0].length==0)return new ArrayList(0);
        int top=0,left=0,right=matrix[0].length-1,bottom=matrix.length-1;
        int len=matrix.length*matrix[0].length;
        ArrayList<Integer> ans=new ArrayList(len);
        int idx=0;
        while(idx<len){
            for(int col=left;col<=right;col++,idx++){
                ans.add(matrix[top][col]);
            }
            for(int row=top+1;row<=bottom;row++,idx++){
                ans.add(matrix[row][right]);
            }
            if(idx==len)break;

            for(int col=right-1;col>=left;col--,idx++){
                ans.add(matrix[bottom][col]);
            }
            for(int row=bottom-1;row>top;row--,idx++){//注意是>
                ans.add(matrix[row][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if(root==null)return new String(sb);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node==null)
                sb.append("null,");
            else{
                sb.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return new String(sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||"".equals(data))return null;
        String[] nodes=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int len=nodes.length,idx=1;
        while(idx<len-1){
            TreeNode ptr=queue.poll();
            if("null".equals(nodes[idx])){
                ptr.left=null;
            }
            else{
                ptr.left = new TreeNode(Integer.parseInt(nodes[idx]));
                queue.offer(ptr.left);
            }
            idx++;
            if("null".equals(nodes[idx])){
                ptr.right=null;
            }
            else{
                ptr.right = new TreeNode(Integer.parseInt(nodes[idx]));
                queue.offer(ptr.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        //testNC22();

        //testNC105();

        //JZ01();

        JZ29();
    }

}
