package javaee.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(1,1);

        hashMap.remove(1);
    }
}
