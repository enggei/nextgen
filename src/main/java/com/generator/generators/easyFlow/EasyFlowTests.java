package com.generator.generators.easyFlow;

import com.generator.generators.easyFlow.domain.*;
import org.junit.Test;
import org.neo4j.graphdb.Node;

import java.io.File;
import java.util.*;

public class EasyFlowTests {

	@Test
	public void testEasyFlowGroup() {

		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		final EasyFlowGroup group = new EasyFlowGroup();

		// todo add EasyFlowGroup- tests here;

		EasyFlowGroup.easyFlowST easyFlowST = group.neweasyFlow();

		addBinding(group, easyFlowST, "STATE1", "XXX");
		addBinding(group, easyFlowST, "STATE2", "YYY");
		addBinding(group, easyFlowST, "STATE3", "ZZZ");
		System.out.println(easyFlowST);
	}

	private static void addBinding(EasyFlowGroup group, EasyFlowGroup.easyFlowST easyFlowST, String state1, String yyy) {
		EasyFlowGroup.declarationST declaration_ = group.newdeclaration().setName(state1).setState(yyy);
		EasyFlowGroup.implST impl_ = group.newimpl().setName(state1).setState(yyy);
		easyFlowST.addBindingsValue(declaration_, impl_);
	}

	@Test
	public void testEasyFlowNeo() {

		final org.neo4j.graphdb.GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"));
		final com.generator.editors.domain.NeoModel model = new com.generator.editors.domain.NeoModel(db);

		model.doInTransaction(new com.generator.editors.domain.NeoModel.Committer() {
			@Override
			public void doAction(org.neo4j.graphdb.Transaction tx) throws Throwable {

				// parse into NEO:
				final EasyFlowParser easyFlowParser = new EasyFlowParser(new File("/media/storage/projects/ucs-node/src/main/java/com/ucs/network/server/NodeServerFSM.java"));
				final EasyFlowFSM fsm = easyFlowParser.getEasyFlowFSM();

				final EasyFlowNeo easyFlowNeo = new EasyFlowNeo(db);

				final EasyFlowNeo.easyFlowNode flowNode = easyFlowNeo.newEasyFlow().
					setName(easyFlowNeo.newStringNode(fsm.getName())).
					setContext(easyFlowNeo.newStringNode(fsm.getContextName())).
					setPackage(easyFlowNeo.newStringNode(fsm.getPackage())).
					setExtends(easyFlowNeo.newStringNode(fsm.getExtends()));
//					/*"templateFile", fsm.getTemplateFile(),*/
//					"targetFile", fsm.getTargetFile());

				final EasyFlowNeo.statefulContextNode statefulContextNode = easyFlowNeo.newStatefulContext();
				flowNode.setContext(statefulContextNode.node());

				for (EasyFlowContextProperty contextProperty : fsm.getContextProperties()) {
					statefulContextNode.addPropertiesValue(
						easyFlowNeo.newStringNode("comment"),
						easyFlowNeo.newStringNode(contextProperty.getModifier()),
						easyFlowNeo.newStringNode(contextProperty.getName()),
						easyFlowNeo.newStringNode(contextProperty.getType()),
						easyFlowNeo.newStringNode(contextProperty.getInitializer()));
				}

				// create state-nodes
				final Map<UUID, Node> stateNodes = new LinkedHashMap<>();
				Node initialState = null;
				for (Map.Entry<String, EasyFlowState> stateEntry : fsm.getStates().entrySet()) {

					final Node stateNode = easyFlowNeo.newStateDeclaration().
						setName(easyFlowNeo.newStringNode(stateEntry.getValue().getName())).node();

					stateNodes.put(stateEntry.getValue().getUuid(), stateNode);

					if (stateEntry.getValue().isInitialState()) initialState = stateNode;
				}

				if (initialState == null)
					throw new IllegalStateException("fsm has no initialState! Please set initial state.");

				// create event-nodes
				final Map<UUID, Node> eventNodes = new LinkedHashMap<>();
				for (Map.Entry<String, EasyFlowEvent> eventEntry : fsm.getEvents().entrySet()) {

//					final Node eventNode = editor.getDomain().newNode(EasyFlowDomain.ENTITIES.Event, eventEntry.getValue().getUuid(),
//						"name", eventEntry.getValue().getName());
//
//					eventNodes.put(eventEntry.getValue().getUuid(), eventNode);
				}

				// transitions: from
//				editor.getDomain().relate(EasyFlowDomain.RELATIONS.FROM, flowNode, initialState);

				// transitions: rest
				final Set<String> eventToStates = new LinkedHashSet<>();
				for (EasyFlowState state : fsm.getStates().values()) {
					final Map<EasyFlowEvent, EasyFlowTransition> stateTransitions = state.getTransitions();
					for (Map.Entry<EasyFlowEvent, EasyFlowTransition> stateTransition : stateTransitions.entrySet()) {
						final EasyFlowTransition transition = stateTransition.getValue();

						// state -> event
//						editor.getDomain().relate(EasyFlowDomain.RELATIONS.ON,
//							stateNodes.get(transition.getStart().getUuid()),
//							eventNodes.get(transition.getEvent().getUuid()));

						// event -> state
						final String eventToState = transition.getEvent().getName() + (transition.isEndState() ? EasyFlowDomain.RELATIONS.FINISH : EasyFlowDomain.RELATIONS.TO) + transition.getEnd().getName();
						if (eventToStates.contains(eventToState)) continue;      // prevent duplicates
						eventToStates.add(eventToState);

//						editor.getDomain().relate(transition.isEndState() ? EasyFlowDomain.RELATIONS.FINISH : EasyFlowDomain.RELATIONS.TO,
//							eventNodes.get(transition.getEvent().getUuid()),
//							stateNodes.get(transition.getEnd().getUuid()));
					}
				}
			}

			@Override
			public void exception(Throwable throwable) {
				throw new RuntimeException(throwable);
			}
		});
	}

	;
} 