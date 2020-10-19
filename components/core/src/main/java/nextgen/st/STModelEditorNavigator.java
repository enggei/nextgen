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

		tree.setCellRenderer(new STModelEditorNavigator.STModelEditorNavigatorCellRenderer());
		tree.addKeyListener(new STModelEditorNavigator.STModelEditorNavigatorKeyListener());
		tree.addMouseListener(new STModelEditorNavigator.STModelEditorNavigatorMouseListener());

		setPreferredSize(new Dimension(600, 600));
		add(new JScrollPane(tree), BorderLayout.CENTER);

		org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	private final class STModelEditorNavigatorCellRenderer extends DefaultTreeCellRenderer {
		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
			final BaseTreeNode<?> node = (BaseTreeNode<?>) value;
			final ImageIcon icon = node.getIcon();
			setIcon(icon);
			setOpenIcon(icon);
			setClosedIcon(icon);
			setLeafIcon(icon);
			setToolTipText(node.getTooltip());
			return super.getTreeCellRendererComponent(tree, node.getLabel(), sel, expanded, leaf, row, hasFocus);
		}
	}

	private final class STModelEditorNavigatorKeyListener extends KeyAdapter {
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
	}

	private final class STModelEditorNavigatorMouseListener extends MouseAdapter {
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

            appModel().doLaterInTransaction(transaction -> {
					if (isSTValueTreeNode(lastPathComponent)) 
						onSTValueTreeNodeSelected((STValueTreeNode) lastPathComponent);
					else if (isSTModelTreeNode(lastPathComponent)) 
						onSTModelTreeNodeSelected((STModelTreeNode) lastPathComponent);
					else if (isSTKVArgumentTreeNode(lastPathComponent)) 
						onSTKVArgumentTreeNodeSelected((STKVArgumentTreeNode) lastPathComponent);
					else if (isSTKVTreeNode(lastPathComponent)) 
						onSTKVTreeNodeSelected((STKVTreeNode) lastPathComponent);
					else if (isSTParameterTreeNode(lastPathComponent)) 
						onSTParameterTreeNodeSelected((STParameterTreeNode) lastPathComponent);
					else 
						onUnhandledNodeSelected((BaseTreeNode<?>) lastPathComponent);
            });
         }
      }
   }

   private void onUnhandledNodeSelected(BaseTreeNode<?> selectedNode) {
   	editor.setText("", null);
   }

	public class BaseTreeNode<T> extends DefaultMutableTreeNode {

		protected String label;
		protected ImageIcon icon;
		protected String tooltip;

		public BaseTreeNode(T model, ImageIcon icon) {
			setUserObject(model);
			setLabel(model.toString());
			this.icon = icon;
			this.tooltip = "";
		}

		@SuppressWarnings("unchecked")
		public T getModel() {
			return (T) getUserObject();
		}

		protected void setLabel(String label) {
			this.label = label;
			if (this.label == null || this.label.trim().length() == 0) this.label = "[EMPTY]";
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

			int n = getChildCount();
			if (n == 0) {
				add(child);
				return new javax.swing.tree.TreePath(child.getPath());
			}

			for (int i = 0; i < n; i++) {
				final BaseTreeNode<?> node = (BaseTreeNode<?>) getChildAt(i);
				if (node.getLabel().compareTo(child.getLabel()) > 0) {
					insert(child, i);
					return new javax.swing.tree.TreePath(child.getPath());
				}
			}

			add(child);

			return new javax.swing.tree.TreePath(child.getPath());
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
	public class STModelTreeNode extends BaseTreeNode<nextgen.st.model.STModel> {

		private String uuid;
		private STTemplate stTemplate;
		private Object stArgument;

		STModelTreeNode(nextgen.st.model.STModel model, STTemplate stTemplate, Object stArgument) {
			super(model, appModel().loadIcon("sq-teal"));

			this.stTemplate = stTemplate;
			this.stArgument = stArgument;
			setLabel(appModel().tryToFindArgument(getModel(), "name", () -> "[" + stTemplate.getName() + "]"));
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
			setLabel(appModel().tryToFindArgument(getModel(), "name", () -> "[" + stTemplate.getName() + "]"));
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newTransactionAction("Copy Model", actionEvent -> {
				SwingUtil.toClipboard("stmodel-" + getModel().getUuid());
			}));
			actions.add(newTransactionAction("Open", actionEvent -> {
				nextgen.events.OpenSTModel.post(getModel());
			}));
			actions.add(newTransactionAction("Visit", actionEvent -> {
				new STVisitorTest(appModel()).visit(((STModelTreeNode)treeModel.getRoot()).getModel());
			}));
			actions.add(newAction("Write to File", actionEvent -> {
				appModel().writeToFile(getModel());
			}));
			actions.add(newAction("Delete", actionEvent -> {
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

	private boolean isSTModelTreeNode(Object treeNode) {
		return treeNode instanceof STModelTreeNode;
	}

	private Optional<STModelTreeNode> findSTModelTreeNode(java.util.function.Predicate<STModelTreeNode> predicate) {
		return treeModel.find(STModelTreeNode.class, predicate);
	}

	private Optional<STModelTreeNode> findSTModelTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STModelTreeNode> predicate) {
		return treeModel.find(parent, STModelTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STModelTreeNode> getSelectedSTModelTreeNodes() {
		return getSelectedNodes(STModelTreeNode.class);
	}

	private void onSTModelTreeNodeSelected(STModelTreeNode selectedNode) {
		editor.setText(appModel().render(selectedNode.getModel()), null);
		nextgen.events.STModelEditorTreeNodeClicked.post(selectedNode.getModel());
	}

	// STValueTreeNode
	public class STValueTreeNode extends BaseTreeNode<nextgen.st.model.STValue> {

		private String uuid;
		private Object stArgument;

		STValueTreeNode(nextgen.st.model.STValue model, Object stArgument) {
			super(model, appModel().loadIcon("sq-orange"));

			this.stArgument = stArgument;
			setLabel(getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? "[EMPTY]" : getModel().getValue());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STValueTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? "[EMPTY]" : getModel().getValue());
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
			actions.add(newAction("Delete", actionEvent -> {
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

	private boolean isSTValueTreeNode(Object treeNode) {
		return treeNode instanceof STValueTreeNode;
	}

	private Optional<STValueTreeNode> findSTValueTreeNode(java.util.function.Predicate<STValueTreeNode> predicate) {
		return treeModel.find(STValueTreeNode.class, predicate);
	}

	private Optional<STValueTreeNode> findSTValueTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STValueTreeNode> predicate) {
		return treeModel.find(parent, STValueTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STValueTreeNode> getSelectedSTValueTreeNodes() {
		return getSelectedNodes(STValueTreeNode.class);
	}

	private void onSTValueTreeNodeSelected(STValueTreeNode selectedNode) {
		editor.setText(appModel().render(selectedNode.getModel()), selectedNode);
	}

	// STKVArgumentTreeNode
	public class STKVArgumentTreeNode extends BaseTreeNode<nextgen.st.model.STArgument> {
		private STParameter stParameter;

		STKVArgumentTreeNode(nextgen.st.model.STArgument model, STParameter stParameter) {
			super(model, null);

			this.stParameter = stParameter;
			setLabel(appModel().tryToFindArgument(getModel().getKeyValues(), stParameter, "name", stParameter::getName));
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
			setLabel(appModel().tryToFindArgument(getModel().getKeyValues(), stParameter, "name", stParameter::getName));
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
											final STValue stValue = appModel().db.newSTValue(inputValue);
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
								final STValue stValue = appModel().db.newSTValue(SwingUtil.fromClipboard());
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
			actions.add(newTransactionAction("Delete", actionEvent -> {
				appModel().remove(getModel());
			}));
			return actions;
		}

	}

	private boolean isSTKVArgumentTreeNode(Object treeNode) {
		return treeNode instanceof STKVArgumentTreeNode;
	}

	private Optional<STKVArgumentTreeNode> findSTKVArgumentTreeNode(java.util.function.Predicate<STKVArgumentTreeNode> predicate) {
		return treeModel.find(STKVArgumentTreeNode.class, predicate);
	}

	private Optional<STKVArgumentTreeNode> findSTKVArgumentTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STKVArgumentTreeNode> predicate) {
		return treeModel.find(parent, STKVArgumentTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STKVArgumentTreeNode> getSelectedSTKVArgumentTreeNodes() {
		return getSelectedNodes(STKVArgumentTreeNode.class);
	}

	private void onSTKVArgumentTreeNodeSelected(STKVArgumentTreeNode selectedNode) {
		editor.setText(appModel().render(selectedNode.getModel(), selectedNode.stParameter), null);
	}

	// STKVTreeNode
	public class STKVTreeNode extends BaseTreeNode<nextgen.st.model.STArgumentKV> {

		private String uuid;
		private STArgument stArgument;
		private STParameterKey stParameterKey;

		STKVTreeNode(nextgen.st.model.STArgumentKV model, STArgument stArgument, STParameterKey stParameterKey) {
			super(model, null);

			this.stArgument = stArgument;
			this.stParameterKey = stParameterKey;
			setLabel(stParameterKey.getName());
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
			setLabel(stParameterKey.getName());
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			appModel().doInTransaction(transaction -> {

				getSelectedNodes(STValueTreeNode.class).forEach(stValueTreeNode -> {
					actions.add(newAction("Set " + appModel().render(stValueTreeNode.getModel(), 30), actionEvent -> {
						SwingUtil.showInputDialog(stParameterKey.getName(), tree, inputValue ->
								appModel().doLaterInTransaction(transaction1 -> {
									final STValue stValue = stValueTreeNode.getModel();
									getModel().setValue(stValue);
									while (getChildCount() != 0)
										treeModel.removeNodeFromParent((MutableTreeNode) getChildAt(0));
									addAndSelectChild(new STValueTreeNode(stValue, getModel()));
									nodeChanged();
								}));
					}));
				});

				appModel().getSelectedSTValues().forEach(selectedValue -> {
					actions.add(newTransactionAction("Set " + appModel().render(selectedValue, 30), actionEvent -> {
						getModel().setValue(selectedValue);
						while (getChildCount() != 0)
							treeModel.removeNodeFromParent((MutableTreeNode) getChildAt(0));
						addAndSelectChild(new STValueTreeNode(selectedValue, getModel()));
						nodeChanged();
					}));
				});

				appModel().getSelectedSTModels().forEach(selectedModel -> {
					actions.add(newTransactionAction("Set " + appModel().render(selectedModel, 30), actionEvent -> {
						getModel().setValue(appModel().db.newSTValue(selectedModel));
						while (getChildCount() != 0)
							treeModel.removeNodeFromParent((MutableTreeNode) getChildAt(0));
						addAndSelectChild(new STModelTreeNode(selectedModel, appModel().findSTTemplateByUuid(selectedModel.getStTemplate()), getModel()));
						nodeChanged();
					}));
				});

				actions.add(newAction("Set from input", actionEvent -> {
					SwingUtil.showInputDialog(stParameterKey.getName(), tree, inputValue ->
							appModel().doLaterInTransaction(transaction1 -> {
								final STValue stValue = appModel().db.newSTValue(inputValue);
								getModel().setValue(stValue);
								while (getChildCount() != 0)
									treeModel.removeNodeFromParent((MutableTreeNode) getChildAt(0));
								addAndSelectChild(new STValueTreeNode(stValue, getModel()));
								nodeChanged();
							}));
				}));

				actions.add(newAction("Set '" + appModel().cut(SwingUtil.fromClipboard(), 30) + "'", actionEvent -> {
					appModel().doLaterInTransaction(transaction1 -> {
						final STValue stValue = appModel().db.newSTValue(SwingUtil.fromClipboard());
						getModel().setValue(stValue);
						while (getChildCount() != 0)
							treeModel.removeNodeFromParent((MutableTreeNode) getChildAt(0));
						addAndSelectChild(new STValueTreeNode(stValue, getModel()));
						nodeChanged();
					});
				}));
			});
			actions.add(newAction("Delete", actionEvent -> {
				appModel().doLaterInTransaction(transaction1 -> {
					stArgument.removeKeyValues(getModel());
					treeModel.removeNodeFromParent(this);
					editor.setText("", null);
				});
			}));
			return actions;
		}

	}

	private boolean isSTKVTreeNode(Object treeNode) {
		return treeNode instanceof STKVTreeNode;
	}

	private Optional<STKVTreeNode> findSTKVTreeNode(java.util.function.Predicate<STKVTreeNode> predicate) {
		return treeModel.find(STKVTreeNode.class, predicate);
	}

	private Optional<STKVTreeNode> findSTKVTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STKVTreeNode> predicate) {
		return treeModel.find(parent, STKVTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STKVTreeNode> getSelectedSTKVTreeNodes() {
		return getSelectedNodes(STKVTreeNode.class);
	}

	private void onSTKVTreeNodeSelected(STKVTreeNode selectedNode) {
	}

	// STParameterTreeNode
	public class STParameterTreeNode extends BaseTreeNode<nextgen.st.domain.STParameter> {

		private String uuid;
		private STModel stModel;

		STParameterTreeNode(nextgen.st.domain.STParameter model, STModel stModel) {
			super(model, null);

			this.stModel = stModel;
			setLabel(getModel().getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

			stModel.getArgumentsSorted()
				.filter(stArgument -> stArgument.getStParameter().equals(model.getUuid()))
				.forEach(appModel().stArgumentConsumer(model)
						.onSingleSTValue((stArgument, stValue) -> addChild(new STValueTreeNode(stValue, stArgument)))
						.onSingleSTModel((stArgument, stValue) -> addChild(new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), stArgument)))
						.onListSTValue((stArgument, stValue) -> addChild(new STValueTreeNode(stValue, stArgument)))
						.onListSTModel((stArgument, stValue) -> addChild(new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), stArgument)))
						.onKVListConsumer((stArgument, stKVValues) -> addChild(new STKVArgumentTreeNode(stArgument, model))));
		}

		STParameterTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(getModel().getName());
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			appModel().doInTransaction(tx -> {

				final String fromClipboard = nextgen.utils.SwingUtil.fromClipboard();

				switch (getModel().getType()) {
					case SINGLE:

						getSelectedNodes(STValueTreeNode.class).forEach(stValueTreeNode -> {
							actions.add(newAction("Set " + appModel().render(stValueTreeNode.getModel(), 30), actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().removeArgument(stModel, getModel());
									while (getChildCount() != 0)
										treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));
									appModel().newSTArgument(stModel, getModel(), stValueTreeNode.getModel());
								});
							}));
						});

						actions.add(newAction("Set from Input", actionEvent -> {
							SwingUtil.showInputDialog(getModel().getName(), tree, inputValue ->
									appModel().doLaterInTransaction(transaction -> {
										appModel().removeArgument(stModel, getModel());
										while (getChildCount() != 0)
											treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));
										appModel().newSTArgument(stModel, getModel(), inputValue);
									}));
						}));

						appModel().getSelectedSTValues().forEach(selectedValue -> {
							actions.add(newAction("Set " + appModel().render(selectedValue, 30), actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().removeArgument(stModel, getModel());
									while (getChildCount() != 0)
										treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));
									appModel().newSTArgument(stModel, getModel(), selectedValue);
								});
							}));
						});

						appModel().getSelectedSTModels().forEach(selectedModel -> {
							actions.add(newAction("Set " + appModel().render(selectedModel, 30), actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().removeArgument(stModel, getModel());
									while (getChildCount() != 0)
										treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));
									appModel().newSTArgument(stModel, getModel(), selectedModel);
								});
							}));
						});

						if (fromClipboard != null && fromClipboard.startsWith("stmodel-")) {
							actions.add(newAction("Set " + fromClipboard.substring(8), actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().removeArgument(stModel, getModel());
									while (getChildCount() != 0)
										treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));
									appModel().newSTArgument(stModel, getModel(), appModel().db.cloneSTModel(fromClipboard.substring(8)));
								});
							}));
						} else {
							actions.add(newAction("Set from Clipboard '" + appModel().cut(fromClipboard, 30) + "'", actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().removeArgument(stModel, getModel());
									while (getChildCount() != 0)
										treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));
									appModel().newSTArgument(stModel, getModel(), SwingUtil.fromClipboard());
								});
							}));
						}
						if (getModel().getName().startsWith("is") || getModel().getName().startsWith("has")) {
							actions.add(newAction("Set to TRUE", actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().removeArgument(stModel, getModel());
									while (getChildCount() != 0)
										treeModel.removeNodeFromParent((BaseTreeNode<?>) getChildAt(0));
									appModel().newSTArgument(stModel, getModel(), "TRUE");
								});
							}));
						}
						break;
					case LIST:

						getSelectedNodes(STValueTreeNode.class).forEach(stValueTreeNode -> {
							actions.add(newAction("Add " + appModel().render(stValueTreeNode.getModel(), 30), actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().newSTArgument(stModel, getModel(), stValueTreeNode.getModel());
								});
							}));
						});

						appModel().getSelectedSTValues().forEach(selectedValue -> {
							actions.add(newAction("Add " + appModel().render(selectedValue, 30), actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().newSTArgument(stModel, getModel(), selectedValue);
								});
							}));
						});

						appModel().getSelectedSTModels().forEach(selectedModel -> {
							actions.add(newAction("Add " + appModel().render(selectedModel, 30), actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().newSTArgument(stModel, getModel(), selectedModel);
								});
							}));
						});

						appModel().getSelectedSTTemplates().forEach(selectedValue -> {
							actions.add(newAction("Add new " + selectedValue.getName(), actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().newSTArgument(stModel, getModel(), appModel().newSTModel(selectedValue));
								});
							}));
						});

						if (fromClipboard != null && fromClipboard.startsWith("stmodel-")) {
							actions.add(newAction("Add " + fromClipboard.substring(8), actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().newSTArgument(stModel, getModel(), appModel().db.cloneSTModel(fromClipboard.substring(8)));
								});
							}));
						} else {
							actions.add(newAction("Add from Clipboard '" + appModel().cut(SwingUtil.fromClipboard(), 30) + "'", actionEvent -> {
								appModel().doLaterInTransaction(transaction -> {
									appModel().newSTArgument(stModel, getModel(), SwingUtil.fromClipboard());
								});
							}));
						}

						actions.add(newAction("Add", actionEvent -> {
							appModel().addList(getModel(), stModel, tree, newArgument -> {});
						}));

						actions.add(newAction("Add Multiple", actionEvent -> {
							appModel().addMultiple(tree,  stModel, getModel());
						}));
						
						break;
					case KVLIST:
						actions.add(newAction("Add " + getModel().getName(), actionEvent -> {
							appModel().doLaterInTransaction(transaction -> {
								appModel().addKVArgument(stModel, getModel(), tree, stArgument -> addAndSelectChild(new STKVArgumentTreeNode(stArgument, getModel())));
							});
						}));
						break;
				}
			});
			return actions;
		}

	}

	private boolean isSTParameterTreeNode(Object treeNode) {
		return treeNode instanceof STParameterTreeNode;
	}

	private Optional<STParameterTreeNode> findSTParameterTreeNode(java.util.function.Predicate<STParameterTreeNode> predicate) {
		return treeModel.find(STParameterTreeNode.class, predicate);
	}

	private Optional<STParameterTreeNode> findSTParameterTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STParameterTreeNode> predicate) {
		return treeModel.find(parent, STParameterTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STParameterTreeNode> getSelectedSTParameterTreeNodes() {
		return getSelectedNodes(STParameterTreeNode.class);
	}

	private void onSTParameterTreeNodeSelected(STParameterTreeNode selectedNode) {
		editor.setText("", null);
		selectedNode.getParentNode(nextgen.st.STModelEditorNavigator.STModelTreeNode.class)
				.ifPresent(treeNode -> nextgen.events.STParameterEditorTreeNodeClicked.post(selectedNode.getModel(), treeNode.getModel()));
	}	

	private Action newAction(String name, Consumer<ActionEvent> actionEventConsumer) {
		return new AbstractAction(name) {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> actionEventConsumer.accept(e));
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

	public <T> java.util.stream.Stream<T> getSelectedNodes() {
		final TreePath[] selectionPaths = tree.getSelectionPaths();
		if (selectionPaths == null || selectionPaths.length == 0) return java.util.stream.Stream.empty();
		return Arrays.stream(selectionPaths)
				.filter(treePath -> treePath.getLastPathComponent() != null)
				.map(treePath -> (T) treePath.getLastPathComponent());
	}

	private STAppPresentationModel appModel() {
		return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTModelDeleted(nextgen.events.STModelDeleted event) {
		findSTModelTreeNode(stModelTreeNode -> stModelTreeNode.uuid.equals(event.uuid))
				.filter(treeNode -> treeNode.getParent() != null)
				.ifPresent(treeModel::removeNodeFromParent);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTArgumentAdded(nextgen.events.NewSTArgument event) {
		findSTModelTreeNode(treeNode -> treeNode.getModel().equals(event.stModel))
					.ifPresent(stModelTreeNode -> findSTParameterTreeNode(stModelTreeNode, stParameterTreeNode -> stParameterTreeNode.getModel().getUuid().equals(event.stArgument.getStParameter()))
							.ifPresent(stParameterTreeNode -> {
								appModel().stArgumentConsumer(event.stParameter)
											 .onSingleSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STValueTreeNode(stValue, event.stArgument)))
											 .onSingleSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), event.stArgument)))
											 .onListSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STValueTreeNode(stValue, event.stArgument)))
											 .onListSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), event.stArgument)))
											 .onKVListConsumer((stArgument, stKVValues) -> treeModel.addNodeInSortedOrder(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STKVArgumentTreeNode(event.stArgument, event.stParameter)));
								stModelTreeNode.nodeChanged();
							}));
	}

	class STModelEditorNavigatorTreeModel extends DefaultTreeModel {

		public STModelEditorNavigatorTreeModel(BaseTreeNode root) {
			super(root);
		}

		protected Optional<BaseTreeNode<?>> find(java.util.function.Predicate<BaseTreeNode<?>> predicate) {
			return find((BaseTreeNode<?>) getRoot(), predicate);
		}

		protected <T extends BaseTreeNode<?>> Optional<T> find(Class<T> nodeType) {
			final BaseTreeNode<?> root = (BaseTreeNode<?>) getRoot();
			if (root.getClass().isAssignableFrom(nodeType)) return Optional.of((T) root);
			return find((BaseTreeNode<?>) getRoot(), navigatorTreeNode ->
					navigatorTreeNode.getClass().isAssignableFrom(nodeType));
		}

		protected <T extends BaseTreeNode<?>> Optional<T> find(Class<T> nodeType, java.util.function.Predicate<T> predicate) {
			final BaseTreeNode<?> root = (BaseTreeNode<?>) getRoot();
			if (root.getClass().isAssignableFrom(nodeType) && predicate.test((T) root)) return Optional.of((T) root);
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

		protected <T extends BaseTreeNode<?>> Optional<T> find(BaseTreeNode<?> parent, Class<T> nodeType, java.util.function.Predicate<T> predicate) {
			return find(parent, navigatorTreeNode -> navigatorTreeNode.getClass()
					.isAssignableFrom(nodeType) && predicate.test((T) navigatorTreeNode));
		}

		private void addNodeInSortedOrderAndSelect(BaseTreeNode<?> parent, BaseTreeNode<?> child) {
			addNodeInSortedOrder(parent, child);
			tree.scrollPathToVisible(child.getThisPath());
			tree.setSelectionPath(child.getThisPath());
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