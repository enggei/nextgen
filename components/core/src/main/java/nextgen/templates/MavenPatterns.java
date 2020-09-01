package nextgen.templates;

import nextgen.utils.FileUtil;
import nextgen.templates.maven.*;
import nextgen.templates.maven.Properties;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MavenPatterns extends MavenST {

   public static void generate(Project project) {

      tryToCreateDirIfNotExists(newFile(project.getRoot()));

      tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/assembly"));

      tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/main/java"));
      tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/main/resources"));
      tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/main/filters"));
      tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/main/webapp"));

      tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/test/java"));
      tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/test/resources"));
      tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/test/filters"));

      tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/it"));
      tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/assembly"));
      tryToCreateDirIfNotExists(newFile(project.getRoot(), "src/site"));

      tryToCreateFileIfNotExists(newFile(project.getRoot(), "LICENSE.txt"));
      tryToCreateFileIfNotExists(newFile(project.getRoot(), "NOTICE.txt"));
      tryToCreateFileIfNotExists(newFile(project.getRoot(), "README.txt"));

      writePom(project.getPom(), project.getRoot());
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

   private static File newFile(Object path) {
      return new File(path.toString());
   }

   private static File newFile(Object path, String child) {
      return new File(path.toString(), child);
   }

   private static void writePom(Object pom, Object dir) {
      FileUtil.write(pom, new File(dir.toString(), "pom.xml"));
   }

   public static Properties setMavenCompilerSource(String version) {
      return newPomProperties("maven.compiler.source", version);
   }

   public static Properties setMavenCompilerTarget(String version) {
      return newPomProperties("maven.compiler.target", version);
   }

   public static Properties setProjectBuildSourceEncoding(String encoding) {
      return newPomProperties("project.build.sourceEncoding", encoding);
   }

   public static Properties setProjectReportingOutputEncoding(String encoding) {
      return newPomProperties("project.reporting.outputEncoding", encoding);
   }

   public static Properties newPomProperties(Object name, Object value) {
      return newProperties().setName(name).setValue(value);
   }

   public static PropertyReference newPropertyReference(String name) {
      return newPropertyReference().setName(name);
   }

   public static Dependency newDependency(Object groupId, Object artifactId, Object version) {
      return newDependency()
            .setGroupId(groupId)
            .setArtifactId(artifactId)
            .setVersion(version);
   }

   public static Set<Dependency> parseDependencies(String xml) {

      final Set<Dependency> dependencies = new LinkedHashSet<>();

      final String[] s = xml.split("\n");
      final AtomicBoolean inDependency = new AtomicBoolean(false);
      final List<String> dependency = new ArrayList<>();
      for (String value : s) {
         final String line = value.trim();
         if (line.contains("<dependency>")) {
            inDependency.set(true);
            dependency.clear();
            dependency.add(line.trim());
         } else if (line.contains("</dependency>")) {
            if (!dependency.isEmpty()) {
               final StringBuilder tmp = new StringBuilder();
               for (String s1 : dependency)
                  tmp.append(s1).append("\n");
               dependencies.add(newDependency(tmp.toString()));
            }
            inDependency.set(false);
         } else if (inDependency.get()) {
            dependency.add(line.trim());
         }
      }

      return dependencies;
   }

   public static Dependency newDependency(String xml) {

      final String scope = parseDependency("scope", xml);
      final Dependency dependency = newDependency()
            .setGroupId(parseDependency("groupId", xml))
            .setClassifier(parseDependency("classifier", xml))
            .setType(parseDependency("type", xml))
            .setScope(scope == null ? null : DependencyScope.valueOf(scope))
            .setSystemPath(parseDependency("systemPath", xml))
            .setArtifactId(parseDependency("artifactId", xml))
            .setVersion(parseDependency("version", xml));

      final StringBuilder out = new StringBuilder(".addDependencies(nextgen.templates.MavenPatterns.newDependency()");
      if (dependency.getGroupId() != null) out.append(".setGroupId(\"").append(dependency.getGroupId()).append("\")");
      if (dependency.getArtifactId() != null)
         out.append(".setArtifactId(\"").append(dependency.getArtifactId()).append("\")");
      if (dependency.getVersion() != null) out.append(".setVersion(\"").append(dependency.getVersion()).append("\")");
      if (dependency.getClassifier() != null)
         out.append(".setClassifier(\"").append(dependency.getClassifier()).append("\")");
      if (dependency.getScope() != null) out.append(".setScope(\"").append(dependency.getScope()).append("\")");
      if (dependency.getType() != null) out.append(".setType(\"").append(dependency.getType()).append("\")");
      if (dependency.getSystemPath() != null)
         out.append(".setSystemPath(\"").append(dependency.getSystemPath()).append("\")");
      out.append(")");

      System.out.println(out.toString().trim());

      return dependency;
   }

   public static void addDependencyGroup(Pom pom, DependencyGroup dependencyGroup) {
      final String groupPropertyName = dependencyGroup.getName() + ".version";
      if (pom.getProperties()
             .stream()
             .filter(pomProperty -> pomProperty instanceof Properties)
             .map(pomProperty -> (Properties) pomProperty)
             .anyMatch(pom_Properties -> pom_Properties.getName().equals(groupPropertyName)))
         return;
      pom.addProperties(newPomProperties(groupPropertyName, dependencyGroup.getVersion()));
      dependencyGroup.getArtifacts()
                     .forEach(artifact -> pom.addDependencies(newDependency(dependencyGroup.getGroupId(), artifact, newPropertyReference(groupPropertyName))));
   }

   public static Set<Dependency> importDependencies(File pomPath) {

      final Set<Dependency> dependencies = new LinkedHashSet<>();

      try {
         FileUtil.readString(pomPath, new FileUtil.LineHandler() {

            private StringBuilder xml;

            @Override
            public boolean handleLine(String line) {
               if (line.toLowerCase().contains("<dependency>")) {
                  xml = new StringBuilder();
               } else if (line.toLowerCase().contains("</dependency>")) {
                  dependencies.add(newDependency(xml.toString().trim()));
                  xml = null;
               } else if (xml != null) {
                  xml.append(line.trim()).append("\n");
               }
               return false;
            }
         });
      } catch (IOException e) {
         e.printStackTrace();
      }

      return dependencies;
   }

   private static String parseDependency(String element, String text) {
      final Pattern compile = Pattern.compile("<" + element + ">(.+)</" + element + ">", Pattern.CASE_INSENSITIVE);
      final Matcher matcher = compile.matcher(text.trim().toLowerCase());
      if (matcher.find()) return matcher.group(1);
      return null;
   }
}