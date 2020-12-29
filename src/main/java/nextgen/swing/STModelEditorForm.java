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
import static nextgen.utils.SwingUtil.*;

public class STModelEditorForm extends BaseEditor<STModel> {

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

         final JPanel content = getContentPanel();

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
         switch (parameterArguments.parameter().getType()) {
            case SINGLE:
               if (parameterArguments.arguments().isEmpty())
                  panel.add(getKeyValueForm().setCompkey(getLabel(parameterArguments.parameter().getName())).setCompvalue(new ButtonFormLeft().setBtnone(getButton(new SetArgumentFromArgumentType(model, parameterArguments.parameter(), panel).setName("SET")))));
               else {
                  panel.add(getKeyValueForm().setCompkey(getLabel(parameterArguments.parameter().getName())).setCompvalue(newSTValueComponent(model, parameterArguments.parameter(), parameterArguments.arguments().get(0))));
               }

               break;
            case LIST: {
               index.set(0);
               final JPanel listPanel = getContentPanel();
               parameterArguments.arguments().stream()
                     .filter(stArgument -> stArgument.getValue() != null)
                     .forEachOrdered(argument -> {
                        final int i = index.incrementAndGet();

                        if (listPanel.getComponents().length == 0)
                           listPanel.add(getKeyValueForm().setCompkey(new ButtonFormLeft().setBtnone(getButton(new AddArgumentFromArgumentType(model, parameterArguments.parameter(), listPanel)))));

                        listPanel.add(getKeyValueForm()
                              .setCompkey(new ButtonFormRight().setCompone(getButton(i, parameterArguments.arguments().size()).action(selectButton -> {
                                 int selectedIndex = Integer.parseInt(selectButton.getValue().toString()) -1;
                                 appModel().reorder(model, argument, parameterArguments.arguments().get(selectedIndex));
                              })))
                              .setCompvalue(newSTValueComponent(model, parameterArguments.parameter(), argument)));
                     });

               if (listPanel.getComponents().length != 0)
                  panel.add(getKeyValueForm(parameterArguments).setCompvalue(listPanel));
               else
                  panel.add(getKeyValueForm(parameterArguments).setCompvalue(new ButtonFormLeft().setBtnthree(getButton(new AddArgumentFromArgumentType(model, parameterArguments.parameter(), panel)))));
            }
            break;
            case KVLIST:
               index.set(0);

               final JPanel listPanel = getContentPanel();

               parameterArguments.arguments().forEach(stArgument -> {

                  index.incrementAndGet();

                  final JPanel kvPanel = getContentPanel();

                  parameterArguments.parameter().getKeysSorted().forEach(stParameterKey -> {

                     final Optional<STArgumentKV> found = stArgument.getKeyValues()
                           .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey))
                           .filter(stArgumentKV -> stArgumentKV.getValue() != null)
                           .findFirst();

                     if (found.isPresent()) {
                        kvPanel.add(getKeyValueForm()
                              .setCompkey(getLabel((index.get()) + "." + stParameterKey.getName()))
                              .setCompvalue(newSTValueComponent(model, stParameterKey, stArgument, found.get())));
                     } else {
                        kvPanel.add(getKeyValueForm(index.get(), stParameterKey).setCompvalue(new ButtonFormLeft().setBtnthree(getButton(new SetKVArgumentFromArgumentType(model, stArgument, stParameterKey, kvPanel).setName("SET")))));
                     }
                  });

                  if (kvPanel.getComponents().length != 0) {
                     if (listPanel.getComponents().length == 0) listPanel.add(getKeyValueForm().setCompvalue(new ButtonFormLeft().setBtnthree(getButton(new AddKVArguments(parameterArguments.parameter(), model, listPanel)))));
                     kvPanel.add(getKeyValueForm()
                           .setCompkey(new ButtonFormRight().setBtnthree(getButton(new DeleteSTArgument(stArgument, listPanel)))));
                     listPanel.add(kvPanel);
                  }
               });

               if (listPanel.getComponents().length != 0)
                  panel.add(getKeyValueForm(parameterArguments).setCompvalue(listPanel));
               else
                  panel.add(getKeyValueForm(parameterArguments).setCompvalue(new ButtonFormLeft().setBtnthree(getButton(new AddKVArguments(parameterArguments.parameter(), model, panel)))));
               break;
         }
      });
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
            final JPanel content = getContentPanel();
            addSTValues(argument.getValue().getStModel(), content);
            return content;
         case PRIMITIVE:
            return newPrimitiveComponent(stModel, stParameter, argument);
         case ENUM:
            return new SelectButton(argument.getValue().getStEnumValue().getIncomingValuesSTEnum().findFirst().get().getValuesSorted().toArray(), argument.getValue().getStEnumValue());
      }

      return null;
   }

   private JPanel getContentPanel() {
      return newPagePanel();
   }

   private JComponent newSTValueComponent(STModel model, STParameterKey stParameterKey, STArgument stArgument, STArgumentKV argument) {
      if (argument.getValue() == null) return null;
      switch (argument.getValue().getType()) {
         case STMODEL:
            final JPanel content = getContentPanel();
            addSTValues(argument.getValue().getStModel(), content);
            return content;
         case PRIMITIVE:
            return newPrimitiveComponent(model, stParameterKey, stArgument, argument);
         case ENUM:
            return new SelectButton(argument.getValue().getStEnumValue().getIncomingValuesSTEnum().findFirst().get().getValuesSorted().toArray(), argument.getValue().getStEnumValue());
      }

      return null;
   }

   private JComponent newPrimitiveComponent(STModel model, STParameter stParameter, STArgument stArgument) {

      final String render = appModel().render(stArgument.getValue(), "");

      if (render.contains("\n")) {

         final RSyntaxTextArea rSyntaxTextArea = newRSyntaxTextArea(render);
         rSyntaxTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent keyEvent) {
               if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_S) {
                  appModel().doLaterInTransaction(tx -> stArgument.setValue(appModel().newSTValue(rSyntaxTextArea.getText().trim())));
               }
            }
         });
         return new TextAreaCrudPanel()
               .setScrtextArea(newRTextScrollPane(rSyntaxTextArea))
               .setBtndelete(getButton(new DeleteSTArgument(stArgument, rSyntaxTextArea)))
               .setBtnfromClipboard(getButton(new SetArgumentFromClipboard(model, stParameter)))
               .setBtntoClipboard(getButton(new STValueToClipboard(stArgument.getValue())));

      } else if (stParameter.getName().startsWith("is") || stParameter.getName().startsWith("has")) {

         final JCheckBox component = newJCheckBox("true".equals(render));
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

         return new CrudPanel()
               .setTxtvalue(textField)
               .setBtndelete(getButton(new DeleteSTArgument(stArgument, STModelEditorForm.this)))
               .setBtnfromClipboard(getButton(new SetArgumentFromClipboard(model, stParameter)))
               .setBtntoClipboard(getButton(new STValueToClipboard(stArgument.getValue())));
      }
   }

   private JComponent newPrimitiveComponent(STModel model, STParameterKey stParameterKey, STArgument stArgument, STArgumentKV argument) {

      final String render = appModel().render(argument.getValue());

      if (render.contains("\n")) {

         final RSyntaxTextArea rSyntaxTextArea = newRSyntaxTextArea(render);
         rSyntaxTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent keyEvent) {
               if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_S) {
                  appModel().doLaterInTransaction(tx -> argument.setValue(appModel().newSTValue(rSyntaxTextArea.getText().trim())));
               }
            }
         });

         return new TextAreaCrudPanel()
               .setScrtextArea(newRTextScrollPane(rSyntaxTextArea))
               .setBtndelete(getButton(new DeleteKV(argument, STModelEditorForm.this)))
               .setBtnfromClipboard(getButton(new SetKVArgumentFromClipboard(model, stArgument, stParameterKey)))
               .setBtntoClipboard(getButton(new STValueToClipboard(stArgument.getValue())));

      } else if (stParameterKey.getName().startsWith("is") || stParameterKey.getName().startsWith("has")) {

         final JCheckBox component = newJCheckBox("true".equals(render));
         component.setHorizontalAlignment(SwingConstants.RIGHT);
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

         return new CrudPanel()
               .setTxtvalue(textField)
               .setBtndelete(getButton(new DeleteKV(argument, STModelEditorForm.this)))
               .setBtnfromClipboard(getButton(new SetKVArgumentFromClipboard(model, stArgument, stParameterKey)))
               .setBtntoClipboard(getButton(new STValueToClipboard(stArgument.getValue())));
      }
   }

   private KeyValueForm getKeyValueForm(ParameterArguments parameterArguments) {
      return getKeyValueForm()
            .setCompkey(getLabel(parameterArguments.parameter().getName()));
   }

   private KeyValueForm getKeyValueForm(int index, STParameterKey stParameterKey) {
      return getKeyValueForm()
            .setCompkey(getLabel(index + "." + stParameterKey.getName()));
   }

   private KeyValueForm getKeyValueForm() {
      return new KeyValueForm();
   }
}