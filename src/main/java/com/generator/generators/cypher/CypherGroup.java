package com.generator.generators.cypher;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'CypherGroup.stg' file<br/>
 */
public final class CypherGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public CypherGroup() {

		final String generatorPath = System.getProperty("generator.path");

		if (generatorPath != null) {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "cypher" + java.io.File.separator + "cypher.stg");
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		} else {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(CypherGroup.class.getResource("/com/generator/generators/cypher/cypher.stg"), "UTF-8", '~', '~');
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		}

		//this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "cypher" + java.io.File.separator + "cypher.stg"));
   }

   public CypherGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public CypherGroup(java.io.File templateFile) {
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


   public createNodeST newcreateNode() {
      return new createNodeST(stGroup);
   } 


   public createNodesST newcreateNodes() {
      return new createNodesST(stGroup);
   } 


   public createRelationshipST newcreateRelationship() {
      return new createRelationshipST(stGroup);
   } 


   public createRelationshipsST newcreateRelationships() {
      return new createRelationshipsST(stGroup);
   } 


   public matchLabelST newmatchLabel() {
      return new matchLabelST(stGroup);
   } 


   public queryST newquery() {
      return new queryST(stGroup);
   } 


   public stringPropertyST newstringProperty() {
      return new stringPropertyST(stGroup);
   } 


   public valuePropertyST newvalueProperty() {
      return new valuePropertyST(stGroup);
   } 

    public final class createNodeST {

      private final AtomicBoolean idIsSet = new AtomicBoolean(false);
      private final AtomicBoolean labelsIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final ST template;

      private createNodeST(STGroup group) {
   		template = group.getInstanceOf("createNode");
   	}

       public createNodeST setId(Object value) {
      	tryToSetStringProperty(template, value, idIsSet, "id");   
         return this;
      } 
      public createNodeST addLabelsValue(Object value) {
      	tryToSetListProperty(template, value, labelsIsSet, "labels");
         return this;
      }
      public createNodeST addPropertiesValue(Object value) {
      	tryToSetListProperty(template, value, propertiesIsSet, "properties");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class createNodesST {

      private final AtomicBoolean nodesIsSet = new AtomicBoolean(false);
      private final ST template;

      private createNodesST(STGroup group) {
   		template = group.getInstanceOf("createNodes");
   	}

      public createNodesST addNodesValue(Object value) {
      	tryToSetListProperty(template, value, nodesIsSet, "nodes");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class createRelationshipST {

      private final AtomicBoolean dstIsSet = new AtomicBoolean(false);
      private final AtomicBoolean propertiesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean srcIsSet = new AtomicBoolean(false);
      private final AtomicBoolean typeIsSet = new AtomicBoolean(false);
      private final ST template;

      private createRelationshipST(STGroup group) {
   		template = group.getInstanceOf("createRelationship");
   	}

       public createRelationshipST setDst(Object value) {
      	tryToSetStringProperty(template, value, dstIsSet, "dst");   
         return this;
      } 
      public createRelationshipST addPropertiesValue(Object value) {
      	tryToSetListProperty(template, value, propertiesIsSet, "properties");
         return this;
      }
       public createRelationshipST setSrc(Object value) {
      	tryToSetStringProperty(template, value, srcIsSet, "src");   
         return this;
      } 
       public createRelationshipST setType(Object value) {
      	tryToSetStringProperty(template, value, typeIsSet, "type");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class createRelationshipsST {

      private final AtomicBoolean relationshipsIsSet = new AtomicBoolean(false);
      private final ST template;

      private createRelationshipsST(STGroup group) {
   		template = group.getInstanceOf("createRelationships");
   	}

      public createRelationshipsST addRelationshipsValue(Object value) {
      	tryToSetListProperty(template, value, relationshipsIsSet, "relationships");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class matchLabelST {

      private final AtomicBoolean labelIsSet = new AtomicBoolean(false);
      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final ST template;

      private matchLabelST(STGroup group) {
   		template = group.getInstanceOf("matchLabel");
   	}

       public matchLabelST setLabel(Object value) {
      	tryToSetStringProperty(template, value, labelIsSet, "label");   
         return this;
      } 
       public matchLabelST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class queryST {

      private final AtomicBoolean matchIsSet = new AtomicBoolean(false);
      private final AtomicBoolean returnIsSet = new AtomicBoolean(false);
      private final AtomicBoolean whereIsSet = new AtomicBoolean(false);
      private final ST template;

      private queryST(STGroup group) {
   		template = group.getInstanceOf("query");
   	}

       public queryST setMatch(Object value) {
      	tryToSetStringProperty(template, value, matchIsSet, "match");   
         return this;
      } 
       public queryST setReturn(Object value) {
      	tryToSetStringProperty(template, value, returnIsSet, "return");   
         return this;
      } 
       public queryST setWhere(Object value) {
      	tryToSetStringProperty(template, value, whereIsSet, "where");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class stringPropertyST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private stringPropertyST(STGroup group) {
   		template = group.getInstanceOf("stringProperty");
   	}

       public stringPropertyST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public stringPropertyST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class valuePropertyST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private valuePropertyST(STGroup group) {
   		template = group.getInstanceOf("valueProperty");
   	}

       public valuePropertyST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public valuePropertyST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
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