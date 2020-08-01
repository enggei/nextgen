package nextgen.st.canvas;

import nextgen.st.model.Script;
import nextgen.utils.SwingUtil;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ScriptNode extends nextgen.st.canvas.STNode {

	Script script;

	public ScriptNode(nextgen.st.canvas.STCanvas canvas, Script script) {
		super(canvas, script.getName(), java.util.UUID.fromString(script.getUuid()));
		this.script = script;
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
		if (script.getScript() == null || !node.getUuid().toString().equals(script.getScript().getUuid())) return;
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
		pop.add(new OpenScript(this, canvas, event));
		pop.add(new Run(this, canvas, event));
		pop.add(new SetName(this, canvas, event));
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

	private static final class OpenScript extends NodeAction<ScriptNode> {


		OpenScript(ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Open Script", node, canvas, event);
		}

		@Override
		void actionPerformed(ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.db.doInTransaction(transaction -> {
				final nextgen.st.model.STValue stValue = node.script.getScript();
				if (stValue == null) return;
				canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));
			//					 canvas.addRelation(node.script.getUuid(), canvas.newScriptRelation(node, stValueNode));
			});
		}
	}

	private static final class Run extends NodeAction<ScriptNode> {


		Run(ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Run", node, canvas, event);
		}

		@Override
		void actionPerformed(ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				try {

					final nextgen.st.STAppPresentationModel.CompilationResult compilationResult = canvas.presentationModel.generateScriptCode(node.script);

					if (compilationResult.aClass == null) {
						JOptionPane.showMessageDialog(canvas, compilationResult.compilerOutput, "Compilation Exception", JOptionPane.ERROR_MESSAGE);
						return;
					}

					((Runnable) compilationResult.aClass
							.getConstructor(nextgen.st.model.STModelDB.class, nextgen.st.STRenderer.class)
							.newInstance(canvas.presentationModel.db, canvas.presentationModel.stRenderer))
							.run();

				} catch (Throwable ex) {
					SwingUtil.showException(canvas, ex);
				}
			});
		}
	}

	private static final class SetName extends NodeAction<ScriptNode> {


		SetName(ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Set Name", node, canvas, event);
		}

		@Override
		void actionPerformed(ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.db.doInTransaction(transaction -> {
				SwingUtil.showInputDialog("Name", canvas, node.script.getName(), s -> doLaterInTransaction(tx -> {
					node.script.setName(s);
					node.setText(node.script.getName());					
				}));
			});
		}
	}

	private static final class Delete extends NodeAction<ScriptNode> {


		Delete(ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Delete", node, canvas, event);
		}

		@Override
		void actionPerformed(ScriptNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			if (!SwingUtil.showConfirmDialog(canvas, "Delete script ?")) return;
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
				final nextgen.st.model.STValue dst = canvas.presentationModel.newSTValue(stModelNode.stModel);
				node.script.setScript(dst);
				canvas.removeRelation(node.getUuid());
				final STValueNode stValueNode = canvas.addNode(dst.getUuid(), canvas.newSTNode(dst));
				canvas.addRelation(node.getUuid(), canvas.newScriptRelation(node, stValueNode));
			});
		}
	}
}