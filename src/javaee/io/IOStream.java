package javaee.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/*
* 1. 字节流操作的基本单元为字节；字符流操作的基本单元为Unicode码元。
* 2. 字节流默认不使用缓冲区；字符流使用缓冲区。
* 3. 字节流通常用于处理二进制数据，实际上它可以处理任意类型的数据，但它不支持直接写入或读取Unicode码元；字符流通常处理文本数据，它支持写入及读取Unicode码元。
 */
public class IOStream {
    public static void testFileWriter(){
        FileWriter fileWriter = null;
        try {
            try {
                fileWriter = new FileWriter("src/javaee/io/demo.txt");

                fileWriter.write("demo");
            } finally {
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testOutputStream(){
        OutputStreamWriter outputStreamWriter=null;
        try {
            try {
                //outputStreamWriter = new OutputStreamWriter("src/javaee/io/outputStreamWriter.txt");
                //outputStreamWriter.write("outputStream");
            } finally {
                outputStreamWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}
