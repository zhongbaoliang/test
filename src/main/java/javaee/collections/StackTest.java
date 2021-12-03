package javaee.collections;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.peek();
        Integer pop = stack.pop();

        Deque<Integer> stack1 = new ArrayDeque<>();



    }
}
