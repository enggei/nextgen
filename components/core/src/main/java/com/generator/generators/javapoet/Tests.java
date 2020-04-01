package com.generator.generators.javapoet;

import com.squareup.javapoet.*;
import org.junit.Test;

import javax.lang.model.element.Modifier;


/**
 * Created 06.12.17.
 */
public class Tests {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Tests.class);

   @Test
   public void testHelloWorld() {

      ParameterSpec parameter = ParameterSpec.builder(ArrayTypeName.of(String.class),"args").build();

      MethodSpec main = MethodSpec.methodBuilder("main")
            .addModifiers(Modifier.PUBLIC)
            .addModifiers(Modifier.STATIC)
            .returns(void.class)
            .addParameter(parameter)
            .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
            .build();

      MethodSpec computeRange = MethodSpec.methodBuilder("computeRange")
            .addStatement("int total = 0")
            .beginControlFlow("for (int i = 0; i < 10; i++)")
            .addStatement("total += i")
            .endControlFlow()
            .build();

      TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addMethod(main)
            .addMethod(computeRange)
            .build();

      System.out.println(helloWorld.toString());

      ClassName hoverboard = ClassName.get("com.mattel", "Hoverboard");

      MethodSpec today = MethodSpec.methodBuilder("tomorrow")
            .returns(hoverboard)
            .addStatement("return new $T()", hoverboard)
            .build();

      TypeSpec jupp = TypeSpec.classBuilder("Today")
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addMethod(today)
            .build();


      JavaFile javaFile = JavaFile.builder("com.example.helloworld", jupp).build();

      log.info(javaFile.toString());
   }
}
