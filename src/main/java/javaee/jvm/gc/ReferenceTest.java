package javaee.jvm.gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
////强弱软虚引用
//强引用：永不回收（除非手动让其等于null
//软引用：内存不够时回收。可通过get获得
//弱引用：GC时就回收。可通过get获得。ThreadLocal
//虚引用：         。无法通过虚引用获得对象的引用。NIO


public class ReferenceTest
{
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();
    private static LinkedList<WeakReference<VeryBig>> linkedList = new LinkedList<WeakReference<VeryBig>>();

    public static void main(String args[])
    {
        int size = 3;

        for(int i = 0; i < size; i++)
        {
            linkedList.add(new VeryBigWeakReference(new VeryBig("Weak " + i), rq));
        }
        System.out.println("第一个VeryBig对象："+linkedList.getFirst().get());
        System.gc();
        try
        { // 下面休息几分钟，让上面的垃圾回收线程运行完成
            TimeUnit.SECONDS.sleep(6);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        checkQueue();
        System.out.println("第一个VeryBig对象："+linkedList.getFirst().get());
    }

    public static void checkQueue()
    {
        Reference<? extends VeryBig> ref = null;
        while((ref = rq.poll()) != null)
        {
            if(ref != null)
            {
                System.out.println("In queue: " + ((VeryBigWeakReference) (ref)).id);
            }
        }
    }
}

class VeryBig
{
    public String id;
    byte[] b = new byte[2 * 1024];

    public VeryBig(String id)
    {
        this.id = id;
    }

    protected void finalize()
    {
        System.out.println("回收 VeryBig " + id);
    }
}

class VeryBigWeakReference extends WeakReference<VeryBig>
{
    public String id;

    public VeryBigWeakReference(VeryBig big, ReferenceQueue<VeryBig> rq)
    {
        super(big, rq);
        this.id = big.id;
    }

    protected void finalize()
    {
        System.out.println("回收 VeryBigWeakReference " + id);
    }
}