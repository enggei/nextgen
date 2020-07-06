package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.stream.Stream;

public class STFileNode extends STNode {

	nextgen.st.model.STFile stFile;
	nextgen.st.model.STModel stModel;
	nextgen.st.STRenderer stRenderer;

	public STFileNode(STCanvas canvas, nextgen.st.model.STFile stFile, nextgen.st.model.STModel stModel, nextgen.st.STRenderer stRenderer) {
		super(canvas, nextgen.st.STGenerator.asFile(stFile).getAbsolutePath(), java.util.UUID.fromString(stFile.getUuid()));
		this.stFile = stFile;
		this.stModel = stModel;
		this.stRenderer = stRenderer;
	}

	public void setSTModel(nextgen.st.model.STModel stModel) {
		javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
			this.stModel = stModel;
			this.stModel.setFile(stFile);
			setText(nextgen.st.STGenerator.asFile(stFile).getAbsolutePath());
		}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
	}

	@Override
	public Stream<UUID> getOutgoingReferences() {
		return java.util.stream.Stream.of(UUID.fromString(stModel.getUuid()));
	}

	@Override
	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
		final java.util.List<STModelNode> stModelNodes = canvas.getSelectedNodes()
				.filter(stNode -> stNode instanceof STModelNode)
				.filter(stNode -> !stNode.getUuid().equals(getUuid()))
				.map(stNode -> (STModelNode) stNode)
				.collect(java.util.stream.Collectors.toList());
		javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
			final JMenu sourceMenu = new JMenu("STModels");
			stModelNodes.forEach(stNode -> {
				final int end = Math.min(stNode.getText().length(), 50);
				sourceMenu.add(new STNode.NodeAction<STFileNode>("Set source to " + stNode.getText().substring(0, end), this, canvas, event) {
					@Override
					void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
						node.setSTModel(stNode.stModel);
					}
				});
			});
			pop.add(sourceMenu);
		}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		pop.add(new EditFileSink(this, canvas, event));
		pop.add(new OpenFile(this, canvas, event));
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
		javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
			if (stRenderer == null || stModel == null) return;
			nextgen.st.STGenerator.writeToFile(stRenderer.render(stModel), stFile.getPackageName(), stFile.getName(), stFile.getType(), new java.io.File(stFile.getPath()));
		}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
	}

	private static final class EditFileSink extends NodeAction<STFileNode> {


		EditFileSink(STFileNode node, STCanvas canvas, PInputEvent event) {
			super("Edit", node, canvas, event);
		}

		@Override
		void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.modelDb.doInTransaction(tx -> {
				final Map<String, JTextField> fieldMap = new java.util.LinkedHashMap<>();
				fieldMap.put("name", new JTextField(node.stFile.getName(), 15));
				fieldMap.put("type", new JTextField(node.stFile.getType(), 15));
				fieldMap.put("path", new JTextField(node.stFile.getPath(), 15));
				fieldMap.put("package", new JTextField(node.stFile.getPackageName(), 15));
				final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
				inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
				for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) {
					inputPanel.add(new JLabel(fieldEntry.getKey()));
					inputPanel.add(fieldEntry.getValue());
				}
				com.generator.util.SwingUtil.showDialog(inputPanel, canvas, "Edit", new com.generator.util.SwingUtil.ConfirmAction() {
					@Override
					public void verifyAndCommit() throws Exception {
						final String name = fieldMap.get("name").getText().trim();
						final String type = fieldMap.get("type").getText().trim();
						final String path = fieldMap.get("path").getText().trim();
						final String packageName = fieldMap.get("package").getText().trim();
						javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
							node.stFile.setName(name);
							node.stFile.setType(type);
							node.stFile.setPath(path);
							node.stFile.setPackageName(packageName);
							node.setText(nextgen.st.STGenerator.asFile(node.stFile).getAbsolutePath());
						}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
					}
				});
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable));
		}
	}

	private static final class OpenFile extends NodeAction<STFileNode> {


		OpenFile(STFileNode node, STCanvas canvas, PInputEvent event) {
			super("Open", node, canvas, event);
		}

		@Override
		void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			javax.swing.SwingUtilities.invokeLater(() -> canvas.modelDb.doInTransaction(tx -> {
				try {
					java.awt.Desktop.getDesktop().open(nextgen.st.STGenerator.asFile(node.stFile));
				} catch (Exception ex) { com.generator.util.SwingUtil.showException(canvas, ex); }
			}, throwable -> com.generator.util.SwingUtil.showExceptionNoStack(canvas, throwable)));
		}
	}
}