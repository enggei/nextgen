package nextgen.swing.forms;

import javax.swing.JLabel;

import static nextgen.templates.jgoodies.JavaJGoodiesPatterns.*;

public class Forms extends javax.swing.JPanel {

   public static void main(String[] args) {
      com.formdev.flatlaf.FlatDarculaLaf.install();

      final java.awt.Font font = new java.awt.Font("InputMono", java.awt.Font.PLAIN, 24);
      javax.swing.UIManager.put("TextField.font", font);
      javax.swing.UIManager.put("TextArea.font", font);
      nextgen.utils.SwingUtil.showPanel(new Forms());
   }

   public Forms() {
      super();
      setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

      final InputPanel inputPanel = new InputPanel();
      final OutputPanel outputPanel = new OutputPanel();
      final javax.swing.JButton run = new javax.swing.JButton(new javax.swing.AbstractAction("Run") {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
            rebuildForm(inputPanel, outputPanel);
         }
      });

      add(inputPanel);
      add(run);
      add(outputPanel);
   }

   private void rebuildForm(nextgen.swing.forms.Forms.InputPanel inputPanel, nextgen.swing.forms.Forms.OutputPanel outputPanel) {

      outputPanel.removeAll();
      revalidate();
      repaint();

      com.jgoodies.forms.debug.FormDebugPanel panel = new com.jgoodies.forms.debug.FormDebugPanel();
      panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
      panel.setPreferredSize(new java.awt.Dimension(800, 600));
      panel.setBackground(javax.swing.UIManager.getColor("Panel.background"));

      com.jgoodies.forms.layout.FormLayout formLayout = new com.jgoodies.forms.layout.FormLayout(inputPanel.encodedColumnSpecs(), inputPanel.encodedRowSpecs());
      panel.setLayout(formLayout);
      inputPanel.components().forEach(formComponent -> panel.add(formComponent.component(), formComponent.constraints()));

      outputPanel.add(panel, java.awt.BorderLayout.CENTER);

      revalidate();
      repaint();
   }

   interface FormComponent {
      java.awt.Component component();

      com.jgoodies.forms.layout.CellConstraints constraints();
   }

   private class InputPanel extends javax.swing.JPanel {

      javax.swing.JTextField txtColumnSpecs = new javax.swing.JTextField(150);
      javax.swing.JTextField txtRowSpecs = new javax.swing.JTextField(150);
      javax.swing.JTable results;
      ResultsTableModel resultsModel = new nextgen.swing.forms.Forms.InputPanel.ResultsTableModel();

      public InputPanel() {
         super(new java.awt.BorderLayout());

         testValues();

         javax.swing.JPanel columnPanel = new javax.swing.JPanel();
         columnPanel.setLayout(new javax.swing.BoxLayout(columnPanel, javax.swing.BoxLayout.LINE_AXIS));
         columnPanel.add(new javax.swing.JLabel("Columns"));
         columnPanel.add(txtColumnSpecs);

         javax.swing.JPanel rowPanel = new javax.swing.JPanel();
         rowPanel.setLayout(new javax.swing.BoxLayout(rowPanel, javax.swing.BoxLayout.LINE_AXIS));
         rowPanel.add(new javax.swing.JLabel("Rows"));
         rowPanel.add(txtRowSpecs);

         javax.swing.JPanel center = new javax.swing.JPanel();
         center.setLayout(new java.awt.GridLayout(2, 1));
         center.add(columnPanel);
         center.add(rowPanel);

         add(center, java.awt.BorderLayout.NORTH);

         results = new javax.swing.JTable(resultsModel);
         results.setIntercellSpacing(new java.awt.Dimension(0, 5));
         results.setShowGrid(false);
         results.setRowMargin(0);
         results.setRowHeight(150);
         results.getColumn("Component").setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
               return (java.awt.Component) value;
            }
         });
         results.getColumn("Constraints").setCellRenderer(new ConstraintsCellRenderer());

         final javax.swing.JScrollPane jScrollPane = new javax.swing.JScrollPane(results);
         jScrollPane.setBackground(javax.swing.UIManager.getColor("Panel.background"));
         jScrollPane.getVerticalScrollBar().setUnitIncrement(5);
         add(jScrollPane, java.awt.BorderLayout.CENTER);
      }

      public String encodedColumnSpecs() {
         return txtColumnSpecs.getText();
      }

      public String encodedRowSpecs() {
         return txtRowSpecs.getText();
      }

      public java.util.stream.Stream<nextgen.swing.forms.Forms.FormComponent> components() {
         return resultsModel.content.stream();
      }

      protected class ResultsTableModel extends javax.swing.table.AbstractTableModel {

         private final java.util.List<FormComponent> content = new java.util.ArrayList<>();

         @Override
         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return !content.isEmpty();
         }

         @Override
         public String getColumnName(int column) {
            return column == 0 ? "Component" : "Constraints";
         }

         @Override
         public Class<?> getColumnClass(int column) {
            return column == 0 ? java.awt.Component.class : com.jgoodies.forms.layout.CellConstraints.class;
         }

         @Override
         public int findColumn(String column) {
            return "Component".equals(column) ? 0 : 1;
         }

         @Override
         public int getRowCount() {
            return content.size();
         }

         @Override
         public int getColumnCount() {
            return 2;
         }

         @Override
         public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
               case 0:
                  return content.get(rowIndex).component();
               default:
                  return content.get(rowIndex).constraints();
            }
         }

         @Override
         public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (content.isEmpty()) return;
            fireTableCellUpdated(rowIndex, columnIndex);
         }

         protected void clear() {
            content.clear();
            fireTableDataChanged();
         }
      }

      private void testValues() {
         txtColumnSpecs.setText(newColumnSpecs()
               .addColumnSpec(newColumnSpec(nextgen.templates.jgoodies.columnAlignment.FILL, "50px", null))
               .addColumnSpec(newColumnSpec(nextgen.templates.jgoodies.columnAlignment.FILL, "50px", null))
               .addColumnSpec(newColumnSpec(nextgen.templates.jgoodies.columnAlignment.FILL, "50px", ".25"))
               .toString());

         txtRowSpecs.setText(newRowSpecs()
               .addRowSpec(newRowSpec(nextgen.templates.jgoodies.rowAlignment.FILL, "pref", null))
               .toString());

         resultsModel.content.add(newFormComponent("Comp1", 1, 1, null));
         resultsModel.content.add(newFormComponent("Comp2", 2, 1, null));
         resultsModel.content.add(newFormComponent("Comp3", 3, 1, null));
      }

      private nextgen.swing.forms.Forms.FormComponent newFormComponent(String name, int col, int row, String encodedAlignments) {
         javax.swing.JLabel label = new javax.swing.JLabel(name);
         return new nextgen.swing.forms.Forms.FormComponent() {

            private com.jgoodies.forms.layout.CellConstraints constraints = new com.jgoodies.forms.layout.CellConstraints();

            @Override
            public java.awt.Component component() {
               return label;
            }

            @Override
            public com.jgoodies.forms.layout.CellConstraints constraints() {
               return encodedAlignments == null ? constraints.xy(col, row) : constraints.xy(col, row, encodedAlignments);
            }
         };
      }

      private class ConstraintsCellRenderer extends javax.swing.table.DefaultTableCellRenderer {

         final javax.swing.JPanel panel = new javax.swing.JPanel();
         javax.swing.JTextField x = new javax.swing.JTextField(2);
         javax.swing.JTextField y = new javax.swing.JTextField(2);
         javax.swing.JTextField w = new javax.swing.JTextField(2);
         javax.swing.JTextField h = new javax.swing.JTextField(2);

         public ConstraintsCellRenderer() {
            panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.LINE_AXIS));
            panel.add(x);
            panel.add(y);
            panel.add(w);
            panel.add(h);
         }

         @Override
         public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            com.jgoodies.forms.layout.CellConstraints constraints = (com.jgoodies.forms.layout.CellConstraints) value;
            x.setText(Integer.toString(constraints.gridX));
            y.setText(Integer.toString(constraints.gridY));
            w.setText(Integer.toString(constraints.gridWidth));
            h.setText(Integer.toString(constraints.gridHeight));
            return panel;
         }
      }
   }

   private class OutputPanel extends javax.swing.JPanel {

      public OutputPanel() {
         super(new java.awt.BorderLayout(5, 5));
         setBackground(javax.swing.UIManager.getColor("Panel.background"));
         setPreferredSize(new java.awt.Dimension(800, 600));
      }
   }
}
