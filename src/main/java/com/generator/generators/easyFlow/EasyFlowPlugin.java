package com.generator.generators.easyFlow;

import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.DomainMotif;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.Visitor;
import com.generator.generators.stringtemplate.GeneratedFile;
import com.generator.util.NeoUtil;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static com.generator.generators.easyFlow.EasyFlowDomainPlugin.Relations.*;
import static com.generator.generators.project.ProjectPlugin.getPackageName;
import static com.generator.generators.project.ProjectPlugin.getFile;
import static com.generator.generators.project.ProjectPlugin.incomingRENDERER;
import static com.generator.util.NeoUtil.*;
import static org.neo4j.graphdb.Direction.OUTGOING;

/**
 * Created 03.08.17.
 */
public class EasyFlowPlugin extends EasyFlowDomainPlugin {

//   private final Node flowNode;

   public EasyFlowPlugin(App app) {
      super(app);

//      final Node domainNode = getGraph().findOrCreate(Domain, AppMotif.Properties.name.name(), "EasyFlow");
//      flowNode = getGraph().findOrCreate(Entity, AppMotif.Properties.name.name(), Flow.name());
//      DomainMotif.newEntityProperty(getGraph(), flowNode, AppMotif.Properties.name.name());
//      DomainMotif.newEntityProperty(getGraph(), flowNode, Properties.extending.name());
//      relate(domainNode, flowNode, DomainPlugin.Relations.ENTITY);
//
//      final Node stateNode = getGraph().findOrCreate(Entity, AppMotif.Properties.name.name(), State.name());
//      DomainMotif.newEntityProperty(getGraph(), stateNode, AppMotif.Properties.name.name());
//
//      final Node contextPropertyNode = getGraph().findOrCreate(Entity, AppMotif.Properties.name.name(), ContextProperty.name());
//      DomainMotif.newEntityProperty(getGraph(), contextPropertyNode, AppMotif.Properties.name.name());
//      DomainMotif.newEntityProperty(getGraph(), contextPropertyNode, Properties.modifier.name());
//      DomainMotif.newEntityProperty(getGraph(), contextPropertyNode, Properties.comment.name());
//      DomainMotif.newEntityProperty(getGraph(), contextPropertyNode, Properties.type.name());
//      DomainMotif.newEntityProperty(getGraph(), contextPropertyNode, Properties.value.name());
//
//      final Node eventNode = getGraph().findOrCreate(Entity, AppMotif.Properties.name.name(), Event.name());
//      DomainMotif.newEntityProperty(getGraph(), eventNode, AppMotif.Properties.name.name());
//
//      DomainMotif.newEntityRelation(getGraph(), flowNode, Relations.FROM.name(), DomainPlugin.RelationCardinality.SINGLE, stateNode);
//      DomainMotif.newEntityRelation(getGraph(), flowNode, Relations.CONTEXT_PROPERTY.name(), DomainPlugin.RelationCardinality.LIST, contextPropertyNode);
//      DomainMotif.newEntityRelation(getGraph(), stateNode, Relations.ON.name(), DomainPlugin.RelationCardinality.LIST, eventNode);
//      DomainMotif.newEntityRelation(getGraph(), eventNode, Relations.TO.name(), DomainPlugin.RelationCardinality.SINGLE, stateNode);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.Flow);

      menu.add(new App.TransactionAction("New Flow", app) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            final Node newNode = newFlow(name);
//            flowNode.createRelationshipTo(newNode, DomainPlugin.Relations.INSTANCE);

            // set name-property = name
            relate(newNode, DomainMotif.newValueNode(getGraph(), name), RelationshipType.withName(AppMotif.Properties.name.name()));
            fireNodesLoaded(newNode);
         }
      });

//      menu.add(new App.TransactionAction("Show domain", app) {
//         @Override
//         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//            fireNodesLoaded(flowNode);
//         }
//      });
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      final Node node = neoNode.getNode();

      if (isFlow(node)) {
         incomingRENDERER(neoNode.getNode(), (rendererRelationship, other) -> pop.add(new App.TransactionAction("Render FSM", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               renderEasyFlow(rendererRelationship, node);
            }
         }));
      }
   }

   @Override
   public JComponent getEditorFor(NeoNode neoNode) {
      return null;
   }

   public static void renderEasyFlow(Relationship rendererRelationship, Node node) {

      final String packageName = getPackageName(rendererRelationship);
      final String name = getName(node);
      final File targetDir = getFile(other(node, rendererRelationship));

      final JavaGenerator javaGenerator = new JavaGenerator(packageName);
      javaGenerator.visit(node);
      final String javaClass = javaGenerator.getResult();

      try {
         GeneratedFile.newJavaFile(targetDir.getPath(), packageName, name).write(javaClass);
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }

   private static final class JavaGenerator implements Visitor<String> {

      private final EasyFlowGroup group = new EasyFlowGroup();
      private final String packageName;

      private EasyFlowGroup.easyFlowST fsm;
      private String result;

      JavaGenerator(String packageName) {
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

         if (!hasOutgoing(node, Relations.FROM))
            throw new IllegalStateException("Flownode has no initial state");

         final Node initStateNode = NeoUtil.otherOutgoing(node, Relations.FROM);
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
            final Object propertyValue = DomainMotif.getEntityProperty(contextPropertyNode, Properties.value.name());
            final String comment = DomainMotif.getEntityProperty(contextPropertyNode, Properties.comment.name());
            final String modifier = DomainMotif.getEntityProperty(contextPropertyNode, Properties.modifier.name());
            final String contextName = DomainMotif.getEntityProperty(contextPropertyNode, AppMotif.Properties.name.name());
            final String type = DomainMotif.getEntityProperty(contextPropertyNode, Properties.type.name());
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

         final String extendsName = DomainMotif.getEntityProperty(node, Properties.extending.name());
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

         if (DomainMotif.hasEntityProperty(state, Properties.comment.name()))
            stateComments.put(stateName, DomainMotif.getEntityProperty(state, Properties.comment.name()));

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
            final Relations relation = hasOutgoing(eventNode, TO) ? TO : FINISH;
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
               System.out.println(eventNode.getProperty(AppMotif.Properties.name.name()) + " " + relation.name() + " x " + types(eventNode.getRelationships(relation, OUTGOING)));
            }
         }
      }
   }
}
