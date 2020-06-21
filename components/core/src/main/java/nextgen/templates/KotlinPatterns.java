package nextgen.templates;

import nextgen.templates.kotlin.*;

import java.util.List;
import java.util.stream.Collectors;

public class KotlinPatterns extends KotlinST {

   public static Expression asThisExpression(FieldDeclaration fieldDeclaration) {
      return newThisExpression().setExpression(newVarExpression().setVarname(fieldDeclaration.getName()));
   }

   public static Expression asScopeExpression(String scope, FieldDeclaration fieldDeclaration) {
      return newScopeExpression().setScope(scope).setExpression(newVarExpression().setVarname(fieldDeclaration.getName()));
   }

   public static OverrideEquals createEqualsFunction(String className, List<FieldDeclaration> fields) {
      return newOverrideEquals()
         .setClassName(className)
         .setFields(fields.stream()
            .map(fieldDeclaration -> {
               if (fieldDeclaration.getType().getClass().getSimpleName().equals("ArrayType")) {
                  return newArrayEqualsExpression()
                     .setLeftArray(asThisExpression(fieldDeclaration))
                     .setRightArray(asScopeExpression("other", fieldDeclaration));
               } else {
                  return newEqualsExpression().setLhs(asThisExpression(fieldDeclaration)).setRhs(asScopeExpression("other", fieldDeclaration));
               }
            })
            .filter(name -> !name.equals("id"))
            .collect(Collectors.toList()));
   }

   public static OverrideToString createToStringFunction(String className, List<FieldDeclaration> fields) {
      return newOverrideToString()
         .setClassName(className)
         .setFields(fields.stream()
            .map(FieldDeclaration::getName)
            .collect(Collectors.toList()));
   }

   public static FieldDeclaration newFieldDeclaration(TypeDeclaration typeDeclaration, String name) {
      return newFieldDeclaration(typeDeclaration, name, false);
   }

   public static FieldDeclaration newFieldDeclaration(TypeDeclaration typeDeclaration, String name, Boolean mutable) {
      return newFieldDeclaration().setName(name).setType(typeDeclaration).setIsMutable(mutable);
   }

   public static ClassDeclaration newClassDeclaration(String name) {
      return newClassDeclaration().setName(name);
   }
}
