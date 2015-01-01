import java.io.*;
import java.net.*;

public class EchoServer{
    public void go(){
        try{
            ServerSocket serverSock = new ServerSocket(4561);
            while (true){
                Socket sock = serverSock.accept();
                System.out.println("a new connect");
                InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String message;
                try{
                	if ((message = reader.readLine()) != null){
                		System.out.println("read " + message);
                		writer.println(message);
                		writer.flush();
                	}
                }catch (Exception exx){
                	exx.printStackTrace();
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        EchoServer echo = new EchoServer();
        echo.go();
    }
}
