package com.generator.generators.java;

import com.generator.editors.domain.MetaDomain;
import com.generator.editors.domain.NeoModel;
import com.generator.generators.easyFlow.EasyFlowDomain;
import com.generator.generators.java.domain.*;
import com.generator.generators.java.parser.JavaParser;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import org.junit.Test;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static com.generator.generators.easyFlow.EasyFlowDomain.RELATIONS.PROPERTY;
import static com.generator.generators.java.parser.JavaParser.createLexer;

/**
 * User: goe
 * Date: 24.09.13
 */
public class Tests {

	public static void main(String[] args) {

		final GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabase("src/test/tests/db");
		final JavaDomain domain = new JavaDomain(new NeoModel(db));

		domain.commit(new MetaDomain.Committer() {
			@Override
			public void doAction(Transaction tx) {
				final Node packageNode = domain.addPACKAGE(UUID.randomUUID(), null, "PACKAGENAME");
				final Node classNode = domain.addCLASS(UUID.randomUUID(), "ClassName", "true", "true", "false");
				domain.relatePACKAGE_MEMBER_CLASS(packageNode, classNode);
			}

			@Override
			public void exception(Throwable throwable) {

			}
		});

		SwingUtil.setLookAndFeel_Nimbus();

		final JavaDomainEditor editor = Java.newJavaDomainEditor(domain);
		final JFrame frame = new JFrame("JavaDomain");
		frame.addKeyListener(editor);
		frame.getContentPane().add(editor, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SwingUtil.show(frame);

	}

	@Test
	public void testJavaGroup() {
		final JavaGroup group = new JavaGroup();

		final JavaGroup.classST classST = group.newclass().setName("CLASSNAME").setAbstract(false).setFinal(true).addPropertiesValue(null, false, null, false, false, false, null, true, "name", "protected", "String", null);
		System.out.println(classST);

		System.out.println(group.newsendEmail().
				addAttachmentsValue("\"D:\\\\projects\\\\generator\\\\src\\\\com\\\\generator\\\\generators\\\\java\\\\java.stg\"").
				addAttachmentsValue("\"D:\\\\projects\\\\generator\\\\src\\\\com\\\\generator\\\\generators\\\\java\\\\javaGroup.java\"").
				setFrom("geirove@mailudc.com").
				setHost("localhost").
				setMessageBody("\"Body\"").
				setSubject("\"TEST\"").
				addRecipientsValue("ernst@mailudc.com").
				addRecipientsValue("geirove@mailudc.com")
		);
	}

	@Test
	public void testSourceToClass() throws IOException {

		// parse these files:
		final List<File> files = FileUtil.findAllFilesWhichEndsWith("/media/storage/projects/ucs-node/src/main/java/com/ucs/network/server", ".java");

		// clean db for each run:
		FileUtil.removeFilesUnder("src/test/tests/db");
		final NeoModel db = new NeoModel(new GraphDatabaseFactory().newEmbeddedDatabase("src/test/tests/db"));

		for (File file : files) {

			if (file.getName().contains("HttpRequestFSM")) {

				try (Transaction tx = db.beginTx()) {

					final Node flowNode = db.newNode(EasyFlowDomain.ENTITIES.Flow.name(), UUID.randomUUID(), "name", "HttpRequest");

					final Map<String, CompileUnit> set = new SourceToClass(file.getAbsolutePath()).parse();
					for (CompileUnit sourceToClass : set.values()) {

						//parse statement from transitions statement

						System.out.print(sourceToClass.getUuid() + " " + sourceToClass.getDomainType() + " " + sourceToClass.getPackage() + " " + sourceToClass.getName() + " " + sourceToClass.getImplements().keySet());

						switch (sourceToClass.getDomainType()) {
							case PACKAGE:
								System.out.println();
								break;
							case CLASS:
								final JavaClass javaClass = (JavaClass) sourceToClass;
								System.out.println("");
								if (javaClass.getName().contains("RequestContext")) {
									for (Field field : javaClass.getFields()) {
										System.out.println("\t" + field.getUuid() + " " + field.getDomainType() + " " + field.getName() + " " + field.getType() + " " + field.getInitializer());
										final Node contextPropertyNode = db.newNode(EasyFlowDomain.ENTITIES.ContextProperty.name(), UUID.randomUUID(), "name", field.getName(), "type", field.getType(), "value", field.getInitializer());
										flowNode.createRelationshipTo(contextPropertyNode, PROPERTY);
									}

									for (Method method : javaClass.getMethods()) {
										System.out.println("\t" + method.getUuid() + " " + method.getDomainType() + " " + method.getName() + " " + method.getArguments() + " " + method.getReturnValue());
									}
								}
								//printClass(javaClass);
								break;

							case INTERFACE:
								final JavaInterface javaInterface = (JavaInterface) sourceToClass;
								System.out.println();
								for (Method method : javaInterface.getMethods()) {
									System.out.println("\t" + method.getUuid() + " " + method.getDomainType() + " " + method.getName() + " " + method.getArguments() + " " + method.getReturnValue());
								}
								break;

							case ENUM:
								final JavaEnum javaEnum = (JavaEnum) sourceToClass;
								System.out.println(" " + javaEnum.getName());
								if (javaEnum.getName().contains("States")) {
									for (EnumValue states : javaEnum.getValues()) {
										System.out.println("\t state : " + states.getUuid() + " " + states.getDomainType() + " " + states.getName());
									}

								} else if (javaEnum.getName().contains("Events")) {
									for (EnumValue events : javaEnum.getValues()) {
										System.out.println("\t event : " + events.getUuid() + " " + events.getDomainType() + " " + events.getName());
									}
								}
								//printEnum(javaEnum);
								break;
							case ANNOTATION:
								System.out.println();
								break;
							case METHOD:
								System.out.println();
								break;
							case FIELD:
								System.out.println();
								break;
							case ENUMVALUE:
								System.out.println("\t" + sourceToClass.getName());
								break;
						}
					}
					tx.success();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void printEnum(JavaEnum sourceToClass) {
		System.out.println("ENUM: " + sourceToClass.getPackage() + "." + sourceToClass.getName() + (sourceToClass.getImplements().isEmpty() ? "" : (sourceToClass.getImplements())));
		for (EnumValue enumValue : sourceToClass.getValues()) {
			System.out.println("\t" + enumValue.getName());
		}
	}

	private void printClass(JavaClass sourceToClass) {
		System.out.println(sourceToClass.getPackage() + "." + sourceToClass.getName());
		for (Field field : sourceToClass.getFields())
			System.out.println("\t" + field);
		for (Method method : sourceToClass.getMethods())
			System.out.println("\t\t" + method);
	}

	@Test
	public void testJarParsing() throws IOException {

		final JarFile jarFile = new JarFile("/media/storage/projects/filmjump/lib/netty-3.6.6.Final.jar");

		final Enumeration<JarEntry> entries = jarFile.entries();
		while (entries.hasMoreElements()) {
			final JarEntry entry = entries.nextElement();
			if (entry.getName().contains(".")) {
				System.out.println("File : " + entry.getName());

				if (entry.getName().toLowerCase().endsWith(".java")) {
					JarEntry fileEntry = jarFile.getJarEntry(entry.getName());
					InputStream input = jarFile.getInputStream(fileEntry);
					parse(new InputStreamReader(input));
				}
			}
		}
	}

	@Test
	public void testJavaBeansFuck() throws IOException {

		final String fuck = "package com.com.com;\n" +
			"\n" +
			"import java.beans.*;\n" +
			"import java.beans.*;\n" +
			"import java.util.*;\n" +
			"\n" +
			"import java.util.*;\n" +
			"\n" +
			"class Xxx  {\n" +
			"\n" +
			"   final PropertyChangeSupport propertySupport;\n" +
			"   final VetoableChangeSupport vetoSupport;\n" +
			"   private eee www;\n" +
			"\n" +
			"   // change support\n" +
			"   private final PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);  // change support\n" +
			"   private final VetoableChangeSupport vetoSupport = new VetoableChangeSupport(this);      // veto support\n" +
			"\n" +
			"   public Xxx(PropertyChangeSupport propertySupport, VetoableChangeSupport vetoSupport, eee www) {\n" +
			"      this.propertySupport = propertySupport;\n" +
			"      this.vetoSupport = vetoSupport;\n" +
			"      this.www = www;\n" +
			"   }\n" +
			"\n" +
			"   public Xxx() {\n" +
			"   }\n" +
			"\n" +
			"   public void setPropertySupport(PropertyChangeSupport propertySupport)  {\n" +
			"      this.propertySupport = propertySupport;\n" +
			"   }\n" +
			"\n" +
			"   public PropertyChangeSupport getPropertySupport() {\n" +
			"      return propertySupport;\n" +
			"   }\n" +
			"\n" +
			"\n" +
			"   public void setVetoSupport(VetoableChangeSupport vetoSupport)  {\n" +
			"      this.vetoSupport = vetoSupport;\n" +
			"   }\n" +
			"\n" +
			"   public VetoableChangeSupport getVetoSupport() {\n" +
			"      return vetoSupport;\n" +
			"   }\n" +
			"\n" +
			"\n" +
			"   public void setWww(eee www)  {\n" +
			"      this.www = www;\n" +
			"   }\n" +
			"\n" +
			"   public eee getWww() {\n" +
			"      return www;\n" +
			"   }\n" +
			"\n" +
			"    public void addPropertyChangeListener() {  } \n" +
			"    public void removePropertyChangeListener() {  } \n" +
			"    public void addVetoableChangeListener() {  } \n" +
			"    public void removeVetoableChangeListener() {  } \n" +
			"\n" +
			"   public void addPropertyChangeListener(PropertyChangeListener pcl) {\n" +
			"       propertySupport.addPropertyChangeListener(pcl);\n" +
			"   }\n" +
			"\n" +
			"   public void removePropertyChangeListener(PropertyChangeListener pcl) {\n" +
			"       propertySupport.removePropertyChangeListener(pcl);\n" +
			"   }\n" +
			"\n" +
			"   public void addVetoableChangeListener(VetoableChangeListener vcs) {\n" +
			"       vetoSupport.addVetoableChangeListener(vcs);\n" +
			"   }\n" +
			"\n" +
			"   public void removeVetoableChangeListener(VetoableChangeListener vcs) {\n" +
			"       vetoSupport.removeVetoableChangeListener(vcs);\n" +
			"   }\n" +
			"\n" +
			"\n" +
			"}";

		parse(new StringReader(fuck));
	}

	private void parse(final Reader reader) throws IOException {
		new JavaParser(createLexer(reader)) {
			@Override
			public void packageName(String name) {
				System.out.println(name);
			}

			@Override
			public void importName(String packageName, String name) {
				System.out.println("importing : " + packageName + " - " + name);
			}

			@Override
			public void className(String modifier, String name) {
				System.out.println("\t" + name);
			}

			@Override
			public void interfaceName(String name) {
				System.out.println("\t" + name);
			}

			@Override
			public void annotationName(String name) {
				System.out.println("@ -> " + name);
			}

			@Override
			public void newBlock() {
				System.out.println("\t\t");
			}

			@Override
			public void endBlock() {
				System.out.println("\t\t");
			}

			@Override
			public void newLocalVariableStatement(String statement) {
				System.out.println("\t\t\t" + statement);
			}

			@Override
			public void newStatement(String statement) {
				System.out.println("\t\t\t" + statement);
			}

			@Override
			public void newTypeDeclaration(String declaration) {
				System.out.println("\t\t\t" + declaration);
			}

			@Override
			public void interfaceExtends(String name) {

				final String[] s = name.split(",");
				for (String ss : s) {
					System.out.println("extends: '" + ss + "'");
				}
			}

			@Override
			public void enumName(String name) {
				System.out.println("\t" + name);
			}

			@Override
			public void newMethod(String returnType, String name) {
				System.out.println("\t\t" + name + "() : " + returnType);
			}

			@Override
			public void newParameter(String modifier, String type, String name) {
				System.out.println("\t\t\t:" + modifier + " " + type + " " + name);
			}

			@Override
			public void newField(String modifier, String type, String name, String initalizer) {
				System.out.println("\t\t" + (modifier == null ? "" : (modifier + " ")) + name + "(" + type + ")" + ((initalizer != null && initalizer.length() > 0) ? (" = " + initalizer) : ""));
			}

			@Override
			public void endMethod(String methodBody) {
				System.out.println("\t\t" + methodBody);
			}
		}.compilationUnit();
	}
}