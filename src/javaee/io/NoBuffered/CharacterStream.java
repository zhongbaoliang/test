package javaee.io.NoBuffered;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//reader，writer
//国际化用字符流，自动适应本地字符集
public class CharacterStream {
    public static void main(String[] args) throws IOException {
        FileReader fileReader=null;
        FileWriter fileWriter=null;
        try{
            fileReader=new FileReader("src/javaee/io/in.txt");
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
    }
}
