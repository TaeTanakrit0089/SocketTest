import java.io.*
import java.net.*
import java.util.Scanner

object MyClient {
  def main(args: Array[String]): Unit = 
    val scanner = new Scanner(System.in)
    val text = scanner.nextLine()
    try {
      val s = new Socket("127.0.0.1", 8080)
      val dout = new DataOutputStream(s.getOutputStream)
      dout.writeUTF(text)
      dout.flush()
      dout.close()
      s.close()
    } catch {
      case e: Exception => println(e)
    }
}
