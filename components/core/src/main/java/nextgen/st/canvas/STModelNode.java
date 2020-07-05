package nextgen.st.canvas;

import com.generator.util.SwingUtil;
import nextgen.st.domain.STParameterKey;
import nextgen.st.model.STArgumentKV;
import nextgen.st.model.STValue;
import nextgen.st.model.STValueType;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class STModelNode extends STNode {

	nextgen.st.domain.STTemplate stTemplate;
	nextgen.st.model.STModel stModel;
	nextgen.st.STRenderer stRenderer;

	public STModelNode(STCanvas canvas, nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel stModel, nextgen.st.STRenderer stRenderer) {
		super(canvas, stRenderer.render(stModel), java.util.UUID.fromString(stModel.getUuid()));
		this.stTemplate = stTemplate;
		this.stModel = stModel;
		this.stRenderer = stRenderer;
	}

	public String cut(String text) {
		return text.substring(0, Math.min(text.length(), 20));
	}

	@Override
	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
		final java.util.List<STValueNode> stValueNodes = canvas.getSelectedNodes()
				.filter(stNode -> stNode instanceof STValueNode)
				.filter(stNode -> !stNode.getUuid().equals(getUuid()))
				.map(stNode -> (STValueNode) stNode)
				.collect(Collectors.toList());
		final java.util.List<STModelNode> stModelNodes = canvas.getSelectedNodes()
				.filter(stNode -> stNode instanceof STModelNode)
				.filter(stNode -> !stNode.getUuid().equals(getUuid()))
				.map(stNode -> (STModelNode) stNode)
				.collect(Collectors.toList());
		canvas.modelDb.doInTransaction(tx -> {
			stTemplate.getParameters().forEach(stParameter -> {
				final JMenu stParameterMenu = new JMenu(stParameter.getName());
				switch (stParameter.getType()) {
					case SINGLE: {
						stParameterMenu.add(new SetInputValueArgumentAction("Set " + stParameter.getName(), STModelNode.this, canvas, event, stParameter));
						stValueNodes.forEach(stNode -> {
							stParameterMenu.add(new SetSTValueArgumentAction("Set " + stParameter.getName() + " = " + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode.stValue));
						});
						stModelNodes.forEach(stNode -> {
							stParameterMenu.add(new SetSTModelArgumentAction("Set " + stParameter.getName() + " = " + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode.stModel));
						});
						break;
					}
					case LIST: {
						stParameterMenu.add(new AddInputValueArgumentAction("Add " + stParameter.getName(), STModelNode.this, canvas, event, stParameter));
						stValueNodes.forEach(stNode -> {
							stParameterMenu.add(new AddSTValueArgumentAction("Add " + stParameter.getName() + " = " + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode.stValue));
						});
						stModelNodes.forEach(stNode -> {
							stParameterMenu.add(new AddSTModelArgumentAction("Add " + stParameter.getName() + " = " + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode.stModel));
						});
						break;
					}
					case KVLIST: {
						stParameterMenu.add(new AddKVInputValueArgumentAction("Add " + stParameter.getName(), STModelNode.this, canvas, event, stParameter));
						break;
					}
				}
				if (stParameterMenu.getMenuComponentCount() != 0) pop.add(stParameterMenu);
			});
			final JMenu open = new JMenu("Open");
			final JMenu remove = new JMenu("Remove");
			stModel.getArguments().forEach(stArgument -> {
				open.add(new OpenArgument(STModelNode.this, canvas, event, stArgument));
				remove.add(new RemoveArgument(STModelNode.this, canvas, event, stArgument));
			});
			if (open.getMenuComponentCount() != 0) pop.add(open);
			if (remove.getMenuComponentCount() != 0) pop.add(remove);
		});
		pop.add(new ToClipboard(this, canvas, event));
		pop.add(new Delete(this, canvas, event));
		pop.add(new AddFileSink(this, canvas, event));
		pop.add(new OpenFileSink(this, canvas, event));
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
		canvas.modelDb.doInTransaction(tx -> {
			setText(stRenderer.render(stModel));
		});
	}

	private static final class SetInputValueArgumentAction extends NodeAction<STModelNode> {

		nextgen.st.domain.STParameter stParameter;

		SetInputValueArgumentAction(String name, STModelNode node, STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			final String s = SwingUtil.showInputDialog(stParameter.getName(), canvas);
			if (s == null || s.trim().length() == 0) return;
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s.trim());
				canvas.modelDb.setArgument(node.stModel, stParameter, stValue);
				node.setText(node.stRenderer.render(node.stModel));
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}

	private static final class SetSTValueArgumentAction extends NodeAction<STModelNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.model.STValue stValue;

		SetSTValueArgumentAction(String name, STModelNode node, STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STValue stValue) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stValue = stValue;
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				canvas.modelDb.setArgument(node.stModel, stParameter, stValue);
				node.setText(node.stRenderer.render(node.stModel));
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}

	private static final class SetSTModelArgumentAction extends NodeAction<STModelNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.model.STModel stModel;

		SetSTModelArgumentAction(String name, STModelNode node, STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STModel stModel) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stModel = stModel;
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				canvas.modelDb.setArgument(node.stModel, stParameter, stModel);
				node.setText(node.stRenderer.render(node.stModel));
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}

	private static final class AddInputValueArgumentAction extends NodeAction<STModelNode> {

		nextgen.st.domain.STParameter stParameter;

		AddInputValueArgumentAction(String name, STModelNode node, STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			final String s = SwingUtil.showInputDialog(stParameter.getName(), canvas);
			if (s == null || s.trim().length() == 0) return;
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				final nextgen.st.model.STValue stValue = canvas.modelDb.newSTValue(s.trim());
				canvas.modelDb.addArgument(node.stModel, stParameter, stValue);
				node.setText(node.stRenderer.render(node.stModel));
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}

	private static final class AddSTValueArgumentAction extends NodeAction<STModelNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.model.STValue stValue;

		AddSTValueArgumentAction(String name, STModelNode node, STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STValue stValue) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stValue = stValue;
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				canvas.modelDb.addArgument(node.stModel, stParameter, stValue);
				node.setText(node.stRenderer.render(node.stModel));
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}

	private static final class AddSTModelArgumentAction extends NodeAction<STModelNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.model.STModel stModel;

		AddSTModelArgumentAction(String name, STModelNode node, STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STModel stModel) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stModel = stModel;
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				canvas.modelDb.addArgument(node.stModel, stParameter, stModel);
				node.setText(node.stRenderer.render(node.stModel));
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}

	private static final class AddKVInputValueArgumentAction extends NodeAction<STModelNode> {

		nextgen.st.domain.STParameter stParameter;

		AddKVInputValueArgumentAction(String name, STModelNode node, STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			final Map<STParameterKey, JTextField> fieldMap = new LinkedHashMap<>();
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				stParameter.getKeys().forEach(stParameterKey -> fieldMap.put(stParameterKey, new JTextField(15)));
				final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
				inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
				for (Map.Entry<STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {
					inputPanel.add(new JLabel(fieldEntry.getKey().getName()));
					inputPanel.add(fieldEntry.getValue());
				}
				SwingUtil.showDialog(inputPanel, canvas, stParameter.getName(), new SwingUtil.ConfirmAction() {
					@Override
					public void verifyAndCommit() throws Exception {
						final Collection<STArgumentKV> kvs = new ArrayList<>();
						for (Map.Entry<STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {
							final String value = fieldEntry.getValue().getText().trim();
							if (value.length() == 0) continue;
							kvs.add(canvas.modelDb.newSTArgumentKV(fieldEntry.getKey(),canvas.modelDb.newSTValue(value)));
						}
						canvas.modelDb.addArgument(node.stModel, stParameter, kvs);
						node.setText(node.stRenderer.render(node.stModel));
					}
				});
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}

	private static final class OpenArgument extends NodeAction<STModelNode> {

		nextgen.st.model.STArgument stArgument;

		OpenArgument(STModelNode node, STCanvas canvas, PInputEvent event, nextgen.st.model.STArgument stArgument) {
			super("Open", node, canvas, event);
			this.stArgument = stArgument;
			final String s = node.stRenderer.render(stArgument).toString();
			final int end = Math.min(s.length(), 50);
			setName("Open " + s.substring(0, end));
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				final STValue stValue = stArgument.getValue();
				switch (stValue.getType()) {
					case STMODEL: {
						final nextgen.st.model.STModel stModel = stValue.getStModel();
						canvas.addNode(new STModelNode(canvas, canvas.modelDb.findSTTemplateByUuid(stModel.getStTemplate()), stModel, node.stRenderer));
						break;
					}
					case PRIMITIVE: {
						canvas.addNode(new STValueNode(canvas, stValue, node.stRenderer));
						break;
					}
					case ENUM: {
						canvas.addNode(new STValueNode(canvas, stValue, node.stRenderer));
						break;
					}
				}
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}

	private static final class RemoveArgument extends NodeAction<STModelNode> {

		nextgen.st.model.STArgument stArgument;

		RemoveArgument(STModelNode node, STCanvas canvas, PInputEvent event, nextgen.st.model.STArgument stArgument) {
			super("Remove", node, canvas, event);
			this.stArgument = stArgument;
			final String s = node.stRenderer.render(stArgument).toString();
			final int end = Math.min(s.length(), 50);
			setName("Remove " + s.substring(0, end));
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				node.stModel.removeArguments(stArgument);
				node.setText(node.stRenderer.render(node.stModel));
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}

	private static final class ToClipboard extends NodeAction<STModelNode> {


		ToClipboard(STModelNode node, STCanvas canvas, PInputEvent event) {
			super("To Clipboard", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				com.generator.util.SwingUtil.toClipboard(node.stRenderer.render(node.stModel));
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}

	private static final class Delete extends NodeAction<STModelNode> {


		Delete(STModelNode node, STCanvas canvas, PInputEvent event) {
			super("Delete", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				canvas.modelDb.remove(node.stModel);
				canvas.removeNode(node.getUuid());
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}

	private static final class AddFileSink extends NodeAction<STModelNode> {


		AddFileSink(STModelNode node, STCanvas canvas, PInputEvent event) {
			super("Add File Sink", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.modelDb.doInTransaction(tx -> {
				final Map<String, JTextField> fieldMap = new java.util.LinkedHashMap<>();
				fieldMap.put("name", new JTextField(canvas.modelDb.getSTModelName(node.stModel, ""), 15));
				fieldMap.put("type", new JTextField(15));
				fieldMap.put("path", new JTextField(15));
				fieldMap.put("package", new JTextField(canvas.modelDb.getSTModelPackage(node.stModel, ""), 15));
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
						javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
							final nextgen.st.model.STFile stFile = canvas.modelDb.newSTFile(name, type, path, packageName);
							node.stModel.setFile(stFile);
							canvas.addNode(new STFileNode(canvas, stFile, node.stModel, node.stRenderer));
						}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
					}
				});
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable));
		}
	}

	private static final class OpenFileSink extends NodeAction<STModelNode> {


		OpenFileSink(STModelNode node, STCanvas canvas, PInputEvent event) {
			super("Open File Sink", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				final nextgen.st.model.STFile stFile = node.stModel.getFile();
				if (stFile == null) return;
				canvas.addNode(new STFileNode(canvas, stFile, node.stModel, node.stRenderer));
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}
}