package javaee.io;
//内码：运行时char或者string在内存中的编码方式
//外码：除了内码都是外码
//内码采用UTF-16——决定了char占两个字节
//外码采用UTF-8
//UTF-16与UTF-8是unicode的不同实现形式



//字符流与字节流
//字节数据 图片音频，视频
//字节流传输的是二进制数据流
// 字节流 InputStream,OutputStream

//字符数据 文本
//字符流传输的是字符char
//字符流 Reader,Writer

//阻塞与非阻塞：是否立即有返回值
//阻塞 IO操作完成才返回
//非阻塞 IO操作被调用立即返回一个状态



//同步和异步：是否并行执行
//同步 进程等待或者轮询IO完成后才能继续执行
//异步 IO的同时时进程并行执行

//UNIX IO演进
//主动请求
//1. 阻塞IO模型
// 进程阻塞于recvfrom
// 1.1 多线程。一个线程处理一个连接
// 1.2 线程池。
//问题 线程创建切换开销，造成资源匮乏
//解决   需要IO时才创建线程，线程自行IO并处理数据
//      系统进行IO并返回，然后创建线程进行处理

//2.非阻塞IO模型
// 轮询查看那些连接需要IO。
//  进程轮询进行N次系统调用recvfrom，数据未就绪时recvfrom返回错误码EWOULDBLOCK状态

//3. IO多路复用
//select和poll系统调用，阻塞于二者之一
//select传所有连接到内核，内核访问所有连接是否需要IO。
// selector多路复用器查看那些连接需要IO。O(K+1)
//   1次系统调用select，系统调用时遍历N个连接，进程阻塞于select
//   k个线程执行k次recvfrom
//问题  select传递内容过多，内核主动遍历N次
//解决  内核开辟空间存储连接信息——epoll：epoll_create开辟内核空间,epoll_ctl添加修改删除文件描述符
//     不主动遍历


//被动响应
//4. 信号驱动。还是自己进行读取
// 进程进行系统调用sigaction，数据未就绪时进程继续执行
// 数据就绪之后系统向进程递交SIGIO
// 进程进行系统调用recvfrom复制数据

//5. 异步IO模型。系统读取完了返回数据
// 进程调用系统调用aio_read，数据未就绪时返回状态
// 进程继续运行，数据就绪并且系统已经将数据复制
// 系统向进程递交aio_read指定的数据
//就是IO请求交给内核处理，内核负责IO处理。内核与进程并行执行，等IO完了内核向进程提交数据

//JAVA IO模型
//BIO 同步阻塞.阻塞于recvfrom，同上述1
//NIO 一个线程或者cpu个数个线程 处理一个IO请求，同上述3
//AIO 又称NIO.2，同上述5


import sun.net.www.http.HttpClient;

//一个线程处理一个有效IO请求，
public class IO {
    public static void test(int arr[]){
        arr[arr.length-1]=-1;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        test(arr);
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);

    }
}
