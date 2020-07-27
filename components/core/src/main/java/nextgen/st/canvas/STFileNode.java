package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class STFileNode extends nextgen.st.canvas.STNode {

	nextgen.st.model.STFile stFile;
	nextgen.st.model.STModel stModel;

	public STFileNode(STCanvas canvas, nextgen.st.model.STFile stFile, nextgen.st.model.STModel stModel) {
		super(canvas, nextgen.st.STGenerator.asFile(stFile).getAbsolutePath(), java.util.UUID.fromString(stFile.getUuid()));
		this.stFile = stFile;
		this.stModel = stModel;
	}

	@Override
	public void addedToCanvas() {
		canvas.getAllNodes()
				.filter(stNode -> stNode instanceof STModelNode)
				.map(stNode -> (STModelNode) stNode)
				.filter(stModelNode -> stModelNode.stModel.getUuid().equals(stModel.getUuid()))
				.findAny()
				.ifPresent(stModelNode -> canvas.addRelation(getUuid(), canvas.newSinkRelation(stModelNode, STFileNode.this)));
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
		final java.util.List<STValueNode> stValueNodes = canvas.getSelectedNodes()
				.filter(stNode -> stNode instanceof STValueNode)
				.filter(stNode -> !stNode.getUuid().equals(getUuid()))
				.map(stNode -> (STValueNode) stNode)
				.collect(java.util.stream.Collectors.toList());
		canvas.presentationModel.db.doInTransaction(tx -> {
			final JMenu sourceMenu = new JMenu("STModels");
			stModelNodes.forEach(stModelNode -> {
				final int end = Math.min(stModelNode.getText().length(), 50);
				sourceMenu.add(new SetSource("Set source to " + stModelNode.getText().substring(0, end), STFileNode.this, canvas, event, stModelNode));
			});
			if (!stModelNodes.isEmpty())
				pop.add(sourceMenu);

			final JMenu setNameMenu = new JMenu("Set Name");
			final JMenu setPathMenu = new JMenu("Set Path");
			final JMenu setTypeMenu = new JMenu("Set Type");
			final JMenu setPackageName = new JMenu("Set Package name");
			stValueNodes.stream().filter(stNode -> stNode.stValue.getType().equals(nextgen.st.model.STValueType.PRIMITIVE)).forEach(stValueNode -> {
				setPathMenu.add(new SetPathTo(stValueNode.stValue.getValue(), STFileNode.this, canvas, event, stValueNode.stValue));
				setNameMenu.add(new SetNameTo(stValueNode.stValue.getValue(), STFileNode.this, canvas, event, stValueNode.stValue));
				setPackageName.add(new SetPackageNameTo(stValueNode.stValue.getValue(), STFileNode.this, canvas, event, stValueNode.stValue));
				setTypeMenu.add(new SetTypeTo(stValueNode.stValue.getValue(), STFileNode.this, canvas, event, stValueNode.stValue));
			});
			if (setNameMenu.getMenuComponentCount() != 0) {
				pop.add(setNameMenu);
				pop.add(setPathMenu);
				pop.add(setTypeMenu);
				pop.add(setPackageName);
			}
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
			if (stModel == null || stFile.getPath() == null) return;
			nextgen.st.STGenerator.writeToFile(canvas.presentationModel.render(stModel), stFile.getPackageName().getValue(), stFile.getName().getValue(), stFile.getType().getValue(), new java.io.File(stFile.getPath().getValue()));
		});
	}

	private static final class EditFileSink extends NodeAction<STFileNode> {


		EditFileSink(STFileNode node, STCanvas canvas, PInputEvent event) {
			super("Edit", node, canvas, event);
		}

		@Override
		void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.db.doInTransaction(tx -> {
				final java.util.LinkedHashMap<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();
				fieldMap.put("name", canvas.newTextField(node.stFile.getName() == null ? "" : node.stFile.getName().getValue(), 15));
				fieldMap.put("type", canvas.newTextField(node.stFile.getType() == null ? "" : node.stFile.getType().getValue(), 15));
				fieldMap.put("path", canvas.newTextField(node.stFile.getPath() == null ? "" : node.stFile.getPath().getValue(), 15));
				fieldMap.put("package", canvas.newTextField(node.stFile.getPackageName() == null ? "" : node.stFile.getPackageName().getValue(), 15));
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

								if (node.stFile.getName() == null || (node.stFile.getName().getValue() == null || !node.stFile.getName().getValue().equals(name)))
									node.stFile.setName(canvas.presentationModel.db.newSTValue(name));

								if (node.stFile.getType() == null || (node.stFile.getType().getValue() == null || !node.stFile.getType().getValue().equals(type)))
									node.stFile.setType(canvas.presentationModel.db.newSTValue(type));

								if (node.stFile.getPath() == null || (node.stFile.getPath().getValue() == null || !node.stFile.getPath().getValue().equals(path)))
									node.stFile.setPath(canvas.presentationModel.db.newSTValue(path));

								if (node.stFile.getPackageName() == null || (node.stFile.getPackageName().getValue() == null || !node.stFile.getPackageName().getValue().equals(packageName)))
									node.stFile.setPackageName(canvas.presentationModel.db.newSTValue(packageName));

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
			doLaterInTransaction(transaction -> {
				node.stFile.setPath(stValue);
				node.setText(nextgen.st.STGenerator.asFile(node.stFile).getAbsolutePath());				
			});
		}
	}

	private static final class SetNameTo extends NodeAction<STFileNode> {

		nextgen.st.model.STValue stValue;

		SetNameTo(String name, STFileNode node, STCanvas canvas, PInputEvent event, nextgen.st.model.STValue stValue) {
			super(name, node, canvas, event);
			this.stValue = stValue;
		}

		@Override
		void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(transaction -> {
				node.stFile.setName(stValue);
				node.setText(nextgen.st.STGenerator.asFile(node.stFile).getAbsolutePath());				
			});
		}
	}

	private static final class SetTypeTo extends NodeAction<STFileNode> {

		nextgen.st.model.STValue stValue;

		SetTypeTo(String name, STFileNode node, STCanvas canvas, PInputEvent event, nextgen.st.model.STValue stValue) {
			super(name, node, canvas, event);
			this.stValue = stValue;
		}

		@Override
		void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(transaction -> {
				node.stFile.setType(stValue);
				node.setText(nextgen.st.STGenerator.asFile(node.stFile).getAbsolutePath());				
			});
		}
	}

	private static final class SetPackageNameTo extends NodeAction<STFileNode> {

		nextgen.st.model.STValue stValue;

		SetPackageNameTo(String name, STFileNode node, STCanvas canvas, PInputEvent event, nextgen.st.model.STValue stValue) {
			super(name, node, canvas, event);
			this.stValue = stValue;
		}

		@Override
		void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			doLaterInTransaction(transaction -> {
				node.stFile.setPackageName(stValue);
				node.setText(nextgen.st.STGenerator.asFile(node.stFile).getAbsolutePath());				
			});
		}
	}
}