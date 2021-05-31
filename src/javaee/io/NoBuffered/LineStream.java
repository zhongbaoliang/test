package javaee.io.NoBuffered;

import java.io.*;

//BufferedReader,PrintWriter
public class LineStream {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=null;
        PrintWriter printWriter=null;

        try {
            bufferedReader=new BufferedReader(new FileReader("src/javaee/io/in.txt"));
            printWriter=new PrintWriter(new FileWriter("src/javaee/io/out.txt"));
            String line;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
                printWriter.println(line);
            }
            printWriter.println("Line");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(bufferedReader!=null)
                bufferedReader.close();
            if(printWriter!=null)
                printWriter.close();
        }

    }
}
