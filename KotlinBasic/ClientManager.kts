import java.io.File
import java.util.*

data class Client(val id: String, val name: String, val tel: String, val point: Int)

class ClientManager {
    val client = mutableMapOf<String, Client>()

    init {
        println("Initialize ClientManager")
        val scan = Scanner(File("client.txt"))
        while (scan.hasNext()) {
            val str = scan.nextLine()
            val line = str.split(" ")
            client[line[0]] = Client(line[0], line[1], line[2], line[3].toInt())
        }
    }

    fun findClient(id: String) = client[id]
    fun getPoint(c: Client) = c.point
}

val clientManger = ClientManager()
val client = clientManger.findClient("gdlee")
if (client != null)
    println(clientManger.getPoint(client!!))
else
    println("아이디 확인 요망")
