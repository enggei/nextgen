package com.generator.util;

import java.io.File;
import java.io.IOException;

/**
 * User: geirove
 * Date: 07.05.13
 * todo: refactor this to a general class, on same level as STGenerator
 */
public class GeneratedFile {

   private final File file;

   public GeneratedFile(File file) {
      this.file = file;
   }

   public File getFile() {
      return file;
   }

   public boolean exists() {
      return file != null && file.exists();
   }

   public static GeneratedFile newJavaFile(String root, String packageName, String className) {
      final String file = (packageName == null ? "" : (packageName.replaceAll("[.]", "/") + File.separator)) + className + ".java";
      return new GeneratedFile(new File(root, file));
   }

   public static GeneratedFile newJavaFile(File root, String packageName, String className) {
      return newJavaFile(root.getAbsolutePath(), packageName, className);
   }

   public static GeneratedFile newPlainFile(String root, String packageName, String filename) {
      final String file = (packageName == null ? "" : (packageName.replaceAll("[.]", "/") + File.separator)) + filename;
      return new GeneratedFile(new File(root, file));
   }

   public static GeneratedFile newDirectory(String root, String packageName) {
      final String file = (packageName == null ? "" : (packageName.replaceAll("[.]", "/")));
      return new GeneratedFile(new File(root, file));
   }

   public static GeneratedFile newPlainFile(String root, String filename) {
      return newPlainFile(root, null, filename);
   }

   public static GeneratedFile newPlainFile(File root, String packageName, String filename) {
      return newPlainFile(root.getAbsolutePath(), packageName, filename);
   }

   public static String packageToPath(String packageName) {
      return (packageName == null ? "" : (packageName.replaceAll("[.]", "/") + File.separator));
   }

   public static String packageToPath(String packageName, String filename) {
      return (packageName == null ? "" : (packageName.replaceAll("[.]", "/") + File.separator + filename));
   }

   public static String pathToPackage(String path) {
      return (path == null ? "" : (path.replaceAll("/", ".")));
   }

   public GeneratedFile write(Object content) throws IOException {
      FileUtil.writeFile(content, getFile());
      return this;
   }

   public GeneratedFile writeIfNotExists(Object content) throws IOException {
      if (this.exists()) return this;
      FileUtil.writeFile(content, getFile());
      return this;
   }
}