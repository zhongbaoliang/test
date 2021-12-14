package javaee.collections;

import org.junit.Test;
/**
 * HashMap                 不安全      无锁                 二倍扩容
 * HashTable                安全      全表所                二倍加一
 * ConcurrentHashMap        安全      由分段锁到锁头结点       二倍扩容
 *
 *基于Hash散列与链表或红黑树
 *
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * hashmap
 * 2倍扩容
 * hash码：右移16位，与操作
 **/


public class MapTest {  @Test
    public void test(){
        Map<Integer,String > map = new HashMap<Integer, String>(){{
            put(1,"111");
            put(2,"222");
            put(3,"333");
        }};
        Map<Integer,String > map1 = new HashMap<>(new HashMap<Integer, String>(){
            {
                put(1, "111");
                put(2, "222");
                put(3, "333");
            }
        });
        /**
        *
        * 1.此种方式是匿名内部类的声明方式，所以引用中持有着外部类的引用。
         * 所以当串行化这个集合时外部类也会被不知不觉的串行化，当外部类没有实现serialize接口时，就会报错。
        * 2.上例中，其实是声明了一个继承自HashMap的子类。
         * 然而有些串行化方法，例如要通过Gson串行化为json，或者要串行化为xml时，需要类库中提供的方式，
         * 是无法串行化Hashset或者HashMap的子类的，从而导致串行化失败。解决办法：重新初始化为一个HashMap对象。
        *
        * */
        for(Map.Entry entry:map.entrySet()){
            entry.setValue("123");
            //map.remove(entry.getKey());

        }
        char ch = 't';
        int[] arr = new int[]{1,2,3,4};
        int a = arr[ch-'a'];
        

        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            entry.setValue("111");
        }
    }

    @Test
    public void visit01(){//迭代器
        Map<Integer,String > map=new HashMap<>();
        map.put(5,"asd");
        map.put(3,"zxc");
        map.put(5,"zxc");//重复键值写入最新的元素
        map.put(1,"asd");
        Iterator iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("key:" + entry.getKey() + ", " + "val:" + entry.getValue());
            entry.setValue("123");
        }

        iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("key:" + entry.getKey() + ", " + "val:" + entry.getValue());
            iterator.remove();
            //entry.setValue("123");

        }
        System.out.println(map.size());
    }

    @Test
    public void visit02(){//entrySet
        Map<Integer,String > map=new HashMap<>();
        map.put(5,"asd");
        map.put(3,"zxc");
        map.put(5,"zxc");//重复键值写入最新的元素
        map.put(1,"asd");
        map.remove(1);
        map.get(5);
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        for (Map.Entry entry:map.entrySet()) {//entry.getValue();返回的是Object
            Integer value = (Integer) entry.getValue();
            System.out.println("key:" + entry.getKey() + ", " + "val:" + entry.getValue());
        }
    }

    @Test
    public void visit03(){//keySet
        Map<Integer,String > map=new HashMap<>();
        map.put(5,"asd");
        map.put(3,"zxc");
        map.put(5,"zxc");//重复键值写入最新的元素
        map.put(1,"asd");
        String getK = map.getOrDefault(0,"0");
        getK = map.get(1);
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            System.out.println("key:" + key + ", " + "val:" + map.get(key));
        }
    }

    @Test
    public void visit04(){//lambda
        Map<Integer,String > map=new HashMap<>();
        map.put(5,"asd");
        map.put(3,"zxc");
        map.put(5,"zxc");//重复键值写入最新的元素
        map.put(1,"asd");
        map.forEach((key,val)->{
            System.out.println("key:" + key + ", " + "val:" + val);

        });
    }

    @Test
    public void test01(){//lambda
        Map<Integer,String > map=new HashMap<>();
        map.put(5,"asd");
        map.put(3,"zxc");
        map.put(5,"zxc");//重复键值写入最新的元素
        map.put(1,"asd");
        for(Map.Entry entry : map.entrySet()){
            entry.getKey();
            entry.getValue();

        }
    }



}