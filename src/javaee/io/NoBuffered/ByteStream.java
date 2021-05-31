package javaee.io.NoBuffered;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//字节流：input,output
public class ByteStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            fileInputStream=new FileInputStream("src/javaee/io/in.txt");
            fileOutputStream=new FileOutputStream("src/javaee/io/out.txt");
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
}
