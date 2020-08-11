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
	private final STAppPresentationModel presentationModel;
	private final DefaultTreeModel treeModel;

	private STModel model;
	private STModelEditor editor;

	public STModelEditorNavigator(STAppPresentationModel presentationModel, STModel model, STModelEditor editor) {
		super(new BorderLayout());

		this.model = model;
		this.editor = editor;

		this.presentationModel = presentationModel;

		treeModel = new DefaultTreeModel(new STModelTreeNode(model, presentationModel.findSTTemplateByUuid(model.getStTemplate()), null));
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

					if (lastPathComponent instanceof STModelTreeNode) {
						final STModelTreeNode selectedNode = (STModelTreeNode) lastPathComponent;
						editor.setText(presentationModel.renderInTransaction(selectedNode.getModel()), null);
					} else if (lastPathComponent instanceof STValueTreeNode) {
						final STValueTreeNode selectedNode = (STValueTreeNode) lastPathComponent;
						editor.setText(presentationModel.renderInTransaction(selectedNode.getModel()), selectedNode);
					} else if (lastPathComponent instanceof STKVArgumentTreeNode) {
						final STKVArgumentTreeNode selectedNode = (STKVArgumentTreeNode) lastPathComponent;
						editor.setText(presentationModel.renderInTransaction(selectedNode.getModel(), selectedNode.stParameter), null);
					} else {
						editor.setText("", null);
					}
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

		setPreferredSize(new Dimension(300, 600));
		add(new JScrollPane(tree), BorderLayout.CENTER);

	}

	public class BaseTreeNode<T> extends DefaultMutableTreeNode {

		protected String label;
		protected ImageIcon icon;
		protected String tooltip;

		public BaseTreeNode(T model, String icon) {
			setUserObject(model);
			this.label = model.toString();
			this.icon = presentationModel.loadIcon(icon);
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
	public class STModelTreeNode extends BaseTreeNode<STModel> {

		private String uuid;
		private STTemplate stTemplate;
		private Object stArgument;

		STModelTreeNode(STModel model, STTemplate stTemplate, Object stArgument) {
			super(model, null);

			this.stTemplate = stTemplate;
			this.stArgument = stArgument;
			this.label = presentationModel.tryToFindArgument(getModel(), "name", () -> "[" + stTemplate.getName() + "]");
			this.tooltip = "";
			this.uuid = model.getUuid();

			stTemplate.getParameters()
					.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
					.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));
		}

		@Override
		public void nodeChanged() {
			this.label = presentationModel.tryToFindArgument(getModel(), "name", () -> "[" + stTemplate.getName() + "]");
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newAction("Remove", actionEvent -> {
				presentationModel.doLaterInTransaction(transaction -> {
					if (stArgument instanceof STArgument) {
						STArgument argument = (STArgument) stArgument;
						argument.getIncomingArguments().findFirst().ifPresent(stModel -> stModel.removeArguments(argument));
						treeModel.removeNodeFromParent(this);
						editor.setText("", null);
					} else if (stArgument instanceof STArgumentKV) {
						STArgumentKV argumentKV = (STArgumentKV) stArgument;
						argumentKV.getIncomingKeyValues().findFirst().ifPresent(stArgument -> stArgument.removeKeyValues(argumentKV));
						treeModel.removeNodeFromParent(this);
						editor.setText("", null);
					}
				});
			}));
			return actions;
		}

	}

	// STValueTreeNode
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

		@Override
		public void nodeChanged() {
			this.label = getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? "[EMPTY]" : getModel().getValue();
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newAction("Remove", actionEvent -> {
				presentationModel.doLaterInTransaction(transaction -> {
					if (stArgument instanceof STArgument) {
						STArgument argument = (STArgument) stArgument;
						argument.getIncomingArguments().findFirst().ifPresent(stModel -> stModel.removeArguments(argument));
						treeModel.removeNodeFromParent(this);
						editor.setText("", null);
					} else if (stArgument instanceof STArgumentKV) {
						STArgumentKV argumentKV = (STArgumentKV) stArgument;
						argumentKV.getIncomingKeyValues().findFirst().ifPresent(stArgument -> stArgument.removeKeyValues(argumentKV));
						treeModel.removeNodeFromParent(this);
						editor.setText("", null);
					}
				});
			}));
			return actions;
		}

	}

	// STKVArgumentTreeNode
	public class STKVArgumentTreeNode extends BaseTreeNode<STArgument> {
		private STParameter stParameter;

		STKVArgumentTreeNode(STArgument model, STParameter stParameter) {
			super(model, null);

			this.stParameter = stParameter;
			this.label = presentationModel.tryToFindArgument(getModel().getKeyValues(), stParameter, "name", stParameter::getName);
			this.tooltip = "";

			stParameter.getKeys().forEach(stParameterKey -> getModel().getKeyValues()
					.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
					.findFirst()
					.ifPresent(stArgumentKV -> add(new STKVTreeNode(stArgumentKV, getModel(), stParameterKey))));
		}

		@Override
		public void nodeChanged() {
			this.label = presentationModel.tryToFindArgument(getModel().getKeyValues(), stParameter, "name", stParameter::getName);
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			presentationModel.doInTransaction(transaction -> {
				stParameter.getKeys().forEach(stParameterKey -> {
					actions.add(newAction(stParameterKey.getName() + " from input", actionEvent -> {
							SwingUtil.showInputDialog(stParameterKey.getName(), tree, inputValue ->
									presentationModel.doLaterInTransaction(transaction1 -> {
											int childCount = getChildCount();
											final STValue stValue = presentationModel.newSTValue(inputValue);
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

											final STArgumentKV stArgumentKV = presentationModel.newSTArgumentKV(stParameterKey, stValue);
											getModel().addKeyValues(stArgumentKV);
											addAndSelectChild(new STKVTreeNode(stArgumentKV, getModel(), stParameterKey));
									}));
					}));
					actions.add(newAction(stParameterKey.getName() + " from Clipboard " + presentationModel.cut(SwingUtil.fromClipboard(), 30), actionEvent -> {
							presentationModel.doLaterInTransaction(transaction1 -> {
								int childCount = getChildCount();
								final STValue stValue = presentationModel.newSTValue(SwingUtil.fromClipboard());
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

								final STArgumentKV stArgumentKV = presentationModel.newSTArgumentKV(stParameterKey, stValue);
								getModel().addKeyValues(stArgumentKV);
								addAndSelectChild(new STKVTreeNode(stArgumentKV, getModel(), stParameterKey));
							});
					}));
				});
			});
			actions.add(newAction("Remove", actionEvent -> {
				presentationModel.doLaterInTransaction(transaction -> {
					getModel().getIncomingArguments().findFirst().ifPresent(stModel -> stModel.removeArguments(getModel()));
					treeModel.removeNodeFromParent(this);
					editor.setText("", null);
				});
			}));
			return actions;
		}

	}

	// STKVTreeNode
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
						add(new STModelTreeNode(stValue.getStModel(), presentationModel.findSTTemplateByUuid(stValue.getStModel().getStTemplate()), model));
						break;
					case PRIMITIVE:
						add(new STValueTreeNode(stValue, model));
						break;
					case ENUM:
						break;
				}
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
			presentationModel.doInTransaction(transaction -> {

				actions.add(newAction("Set from input", actionEvent -> {
					SwingUtil.showInputDialog(stParameterKey.getName(), tree, inputValue ->
								presentationModel.doLaterInTransaction(transaction1 -> {
									final STValue stValue = presentationModel.newSTValue(inputValue);
									getModel().setValue(stValue);
									while (getChildCount() != 0)
											treeModel.removeNodeFromParent((MutableTreeNode) getChildAt(0));
									addAndSelectChild(new STValueTreeNode(stValue, getModel()));
									nodeChanged();
								}));
				}));

				actions.add(newAction("Set from Clipboard " + presentationModel.cut(SwingUtil.fromClipboard(), 30), actionEvent -> {
					presentationModel.doLaterInTransaction(transaction1 -> {
							final STValue stValue = presentationModel.newSTValue(SwingUtil.fromClipboard());
							getModel().setValue(stValue);
							while (getChildCount() != 0)
								treeModel.removeNodeFromParent((MutableTreeNode) getChildAt(0));
							addAndSelectChild(new STValueTreeNode(stValue, getModel()));
							nodeChanged();
					});
				}));
			});
			actions.add(newAction("Remove", actionEvent -> {
				presentationModel.doLaterInTransaction(transaction1 -> {
					stArgument.removeKeyValues(getModel());
					treeModel.removeNodeFromParent(this);
					editor.setText("", null);
				});
			}));
			return actions;
		}

	}

	// STParameterTreeNode
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
				.filter(stArgument -> stArgument.getStParameter().equals(model.uuid()))
				.forEach(presentationModel.stArgumentConsumer(model)
						.onSingleSTValue((stArgument, stValue) -> add(new STValueTreeNode(stValue, stArgument)))
						.onSingleSTModel((stArgument, stValue) -> add(new STModelTreeNode(stValue.getStModel(), presentationModel.findSTTemplateByUuid(stValue.getStModel().getStTemplate()), stArgument)))
						.onListSTValue((stArgument, stValue) -> add(new STValueTreeNode(stValue, stArgument)))
						.onListSTModel((stArgument, stValue) -> add(new STModelTreeNode(stValue.getStModel(), presentationModel.findSTTemplateByUuid(stValue.getStModel().getStTemplate()), stArgument)))
						.onKVListConsumer((stArgument, stKVValues) -> add(new STKVArgumentTreeNode(stArgument, model))));
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
			switch (getModel().getType()) {
				case SINGLE:
					actions.add(newAction("Set from Input", actionEvent -> {
						SwingUtil.showInputDialog(getModel().getName(), tree, inputValue ->
								presentationModel.doLaterInTransaction(transaction -> {
									presentationModel.removeArgument(stModel, getModel());
									while (getChildCount() != 0)
										treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));

									final org.javatuples.Pair<STArgument, STValue> newArgument = presentationModel.newSTArgument(getModel(), inputValue);
									stModel.addArguments(newArgument.getValue0());
									addAndSelectChild(new STValueTreeNode(newArgument.getValue1(), newArgument.getValue0()));
								}));
					}));
					actions.add(newAction("Set from Clipboard " + presentationModel.cut(SwingUtil.fromClipboard(), 30), actionEvent -> {
						presentationModel.doLaterInTransaction(transaction -> {
							presentationModel.removeArgument(stModel, getModel());
							while (getChildCount() != 0)
								treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));

							final org.javatuples.Pair<STArgument, STValue> newArgument = presentationModel.newSTArgument(getModel(), SwingUtil.fromClipboard());
							stModel.addArguments(newArgument.getValue0());
							addAndSelectChild(new STValueTreeNode(newArgument.getValue1(), newArgument.getValue0()));
						});
					}));
					if (getModel().getName().startsWith("is") || getModel().getName().startsWith("has")) {
						actions.add(newAction("Set to TRUE", actionEvent -> {
							presentationModel.doLaterInTransaction(transaction -> {
								presentationModel.removeArgument(stModel, getModel());
								while (getChildCount() != 0)
									treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));

								final org.javatuples.Pair<STArgument, STValue> newArgument = presentationModel.newSTArgument(getModel(), "TRUE");
								stModel.addArguments(newArgument.getValue0());
								addAndSelectChild(new STValueTreeNode(newArgument.getValue1(), newArgument.getValue0()));
							});
						}));
					}
					break;
				case LIST:
					actions.add(newAction("Add from Input", actionEvent -> {
						SwingUtil.showInputDialog(getModel().getName(), tree, inputValue ->
								presentationModel.doLaterInTransaction(transaction -> {
									final org.javatuples.Pair<STArgument, STValue> newArgument = presentationModel.newSTArgument(getModel(), inputValue);
									stModel.addArguments(newArgument.getValue0());
									addAndSelectChild(new STValueTreeNode(newArgument.getValue1(), newArgument.getValue0()));
								}));
					}));
					actions.add(newAction("Add from Clipboard " + presentationModel.cut(SwingUtil.fromClipboard(), 30), actionEvent -> {
						presentationModel.doLaterInTransaction(transaction -> {
							final org.javatuples.Pair<STArgument, STValue> newArgument = presentationModel.newSTArgument(getModel(), SwingUtil.fromClipboard());
							stModel.addArguments(newArgument.getValue0());
							addAndSelectChild(new STValueTreeNode(newArgument.getValue1(), newArgument.getValue0()));
						});
					}));
					break;
				case KVLIST:
					actions.add(newAction("Add " + getModel().getName(), actionEvent -> {
						presentationModel.doLaterInTransaction(transaction -> {
							presentationModel.addKVArgument(stModel, getModel(), tree, stArgument -> 
								addAndSelectChild(new STKVArgumentTreeNode(stArgument, getModel()))
							);
						});
					}));
					break;
			}
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

	private void showPopup(BaseTreeNode<?> lastPathComponent, int x, int y) {
		final List<Action> actions = lastPathComponent.getActions();
		if (actions.isEmpty()) return;

		final JPopupMenu pop = new JPopupMenu();
		pop.add("With " + presentationModel.cut(lastPathComponent.getLabel()) + " :");
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

}