package com.generator.generators.protobuf.domain;

import com.generator.generators.templates.domain.*;

import java.util.List;
import java.util.UUID;

/**
 * Wraps Statement-methods based on 'Protobuf.stg' file<br/>
 */
public final class Protobuf {

   public Protobuf() {
   }

   public enumStatement newenumStatement() {
      return new enumStatement();
   }

   public extendStatement newextendStatement() {
      return new extendStatement();
   }

   public extensionsStatement newextensionsStatement() {
      return new extensionsStatement();
   }

   public messageStatement newmessageStatement() {
      return new messageStatement();
   }

   public messageFieldStatement newmessageFieldStatement() {
      return new messageFieldStatement();
   }

   public protobufPackageStatement newprotobufPackageStatement() {
      return new protobufPackageStatement();
   }

   public final class enumStatement extends Statement {

      public enumStatement() {
         super("enum");
   	}

      public enumStatement(UUID uuid, List<Property> properties) {
         super(uuid, "enum", properties);
   	}

      public enumStatement setComments(Object value_) {
         StringProperty property = getStringProperty("comments");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("comments", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }

      public enumStatement setName(Object value_) {
         StringProperty property = getStringProperty("name");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("name", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }

      public enumStatement addPropertiesElement(Object element) {
         ListProperty property = getListProperty("properties");

         if (property == null) {
            if (element == null) return this;   //no need to add it if element is null
            property = new ListProperty("properties");
            add(property);
         }

         property.add(new StringProperty(element.toString()));

         return this;
      }
   }

   public final class extendStatement extends Statement {

      public extendStatement() {
         super("extend");
   	}

      public extendStatement(UUID uuid, List<Property> properties) {
         super(uuid, "extend", properties);
   	}

      public extendStatement setComments(Object value_) {
         StringProperty property = getStringProperty("comments");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("comments", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }

      public extendStatement setName(Object value_) {
         StringProperty property = getStringProperty("name");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("name", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }

      public extendStatement addPropertiesElement(Object element) {
         ListProperty property = getListProperty("properties");

         if (property == null) {
            if (element == null) return this;   //no need to add it if element is null
            property = new ListProperty("properties");
            add(property);
         }

         property.add(new StringProperty(element.toString()));

         return this;
      }
   }

   public final class extensionsStatement extends Statement {

      public extensionsStatement() {
         super("extensions");
   	}

      public extensionsStatement(UUID uuid, List<Property> properties) {
         super(uuid, "extensions", properties);
   	}

      public extensionsStatement setMax(Object value_) {
         StringProperty property = getStringProperty("max");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("max", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }

      public extensionsStatement setMin(Object value_) {
         StringProperty property = getStringProperty("min");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("min", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }
   }

   public final class messageStatement extends Statement {

      public messageStatement() {
         super("message");
   	}

      public messageStatement(UUID uuid, List<Property> properties) {
         super(uuid, "message", properties);
   	}

      public messageStatement setComments(Object value_) {
         StringProperty property = getStringProperty("comments");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("comments", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }

      public messageStatement setName(Object value_) {
         StringProperty property = getStringProperty("name");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("name", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }

      public messageStatement setParent(Object value_) {
         StringProperty property = getStringProperty("parent");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("parent", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }

      public messageStatement addPropertiesElement(Object element) {
         ListProperty property = getListProperty("properties");

         if (property == null) {
            if (element == null) return this;   //no need to add it if element is null
            property = new ListProperty("properties");
            add(property);
         }

         property.add(new StringProperty(element.toString()));

         return this;
      }
   }

   public final class messageFieldStatement extends Statement {

      public messageFieldStatement() {
         super("messageField");
   	}

      public messageFieldStatement(UUID uuid, List<Property> properties) {
         super(uuid, "messageField", properties);
   	}

      public messageFieldStatement setComments(Object value_) {
         StringProperty property = getStringProperty("comments");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("comments", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }

      public messageFieldStatement setDefaultValue(Object value_) {
         StringProperty property = getStringProperty("defaultValue");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("defaultValue", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }

      public messageFieldStatement setFieldConstraint(Object value_) {
         StringProperty property = getStringProperty("fieldConstraint");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("fieldConstraint", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }

      public messageFieldStatement setName(Object value_) {
         StringProperty property = getStringProperty("name");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("name", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }

      public messageFieldStatement setOrdinal(Object value_) {
         StringProperty property = getStringProperty("ordinal");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("ordinal", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }

      public messageFieldStatement setType(Object value_) {
         StringProperty property = getStringProperty("type");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("type", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }
   }

   public final class protobufPackageStatement extends Statement {

      public protobufPackageStatement() {
         super("protobufPackage");
   	}

      public protobufPackageStatement(UUID uuid, List<Property> properties) {
         super(uuid, "protobufPackage", properties);
   	}

      public protobufPackageStatement addDeliverablesElement(Object element) {
         ListProperty property = getListProperty("deliverables");

         if (property == null) {
            if (element == null) return this;   //no need to add it if element is null
            property = new ListProperty("deliverables");
            add(property);
         }

         property.add(new StringProperty(element.toString()));

         return this;
      }

      public protobufPackageStatement addImportsElement(Object element) {
         ListProperty property = getListProperty("imports");

         if (property == null) {
            if (element == null) return this;   //no need to add it if element is null
            property = new ListProperty("imports");
            add(property);
         }

         property.add(new StringProperty(element.toString()));

         return this;
      }

      public protobufPackageStatement addOptionsValues(Object name_, Object value_) {
         final PropertySet propertySet = new PropertySet();

         if (name_ != null) propertySet.add(new StringProperty("name", name_.toString()));
         if (value_ != null) propertySet.add(new StringProperty("value", value_.toString()));

         KeyValueListProperty kvProperty = getKeyValueListProperty("options");
         if (kvProperty == null) {
            kvProperty = new KeyValueListProperty("options");
            add(kvProperty);
         }

         kvProperty.addPropertySet(propertySet);
         return this;
      }

      public protobufPackageStatement setPackage(Object value_) {
         StringProperty property = getStringProperty("package");

         if (property == null) {
            if (value_ == null) return this; // no need to add it if its null
            add(new StringProperty("package", value_.toString()));
         } else {
            if (value_ == null) this.removeProperty(property.getUuid());   // if null- remove it
            else property.setValue(value_.toString());   // else, update its value
         }

         return this;
      }
   }
}