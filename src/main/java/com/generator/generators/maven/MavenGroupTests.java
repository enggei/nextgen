package com.generator.generators.maven;

import org.junit.Test;

public class MavenGroupTests {

	final MavenGroup group = new MavenGroup(new java.io.File("/home/goe/projects/nextgen/src/main/java/com/generator/generators/project/maven.stg"));

   @Test
   public void testMaven() {
       // todo add MavenGroup- tests here;

		System.out.println(group.newbuildHelperPlugin());
		System.out.println(group.newproject());
		System.out.println(group.newbuildPlugins());
		System.out.println(group.newdependencies());
	};

}