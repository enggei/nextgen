package nextgen.model.domain;

import nextgen.model.domain.swing.*;
import nextgen.swing.BaseEditor;
import nextgen.utils.SwingUtil;
import org.greenrobot.eventbus.EventBus;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import static nextgen.swing.ComponentFactory.*;

public class DomainEditor extends BaseEditor<Domain> {

   public DomainEditor() {
   }

   public DomainEditor(Domain model) {
      super(model);
      add(newDomainForm(model));
   }

   public static void main(String[] args) {

      final DomainEditor tests = new DomainEditor();
      EventBus.getDefault().register(tests);

      final Domain zzzz = tests.newDomain("zzzz");
      for (int i = 0; i < 2; i++) zzzz.addProperties(tests.newProperty("z" + (i + 1), i));
      for (DomainProperty domainProperty : zzzz.getProperties()) log(domainProperty.toString());

      final DomainEntity a = tests.newEntity("A");
      zzzz.addRoots(a);
      for (int i = 0; i < 3; i++) a.addProperties(tests.newProperty("a" + (i + 1), i));

      final DomainEntity b = tests.newEntity("B");
      zzzz.addRoots(b);
      for (int i = 0; i < 3; i++) b.addProperties(tests.newProperty("b" + (i + 1), i));

      final DomainEntity c = tests.newEntity("C");
      for (int i = 0; i < 3; i++) b.addProperties(tests.newProperty("c" + (i + 1), i));

      final DomainRelation rab = tests.newRelation("ab", a, b);
      for (int i = 0; i < 4; i++) rab.addProperties(tests.newProperty("rab" + (i + 1), i));

      final DomainRelation rbc = tests.newRelation("bc", b, c);
      for (int i = 0; i < 4; i++) rbc.addProperties(tests.newProperty("rbc" + (i + 1), i));

      applyLaf();
      SwingUtil.showPanel(new DomainEditor(zzzz));
   }

   private DomainForm newDomainForm(Domain domain) {

      final JPanel propertiesPanel = newPagePanel();
      final Map<Object, JComponent> propertiesMap = new LinkedHashMap<>();
      propertiesPanel.add(newAddDelPanel(actionEvent -> {
         final DomainProperty newProperty = newProperty("", "");
         domain.addProperties(newProperty);
         final DomainPropertyForm form = newPropertyForm(newProperty);
         propertiesMap.put(newProperty, form);
         propertiesPanel.add(form);
         propertiesPanel.revalidate();
      }, actionEvent -> {
         if (domain.getProperties().isEmpty()) return;
         final DomainProperty property = domain.getProperties().getLast();
         domain.removeProperties(property);
         final JComponent form = propertiesMap.remove(property);
         propertiesPanel.remove(form);
         propertiesPanel.revalidate();
      }));

      domain.getProperties().forEach(property -> {
         final DomainPropertyForm form = newPropertyForm(property);
         propertiesMap.put(property, form);
         propertiesPanel.add(form);
      });

      final JPanel rootsPanel = newPagePanel();
      domain.getRoots().forEach(entity -> rootsPanel.add(newEntityForm(entity)));

      final DomainForm form = new DomainForm()
            .setName(newJLabel("Name"))
            .setName(newJTextField(domain.getName(), newSaveListener(textField -> domain.setName(textField.getText()))))
            .setProperties(newJLabel("Properties"))
            .setProperties(propertiesPanel)
            .setRoots(newJLabel("Roots"))
            .setRoots(rootsPanel);
      form.setPreferredSize(new Dimension(1024, 768));

      return form;
   }

   private DomainEntityForm newEntityForm(DomainEntity entity) {

      final JPanel propertiesPanel = newPagePanel();
      final Map<Object, JComponent> propertiesMap = new LinkedHashMap<>();
      propertiesPanel.add(newAddDelPanel(actionEvent -> {
         final DomainProperty newProperty = newProperty("", "");
         entity.addProperties(newProperty);
         final DomainPropertyForm form = newPropertyForm(newProperty);
         propertiesMap.put(newProperty, form);
         propertiesPanel.add(form);
         propertiesPanel.revalidate();
      }, actionEvent -> {
         if (entity.getProperties().isEmpty()) return;
         final DomainProperty property = entity.getProperties().getLast();
         entity.removeProperties(property);
         final JComponent form = propertiesMap.remove(property);
         propertiesPanel.remove(form);
         propertiesPanel.revalidate();
      }));

      entity.getProperties().forEach(property -> {
         final DomainPropertyForm form = newPropertyForm(property);
         propertiesMap.put(property, form);
         propertiesPanel.add(form);
      });

      final JPanel relationsPanel = newPagePanel();
      entity.getRelations().forEach(relation -> relationsPanel.add(newRelationForm(relation)));

      return new DomainEntityForm()
            .setName(newJLabel("Name"))
            .setName(newJTextField(entity.getName(), newSaveListener(textField -> entity.setName(textField.getText()))))
            .setProperties(newJLabel("Properties"))
            .setProperties(propertiesPanel)
            .setRelations(newJLabel("Relations"))
            .setRelations(relationsPanel)
            ;
   }

   private DomainRelationForm newRelationForm(DomainRelation relation) {

      final JPanel propertiesPanel = newPagePanel();
      final Map<Object, JComponent> propertiesMap = new LinkedHashMap<>();
      propertiesPanel.add(newAddDelPanel(actionEvent -> {
         final DomainProperty newProperty = newProperty("", "");
         relation.addProperties(newProperty);
         final DomainPropertyForm form = newPropertyForm(newProperty);
         propertiesMap.put(newProperty, form);
         propertiesPanel.add(form);
         propertiesPanel.revalidate();
      }, actionEvent -> {
         if (relation.getProperties().isEmpty()) return;
         final DomainProperty property = relation.getProperties().getLast();
         relation.removeProperties(property);
         final JComponent form = propertiesMap.remove(property);
         propertiesPanel.remove(form);
         propertiesPanel.revalidate();
      }));

      relation.getProperties().forEach(property -> {
         final DomainPropertyForm form = newPropertyForm(property);
         propertiesMap.put(property, form);
         propertiesPanel.add(form);
      });

      return new DomainRelationForm()
            .setName(newJLabel("Name"))
            .setName(newJTextField(relation.getName(), newSaveListener(textField -> relation.setName(textField.getText()))))
            .setProperties(newJLabel("Properties"))
            .setProperties(propertiesPanel)
            .setEntity(newJLabel("Entity"))
            .setEntity(newEntityForm(relation.getEntity()));
   }

   private DomainPropertyForm newPropertyForm(DomainProperty property) {
      return new DomainPropertyForm()
            .setName(newJLabel("name"))
            .setValue(newJLabel("value"))
            .setName(newJTextField(property.getName(), newSaveListener(textField -> property.setName(textField.getText()))))
            .setValue(newJTextField(property.getValue().toString(), newSaveListener(textField -> property.setName(textField.getText()))));
   }

   private DomainProperty newProperty(String name, Object value) {
      return new DomainProperty().setName(name).setValue(value);
   }

   private DomainRelation newRelation(String name, DomainEntity a, DomainEntity b) {
      final DomainRelation relation = new DomainRelation().setName(name).setEntity(b);
      a.addRelations(relation);
      return relation;
   }

   private DomainEntity newEntity(String name) {
      return new DomainEntity().setName(name);
   }

   private Domain newDomain(String name) {
      return new Domain().setName(name);
   }

   @org.greenrobot.eventbus.Subscribe
   public void onName(String event) {
      log(event);
   }

   private static void log(String s) {
      System.out.println(s);
   }
}
