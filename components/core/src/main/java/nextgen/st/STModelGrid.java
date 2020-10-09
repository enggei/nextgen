package nextgen.st;

import nextgen.st.domain.STParameter;
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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class STModelGrid extends JPanel {

    private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelGrid.class);

    private final STTemplate model;

    public STModelGrid(STTemplate stTemplate) {
        super(new BorderLayout());

        this.model = stTemplate;

        final List<STParameter> stParameters = stTemplate.getParameters()
                .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                .filter(stParameter -> stParameter.getType().equals(STParameterType.SINGLE))
                .collect(Collectors.toList());

        final JPanel grid = new JPanel();
        grid.setLayout(new BoxLayout(grid, BoxLayout.X_AXIS));
        grid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // columns
        final Map<String, JPanel> columns = new TreeMap<>();
        final Map<String, STParameter> stParameterMap = new TreeMap<>();
        stParameters.forEach(stParameter -> {
            columns.put(stParameter.getUuid(), getColumnPanel(stParameter.getName()));
            stParameterMap.put(stParameter.getUuid(), stParameter);
        });

        // rows
        appModel().db.findAllSTModelByStTemplate(stTemplate.getUuid()).forEach(stModel -> {
            final Map<String, RSyntaxTextArea> txtMap = new LinkedHashMap<>();
            final Map<String, SingleHandler> singleHandlerMap = new LinkedHashMap<>();
            for (Map.Entry<String, JPanel> columnEntry : columns.entrySet()) {

                final JPanel parameterColumn = columnEntry.getValue();
                parameterColumn.add(Box.createRigidArea(new Dimension(0, 10)));

                final RSyntaxTextArea txtValue = SwingUtil.newRSyntaxTextArea(3, 40);
                txtValue.setHighlightCurrentLine(false);
                parameterColumn.add(decorate(txtValue));

                txtMap.put(columnEntry.getKey(), txtValue);

                final STParameter stParameter = stParameterMap.get(columnEntry.getKey());
                singleHandlerMap.put(stParameter.getUuid(), new SingleHandler(stTemplate, stModel, txtValue, stParameter));
            }

            stModel.getArguments()
                    .filter(stArgument -> stArgument.getValue() != null)
                    .filter(stArgument -> stParameterMap.containsKey(stArgument.getStParameter()))
                    .forEach(stArgument -> {
                        final RSyntaxTextArea txtValue = txtMap.get(stArgument.getStParameter());
                        final STParameter stParameter = stParameterMap.get(stArgument.getStParameter());
                        txtValue.setText(appModel().render(stArgument.getValue()));
                        singleHandlerMap.get(stParameter.getUuid()).stArgument = stArgument;
                    });
        });

        stParameters.forEach(stParameter -> {
            final JPanel value = columns.get(stParameter.getUuid());
            value.add(Box.createVerticalGlue());
            grid.add(value);
        });

        final JScrollPane jScrollPane = new JScrollPane(grid);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(20);
        add(jScrollPane, BorderLayout.CENTER);
    }

    private STAppPresentationModel appModel() {
        return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
    }

    public RTextScrollPane decorate(RSyntaxTextArea txtValue) {
        final RTextScrollPane scrollPane = new RTextScrollPane(txtValue);
        scrollPane.setLineNumbersEnabled(false);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        for (MouseWheelListener mouseWheelListener : scrollPane.getMouseWheelListeners())
            scrollPane.removeMouseWheelListener(mouseWheelListener);
        return scrollPane;
    }

    public JPanel getColumnPanel(String header) {
        final JPanel headerPanel = new JPanel();
        headerPanel.setBackground(UIManager.getColor("Panel.background"));
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

        public SingleHandler(STTemplate stTemplate, STModel stModel, RSyntaxTextArea txtValue, STParameter stParameter) {
            final JPopupMenu pop = txtValue.getPopupMenu();
            pop.addSeparator();
            pop.add(newAction("Save", actionEvent -> save(stModel, txtValue, stParameter)));
            pop.addSeparator();
            pop.add(newAction("Open", actionEvent -> appModel().doLaterInTransaction(transaction -> STAppEvents.postOpenSTModel(stModel))));
            pop.add(newAction("Set From Clipboard", actionEvent -> {
                txtValue.setText(SwingUtil.fromClipboard().trim());
                save(stModel, txtValue, stParameter);
            }));
            pop.add(newAction("Append From Clipboard", actionEvent -> {
                txtValue.append(SwingUtil.fromClipboard().trim());
                save(stModel, txtValue, stParameter);
            }));
            pop.add(newAction("Prepend From Clipboard", actionEvent -> {
                txtValue.setText(SwingUtil.fromClipboard().trim() + txtValue.getText());
                save(stModel, txtValue, stParameter);
            }));
            pop.add(newAction("Set TRUE", actionEvent -> {
                txtValue.setText("TRUE");
                save(stModel, txtValue, stParameter);
            }));
            pop.addSeparator();
            pop.add(newAction("To Clipboard", actionEvent -> SwingUtil.toClipboard(txtValue.getText().trim())));
            pop.addSeparator();
            pop.add(newAction("Remove", actionEvent -> remove(stModel, txtValue)));

            txtValue.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent keyEvent) {
                    if (keyEvent.getModifiers() == KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == KeyEvent.VK_S)
                        save(stModel, txtValue, stParameter);
                }
            });
        }

        private void save(STModel stModel, RSyntaxTextArea txtValue, STParameter stParameter) {
            appModel().doInTransaction(transaction -> {
                final String s = txtValue.getText().trim();
                final STValue stValue = appModel().newSTValue(s);
                if (stArgument == null) {
                    stArgument = appModel().newSTArgument(stParameter, stValue);
                    stModel.addArguments(stArgument);
                } else
                    stArgument.setValue(stValue);
                log.info("saving " + appModel().render(stValue));
                txtValue.setBackground(UIManager.getColor("Panel.background"));
            });
        }

        private void remove(STModel stModel, RSyntaxTextArea txtValue) {
            if (stArgument == null) return;
            appModel().doInTransaction(transaction -> {
                stModel.removeArguments(stArgument);
                txtValue.setText("");
                txtValue.setBackground(UIManager.getColor("Panel.background"));
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