package com.generator.util;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.tools.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.SecureClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created 11.09.17.
 */
public class CompilerUtil {

   private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(CompilerUtil.class);

   private final JavaCompiler compiler;

   public CompilerUtil() {
      // todo add classpath
      this.compiler = ToolProvider.getSystemJavaCompiler();
   }

   @SuppressWarnings("unchecked")
   public <T> T newInstance(String canonicalName, Object content, DiagnosticCollector<JavaFileObject> diagnostics) {

      final Class<?> loadClass = compile(canonicalName, content, diagnostics);

      try {
         return (T) loadClass.newInstance();
      } catch (InstantiationException e) {
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      }
      return null;
   }

   public Class<?> compile(String canonicalName, Object content, DiagnosticCollector<JavaFileObject> diagnostics) {
      // compilation-units
      final List<JavaFileObject> inMemoryFiles = new ArrayList<>(1);
      inMemoryFiles.add(new CharSequenceJavaFileObject(canonicalName, content.toString()));

      // compilation options
      final Iterable<String> compilationOptionss = Arrays.asList();

      // compile
      final JavaFileManager fileManager = new ClassFileManager(compiler.getStandardFileManager(diagnostics, Locale.getDefault(), Charset.defaultCharset()));
      final JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, compilationOptionss, null, inMemoryFiles);
      boolean success = task.call();

      // if failed to compile, return null (caller uses diagnostics for why)
      if (!success) return null;

      try {
         final Class<?> aClass = fileManager.getClassLoader(null).loadClass(canonicalName);
         fileManager.close();
         return aClass;
      } catch (Throwable t) {
         t.printStackTrace();
         return null;
      }
   }

   public static void printDiagnostics(DiagnosticCollector<JavaFileObject> diagnostics) {
      for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
         log.info("diagnostic.getCode() = " + diagnostic.getCode());
         log.info("diagnostic.getKind().name() = " + diagnostic.getKind().name());
         log.info("diagnostic.getLineNumber() = " + diagnostic.getLineNumber());
      }
   }

   public static final class DiagnosticPanel extends JPanel {

      private final JTree informationTree;

      private final JTextArea txtSource = SwingUtil.newTextArea();

      public DiagnosticPanel(DiagnosticCollector<JavaFileObject> diagnostics, String source) {
         super(new BorderLayout());

         final DiagnosticNode root = new DiagnosticNode("");
         final List<Diagnostic<? extends JavaFileObject>> diagnosticList = diagnostics.getDiagnostics();
         for (Diagnostic<? extends JavaFileObject> diagnostic : diagnosticList) {
            root.add(new DiagnosticNode(diagnostic));
         }

         informationTree = new JTree(root) {{

            setRootVisible(true);

            setCellRenderer(new DefaultTreeCellRenderer() {
               @Override
               public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                  final DiagnosticNode nodeEntry = (DiagnosticNode) value;
                  return super.getTreeCellRendererComponent(tree, nodeEntry.label(), sel, expanded, leaf, row, hasFocus);
               }
            });

            addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                  final TreePath selectionPath = ((JTree) e.getSource()).getSelectionPath();
                  if (selectionPath == null) return;
                  final DiagnosticNode selectedNode = (DiagnosticNode) selectionPath.getLastPathComponent();
                  if (selectedNode == null) return;
                  if (SwingUtilities.isRightMouseButton(e)) {
                     final JPopupMenu pop = new JPopupMenu();
                     selectedNode.addRightClickActions(pop, selectionPath, ((JTree) e.getSource()));
                     if (pop.getComponentCount() == 0) return;
                     SwingUtil.showPopup(pop, ((JTree) e.getSource()), e);
                  }
               }
            });
         }};
         add(new JScrollPane(informationTree), BorderLayout.WEST);

         txtSource.setText(source);
         txtSource.setCaretPosition(0);

         add(new JScrollPane(txtSource), BorderLayout.CENTER);
      }

      private class DiagnosticNode extends DefaultMutableTreeNode {

         protected String label = "";

         DiagnosticNode(String label) {
            this.label = label;
         }

         DiagnosticNode(Diagnostic<? extends JavaFileObject> diagnostic) {
            this.label = diagnostic.getCode();
            setUserObject(diagnostic);
         }

         public String label() {
            return label;
         }

         void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {

         }
      }
   }
   
   private static final class CharSequenceJavaFileObject extends SimpleJavaFileObject {

      private CharSequence content;

      CharSequenceJavaFileObject(String className, CharSequence content) {
         super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
         this.content = content;
      }

      @Override
      public CharSequence getCharContent(boolean ignoreEncodingErrors) {
         return content;
      }
   }

   private static final class JavaClassObject extends SimpleJavaFileObject {

      final ByteArrayOutputStream bos = new ByteArrayOutputStream();

      JavaClassObject(String name, Kind kind) {
         super(URI.create("string:///" + name.replace('.', '/') + kind.extension), kind);
      }

      byte[] getBytes() {
         return bos.toByteArray();
      }

      @Override
      public OutputStream openOutputStream() throws IOException {
         return bos;
      }
   }

   private static class ClassFileManager extends ForwardingJavaFileManager<StandardJavaFileManager> {

      private JavaClassObject jclassObject;

      ClassFileManager(StandardJavaFileManager standardManager) {
         super(standardManager);
      }

      @Override
      public ClassLoader getClassLoader(Location location) {
         return new SecureClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
               byte[] b = jclassObject.getBytes();
               return super.defineClass(name, jclassObject.getBytes(), 0, b.length);
            }
         };
      }

      @Override
      public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
         jclassObject = new JavaClassObject(className, kind);
         return jclassObject;
      }
   }
}