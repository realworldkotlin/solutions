import database.Credentials
import database.Database
import database.DatabaseConnection
import database.Port
import database.TransactionRetryBehaviour
import java.net.InetAddress
import java.nio.charset.Charset

class DatabaseConnectionBuilder {
    var port = -1
    lateinit var host: String
    lateinit var username: String
    lateinit var password: String
}

fun connection(fn: DatabaseConnectionBuilder.() -> Unit) = DatabaseConnectionBuilder().apply(fn).run {
    DatabaseConnection().apply {
        databaseCredentials = Credentials(username).apply {
            passwordForDatabase = password
            charsetForDatabase = Charset.defaultCharset()
        }
        database = Database().apply {
            databaseInetAddress = InetAddress.getByName(host)
            databasePort = Port().apply {
                databasePortNumber = port
            }
        }
    }
}