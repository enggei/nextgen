package com.generator.generators.stardog;

import com.generator.app.App;
import com.generator.app.Plugin;
import com.generator.app.nodes.NeoNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Set;

public class StardogPlugin extends Plugin {

	public enum Entities implements Label {
		Database, Namespace, Graph
	}

	public enum Relations implements RelationshipType {
		GRAPH, NAMESPACE
	}

	public enum Properties {

	}

	public StardogPlugin(App app) {
		super(app, "Stardog");
	}

	@Override
	protected Label[] getLabels() {
		return new Label[0];
	}

	@Override
	protected void addActionsTo(JMenu menu) {
		menu.add(new App.TransactionAction("Get databases from instance", app) {
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

				if (txtHost.getText().length() == 0) throw new IllegalArgumentException("host must be set");
				if (txtDatabase.getText().length() == 0)
					throw new IllegalArgumentException("database must be set");
				if (txtUsername.getText().length() == 0)
					throw new IllegalArgumentException("username must be set");
				if (txtPassword.getPassword().length == 0)
					throw new IllegalArgumentException("password must be set");

				// TODO: Connect to Stardog
				// TODO: Get list of databases and then query list of graphs
				// TODO Parse JSON-LD result and build graph representation

			}
		});
	}

	@Override
	public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

	}

	@Override
	public JComponent getEditorFor(NeoNode neoNode) {
		return null;
	}
}
