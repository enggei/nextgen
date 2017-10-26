package com.generator.generators.mysql;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.DomainMotif;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.mysql.parser.MySqlLexer;
import com.generator.generators.mysql.parser.MySqlParser;
import com.generator.generators.mysql.parser.MySqlParserNeoVisitor;
import com.generator.generators.spring.SpringDAOGroup;
import com.generator.generators.stringtemplate.GeneratedFile;
import com.generator.neo.NeoModel;
import com.generator.util.NeoUtil;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSetMetaData;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.util.NeoUtil.*;

/**
 * Created 23.08.17.
 */
public class MySQLPlugin extends Plugin {

   public enum Entities implements Label {
      Database, Table, Column, FOREIGN_KEY, Query
   }

   public enum Relations implements RelationshipType {
      TABLE, COLUMN, FK_SRC, FK_DST, QUERY, QUERY_TABLE, QUERY_COLUMN
   }

   public enum Properties {
      host, username, columnType, onDelete
   }

   public MySQLPlugin(App app) {
      super(app, "MySQL");
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
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

      } else if (NeoUtil.hasLabel(neoNode.getNode(), Entities.Database)) {

         pop.add(new App.TransactionAction("Create Dao", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final String daoName = StringUtil.capitalize(getString(neoNode.getNode(), AppMotif.Properties.name.name())) + "DAO";
               final String daoImplName = daoName + "Impl";

               final SpringDAOGroup springDAOGroup = new SpringDAOGroup();
               final SpringDAOGroup.DaoImplST daoImplST = springDAOGroup.newDaoImpl();
               final SpringDAOGroup.DaoST daoST = springDAOGroup.newDao();

               final String packageName = "com.ud.tr.dao";

               daoST.setPackage(packageName).setName(daoName);
               daoImplST.
                     setPackage(packageName).
                     setName(daoImplName).
                     setImplement(daoName);

               outgoing(neoNode.getNode(), Relations.TABLE).forEach(relationship -> {
                  final Node tableNode = other(neoNode.getNode(), relationship);
                  System.out.println(getString(tableNode, AppMotif.Properties.name.name()));
               });

               GeneratedFile.newJavaFile("/home/goe/udc/trailer-report/src/main/java", packageName, daoImplName).write(daoImplST);
               GeneratedFile.newJavaFile("/home/goe/udc/trailer-report/src/main/java", packageName, daoName).write(daoST);
            }
         });


         pop.add(new App.TransactionAction("New Query", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Name", app);
               if (name == null || name.length() == 0) return;

               final Node newNode = getGraph().newNode(Entities.Query, AppMotif.Properties.name.name(), name);
               relate(neoNode.getNode(), newNode, Relations.QUERY);
               fireNodesLoaded(newNode);
            }
         });


      } else if (NeoUtil.hasLabel(neoNode.getNode(), Entities.Query)) {


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

         pop.add(new App.TransactionAction("Select Columns", app) {

            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final Map<String, Map<String, Boolean>> tableColumns = new HashMap<>();
               final Map<String, Node> columnNodes = new LinkedHashMap<>();

               outgoing(neoNode.getNode(), Relations.QUERY_TABLE).forEach(tableRelation -> {
                  final Node tableNode = other(neoNode.getNode(), tableRelation);

                  tableColumns.put(DomainMotif.getName(tableNode), new HashMap<>());
                  outgoing(tableNode, Relations.COLUMN).forEach(columnRelation -> {
                     final Node columnNode = other(tableNode, columnRelation);
                     tableColumns.get(DomainMotif.getName(tableNode)).put(DomainMotif.getName(columnNode), Boolean.FALSE);
                     columnNodes.put(DomainMotif.getName(tableNode) + "." + DomainMotif.getName(columnNode), columnNode);

                  });
               });

               outgoing(neoNode.getNode(), Relations.QUERY_COLUMN).forEach(relationship -> {
                  final Node columnNode = other(neoNode.getNode(), relationship);
                  final Node tableNode = other(columnNode, singleIncoming(columnNode, Relations.COLUMN));
                  tableColumns.get(DomainMotif.getName(tableNode)).put(DomainMotif.getName(columnNode), Boolean.TRUE);
               });

               final SelectQueryColumnPanel editor = new SelectQueryColumnPanel(tableColumns);

               SwingUtil.showDialog(editor, app, "Columns", new SwingUtil.ConfirmAction() {
                  @Override
                  public void verifyAndCommit() throws Exception {

                     getGraph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {

                           final List<String> selectedColumns = editor.getSelectedColumns();

                           // delete existing relations
                           outgoing(neoNode.getNode(), Relations.QUERY_COLUMN).forEach(Relationship::delete);

                           // add new ones
                           for (String selectedColumn : selectedColumns) {
                              relate(neoNode.getNode(), columnNodes.get(selectedColumn), Relations.QUERY_COLUMN);
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

      } else if (NeoUtil.hasLabel(neoNode.getNode(), Entities.Table)) {

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
   public JComponent getEditorFor(NeoNode neoNode) {

      if (hasLabel(neoNode.getNode(), Entities.Table)) {
         return new TableEditor(neoNode);
      } else if (hasLabel(neoNode.getNode(), Entities.Query)) {
         return new QueryEditor(neoNode);
      }
      return null;
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

      private MySQLSession session;

      QueryEditor(NeoNode neoNode) {
         super(new BorderLayout());

         final Node dbNode = other(neoNode.getNode(), singleIncoming(neoNode.getNode(), Relations.QUERY));

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);
         txtEditor.setEditable(true);
         txtEditor.setWrapStyleWord(true);
         txtEditor.setLineWrap(true);

         final JTextArea txtResult = new JTextArea();
         txtResult.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtResult.setTabSize(1);
         txtResult.setEditable(true);

         final JButton btnExecute = new JButton(new AbstractAction("Run") {
            @Override
            public void actionPerformed(ActionEvent e) {
               executeQuery(txtEditor, dbNode, txtResult);
            }
         });

         txtEditor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getModifiers() == KeyEvent.CTRL_MASK) {
                  executeQuery(txtEditor, dbNode, txtResult);
               }
            }
         });

         final StringBuilder columns = new StringBuilder("select ");
         final StringBuilder from = new StringBuilder("from ");
         final Set<String> tables = new LinkedHashSet<>();

         final AtomicBoolean firstColumn = new AtomicBoolean(true);
         final AtomicBoolean firstTable = new AtomicBoolean(true);
         outgoing(neoNode.getNode(), Relations.QUERY_COLUMN).forEach(queryColumnRelation -> {
            final Node columnNode = other(neoNode.getNode(), queryColumnRelation);
            final Node tableNode = other(columnNode, singleIncoming(columnNode, Relations.COLUMN));

            if (!tables.contains(DomainMotif.getName(tableNode))) {
               tables.add(DomainMotif.getName(tableNode));
               from.append(firstTable.get() ? "" : ", ").append(DomainMotif.getName(tableNode)).append(" ").append(StringUtil.lowFirst(DomainMotif.getName(tableNode)));
               firstTable.set(false);
            }

            columns.append(firstColumn.get() ? "" : ", ").append(StringUtil.lowFirst(DomainMotif.getName(tableNode))).append(".").append(DomainMotif.getName(columnNode));
            firstColumn.set(false);
         });

         String sql = String.valueOf(columns) + " " + from;
         txtEditor.setText(sql);

         final JPanel northPanel = new JPanel(new BorderLayout());
         northPanel.add(txtEditor, BorderLayout.CENTER);
         northPanel.add(btnExecute, BorderLayout.EAST);
         add(northPanel, BorderLayout.NORTH);
         add(new JScrollPane(txtResult), BorderLayout.CENTER);
      }

      public void executeQuery(JTextArea txtEditor, Node dbNode, JTextArea txtResult) {
         if (session == null) {

            final char[] password = SwingUtil.showPasswordDialog(txtEditor);
            if (password == null || password.length == 0) return;

            getGraph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  try {
                     session = new MySQLSession(getString(dbNode, Properties.host.name()), DomainMotif.getName(dbNode), getString(dbNode, Properties.username.name()), new String(password));
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
               });

               txtResult.setText(result.toString());
               txtResult.setCaretPosition(0);
            } catch (Exception e) {
               SwingUtil.showException(txtEditor, e);
            }
         }
      }
   }


   class SelectQueryColumnPanel extends JPanel {

      private final JTable tblColumns;

      SelectQueryColumnPanel(Map<String, Map<String, Boolean>> tableColumns) {
         super(new BorderLayout());

         tblColumns = new JTable(new ColumnTableModel(tableColumns));
         add(new JScrollPane(tblColumns), BorderLayout.CENTER);
      }

      List<String> getSelectedColumns() {
         final List<String> selected = new ArrayList<>();
         final ColumnTableModel model = (ColumnTableModel) tblColumns.getModel();
         for (ColumnEntry columnEntry : model.content) {
            if (columnEntry.selected) selected.add(columnEntry.table + "." + columnEntry.name);
         }
         return selected;
      }

      class ColumnEntry {

         private String table;
         private String name;
         private Boolean selected;

         ColumnEntry(String table, String name, Boolean selected) {
            this.table = table;
            this.name = name;
            this.selected = selected;
         }
      }

      class ColumnTableModel extends AbstractTableModel {

         final List<ColumnEntry> content = new java.util.ArrayList<>();

         ColumnTableModel(Map<String, Map<String, Boolean>> tableColumns) {
            for (Map.Entry<String, Map<String, Boolean>> entries : tableColumns.entrySet()) {
               for (Map.Entry<String, Boolean> column : entries.getValue().entrySet()) {
                  content.add(new ColumnEntry(entries.getKey(), column.getKey(), column.getValue()));
               }
            }
         }

         @Override
         public int getRowCount() {
            return content.size();
         }

         @Override
         public int getColumnCount() {
            return 3;
         }

         @Override
         public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
               case 0:
                  return content.get(rowIndex).table;
               case 1:
                  return content.get(rowIndex).name;
               case 2:
                  return content.get(rowIndex).selected;
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
                  return "Selected";
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
            }
            return Object.class;
         }

         @Override
         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 2;
         }

         @Override
         public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            content.get(rowIndex).selected = Boolean.valueOf(aValue.toString());
            fireTableCellUpdated(rowIndex, columnIndex);
         }
      }
   }
}