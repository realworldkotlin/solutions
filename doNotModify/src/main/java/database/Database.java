package database;

import java.net.InetAddress;

public class Database {
    private InetAddress databaseInetAddress;
    private Port databasePort;

    public InetAddress getDatabaseInetAddress() {
        return databaseInetAddress;
    }

    public void setDatabaseInetAddress(InetAddress databaseInetAddress) {
        this.databaseInetAddress = databaseInetAddress;
    }

    public Port getDatabasePort() {
        return databasePort;
    }

    public void setDatabasePort(Port port) {
        this.databasePort = port;
    }

    boolean verify() {
        return databaseInetAddress != null && databasePort != null && databasePort.verify();
    }
}
