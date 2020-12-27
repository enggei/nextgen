package nextgen.utils;

import nextgen.templates.java.*;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.*;

public class ReflectionUtil {

   public static void evaluate(Object o) {

      final Class<?> aClass = o.getClass();

      getMethods(aClass)
            .filter(method -> method.getParameterCount() != 0)
            .filter(method -> Modifier.isPublic(method.getModifiers()))
            .filter(method -> !Modifier.isStatic(method.getModifiers()))
            .forEach(method -> {
               System.out.println(toString(method));
            });

      final List<Method> methods = getMethods(aClass)
            .filter(method -> method.getParameterCount() == 0)
            .filter(method -> Modifier.isPublic(method.getModifiers()))
            .filter(method -> !Modifier.isStatic(method.getModifiers()))
            .collect(Collectors.toList());

      for (Method method : methods) {
         try {
            System.out.println(method.invoke(o));
         } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
         }
      }
   }

   private static String toString(Method method) {
      final MethodDeclaration methodDeclaration = JavaST.newMethodDeclaration();
      methodDeclaration.setName(method.getName());
      methodDeclaration.setType(method.getReturnType());
      Arrays.stream(method.getParameters()).forEach(parameter -> methodDeclaration.addParameters(JavaST.newParameter().setName(parameter.getName()).setType(parameter.getType())));
      return methodDeclaration.toString();
   }

   private static Stream<Method> getMethods(Class<?> aClass) {
      return getMethods(aClass, new TreeSet<>((method, t1) -> toString(method).compareTo(toString(t1))));
   }

   private static Stream<Method> getMethods(Class<?> aClass, Set<Method> allMethods) {
      if (aClass == null || aClass.equals(Object.class)) return allMethods.stream();
      allMethods.addAll(Arrays.asList(aClass.getDeclaredMethods()));
      return getMethods(aClass.getSuperclass(), allMethods);
   }
}