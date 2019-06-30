package database;

public class Port {
    private Integer databasePortNumber;

    public Integer getDatabasePortNumber() {
        return databasePortNumber;
    }

    public void setDatabasePortNumber(Integer databasePortNumber) {
        this.databasePortNumber = databasePortNumber;
    }

    boolean verify() {
        return databasePortNumber != null;
    }
}