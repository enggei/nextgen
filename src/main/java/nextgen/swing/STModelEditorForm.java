package nextgen.swing;

import nextgen.actions.*;
import nextgen.model.*;
import nextgen.swing.forms.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static nextgen.swing.ComponentFactory.*;

public class STModelEditorForm extends BaseEditor<STModel> {

   public STModelEditorForm() {
      addComponentListener(new java.awt.event.ComponentAdapter() {
         @Override
         public void componentShown(java.awt.event.ComponentEvent e) {
            if (getModel() == null) return;
            setModel(getModel());
         }
      });
   }

   @Override
   public void setModel(STModel model) {
      super.setModel(model);
      appModel().doLaterInTransaction(tx -> {

         Point viewPosition = null;
         final Component[] components = getComponents();
         if (components.length > 0 && components[0] instanceof JScrollPane) {
            JScrollPane scrollPane = (JScrollPane) components[0];
            viewPosition = scrollPane.getViewport().getViewPosition();
         }

         final JPanel content = newPagePanel();

         addSTValues(getModel(), content);
         content.add(Box.createVerticalGlue());

         removeAll();

         final JScrollPane formScrollPane = newJScrollPane(content);
         formScrollPane.getVerticalScrollBar().setUnitIncrement(50);
         formScrollPane.getHorizontalScrollBar().setUnitIncrement(50);
         if (viewPosition != null) formScrollPane.getViewport().setViewPosition(viewPosition);
         add(formScrollPane, BorderLayout.CENTER);

         revalidate();
         repaint();
      });
   }

   private void addSTValues(STModel model, JPanel panel) {

      final AtomicInteger index = new AtomicInteger(0);

      appModel().getSTParameters(model).forEach(parameterArguments -> {

         final JTextField label = getLabel(parameterArguments.parameter().getName());

         switch (parameterArguments.parameter().getType()) {
            case SINGLE:
               addSingle(model, panel, parameterArguments, label);
               break;
            case LIST:
               index.set(0);
               addList(model, panel, index, parameterArguments, label);
               break;
            case KVLIST:
               index.set(0);
               addKVList(model, panel, index, parameterArguments, label);
               break;
         }
      });
   }

   private void addSingle(STModel model, JPanel panel, ParameterArguments parameterArguments, JTextField label) {
      if (parameterArguments.arguments().isEmpty())
         panel.add(getKeyValueForm(label).setValue(newPrimitiveComponent(model, parameterArguments.parameter())));
      else
         panel.add(getKeyValueForm(label).setValue(newSTValueComponent(model, parameterArguments.parameter(), parameterArguments.arguments().get(0))));
   }

   private void addList(STModel model, JPanel panel, AtomicInteger index, ParameterArguments parameterArguments, JTextField label) {

      final JPanel listPanel = newPagePanel();

      parameterArguments.arguments().stream().filter(stArgument -> stArgument.getValue() != null).forEachOrdered(argument -> {

         if (listPanel.getComponents().length == 0)
            listPanel.add(getKeyValueForm(leftButtons().setOne(getButton(new AddArgumentFromArgumentType(model, parameterArguments.parameter(), listPanel)))));

         listPanel.add(getKeyValueForm(rightButtons()
               .setOne(getButton(index.incrementAndGet(), parameterArguments.arguments().size())
                     .action(selectButton -> {
                        int selectedIndex = Integer.parseInt(selectButton.getValue().toString()) - 1;
                        appModel().reorder(model, argument, parameterArguments.arguments().get(selectedIndex));
                     })))
               .setValue(newSTValueComponent(model, parameterArguments.parameter(), argument)));
      });

      if (listPanel.getComponents().length == 0)
         panel.add(getKeyValueForm(label).setValue(leftButtons().setThree(getButton(new AddArgumentFromArgumentType(model, parameterArguments.parameter(), panel)))));
      else
         panel.add(getKeyValueForm(parameterArguments).setValue(listPanel));
   }

   private void addKVList(STModel model, JPanel panel, AtomicInteger index, ParameterArguments parameterArguments, JTextField label) {
      final JPanel listPanel = newPagePanel();

      parameterArguments.arguments().forEach(stArgument -> {

         if (listPanel.getComponents().length == 0)
            listPanel.add(getKeyValueForm(leftButtons().setThree(getButton(new AddKVArguments(parameterArguments.parameter(), model, listPanel)))));

         index.incrementAndGet();

         final JPanel kvPanel = newPagePanel();

         parameterArguments.parameter().getKeysSorted().forEach(stParameterKey -> {

            final Optional<STArgumentKV> found = stArgument.getKeyValues()
                  .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey))
                  .filter(stArgumentKV -> stArgumentKV.getValue() != null)
                  .findFirst();

            if (found.isPresent()) {
               kvPanel.add(getKeyValueForm(getLabel((index.get()) + "." + stParameterKey.getName()))
                     .setValue(newSTValueComponent(model, stParameterKey, stArgument, found.get())));
            } else {
               kvPanel.add(getKeyValueForm(index.get(), stParameterKey).setValue(leftButtons().setThree(getButton(new SetKVArgumentFromArgumentType(model, stArgument, stParameterKey, kvPanel).setName("SET")))));
            }
         });

         if (kvPanel.getComponents().length != 0) {
            kvPanel.add(getKeyValueForm(rightButtons().setThree(getButton(new DeleteSTArgument(stArgument, listPanel)))));
            listPanel.add(kvPanel);
         }
      });

      if (listPanel.getComponents().length == 0)
         panel.add(getKeyValueForm(label).setValue(leftButtons().setThree(getButton(new AddKVArguments(parameterArguments.parameter(), model, panel)))));
      else
         panel.add(getKeyValueForm(parameterArguments).setValue(listPanel));
   }

   private ButtonFormRight rightButtons() {
      return new ButtonFormRight();
   }

   private ButtonFormLeft leftButtons() {
      return new ButtonFormLeft();
   }

   private JTextField getLabel(String s) {
      final JTextField component = newJTextField(s, s.length());
      component.setEditable(false);
      component.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
      return component;
   }

   private SelectButton getButton(int index, int max) {
      Object[] values = new Object[max];
      for (int i = 0; i < max; i++)
         values[i] = (i + 1);
      return new SelectButton(values, index - 1);
   }

   private JButton getButton(Action action) {
      final JButton component = newButton(action);
      component.setPreferredSize(new Dimension(65, component.getPreferredSize().height));
      component.setMinimumSize(new Dimension(65, component.getPreferredSize().height));
      component.setMaximumSize(new Dimension(65, component.getPreferredSize().height));
      return component;
   }

   private JComponent newSTValueComponent(STModel stModel, STParameter stParameter, STArgument argument) {
      if (argument.getValue() == null) return null;
      switch (argument.getValue().getType()) {
         case STMODEL:
            final JPanel content = newPagePanel();
            addSTValues(argument.getValue().getStModel(), content);
            return content;
         case PRIMITIVE:
            return newPrimitiveComponent(stModel, stParameter, argument);
         case ENUM:
            return new SelectButton(argument.getValue().getStEnumValue().getIncomingValuesSTEnum().findFirst().get().getValuesSorted().toArray(), argument.getValue().getStEnumValue());
      }

      return null;
   }

   private JComponent newSTValueComponent(STModel model, STParameterKey stParameterKey, STArgument stArgument, STArgumentKV argument) {
      if (argument.getValue() == null) return null;
      switch (argument.getValue().getType()) {
         case STMODEL:
            final JPanel content = newPagePanel();
            addSTValues(argument.getValue().getStModel(), content);
            return content;
         case PRIMITIVE:
            return newPrimitiveComponent(model, stParameterKey, stArgument, argument);
         case ENUM:
            return new SelectButton(argument.getValue().getStEnumValue().getIncomingValuesSTEnum().findFirst().get().getValuesSorted().toArray(), argument.getValue().getStEnumValue());
      }

      return null;
   }

   private JComponent newPrimitiveComponent(STModel model, STParameter stParameter) {

      if (stParameter.getName().startsWith("is") || stParameter.getName().startsWith("has")) {
         final JCheckBox component = newJCheckBox();
         component.addActionListener(actionEvent -> appModel().doLaterInTransaction(tx -> appModel().setArgument(model, stParameter, component.isSelected() ? "true" : null)));
         return component;

      } else {
         final JTextField textField = newJTextField("", newSaveListener(txt -> appModel().doLaterInTransaction(tx -> appModel().setArgument(model, stParameter, txt.getText().trim()))));
         return new CrudPanel()
               .setValue(textField)
               .setFromClipboard(getButton(new SetArgumentFromClipboard(model, stParameter)));
      }
   }

   private JComponent newPrimitiveComponent(STModel model, STParameter stParameter, STArgument stArgument) {

      final String render = appModel().render(stArgument.getValue(), "");

      if (render.contains("\n")) {
         final RSyntaxTextArea rSyntaxTextArea = newRSyntaxTextArea(render, newSaveListener(txt -> appModel().doLaterInTransaction(tx -> appModel().updateSTArgument(model, stArgument, txt.getText().trim()))));
         return new TextAreaCrudForm()
               .setTextArea(newRTextScrollPane(rSyntaxTextArea))
               .setDelete(getButton(new DeleteSTArgument(stArgument, rSyntaxTextArea)))
               .setFromClipboard(getButton(new SetArgumentFromClipboard(model, stParameter)))
               .setToClipboard(getButton(new STValueToClipboard(stArgument.getValue())));

      } else if (STAppPresentationModel.isBoolean(stParameter)) {
         final JCheckBox component = newJCheckBox("true".equals(render));
         component.addActionListener(actionEvent -> appModel().doLaterInTransaction(tx -> appModel().updateSTArgument(model, stArgument, component.isSelected() ? "true" : null)));
         return component;

      } else {
         final JTextField textField = newJTextField(render, newSaveListener(txt -> appModel().doLaterInTransaction(tx -> appModel().updateSTArgument(model, stArgument, txt.getText().trim()))));
         return new CrudPanel()
               .setValue(textField)
               .setDelete(getButton(new DeleteSTArgument(stArgument, STModelEditorForm.this)))
               .setFromClipboard(getButton(new SetArgumentFromClipboard(model, stParameter)))
               .setToClipboard(getButton(new STValueToClipboard(stArgument.getValue())));
      }
   }

   private JComponent newPrimitiveComponent(STModel model, STParameterKey stParameterKey, STArgument stArgument, STArgumentKV argument) {

      final String render = appModel().render(argument.getValue());

      if (render.contains("\n")) {
         final RSyntaxTextArea rSyntaxTextArea = newRSyntaxTextArea(render, newSaveListener(txt -> appModel().doLaterInTransaction(tx -> appModel().updateSTArgument(model, stArgument, txt.getText().trim()))));
         return new TextAreaCrudForm()
               .setTextArea(newRTextScrollPane(rSyntaxTextArea))
               .setDelete(getButton(new nextgen.actions.DeleteSTArgumentKV(argument, STModelEditorForm.this)))
               .setFromClipboard(getButton(new SetKVArgumentFromClipboard(model, stArgument, stParameterKey)))
               .setToClipboard(getButton(new STValueToClipboard(stArgument.getValue())));

      } else if (STAppPresentationModel.isBoolean(stParameterKey)) {
         final JCheckBox component = newJCheckBox("true".equals(render));
         component.setHorizontalAlignment(SwingConstants.RIGHT);
         component.addActionListener(actionEvent -> appModel().doLaterInTransaction(tx -> appModel().updateSTArgument(model, argument, component.isSelected() ? "true" : null)));
         return component;

      } else {
         final JTextField textField = newJTextField(render, newSaveListener(txt -> appModel().doLaterInTransaction(tx -> appModel().updateSTArgument(model, argument, txt.getText().trim()))));
         return new CrudPanel()
               .setValue(textField)
               .setDelete(getButton(new nextgen.actions.DeleteSTArgumentKV(argument, STModelEditorForm.this)))
               .setFromClipboard(getButton(new SetKVArgumentFromClipboard(model, stArgument, stParameterKey)))
               .setToClipboard(getButton(new STValueToClipboard(stArgument.getValue())));
      }
   }

   private KeyValueForm getKeyValueForm(ParameterArguments key) {
      return getKeyValueForm()
            .setKey(getLabel(key.parameter().getName()));
   }

   private KeyValueForm getKeyValueForm(int index, STParameterKey stParameterKey) {
      return getKeyValueForm()
            .setKey(getLabel(index + "." + stParameterKey.getName()));
   }

   private KeyValueForm getKeyValueForm(JComponent key) {
      return getKeyValueForm().setKey(key);
   }

   private KeyValueForm getKeyValueForm() {
      return new KeyValueForm();
   }
}