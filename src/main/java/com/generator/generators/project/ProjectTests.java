package com.generator.generators.project;

import com.generator.generators.templates.domain.GeneratedFile;
import org.junit.Test;

import java.io.IOException;


public class ProjectTests {

	@Test
	public void testProjectGroup() throws IOException {

		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		final ProjectGroup group = new ProjectGroup();

		// todo add ProjectGroup- tests here;

		final ProjectGroup.projectST nextGen = group.newproject().
			setName("NextGen").
			setPackageName("com.generator.generators.project").
			setComments("Represents the nextgen project. Will generate app for managing projects, templates and generation of these.");

		nextGen.addGroupsValue("ProjectGroup", "com.generator.generators.project", "/media/storage/nextgen/src/main/java/com/generator/generators/project/project.stg", "project");

		nextGen.addRootsValue("/media/storage/nextgen/src/main/java/com/generator/generators/project/test", "root");
		nextGen.addRootsValue("/media/storage/nextgen/src/main/java/com/generator/generators/project/test/src/java", "javaRoot");
		nextGen.addRootsValue("/media/storage/nextgen/src/main/java/com/generator/generators/project/test/src/web", "webRoot");

		nextGen.addAspectsValue(group.newaspect().
			setName("fjProject").
			addTasksValue(group.newwriteFile().setName("pom").setFiletype("xml").setComment("Test maven").setContent(group.newstringValue().setValue("content")).setDir("/media/storage/nextgen/src/main/java/com/generator/generators/project/test/src/java")));

		GeneratedFile.newJavaFile("/media/storage/nextgen/src/main/java", "com.generator.generators.project", "NextGen").write(nextGen);
	}
}