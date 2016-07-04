package com.generator.generators.knockout;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'KnockoutGroup.stg' file<br/>
 */
public final class KnockoutGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public KnockoutGroup() {

		final String generatorPath = System.getProperty("generator.path");

		if (generatorPath != null) {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(generatorPath + java.io.File.separator + "knockout" + java.io.File.separator + "knockout.stg");
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		} else {
			this.stGroup = new org.stringtemplate.v4.STGroupFile(KnockoutGroup.class.getResource("/com/generator/generators/knockout/knockout.stg"), "UTF-8", '~', '~');
			this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
			this.delimiter = stGroup.delimiterStartChar;
		}

		//this(new org.stringtemplate.v4.STGroupFile(System.getProperty("generator.path") + java.io.File.separator + "knockout" + java.io.File.separator + "knockout.stg"));
   }

   public KnockoutGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public KnockoutGroup(java.io.File templateFile) {
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


   public applyBindingsST newapplyBindings() {
      return new applyBindingsST(stGroup);
   } 


   public computedST newcomputed() {
      return new computedST(stGroup);
   } 


   public kvST newkv() {
      return new kvST(stGroup);
   } 


   public observableST newobservable() {
      return new observableST(stGroup);
   } 


   public observableArrayST newobservableArray() {
      return new observableArrayST(stGroup);
   } 


   public observableViewST newobservableView() {
      return new observableViewST(stGroup);
   } 


   public rowST newrow() {
      return new rowST(stGroup);
   } 


   public viewModelST newviewModel() {
      return new viewModelST(stGroup);
   } 

    public final class applyBindingsST {

      private final AtomicBoolean viewsIsSet = new AtomicBoolean(false);
      private final ST template;

      private applyBindingsST(STGroup group) {
   		template = group.getInstanceOf("applyBindings");
   	}

      public applyBindingsST addViewsValue(Object value) {
      	tryToSetListProperty(template, value, viewsIsSet, "views");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class computedST {

      private final AtomicBoolean computedIsSet = new AtomicBoolean(false);
      private final ST template;

      private computedST(STGroup group) {
   		template = group.getInstanceOf("computed");
   	}

       public computedST setComputed(Object value) {
      	tryToSetStringProperty(template, value, computedIsSet, "computed");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class kvST {

      private final AtomicBoolean nameIsSet = new AtomicBoolean(false);
      private final AtomicBoolean valueIsSet = new AtomicBoolean(false);
      private final ST template;

      private kvST(STGroup group) {
   		template = group.getInstanceOf("kv");
   	}

       public kvST setName(Object value) {
      	tryToSetStringProperty(template, value, nameIsSet, "name");   
         return this;
      } 
       public kvST setValue(Object value) {
      	tryToSetStringProperty(template, value, valueIsSet, "value");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class observableST {

      private final AtomicBoolean initIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final ST template;

      private observableST(STGroup group) {
   		template = group.getInstanceOf("observable");
   	}

       public observableST setInit(Object value) {
      	tryToSetStringProperty(template, value, initIsSet, "init");   
         return this;
      } 
       public observableST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class observableArrayST {

      private final AtomicBoolean initIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final ST template;

      private observableArrayST(STGroup group) {
   		template = group.getInstanceOf("observableArray");
   	}

       public observableArrayST setInit(Object value) {
      	tryToSetStringProperty(template, value, initIsSet, "init");   
         return this;
      } 
       public observableArrayST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class observableViewST {

      private final AtomicBoolean attributesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean computedIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final ST template;

      private observableViewST(STGroup group) {
   		template = group.getInstanceOf("observableView");
   	}

      public observableViewST addAttributesValue(Object array_, Object reference_, Object value_) {
         attributesIsSet.set(true);
         template.addAggr("attributes.{array, reference, value}", ( (array_==null || array_.toString().length()==0) ? null : array_), ( (reference_==null || reference_.toString().length()==0) ? null : reference_), ( (value_==null || value_.toString().length()==0) ? null : value_));
         return this;
      }
      public observableViewST addComputedValue(Object computed_, Object reference_) {
         computedIsSet.set(true);
         template.addAggr("computed.{computed, reference}", ( (computed_==null || computed_.toString().length()==0) ? null : computed_), ( (reference_==null || reference_.toString().length()==0) ? null : reference_));
         return this;
      }
       public observableViewST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
         return this;
      } 

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class rowST {

      private final AtomicBoolean valuesIsSet = new AtomicBoolean(false);
      private final ST template;

      private rowST(STGroup group) {
   		template = group.getInstanceOf("row");
   	}

      public rowST addValuesValue(Object value) {
      	tryToSetListProperty(template, value, valuesIsSet, "values");
         return this;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   } 

    public final class viewModelST {

      private final AtomicBoolean observablesIsSet = new AtomicBoolean(false);
      private final AtomicBoolean referenceIsSet = new AtomicBoolean(false);
      private final ST template;

      private viewModelST(STGroup group) {
   		template = group.getInstanceOf("viewModel");
   	}

      public viewModelST addObservablesValue(Object declaration_) {
         observablesIsSet.set(true);
         template.addAggr("observables.{declaration}", ( (declaration_==null || declaration_.toString().length()==0) ? null : declaration_));
         return this;
      }
       public viewModelST setReference(Object value) {
      	tryToSetStringProperty(template, value, referenceIsSet, "reference");   
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