package newcoder.company.oppo;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public ListNode solve(ListNode head){
        ListNode hair = new ListNode(-1);
        while(head!=null){
            ListNode nxt = head.getNext();
            head.setNext(hair.getNext());
            hair.setNext(head);
            head = nxt;
        }
        return hair.getNext();
    }


    public String addBinary(String a, String b) {
        if(a.length()>=b.length())return addS(a,b);
        return addS(b,a);
    }

    public String addS(String a,String b){
        int cc = 0,lenA = a.length(),lenB = b.length();//lenA>=lenB
        StringBuilder ans = new StringBuilder(a);
        int idx = lenA-1,idxB = lenB-1;
        while(idxB>=0){
            int sum = (a.charAt(idx)-'0') + (b.charAt(idxB)-'0')+cc;
            cc = sum/2;
            ans.setCharAt(idx,(char) (sum%2+'0'));
            idx--;
            idxB--;
        }
        while(idx>=0){
            int sum = (a.charAt(idx)-'0')+cc;
            cc = sum/2;
            ans.setCharAt(idx, (char) (sum%2+'0'));

            idx--;
        }
        StringBuilder sb = new StringBuilder();
        if(cc!=0){
            sb.append("1");
        }
        sb.append(ans);
        return sb.toString();
    }



    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        map.containsKey(0);
        StringBuilder sb = new StringBuilder(10);
    }
}
