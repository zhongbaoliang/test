package newcoder.company.tengxun;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
       this.val = val;
    }
}
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a ListNode类一维数组 指向这些数链的开头
     * @return ListNode类
     */

    /*public ListNode solve (ListNode[] a) {
        // write code here
        ListNode ans = new ListNode(-1),ptr = ans;
        Queue<ListNode> queue = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                queue.add(a[i]);
            }
        }
        while(!queue.isEmpty()) {
            ListNode cur = queue.poll();
            ListNode node = new ListNode(cur.val);
            ptr.next = node;
            ptr = ptr.next;
            if(cur.next!=null)
                queue.add(cur.next);
        }
        return ans.next;
    }
*/

    public static ListNode solve (ListNode[] a) {
        // write code here
        ListNode ans = new ListNode(-1),ptr = ans;
        LinkedList<ListNode> lists = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                lists.add(a[i]);
            }
        }

        while(!lists.isEmpty()) {
            Iterator iterator = lists.iterator();
            int i=0;
            while(iterator.hasNext()) {
                ListNode cur = (ListNode) iterator.next();
                ListNode node = new ListNode(cur.val);
                ptr.next = node;
                ptr = ptr.next;
                if(cur.next!=null)
                    lists.set(i,cur.next);
                else
                    iterator.remove();
                i++;
            }
        }

        return ans.next;

    }

    public static void main(String[] args) {
        ListNode a[] = new ListNode[3];
        a[0] = new ListNode(1);
        a[0].next = new ListNode(2);
        a[0].next.next = new ListNode(3);

        a[1] = new ListNode(1);
        a[1].next = new ListNode(2);

        a[2] = new ListNode(1);

        ListNode ANS = solve(a);
        System.out.println(1);

    }
    /*public ListNode solve (ListNode[] a) {
        // write code here
        ListNode ans = new ListNode(-1),ptr = ans;
        int tag = a.length;
        while(tag>1) {
            tag=0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != null) {
                    tag++;
                    ListNode cur = new ListNode(a[i].val);
                    a[i] = a[i].next;
                    ptr.next = cur;
                    ptr = ptr.next;
                }
            }
        }

        return ans.next;
    }*/
}