package com.generator.app;

import com.generator.util.FormatUtil;
import com.generator.util.SwingUtil;
import org.zeroturnaround.exec.stream.LogOutputStream;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.OutputStream;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created 04.12.17.
 */
public class LogWindow extends JPanel {

   public final JTextArea txtLog = SwingUtil.newTextArea();
   private final Queue<String> lines = new ConcurrentLinkedQueue<>();
   private final int MAX_LINES = 40;

   LogWindow() {
      super(new BorderLayout());
      setPreferredSize(new Dimension(1024, 200));
      setMaximumSize(new Dimension(1024, 200));
      add(new JScrollPane(txtLog), BorderLayout.CENTER);

      txtLog.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            if(SwingUtilities.isRightMouseButton(e)) {
               final JPopupMenu pop = new JPopupMenu();
               pop.add(new AbstractAction("Clear") {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                     txtLog.setText("");
                  }
               });

               SwingUtilities.invokeLater(() -> pop.show(txtLog, e.getX(), e.getY()));
            }
         }
      });

   }

   public void log(String line) {
      SwingUtilities.invokeLater(() -> {
         txtLog.append("\n" + line);
         txtLog.setCaretPosition(txtLog.getDocument().getLength());
      });
   }

   public void log(String line, Long previous) {
      SwingUtilities.invokeLater(() -> {
         txtLog.append("\n" +line);
         txtLog.append(" in " + FormatUtil.formatTime(System.currentTimeMillis() - previous));
         txtLog.setCaretPosition(txtLog.getDocument().getLength());
      });
   }

   public Long logWithTimestamp(String line) {
      SwingUtilities.invokeLater(() -> {
         txtLog.append("\n" +line);
         txtLog.setCaretPosition(txtLog.getDocument().getLength());
      });
      return System.currentTimeMillis();
   }

   public Long logWithTimestamp(String line, Long previous) {
      SwingUtilities.invokeLater(() -> {
         txtLog.append("\n" + line);
         txtLog.append(" in " + FormatUtil.formatTime(System.currentTimeMillis() - previous));
         txtLog.setCaretPosition(txtLog.getDocument().getLength());
      });
      return System.currentTimeMillis();
   }

   public LogOutputStream getLogOutputStream() {
      return new LogOutputStream() {
         @Override
         protected void processLine(String s) {

            lines.add(s);
            while (lines.size() >= MAX_LINES) lines.poll();

            SwingUtilities.invokeLater(() -> {
               final StringBuilder text = new StringBuilder();
               for (String line : lines)
                  text.append(line).append("\n");
               txtLog.setText(text.toString());
               txtLog.setCaretPosition(txtLog.getDocument().getLength());
            });
         }
      };
   }

   public void logException(Throwable throwable) {
      SwingUtilities.invokeLater(() -> txtLog.append(SwingUtil.printStackTrace(throwable)));
   }
}