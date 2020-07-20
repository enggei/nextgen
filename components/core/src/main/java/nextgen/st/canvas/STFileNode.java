package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class STFileNode extends nextgen.st.canvas.STNode {

	nextgen.st.model.STFile stFile;
	nextgen.st.model.STModel stModel;
	nextgen.st.STRenderer stRenderer;

	public STFileNode(STCanvas canvas, nextgen.st.model.STFile stFile, nextgen.st.model.STModel stModel, nextgen.st.STRenderer stRenderer) {
		super(canvas, nextgen.st.STGenerator.asFile(stFile).getAbsolutePath(), java.util.UUID.fromString(stFile.getUuid()));
		this.stFile = stFile;
		this.stModel = stModel;
		this.stRenderer = stRenderer;
	}

	@Override
	public void addedToCanvas() {
	}

	@Override
	public void newNodeAdded(nextgen.st.canvas.STNode node) {
	}

	@Override
	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
		final java.util.List<STModelNode> stModelNodes = canvas.getSelectedNodes()
		                .filter(stNode -> stNode instanceof STModelNode)
		                .filter(stNode -> !stNode.getUuid().equals(getUuid()))
		                .map(stNode -> (STModelNode) stNode)
		                .collect(java.util.stream.Collectors.toList());
		doLaterInTransaction(tx -> {
		            final JMenu sourceMenu = new JMenu("STModels");
		            stModelNodes.forEach(stModelNode -> {
		                final int end = Math.min(stModelNode.getText().length(), 50);
		                sourceMenu.add(new SetSource("Set source to " + stModelNode.getText().substring(0, end), STFileNode.this, canvas, event, stModelNode));
		            });
		            pop.add(sourceMenu);
		        });
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
		doLaterInTransaction(tx -> {
		            if (stRenderer == null || stModel == null || stFile.getPath() == null) return;
		            nextgen.st.STGenerator.writeToFile(stRenderer.render(stModel), stFile.getPackageName(), stFile.getName(), stFile.getType(), new java.io.File(stFile.getPath()));
		        });
	}

	private static final class EditFileSink extends NodeAction<STFileNode> {


		EditFileSink(STFileNode node, STCanvas canvas, PInputEvent event) {
			super("Edit", node, canvas, event);
		}

		@Override
		void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.modelDb.doInTransaction(tx -> {
				final java.util.LinkedHashMap<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();
				fieldMap.put("name", canvas.newTextField(node.stFile.getName(), 15));
				fieldMap.put("type", canvas.newTextField(node.stFile.getType(), 15));
				fieldMap.put("path", canvas.newTextField(node.stFile.getPath(), 15));
				fieldMap.put("package", canvas.newTextField(node.stFile.getPackageName(), 15));
				final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
				inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
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
							doLaterInTransaction(tx -> {
								node.stFile.setName(name);
								node.stFile.setType(type);
								node.stFile.setPath(path);
								node.stFile.setPackageName(packageName);
								node.setText(nextgen.st.STGenerator.asFile(node.stFile).getAbsolutePath());
							});
					}
				});
			});
		}
	}

	private static final class OpenFile extends NodeAction<STFileNode> {


		OpenFile(STFileNode node, STCanvas canvas, PInputEvent event) {
			super("Open", node, canvas, event);
		}

		@Override
		void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				try {
					java.awt.Desktop.getDesktop().open(nextgen.st.STGenerator.asFile(node.stFile));
				} catch (Exception ex) {
					com.generator.util.SwingUtil.showException(canvas, ex);
				}
			});
		}
	}

	private static final class SetSource extends NodeAction<STFileNode> {

		STModelNode stModelNode;

		SetSource(String name, STFileNode node, STCanvas canvas, PInputEvent event, STModelNode stModelNode) {
			super(name, node, canvas, event);
			this.stModelNode = stModelNode;
		}

		@Override
		void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(tx -> {
				if (node.stModel != null) canvas.removeRelation(node.getUuid());
				node.stModel = stModelNode.stModel;
				node.stModel.addFiles(node.stFile);
				canvas.addRelation(node.getUuid(), canvas.newSinkRelation(stModelNode, node));
				node.setText(nextgen.st.STGenerator.asFile(node.stFile).getAbsolutePath());
			});
		}
	}

	private static final class SetPathTo extends NodeAction<STFileNode> {

		nextgen.st.model.STValue stValue;

		SetPathTo(String name, STFileNode node, STCanvas canvas, PInputEvent event, nextgen.st.model.STValue stValue) {
			super(name, node, canvas, event);
			this.stValue = stValue;
		}

		@Override
		void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
		}
	}
}