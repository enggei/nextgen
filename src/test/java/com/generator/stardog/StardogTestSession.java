package com.generator.stardog;

import com.complexible.stardog.api.Connection;
import com.complexible.stardog.api.ConnectionConfiguration;
import com.complexible.stardog.api.SelectQuery;
import com.complexible.stardog.api.admin.AdminConnection;
import com.complexible.stardog.api.admin.AdminConnectionConfiguration;
import com.complexible.stardog.sesame.StardogRepository;
import io.vertx.core.Handler;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.RunTestOnContext;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.query.resultio.QueryResultIO;
import org.openrdf.query.resultio.TupleQueryResultFormat;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class StardogTestSession {

	private static final Logger log = LoggerFactory.getLogger(StardogTestSession.class);

	private static String server;
	private static String username;
	private static String password;
	private static String dbName;

	@BeforeClass
	public static void setup(TestContext context) {
		server = "http://127.0.0.1:5820";
		username = "admin";
		password = "admin";
		dbName = "testSesame";
	}

	@Rule
	public RunTestOnContext rule = new RunTestOnContext();

	class TestSession {

		private final TestContext context;
		final Async async;

		TestSession(TestContext context) {
			this.context = context;
			this.async = context.async();
		}

		void done() {
			async.complete();
			log.info("async complete");
		}

		private AdminConnection adminConnection() {
			return AdminConnectionConfiguration.toServer(server).credentials(username, password).connect();
		}

		private Connection dbConnection(final String dbName) {
			return ConnectionConfiguration.at(server + "/" + dbName);
		}

		private Repository dbRepository(final String dbName) {
			return new StardogRepository("http://" + username + ":" + password + "@127.0.0.1:5820/" + dbName);
		}

		void doTestAdminConnect(Handler<String> after) {
			StringBuilder output = new StringBuilder();

			try (AdminConnection dbms = adminConnection()) {
				output.append("Databases:");
				dbms.list().forEach(s -> output.append("\n* ").append(s));
			}

			after.handle(output.toString());
		}

		void doTestRepositoryConnection(final String sparql, Handler<String> after) throws IOException {
			StringBuilder output = new StringBuilder();

			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			Repository repository = dbRepository(dbName);
			repository.initialize();	// ALWAYS initialize a repository

			try (RepositoryConnection connection = repository.getConnection()) {
				output.append("Connection ").append(connection.toString()).append(":");

				TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL, sparql);

				output.append("\nQuery: ").append(sparql).append('\n');

				try (TupleQueryResult result = tupleQuery.evaluate()) {
					QueryResultIO.writeTuple(result, TupleQueryResultFormat.JSON, bos);
				}
			}
			finally {
				repository.shutDown();
			}

			output.append(bos.toString());

			after.handle(output.toString());
		}

		void doTestConnection(final String sparql, Handler<String> after) throws IOException {
			StringBuilder output = new StringBuilder();

			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			try(Connection connection = dbConnection(dbName)) {
				SelectQuery query = connection.select(sparql);

				output.append("\nQuery: ").append(sparql).append('\n');

				// Ensure to close the result
				try (TupleQueryResult result = query.execute()) {
					output.append("Graphs:");

					result.getBindingNames().forEach(s -> output.append("\n* ").append(s));
					QueryResultIO.writeTuple(result, TupleQueryResultFormat.JSON, bos);
				}
			}

			output.append(bos.toString());

			after.handle(output.toString());
		}
	}
}
