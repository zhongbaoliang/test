package newcoder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    Queue<Integer> queue ;
    Deque<Integer> deque ;
    public MaxQueue(){
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }
    public void add(int val){
        queue.add(val);
        while (!deque.isEmpty() && deque.peek() < val) deque.pollLast();
        deque.addLast(val);
    }
    public int poll(){
        int val=queue.poll();
        if(val==deque.getFirst())deque.pollFirst();
        return val;
    }

    public int max(){
        if(!deque.isEmpty())return deque.getFirst();
        return -1;
    }
}
