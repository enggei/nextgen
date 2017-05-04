package com.generator.generators.javaparser;

import com.automation.Langton;
import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.generators.java.JavaGroup;
import com.generator.generators.meta.MetaDomain;
import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.util.FileUtil;
import com.github.javaparser.ASTHelper;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class JavaparserTests {

   private final String root = "/media/storage/nextgen/src/test/java";
   private final String packageName = "com.generator.generators.javaparser";

   @BeforeClass
   public static void setup() {
      System.setProperty("generator.path", "src/main/java/com/generator/generators");
   }

   @Test
   public void testJavaParsingVisitor() throws IOException, ParseException {

      File[] list = FileUtil.list("/home/goe/udc/trailer-report/src/main/java/com/ud/tr/domain", ".java");

      for (File file : list) {
         System.out.println(file);

         CompilationUnit cu = JavaParser.parse(file);
         visitEssentials(cu);
      }
   }

   private static void visitEssentials(CompilationUnit cu) {
      new VoidVisitorAdapter<String>() {

         @Override
         public void visit(PackageDeclaration n, String arg) {
            System.out.print("PackageDeclaration " + n.getPackageName());
            super.visit(n, arg);
         }

         @Override
         public void visit(ImportDeclaration n, String arg) {
            final StringBuilder out = new StringBuilder("\n\tImportDeclaration " + n.getName());
            System.out.print(out.toString());
            super.visit(n, arg);
         }

         @Override
         public void visit(ClassOrInterfaceDeclaration n, String arg) {
            final StringBuilder out = new StringBuilder("\n\tClassOrInterfaceDeclaration " + n.getName());

            for (ClassOrInterfaceType extendsType : n.getExtends()) {
               out.append("\n\t\textends ").append(extendsType.getName());
            }

            for (ClassOrInterfaceType implementsType : n.getImplements()) {
               out.append("\n\t\timplements ").append(implementsType.getName());
            }

            System.out.print(out.toString());
            super.visit(n, arg);
         }

         @Override
         public void visit(FieldDeclaration n, String arg) {
            final StringBuilder out = new StringBuilder();

            for (VariableDeclarator variableDeclarator : n.getVariables()) {
               out.append("\n\t\t\t").append(ModifierSet.getAccessSpecifier(n.getModifiers())).append(" ").append(n.getType()).append(" ").append(variableDeclarator.getId()).append(variableDeclarator.getInit() == null ? "" : (" = " + variableDeclarator.getInit()));
            }

            System.out.print(out.toString());
            super.visit(n, arg);
         }

         @Override
         public void visit(MethodDeclaration n, String arg) {
            final StringBuilder out = new StringBuilder();
            out.append("\n\t\t\t").append(ModifierSet.getAccessSpecifier(n.getModifiers())).append(" ").append(n.getType()).append(" ").append(n.getName()).append("(");
            for (Parameter parameter : n.getParameters()) {
               out.append(parameter.getType()).append(" ").append(parameter.getName()).append(" ");
            }
            out.append(")");

            for (Statement statement : n.getBody().getStmts()) {
               //out.append("\n\t\t\t\t").append(statement);
               statement.accept(new VoidVisitorAdapter<String>() {

                  @Override
                  public void visit(VariableDeclarator n, String arg) {
                     out.append("\n\t\t\t\t\tLOCAL." + n.getId());
                     super.visit(n, arg);
                  }

                  @Override
                  public void visit(FieldAccessExpr n, String arg) {
                     out.append("\n\t\t\t\t\tTHIS." + n.getField());
                     super.visit(n, arg);
                  }

                  @Override
                  public void visit(ReturnStmt n, String arg) {
                     out.append("\n\t\t\t\t\tRETURNS " + n.getExpr());
                     super.visit(n, arg);
                  }

                  @Override
                  public void visit(MethodCallExpr n, String arg) {
                     out.append("\n\t\t\t\t\tCALLING " + (n.getScope() == null ? "" : ("THIS." + n.getScope() + ".")) + n.getName());
                     super.visit(n, arg);
                  }
               }, "");
            }

            System.out.print(out.toString());
            super.visit(n, arg);
         }
      }.visit(cu, null);
      System.out.println();
      System.out.println();
   }


   @Test
   public void createTestClass() throws IOException, ParseException {

      CompilationUnit cu = new CompilationUnit();

      // set the package
      // todo: use relations for each QualifiedNameExpression, and use an action for setPackage(traversing the qualifiedNameexpression and generate the packageDeclaration
      cu.setPackage(new PackageDeclaration(new QualifiedNameExpr(new QualifiedNameExpr(new QualifiedNameExpr(new NameExpr("com"), "generator"), "generators"), "javaparser")));
      // packageDeclarationTraverser: given a QualifiedNameExpression, traverses all of them, and returns a PackageDeclaration- node.
      // using relations between CompilationUnit and PackageDeclaration, allow to "setPackage()" on cu-node, which has a defined relationship to a PackageDeclaration.

      // create the type declaration
      final String classname = "GeneratedClass";
      ClassOrInterfaceDeclaration type = new ClassOrInterfaceDeclaration(ModifierSet.PUBLIC, false, classname);
      // todo: create a node for ClassOrInterfaceDeclaration, whith properties (ModifierSet-enum-nodes with relationships, false if class, true if interface, string property for classname)

      // this is a relationship, which binds a compilationunit to  a type:
      ASTHelper.addTypeDeclaration(cu, type);

      // todo: this is a node-action
      final ConstructorDeclaration constructorDeclaration = new ConstructorDeclaration(ModifierSet.PUBLIC, classname);
      constructorDeclaration.setNameExpr(new NameExpr(classname));
      System.out.println(constructorDeclaration.getDeclarationAsString());

      // todo: use relation-action for this command
      ASTHelper.addMember(type, constructorDeclaration);

      // create a method
      MethodDeclaration method = new MethodDeclaration(ModifierSet.PUBLIC, ASTHelper.VOID_TYPE, "main");
      method.setModifiers(ModifierSet.addModifier(method.getModifiers(), ModifierSet.STATIC));
      ASTHelper.addMember(type, method);

      // add a parameter to the method
      Parameter param = ASTHelper.createParameter(ASTHelper.createReferenceType("String", 0), "args");
      param.setVarArgs(true);
      ASTHelper.addParameter(method, param);

      // add a body to the method
      BlockStmt block = new BlockStmt();
      method.setBody(block);

      // add a statement do the method body
      NameExpr clazz = new NameExpr("System");
      FieldAccessExpr field = new FieldAccessExpr(clazz, "out");
      MethodCallExpr call = new MethodCallExpr(field, "println");
      ASTHelper.addArgument(call, new StringLiteralExpr("Hello World!"));
      ASTHelper.addStmt(block, call);

      FileUtil.write(cu.toString(), GeneratedFile.newJavaFile(root, packageName, classname).getFile());

      // try to parse generated file:
      cu = JavaParser.parse(GeneratedFile.newJavaFile(root, packageName, classname).getFile());

      // generate code like above, from parsed- class (use this and apply to all other java-classes, so I can make buttons for adding methods parameters etc.
      new BuilderGenerator(cu).writeToFile(root);
   }

   @Test
   public void testCases() throws IOException, ParseException {

      final File testDB = Files.createTempDirectory("testDB").toFile();

      final GraphDatabaseService testGraph = new GraphDatabaseFactory().
            newEmbeddedDatabaseBuilder(testDB).
            newGraphDatabase();

      final NeoModel neoModel = new NeoModel(testGraph, mod -> FileUtil.removeFilesUnderIncluding(testDB.getAbsolutePath()));

      final CompilationUnit cu = JavaParser.parse(new File("/media/storage/nextgen/src/main/java/com/generator/generators/templates/editors/CanvasEditor.java"));

      neoModel.doInTransaction(new NeoModel.Committer() {
         @Override
         public void doAction(Transaction tx) throws Throwable {
            new NeoVisitorAdapter(neoModel, new Stack<>()).visit(cu, null);
         }

         @Override
         public void exception(Throwable throwable) {
            throwable.printStackTrace();
         }
      });

      // todo: make Piccolo and create a Neo-visualiser, using NeoVisitor-adapter for parsing java-files

   }

   @Test
   public void classToNeo() throws IOException {

      final File testDB = Files.createTempDirectory("testDB").toFile();

      final GraphDatabaseService testGraph = new GraphDatabaseFactory().
            newEmbeddedDatabaseBuilder(testDB).
            newGraphDatabase();

      final NeoModel neoModel = new NeoModel(testGraph, mod -> FileUtil.removeFilesUnderIncluding(testDB.getAbsolutePath()));
      neoModel.doInTransaction(new NeoModel.Committer() {
         @Override
         public void doAction(Transaction tx) throws Throwable {
//            new ClasstoNeo(neoModel).visit(Langton.class);
         }

         @Override
         public void exception(Throwable throwable) {
            throwable.printStackTrace();
         }
      });
   }

   @Test
   public void testVisitorToEntities() {

      new BaseClassVisitor() {
         @Override
         public void onDeclaredMethod(Method method) {
            for (java.lang.reflect.Parameter parameter : method.getParameters()) {

               if (isTypeVariable(parameter)) {
                  final String simpleName = ((Class) getBounds(asTypeVariableType(parameter))[0]).getSimpleName();
                  //System.out.println("typeVariable.simpleName " + simpleName);

               } else {

                  final String type = parameter.getParameterizedType().getTypeName().substring(parameter.getParameterizedType().getTypeName().lastIndexOf(".") + 1).trim();
                  final String parameterType = parameter.getType().getSimpleName();
                  System.out.println("type " + type + " " + parameterType);

               }
            }
         }
      }.visit(VoidVisitorAdapter.class);

   }
   @Test
   public void createJavaParserDomain() {

      final String[] split = "AnnotationDeclaration, AnnotationMemberDeclaration, BaseParameter, ClassOrInterfaceDeclaration, ClassOrInterfaceType, ConstructorDeclaration, EmptyTypeDeclaration, EnumConstantDeclaration, EnumDeclaration, MemberValuePair, MethodDeclaration, MultiTypeParameter, NameExpr, Parameter, QualifiedNameExpr, TypeDeclaration, TypeParameter, VariableDeclaratorId".split(",");


      final NeoModel neoModel = NeoEditor.newEmbeddedDatabase("/home/goe/dbMetaTest");

      neoModel.doInTransaction(new NeoModel.Committer() {
         @Override
         public void doAction(Transaction tx) throws Throwable {

            final String[] colors = parse("['#a6cee3','#1f78b4','#b2df8a','#33a02c','#fb9a99','#e31a1c','#fdbf6f','#ff7f00','#cab2d6','#6a3d9a','#ffff99','#b15928']");
            final AtomicInteger color = new AtomicInteger(0);

            final Node domainNode = neoModel.newNode(MetaDomain.Entities.Domain,
                  MetaDomain.Properties.name.name(), "JavaParserDomain",
                  MetaDomain.Properties.packageName.name(), "com.nextgen.meta",
                  MetaDomain.Properties.root.name(), "/home/goe/projects/nextgen/src/test/java");


            new BaseClassVisitor() {
               @Override
               public void onDeclaredMethod(Method method) {
                  newEntity(domainNode, "Package", colors[color.incrementAndGet()%colors.length]);
               }
            }.visit(VoidVisitorAdapter.class);


            final Node packageNode = newEntity(domainNode, "Package", colors[color.incrementAndGet()%colors.length]);

            final Node classNode = neoModel.newNode(MetaDomain.Entities.Entity, MetaDomain.Properties.name.name(), "Class", MetaDomain.Properties.color.name(), "#1f78b4");
            final Node fieldNode = neoModel.newNode(MetaDomain.Entities.Entity, MetaDomain.Properties.name.name(), "Field", MetaDomain.Properties.color.name(), "#b2df8a");

            final Node packageMember = neoModel.newNode(MetaDomain.Entities.Relation, MetaDomain.Properties.name.name(), "MEMBER");
            packageMember.createRelationshipTo(packageNode, MetaDomain.Relations.SRC);
            packageMember.createRelationshipTo(classNode, MetaDomain.Relations.DST);

            final Node classField = neoModel.newNode(MetaDomain.Entities.Relation, MetaDomain.Properties.name.name(), "FIELD");
            classField.createRelationshipTo(classNode, MetaDomain.Relations.SRC);
            classField.createRelationshipTo(fieldNode, MetaDomain.Relations.DST);


            domainNode.createRelationshipTo(classNode, MetaDomain.Relations.ENTITY);
            domainNode.createRelationshipTo(fieldNode, MetaDomain.Relations.ENTITY);

            domainNode.createRelationshipTo(packageMember, MetaDomain.Relations.RELATION);
            domainNode.createRelationshipTo(classField, MetaDomain.Relations.RELATION);

         }

         private Node newEntity(Node domainNode, String name, String color) {
            final Node packageNode = neoModel.newNode(MetaDomain.Entities.Entity, MetaDomain.Properties.name.name(), name, MetaDomain.Properties.color.name(), color);
            domainNode.createRelationshipTo(packageNode, MetaDomain.Relations.ENTITY);
            return packageNode;
         }

         private String[] parse(String map) {
            final String[] c = map.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\'", "").split(",");
            final String[] colors = new String[c.length];
            System.arraycopy(c, 0, colors, 0, c.length);
            return colors;
         }

         @Override
         public void exception(Throwable throwable) {

         }
      });

   }

   @Test
   public void createNeoVisitorAdapter() {

      final Class<VoidVisitorAdapter> clazz = VoidVisitorAdapter.class;
      final JavaGroup javaGroup = new JavaGroup();

      final String debugClass = "NeoVisitorAdapter";

      // http://www.javadoc.io/doc/com.github.javaparser/javaparser-core/2.5.1
      // NamedNodes:
      final String[] split = "AnnotationDeclaration, AnnotationMemberDeclaration, BaseParameter, ClassOrInterfaceDeclaration, ClassOrInterfaceType, ConstructorDeclaration, EmptyTypeDeclaration, EnumConstantDeclaration, EnumDeclaration, MemberValuePair, MethodDeclaration, MultiTypeParameter, NameExpr, Parameter, QualifiedNameExpr, TypeDeclaration, TypeParameter, VariableDeclaratorId".split(",");

      //todo: use Baseclassvisitor to create a domain for java .. ?

      // todo: use template-groups for this !!!

      final Map<String, String> nodeClasses = new LinkedHashMap<>();
      final Set<String> nodeTypes = new LinkedHashSet<>();

      new BaseClassVisitor() {

         final JavaGroup.classST builderGenerator = javaGroup.newclass().
               setPackage(packageName).
               setScope("public").
               setName(debugClass).
               addImportsValue("com.generator.editors.BaseDomainVisitor").
               addImportsValue("com.generator.editors.NeoModel").
               addImportsValue("org.neo4j.graphdb.*").
               addImportsValue("com.github.javaparser.ast.*").
               addImportsValue("com.github.javaparser.ast.body.*").
               addImportsValue("com.github.javaparser.ast.comments.*").
               addImportsValue("com.github.javaparser.ast.expr.*").
               addImportsValue("com.github.javaparser.ast.stmt.*").
               addImportsValue("com.github.javaparser.ast.type.*").
               addImportsValue("com.github.javaparser.ast.visitor.VoidVisitorAdapter").
               setExtends("VoidVisitorAdapter<Object>");

			/*
            * public void visit(Relationship relationship, Node source) {
		final String nodeType = relationship.getProperty("nodeType").toString();
		switch (nodeType) {
			case "CompilationUnit": visitCompilationUnit(BaseDomainVisitor.other(source, relationship)); break;
			default: System.out.println("Unsupported nodeType: " + nodeType);
		}
	}
	*/

         final JavaGroup.methodST visitMethod = javaGroup.newmethod().setScope("public").setReturnVal("void").setName("visit");

         @Override
         public void onClass(Package classPackage, String className, Class superClass) {
            builderGenerator.addPropertiesValue(null, null, null, null, null, null, null, null, "graph", "private", "NeoModel", null);
            builderGenerator.addPropertiesValue("org.neo4j.graphdb.Node", null, "Stack", true, null, null, null, null, "nodes", "private", "Stack", null);

            visitMethod.addParamsValue(null, null, null, null, null, null, "relationship", "Relationship", null);
            visitMethod.addParamsValue(null, null, null, null, null, null, "node", "org.neo4j.graphdb.Node", null);
         }

         @Override
         public void onDeclaredMethod(Method method) {

            if (method.getName().equals("visitComment")) return;

            final JavaGroup.methodST javaParserNodeMethod = javaGroup.newmethod().
                  setScope(getScope(method)).
                  setName(getName(method)).
                  setReturnVal(getReturnType(method)).
                  addAnnotationsValue("Override");

            for (java.lang.reflect.Parameter parameter : method.getParameters()) {

               if (isTypeVariable(parameter)) {
                  javaParserNodeMethod.addParamsValue(null, null, null, null, null, null, "arg", ((Class) getBounds(asTypeVariableType(parameter))[0]).getSimpleName(), null);

               } else {

                  final String type = parameter.getParameterizedType().getTypeName().substring(parameter.getParameterizedType().getTypeName().lastIndexOf(".") + 1).trim();
                  javaParserNodeMethod.addStatementsValue("org.neo4j.graphdb.Node node = graph.createNode(Label.label(\"" + type + "\"));");
                  if (isIn(split, type))
                     javaParserNodeMethod.addStatementsValue("node.setProperty(\"name\",arg0.getName());");
                  javaParserNodeMethod.addStatementsValue("if(!nodes.isEmpty()) {\n\tfinal Relationship relationship = nodes.peek().createRelationshipTo(node, RelationshipType.withName(\"" + type + "\"));\n\trelationship.setProperty(\"nodeType\", \"" + type + "\");\n}");
                  javaParserNodeMethod.addStatementsValue("nodes.push(node);");
                  javaParserNodeMethod.addStatementsValue("super.visit(arg0, arg);");
                  javaParserNodeMethod.addStatementsValue("nodes.pop();");

                  javaParserNodeMethod.addParamsValue(null, null, null, null, null, null, parameter.getName(), parameter.getType().getSimpleName(), null);

                  // nodes:
                  String s = "public class " + type + " extends NeoPTextNode {\n" +
                        "\n" +
                        "\t\tpublic " + type + "(Node node, NeoEditor editor) {\n" +
                        "\t\t\tsuper(node, editor);\n" +
                        "\t\t}\n" +
                        "\t}";

                  if (!nodeClasses.containsKey(type)) {
                     nodeClasses.put(type, s);

                     nodeTypes.add(type);

                     builderGenerator.addMethodsValue(
                           "\npublic void visit" + type + "(org.neo4j.graphdb.Node node) {\n" +
                                 "\tSystem.out.println(node.hasProperty(\"name\") ? node.getProperty(\"name\").toString() : \"" + type + "\");\n" +
                                 "\tfor (Relationship relationship : node.getRelationships(Direction.OUTGOING)) visit(relationship, node);\n" +
                                 "}\n");
                  }
               }
            }

            builderGenerator.addMethodsValue(javaParserNodeMethod);

         }

         private boolean isIn(String[] split, String s) {
            for (String s1 : split)
               if (s1.trim().equals(s)) return true;
            return false;
         }

         @Override
         public void done() {
            try {

               visitMethod.addStatementsValue("final String nodeType = relationship.getProperty(\"nodeType\").toString();");
               final JavaGroup.switchST nodeSwitch = javaGroup.newswitch().setState("nodeType");
               for (String nodeType : nodeTypes)
                  nodeSwitch.addCasesValue(javaGroup.newstring().setValue(nodeType), "visit" + nodeType + "(BaseDomainVisitor.other(node, relationship));");
               visitMethod.addStatementsValue(nodeSwitch);
               builderGenerator.addMethodsValue(visitMethod);

               FileUtil.writeFile(builderGenerator, GeneratedFile.newJavaFile("src/main/java", packageName, debugClass).getFile());

               //todo: write to file directly:
               for (String s : nodeClasses.values()) {
                  System.out.println(s);
               }

            } catch (IOException e) {
               e.printStackTrace();
            }
         }

      }.visit(clazz);
   }

   @Test
   public void createDebugVisitorAdapter() {

      final Class<VoidVisitorAdapter> clazz = VoidVisitorAdapter.class;
      final JavaGroup javaGroup = new JavaGroup();

      final String debugClass = "DebugVisitorAdapter";

      new BaseClassVisitor() {

         final JavaGroup.classST builderGenerator = javaGroup.newclass().
               setPackage(packageName).
               setName(debugClass).
               addImportsValue("com.generator.generators.templates.domain.GeneratedFile").
               addImportsValue("com.generator.util.FileUtil").
               addImportsValue("com.generator.util.StringUtil").
               addImportsValue("com.github.javaparser.ast.*").
               addImportsValue("com.github.javaparser.ast.body.*").
               addImportsValue("com.github.javaparser.ast.comments.*").
               addImportsValue("com.github.javaparser.ast.expr.*").
               addImportsValue("com.github.javaparser.ast.stmt.*").
               addImportsValue("com.github.javaparser.ast.type.*").
               addImportsValue("com.github.javaparser.ast.visitor.VoidVisitorAdapter").
               addImportsValue("java.io.IOException").
               addImportsValue("java.util.Stack;").
               setExtends("VoidVisitorAdapter<Object>");

         @Override
         public void onClass(Package classPackage, String className, Class superClass) {
            builderGenerator.addPropertiesValue(null, null, null, null, null, null, null, null, "indent", "private", "int", null);
         }

         @Override
         public void onPublicMethod(Method method) {
            super.onPublicMethod(method);
         }

         @Override
         public void onPrivateMethod(Method method) {
            super.onPrivateMethod(method);
         }

         @Override
         public void onProtectedMethod(Method method) {
            super.onProtectedMethod(method);
         }

         @Override
         public void onPackageMethod(Method method) {
            super.onPackageMethod(method);
         }

         @Override
         public void onDeclaredMethod(Method method) {

            if (method.getName().equals("visitComment")) return;

            final JavaGroup.methodST methodST = javaGroup.newmethod().
                  setScope(getScope(method)).
                  setName(getName(method)).
                  setReturnVal(getReturnType(method)).
                  addAnnotationsValue("Override");

            for (java.lang.reflect.Parameter parameter : method.getParameters()) {

               if (isParameterized(parameter)) {

               } else if (isGenericArray(parameter)) {

               } else if (isTypeVariable(parameter)) {
                  methodST.addParamsValue(null, null, null, null, null, null, "arg", ((Class) getBounds(asTypeVariableType(parameter))[0]).getSimpleName(), null);


               } else if (isWildcardType(parameter)) {

               } else {
                  methodST.addStatementsValue("System.out.println(StringUtil.pad(indent++, \"-\", \"" + parameter.getType().getSimpleName() + ":\" + arg0.toString().trim() + \" children: \" + arg0.getChildrenNodes().size()));");
                  methodST.addStatementsValue("indent++;");
                  methodST.addParamsValue(null, null, null, null, null, null, parameter.getName(), parameter.getType().getSimpleName(), null);
               }
            }

            builderGenerator.addMethodsValue(methodST.
                  addStatementsValue("super.visit(arg0, arg);").
                  addStatementsValue("indent--;"));
         }

         @Override
         public void done() {
            try {

               FileUtil.writeFile(builderGenerator, GeneratedFile.newJavaFile("src/main/java", packageName, debugClass).getFile());
            } catch (IOException e) {
               e.printStackTrace();
            }
         }

      }.visit(clazz);
   }

   private static void createRecursiveVisitor(Class<VoidVisitorAdapter> clazz) {
      new BaseClassVisitor() {

         final Set<Class> candidateClasses = new LinkedHashSet<>();
         final Set<Class> visitedClasses = new LinkedHashSet<>();

         @Override
         public void onClass(Package classPackage, String className, Class superClass) {
            if (classPackage == null)
               System.out.println("package: [none]\n\tclass: " + className + " \n\tsuper: " + superClass);
            else
               System.out.println("package: " + classPackage.getName() + "\n\tclass: " + className + "\n\tsuper: " + superClass);

            if (superClass != null) candidateClasses.add(superClass);
         }

         @Override
         public void onInterface(Class classInterface) {
            System.out.println("interface: " + classInterface.getName());
            candidateClasses.add(classInterface);
         }

         @Override
         public void onDeclaredMethod(Method method) {
            System.out.println("Method " + getName(method) + " " + getReturnType(method));
         }

         @Override
         public void onConstructorComplete() {
            super.onConstructorComplete();
         }

         @Override
         public void onParameter(String name, Class<?> type) {
            System.out.println("\t" + name + type.getName());
            candidateClasses.add(type);
         }

         @Override
         public void onPublicField(String name, Class<?> returnType) {
            System.out.println("public field " + name + " type " + returnType.getName());
         }

         @Override
         public void onProtectedField(String name, Class<?> returnType) {
            System.out.println("protected field " + name + " type " + returnType.getName());
         }

         @Override
         public void onPackageField(String name, Class<?> returnType) {
            System.out.println("package field " + name + " type " + returnType.getName());
         }

         @Override
         public void onPrivateField(String name, Class<?> returnType) {
            System.out.println("private field " + name + " type " + returnType.getName());
         }

         @Override
         public void onPublicConstructor(String name) {
            System.out.println("public constructor " + name);
         }

         @Override
         public void onProtectedConstructor(String name) {
            System.out.println("protected constructor " + name);
         }

         @Override
         public void onPackageConstructor(String name) {
            System.out.println("package constructor " + name);
         }

         @Override
         public void onPrivateConstructor(String name) {
            System.out.println("private constructor " + name);
         }

         @Override
         public void onInnerClass(Class innerClass) {
            System.out.println("Inner class: " + innerClass.getName());
            candidateClasses.add(innerClass);
         }

         @Override
         public void done() {

            System.out.println("visited " + clazz.getName());
            System.out.println(" ----------------------------------------------------- ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

            visitedClasses.add(clazz);
            if (candidateClasses.isEmpty()) return;

            Class next = null;
            while (next == null) {

               for (Class candidateClass : candidateClasses) {
                  if (visitedClasses.contains(candidateClass)) continue;
                  next = candidateClass;
                  break;
               }

               if (next == null) {
                  System.out.println("Done");
                  return;
               }
            }

            visit(next);
         }
      }.visit(clazz);
   }
}