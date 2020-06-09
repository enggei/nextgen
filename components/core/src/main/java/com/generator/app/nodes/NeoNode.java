package com.generator.app.nodes;

import com.generator.app.*;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.domain.DomainPluginGroup;
import com.generator.generators.neo4j.Neo4jGroup;
import com.generator.generators.stringtemplate.StringTemplatePlugin;
import com.generator.neo.NeoModel;
import com.generator.util.GeneratedFile;
import com.generator.util.NeoUtil;
import com.generator.util.SwingUtil;
import org.abego.treelayout.Configuration;
import org.abego.treelayout.NodeExtentProvider;
import org.abego.treelayout.TreeForTreeLayout;
import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.util.AbstractTreeForTreeLayout;
import org.abego.treelayout.util.DefaultConfiguration;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Label;
import org.piccolo2d.PLayer;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PDragSequenceEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.app.AppEvents.*;
import static com.generator.util.NeoUtil.*;

/**
 * Created 01.10.17.
 */
public class NeoNode extends PNode {

    private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NeoNode.class);

    private Workspace workspace;
    private Workspace.NodeCanvas nodeCanvas;
    private final PText delegate;
    private Color defaultNodeColor = Color.BLACK;

    public NeoNode(Workspace workspace, Workspace.NodeCanvas nodeCanvas, Node node, Point2D offset, PBasicInputEventHandler canvasInputListener, PLayer nodeLayer) {
        super();
        this.workspace = workspace;
        this.nodeCanvas = nodeCanvas;

        delegate = new PText(getNodeText(nodeCanvas.nodePaintStrategy, node));
        addChild(delegate);

        addAttribute("id", node.getId());
        addAttribute("node", node);

        for (org.neo4j.graphdb.Label label : node.getLabels()) {
            final Node colorNode = workspace.app.model.graph().findNode(AppMotif.Entities._Color, "label", label.name());
            if (colorNode == null) continue;
            final String color = getString(colorNode, AppMotif.Properties._color.name());
            defaultNodeColor = Color.decode(color);
            break;
        }
        if (defaultNodeColor == null) defaultNodeColor = Color.BLACK;

        setOffset(offset == null ? (node.hasProperty(AppMotif.Properties.x.name()) ? new Point2D.Double(getDouble(node, AppMotif.Properties.x.name()), getDouble(node, AppMotif.Properties.y.name())) : nodeCanvas.newRandomPosition()) : offset);

        final PBasicInputEventHandler nodeEventListener = new PDragSequenceEventHandler() {
            @Override
            protected final void startDrag(PInputEvent event) {
                super.startDrag(event);
            }

            @Override
            protected final void drag(PInputEvent event) {
                super.drag(event);
                translate(event.getDelta().width, event.getDelta().height);
            }

            @Override
            protected final void endDrag(PInputEvent event) {
                super.endDrag(event);
            }

            @Override
            protected final boolean shouldStartDragInteraction(PInputEvent event) {
                return super.shouldStartDragInteraction(event);
            }

            @Override
            public void mouseEntered(PInputEvent event) {
                event.getInputManager().setKeyboardFocus(this);
                highlight();
                workspace.app.events.firePropertyChange(NODE_HIGHLIGHTED, NeoNode.this);
            }

            @Override
            public void mouseExited(PInputEvent event) {
                event.getInputManager().setKeyboardFocus(canvasInputListener);
                unhighlight();
            }

            @Override
            public void mouseClicked(PInputEvent event) {
                if (event.isRightMouseButton()) {
                    SwingUtilities.invokeLater(() -> onRightClick(event));
                } else if (event.isLeftMouseButton()) {
                    SwingUtilities.invokeLater(() -> onLeftClick(event));
                } else if (event.isMiddleMouseButton()) {
                    SwingUtilities.invokeLater(() -> onMiddleClick(event));
                }
            }

            private void onLeftClick(PInputEvent event) {
                toggleSelect();
                workspace.app.events.firePropertyChange(NODES_SELECTED, nodeCanvas.getSelectedNodes());
            }

            private void onMiddleClick(PInputEvent event) {

            }

            @Override
            public void keyPressed(PInputEvent event) {
                switch (event.getKeyCode()) {

                    case KeyEvent.VK_1:
                        SwingUtilities.invokeLater(() -> {
                            layoutTree(new DefaultConfiguration<>(150, 15, Configuration.Location.Left), !event.isControlDown(), NeoNode.this, workspace.app);
                        });
                        break;

                    case KeyEvent.VK_2:
                        SwingUtilities.invokeLater(() -> {
                            layoutTree(new DefaultConfiguration<>(150, 15, Configuration.Location.Right), !event.isControlDown(), NeoNode.this, workspace.app);
                        });
                        break;

                    case KeyEvent.VK_3:
                        SwingUtilities.invokeLater(() -> {
                            layoutTree(new DefaultConfiguration<>(150, 15, Configuration.Location.Bottom), !event.isControlDown(), NeoNode.this, workspace.app);
                        });
                        break;

                    case KeyEvent.VK_4:
                        SwingUtilities.invokeLater(() -> {
                            layoutTree(new DefaultConfiguration<>(150, 15, Configuration.Location.Top), !event.isControlDown(), NeoNode.this, workspace.app);
                        });
                        break;


                    case KeyEvent.VK_C:
                        SwingUtilities.invokeLater(() -> workspace.app.events.firePropertyChange(NODES_CLOSED, Collections.singleton(NeoNode.this)));
                        break;


                    case KeyEvent.VK_R:
                        SwingUtilities.invokeLater(() -> {

                            final Set<NeoNode> nodesToClose = new LinkedHashSet<>();
                            for (Object o : nodeLayer.getAllNodes()) {
                                if (o instanceof NeoNode && !((NeoNode) o).isSelected() && !NeoNode.this.equals(o))
                                    nodesToClose.add((NeoNode) o);
                            }
                            workspace.app.events.firePropertyChange(NODES_CLOSED, nodesToClose);
                        });
                        break;

                    case KeyEvent.VK_E:

                        if (event.isControlDown()) {
                            SwingUtilities.invokeLater(() -> workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
                                @Override
                                public void doAction(Transaction tx) throws Throwable {

                                    final Map<String, Set<AppEvents.NodeLoadEvent>> nodesByType = new TreeMap<>();
                                    outgoing(node).forEach(relationship -> {
                                        final Set<AppEvents.NodeLoadEvent> eventSet = nodesByType.computeIfAbsent(relationship.getType().name(), k -> new LinkedHashSet<>());
                                        eventSet.add(new AppEvents.NodeLoadEvent(other(node, relationship), null));
                                    });

                                    if (nodesByType.size() == 1) {

                                        for (Set<AppEvents.NodeLoadEvent> nodeLoadEvents : nodesByType.values())
                                            workspace.app.events.firePropertyChange(NODE_LOAD, nodeLoadEvents);

                                    } else {
                                        final JPopupMenu pop = new JPopupMenu();
                                        for (Map.Entry<String, Set<NodeLoadEvent>> entry : nodesByType.entrySet()) {
                                            pop.add(new App.TransactionAction(entry.getKey(), workspace.app) {
                                                @Override
                                                protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                                                    workspace.app.events.firePropertyChange(NODE_LOAD, entry.getValue());
                                                }
                                            });
                                        }
                                        pop.add(new App.TransactionAction("All", workspace.app) {
                                            @Override
                                            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                                                for (Set<NodeLoadEvent> nodeLoadEvents : nodesByType.values()) {
                                                    workspace.app.events.firePropertyChange(NODE_LOAD, nodeLoadEvents);
                                                }
                                            }
                                        });

                                        final Point2D position = workspace.app.getMousePosition();
                                        pop.show(workspace.app, (int) position.getX(), (int) position.getY());
                                    }
                                }

                                @Override
                                public void exception(Throwable throwable) {
                                    SwingUtil.showException(nodeCanvas, throwable);
                                }
                            }));

                        } else {

                            SwingUtilities.invokeLater(() -> workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
                                @Override
                                public void doAction(Transaction tx) throws Throwable {
                                    final Set<NeoNode> nodes = new LinkedHashSet<>();
                                    outgoing(node).forEach(relationship -> {
                                        if (!workspace.layerRelations.containsKey(relationship.getId())) return;
                                        final NeoNode target = (NeoNode) workspace.layerRelations.get(relationship.getId()).path.getAttribute("target");
                                        target.select();
                                        nodes.add(target);
                                    });
                                    workspace.app.events.firePropertyChange(NODES_SELECTED, nodes);
                                }

                                @Override
                                public void exception(Throwable throwable) {
                                    SwingUtil.showException(nodeCanvas, throwable);
                                }
                            }));
                        }
                        break;

                    case KeyEvent.VK_D:

                        if (!event.isControlDown()) {

                            SwingUtilities.invokeLater(() -> workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
                                @Override
                                public void doAction(Transaction tx) throws Throwable {
                                    final Set<NeoNode> nodes = new LinkedHashSet<>();
                                    incoming(node).forEach(relationship -> {
                                        if (!workspace.layerRelations.containsKey(relationship.getId())) return;
                                        final NeoNode source = (NeoNode) workspace.layerRelations.get(relationship.getId()).path.getAttribute("source");
                                        source.select();
                                        nodes.add(source);
                                    });
                                    workspace.app.events.firePropertyChange(NODES_SELECTED, nodes);
                                }

                                @Override
                                public void exception(Throwable throwable) {
                                    SwingUtil.showException(nodeCanvas, throwable);
                                }
                            }));

                        } else {

                            SwingUtilities.invokeLater(() -> workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
                                @Override
                                public void doAction(Transaction tx) throws Throwable {
                                    final Set<NodeLoadEvent> nodes = new LinkedHashSet<>();
                                    incoming(node).forEach(relationship -> {
                                        if (relationship.getType().name().equals(AppMotif.Relations._LAYOUT_MEMBER.name()))
                                            return;
                                        nodes.add(new NodeLoadEvent(other(node, relationship), null));
                                    });
                                    workspace.app.events.firePropertyChange(NODE_LOAD, nodes);
                                }

                                @Override
                                public void exception(Throwable throwable) {
                                    SwingUtil.showException(nodeCanvas, throwable);
                                }
                            }));
                        }

                        break;

                    case KeyEvent.VK_DELETE:

                        if (!event.isControlDown()) {

                            SwingUtilities.invokeLater(() -> workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
                                @Override
                                public void doAction(Transaction tx) throws Throwable {
                                    if (SwingUtil.showConfirmDialog(workspace.app, "Delete " + getNameAndLabelsFrom(node) + " ?")) {
                                        workspace.app.model.deleteNodes(Collections.singleton(node));
                                    }
                                }

                                @Override
                                public void exception(Throwable throwable) {
                                    SwingUtil.showException(nodeCanvas, throwable);
                                }
                            }));
                        }

                        break;
                }
            }


        };

        nodeEventListener.getEventFilter().setMarksAcceptedEventsAsHandled(true);
        addInputEventListener(nodeEventListener);
    }

    public void setPaintStrategy(AppMotif.NodePaintStrategy nodePaintStrategy) {
        delegate.setText(getNodeText(nodePaintStrategy, getNode()));
    }

    private void onRightClick(PInputEvent event) {
        SwingUtilities.invokeLater(() -> workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {
                workspace.app.getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                final JPopupMenu pop = new JPopupMenu();

                final Set<NeoNode> selectedNodes = new LinkedHashSet<>();
                for (Object o : nodeCanvas.nodeLayer.getAllNodes())
                    if (o instanceof NeoNode && ((NeoNode) o).isSelected() && !NeoNode.this.equals(o))
                        selectedNodes.add((NeoNode) o);

                // specialised node-types:
                for (Plugin plugin : workspace.app.plugins)
                    plugin.handleNodeRightClick(pop, NeoNode.this, selectedNodes);

                // Basic graph-operations:
                pop.add(new JSeparator());
                final JMenu layoutMenu = new JMenu("Layout");
                layoutMenu.add(new App.TransactionAction("Layout Right", workspace.app) {
                    @Override
                    protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        SwingUtilities.invokeLater(() -> {
                            layoutTree(new DefaultConfiguration<>(50, 15, Configuration.Location.Left), true, NeoNode.this, workspace.app);
                        });
                    }
                });
                layoutMenu.add(new App.TransactionAction("Layout Left", workspace.app) {
                    @Override
                    protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        SwingUtilities.invokeLater(() -> {
                            layoutTree(new DefaultConfiguration<>(50, 15, Configuration.Location.Right), true, NeoNode.this, workspace.app);
                        });
                    }
                });
                layoutMenu.add(new App.TransactionAction("Layout Top", workspace.app) {
                    @Override
                    protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        SwingUtilities.invokeLater(() -> {
                            layoutTree(new DefaultConfiguration<>(50, 15, Configuration.Location.Top), true, NeoNode.this, workspace.app);
                        });
                    }
                });
                layoutMenu.add(new App.TransactionAction("Layout Bottom", workspace.app) {
                    @Override
                    protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        SwingUtilities.invokeLater(() -> {
                            layoutTree(new DefaultConfiguration<>(50, 15, Configuration.Location.Bottom), true, NeoNode.this, workspace.app);
                        });
                    }
                });
                pop.add(layoutMenu);

                pop.add(new JSeparator());
                final JMenu relationsMenu = new JMenu("Relations");
                final JMenu showAllRelationMenu = new JMenu("Show all ");
                final JMenu closeAll = new JMenu("Close all ");
                final JMenu selectAll = new JMenu("Select all ");
                final Set<String> relations = new TreeSet<>();
                outgoing(getNode()).forEach(relationship -> relations.add(relationship.getType().name()));

                for (String relation : relations) {
                    showAllRelationMenu.add(new App.TransactionAction(relation, workspace.app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                            final Set<NodeLoadEvent> nodes = new LinkedHashSet<>();
                            outgoing(getNode(), RelationshipType.withName(relation)).forEach(relationship -> nodes.add(new NodeLoadEvent(other(getNode(), relationship))));
                            workspace.app.events.firePropertyChange(NODE_LOAD, nodes);
                        }
                    });

                    closeAll.add(new App.TransactionAction(relation, workspace.app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                            final Set<NeoNode> neoNodes = new LinkedHashSet<>();
                            outgoing(getNode(), RelationshipType.withName(relation)).forEach(relationship -> {
                                if (!workspace.app.workspace.layerNodes.containsKey(relationship.getEndNode().getId()))
                                    return;
                                neoNodes.add(workspace.app.workspace.layerNodes.get(relationship.getEndNode().getId()));
                            });

                            workspace.app.events.firePropertyChange(NODES_CLOSED, neoNodes);
                        }
                    });

                    selectAll.add(new App.TransactionAction(relation, workspace.app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                            final Set<NeoNode> neoNodes = new LinkedHashSet<>();
                            outgoing(getNode(), RelationshipType.withName(relation)).forEach(relationship -> {
                                if (!workspace.app.workspace.layerNodes.containsKey(relationship.getEndNode().getId()))
                                    return;

                                final NeoRelationship neoRelationship = workspace.app.workspace.layerRelations.get(relationship.getId());
                                neoRelationship.select();

//                        final NeoNode node = workspace.app.workspace.layerNodes.get(relationship.getEndNode().getId());
//                        node.select();
//                        neoNodes.add(node);
                            });

//                     workspace.app.events.firePropertyChange(NODES_SELECTED, neoNodes);
                        }
                    });
                }
                if (showAllRelationMenu.getMenuComponents().length > 0) {
                    relationsMenu.add(showAllRelationMenu);
                    relationsMenu.add(selectAll);
                    relationsMenu.add(closeAll);
                }
                if (relationsMenu.getMenuComponents().length > 0) pop.add(relationsMenu);

                pop.add(new JSeparator());

                pop.add(new App.TransactionAction("Create Visitor", workspace.app) {
                    @Override
                    protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                        final String visitorName = "TEST";
                        final String packageName = "com.test";

                        final PathBuilder pathBuilder = new PathBuilder(getNode());
                        final Path path = pathBuilder.getPath();

                        final Set<Label> distinctLabels = new LinkedHashSet<>();
                        for (Node node : path.nodes())
                            for (Label label : node.getLabels())
                                distinctLabels.add(label);

                        final DomainPluginGroup pluginGroup = new DomainPluginGroup();
                        final DomainPluginGroup.VisitorST visitorST = pluginGroup.newVisitor().
                                setName(visitorName).
                                setPackage(packageName);

                        for (Label distinctLabel : distinctLabels) {
                            visitorST.addLabelsValue(distinctLabel.name());
                        }

                        for (String distinctPath : pathBuilder.getDistinctPaths()) {
                            visitorST.addPathsValue(distinctPath);
                        }

                        GeneratedFile.newJavaFile("/home/goe/projects/nextgen/src/main/java", packageName, visitorName).write(visitorST);
                    }
                });

                pop.add(new JSeparator());
                if (!selectedNodes.isEmpty()) {
                    pop.add(new App.TransactionAction("Add relationship", workspace.app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                            final Set<String> relationships = new LinkedHashSet<>();
                            workspace.app.model.graph().getAllRelationshipTypesInUse().forEach(relationshipType -> relationships.add(relationshipType.name()));
                            final JComboBox<String> cboRelationships = new JComboBox<>(relationships.toArray(new String[relationships.size()]));

                            final JRadioButton radOneToMany = new JRadioButton();
                            final JRadioButton radManyToOne = new JRadioButton("", true);
                            final ButtonGroup group = new ButtonGroup();
                            group.add(radOneToMany);
                            group.add(radManyToOne);

                            final JTextField txtSearch = new JTextField();
                            txtSearch.addKeyListener(new KeyAdapter() {
                                @Override
                                public void keyReleased(KeyEvent e) {
                                    SwingUtilities.invokeLater(() -> {
                                        final String s = txtSearch.getText().trim().toLowerCase();
                                        for (String lbl : relationships) {
                                            if (lbl.toLowerCase().startsWith(s)) {
                                                cboRelationships.setSelectedItem(lbl);
                                            }
                                        }
                                    });
                                }
                            });


                            final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", "pref,4dlu,pref,4dlu,pref,4dlu,pref");
                            editor.addLabel("Relationship", 1, 1);
                            editor.add(cboRelationships, 3, 1);
                            editor.addLabel("Search", 1, 3);
                            editor.add(txtSearch, 3, 3);
                            editor.addLabel("this -> " + selectedNodes.size(), 1, 5);
                            editor.add(radOneToMany, 3, 5);
                            editor.addLabel(selectedNodes.size() + " -> this", 1, 7);
                            editor.add(radManyToOne, 3, 7);

                            editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

                            SwingUtil.showDialog(editor, workspace.app, "Add relationships", new SwingUtil.ConfirmAction() {
                                @Override
                                public void verifyAndCommit() throws Exception {
                                    final String selected = (String) cboRelationships.getSelectedItem();

                                    workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
                                        @Override
                                        public void doAction(Transaction tx1) throws Throwable {
                                            for (NeoNode selectedNode : selectedNodes) {
                                                if (radOneToMany.isSelected() && NeoUtil.isRelated(getNode(), selectedNode.getNode(), RelationshipType.withName(selected)))
                                                    continue;
                                                else if (radManyToOne.isSelected() && NeoUtil.isRelated(selectedNode.getNode(), getNode(), RelationshipType.withName(selected)))
                                                    continue;

                                                if (radOneToMany.isSelected())
                                                    getNode().createRelationshipTo(selectedNode.getNode(), RelationshipType.withName(selected));
                                                if (radManyToOne.isSelected())
                                                    selectedNode.getNode().createRelationshipTo(getNode(), RelationshipType.withName(selected));
                                            }
                                        }

                                        @Override
                                        public void exception(Throwable throwable) {
                                            SwingUtil.showExceptionNoStack(workspace.app, throwable);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
                pop.add(new App.TransactionAction("Set Node-property", workspace.app) {

                    @Override
                    protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                        final String newProperty = SwingUtil.showInputDialog("[Property] [value]", nodeCanvas);
                        if (newProperty == null || newProperty.length() == 0) return;

                        final String property = newProperty.substring(0, newProperty.indexOf(" "));
                        final String value = newProperty.substring(newProperty.indexOf(" ") + 1);
                        getNode().setProperty(property, value);
                        workspace.app.events.firePropertyChange(NODE_CHANGED + getNode().getId(), property, value);
                    }
                });
                pop.add(new App.TransactionAction("Select all " + getNameAndLabelsFrom(getNode()), workspace.app) {

                    @Override
                    protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        final String id = getNameAndLabelsFrom(getNode());
                        final Set<NeoNode> nodes = new LinkedHashSet<>();
                        for (NeoNode neoNode : nodeCanvas.getAllNodes()) {
                            if (!id.equals(getNameAndLabelsFrom(neoNode.getNode()))) continue;
                            neoNode.select();
                            nodes.add(neoNode);
                        }
                        workspace.app.events.firePropertyChange(NODES_SELECTED, nodes);

                    }
                });
                pop.add(new AbstractAction("Retain") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SwingUtilities.invokeLater(() -> {
                            final Set<NeoNode> nodesToClose = new LinkedHashSet<>();
                            for (Object o : nodeCanvas.nodeLayer.getAllNodes()) {
                                if (o instanceof NeoNode && !((NeoNode) o).isSelected() && !NeoNode.this.equals(o))
                                    nodesToClose.add((NeoNode) o);
                            }
                            workspace.app.events.firePropertyChange(NODES_CLOSED, nodesToClose);
                        });
                    }
                });
                pop.add(new App.TransactionAction("Close", workspace.app) {
                    @Override
                    protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        workspace.app.events.firePropertyChange(NODES_CLOSED, Collections.singleton(NeoNode.this));
                    }
                });
                pop.add(new App.TransactionAction("Delete", workspace.app) {
                    @Override
                    protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        if (SwingUtil.showConfirmDialog(workspace.app, "Delete " + getNameAndLabelsFrom(getNode()) + " ?")) {
                            workspace.app.model.deleteNodes(Collections.singleton(getNode()));

                        }
                    }
                });

                pop.add(new App.TransactionAction("Expand Full Tree", workspace.app) {

                    final AtomicBoolean continueExpanding = new AtomicBoolean(true);

                    @Override
                    protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        // todo expand all outgoing nodes from this node. Could be large amount.

                        final Set<Node> nodes = new LinkedHashSet<>();
                        expandNode(nodes, getNode());
                        fireNodesLoaded(nodes);
                    }

                    private void expandNode(Set<Node> nodes, Node node) {

                        if (continueExpanding.get() && nodes.size() > 1000)
                            continueExpanding.set(SwingUtil.showConfirmDialog(workspace.app, "There are more than 1000 nodes loaded. Do you want to continue ?"));

                        if (!continueExpanding.get()) return;

                        outgoing(node).forEach(relationship -> {
                            final Node other = other(node, relationship);
                            if (nodes.contains(other))
                                return;
                            nodes.add(other);
                            expandNode(nodes, other);
                        });
                    }
                });

                pop.add(new App.TransactionAction("Export current model", workspace.app) {
                    @Override
                    protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                        final String classnameKey = "_export_classname";
                        final String rootKey = "_export_root";

                        final String name = SwingUtil.showInputDialog("classname root", nodeCanvas, (String) getNode().getProperty(classnameKey, "") + " " + (String) getNode().getProperty(rootKey, ""));
                        if (name == null || name.length() == 0) return;

                        final String packageName = name.substring(0, name.lastIndexOf("."));
                        final String className = name.split(" ")[0].substring(name.lastIndexOf(".") + 1);
                        final String root = name.split(" ")[1];

                        getNode().setProperty(classnameKey, name.split(" ")[0]);
                        getNode().setProperty(rootKey, root);

                        final Neo4jGroup group = new Neo4jGroup();
                        final Neo4jGroup.ExportDatabaseST domainDB = group.newExportDatabase().setPackageName(packageName).setName(className);

                        domainDB.setRootLabel(getNode().getLabels().iterator().next());
                        domainDB.setRootUUID(uuidOf(getNode()));

                        exportNode(group, domainDB, getNode(), new LinkedHashSet<>());

                        GeneratedFile.newJavaFile(root, packageName, className).write(domainDB);
                    }

                    private void exportNode(Neo4jGroup group, Neo4jGroup.ExportDatabaseST domainDB, Node node, Set<Node> nodes) {

                        nodes.add(node);

                        final Neo4jGroup.exportNodeST nodeST = group.newexportNode().
                                setUuid(node.getProperty("_uuid"));

                        for (Label label : node.getLabels())
                            nodeST.addLabelsValue(label);

                        for (Map.Entry<String, Object> entry : node.getAllProperties().entrySet())
                            nodeST.addPropertiesValue(entry.getValue(), entry.getKey());

                        domainDB.addNodesValue(nodeST);

                        node.getRelationships(Direction.OUTGOING).forEach(relationship -> {
                            final Node otherNode = relationship.getOtherNode(node);

                            final Neo4jGroup.exportRelationST exportRelationST = group.newexportRelation().setType(relationship.getType()).setSrcLabel(node.getLabels().iterator().next()).setSrcUuid(node.getProperty("_uuid")).setDstLabel(otherNode.getLabels().iterator().next()).setDstUuid(otherNode.getProperty("_uuid"));
                            for (Map.Entry<String, Object> entry : relationship.getAllProperties().entrySet())
                                exportRelationST.addPropertiesValue(entry.getKey(), entry.getValue());

                            domainDB.addRelationsValue(exportRelationST);

                            if (nodes.contains(otherNode)) return;

                            exportNode(group, domainDB, otherNode, nodes);
                        });
                    }
                });

                pop.addSeparator();
                pop.add(new App.TransactionAction("Show roots", workspace.app) {
                    @Override
                    protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                        final Node node = getNode();

                        final Set<Node> visited = new LinkedHashSet<>();
                        final Set<Node> parents = new LinkedHashSet<>();
                        visitIncoming(node, visited, parents);

                        fireNodesLoaded(parents.toArray(new Node[parents.size()]));
                    }


                    private void visitIncoming(Node node, Set<Node> visited, Set<Node> parents) {

                        visited.add(node);

                        final AtomicBoolean hasParents = new AtomicBoolean(false);
                        incoming(node).forEach(relationship -> {
                            final Node parent = other(node, relationship);
                            hasParents.set(true);
                            if (visited.contains(parent)) return;
                            visitIncoming(parent, visited, parents);
                        });

//                  if (!hasParents.get()) {
                        if (hasLabel(node, AppMotif.Entities._Layout)) return;
                        parents.add(node);
//                  }
                    }
                });

                workspace.app.getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                pop.show(nodeCanvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
            }

            @Override
            public void exception(Throwable throwable) {
                SwingUtil.showException(nodeCanvas, throwable);
            }
        }));
    }

    public Long id() {
        return Long.valueOf(getAttribute("id").toString());
    }

    public void setColor(Color color) {
        defaultNodeColor = color;
        setTextPaint(color);
    }

    private void setTextPaint(Color color) {
        delegate.setTextPaint(color);
    }

    public void highlight() {
        addAttribute("highlighted", Boolean.TRUE);
        setTextPaint(nodeCanvas.highlightedNodeColor);
    }

    public void unhighlight() {
        addAttribute("highlighted", Boolean.FALSE);
        setTextPaint(getBooleanAttribute("selected", false) ? nodeCanvas.selectedNodeColor : defaultNodeColor);
    }

    private void toggleSelect() {
        addAttribute("selected", !getBooleanAttribute("selected", false));
        setTextPaint(getBooleanAttribute("selected", false) ? nodeCanvas.selectedNodeColor : defaultNodeColor);
    }

    public void select() {
        addAttribute("selected", Boolean.TRUE);
        setTextPaint(nodeCanvas.selectedNodeColor);
    }

    public void unselect() {
        addAttribute("selected", Boolean.FALSE);
        setTextPaint(defaultNodeColor);
    }

    public boolean isSelected() {
        return getBooleanAttribute("selected", false);
    }

    public Node getNode() {
        return (Node) getAttribute("node");
    }

    @Override
    public boolean equals(Object obj) {
        return ((obj instanceof NeoNode)) && ((NeoNode) obj).getAttribute("id").equals(getAttribute("id"));
    }

    @Override
    public int hashCode() {
        return getAttribute("id").hashCode();
    }

    public static String getNodeText(AppMotif.NodePaintStrategy nodePaintStrategy, Node node) {
        switch (nodePaintStrategy) {
            case showNameAndLabels:
                return getNameAndLabelsFrom(node) + " " + node.getId();
            case showName:
                return getString(node, AppMotif.Properties.name.name(), "()") + " " + node.getId();
            case showLabels:
                return labelsFor(node) + " " + node.getId();
            case showProperties:
                final StringBuilder out = new StringBuilder();
                boolean first = true;
                for (String key : node.getPropertyKeys()) {
                    if (AppMotif.Properties.x.name().equals(key)) continue;
                    if (AppMotif.Properties.y.name().equals(key)) continue;
                    if (AppMotif.Properties._color.name().equals(key)) continue;
                    if (AppMotif.Properties._lastLayout.name().equals(key)) continue;
                    if (TAG_UUID.equals(key)) continue;
                    if (!first) out.append(", ");
                    out.append(key).append(": '").append(node.getProperty(key)).append("'");
                    first = false;
                }
                return out.toString();
            case showValues:

                if (hasLabel(node, DomainPlugin.Entities.Value)) {
                    return getString(node, AppMotif.Properties.name.name(), "()");
                } else {

                    for (Relationship instanceRelation : incoming(node, DomainPlugin.Relations.INSTANCE)) {
                        final Node instanceNode = other(node, instanceRelation);
                        if (StringTemplatePlugin.isSTTemplate(instanceNode)) {
                            return StringTemplatePlugin.renderStatement(node, instanceNode);

                        }
                    }
                }
        }

        return "?";
    }

    private static final class PathBuilder {

        private Node startNode;
        private Node endNode;
        private Relationship lastRelationship;
        private List<Relationship> relationships = new LinkedList<>();
        private List<Relationship> reverseRelationships = new LinkedList<>();
        private List<Node> nodes = new LinkedList<>();
        private List<Node> reverseNodes = new LinkedList<>();
        private int length = 0;
        private List<PropertyContainer> propertyContainers = new LinkedList<>();

        private final Set<Node> visitedNodes = new LinkedHashSet<>();
        private final Stack<PathElement> pathElements = new Stack<>();
        private final Set<String> distinctPaths = new LinkedHashSet<>();

        PathBuilder(Node node) {
            visit(node);

            final int relationshipsSize = relationships.size();
            for (int i = 0; i < relationshipsSize; i++)
                reverseRelationships.add(relationships.get(relationshipsSize - i - 1));

            final int nodesSize = nodes.size();
            for (int i = 0; i < nodesSize; i++)
                reverseNodes.add(nodes.get(nodesSize - i - 1));

            pathElements.peek().createPaths("", distinctPaths);
        }

        public Set<String> getDistinctPaths() {
            return distinctPaths;
        }

        public void visit(Node node) {

            if (visitedNodes.contains(node)) return;
            visitedNodes.add(node);

            if (startNode == null) startNode = node;
            endNode = node;

            propertyContainers.add(node);
            nodes.add(node);

            final PathElement pathElement = new PathElement(node);
            if (!pathElements.isEmpty())
                pathElements.peek().outgoing.put(node, pathElement);
            pathElements.push(pathElement);

            NeoUtil.outgoing(node).forEach(relationship -> {
                propertyContainers.add(relationship);
                relationships.add(relationship);

                lastRelationship = relationship;

                visit(other(node, relationship));
            });

            if (pathElements.size() > 1) pathElements.pop();
        }

        public Path getPath() {
            return new Path() {
                @Override
                public Node startNode() {
                    return startNode;
                }

                @Override
                public Node endNode() {
                    return endNode;
                }

                @Override
                public Relationship lastRelationship() {
                    return lastRelationship;
                }

                @Override
                public Iterable<Relationship> relationships() {
                    return relationships;
                }

                @Override
                public Iterable<Relationship> reverseRelationships() {
                    return reverseRelationships;
                }

                @Override
                public Iterable<Node> nodes() {
                    return nodes;
                }

                @Override
                public Iterable<Node> reverseNodes() {
                    return reverseNodes;
                }

                @Override
                public int length() {
                    return length;
                }

                @Override
                public Iterator<PropertyContainer> iterator() {
                    return propertyContainers.iterator();
                }
            };
        }

        private final class PathElement {

            final Node node;
            final Map<Node, PathElement> outgoing = new LinkedHashMap<>();

            PathElement(Node node) {
                this.node = node;
            }

            void createPaths(String currentPath, Set<String> distinctPaths) {
                for (Label label : node.getLabels()) {
                    final String newPath = currentPath.length() == 0 ? label.name() : (currentPath + "_" + label);
                    distinctPaths.add(newPath);
                    for (PathElement pathElement : outgoing.values())
                        pathElement.createPaths(newPath, distinctPaths);
                }
            }

            @Override
            public String toString() {
                final StringBuilder out = new StringBuilder("(" + NeoUtil.labelsFor(node) + ")");
                for (PathElement pathElement : outgoing.values())
                    out.append("\n\t").append(pathElement);
                return out.toString();
            }
        }
    }

    public static void layoutTree(Configuration<NeoNode> configuration, boolean outgoing, NeoNode root, App app) {

        final Map<Long, NeoNode> nodesAndIds = new LinkedHashMap<>();
        for (NeoNode visibleNode : app.workspace.nodeCanvas.getAllNodes())
            nodesAndIds.put(visibleNode.id(), visibleNode);

        final Map<Long, NeoNode> parentsMap = new LinkedHashMap<>();
        final Map<Long, java.util.List<NeoNode>> childrensMap = new LinkedHashMap<>();

        app.model.graph().doInTransaction(new NeoModel.Committer() {
            @Override
            public void doAction(Transaction tx) throws Throwable {

                // recursively traverse from root, finding all visible-children and populate parentsMap and childrensMap:
                visit(new LinkedHashSet<>(), root, outgoing);

                final TreeForTreeLayout<NeoNode> tree = new AbstractTreeForTreeLayout<NeoNode>(root) {
                    @Override
                    public NeoNode getParent(NeoNode neoNode) {
                        return parentsMap.get(neoNode.id());
                    }

                    @Override
                    public java.util.List<NeoNode> getChildrenList(NeoNode neoNode) {
                        if (neoNode == null) return Collections.emptyList();
                        return childrensMap.get(neoNode.id());
                    }
                };

                final NodeExtentProvider<NeoNode> nodeExtendProvider = new NodeExtentProvider<NeoNode>() {
                    @Override
                    public double getWidth(NeoNode neoNode) {
                        return neoNode.getFullBounds().getWidth();
                    }

                    @Override
                    public double getHeight(NeoNode neoNode) {
                        return neoNode.getFullBounds().getHeight();
                    }
                };


                final TreeLayout<NeoNode> layout = new TreeLayout<>(tree, nodeExtendProvider, configuration);

                // apply coordination-translation
                final Point2D rootLocation = root.getOffset();
                final Map<NeoNode, Rectangle2D.Double> nodeBounds = layout.getNodeBounds();
                final Rectangle2D.Double rootBounds = nodeBounds.get(root);
                final double dX = rootLocation.getX() - rootBounds.getCenterX();
                final double dY = rootLocation.getY() - rootBounds.getCenterY();
                for (Map.Entry<NeoNode, Rectangle2D.Double> nodeBound : nodeBounds.entrySet()) {
                    final double centerX = nodeBound.getValue().getCenterX() + dX;
                    final double centerY = nodeBound.getValue().getCenterY() + dY;
                    nodeBound.getKey().setOffset(centerX, centerY);
                }
            }

            private void visit(Set<NeoNode> visitedNodes, NeoNode root, boolean outgoing) {

                if (visitedNodes.contains(root)) return;
                visitedNodes.add(root);

                childrensMap.put(root.id(), new ArrayList<>());
                final Set<Long> childrenToVisit = new LinkedHashSet<>();
                if (outgoing) {
                    outgoing(root.getNode()).forEach(relationship -> {
                        final Node childNode = other(root.getNode(), relationship);

                        final long childId = childNode.getId();
                        if (!nodesAndIds.containsKey(childId)) return;
                        if (visitedNodes.contains(nodesAndIds.get(childId))) return;
                        if (childNode.equals(root.getNode())) return;
                        if (parentsMap.containsKey(childId)) return;

                        childrenToVisit.add(childId);
                        parentsMap.put(childId, root);
                        childrensMap.get(root.id()).add(nodesAndIds.get(childId));
                    });
                } else {
                    incoming(root.getNode()).forEach(relationship -> {
                        final Node childNode = other(root.getNode(), relationship);

                        final long childId = childNode.getId();
                        if (!nodesAndIds.containsKey(childId)) return;
                        if (visitedNodes.contains(nodesAndIds.get(childId))) return;
                        if (childNode.equals(root.getNode())) return;
                        if (parentsMap.containsKey(childId)) return;

                        childrenToVisit.add(childId);
                        parentsMap.put(childId, root);
                        childrensMap.get(root.id()).add(nodesAndIds.get(childId));
                    });
                }

                // recursively visit added children:
                for (Long childNode : childrenToVisit)
                    visit(visitedNodes, nodesAndIds.get(childNode), outgoing);
            }

            @Override
            public void exception(Throwable throwable) {
                SwingUtil.showException(app, throwable);
            }
        });
    }

    private void fireNodesLoaded(Node... nodes) {
        final Set<AppEvents.NodeLoadEvent> nodeEvents = new LinkedHashSet<>();
        for (Node node : nodes)
            nodeEvents.add(new AppEvents.NodeLoadEvent(node, false));
        workspace.app.events.firePropertyChange(NODE_LOAD, nodeEvents);
    }

    private void fireNodesLoaded(Set<Node> nodes) {
        final Set<AppEvents.NodeLoadEvent> nodeEvents = new LinkedHashSet<>();
        for (Node node : nodes)
            nodeEvents.add(new AppEvents.NodeLoadEvent(node, false));
        workspace.app.events.firePropertyChange(NODE_LOAD, nodeEvents);
    }
}