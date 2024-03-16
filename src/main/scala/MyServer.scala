import java.io.*
import java.net.*

object MyServer {
  def main(args: Array[String]): Unit =
    try {
      val ss = new ServerSocket(8080)
      var loop_stat = true
      println(">> Server is On!")
      while (loop_stat) {
        val s = ss.accept() // establishes connection
        val dis = new DataInputStream(s.getInputStream)
        val str = dis.readUTF()
        println("message= " + str)
        if (str == "end") {
          ss.close()
          println(">> Server is Off!")
          loop_stat = false
        }
      }
    } catch {
      case e: Exception => println(e)
    }
}

