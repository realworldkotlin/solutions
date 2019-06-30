import database.*;
import org.junit.Test;

import java.net.InetAddress;
import java.nio.charset.Charset;

import static org.junit.Assert.assertTrue;

public class JavaConnectionDslTest {

    @Test
    public void can_configure_a_database_connection_and_connect() throws Exception {
        Credentials credentials = new Credentials("username");
        credentials.setCharsetForDatabase(Charset.defaultCharset());
        credentials.setPasswordForDatabase("password");

        Port port = new Port();
        port.setDatabasePortNumber(123);

        Database database = new Database();
        database.setDatabaseInetAddress(InetAddress.getByName("localhost"));
        database.setDatabasePort(port);

        DatabaseConnection connection = new DatabaseConnection();
        connection.setDatabaseCredentials(credentials);
        connection.setDatabase(database);

        assertTrue(connection.connect());
    }
}
