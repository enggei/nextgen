package com.generator.generators.easyFlow;

import com.generator.editors.BaseDomainVisitor;
import com.generator.util.StringUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.generators.easyFlow.EasyFlowDomain.Relations.*;
import static org.neo4j.graphdb.Direction.OUTGOING;

/**
 * Created 14.03.17.
 */
public class EasyFlowJavaGenerator extends EasyFlowDomain.EasyFlowDomainVisitor {

   private final EasyFlowGroup group;

   private EasyFlowGroup.easyFlowST fsm;

   public EasyFlowJavaGenerator(EasyFlowGroup group) {
      this.group = group;
   }

   @Override
   <T> T visitFlow(Node node) {

      final String name = get(node, EasyFlowDomain.Properties.name.name());
      final String packageName = get(node, EasyFlowDomain.Properties.packageName.name());

      final Set<String> events = new TreeSet<>();
      final Set<String> states = new TreeSet<>();
      final Map<String, String> stateComments = new LinkedHashMap<>();

      final EasyFlowGroup.transitST transitST = group.newtransit().
            setIsInit("true").
            setIsFinish("false");

      if (!hasOutgoing(node, FROM))
         throw new IllegalStateException("Flownode has no initial state");

      final Node initStateNode = BaseDomainVisitor.otherOutgoing(node, FROM);
      final String initStateName = StringUtil.toUpper(get(initStateNode, "name"));
      expand(initStateNode, transitST.setState(initStateName), group, events, states, stateComments);

      final EasyFlowGroup.eventsST eventsST = group.newevents();
      for (String event : events) eventsST.addEventsValue(event);

      final EasyFlowGroup.statesST statesST = group.newstates();
      for (String state : states)
         statesST.addStatesValue(group.newstateDeclaration().
               setName(state).
               setComment(stateComments.getOrDefault(state, null)));

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
            setPackage(packageName).
            setContext(contextST).
            setStates(statesST).
            setEvents(eventsST).
            setTransit(transitST);

      group.getSTGroup().getInstanceOf("easyFLow");

      if (has(node, "extends")) fsm.setExtends(get(node, "extends"));

//      for (Relationship relationship : outgoing(node, SUPERPARAMETERS))
//         fsm.addSuperParamsValue(getOtherProperty(node, relationship, "name"), getOtherProperty(node, relationship, "type"));

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

      final String stateName = StringUtil.toUpper(get(state, "name"));
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

         final EasyFlowDomain.Relations relation = hasOutgoing(eventNode, TO) ? TO : FINISH;
         try {

            final Relationship toStateRelationship = singleOutgoing(eventNode, relation);
            if (toStateRelationship == null)
               throw new IllegalStateException("event '" + eventName + "' is missing a destination state. Please add a state to this event.");

            final Node newState = other(eventNode, toStateRelationship);
            final EasyFlowGroup.transitST transit = group.newtransit().
                  setEvent(eventName).
                  setState(StringUtil.toUpper(get(newState, "name")));
            expand(newState, transit, group, events, states, stateComments);
            parent.addTransitsValue(transit);

         } catch (Exception e) {
            System.out.println(eventNode.getProperty("name") + " " + relation.name() + " x " + types(eventNode.getRelationships(relation, OUTGOING)));
         }
      }
   }
}