package com.generator.generators.mysql;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.mysql.parser.MySqlLexer;
import com.generator.generators.mysql.parser.MySqlParser;
import com.generator.generators.mysql.parser.MySqlParserNeoVisitor;
import com.generator.generators.mysql.parser.MySqlParserNodeListener;
import com.generator.generators.spring.SpringGroup;
import com.generator.generators.stringtemplate.GeneratedFile;
import com.generator.neo.NeoModel;
import com.generator.util.MySQLUtil;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.PropertyContainer;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.generator.util.NeoUtil.*;

/**
 * Created 23.08.17.
 * https://dev.mysql.com/doc/refman/5.7/en/functions.html
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

            final Node newNode = newQuery(name);
            relateQUERY(neoNode.getNode(), newNode);
            fireNodesLoaded(newNode);
         }
      });

      pop.add(new App.TransactionAction("Import SQL query", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String sql = SwingUtil.showInputDialog("sql", app);
            if (name == null || name.length() == 0) return;

            new ParseTreeWalker().walk(new MySqlParserNodeListener(true) {

            }, new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(sql)))).root());


            final Node newNode = newQuery(name);
            relateQUERY(neoNode.getNode(), newNode);
            fireNodesLoaded(newNode);
         }
      });

      final Set<Node> queryNodes = new LinkedHashSet<>();
      outgoingQUERY(neoNode.getNode(), (relationship, queryNode) -> queryNodes.add(queryNode));

      if (!queryNodes.isEmpty()) {
         pop.add(new App.TransactionAction("Create DAO for queries", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final SpringGroup.DAOST daost = springGroup.newDAO().
                     setPackage("com.ud.tr.dao").
                     setName("TestDAO").
                     setDatabase(getNameProperty(neoNode.getNode())).
                     setHost(getHostProperty(neoNode.getNode())).
                     setUsername(getUsernameProperty(neoNode.getNode())).
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
         if (isTable(selectedNode.getNode())) {
            final String tableName = getNameProperty(selectedNode.getNode());
            pop.add(new App.TransactionAction("Add " + tableName, app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  relateQUERY_TABLE(neoNode.getNode(), selectedNode.getNode());
               }
            });
         }
      }

      pop.add(new App.TransactionAction("Edit", app) {

         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final SelectQueryColumnPanel editor = new SelectQueryColumnPanel(neoNode.getNode());

            SwingUtil.showDialog(editor, app, "Columns", new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {

                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {

                        final List<QueryColumn> selectedColumns = editor.getSelectedColumns();

                        // select-columns
                        outgoingQUERY_COLUMN(neoNode.getNode(), (relationship, other) -> relationship.delete());
                        for (QueryColumn selectedColumn : selectedColumns) {
                           final Relationship relationship = relateQUERY_COLUMN(neoNode.getNode(), selectedColumn.columnNode);
                           setInSelectProperty(relationship, selectedColumn.selected);
                           setWhereOperatorProperty(relationship, selectedColumn.whereOperator == null || selectedColumn.whereOperator.length() == 0 ? null : selectedColumn.whereOperator);
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
      final String name = getNameProperty(queryNode);

      final SpringGroup.queryMethodST queryMethodST = springGroup.newqueryMethod().
            setEntity(name + "Result").
            setName("get" + name).
            setSql(queryNodeToSQL(queryNode));

      for (Node column : getSelectColumns(queryNode)) {
         final String columnName = getNameProperty(column);
         final String columnType = getColumnTypeProperty(column, "");
         queryMethodST.addColumnsValue(columnName, MySQLUtil.columnMapping(columnType));
      }

      for (WhereParam queryColumn : getWhereColumnsForQuery(queryNode)) {
         final String columnName = getNameProperty(queryColumn.propertyContainer);
         final String columnType = getColumnTypeProperty(queryColumn.propertyContainer, "");
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
                        final MySqlParser parser = new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(MySQLUtil.preprocessSQL(sql)))));
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

      TableEditor(NeoNode tableNode) {
         super(new BorderLayout());

         final Node dbNode = other(tableNode.getNode(), singleIncoming(tableNode.getNode(), Relations.TABLE));
         final ColumnTableModel columnTableModel = new ColumnTableModel(getQueryColumnsForTable(tableNode.getNode()));
         final JTable tblParams = new JTable(columnTableModel);
         tblParams.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(createOperatorComboBox()));
         tblParams.getColumnModel().getColumn(4).setCellEditor(new ValueCellEditor(dbNode, tableNode.getNode()));

         final JTable tblResult = new JTable(new ResultSetTableModel());

         final JTextArea txtQuery = SwingUtil.newTextArea();
         txtQuery.setEditable(false);
         txtQuery.setWrapStyleWord(true);
         txtQuery.setLineWrap(true);

         final JButton btnExecute = new JButton(new AbstractAction("Run") {
            @Override
            public void actionPerformed(ActionEvent e) {
               runQuery(dbNode, txtQuery.getText(), columnTableModel.asParams(), tblResult);
            }
         });

         txtQuery.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  runQuery(dbNode, txtQuery.getText(), columnTableModel.asParams(), tblResult);
               }
            }
         });

         txtQuery.setText(tableNodeToSQL(tableNode.getNode()) + " limit 50");

         columnTableModel.addTableModelListener(e -> getGraph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               for (QueryColumn selectedColumn : columnTableModel.content) {
                  setInSelectProperty(selectedColumn.columnNode, selectedColumn.selected);
                  setWhereOperatorProperty(selectedColumn.columnNode, selectedColumn.whereOperator.length() == 0 ? null : selectedColumn.whereOperator);
                  setValueProperty(selectedColumn.columnNode, (selectedColumn.value == null || selectedColumn.value.toString().length() == 0) ? null : selectedColumn.value);
               }
               txtQuery.setText(tableNodeToSQL(tableNode.getNode()));
            }

            @Override
            public void exception(Throwable throwable) {
               System.out.println("Could not update columns");
            }
         }));

         if (sessions.containsKey(dbNode))
            runQuery(dbNode, txtQuery.getText(), columnTableModel.asParams(), tblResult);

         final SwingUtil.FormPanel queryPanel = new SwingUtil.FormPanel("10dlu:grow, 4dlu, 30dlu", "pref, 4dlu, 30dlu, 4dlu, 60dlu, 4dlu, 75dlu:grow");
         queryPanel.add(new JScrollPane(txtQuery), 1, 1, 1, 3);
         queryPanel.add(btnExecute, 3, 1, 1, 1);
         queryPanel.add(new JScrollPane(tblParams), 1, 5, 3, 1);
         queryPanel.add(new JScrollPane(tblResult), 1, 7, 3, 1);
         add(queryPanel.build(), BorderLayout.CENTER);
      }

      private class ValueCellEditor extends DefaultCellEditor implements TableCellEditor {

         private final Node dbNode;
         private final String tableName;
         private JButton editorComponent;
         private Object newValue = null;

         ValueCellEditor(Node dbNode, Node tableNode) {
            super(new JTextField());

            this.dbNode = dbNode;
            this.tableName = getNameProperty(tableNode);

            setClickCountToStart(1);

            editorComponent = new JButton();
            editorComponent.setBackground(Color.white);
            editorComponent.setBorderPainted(false);
            editorComponent.setContentAreaFilled(false);
            editorComponent.setFocusable(false);
         }

         @Override
         public Object getCellEditorValue() {
            return newValue;
         }

         @Override
         public Component getTableCellEditorComponent(JTable table, final Object value, boolean isSelected, int row, int column) {

            SwingUtilities.invokeLater(() -> {

               final JTextField txtValue = new JTextField(value==null ? "" : value.toString());

               final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu, 4dlu, 100dlu, 4dlu, pref", "pref");

               final JButton btnSelect = new JButton(new App.TransactionAction("Select", app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final MySQLSession mySQLSession = getSession(dbNode, editor);
                     if (mySQLSession == null) return;

                     final ColumnTableModel columnTableModel = (ColumnTableModel) table.getModel();
                     final String columnName = columnTableModel.content.get(row).columnName;

                     final Set<Object> values = new LinkedHashSet<>();
                     try {

                        mySQLSession.executeQuery("select distinct(" + columnName + ") from " + tableName + " order by 1", resultSet -> values.add(resultSet.getObject(1)));

                     } catch (Exception e1) {
                        SwingUtil.showException(editor, e1);
                     }

                     final Object selectedValue = SwingUtil.showSelectDialog(editor, values, value);
                     if(selectedValue==null) return;
                     txtValue.setText(selectedValue.toString());
                  }
               });

               editor.addLabel("Value", 1, 1);
               editor.add(txtValue, 3, 1);
               editor.add(btnSelect, 5, 1);

               SwingUtil.showDialog(editor, editorComponent, "Set Value", new SwingUtil.ConfirmAction() {
                  @Override
                  public void verifyAndCommit() throws Exception {

                     newValue = txtValue.getText();
                     fireEditingStopped();
                  }
               });
            });

            newValue = value;
            editorComponent.setText(value == null ? "" : value.toString());
            return editorComponent;
         }
      }
   }

   private final class QueryEditor extends JPanel {

      QueryEditor(NeoNode neoNode) {
         super(new BorderLayout());

         final Node dbNode = other(neoNode.getNode(), singleIncoming(neoNode.getNode(), Relations.QUERY));
         final Set<WhereParam> whereColumns = getWhereColumnsForQuery(neoNode.getNode());
         final JTable tblParams = new JTable(new ParamsTableModel(whereColumns));
         final JTable tblResult = new JTable(new ResultSetTableModel());

         final JTextArea txtQuery = SwingUtil.newTextArea();
         txtQuery.setEditable(true);
         txtQuery.setWrapStyleWord(true);
         txtQuery.setLineWrap(true);

         final JButton btnExecute = new JButton(new AbstractAction("Run") {
            @Override
            public void actionPerformed(ActionEvent e) {
               runQuery(dbNode, txtQuery.getText(), ((ParamsTableModel) tblParams.getModel()).asParams(), tblResult);
            }
         });

         txtQuery.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  runQuery(dbNode, txtQuery.getText(), ((ParamsTableModel) tblParams.getModel()).asParams(), tblResult);
               }
            }
         });

         txtQuery.setText(queryNodeToSQL(neoNode.getNode()));

         final SwingUtil.FormPanel queryPanel = new SwingUtil.FormPanel("10dlu:grow, 4dlu, 30dlu", "pref, 4dlu, 30dlu, 4dlu, 60dlu, 4dlu, 75dlu:grow");
         queryPanel.add(new JScrollPane(txtQuery), 1, 1, 1, 3);
         queryPanel.add(btnExecute, 3, 1, 1, 1);
         queryPanel.add(new JScrollPane(tblParams), 1, 5, 3, 1);
         queryPanel.add(new JScrollPane(tblResult), 1, 7, 3, 1);
         add(queryPanel.build(), BorderLayout.CENTER);
      }
   }

   private void runQuery(Node dbNode, String query, Object[] params, JTable tblResult) {

      final MySQLSession mySQLSession = getSession(dbNode, tblResult);
      if (mySQLSession == null) return;

      // todo make a textField or add to queryNodeToSQL as limit...
      final int max = 250;

      final AtomicInteger count = new AtomicInteger(0);
      final ResultSetTableModel resultSetTableModel = new ResultSetTableModel();
      try {

         mySQLSession.executeQuery(query, resultSet -> {

            if (count.get() > max) return;

            final ResultSetMetaData metaData = resultSet.getMetaData();

            if (count.get() == 0) {
               resultSetTableModel.setColumns(metaData);
            }
            resultSetTableModel.addRow(resultSet);
            count.incrementAndGet();
         }, params);

      } catch (Exception e1) {
         SwingUtil.showException(tblResult, e1);
      }

      SwingUtilities.invokeLater(() -> tblResult.setModel(resultSetTableModel));
   }

   private class ParamsTableModel extends AbstractTableModel {

      private final List<WhereParam> content = new ArrayList<>();

      ParamsTableModel(Set<WhereParam> whereColumns) {
         content.addAll(whereColumns);
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
                  removeLastParamProperty(whereParam.propertyContainer);
               } else
                  setLastParamProperty(whereParam.propertyContainer, aValue);
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
   }

   private static class WhereParam {

      private final PropertyContainer propertyContainer;
      private String name;
      private Object value;

      WhereParam(Relationship whereColumn) {
         this.propertyContainer = whereColumn;
         this.name = getNameProperty(whereColumn.getEndNode());
         this.value = getLastParamProperty(whereColumn, "");
      }
   }

   private class ResultSetTableModel extends AbstractTableModel {

      private final List<TableRow> content = new ArrayList<>();
      private String[] columns = new String[0];

      @Override
      public int getRowCount() {
         return content.size();
      }

      @Override
      public int getColumnCount() {
         return columns.length;
      }

      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
         return this.content.get(rowIndex).get(columnIndex);
      }

      @Override
      public String getColumnName(int column) {
         return columns[column];
      }

      void setColumns(ResultSetMetaData metaData) throws SQLException {
         this.columns = new String[metaData.getColumnCount()];
         for (int i = 1; i <= metaData.getColumnCount(); i++) {
            this.columns[i - 1] = metaData.getColumnLabel(i);
         }
      }

      void addRow(ResultSet resultSet) throws SQLException {
         this.content.add(new TableRow(resultSet, this.columns));
      }

      private final class TableRow {

         private final Map<Integer, Object> values = new LinkedHashMap<>();

         TableRow(ResultSet resultSet, String[] columns) throws SQLException {
            for (int i = 0; i < columns.length; i++)
               values.put(i, resultSet.getObject(i + 1));
         }

         public Object get(int columnIndex) {
            return values.get(columnIndex);
         }
      }
   }

   private MySQLSession getSession(Node dbNode, JComponent parent) {

      if (!sessions.containsKey(dbNode)) {

         final char[] password = SwingUtil.showPasswordDialog(parent);
         if (password == null || password.length == 0) return null;

         getGraph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               try {
                  sessions.put(dbNode, getSession(dbNode, password));
               } catch (Throwable t) {
                  SwingUtil.showException(app, t);
               }
            }

            @Override
            public void exception(Throwable throwable) {
               SwingUtil.showException(parent, throwable);
            }
         });
      }

      return sessions.get(dbNode);
   }

   @NotNull
   public static String queryNodeToSQL(Node queryNode) {

      final MysqlGroup mysqlGroup = new MysqlGroup();
      final MysqlGroup.selectST selectST = mysqlGroup.newselect();

      final Set<Node> tables = new LinkedHashSet<>();
      outgoingQUERY_COLUMN(queryNode, (queryColumnRelation, columnNode) -> {
         final Node tableNode = other(columnNode, singleIncoming(columnNode, Relations.COLUMN));

         if (!tables.contains(tableNode)) {
            tables.add(tableNode);
            selectST.addTablesValue(getNameProperty(tableNode) + " " + StringUtil.lowFirst(getNameProperty(tableNode)));
         }

         if (getInSelectProperty(queryColumnRelation)) {
            selectST.addColumnsValue(getQualifiedColumnName(columnNode, tableNode));
         }

         final String whereOperator = getWhereOperatorProperty(queryColumnRelation, "");
         if (whereOperator.length() > 0)
            selectST.addWhereValue("?", getWhereOperatorProperty(queryColumnRelation), getQualifiedColumnName(columnNode, tableNode));
      });

      // todo auto-join tables through fk-columns
      if (tables.size() > 1) {
         final Map<String, String> fkColumns = new LinkedHashMap<>();
         for (Node table : tables) {
            outgoingCOLUMN(table, (relationship, columnNode) -> outgoingFK_SRC(columnNode, (fkRelation, fkColumn) -> {
               final String srcName = getQualifiedColumnName(columnNode, table);
               final String dstName = getQualifiedColumnName(fkColumn, other(fkColumn, singleIncoming(fkColumn, Relations.COLUMN)));
               fkColumns.put(srcName, dstName);
            }));
         }

         for (Map.Entry<String, String> fkEntry : fkColumns.entrySet()) {
            selectST.addWhereValue(fkEntry.getValue(), "=", fkEntry.getKey());
         }
      }

      return selectST.toString();
   }

   @NotNull
   public static String tableNodeToSQL(Node tableNode) {

      final MysqlGroup mysqlGroup = new MysqlGroup();
      final MysqlGroup.selectST selectST = mysqlGroup.newselect();

      selectST.addTablesValue(getNameProperty(tableNode) + " " + StringUtil.lowFirst(getNameProperty(tableNode)));

      outgoingCOLUMN(tableNode, (queryColumnRelation, columnNode) -> {

         if (getInSelectProperty(columnNode, true))
            selectST.addColumnsValue(getQualifiedColumnName(columnNode, tableNode));

         final String whereOperator = getWhereOperatorProperty(columnNode, "");
         if (whereOperator.length() > 0)
            selectST.addWhereValue("?", whereOperator, getQualifiedColumnName(columnNode, tableNode));
      });

      return selectST.toString();
   }

   @NotNull
   public static String getQualifiedColumnName(Node columnNode, Node tableNode) {
      return StringUtil.lowFirst(getNameProperty(tableNode)) + "." + getNameProperty(columnNode);
   }

   @NotNull
   private static Set<Node> getSelectColumns(Node queryNode) {
      final Set<Node> columns = new LinkedHashSet<>();
      outgoingQUERY_COLUMN(queryNode, (queryColumnRelation, other) -> {
         if (getInSelectProperty(queryColumnRelation)) columns.add(other);
      });
      return columns;
   }

   @NotNull
   private static Set<WhereParam> getWhereColumnsForQuery(Node queryNode) {
      final Set<WhereParam> columns = new LinkedHashSet<>();
      outgoingQUERY_COLUMN(queryNode, (queryColumnRelation, other) -> {
         if (getWhereOperatorProperty(queryColumnRelation, "").length() > 0) columns.add(new WhereParam(queryColumnRelation));
      });
      return columns;
   }

   @NotNull
   private static List<QueryColumn> getQueryColumnsForTable(Node tableNode) {
      final List<QueryColumn> columns = new ArrayList<>();
      outgoingCOLUMN(tableNode, (columnRelation, columnNode) -> columns.add(new QueryColumn(tableNode, columnNode, true)));
      return columns;
   }

   class SelectQueryColumnPanel extends JPanel {

      private final JTable tblColumns;

      SelectQueryColumnPanel(Node queryNode) {
         super(new BorderLayout());

         final List<QueryColumn> queryColumns = new ArrayList<>();
         final Map<String, QueryColumn> columnNodes = new LinkedHashMap<>();

         outgoingQUERY_TABLE(queryNode, (relationship, tableNode) -> outgoingCOLUMN(tableNode, (columnRelation, columnNode) -> {
            final QueryColumn queryColumn = new QueryColumn(tableNode, columnNode, false);
            queryColumns.add(queryColumn);
            columnNodes.put(getNameProperty(tableNode) + "." + getNameProperty(queryColumn.columnNode), queryColumn);
         }));

         outgoingQUERY_COLUMN(queryNode, (relationship, columnNode) -> {
            final QueryColumn queryColumn = columnNodes.get(getNameProperty(other(columnNode, singleIncoming(columnNode, Relations.COLUMN))) + "." + getNameProperty(columnNode));
            queryColumn.selected = getInSelectProperty(relationship);
            queryColumn.whereOperator = getWhereOperatorProperty(relationship, "");
         });

         tblColumns = new JTable(new ColumnTableModel(queryColumns));
         tblColumns.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(createOperatorComboBox()));
         add(new JScrollPane(tblColumns), BorderLayout.NORTH);

         outgoingQUERY_TABLE(queryNode, new RelationConsumer() {
            @Override
            public void accept(Relationship relationship, Node other) {

            }
         });
      }

      List<QueryColumn> getSelectedColumns() {
         final ColumnTableModel model = (ColumnTableModel) tblColumns.getModel();
         return model.getSelectedColumns();
      }
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
      chk.addItem(" != ");
      return chk;
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
               return content.get(rowIndex).whereOperator;
            case 4:
               return content.get(rowIndex).value;
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
               return "Value";
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
               return String.class;
            case 4:
               return Object.class;
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
               content.get(rowIndex).whereOperator = aValue == null ? "" : aValue.toString();
               fireTableCellUpdated(rowIndex, columnIndex);
               break;
            case 4:
               content.get(rowIndex).value = aValue == null ? "" : aValue.toString();
               fireTableCellUpdated(rowIndex, columnIndex);
               break;
         }
      }

      List<QueryColumn> getSelectedColumns() {
         final List<QueryColumn> selected = new ArrayList<>();
         for (QueryColumn columnEntry : content)
            if (columnEntry.selected) selected.add(columnEntry);
         return selected;
      }

      Object[] asParams() {

         final List<QueryColumn> whereColumns = new ArrayList<>();
         for (QueryColumn columnEntry : content)
            if (columnEntry.whereOperator.length() > 0) whereColumns.add(columnEntry);

         final Object[] params = new Object[whereColumns.size()];
         for (int i = 0; i < whereColumns.size(); i++) {
            QueryColumn whereParam = whereColumns.get(i);
            params[i] = whereParam.value == null || whereParam.value.toString().length() == 0 ? null : whereParam.value;
         }
         return params;
      }
   }

   private static class QueryColumn {

      private final Node columnNode;
      private final String columnName;
      private final String tableName;
      private boolean selected = false;
      private String whereOperator = "";
      private Object value = null;

      QueryColumn(Node tableNode, Node columnNode, boolean defaultSelected) {
         this.columnNode = columnNode;
         this.tableName = getNameProperty(tableNode);
         this.columnName = getNameProperty(columnNode);

         selected = getInSelectProperty(columnNode, defaultSelected);
         whereOperator = getWhereOperatorProperty(columnNode, "");
         value = getValueProperty(columnNode);
      }
   }

   public static MySQLSession getSession(Node dbNode, char[] password) throws Exception {
      return new MySQLSession(getHostProperty(dbNode), getNameProperty(dbNode), getUsernameProperty(dbNode), new String(password));
   }
}