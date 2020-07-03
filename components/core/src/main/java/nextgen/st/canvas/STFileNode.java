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

import static nextgen.st.STModelPatterns.*;

public class STFileNode extends STNode {

	nextgen.st.model.STFile stFile;
	nextgen.st.model.STModel stModel;
	nextgen.st.STRenderer stRenderer;

	public STFileNode(STCanvas canvas, String initText, java.util.UUID uuid, nextgen.st.model.STFile stFile, nextgen.st.model.STModel stModel, nextgen.st.STRenderer stRenderer) {
		super(canvas, initText, uuid);
		this.stFile = stFile;
		this.stModel = stModel;
		this.stRenderer = stRenderer;
		if (this.stModel != null)
			this.stModel.addPropertyChangeListener(this);
	}

	public void setSTModel(nextgen.st.model.STModel stModel) {
		if (this.stModel != null)
			this.stModel.removePropertyChangeListener(this);
		this.stModel = stModel;
		this.stModel.addPropertyChangeListener(this);
		this.stModel.setFile(stFile);
		setText(nextgen.st.STGenerator.asFile(stFile).getAbsolutePath());
	}

	@Override
	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {
		final java.util.List<STModelNode> stModelNodes = canvas.getSelectedNodes()
				.filter(stNode -> stNode instanceof STModelNode)
				.filter(stNode -> !stNode.getUuid().equals(getUuid()))
				.map(stNode -> (STModelNode) stNode)
				.collect(Collectors.toList());
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
		if (stRenderer == null || stModel == null) return;
		nextgen.st.STGenerator.writeToFile(stRenderer.render(stModel), stFile.getPackageName(), stFile.getName(), stFile.getType(), new java.io.File(stFile.getPath()));
	}

	@Override
	public void propertyChange(java.beans.PropertyChangeEvent evt) {
		final Object source = evt.getSource();
		System.out.println("Event :" + source.getClass().getCanonicalName());
		if (source instanceof nextgen.st.model.STModel) {
			final nextgen.st.model.STModel stModel = (nextgen.st.model.STModel) source;
			this.stFile.setName(nextgen.st.STModelPatterns.getSTModelValue(stModel, "name", this.stFile.getName()));
			this.stFile.setPackageName(nextgen.st.STModelPatterns.getSTModelPackage(stModel, this.stFile.getPackageName()));
		}	
	}

	private static final class EditFileSink extends NodeAction<STFileNode> {

		EditFileSink(STFileNode node, STCanvas canvas, PInputEvent event) {
			super("Edit", node, canvas, event);
		}

		@Override
		void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
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
					javax.swing.SwingUtilities.invokeLater(() ->  {
						node.stFile.setName(name);
						node.stFile.setType(type);
						node.stFile.setPath(path);
						node.stFile.setPackageName(packageName);
						node.setText(nextgen.st.STGenerator.asFile(node.stFile).getAbsolutePath());	
					});
				}
			});
		}
	}

	private static final class OpenFile extends NodeAction<STFileNode> {

		OpenFile(STFileNode node, STCanvas canvas, PInputEvent event) {
			super("Open", node, canvas, event);
		}

		@Override
		void actionPerformed(STFileNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			try {
				java.awt.Desktop.getDesktop().open(nextgen.st.STGenerator.asFile(node.stFile));
			} catch (Exception ex) { com.generator.util.SwingUtil.showException(canvas, ex); }
		}
	}
}