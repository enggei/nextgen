package nextgen.st.canvas;

import com.generator.util.SwingUtil;
import nextgen.st.STModeller;
import nextgen.st.domain.STParameterKey;
import nextgen.st.model.STArgumentKV;
import nextgen.st.model.STValue;
import nextgen.st.model.STValueType;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.stream.Collectors;

public class STModelNode extends STNode {

	final nextgen.st.domain.STGroupModel stGroupModel;
	final nextgen.st.domain.STTemplate stTemplate;
	final nextgen.st.model.STModel stModel;
	final nextgen.st.STRenderer stRenderer;

	public STModelNode(STCanvas canvas, String initText, java.util.UUID uuid, nextgen.st.domain.STGroupModel stGroupModel, nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel stModel, nextgen.st.STRenderer stRenderer) {
		super(canvas, initText, uuid);
		this.stGroupModel = stGroupModel;
		this.stTemplate = stTemplate;
		this.stModel = stModel;
		this.stRenderer = stRenderer;
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
		stTemplate.getParameters().forEach(stParameter -> {
			final JMenu stParameterMenu = new JMenu(stParameter.getName());
			switch(stParameter.getType()) {
				case SINGLE: {
					stParameterMenu.add(new STNode.NodeAction<STModelNode>("Set " + stParameter.getName(), this, canvas, event) {
						@Override
						void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
							final String s = SwingUtil.showInputDialog(stParameter.getName(), canvas);
							if (s == null || s.trim().length() == 0) return;
							STModeller.setArgument(stParameter, stModel, new STValue().setType(STValueType.PRIMITIVE).setValue(s.trim()));
							setText(stRenderer.render(stModel));
						}
					});
					stValueNodes.forEach(stNode -> {
						final int end = Math.min(stNode.getText().length(), 50);
						stParameterMenu.add(new STNode.NodeAction<STModelNode>("Set " + stParameter.getName() + " = " + stNode.getText().substring(0, end), this, canvas, event) {
							@Override
							void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
								STModeller.setArgument(stParameter, stModel, stNode.stValue);
								setText(stRenderer.render(stModel));
							}
						});
					});
					stModelNodes.forEach(stNode -> {
						final int end = Math.min(stNode.getText().length(), 50);
						stParameterMenu.add(new STNode.NodeAction<STModelNode>("Set " + stParameter.getName() + " = " + stNode.getText().substring(0, end), this, canvas, event) {
							@Override
							void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
								STModeller.setArgument(stParameter, stModel, new STValue().setType(STValueType.STMODEL).setValue(stNode.getUuid().toString()));
								setText(stRenderer.render(stModel));
							}
						});
					});
					break;
				}
				case LIST: {
					stParameterMenu.add(new STNode.NodeAction<STModelNode>("Add " + stParameter.getName(), this, canvas, event) {
						@Override
						void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
							final String s = SwingUtil.showInputDialog(stParameter.getName(), canvas);
							if (s == null || s.trim().length() == 0) return;
							STModeller.addArgument(stParameter, stModel, new STValue().setType(STValueType.PRIMITIVE).setValue(s.trim()));
							setText(stRenderer.render(stModel));
						}
					});
					stValueNodes.forEach(stNode -> {
						final int end = Math.min(stNode.getText().length(), 50);
						stParameterMenu.add(new STNode.NodeAction<STModelNode>("Add " + stParameter.getName() + " = " + stNode.getText().substring(0, end), this, canvas, event) {
							@Override
							void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
								STModeller.addArgument(stParameter, stModel, stNode.stValue);
								setText(stRenderer.render(stModel));
							}
						});
					});
					stModelNodes.forEach(stNode -> {
						final int end = Math.min(stNode.getText().length(), 50);
						stParameterMenu.add(new STNode.NodeAction<STModelNode>("Add " + stParameter.getName() + " = " + stNode.getText().substring(0, end), this, canvas, event) {
							@Override
							void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
								STModeller.addArgument(stParameter, stModel, new STValue().setType(STValueType.STMODEL).setValue(stNode.getUuid().toString()));
								setText(stRenderer.render(stModel));
							}
						});
					});
					break;
				}
				case KVLIST: {
					stParameterMenu.add(new STNode.NodeAction<STModelNode>("Add " + stParameter.getName(), this, canvas, event) {
						@Override
						void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
							final Map<STParameterKey, JTextField> fieldMap = new LinkedHashMap<>();
							stParameter.getKeys().forEach(stParameterKey -> {
								fieldMap.put(stParameterKey, new JTextField(15));
							});
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
										kvs.add(new STArgumentKV().setKey(fieldEntry.getKey().getName()).setValue(new STValue().setType(STValueType.PRIMITIVE).setValue(fieldEntry.getValue().getText().trim())));
									}
									STModeller.addArgument(stParameter, stModel, kvs);
									setText(stRenderer.render(stModel));
								}
							});
						}
					});
					break;
				}
			}
			pop.add(stParameterMenu);
		});
		final JMenu remove = new JMenu("Remove");
		stModel.getArguments().forEach(stArgument -> {
			final String s = stRenderer.render(stArgument).toString();
			final int end = Math.min(s.length(), 50);
			remove.add(new STNode.NodeAction<STModelNode>("Remove " + s.substring(0, end), this, canvas, event) {
				@Override
				void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
					STModeller.removeArgument(stArgument, stModel);
					setText(stRenderer.render(stModel));
				}
			});
		});
		if (remove.getMenuComponentCount() != 0) pop.add(remove);
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

}