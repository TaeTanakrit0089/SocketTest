import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8080);
            System.out.println(">> Server is On!");
            while (true) {
                Socket s = ss.accept();//establishes connection
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                System.out.println("message= " + str);
                if (str.equals("end")) {
                    ss.close();
                    System.out.println(">> Server is Off!");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}  