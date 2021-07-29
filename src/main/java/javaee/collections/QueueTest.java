package javaee.collections;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
//阻塞队列：线程安全。提供阻塞的插入删除方法 put和take

//非阻塞队列插入方法
// add成功返回true,失败抛出异常
// offer成功返回true,失败抛出异常
//
//阻塞队列插入方法
// add成功返回true,失败抛出异常
// offer成功返回true,失败失败则等待一段时间
// put失败返回则一直等待
//对于非阻塞队列，一般情况下建议使用offer、poll和peek三个方法;因为有返回值

//put,take  阻塞队列
//offer,poll 非阻塞队列
//add，remove 链表
class User{
    int id;
    int age;
    String name;
    User(int id , int age,String name){
        this.id=id;
        this.age=age;
        this.name=name;
    }

}

public class QueueTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue=new ArrayBlockingQueue(3);
        //arrayBlockingQueue.put(1);
        //arrayBlockingQueue.add(2);
        arrayBlockingQueue.offer(3);
        arrayBlockingQueue.poll();

    }
    public static void noBlocking(){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(2);
        queue.peek();
        queue.poll();
        if(queue.isEmpty())return;
    }

    public static void deQueue(){
        Deque<Integer> deque=new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(10);
        deque.getFirst();
        deque.getLast();
        deque.pollFirst();
        deque.pollLast();
    }
    @Test
    public void priorityQ(){
        PriorityQueue<User> queue=new PriorityQueue<>((root,son)-> {

            if(root.id-son.id!=0)
                return son.id-root.id;
            else if(root.age-son.age!=0)
                return son.age-root.age;
            return son.name.compareTo(root.name);
        });
                /*new PriorityQueue<>(new Comparator<User>() {
            @Override
            public int compare(User root, User son) {
                if(root.id-son.id!=0)
                    return root.id-son.id;
                else if(root.age-son.age!=0)
                    return root.age-son.age;
                return root.name.compareTo(son.name);
            }
        });*/
        queue.offer(new User(11,20,"ab"));
        queue.offer(new User(12,15,"ab"));
        queue.offer(new User(13,20,"ab"));
        queue.offer(new User(11,21,"ab"));
        queue.offer(new User(11,20,"abc"));

        while(!queue.isEmpty())
            System.out.println(queue.peek().id + " " +queue.peek().age + " " + queue.poll().name);
    }

}
