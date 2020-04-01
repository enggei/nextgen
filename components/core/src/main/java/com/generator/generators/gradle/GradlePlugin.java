package com.generator.generators.gradle;

import com.generator.app.App;
import com.generator.util.SwingUtil;
import com.generator.util.ThreadUtil;
import org.neo4j.graphdb.Transaction;
import org.zeroturnaround.exec.ProcessExecutor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Created 11.12.17.
 */
public class GradlePlugin extends GradleDomainPlugin {

   public GradlePlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

   }

   public static JMenu createGradlewBuild(File directory, App app) {
      final JMenu lifecycleMenu = new JMenu("Run Gradlew Lifecycle");

      final String[] cycles = {"assemble", "build", "buildDependents", "buildNeeded", "classes", "clean", "jar", "jmhClasses", "testClasses"};
      for (String cycle : cycles) {
         lifecycleMenu.add(new App.TransactionAction("Run " + cycle, app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               ThreadUtil.runTask(new ThreadUtil.ThreadTask<Throwable>() {
                  @Override
                  public Throwable run() {
                     try {
                        new ProcessExecutor().
                              directory(directory).
                              command("./gradlew", cycle)
                              .redirectOutput(app.logWindow.getLogOutputStream()).execute();
                     } catch (Throwable t) {
                        return t;
                     }

                     return null;
                  }

                  @Override
                  public void onComplete(Throwable throwable) {
                     if (throwable != null) SwingUtil.showException(app, throwable);
                  }
               });
            }
         });
      }

      return lifecycleMenu;
   }
}