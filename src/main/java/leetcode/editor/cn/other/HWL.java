package leetcode.editor.cn.other;

import java.util.PriorityQueue;

   class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }

public class HWL {
    public static int findK (int[] array, int n, int k) {
        // write code here
        if(array==null||n==0||k<1)return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((root,child)->{
            return child-root;
        });
        for(int i=0;i<k;i++){
            pq.add(array[i]);
        }
        for(int i=k;i<n;i++){
            if(pq.peek()>array[i]) {
                pq.poll();
                pq.add(array[i]);
            }
        }
        return pq.peek();
    }

    public ListNode reverseKGroup (ListNode list, int k) {
        // write code here
        ListNode hair = new ListNode(0);
        hair.next = list;
        ListNode pre =hair;
        while(list!=null){
            ListNode tail = pre;
            for(int i=0;i<k;i++){
                tail = tail.next;
                if(tail==null)return hair.next;
            }
            ListNode next = tail.next;
            ListNode[] reverse = myReverse(list,tail);
            list = reverse[0];
            hair = reverse[1];
            pre.next = list;
            tail.next=next;
            pre=tail;
            list=tail.next;
        }
        return hair.next;


    }

    public ListNode[] myReverse(ListNode head,ListNode tail){
        ListNode pre = tail.next;
        ListNode p = head;
        while(pre!=tail){
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return new ListNode[]{tail,head};
    }

    public static void main(String[] args) {
        System.out.println(findK(new int[]{1,3,5,2,2},5,3));
    }

}
