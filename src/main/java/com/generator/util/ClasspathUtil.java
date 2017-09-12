package com.generator.util;

import java.io.File;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created 05.07.17.
 */
public class ClasspathUtil {

   public interface Visitor<T> {

      boolean visit(T t);

   }

   public static void findClasses(Visitor<String> visitor) {
      String classpath = System.getProperty("java.class.path");
      String[] paths = classpath.split(System.getProperty("path.separator"));
      File file;

      for (String path : paths) {
         file = new File(path);
         if (file.exists()) findClasses(file, file, false, visitor);
      }
   }

   private static boolean findClasses(File root, File file, boolean includeJars, Visitor<String> visitor) {

      try {

         if (file.isDirectory()) {

            final File[] files = file.listFiles();
            if (files == null) return false;
            for (File child : files)
               if (!findClasses(root, child, includeJars, visitor))
                  return false;

         } else {

            if (file.getName().toLowerCase().endsWith(".jar") && includeJars) {
               final JarFile jar = new JarFile(file);
               final Enumeration<JarEntry> entries = jar.entries();
               while (entries.hasMoreElements()) {
                  final JarEntry entry = entries.nextElement();
                  final String name = entry.getName();
                  final int extIndex = name.lastIndexOf(".class");
                  if (extIndex > 0)
                     if (!visitor.visit(name.substring(0, extIndex).replace("/", ".")))
                        return false;
               }

            } else if (file.getName().toLowerCase().endsWith(".class")) {
               if (!visitor.visit(createClassName(root, file))) return false;
            }
         }

      } catch (Exception ex) {
         System.out.println("findClasses exception " + ex);
      }

      return true;
   }

   private static String createClassName(File root, File file) {
      final StringBuilder sb = new StringBuilder();
      final String fileName = file.getName();
      sb.append(fileName.substring(0, fileName.lastIndexOf(".class")));
      file = file.getParentFile();
      while (file != null && !file.equals(root)) {
         sb.insert(0, '.').insert(0, file.getName());
         file = file.getParentFile();
      }
      return sb.toString();
   }
}