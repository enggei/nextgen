package com.generator.generators.docker;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'Docker.stg' file<br/>
 */
public final class DockerGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public DockerGroup() {
		this(new STGroupString(stg));
   }

   public DockerGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public DockerGroup(java.io.File templateFile) {
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

	public interface DockerGroupTemplate {

	}

   public RUNExecST newRUNExec() {
      return new RUNExecST(stGroup);
   }

   public ENVSingleST newENVSingle() {
      return new ENVSingleST(stGroup);
   }

   public LABELST newLABEL() {
      return new LABELST(stGroup);
   }

   public RUNShellST newRUNShell() {
      return new RUNShellST(stGroup);
   }

   public COPYST newCOPY() {
      return new COPYST(stGroup);
   }

   public WORKDIRST newWORKDIR() {
      return new WORKDIRST(stGroup);
   }

   public DockerfileST newDockerfile() {
      return new DockerfileST(stGroup);
   }

   public ENVMultiST newENVMulti() {
      return new ENVMultiST(stGroup);
   }

   public final class RUNExecST implements DockerGroupTemplate {

      private java.util.Set<Object> _values = new java.util.LinkedHashSet<>();

      private final ST template;

      private RUNExecST(STGroup group) {
   		template = group.getInstanceOf("RUNExec");
   	}

      public RUNExecST addValuesValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._values.add(value);
      	template.add("values", value);

         return this;
      }

      public java.util.Set<Object> getValuesValues() {
      	return this._values;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class ENVSingleST implements DockerGroupTemplate {

      private Object _name;
      private Object _value;

      private final ST template;

      private ENVSingleST(STGroup group) {
   		template = group.getInstanceOf("ENVSingle");
   	}

      public ENVSingleST setName(Object value) {
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

      public ENVSingleST setValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._value == null) {
            this._value = value;
         	template.add("value", value);
         }

      	return this;
      }

      public String getValue() {
      	return (String) this._value;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class LABELST implements DockerGroupTemplate {

      private Object _name;
      private Object _value;

      private final ST template;

      private LABELST(STGroup group) {
   		template = group.getInstanceOf("LABEL");
   	}

      public LABELST setName(Object value) {
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

      public LABELST setValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._value == null) {
            this._value = value;
         	template.add("value", value);
         }

      	return this;
      }

      public String getValue() {
      	return (String) this._value;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class RUNShellST implements DockerGroupTemplate {

      private Object _command;

      private final ST template;

      private RUNShellST(STGroup group) {
   		template = group.getInstanceOf("RUNShell");
   	}

      public RUNShellST setCommand(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._command == null) {
            this._command = value;
         	template.add("command", value);
         }

      	return this;
      }

      public String getCommand() {
      	return (String) this._command;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class COPYST implements DockerGroupTemplate {

      private Object _dest;
      private java.util.Set<Object> _src = new java.util.LinkedHashSet<>();

      private final ST template;

      private COPYST(STGroup group) {
   		template = group.getInstanceOf("COPY");
   	}

      public COPYST setDest(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._dest == null) {
            this._dest = value;
         	template.add("dest", value);
         }

      	return this;
      }

      public String getDest() {
      	return (String) this._dest;
      }

      public COPYST addSrcValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._src.add(value);
      	template.add("src", value);

         return this;
      }

      public java.util.Set<Object> getSrcValues() {
      	return this._src;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class WORKDIRST implements DockerGroupTemplate {

      private Object _path;

      private final ST template;

      private WORKDIRST(STGroup group) {
   		template = group.getInstanceOf("WORKDIR");
   	}

      public WORKDIRST setPath(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._path == null) {
            this._path = value;
         	template.add("path", value);
         }

      	return this;
      }

      public String getPath() {
      	return (String) this._path;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class DockerfileST implements DockerGroupTemplate {

      private java.util.Set<Object> _entrypoint = new java.util.LinkedHashSet<>();
      private Object _from;
      private java.util.Set<java.util.Map<String, Object>> _instructions = new java.util.LinkedHashSet<>();
      private Object _expose;
      private java.util.Set<Object> _cmd = new java.util.LinkedHashSet<>();

      private final ST template;

      private DockerfileST(STGroup group) {
   		template = group.getInstanceOf("Dockerfile");
   	}

      public DockerfileST addEntrypointValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._entrypoint.add(value);
      	template.add("entrypoint", value);

         return this;
      }

      public java.util.Set<Object> getEntrypointValues() {
      	return this._entrypoint;
      }

      public DockerfileST setFrom(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._from == null) {
            this._from = value;
         	template.add("from", value);
         }

      	return this;
      }

      public String getFrom() {
      	return (String) this._from;
      }

      public DockerfileST addInstructionsValue(Object instruction_, Object comment_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("instruction", (instruction_ == null || instruction_.toString().length() == 0) ? null : instruction_);
      	map.put("comment", (comment_ == null || comment_.toString().length() == 0) ? null : comment_);
      	this._instructions.add(map);

         template.addAggr("instructions.{instruction, comment}", map.get("instruction"), map.get("comment"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getInstructions() {
      	return this._instructions;
      }

      public DockerfileST setExpose(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._expose == null) {
            this._expose = value;
         	template.add("expose", value);
         }

      	return this;
      }

      public String getExpose() {
      	return (String) this._expose;
      }

      public DockerfileST addCmdValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._cmd.add(value);
      	template.add("cmd", value);

         return this;
      }

      public java.util.Set<Object> getCmdValues() {
      	return this._cmd;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class ENVMultiST implements DockerGroupTemplate {

      private java.util.Set<java.util.Map<String, Object>> _values = new java.util.LinkedHashSet<>();

      private final ST template;

      private ENVMultiST(STGroup group) {
   		template = group.getInstanceOf("ENVMulti");
   	}

      public ENVMultiST addValuesValue(Object key_, Object value_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("key", (key_ == null || key_.toString().length() == 0) ? null : key_);
      	map.put("value", (value_ == null || value_.toString().length() == 0) ? null : value_);
      	this._values.add(map);

         template.addAggr("values.{key, value}", map.get("key"), map.get("value"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getValues() {
      	return this._values;
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "DockerGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("RUNExec(values) ::= <<RUN [~values:{it|\"~it~\"};separator=\", \"~]>>\n")
			.append("ENVSingle(name,value) ::= <<ENV ~name~ ~value~>>\n")
			.append("LABEL(name,value) ::= <<LABEL ~name~ = \"~value~\">>\n")
			.append("RUNShell(command) ::= <<// default is /bin/sh -c on Linux or cmd /S /C on Windows\n" + 
		"RUN ~command~>>\n")
			.append("COPY(dest,src) ::= <<COPY [~src:{it|\"~it~\"};separator=\", \"~, \"~dest~\"]>>\n")
			.append("WORKDIR(path) ::= <<WORKDIR ~path~>>\n")
			.append("Dockerfile(entrypoint,from,instructions,expose,cmd) ::= <<~if(from)~FROM ~from~~endif~\n" + 
		"\n" + 
		"~instructions:{it|~if(it.comment)~# ~it.comment~\n" + 
		"~endif~\n" + 
		"~it.instruction~};separator=\"\\n\"~\n" + 
		"~if(expose)~\n" + 
		"\n" + 
		"EXPOSE ~expose~\n" + 
		"~endif~\n" + 
		"~if(entrypoint)~\n" + 
		"\n" + 
		"ENTRYPOINT [~entrypoint:{it|\"~it~\"};separator=\", \"~]\n" + 
		"~endif~\n" + 
		"~if(cmd)~\n" + 
		"\n" + 
		"CMD [~cmd:{it|\"~it~\"};separator=\", \"~]\n" + 
		"~endif~>>\n")
			.append("ENVMulti(values) ::= <<ENV ~values:{it|~it.key~=~it.value~};separator=\" \"~>>\n")
		.toString();
}