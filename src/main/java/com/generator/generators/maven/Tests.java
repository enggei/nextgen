package com.generator.generators.maven;

import org.junit.Test;

public class Tests {

   @Test
   public void testMaven() {

		final MavenGroup mavenGroup = new MavenGroup();

		final MavenGroup.pomST pomST = mavenGroup.newpom().
				setArtifactId("artifactId").
				setGroupId("groupId").
				setVersion("version").
				setName("MyProject");

		System.out.println(pomST);
	};

}