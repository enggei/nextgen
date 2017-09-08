package com.generator.generators.javareflection;

import com.generator.util.ClasspathUtil;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created 20.05.17.
 */
public class Tests {

   @Test
   public void testReflection() throws IOException {

      ClasspathUtil.findClasses(s -> {
         try {
            new BaseClassVisitor() {
               @Override
               public void onClass(Package classPackage, String className, Class superClass) {
                  System.out.println(classPackage.getName() + "\n\t" + className);
               }

               @Override
               public void onPublicMethod(Method method) {
                  System.out.println("\t\t" + method.getName());
               }
            }.visit(Class.forName(s));
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
         return true;
      });
   }
}