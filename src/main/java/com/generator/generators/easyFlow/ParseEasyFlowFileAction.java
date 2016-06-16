package com.generator.generators.easyFlow;

import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.d2.GraphNode2D;
import com.generator.generators.easyFlow.domain.*;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * goe on 3/26/15.
 * todo this needs to be combined with EasyFlowParser into one class
 */
public class ParseEasyFlowFileAction extends GraphEditorAction<EasyFlowDomain.ENTITIES, EasyFlowDomain.RELATIONS, GraphNode2D<EasyFlowDomain.ENTITIES>, GraphEditor<EasyFlowDomain.ENTITIES, EasyFlowDomain.RELATIONS, GraphNode2D<EasyFlowDomain.ENTITIES>>> {

    public ParseEasyFlowFileAction(GraphEditor<EasyFlowDomain.ENTITIES, EasyFlowDomain.RELATIONS, GraphNode2D<EasyFlowDomain.ENTITIES>> editor) {
        super("Parse easy-flow .java file", editor);
    }

    @Override
    public void doAction(Transaction tx) throws Throwable {

        final File file = SwingUtil.showOpenFile(editor);
        if (file != null && file.exists()) {

            oldParser(file);

//            final Node flowNode = editor.getDomain().newNode(EasyFlowDomain.ENTITIES.Flow, UUID.randomUUID());
//
//            final JavaParser parser = new JavaParser(JavaParser.createLexer(new FileReader(file.getAbsolutePath()))) {
//
//                @Override
//                public void packageName(String name) {
//                    flowNode.setProperty("package", name);
//                }
//
//                @Override
//                public void className(String name) {
//                    if (!flowNode.hasProperty("name"))
//                        flowNode.setProperty("name", name);
//                    else {  // assume context
//                        Node contextNode = editor.getDomain().newNode(EasyFlowDomain.ENTITIES.Flow, UUID.randomUUID(), "name", name);
//                        editor.getDomain().relate(EasyFlowDomain.RELATIONS.PROPERTY, flowNode, contextNode);
//                    }
//                }
//
//                @Override
//                public void classExtends(String name) {
//                    if (!flowNode.hasProperty("extends")) flowNode.setProperty("extends", name);
//                }
//
//                @Override
//                public void newStatement(String statement) {
//                    if (statement.contains("from(")) {
//
//                        final int from = statement.indexOf("from(");
////                        parseTransitions(statement, from);
//
//                        final String[] t = statement.substring(from).replaceAll("[.,]", " ").split("[\\(\\)]");
//
//                        for (int i = 0; i < t.length; i++) {
//                            String s = t[i].trim();
//                            System.out.println(s);
//
//                            if (s.length() == 0 && !currentStates.empty()) {
//                                currentStates.pop();
//
//                            } else if (s.startsWith("from")) {
//
//                                final UUID uuid = UUID.randomUUID();
//                                final String name = t[++i];
//
//                                addState(uuid, name, true);
//
//                            } else if (s.startsWith("on")) {
//
//                                final UUID uuid = UUID.randomUUID();
//                                final String eventName = t[++i];
//
//                                addEvent(uuid, eventName);
//
//                            } else if (s.startsWith("to")) {
//
//                                final String src = currentStates.peek();
//
//                                final UUID uuid = UUID.randomUUID();
//                                final String stateName = t[++i];
//
//                                addState(uuid, stateName, false);
//                                final String dst = currentStates.peek();
//                                final String event = currentEvents.peek();
//
//                                addTransition(src, dst, event, false);
//
//                                if (!t[i + 1].contains("transit"))
//                                    currentStates.pop();
//
//                            } else if (s.startsWith("finish")) {
//
//                                final String src = currentStates.peek();
//
//                                final UUID uuid = UUID.randomUUID();
//                                final String stateName = t[++i];
//
//                                addState(uuid, stateName, false);
//                                final String dst = currentStates.peek();
//                                final String event = currentEvents.peek();
//
//                                addTransition(src, dst, event, true);   // make transition
//
//                                currentStates.pop();   // last state: pop from stack
//                            }
//                        }
//                    }
//
//                }
//
//                @Override
//                public void newField(final String modifier, final String type, final String name, final String initalizer) {
//                    if ("log".equals(name) && "Logger".equals(type)) return;
//
//                    // context-fields:
//                    final String formattedInitializer = (initalizer == null || !initalizer.startsWith("new")) ? initalizer : ("new " + initalizer.substring(3));
//
//                    if (type.contains("<" + contextName + ">")) return;
//                    if (type.equals(fsmName + "Listener")) return;
//
//                    final UUID uuid = UUID.randomUUID();
//
//                    contextProperties.add(new EasyFlowContextProperty() {
//
//                        @Override
//                        public UUID getUuid() {
//                            return uuid;
//                        }
//
//                        @Override
//                        public EasyFlowDomain.ENTITIES getDomainType() {
//                            return EasyFlowDomain.ENTITIES.ContextProperty;
//                        }
//
//                        @Override
//                        public String getName() {
//                            return name;
//                        }
//
//                        @Override
//                        public String getModifier() {
//                            return modifier;
//                        }
//
//                        @Override
//                        public String getType() {
//                            return type;
//                        }
//
//                        @Override
//                        public String getInitializer() {
//                            return formattedInitializer == null ? null : (formattedInitializer.startsWith("\"") ? ("\\" + formattedInitializer.substring(0, formattedInitializer.length() - 1) + "\\\"") : formattedInitializer);
//                        }
//                    });
//                }
//            };
        }
    }

    private void oldParser(File file) throws IOException {

        final EasyFlowParser easyFlowParser = new EasyFlowParser(file);
        final EasyFlowFSM fsm = easyFlowParser.getEasyFlowFSM();

        final Node flowNode = editor.getDomain().newNode(EasyFlowDomain.ENTITIES.Flow, fsm.getUuid(),
                "name", fsm.getName(),
                "contextName", fsm.getContextName(),
                "package", fsm.getPackage(),
                "extends", fsm.getExtends(),
//                "templateFile", fsm.getTemplateFile(),
                "targetFile", fsm.getTargetFile());

        for (EasyFlowContextProperty contextProperty : fsm.getContextProperties()) {
            final Node contextPropertyNode = editor.getDomain().newNode(EasyFlowDomain.ENTITIES.ContextProperty, contextProperty.getUuid(),
                    "name", contextProperty.getName(),
                    "modifier", contextProperty.getModifier(),
                    "type", contextProperty.getType(),
                    "value", contextProperty.getInitializer());

            editor.getDomain().relate(EasyFlowDomain.RELATIONS.PROPERTY, flowNode, contextPropertyNode);
        }

        // create state-nodes
        final Map<UUID, Node> stateNodes = new LinkedHashMap<>();
        Node initialState = null;
        for (Map.Entry<String, EasyFlowState> stateEntry : fsm.getStates().entrySet()) {

            final Node stateNode = editor.getDomain().newNode(EasyFlowDomain.ENTITIES.State, stateEntry.getValue().getUuid(),
                    "name", stateEntry.getValue().getName());

            stateNodes.put(stateEntry.getValue().getUuid(), stateNode);

            if (stateEntry.getValue().isInitialState()) initialState = stateNode;
        }

        if (initialState == null)
            throw new IllegalStateException("fsm has no initialState! Please set initial state.");

        // create event-nodes
        final Map<UUID, Node> eventNodes = new LinkedHashMap<>();
        for (Map.Entry<String, EasyFlowEvent> eventEntry : fsm.getEvents().entrySet()) {

            final Node eventNode = editor.getDomain().newNode(EasyFlowDomain.ENTITIES.Event, eventEntry.getValue().getUuid(),
                    "name", eventEntry.getValue().getName());

            eventNodes.put(eventEntry.getValue().getUuid(), eventNode);
        }

        // transitions: from
        editor.getDomain().relate(EasyFlowDomain.RELATIONS.FROM, flowNode, initialState);

        // transitions: rest
        final Set<String> eventToStates = new LinkedHashSet<>();
        for (EasyFlowState state : fsm.getStates().values()) {
            final Map<EasyFlowEvent, EasyFlowTransition> stateTransitions = state.getTransitions();
            for (Map.Entry<EasyFlowEvent, EasyFlowTransition> stateTransition : stateTransitions.entrySet()) {
                final EasyFlowTransition transition = stateTransition.getValue();

                // state -> event
                editor.getDomain().relate(EasyFlowDomain.RELATIONS.ON,
                        stateNodes.get(transition.getStart().getUuid()),
                        eventNodes.get(transition.getEvent().getUuid()));

                // event -> state
                final String eventToState = transition.getEvent().getName() + (transition.isEndState() ? EasyFlowDomain.RELATIONS.FINISH : EasyFlowDomain.RELATIONS.TO) + transition.getEnd().getName();
                if (eventToStates.contains(eventToState)) continue;      // prevent duplicates
                eventToStates.add(eventToState);

                editor.getDomain().relate(transition.isEndState() ? EasyFlowDomain.RELATIONS.FINISH : EasyFlowDomain.RELATIONS.TO,
                        eventNodes.get(transition.getEvent().getUuid()),
                        stateNodes.get(transition.getEnd().getUuid()));
            }
        }

        // show and select node
        editor.getOrAdd(flowNode);
    }
}