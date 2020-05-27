package nextgen.java;

import nextgen.java.st.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class JavaPatterns extends JavaFactory {

    private static final JavaGenerator javaGenerator = new JavaGenerator();

    public static ClassOrInterfaceType newTypedClassOrInterfaceType(ClassOrInterfaceType classOrInterfaceType, ClassOrInterfaceType... typeArguments) {
        final ClassOrInterfaceType copy = copy(classOrInterfaceType);
        for (ClassOrInterfaceType typeArgument : typeArguments) copy.addTypeArguments(typeArgument);
        return copy;
    }

    public static ClassOrInterfaceType copy(ClassOrInterfaceType classOrInterfaceType) {
        final ClassOrInterfaceType copy = new ClassOrInterfaceType(classOrInterfaceType.getUuid());
        classOrInterfaceType.getNames().forEach(copy::addNames);
        classOrInterfaceType.getTypeArguments().forEach(copy::addTypeArguments);
        copy.setIsArrayType(classOrInterfaceType.isArrayType());
        copy.setIsCollection(classOrInterfaceType.isCollection());
        copy.setIsInterface(classOrInterfaceType.isInterface());
        copy.setIsPrimitive(classOrInterfaceType.isPrimitive());
        copy.setIsTyped(classOrInterfaceType.isTyped());
        copy.setIsEnum(classOrInterfaceType.isEnum());
        copy.setScope(classOrInterfaceType.getScope());
        return copy;
    }

    public static void writeToFile(EnumDeclaration enumDeclaration, PackageDeclaration packageDeclaration, String root) {
        writeToFile(newCompilationUnit().addTypes(enumDeclaration).setPackageDeclaration(packageDeclaration), root);
    }

    public static void writeToFile(ClassOrInterfaceDeclaration classOrInterfaceDeclaration, PackageDeclaration packageDeclaration, String root) {
        writeToFile(newCompilationUnit().addTypes(classOrInterfaceDeclaration).setPackageDeclaration(packageDeclaration), root);
    }

    public static void writeToFile(CompilationUnit compilationUnit, String root) {

        final String packageName = compilationUnit.getPackageDeclaration() == null ? null : compilationUnit.getPackageDeclaration().getName();
        final File directory = packageName == null ? new File(root) : new File(root, packageToPath(packageName));

        compilationUnit.getTypes().stream().findFirst().ifPresent(o -> {
            if (o instanceof ClassOrInterfaceDeclaration)
                write(new File(directory, ((ClassOrInterfaceDeclaration) o).getName() + ".java"), javaGenerator.generate(compilationUnit));
            else if (o instanceof EnumDeclaration)
                write(new File(directory, ((EnumDeclaration) o).getName() + ".java"), javaGenerator.generate(compilationUnit));
        });
    }

    public static String packageToPath(String packageName) {
        return packageName.replaceAll("[.]", "/");
    }

    public static File write(File file, Object content) {

        try {

            if (!file.exists()) {
                final File parent = file.getParentFile();
                if (!parent.exists()) {
                    if (parent.getParentFile() != null && !parent.getParentFile().exists() && !parent.getParentFile().mkdirs())
                        throw new RuntimeException("Could not create parent dirs for " + parent.getAbsolutePath());
                    if (!parent.mkdir()) throw new RuntimeException("Could not create directory " + parent.getName());
                }
                if (!file.createNewFile()) throw new RuntimeException("Could not create file " + file.getName());
            }

            final BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(content == null ? "" : content.toString());
            out.close();

            return file;

        } catch (Exception e) {
            throw new RuntimeException("Could not write to " + file.getAbsolutePath() + " : " + e.getMessage(), e);
        }
    }

    public static PackageDeclaration newPackageDeclaration(String packageName) {
        return newPackageDeclaration().setName(packageName);
    }

    public static ClassOrInterfaceDeclaration newClass(String name) {
        return newClassOrInterfaceDeclaration()
                .setIsInterface(false)
                .setName(name);
    }

    public static ClassOrInterfaceDeclaration newPublicClassDeclaration() {
        return newClassOrInterfaceDeclaration()
                .addModifiers(Modifier.PUBLIC);
    }

    public static ClassOrInterfaceDeclaration newPublicClassDeclaration(String name) {
        return newClassDeclaration(name)
                .addModifiers(Modifier.PUBLIC);
    }

    public static EnumDeclaration newPublicEnumDeclaration(String name) {
        return newEnumDeclaration()
                .addModifiers(Modifier.PUBLIC)
                .setName(name);
    }

    public static ClassOrInterfaceDeclaration newClassDeclaration(String name) {
        return newClassOrInterfaceDeclaration()
                .setName(name);
    }

    public static PrivateFinalFieldDeclaration newPrivateFinalFieldDeclaration(ClassOrInterfaceType classOrInterfaceType, String name) {
        return newPrivateFinalFieldDeclaration()
                .setType(classOrInterfaceType)
                .setName(name);
    }

    public static FinalFieldDeclaration newFinalFieldDeclaration(ClassOrInterfaceType classOrInterfaceType, String name) {
        return newFinalFieldDeclaration()
                .setType(classOrInterfaceType)
                .setName(name);
    }

    public static PublicFinalFieldDeclaration newPublicFinalFieldDeclaration(ClassOrInterfaceType classOrInterfaceType, String name) {
        return newPublicFinalFieldDeclaration()
                .setType(classOrInterfaceType)
                .setName(name);
    }

    public static ConstructorDeclaration newPublicConstructorDeclaration() {
        return newConstructorDeclaration()
                .addModifiers(Modifier.PUBLIC);
    }

    public static ConstructorDeclaration newPublicConstructorDeclaration(String name) {
        return newConstructorDeclaration(name)
                .addModifiers(Modifier.PUBLIC);
    }

    public static ConstructorDeclaration newPublicConstructorDeclaration(String name, Parameter parameter) {
        return newConstructorDeclaration(name, parameter)
                .addModifiers(Modifier.PUBLIC);
    }

    public static ConstructorDeclaration newConstructorDeclaration(String name) {
        return newConstructorDeclaration()
                .setName(name);
    }

    public static ConstructorDeclaration newConstructorDeclaration(String name, Parameter parameter) {
        return newConstructorDeclaration()
                .setName(name)
                .addParameters(parameter);
    }

    public static MethodDeclaration newPublicMethodDeclaration() {
        return newMethodDeclaration()
                .addModifiers(Modifier.PUBLIC);
    }

    public static MethodDeclaration newPublicStaticMethodDeclaration() {
        return newPublicMethodDeclaration()
                .addModifiers(Modifier.STATIC);
    }

    public static MethodDeclaration newPublicMethodDeclaration(String name) {
        return newMethodDeclaration(name)
                .addModifiers(Modifier.PUBLIC);
    }

    public static MethodDeclaration newPublicMethodDeclaration(String name, ClassOrInterfaceType classOrInterfaceType) {
        return newMethodDeclaration(name, classOrInterfaceType)
                .addModifiers(Modifier.PUBLIC);
    }

    public static MethodDeclaration newPublicStaticMethodDeclaration(String name, ClassOrInterfaceType classOrInterfaceType) {
        return newMethodDeclaration(name, classOrInterfaceType)
                .addModifiers(Modifier.PUBLIC)
                .addModifiers(Modifier.STATIC);
    }

    public static MethodDeclaration newPrivateMethodDeclaration() {
        return newMethodDeclaration()
                .addModifiers(Modifier.PRIVATE);
    }

    public static MethodDeclaration newPrivateMethodDeclaration(String name) {
        return newMethodDeclaration(name)
                .addModifiers(Modifier.PRIVATE);
    }

    public static MethodDeclaration newPrivateMethodDeclaration(String name, ClassOrInterfaceType classOrInterfaceType) {
        return newMethodDeclaration(name, classOrInterfaceType)
                .addModifiers(Modifier.PRIVATE);
    }

    public static MethodDeclaration newMethodDeclaration(String name) {
        return newMethodDeclaration()
                .setName(name);
    }

    public static MethodDeclaration newMethodDeclaration(String name, ClassOrInterfaceType classOrInterfaceType) {
        return newMethodDeclaration(name)
                .setType(classOrInterfaceType);
    }

    public static VariableDeclarationExpression newVariableDeclarationExpression(ClassOrInterfaceType classOrInterfaceType, String name) {
        return newVariableDeclarationExpression()
                .addVariables(newVariableDeclaration()
                        .setType(classOrInterfaceType)
                        .setName(name));
    }

    public static VariableDeclarationExpression newVariableDeclarationExpression(ClassOrInterfaceType classOrInterfaceType, String name, Object initializer) {
        return newVariableDeclarationExpression()
                .addVariables(newVariableDeclaration()
                        .setType(classOrInterfaceType)
                        .setName(name)
                        .setInitializer(initializer));
    }

    public static VariableDeclarationExpression newFinalVariableDeclarationExpression() {
        return newVariableDeclarationExpression()
                .addModifiers(Modifier.FINAL);
    }

    public static VariableDeclarationExpression newFinalVariableDeclarationExpression(ClassOrInterfaceType classOrInterfaceType, String name) {
        return newFinalVariableDeclarationExpression(classOrInterfaceType, name, null);
    }

    public static VariableDeclarationExpression newFinalVariableDeclarationExpression(ClassOrInterfaceType classOrInterfaceType, String name, Object initializer) {
        return newVariableDeclarationExpression()
                .addModifiers(Modifier.FINAL)
                .addVariables(newVariableDeclaration()
                        .setType(classOrInterfaceType)
                        .setName(name)
                        .setInitializer(initializer));
    }

    public static Parameter newParameter(ClassOrInterfaceType classOrInterfaceType, String name) {
        return newParameter().setType(classOrInterfaceType).setName(name);
    }

    public static Parameter newParameter(String name) {
        return newParameter().setName(name);
    }

    public static FieldAccessExpression newFieldAccessExpression(Object scope, String name) {
        return newFieldAccessExpression()
                .setScope(scope)
                .setName(name);
    }

    public static AssignThisVariableExpression newAssignThisVariableExpression(Object variable) {
        return newAssignThisVariableExpression().setValue(variable);
    }

    public static AssignExpression newAssignThisExpression(String fieldName, Object value) {
        return newAssignExpression()
                .setTarget(newThisVariableExpression(fieldName))
                .setOperator("=")
                .setValue(value);
    }

    public static BlockStmt newBlockStmt(Expression expression) {
        return newBlockStmt().addStatements(newExpressionStmt(expression));
    }

    public static BlockStmt newReturnBlockStmt(Expression expression) {
        return newBlockStmt()
                .addStatements(newReturnStmt()
                        .setExpression(expression));
    }

    public static ReturnStmt newReturnStmt(Expression expression) {
        return newReturnStmt().setExpression(expression);
    }

    public static ReturnStmt newReturnThis() {
        return newReturnStmt(newThisExpression());
    }

    public static ClassOrInterfaceType newClassOrInterfaceType(String name) {
        return newClassOrInterfaceType().addNames(name);
    }

    public static StringLiteralExpression newStringLiteralExpression(String property) {
        return newStringLiteralExpression()
                .setValue(property);
    }

    public static NameExpression newExpression(Object name) {
        return newNameExpression()
                .setValue(name);
    }

    public static MethodReferenceExpression newMethodReferenceExpression(ClassOrInterfaceType classOrInterfaceType, String method) {
        return newMethodReferenceExpression().setScope(classOrInterfaceType).setIdentifier(method);
    }

    public static ExpressionStmt newExpressionStmt(Expression expression) {
        return newExpressionStmt()
                .setExpression(expression);
    }

    public static MethodDeclaration newToStringMethod(Expression variableName) {
        return newPublicMethodDeclaration("toString", StringType)
                .addAnnotations(newOverrideAnnotation())
                .setBlockStmt(newReturnBlockStmt(variableName));
    }

    public static MethodDeclaration newEqualsMethod(BlockStmt blockStmt) {
        return newPublicMethodDeclaration()
                .addAnnotations(newOverrideAnnotation())
                .setType(booleanType)
                .setName("equals")
                .addParameters(newParameter(ObjectType, "o"))
                .setBlockStmt(blockStmt);
    }

    public static MethodDeclaration newHashMethod(Object expression) {
        return newPublicMethodDeclaration()
                .addAnnotations(newOverrideAnnotation())
                .setName("hashCode")
                .setType(intType)
                .setBlockStmt(newReturnBlockStmt(newMethodCallExpression(ObjectsType, "hash", expression)));
    }

    public static SingleMemberAnnotationExpression newOverrideAnnotation() {
        return newSingleMemberAnnotationExpression()
                .setName(newClassOrInterfaceType("Override"));
    }

    public static ReturnStmt returnTrue() {
        return newReturnStmt(newTrueExpression());
    }

    public static ReturnStmt returnFalse() {
        return newReturnStmt(newFalseExpression());
    }

    public static BooleanLiteralExpression newTrueExpression() {
        return newBooleanLiteralExpression().setValue("true");
    }

    public static BooleanLiteralExpression newFalseExpression() {
        return newBooleanLiteralExpression()
                .setValue("false");
    }

    public static ThisVariableExpression newThisVariableExpression(Object value) {
        return newThisVariableExpression()
                .setValue(value);
    }

    public static MethodCallExpression newThisConstructorCall() {
        return newMethodCallExpression("this");
    }

    public static MethodCallExpression newSuperConstructorCall() {
        return newMethodCallExpression("super");
    }

    public static NullLiteralExpression newNull() {
        return newNullLiteralExpression()
                .setValue("null");
    }

    public static ObjectCreationExpression newObjectCreationExpression(String name) {
        return newObjectCreationExpression(newClassOrInterfaceType(name));
    }

    public static ObjectCreationExpression newObjectCreationExpression(String name, Object argument) {
        return newObjectCreationExpression(newClassOrInterfaceType(name))
                .addArguments(argument);
    }

    public static ObjectCreationExpression newObjectCreationExpression(ClassOrInterfaceType classOrInterfaceType) {
        return newObjectCreationExpression()
                .setType(classOrInterfaceType);
    }

    public static ObjectCreationExpression newObjectCreationExpression(ClassOrInterfaceType classOrInterfaceType, Object argument) {
        return newObjectCreationExpression()
                .setType(classOrInterfaceType)
                .addArguments(argument);
    }

    public static MethodCallExpression newMethodCallExpression(String name) {
        return newMethodCallExpression()
                .setName(name);
    }

    public static MethodCallExpression newMethodCallExpression(Object scope, String name) {
        return newMethodCallExpression()
                .setName(name)
                .setScope(scope);
    }

    public static MethodCallExpression newMethodCallExpression(Object scope, String name, Object argument) {
        return newMethodCallExpression()
                .setName(name)
                .setScope(scope)
                .addArguments(argument);
    }

    public static Expression notNull(Object value) {
        return newBinaryExpression()
                .setLeft(value)
                .setOperator("!=")
                .setRight("null");
    }

    public static Expression isNull(Object value) {
        return newBinaryExpression()
                .setLeft(value)
                .setOperator("==")
                .setRight("null");
    }

    public static LambdaExpression newLambdaExpression(Parameter parameter, LambdaBody body) {
        return newLambdaExpression()
                .addParameters(parameter)
                .setBody(body);
    }

    public static IfStmt newIfStmt(Object condition, Statement then) {
        return newIfStmt()
                .setCondition(condition)
                .setThen(then);
    }

    public static IfStmt newIfStmt(Object condition, Object then, Object otherwise) {
        return newIfStmt()
                .setCondition(condition)
                .setThen(then)
                .setElseStmt(otherwise);
    }

    public static ClassOrInterfaceType streamOf(ClassOrInterfaceType classOrInterfaceType) {
        return newTypedClassOrInterfaceType(StreamType, classOrInterfaceType);
    }

    public static ClassOrInterfaceType optionalOf(ClassOrInterfaceType classOrInterfaceType) {
        return newTypedClassOrInterfaceType(OptionalType, classOrInterfaceType);
    }

    public static ClassOrInterfaceType collectionOf(ClassOrInterfaceType type) {
        return newTypedClassOrInterfaceType(CollectionType, type);
    }

    public static ClassOrInterfaceType listOf(ClassOrInterfaceType type) {
        return newTypedClassOrInterfaceType(ListType, type);
    }

    public static ClassOrInterfaceType mapOf(ClassOrInterfaceType keyType, ClassOrInterfaceType valueType) {
        return newTypedClassOrInterfaceType(MapType, keyType, valueType);
    }

    public static ClassOrInterfaceType setOf(ClassOrInterfaceType type) {
        return newTypedClassOrInterfaceType(SetType, type);
    }


}