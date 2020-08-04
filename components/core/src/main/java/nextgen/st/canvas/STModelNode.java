package nextgen.st.canvas;

import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class STModelNode extends nextgen.st.canvas.STNode {

	nextgen.st.domain.STTemplate stTemplate;
	nextgen.st.model.STModel stModel;

	public STModelNode(nextgen.st.canvas.STCanvas canvas, nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel stModel) {
		super(canvas, stTemplate.getName() + " :\n" + canvas.presentationModel.render(stModel), java.util.UUID.fromString(stModel.getUuid()));
		this.stTemplate = stTemplate;
		this.stModel = stModel;
	}

	@Override
	public void setText(String text) {
		super.setText(stTemplate.getName() + " : \n" + text);
	}

	@Override
	public void addedToCanvas() {
		// getting all nodes and notifying them of this
		canvas.getAllNodes().forEach(this::newNodeAdded);
	}

	@Override
	public void newNodeAdded(nextgen.st.canvas.STNode node) {
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
		final java.util.List<STModelNode> sameModelNodes = canvas.getSelectedNodes()
						.filter(stNode -> stNode instanceof STModelNode)
						.filter(stNode -> !stNode.getUuid().equals(getUuid()))
						.map(stNode -> (STModelNode) stNode)
						.filter(stModelNode -> stModelNode.stTemplate.equals(STModelNode.this.stTemplate))
						.collect(java.util.stream.Collectors.toList());
		canvas.presentationModel.doInTransaction(tx -> {

			final String clipboardValue = cut(nextgen.utils.SwingUtil.fromClipboard());
			final java.util.LinkedHashMap<nextgen.st.domain.STParameter, org.fife.ui.rsyntaxtextarea.RSyntaxTextArea> fieldMap = new java.util.LinkedHashMap<>();

			final JMenu parametersMenu = new JMenu("Parameters");
			pop.add(parametersMenu);
			final Map<String, nextgen.st.model.STValue> existingSelections = new LinkedHashMap<>();

			stTemplate.getParameters().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stParameter -> {

				final JMenu stParameterMenu = new JMenu(stParameter.getName());
				parametersMenu.add(stParameterMenu);

				switch(stParameter.getType()) {
					case SINGLE :
						{ 
							final JMenu addstParameterMenu = new JMenu("Set");
							stParameterMenu.add(addstParameterMenu);
							stValueNodes.forEach(stNode -> addstParameterMenu.add(new SetSTValueArgumentAction(cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode)));
							stModelNodes.forEach(stNode -> addstParameterMenu.add(new SetSTModelArgumentAction(cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode)));
							sameModelNodes.forEach(stNode -> addstParameterMenu.add(new SetToSameAsArgumentAction("Same as " + cut(stNode.getText()), STModelNode.this, canvas, event, stParameter, stNode)));
							addstParameterMenu.add(new SetInputValueArgumentAction("From input", STModelNode.this, canvas, event, stParameter));
							addstParameterMenu.add(new SetBooleanValue("Set TRUE", STModelNode.this, canvas, event, stParameter));
							addstParameterMenu.add(new SetClipboardValueArgumentAction("From clipboard " + clipboardValue, STModelNode.this, canvas, event, stParameter));

							final JMenu openstParameterMenu = new JMenu("Open");
							stParameterMenu.add(openstParameterMenu);
							
							final JMenu removestParameterMenu = new JMenu("Remove");
							stParameterMenu.add(removestParameterMenu);

							stModel.getArguments().filter(existing -> existing.getValue() != null).filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid())).forEach(stArgument -> {
								openstParameterMenu.add(new OpenArgument(cut(canvas.presentationModel.render(stArgument.getValue())), STModelNode.this, canvas, event, stParameter, stArgument));
								removestParameterMenu.add(new RemoveArgument(cut(canvas.presentationModel.render(stArgument.getValue())), STModelNode.this, canvas, event, stParameter, stArgument));
								existingSelections.put(stParameter.uuid(), stArgument.getValue());
							});
							if (openstParameterMenu.getMenuComponentCount() > 1)
								openstParameterMenu.add(new OpenAllOf("All", STModelNode.this, canvas, event, stParameter));

							if (stParameter.getArgumentType() != null && (stParameter.getArgumentType().equals("String") || stParameter.getArgumentType().equals("Object"))) {
								fieldMap.put(stParameter, nextgen.utils.SwingUtil.newRSyntaxTextArea(1, 40));
							}
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
								openstParameterMenu.add(new OpenArgument(cut(canvas.presentationModel.render(stArgument.getValue())), STModelNode.this, canvas, event, stParameter, stArgument));
								removestParameterMenu.add(new RemoveArgument(cut(canvas.presentationModel.render(stArgument.getValue())), STModelNode.this, canvas, event, stParameter, stArgument));
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
								openstParameterMenu.add(new OpenArgument("Open " + (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST) ? stParameter.getName() : cut(canvas.presentationModel.render(stArgument.getValue()))), STModelNode.this, canvas, event, stParameter, stArgument));
								removestParameterMenu.add(new RemoveArgument("Remove " + (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST) ? stParameter.getName() : cut(canvas.presentationModel.render(stArgument.getValue()))), STModelNode.this, canvas, event, stParameter, stArgument));
							});
							break;
						}
				}
			});

			final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
			inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

			for (Map.Entry<nextgen.st.domain.STParameter, org.fife.ui.rsyntaxtextarea.RSyntaxTextArea> fieldEntry : fieldMap.entrySet()) {
				inputPanel.add(new JLabel(fieldEntry.getKey().getName()));
				inputPanel.add(fieldEntry.getValue());
			}

			if (!fieldMap.isEmpty()) {
				pop.add(new NodeAction<STModelNode>("Set Multiple", this, canvas, event) {
					@Override
					void actionPerformed(STModelNode node, STCanvas canvas, PInputEvent event, ActionEvent e) {

						final Map<String, Vector<String>> selections = new LinkedHashMap<>();					 // stParameter.uuid -> stArgument.uuid
						final Map<String, String> labels = new LinkedHashMap<>();									 // stArgument.uuid -> stValue.rendered
						final Map<String, nextgen.st.model.STValue> valueMap = new LinkedHashMap<>();		  // stArgument.uuid -> stValue
						final Map<String, nextgen.st.model.STValue> selectionMap = new LinkedHashMap<>();	 // stParameter.name -> stValue
						final Map<String, String> preSelected = new LinkedHashMap<>();								// stParameter.uuid -> stValue.rendered

						final Set<nextgen.st.model.STValue> distinct = new LinkedHashSet<>();
						canvas.presentationModel.doInTransaction(transaction -> {
							canvas.presentationModel.db.findAllSTModelByStTemplate(node.stTemplate.uuid())
										.forEach(stModel1 -> {
											stModel1.getArguments()
														.filter(stArgument -> stArgument.getValue() != null)
														.forEach(stArgument -> {
															final nextgen.st.model.STValue stArgumentValue = stArgument.getValue();
															if (distinct.contains(stArgumentValue)) return;
															distinct.add(stArgumentValue);
															final String stArgumentStParameter = stArgument.getStParameter();
															selections.putIfAbsent(stArgumentStParameter, new Vector<>());
															selections.get(stArgumentStParameter).add(stArgumentValue.getUuid());
															labels.put(stArgumentValue.getUuid(), canvas.presentationModel.render(stArgumentValue));
															valueMap.putIfAbsent(stArgumentValue.getUuid(), stArgumentValue);

															if (existingSelections.containsKey(stArgumentStParameter)) {
																preSelected.put(stArgumentStParameter, labels.get(stArgumentValue.getUuid()));
															}
														});
										});

							final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 3));
							inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

							for (Map.Entry<nextgen.st.domain.STParameter, org.fife.ui.rsyntaxtextarea.RSyntaxTextArea> fieldEntry : fieldMap.entrySet()) {
								inputPanel.add(new JLabel(fieldEntry.getKey().getName()));
								inputPanel.add(fieldEntry.getValue());
								final Vector<String> vector = selections.get(fieldEntry.getKey().uuid());
								final JComboBox<String> jComboBox = vector == null ? new JComboBox<>() : new JComboBox<>(vector);
								jComboBox.setEnabled(vector != null);
								jComboBox.setRenderer(new DefaultListCellRenderer() {
										@Override
										public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
											return super.getListCellRendererComponent(list, labels.get(value), index, isSelected, cellHasFocus);
										}
								});

								if (preSelected.containsKey(fieldEntry.getKey().uuid())) {
										jComboBox.setSelectedItem(preSelected.get(fieldEntry.getKey().uuid()));
										fieldEntry.getValue().setText(labels.get(jComboBox.getSelectedItem().toString()));
										selectionMap.put(fieldEntry.getKey().getName(), valueMap.get(jComboBox.getSelectedItem().toString()));
								}

								jComboBox.addActionListener(e1 -> {
										if (jComboBox.getSelectedItem() == null) return;
										fieldEntry.getValue().setText(labels.get(jComboBox.getSelectedItem().toString()));
										selectionMap.put(fieldEntry.getKey().getName(), valueMap.get(jComboBox.getSelectedItem().toString()));
								});
								jComboBox.setPrototypeDisplayValue("This is the proper length, with some extra");
								inputPanel.add(jComboBox);
							}

							nextgen.utils.SwingUtil.showDialog(inputPanel, canvas, "Set Multiple", new nextgen.utils.SwingUtil.ConfirmAction() {
								@Override
								public void verifyAndCommit() throws Exception {

										canvas.presentationModel.doInTransaction(transaction1 -> {
											for (Map.Entry<nextgen.st.domain.STParameter, org.fife.ui.rsyntaxtextarea.RSyntaxTextArea> entry : fieldMap.entrySet()) {
												final String text = entry.getValue().getText();
												if (text.trim().length() == 0) continue;

												if (selectionMap.containsKey(entry.getKey().getName())) {
														final nextgen.st.model.STValue stValue = selectionMap.get(entry.getKey().getName());
														final STValueNode stValueNode = canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));
														new SetSTValueArgumentAction("Set " + entry.getKey(), STModelNode.this, canvas, event, entry.getKey(), stValueNode).actionPerformed(STModelNode.this, canvas, event, null);
												} else {
														final nextgen.st.model.STValue stValue = canvas.presentationModel.db.newSTValue(text.trim());
														final STValueNode stValueNode = canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));
														new SetSTValueArgumentAction("Set " + entry.getKey(), STModelNode.this, canvas, event, entry.getKey(), stValueNode).actionPerformed(STModelNode.this, canvas, event, null);
												}
											}
										});
								}
							});
						});
					}
				});
			}
		});
		pop.add(new OpenUsages(this, canvas, event));
		pop.add(new WriteToFile(this, canvas, event));
		pop.add(new OpenIncoming(this, canvas, event));
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

			case java.awt.event.KeyEvent.VK_O:
				new OpenFileSink(this, canvas, event).actionPerformed(null);
				return;

		}
		super.onNodeKeyPressed(event);
	}

	@Override
	protected void onNodeLeftClick(PInputEvent event) {
		super.onNodeLeftClick(event);
		canvas.presentationModel.doInTransaction(tx -> setText(canvas.presentationModel.render(stModel)));
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

	protected void removeArgument(nextgen.st.domain.STParameter stParameter){ 
		stModel.getArguments().filter(existing -> existing.getStParameter().equals(stParameter.uuid())).findAny().ifPresent(existing -> {
			canvas.removeRelation(UUID.fromString(existing.getUuid()));
			stModel.removeArguments(existing);
		});
	}

	public boolean sameArgumentValue(nextgen.st.domain.STParameter stParameter,nextgen.st.model.STValue model) {
		final java.util.concurrent.atomic.AtomicBoolean exists = new java.util.concurrent.atomic.AtomicBoolean(false);
		stModel.getArguments().filter(existing -> existing.getStParameter().equals(stParameter.uuid())).forEach(existing -> {
			if (existing.getValue() != null && existing.getValue().getUuid().equals(model.getUuid()))
				exists.set(true);
		});
		return exists.get();
	}

	public boolean refersTo(nextgen.st.model.STArgument stArgument,nextgen.st.domain.STParameter stParameter,nextgen.st.canvas.STNode node) {
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

	private static final class OpenUsages extends NodeAction<nextgen.st.canvas.STModelNode> {


		OpenUsages(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Open usages", node, canvas, event);
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
		}
	}

	private static final class SetToSameAsArgumentAction extends NodeAction<nextgen.st.canvas.STModelNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.canvas.STModelNode stModelNode;

		SetToSameAsArgumentAction(String name, nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.canvas.STModelNode stModelNode) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stModelNode = stModelNode;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doInTransaction(transaction -> stModelNode.stModel.getArguments()
				.filter(stArgument -> stArgument.getStParameter().equals(stParameter.uuid()))
				.filter(stArgument -> stArgument.getValue() != null)
				.findFirst()
				.ifPresent(sourceArgument -> {
					node.removeArgument(stParameter);
					final nextgen.st.model.STArgument stArgument = canvas.presentationModel.newSTArgument(stParameter, sourceArgument.getValue());
					node.stModel.addArguments(stArgument);
					final STValueNode stValueNode = canvas.addNode(sourceArgument.getValue().getUuid(), canvas.newSTNode(sourceArgument.getValue()));
					canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stValueNode, stArgument, stParameter));
					node.setText(canvas.presentationModel.render(node.stModel));
				}));
		}
	}

	private static final class OpenIncoming extends NodeAction<STModelNode> {


		OpenIncoming(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Open Incoming", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(transaction -> {
				canvas.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				final org.neo4j.graphdb.Node stModelNode = node.stModel.getNode();
				stModelNode.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(relationship -> {
					if (nextgen.st.model.STModelNeoFactory.isSTValue(relationship.getOtherNode(stModelNode))) {
						final org.neo4j.graphdb.Node stValueNode = relationship.getOtherNode(stModelNode);
						stValueNode.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(relationship2 -> {
							final org.neo4j.graphdb.Node otherNode = relationship2.getOtherNode(stValueNode);
							if (nextgen.st.model.STModelNeoFactory.isSTArgument(otherNode)) {
								final nextgen.st.model.STArgument stArgument = new nextgen.st.model.STArgument(otherNode);
								stArgument.getIncomingArguments().forEach(stModel -> {
									final nextgen.st.domain.STTemplate stTemplateByUuid = canvas.presentationModel.findSTTemplateByUuid(stModel.getStTemplate());
									if (stTemplateByUuid == null) return;
									stTemplateByUuid.getParameters()
										.filter(stParameter -> stParameter.uuid().equals(stArgument.getStParameter()))
										.findFirst()
										.ifPresent(stParameter -> {
												final STModelNode refstModelNode = canvas.addNode(stModel.getUuid(), canvas.newSTNode(stModel));
												canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(refstModelNode, node, stArgument, stParameter));
										});
								});
							} else if (nextgen.st.model.STModelNeoFactory.isSTArgumentKV(otherNode)) {
								final nextgen.st.model.STArgumentKV stArgumentKV = new nextgen.st.model.STArgumentKV(otherNode);

								stArgumentKV.getIncomingKeyValues().forEach(stArgument -> {
									stArgument.getIncomingArguments().forEach(stModel -> {
										final nextgen.st.domain.STTemplate stTemplateByUuid = canvas.presentationModel.findSTTemplateByUuid(stModel.getStTemplate());
										if (stTemplateByUuid == null) return;
										stTemplateByUuid.getParameters()
											.filter(stParameter -> stParameter.uuid().equals(stArgument.getStParameter()))
											.findFirst()
											.ifPresent(stParameter -> {
												final STModelNode refstModelNode = canvas.addNode(stModel.getUuid(), canvas.newSTNode(stModel));
												canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(refstModelNode, canvas.addNode(stArgument.getUuid(), canvas.newSTNode(stParameter, stArgument)), stArgument, stParameter));
											});
									});
								});
							}
						});
					}
				});
				canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			});
		}
	}

	private static final class WriteToFile extends NodeAction<STModelNode> {


		WriteToFile(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Write To File", node, canvas, event);
		}

		@Override
		void actionPerformed(STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.writeToFile(node.stModel);
		}
	}

	private static final class OpenAllArguments extends NodeAction<nextgen.st.canvas.STModelNode> {


		OpenAllArguments(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Open All", node, canvas, event);
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(tx -> {
				node.forEachArgument((stArgument, stParameter) -> new OpenArgument("", node, canvas, event, stParameter, stArgument).actionPerformed(null));
				new LayoutTreeAction(node, canvas, event).actionPerformed(null);
			});
		}
	}

	private static final class RemoveArgument extends NodeAction<nextgen.st.canvas.STModelNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.model.STArgument stArgument;

		RemoveArgument(String name, nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STArgument stArgument) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stArgument = stArgument;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			if (!nextgen.utils.SwingUtil.showConfirmDialog(canvas, "Remove argument ?")) return;
			canvas.presentationModel.doLaterInTransaction(tx -> {
				canvas.removeRelation(UUID.fromString(stArgument.getUuid()));
				node.stModel.removeArguments(stArgument);
				node.setText(canvas.presentationModel.render(node.stModel));
			});
		}
	}

	private static final class ToClipboard extends NodeAction<nextgen.st.canvas.STModelNode> {


		ToClipboard(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("To Clipboard", node, canvas, event);
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(tx -> nextgen.utils.SwingUtil.toClipboard(canvas.presentationModel.render(node.stModel)));
		}
	}

	private static final class Delete extends NodeAction<nextgen.st.canvas.STModelNode> {


		Delete(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Delete", node, canvas, event);
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			if (!nextgen.utils.SwingUtil.showConfirmDialog(canvas, "Delete model ?")) return;
			canvas.presentationModel.doLaterInTransaction(tx -> {
				node.close();
				canvas.presentationModel.db.remove(node.stModel);
			});
		}
	}

	private static final class Clone extends NodeAction<nextgen.st.canvas.STModelNode> {


		Clone(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Clone", node, canvas, event);
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(tx -> {
				final nextgen.st.model.STModel clone = canvas.presentationModel.db.clone(node.stModel);
				final STModelNode stModelNode = canvas.newSTNode(clone).get();
				canvas.addNode(stModelNode);
				stModelNode.setText(canvas.presentationModel.render(stModelNode.stModel));
			});
		}
	}

	private static final class AddFileSink extends NodeAction<nextgen.st.canvas.STModelNode> {


		AddFileSink(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Add File Sink", node, canvas, event);
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(tx -> {

				final java.util.concurrent.atomic.AtomicInteger typeIndex = new java.util.concurrent.atomic.AtomicInteger(0);
				final String[] fileTypes = new String[]{"html", "java", "js"};

				final java.util.concurrent.atomic.AtomicInteger pathIndex = new java.util.concurrent.atomic.AtomicInteger(0);
				final String[] pathTypes = canvas.presentationModel.db.findAllSTFile()
						.filter(stFile -> stFile.getPath() != null)
						.filter(stFile -> stFile.getPath().getValue() != null)
						.map(stFile -> stFile.getPath().getValue())
						.distinct()
						.toArray(String[]::new);

				final java.util.LinkedHashMap<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();
				fieldMap.put("name", canvas.newTextField(canvas.presentationModel.getSTModelName(node.stModel, ""), 15));
				fieldMap.put("type", canvas.newTextField(15));
				fieldMap.put("path", canvas.newTextField(15));
				fieldMap.put("package", canvas.newTextField(canvas.presentationModel.getSTModelPackage(node.stModel, ""), 15));
				final JPanel inputPanel = new JPanel(new GridLayout(fieldMap.size(), 2));
				inputPanel.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
				for (Map.Entry<String, JTextField> fieldEntry : fieldMap.entrySet()) { 
					inputPanel.add(new JLabel(fieldEntry.getKey()));
					inputPanel.add(fieldEntry.getValue());

					if (fieldEntry.getKey().equals("type")) {
						fieldEntry.getValue().addMouseListener(new java.awt.event.MouseAdapter() {
							@Override
							public void mouseClicked(java.awt.event.MouseEvent e) {
								fieldEntry.getValue().setText(fileTypes[typeIndex.incrementAndGet() % fileTypes.length]);
							}
						});
					} else if (fieldEntry.getKey().equals("path")) {
						fieldEntry.getValue().addMouseListener(new java.awt.event.MouseAdapter() {
							@Override
							public void mouseClicked(java.awt.event.MouseEvent e) {
								fieldEntry.getValue().setText(pathTypes[pathIndex.incrementAndGet() % pathTypes.length]);
							}
						});
				}
				}
				
				nextgen.utils.SwingUtil.showDialog(inputPanel, canvas, "New File sink", new nextgen.utils.SwingUtil.ConfirmAction() {
					@Override
					public void verifyAndCommit() throws Exception {
						final String name = fieldMap.get("name").getText().trim();
						final String type = fieldMap.get("type").getText().trim();
						final String path = fieldMap.get("path").getText().trim();
						final String packageName = fieldMap.get("package").getText().trim();
						canvas.presentationModel.doLaterInTransaction(tx -> {
							final nextgen.st.model.STFile stFile = canvas.presentationModel.newSTFile(name, type, path, packageName);
							node.stModel.addFiles(stFile);
							final STFileNode dstNode = canvas.addNode(new STFileNode(canvas, stFile, node.stModel));
							//canvas.addRelation(new STSinkRelation(canvas, node, dstNode));
							canvas.addRelation(dstNode.getUuid(), canvas.newSinkRelation(node, dstNode));
						});
					}
				});
			});
		}
	}

	private static final class OpenFileSink extends NodeAction<nextgen.st.canvas.STModelNode> {


		OpenFileSink(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Open File Sink", node, canvas, event);
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(tx -> 
				node.stModel.getFiles().forEach(stFile -> {
					final STFileNode dstNode = canvas.addNode(stFile.getUuid(), canvas.newSTNode(stFile, node.stModel));
					canvas.addRelation(dstNode.getUuid(), canvas.newSinkRelation(node, dstNode));
					new LayoutTreeAction(node, canvas, event).actionPerformed(null);
				})
			);
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
			canvas.presentationModel.doLaterInTransaction(tx -> {
				node.removeArgument(stParameter);
				final nextgen.st.model.STValue stValue = canvas.presentationModel.db.newSTValue("true");
				final nextgen.st.model.STArgument stArgument = canvas.presentationModel.db.newSTArgument(stParameter, stValue);
				node.stModel.addArguments(stArgument);
				node.setText(canvas.presentationModel.render(node.stModel));
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
			nextgen.utils.SwingUtil.showInputDialog(stParameter.getName(), canvas, s -> {
				canvas.presentationModel.doLaterInTransaction(tx -> {
					node.removeArgument(stParameter);
					final nextgen.st.model.STValue stValue = canvas.presentationModel.db.newSTValue(s.trim());
					final nextgen.st.model.STArgument stArgument = canvas.presentationModel.db.newSTArgument(stParameter, stValue);
					node.stModel.addArguments(stArgument);
					canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));
					canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, canvas.getNode(stValue.getUuid()), stArgument, stParameter));
					node.setText(canvas.presentationModel.render(node.stModel));
				});
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
			final String s = nextgen.utils.SwingUtil.fromClipboard();
			if (s == null || s.trim().length() == 0) return;
			canvas.presentationModel.doLaterInTransaction(tx -> {
				node.removeArgument(stParameter);
				final nextgen.st.model.STValue stValue = canvas.presentationModel.newSTValue(s.trim());
				final nextgen.st.model.STArgument stArgument = canvas.presentationModel.newSTArgument(stParameter, stValue);
				node.stModel.addArguments(stArgument);
				canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue));
				//canvas.addRelation(new STArgumentRelation(canvas, node, canvas.getNode(stValue.getUuid()), stArgument, stParameter));
				canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, canvas.getNode(stValue.getUuid()), stArgument, stParameter));
				node.setText(canvas.presentationModel.render(node.stModel));
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
			canvas.presentationModel.doLaterInTransaction(tx -> {
				if (node.sameArgumentValue(stParameter, stValueNode.stValue)) return;
				node.removeArgument(stParameter);
				final nextgen.st.model.STArgument stArgument = canvas.presentationModel.newSTArgument(stParameter, stValueNode.stValue);
				node.stModel.addArguments(stArgument);
				// canvas.addRelation(new STArgumentRelation(canvas, node, stValueNode, stArgument, stParameter));
				canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stValueNode, stArgument, stParameter));
				node.setText(canvas.presentationModel.render(node.stModel));
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
			canvas.presentationModel.doLaterInTransaction(tx -> {
				node.removeArgument(stParameter);
				final nextgen.st.model.STValue stValue = canvas.presentationModel.newSTValue(stModelNode.stModel);
				final nextgen.st.model.STArgument stArgument = canvas.presentationModel.newSTArgument(stParameter, stValue);
				node.stModel.addArguments(stArgument);
				//canvas.addRelation(new STArgumentRelation(canvas, node, stModelNode, stArgument, stParameter));
				canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stModelNode, stArgument, stParameter));
				node.setText(canvas.presentationModel.render(node.stModel));
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
			nextgen.utils.SwingUtil.showInputDialog(stParameter.getName(), canvas, s -> {
				canvas.presentationModel.doLaterInTransaction(tx -> {
					final nextgen.st.model.STValue stValue = canvas.presentationModel.newSTValue(s.trim());
					final nextgen.st.model.STArgument stArgument = canvas.presentationModel.newSTArgument(stParameter, stValue);
					node.stModel.addArguments(stArgument);
					final STNode stValueNode = canvas.addNode(canvas.newSTNode(stValue).get());
					canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stValueNode, stArgument, stParameter));
					node.setText(canvas.presentationModel.render(node.stModel));
				});
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
			final String s = nextgen.utils.SwingUtil.fromClipboard();
			if (s == null || s.trim().length() == 0) return;
			canvas.presentationModel.doLaterInTransaction(tx -> {
				final nextgen.st.model.STValue stValue = canvas.presentationModel.newSTValue(s.trim());
				final nextgen.st.model.STArgument stArgument = canvas.presentationModel.newSTArgument(stParameter, stValue);
				node.stModel.addArguments(stArgument);
				final STNode stValueNode = canvas.addNode(canvas.newSTNode(stValue).get());
				//canvas.addRelation(new STArgumentRelation(canvas, node, stValueNode, stArgument, stParameter));
				canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stValueNode, stArgument, stParameter));
				node.setText(canvas.presentationModel.render(node.stModel));
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
			canvas.presentationModel.doLaterInTransaction(tx -> {
				final nextgen.st.model.STArgument stArgument = canvas.presentationModel.newSTArgument(stParameter, stValueNode.stValue);
				node.stModel.addArguments(stArgument);
				//canvas.addRelation(new STArgumentRelation(canvas, node, stValueNode, stArgument, stParameter));
				canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stValueNode, stArgument, stParameter));
				node.setText(canvas.presentationModel.render(node.stModel));
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
			canvas.presentationModel.doLaterInTransaction(tx -> {
				final nextgen.st.model.STValue stValue = canvas.presentationModel.newSTValue(stModelNode.stModel);
				final nextgen.st.model.STArgument stArgument = canvas.presentationModel.newSTArgument(stParameter, stValue);
				node.stModel.addArguments(stArgument);
				//canvas.addRelation(new STArgumentRelation(canvas, node, stModelNode, stArgument, stParameter));
				canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stModelNode, stArgument, stParameter));
				node.setText(canvas.presentationModel.render(node.stModel));
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
			canvas.presentationModel.doLaterInTransaction(tx -> {
				canvas.presentationModel.addKVArgument(node.stModel, stParameter, canvas, stArgument -> {
					final STNode stkvNode = canvas.addNode(canvas.newSTNode(stParameter, stArgument).get());
					canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, stkvNode, stArgument, stParameter));
					node.setText(canvas.presentationModel.render(node.stModel));
				});
			});
		}
	}

	private static final class OpenArgument extends NodeAction<nextgen.st.canvas.STModelNode> {

		nextgen.st.domain.STParameter stParameter;
		nextgen.st.model.STArgument stArgument;

		OpenArgument(String name, nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STArgument stArgument) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
			this.stArgument = stArgument;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(tx -> {
				if (stParameter.getType().equals(nextgen.st.domain.STParameterType.KVLIST)) {
					canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, canvas.addNode(stArgument.getUuid(), canvas.newSTNode(stParameter, stArgument)), stArgument, stParameter));
				} else {
					final nextgen.st.model.STValue stValue = stArgument.getValue();
					switch(stValue.getType()) {
						case STMODEL :
						{
							canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, canvas.addNode(stValue.getStModel().getUuid(), canvas.newSTNode(stValue.getStModel())), stArgument, stParameter));
							break;
						}
						case PRIMITIVE :
						{
							canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue)), stArgument, stParameter));
							break;
						}
						case ENUM :
						{
							canvas.addRelation(stArgument.getUuid(), canvas.newSTArgumentRelation(node, canvas.addNode(stValue.getUuid(), canvas.newSTNode(stValue)), stArgument, stParameter));				
							break;
						}
					}
				}
				new LayoutTreeAction(node, canvas, event).actionPerformed(null);
			});
		}
	}

	private static final class OpenTemplateAction extends NodeAction<nextgen.st.canvas.STModelNode> {


		OpenTemplateAction(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event) {
			super("Open template", node, canvas, event);
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(transaction -> nextgen.st.STAppEvents.postOpenSTModel(node.stTemplate.uuid()));
		}
	}

	private static final class OpenAllOf extends NodeAction<nextgen.st.canvas.STModelNode> {

		nextgen.st.domain.STParameter stParameter;

		OpenAllOf(String name, nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, nextgen.st.domain.STParameter stParameter) {
			super(name, node, canvas, event);
			this.stParameter = stParameter;
		}

		@Override
		void actionPerformed(nextgen.st.canvas.STModelNode node, nextgen.st.canvas.STCanvas canvas, PInputEvent event, ActionEvent e) {
			canvas.presentationModel.doLaterInTransaction(tx -> {
				node.forEachArgument((stArgument, stParameter) -> {
					if (this.stParameter.equals(stParameter))
						new OpenArgument("", node, canvas, event, stParameter, stArgument).actionPerformed(null);
				});
				new LayoutTreeAction(node, canvas, event).actionPerformed(null);
			});
		}
	}
}