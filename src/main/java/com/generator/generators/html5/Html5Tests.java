package com.generator.generators.html5;

import org.junit.Test;

import java.io.File;

import static com.generator.util.FileUtil.write;

public class Html5Tests {

	static {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
	}

	final Html5Group group = new Html5Group();

	@Test
	public void testHtml5Group() {

		write(group.newpage().
				setHead(group.newhead().
					addContentValue(group.newlink().setRel("stylesheet").setType("text/css").setHref("mystyle.css")).
					addContentValue(group.newscript().setType("text/css"))).
				setBody(group.newbody().
						addContentValue(group.newa().setHref("www.vg.no").setId("VG").setAccesskey("h").setAccesskey("V")).
						addContentValue(group.newabbr().setTitle("TITLE")).
						addContentValue(group.newcomment().setComment("This is a comment")).
						addContentValue(group.newaddress().setTitle("Address")).
						addContentValue(group.newarea().setTitle("Area").setShape("rect").setCoords("0,0,82,126")).
						addContentValue(group.newarticle().setTitle("Article")).
						addContentValue(group.newaside().setTitle("Aside")).
						addContentValue(group.newaudio().setTitle("Audio").setLoop("loop").setControls("controls").setSrc("www.vg.no")).
						addContentValue(group.newdiv().setContent(group.newblock().
								addContentValue(group.newh2().setContent("HEADER")).
								addContentValue(group.newp().setContent(group.newblock().
									addContentValue(group.newb().setContent("Bold")))))
						)
				),
			new File("/media/storage/nextgen/src/main/java/com/generator/generators/html5/example.html"));
	}

	@Test
	public void testHtml5Neo() {

		final org.neo4j.graphdb.GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new java.io.File("src/test/tests/db"));
		final com.generator.editors.domain.NeoModel model = new com.generator.editors.domain.NeoModel(db);

		model.doInTransaction(new com.generator.editors.domain.NeoModel.Committer() {
			@Override
			public void doAction(org.neo4j.graphdb.Transaction tx) throws Throwable {
			}

			@Override
			public void exception(Throwable throwable) {
				throw new RuntimeException(throwable);
			}
		});
	}

	;
} 