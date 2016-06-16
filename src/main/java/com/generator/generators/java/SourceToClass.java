package com.generator.generators.java;

import com.generator.domain.DomainEntity;
import com.generator.generators.java.domain.*;
import com.generator.generators.java.parser.JavaParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * User: goe
 * Date: 24.09.13
 */
public class SourceToClass extends JavaParser {

	private Map<String, CompileUnit> compileUnits = new LinkedHashMap<>();
	private Stack<DomainEntity<JavaEntities>> currentEntities = new Stack<>();

	private String currentPackage = "";

	public SourceToClass(String sourceFile) throws IOException {
		super(createLexer(new FileReader(sourceFile)));
		compilationUnit();
	}

	public Map<String, CompileUnit> parse() {
		return compileUnits;
	}

	@Override
	public void enumName(final String name) {

		final JavaEnum javaEnum = new JavaEnum() {

			final String packageName = currentPackage;
			final Collection<EnumValue> values = new ArrayList<>();
			final Map<String, JavaInterface> implement = new LinkedHashMap<>();
			final UUID uuid = UUID.randomUUID();

			@Override
			public String toString() {
				return getName();
			}

			@Override
			public Collection<EnumValue> getValues() {
				return values;
			}

			@Override
			public JavaEntities getDomainType() {
				return JavaEntities.ENUM;
			}

			@Override
			public String getPackage() {
				return packageName;
			}

			@Override
			public String getName() {
				return name;
			}

			@Override
			public Map<String, JavaInterface> getImplements() {
				return implement;
			}

			@Override
			public UUID getUuid() {
				return uuid;
			}
		};
		this.currentEntities.push(javaEnum);
		this.compileUnits.put(name, javaEnum);
	}

	@Override
	public void enumConstant(final String name) {

		final UUID uuid = UUID.randomUUID();

		((JavaEnum) this.currentEntities.peek()).getValues().add(new EnumValue() {

			@Override
			public String toString() {
				return getName();
			}

			@Override
			public String getName() {
				return name;
			}

			@Override
			public UUID getUuid() {
				return uuid;
			}

			@Override
			public JavaEntities getDomainType() {
				return JavaEntities.ENUMVALUE;
			}
		});
	}

	@Override
	public void enumImplements(String implement) {

		final Set<String> impl = new LinkedHashSet<>();
		if (implement.contains(",")) impl.addAll(filter(implement.split(",")));
		else impl.add(implement);

		for (String name : impl)
			((CompileUnit) this.currentEntities.peek()).getImplements().put(name, null);
	}

	private Collection<? extends String> filter(String[] split) {
		final Set<String> result = new TreeSet<>();
		for (String s : split) {
			if (s.trim().isEmpty()) continue;
			result.add(s.trim());
		}
		return result;
	}

	@Override
	public void enumEnd() {
		this.currentEntities.pop();
	}

	@Override
	public void packageName(final String name) {
		 this.currentPackage = name;
	}

	@Override
	public void packageEnd() {
		this.currentEntities.pop();
	}

	@Override
	public void className(String modifier, final String name) {

		final JavaClass javaClass = new JavaClass() {

			public final Collection<Field> fields = new ArrayList<>();
			public final Collection<Method> methods = new ArrayList<>();
			public String packageName = "";
			public final Map<String, JavaInterface> implement = new LinkedHashMap<>();
			public final UUID uuid = UUID.randomUUID();

			@Override
			public String toString() {
				return getName();
			}

			@Override
			public Collection<Field> getFields() {
				return fields;
			}

			@Override
			public Collection<Method> getMethods() {
				return methods;
			}

			@Override
			public JavaEntities getDomainType() {
				return JavaEntities.CLASS;
			}

			@Override
			public String getPackage() {
				return packageName;
			}

			@Override
			public String getName() {
				return name;
			}

			@Override
			public Map<String, JavaInterface> getImplements() {
				return implement;
			}

			@Override
			public UUID getUuid() {
				return uuid;
			}
		};

		this.currentEntities.push(javaClass);
		this.compileUnits.put(name, javaClass);
	}

	@Override
	public void interfaceName(final String name) {

		final JavaInterface javaInterface = new JavaInterface() {

			public final UUID uuid = UUID.randomUUID();
			public Collection<Method> methods = new ArrayList<>();
			public String packageName = "";
			public Map<String, JavaInterface> implement = new LinkedHashMap<>();

			@Override
			public String toString() {
				return getName();
			}

			@Override
			public Collection<Method> getMethods() {
				return methods;
			}

			@Override
			public JavaEntities getDomainType() {
				return JavaEntities.INTERFACE;
			}

			@Override
			public String getPackage() {
				return packageName;
			}

			@Override
			public String getName() {
				return name;
			}

			@Override
			public Map<String, JavaInterface> getImplements() {
				return implement;
			}

			@Override
			public UUID getUuid() {
				return uuid;
			}
		};

		this.currentEntities.add(javaInterface);
		this.compileUnits.put(name, javaInterface);
	}

	@Override
	public void classEnd() {
		currentEntities.pop();
	}

	@Override
	public void interfaceEnd() {
		currentEntities.pop();
	}

	@Override
	public void newField(final String modifier, final String type, final String name, final String initalizer) {

		final UUID uuid = UUID.randomUUID();

		((JavaClass) this.currentEntities.peek()).getFields().add(new Field() {

			@Override
			public String getName() {
				return name;
			}

			@Override
			public String getType() {
				return (modifier == null ? "" : (modifier + " ")) + type;
			}

			@Override
			public JavaEntities getDomainType() {
				return JavaEntities.FIELD;
			}

			@Override
			public String getInitializer() {
				return initalizer;
			}

			@Override
			public UUID getUuid() {
				return uuid;
			}

			@Override
			public String toString() {
				return name + "(" + type + ")" + (initalizer == null ? "" : (" = " + initalizer));
			}
		});
	}

	@Override
	public void newMethod(final String returnType, final String name) {

		final Method javaMethod = new Method() {

			final Collection<MethodArgument> arguments = new ArrayList<>();
			String body;
			final UUID uuid = UUID.randomUUID();

			@Override
			public String toString() {
				return getName();
			}

			@Override
			public String getName() {
				return name;
			}

			@Override
			public String getReturnValue() {
				return returnType;
			}

			@Override
			public Collection<MethodArgument> getArguments() {
				return arguments;
			}

			@Override
			public String methodBody() {
				return body;
			}

			@Override
			public UUID getUuid() {
				return uuid;
			}

			@Override
			public JavaEntities getDomainType() {
				return JavaEntities.METHOD_ARGUMENT;
			}
		};

		((JavaInterface) this.currentEntities.peek()).getMethods().add(javaMethod);
		this.currentEntities.push(javaMethod);
	}

	@Override
	public void newParameter(String modifier, final String type, final String name) {

		final UUID uuid = UUID.randomUUID();

		((Method) this.currentEntities.peek()).getArguments().add(new MethodArgument() {

			@Override
			public UUID getUuid() {
				return uuid;
			}

			@Override
			public boolean isFinal() {
				return false;
			}

			@Override
			public String getName() {
				return name;
			}

			@Override
			public String getType() {
				return type;
			}

			@Override
			public JavaEntities getDomainType() {
				return JavaEntities.METHOD_ARGUMENT;
			}

			@Override
			public String toString() {
				return name + "(" + type + ")";
			}
		});
	}

	@Override
	public void endMethod(final String methodBody) {
		this.currentEntities.pop();
	}

	@Override
	public void newLocalVariableStatement(String statement) {
		super.newLocalVariableStatement(statement);
	}

	@Override
	public void newStatement(String statement) {
		System.out.println("STATEMENT: " + statement);
	}

	@Override
	public void newBlock() {
		super.newBlock();
	}

	@Override
	public void newTypeDeclaration(String declaration) {
		super.newTypeDeclaration(declaration);
	}

	@Override
	public void importName(String packageName, String name) {
		// todo use this to map package-less types
		System.out.println("IMPORT:" + packageName + " " + name);
	}

	@Override
	public void interfaceExtends(String name) {
		super.interfaceExtends(name);
	}

	@Override
	public void endBlock() {
		super.endBlock();
	}

	@Override
	public void annotationName(String name) {
		System.out.println("ANNOTATION: " + name);
	}
}