package com.generator.generators.npm;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'Npm.stg' file<br/>
 */
public final class NpmGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public NpmGroup() {
		this(new STGroupString(stg));
   }

   public NpmGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public NpmGroup(java.io.File templateFile) {
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

	public interface NpmGroupTemplate {

	}

   public webpackConfigST newwebpackConfig() {
      return new webpackConfigST(stGroup);
   }

   public packageJsonST newpackageJson() {
      return new packageJsonST(stGroup);
   }

   public final class webpackConfigST implements NpmGroupTemplate {

      private Object _entry;

      private final ST template;

      private webpackConfigST(STGroup group) {
   		template = group.getInstanceOf("webpackConfig");
   	}

      public webpackConfigST setEntry(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._entry == null) {
            this._entry = value;
         	template.add("entry", value);
         }

      	return this;
      }

      public String getEntry() {
      	return (String) this._entry;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class packageJsonST implements NpmGroupTemplate {

      private Object _description;
      private Object _main;
      private Object _gitRepository;
      private Object _author;
      private Object _name;
      private Object _version;

      private final ST template;

      private packageJsonST(STGroup group) {
   		template = group.getInstanceOf("packageJson");
   	}

      public packageJsonST setDescription(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._description == null) {
            this._description = value;
         	template.add("description", value);
         }

      	return this;
      }

      public String getDescription() {
      	return (String) this._description;
      }

      public packageJsonST setMain(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._main == null) {
            this._main = value;
         	template.add("main", value);
         }

      	return this;
      }

      public String getMain() {
      	return (String) this._main;
      }

      public packageJsonST setGitRepository(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._gitRepository == null) {
            this._gitRepository = value;
         	template.add("gitRepository", value);
         }

      	return this;
      }

      public String getGitRepository() {
      	return (String) this._gitRepository;
      }

      public packageJsonST setAuthor(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._author == null) {
            this._author = value;
         	template.add("author", value);
         }

      	return this;
      }

      public String getAuthor() {
      	return (String) this._author;
      }

      public packageJsonST setName(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._name == null) {
            this._name = value;
         	template.add("name", value);
         }

      	return this;
      }

      public String getName() {
      	return (String) this._name;
      }

      public packageJsonST setVersion(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._version == null) {
            this._version = value;
         	template.add("version", value);
         }

      	return this;
      }

      public String getVersion() {
      	return (String) this._version;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
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

	public static void toSTGFile(java.io.File dir) throws java.io.IOException {
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "NpmGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("webpackConfig(entry) ::= <<var webpack = require('webpack');\n" + 
		"var path = require('path');\n" + 
		"\n" + 
		"var BUILD_DIR = path.resolve(__dirname, 'target/web/');\n" + 
		"var APP_DIR = path.resolve(__dirname, 'src/main/web/');\n" + 
		"\n" + 
		"var config = {\n" + 
		"  entry: APP_DIR + '/~if(entry)~~entry~~else~index.js~endif~',\n" + 
		"  output: {\n" + 
		"    path: BUILD_DIR,\n" + 
		"    filename: 'app.js'\n" + 
		"  },\n" + 
		"  module : {\n" + 
		"      loaders : [\n" + 
		"        {\n" + 
		"          test : /\\.jsx?/,\n" + 
		"          include : APP_DIR,\n" + 
		"          loader : 'babel-loader',\n" + 
		"          query: {\n" + 
		"            presets: ['es2015', 'react'],\n" + 
		"            plugins: ['transform-object-rest-spread', 'transform-decorators-legacy', 'transform-class-properties']\n" + 
		"          }\n" + 
		"        },\n" + 
		"        {\n" + 
		"            test: /\\.css$/,\n" + 
		"            use: ['style-loader', 'css-loader']\n" + 
		"        },\n" + 
		"        {\n" + 
		"            test: /\\.(woff|woff2|eot|ttf|otf)$/,\n" + 
		"            loader: \"file-loader\"\n" + 
		"        }\n" + 
		"      ]\n" + 
		"    }\n" + 
		"};\n" + 
		"\n" + 
		"new webpack.DefinePlugin({\n" + 
		"  'process.env': {\n" + 
		"    NODE_ENV: JSON.stringify('production')\n" + 
		"  }\n" + 
		"}),\n" + 
		"new webpack.optimize.UglifyJsPlugin()\n" + 
		"\n" + 
		"module.exports = config;>>\n")
			.append("packageJson(description,main,gitRepository,author,name,version) ::= <<{\n" + 
		"  \"name\": \"~name~\",\n" + 
		"  \"version\": \"~version~\",\n" + 
		"  \"description\": \"~description~\",\n" + 
		"  \"main\": \"~if(main)~~main~~else~index.js~endif~\",\n" + 
		"  \"scripts\": {\n" + 
		"    \"dev\": \"webpack -d --watch\",\n" + 
		"    \"live\": \"webpack -p\"\n" + 
		"  },\n" + 
		"~if(gitRepository)~\n" + 
		"  \"repository\": {\n" + 
		"    \"type\": \"git\",\n" + 
		"    \"url\": \"~gitRepository~\"\n" + 
		"  },\n" + 
		"~endif~\n" + 
		"  \"author\": \"~author~\",\n" + 
		"  \"license\": \"ISC\"\n" + 
		"}>>\n")
		.toString();
}