package javaee.oop.extendsTest;

class ListNode<T>{
    T val;
    ListNode next;
}

public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 10;
        System.out.println(listNode.val);
    }
}
