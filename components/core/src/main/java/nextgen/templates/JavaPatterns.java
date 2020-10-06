package nextgen.templates;

import nextgen.templates.java.*;

public class JavaPatterns extends JavaST {

   public static PackageDeclaration newPackageDeclaration(String packageName) {
      return newPackageDeclaration().setName(packageName);
   }

   public static PackageDeclaration newPackageDeclaration(PackageDeclaration parent, String packageName) {
      return newPackageDeclaration().setName(parent.getName() + "." + packageName);
   }

   public static ImportDeclaration newImportDeclaration(String name) {
      return newImportDeclaration().setName(name);
   }

   public static ImportDeclaration newImportDeclaration(PackageDeclaration packageDeclaration) {
      return newImportDeclaration().setName(packageDeclaration.getName()).setIsAsterisk(true);
   }

   public static VariableDeclarationExpression newFinalVariableDeclarationExpression(Object type, String name, Object initializer) {
      return newVariableDeclarationExpression()
            .addModifiers(Modifiers.FINAL)
            .addVariables(newVariableDeclaration(type, name, initializer));
   }

   private static VariableDeclaration newVariableDeclaration(Object type, String name, Object initializer) {
      return newVariableDeclaration()
            .setName(name)
            .setType(type)
            .setInitializer(initializer);
   }

   public static ExpressionStmt newFinalVariableDeclarationExpressionStmt(Object type, String name, Object initializer) {
      return newExpressionStmt(newFinalVariableDeclarationExpression(type, name, initializer));
   }

   private static ExpressionStmt newExpressionStmt(Expression expression) {
      return newExpressionStmt()
            .setExpression(expression);
   }

   public static ObjectCreationExpression newObjectCreationExpression(Object type) {
      return newObjectCreationExpression()
            .setType(type);
   }

   public static ImportDeclaration newImportDeclaration(PackageDeclaration packageDeclaration, String className) {
      return newImportDeclaration()
            .setName(packageDeclaration.getName() + "." + className);
   }

   public static ClassOrInterfaceDeclaration newClassOrInterfaceDeclaration(String name) {
      return newClassOrInterfaceDeclaration()
            .setName(name);
   }

   public static CompilationUnit newCompilationUnit(ClassOrInterfaceDeclaration classOrInterfaceDeclaration, PackageDeclaration packageDeclaration) {
      return newCompilationUnit()
            .setPackageDeclaration(packageDeclaration)
            .addTypes(classOrInterfaceDeclaration);
   }

   public static Singleton newSingleton(String name, PackageDeclaration packageDeclaration) {
      return newSingleton()
            .setPackageName(packageDeclaration.getName())
            .setName(name);
   }

   public static PrimitiveAccessors newPrimitiveAccessors(String type, String name, String className) {
      return newPrimitiveAccessors()
            .setType(type)
            .setName(name)
            .setClassName(className);
   }

   public static ReferenceAccessors newReferenceAccessors(String type, String name, String className) {
      return newReferenceAccessors()
            .setType(type)
            .setName(name)
            .setClassName(className);
   }

   public static ReferenceAccessors newReferenceAccessors(ClassOrInterfaceType type, String name, String className) {
      return newReferenceAccessors()
            .setType(type)
            .setName(name)
            .setClassName(className);
   }

   public static ClassOrInterfaceType newClassOrInterfaceType(String packageName, String name) {
      return newClassOrInterfaceType()
            .setScope(packageName)
            .addNames(name);
   }

   public static ClassOrInterfaceType newClassOrInterfaceType(Object packageName, Object name) {
      return newClassOrInterfaceType(packageName.toString(), name.toString());
   }

   public static ClassOrInterfaceType newClassOrInterfaceType(PackageDeclaration packageDeclaration, String name) {
      return newClassOrInterfaceType()
            .setScope(packageDeclaration.getName())
            .addNames(name);
   }

   public static MethodDeclaration newPrivateMethodDeclaration(String name) {
      return newMethodDeclaration()
            .setName(name)
            .addModifiers(Modifiers.PRIVATE);
   }

   public static MethodDeclaration newPublicMethodDeclaration(String name) {
      return newMethodDeclaration()
            .setName(name)
            .addModifiers(Modifiers.PUBLIC);
   }

   public static Parameter newParameter(String type, String name) {
      return newParameter()
            .setType(type)
            .setName(name);
   }

   public static BlockStmt newBlockStmt(Object[] statements) {
      final BlockStmt blockStmt = newBlockStmt();
      for (Object statement : statements)
         blockStmt.addStatements(statement);
      return blockStmt;
   }
}