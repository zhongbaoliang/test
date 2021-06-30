package javaee.io.BNAio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.*;
//BIO同步阻塞
//面向流
// 服务器为每一个客户端连接启动一个线程，读写必须阻塞在一个线程，一直到操作完成。
//无缓冲区，单向流
//

//适用于小型且固定的网络架构
public class BIO {

    public static void client(){
        try {
            Socket socket = new Socket("127.0.0.1", 3333);
            try {
                socket.getOutputStream().write((Thread.currentThread().getName()+ " : hello world "+new Date() ).getBytes());
                Thread.sleep(2000);
            }
            catch (Exception e) {
                System.out.println(Thread.currentThread().getName()+" failed");
            }
            socket.close();
        }
        catch (IOException e) {
            System.out.println(Thread.currentThread().getName()+" failed");
        }
    }

    //多线程
    public static void server(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(3333);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ServerSocket finalServerSocket = serverSocket;
        // 接收到客户端连接请求之后为每个客户端创建一个新的线程进行链路处理
        new Thread(() -> {//服务器线程
            while (true) {
                try {
                    // 阻塞方法获取新的连接
                    Socket socket = finalServerSocket.accept();
                    // 每一个新的连接都创建一个线程，负责读取数据
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            // 按字节流方式读取数据
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (IOException e) {
                        }
                    }).start();
                } catch (IOException e) {
                }
            }
        }).start();
    }

    //线程池
    public static void server1(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(3333);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ServerSocket finalServerSocket = serverSocket;
        // 接收到客户端连接请求之后为每个客户端创建一个新的线程进行链路处理
        new Thread(() -> {//服务器线程
            ExecutorService executorService= Executors.newFixedThreadPool(5);
            while (true) {
                try {
                    //BlockingQueue<Future<Boolean>> futureBlockingQueue=null;

                    // 阻塞方法获取新的连接
                    Socket clientSocket = finalServerSocket.accept();
                    // 每一个新的连接都创建一个线程，负责读取数据
                    executorService.submit(new Thread(()->{
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = clientSocket.getInputStream();
                            // 按字节流方式读取数据
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public static void main(String[] args) {
        server1();
        // TODO 创建多个线程，模拟多个客户端连接服务端
        for (int i = 0; i < 10; i++) {
            new Thread(() -> client()).start();
        }
    }
}
