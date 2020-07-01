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
							setArgument(stModel, newSTArgument(stParameter, newSTValue(s.trim())));
							setText(stRenderer.render(stModel));
						}
					});
					stValueNodes.forEach(stNode -> {
						final int end = Math.min(stNode.getText().length(), 50);
						stParameterMenu.add(new STNode.NodeAction<STModelNode>("Set " + stParameter.getName() + " = " + stNode.getText().substring(0, end), this, canvas, event) {
							@Override
							void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
								setArgument(stModel, newSTArgument(stParameter, stNode.stValue));
								setText(stRenderer.render(stModel));
							}
						});
					});
					stModelNodes.forEach(stNode -> {
						final int end = Math.min(stNode.getText().length(), 50);
						stParameterMenu.add(new STNode.NodeAction<STModelNode>("Set " + stParameter.getName() + " = " + stNode.getText().substring(0, end), this, canvas, event) {
							@Override
							void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
								setArgument(stModel, newSTArgument(stParameter, newSTValue(stNode.stModel)));
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
							addArgument(stTemplate, stModel, newSTArgument(stParameter, newSTValue(s.trim())));
							setText(stRenderer.render(stModel));
						}
					});
					stValueNodes.forEach(stNode -> {
						final int end = Math.min(stNode.getText().length(), 50);
						stParameterMenu.add(new STNode.NodeAction<STModelNode>("Add " + stParameter.getName() + " = " + stNode.getText().substring(0, end), this, canvas, event) {
							@Override
							void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
								addArgument(stTemplate, stModel, newSTArgument(stParameter, stNode.stValue));
								setText(stRenderer.render(stModel));
							}
						});
					});
					stModelNodes.forEach(stNode -> {
						final int end = Math.min(stNode.getText().length(), 50);
						stParameterMenu.add(new STNode.NodeAction<STModelNode>("Add " + stParameter.getName() + " = " + stNode.getText().substring(0, end), this, canvas, event) {
							@Override
							void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
								addArgument(stTemplate, stModel, newSTArgument(stParameter, newSTValue(stNode.stModel)));
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
										kvs.add(new STArgumentKV().setStParameterKey(fieldEntry.getKey()).setValue(newSTValue(value)));
									}
									addArgument(stTemplate, stModel,  newSTArgument(stParameter, kvs));
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
					stModel.removeArguments(stArgument);
					setText(stRenderer.render(stModel));
				}
			});
		});
		if (remove.getMenuComponentCount() != 0) pop.add(remove);
		pop.add(new ToClipboard(this, canvas, event));
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

	private static final class ToClipboard extends NodeAction<STModelNode> {

		ToClipboard(STModelNode node, STCanvas canvas, PInputEvent event) {
			super("To Clipboard", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {
			com.generator.util.SwingUtil.toClipboard(node.stRenderer.render(node.stModel));
		}
	}
}