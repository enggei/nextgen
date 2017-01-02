package com.generator.util;

import javax.tools.*;
import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.SecureClassLoader;
import java.util.*;

public class CompileUtil {

	public static void main(String[] args) {
		String str = "package com.test;"
			+ "\n" + "public class Test {"
			+ "\npublic static void test() {"
			+ "\nSystem.out.println(\"Comiler API Test\");" + ""
			+ "\n}" + "\n}";

		SimpleJavaFileObject fileObject = new CharSequenceJavaFileObject("com.test.Test", str);
		JavaFileObject javaFileObjects[] = new JavaFileObject[]{fileObject};
		Iterable<? extends JavaFileObject> compilationUnits = Arrays
			.asList(javaFileObjects);

//		Iterable<String> compilationOptionss = Arrays.asList(new String[]{"-d", "classes"});
		Iterable<String> compilationOptionss = Arrays.asList();

		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		JavaFileManager fileManager = compiler.getStandardFileManager(
			diagnostics, Locale.getDefault(), Charset.defaultCharset());
		JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics,
			compilationOptionss, null, compilationUnits);
		boolean status = task.call();

		if (!status) {
			System.out.println("Found errors in compilation");
			int errors = 1;
			for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
				printError(errors, diagnostic);
				errors++;
			}
		} else
			System.out.println("Compilation sucessfull");

		try {
			fileManager.close();
		} catch (IOException e) {
		}

	}

	public static void printError(int number, Diagnostic diagnostic) {
		System.out.println();
		System.out.print(diagnostic.getKind() + "  : " + number + " Type : " + diagnostic.getMessage(Locale.getDefault()));
		System.out.print(" at column : " + diagnostic.getColumnNumber());
		System.out.println(" Line number : " + diagnostic.getLineNumber());
		System.out.println("Source : " + diagnostic.getSource());
	}

	public static CompilationResult compile(File[] sourceFiles, String outputDir, Writer out) {

		final CompilationResult result = new CompilationResult();

		for (File sourceFile : sourceFiles) {

			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

			try {
				fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(new File(outputDir)));

				// Compile the file
				final Boolean call = compiler.getTask(out, fileManager, null, null, null, fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile))).call();
				System.out.println("compiled = " + call);
				fileManager.close();

			} catch (IOException e) {
				result.erroneous.put(sourceFile, e);
			}
		}

		return result;
	}

	public static class CompilationResult {

		private final Map<File, Throwable> erroneous = new TreeMap<>();

		public Map<File, Throwable> getErroneous() {
			return erroneous;
		}

		public boolean success() {
			return erroneous.size() == 0;
		}
	}

	public static <T> T compileAndLoad(String fullName, Object src) throws Exception {

		final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		final JavaFileManager fileManager = new ClassFileManager(compiler.getStandardFileManager(null, null, null));

		final Class<?> loadedClass = getClass(fullName, src, compiler, fileManager);

		final T t = (T) loadedClass.newInstance();
		fileManager.close();
		return t;
	}

	public static Class<?> getClass(String fullName, Object src) throws Exception {
		final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		final JavaFileManager fileManager = new ClassFileManager(compiler.getStandardFileManager(null, null, null));
		return getClass(fullName, src, compiler, fileManager);
	}

	private static Class<?> getClass(String fullName, Object src, JavaCompiler compiler, JavaFileManager fileManager) throws ClassNotFoundException {
		final List<JavaFileObject> inMemoryFiles = new ArrayList<>(1);
		inMemoryFiles.add(new CharSequenceJavaFileObject(fullName, src.toString()));
		compiler.getTask(null, fileManager, null, null, null, inMemoryFiles).call();
		return fileManager.getClassLoader(null).loadClass(fullName);
	}

	private static final class CharSequenceJavaFileObject extends SimpleJavaFileObject {

		private CharSequence content;

		public CharSequenceJavaFileObject(String className, CharSequence content) {
			super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
			this.content = content;
		}

		@Override
		public CharSequence getCharContent(boolean ignoreEncodingErrors) {
			return content;
		}
	}

	public static final class JavaClassObject extends SimpleJavaFileObject {

		protected final ByteArrayOutputStream bos = new ByteArrayOutputStream();

		public JavaClassObject(String name, Kind kind) {
			super(URI.create("string:///" + name.replace('.', '/') + kind.extension), kind);
		}

		public byte[] getBytes() {
			return bos.toByteArray();
		}

		@Override
		public OutputStream openOutputStream() throws IOException {
			return bos;
		}
	}

	public static class ClassFileManager extends ForwardingJavaFileManager {

		private JavaClassObject jclassObject;

		public ClassFileManager(StandardJavaFileManager standardManager) {
			super(standardManager);
		}

		@Override
		public ClassLoader getClassLoader(Location location) {
			return new SecureClassLoader() {
				@Override
				protected Class<?> findClass(String name) throws ClassNotFoundException {
					byte[] b = jclassObject.getBytes();
					return super.defineClass(name, jclassObject.getBytes(), 0, b.length);
				}
			};
		}

		@Override
		public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
			jclassObject = new JavaClassObject(className, kind);
			return jclassObject;
		}
	}
}