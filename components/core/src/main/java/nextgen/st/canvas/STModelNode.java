package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class STModelNode extends STNode {

	nextgen.st.domain.STTemplate stTemplate;
	nextgen.st.model.STModel stModel;
	nextgen.st.STRenderer stRenderer;

	public STModelNode(STCanvas canvas, nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel stModel, nextgen.st.STRenderer stRenderer) {
		super(canvas, stTemplate.getName() + " : \n" + stRenderer.render(stModel), java.util.UUID.fromString(stModel.getUuid()));
		this.stTemplate = stTemplate;
		this.stModel = stModel;
		this.stRenderer = stRenderer;
	}

	@Override
	public void setText(String text) {
		super.setText(stTemplate.getName() + " : \n" + text);
	}

	@Override
	public void addedToCanvas() {
		canvas.getAllNodes().forEach(this::newNodeAdded);
	}

	@Override
	public void newNodeAdded(STNode node) {
		forEachArgument((stArgument, stParameter) -> {
			if (refersTo(stArgument, stParameter, node)) canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(STModelNode.this, node, stArgument, stParameter));
		});
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
		canvas.modelDb.doInTransaction(tx -> {
			
			final String clipboardValue = cut(com.generator.util.SwingUtil.fromClipboard());
			
			stTemplate.getParameters().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stParameter -> {
				
				final JMenu stParameterMenu = new JMenu(stParameter.getName());
				pop.add(stParameterMenu);
				
				switch(stParameter.getType()) {
					case SINGLE :
						{ 
							final JMenu addstParameterMenu = new JMenu("Set");
							stParameterMenu.add(addstParameterMenu);
							stValueNodes.forEach(stNode -> addstParameterMenu.add(new SetSTValueArgumentAction(cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode)));
							stModelNodes.forEach(stNode -> addstParameterMenu.add(new SetSTModelArgumentAction(cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode)));
							addstParameterMenu.add(new SetInputValueArgumentAction("From input", STModelNode.this, canvas, event, stParameter));
							addstParameterMenu.add(new SetBooleanValue("Set TRUE", STModelNode.this, canvas, event, stParameter));
							addstParameterMenu.add(new SetClipboardValueArgumentAction("From clipboard " + clipboardValue, STModelNode.this, canvas, event, stParameter));

							final JMenu openstParameterMenu = new JMenu("Open");
							stParameterMenu.add(openstParameterMenu);
							openstParameterMenu.add(new OpenAllOf("All", STModelNode.this, canvas, event, stParameter));
							
							final JMenu removestParameterMenu = new JMenu("Remove");
							stParameterMenu.add(removestParameterMenu);
							
							stModel.getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid())).forEach(stArgument -> {
								openstParameterMenu.add(new OpenArgument(cut(canvas.stRenderer.render(stArgument.getValue())), STModelNode.this, canvas, event, stParameter, stArgument));
								removestParameterMenu.add(new RemoveArgument(cut(canvas.stRenderer.render(stArgument.getValue())), STModelNode.this, canvas, event, stParameter, stArgument));
							});
							break;
						}
					case LIST :
						{ 
							final JMenu addstParameterMenu = new JMenu("Add");
							stParameterMenu.add(addstParameterMenu);
							stValueNodes.forEach(stNode -> addstParameterMenu.add(new AddSTValueArgumentAction(cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode)));
							stModelNodes.forEach(stNode -> addstParameterMenu.add(new AddSTModelArgumentAction(cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode)));
							addstParameterMenu.add(new AddInputValueArgumentAction("From input", STModelNode.this, canvas, event, stParameter));
							addstParameterMenu.add(new AddClipboardValueArgumentAction("From clipboard " + clipboardValue, STModelNode.this, canvas, event, stParameter));

							final JMenu openstParameterMenu = new JMenu("Open");
							stParameterMenu.add(openstParameterMenu);
							openstParameterMenu.add(new OpenAllOf("All", STModelNode.this, canvas, event, stParameter));
							
							final JMenu removestParameterMenu = new JMenu("Remove");
							stParameterMenu.add(removestParameterMenu);
							
							stModel.getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid())).forEach(stArgument -> {
								openstParameterMenu.add(new OpenArgument(cut(canvas.stRenderer.render(stArgument.getValue())), STModelNode.this, canvas, event, stParameter, stArgument));
								removestParameterMenu.add(new RemoveArgument(cut(canvas.stRenderer.render(stArgument.getValue())), STModelNode.this, canvas, event, stParameter, stArgument));
							});
							break;
						}
					case KVLIST :
						{
							final JMenu addstParameterMenu = new JMenu("Add");
							stParameterMenu.add(addstParameterMenu);
							addstParameterMenu.add(new AddKVInputValueArgumentAction("Add " + stParameter.getName(), STModelNode.this, canvas, event, stParameter));

							final JMenu openstParameterMenu = new JMenu("Open");
							stParameterMenu.add(openstParameterMenu);
							openstParameterMenu.add(new OpenAllOf("All", STModelNode.this, canvas, event, stParameter));
							
							final JMenu removestParameterMenu = new JMenu("Remove");
							stParameterMenu.add(removestParameterMenu);
							
							stModel.getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid())).forEach(stArgument -> {
								openstParameterMenu.add(new OpenArgument("Open " + (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST) ? stParameter.getName() : cut(canvas.stRenderer.render(stArgument.getValue()))), STModelNode.this, canvas, event, stParameter, stArgument));
								removestParameterMenu.add(new RemoveArgument("Remove " + (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST) ? stParameter.getName() : cut(canvas.stRenderer.render(stArgument.getValue()))), STModelNode.this, canvas, event, stParameter, stArgument));
							});
							break;
						}
				}
			});
		});
		pop.add(new OpenUsages(this, canvas, event));
		pop.add(new OpenAllArguments(this, canvas, event));
		pop.add(new ToClipboard(this, canvas, event));
		pop.add(new Delete(this, canvas, event));
		pop.addSeparator();
		pop.add(new Clone(this, canvas, event));
		pop.addSeparator();
		pop.add(new AddFileSink(this, canvas, event));
		pop.add(new OpenFileSink(this, canvas, event));
		pop.addSeparator();
		super.onNodeRightClick(event, pop);
	}

	@Override
	protected void onNodeKeyPressed(PInputEvent event) {
		switch (event.getKeyCode()) {
			case java.awt.event.KeyEvent.VK_W:
				new WriteToFile(this, canvas, event).actionPerformed(null);
				return;

			case java.awt.event.KeyEvent.VK_E:
				new OpenAllArguments(this, canvas, event).actionPerformed(null);
				return;

			case java.awt.event.KeyEvent.VK_D:
				new Delete(this, canvas, event).actionPerformed(null);
				return;

			case java.awt.event.KeyEvent.VK_S:
				new OpenFileSink(this, canvas, event).actionPerformed(null);
				return;

		}
		super.onNodeKeyPressed(event);
	}

	@Override
	protected void onNodeLeftClick(PInputEvent event) {
		super.onNodeLeftClick(event);
		canvas.modelDb.doInTransaction(tx -> {
			setText(stRenderer.render(stModel));
		});
	}

	@Override
	public void onNodeAdded(nextgen.st.STAppEvents.NodeAdded event){ 
		super.onNodeAdded(event);
		forEachArgument((stArgument, stParameter) -> {
			if (refersTo(stArgument, stParameter, event.node)) canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(STModelNode.this, event.node, stArgument, stParameter));
		});
	}

	protected void forEachArgument(java.util.function.BiConsumer<nextgen.st.model.STArgument, nextgen.st.domain.STParameter> consumer){ 
		stTemplate.getParameters().forEach(stParameter -> stModel.getArgumentsSorted().filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid())).forEach(stArgument -> consumer.accept(stArgument, stParameter)));
	}

	protected boolean refersTo(nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameter stParameter, nextgen.st.canvas.STNode node){ 
		if (stArgument == null || stParameter == null || node == null) return false;
		switch(stParameter.getType()) {
			case SINGLE :
				{ 
					final nextgen.st.model.STValue value = stArgument.getValue();
					if (value != null) return UUID.fromString(value.getUuid()).equals(node.getUuid()) || (value.getType().equals(nextgen.st.model.STValueType.STMODEL) && value.getStModel() != null && UUID.fromString(value.getStModel().getUuid()).equals(node.getUuid()));
					break;
				}
			case LIST :
				{ 
					final nextgen.st.model.STValue value = stArgument.getValue();
					if (value != null) return UUID.fromString(value.getUuid()).equals(node.getUuid()) || (value.getType().equals(nextgen.st.model.STValueType.STMODEL) && value.getStModel() != null && UUID.fromString(value.getStModel().getUuid()).equals(node.getUuid()));
					break;
				}
			case KVLIST :
				{ 
					if (UUID.fromString(stArgument.getUuid()).equals(node.getUuid())) return true;
					break;
				}
		}
		return false;
	}

	protected void removeArgument(nextgen.st.domain.STParameter stParameter){ 
		stModel.getArguments().filter(existing -> existing.getStParameter().equals(stParameter.uuid())).findAny().ifPresent(existing -> {
			canvas.removeRelation(UUID.fromString(existing.getUuid()));
			stModel.removeArguments(existing);
		});
	}
	private static final class OpenUsages extends NodeAction<STModelNode> {


		OpenUsages(STModelNode node, STCanvas canvas, PInputEvent event) {
			super("Open usages", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
		}
	}

	private static final class WriteToFile extends NodeAction<STModelNode> {


		WriteToFile(STModelNode node, STCanvas canvas, PInputEvent event) {
			super("Write To File", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				node.stModel.getFiles().forEach(stFile -> {
					if (stFile.getPath() == null) return;
					nextgen.st.STGenerator.writeToFile(canvas.stRenderer.render(node.stModel), stFile.getPackageName().getValue(), stFile.getName().getValue(), stFile.getType().getValue(), new java.io.File(stFile.getPath().getValue()));
				});
			});
		}
	}

	private static final class OpenAllArguments extends NodeAction<STModelNode> {


		OpenAllArguments(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Open All", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				node.forEachArgument((stArgument, stParameter) -> {
					new OpenArgument("", node, canvas, event, stParameter, stArgument).actionPerformed(null);
				});
				new LayoutTreeAction(node, canvas, event).actionPerformed(null);
			});
		}
	}

	private static final class RemoveArgument extends NodeAction<STModelNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.model.STArgument stArgument;

		RemoveArgument(String name, STModelNode node, STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STArgument stArgument) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stArgument = stArgument;
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			if (!com.generator.util.SwingUtil.showConfirmDialog(canvas, "Remove argument ?")) return;
			doLaterInTransaction(tx -> {
				canvas.removeRelation(UUID.fromString(stArgument.getUuid()));
				node.stModel.removeArguments(stArgument);
				node.setText(node.stRenderer.render(node.stModel));
			});
		}
	}

	private static final class ToClipboard extends NodeAction<STModelNode> {


		ToClipboard(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("To Clipboard", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				com.generator.util.SwingUtil.toClipboard(node.stRenderer.render(node.stModel));
			});
		}
	}

	private static final class Delete extends NodeAction<STModelNode> {


		Delete(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Delete", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			if (!com.generator.util.SwingUtil.showConfirmDialog(canvas, "Delete model ?")) return;
			doLaterInTransaction(tx -> {
				node.close();
				canvas.modelDb.remove(node.stModel);
			});
		}
	}

	private static final class Clone extends NodeAction<STModelNode> {


		Clone(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Clone", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				final nextgen.st.model.STModel clone = canvas.modelDb.clone(node.stModel);
				final STModelNode stModelNode = (STModelNode) canvas.newSTNode(clone).get();
				canvas.addNode(stModelNode);
				stModelNode.setText(stModelNode.stRenderer.render(stModelNode.stModel));
			});
		}
	}

	private static final class AddFileSink extends NodeAction<STModelNode> {


		AddFileSink(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Add File Sink", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				final java.util.LinkedHashMap<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();
				fieldMap.put("name", canvas.newTextField(canvas.modelDb.getSTModelName(node.stModel, ""), 15));
				fieldMap.put("type", canvas.newTextField(15));
				fieldMap.put("path", canvas.newTextField(15));
				fieldMap.put("package", canvas.newTextField(canvas.modelDb.getSTModelPackage(node.stModel, ""), 15));
				final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
				inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
				for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) { 
					inputPanel.add(new JLabel(fieldEntry.getKey()));
					inputPanel.add(fieldEntry.getValue());
				}
				com.generator.util.SwingUtil.showDialog(inputPanel, canvas, "New File sink", new com.generator.util.SwingUtil.ConfirmAction() {
					@Override
					public void verifyAndCommit() throws Exception {
						final String name = fieldMap.get("name").getText().trim();
						final String type = fieldMap.get("type").getText().trim();
						final String path = fieldMap.get("path").getText().trim();
						final String packageName = fieldMap.get("package").getText().trim();
						doLaterInTransaction(tx -> {
							final nextgen.st.model.STFile stFile = canvas.modelDb.newSTFile(name, type, path, packageName);
							node.stModel.addFiles(stFile);
							final STFileNode dstNode = canvas.addNode(new STFileNode(canvas, stFile, node.stModel, node.stRenderer));
							//canvas.addRelation(new STSinkRelation(canvas, node, dstNode));
							canvas.addRelation(dstNode.getUuid(), canvas.newSinkRelation(node, dstNode));
						});
					}
				});
			});
		}
	}

	private static final class OpenFileSink extends NodeAction<STModelNode> {


		OpenFileSink(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Open File Sink", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				node.stModel.getFiles().forEach(stFile -> {
					final STFileNode dstNode = (STFileNode) canvas.addNode(stFile.getUuid(), canvas.newSTNode(stFile, node.stModel));
					//canvas.addRelation(new STSinkRelation(canvas, node, dstNode));
					canvas.addRelation(dstNode.getUuid(), canvas.newSinkRelation(node, dstNode));
					new LayoutTreeAction(node, canvas, event).actionPerformed(null);
				});
			});
		}
	}

	private static final class SetBooleanValue extends NodeAction<nextgen.st.canvas.STModelNode> {

		nextgen.st.domain.STParameter stParameter;

		SetBooleanValue(String name, nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				node.removeArgument(stParameter);
				final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue("true");
				final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValue);
				node.stModel.addArguments(stArgument);
				node.setText(node.stRenderer.render(node.stModel));
			});
		}
	}

	private static final class SetInputValueArgumentAction extends NodeAction<nextgen.st.canvas.STModelNode> {

		nextgen.st.domain.STParameter stParameter;

		SetInputValueArgumentAction(String name, nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			final String s = com.generator.util.SwingUtil.showInputDialog(stParameter.getName(), canvas);
			if (s == null || s.trim().length() == 0) return;
			doLaterInTransaction(tx -> {
				node.removeArgument(stParameter);
				final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s.trim());
				final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValue);
				node.stModel.addArguments(stArgument);
				canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));
				//canvas.addRelation(new STArgumentRelation(canvas, node, canvas.getNode(stValue.getUuid()), stArgument, stParameter));
				canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, canvas.getNode(stValue.getUuid()), stArgument, stParameter));
				node.setText(node.stRenderer.render(node.stModel));
			});
		}
	}

	private static final class SetClipboardValueArgumentAction extends NodeAction<nextgen.st.canvas.STModelNode> {

		nextgen.st.domain.STParameter stParameter;

		SetClipboardValueArgumentAction(String name, nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			final String s = com.generator.util.SwingUtil.fromClipboard();
			if (s == null || s.trim().length() == 0) return;
			doLaterInTransaction(tx -> {
				node.removeArgument(stParameter);
				final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s.trim());
				final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValue);
				node.stModel.addArguments(stArgument);
				canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));
				//canvas.addRelation(new STArgumentRelation(canvas, node, canvas.getNode(stValue.getUuid()), stArgument, stParameter));
				canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, canvas.getNode(stValue.getUuid()), stArgument, stParameter));
				node.setText(node.stRenderer.render(node.stModel));
			});
		}
	}

	private static final class SetSTValueArgumentAction extends NodeAction<nextgen.st.canvas.STModelNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.canvas.STValueNode stValueNode;

		SetSTValueArgumentAction(String name, nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.canvas.STValueNode stValueNode) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stValueNode = stValueNode;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				node.removeArgument(stParameter);
				final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValueNode.stValue);
				node.stModel.addArguments(stArgument);
				// canvas.addRelation(new STArgumentRelation(canvas, node, stValueNode, stArgument, stParameter));
				canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stValueNode, stArgument, stParameter));
				node.setText(node.stRenderer.render(node.stModel));
			});
		}
	}

	private static final class SetSTModelArgumentAction extends NodeAction<nextgen.st.canvas.STModelNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.canvas.STModelNode stModelNode;

		SetSTModelArgumentAction(String name, nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.canvas.STModelNode stModelNode) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stModelNode = stModelNode;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				node.removeArgument(stParameter);
				final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(stModelNode.stModel);
				final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValue);
				node.stModel.addArguments(stArgument);
				//canvas.addRelation(new STArgumentRelation(canvas, node, stModelNode, stArgument, stParameter));
				canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stModelNode, stArgument, stParameter));
				node.setText(node.stRenderer.render(node.stModel));
			});
		}
	}

	private static final class AddInputValueArgumentAction extends NodeAction<nextgen.st.canvas.STModelNode> {

		nextgen.st.domain.STParameter stParameter;

		AddInputValueArgumentAction(String name, nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			final String s = com.generator.util.SwingUtil.showInputDialog(stParameter.getName(), canvas);
			if (s == null || s.trim().length() == 0) return;
			doLaterInTransaction(tx -> {
				final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s.trim());
				final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValue);
				node.stModel.addArguments(stArgument);
				final STNode stValueNode = canvas.addNode(canvas.newSTNode(stValue).get());
				// canvas.addRelation(new STArgumentRelation(canvas, node, stValueNode, stArgument, stParameter));
				canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stValueNode, stArgument, stParameter));
				node.setText(node.stRenderer.render(node.stModel));
			});
		}
	}

	private static final class AddClipboardValueArgumentAction extends NodeAction<nextgen.st.canvas.STModelNode> {

		nextgen.st.domain.STParameter stParameter;

		AddClipboardValueArgumentAction(String name, nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			final String s = com.generator.util.SwingUtil.fromClipboard();
			if (s == null || s.trim().length() == 0) return;
			doLaterInTransaction(tx -> {
				final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s.trim());
				final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValue);
				node.stModel.addArguments(stArgument);
				final STNode stValueNode = canvas.addNode(canvas.newSTNode(stValue).get());
				//canvas.addRelation(new STArgumentRelation(canvas, node, stValueNode, stArgument, stParameter));
				canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stValueNode, stArgument, stParameter));
				node.setText(node.stRenderer.render(node.stModel));
			});
		}
	}

	private static final class AddSTValueArgumentAction extends NodeAction<nextgen.st.canvas.STModelNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.canvas.STValueNode stValueNode;

		AddSTValueArgumentAction(String name, nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.canvas.STValueNode stValueNode) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stValueNode = stValueNode;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValueNode.stValue);
				node.stModel.addArguments(stArgument);
				//canvas.addRelation(new STArgumentRelation(canvas, node, stValueNode, stArgument, stParameter));
				canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stValueNode, stArgument, stParameter));
				node.setText(node.stRenderer.render(node.stModel));
			});
		}
	}

	private static final class AddSTModelArgumentAction extends NodeAction<nextgen.st.canvas.STModelNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.canvas.STModelNode stModelNode;

		AddSTModelArgumentAction(String name, nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.canvas.STModelNode stModelNode) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stModelNode = stModelNode;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(stModelNode.stModel);
				final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, stValue);
				node.stModel.addArguments(stArgument);
				//canvas.addRelation(new STArgumentRelation(canvas, node, stModelNode, stArgument, stParameter));
				canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stModelNode, stArgument, stParameter));
				node.setText(node.stRenderer.render(node.stModel));
			});
		}
	}

	private static final class AddKVInputValueArgumentAction extends NodeAction<nextgen.st.canvas.STModelNode> {

		nextgen.st.domain.STParameter stParameter;

		AddKVInputValueArgumentAction(String name, nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			final Map<nextgen.st.domain.STParameterKey, JTextField> fieldMap = new LinkedHashMap<>();
			doLaterInTransaction(tx -> {
				stParameter.getKeys().forEach(stParameterKey -> fieldMap.put(stParameterKey, canvas.newTextField(15)));
				final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
				inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
				for (Map.Entry<nextgen.st.domain.STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {
					inputPanel.add(new JLabel(fieldEntry.getKey().getName()));
					inputPanel.add(fieldEntry.getValue());
				}
				com.generator.util.SwingUtil.showDialog(inputPanel, canvas, stParameter.getName(), new com.generator.util.SwingUtil.ConfirmAction() {
					@Override
					public void verifyAndCommit() throws Exception {
						doLaterInTransaction(tx -> {
							final java.util.List<nextgen.st.model.STArgumentKV> kvs = new ArrayList<>();
							for (Map.Entry<nextgen.st.domain.STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {
								final String value = fieldEntry.getValue().getText().trim();
								if (value.length() == 0) continue;
								kvs.add(canvas.modelDb.newSTArgumentKV(fieldEntry.getKey(), canvas.modelDb.newSTValue(value)));
							}
							final nextgen.st.model.STArgument stArgument = canvas.modelDb.newSTArgument(stParameter, kvs);
							node.stModel.addArguments(stArgument);
							final STNode stkvNode = canvas.addNode(canvas.newSTNode(stParameter, stArgument).get());
							// canvas.addRelation(new STArgumentRelation(canvas, node, stkvNode, stArgument, stParameter));
							canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stkvNode, stArgument, stParameter));
							node.setText(node.stRenderer.render(node.stModel));
						});
					}
				});
			});
		}
	}

	private static final class OpenArgument extends NodeAction<STModelNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.model.STArgument stArgument;

		OpenArgument(String name, STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STArgument stArgument) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stArgument = stArgument;
		}

		@Override
		void actionPerformed(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				if (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST)) {
					final STNode dstNode = canvas.addNode(stArgument.getUuid(), canvas.newSTNode(stParameter, stArgument));
					//canvas.addRelation(new STArgumentRelation(canvas, node, dstNode, stArgument, stParameter));
					canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, dstNode, stArgument, stParameter));
				} else {
					final nextgen.st.model.STValue stValue = stArgument.getValue();
					switch(stValue.getType()) {
						case STMODEL :
						{
							final STNode dstNode = canvas.addNode(stValue.getStModel().getUuid(), canvas.newSTNode(stValue.getStModel()));
							//canvas.addRelation(new STArgumentRelation(canvas, node, dstNode, stArgument, stParameter));
							canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, dstNode, stArgument, stParameter));
							break;
						}
						case PRIMITIVE :
						{
							final STNode dstNode = canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));
							//canvas.addRelation(new STArgumentRelation(canvas, node, dstNode, stArgument, stParameter));
							canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, dstNode, stArgument, stParameter));
							
							break;
						}
						case ENUM :
						{
							final STNode dstNode = canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));
							//canvas.addRelation(new STArgumentRelation(canvas, node, dstNode, stArgument, stParameter));
							canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, dstNode, stArgument, stParameter));
							
							break;
						}
					}
				}
				new LayoutTreeAction(node, canvas, event).actionPerformed(null);
			});
		}
	}

	private static final class OpenAllOf extends NodeAction<STModelNode> {

		nextgen.st.domain.STParameter stParameter;

		OpenAllOf(String name, STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
		}

		@Override
		void actionPerformed(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				node.forEachArgument((stArgument, stParameter) -> {
					if (this.stParameter.equals(stParameter))
						new OpenArgument("", node, canvas, event, stParameter, stArgument).actionPerformed(null);
				});
				new LayoutTreeAction(node, canvas, event).actionPerformed(null);
			});
		}
	}
}