<<<<<<< HEAD
package javaee.io.NoBuffered;
=======
package javaee.io.basic;
>>>>>>> origin/master

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
<<<<<<< HEAD

=======
//字符流
>>>>>>> origin/master
//reader，writer
//国际化用字符流，自动适应本地字符集
public class CharacterStream {
    public static void main(String[] args) throws IOException {
<<<<<<< HEAD
        FileReader fileReader=null;
        FileWriter fileWriter=null;
        try{
            fileReader=new FileReader("src/javaee/io/in.txt");
=======
        long l = System.currentTimeMillis();
        FileReader fileReader=null;
        FileWriter fileWriter=null;
        try{
            fileReader=new FileReader("src/javaee/io/basic/ByteStream.java");
>>>>>>> origin/master
            fileWriter=new FileWriter("src/javaee/io/out.txt");
            int c;
            while((c=fileReader.read())!=-1){
                fileWriter.write(c);
            }
            fileWriter.write("Character");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fileReader!=null)
                fileReader.close();
            if(fileWriter!=null)
                fileWriter.close();
        }
<<<<<<< HEAD
    }
=======
        System.out.println("字符流 " + (System.currentTimeMillis()-l)+"ms");
    }

>>>>>>> origin/master
}
