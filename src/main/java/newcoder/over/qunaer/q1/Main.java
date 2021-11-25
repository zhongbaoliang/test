package newcoder.over.qunaer.q1;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    /* Write Code Here */
    public String solution(int[] d) {
        if(d==null||d.length==0)return null;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(),pq2 = new PriorityQueue<>(),pq0 = new PriorityQueue(
                new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return (Integer)o2-(Integer) o1;
                    }
                }
        );
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            if(d[i]%3==0)pq0.add(d[i]);
            else if(d[i]%3==1)pq1.add(d[i]);
            else pq2.add(d[i]);
            sum+=d[i];
        }
        if(sum%3==1) {

            if(!pq1.isEmpty())pq1.poll();
            else {
                if(pq2.isEmpty())return null;
                pq2.poll();
                if(pq2.isEmpty())return null;
                pq2.poll();
            }

        }
        else if(sum%3==2) {
            if(!pq2.isEmpty())pq2.poll();
            else {
                if(pq1.isEmpty())return null;
                pq1.poll();
                if(pq1.isEmpty())return null;
                pq1.poll();
            }
        }
        pq0.addAll(pq1);
        pq0.addAll(pq2);
        StringBuilder sb = new StringBuilder();
        while(!pq0.isEmpty()){
            sb.append(pq0.poll());
        }
        return sb.toString();

    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _d_size = 0;
        _d_size = Integer.parseInt(in.nextLine().trim());
        int[] _d = new int[_d_size];
        int _d_item;
        for(int _d_i = 0; _d_i < _d_size; _d_i++) {
            _d_item = Integer.parseInt(in.nextLine().trim());
            _d[_d_i] = _d_item;
        }

        res = new Solution().solution(_d);
        System.out.println(res);
    }
}
