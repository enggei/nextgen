package com.generator.util;

import org.apache.log4j.WriterAppender;
import org.apache.log4j.spi.LoggingEvent;

import javax.swing.*;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * Created 11.12.17.
 */
public class TextAreaLogAppender extends WriterAppender {

   public static JTextArea logTextArea;

   private final Queue<String> prelogs = new ConcurrentLinkedQueue<>();
   private long lastEvent = 0;

   @Override
   public void append(LoggingEvent loggingEvent) {

      if (logTextArea == null || (lastEvent - System.currentTimeMillis() < 100L)) {
         prelogs.add(this.layout.format(loggingEvent));
         lastEvent = System.currentTimeMillis();
         return;
      }

      if (!prelogs.isEmpty()) {
         for (String prelog : prelogs) {
            logTextArea.append(prelog);
            logTextArea.setCaretPosition(logTextArea.getDocument().getLength());
         }
         prelogs.clear();
      }

      SwingUtilities.invokeLater(() -> {
         logTextArea.append(layout.format(loggingEvent));
         logTextArea.setCaretPosition(logTextArea.getDocument().getLength());
      });
   }
}
