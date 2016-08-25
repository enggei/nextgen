package com.generator.generators.easyFlow;

import com.generator.editors.graph.GraphEditor;
import com.generator.editors.graph.GraphEditorAction;
import com.generator.editors.graph.d2.GraphNode2D;
import com.generator.generators.easyFlow.domain.*;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import java.io.File;
import java.util.*;

/**
 * goe on 3/26/15.
 */
public class ParseEasyFlowFileAction extends GraphEditorAction<EasyFlowDomain.ENTITIES, EasyFlowDomain.RELATIONS, GraphNode2D<EasyFlowDomain.ENTITIES>, GraphEditor<EasyFlowDomain.ENTITIES, EasyFlowDomain.RELATIONS, GraphNode2D<EasyFlowDomain.ENTITIES>>> {

	public ParseEasyFlowFileAction(GraphEditor<EasyFlowDomain.ENTITIES, EasyFlowDomain.RELATIONS, GraphNode2D<EasyFlowDomain.ENTITIES>> editor) {
		super("Parse easy-flow .java file", editor);
	}

	@Override
	public void doAction(Transaction tx) throws Throwable {

		final File file = SwingUtil.showOpenFile(editor);
		if (file != null && file.exists()) {

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
}