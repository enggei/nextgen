package nextgen.st;

import nextgen.st.domain.STParameter;
import nextgen.st.domain.STParameterKey;
import nextgen.st.domain.STParameterType;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.STArgument;
import nextgen.st.model.STModel;
import nextgen.st.model.STValue;
import nextgen.utils.SwingUtil;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelListener;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

public class STModelGrid extends JPanel {

    private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelGrid.class);

    private final STTemplate model;

    public STModelGrid(STAppPresentationModel presentationModel, STTemplate stTemplate) {
        super(new BorderLayout());

        this.model = stTemplate;

        // columns
        final Map<String, JPanel> columns = new TreeMap<>();
        final Map<String, STParameter> stParameterMap = new TreeMap<>();
        final Map<String, STParameterKey> stParameterKeyMap = new TreeMap<>();
        final Map<String, STParameter> reverseMap = new TreeMap<>();
        stTemplate.getParameters().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                .filter(stParameter -> stParameter.getType().equals(STParameterType.SINGLE))
                .forEach(stParameter -> {
                    columns.put(stParameter.uuid(), getColumnPanel(stParameter.getName()));
                    stParameterMap.put(stParameter.uuid(), stParameter);
                    stParameter.getKeys()
                            .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                            .forEach(stParameterKey -> {
                                columns.put(stParameterKey.uuid(), getColumnPanel(stParameter.getName() + "." + stParameterKey.getName()));
                                stParameterKeyMap.put(stParameterKey.uuid(), stParameterKey);
                                reverseMap.put(stParameterKey.uuid(), stParameter);
                            });
                });

        // rows
        presentationModel.db.findAllSTModelByStTemplate(stTemplate.uuid()).forEach(stModel -> {
            final Map<String, RSyntaxTextArea> txtMap = new LinkedHashMap<>();
            final Map<String, SingleHandler> singleHandlerMap = new LinkedHashMap<>();
            for (Map.Entry<String, JPanel> columnEntry : columns.entrySet()) {
                final JPanel parameterColumn = columnEntry.getValue();
                parameterColumn.add(Box.createRigidArea(new Dimension(0, 10)));
                final RSyntaxTextArea txtValue = SwingUtil.newRSyntaxTextArea(3, 40);
                txtValue.setHighlightCurrentLine(false);
                final RTextScrollPane scrollPane = new RTextScrollPane(txtValue);
                scrollPane.setLineNumbersEnabled(false);
                scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                for (MouseWheelListener mouseWheelListener : scrollPane.getMouseWheelListeners())
                    scrollPane.removeMouseWheelListener(mouseWheelListener);
                parameterColumn.add(scrollPane);
                txtMap.put(columnEntry.getKey(), txtValue);

                final STParameter stParameter = stParameterMap.containsKey(columnEntry.getKey()) ? stParameterMap.get(columnEntry.getKey()) : reverseMap.get(columnEntry.getKey());
                switch (stParameter.getType()) {
                    case SINGLE:
                        singleHandlerMap.put(stParameter.uuid(), new SingleHandler(stModel, txtValue, stParameter, presentationModel));
                        break;
                    case LIST:
                        txtValue.setEditable(false);
                        break;
                    case KVLIST:
                        txtValue.setEditable(false);
                        break;
                }
            }

            stModel.getArguments()
                    .filter(stArgument -> stArgument.getValue() != null)
                    .filter(stArgument -> stParameterMap.containsKey(stArgument.getStParameter()))
                    .forEach(stArgument -> {
                        final RSyntaxTextArea txtValue = txtMap.get(stArgument.getStParameter());

                        final STParameter stParameter = stParameterMap.get(stArgument.getStParameter());
                        switch (stParameter.getType()) {
                            case SINGLE:
                                txtValue.setText(presentationModel.render(stArgument.getValue()));
                                singleHandlerMap.get(stParameter.uuid()).stArgument = stArgument;
                                break;
                            case LIST:
                                txtValue.append(presentationModel.render(stArgument.getValue()));
                                txtValue.setEditable(false);
                                break;
                            case KVLIST:
                                stArgument.getKeyValues().forEach(stArgumentKV -> {
                                    final STParameterKey stParameterKey = stParameterKeyMap.get(stArgumentKV.getStParameterKey());
                                    txtValue.append(stParameterKey.getName() + ":\n");
                                    txtValue.append(presentationModel.render(stArgumentKV.getValue()));
                                });
                                txtValue.setEditable(false);
                                break;
                        }
                    });
        });

        final JPanel grid = new JPanel();
        grid.setLayout(new BoxLayout(grid, BoxLayout.X_AXIS));
        grid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        stTemplate.getParameters().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                .filter(stParameter -> stParameter.getType().equals(STParameterType.SINGLE))
                .forEach(stParameter -> {
                    JPanel value = columns.get(stParameter.uuid());
                    value.add(Box.createVerticalGlue());
                    grid.add(value);
                });

        final JScrollPane jScrollPane = new JScrollPane(grid);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(20);
        add(jScrollPane, BorderLayout.CENTER);
    }

    public JPanel getColumnPanel(String header) {
        final JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        headerPanel.add(new JLabel(header, SwingConstants.LEFT));
        return headerPanel;
    }

    public STTemplate getModel() {
        return model;
    }

    private class SingleHandler {

        STArgument stArgument;

        public SingleHandler(STModel stModel, RSyntaxTextArea txtValue, STParameter stParameter, STAppPresentationModel presentationModel) {
            final JPopupMenu pop = txtValue.getPopupMenu();
            pop.addSeparator();
            pop.add(newAction("Save", actionEvent -> save(stModel, presentationModel, txtValue, stParameter)));
            pop.addSeparator();
            pop.add(newAction("From Clipboard", actionEvent -> {
                txtValue.setText(SwingUtil.fromClipboard().trim());
                save(stModel, presentationModel, txtValue, stParameter);
            }));
            pop.add(newAction("Set TRUE", actionEvent -> {
                txtValue.setText("TRUE");
                save(stModel, presentationModel, txtValue, stParameter);
            }));
            pop.addSeparator();
            pop.add(newAction("To Clipboard", actionEvent -> {
                SwingUtil.toClipboard(txtValue.getText().trim());
            }));
            pop.addSeparator();
            pop.add(newAction("Remove", actionEvent -> {
                remove(stModel, presentationModel, txtValue);
            }));
            txtValue.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent keyEvent) {
                    if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_S)
                        save(stModel, presentationModel, txtValue, stParameter);
                }
            });
        }

        private void save(STModel stModel, STAppPresentationModel presentationModel, RSyntaxTextArea txtValue, STParameter stParameter) {
            presentationModel.db.doInTransaction(transaction -> {
                final String s = txtValue.getText().trim();
                final STValue stValue = presentationModel.newSTValue(s);
                if (stArgument == null) {
                    stArgument = presentationModel.newSTArgument(stParameter, stValue);
                    stModel.addArguments(stArgument);
                } else
                    stArgument.setValue(stValue);
                log.info("saving " + presentationModel.render(stValue));
                txtValue.setBackground(Color.WHITE);
            });
        }

        private void remove(STModel stModel, STAppPresentationModel presentationModel, RSyntaxTextArea txtValue) {
            if (stArgument == null) return;
            presentationModel.db.doInTransaction(transaction -> {
                stModel.removeArguments(stArgument);
                txtValue.setText("");
                txtValue.setBackground(Color.WHITE);
            });
        }
    }

    private Action newAction(String name, Consumer<ActionEvent> consumer) {
        return new AbstractAction(name) {
            @Override
            public void actionPerformed(ActionEvent e) {
                consumer.accept(e);
            }
        };
    }
}