package nextgen.templates.java;

public class JavaCompiler {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private String _name;
	private java.util.List<JCMethod> _methods = new java.util.ArrayList<>();

	JavaCompiler(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JavaCompiler");
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _methods) st.add("methods", o);
		return st.render().trim();
	}

	public JavaCompiler setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public JavaCompiler removePackageName() {
		this._packageName = null;
		return this;
	} 

	public JavaCompiler setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public JavaCompiler removeName() {
		this._name = null;
		return this;
	} 

	public JavaCompiler addMethods(JCMethod value) {
		this._methods.add(value);
		return this;
	}

	public JavaCompiler setMethods(JCMethod[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JavaCompiler setMethods(java.util.Collection<JCMethod> values) {
		this._methods.addAll(values);
		return this;
	}

	public JavaCompiler removeMethods(JCMethod value) {
		this._methods.remove(value);
		return this;
	}

	public JavaCompiler removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<JCMethod> getMethods() {
		return this._methods;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JavaCompiler that = (JavaCompiler) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JavaCompiler(packageName,name,methods) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"class ~name~ {\n" + 
				"\n" + 
				"   private static final java.io.PrintStream log = System.out;\n" + 
				"\n" + 
				"   public static void main(String[] args) throws java.io.IOException {\n" + 
				"\n" + 
				"      final String newClass = \"NEWCLASS\";\n" + 
				"      final java.nio.file.Path copypath = copy(\"/home/goe/projects/compiler/src/main/java\", \".java\", \"CLASS\", newClass);\n" + 
				"\n" + 
				"      assert copypath != null;\n" + 
				"      final Class<?> aClass = compile(newClass, java.nio.file.Files.readString(copypath));\n" + 
				"\n" + 
				"      assert aClass != null;\n" + 
				"      final Object anObject = instanceOf(aClass, 0, null);\n" + 
				"\n" + 
				"      assert anObject != null;\n" + 
				"      apply(anObject, 0, null);\n" + 
				"   }\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"   private static Class<?> compile(String name, String source) {\n" + 
				"      log.println(java.util.Arrays.toString(new String[]{\"compile\", name, source}));\n" + 
				"      try {\n" + 
				"         return net.openhft.compiler.CompilerUtils.CACHED_COMPILER.loadFromJava(name, source);\n" + 
				"      } catch (Throwable e) {\n" + 
				"         error(e);\n" + 
				"         return null;\n" + 
				"      }\n" + 
				"   }\n" + 
				"\n" + 
				"   private static Object instanceOf(Class<?> aClass, int constructor, Object[] args) {\n" + 
				"      assert aClass != null;\n" + 
				"      log.println(java.util.Arrays.toString(new String[]{\"instantiate\", aClass.toString(), Integer.toString(constructor), java.util.Arrays.toString(args)}));\n" + 
				"\n" + 
				"      final java.lang.reflect.Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();\n" + 
				"      final java.lang.reflect.Constructor<?> declaredConstructor = declaredConstructors[constructor];\n" + 
				"      try {\n" + 
				"         if (args == null) return declaredConstructor.newInstance();\n" + 
				"         else return declaredConstructor.newInstance(args);\n" + 
				"      } catch (Throwable e) {\n" + 
				"         error(e);\n" + 
				"         return null;\n" + 
				"      }\n" + 
				"   }\n" + 
				"\n" + 
				"   private static void apply(Object anObject, int method, Object[] args) {\n" + 
				"      log.println(java.util.Arrays.toString(new String[]{\"invoke\", anObject.toString(), Integer.toString(method), java.util.Arrays.toString(args)}));\n" + 
				"\n" + 
				"      final java.lang.reflect.Method[] methods = anObject.getClass().getMethods();\n" + 
				"      try {\n" + 
				"         if (args == null) methods[method].invoke(anObject);\n" + 
				"         else methods[method].invoke(anObject, args);\n" + 
				"      } catch (Throwable e) {\n" + 
				"         error(e);\n" + 
				"      }\n" + 
				"   }\n" + 
				"\n" + 
				"   private static void error(Throwable e) {\n" + 
				"      log.println(java.util.Arrays.toString(new String[]{\"!\", e.getClass().getCanonicalName(), e.getMessage(), java.util.Arrays.toString(e.getStackTrace())}));\n" + 
				"   }\n" + 
				"} >>";
}  