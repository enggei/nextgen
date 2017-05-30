package com.generator.generators;

import com.generator.domain.IDomain;
import com.generator.editors.NeoModel;
import com.generator.editors.canvas.NeoPNodeRenderPanel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.editors.canvas.neo.NeoPTextNode;
import com.generator.generators.durandal.DurandalDomainImpl;
import com.generator.generators.easyFlow.EasyFlowDomainImpl;
import com.generator.generators.html5.Html5Domain;
import com.generator.generators.java.JavaDomainImpl;
import com.generator.generators.javareflection.JavaBuilderDomainImpl;
import com.generator.generators.json.JsonDomainImpl;
import com.generator.generators.maven.MavenDomain;
import com.generator.generators.maven.MavenDomainImpl;
import com.generator.generators.meta.MetaDomainImpl;
import com.generator.generators.mysql.MysqlDomainImpl;
import com.generator.generators.neo.NeoDomainImpl;
import com.generator.generators.project.ProjectDomain;
import com.generator.generators.project.ProjectDomainImpl;
import com.generator.generators.templates.TemplateDomainImpl;
import com.generator.generators.vertx.VertxDomain;
import com.generator.generators.vertx.VertxDomainImpl;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import static com.generator.editors.NeoModel.uuidOf;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created 23.02.17.
 */
public class GeneratorEditor extends NeoEditor {

   private final Set<IDomain> domains = new LinkedHashSet<>();

   GeneratorEditor(Set<IDomain> domains) {
      super();
      canvas.setBackground(new Color(Integer.valueOf("247, 247, 247".split(", ")[0]), Integer.valueOf("247, 247, 247".split(", ")[1]), Integer.valueOf("247, 247, 247".split(", ")[2])));

      this.domains.addAll(domains);
      for (IDomain domain : this.domains)
         for (org.neo4j.graphdb.Label label : domain.values())
            nodesByLabel.put(label.name(), new LinkedHashSet<>());
   }

   @Override
   protected NeoPNode newNode(Node node, String nodetype) {

      if (nodetype == null) {
         System.out.println("null nodetype");
         return new NeoPTextNode(node, this, node.getLabels().iterator().next().toString());
      }

      final Set<UUID> set = nodesByLabel.computeIfAbsent(nodetype, k -> new LinkedHashSet<>());
      set.add(uuidOf(node));

      for (IDomain domain : domains) {
         for (Label label : domain.values()) {
            if (nodetype.equals(label.name()))
               return domain.newPNode(node, nodetype, this);
         }
      }

      for (Html5Domain.Entities label : Html5Domain.Entities.values()) {
         if (nodetype.equals(label.name())) {
            return Html5Domain.newPNode(node, nodetype, this);
         }
      }

      System.err.println("nodetype " + nodetype + " is unsupported for node " + NeoModel.debugNode(node));

      return new NeoPTextNode(node,this, node.getLabels().iterator().next().toString());
   }

   @Override
   public void deleteNode(Node node) throws ReferenceException {

      final String deleteLabel = node.getLabels().iterator().next().name();// assumes first (and only?) label is the node's label

      for (IDomain domain : domains) {
         for (Label label : domain.values()) {
            if (label.name().equals(deleteLabel)) {
               domain.deleteNode(node);
               return;
            }
         }
      }
   }

   @Override
   protected void addToMenu(JPopupMenu pop, PInputEvent event) {

      for (IDomain domain : domains) {
         final JMenu domainMenu = new JMenu(domain.getName());
         domain.addToDomainMenu(event, this, domainMenu);

         getGraph().getGraphDb().getAllLabelsInUse().forEach(lbl -> {
            for (Label label : domain.values()) {
               if (lbl.name().equals(label.name())) {
                  domainMenu.add(showAllNodesByLabel(label, event));
                  return;
               }
            }
         });

         pop.add(domainMenu);
      }

      super.addToMenu(pop, event);
   }

   public static void main(String[] args) {

      // todo make a parseable-json converting to Set<IDomain>
      final Set<IDomain> domains = new LinkedHashSet<>();
      domains.add(new MetaDomainImpl());
      domains.add(new TemplateDomainImpl());
      domains.add(new EasyFlowDomainImpl());
      domains.add(new VertxDomainImpl());
      domains.add(new ProjectDomainImpl());
      domains.add(new MavenDomainImpl());
      domains.add(new MysqlDomainImpl());
      domains.add(new JsonDomainImpl());
      domains.add(new JavaDomainImpl());
      domains.add(new NeoDomainImpl());
      domains.add(new DurandalDomainImpl());
      domains.add(new JavaBuilderDomainImpl());

      System.setProperty("generator.path", "src/main/java/com/generator/generators");
      SwingUtil.setLookAndFeel_Nimbus();

      final JFrame frame = new JFrame();
      final GeneratorEditor contentPanel = new GeneratorEditor(domains);
      final NeoPNodeRenderPanel renderPanel = new NeoPNodeRenderPanel();
      contentPanel.addPropertyChangeListener(renderPanel);

      frame.getContentPane().add(contentPanel.getCanvas(), BorderLayout.CENTER);
      frame.getContentPane().add(new JScrollPane(renderPanel), BorderLayout.EAST);
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      frame.addWindowFocusListener(new WindowAdapter() {
         @Override
         public void windowGainedFocus(WindowEvent e) {
            contentPanel.getCanvas().requestFocusInWindow();
         }
      });

      SwingUtil.show(frame);
   }
}