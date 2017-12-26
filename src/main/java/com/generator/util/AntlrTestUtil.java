package com.generator.util;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;

/**
 * Created 21.10.17.
 */
public class AntlrTestUtil {
	private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AntlrTestUtil.class);
	@FunctionalInterface
	public interface RuleTester<P extends Parser, C extends ParserRuleContext> {
		C apply(P parser);
	}

	private static Class getClass(final Package pkg, final String name) {
		try {
			return Class.forName(pkg.getName() + "." + name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		throw new RuntimeException("Class " + pkg.getName() + "." + name + " was not found");
	}

	private static Constructor getConstructor(final Class clazz, final String argType) {
		for (Constructor ctor : clazz.getDeclaredConstructors()) {

			if (ctor.getParameterCount() != 1) continue;

			if (ctor.getGenericParameterTypes()[0].getTypeName().equals(argType)) {
				ctor.setAccessible(true);
				return ctor;
			}
		}

		throw new RuntimeException("Constructor " + clazz.getName() + "(" + argType + ") was not found");
	}

	@SuppressWarnings("unchecked")
	@NotNull
	private static <X extends Lexer> X newLexer(final Class<X> clazz, CharStream charStream) {
		Constructor ctor = getConstructor(clazz, CharStream.class.getName());

		try {
			return (X) ctor.newInstance(charStream);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		throw new RuntimeException("Constructor " + clazz.getName() + "(" + CharStream.class.getName() + ") was not found");
	}

	@SuppressWarnings("unchecked")
	@NotNull
	private static <P extends Parser> P newParser(final Class<P> clazz, TokenStream tokenStream) {
		Constructor ctor = getConstructor(clazz, TokenStream.class.getName());

		try {
			return (P) ctor.newInstance(tokenStream);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		throw new RuntimeException("Constructor " + clazz.getName() + "(" + TokenStream.class.getName() + ") was not found");
	}

	@SuppressWarnings("unchecked")
	@NotNull
	private static <L extends ParseTreeListener> L newParseTreeListener(final Class<L> clazz, boolean debug) {
		Constructor ctor = getConstructor(clazz, "boolean");

		try {
			return (L) ctor.newInstance(debug);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		throw new RuntimeException("Constructor " + clazz.getName() + "(" + TokenStream.class.getName() + ") was not found");
	}

	@NotNull
	private static <X extends Lexer> CommonTokenStream newTokenStream(Class<X> lexerClass, CharStream charStream) {
		return new CommonTokenStream(newLexer(lexerClass, charStream));
	}

	public static <L extends ParseTreeListener, X extends Lexer, P extends Parser> void testParserRule(Class<L> listenerClass, Class<X> lexerClass, Class<P> parserClass, RuleTester ruleContextFunction, final String input, boolean debug) throws IOException {
		testParserRule(listenerClass, lexerClass, parserClass, ruleContextFunction, CharStreams.fromString(input), debug);
	}

	public static <L extends ParseTreeListener, X extends Lexer, P extends Parser> void testParserRule(Class<L> listenerClass, Class<X> lexerClass, Class<P> parserClass, RuleTester ruleContextFunction, final Path source, boolean debug) throws IOException {
		testParserRule(listenerClass, lexerClass, parserClass, ruleContextFunction, CharStreams.fromPath(source), debug);
	}

	@SuppressWarnings("unchecked")
	public static <L extends ParseTreeListener, X extends Lexer, P extends Parser> void testParserRule(Class<L> listenerClass, Class<X> lexerClass, Class<P> parserClass, RuleTester ruleContextFunction, CharStream charStream, boolean debug) throws IOException {
		new ParseTreeWalker().walk(
			newParseTreeListener(listenerClass, debug),
			ruleContextFunction.apply(
				newParser(
					parserClass,
					newTokenStream(lexerClass, charStream)
				)
			)
		);
	}

	public static <L extends Lexer> void testLexer(Class<L> clazz, final String input) throws IOException {
		testLexer(clazz, CharStreams.fromString(input));
	}

	public static <L extends Lexer> void testLexer(Class<L> clazz, final Path path) throws IOException {
		testLexer(clazz, CharStreams.fromPath(path));
	}

	public static <L extends Lexer> void testLexer(Class<L> clazz, CharStream charStream) throws IOException {
		Lexer lexer = newLexer(clazz, charStream);

		Token token = lexer.nextToken();

		while (token != null) {
			log.info(token.getType() + ": " + token.getText());
			if (token.getText().equals("<EOF>")) break;
			token = lexer.nextToken();
		}
	}
}
