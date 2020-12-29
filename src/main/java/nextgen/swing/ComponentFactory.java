package nextgen.swing;

import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.DarculaTheme;

import javax.swing.*;
import java.awt.*;

public class ComponentFactory {

   private static final DarculaTheme theme = new DarculaTheme();

//   public static final Font font = new Font("Dialog", Font.PLAIN, 12);

   public static void applyLaf() {
      LafManager.install(theme);
   }

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

   public static <T> javax.swing.JList<T> newJList() {
      return decorate(new JList<>());
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

   public static JPopupMenu newJPopupMenu() {
      return decorate(new JPopupMenu());
   }

   public static javax.swing.JMenuItem newJMenuItem() {
      return decorate(new javax.swing.JMenuItem());
   }

   public static javax.swing.JScrollPane newJScrollPane() {
      return decorate(new javax.swing.JScrollPane());
   }


   // decorators

   public static Component decorate(Component component) {
      return component;
   }

   public static javax.swing.JLabel decorate(javax.swing.JLabel component) {
      baseDecorate(component);
      return component;
   }

   public static javax.swing.JTextField decorate(javax.swing.JTextField component) {
      baseDecorate(component);
      return component;
   }

   public static javax.swing.JTextArea decorate(javax.swing.JTextArea component) {
      baseDecorate(component);
      return component;
   }

   public static javax.swing.JButton decorate(javax.swing.JButton component) {
      baseDecorate(component);
      component.setBackground(Color.DARK_GRAY);
      return component;
   }

   public static javax.swing.JToggleButton decorate(javax.swing.JToggleButton component) {
      baseDecorate(component);
      return component;
   }

   public static javax.swing.JTable decorate(javax.swing.JTable component) {
      baseDecorate(component);
      return component;
   }

   public static <T> javax.swing.JList<T> decorate(javax.swing.JList<T> component) {
      baseDecorate(component);
      return component;
   }

   public static javax.swing.JTabbedPane decorate(javax.swing.JTabbedPane component) {
      baseDecorate(component);
      return component;
   }

   public static javax.swing.JCheckBox decorate(javax.swing.JCheckBox component) {
      baseDecorate(component);
      return component;
   }

   public static javax.swing.JRadioButton decorate(javax.swing.JRadioButton component) {
      baseDecorate(component);
      return component;
   }

   public static javax.swing.JPanel decorate(javax.swing.JPanel component) {
      baseDecorate(component);
      return component;
   }

   public static javax.swing.JScrollPane decorate(javax.swing.JScrollPane component) {
      baseDecorate(component);
      return component;
   }

   public static javax.swing.JMenuItem decorate(javax.swing.JMenuItem component) {
      baseDecorate(component);
      return component;
   }

   public static javax.swing.JPopupMenu decorate(javax.swing.JPopupMenu component) {
      baseDecorate(component);
      return component;
   }

   private static JComponent baseDecorate(JComponent component) {
//      component.setFont(font);
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

   public static javax.swing.JCheckBox newJCheckBox(boolean selected) {
      final javax.swing.JCheckBox component = newJCheckBox();
      component.setSelected(selected);
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

   public static LayoutManager newBoxLineLayout(JComponent component) {
      final BoxLayout layout = new BoxLayout(component, BoxLayout.LINE_AXIS);
      component.setLayout(layout);
      return layout;
   }

   public static LayoutManager newBoxPageLayout(JComponent component) {
      final BoxLayout layout = new BoxLayout(component, BoxLayout.PAGE_AXIS);
      component.setLayout(layout);
      return layout;
   }

   public static JRadioButton newJRadioButton(String text, boolean selected) {
      final JRadioButton component = newJRadioButton();
      component.setText(text);
      component.setSelected(selected);
      return component;
   }

   public static JPanel newFlowPanel() {
      final JPanel component = newJPanel();
      component.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
      return component;
   }

   public static JPanel newPagePanel() {
      final JPanel component = newJPanel();
      component.setLayout(new BoxLayout(component, BoxLayout.PAGE_AXIS));
      return component;
   }

   public static JPanel newBorderPanel() {
      return newJPanel(new BorderLayout());
   }

   public static javax.swing.JScrollPane newJScrollPane(java.awt.Component jComponent) {
      return decorate(new javax.swing.JScrollPane(jComponent));
   }



   public static JMenuItem newJMenuItem(Action action) {
      final JMenuItem component = newJMenuItem();
      component.setAction(action);
      return component;
   }

   public static JPanel newGridPanel(int rows, int cols) {
      return newJPanel(new GridLayout(rows, cols));
   }
}