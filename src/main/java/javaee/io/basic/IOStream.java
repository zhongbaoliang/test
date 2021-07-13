
package javaee.io.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
/*
* 1. 字节流操作的基本单元为字节；字符流操作的基本单元为Unicode码元。
* 2. 字节流默认不使用缓冲区；字符流使用缓冲区。
* 3. 字节流通常用于处理二进制数据，实际上它可以处理任意类型的数据，但它不支持直接写入或读取Unicode码元；字符流通常处理文本数据，它支持写入及读取Unicode码元。



/**
* 1. 传输内容不同。
*    字节流操作的基本单元为字节；字符流操作的基本单元为Unicode码元。
 *    字节流可传输任意类型数据，包括视频、图片、音频等；字符流只能传输文本。
* 2. 有无缓冲区。(BufferedInputStream,BufferedOutputStream,BufferedReader,BufferedWriter)
 *             (FileInputStream,    FileOutputStream,    FileReader,    FileWriter)
 *   字节流默认不使用缓冲区；字符流使用缓冲区。
* 3. 国际化用字符流，自动适应本地字符集。

 */
public class IOStream {
    public static void testFileWriter(){
        FileWriter fileWriter = null;
        try {
            try {
                fileWriter = new FileWriter("src/javaee/io/in.txt");

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
