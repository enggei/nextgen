package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class ScriptNode extends nextgen.st.canvas.STNode {

	nextgen.st.script.Script script;
	nextgen.st.STRenderer stRenderer;

	public ScriptNode(nextgen.st.canvas.STCanvas canvas, nextgen.st.script.Script script, nextgen.st.STRenderer stRenderer) {
		super(canvas, script.getName(), java.util.UUID.fromString(script.getUuid()));
		this.script = script;
		this.stRenderer = stRenderer;
	}

	@Override
	public void addedToCanvas() {
		if (script.getScript() == null) return;
		canvas.getAllNodes().filter(stNode -> stNode instanceof STValueNode)
				.map(stNode -> (STValueNode) stNode)
				.filter(stValueNode -> stValueNode.getUuid().toString().equals(script.getScript().getUuid()))
				.findFirst()
				.ifPresent(stValueNode -> {
					canvas.addRelation(script.getUuid(), canvas.newScriptRelation(ScriptNode.this, stValueNode));
				});
	}

	@Override
	public void newNodeAdded(nextgen.st.canvas.STNode node) {
		if (script.getScript() != null || !node.getUuid().toString().equals(script.getScript().getUuid())) return;
		canvas.addRelation(script.getUuid(), canvas.newScriptRelation(ScriptNode.this, node));
	}

	@Override
	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
		final java.util.List<STValueNode> stValueNodes = canvas.getSelectedNodes()
				.filter(stNode -> stNode instanceof STValueNode)
				.filter(stNode -> !stNode.getUuid().equals(getUuid()))
				.map(stNode -> (STValueNode) stNode)
				.collect(java.util.stream.Collectors.toList());
		final java.util.List<STModelNode> stModelNodes = canvas.getSelectedNodes()
				.filter(stNode -> stNode instanceof STModelNode)
				.filter(stNode -> !stNode.getUuid().equals(getUuid()))
				.map(stNode -> (STModelNode) stNode)
				.collect(java.util.stream.Collectors.toList());
		canvas.presentationModel.db.doInTransaction(tx -> {
			
			stModelNodes.forEach(stNode -> pop.add(new SetScriptModelAction("Set Script to " + cut(stNode.getText()), ScriptNode.this, canvas, event, stNode)));
			stValueNodes.forEach(stNode -> pop.add(new SetScriptValueAction("Set Script to " + cut(stNode.getText()), ScriptNode.this, canvas, event, stNode)));				
		});
		pop.add(new Run(this, canvas, event));
		pop.add(new Delete(this, canvas, event));
		pop.addSeparator();
		super.onNodeRightClick(event, pop);
	}

	@Override
	protected void onNodeKeyPressed(PInputEvent event) {
		super.onNodeKeyPressed(event);
	}

	@Override
	protected void onNodeLeftClick(PInputEvent event) {
		super.onNodeLeftClick(event);
	}

	private static final class Run extends NodeAction<ScriptNode> {


		Run(ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Run", node, canvas, event);
		}

		@Override
		void actionPerformed(ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				try {
					final String className = "Runner" + System.currentTimeMillis();
					final String script = node.stRenderer.render(node.script.getScript());
					log.info(script);

					final nextgen.templates.java.PackageDeclaration packageDeclaration = nextgen.templates.java.JavaST.newPackageDeclaration()
							.setName("tmp");

					final nextgen.templates.java.CompilationUnit compilationUnit = nextgen.templates.java.JavaST.newCompilationUnit()
						.setPackageDeclaration(packageDeclaration)
						.addTypes(nextgen.templates.java.JavaST.newClassOrInterfaceDeclaration()
								.setName(className)
								.addModifiers("public")
								.addImplementedTypes("Runnable")
								.addMembers(nextgen.templates.java.JavaST.newFieldDeclaration()
										.addVariables(nextgen.templates.java.JavaST.newVariableDeclaration()
												.setName("db")
												.setType(nextgen.st.model.STModelDB.class.getCanonicalName())))
								.addMembers(nextgen.templates.java.JavaST.newFieldDeclaration()
										.addVariables(nextgen.templates.java.JavaST.newVariableDeclaration()
												.setName("renderer")
												.setType(nextgen.st.STRenderer.class.getCanonicalName())))
								.addMembers(nextgen.templates.java.JavaST.newConstructorDeclaration()
										.setName(className)
										.addModifiers("public")
										.addParameters(nextgen.templates.java.JavaST.newParameter()
												.setName("db")
												.setType(nextgen.st.model.STModelDB.class.getCanonicalName()))
										.addParameters(nextgen.templates.java.JavaST.newParameter()
												.setName("renderer")
												.setType(nextgen.st.STRenderer.class.getCanonicalName()))
										.setBlockStmt(nextgen.templates.java.JavaST.newBlockStmt()
												.addStatements("this.db = db;")
												.addStatements("this.renderer = renderer;")))
								.addMembers(nextgen.templates.java.JavaST.newMethodDeclaration()
										.addAnnotations(nextgen.templates.java.JavaST.newSingleMemberAnnotationExpression().setName("Override"))
										.setName("run")
										.addModifiers("public")
										.setBlockStmt(nextgen.templates.java.JavaST.newBlockStmt()
												.addStatements("db.doInTransaction(transaction -> {")
												.addStatements("\t" + script)
												.addStatements("});"))));

					final Class<?> aClass = net.openhft.compiler.CompilerUtils.CACHED_COMPILER.loadFromJava(packageDeclaration.getName() + "." + className, compilationUnit.toString());
					final Runnable runner = (Runnable) aClass.getConstructor(
								nextgen.st.model.STModelDB.class, nextgen.st.STRenderer.class)
								.newInstance(canvas.presentationModel.db, canvas.presentationModel.stRenderer);
					runner.run();
				} catch (Throwable ex) {
					com.generator.util.SwingUtil.showException(canvas, ex);
				}
			});
		}
	}

	private static final class Delete extends NodeAction<ScriptNode> {


		Delete(ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Delete", node, canvas, event);
		}

		@Override
		void actionPerformed(ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			if (!com.generator.util.SwingUtil.showConfirmDialog(canvas, "Delete script ?")) return;
			doLaterInTransaction(tx -> {
				node.close();
				canvas.presentationModel.db.remove(node.script);
			});
		}
	}

	private static final class SetScriptValueAction extends NodeAction<ScriptNode> {

		nextgen.st.canvas.STValueNode stValue;

		SetScriptValueAction(String name, ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.canvas.STValueNode stValue) {
			super(name, node, canvas, event);
			this.stValue = stValue;
		}

		@Override
		void actionPerformed(ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(transaction -> {
				node.script.setScript(stValue.stValue);
				canvas.removeRelation(node.getUuid());
				canvas.addRelation(node.getUuid(), canvas.newScriptRelation(node, stValue));
			});
		}
	}

	private static final class SetScriptModelAction extends NodeAction<ScriptNode> {

		nextgen.st.canvas.STModelNode stModelNode;

		SetScriptModelAction(String name, ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.canvas.STModelNode stModelNode) {
			super(name, node, canvas, event);
			this.stModelNode = stModelNode;
		}

		@Override
		void actionPerformed(ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(transaction -> {
				final nextgen.st.model.STValue dst = canvas.presentationModel.db.newSTValue(stModelNode.stModel);
				node.script.setScript(dst);
				canvas.removeRelation(node.getUuid());
				final STValueNode stValueNode = canvas.addNode(dst.getUuid(), canvas.newSTNode(dst));
				canvas.addRelation(node.getUuid(), canvas.newScriptRelation(node, stValueNode));
			});
		}
	}
}