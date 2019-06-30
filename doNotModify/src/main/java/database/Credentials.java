package database;

import java.nio.charset.Charset;

public class Credentials {
    private String usernameForDatabase;
    private String passwordForDatabase;
    private Charset charsetForDatabase;

    public Credentials(String usernameForDatabase) {
        this.usernameForDatabase = usernameForDatabase;
    }

    public String getUsernameForDatabase() {
        return usernameForDatabase;
    }

    public String getPasswordForDatabase() {
        return passwordForDatabase;
    }

    public void setPasswordForDatabase(String password) {
        this.passwordForDatabase = password;
    }

    public Charset getCharsetForDatabase() {
        return charsetForDatabase;
    }

    public void setCharsetForDatabase(Charset charsetForDatabase) {
        this.charsetForDatabase = charsetForDatabase;
    }

    boolean verify() {
        if (usernameForDatabase == null || usernameForDatabase.isEmpty()) return false;
        if (passwordForDatabase == null || passwordForDatabase.isEmpty()) return false;
        return charsetForDatabase != null;
    }
}
