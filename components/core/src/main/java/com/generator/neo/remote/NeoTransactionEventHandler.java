package com.generator.neo.remote;

import org.neo4j.graphdb.event.TransactionData;
import org.neo4j.graphdb.event.TransactionEventHandler;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

class NeoTransactionEventHandler {

	// Inspiration from org.neo4j.kernel.internal.TransactionEventHandlers

	private final Collection<TransactionEventHandler<Object>> transactionEventHandlers = new CopyOnWriteArrayList<>();
	private final Map<TransactionEventHandler<Object>, Object> transactionEventHandlerStates = new HashMap<>();

	TransactionEventHandler<Object> registerTransactionEventHandler(TransactionEventHandler<Object> handler) {
		this.transactionEventHandlers.add(handler);
		return handler;
	}

	TransactionEventHandler<Object> unregisterTransactionEventHandler(TransactionEventHandler<Object> handler) {
		if (!transactionEventHandlers.remove(handler))
			throw new IllegalStateException(handler + " isn't registered");

		if (transactionEventHandlerStates.containsKey(handler))
			transactionEventHandlerStates.remove(handler);

		return handler;
	}

	void fireBeforeCommit(TransactionData data) throws Exception {
		fireBeforeTransactionCommit(transactionEventHandlers, transactionEventHandlerStates, data);
	}

	void fireAfterCommit(TransactionData data) {
		fireAfterTransactionCommit(transactionEventHandlers, transactionEventHandlerStates, data);
	}

	void fireAfterRollback(TransactionData data) {
		fireAfterTransactionRollback(transactionEventHandlers, transactionEventHandlerStates, data);
	}

	private static void fireBeforeTransactionCommit(final Collection<TransactionEventHandler<Object>> handlers, final Map<TransactionEventHandler<Object>, Object> states, TransactionData data) throws Exception {
		for (TransactionEventHandler<Object> handler : handlers)
			states.put(handler, handler.beforeCommit(data));
	}

	private static void fireAfterTransactionCommit(final Collection<TransactionEventHandler<Object>> handlers, final Map<TransactionEventHandler<Object>, Object> states, TransactionData data) {
		for (TransactionEventHandler<Object> handler : handlers)
			handler.afterCommit(data, states.get(handler));
	}

	private static void fireAfterTransactionRollback(final Collection<TransactionEventHandler<Object>> handlers, final Map<TransactionEventHandler<Object>, Object> states, TransactionData data) {
		for (TransactionEventHandler<Object> handler : handlers)
			handler.afterRollback(data, states.get(handler));
	}
}
