package javaee.io.BNAio;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Echo {
}
class EchoClient{
    @Test
    public static void main(String[] args) {


        String hostName="127.0.0.1";
        int portNumber=8080;
        try (
            Socket echoSocket=new Socket(hostName,portNumber);
            PrintWriter out =new PrintWriter(echoSocket.getOutputStream(),true);//autoFlush自动清空缓冲区并发送数据
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in))
        )
        {
            String userInput;
            while((userInput=stdIn.readLine())!=null){
                out.println(userInput);
                System.out.println("echo: "+in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class EchoServer{
    @Test
    public static void main(String[] args) {

        int portNumber=8080;

        try (
            ServerSocket serverSocket=new ServerSocket(portNumber);
            Socket clientSocket=serverSocket.accept();
            PrintWriter out =new PrintWriter(clientSocket.getOutputStream());
            BufferedReader in =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ){
            String inputLine;
            while ((inputLine=in.readLine())!=null){
                System.out.println(inputLine);
                out.println(inputLine);
                out.flush();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}