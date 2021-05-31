package javaee.io.BNAio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.*;
//NIO 同步非阻塞
//线程自行进行IO操作
//面向缓冲区
//一个IO请求一个线程
//客户端发送连接请求都会到多路复用器selector上注册channel，
// 然后调用selector的select方法，一直阻塞到有IO请求
// 多路复用器轮询到 连有IO请求时，才启动一个线程进行处理.轮询复杂度为O(N)

//三大结构
//通道channel，仅用于连接，负责数据传输。铁路
//缓冲区buffer，负责数据存取；双向。除了boolean之外，其他基本数据类型都支持
//选择器selector

//适用于连接数量多但是连接比较短的架构
public class NIO {

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
    public static void server() throws IOException {
        // 1. serverSelector负责轮询是否有新的连接，服务端监测到新的连接之后，不再创建一个新的线程，
        // 而是直接将新连接绑定到clientSelector上，这样就不用 IO 模型中 1w 个 while 循环在死等
        Selector serverSelector = Selector.open();
        // 2. clientSelector负责轮询连接是否有数据可读
        Selector clientSelector = Selector.open();

        new Thread(() -> {
            try {
                // 对应IO编程中服务端启动
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.socket().bind(new InetSocketAddress(3333));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
                while (true) {
                    // 监测是否有新的连接，这里的1指的是阻塞的时间为 1ms
                    if (serverSelector.select(1) > 0) {
                        Set<SelectionKey> set = serverSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();
                        while (keyIterator.hasNext()) {
                            SelectionKey key = keyIterator.next();
                            if (key.isAcceptable()) {
                                try {
                                    // (1)
                                    // 每来一个新连接，不需要创建一个线程，而是直接注册到clientSelector
                                    SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                                    clientChannel.configureBlocking(false);
                                    clientChannel.register(clientSelector, SelectionKey.OP_READ);
                                } finally {
                                    keyIterator.remove();
                                }
                            }
                        }
                    }
                }
            } catch (IOException ignored) {
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    // (2) 批量轮询是否有哪些连接有数据可读，这里的1指的是阻塞的时间为 1ms
                    if (clientSelector.select(1) > 0) {
                        Set<SelectionKey> set = clientSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();
                        while (keyIterator.hasNext()) {
                            SelectionKey key = keyIterator.next();
                            if (key.isReadable()) {
                                try {
                                    SocketChannel clientChannel = (SocketChannel) key.channel();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    // (3) 面向 Buffer
                                    clientChannel.read(byteBuffer);
                                    byteBuffer.flip();
                                    System.out.println(
                                            Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
                                } finally {
                                    keyIterator.remove();
                                    key.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                }
            } catch (IOException ignored) {
            }
        }).start();
    }

    public static void server1(){
        int port=3333;
        ServerSocketChannel serverSocketChannel;
        Selector selector;
        try{
            serverSocketChannel=ServerSocketChannel.open();//创建channel
            InetSocketAddress address = new InetSocketAddress(port);
            serverSocketChannel.bind(address);//channel绑定端口
            serverSocketChannel.configureBlocking(false);
            selector=Selector.open();//创建selector
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);//将服务器绑定到selector

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while(true){
            try {
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

            Set<SelectionKey> readyKeys = selector.selectedKeys();//所有等待IO的客户端
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while(iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                try {
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        System.out.println("接受连接，来自 " + client);
                        client.configureBlocking(false);
                        SelectionKey clientKey = client.register(selector,SelectionKey.OP_WRITE|SelectionKey.OP_READ);
                        ByteBuffer buffer = ByteBuffer.allocate(100);
                        clientKey.attach(buffer);
                    }
                    if(key.isReadable()){
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        client.read(output);
                    }
                    if(key.isWritable()){
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        output.flip();
                        client.write(output);
                        output.compact();
                    }

                } catch (IOException e) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    e.printStackTrace();

                }
            }

        }

    }

    public static void main(String[] args) {
        server1();
        // TODO 创建多个线程，模拟多个客户端连接服务端
        for (int i = 0; i < 10; i++) {
            new Thread(() -> client()).start();
        }

    }

}
