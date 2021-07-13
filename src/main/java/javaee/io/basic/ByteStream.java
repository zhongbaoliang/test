package javaee.io.basic;


import java.io.*;

//字节流：Stream结尾
//不手动使用缓冲区时，一次只写入一个字节，多少个字节循环多少次
/**
 * 使用缓冲区是操作如下：
 * 1. 获取文件的输入流、输出流
 * 2. 创建缓冲区
 * 3. 通过输入流将文件写入buffer，再通过输出流将buffer的内容发送给客户端
 * 4. 关闭流（通过try-resources自动关闭)
 *
 * */
public class ByteStream {
    public static void noBuffered() throws IOException {
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        try {//src/javaee/io/basic/ByteStream.java不能如此使用相对路径，maven项目是在target里面，要读取源文件必须通过
            fileInputStream=new FileInputStream("D:\\IDEA\\IDEAPro\\github\\test\\src\\main\\java\\javaee\\io\\basic\\ByteStream.java");
            fileOutputStream=new FileOutputStream("D:\\IDEA\\IDEAPro\\github\\test\\src\\main\\java\\javaee\\io\\out.txt");
            int c;
            while((c=fileInputStream.read())!=-1){
                fileOutputStream.write(c);
            }
            byte[] bs={66,121,116,101};
            fileOutputStream.write(bs);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fileInputStream!=null)
                fileInputStream.close();
            if(fileOutputStream!=null)
                fileOutputStream.close();
        }
    }

    public static void buffered(){

        //try-with-resources
        /**
         * try(){}
         * catch{}
         * finally{}
         *
         * */

        try(FileInputStream fileInputStream=new FileInputStream("D:\\IDEA\\IDEAPro\\github\\test\\src\\main\\java\\javaee\\io\\basic\\ByteStream.java");
            FileOutputStream fileOutputStream=new FileOutputStream("D:\\IDEA\\IDEAPro\\github\\test\\src\\main\\java\\javaee\\io\\out.txt");) {
            int len=0;
            byte[] buffer=new byte[1024];
            while((len=fileInputStream.read(buffer))!=-1){
                fileOutputStream.write(buffer,0,len);
            }
            byte[] bs={66,121,116,101};
            fileOutputStream.write(bs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buffered1(){
        try(FileInputStream fileInputStream=new FileInputStream("D:\\IDEA\\IDEAPro\\github\\test\\src\\main\\java\\javaee\\io\\basic\\ByteStream.java");
            FileOutputStream fileOutputStream=new FileOutputStream("D:\\IDEA\\IDEAPro\\github\\test\\src\\main\\java\\javaee\\io\\out.txt");
            BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            ) {
            int len=0;
            while((len=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(len);
            }
            byte[] bs={66,121,116,101};
            bufferedOutputStream.write(bs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        long l = System.currentTimeMillis();
        noBuffered();
        System.out.println("noBuffered time " + (System.currentTimeMillis()-l) + " ms");
        l = System.currentTimeMillis();
        buffered();
        System.out.println("buffered time " + (System.currentTimeMillis()-l) + " ms");

        l = System.currentTimeMillis();
        buffered1();
        System.out.println("buffered1 time " + (System.currentTimeMillis()-l) + " ms");
    }
}