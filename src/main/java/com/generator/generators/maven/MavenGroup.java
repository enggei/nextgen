package com.generator.generators.maven;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'maven.stg' file<br/>
 */
public final class MavenGroup {
   // old maven
   private final STGroup stGroup;
   private final char delimiter;

   public MavenGroup() {
      final String generatorPath = System.getProperty("generator.path");

      if (generatorPath != null) {
         this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "maven" + java.io.File.separator + "maven.stg");
         this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
         this.delimiter = stGroup.delimiterStartChar;
      } else {
         this.stGroup = new org.stringtemplate.v4.STGroupFile(MavenGroup.class.getResource("/com/generator/generators/maven/maven.stg"), "UTF-8", '~', '~');
         this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
         this.delimiter = stGroup.delimiterStartChar;
      }
   }

   public MavenGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public MavenGroup(java.io.File templateFile) {
      this.stGroup = new org.stringtemplate.v4.STGroupFile(templateFile.getAbsolutePath());
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public STGroup getSTGroup() {
      return stGroup;
   }

   public char getDelimiter() {
      return delimiter;
   }

   public interface mavenGroupTemplate {

   }


   public buildHelperPluginST newbuildHelperPlugin() {
      return new buildHelperPluginST(stGroup);
   }


   public buildPluginsST newbuildPlugins() {
      return new buildPluginsST(stGroup);
   }


   public dependenciesST newdependencies() {
      return new dependenciesST(stGroup);
   }


   public dependencyST newdependency() {
      return new dependencyST(stGroup);
   }


   public fatJarVertxPluginST newfatJarVertxPlugin() {
      return new fatJarVertxPluginST(stGroup);
   }


   public integrationTestsST newintegrationTests() {
      return new integrationTestsST(stGroup);
   }


   public mavenCompilerPluginST newmavenCompilerPlugin() {
      return new mavenCompilerPluginST(stGroup);
   }


   public pluginST newplugin() {
      return new pluginST(stGroup);
   }


   public pomST newpom() {
      return new pomST(stGroup);
   }


   public projectST newproject() {
      return new projectST(stGroup);
   }


   public propertiesST newproperties() {
      return new propertiesST(stGroup);
   }


   public repositoriesST newrepositories() {
      return new repositoriesST(stGroup);
   }


   public repositoryST newrepository() {
      return new repositoryST(stGroup);
   }


   public runFatJarPluginST newrunFatJarPlugin() {
      return new runFatJarPluginST(stGroup);
   }


   public testResourcesST newtestResources() {
      return new testResourcesST(stGroup);
   }


   public vertxIntegrationProfileST newvertxIntegrationProfile() {
      return new vertxIntegrationProfileST(stGroup);
   }


   public webrootAssemblyPluginST newwebrootAssemblyPlugin() {
      return new webrootAssemblyPluginST(stGroup);
   }


   public windowsProfileST newwindowsProfile() {
      return new windowsProfileST(stGroup);
   }

   public final class buildHelperPluginST implements mavenGroupTemplate {

      private final ST template;

      private buildHelperPluginST(STGroup group) {
         template = group.getInstanceOf("buildHelperPlugin");
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class buildPluginsST implements mavenGroupTemplate {

      private final AtomicBoolean filtersIsSet = new AtomicBoolean(false);
      private final AtomicBoolean pluginsIsSet = new AtomicBoolean(false);
      private final ST template;

      private buildPluginsST(STGroup group) {
         template = group.getInstanceOf("buildPlugins");
      }

      public buildPluginsST addFiltersValue(Object value) {
         tryToSetListProperty(template, value, filtersIsSet, "filters");
         return this;
      }
      public buildPluginsST addPluginsValue(Object value) {
         tryToSetListProperty(template, value, pluginsIsSet, "plugins");
         return this;
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class dependenciesST implements mavenGroupTemplate {

      private final AtomicBoolean dependenciesIsSet = new AtomicBoolean(false);
      private final ST template;

      private dependenciesST(STGroup group) {
         template = group.getInstanceOf("dependencies");
      }

      public dependenciesST addDependenciesValue(Object value) {
         tryToSetListProperty(template, value, dependenciesIsSet, "dependencies");
         return this;
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class dependencyST implements mavenGroupTemplate {

      private final AtomicBoolean artifactIdIsSet = new AtomicBoolean(false);
      private final AtomicBoolean groupIdIsSet = new AtomicBoolean(false);
      private final AtomicBoolean scopeIsSet = new AtomicBoolean(false);
      private final AtomicBoolean versionIsSet = new AtomicBoolean(false);
      private final ST template;

      private dependencyST(STGroup group) {
         template = group.getInstanceOf("dependency");
      }

      public dependencyST setArtifactId(Object value) {
         tryToSetStringProperty(template, value, artifactIdIsSet, "artifactId");
         return this;
      }
      public dependencyST setGroupId(Object value) {
         tryToSetStringProperty(template, value, groupIdIsSet, "groupId");
         return this;
      }
      public dependencyST setScope(Object value) {
         tryToSetStringProperty(template, value, scopeIsSet, "scope");
         return this;
      }
      public dependencyST setVersion(Object value) {
         tryToSetStringProperty(template, value, versionIsSet, "version");
         return this;
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class fatJarVertxPluginST implements mavenGroupTemplate {

      private final AtomicBoolean mainVerticleIsSet = new AtomicBoolean(false);
      private final ST template;

      private fatJarVertxPluginST(STGroup group) {
         template = group.getInstanceOf("fatJarVertxPlugin");
      }

      public fatJarVertxPluginST setMainVerticle(Object value) {
         tryToSetStringProperty(template, value, mainVerticleIsSet, "mainVerticle");
         return this;
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class integrationTestsST implements mavenGroupTemplate {

      private final ST template;

      private integrationTestsST(STGroup group) {
         template = group.getInstanceOf("integrationTests");
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class mavenCompilerPluginST implements mavenGroupTemplate {

      private final AtomicBoolean sourceIsSet = new AtomicBoolean(false);
      private final AtomicBoolean targetIsSet = new AtomicBoolean(false);
      private final ST template;

      private mavenCompilerPluginST(STGroup group) {
         template = group.getInstanceOf("mavenCompilerPlugin");
      }

      public mavenCompilerPluginST setSource(Object value) {
         tryToSetStringProperty(template, value, sourceIsSet, "source");
         return this;
      }
      public mavenCompilerPluginST setTarget(Object value) {
         tryToSetStringProperty(template, value, targetIsSet, "target");
         return this;
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class pluginST implements mavenGroupTemplate {

      private final AtomicBoolean artifactIdIsSet = new AtomicBoolean(false);
      private final AtomicBoolean configurationIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dependenciesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean executionsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean groupIdIsSet = new AtomicBoolean(false);
      private final AtomicBoolean versionIsSet = new AtomicBoolean(false);
      private final ST template;

      private pluginST(STGroup group) {
         template = group.getInstanceOf("plugin");
      }

      public pluginST setArtifactId(Object value) {
         tryToSetStringProperty(template, value, artifactIdIsSet, "artifactId");
         return this;
      }
      public pluginST addConfigurationValue(Object value) {
         tryToSetListProperty(template, value, configurationIsSet, "configuration");
         return this;
      }
      public pluginST addDependenciesValue(Object value) {
         tryToSetListProperty(template, value, dependenciesIsSet, "dependencies");
         return this;
      }
      public pluginST addExecutionsValue(Object value) {
         tryToSetListProperty(template, value, executionsIsSet, "executions");
         return this;
      }
      public pluginST setGroupId(Object value) {
         tryToSetStringProperty(template, value, groupIdIsSet, "groupId");
         return this;
      }
      public pluginST setVersion(Object value) {
         tryToSetStringProperty(template, value, versionIsSet, "version");
         return this;
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class pomST implements mavenGroupTemplate {

      private final AtomicBoolean buildPluginsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean profilesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean projectIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean repositoriesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean dependencyIsSet = new AtomicBoolean(false);
      private final ST template;

      private pomST(STGroup group) {
         template = group.getInstanceOf("pom");
      }

      public pomST setBuildPlugins(Object value) {
         tryToSetStringProperty(template, value, buildPluginsIsSet, "buildPlugins");
         return this;
      }
      public pomST setProfiles(Object value) {
         tryToSetStringProperty(template, value, profilesIsSet, "profiles");
         return this;
      }
      public pomST setProject(Object value) {
         tryToSetStringProperty(template, value, projectIsSet, "project");
         return this;
      }
      public pomST setProperties(Object value) {
         tryToSetStringProperty(template, value, propertiesIsSet, "properties");
         return this;
      }
      public pomST setRepositories(Object value) {
         tryToSetStringProperty(template, value, repositoriesIsSet, "repositories");
         return this;
      }
      public pomST addDependencyValue(Object artifactId_, Object groupId_, Object scope_, Object version_) {
         dependencyIsSet.set(true);
         template.addAggr("dependency.{artifactId, groupId, scope, version}", ( (artifactId_==null || artifactId_.toString().length()==0) ? null : artifactId_), ( (groupId_==null || groupId_.toString().length()==0) ? null : groupId_), ( (scope_==null || scope_.toString().length()==0) ? null : scope_), ( (version_==null || version_.toString().length()==0) ? null : version_));
         return this;
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class projectST implements mavenGroupTemplate {

      private final AtomicBoolean artifactIdIsSet = new AtomicBoolean(false);
      private final AtomicBoolean groupIdIsSet = new AtomicBoolean(false);
      private final AtomicBoolean versionIsSet = new AtomicBoolean(false);
      private final ST template;

      private projectST(STGroup group) {
         template = group.getInstanceOf("project");
      }

      public projectST setArtifactId(Object value) {
         tryToSetStringProperty(template, value, artifactIdIsSet, "artifactId");
         return this;
      }
      public projectST setGroupId(Object value) {
         tryToSetStringProperty(template, value, groupIdIsSet, "groupId");
         return this;
      }
      public projectST setVersion(Object value) {
         tryToSetStringProperty(template, value, versionIsSet, "version");
         return this;
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class propertiesST implements mavenGroupTemplate {

      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private propertiesST(STGroup group) {
         template = group.getInstanceOf("properties");
      }

      public propertiesST addPropertiesValue(Object key_, Object value_) {
         propertiesIsSet.set(true);
         template.addAggr("properties.{key, value}", ( (key_==null || key_.toString().length()==0) ? null : key_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class repositoriesST implements mavenGroupTemplate {

      private final AtomicBoolean repositoriesIsSet = new AtomicBoolean(false);
      private final ST template;

      private repositoriesST(STGroup group) {
         template = group.getInstanceOf("repositories");
      }

      public repositoriesST addRepositoriesValue(Object value) {
         tryToSetListProperty(template, value, repositoriesIsSet, "repositories");
         return this;
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class repositoryST implements mavenGroupTemplate {

      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean urlIsSet = new AtomicBoolean(false);
      private final ST template;

      private repositoryST(STGroup group) {
         template = group.getInstanceOf("repository");
      }

      public repositoryST setId(Object value) {
         tryToSetStringProperty(template, value, idIsSet, "id");
         return this;
      }
      public repositoryST setName(Object value) {
         tryToSetStringProperty(template, value, nameIsSet, "name");
         return this;
      }
      public repositoryST setUrl(Object value) {
         tryToSetStringProperty(template, value, urlIsSet, "url");
         return this;
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class runFatJarPluginST implements mavenGroupTemplate {

      private final AtomicBoolean confPathIsSet = new AtomicBoolean(false);
      private final ST template;

      private runFatJarPluginST(STGroup group) {
         template = group.getInstanceOf("runFatJarPlugin");
      }

      public runFatJarPluginST setConfPath(Object value) {
         tryToSetStringProperty(template, value, confPathIsSet, "confPath");
         return this;
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class testResourcesST implements mavenGroupTemplate {

      private final AtomicBoolean directoryIsSet = new AtomicBoolean(false);
      private final AtomicBoolean filteringIsSet = new AtomicBoolean(false);
      private final ST template;

      private testResourcesST(STGroup group) {
         template = group.getInstanceOf("testResources");
      }

      public testResourcesST setDirectory(Object value) {
         tryToSetStringProperty(template, value, directoryIsSet, "directory");
         return this;
      }
      public testResourcesST setFiltering(Object value) {
         tryToSetStringProperty(template, value, filteringIsSet, "filtering");
         return this;
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class vertxIntegrationProfileST implements mavenGroupTemplate {

      private final ST template;

      private vertxIntegrationProfileST(STGroup group) {
         template = group.getInstanceOf("vertxIntegrationProfile");
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class webrootAssemblyPluginST implements mavenGroupTemplate {

      private final ST template;

      private webrootAssemblyPluginST(STGroup group) {
         template = group.getInstanceOf("webrootAssemblyPlugin");
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   public final class windowsProfileST implements mavenGroupTemplate {

      private final ST template;

      private windowsProfileST(STGroup group) {
         template = group.getInstanceOf("windowsProfile");
      }

      @Override
      public String toString() {
         return template.render();
      }
   }

   static void tryToSetStringProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {
      if (alreadySet.get()) return;
      if (value == null || value.toString().length() == 0) return;
      alreadySet.set(true);
      template.add(name, value);
   }

   static boolean tryToSetListProperty(ST template, Object value, AtomicBoolean alreadySet, String name) {
      if (value == null || value.toString().length() == 0) return true;
      alreadySet.set(true);
      template.add(name, value);
      return false;
   }

   private enum FormatCode {
      capitalize, toUpper, lowFirst, toLower, humpToCap, camelHump, splitCamelHump, singlify, packageToPath
   }

   private final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

      @Override
      public String toString(Object o, String formatString, java.util.Locale locale) {

         final String text = o.toString();

         if (formatString == null) return text;

         switch (FormatCode.valueOf(formatString)) {
            case capitalize:
               return capitalize(text);
            case toUpper:
               return toUpper(text);
            case lowFirst:
               return lowFirst(text);
            case toLower:
               return text.toLowerCase();
            case humpToCap:
               return humpToCap(text);
            case camelHump:
               return camelHump(text);
            case splitCamelHump:
               return splitCamelHump(text);
            case singlify:
               String s = toUpper(text).substring(0, 1) + text.substring(1);
               if (s.toLowerCase().endsWith("ies")) return s.substring(0, s.length() - 3) + "y";
               else if (s.toLowerCase().endsWith("es") || s.toLowerCase().endsWith("nts")) return s.substring(0, s.length() - 1);
               else if (s.toLowerCase().endsWith("ions") || s.toLowerCase().endsWith("mns"))
                  return s.substring(0, s.length() - 1);
               return s;
            case packageToPath:
               return packageToPath((text));
            default:
               return o.toString();
         }
      }

      private String capitalize(String string) {
         if (string == null || string.length() == 0) return "";
         return Character.toUpperCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
      }

      private String lowFirst(String string) {
         if (string == null || string.length() == 0) return "";
         return Character.toLowerCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
      }

      private String toUpper(String text) {
         return text.toUpperCase();
      }

      private String humpToCap(String text) {
         final char[] chars = text.toCharArray();
         final StringBuilder out = new StringBuilder();
         boolean first = true;
         for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (!first && Character.isUpperCase(aChar) && (i < chars.length - 2 && Character.isLowerCase(chars[i + 1]))) {
               out.append("_");
            }
            first = false;
            out.append(Character.toUpperCase(aChar));
         }
         return out.toString();
      }

      private String camelHump(String text) {
         final char[] chars = text.toCharArray();
         final StringBuilder out = new StringBuilder();
         boolean capitalize = true;
         for (char aChar : chars) {
            if (Character.isWhitespace(aChar)) {
               capitalize = true;
               continue;
            }
            out.append(capitalize ? Character.toUpperCase(aChar) : aChar);
            capitalize = false;
         }
         return out.toString();
      }

      private String splitCamelHump(String text) {
         final char[] chars = text.toCharArray();
         final StringBuilder out = new StringBuilder();
         boolean first = true;
         for (char aChar : chars) {
            if (Character.isUpperCase(aChar)) out.append(" ");
            out.append(first ? Character.toUpperCase(aChar) : Character.toLowerCase(aChar));
            first = false;
         }
         return out.toString();
      }

      private String packageToPath(String packageName) {
         return (packageName == null ? "" : (packageName.replaceAll("[.]", "/") + java.io.File.separator));
      }
   }

   public String list(String delimiter, Object... elements) {
      final StringBuilder list = new StringBuilder();
      boolean first = true;
      for (Object element : elements) {
         if (!first) list.append(delimiter);
         list.append(element);
         first = false;
      }
      return list.toString() + delimiter;
   }
}