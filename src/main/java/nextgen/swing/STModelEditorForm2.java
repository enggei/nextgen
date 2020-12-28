package nextgen.swing;

import nextgen.model.*;
import nextgen.swing.forms.KeyValueForm;
import nextgen.utils.SwingUtil;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

import static nextgen.swing.ComponentFactory.*;
import static nextgen.utils.SwingUtil.*;

public class STModelEditorForm2 extends BaseEditor<STModel> {

   @Override
   public void setModel(STModel model) {
      super.setModel(model);
      appModel().doLaterInTransaction(tx -> {

         final JPanel content = newPagePanel();

         addSTValues(getModel(), content);
         content.add(Box.createVerticalGlue());

         removeAll();

         final JScrollPane formScrollPane = newJScrollPane(content);
         formScrollPane.getVerticalScrollBar().setUnitIncrement(100);
         formScrollPane.getHorizontalScrollBar().setUnitIncrement(100);
         add(formScrollPane, BorderLayout.CENTER);

         revalidate();
         repaint();
      });
   }

   private void addSTValues(STModel model, JPanel panel) {

      final AtomicInteger index = new AtomicInteger(0);

      appModel().getSTParameters(model).forEach(parameterArguments -> {
         switch (parameterArguments.parameter().getType()) {
            case SINGLE:
               if (!parameterArguments.arguments().isEmpty())
                  panel.add(getKeyValueForm(parameterArguments).setCompvalue(newSTValueComponent(model, parameterArguments.parameter(), parameterArguments.arguments().iterator().next())));
               break;
            case LIST: {
               index.set(0);
               final JPanel listPanel = newPagePanel();
               parameterArguments.arguments().stream()
                     .filter(stArgument -> stArgument.getValue() != null)
                     .forEachOrdered(argument -> listPanel.add(getKeyValueForm()
                           .setLblkey(newLabel(Integer.toString(index.incrementAndGet())))
                           .setCompvalue(newSTValueComponent(model, parameterArguments.parameter(), argument))));

               if (listPanel.getComponents().length != 0)
                  panel.add(getKeyValueForm(parameterArguments)
                        .setCompvalue(listPanel));
            }
            break;
            case KVLIST:
               index.set(0);

               final JPanel listPanel = newPagePanel();

               parameterArguments.arguments().forEach(stArgument -> {

                  index.incrementAndGet();

                  final JPanel kvPanel = newPagePanel();

                  parameterArguments.parameter().getKeysSorted().forEach(stParameterKey -> stArgument.getKeyValues()
                        .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey))
                        .filter(stArgumentKV -> stArgumentKV.getValue() != null)
                        .findFirst()
                        .ifPresent(stArgumentKV -> kvPanel.add(getKeyValueForm()
                              .setLblkey(ComponentFactory.newJLabel((index.get()) + "." + stParameterKey.getName()))
                              .setCompvalue(newSTValueComponent(model, stParameterKey, stArgument, stArgumentKV)))));

                  if (kvPanel.getComponents().length != 0) listPanel.add(kvPanel);
               });

               if (listPanel.getComponents().length != 0)
                  panel.add(getKeyValueForm(parameterArguments).setCompvalue(listPanel));

               break;
         }
      });
   }

   private JComponent newSTValueComponent(STModel stModel, STParameter stParameter, STArgument argument) {
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

   private JComponent newPrimitiveComponent(STModel model, STParameterKey stParameterKey, STArgument stArgument, STArgumentKV argument) {

      final String render = appModel().render(argument.getValue());

      if (render.contains("\n")) {

         final RSyntaxTextArea rSyntaxTextArea = newRSyntaxTextArea(render);
         rSyntaxTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent keyEvent) {
               if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_S) {
                  appModel().doLaterInTransaction(tx -> appModel().setArgumentKV(model, stArgument, stParameterKey, rSyntaxTextArea.getText().trim()));
               }
            }
         });
         return SwingUtil.newRTextScrollPane(rSyntaxTextArea);

      } else if (stParameterKey.getName().startsWith("is")) {

         final JCheckBox component = newJCheckBox(true);
         component.addActionListener(actionEvent -> appModel().doLaterInTransaction(tx -> appModel().setArgumentKV(model, stArgument, stParameterKey, appModel().newSTValue(component.isSelected()))));
         return component;

      } else {
         final JTextField textField = newTextField(render);
         textField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent keyEvent) {
               if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_S) {
                  appModel().doLaterInTransaction(tx -> appModel().setArgumentKV(model, stArgument, stParameterKey, textField.getText().trim()));
               }
            }
         });

         return textField;
      }
   }

   private JComponent newPrimitiveComponent(STModel model, STParameter stParameter, STArgument argument) {

      final String render = appModel().render(argument.getValue(), "");

      if (render.contains("\n")) {

         final RSyntaxTextArea rSyntaxTextArea = newRSyntaxTextArea(render);
         rSyntaxTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent keyEvent) {
               if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_S) {
                  appModel().doLaterInTransaction(tx -> appModel().setArgument(model, stParameter, rSyntaxTextArea.getText().trim()));
               }
            }
         });
         return SwingUtil.newRTextScrollPane(rSyntaxTextArea);

      } else if (stParameter.getName().startsWith("is")) {

         final JCheckBox component = newJCheckBox(true);
         component.addActionListener(actionEvent -> appModel().doLaterInTransaction(tx -> appModel().setArgument(model, stParameter, component.isSelected())));
         return component;

      } else {
         final JTextField textField = newTextField(render);
         textField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent keyEvent) {
               if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_S) {
                  appModel().doLaterInTransaction(tx -> appModel().setArgument(model, stParameter, textField.getText().trim()));
               }
            }
         });

         return textField;
      }
   }

   private KeyValueForm getKeyValueForm(ParameterArguments parameterArguments) {
      return getKeyValueForm()
            .setLblkey(newJLabel(parameterArguments.parameter().getName()));
   }

   private KeyValueForm getKeyValueForm() {
      return new KeyValueForm();
   }
}