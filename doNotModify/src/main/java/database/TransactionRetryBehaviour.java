package database;

public enum TransactionRetryBehaviour {
    Retry, Rollback, Backoff
}
