package nextgen.projects;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import nextgen.templates.java.JavaPatterns;
import nextgen.templates.java.ClassOrInterfaceDeclaration;
import nextgen.templates.java.MethodCallExpression;
import nextgen.utils.StringUtil;
import nextgen.utils.SwingUtil;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import static nextgen.templates.java.JavaST.newMethodCallExpression;

public class JavaSourceCleaner extends JFrame {

   public JavaSourceCleaner() throws HeadlessException {
      super("Java Source Cleaner");

      final RSyntaxTextArea rSyntaxTextArea = SwingUtil.newRSyntaxTextArea(30, 100);
      add(SwingUtil.newRTextScrollPane(rSyntaxTextArea), BorderLayout.CENTER);

      final JPopupMenu pop = rSyntaxTextArea.getPopupMenu();
      pop.addSeparator();
      pop.add(newAction("Format", actionEvent -> SwingUtil.format(rSyntaxTextArea)));
      pop.add(newAction("As Object array", actionEvent -> {
         final String output = asObjectArray(rSyntaxTextArea);
         System.out.println(output);
         SwingUtil.toClipboard(output);
      }));
      pop.add(newAction("As Dependency", actionEvent -> asDependency(rSyntaxTextArea)));
      pop.add(newAction("As Imports", actionEvent -> asImports(rSyntaxTextArea)));
      pop.add(newAction("As Fields", actionEvent -> asFields(rSyntaxTextArea)));
      pop.add(newAction("As ClassMembers", actionEvent -> asClassMembers(rSyntaxTextArea)));

      rSyntaxTextArea.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
               SwingUtilities.invokeLater(() -> rSyntaxTextArea.setText(SwingUtil.fromClipboard()));
            }
         }
      });
   }

   private void asDependency(RSyntaxTextArea textArea) {
      SwingUtil.toClipboard(nextgen.templates.maven.MavenPatterns.parseToDependencyBuilder(textArea.getText().trim())
            .toString());
   }

   private void asImports(RSyntaxTextArea textArea) {

      final String trim = textArea.getText().trim();
      final String[] lines = trim.split("\n");
      final StringBuilder result = new StringBuilder();
      for (String s : lines) {
         final String line = s.trim();
         if (line.startsWith("import")) {
            final ImportDeclaration importDeclaration = StaticJavaParser.parseImport(line);
            result.append("\n.addImports(newImportDeclaration(\"").append(importDeclaration.getNameAsString());
            if (importDeclaration.isAsterisk())
               result.append("\").setIsAsterisk(true))");
            if (importDeclaration.isStatic())
               result.append("\").setIsStatic(true))");
         }
      }

      SwingUtil.toClipboard(result.toString().trim());
   }

   private void asClassMembers(RSyntaxTextArea textArea) {

      final StringBuilder result = new StringBuilder();

      final String trim = textArea.getText().trim();

      final CompilationUnit compilationUnit = StaticJavaParser.parse(trim);

      final AtomicReference<MethodCallExpression> addMethodDeclaration = new AtomicReference<>();

      compilationUnit.getTypes().forEach(typeDeclaration -> {
         typeDeclaration.getMembers().stream()
               .filter(bodyDeclaration -> bodyDeclaration instanceof MethodDeclaration)
               .map(methodDeclaration -> (MethodDeclaration) methodDeclaration)
               .forEach(methodDeclaration -> {

                  final AtomicReference<MethodCallExpression> expression = new AtomicReference<>();

                  expression.set(newMethodCallExpression()
                        .setName("newMethodDeclaration"));

                  expression.set(newMethodCallExpression()
                        .setScope(expression.get())
                        .setName("setName")
                        .addArguments("\"" + methodDeclaration.getNameAsString() + "\""));

                  methodDeclaration.getParameters().forEach(parameter -> {
                     expression.set(newMethodCallExpression()
                           .setScope(expression.get())
                           .setName("addParameters")
                           .addArguments(newMethodCallExpression()
                                 .setName("newParameter")
                                 .addArguments("\"" + parameter.getTypeAsString() + "\"")
                                 .addArguments("\"" + parameter.getNameAsString() + "\"")));
                  });

                  methodDeclaration.getBody().ifPresent(blockStmt -> {

                     RSyntaxTextArea tmp = new RSyntaxTextArea();
                     tmp.setText(blockStmt.toString());
                     final String s = asObjectArray(tmp);

                     expression.set(newMethodCallExpression()
                           .setScope(expression.get())
                           .setName("setBlockStmt")
                           .addArguments(newMethodCallExpression()
                                 .setName("newBlockStmt")
                                 .addArguments(s)));
                  });

                  addMethodDeclaration.set(newMethodCallExpression()
                        .setName("addMethods")
                        .setScope(addMethodDeclaration.get() == null ? "." : addMethodDeclaration.get())
                        .addArguments(expression.get()));
               });

         typeDeclaration.getMembers().stream()
               .filter(bodyDeclaration -> bodyDeclaration instanceof com.github.javaparser.ast.body.ClassOrInterfaceDeclaration)
               .map(bodyDeclaration -> (com.github.javaparser.ast.body.ClassOrInterfaceDeclaration) bodyDeclaration)
               .forEach(classOrInterfaceDeclaration -> {

               });

      });

      final String s = addMethodDeclaration.toString();
      SwingUtil.toClipboard(s);
      System.out.println(s);
   }

   private void asFields(RSyntaxTextArea textArea) {
      final StringBuilder result = new StringBuilder();

      final ClassOrInterfaceDeclaration classOrInterfaceDeclaration = JavaPatterns.newClassOrInterfaceDeclaration("Tmp");
      final String[] lines = textArea.getText().trim().split("\n");
      for (String s : lines) {
         classOrInterfaceDeclaration.addFields(s.trim());
      }

      final CompilationUnit compilationUnit = StaticJavaParser.parse(classOrInterfaceDeclaration.toString());
      compilationUnit.getTypes().forEach(typeDeclaration -> {
         typeDeclaration.getMembers().stream()
               .map(bodyDeclaration -> (FieldDeclaration) bodyDeclaration)
               .forEach(fieldDeclaration -> {
                  final List<VariableDeclarator> variableDeclarators = new ArrayList<>(fieldDeclaration.getVariables());
                  for (VariableDeclarator variableDeclarator : variableDeclarators) {
                     final StringBuilder declaration = new StringBuilder(".addFields(")
                           .append("\"").append(variableDeclarator.getType()).append("\"")
                           .append(", ")
                           .append("\"").append(variableDeclarator.getName()).append("\"")
                           .append(", ");

                     if (variableDeclarator.getInitializer().isPresent())
                        variableDeclarator.getInitializer()
                              .ifPresent(expression -> declaration.append("\"")
                                    .append(StringUtil.escape(expression.toString()))
                                    .append("\""));
                     else
                        declaration.append("null");
                     declaration.append(")");
                     result.append("\n").append(declaration);
                  }
               });
      });

      SwingUtil.toClipboard(result.toString().trim());
   }

   public static Action newAction(String name, Consumer<ActionEvent> consumer) {
      return new AbstractAction(name) {
         @Override
         public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(() -> consumer.accept(e));
         }
      };
   }

   private String asObjectArray(RSyntaxTextArea textArea) {
      final StringBuilder output = new StringBuilder("new Object[] {");

      try {
         final Document doc = textArea.getDocument();
         final Element root = doc.getDefaultRootElement();
         final int lines = root.getElementCount();

         int tabOffset = 0;
         for (int i = 0; i < lines; i++) {
            final Element element = root.getElement(i);
            int start = element.getStartOffset();
            int end = element.getEndOffset();
            final String line = doc.getText(start, end - start);

            int lineTab = lineTabs(line);
            if (i == 0) tabOffset = lineTab;
            lineTab -= tabOffset;

            int tabCount = lineTab;
            output.append(i > 0 ? ",\n\t" : "\n\t")
                  .append("\"")
                  .append(tabs(tabCount))
                  .append(StringUtil.escape(line.trim()))
                  .append("\"");
         }

      } catch (BadLocationException ex) {
         throw new RuntimeException(ex);
      }
      output.append("\n}");

      return output.toString();
   }

   private String tabs(int tabCount) {
      final StringBuilder tabs = new StringBuilder();
      for (int i = 0; i < tabCount; i++)
         tabs.append("\t");
      return tabs.toString();
   }

   private int lineTabs(String line) {
      final char[] chars = line.toCharArray();
      int spaces = 0;
      for (char aChar : chars) {
         if (aChar == ' ') spaces++;
         else if (aChar == '\t') spaces += 3;
         else break;
      }
      return spaces / 3;
   }

   public static void main(String[] args) {
      com.formdev.flatlaf.FlatDarculaLaf.install();
      SwingUtil.show(new JavaSourceCleaner());
   }
}
