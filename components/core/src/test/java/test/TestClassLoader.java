package test;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TestClassLoader {

    private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TestClassLoader.class);

    public static void main(String[] args) {

        final List<ClassLoader> classLoadersList = new LinkedList<>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
                .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
                .filterInputsBy(s -> s != null && s.endsWith(".class") && s.contains("/"))
                //.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("java.")))
        );

        reflections.getAllTypes().stream().filter(s -> !s.contains("sun.") && !s.contains("$")).sorted(Comparator.naturalOrder()).forEach(s -> {

            try {
                final Class<?> aClass = Class.forName(s);

                if (!Modifier.isPublic(aClass.getModifiers()))
                    return;

                log.info((aClass.isInterface() ? "interface " : (aClass.isEnum() ? "enum " : "class ")) +  aClass.getCanonicalName());

                final Method[] declaredMethods = aClass.getDeclaredMethods();
                for (int i = 0; i < declaredMethods.length; i++) {
                    Method declaredMethod = declaredMethods[i];
                    if (!Modifier.isPublic(declaredMethod.getModifiers())) continue;
                    final Class<?> returnType = declaredMethod.getReturnType();
                    String returnDescription = returnType.isArray() ? (returnType.getComponentType() + "[]") : (returnType.getCanonicalName());

                    final StringBuilder paramsString = new StringBuilder();
                    final Parameter[] parameters = declaredMethod.getParameters();
                    for (int j = 0; j < parameters.length; j++) {
                        Parameter parameter = parameters[j];
                        if (j > 0) paramsString.append(", ");
                        String paramDescription = parameter.getType().isArray() ? (parameter.getType().getComponentType() + "[]") : parameter.getType().getCanonicalName();
                        paramsString.append(paramDescription);
                    }

                    log.info("\t" + returnDescription + " " + declaredMethod.getName() + "(" + paramsString + ")");
                }

            } catch (Throwable e) {
                log.error("\t" + s);
            }
        });
    }
}
