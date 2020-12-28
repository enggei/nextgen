package nextgen.swing;

import javax.swing.*;

public final class SelectButton extends JToggleButton {

   private final java.util.concurrent.atomic.AtomicInteger index = new java.util.concurrent.atomic.AtomicInteger(0);
   private final java.util.List<Object> values = new java.util.ArrayList<>();
   private java.util.function.Consumer<SelectButton> action;
   private java.util.function.Function<Object, String> formatter = Object::toString;

   public SelectButton(Object[] array) {
      this(array, indexOf(array, 0));
   }

   public SelectButton(Object[] array, Object initial) {
      this(array, indexOf(array, initial));
   }

   public SelectButton(Object[] array, int initial) {
      ComponentFactory.decorate(this);

      this.values.addAll(java.util.Arrays.asList(array));
      this.index.set(initial);

      setText(values.get(index.get()).toString());
      addActionListener(actionEvent -> SwingUtilities.invokeLater(() -> {
         if (index.incrementAndGet() >= values.size()) index.set(0);
         setValue(values.get(index.get()));
         if (action != null) action.accept(this);
      }));

      addMouseListener(new java.awt.event.MouseAdapter() {
         @Override
         public void mousePressed(java.awt.event.MouseEvent e) {
            if (SwingUtilities.isRightMouseButton(e)) {
               SwingUtilities.invokeLater(() -> {
                  JPopupMenu pop = ComponentFactory.newJPopupMenu();
                  for (int i = 0; i < values.size(); i++) {
                     Object value = values.get(i);
                     int finalI = i;
                     pop.add(ComponentFactory.newJMenuItem(new AbstractAction(value.toString()) {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
                           SwingUtilities.invokeLater(() -> {
                              index.set(finalI);
                              setText(formatter.apply(values.get(index.get())));
                              if (action != null) action.accept(SelectButton.this);
                           });
                        }
                     }));
                  }

                  pop.show(SelectButton.this, e.getX(), e.getY());
               });
            }
         }
      });
   }

   public SelectButton action(java.util.function.Consumer<SelectButton> actionListenerConsumer) {
      this.action = actionListenerConsumer;
      return this;
   }

   public SelectButton formatter(java.util.function.Function<Object, String> formatter) {
      this.formatter = formatter;
      return this;
   }

   @SuppressWarnings("unchecked")
   public <T> T getValue() {
      return (T) values.get(index.get());
   }

   public void setValue(Object value) {
      if (!values.contains(value)) values.add(value);
      index.set(values.indexOf(value));
      setText(formatter.apply(values.get(index.get())));
   }

   private static int indexOf(Object[] values, Object initial) {
      for (int i = 0; i < values.length; i++)
         if (initial.equals(values[i])) return i;
      return 0;
   }
}
