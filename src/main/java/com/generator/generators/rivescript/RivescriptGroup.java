package com.generator.generators.rivescript;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Wraps STGroup-methods based on 'Rivescript.stg' file<br/>
 */
public final class RivescriptGroup {

   private final STGroup stGroup;
   private final char delimiter;

	public RivescriptGroup() {
		this(new STGroupString(stg));
   }

   public RivescriptGroup(STGroup stGroup) {
      this.stGroup = stGroup;
      this.stGroup.registerRenderer(String.class, new DefaultAttributeRenderer());
      this.delimiter = stGroup.delimiterStartChar;
   }

   public RivescriptGroup(java.io.File templateFile) {
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

	public interface RivescriptGroupTemplate {

	}

   public scriptST newscript() {
      return new scriptST(stGroup);
   }

   public definitionST newdefinition() {
      return new definitionST(stGroup);
   }

   public variableST newvariable() {
      return new variableST(stGroup);
   }

   public substitutionST newsubstitution() {
      return new substitutionST(stGroup);
   }

   public triggerST newtrigger() {
      return new triggerST(stGroup);
   }

   public arrayST newarray() {
      return new arrayST(stGroup);
   }

   public previousST newprevious() {
      return new previousST(stGroup);
   }

   public userSetST newuserSet() {
      return new userSetST(stGroup);
   }

   public userGetST newuserGet() {
      return new userGetST(stGroup);
   }

   public topicST newtopic() {
      return new topicST(stGroup);
   }

   public beginST newbegin() {
      return new beginST(stGroup);
   }

   public JavaMacroST newJavaMacro() {
      return new JavaMacroST(stGroup);
   }

   public globalVariableST newglobalVariable() {
      return new globalVariableST(stGroup);
   }

   public personSubstitutionST newpersonSubstitution() {
      return new personSubstitutionST(stGroup);
   }

   public botGetST newbotGet() {
      return new botGetST(stGroup);
   }

   public botSetST newbotSet() {
      return new botSetST(stGroup);
   }

   public globalSetST newglobalSet() {
      return new globalSetST(stGroup);
   }

   public globalGetST newglobalGet() {
      return new globalGetST(stGroup);
   }

   public randomST newrandom() {
      return new randomST(stGroup);
   }

   public callMacroST newcallMacro() {
      return new callMacroST(stGroup);
   }

   public final class scriptST implements RivescriptGroupTemplate {

      private java.util.Set<Object> _comments = new java.util.LinkedHashSet<>();
      private Object _name;
      private java.util.Set<Object> _groups = new java.util.LinkedHashSet<>();
      private Object _version;

      private final ST template;

      private scriptST(STGroup group) {
   		template = group.getInstanceOf("script");
   	}

      public scriptST addCommentsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._comments.add(value);
      	template.add("comments", value);

         return this;
      }

      public java.util.Set<Object> getCommentsValues() {
      	return this._comments;
      }

      public scriptST setName(Object value) {
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

      public scriptST addGroupsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._groups.add(value);
      	template.add("groups", value);

         return this;
      }

      public java.util.Set<Object> getGroupsValues() {
      	return this._groups;
      }

      public scriptST setVersion(Object value) {
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

   public final class definitionST implements RivescriptGroupTemplate {

      private Object _value;

      private final ST template;

      private definitionST(STGroup group) {
   		template = group.getInstanceOf("definition");
   	}

      public definitionST setValue(Object value) {
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

   public final class variableST implements RivescriptGroupTemplate {

      private Object _name;
      private Object _value;

      private final ST template;

      private variableST(STGroup group) {
   		template = group.getInstanceOf("variable");
   	}

      public variableST setName(Object value) {
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

      public variableST setValue(Object value) {
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

   public final class substitutionST implements RivescriptGroupTemplate {

      private Object _input;
      private Object _substitution;

      private final ST template;

      private substitutionST(STGroup group) {
   		template = group.getInstanceOf("substitution");
   	}

      public substitutionST setInput(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._input == null) {
            this._input = value;
         	template.add("input", value);
         }

      	return this;
      }

      public String getInput() {
      	return (String) this._input;
      }

      public substitutionST setSubstitution(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._substitution == null) {
            this._substitution = value;
         	template.add("substitution", value);
         }

      	return this;
      }

      public String getSubstitution() {
      	return (String) this._substitution;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class triggerST implements RivescriptGroupTemplate {

      private java.util.Set<Object> _conditionals = new java.util.LinkedHashSet<>();
      private Object _name;
      private java.util.Set<java.util.Map<String, Object>> _responses = new java.util.LinkedHashSet<>();
      private Object _weight;

      private final ST template;

      private triggerST(STGroup group) {
   		template = group.getInstanceOf("trigger");
   	}

      public triggerST addConditionalsValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._conditionals.add(value);
      	template.add("conditionals", value);

         return this;
      }

      public java.util.Set<Object> getConditionalsValues() {
      	return this._conditionals;
      }

      public triggerST setName(Object value) {
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

      public triggerST addResponsesValue(Object name_, Object topic_, Object weight_) {
      	final java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
      	map.put("name", (name_ == null || name_.toString().length() == 0) ? null : name_);
      	map.put("topic", (topic_ == null || topic_.toString().length() == 0) ? null : topic_);
      	map.put("weight", (weight_ == null || weight_.toString().length() == 0) ? null : weight_);
      	this._responses.add(map);

         template.addAggr("responses.{name, topic, weight}", map.get("name"), map.get("topic"), map.get("weight"));
         return this;
      }

      public java.util.Set<java.util.Map<String, Object>> getResponses() {
      	return this._responses;
      }

      public triggerST setWeight(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._weight == null) {
            this._weight = value;
         	template.add("weight", value);
         }

      	return this;
      }

      public String getWeight() {
      	return (String) this._weight;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class arrayST implements RivescriptGroupTemplate {

      private Object _name;
      private java.util.Set<Object> _values = new java.util.LinkedHashSet<>();

      private final ST template;

      private arrayST(STGroup group) {
   		template = group.getInstanceOf("array");
   	}

      public arrayST setName(Object value) {
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

      public arrayST addValuesValue(Object value) {
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

   public final class previousST implements RivescriptGroupTemplate {

      private Object _value;

      private final ST template;

      private previousST(STGroup group) {
   		template = group.getInstanceOf("previous");
   	}

      public previousST setValue(Object value) {
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

   public final class userSetST implements RivescriptGroupTemplate {

      private Object _value;
      private Object _name;

      private final ST template;

      private userSetST(STGroup group) {
   		template = group.getInstanceOf("userSet");
   	}

      public userSetST setValue(Object value) {
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

      public userSetST setName(Object value) {
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

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class userGetST implements RivescriptGroupTemplate {

      private Object _name;
      private Object _conditional;
      private Object _then;
      private Object _operator;

      private final ST template;

      private userGetST(STGroup group) {
   		template = group.getInstanceOf("userGet");
   	}

      public userGetST setName(Object value) {
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

      public userGetST setConditional(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._conditional == null) {
            this._conditional = value;
         	template.add("conditional", value);
         }

      	return this;
      }

      public String getConditional() {
      	return (String) this._conditional;
      }

      public userGetST setThen(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._then == null) {
            this._then = value;
         	template.add("then", value);
         }

      	return this;
      }

      public String getThen() {
      	return (String) this._then;
      }

      public userGetST setOperator(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._operator == null) {
            this._operator = value;
         	template.add("operator", value);
         }

      	return this;
      }

      public String getOperator() {
      	return (String) this._operator;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class topicST implements RivescriptGroupTemplate {

      private Object _name;
      private java.util.Set<Object> _triggers = new java.util.LinkedHashSet<>();
      private Object _includes;
      private Object _inherits;

      private final ST template;

      private topicST(STGroup group) {
   		template = group.getInstanceOf("topic");
   	}

      public topicST setName(Object value) {
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

      public topicST addTriggersValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._triggers.add(value);
      	template.add("triggers", value);

         return this;
      }

      public java.util.Set<Object> getTriggersValues() {
      	return this._triggers;
      }

      public topicST setIncludes(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._includes == null) {
            this._includes = value;
         	template.add("includes", value);
         }

      	return this;
      }

      public String getIncludes() {
      	return (String) this._includes;
      }

      public topicST setInherits(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._inherits == null) {
            this._inherits = value;
         	template.add("inherits", value);
         }

      	return this;
      }

      public String getInherits() {
      	return (String) this._inherits;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class beginST implements RivescriptGroupTemplate {

      private java.util.Set<Object> _triggers = new java.util.LinkedHashSet<>();

      private final ST template;

      private beginST(STGroup group) {
   		template = group.getInstanceOf("begin");
   	}

      public beginST addTriggersValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._triggers.add(value);
      	template.add("triggers", value);

         return this;
      }

      public java.util.Set<Object> getTriggersValues() {
      	return this._triggers;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class JavaMacroST implements RivescriptGroupTemplate {

      private Object _body;
      private Object _name;
      private Object _package;

      private final ST template;

      private JavaMacroST(STGroup group) {
   		template = group.getInstanceOf("JavaMacro");
   	}

      public JavaMacroST setBody(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._body == null) {
            this._body = value;
         	template.add("body", value);
         }

      	return this;
      }

      public String getBody() {
      	return (String) this._body;
      }

      public JavaMacroST setName(Object value) {
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

      public JavaMacroST setPackage(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._package == null) {
            this._package = value;
         	template.add("package", value);
         }

      	return this;
      }

      public String getPackage() {
      	return (String) this._package;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class globalVariableST implements RivescriptGroupTemplate {

      private Object _name;
      private Object _value;

      private final ST template;

      private globalVariableST(STGroup group) {
   		template = group.getInstanceOf("globalVariable");
   	}

      public globalVariableST setName(Object value) {
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

      public globalVariableST setValue(Object value) {
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

   public final class personSubstitutionST implements RivescriptGroupTemplate {

      private Object _input;
      private Object _substitution;

      private final ST template;

      private personSubstitutionST(STGroup group) {
   		template = group.getInstanceOf("personSubstitution");
   	}

      public personSubstitutionST setInput(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._input == null) {
            this._input = value;
         	template.add("input", value);
         }

      	return this;
      }

      public String getInput() {
      	return (String) this._input;
      }

      public personSubstitutionST setSubstitution(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._substitution == null) {
            this._substitution = value;
         	template.add("substitution", value);
         }

      	return this;
      }

      public String getSubstitution() {
      	return (String) this._substitution;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class botGetST implements RivescriptGroupTemplate {

      private Object _conditional;
      private Object _name;
      private Object _operator;
      private Object _then;

      private final ST template;

      private botGetST(STGroup group) {
   		template = group.getInstanceOf("botGet");
   	}

      public botGetST setConditional(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._conditional == null) {
            this._conditional = value;
         	template.add("conditional", value);
         }

      	return this;
      }

      public String getConditional() {
      	return (String) this._conditional;
      }

      public botGetST setName(Object value) {
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

      public botGetST setOperator(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._operator == null) {
            this._operator = value;
         	template.add("operator", value);
         }

      	return this;
      }

      public String getOperator() {
      	return (String) this._operator;
      }

      public botGetST setThen(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._then == null) {
            this._then = value;
         	template.add("then", value);
         }

      	return this;
      }

      public String getThen() {
      	return (String) this._then;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class botSetST implements RivescriptGroupTemplate {

      private Object _name;
      private Object _value;

      private final ST template;

      private botSetST(STGroup group) {
   		template = group.getInstanceOf("botSet");
   	}

      public botSetST setName(Object value) {
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

      public botSetST setValue(Object value) {
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

   public final class globalSetST implements RivescriptGroupTemplate {

      private Object _name;
      private Object _value;

      private final ST template;

      private globalSetST(STGroup group) {
   		template = group.getInstanceOf("globalSet");
   	}

      public globalSetST setName(Object value) {
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

      public globalSetST setValue(Object value) {
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

   public final class globalGetST implements RivescriptGroupTemplate {

      private Object _conditional;
      private Object _name;
      private Object _operator;
      private Object _then;

      private final ST template;

      private globalGetST(STGroup group) {
   		template = group.getInstanceOf("globalGet");
   	}

      public globalGetST setConditional(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._conditional == null) {
            this._conditional = value;
         	template.add("conditional", value);
         }

      	return this;
      }

      public String getConditional() {
      	return (String) this._conditional;
      }

      public globalGetST setName(Object value) {
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

      public globalGetST setOperator(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._operator == null) {
            this._operator = value;
         	template.add("operator", value);
         }

      	return this;
      }

      public String getOperator() {
      	return (String) this._operator;
      }

      public globalGetST setThen(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	if (this._then == null) {
            this._then = value;
         	template.add("then", value);
         }

      	return this;
      }

      public String getThen() {
      	return (String) this._then;
      }

      @Override
   	public String toString() {
   		return template.render();
   	}
   }

   public final class randomST implements RivescriptGroupTemplate {

      private java.util.Set<Object> _values = new java.util.LinkedHashSet<>();

      private final ST template;

      private randomST(STGroup group) {
   		template = group.getInstanceOf("random");
   	}

      public randomST addValuesValue(Object value) {
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

   public final class callMacroST implements RivescriptGroupTemplate {

      private Object _name;
      private java.util.Set<Object> _parameters = new java.util.LinkedHashSet<>();

      private final ST template;

      private callMacroST(STGroup group) {
   		template = group.getInstanceOf("callMacro");
   	}

      public callMacroST setName(Object value) {
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

      public callMacroST addParametersValue(Object value) {
      	if (value == null || value.toString().length() == 0)
         	return this;

      	this._parameters.add(value);
      	template.add("parameters", value);

         return this;
      }

      public java.util.Set<Object> getParametersValues() {
      	return this._parameters;
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
		final java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.FileWriter(new java.io.File(dir, "RivescriptGroup.stg")));
		out.write(stg);
		out.close();
   }

	private static final String stg = new StringBuilder("delimiters \"~\", \"~\"\n")
		.append("eom() ::= <<}>>\n")
		.append("gt() ::= \">\"\n")
			.append("script(comments,name,groups,version) ::= <<! ~version~\n" + 
		"\n" + 
		"// ~name;format=\"toUpper\"~\n" + 
		"~comments:{it|// ~it~};separator=\"\\n\"~\n" + 
		"\n" + 
		"~groups:{it|\n" + 
		"~it~\n" + 
		"};separator=\"\\n\"~>>\n")
			.append("definition(value) ::= <<! ~value~>>\n")
			.append("variable(name,value) ::= <<! var ~name~ = ~value~>>\n")
			.append("substitution(input,substitution) ::= <<! sub ~input;format=\"toLower\"~ = ~substitution;format=\"toLower\"~>>\n")
			.append("trigger(conditionals,name,responses,weight) ::= <<+ ~name;format=\"toLower\"~~if(weight)~{weight=~weight~}~endif~\n" + 
		"~conditionals:{it|* ~src~ ~operator~ ~dst~ => ~then~ };separator=\"\\n\"~\n" + 
		"~responses:{it|- ~it.name;format=\"toLower\"~~if(it.weight)~{weight=~it.weight~~eom()~~endif~~if(it.topic)~{topic=~it.name~~eom()~~endif~};separator=\"\\n\"~>>\n")
			.append("array(name,values) ::= <<! array ~name~ = ~values:{it|~it~};separator=\" \"~>>\n")
			.append("previous(value) ::= <<% ~value~>>\n")
			.append("userSet(value,name) ::= <<<set ~name~=<~value~>~eot()~>>\n")
			.append("userGet(name,conditional,then,operator) ::= <<<get ~name~>~if(conditional)~ ~operator~ ~conditional~ => ~then~~endif~>>\n")
			.append("topic(name,triggers,includes,inherits) ::= <<> topic ~name~~if(inherits)~ inherits ~inherits~~endif~~if(includes)~ includes ~includes~~endif~\n" + 
		"\n" + 
		"	~triggers:{it|~it~};separator=\"\\n\"~\n" + 
		"  \n" + 
		"< topic>>\n")
			.append("begin(triggers) ::= <<> begin\n" + 
		"\n" + 
		"  ~triggers:{it|~it~};separator=\"\\n\"~\n" + 
		"\n" + 
		"< begin>>\n")
			.append("JavaMacro(body,name,package) ::= <<package ~package~;\n" + 
		"\n" + 
		"import com.rivescript.macro.Subroutine;\n" + 
		"import com.rivescript.util.StringUtils;\n" + 
		"\n" + 
		"import java.lang.String;\n" + 
		"import java.lang.StringBuilder;\n" + 
		"\n" + 
		"public class ~name~ implements Subroutine {\n" + 
		"	\n" + 
		"	public String call (com.rivescript.RiveScript rs, String[] args) {\n" + 
		"		~body~\n" + 
		"	}\n" + 
		"}>>\n")
			.append("globalVariable(name,value) ::= <<! global ~name~ = ~value~>>\n")
			.append("personSubstitution(input,substitution) ::= <<! person ~input;format=\"toLower\"~ = ~substitution;format=\"toLower\"~>>\n")
			.append("botGet(conditional,name,operator,then) ::= <<<bot ~name~>~if(conditional)~ ~operator~ ~conditional~ => ~then~~endif~>>\n")
			.append("botSet(name,value) ::= <<<bot ~name~=<~value~>~eot()~>>\n")
			.append("globalSet(name,value) ::= <<<env ~name~=<~value~>~eot()~>>\n")
			.append("globalGet(conditional,name,operator,then) ::= <<<env ~name~>~if(conditional)~ ~operator~ ~conditional~ => ~then~~endif~>>\n")
			.append("random(values) ::= <<{random}~values:{it|~it~};separator=\"|\"~{/random}>>\n")
			.append("callMacro(name,parameters) ::= <<<call>~name~~parameters:{it|~it~};separator=\" \"~</call> >>\n")
		.toString();
}