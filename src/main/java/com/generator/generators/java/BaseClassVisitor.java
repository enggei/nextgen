package com.generator.generators.java;

import com.generator.util.StringUtil;

import java.lang.reflect.*;
import java.util.Arrays;

import static java.lang.reflect.Modifier.*;

/**
 * goe on 9/5/16.
 * <p>
 * used as  base-class for class visitors. can create panels, verticles etc. from all other java classes
 * todo: make editor for this:
 */
public abstract class BaseClassVisitor {

	protected BaseClassVisitor() {
	}

	public final void visit(Class clazz) {

		onClass(clazz.getPackage(), clazz.getName(), clazz.getSuperclass());

		for (Class classInterface : clazz.getInterfaces())
			onInterface(classInterface);

		for (Field field : clazz.getDeclaredFields()) {

			final String name = field.getName();
			final Class<?> returnType = field.getType();
			// todo: simplify
			if (isPublic(field.getModifiers()))
				onPublicField(name, returnType);
			else if (isPrivate(field.getModifiers()))
				onPrivateField(name, returnType);
			else if (Modifier.isProtected(field.getModifiers()))
				onProtectedField(name, returnType);
			else
				onPackageField(name, returnType);
		}

		for (Constructor constructor : clazz.getConstructors()) {
			final String name = constructor.getName();
			// todo: simplify
			if (isPublic(constructor.getModifiers()))
				onPublicConstructor(name);
			else if (isPrivate(constructor.getModifiers()))
				onPrivateConstructor(name);
			else if (Modifier.isProtected(constructor.getModifiers()))
				onProtectedConstructor(name);
			else
				onPackageConstructor(name);

			for (Parameter parameter : constructor.getParameters())
				visitParameter(parameter);

			onConstructorComplete();
		}

		for (Method method : clazz.getDeclaredMethods()) {

			onDeclaredMethod(method);

			if (isPublic(method.getModifiers()))
				onPublicMethod(method);
			else if (isPrivate(method.getModifiers()))
				onPrivateMethod(method);
			else if (isProtected(method.getModifiers()))
				onProtectedMethod(method);
			else onPackageMethod(method);
		}

		for (Class innerClass : clazz.getDeclaredClasses())
			onInnerClass(innerClass);

		done();
	}


	public void onClass(Package classPackage, String className, Class superClass) {

	}

	public void onInterface(Class classInterface) {

	}

	public void onPublicField(String name, Class<?> returnType) {

	}

	public void onProtectedField(String name, Class<?> returnType) {

	}

	public void onPackageField(String name, Class<?> returnType) {

	}

	public void onPrivateField(String name, Class<?> returnType) {

	}

	public void onPublicConstructor(String name) {

	}

	public void onProtectedConstructor(String name) {

	}

	public void onPackageConstructor(String name) {

	}

	public void onPrivateConstructor(String name) {

	}

	public void onConstructorComplete() {

	}

	public void onParameter(String name, Class<?> type) {

	}

	public void onTypeParameter(String name, Type[] bounds) {

	}

	public void onDeclaredMethod(Method method) {
	}

	public void onPublicMethod(Method method) {
	}

	public void onPrivateMethod(Method method) {
	}

	public void onProtectedMethod(Method method) {
	}

	public void onPackageMethod(Method method) {
	}

	public void onInnerClass(Class innerClass) {

	}

	public void done() {

	}

	protected static String getName(Method method) {
		return method.getName();
	}

	protected static String getScope(Method method) {
		if (isPublic(method.getModifiers())) return "public";
		if (isPrivate(method.getModifiers())) return "private";
		if (isProtected(method.getModifiers())) return "protected";
		return "";
	}

	protected static String getReturnType(Method method) {
		return method.getReturnType().getSimpleName();
	}

	private void visitParameter(Parameter parameter) {

		// todo: update these cases with handlers, on a need-to basis (like default at bottom)
		if (isParameterized(parameter)) {
			final ParameterizedType type = asParameterizedType(parameter);
			System.out.println("\t" + parameter.getName() + " ParameterizedType " + parameter.getType() + " " + ("actualTypeArguments: " + StringUtil.list(Arrays.asList(type.getActualTypeArguments()))));

		} else if (isGenericArray(parameter)) {
			final GenericArrayType type = asGenericArrayType(parameter);
			System.out.println("\t" + parameter.getName() + " GenericArrayType " + "getGenericComponentType: " + type.getGenericComponentType());

		} else if (isTypeVariable(parameter)) {
			final TypeVariable<?> type = asTypeVariableType(parameter);
			onTypeParameter(type.getName(), type.getBounds());

		} else if (isWildcardType(parameter)) {
			final WildcardType type = asWildcardTypeType(parameter);
			System.out.println("\t" + parameter.getName() + " WildcardType " + ("lowerBounds: " + StringUtil.list(Arrays.asList(type.getLowerBounds()))) + " uppderBounds: " + StringUtil.list(Arrays.asList(type.getUpperBounds())));

		} else {

			onParameter(parameter.getName(), parameter.getType());
		}
	}

	protected static boolean isParameterized(Parameter parameter) {
		return parameter.getParameterizedType() instanceof ParameterizedType;
	}

	protected static ParameterizedType asParameterizedType(Parameter parameter) {
		return (ParameterizedType) parameter.getParameterizedType();
	}

	protected static Type[] getBounds(TypeVariable<?> typeVariable) {
		return typeVariable.getBounds();
	}

	protected static boolean isGenericArray(Parameter parameter) {
		return parameter.getParameterizedType() instanceof GenericArrayType;
	}

	protected static GenericArrayType asGenericArrayType(Parameter parameter) {
		return (GenericArrayType) parameter.getParameterizedType();
	}

	protected static boolean isTypeVariable(Parameter parameter) {
		return parameter.getParameterizedType() instanceof TypeVariable<?>;
	}

	protected static TypeVariable<?> asTypeVariableType(Parameter parameter) {
		return (TypeVariable<?>) parameter.getParameterizedType();
	}

	protected static boolean isWildcardType(Parameter parameter) {
		return parameter.getParameterizedType() instanceof WildcardType;
	}

	protected static WildcardType asWildcardTypeType(Parameter parameter) {
		return (WildcardType) parameter.getParameterizedType();
	}

}