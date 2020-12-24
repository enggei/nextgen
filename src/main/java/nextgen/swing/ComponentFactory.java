package nextgen.swing;

public class ComponentFactory {

   // UIs
   private static final javax.swing.plaf.ButtonUI button = new javax.swing.JButton().getUI();
   private static final javax.swing.plaf.ButtonUI toggleButton = new javax.swing.JToggleButton().getUI();
   private static final javax.swing.plaf.PanelUI panel = new javax.swing.JPanel().getUI();

   // components
   public static javax.swing.JLabel newJLabel() {
      return decorate(new javax.swing.JLabel());
   }

   public static javax.swing.JTextField newJTextField() {
      return decorate(new javax.swing.JTextField());
   }

   public static javax.swing.JButton newJButton() {
      return decorate(new javax.swing.JButton());
   }

   public static javax.swing.JTextArea newJTextArea() {
      return decorate(new javax.swing.JTextArea());
   }

   public static javax.swing.JTable newJTable() {
      return decorate(new javax.swing.JTable());
   }

   public static javax.swing.JList<?> newJList() {
      return decorate(new javax.swing.JList<>());
   }

   public static javax.swing.JToggleButton newJToggleButton() {
      return decorate(new javax.swing.JToggleButton());
   }

   public static javax.swing.JTabbedPane newJTabbedPane() {
      return decorate(new javax.swing.JTabbedPane());
   }

   public static javax.swing.JCheckBox newJCheckBox() {
      return decorate(new javax.swing.JCheckBox());
   }

   public static javax.swing.JRadioButton newJRadioButton() {
      return decorate(new javax.swing.JRadioButton());
   }

   public static javax.swing.JPanel newJPanel() {
      return decorate(new javax.swing.JPanel());
   }

   public static javax.swing.JScrollPane newJScrollPane(java.awt.Component jComponent) {
      return decorate(new javax.swing.JScrollPane(jComponent));
   }

   public static javax.swing.JScrollPane newJScrollPane() {
      return decorate(new javax.swing.JScrollPane());
   }

   // decorators

   public static javax.swing.JLabel decorate(javax.swing.JLabel component) {
      return component;
   }

   public static javax.swing.JTextField decorate(javax.swing.JTextField component) {
      return component;
   }

   public static javax.swing.JButton decorate(javax.swing.JButton component) {
      return component;
   }

   public static javax.swing.JTextArea decorate(javax.swing.JTextArea component) {
      return component;
   }

   public static javax.swing.JTable decorate(javax.swing.JTable component) {
      return component;
   }

   public static javax.swing.JList<?> decorate(javax.swing.JList<?> component) {
      return component;
   }

   public static javax.swing.JToggleButton decorate(javax.swing.JToggleButton component) {
      component.setUI(toggleButton);
      return component;
   }

   public static javax.swing.JTabbedPane decorate(javax.swing.JTabbedPane component) {
      return component;
   }

   public static javax.swing.JCheckBox decorate(javax.swing.JCheckBox component) {
      return component;
   }

   public static javax.swing.JRadioButton decorate(javax.swing.JRadioButton component) {
      return component;
   }

   public static javax.swing.JPanel decorate(javax.swing.JPanel component) {
      return component;
   }

   public static javax.swing.JScrollPane decorate(javax.swing.JScrollPane component) {
      return component;
   }

   // convenience methods

   public static javax.swing.JLabel newJLabel(String text) {
      final javax.swing.JLabel component = newJLabel();
      component.setText(text);
      return component;
   }

   public static javax.swing.JTextField newJTextField(int columns) {
      final javax.swing.JTextField component = newJTextField();
      component.setColumns(columns);
      return component;
   }

   public static javax.swing.JButton newJButton(String text) {
      final javax.swing.JButton component = newJButton();
      component.setText(text);
      return component;
   }

   public static javax.swing.JButton newJButton(javax.swing.Action action) {
      final javax.swing.JButton component = newJButton();
      component.setAction(action);
      return component;
   }

   public static javax.swing.JTextArea newJTextArea(int cols, int rows) {
      final javax.swing.JTextArea component = newJTextArea();
      component.setColumns(cols);
      component.setRows(rows);
      return component;
   }

   public static javax.swing.JToggleButton newJToggleButton(String text) {
      final javax.swing.JToggleButton component = newJToggleButton();
      component.setText(text);
      return component;
   }

   public static javax.swing.JCheckBox newJCheckBox(String text) {
      final javax.swing.JCheckBox component = newJCheckBox();
      component.setText(text);
      return component;
   }

   public static javax.swing.JRadioButton newJRadioButton(String text) {
      final javax.swing.JRadioButton component = newJRadioButton();
      component.setText(text);
      return component;
   }

   public static javax.swing.JTextField newJTextField(String text, int cols) {
      final javax.swing.JTextField component = newJTextField();
      component.setText(text);
      component.setColumns(cols);
      return component;
   }

   public static javax.swing.JPanel newJPanel(java.awt.LayoutManager layout) {
      final javax.swing.JPanel component = newJPanel();
      component.setLayout(layout);
      return component;
   }

   public static javax.swing.JTable newJTable(javax.swing.table.TableModel tableModel) {
      final javax.swing.JTable component = newJTable();
      component.setModel(tableModel);
      return component;
   }

   public static javax.swing.JTextArea newJTextArea(String text) {
      final javax.swing.JTextArea component = newJTextArea();
      component.setText(text);
      return component;
   }


}