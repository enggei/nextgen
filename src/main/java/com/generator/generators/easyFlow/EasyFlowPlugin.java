package com.generator.generators.easyFlow;

import com.generator.app.*;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.project.ProjectPlugin;
import com.generator.generators.stringtemplate.domain.GeneratedFile;
import com.generator.util.NeoUtil;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static com.generator.app.DomainMotif.getPropertyValue;
import static com.generator.app.DomainMotif.hasProperty;
import static com.generator.generators.domain.DomainPlugin.Entities.Domain;
import static com.generator.generators.domain.DomainPlugin.Entities.Entity;
import static com.generator.generators.easyFlow.EasyFlowPlugin.Entities.*;
import static com.generator.generators.easyFlow.EasyFlowPlugin.Relations.*;
import static com.generator.generators.project.ProjectPlugin.getFile;
import static com.generator.util.NeoUtil.*;
import static org.neo4j.graphdb.Direction.OUTGOING;

/**
 * Created 03.08.17.
 */
public class EasyFlowPlugin extends Plugin {

   public enum Entities implements Label {
      Flow, State, ContextProperty, Event
   }

   public enum Relations implements RelationshipType {
      CONTEXT_PROPERTY, FINISH, TO, FROM, ON
   }

   public enum Properties {
      extending, modifier, comment, type, value
   }

   private final Node flowNode;

   public EasyFlowPlugin(App app) {
      super(app, "EasyFlow");

      final Node domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), "EasyFlow");
      flowNode = getGraph().findOrCreate(Entity, AppMotif.Properties.name.name(), Flow.name());
      DomainMotif.newEntityProperty(getGraph(),flowNode, AppMotif.Properties.name.name());
      DomainMotif.newEntityProperty(getGraph(),flowNode, Properties.extending.name());
      relate(domainNode, flowNode, DomainPlugin.Relations.ENTITY);

      final Node stateNode = getGraph().findOrCreate(Entity, AppMotif.Properties.name.name(), State.name());
      DomainMotif.newEntityProperty(getGraph(),stateNode, AppMotif.Properties.name.name());

      final Node contextPropertyNode = getGraph().findOrCreate(Entity, AppMotif.Properties.name.name(), ContextProperty.name());
      DomainMotif.newEntityProperty(getGraph(),contextPropertyNode, AppMotif.Properties.name.name());
      DomainMotif.newEntityProperty(getGraph(),contextPropertyNode, Properties.modifier.name());
      DomainMotif.newEntityProperty(getGraph(),contextPropertyNode, Properties.comment.name());
      DomainMotif.newEntityProperty(getGraph(),contextPropertyNode, Properties.type.name());
      DomainMotif.newEntityProperty(getGraph(),contextPropertyNode, Properties.value.name());

      final Node eventNode = getGraph().findOrCreate(Entity, AppMotif.Properties.name.name(), Event.name());
      DomainMotif.newEntityProperty(getGraph(),eventNode, AppMotif.Properties.name.name());

      DomainMotif.newEntityRelation(getGraph(),flowNode, Relations.FROM.name(), DomainPlugin.RelationCardinality.SINGLE, stateNode);
      DomainMotif.newEntityRelation(getGraph(),flowNode, Relations.CONTEXT_PROPERTY.name(), DomainPlugin.RelationCardinality.LIST, contextPropertyNode);
      DomainMotif.newEntityRelation(getGraph(),stateNode, Relations.ON.name(), DomainPlugin.RelationCardinality.LIST, eventNode);
      DomainMotif.newEntityRelation(getGraph(),eventNode, Relations.TO.name(), DomainPlugin.RelationCardinality.SINGLE, stateNode);
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.Flow);

      menu.add(new App.TransactionAction("New Flow", app) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            final Node newNode = getGraph().newNode(Entities.Flow);
            flowNode.createRelationshipTo(newNode, DomainPlugin.Relations.INSTANCE);

            // set name-property = name
            relate(newNode, DomainMotif.newValueNode(getGraph(), name), RelationshipType.withName(AppMotif.Properties.name.name()));
            fireNodesLoaded(newNode);
         }
      });

      menu.add(new App.TransactionAction("Show domain", app) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            fireNodesLoaded(flowNode);
         }
      });
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      final Node node = neoNode.getNode();

      if (hasLabel(node, Entities.Flow)) {
         incoming(neoNode.getNode(), ProjectPlugin.Relations.RENDERER).forEach(rendererRelationship -> pop.add(new App.TransactionAction("Render FSM", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               renderEasyFlow(rendererRelationship, node);
            }
         }));
      }
   }

   @Override
   public void showEditorFor(NeoNode neoNode, JTabbedPane tabbedPane) {

   }

   public static void renderEasyFlow(Relationship rendererRelationship, Node node) {

      final String packageName = getString(rendererRelationship, "package");
      final String name = getPropertyValue(node, AppMotif.Properties.name.name());
      final File targetDir = getFile(other(node, rendererRelationship));

      final String javaClass = new JavaGenerator(new EasyFlowGroup()).visitFlow(node, packageName);

      try {
         GeneratedFile.newJavaFile(targetDir.getPath(), packageName, name).write(javaClass);
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }

   private static final class JavaGenerator {

      private final EasyFlowGroup group;

      private EasyFlowGroup.easyFlowST fsm;

      JavaGenerator(EasyFlowGroup group) {
         this.group = group;
      }

      String visitFlow(Node node, String packageName) {
         final String name = getPropertyValue(node, AppMotif.Properties.name.name());

         final Set<String> events = new TreeSet<>();
         final Set<String> states = new TreeSet<>();
         final Map<String, String> stateComments = new LinkedHashMap<>();

         final EasyFlowGroup.transitST transitST = group.newtransit().
               setIsInit("true").
               setIsFinish("false");

         if (!hasOutgoing(node, FROM))
            throw new IllegalStateException("Flownode has no initial state");

         final Node initStateNode = NeoUtil.otherOutgoing(node, FROM);
         final String initStateName = StringUtil.toUpper(getPropertyValue(initStateNode, AppMotif.Properties.name.name()));
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
            final Object propertyValue = getPropertyValue(contextPropertyNode, Properties.value.name());
            final String comment = getPropertyValue(contextPropertyNode, Properties.comment.name());
            final String modifier = getPropertyValue(contextPropertyNode, Properties.modifier.name());
            final String contextName = getPropertyValue(contextPropertyNode, AppMotif.Properties.name.name());
            final String type = getPropertyValue(contextPropertyNode, Properties.type.name());
            contextST.addPropertiesValue(comment, modifier, contextName, type, propertyValue == null ? null : formatPropertyValue(propertyValue));
         }

         this.fsm = group.neweasyFlow().
               setName(name).
               setPackage(packageName).
               setContext(contextST).
               setStates(statesST).
               setEvents(eventsST).
               setTransit(transitST);

         group.getSTGroup().getInstanceOf("easyFLow");

         final String extendsName = getPropertyValue(node, Properties.extending.name());
         if (extendsName != null) fsm.setExtends(extendsName);

         for (String state : states) {
            fsm.addBindingsValue(
                  group.newdeclaration().
                        setName(name).
                        setState(state),
                  group.newimpl().
                        setName(name).
                        setState(state));
         }

         return fsm.toString();
      }

      private Object formatPropertyValue(Object value) {
         // non-null
         final String t = value.toString();
         return t.replaceAll("\\\\", "");
      }

      private void expand(Node state, final EasyFlowGroup.transitST parent, EasyFlowGroup group, Set<String> events, Set<String> states, Map<String, String> stateComments) {

         final String stateName = StringUtil.toUpper(getPropertyValue(state, AppMotif.Properties.name.name()));
         if (states.contains(stateName)) return;
         states.add(stateName);

         if (hasProperty(state, Properties.comment.name()))
            stateComments.put(stateName, getPropertyValue(state, Properties.comment.name()));

         if (!state.hasRelationship(OUTGOING, ON)) {
            parent.setIsFinish("true");
            return;
         }

         for (Relationship relationship : outgoing(state, ON)) {
            final Node eventNode = other(state, relationship);

            if (!hasProperty(eventNode, AppMotif.Properties.name.name()))
               throw new IllegalStateException("state '" + stateName + "' has an event with no name. Please name the event.");

            final String eventName = getPropertyValue(eventNode, AppMotif.Properties.name.name());
            events.add(eventName);

            // this should fix the TO/FINISH in easy-flow (i.e its automatic, user do not have to worry about it)
            final Relations relation = hasOutgoing(eventNode, TO) ? TO : FINISH;
            try {

               final Relationship toStateRelationship = singleOutgoing(eventNode, relation);
               if (toStateRelationship == null)
                  throw new IllegalStateException("event '" + eventName + "' is missing a destination state. Please add a state to this event.");

               final Node newState = other(eventNode, toStateRelationship);
               final EasyFlowGroup.transitST transit = group.newtransit().
                     setEvent(eventName).
                     setState(StringUtil.toUpper(getPropertyValue(newState, AppMotif.Properties.name.name())));
               expand(newState, transit, group, events, states, stateComments);
               parent.addTransitsValue(transit);

            } catch (Exception e) {
               System.out.println(eventNode.getProperty(AppMotif.Properties.name.name()) + " " + relation.name() + " x " + types(eventNode.getRelationships(relation, OUTGOING)));
            }
         }
      }
   }
}
