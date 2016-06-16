package com.generator.generators;

import com.generator.generators.templates.domain.*;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.misc.ErrorType;
import org.stringtemplate.v4.misc.STMessage;

import java.io.File;
import java.util.*;

/**
 * User: geirove
 * Date: 07.01.12
 */
public final class STGenerator<T extends Statement> {

   private static final DefaultAttributeRenderer defaultAttributeRenderer = new DefaultAttributeRenderer();

   private final STGroupFile groupFile;
   private final STErrorListener errorListener;

   public STGenerator(STGroupFile groupFile) {
      this.groupFile = groupFile;
      this.errorListener = null;
      groupFile.registerRenderer(String.class, defaultAttributeRenderer);
   }

   public STGenerator(STGroupFile groupFile, STErrorListener errorListener) {
      this.groupFile = groupFile;
      this.groupFile.setListener(this.errorListener = errorListener);
      groupFile.registerRenderer(String.class, defaultAttributeRenderer);
   }

   public STGenerator(String groupFile) {
      this(getTemplateGroup(groupFile));
   }

   public STGenerator(File templateFile) {
      this(templateFile.getAbsolutePath());
   }

   public static STGroupFile getTemplateGroup(String template) {
      final STGroupFile groupFile = new STGroupFile(template);
      groupFile.registerRenderer(String.class, defaultAttributeRenderer);
      return groupFile;
   }

   public String generate(T statement) {
      return render(statement);
   }

   private String render(Statement statement) {
      final ST template = createSTFrom(statement);
      return template == null ? "" : template.render();
   }

   private ST createSTFrom(Statement statement) {
      return createSTFrom(statement, groupFile);
   }

   public ST createSTFrom(Statement statement, STGroupFile groupFile) {
      final ST template = groupFile.getInstanceOf(statement.getStatementName());
      if (template == null) {
         final IllegalArgumentException cause = new IllegalArgumentException("template '" + statement.getStatementName() + "' is not found in " + groupFile.fileName);
         if (errorListener != null) {
            errorListener.IOError(new STMessage(ErrorType.INVALID_TEMPLATE_NAME, null, cause, statement.getStatementName()));
            return null;
         } else {
            throw cause;
         }
      }
      fill(template, statement.getProperties(), null, groupFile);
      return template;
   }

   public void fill(ST template, List<Property> properties, String propertyName, STGroupFile groupFile) {

      if (properties == null) return;
      for (Property property : properties) {
         try {
            if (property instanceof StringProperty) {
               template.add(property.getPropertyName() == null ? propertyName : property.getPropertyName(), ((StringProperty) property).getValue());
            } else if (property instanceof BooleanProperty) {
               final Boolean value = ((BooleanProperty) property).getValue();
               if (value != null && value)
                  template.add(property.getPropertyName() == null ? propertyName : property.getPropertyName(), true);
            } else if (property instanceof StatementProperty) {
               template.add(property.getPropertyName() == null ? propertyName : property.getPropertyName(), createSTFrom(((StatementProperty) property).getStatement(), groupFile).render());
            } else if (property instanceof ListProperty) {
               fill(template, ((ListProperty) property).getElements(), property.getPropertyName(), groupFile);
            } else if (property instanceof KeyValueListProperty) {
               for (List<Property> kvProperty : ((KeyValueListProperty) property).getElements()) {
                  final KeyedValue aggregate = new KeyedValue(property.getPropertyName());
                  fill(aggregate, kvProperty, groupFile);
                  aggregate.addToTemplate(template);
               }
            }
         } catch (Exception e) {
            if (e.getMessage().contains("no such attribute:")) {
               System.out.print(e.getMessage() + " in template '" + template.getName() + "'. ignoring\n");
            } else
               throw new IllegalArgumentException(" '" + template.getName() + "' : " + e.getMessage());
         }
      }
   }

   private void fill(KeyedValue aggregate, List<Property> properties, STGroupFile groupFile) {
      for (Property property : properties) {
         if (property instanceof StringProperty) {
            aggregate.add(property.getPropertyName(), ((StringProperty) property).getValue());
         } else if (property instanceof BooleanProperty) {
            final Boolean value = ((BooleanProperty) property).getValue();
            if (value != null && value)
               aggregate.add(property.getPropertyName(), true);
         } else if (property instanceof StatementProperty) {
            aggregate.add(property.getPropertyName(), createSTFrom(((StatementProperty) property).getStatement(), groupFile).render());
         } else {
            System.out.println("ignoring " + aggregate.getName() + ".'" + property.getPropertyName() + "': cannot have a list of values in StringTemplate-output. Only one value can be assigned to a key in a key/value list in StringTemplate.");
         }
      }
   }

   public static final class KeyedValue {

      private final String name;
      private final List<Map<String, String>> values = new LinkedList<>();
      private int index = 0;

      public KeyedValue(String name) {
         this.name = name;
      }

      public String getName() {
         return name;
      }

      public void add(String key, Object value) {
         if (value == null || value.toString().length() == 0) return;
         if (values.size() < (index + 1)) values.add(new HashMap<>());
         values.get(index).put(key, value.toString());
      }

      public void addToTemplate(ST template) {
         for (Map<String, String> value : values) {
            boolean first = true;
            final StringBuilder keyName = new StringBuilder(name + ".{");

            final List<String> keys = new ArrayList<>(value.keySet());
            for (String key : keys) {
               if (!first) keyName.append(",");
               keyName.append(key);
               first = false;
            }
            keyName.append("}");

            final Object[] values = new Object[keys.size()];
            for (int i = 0; i < keys.size(); i++)
               values[i] = value.get(keys.get(i));
            template.addAggr(keyName.toString(), values);
         }
      }
   }
}