package nextgen.st;

import nextgen.utils.SwingUtil;
import nextgen.st.model.*;
import nextgen.st.domain.*;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;
import java.util.function.Consumer;

public class STModelEditorNavigator extends JPanel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelEditorNavigator.class);

	private final JTree tree = new JTree();
	private final STModelEditorNavigatorTreeModel treeModel;

	private STModel model;
	private STModelEditor editor;

	public STModelEditorNavigator(STModel model, STModelEditor editor) {
		super(new BorderLayout());

		this.model = model;
		this.editor = editor;

		treeModel = new STModelEditorNavigatorTreeModel(new STModelTreeNode(model, appModel().findSTTemplateByUuid(model.getStTemplate()), null));
		tree.setModel(treeModel);
		ToolTipManager.sharedInstance().registerComponent(tree);

		tree.setCellRenderer(new DefaultTreeCellRenderer() {

			@Override
			public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
				final boolean isBaseTreeNode = value instanceof BaseTreeNode;
				if (isBaseTreeNode) {
					final BaseTreeNode<?> baseTreeNode = (BaseTreeNode<?>) value;
					final ImageIcon icon = baseTreeNode.getIcon();
					setIcon(icon);
					setOpenIcon(icon);
					setClosedIcon(icon);
					setLeafIcon(icon);
					setToolTipText(baseTreeNode.getTooltip());
					return super.getTreeCellRendererComponent(tree, baseTreeNode.getLabel(), sel, expanded, leaf, row, hasFocus);
				}
				return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
			}
		});

		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {

					final TreePath selectionPath = tree.getPathForLocation(e.getX(), e.getY());
					if (selectionPath == null) return;
					final Object lastPathComponent = selectionPath.getLastPathComponent();
					if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;

					showPopup((BaseTreeNode<?>) lastPathComponent, e.getX(), e.getY());

				} else {

					final TreePath selectionPath = tree.getPathForLocation(e.getX(), e.getY());
					if (selectionPath == null) return;
					final Object lastPathComponent = selectionPath.getLastPathComponent();
					if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;

					appModel().doInTransaction(transaction -> {
						if (lastPathComponent instanceof STModelTreeNode) {
							final STModelTreeNode selectedNode = (STModelTreeNode) lastPathComponent;
							editor.setText(appModel().render(selectedNode.getModel()), null);

							STAppEvents.postSTModelEditorTreeNodeClicked(selectedNode.getModel());
							
						} else if (lastPathComponent instanceof STValueTreeNode) {
							final STValueTreeNode selectedNode = (STValueTreeNode) lastPathComponent;
							editor.setText(appModel().render(selectedNode.getModel()), selectedNode);
						} else if (lastPathComponent instanceof STKVArgumentTreeNode) {
							final STKVArgumentTreeNode selectedNode = (STKVArgumentTreeNode) lastPathComponent;
							editor.setText(appModel().render(selectedNode.getModel(), selectedNode.stParameter), null);
						} else {
							editor.setText("", null);
						}
					});
				}
			}
		});

		tree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					final TreePath selectionPath = tree.getSelectionPath();
					if (selectionPath == null) return;
					final Object lastPathComponent = selectionPath.getLastPathComponent();
					if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;

					final Rectangle bounds = tree.getPathBounds(selectionPath);
					if (bounds == null) return;

					showPopup((BaseTreeNode<?>) lastPathComponent, (int) bounds.getX(), (int) bounds.getY());
				}
			}
		});

		setPreferredSize(new Dimension(600, 600));
		add(new JScrollPane(tree), BorderLayout.CENTER);

	}

	public class BaseTreeNode<T> extends DefaultMutableTreeNode {

		protected String label;
		protected ImageIcon icon;
		protected String tooltip;

		public BaseTreeNode(T model, ImageIcon icon) {
			setUserObject(model);
			this.label = model.toString();
			this.icon = icon;
			this.tooltip = "";
		}

		@SuppressWarnings("unchecked")
		public T getModel() {
			return (T) getUserObject();
		}

		public String getLabel() {
			return label;
		}

		public ImageIcon getIcon() {
			return icon;
		}

		protected java.util.List<Action> getActions() {
			java.util.List<Action> actions = new ArrayList<>();
			actions.add(newAction("Expand", actionEvent -> {
				SwingUtilities.invokeLater(() -> expandTreeNodesRecursive(getThisPath(), true));
			}));
			actions.add(newAction("Collapse", actionEvent -> {
				SwingUtilities.invokeLater(() -> expandTreeNodesRecursive(getThisPath(), false));
			}));
			return actions;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof BaseTreeNode)) return false;
			return getModel().equals(((BaseTreeNode<?>) obj).getModel());
		}

		@Override
		public int hashCode() {
			return getModel().hashCode();
		}

		@SuppressWarnings("unchecked")
		public <T> Optional<T> getParentNode(Class<T> type) {
			if (getClass().equals(type)) return (Optional<T>) Optional.of(this);

			final TreeNode parent = getParent();
			if (!(parent instanceof BaseTreeNode)) return Optional.empty();

			return ((BaseTreeNode<?>) parent).getParentNode(type);
		}

		public String getTooltip() {
			return tooltip;
		}

		public void nodeChanged() {
			treeModel.nodeChanged(this);
		}

		protected TreePath addChild(BaseTreeNode<?> child) {
			add(child);
			final TreePath path = new TreePath(child.getPath());
			treeModel.nodesWereInserted(BaseTreeNode.this, new int[]{getIndex(child)});
			return path;
		}

		protected void addAndSelectChild(BaseTreeNode<?> child) {
			final TreePath path = addChild(child);
			tree.scrollPathToVisible(path);
			tree.setSelectionPath(path);
		}

		protected <T> java.util.stream.Stream<T> getChildren(Class<T> type) {
			final java.util.Set<T> set = new java.util.LinkedHashSet<>();
			final int childCount = getChildCount();
			for (int i = 0; i < childCount; i++) {
				if (getChildAt(i).getClass().isAssignableFrom(type))
					set.add((T) getChildAt(i));
			}

			return set.stream();
		}

		protected TreePath find(java.util.function.Predicate<BaseTreeNode<?>> predicate) {
			final int childCount = getChildCount();
			for (int i = 0; i < childCount; i++) {
				final BaseTreeNode<?> childAt = (BaseTreeNode<?>) getChildAt(i);
				if (predicate.test(childAt))
					return (childAt).getThisPath();
				else {
					final TreePath treePath = childAt.find(predicate);
					if (treePath != null) return treePath;
				}
			}
			return null;
		}

		protected TreePath getThisPath() {
			return new TreePath(getPath());
		}

		protected void expandTreeNodesRecursive(TreePath parent, boolean expand) {
			TreeModel model = tree.getModel();

			Object node = parent.getLastPathComponent();
			int childCount = model.getChildCount(node);
			for (int j = 0; j < childCount; j++) 
				expandTreeNodesRecursive(parent.pathByAddingChild(model.getChild(node, j)), expand);

			if (expand) 
				tree.expandPath(parent);
			else 
				tree.collapsePath(parent);
		}
	}

	// STModelTreeNode

	private boolean isSTModelTreeNode(BaseTreeNode<?> treeNode) {
		return treeNode instanceof STModelTreeNode;
	}

	public class STModelTreeNode extends BaseTreeNode<STModel> {

		private String uuid;
		private STTemplate stTemplate;
		private Object stArgument;

		STModelTreeNode(STModel model, STTemplate stTemplate, Object stArgument) {
			super(model, null);

			this.stTemplate = stTemplate;
			this.stArgument = stArgument;
			this.label = appModel().tryToFindArgument(getModel(), "name", () -> "[" + stTemplate.getName() + "]");
			this.tooltip = "";
			this.uuid = model.getUuid();

			stTemplate.getParameters()
					.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
					.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));
		}

		STModelTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			this.label = appModel().tryToFindArgument(getModel(), "name", () -> "[" + stTemplate.getName() + "]");
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newAction("Write to File", actionEvent -> {
				appModel().writeToFile(getModel());
			}));
			actions.add(newAction("Remove", actionEvent -> {
				SwingUtil.confirm(tree, "Delete ?").ifPresent(aBoolean -> 
					appModel().doLaterInTransaction(transaction -> {
						if (stArgument instanceof STArgument) {
							STArgument argument = (STArgument) stArgument;
							argument.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> stModel.removeArguments(argument));
							treeModel.removeNodeFromParent(this);
							editor.setText("", null);
						} else if (stArgument instanceof STArgumentKV) {
							STArgumentKV argumentKV = (STArgumentKV) stArgument;
							argumentKV.getIncomingKeyValuesSTArgument().findFirst().ifPresent(stArgument -> stArgument.removeKeyValues(argumentKV));
							treeModel.removeNodeFromParent(this);
							editor.setText("", null);
						}
					})
				);
			}));
			actions.add(newAction("Edit", actionEvent -> {
				SwingUtilities.invokeLater(() -> appModel().db.doInTransaction(transaction -> appModel().getWorkspace().setSelectedComponent(appModel().getModelEditor(getModel()))));
			}));
			return actions;
		}

	}

	// STValueTreeNode

	private boolean isSTValueTreeNode(BaseTreeNode<?> treeNode) {
		return treeNode instanceof STValueTreeNode;
	}

	public class STValueTreeNode extends BaseTreeNode<nextgen.st.model.STValue> {

		private String uuid;
		private Object stArgument;

		STValueTreeNode(nextgen.st.model.STValue model, Object stArgument) {
			super(model, null);

			this.stArgument = stArgument;
			this.label = getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? "[EMPTY]" : getModel().getValue();
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STValueTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			this.label = getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? "[EMPTY]" : getModel().getValue();
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newAction("To Clipboard", actionEvent -> {
				appModel().doLaterInTransaction(transaction -> {
					SwingUtil.toClipboard(appModel().render(getModel()));
				});
			}));
			actions.add(newAction("Remove", actionEvent -> {
				SwingUtil.confirm(tree, "Delete ?").ifPresent(aBoolean -> 
					appModel().doLaterInTransaction(transaction -> {
						if (stArgument instanceof STArgument) {
							STArgument argument = (STArgument) stArgument;
							argument.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> stModel.removeArguments(argument));
							treeModel.removeNodeFromParent(this);
							editor.setText("", null);
						} else if (stArgument instanceof STArgumentKV) {
							STArgumentKV argumentKV = (STArgumentKV) stArgument;
							argumentKV.getIncomingKeyValuesSTArgument().findFirst().ifPresent(stArgument -> stArgument.removeKeyValues(argumentKV));
							treeModel.removeNodeFromParent(this);
							editor.setText("", null);
						}
					})
				);
			}));
			return actions;
		}

	}

	// STKVArgumentTreeNode

	private boolean isSTKVArgumentTreeNode(BaseTreeNode<?> treeNode) {
		return treeNode instanceof STKVArgumentTreeNode;
	}

	public class STKVArgumentTreeNode extends BaseTreeNode<STArgument> {
		private STParameter stParameter;

		STKVArgumentTreeNode(STArgument model, STParameter stParameter) {
			super(model, null);

			this.stParameter = stParameter;
			this.label = appModel().tryToFindArgument(getModel().getKeyValues(), stParameter, "name", stParameter::getName);
			this.tooltip = "";

			stParameter.getKeys().forEach(stParameterKey -> getModel().getKeyValues()
					.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
					.findFirst()
					.ifPresent(stArgumentKV -> add(new STKVTreeNode(stArgumentKV, getModel(), stParameterKey))));
		}

		STKVArgumentTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			this.label = appModel().tryToFindArgument(getModel().getKeyValues(), stParameter, "name", stParameter::getName);
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			appModel().doInTransaction(transaction -> {
				stParameter.getKeys().forEach(stParameterKey -> {
					actions.add(newAction(stParameterKey.getName() + " from input", actionEvent -> {
							SwingUtil.showInputDialog(stParameterKey.getName(), tree, inputValue ->
									appModel().doLaterInTransaction(transaction1 -> {
											int childCount = getChildCount();
											final STValue stValue = appModel().newSTValue(inputValue);
											for (int i = 0; i < childCount; i++) {
												final STKVTreeNode stkvTreeNode = (STKVTreeNode) getChildAt(i);
												final STArgumentKV stArgumentKV = stkvTreeNode.getModel();
												if (stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid())) {
													stArgumentKV.setValue(stValue);
													while (stkvTreeNode.getChildCount() != 0)
															treeModel.removeNodeFromParent((MutableTreeNode) stkvTreeNode.getChildAt(0));
													stkvTreeNode.addAndSelectChild(new STValueTreeNode(stValue, stArgumentKV));
													return;
												}
											}

											final STArgumentKV stArgumentKV = appModel().newSTArgumentKV(stParameterKey, stValue);
											getModel().addKeyValues(stArgumentKV);
											addAndSelectChild(new STKVTreeNode(stArgumentKV, getModel(), stParameterKey));
									}));
					}));
					actions.add(newAction(stParameterKey.getName() + " from Clipboard " + appModel().cut(SwingUtil.fromClipboard(), 30), actionEvent -> {
							appModel().doLaterInTransaction(transaction1 -> {
								int childCount = getChildCount();
								final STValue stValue = appModel().newSTValue(SwingUtil.fromClipboard());
								for (int i = 0; i < childCount; i++) {
									final STKVTreeNode stkvTreeNode = (STKVTreeNode) getChildAt(i);
									final STArgumentKV stArgumentKV = stkvTreeNode.getModel();
									if (stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid())) {
											stArgumentKV.setValue(stValue);
											while (stkvTreeNode.getChildCount() != 0)
												treeModel.removeNodeFromParent((MutableTreeNode) stkvTreeNode.getChildAt(0));
											stkvTreeNode.addAndSelectChild(new STValueTreeNode(stValue, stArgumentKV));
											return;
									}
								}

								final STArgumentKV stArgumentKV = appModel().newSTArgumentKV(stParameterKey, stValue);
								getModel().addKeyValues(stArgumentKV);
								addAndSelectChild(new STKVTreeNode(stArgumentKV, getModel(), stParameterKey));
							});
					}));
				});
			});
			actions.add(newAction("Remove", actionEvent -> {
				appModel().doLaterInTransaction(transaction -> {
					getModel().getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> stModel.removeArguments(getModel()));
					treeModel.removeNodeFromParent(this);
					editor.setText("", null);
				});
			}));
			return actions;
		}

	}

	// STKVTreeNode

	private boolean isSTKVTreeNode(BaseTreeNode<?> treeNode) {
		return treeNode instanceof STKVTreeNode;
	}

	public class STKVTreeNode extends BaseTreeNode<STArgumentKV> {

		private String uuid;
		private STArgument stArgument;
		private STParameterKey stParameterKey;

		STKVTreeNode(STArgumentKV model, STArgument stArgument, STParameterKey stParameterKey) {
			super(model, null);

			this.stArgument = stArgument;
			this.stParameterKey = stParameterKey;
			this.label = stParameterKey.getName();
			this.tooltip = "";
			this.uuid = model.getUuid();

			final STValue stValue = model.getValue();
			if (stValue != null)
				switch (stValue.getType()) {
					case STMODEL:
						add(new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), model));
						break;
					case PRIMITIVE:
						add(new STValueTreeNode(stValue, model));
						break;
					case ENUM:
						break;
				}
		}

		STKVTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			this.label = stParameterKey.getName();
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			appModel().doInTransaction(transaction -> {

				actions.add(newAction("Set from input", actionEvent -> {
					SwingUtil.showInputDialog(stParameterKey.getName(), tree, inputValue ->
								appModel().doLaterInTransaction(transaction1 -> {
									final STValue stValue = appModel().newSTValue(inputValue);
									getModel().setValue(stValue);
									while (getChildCount() != 0)
											treeModel.removeNodeFromParent((MutableTreeNode) getChildAt(0));
									addAndSelectChild(new STValueTreeNode(stValue, getModel()));
									nodeChanged();
								}));
				}));

				actions.add(newAction("Set from Clipboard " + appModel().cut(SwingUtil.fromClipboard(), 30), actionEvent -> {
					appModel().doLaterInTransaction(transaction1 -> {
							final STValue stValue = appModel().newSTValue(SwingUtil.fromClipboard());
							getModel().setValue(stValue);
							while (getChildCount() != 0)
								treeModel.removeNodeFromParent((MutableTreeNode) getChildAt(0));
							addAndSelectChild(new STValueTreeNode(stValue, getModel()));
							nodeChanged();
					});
				}));
			});
			actions.add(newAction("Remove", actionEvent -> {
				appModel().doLaterInTransaction(transaction1 -> {
					stArgument.removeKeyValues(getModel());
					treeModel.removeNodeFromParent(this);
					editor.setText("", null);
				});
			}));
			return actions;
		}

	}

	// STParameterTreeNode

	private boolean isSTParameterTreeNode(BaseTreeNode<?> treeNode) {
		return treeNode instanceof STParameterTreeNode;
	}

	public class STParameterTreeNode extends BaseTreeNode<STParameter> {

		private String uuid;
		private STModel stModel;

		STParameterTreeNode(STParameter model, STModel stModel) {
			super(model, null);

			this.stModel = stModel;
			this.label = getModel().getName();
			this.tooltip = "";
			this.uuid = model.getUuid();

			stModel.getArgumentsSorted()
				.filter(stArgument -> stArgument.getStParameter().equals(model.getUuid()))
				.forEach(appModel().stArgumentConsumer(model)
						.onSingleSTValue((stArgument, stValue) -> add(new STValueTreeNode(stValue, stArgument)))
						.onSingleSTModel((stArgument, stValue) -> add(new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), stArgument)))
						.onListSTValue((stArgument, stValue) -> add(new STValueTreeNode(stValue, stArgument)))
						.onListSTModel((stArgument, stValue) -> add(new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), stArgument)))
						.onKVListConsumer((stArgument, stKVValues) -> add(new STKVArgumentTreeNode(stArgument, model))));
		}

		STParameterTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			this.label = getModel().getName();
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			appModel().doInTransaction(tx -> {

				switch (getModel().getType()) {
					case SINGLE:
						actions.add(newAction("Set from Input", actionEvent -> {
							SwingUtil.showInputDialog(getModel().getName(), tree, inputValue ->
									appModel().doLaterInTransaction(transaction -> {
										appModel().removeArgument(stModel, getModel());
										while (getChildCount() != 0)
											treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));

										final org.javatuples.Pair<STArgument, STValue> newArgument = appModel().newSTArgument(getModel(), inputValue);
										stModel.addArguments(newArgument.getValue0());
										addAndSelectChild(new STValueTreeNode(newArgument.getValue1(), newArgument.getValue0()));
									}));
						}));

						appModel().getSelectedSTValues().forEach(selectedValue -> {
							actions.add(newAction("Set '" + appModel().render(selectedValue, 30) + "'", actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().removeArgument(stModel, getModel());
									while (getChildCount() != 0)
										treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));

									final STArgument stArgument = appModel().newSTArgument(getModel(), selectedValue);
									stModel.addArguments(stArgument);
									addAndSelectChild(new STValueTreeNode(selectedValue, stArgument));
								});
							}));
						});

						appModel().getSelectedSTModels().forEach(selectedModel -> {
							actions.add(newAction("Set '" + appModel().render(selectedModel, 30) + "'", actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().removeArgument(stModel, getModel());
									while (getChildCount() != 0)
										treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));

									final STValue stValue = appModel().newSTValue(selectedModel);
									final STArgument newArgument = appModel().newSTArgument(getModel(), stValue);
									stModel.addArguments(newArgument);
									addAndSelectChild(new STValueTreeNode(stValue, newArgument));
								});
							}));
						});

						actions.add(newAction("Set from Clipboard " + appModel().cut(SwingUtil.fromClipboard(), 30), actionEvent -> {
							appModel().doLaterInTransaction(transaction -> {
								appModel().removeArgument(stModel, getModel());
								while (getChildCount() != 0)
									treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));

								final org.javatuples.Pair<STArgument, STValue> newArgument = appModel().newSTArgument(getModel(), SwingUtil
										.fromClipboard());
								stModel.addArguments(newArgument.getValue0());
								addAndSelectChild(new STValueTreeNode(newArgument.getValue1(), newArgument.getValue0()));
							});
						}));
						if (getModel().getName().startsWith("is") || getModel().getName().startsWith("has")) {
							actions.add(newAction("Set to TRUE", actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().removeArgument(stModel, getModel());
									while (getChildCount() != 0)
										treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));

									final org.javatuples.Pair<STArgument, STValue> newArgument = appModel().newSTArgument(getModel(), "TRUE");
									stModel.addArguments(newArgument.getValue0());
									addAndSelectChild(new STValueTreeNode(newArgument.getValue1(), newArgument.getValue0()));
								});
							}));
						}
						break;
					case LIST:
						actions.add(newAction("Add", actionEvent -> {
							appModel().addList(getModel(), stModel, tree, newArgument -> {

								STValue argumentValue = newArgument.getValue1();
								switch (argumentValue.getType()) {

									case STMODEL:
										final STModel stModel = argumentValue.getStModel();
										addAndSelectChild(new STModelTreeNode(stModel, appModel().findSTTemplateByUuid(stModel
												.getStTemplate()), newArgument.getValue0()));
										break;
									case PRIMITIVE:
										addAndSelectChild(new STValueTreeNode(newArgument.getValue1(), newArgument.getValue0()));
										break;
									case ENUM:
										break;
								}
							});
						}));

						appModel().getSelectedSTValues().forEach(selectedValue -> {
							actions.add(newAction("Add '" + appModel().render(selectedValue, 30) + "'", actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									final STArgument stArgument = appModel().newSTArgument(getModel(), selectedValue);
									stModel.addArguments(stArgument);
									addAndSelectChild(new STValueTreeNode(selectedValue, stArgument));
								});
							}));
						});

						appModel().getSelectedSTModels().forEach(selectedModel -> {
							actions.add(newAction("Add '" + appModel().render(selectedModel, 30) + "'", actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									final STValue stValue = appModel().newSTValue(selectedModel);
									final STArgument newArgument = appModel().newSTArgument(getModel(), stValue);
									stModel.addArguments(newArgument);
									addAndSelectChild(new STValueTreeNode(stValue, newArgument));
								});
							}));
						});

						actions.add(newAction("Add from Clipboard " + appModel().cut(SwingUtil.fromClipboard(), 30), actionEvent -> {
							appModel().doLaterInTransaction(transaction -> {
								final org.javatuples.Pair<STArgument, STValue> newArgument = appModel().newSTArgument(getModel(), SwingUtil
										.fromClipboard());
								stModel.addArguments(newArgument.getValue0());
								addAndSelectChild(new STValueTreeNode(newArgument.getValue1(), newArgument.getValue0()));
							});
						}));
						break;
					case KVLIST:
						actions.add(newAction("Add " + getModel().getName(), actionEvent -> {
							appModel().doLaterInTransaction(transaction -> {
								appModel().addKVArgument(stModel, getModel(), tree, stArgument ->
										addAndSelectChild(new STKVArgumentTreeNode(stArgument, getModel()))
								);
							});
						}));
						break;
				}
			});
			return actions;
		}

	}	

	private Action newAction(String name, Consumer<ActionEvent> actionEventConsumer) {
		return new AbstractAction(name) {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionEventConsumer.accept(e);
			}
		};
	}

	private Action newTransactionAction(String name, Consumer<ActionEvent> actionEventConsumer) {
		return new AbstractAction(name) {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> appModel().doInTransaction(transaction -> actionEventConsumer.accept(e)));
			}
		};
	}

	private void showPopup(BaseTreeNode<?> lastPathComponent, int x, int y) {
		final List<Action> actions = lastPathComponent.getActions();
		if (actions.isEmpty()) return;

		final JPopupMenu pop = new JPopupMenu();
		for (Action action : actions)
			pop.add(action);

		SwingUtilities.invokeLater(() -> pop.show(tree, x, y));
	}

	public <T> java.util.stream.Stream<T> getSelectedNodes(Class<T> type) {
		final TreePath[] selectionPaths = tree.getSelectionPaths();
		if (selectionPaths == null || selectionPaths.length == 0) return java.util.stream.Stream.empty();
		return Arrays.stream(selectionPaths)
				.filter(treePath -> treePath.getLastPathComponent() != null)
				.filter(treePath -> treePath.getLastPathComponent().getClass().isAssignableFrom(type))
				.map(treePath -> (T) treePath.getLastPathComponent());
	}

	private STAppPresentationModel appModel() {
		return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTArgumentAdded(STAppEvents.STArgumentAdded event) {
		treeModel
				.find(STModelTreeNode.class, treeNode -> treeNode.getModel().equals(event.stModel))
				.flatMap(stModelTreeNode -> treeModel.find(stModelTreeNode, STParameterTreeNode.class, baseTreeNode -> ((STParameterTreeNode) baseTreeNode)
						.getModel()
						.getUuid()
						.equals(event.stArgument.getStParameter())))
				.ifPresent(stParameterTreeNode -> {
					final STValue stValue = event.stArgument.getValue();
					switch (stValue.getType()) {
						case STMODEL:
							treeModel.addNodeInSortedOrder(stParameterTreeNode, new STModelTreeNode(stValue.getStModel(), appModel()
									.findSTTemplateByUuid(stValue.getStModel().getStTemplate()), event.stArgument));
							break;
						case PRIMITIVE:
							treeModel.addNodeInSortedOrder(stParameterTreeNode, new STValueTreeNode(stValue, event.stArgument));
							break;
						case ENUM:
							break;
					}
				});
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTModelUpdated(STAppEvents.STModelUpdated event) {
	}

	class STModelEditorNavigatorTreeModel extends DefaultTreeModel {

		public STModelEditorNavigatorTreeModel(BaseTreeNode root) {
			super(root);
		}

		protected Optional<BaseTreeNode<?>> find(java.util.function.Predicate<BaseTreeNode<?>> predicate) {
			return find((BaseTreeNode<?>) getRoot(), predicate);
		}

		protected <T extends BaseTreeNode<?>> Optional<T> find(Class<T> nodeType) {
			return find((BaseTreeNode<?>) getRoot(), navigatorTreeNode ->
					navigatorTreeNode.getClass().isAssignableFrom(nodeType));
		}

		protected <T extends BaseTreeNode<?>> Optional<T> find(Class<T> nodeType, java.util.function.Predicate<T> predicate) {
			return find((BaseTreeNode<?>) getRoot(), navigatorTreeNode -> navigatorTreeNode.getClass()
					.isAssignableFrom(nodeType) && predicate.test((T) navigatorTreeNode));
		}

		protected <T extends BaseTreeNode<?>> Optional<T> find(BaseTreeNode<?> parent, java.util.function.Predicate<BaseTreeNode<?>> predicate) {
			final int childCount = parent.getChildCount();
			for (int i = 0; i < childCount; i++) {
				final BaseTreeNode<?> childAt = (BaseTreeNode<?>) parent.getChildAt(i);
				if (predicate.test(childAt))
					return Optional.of((T) new TreePath(childAt.getPath()).getLastPathComponent());
				else {
					final Optional<T> node = find(childAt, predicate);
					if (node.isPresent()) return node;
				}
			}
			return Optional.empty();
		}

		protected <T extends BaseTreeNode<?>> Optional<T> find(BaseTreeNode<?> parent, Class<T> nodeType, java.util.function.Predicate<BaseTreeNode<?>> predicate) {
			return find(parent, navigatorTreeNode -> navigatorTreeNode.getClass()
					.isAssignableFrom(nodeType) && predicate.test((T) navigatorTreeNode));
		}

		private void addNodeInSortedOrder(BaseTreeNode<?> parent, BaseTreeNode<?> child) {

			int n = parent.getChildCount();
			if (n == 0) {
				parent.add(child);
				nodesWereInserted(parent, new int[]{n});
				return;
			}

			for (int i = 0; i < n; i++) {
				final BaseTreeNode<?> node = (BaseTreeNode<?>) parent.getChildAt(i);
				if (node.getLabel().compareTo(child.getLabel()) > 0) {
					parent.insert(child, i);
					nodesWereInserted(parent, new int[]{i});
					return;
				}
			}

			parent.add(child);
			nodesWereInserted(parent, new int[]{n});
		}
	}
}