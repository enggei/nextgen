package com.generator.generators.durandal;

import com.generator.editors.NeoModel;
import com.generator.generators.html5.Html5Group;
import com.generator.generators.javascript.JavascriptGroup;
import com.generator.generators.json.JsonGroup;
import com.generator.generators.knockout.KnockoutGroup;
import com.generator.util.StringUtil;
import org.junit.Test;

import java.io.File;

import static com.generator.util.FileUtil.write;

public class DurandalTests {

	static {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
	}

	private final File webSrc = new File("/media/storage/ucs/filmjump/src/main/web/");
	private final File adminSrc = new File(webSrc, "app/admin");

	private final DurandalGroup group = new DurandalGroup();
	private final Html5Group html = new Html5Group();
	private final JavascriptGroup js = new JavascriptGroup();
	private final JsonGroup json = new JsonGroup();
	private final KnockoutGroup ko = new KnockoutGroup();

	@Test
	public void makeTreeModule() {

		final Object treeViewConfig = json.newobject().
			addPairsValue("data", "getTree()").
			addFunctionsValue("onNodeSelected", js.newfunction().
				addParametersValue("event").
				addParametersValue("data").
				addStatementsValue(js.newlogString().setString("Selected")));

		write(group.newmoduleJS().
				addDependenciesValue("treeview", "tree").
				addDependenciesValue("serverChannel", "serverChannel").
				addDependenciesValue("domain", "Domain").
				addDependenciesValue("knockout", "ko").

				addStatementsValue(js.newfunction().
					setName("add").
					addStatementsValue(js.newlogString().setString("ADDING NODE")).
					addStatementsValue("serverChannel.send(Domain.USER_ACTIONS,\n" +
						"\n" +
						"            {\n" +
						"                'action': Domain.INSERT,\n" +
						"                'type': 'Site',\n" +
						"                'properties': [\n" +
						"                    {'key': 'name', 'value': self.name()} \n" +
						"                ]\n" +
						"            },\n" +
						"\n" +
						"            function (content) {\n" +
						"                var returnValue = {'uuid': content.uuid, 'name': self.name()};\n" +
						"                console.info(\"NewSiteDialog.returnValue \" + JSON.stringify(content));\n" +
						"                dialog.close(self, returnValue);\n" +
						"            },\n" +
						"\n" +
						"            function (cause) {\n" +
						"                console.info(\"new Site: \" + JSON.stringify(cause));\n" +
						"            });")).

				addReturnsValue("add", "add").

				addStatementsValue(js.newfunction().
					setName("del").
					addStatementsValue(js.newlogString().setString("REMOVING NODE"))).

				addReturnsValue("del", "del").

				addStatementsValue(js.newfunction().setName("getTree").addStatementsValue("var tree = [\n" +
					"  {\n" +
					"    text: \"Parent 1\",\n" +
					"    nodes: [\n" +
					"      {\n" +
					"        text: \"Child 1\",\n" +
					"        nodes: [\n" +
					"          {\n" +
					"            text: \"Grandchild 1\"\n" +
					"          },\n" +
					"          {\n" +
					"            text: \"Grandchild 2\"\n" +
					"          }\n" +
					"        ]\n" +
					"      },\n" +
					"      {\n" +
					"        text: \"Child 2\"\n" +
					"      }\n" +
					"    ]\n" +
					"  },\n" +
					"  {\n" +
					"    text: \"Parent 2\"\n" +
					"  },\n" +
					"  {\n" +
					"    text: \"Parent 3\"\n" +
					"  },\n" +
					"  {\n" +
					"    text: \"Parent 4\"\n" +
					"  },\n" +
					"  {\n" +
					"    text: \"Parent 5\"\n" +
					"  }\n " +
					"];\n" +
					"return tree;")).

				addReturnsValue(js.newfunction().
					setName("attached").
					addStatementsValue("$('#tree').treeview(" + treeViewConfig + ");"), "attached"),

			new File(adminSrc, "treetest/tree.js"));

		write(group.newmoduleHTML().
				setTitle("Locations").
				addContentValue(html.newdiv().setId("tree")).
				addContentValue(html.newa().setClass("btn btn-primary btn-lg").setDatabind("click: add").setContent("ADD")).
				addContentValue(html.newa().setClass("btn btn-primary btn-lg").setDatabind("click: del").setContent("REMOVE")),
			new File(adminSrc, "treetest/tree.html"));

	}

	@Test
	public void createCRUD() {

		String type = "Site";
		String module = "app/admin/" + StringUtil.lowFirst(type) + "/";
		String[][] fields = new String[][]{
			new String[]{"name", "N/A"}
		};
		String[][] columns = new String[][]{
			new String[]{"name", "N/A"},
		};
		createCRUD(webSrc, module, type, fields, columns, group);


		type = "Content";
		module = "app/admin/" + StringUtil.lowFirst(type) + "/";
		fields = new String[][]{
			new String[]{"name", "N/A"}
		};
		columns = new String[][]{
			new String[]{"name", "N/A"},
		};
		createCRUD(webSrc, module, type, fields, columns, group);

		type = "User";
		module = "app/admin/" + StringUtil.lowFirst(type) + "/";
		fields = new String[][]{
			new String[]{"name", "username"},
			new String[]{"email", "email"}
		};
		columns = new String[][]{
			new String[]{"name", "N/A"},
		};
		createCRUD(webSrc, module, type, fields, columns, group);


		final DurandalGroup.shellJSST shellJSST = group.newshellJS().
			setUnknownRoutePage("not-found").
			setUnknownRoutePath("viewmodels/");

		shellJSST.addRoutesValue("admin/menu", "true", "", "Filmjump");
		shellJSST.addRoutesValue("admin/location/ListLocation", "false", "manageLocation", "Manage Locations");
		shellJSST.addRoutesValue("admin/content/ListContent", "false", "manageContent", "Manage Content");
		shellJSST.addRoutesValue("admin/user/ListUser", "false", "manageUser", "Manage Users");
		shellJSST.addRoutesValue("admin/tree", "true", "testTree", "Trees");
		shellJSST.addRoutesValue("admin/upload", "false", "uploadContent", "Upload Content");


		write(shellJSST, new File(webSrc, "app/shell.js"));
	}

	private void createCRUD(File webSrc, String module, String type, String[][] fields, String[][] columns, DurandalGroup group) {

		// edit dialog
		final DurandalGroup.EditDialogJSST editDialogJSST = group.newEditDialogJS().
			setType(type);
		for (String[] field : fields)
			editDialogJSST.addFieldsValue(field[0]);
		write(editDialogJSST, new File(webSrc, module + "Edit" + type + "Dialog.js"));

		final DurandalGroup.EditDialogHTMLST editDialogHTMLST = group.newEditDialogHTML().
			setType(type);
		for (String[] field : fields)
			editDialogHTMLST.addFieldsValue(StringUtil.capitalize(field[0]), field[0]);
		write(editDialogHTMLST, new File(webSrc, module + "Edit" + type + "Dialog.html"));

		// List (CRUD) panel
		final DurandalGroup.CrudJSST crudJSST = group.newCrudJS().
			setType(type);
		for (String[] column : columns)
			crudJSST.addColumnsValue(column[1], column[0]);
		for (String[] field : fields)
			crudJSST.addEditableFieldsValue(field[1], field[0]);
		write(crudJSST, new File(webSrc, module + "List" + type + ".js"));

		final DurandalGroup.CrudHtmlST crudHtmlST = group.newCrudHtml().
			setType(type);
		for (String[] column : columns)
			crudHtmlST.addColumnsValue(column[0]);
		write(crudHtmlST, new File(webSrc, module + "List" + type + ".html"));

		// new dialog
		final DurandalGroup.NewDialogJSST newDialogJSST = group.newNewDialogJS().
			setType(type);
		for (String[] field : fields)
			newDialogJSST.addFieldsValue(field[0]);
		write(newDialogJSST, new File(webSrc, module + "New" + type + "Dialog.js"));

		final DurandalGroup.NewDialogHTMLST newDialogHTMLST = group.newNewDialogHTML().
			setType(type);
		for (String[] field : fields)
			newDialogHTMLST.addFieldsValue(StringUtil.capitalize(field[0]), field[0]);
		write(newDialogHTMLST, new File(webSrc, module + "New" + type + "Dialog.html"));
	}

	@Test
	public void testDurandalNeo() {

		final org.neo4j.graphdb.GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"));
		final NeoModel model = new NeoModel(db);

		model.doInTransaction(new NeoModel.Committer() {
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