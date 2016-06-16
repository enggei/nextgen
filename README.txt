
import antlr.jar into local repository:
# open Terminal
# mvn install:install-file -Dfile=antlr-4.5.3-complete.jar -DgroupId=antlr -DartifactId=antlr -Dversion=4.5.3 -Dpackaging=jar

todo: add jcypher and apply external neo-database:

http://jcypher.iot-solutions.net/

<!--<dependency>-->
    <!--<groupId>net.iot-solutions.graphdb</groupId>-->
    <!--<artifactId>jcypher</artifactId>-->
    <!--<version>3.4.0</version>-->
<!--</dependency>-->



be able to use Domain-graph editor to produce these: (combine group-calls with node-data, and write/run on demand:
Add Write-file to graph

@Test
public void makeTreeModule() {

	write(group.newmoduleJS().
			addDependenciesValue("treeview", "tree"),
		new File(adminSrc, "treetest/tree.js"));

	write(group.newmoduleHTML().
			addHtmlValue(html.newdiv().setId("tree")),
		new File(adminSrc, "treetest/tree.html"));
}

# create domain from template : combine graph-panel with verticles and messages, so I can send values of output from verticles as messages to other verticles
# finish editors for list,keyvaluelist and statement properties

// todo, for domain and persistency and modelling:
# create Graph-editor from templates , define a domain as all the verticles, and relations as the messages that can be sent. support statement as methods
    (link statements to parameters to other statements)
# Check NeoVerticle for patterns on verticles, messages and private handle-method
# create java- interface parser, which can generate implementations from interfaces (neo-backend, java-beans, json, protobuf, Mysql etc) using adapters, factories etc.
    create a Graph2D editor based on the template, with a set of predefined relations:
        - A parameter can be linked by a message (MetaDomain)
# TemplateGroupGenerator.generateDomain from Template into TemplateGroupDomain     (Use DomainGeneratorGenerator for pattern)
    TemplateGroupPanel (refactor away if Domain is generated completely)

# cleanup Template-parser - use antlr if possible
# cleanup FileUtil - remove unnused methods
# upgrade to Neo 3.0  (when pom is available from maven-central)

# templates:
create autocomplete stringtemplate-group.editor
// todo: TemplateFileEditor: createDomain: create domains from a templateGroup

# vertx:
Make router - editor
Service - editor
Events and verticle- graph

# neo-traversers:
use BaseDomainVisitor's methods, and dynamically create traverser-paths by clicking on nodes and traverse-rules