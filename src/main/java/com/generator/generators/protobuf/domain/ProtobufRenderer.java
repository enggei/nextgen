package com.generator.generators.protobuf.domain;

import com.generator.generators.protobuf.ProtobufGroup;

import java.io.File;

/**
 * User: goe
 * Date: 23.10.13
 * <p/>
 * Use renderer as prototype for generating derived models from existing ones, and for rendering output. This should be intimately linked with a parser, to be able to parse the rendered output.
 */
final class ProtobufRenderer implements ProtobufEntitiesDefaults.Visitor{

   private final ProtobufGroup group;

   public ProtobufRenderer(File file) {
      this.group = new ProtobufGroup(file);
   }

   @Override
   public void visit(ProtobufPackage protobufPackage) {

      final ProtobufGroup.protobufPackageST st = group.newprotobufPackage();

      st.setPackage(protobufPackage.getPackageName());

      for (ProtobufPackage value : protobufPackage.getImports())
         st.addImportsValue(value.getPackageName());

      for (ProtobufPackageOption value : protobufPackage.getOptions())
         st.addOptionsValue(value.getName(), value.getValue());

      for (ProtobufDeliverable value : protobufPackage.getDeliverables()) {
         switch (value.getDomainType()) {
            case ProtobufEnum:
               st.addDeliverablesValue(render((ProtobufEnum) value));
               break;
            case ProtobufMessage:
               st.addDeliverablesValue(render((ProtobufMessage) value));
               break;
         }
      }

      System.out.println(st.toString());
   }

   public String render(ProtobufMessage value) {
      final ProtobufGroup.messageST st = group.newmessage();
      st.setName(value.getName());
      st.setComments(value.getComment());
      for (ProtobufMessageField messageField : value.getProperties()) {

         // todo update
         //st.addPropertiesValue(messageField.getComment(), messageField.getDefaultValue(), render(messageField.getFieldConstraint()), messageField.getName(), render(messageField.getType()));
      }
      return st.toString();
   }

   public String render(ProtobufFieldConstraint protobufFieldConstraint) {
      return protobufFieldConstraint.getName();
   }

   public String render(ProtobufFieldType type) {
      return type.getName();
   }

   public String render(ProtobufEnum entity) {
      final ProtobufGroup.enumST st = group.newenum();
      st.setName(entity.getName());
      st.setComments(entity.getComment());
      for (ProtobufEnumValue protobufEnumValue : entity.getValues())
         st.addPropertiesValue(render(protobufEnumValue));
      return st.toString();
   }

   private String render(ProtobufEnumValue protobufEnumValue) {
      return protobufEnumValue.getName();
   }


}
