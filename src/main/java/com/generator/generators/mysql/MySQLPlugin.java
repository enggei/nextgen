package com.generator.generators.mysql;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.DomainMotif;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.mysql.parser.MySqlLexer;
import com.generator.generators.mysql.parser.MySqlParser;
import com.generator.generators.mysql.parser.MySqlParserNeoVisitor;
import com.generator.generators.spring.SpringGroup;
import com.generator.generators.stringtemplate.GeneratedFile;
import com.generator.neo.NeoModel;
import com.generator.util.MySQLUtil;
import com.generator.util.NeoUtil;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

import static com.generator.util.NeoUtil.*;

/**
 * Created 23.08.17.
 */
public class MySQLPlugin extends MySQLDomainPlugin {

   private final SpringGroup springGroup = new SpringGroup();
   private final Map<Node, MySQLSession> sessions = new LinkedHashMap<>();

   public MySQLPlugin(App app) {
      super(app);

      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
         for (MySQLSession mySQLSession : sessions.values()) {
            try {
               mySQLSession.close();
            } catch (SQLException e) {
               System.out.println("Could not close mysql-session: " + e.getMessage());
            }
         }
      }));
   }

   @Override
   protected void handleDatabase(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("New Query", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            final Node newNode = newQuery(getGraph(), name);
            relate(neoNode.getNode(), newNode, Relations.QUERY);
            fireNodesLoaded(newNode);
         }
      });

      final Set<Node> queryNodes = new LinkedHashSet<>();
      outgoing(neoNode.getNode(), Relations.QUERY).forEach(relationship -> queryNodes.add(other(neoNode.getNode(), relationship)));
      if (!queryNodes.isEmpty()) {
         pop.add(new App.TransactionAction("Create DAO for queries", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final SpringGroup.DAOST daost = springGroup.newDAO().
                     setPackage("com.ud.tr.dao").
                     setName("TestDAO").
                     setDatabase(DomainMotif.getName(neoNode.getNode())).
                     setHost(getString(neoNode.getNode(), Properties.host.name())).
                     setUsername(getString(neoNode.getNode(), Properties.username.name())).
                     setPort(3306);

               for (Node queryNode : queryNodes) {
                  daost.addQueriesValue(createDao(queryNode));
               }

               GeneratedFile.newJavaFile("/home/goe/udc/trailer-report/src/main/java", "com.ud.tr.dao", "TestDAO").write(daost);
            }
         });
      }
   }

   @Override
   protected void handleQuery(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("Create DaoAccessor", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final SpringGroup.queryMethodST queryMethodST = createDao(neoNode.getNode());
            System.out.println(queryMethodST);
         }
      });

      for (NeoNode selectedNode : selectedNodes) {
         if (hasLabel(selectedNode.getNode(), Entities.Table)) {
            final String tableName = getString(selectedNode.getNode(), AppMotif.Properties.name.name());
            pop.add(new App.TransactionAction("Add " + tableName, app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  relate(neoNode.getNode(), selectedNode.getNode(), Relations.QUERY_TABLE);
               }
            });
         }
      }

      pop.add(new App.TransactionAction("Edit", app) {

         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final List<QueryColumn> queryColumns = new ArrayList<>();
            final Map<String, QueryColumn> columnNodes = new LinkedHashMap<>();

            outgoing(neoNode.getNode(), Relations.QUERY_TABLE).forEach(tableRelation -> {
               final Node tableNode = other(neoNode.getNode(), tableRelation);
               outgoing(tableNode, Relations.COLUMN).forEach(columnRelation -> {
                  final QueryColumn queryColumn = new QueryColumn(tableNode, other(tableNode, columnRelation));
                  queryColumns.add(queryColumn);
                  columnNodes.put(DomainMotif.getName(tableNode) + "." + DomainMotif.getName(queryColumn.columnNode), queryColumn);
               });
            });

            outgoing(neoNode.getNode(), Relations.QUERY_COLUMN).forEach(relationship -> {
               final Node columnNode = other(neoNode.getNode(), relationship);
               final QueryColumn queryColumn = columnNodes.get(DomainMotif.getName(other(columnNode, singleIncoming(columnNode, Relations.COLUMN))) + "." + DomainMotif.getName(columnNode));
               queryColumn.selected = get(relationship, Properties.inSelect.name());
               queryColumn.where = get(relationship, Properties.inWhere.name());
               queryColumn.whereOperator = get(relationship, Properties.whereOperator.name(), "");
            });

            final SelectQueryColumnPanel editor = new SelectQueryColumnPanel(queryColumns);

            SwingUtil.showDialog(editor, app, "Columns", new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {

                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {

                        final List<QueryColumn> selectedColumns = editor.getSelectedColumns();

                        // select-columns
                        outgoing(neoNode.getNode(), Relations.QUERY_COLUMN).forEach(Relationship::delete);
                        for (QueryColumn selectedColumn : selectedColumns) {
                           relate(neoNode.getNode(), selectedColumn.columnNode, Relations.QUERY_COLUMN, Properties.inSelect.name(), selectedColumn.selected, Properties.inWhere.name(), selectedColumn.where, Properties.whereOperator.name(), selectedColumn.whereOperator == null ? "" : selectedColumn.whereOperator);
                        }
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showException(app, throwable);
                     }
                  });
               }
            });
         }
      });
   }

   private SpringGroup.queryMethodST createDao(Node queryNode) {
      final String name = DomainMotif.getName(queryNode);

      final SpringGroup.queryMethodST queryMethodST = springGroup.newqueryMethod().
            setEntity(name + "Result").
            setName("get" + name).
            setSql(getSql(queryNode));

      for (Node column : getSelectColumns(queryNode)) {
         final String columnName = DomainMotif.getName(column);
         final String columnType = getString(column, Properties.columnType.name(), "");
         queryMethodST.addColumnsValue(columnName, MySQLUtil.columnMapping(columnType));
      }

      for (Relationship queryColumn : getWhereColumns(queryNode)) {
         final Node column = queryColumn.getEndNode();
         final String columnName = DomainMotif.getName(column);
         final String columnType = getString(column, Properties.columnType.name(), "");
         queryMethodST.addParamsValue(columnName, MySQLUtil.columnMapping(columnType));
      }
      return queryMethodST;
   }

   @Override
   protected void handleTable(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("Show queries", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {


         }
      });

      pop.add(new App.TransactionAction("Make Spring accessor", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         }
      });
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      if (NeoUtil.hasLabel(neoNode.getNode(), "ColCreateTable")) {
         pop.add(new App.TransactionAction("As Pojo", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               NeoUtil.outgoing(neoNode.getNode(), RelationshipType.withName("child")).forEach(relationship -> {
                  final Node other = NeoUtil.other(neoNode.getNode(), relationship);

               });
            }
         });

      } else {
         super.handleNodeRightClick(pop, neoNode, selectedNodes);
      }
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.Database);

      menu.add(new App.TransactionAction("Parse sql", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final JTextArea txtSql = new JTextArea(20, 30);

            SwingUtil.showTextInput("Sql", txtSql, app, new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {
                  final String sql = txtSql.getText().trim();
                  if (sql.length() == 0) return;

                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx1) throws Throwable {
                        final MySqlParser parser = new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(MySQLSession.preprocessSQL(sql)))));
                        final MySqlParserNeoVisitor visitor = new MySqlParserNeoVisitor(getGraph());
                        visitor.visit(parser.sql_statements());
                        if (visitor.getRoot() != null) fireNodesLoaded(visitor.getRoot());
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showExceptionNoStack(app, throwable);
                     }
                  });
               }
            });
         }
      });

      menu.add(new App.TransactionAction("Get tables from Database", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final JTextField txtHost = new JTextField("127.0.0.1");
            final JTextField txtDatabase = new JTextField("tr");
            final JTextField txtUsername = new JTextField("root");
            final JPasswordField txtPassword = new JPasswordField("");

            SwingUtil.FormPanel login = new SwingUtil.FormPanel("pref, 4dlu, 75dlu:grow", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");
            login.addLabel("Host", 1, 1);
            login.add(txtHost, 3, 1);
            login.addLabel("Database", 1, 3);
            login.add(txtDatabase, 3, 3);
            login.addLabel("Username", 1, 5);
            login.add(txtUsername, 3, 5);
            login.addLabel("Password", 1, 7);
            login.add(txtPassword, 3, 7);

            SwingUtil.showDialog(login, app, "Database", new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {
                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx12) throws Throwable {

                        if (txtHost.getText().length() == 0) throw new IllegalArgumentException("host must be set");
                        if (txtDatabase.getText().length() == 0)
                           throw new IllegalArgumentException("database must be set");
                        if (txtUsername.getText().length() == 0)
                           throw new IllegalArgumentException("username must be set");
                        if (txtPassword.getPassword().length == 0)
                           throw new IllegalArgumentException("password must be set");

                        final MySQLSession db = new MySQLSession(txtHost.getText(), txtDatabase.getText(), txtUsername.getText(), txtPassword.getPassword());

                        final Node databaseNode = getGraph().findOrCreate(Entities.Database, AppMotif.Properties.name.name(), db.getDatabase(), Properties.host.name(), txtHost.getText(), Properties.username.name(), txtUsername.getText());

                        final DatabaseToDomain neoListener = new DatabaseToDomain(true, getGraph());
                        for (String table : db.getTables()) {
                           new ParseTreeWalker().walk(neoListener, new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table)))).root());
                           relate(databaseNode, neoListener.done(), Relations.TABLE);
                        }
                        neoListener.assignForeignKeys();

                        fireNodesLoaded(databaseNode);

                        db.close();
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showExceptionNoStack(app, throwable);
                     }
                  });
               }
            });
         }
      });
   }

   @Override
   protected JComponent newTableEditor(NeoNode neoNode) {
      return new TableEditor(neoNode);
   }

   @Override
   protected JComponent newQueryEditor(NeoNode neoNode) {
      return new QueryEditor(neoNode);
   }

   private final class TableEditor extends JPanel {
      TableEditor(NeoNode neoNode) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);
         txtEditor.setEditable(false);

         final StringBuilder out = new StringBuilder(getString(neoNode.getNode(), AppMotif.Properties.name.name()));

         outgoing(neoNode.getNode(), Relations.COLUMN).forEach(columnRelation -> {
            final Node columnNode = other(neoNode.getNode(), columnRelation);
            out.append("\n\t").append(getString(columnNode, AppMotif.Properties.name.name())).append(" ").append(getString(columnNode, Properties.columnType.name()));
         });
         txtEditor.setText(out.toString());

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }

   private final class QueryEditor extends JPanel {

      QueryEditor(NeoNode neoNode) {
         super(new BorderLayout());

         final Node dbNode = other(neoNode.getNode(), singleIncoming(neoNode.getNode(), Relations.QUERY));
         final Set<Relationship> whereColumns = getWhereColumns(neoNode.getNode());
         final JTable tblParams = new JTable(new ParamsTableModel(whereColumns));

         final JTextArea txtQuery = SwingUtil.newTextArea();
         txtQuery.setEditable(true);
         txtQuery.setWrapStyleWord(true);
         txtQuery.setLineWrap(true);
         txtQuery.setMaximumSize(new Dimension(100, 80));

         final JTextArea txtResult = SwingUtil.newTextArea();
         txtResult.setEditable(true);

         final JButton btnExecute = new JButton(new AbstractAction("Run") {
            @Override
            public void actionPerformed(ActionEvent e) {
               executeQuery(txtQuery, dbNode, ((ParamsTableModel) tblParams.getModel()), txtResult);
            }
         });

         txtQuery.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  executeQuery(txtQuery, dbNode, ((ParamsTableModel) tblParams.getModel()), txtResult);
               }
            }
         });

         txtQuery.setText(getSql(neoNode.getNode()));

         final SwingUtil.FormPanel queryPanel = new SwingUtil.FormPanel("10dlu:grow, 4dlu, 30dlu", "pref, 4dlu, 15dlu:grow, 4dlu, 15dlu:grow");
         queryPanel.add(new JScrollPane(txtQuery), 1, 1, 1, 3);
         queryPanel.add(btnExecute, 3, 1, 1, 1);
         queryPanel.add(new JScrollPane(tblParams), 1, 5, 1, 1);

         add(queryPanel.build(), BorderLayout.NORTH);
         add(new JScrollPane(txtResult), BorderLayout.CENTER);
      }

      void executeQuery(JTextArea txtEditor, Node dbNode, ParamsTableModel tableModel, JTextArea txtResult) {

         if (!sessions.containsKey(dbNode)) {

            final char[] password = SwingUtil.showPasswordDialog(txtEditor);
            if (password == null || password.length == 0) return;

            getGraph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  try {
                     sessions.put(dbNode, new MySQLSession(getString(dbNode, Properties.host.name()), DomainMotif.getName(dbNode), getString(dbNode, Properties.username.name()), new String(password)));
                  } catch (Throwable t) {
                     SwingUtil.showException(app, t);
                  }
               }

               @Override
               public void exception(Throwable throwable) {
                  SwingUtil.showException(txtEditor, throwable);
               }
            });
         }

         final MySQLSession session = sessions.get(dbNode);
         if (session != null) {
            try {

               final StringBuilder result = new StringBuilder();

               final AtomicBoolean first = new AtomicBoolean(true);
               session.executeQuery(txtEditor.getText().trim(), resultSet -> {

                  final ResultSetMetaData metaData = resultSet.getMetaData();
                  if (first.get()) {
                     for (int i = 1; i <= metaData.getColumnCount(); i++)
                        result.append(metaData.getColumnLabel(i)).append(" ");
                     first.set(false);
                  }

                  result.append("\n");
                  for (int i = 1; i <= metaData.getColumnCount(); i++) {
                     result.append(resultSet.getObject(i)).append(" ");
                  }
               }, tableModel.asParams());

               txtResult.setText(result.toString());
               txtResult.setCaretPosition(0);
            } catch (Exception e) {
               SwingUtil.showException(txtEditor, e);
            }
         }
      }

      private class ParamsTableModel extends AbstractTableModel {

         private final List<WhereParam> content = new ArrayList<>();

         ParamsTableModel(Set<Relationship> whereColumns) {
            for (Relationship whereColumn : whereColumns) {
               content.add(new WhereParam(whereColumn));
            }
         }

         @Override
         public int getRowCount() {
            return content.size();
         }

         @Override
         public int getColumnCount() {
            return 2;
         }

         @Override
         public Object getValueAt(int rowIndex, int columnIndex) {

            switch (columnIndex) {
               case 0:
                  return content.get(rowIndex).name;
               case 1:
                  return content.get(rowIndex).value;
            }

            return null;
         }

         @Override
         public String getColumnName(int column) {
            switch (column) {
               case 0:
                  return "Name";
               case 1:
                  return "Value";
            }
            return "";
         }

         @Override
         public Class<?> getColumnClass(int columnIndex) {
            return String.class;
         }

         @Override
         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 1;
         }

         @Override
         public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            final WhereParam whereParam = content.get(rowIndex);
            whereParam.value = aValue;

            getGraph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {

                  if ((aValue == null || aValue.toString().length() == 0)) {
                     if (whereParam.column.hasProperty(Properties.lastParam.name()))
                        whereParam.column.removeProperty(Properties.lastParam.name());
                  } else
                     whereParam.column.setProperty(Properties.lastParam.name(), aValue);
               }

               @Override
               public void exception(Throwable throwable) {
                  System.err.println("Could not save lastParam=" + aValue + " to param");
               }
            });
         }

         Object[] asParams() {
            final Object[] params = new Object[content.size()];
            for (int i = 0; i < content.size(); i++) {
               WhereParam whereParam = content.get(i);
               params[i] = whereParam.value == null || whereParam.value.toString().length() == 0 ? null : whereParam.value;
            }
            return params;
         }

         private class WhereParam {

            private final Relationship column;
            private String name;
            private Object value;

            WhereParam(Relationship whereColumn) {
               this.column = whereColumn;
               this.name = DomainMotif.getName(whereColumn.getEndNode());
               this.value = getString(whereColumn, Properties.lastParam.name(), "");
            }
         }
      }
   }

   @NotNull
   private static String getSql(Node queryNode) {

      final MysqlGroup mysqlGroup = new MysqlGroup();
      final MysqlGroup.selectST selectST = mysqlGroup.newselect();

      final Set<Node> tables = new LinkedHashSet<>();
      outgoing(queryNode, Relations.QUERY_COLUMN).forEach(queryColumnRelation -> {
         final Node columnNode = other(queryNode, queryColumnRelation);
         final Node tableNode = other(columnNode, singleIncoming(columnNode, Relations.COLUMN));

         if (!tables.contains(tableNode)) {
            tables.add(tableNode);
            selectST.addTablesValue(DomainMotif.getName(tableNode) + " " + StringUtil.lowFirst(DomainMotif.getName(tableNode)));
         }

         if (get(queryColumnRelation, Properties.inSelect.name())) {
            selectST.addColumnsValue(StringUtil.lowFirst(DomainMotif.getName(tableNode)) + "." + DomainMotif.getName(columnNode));
         }

         if (get(queryColumnRelation, Properties.inWhere.name())) {
            final String operator = getString(queryColumnRelation, Properties.whereOperator.name());
            selectST.addWhereValue("?", operator, StringUtil.lowFirst(DomainMotif.getName(tableNode)) + "." + DomainMotif.getName(columnNode));
         }
      });

      // todo auto-join tables through fk-columns
      if (tables.size() > 1) {
         final Map<Node, Node> fkColumns = new LinkedHashMap<>();
         for (Node table : tables) {
            outgoing(table, Relations.COLUMN).forEach(new Consumer<Relationship>() {
               @Override
               public void accept(Relationship relationship) {
                  final Node columnNode = other(table, relationship);

                  outgoing(columnNode, Relations.FK_SRC).forEach(new Consumer<Relationship>() {
                     @Override
                     public void accept(Relationship relationship) {
                        fkColumns.put(columnNode, other(columnNode, relationship));
                     }
                  });
               }
            });
         }

//         where.append(firstWhereColumn.get() ? "" : " AND ").append(StringUtil.lowFirst(DomainMotif.getName(tableNode))).append(".").append(DomainMotif.getName(columnNode)).append(operator).append("?");
      }

      return selectST.toString();
   }

   @NotNull
   private static Set<Node> getSelectColumns(Node queryNode) {
      final Set<Node> columns = new LinkedHashSet<>();
      outgoing(queryNode, Relations.QUERY_COLUMN).forEach(queryColumnRelation -> {
         if (!(Boolean) get(queryColumnRelation, Properties.inSelect.name())) return;
         columns.add(other(queryNode, queryColumnRelation));
      });
      return columns;
   }

   @NotNull
   private static Set<Relationship> getWhereColumns(Node queryNode) {
      final Set<Relationship> columns = new LinkedHashSet<>();
      outgoing(queryNode, Relations.QUERY_COLUMN).forEach(queryColumnRelation -> {
         if (!(Boolean) (get(queryColumnRelation, Properties.inWhere.name()))) return;
         columns.add(queryColumnRelation);
      });
      return columns;
   }

   class SelectQueryColumnPanel extends JPanel {

      private final JTable tblColumns;

      SelectQueryColumnPanel(List<QueryColumn> queryColumns) {
         super(new BorderLayout());

         tblColumns = new JTable(new ColumnTableModel(queryColumns));
         tblColumns.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(createOperatorComboBox()));
         add(new JScrollPane(tblColumns), BorderLayout.NORTH);
      }

      private JComboBox createOperatorComboBox() {
         final JComboBox<String> chk = new JComboBox<>();
         chk.addItem(null);
         chk.addItem("=");
         chk.addItem(">=");
         chk.addItem("<=");
         chk.addItem("<");
         chk.addItem(">");
         chk.addItem(" like ");
         chk.addItem(" in ");
         return chk;
      }

      List<QueryColumn> getSelectedColumns() {
         final List<QueryColumn> selected = new ArrayList<>();
         final ColumnTableModel model = (ColumnTableModel) tblColumns.getModel();
         for (QueryColumn columnEntry : model.content)
            if (columnEntry.selected || columnEntry.where) selected.add(columnEntry);
         return selected;
      }

      class ColumnTableModel extends AbstractTableModel {

         final List<QueryColumn> content = new java.util.ArrayList<>();

         ColumnTableModel(List<QueryColumn> queryColumns) {
            this.content.addAll(queryColumns);
         }

         @Override
         public int getRowCount() {
            return content.size();
         }

         @Override
         public int getColumnCount() {
            return 5;
         }

         @Override
         public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
               case 0:
                  return content.get(rowIndex).tableName;
               case 1:
                  return content.get(rowIndex).columnName;
               case 2:
                  return content.get(rowIndex).selected;
               case 3:
                  return content.get(rowIndex).where;
               case 4:
                  return content.get(rowIndex).whereOperator;
            }
            return null;
         }

         @Override
         public String getColumnName(int column) {
            switch (column) {
               case 0:
                  return "Table";
               case 1:
                  return "Column";
               case 2:
                  return "Select";
               case 3:
                  return "Where";
               case 4:
                  return "Where";
            }
            return "";
         }

         @Override
         public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
               case 0:
                  return String.class;
               case 1:
                  return String.class;
               case 2:
                  return Boolean.class;
               case 3:
                  return Boolean.class;
               case 4:
                  return String.class;
            }
            return Object.class;
         }

         @Override
         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 2 || columnIndex == 3 || columnIndex == 4;
         }

         @Override
         public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            switch (columnIndex) {
               case 2:
                  content.get(rowIndex).selected = Boolean.valueOf(aValue.toString());
                  fireTableCellUpdated(rowIndex, columnIndex);
                  break;
               case 3:
                  content.get(rowIndex).where = Boolean.valueOf(aValue.toString());
                  fireTableCellUpdated(rowIndex, columnIndex);
                  break;
               case 4:
                  content.get(rowIndex).whereOperator = aValue == null ? "" : aValue.toString();
                  fireTableCellUpdated(rowIndex, columnIndex);
                  break;
            }
         }
      }
   }

   private class QueryColumn {

      private final Node tableNode;
      private final Node columnNode;
      private final String columnName;
      private final String tableName;
      private boolean selected = false;
      private boolean where = false;
      private String whereOperator = null;

      QueryColumn(Node tableNode, Node columnNode) {
         this.tableNode = tableNode;
         this.columnNode = columnNode;
         this.tableName = DomainMotif.getName(tableNode);
         this.columnName = DomainMotif.getName(columnNode);
      }
   }
}