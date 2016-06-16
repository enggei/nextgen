package com.generator.generators.easyFlow;

import com.generator.generators.templates.domain.GeneratedFile;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static com.generator.generators.easyFlow.EasyFlowDomain.RELATIONS.*;
import static org.neo4j.graphdb.Direction.OUTGOING;

/**
 * goe on 4/23/15.
 */
public class EasyFlowJavaGenerator extends EasyFlowDomainVisitor {

	private final EasyFlowGroup group = new EasyFlowGroup();

	private EasyFlowGroup.easyFlowST fsm;

	public EasyFlowJavaGenerator(Component component) {
		super(component, "Generate Java");
	}

	@Override
	<T> T visitFlow(Node node) {
		final String name = get(node, "name");

		if (has(node, "root"))
			this.targetFile = GeneratedFile.newJavaFile(get(node, "root").toString(), get(node, "package").toString(), get(node, "name").toString()).getFile();

		final Set<String> events = new TreeSet<>();
		final Set<String> states = new TreeSet<>();
		final Map<String, String> stateComments = new LinkedHashMap<>();

		final EasyFlowGroup.transitST transitST = group.newtransit().
			setIsInit("true").
			setIsFinish("false");

		if (!hasOutgoing(node, FROM))
			throw new IllegalStateException("Flownode has no initial state");

		final Node initState = otherOutgoing(node, FROM);
		expand(initState, transitST.setState(get(initState, "name")), group, events, states, stateComments);

		final EasyFlowGroup.eventsST eventsST = group.newevents();
		for (String event : events) eventsST.addEventsValue(event);

		final EasyFlowGroup.statesST statesST = group.newstates();
		for (String state : states)
			statesST.addStatesValue(group.newstateDeclaration().
				setName(state).
				setComment(stateComments.containsKey(state) ? stateComments.get(state) : null));

		final String contextGeneric = getString(node, "contextGeneric");

		final EasyFlowGroup.statefulContextST contextST = group.newstatefulContext().
			setName(name).
			setContextGeneric(contextGeneric);

		for (Relationship propertyRelation : outgoing(node, PROPERTY)) {
			final Node propertyNode = other(node, propertyRelation);
			final Object propertyValue = has(propertyNode, "value") ? formatPropertyValue(get(propertyNode, "value")) : null;
			contextST.addPropertiesValue(get(propertyNode, "comment"), get(propertyNode, "modifier"), get(propertyNode, "name"), get(propertyNode, "type"), propertyValue);
		}

		this.fsm = group.neweasyFlow().
			setName(name).
			setPackage(get(node, "package")).
			setContext(contextST).
			setStates(statesST).
			setEvents(eventsST).
			setTransit(transitST);

		group.getSTGroup().getInstanceOf("easyFLow");

		if (has(node, "extends")) fsm.setExtends(get(node, "extends"));

		for (Relationship relationship : outgoing(node, SUPERPARAMETERS))
			fsm.addSuperParamsValue(getOtherProperty(node, relationship, "name"), getOtherProperty(node, relationship, "type"));

		for (String state : states) {
			fsm.addBindingsValue(
				group.newdeclaration().
					setName(name).
					setState(state),
				group.newimpl().
					setName(name).
					setState(state));
		}

		return (T) fsm.toString();
	}

	private Object formatPropertyValue(Object value) {
		// non-null
		final String t = value.toString();
		return t.replaceAll("\\\\", "");
	}

	private void expand(Node state, final EasyFlowGroup.transitST parent, EasyFlowGroup group, Set<String> events, Set<String> states, Map<String, String> stateComments) {

		final String stateName = get(state, "name").toString();
		if (states.contains(stateName)) return;
		states.add(stateName);

		if (has(state, "comment"))
			stateComments.put(stateName, getString(state, "comment"));

		if (!state.hasRelationship(OUTGOING, ON)) {
			parent.setIsFinish("true");
			return;
		}

		for (Relationship relationship : outgoing(state, ON)) {
			final Node eventNode = other(state, relationship);

			if (!has(eventNode, "name"))
				throw new IllegalStateException("state '" + stateName + "' has an event with no name. Please name the event.");

			final String eventName = getString(eventNode, "name");
			events.add(eventName);

			final EasyFlowDomain.RELATIONS relation = hasOutgoing(eventNode, TO) ? TO : FINISH;
			try {

				final Relationship toStateRelationship = singleOutgoing(eventNode, relation);
				if (toStateRelationship == null)
					throw new IllegalStateException("event '" + eventName + "' is missing a destination state. Please add a state to this event.");

				final Node newState = other(eventNode, toStateRelationship);
				final EasyFlowGroup.transitST transit = group.newtransit().
					setEvent(eventName).
					setState(get(newState, "name"));
				expand(newState, transit, group, events, states, stateComments);
				parent.addTransitsValue(transit);

			} catch (Exception e) {
				System.out.println(eventNode.getProperty("name") + " " + relation.name() + " x " + types(eventNode.getRelationships(relation, OUTGOING)));
			}
		}
	}

	@Override
	public <T> void done(T result) {
		showOutput(result);
	}
}