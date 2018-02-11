package com.generator.generators.mysql;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

import static com.generator.util.MySQLUtil.preprocessSQL;

/**
 * Created 23.08.17.
 */
public class MySQLSession {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MySQLSession.class);

   private final Connection connection;
   private final String database;

   MySQLSession(String host, String database, String username, String password) throws ClassNotFoundException, SQLException {
      Class.forName("com.mysql.jdbc.Driver");
      this.database = database;
      connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database + "?useSSL=false&zeroDateTimeBehavior=convertToNull&useLegacyDatetimeCode=false&serverTimezone=UTC&user=" + username + "&password=" + password + "&autoReconnect=true");
   }

   MySQLSession(String host, String database, String username, char[] password) {
      try {
         Class.forName("com.mysql.jdbc.Driver");
         this.database = database;
         connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database + "?useSSL=false&zeroDateTimeBehavior=convertToNull&useLegacyDatetimeCode=false&serverTimezone=UTC&user=" + username + "&password=" + new String(password) + "&autoReconnect=true");
      } catch (Throwable e) {
         throw new RuntimeException(e);
      }
   }

   public String getDatabase() {
      return database;
   }

   public void executeQuery(Statement statement, String query, ResultSetHandler handler) throws Exception {
      final ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next())
         handler.handle(resultSet);
      resultSet.close();
   }

   public void executeQuery(String query, ResultSetHandler handler) {
      try {
         final Statement statement = connection.createStatement();
         final ResultSet resultSet = statement.executeQuery(query);
         while (resultSet.next())
            handler.handle(resultSet);
         resultSet.close();
         statement.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void executeQuery(String query, ResultSetHandler handler, Object... params) throws Exception {
      final PreparedStatement statement = connection.prepareStatement(query);
      for (int i = 0; i < params.length; i++)
         statement.setObject(i + 1, params[i]);
      final ResultSet resultSet = statement.executeQuery();
      while (resultSet.next())
         handler.handle(resultSet);
      resultSet.close();
      statement.close();
   }

   public void close() {
      if (connection != null) try {
         connection.close();
      } catch (SQLException e) {
         log.error("close database connection error " + e.getMessage(), e);
      }
   }

   public Set<String> getTables() throws Exception {
      final Set<String> tables = new TreeSet<>();
      final Statement statement = connection.createStatement();
      executeQuery(statement, "show tables", resultSet -> {
         final String tablename = resultSet.getString(1);
         try (PreparedStatement createTableStatement = connection.prepareStatement("show create table " + tablename)) {
            try (ResultSet createTableResultSet = createTableStatement.executeQuery()) {
               if (createTableResultSet.next()) {
                  tables.add(preprocessSQL(createTableResultSet.getString(2)));
               }
            }
         }
      });
      statement.close();
      return tables;
   }

   public Statement createStatement() {
      try {
         return connection.createStatement();
      } catch (SQLException e) {
         log.error("create statement error: " + e.getMessage(), e);
         return null;
      }
   }

   public interface ResultSetHandler {

      void handle(ResultSet resultSet) throws Exception;
   }
}