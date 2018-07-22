package com.nextgen.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
      writeToFile(content, getFile());
      return this;
   }

   public GeneratedFile writeIfNotExists(Object content) throws IOException {
      if (this.exists()) return this;
      writeToFile(content, getFile());
      return this;
   }

   public static void writeToFile(Object string, File file) throws IOException {
      tryToCreateFileIfNotExists(file);
      final BufferedWriter out = new BufferedWriter(new FileWriter(file));
      out.write(string == null ? "" : string.toString());
      out.close();
   }

   private static File tryToCreateFileIfNotExists(File f) {
      if (!f.exists()) {
         tryToCreateDirIfNotExists(f.getParentFile());
         try {
            if (!f.createNewFile()) throw new RuntimeException("Could not create file " + f.getName());
         } catch (IOException e) {
            throw new RuntimeException("Could not create file " + f.getName());
         }
      }
      return f;
   }

   private static File tryToCreateDirIfNotExists(File f) {

      if (f == null) throw new RuntimeException("File cannot be null");

      if (!f.exists()) {
         if (f.getParentFile() != null && !f.getParentFile().exists() && !f.getParentFile().mkdirs())
            throw new RuntimeException("Could not create parent dirs for " + f.getAbsolutePath());
         if (!f.mkdir()) throw new RuntimeException("Could not create directory " + f.getName());
      }
      return f;
   }
}