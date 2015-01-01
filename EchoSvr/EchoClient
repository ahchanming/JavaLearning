import java.io.*;
import java.net.*;
import java.util.*;

public class EchoClient{
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;
	String  str;
    public void go(){
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        str = cin.nextLine();
        setUpNetworking();
        work();
    }
    private void setUpNetworking(){
    	try{
    		sock = new Socket("127.0.0.1",  4561);
    		InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
    		reader = new BufferedReader(streamReader);
    		writer = new PrintWriter(sock.getOutputStream());
    	}catch(IOException ex){
    		ex.printStackTrace();
    	}
    }
    private void work(){
    	writer.println(str);
    	System.out.println("Input String is:" + str);
    	writer.flush();
    	String message;
    	while (true){
    		try{
	    		if ((message = reader.readLine()) != null){
	    			System.out.append("Read " + message);
	    			break;
	    		}
    		}catch(Exception ex){
    			ex.printStackTrace();
    		}
    	}
    }
    public static void main(String[] args){
        EchoClient client= new EchoClient();
        client.go();
    }
}
