package test;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;

public abstract class TransactionHandler {

    public static void doInTransaction(TransactionHandler transactionHandler) {
        try (Transaction tx = transactionHandler.beginTx()) {
            transactionHandler.execute(tx);
            tx.success();
        } catch (Throwable t) {
            t.printStackTrace();
            transactionHandler.handleException(t);
            return;
        }
        transactionHandler.onSuccess();
    }

    private final GraphDatabaseService db;

    public TransactionHandler(GraphDatabaseService db) {
        this.db = db;
    }

    public Transaction beginTx() {
        return db.beginTx();
    }

    public abstract void execute(org.neo4j.graphdb.Transaction tx);

    public void handleException(Throwable throwable) {
        throwable.printStackTrace();
    }

    public void onSuccess() {

    }
}
