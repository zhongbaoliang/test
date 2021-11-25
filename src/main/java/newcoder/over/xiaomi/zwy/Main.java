package newcoder.over.xiaomi.zwy;

import java.util.Scanner;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node head = new Node(1),ptr = head;
        for(int i=2;i<101;i++){
            ptr.next = new Node(i);
            ptr = ptr.next;
        }
        ptr.next = head;
        ptr = head;
        for(int i=1;i<n;i++){//前N-1次
            Node pre = ptr.next.next;
            pre.next = pre.next.next;
            ptr = pre.next;
        }
        System.out.println(ptr.next.next.next.val);
    }
}
