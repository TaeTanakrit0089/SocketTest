import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        try {
            Socket s = new Socket("127.0.0.1", 8080);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(text);
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}  