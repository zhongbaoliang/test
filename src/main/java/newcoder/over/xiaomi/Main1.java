package newcoder.over.xiaomi;

import java.util.Scanner;

class LNode{
    int val;
    LNode pre,next;
    LNode(int val){
        this.val=val;
    }

}

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LNode lNode = new LNode(1),ptr=lNode;
        for(int i = 2;i<n+1;i++){
            LNode cur = new LNode(i);
            ptr.next=cur;
            cur.pre=ptr;
            ptr=cur;
        }
        ptr.next=lNode;
        lNode.pre=ptr;
        ptr=lNode;
        while(n-->1){
            LNode left = ptr.next,right = left.next.next;
            left.next=right;
            right.pre=left;
            ptr=right;
        }
        System.out.println(ptr.val);

    }
}
