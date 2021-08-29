package javaee.collections;

import org.junit.Test;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public void test(){
        Map<Integer,String > map = new HashMap<>();
        map.put(1,"111");
        map.put(2,"222");
        map.put(3,"333");
        for(Map.Entry entry:map.entrySet()){
            entry.setValue("123");
        }

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
            //entry.setValue("123");
            System.out.println("key:" + entry.getKey() + ", " + "val:" + entry.getValue());
        }

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