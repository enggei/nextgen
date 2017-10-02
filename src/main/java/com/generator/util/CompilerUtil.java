package com.generator.util;

import javax.tools.*;
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

   private final JavaCompiler compiler;

   public CompilerUtil() {
      // todo add classpath
      this.compiler = ToolProvider.getSystemJavaCompiler();
   }

   @SuppressWarnings("unchecked")
   public <T> T newInstance(String canonicalName, Object content, DiagnosticCollector<JavaFileObject> diagnostics) {

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
         final Class<?> loadClass = fileManager.getClassLoader(null).loadClass(canonicalName);
         final T t = (T) loadClass.newInstance();
         fileManager.close();
         return t;
      } catch (Exception e) {
         e.printStackTrace();
      }

      return null;
   }

   public static void printDiagnostics(DiagnosticCollector<JavaFileObject> diagnostics) {
      for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
         System.out.println("diagnostic.getCode() = " + diagnostic.getCode());
         System.out.println("diagnostic.getKind().name() = " + diagnostic.getKind().name());
         System.out.println("diagnostic.getLineNumber() = " + diagnostic.getLineNumber());
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