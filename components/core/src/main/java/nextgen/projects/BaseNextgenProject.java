package nextgen.projects;

import nextgen.templates.java.*;


public class BaseNextgenProject {

	final java.io.File root = new java.io.File("/home/goe/projects/nextgen/components/core/src/main/java");
	final java.io.File mainJava = new java.io.File(root, "src/main/java");
	final java.io.File mainResources = new java.io.File(root, "src/main/resources");
	final java.io.File testJava = new java.io.File(root, "src/test/java");
	final java.io.File testResources = new java.io.File(root, "src/test/resources");

	protected static void log(Object log) {
		System.out.println(log);
	}
}