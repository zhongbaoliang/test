package javaee.collections;

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


public class QueueTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue=new ArrayBlockingQueue(3);
        //arrayBlockingQueue.put(1);
        //arrayBlockingQueue.add(2);
        arrayBlockingQueue.offer(3);
        arrayBlockingQueue.poll();
    }
}
