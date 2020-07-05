package nextgen.templates;

import nextgen.templates.kotlin.*;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class KotlinPatterns extends KotlinST {

   public static String getNameFromParameterDefinition(ParameterDefinition parameterDefinition) {
       if (parameterDefinition instanceof PropertyDeclaration) {
           return ((PropertyDeclaration)parameterDefinition).getName();
       } else if(parameterDefinition instanceof ParameterDeclaration) {
           return ((ParameterDeclaration)parameterDefinition).getName();
       }
       return null;
   }

   public static TypeDeclaration getTypeFromParameterDefinition(ParameterDefinition parameterDefinition) {
       if (parameterDefinition instanceof PropertyDeclaration) {
           return ((PropertyDeclaration)parameterDefinition).getType();
       } else if(parameterDefinition instanceof ParameterDeclaration) {
           return ((ParameterDeclaration)parameterDefinition).getType();
       }
       return null;
   }

   public static Expression asThisExpression(ParameterDefinition parameterDefinition) {
      return newThisExpression().setExpression(newLiteralExpression(getNameFromParameterDefinition(parameterDefinition)));
   }

   public static Expression asScopeExpression(String scope, ParameterDefinition parameterDefinition) {
      return newScopeExpression().setScope(scope).setExpression(newLiteralExpression(getNameFromParameterDefinition(parameterDefinition)));
   }

   public static Expression asFunctionCallExpression(String scope, String functionName) {
      return newFunctionCallExpression().setScope(scope).setFunctionName(functionName).setArguments(Collections.emptyList());
   }

   public static Expression asFunctionCallExpression(String scope, String functionName, Collection<Expression> arguments) {
      return newFunctionCallExpression().setScope(scope).setFunctionName(functionName).setArguments(arguments);
   }

   public static Expression createEqualsExpression(ParameterDefinition parameterDefinition) {
       if (getTypeFromParameterDefinition(parameterDefinition) instanceof ArrayType) {
           return newArrayEqualsExpression()
               .setLeftArray(asThisExpression(parameterDefinition))
               .setRightArray(asScopeExpression("other", parameterDefinition));
       } else {
           return newEqualsExpression().setLhs(asThisExpression(parameterDefinition)).setRhs(asScopeExpression("other", parameterDefinition));
       }
   }

   public static OverrideEquals createEqualsFunction(String className, Collection<ParameterDefinition> fields) {
      return newOverrideEquals()
         .setClassName(className)
         .setFields(fields.stream()
            .map(KotlinPatterns::createEqualsExpression)
            .collect(Collectors.toList()));
   }

   public static OverrideHashCode createHashCodeFunction(ParameterDefinition field) {
      return newOverrideHashCode()
         .setReturnStatement(newReturnStatement()
            .setExpression(newFunctionCallExpression().setScope("Objects").setFunctionName("hash")
               .setArguments(Collections.singletonList(newLiteralExpression(getNameFromParameterDefinition(field))))));
   }

   public static OverrideToString createToStringFunction(String className, Collection<ParameterDefinition> fields) {
      OverrideToString overrideToString = newOverrideToString().setClassName(className);
      mapParameterDefinitionsToOverrideToString_Fields(fields).forEach(overrideToString::addFields);
      return overrideToString;
   }

   private static Collection<OverrideToString.OverrideToString_Fields> mapParameterDefinitionsToOverrideToString_Fields(Collection<ParameterDefinition> fields) {
      return fields.stream()
         .map(KotlinPatterns::createOverrideToString_Fields)
         .collect(Collectors.toList());
   }

   public static OverrideToString.OverrideToString_Fields createOverrideToString_Fields(ParameterDefinition parameterDefinition) {
      String name = getNameFromParameterDefinition(parameterDefinition);

      if (getTypeFromParameterDefinition(parameterDefinition) instanceof ArrayType) {
         return new OverrideToString.OverrideToString_Fields(name, newKotlinStringTemplateExpression(
               asFunctionCallExpression(name, "contentToString")
         ));
      }

      return new OverrideToString.OverrideToString_Fields(name, newKotlinStringTemplateSingleValue(name));
   }

   public static FunctionDeclaration createCopyFunction(String className, Collection<ParameterDefinition> fields) {
      return newFunctionDeclaration()
              .setName("copy")
              .setReturnType(newNamedType().setName(className))
              .setParams(fields.stream()
                      .map(fieldDeclaration -> newFunctionParam()
                              .setName(getNameFromParameterDefinition(fieldDeclaration))
                              .setTypeDeclaration(getTypeFromParameterDefinition(fieldDeclaration))
                              .setDefaultValue(asThisExpression(fieldDeclaration)))
                      .collect(Collectors.toList())
              )
              .setExpressionBody(newConstructorCallExpression()
                      .setClassName(className)
                      .setParams(fields.stream()
                              .map(fieldDeclaration -> newLiteralExpression(getNameFromParameterDefinition(fieldDeclaration)))
                              .map(fieldName -> newAssignExpression()
                                  .setVarName(fieldName)
                                  .setExpression(fieldName))
                              .collect(Collectors.toList()))
              );
   }

   public static ParameterDeclaration newParameterDeclaration(TypeDeclaration typeDeclaration, String name) {
       return KotlinST.newParameterDeclaration().setName(name).setType(typeDeclaration);
   }

   public static ParameterDeclaration newParameterDeclaration(TypeDeclaration typeDeclaration, String name, Expression initializer) {
       return KotlinST.newParameterDeclaration().setName(name).setType(typeDeclaration).setInitializer(initializer);
   }

   public static PropertyDeclaration newPropertyDeclaration(TypeDeclaration typeDeclaration, String name) {
      return KotlinST.newPropertyDeclaration().setName(name).setType(typeDeclaration);
   }

   public static PropertyDeclaration newPropertyDeclaration(TypeDeclaration typeDeclaration, String name, Boolean mutable) {
      return KotlinST.newPropertyDeclaration().setName(name).setType(typeDeclaration).setIsMutable(mutable);
   }

   public static PropertyDeclaration newPropertyDeclaration(TypeDeclaration typeDeclaration, String name, Expression initializer, Boolean mutable) {
      return KotlinST.newPropertyDeclaration().setName(name).setType(typeDeclaration).setInitializer(initializer).setIsMutable(mutable);
   }

   public static PropertyDeclaration newPropertyDeclaration(TypeDeclaration typeDeclaration, String name, Expression initializer) {
      return KotlinST.newPropertyDeclaration().setName(name).setType(typeDeclaration).setInitializer(initializer);
   }

   public static ClassDeclaration newClassDeclaration(String name) {
      return newClassDeclaration().setName(name);
   }

   public static DataClassDeclaration newDataClassDeclaration(String name) {
      return newDataClassDeclaration().setName(name);
   }

   public static InterfaceDeclaration newInterfaceDeclaration(String name) {
      return newInterfaceDeclaration().setName(name);
   }

   public static NullableType newNullableType(TypeDeclaration typeDeclaration) {
      return newNullableType().setType(typeDeclaration);
   }

   public static Extending newImplementingInterface(String name) {
       return newImplementingInterface().setInterfaceName(name);
   }

   public static Extending newExtendingClass(String name) {
       return KotlinST.newExtendingClass().setClassName(name);
   }

   public static Extending newExtendingClass(String name, Collection<Expression> params) {
       return KotlinST.newExtendingClass().setClassName(name).setParams(params);
   }

   public static LiteralExpression newLiteralExpression(Object literal) {
       return KotlinST.newLiteralExpression().setLiteral(literal);
   }

   public static StringValueExpression newStringValueExpression(Object literal) {
       return KotlinST.newStringValueExpression().setLiteral(literal);
   }

   public static RawStringExpression newRawStringExpression(Object rawString) {
       return KotlinST.newRawStringExpression().setRawString(rawString);
    }

   public static PropertyAccessorExpression newPropertyAccessorExpression(Expression object, Expression property) {
       return KotlinST.newPropertyAccessorExpression().setObject(object).setProperty(property);
   }

   public static ReferenceExpression newReferenceExpression(String name, Expression property) {
       return KotlinST.newReferenceExpression().setName(name).setProperty(property);
   }

   public static ReferenceExpression newReferenceExpression(String scope, String name, Expression property) {
       return KotlinST.newReferenceExpression().setScope(scope).setName(name).setProperty(property);
   }

   public static KotlinStringTemplateSingleValue newKotlinStringTemplateSingleValue(String name) {
       return KotlinST.newKotlinStringTemplateSingleValue().setName(name);
   }

   public static KotlinStringTemplateExpression newKotlinStringTemplateExpression(Expression expression) {
       return KotlinST.newKotlinStringTemplateExpression().setExpression(expression);
   }
}
