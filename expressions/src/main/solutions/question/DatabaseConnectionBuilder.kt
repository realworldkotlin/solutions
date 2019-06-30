package question


import database.Credentials
import database.Database
import database.DatabaseConnection
import database.Port
import database.TransactionRetryBehaviour
import java.net.InetAddress
import java.net.UnknownHostException
import java.nio.charset.Charset

class DatabaseConnectionBuilder {
    @Throws(UnknownHostException::class)
    fun build(username: String, password: String, host: String, port: Int): DatabaseConnection = DatabaseConnection().apply {
        applyDatabaseTransactionRetryBehaviour(TransactionRetryBehaviour.Retry)
        databaseCredentials = Credentials(username).apply {
            charsetForDatabase = Charset.defaultCharset()
            passwordForDatabase = password
        }
        database = Database().apply {
            databaseInetAddress = InetAddress.getByName(host)
            databasePort = Port().apply {
                databasePortNumber = port
            }
        }
    }
}
