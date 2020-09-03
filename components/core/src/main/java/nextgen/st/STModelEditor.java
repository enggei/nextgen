package nextgen.st;

import nextgen.st.domain.STTemplate;
import nextgen.st.model.STModel;
import nextgen.utils.SwingUtil;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;

import static nextgen.st.STAppPresentationModel.newAction;
import static nextgen.utils.SwingUtil.newRSyntaxTextArea;

public class STModelEditor extends JPanel {

   private final STAppPresentationModel presentationModel;

   private final RSyntaxTextArea txtEditor = newRSyntaxTextArea(20, 80);
   private final STModel stModel;

   private STModelEditorNavigator.STValueTreeNode currentTreeNode;

   public STModelEditor(STAppPresentationModel presentationModel, STModel stModel) {
      super(new BorderLayout());

      this.stModel = stModel;
      this.presentationModel = presentationModel;
      setBackground(UIManager.getColor("Panel.background"));

      txtEditor.setEditable(false);
      txtEditor.addKeyListener(getEditorKeyListener());
      addActionsToPopup();

      final STModelEditorNavigator stModelNavigator = new STModelEditorNavigator(presentationModel, stModel, this);

      add(new RTextScrollPane(txtEditor), BorderLayout.CENTER);
      add(stModelNavigator, BorderLayout.EAST);

      setText(presentationModel.render(stModel), null);
   }

   public void addActionsToPopup() {
      final JPopupMenu pop = txtEditor.getPopupMenu();

      final JMenu parametersMenu = new JMenu("Parameters");
      pop.add(parametersMenu);

      final STTemplate stTemplate = presentationModel.findSTTemplateByUuid(stModel.getStTemplate());

      stTemplate.getParameters()
                .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                .forEach(stParameter -> {

                   final JMenu stParameterMenu = new JMenu(stParameter.getName());
                   parametersMenu.add(stParameterMenu);

                   switch (stParameter.getType()) {
                      case SINGLE: {
                         final JMenu setParameterMenu = new JMenu("Set");
                         stParameterMenu.add(setParameterMenu);
                         setParameterMenu.add(newAction("From Input", actionEvent -> SwingUtil
                               .showInputDialog(stParameter.getName(), txtEditor, s -> {
                                  presentationModel.doLaterInTransaction(tx -> {
                                     presentationModel.removeArgument(getModel(), stParameter);
                                     getModel().addArguments(presentationModel
                                           .newSTArgument(stParameter, presentationModel.newSTValue(s)));
                                     setText(presentationModel.render(stModel), null);
                                  });
                               })));
                         setParameterMenu
                               .add(newAction("Set TRUE", actionEvent -> presentationModel.doLaterInTransaction(tx -> {
                                  presentationModel.removeArgument(getModel(), stParameter);
                                  getModel().addArguments(presentationModel.db
                                        .newSTArgument(stParameter, presentationModel.db.newSTValue("true")));
                               })));
                         setParameterMenu.add(newAction("From Clipboard", actionEvent -> {
                            final String s = SwingUtil.fromClipboard();
                            if (s == null || s.trim().length() == 0) return;
                            presentationModel.doLaterInTransaction(tx -> {
                               presentationModel.removeArgument(getModel(), stParameter);
                               getModel().addArguments(presentationModel
                                     .newSTArgument(stParameter, presentationModel.newSTValue(s.trim())));
                               setText(presentationModel.render(stModel), null);
                            });
                         }));

                         final JMenu removestParameterMenu = new JMenu("Remove");
                         stParameterMenu.add(removestParameterMenu);

                         getModel().getArguments()
                                   .filter(stArgument -> stArgument.getStParameter()
                                                                   .equals(stParameter.getUuid()))
                                   .forEach(stArgument -> {
                                      removestParameterMenu.add(newAction(presentationModel.cut(presentationModel.render(stArgument), 30), actionEvent -> SwingUtil.confirm(txtEditor, "Remove argument ?")
                                                                                .ifPresent(confirm -> presentationModel
                                                                                      .doLaterInTransaction(tx -> getModel()
                                                                                            .removeArguments(stArgument)))));
                                      setText(presentationModel.render(stModel), null);
                                   });
                         break;
                      }
                      case LIST: {
                         final JMenu addParameterMenu = new JMenu("Add");
                         stParameterMenu.add(addParameterMenu);
                         addParameterMenu.add(newAction("From Input", new Consumer<ActionEvent>() {
                            @Override
                            public void accept(ActionEvent actionEvent) {
                               nextgen.utils.SwingUtil.showInputDialog(stParameter.getName(), txtEditor, s -> {
                                  presentationModel.doLaterInTransaction(tx -> {
                                     getModel().addArguments(presentationModel
                                           .newSTArgument(stParameter, presentationModel.newSTValue(s)));
                                     setText(presentationModel.render(stModel), null);
                                  });
                               });
                            }
                         }));
                         addParameterMenu
                               .add(newAction("Set TRUE", actionEvent -> presentationModel.doLaterInTransaction(tx -> {
                                  getModel().addArguments(presentationModel.db
                                        .newSTArgument(stParameter, presentationModel.db.newSTValue("true")));
                               })));
                         addParameterMenu.add(newAction("From Clipboard", actionEvent -> {
                            final String s = SwingUtil.fromClipboard();
                            if (s == null || s.trim().length() == 0) return;
                            presentationModel.doLaterInTransaction(tx -> {
                               getModel().addArguments(presentationModel
                                     .newSTArgument(stParameter, presentationModel.newSTValue(s.trim())));
                               setText(presentationModel.render(stModel), null);
                            });
                         }));

                         final JMenu removestParameterMenu = new JMenu("Remove");
                         stParameterMenu.add(removestParameterMenu);

                         getModel().getArguments()
                                   .filter(stArgument -> stArgument.getStParameter()
                                                                   .equals(stParameter.getUuid()))
                                   .forEach(stArgument -> {
                                      removestParameterMenu.add(newAction(presentationModel.cut(presentationModel.render(stArgument), 30), actionEvent -> SwingUtil.confirm(txtEditor, "Remove argument ?")
                                                                                .ifPresent(confirm -> {
                                                                                   presentationModel
                                                                                         .doLaterInTransaction(tx -> getModel()
                                                                                               .removeArguments(stArgument));
                                                                                   setText(presentationModel
                                                                                         .render(stModel), null);
                                                                                })));
                                   });
                         break;
                      }
                      case KVLIST: {
                         final JMenu addKVParameterMenu = new JMenu("Add");
                         stParameterMenu.add(addKVParameterMenu);
                         addKVParameterMenu.add(newAction("From input", actionEvent -> presentationModel
                               .doLaterInTransaction(tx -> presentationModel
                                     .addKVArgument(getModel(), stParameter, txtEditor, stArgument -> {
                                        setText(presentationModel.render(stModel), null);
                                     }))));

                         final JMenu removestParameterMenu = new JMenu("Remove");
                         stParameterMenu.add(removestParameterMenu);

                         getModel().getArguments()
                                   .filter(stArgument -> stArgument.getStParameter()
                                                                   .equals(stParameter.getUuid()))
                                   .forEach(stArgument -> {
                                      removestParameterMenu.add(newAction(presentationModel
                                            .cut(presentationModel.render(stArgument), 30), actionEvent -> {
                                         nextgen.utils.SwingUtil.confirm(txtEditor, "Remove argument ?")
                                                                .ifPresent(confirm -> presentationModel
                                                                      .doLaterInTransaction(tx -> {
                                                                         getModel().removeArguments(stArgument);
                                                                         setText(presentationModel
                                                                               .render(stModel), null);
                                                                      }));
                                      }));
                                   });
                         break;
                      }
                   }
                });

      pop.add(newAction("Set Multiple", actionEvent -> {
         presentationModel.doLaterInTransaction(transaction -> presentationModel
               .setMultiple(txtEditor, getModel(), stTemplate, stModel -> {
                  setText(presentationModel.render(stModel), null);
               }));
      }));

      pop.addSeparator();
      pop.add(newAction("Save", actionEvent -> tryToSave()));
      pop.add(newAction("Append From Clipboard", actionEvent -> {
         if (!txtEditor.isEditable()) return;
         txtEditor.append(SwingUtil.fromClipboard().trim());
         txtEditor.setCaretPosition(0);
         tryToSave();
      }));
      pop.add(newAction("Prepend From Clipboard", actionEvent -> {
         if (!txtEditor.isEditable()) return;
         txtEditor.setText(SwingUtil.fromClipboard().trim() + txtEditor.getText());
         txtEditor.setCaretPosition(0);
         tryToSave();
      }));
      pop.addSeparator();
      pop.add(newAction("To Clipboard", actionEvent -> SwingUtil.toClipboard(txtEditor.getText().trim())));
   }

   private KeyListener getEditorKeyListener() {
      return new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_S) {
               tryToSave();
            }
         }
      };
   }

   void tryToSave() {
      if (currentTreeNode == null) return;
      presentationModel.doLaterInTransaction(transaction -> {
         currentTreeNode.getModel().setValue(txtEditor.getText().trim());
         currentTreeNode.nodeChanged();
      });
   }

   void setText(String text, STModelEditorNavigator.STValueTreeNode selectedTreeNode) {
      txtEditor.setText(text);
      txtEditor.setCaretPosition(0);
      txtEditor.setEditable(selectedTreeNode != null);
      this.currentTreeNode = selectedTreeNode;
   }

   public STModel getModel() {
      return stModel;
   }
}