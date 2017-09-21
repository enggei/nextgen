package com.generator.neo.remote;

import com.sun.istack.internal.NotNull;
import org.neo4j.graphdb.Lock;
import org.neo4j.graphdb.PropertyContainer;
import org.neo4j.graphdb.Transaction;

import java.util.concurrent.atomic.AtomicBoolean;

public class NeoTransaction implements Transaction {

	private final org.neo4j.driver.v1.Transaction tx;
	private final NeoTransactionContext context;

	private AtomicBoolean terminateCalled = new AtomicBoolean(false);

	NeoTransaction(@NotNull NeoDriver driver, @NotNull org.neo4j.driver.v1.Transaction tx) {
		this.tx = tx;
		this.context = new NeoTransactionContext(driver, new NeoTransactionData(tx));
	}

	@Override
	public void terminate() {
		System.out.println("tx terminate");
		terminateCalled.set(true);
	}

	@Override
	public void failure() {
		System.out.println("tx failure");
		tx.failure();
	}

	@Override
	public void success() {
		System.out.println("tx success");
		if (!terminateCalled.get()) tx.success();
	}

	@Override
	public void close() {
		System.out.println("tx close");
		tx.close();
	}

	@Override
	public Lock acquireWriteLock(PropertyContainer entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Lock acquireReadLock(PropertyContainer entity) {
		throw new UnsupportedOperationException();
	}

	public boolean isOpen() {
		return tx.isOpen();
	}

	org.neo4j.driver.v1.Transaction getTx() {
		return tx;
	}

	NeoTransactionContext getContext() {
		return context;
	}
}
