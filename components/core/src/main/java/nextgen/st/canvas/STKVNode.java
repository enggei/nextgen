package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class STKVNode extends nextgen.st.canvas.STNode {

	nextgen.st.domain.STParameter stParameter;
	nextgen.st.model.STArgument stArgument;

	public STKVNode(nextgen.st.canvas.STCanvas canvas, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STArgument stArgument) {
		super(canvas, stParameter.getName(), java.util.UUID.fromString(stArgument.getUuid()));
		this.stParameter = stParameter;
		this.stArgument = stArgument;
	}

	@Override
	public void addedToCanvas() {
		canvas.getAllNodes().forEach(this::newNodeAdded);
	}

	@Override
	public void newNodeAdded(nextgen.st.canvas.STNode node) {
		stParameter.getKeys()
			.forEach(stParameterKey -> stArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid()))
			.filter(stArgumentKV -> stArgumentKV.getValue()!=null)
			.forEach(stArgumentKV -> {
					final nextgen.st.model.STValue value = stArgumentKV.getValue();
					switch (value.getType()) {
						case STMODEL:
							if (node.getUuid().equals(UUID.fromString(value.getStModel().getUuid())))
								canvas.addRelation(stArgumentKV.getUuid(), canvas.newSTKVArgumentRelation(STKVNode.this, node, stArgument, stParameterKey, stArgumentKV));
							break;
						case PRIMITIVE:
							if (node.getUuid().equals(UUID.fromString(value.getUuid())))
								canvas.addRelation(stArgumentKV.getUuid(), canvas.newSTKVArgumentRelation(STKVNode.this, node, stArgument, stParameterKey, stArgumentKV));
							break;
						case ENUM:
							if (node.getUuid().equals(UUID.fromString(value.getUuid())))
								canvas.addRelation(stArgumentKV.getUuid(), canvas.newSTKVArgumentRelation(STKVNode.this, node, stArgument, stParameterKey, stArgumentKV));
							break;
					}
		}));
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
		canvas.presentationModel.doInTransaction(tx -> {
			stParameter.getKeys().forEach(stParameterKey -> {
				final JMenu stParameterMenu = new JMenu(stParameterKey.getName());
				stValueNodes.forEach(stNode -> stParameterMenu.add(new SetSTValueArgumentAction("Set " + stParameterKey.getName() + " = " + cut(stNode.getText()), STKVNode.this, canvas, event, stParameter, stParameterKey, stArgument, stNode)));
				stModelNodes.forEach(stNode -> stParameterMenu.add(new SetSTModelArgumentAction("Set " + stParameterKey.getName() + " = " + cut(stNode.getText()), STKVNode.this, canvas, event, stParameter, stParameterKey, stArgument, stNode)));
				stParameterMenu.add(new SetInputValueArgumentAction("Set " + stParameterKey.getName() + " from Input", STKVNode.this, canvas, event, stParameter, stParameterKey, stArgument));
				stParameterMenu.add(new SetClipboardValueArgumentAction("Set " + stParameterKey.getName() + " from Clipboard", STKVNode.this, canvas, event, stParameter, stParameterKey, stArgument));
				stArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid())).filter(stArgumentKV -> stArgumentKV.getValue() != null).forEach(stArgumentKV -> {
					stParameterMenu.add(new OpenArgument("Open " + stParameterKey.getName(), STKVNode.this, canvas, event, stArgument, stParameterKey, stArgumentKV));
					stParameterMenu.add(new RemoveArgument("Remove " + stParameterKey.getName(), STKVNode.this, canvas, event, stArgument, stParameterKey, stArgumentKV));
				});
				if (stParameterMenu.getMenuComponentCount() != 0) pop.add(stParameterMenu);
			});
			if (pop.getComponents().length != 0) pop.addSeparator();
		});
		pop.add(new OpenAllArguments(this, canvas, event));
		pop.addSeparator();
		super.onNodeRightClick(event, pop);
	}

	@Override
	protected void onNodeKeyPressed(PInputEvent event) {
		switch (event.getKeyCode()) {
			case java.awt.event.KeyEvent.VK_E:
				new OpenAllArguments(this, canvas, event).actionPerformed(null);
				return;

		}
		super.onNodeKeyPressed(event);
	}

	@Override
	protected void onNodeLeftClick(PInputEvent event) {
		super.onNodeLeftClick(event);
	}

	public void removeArgument(nextgen.st.domain.STParameterKey stParameterKey) {
		stArgument.getKeyValues().filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid())).findAny().ifPresent(stArgumentKV -> {
			canvas.removeRelation(UUID.fromString(stArgumentKV.getUuid()));
			stArgument.removeKeyValues(stArgumentKV);
		});
	}

	private static final class SetInputValueArgumentAction extends NodeAction<STKVNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.domain.STParameterKey stParameterKey;
		nextgen.st.model.STArgument stArgument;

		SetInputValueArgumentAction(String name, STKVNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgument stArgument) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stParameterKey = stParameterKey;
			this.stArgument = stArgument;
		}

		@Override
		void actionPerformed(STKVNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			nextgen.utils.SwingUtil.showInputDialog(stParameterKey.getName(), canvas, s -> {
				canvas.presentationModel.doLaterInTransaction(tx -> {
					final nextgen.st.model.STValue stValue = canvas.presentationModel.db.newSTValue(s);
					node.removeArgument(stParameterKey);
					final nextgen.st.model.STArgumentKV stArgumentKV = canvas.presentationModel.db.newSTArgumentKV(stParameterKey, stValue);
					node.stArgument.addKeyValues(stArgumentKV);
					canvas.addRelation(stArgumentKV.getUuid(), canvas.newSTKVArgumentRelation(node, canvas.addNode(canvas.newSTNode(stValue).get()), stArgument, stParameterKey, stArgumentKV));
				});
			});
		}
	}

	private static final class SetSTValueArgumentAction extends NodeAction<STKVNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.domain.STParameterKey stParameterKey;
		nextgen.st.model.STArgument stArgument;
		STValueNode stValueNode;

		SetSTValueArgumentAction(String name, STKVNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgument stArgument, STValueNode stValueNode) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stParameterKey = stParameterKey;
			this.stArgument = stArgument;
			this.stValueNode = stValueNode;
		}

		@Override
		void actionPerformed(STKVNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(tx -> {
				node.removeArgument(stParameterKey);
				final nextgen.st.model.STArgumentKV stArgumentKV = canvas.presentationModel.db.newSTArgumentKV(stParameterKey, stValueNode.stValue);
				node.stArgument.addKeyValues(stArgumentKV);
				canvas.addRelation(stArgumentKV.getUuid(), canvas.newSTKVArgumentRelation(node, stValueNode, stArgument, stParameterKey, stArgumentKV));
			});
		}
	}

	private static final class SetSTModelArgumentAction extends NodeAction<STKVNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.domain.STParameterKey stParameterKey;
		nextgen.st.model.STArgument stArgument;
		STModelNode stModelNode;

		SetSTModelArgumentAction(String name, STKVNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgument stArgument, STModelNode stModelNode) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stParameterKey = stParameterKey;
			this.stArgument = stArgument;
			this.stModelNode = stModelNode;
		}

		@Override
		void actionPerformed(STKVNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(tx -> {
				node.removeArgument(stParameterKey);
				final nextgen.st.model.STValue stValue = canvas.presentationModel.db.newSTValue(stModelNode.stModel);
				final nextgen.st.model.STArgumentKV stArgumentKV = canvas.presentationModel.db.newSTArgumentKV(stParameterKey, stValue);
				node.stArgument.addKeyValues(stArgumentKV);
				canvas.addRelation(stArgumentKV.getUuid(), canvas.newSTKVArgumentRelation(node, stModelNode, stArgument, stParameterKey, stArgumentKV));
			});
		}
	}

	private static final class OpenAllArguments extends NodeAction<STKVNode> {


		OpenAllArguments(STKVNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Open All", node, canvas, event);
		}

		@Override
		void actionPerformed(STKVNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(tx -> {
				node.stParameter.getKeys()
					.forEach(stParameterKey -> node.stArgument.getKeyValues()
							.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.uuid()))
							.filter(stArgumentKV -> stArgumentKV.getValue() != null)
							.findFirst()
							.ifPresent(stArgumentKV -> new OpenArgument("", node, canvas, event, node.stArgument, stParameterKey, stArgumentKV).actionPerformed(null)));
				new LayoutTreeAction(node, canvas, event).actionPerformed(null);
			});
		}
	}

	private static final class OpenArgument extends NodeAction<STKVNode> {

		nextgen.st.model.STArgument stArgument;
		nextgen.st.domain.STParameterKey stParameterKey;
		nextgen.st.model.STArgumentKV stArgumentKV;

		OpenArgument(String name, STKVNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgumentKV stArgumentKV) {
			super(name, node, canvas, event);
			this.stArgument = stArgument;
			this.stParameterKey = stParameterKey;
			this.stArgumentKV = stArgumentKV;
		}

		@Override
		void actionPerformed(STKVNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(tx -> {
				final nextgen.st.model.STValue stValue = stArgumentKV.getValue();
				switch (stValue.getType()) {
					case STMODEL:
						canvas.addNode(stValue.getStModel().getUuid(), canvas.newSTNode(stValue.getStModel()));
						canvas.addRelation(stArgumentKV.getUuid(), canvas.newSTKVArgumentRelation(node, canvas.getNode(UUID.fromString(stValue.getStModel().getUuid())), node.stArgument, stParameterKey, stArgumentKV));
						break;
					case PRIMITIVE:
						canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));
						canvas.addRelation(stArgumentKV.getUuid(), canvas.newSTKVArgumentRelation(node, canvas.getNode(UUID.fromString(stValue.getUuid())), node.stArgument, stParameterKey, stArgumentKV));
						break;
					case ENUM:
						canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));
						canvas.addRelation(stArgumentKV.getUuid(), canvas.newSTKVArgumentRelation(node, canvas.getNode(UUID.fromString(stValue.getUuid())), node.stArgument, stParameterKey, stArgumentKV));
						break;
				}
				new LayoutTreeAction(node, canvas, event).actionPerformed(null);
			});
		}
	}

	private static final class RemoveArgument extends NodeAction<STKVNode> {

		nextgen.st.model.STArgument stArgument;
		nextgen.st.domain.STParameterKey stParameterKey;
		nextgen.st.model.STArgumentKV stArgumentKV;

		RemoveArgument(String name, STKVNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgumentKV stArgumentKV) {
			super(name, node, canvas, event);
			this.stArgument = stArgument;
			this.stParameterKey = stParameterKey;
			this.stArgumentKV = stArgumentKV;
		}

		@Override
		void actionPerformed(STKVNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(tx -> {
				stArgument.removeKeyValues(stArgumentKV);
				canvas.removeRelation(java.util.UUID.fromString(stArgumentKV.getUuid()));
			});
		}
	}

	private static final class SetClipboardValueArgumentAction extends NodeAction<nextgen.st.canvas.STKVNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.domain.STParameterKey stParameterKey;
		nextgen.st.model.STArgument stArgument;

		SetClipboardValueArgumentAction(String name, nextgen.st.canvas.STKVNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STArgument stArgument) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stParameterKey = stParameterKey;
			this.stArgument = stArgument;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STKVNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(tx -> {
				final nextgen.st.model.STValue stValue = canvas.presentationModel.db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());
				node.removeArgument(stParameterKey);
				final nextgen.st.model.STArgumentKV stArgumentKV = canvas.presentationModel.db.newSTArgumentKV(stParameterKey, stValue);
				node.stArgument.addKeyValues(stArgumentKV);
				canvas.addRelation(stArgumentKV.getUuid(), canvas.newSTKVArgumentRelation(node, canvas.addNode(canvas.newSTNode(stValue).get()), stArgument, stParameterKey, stArgumentKV));
			});
		}
	}
}