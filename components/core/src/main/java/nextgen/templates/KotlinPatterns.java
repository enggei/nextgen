package nextgen.templates;

import nextgen.templates.kotlin.*;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class KotlinPatterns extends KotlinST {

   public static Expression asThisExpression(FieldDeclaration fieldDeclaration) {
      return newThisExpression().setExpression(newLiteralExpression().setLiteral(fieldDeclaration.getName()));
   }

   public static Expression asScopeExpression(String scope, FieldDeclaration fieldDeclaration) {
      return newScopeExpression().setScope(scope).setExpression(newLiteralExpression().setLiteral(fieldDeclaration.getName()));
   }

   public static Expression asFunctionCallExpression(String scope, String functionName) {
      return newFunctionCallExpression().setScope(scope).setFunctionName(functionName).setArguments(Collections.emptyList());
   }

   public static Expression asFunctionCallExpression(String scope, String functionName, Collection<Expression> arguments) {
      return newFunctionCallExpression().setScope(scope).setFunctionName(functionName).setArguments(arguments);
   }

   public static OverrideEquals createEqualsFunction(String className, Collection<FieldDeclaration> fields) {
      return newOverrideEquals()
         .setClassName(className)
         .setFields(fields.stream()
            .map(fieldDeclaration -> {
               if (fieldDeclaration.getType() instanceof ArrayType) {
                  return newArrayEqualsExpression()
                     .setLeftArray(asThisExpression(fieldDeclaration))
                     .setRightArray(asScopeExpression("other", fieldDeclaration));
               } else {
                  return newEqualsExpression().setLhs(asThisExpression(fieldDeclaration)).setRhs(asScopeExpression("other", fieldDeclaration));
               }
            })
            .collect(Collectors.toList()));
   }

   public static OverrideHashCode createHashCodeFunction(FieldDeclaration field) {
      return newOverrideHashCode()
         .setReturnStatement(newReturnStatement()
            .setExpression(newFunctionCallExpression().setScope("Objects").setFunctionName("hash")
               .setArguments(Collections.singletonList(newLiteralExpression().setLiteral(field.getName())))));
   }

   public static OverrideToString createToStringFunction(String className, Collection<FieldDeclaration> fields) {
      return newOverrideToString()
         .setClassName(className)
         .setFields(fields.stream()
            .map(fieldDeclaration -> {
               ToStringExpression tse = newToStringExpression()
                       .setName(fieldDeclaration.getName());
               if (fieldDeclaration.getType() instanceof ArrayType) {
                   tse.setStringExpression(
                           newComplexStringExpression().setExpression(asFunctionCallExpression(fieldDeclaration.getName(), "contentToString"))
                   );
               } else {
                   tse.setStringExpression(
                           newSimpleStringExpression().setExpression(newLiteralExpression().setLiteral(fieldDeclaration.getName()))
                   );
               }
               return tse;
            })
            .collect(Collectors.toList()));
   }

   public static FunctionDeclaration createCopyFunction(String className, Collection<FieldDeclaration> fields) {
      return newFunctionDeclaration()
              .setName("copy")
              .setReturnType(newNamedType().setName(className))
              .setParams(fields.stream()
                      .map(fieldDeclaration -> newFunctionParam()
                              .setName(fieldDeclaration.getName())
                              .setTypeDeclaration(fieldDeclaration.getType())
                              .setDefaultValue(asThisExpression(fieldDeclaration)))
                      .collect(Collectors.toList())
              )
              .setExpressionBody(newConstructorCallExpression()
                      .setClassName(className)
                      .setParams(fields.stream().map(fieldDeclaration -> newFunctionCallParamExpression()
                              .setFieldName(fieldDeclaration.getName())
                              .setExpression(newLiteralExpression().setLiteral(fieldDeclaration.getName()))
                      ).collect(Collectors.toList()))
              );
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

   public static NullableType newNullableType(TypeDeclaration typeDeclaration) {
      return newNullableType().setType(typeDeclaration);
   }
}
