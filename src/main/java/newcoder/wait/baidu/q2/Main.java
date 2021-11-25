package newcoder.wait.baidu.q2;

import java.util.Scanner;

class Node{
    int id;
    Node next;
    public Node(int v){
        id = v;
    }
}
public class Main {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),q = scanner.nextInt();
        int arr[] = new int[q];
        for (int i = 0; i < q; i++) {
            arr[i] = scanner.nextInt();
        }
        Node pre = new Node(0),ptr = pre;
        for (int i = 1; i < n+1; i++) {
            ptr.next = new Node(i);
            ptr = ptr.next;
        }

        for (int i = 0; i < q; i++) {
            int ansi = 0;
            ptr = pre;
            while (ptr.next!=null&&ptr.next.id == -1) {
                ptr = ptr.next;
                ansi++;
            }
            ptr.next = ptr.next.next;
            ptr = pre;
            for(int j=0;j<arr[i];j++){
                while (ptr.next!=null&&ptr.next.id == -1) {
                    ptr.next = ptr.next.next;
                    //ptr = ptr.next;
                    ansi++;
                }
                ptr = ptr.next;
                ansi++;
            }
            System.out.println(ansi+" ");
            if(ptr.next!=null){
                Node nxt = ptr.next;
                ptr.next = new Node(-1);
                ptr.next.next = nxt;
            }

        }

    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),q = scanner.nextInt();
        int arr[] = new int[q];
        for (int i = 0; i < q; i++) {
            arr[i] = scanner.nextInt();
        }
        int queue[] = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            queue[i] = i;
        }
        for (int i = 0; i < q; i++) {

            int idx = 1,idx0 = 1;
            while(queue[idx]==-1){
                idx++;
            }
            int ansi = 0;
            if(idx<=n) {
                ansi = idx-1;
                queue[idx] = -1;
                idx++;
                for (int j = 0; j < arr[i]; j++) {
                    while (idx < n + 1 && queue[idx] == -1) {
                        idx++;
                    }
                    if (idx > n) break;
                    queue[idx0] = queue[idx];
                    ansi += idx - idx0;
                    queue[idx] = -1;
                    idx++;
                    idx0++;
                }
            }
            System.out.println(ansi+" ");
        }
    }
}
