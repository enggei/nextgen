package com.generator.generators.easyFlow;

import com.generator.app.AppMotif;
import com.generator.app.DomainMotif;
import com.generator.generators.domain.Visitor;
import com.generator.util.NeoUtil;
import com.generator.util.StringUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static com.generator.generators.easyFlow.EasyFlowDomainPlugin.Relations.*;
import static com.generator.util.NeoUtil.*;
import static org.neo4j.graphdb.Direction.OUTGOING;

/**
 * Created 01.04.18.
 */
final class EasyFlowGenerator implements Visitor<String> {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EasyFlowGenerator.class);

   private final EasyFlowGroup group = new EasyFlowGroup();
   private final String packageName;

   private String result;

   EasyFlowGenerator(String packageName) {
      this.packageName = packageName;
   }

   @Override
   public String getResult() {
      return result;
   }

   @Override
   public void visit(Node node) {
      final String name = DomainMotif.getEntityProperty(node, AppMotif.Properties.name.name());

      final Set<String> events = new TreeSet<>();
      final Set<String> states = new TreeSet<>();
      final Map<String, String> stateComments = new LinkedHashMap<>();

      final EasyFlowGroup.transitST transitST = group.newtransit().
            setIsInit("true").
            setIsFinish("false");

      if (!hasOutgoing(node, EasyFlowDomainPlugin.Relations.FROM))
         throw new IllegalStateException("Flownode has no initial state");

      final Node initStateNode = NeoUtil.otherOutgoing(node, EasyFlowDomainPlugin.Relations.FROM);
      final String initStateName = StringUtil.toUpper(DomainMotif.getEntityProperty(initStateNode, AppMotif.Properties.name.name()));
      expand(initStateNode, transitST.setState(initStateName), group, events, states, stateComments);

      final EasyFlowGroup.eventsST eventsST = group.newevents();
      for (String event : events) eventsST.addEventsValue(event);

      final EasyFlowGroup.statesST statesST = group.newstates();
      for (String state : states)
         statesST.addStatesValue(group.newstateDeclaration().
               setName(state).
               setComment(stateComments.getOrDefault(state, null)));

      final EasyFlowGroup.statefulContextST contextST = group.newstatefulContext().
            setName(name);

      for (Relationship propertyRelation : NeoUtil.outgoing(node, CONTEXT_PROPERTY)) {
         final Node contextPropertyNode = other(node, propertyRelation);
         final Object propertyValue = DomainMotif.getEntityProperty(contextPropertyNode, EasyFlowDomainPlugin.Properties.value.name());
         final String comment = DomainMotif.getEntityProperty(contextPropertyNode, EasyFlowDomainPlugin.Properties.comment.name());
         final String modifier = DomainMotif.getEntityProperty(contextPropertyNode, EasyFlowDomainPlugin.Properties.modifier.name());
         final String contextName = DomainMotif.getEntityProperty(contextPropertyNode, AppMotif.Properties.name.name());
         final String type = DomainMotif.getEntityProperty(contextPropertyNode, EasyFlowDomainPlugin.Properties.type.name());
         contextST.addPropertiesValue(comment, modifier, contextName, type, propertyValue == null ? null : formatPropertyValue(propertyValue));
      }

      final EasyFlowGroup.easyFlowST fsm = group.neweasyFlow().
            setName(name).
            setPackage(packageName).
            setContext(contextST).
            setStates(statesST).
            setEvents(eventsST).
            setTransit(transitST);

      group.getSTGroup().getInstanceOf("easyFLow");

      final String extendsName = DomainMotif.getEntityProperty(node, EasyFlowDomainPlugin.Properties.extending.name());
      if (extendsName != null) fsm.setExtends(extendsName);

      // if handling jsonMessages, add methods for this:
      final Boolean isHandlingJsonMessages = DomainMotif.getEntityProperty(node, "isHandlingJsonMessages", false);
      final EasyFlowGroup.jsonMessageHandlerST jsonMessageHandlerST = group.newjsonMessageHandler().
            setName(name);

      for (String state : states) {
         fsm.addBindingsValue(
               group.newdeclaration().
                     setName(name).
                     setState(state),
               group.newimpl().
                     setName(name).
                     setState(state));

         if (isHandlingJsonMessages)
            jsonMessageHandlerST.addStatesValue(state);
      }

      if (isHandlingJsonMessages)
         fsm.setIsHandlingJsonMessages(jsonMessageHandlerST);

      result = fsm.toString();
   }

   private Object formatPropertyValue(Object value) {
      // non-null
      final String t = value.toString();
      return t.replaceAll("\\\\", "");
   }

   private void expand(Node state, final EasyFlowGroup.transitST parent, EasyFlowGroup group, Set<String> events, Set<String> states, Map<String, String> stateComments) {

      final String stateName = StringUtil.toUpper(DomainMotif.getEntityProperty(state, AppMotif.Properties.name.name()));
      if (states.contains(stateName)) return;
      states.add(stateName);

      if (DomainMotif.hasEntityProperty(state, EasyFlowDomainPlugin.Properties.comment.name()))
         stateComments.put(stateName, DomainMotif.getEntityProperty(state, EasyFlowDomainPlugin.Properties.comment.name()));

      if (!state.hasRelationship(OUTGOING, ON)) {
         parent.setIsFinish("true");
         return;
      }

      for (Relationship relationship : outgoing(state, ON)) {
         final Node eventNode = other(state, relationship);

         if (!DomainMotif.hasEntityProperty(eventNode, AppMotif.Properties.name.name()))
            throw new IllegalStateException("state '" + stateName + "' has an event with no name. Please name the event.");

         final String eventName = DomainMotif.getEntityProperty(eventNode, AppMotif.Properties.name.name());
         events.add(eventName);

         // this should fix the TO/FINISH in easy-flow (i.e its automatic, user do not have to worry about it)
         final EasyFlowDomainPlugin.Relations relation = hasOutgoing(eventNode, TO) ? TO : FINISH;
         try {

            final Relationship toStateRelationship = singleOutgoing(eventNode, relation);
            if (toStateRelationship == null)
               throw new IllegalStateException("event '" + eventName + "' is missing a destination state. Please add a state to this event.");

            final Node newState = other(eventNode, toStateRelationship);
            final EasyFlowGroup.transitST transit = group.newtransit().
                  setEvent(eventName).
                  setState(StringUtil.toUpper(DomainMotif.getEntityProperty(newState, AppMotif.Properties.name.name())));
            expand(newState, transit, group, events, states, stateComments);
            parent.addTransitsValue(transit);

         } catch (Exception e) {
            log.info(eventNode.getProperty(AppMotif.Properties.name.name()) + " " + relation.name() + " x " + types(eventNode.getRelationships(relation, OUTGOING)));
         }
      }
   }
}
