package database;

public class DatabaseConnection {
    private Database database;
    private Credentials databaseCredentials;
    private TransactionRetryBehaviour databaseTransactionRetryBehaviour;

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Credentials getDatabaseCredentials() {
        return databaseCredentials;
    }

    public void setDatabaseCredentials(Credentials databaseCredentials) {
        this.databaseCredentials = databaseCredentials;
    }

    public TransactionRetryBehaviour getDatabaseTransactionRetryBehaviour() {
        return databaseTransactionRetryBehaviour;
    }

    public void applyDatabaseTransactionRetryBehaviour(TransactionRetryBehaviour databaseTransactionRetryBehaviour) {
        this.databaseTransactionRetryBehaviour = databaseTransactionRetryBehaviour;
    }

    public Boolean connect() {
        if (database == null || !database.verify()) return false;
        if (databaseCredentials == null || !databaseCredentials.verify()) return false;
        return true;
    }
}
