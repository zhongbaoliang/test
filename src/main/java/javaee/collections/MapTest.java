package javaee.collections;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
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
        }

    }

    @Test
    public void visit02(){//entrySet
        Map<Integer,String > map=new HashMap<>();
        map.put(5,"asd");
        map.put(3,"zxc");
        map.put(5,"zxc");//重复键值写入最新的元素
        map.put(1,"asd");
        for (Map.Entry entry:map.entrySet()) {
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

}