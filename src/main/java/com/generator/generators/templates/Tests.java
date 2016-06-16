package com.generator.generators.templates;

import com.generator.generators.generatorDomain.GeneratorDomainGroup;
import com.generator.generators.templates.domain.TemplateFile;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.generators.templates.parser.TemplateFileParser;
import com.generator.util.FileUtil;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

import static com.generator.util.StringUtil.capitalize;

/**
 * User: goe
 * Date: 18.06.14
 */
public class Tests {

	@Test
	public void testDomainFromTemplate() {

		final GeneratorDomainGroup domainGroup = new GeneratorDomainGroup();

		final String test = createBuilderClass(new File("src/com/generator/generators/protobuf/Protobuf.stg"), "protobufPackage", "com.generator.generators.protobuf", domainGroup);
		System.out.println(test);
		FileUtil.write(test, new File("src/com/generator/generators/protobuf/ProtobufDomainTest.java"));
	}

	private String createBuilderClass(File groupTemplateFile, String rootTemplate, String packageName, GeneratorDomainGroup stGroup) {

		final java.util.List<TemplateStatement> statements = new TemplateFileParser().parse(groupTemplateFile).getStatements();
		final String domainName = getDomainName(groupTemplateFile) + "DomainTest";

		final GeneratorDomainGroup.domainST domainST = stGroup.newdomain().
			setPackage(packageName).
			setName(domainName).
			setRoot(rootTemplate);

		for (TemplateStatement statement : statements) {
			processStatement(stGroup, domainST, statement);
		}

		return domainST.toString();
	}

	private void processStatement(GeneratorDomainGroup stGroup, GeneratorDomainGroup.domainST domainST, TemplateStatement statement) {

		final String name = statement.getName();

		final GeneratorDomainGroup.entityDeclarationST declarationST = stGroup.newentityDeclaration().
			setName(name);

		final GeneratorDomainGroup.addEntityST addEntityST = stGroup.newaddEntity().
			setName(name);

		GeneratorDomainGroup.defaultValuesAccessorST defaultValueAccessor = null;
		GeneratorDomainGroup.defaultValuesST defaultValues = null;

		for (TemplateParameter templateParameter : statement.getParameters()) {

			addEntityST.addPropertiesValue(templateParameter.getPropertyName());

			Object setter = null;
			switch (templateParameter.getDomainEntityType()) {
				case KEYVALUELISTPROPERTY:

//                        final TemplateBuilders.StatementKeyValueListPropertySetterST kvSetter = builder.newStatementKeyValueListPropertySetter().setPropertyName(templateParameter.getPropertyName()).setStatementName(name);
//                        for (String kvName : templateParameter.getKvNames()) kvSetter.addKvNamesValue(kvName);
//                        setter = kvSetter;
					break;

				case STRINGPROPERTY:
				case BOOLEANPROPERTY:

					declarationST.addPropertiesValue(stGroup.newpropertyInstantiation().
						setName(templateParameter.getPropertyName()).
						setType("String"));
					break;

				case STATEMENTPROPERTY:


					break;

				case LISTPROPERTY:
//                        setter = builder.newStatementListPropertySetter().setPropertyName(templateParameter.getPropertyName()).setStatementName(name);
					break;
			}
//                declarationST.addPropertiesValue(templateParameter.getPropertyName(), setter);
		}

		domainST.addEntitiesValue(addEntityST, declarationST, defaultValueAccessor, defaultValues, name);
	}

	private static String getDomainName(File groupTemplateFile) {
		return capitalize(groupTemplateFile.getName().substring(0, groupTemplateFile.getName().length() - 4));
	}

	@Test
	public void testTemplateDomainGenerator() throws IOException {

		final String colorData = "'rgb(141,211,199) rgb(255,255,179) rgb(190,186,218) rgb(251,128,114) rgb(128,177,211) rgb(253,180,98) rgb(179,222,105) rgb(252,205,229) rgb(217,217,217) rgb(188,128,189) rgb(204,235,197) rgb(255,237,111)";
		final AtomicInteger currentColor = new AtomicInteger(0);
		final Map<Integer, Color> colorMap = new TreeMap<>();
		for (String rgb : colorData.split(" ")) {
			final String[] c = rgb.substring(5, rgb.length() - 1).split(",");
			colorMap.put(currentColor.incrementAndGet(), new Color(Integer.valueOf(c[0]), Integer.valueOf(c[1]), Integer.valueOf(c[2])));
		}

		final String pathname = "src/com/generator/generators/protobuf/Protobuf.stg";

		//final String packageName = pathname.substring(pathname.indexOf("/src/") + 5, pathname.lastIndexOf("/")).replaceAll("/", ".");
		final String packageName = "com.generator.generators.templates.domainBuilder";
		final File file = new File(pathname);

		final String domainName = capitalize(file.getName().substring(0, file.getName().length() - 4)) + "Domain";
		final GeneratorDomainGroup domainGroup = new GeneratorDomainGroup();

		final GeneratorDomainGroup.domainST domainST = domainGroup.newdomain().
			setName(domainName).
			setPackage(packageName);

		final GeneratorDomainGroup.relationDeclarationST declarationST = domainGroup.newrelationDeclaration().
			setName("PROTOBUFDOMAIN").
			setCardinality("OneToMany").
			setDirection("OneWay");

		// add domain-entity
		addEntity(currentColor, colorMap, domainGroup, domainST, domainName);
		declarationST.addSourceValue(domainName);

		final TemplateFile templateFile = new TemplateFileParser().parse(file);
		boolean first = true;
		for (TemplateStatement templateStatement : templateFile.getStatements()) {
			if (first)
				domainST.setRoot(templateStatement.getName());

			declarationST.addDestinationValue(templateStatement.getName());
			addEntity(currentColor, colorMap, domainGroup, domainST, templateStatement.getName());

			first = false;
		}

		domainST.addRelationsValue(null, declarationST, domainName);

		FileUtil.writeToFile(domainST, new File("src/com/generator/generators/templates/domainBuilder/" + domainName + ".java"));
	}

	private void addEntity(AtomicInteger currentColor, Map<Integer, Color> colorMap, GeneratorDomainGroup domainGroup, GeneratorDomainGroup.domainST domainST, String templateStatement) {
		if (currentColor.incrementAndGet() > colorMap.size()) currentColor.addAndGet(-colorMap.size()); // funny

		final Color color = colorMap.get(currentColor.get());
		final String hex = Integer.toHexString(color.getRGB()).substring(2);

		domainST.addEntitiesValue(null, domainGroup.newentityDeclaration().
				setName(templateStatement)
			, null, null,
			templateStatement);
	}

	@Test
	public void testTemplateParser() throws IOException {
		/*new TemplateFileParser().parse(new File("D:/projects/generator/src/com/generator/generators/protobuf/protobuf.stg"));*/

//        System.out.println("\n" + new TemplateFileParser().parse("$", "simple", "TEXT$if(aa_stringProperty)$TEXT$endif$TEXT"));
//        System.out.println("\n" + new TemplateFileParser().parse("$", "list", "TEXT$cc_listProperty:{cc_it|TEXT$cc_it$TEXT};separator=\",\"$TEXT"));
//        System.out.println("\n" + new TemplateFileParser().parse("$", "keyValue", "TEXT$dd_kvProperty:{dd_it|TEXT$dd_it.dd_one$TEXT$dd_it.dd_two$TEXT};separator=\",\"$TEXT"));

		System.out.println("\n" + new TemplateFileParser().parse("~", "cutoff", "\n" +
			"<modelVersion>4.0.0</modelVersion>\n" +
			"<groupId>~groupId~</groupId>\n" +
			"<artifactId>~artifactId~</artifactId>\n" +
			"<version>~version~</version>"));
	}

	@Test
	public void testTemplateStatement() throws IOException {
		//new TemplateFileParser().parse(new File("templates/parserTest.stg"));
		final java.util.List<TemplateStatement> statements = new TemplateFileParser().parse(new File("D:/projects/filmjump/templates/domain.stg")).getStatements();
		for (TemplateStatement templateStatement : statements) {
			//   System.out.println(templateStatement.getName());
			for (TemplateParameter templateParameter : templateStatement.getParameters()) {
				//    System.out.println("\n" + templateParameter);
			}
		}
	}


	@Test
	public void testPrototype() {
		final TemplateFile parse = new TemplateFileParser().parse(new File("D:\\projects\\generator\\src\\com\\generator\\parsers\\template\\parsed.stg"), true);
		for (TemplateStatement templateStatement : parse.getStatements()) {
			System.out.println(templateStatement.getName());
			for (TemplateParameter templateParameter : templateStatement.getParameters()) {
				System.out.println("\t" + templateParameter.getPropertyName() + " " + templateParameter.getDomainEntityType());
			}
		}
	}

	@Test
	public void testAllTemplates() {
		final File[] templates = new File("templates").listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().toLowerCase().endsWith(".stg");
			}
		});

		for (File template : templates) {
			new TemplateFileParser().parse(template);
		}
	}

	@Test
	public void testTemplateFile() throws IOException {

		final TemplateFile templateFile = new TemplateFileParser().parse(new File("src/com/generator/generators/protobuf/Protobuf.stg"));
		for (TemplateStatement templateStatement : templateFile.getStatements()) {
			System.out.println(templateStatement.getName() + " ");
			for (TemplateParameter parameter : templateStatement.getParameters()) {
				System.out.println("\t" + parameter);
			}
		}
	}
}
