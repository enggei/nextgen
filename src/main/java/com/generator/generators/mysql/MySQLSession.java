package com.generator.generators.mysql;

import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created 23.08.17.
 */
public class MySQLSession {

   private final Connection connection;
   private final String database;

   MySQLSession(String host, String database, String username, String password) throws ClassNotFoundException, SQLException {
      Class.forName("com.mysql.jdbc.Driver");
      this.database = database;
      connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database + "?useSSL=false&zeroDateTimeBehavior=convertToNull&useLegacyDatetimeCode=false&serverTimezone=UTC&user=" + username + "&password=" + password);
   }

   MySQLSession(String host, String database, String username, char[] password) throws ClassNotFoundException, SQLException {
      Class.forName("com.mysql.jdbc.Driver");
      this.database = database;
      connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database + "?useSSL=false&zeroDateTimeBehavior=convertToNull&useLegacyDatetimeCode=false&serverTimezone=UTC&user=" + username + "&password=" + new String(password));
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

   public void executeQuery(String query, ResultSetHandler handler) throws Exception {
      final Statement statement = connection.createStatement();
      final ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next())
         handler.handle(resultSet);
      resultSet.close();
      statement.close();
   }

   public void close() throws SQLException {
      if (connection != null) connection.close();
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

   /**
    * turns everything but `[name]` to upper case (antlr is case sensitive)
    *
    * @param string the sql to process
    * @return sql in upper-case
    */
   static String preprocessSQL(String string) {
      if (string == null || string.trim().length() == 0) return "";

      boolean name = false;
      final StringBuilder output = new StringBuilder();
      final char[] chars = string.toCharArray();
      for (char aChar : chars) {
         char c = name ? aChar : Character.toUpperCase(aChar);
         if (c == '`') name = !name;
         output.append(c);
      }
      return output.toString().trim();
   }



   public interface ResultSetHandler {

      void handle(ResultSet resultSet) throws Exception;
   }
}