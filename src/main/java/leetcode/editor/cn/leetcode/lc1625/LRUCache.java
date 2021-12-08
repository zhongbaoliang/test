package leetcode.editor.cn.leetcode.lc1625;

import java.util.*;

class LRUCache {

    class ListNode{
        int key,val;
        ListNode before,next;
        ListNode(int key,int val){
            this.key = key;
            this.val = val;
            before = next = this;
        }
    }

    private void addLast(ListNode cur){
        cache.before.next = cur;
        cur.before = cache.before;
        cur.next = cache;
        cache.before = cur;
    }

    private void removeFirst(){
        removeListNode(cache.next);
    }

    private void removeListNode(ListNode cur){
        cur.before.next = cur.next;
        cur.next.before = cur.before;
    }

    ListNode cache;
    Map<Integer,ListNode> map;
    int capacity,size;
    public LRUCache(int capacity) {
        cache = new ListNode(-1,-1);
        map = new HashMap<>();
        this.capacity = capacity;
        size = 0;
    }



    public int get(int key) {
        if(map.containsKey(key)){
            ListNode cur = map.get(key);
            removeListNode(cur);
            addLast(cur);
            //cache.remove(cur);//移不出去
            //cache.addAll(cur);
            return cur.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        ListNode cur = new ListNode(key,value);
        if(map.containsKey(key)){
            cur = map.get(key);
            removeListNode(cur);
            cur.val = value;
        }
        else{
            if(size==capacity){
                map.remove(cache.next.key);
                removeFirst();
            }
            else
                size++;
            map.put(key,cur);
        }
        addLast(cur);
    }
    public int add(Integer a,Integer b){
        return a+b;
    }
    public Object add(Object o1,Object o2){
        return o1;
    }



    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        System.out.println(cache.add(1,1));
        System.out.println(cache.add(1,1.2));
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));      // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}

