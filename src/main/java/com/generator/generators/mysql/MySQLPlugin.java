package com.generator.generators.mysql;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.Workspace;
import com.generator.BaseDomainVisitor;
import com.generator.NeoModel;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.mysql.parser.MySqlLexer;
import com.generator.generators.mysql.parser.MySqlNeoVisitor;
import com.generator.generators.mysql.parser.MySqlNodeListener;
import com.generator.generators.mysql.parser.MySqlParser;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;

import static com.generator.NeoModel.relate;

/**
 * Created 23.08.17.
 */
public class MySQLPlugin extends DomainPlugin {
   public MySQLPlugin(App app) {
      super(app, "MySQL");
   }

   @Override
   protected void handleNodeRightClick(JPopupMenu pop, Workspace.NodeCanvas.NeoNode neoNode, Set<Workspace.NodeCanvas.NeoNode> selectedNodes) {

      if (BaseDomainVisitor.hasLabel(neoNode.getNode(), "ColCreateTable")) {
         pop.add(new App.TransactionAction("As Pojo", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               BaseDomainVisitor.outgoing(neoNode.getNode(), RelationshipType.withName("child")).forEach(new Consumer<Relationship>() {
                  @Override
                  public void accept(Relationship relationship) {
                     final Node other = BaseDomainVisitor.other(neoNode.getNode(), relationship);

                  }
               });
            }
         });
      }
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      menu.add(new App.TransactionAction("Parse sql", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final JTextArea txtSql = new JTextArea(20, 30);

            SwingUtil.showTextInput("Sql", txtSql, app, () -> {

               final String sql = txtSql.getText().trim();
               if (sql.length() == 0) return;

               getGraph().doInTransaction(new NeoModel.Committer() {
                  @Override
                  public void doAction(Transaction tx1) throws Throwable {
                     final MySqlParser parser = new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(MySQLSession.preprocessSQL(sql)))));
                     final MySqlNeoVisitor visitor = new MySqlNeoVisitor(getGraph());
                     visitor.visit(parser.sql_statements());
                     if (visitor.getRoot() != null) fireNodesLoaded(visitor.getRoot());
                  }

                  @Override
                  public void exception(Throwable throwable) {
                     SwingUtil.showExceptionNoStack(app, throwable);
                  }
               });
            });
         }
      });

      menu.add(new App.TransactionAction("Get tables from Database", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final JTextField txtHost = new JTextField("127.0.0.1");
            final JTextField txtDatabase = new JTextField("tr");
            final JTextField txtUsername = new JTextField("root");
            final JTextField txtPassword = new JTextField("root");

            SwingUtil.FormPanel login = new SwingUtil.FormPanel("pref, 4dlu, 75dlu:grow", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");
            login.addLabel("Host", 1, 1);
            login.add(txtHost, 3, 1);
            login.addLabel("Database", 1, 3);
            login.add(txtDatabase, 3, 3);
            login.addLabel("Username", 1, 5);
            login.add(txtUsername, 3, 5);
            login.addLabel("Password", 1, 7);
            login.add(txtPassword, 3, 7);

            SwingUtil.showDialog(login, app, "Connect to database", () -> getGraph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx12) throws Throwable {

                  final MySQLSession db = new MySQLSession(txtHost.getText(), txtDatabase.getText(), txtUsername.getText(), txtPassword.getText());
                  final Set<String> tables = db.getTables();
                  for (String table : tables) {
                     System.out.println(table);

                     final MySqlParser parser = new MySqlParser(new CommonTokenStream(new MySqlLexer(CharStreams.fromString(table))));

                     final MySqlNodeListener listener = new MySqlNodeListener() {

                        private final Stack<org.neo4j.graphdb.Node> nodes = new Stack<>();

                        @Override
                        public void enterColCreateTable(MySqlParser.ColCreateTableContext arg0) {
                           nodes.push(getGraph().newNode(Label.label("MySqlTable")));
                        }

                        @Override
                        public void exitColCreateTable(MySqlParser.ColCreateTableContext arg0) {
                           final org.neo4j.graphdb.Node node = nodes.pop();
                           fireNodesLoaded(node);
                        }

                        @Override
                        public void enterId_(MySqlParser.Id_Context arg0) {
                           // todo remove this when all cases are complete
                           if (nodes.size() > 0)
                              relate(nodes.peek(), newValueNode(StringUtil.trimEnds(1, arg0.getText())), RelationshipType.withName("NAME"));
                        }

                        @Override
                        public void enterColumnDefinition(MySqlParser.ColumnDefinitionContext arg0) {
                           final org.neo4j.graphdb.Node mySQLColumn = getGraph().newNode(Label.label("MySQLColumn"));
                           relate(nodes.peek(), mySQLColumn, RelationshipType.withName("COLUMN"));
                           nodes.push(mySQLColumn);
                        }

                        @Override
                        public void exitColumnDefinition(MySqlParser.ColumnDefinitionContext arg0) {
                           nodes.pop();
                        }

                        @Override
                        public void enterDimensionDatatype(MySqlParser.DimensionDatatypeContext arg0) {
                           final org.neo4j.graphdb.Node columnType = getGraph().findOrCreate(Label.label("ColumnType"), AppMotif.Properties.name.name(), arg0.getText());
                           relate(nodes.peek(), columnType, RelationshipType.withName("TYPE"));
                           nodes.push(columnType);
                        }

                        @Override
                        public void exitDimensionDatatype(MySqlParser.DimensionDatatypeContext arg0) {
                           nodes.pop();
                        }

                        @Override
                        public void enterColConstrNull(MySqlParser.ColConstrNullContext arg0) {
                           relate(nodes.peek(), getGraph().findOrCreate(Label.label("Nullable"), AppMotif.Properties.name.name(), arg0.getText()), RelationshipType.withName("NULLABLE"));
                        }

                        @Override
                        public void enterCharDatatype(MySqlParser.CharDatatypeContext arg0) {
                           final org.neo4j.graphdb.Node columnType = getGraph().findOrCreate(Label.label("ColumnType"), AppMotif.Properties.name.name(), arg0.getText());
                           nodes.peek().createRelationshipTo(columnType, RelationshipType.withName("TYPE"));
                           nodes.push(columnType);
                        }

                        @Override
                        public void exitCharDatatype(MySqlParser.CharDatatypeContext arg0) {
                           nodes.peek();
                        }

                        @Override
                        public void enterTblConstrFK(MySqlParser.TblConstrFKContext arg0) {

                        }
                     };
                     new ParseTreeWalker().walk(listener, parser.root());
                  }

                  db.close();
               }

               @Override
               public void exception(Throwable throwable) {
                  SwingUtil.showExceptionNoStack(app, throwable);
               }
            }));
         }
      });
   }
}
