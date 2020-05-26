package nextgen.projects;

import nextgen.domain.DomainToJson;
import nextgen.domain.DomainToNeo4J;
import nextgen.domain.DomainToPojos;
import nextgen.domain.domain.Enum;
import nextgen.domain.domain.*;

import static nextgen.domain.DomainPatterns.*;

public class STDomainProject {

    private static final String mainRoot = "./components/core/src/main/java";
    private static final String testRoot = "./components/core/src/test/java";

    public static void main(String[] args) {

        final Domain domain = getDomain();
        final Domain parserDomain = getParserDomain();

//        DomainToPojos.generate(mainRoot, "nextgen.stringtemplate.domain", domain);
//        DomainToPojos.generate(mainRoot, "nextgen.stringtemplate.parser", parserDomain);

        DomainToPojos.generate(testRoot, "tmp.stringtemplate.domain", domain);
        DomainToPojos.generate(testRoot, "tmp.stringtemplate.parser", parserDomain);
        DomainToJson.generate(testRoot, "tmp.stringtemplate.domain.json", domain);
        DomainToJson.generate(testRoot, "tmp.stringtemplate.parser.json", parserDomain);
        DomainToNeo4J.generate(testRoot, "tmp.stringtemplate.domain.neo", domain);
        DomainToNeo4J.generate(testRoot, "tmp.stringtemplate.parser.neo", parserDomain);
    }

    public static Domain getParserDomain() {

        final Enum astNodeType = newEnum("AstNodeType", "Expression,Name,Prop,Options,Args,If,Include,Subtemplate");

        final Entity argument = newPrimitiveEntity("String");

        final Entity astNode = newEntity("AstNode")
                .addProperties(newExternalProperty("ast", "org.antlr.runtime.tree.Tree"))
                .addProperties(newEnumProperty("type", astNodeType));

        final Entity methodCall = newEntity("MethodCall")
                .addProperties(newStringProperty("name"));

        final Entity expression = newEntity("Expression")
                .addProperties(newStringProperty("name"))
                .addProperties(newStringProperty("options"));

        final Entity subTemplate = newEntity("SubTemplate")
                .addProperties(newStringProperty("options"));

        final Entity prop = newEntity("Prop")
                .addProperties(newStringProperty("Key"))
                .addProperties(newStringProperty("Value"));

        return newDomain("STParser")
                .addEnums(astNodeType)
                .addEntities(argument)
                .addEntities(astNode)
                .addEntities(methodCall)
                .addEntities(expression)
                .addEntities(subTemplate)
                .addEntities(prop)
                .addRelations(newManyToOneRelation("parent", astNode, astNode))
                .addRelations(newOneToManyRelation("children", astNode, astNode))
                .addRelations(newOneToManyRelation("arguments", methodCall, argument))
                .addRelations(newOneToOneRelation("ast", expression, astNode))
                .addRelations(newOneToManyRelation("methodCalls", expression, methodCall))
                .addRelations(newOneToOneRelation("subTemplate", expression, subTemplate))
                .addRelations(newOneToManyRelation("props", expression, prop))
                .addRelations(newOneToManyRelation("args", subTemplate, argument))
                .addRelations(newOneToManyRelation("expressions", subTemplate, expression))
                .addRelations(newOneToManyRelation("props", subTemplate, prop))
                ;
    }

    public static Domain getDomain() {

        final Enum propertyTypeEnum = newEnum("STParameterType", "SINGLE,LIST,KVLIST");

        final Property name = newStringProperty("Name");

        final Entity stDomain = newEntity("STDomain");
        final Entity stGroupModel = newEntity("STGroupModel");
        final Entity stInterface = newEntity("STInterface");
        final Entity stEnum = newEntity("STEnum");
        final Entity stTemplate = newEntity("STTemplate");
        final Entity stParameter = newEntity("STParameter");


        return newDomain()
                .setName("ST")
                .addEnums(propertyTypeEnum)
                .addEntities(stDomain)
                .addEntities(stGroupModel)
                .addEntities(stInterface)
                .addEntities(stEnum)
                .addEntities(stTemplate)
                .addEntities(stParameter)
                ;
    }
}