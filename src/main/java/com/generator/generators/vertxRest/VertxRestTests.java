package com.generator.generators.vertxRest;

import com.generator.util.FileUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class VertxRestTests {

	@Test
	public void testVertxRestGroup() throws IOException {

		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		final VertxRestGroup group = new VertxRestGroup();

		// todo add VertxRestGroup- tests here;

		// todo: use JGoodies forms, and create a panel with buttons for creating each of these / VertxResteo

		final String apiName = "PrototypeAPI";

		final VertxRestGroup.APIST prototypeAPI = group.newAPI().
			setPackageName("com.udc.loopsi.api").
			setName(apiName).
			setComments("Test to generate apis");

		prototypeAPI.addEntitiesValue("Badge");

		prototypeAPI.addVisitorsValue(
			"final JsonObject content = newJsonObject();\n" +
				"success(result, content);",
			"addBadge");

		prototypeAPI.addPropertiesValue("badgeId");

		prototypeAPI.addEndpointsValue(group.newvalidatingNeoHandler().
			setAction("post").
			setUri("/api/admin/badge").
			setApiName(apiName).
			setVisitor("addBadge").
			addValidationsValue("badgeId", "verifyRequiredUUIDParam"));


		System.out.println(prototypeAPI);

		FileUtil.writeFile(prototypeAPI, new File("/media/storage/ucs/loopsi/src/main/java/com/udc/loopsi/api/PrototypeAPI.java"));
	}

	;

	@Test
	public void testVertxRestNeo() {

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