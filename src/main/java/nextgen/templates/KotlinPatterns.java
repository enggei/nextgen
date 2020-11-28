package nextgen.templates;

import nextgen.templates.kotlin.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

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

   private static Expression createEqualsExpression(ParameterDefinition parameterDefinition) {
       if (getTypeFromParameterDefinition(parameterDefinition) instanceof ArrayType) {
           return newArrayEqualsExpression()
               .setLeftArray(asThisExpression(parameterDefinition))
               .setRightArray(asScopeExpression("other", parameterDefinition));
       } else {
           return newComparisonExpression(asThisExpression(parameterDefinition), ComparisonOperator.equals, asScopeExpression("other", parameterDefinition));
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
         .setReturnStatement(newReturnStatement(newFunctionCallExpression().setScope("java.util.Objects").setFunctionName("hash")
                 .setArguments(singletonList(newLiteralExpression(getNameFromParameterDefinition(field))))));
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

   public static AssignExpression newAssignExpression(String varName, Expression expression) {
       return newAssignExpression(newLiteralExpression(varName), AssignmentOperator.assign, expression);
   }

   public static AssignExpression newAssignExpression(String varName, String literal) {
       return newAssignExpression(varName, newLiteralExpression(literal));
   }

   public static AssignExpression newAssignExpression(String varName, StringValueExpression stringExpression) {
       return newAssignExpression(newLiteralExpression(varName), AssignmentOperator.assign, stringExpression);
   }

   public static AssignExpression newAssignExpression(Expression varName, Expression expression) {
       return newAssignExpression(varName, AssignmentOperator.assign, expression);
   }

   public static AssignExpression newAssignExpression(Expression varName, AssignmentOperator operator, Expression expression) {
       return KotlinST.newAssignExpression()
               .setVarName(varName)
               .setOperator(operator)
               .setExpression(expression);
   }

   public static TodoStatement newTodoStatement(String reason) {
       return KotlinST.newTodoStatement().setReason(reason);
   }

   public static FunctionDeclaration createCopyFunction(String className, Collection<ParameterDefinition> fields) {
      return newFunctionDeclaration()
              .setName("copy")
              .setReturnType(newNamedType().setName(className))
              .setParams(fields.stream()
                      .map(fieldDeclaration -> newFunctionParam(
                              getNameFromParameterDefinition(fieldDeclaration),
                              getTypeFromParameterDefinition(fieldDeclaration),
                              asThisExpression(fieldDeclaration)))
                      .collect(Collectors.toList())
              )
              .setExpressionBody(newConstructorCallExpression()
                      .setClassName(className)
                      .setParams(fields.stream()
                              .map(fieldDeclaration -> newLiteralExpression(getNameFromParameterDefinition(fieldDeclaration)))
                              .map(fieldName -> newAssignExpression(fieldName, fieldName))
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
      return KotlinST.newClassDeclaration().setName(name);
   }

   public static DataClassDeclaration newDataClassDeclaration(String name) {
      return KotlinST.newDataClassDeclaration().setName(name);
   }

   public static InterfaceDeclaration newInterfaceDeclaration(String name) {
      return KotlinST.newInterfaceDeclaration().setName(name);
   }

   public static EnumClassDeclaration newEnumClassDeclaration(String name) {
       return KotlinST.newEnumClassDeclaration().setName(name);
   }

   public static EnumClassDeclaration newEnumClassDeclaration(String name, Collection<EnumField> values) {
       return KotlinST.newEnumClassDeclaration().setName(name).setValues(values);
   }

   public static EnumField newEnumField(String name) {
       return KotlinST.newEnumField().setName(name);
   }

   public static EnumField newEnumField(String name, Collection<Expression> inputs) {
       return KotlinST.newEnumField().setName(name).setInputs(inputs);
   }

   public static List<EnumField> buildEnumFields(String... names) {
       return Stream.of(names).map(KotlinPatterns::newEnumField).collect(Collectors.toList());
   }

   public static NullableType newNullableType(TypeDeclaration typeDeclaration) {
      return KotlinST.newNullableType().setType(typeDeclaration);
   }

   public static Extending newImplementingInterface(TypeDeclaration typeDeclaration) {
       return KotlinST.newImplementingInterface().setType(typeDeclaration);
   }

   public static Extending newExtendingClass(TypeDeclaration typeDeclaration) {
       return KotlinST.newExtendingClass().setName(typeDeclaration);
   }

   public static Extending newExtendingClass(TypeDeclaration typeDeclaration, Collection<Expression> params) {
       return KotlinST.newExtendingClass().setName(typeDeclaration).setParams(params);
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

   public static ReferenceExpression createClassReferenceExpression(String className) {
       return newReferenceExpression(className, newLiteralExpression("class"));
   }

   public static ReferenceExpression createJavaClassReferenceExpression(String className) {
       return newReferenceExpression(className, newFunctionCallExpression().setScope("class").setFunctionName("class"));
   }

   public static KotlinStringTemplateSingleValue newKotlinStringTemplateSingleValue(String name) {
       return KotlinST.newKotlinStringTemplateSingleValue().setName(name);
   }

   public static KotlinStringTemplateExpression newKotlinStringTemplateExpression(Expression expression) {
       return KotlinST.newKotlinStringTemplateExpression().setExpression(expression);
   }

   public static ReturnStatement newReturnStatement(Expression expression) {
       return newReturnStatement().setExpression(expression);
   }

   public static PairType newPairType(TypeDeclaration first, TypeDeclaration second) {
       return newPairType().setFirst(first).setSecond(second);
   }

   public static MapType newMapType(TypeDeclaration first, TypeDeclaration second) {
       return newMapType().setFirst(first).setSecond(second);
   }

   public static MapType newMapType(PairType pairType) {
       return newMapType().setFirst(pairType.getFirst()).setSecond(pairType.getSecond());
   }

   public static VarDeclarationStatement newVarDeclarationStatement(String name) {
       return newVarDeclarationStatement().setName(name);
   }

   public static VarDeclarationStatement newVarDeclarationStatement(String name, Boolean mutable) {
       return newVarDeclarationStatement().setName(name).setIsMutable(mutable);
   }

   public static VarDeclarationStatement newVarDeclarationStatement(String name, Expression initializer) {
       return newVarDeclarationStatement().setName(name).setInitializer(initializer);
   }

   public static VarDeclarationStatement newVarDeclarationStatement(String name, Boolean mutable, Expression initializer) {
       return newVarDeclarationStatement().setName(name).setIsMutable(mutable).setInitializer(initializer);
   }

   public static VarDeclarationStatement newVarDeclarationStatement(String name, TypeDeclaration type) {
       return newVarDeclarationStatement().setName(name).setType(type);
   }

   public static VarDeclarationStatement newVarDeclarationStatement(String name, TypeDeclaration type, Boolean mutable) {
       return newVarDeclarationStatement().setName(name).setType(type).setIsMutable(mutable);
   }

   public static VarDeclarationStatement newVarDeclarationStatement(String name, TypeDeclaration type, Expression initializer) {
       return newVarDeclarationStatement().setName(name).setType(type).setInitializer(initializer);
   }

   public static VarDeclarationStatement newVarDeclarationStatement(String name, TypeDeclaration type, Expression initializer, Boolean mutable) {
       return newVarDeclarationStatement().setName(name).setType(type).setInitializer(initializer).setIsMutable(mutable);
   }

   public static ComparisonExpression newComparisonExpression(Expression lhs, ComparisonOperator operator, Expression rhs) {
       return KotlinST.newComparisonExpression()
               .setLhs(lhs)
               .setOperator(operator)
               .setRhs(rhs);
   }

   public static LogicalExpression newLogicalExpression(Expression lhs, LogicalOperator operator, Expression rhs) {
       return KotlinST.newLogicalExpression()
               .setLhs(lhs)
               .setOperator(operator)
               .setRhs(rhs);
   }

   public static IfExpression newIfExpression(LogicalExpression logicalExpression, Expression whenTrue, Expression whenFalse) {
       return newIfExpression()
               .setLogicalExpression(logicalExpression)
               .setWhenTrue(whenTrue)
               .setWhenFalse(whenFalse);
   }

   public static AnnotationDeclaration newAnnotationDeclaration(String name) {
       return KotlinST.newAnnotationDeclaration()
               .setName(name);
   }

   public static AnnotationDeclaration newAnnotationDeclaration(String scope, String name) {
       return KotlinST.newAnnotationDeclaration()
               .setScope(scope)
               .setName(name);
   }

   public static AnnotationDeclaration newAnnotationDeclaration(String name, Collection<Expression> params) {
       return KotlinST.newAnnotationDeclaration()
               .setName(name)
               .setParams(params);
   }

   public static AnnotationDeclaration newAnnotationDeclaration(String scope, String name, Collection<Expression> params) {
       return KotlinST.newAnnotationDeclaration()
               .setScope(scope)
               .setName(name)
               .setParams(params);
   }

   public static FunctionDeclaration newFunctionDeclaration(String name) {
       return KotlinST.newFunctionDeclaration().setName(name);
   }

   public static FunctionDeclaration newFunctionDeclaration(String name, TypeDeclaration returnType) {
       return KotlinST.newFunctionDeclaration().setName(name).setReturnType(returnType);
   }

   public static FunctionDeclaration newFunctionDeclaration(String name, Collection<FunctionParam> params) {
       return KotlinST.newFunctionDeclaration().setName(name).setParams(params);
   }

   public static FunctionDeclaration newFunctionDeclaration(String name, TypeDeclaration returnType, Collection<FunctionParam> params) {
       return KotlinST.newFunctionDeclaration().setName(name).setReturnType(returnType).setParams(params);
   }

   public static FunctionParam newFunctionParam(String name, TypeDeclaration type) {
       return KotlinST.newFunctionParam().setName(name).setTypeDeclaration(type);
   }

   public static FunctionParam newFunctionParam(String name, TypeDeclaration type, Expression defaultValue) {
       return KotlinST.newFunctionParam().setName(name).setTypeDeclaration(type).setDefaultValue(defaultValue);
   }

   public static PackageDeclaration newPackageDeclaration(String name) {
       return KotlinST.newPackageDeclaration().setName(name);
   }

   public static ImportStatement newImportStatement(String scope, String name) {
       return KotlinST.newImportStatement().setScope(scope).setName(name);
   }

   public static KotlinFile newKotlinFile(PackageDeclaration packageDeclaration, Collection<CompilationUnit> compilationUnits) {
       return KotlinST.newKotlinFile().setPackageDeclaration(packageDeclaration).setCompilationUnit(compilationUnits);
   }

   public static KotlinFile newKotlinFile(PackageDeclaration packageDeclaration, Collection<CompilationUnit> compilationUnits, Collection<ImportStatement> importStatements) {
       return KotlinST.newKotlinFile().setPackageDeclaration(packageDeclaration).setCompilationUnit(compilationUnits).setImports(importStatements);
   }

   public static SingleLineComment newSingleLineComment(String comment) {
       return KotlinST.newSingleLineComment().setComment(comment);
   }

   public static CommentBlock newCommentBlock(String comment) {
       return KotlinST.newCommentBlock().setComment(comment);
   }

   public static ClassDeclaration createNeo4jOgmUuidAttributeConverterClass() {
       final NamedType uuidType = newNamedType().setName("java.util.UUID");
       final NamedType uuidAttributeConverterType = newNamedType().setName("UUIDAttributeConverter");
       final StringType stringType = newStringType();
       final TemplateType attributeConverter = newTemplateType().setName("org.neo4j.ogm.typeconversion.AttributeConverter")
               .setTemplates(asList(
                       uuidType,
                       stringType
               ));

       return newClassDeclaration(uuidAttributeConverterType.getName())
               .setExtends(singletonList(newImplementingInterface(attributeConverter)))
               .setMembers(asList(
                       newFunctionDeclaration("toGraphProperty", stringType, singletonList(newFunctionParam("value", uuidType)))
                               .setOverride(true)
                               .setExpressionBody(newFunctionCallExpression().setScope("value").setFunctionName("toString")),
                       newFunctionDeclaration("toEntityAttribute", uuidType, singletonList(newFunctionParam("value", stringType)))
                               .setOverride(true)
                               .setExpressionBody(newFunctionCallExpression().setScope(uuidType.getName()).setFunctionName("fromString").setArguments(singletonList(newLiteralExpression("value"))))
               ));
   }

   public static ClassDeclaration createNeo4jOgmAbstractEntityClass() {
       final TypeDeclaration longType = newNamedType().setName("Long");
       final NullableType nullableLongType = newNullableType(longType);
       final TypeDeclaration uuidType = newNamedType().setName("java.util.UUID");

       final String annotationScopeOgm = "org.neo4j.ogm.annotation";
       final String annotationScopeOgmTypeconversion = "org.neo4j.ogm.annotation.typeconversion";

       PropertyDeclaration idProperty = newPropertyDeclaration(nullableLongType, "id", newLiteralExpression("id"), true)
               .setPrivateSetter(true)
               .setAnnotations(asList(
                       newAnnotationDeclaration(annotationScopeOgm, "Id"),
                       newAnnotationDeclaration(annotationScopeOgm, "GeneratedValue")
               ));

       PropertyDeclaration uuidProperty = newPropertyDeclaration(uuidType, "uuid", newLiteralExpression("uuid"), true)
               .setPrivateSetter(true)
               .setAnnotations(asList(
                       newAnnotationDeclaration(annotationScopeOgm, "Property", singletonList(newStringValueExpression("uuid"))),
                       newAnnotationDeclaration(annotationScopeOgm, "Index", singletonList(newAssignExpression("unique", "true"))),
                       newAnnotationDeclaration(annotationScopeOgmTypeconversion, "Convert", singletonList(createClassReferenceExpression("UUIDAttributeConverter")))
               ));

       List<PropertyDeclaration> properties = asList(
               idProperty,
               uuidProperty
       );

       List<ParameterDefinition> parameters = asList(
               newParameterDeclaration(nullableLongType, "id", newNullExpression()),
               newParameterDeclaration(uuidType, "uuid", newFunctionCallExpression().setScope("java.util.UUID").setFunctionName("randomUUID"))
       );

       final String className = "Entity";

       return newClassDeclaration(className)
               .setIsAbstract(true)
               .setFields(parameters)
               .setProperties(properties)
               .setOverrideEquals(createEqualsFunction(className,
                       properties.stream().filter(fieldDeclaration -> !Objects.equals(getNameFromParameterDefinition(fieldDeclaration), "id")).collect(Collectors.toList()))
               )
               .setOverrideToString(createToStringFunction(className, new ArrayList<>(properties)))
               .setOverrideHashCode(createHashCodeFunction(uuidProperty))
               ;
   }

   public static InterfaceDeclaration createNeo4jOgmEnumNodeInterface() {

       TypeDeclaration enumStarTemplate = newTemplateType()
               .setName("Enum")
               .setTemplates(singletonList(newStarType()));

       return newInterfaceDeclaration("EnumNode")
               .addMembers(newFunctionDeclaration("enumVal", enumStarTemplate));
   }

   public static InterfaceDeclaration createNeo4jOgmRelationshipInterface() {

       TypeDeclaration entityType = newNamedType().setName("Entity");

       return newInterfaceDeclaration("Relationship")
               .setMembers(asList(
                       newFunctionDeclaration("startNode", entityType),
                       newFunctionDeclaration("endNode", entityType)
               ));
   }
}
