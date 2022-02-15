package leetcode.editor.cn.leetcode.lc0146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class Node {
        int key,value;
        Node pre,next;
        public Node(int k,int v){
            key = k;
            value = v;
            pre = next = null;
        }
    }

    Node head,tail;//双向链表，为了中间节点删除复杂度为O(1)
    Map<Integer,Node> map;
    int capacity;


    private void del(Node ptr){
        if(ptr.pre!=null){
            ptr.pre.next = ptr.next;
        }
        if(ptr.next!=null){
            ptr.next.pre = ptr.pre;
        }
    }


    private void addTail(Node ptr){
        ptr.pre = tail;
        ptr.next = null;
        //if(tail.next!=null)tail.next.pre = ptr;
        tail.next = ptr;
        tail = ptr;
    }

    public LRUCache(int capacity) {
        tail = head = new Node(-1,-1);
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node ptr = map.get(key);
        if(ptr!=null){
            del(ptr);
            addTail(ptr);
            return ptr.value;
        }
        return -1;

    }

    public void put(int key, int value) {
        Node ptr = map.get(key);
        if(ptr==null){
            if(map.size()==capacity){
                map.remove(head.next.key);
                head.next = head.next.next;
                if(head.next!=null){
                    head.next.next = head.next;
                }
            }
            ptr = new Node(key,value);
            map.put(key,ptr);
        }
        else{
            ptr.value = value;
            del(ptr);
        }
        addTail(ptr);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */