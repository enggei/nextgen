package com.generator.neo.remote;

import com.sun.istack.internal.NotNull;

public class NeoTransactionContext {

	private final NeoDriver driver;

	private final NeoTransactionData transactionData;

	NeoTransactionContext(@NotNull NeoDriver driver, @NotNull NeoTransactionData transactionData) {
		this.driver = driver;
		this.transactionData = transactionData;
	}

	NeoDriver driver() {
		return driver;
	}

	NeoTransactionData txData() {
		return transactionData;
	}
}
