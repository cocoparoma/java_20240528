package day20.socket5;

import java.net.ServerSocket;
import java.net.Socket;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

 class Servertest {
    int port =5000;

   
    ServerSocket server;
    public void server(){
        

        try{
            server = new ServerSocket(port);

            while(true){
                Socket client = server.accept();

            }
        }catch(Exception e){
            
        }
    }



}