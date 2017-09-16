package com.generator.generators.cypher;

import com.generator.NeoModel;
import com.generator.ProjectConstants;
import com.generator.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Tests {

   @Test
   public void testCypher() {

      final CypherGroup group = new CypherGroup();

      System.out.println(group.newcreateNode().
            setId("ID").
            addLabelsValue("Entities"));

      System.out.println(
            group.newcreateNodes().
                  addNodesValue(group.newstringProperty().
                        setValue("VALUE").
                        setName("NAME")));

   }

   @Test
   public void testCRUD() {

      final CypherGroup cypherGroup = new CypherGroup();

      // from http://gist.neo4j.org/?4471127413fd724ed0a3:
      final List<String> cypherCommands = new ArrayList<>();

      final CypherGroup.createNodesST createAdministrators = cypherGroup.newcreateNodes();
      createAdministrators.addNodesValue(cypherGroup.newcreateNode().setId("Ben").addLabelsValue("administrator").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Ben")));
      createAdministrators.addNodesValue(cypherGroup.newcreateNode().setId("Sarah").addLabelsValue("administrator").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Sarah")));
      createAdministrators.addNodesValue(cypherGroup.newcreateNode().setId("Liz").addLabelsValue("administrator").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Liz")));
      createAdministrators.addNodesValue(cypherGroup.newcreateNode().setId("Phil").addLabelsValue("administrator").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Phil")));
      Assert.assertEquals(createAdministrators.toString(), " CREATE (`Ben`:administrator {name:'Ben'})," +
            " (`Sarah`:administrator {name:'Sarah'})," +
            " (`Liz`:administrator {name:'Liz'})," +
            " (`Phil`:administrator {name:'Phil'})");
      cypherCommands.add(createAdministrators.toString());

      final CypherGroup.createNodesST createGroups = cypherGroup.newcreateNodes();
      createGroups.addNodesValue(cypherGroup.newcreateNode().setId("Group1").addLabelsValue("group").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Group1")));
      createGroups.addNodesValue(cypherGroup.newcreateNode().setId("Group2").addLabelsValue("group").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Group2")));
      createGroups.addNodesValue(cypherGroup.newcreateNode().setId("Group3").addLabelsValue("group").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Group3")));
      createGroups.addNodesValue(cypherGroup.newcreateNode().setId("Group4").addLabelsValue("group").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Group4")));
      createGroups.addNodesValue(cypherGroup.newcreateNode().setId("Group5").addLabelsValue("group").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Group5")));
      createGroups.addNodesValue(cypherGroup.newcreateNode().setId("Group6").addLabelsValue("group").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Group6")));
      createGroups.addNodesValue(cypherGroup.newcreateNode().setId("Group7").addLabelsValue("group").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Group7")));
      Assert.assertEquals(createGroups.toString(), "CREATE (`Group1`:group {name:'Group1'})," +
            " (`Group2`:group {name:'Group2'})," +
            " (`Group3`:group {name:'Group3'})," +
            " (`Group4`:group {name:'Group4'})," +
            " (`Group5`:group {name:'Group5'})," +
            " (`Group6`:group {name:'Group6'})," +
            " (`Group7`:group {name:'Group7'})");
      cypherCommands.add(createGroups.toString());

      final CypherGroup.createNodesST createCompanies = cypherGroup.newcreateNodes();
      createCompanies.addNodesValue(cypherGroup.newcreateNode().setId("Acme").addLabelsValue("company").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Acme")));
      createCompanies.addNodesValue(cypherGroup.newcreateNode().setId("Spinoff").addLabelsValue("company").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Spinoff")));
      createCompanies.addNodesValue(cypherGroup.newcreateNode().setId("Startup").addLabelsValue("company").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Startup")));
      createCompanies.addNodesValue(cypherGroup.newcreateNode().setId("Skunkworkz").addLabelsValue("company").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Skunkworkz")));
      createCompanies.addNodesValue(cypherGroup.newcreateNode().setId("BigCo").addLabelsValue("company").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("BigCo")));
      createCompanies.addNodesValue(cypherGroup.newcreateNode().setId("Aquired").addLabelsValue("company").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Aquired")));
      createCompanies.addNodesValue(cypherGroup.newcreateNode().setId("Subsidry").addLabelsValue("company").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Subsidry")));
      createCompanies.addNodesValue(cypherGroup.newcreateNode().setId("DevShop").addLabelsValue("company").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("DevShop")));
      createCompanies.addNodesValue(cypherGroup.newcreateNode().setId("OneManShop").addLabelsValue("company").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("OneManShop")));
      Assert.assertEquals(createCompanies.toString(), "CREATE (`Acme`:company {name:'Acme'})," +
            " (`Spinoff`:company {name:'Spinoff'})," +
            " (`Startup`:company {name:'Startup'})," +
            " (`Skunkworkz`:company {name:'Skunkworkz'})," +
            " (`BigCo`:company {name:'BigCo'})," +
            " (`Aquired`:company {name:'Aquired'})," +
            " (`Subsidry`:company {name:'Subsidry'})," +
            " (`DevShop`:company {name:'DevShop'})," +
            " (`OneManShop`:company {name:'OneManShop'})");
      cypherCommands.add(createCompanies.toString());

      final CypherGroup.createNodesST createEmployees = cypherGroup.newcreateNodes();
      createEmployees.addNodesValue(cypherGroup.newcreateNode().setId("Arnold").addLabelsValue("employee").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Arnold")));
      createEmployees.addNodesValue(cypherGroup.newcreateNode().setId("Charlie").addLabelsValue("employee").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Charlie")));
      createEmployees.addNodesValue(cypherGroup.newcreateNode().setId("Emily").addLabelsValue("employee").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Emily")));
      createEmployees.addNodesValue(cypherGroup.newcreateNode().setId("Gordon").addLabelsValue("employee").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Gordon")));
      createEmployees.addNodesValue(cypherGroup.newcreateNode().setId("Lucy").addLabelsValue("employee").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Lucy")));
      createEmployees.addNodesValue(cypherGroup.newcreateNode().setId("Kate").addLabelsValue("employee").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Kate")));
      createEmployees.addNodesValue(cypherGroup.newcreateNode().setId("Alister").addLabelsValue("employee").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Alister")));
      createEmployees.addNodesValue(cypherGroup.newcreateNode().setId("Eve").addLabelsValue("employee").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Eve")));
      createEmployees.addNodesValue(cypherGroup.newcreateNode().setId("Gary").addLabelsValue("employee").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Gary")));
      createEmployees.addNodesValue(cypherGroup.newcreateNode().setId("Bill").addLabelsValue("employee").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Bill")));
      createEmployees.addNodesValue(cypherGroup.newcreateNode().setId("Mary").addLabelsValue("employee").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Mary")));
      Assert.assertEquals(createEmployees.toString(), "CREATE (`Arnold`:employee {name:'Arnold'})," +
            " (`Charlie`:employee {name:'Charlie'})," +
            " (`Emily`:employee {name:'Emily'})," +
            " (`Gordon`:employee {name:'Gordon'})," +
            " (`Lucy`:employee {name:'Lucy'})," +
            " (`Kate`:employee {name:'Kate'})," +
            " (`Alister`:employee {name:'Alister'})," +
            " (`Eve`:employee {name:'Eve'})," +
            " (`Gary`:employee {name:'Gary'})," +
            " (`Bill`:employee {name:'Bill'})," +
            " (`Mary`:employee {name:'Mary'})");
      cypherCommands.add(createEmployees.toString());

      final CypherGroup.createNodesST createAccounts = cypherGroup.newcreateNodes();
      createAccounts.addNodesValue(cypherGroup.newcreateNode().setId("account1").addLabelsValue("account").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Acct 1")));
      createAccounts.addNodesValue(cypherGroup.newcreateNode().setId("account2").addLabelsValue("account").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Acct 2")));
      createAccounts.addNodesValue(cypherGroup.newcreateNode().setId("account3").addLabelsValue("account").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Acct 3")));
      createAccounts.addNodesValue(cypherGroup.newcreateNode().setId("account4").addLabelsValue("account").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Acct 4")));
      createAccounts.addNodesValue(cypherGroup.newcreateNode().setId("account5").addLabelsValue("account").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Acct 5")));
      createAccounts.addNodesValue(cypherGroup.newcreateNode().setId("account6").addLabelsValue("account").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Acct 6")));
      createAccounts.addNodesValue(cypherGroup.newcreateNode().setId("account7").addLabelsValue("account").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Acct 7")));
      createAccounts.addNodesValue(cypherGroup.newcreateNode().setId("account8").addLabelsValue("account").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Acct 8")));
      createAccounts.addNodesValue(cypherGroup.newcreateNode().setId("account9").addLabelsValue("account").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Acct 9")));
      createAccounts.addNodesValue(cypherGroup.newcreateNode().setId("account10").addLabelsValue("account").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Acct 10")));
      createAccounts.addNodesValue(cypherGroup.newcreateNode().setId("account11").addLabelsValue("account").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Acct 11")));
      createAccounts.addNodesValue(cypherGroup.newcreateNode().setId("account12").addLabelsValue("account").addPropertiesValue(cypherGroup.newstringProperty().setName("name").setValue("Acct 12")));
      Assert.assertEquals(createAccounts.toString(), "CREATE (`account1`:account {name:'Acct 1'})," +
            " (`account2`:account {name:'Acct 2'})," +
            " (`account3`:account {name:'Acct 3'})," +
            " (`account4`:account {name:'Acct 4'})," +
            " (`account5`:account {name:'Acct 5'})," +
            " (`account6`:account {name:'Acct 6'})," +
            " (`account7`:account {name:'Acct 7'})," +
            " (`account8`:account {name:'Acct 8'})," +
            " (`account9`:account {name:'Acct 9'})," +
            " (`account10`:account {name:'Acct 10'})," +
            " (`account11`:account {name:'Acct 11'})," +
            " (`account12`:account {name:'Acct 12'})");
      cypherCommands.add(createAccounts.toString());

      //administrator-group relationships
      final CypherGroup.createRelationshipsST adminGroupRelations = cypherGroup.newcreateRelationships();
      adminGroupRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Ben").setType("MEMBER_OF").setDst("Group1"));
      adminGroupRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Ben").setType("MEMBER_OF").setDst("Group3"));
      adminGroupRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Sarah").setType("MEMBER_OF").setDst("Group2"));
      adminGroupRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Sarah").setType("MEMBER_OF").setDst("Group3"));
      adminGroupRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Liz").setType("MEMBER_OF").setDst("Group4"));
      adminGroupRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Liz").setType("MEMBER_OF").setDst("Group5"));
      adminGroupRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Liz").setType("MEMBER_OF").setDst("Group6"));
      adminGroupRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Phil").setType("MEMBER_OF").setDst("Group7"));
      Assert.assertEquals(adminGroupRelations.toString(), "CREATE (`Ben`)-[:MEMBER_OF]->(`Group1`), (`Ben`)-[:MEMBER_OF]->(`Group3`)," +
            " (`Sarah`)-[:MEMBER_OF]->(`Group2`), (`Sarah`)-[:MEMBER_OF]->(`Group3`)," +
            " (`Liz`)-[:MEMBER_OF]->(`Group4`), (`Liz`)-[:MEMBER_OF]->(`Group5`), (`Liz`)-[:MEMBER_OF]->(`Group6`)," +
            " (`Phil`)-[:MEMBER_OF]->(`Group7`)");
      cypherCommands.add(adminGroupRelations.toString());

      //administrator-group relationships
      final CypherGroup.createRelationshipsST groupCompanyRelations = cypherGroup.newcreateRelationships();
      groupCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Group1").setType("ALLOWED_INHERIT").setDst("Acme"));
      groupCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Group2").setType("ALLOWED_DO_NOT_INHERIT").setDst("Acme"));
      groupCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Group2").setType("DENIED").setDst("Skunkworkz"));
      groupCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Group3").setType("ALLOWED_INHERIT").setDst("Startup"));
      groupCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Group4").setType("ALLOWED_INHERIT").setDst("BigCo"));
      groupCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Group5").setType("DENIED").setDst("Aquired"));
      groupCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Group6").setType("ALLOWED_DO_NOT_INHERIT").setDst("OneManShop"));
      groupCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Group7").setType("ALLOWED_INHERIT").setDst("Subsidry"));
      Assert.assertEquals(groupCompanyRelations.toString(), "CREATE (`Group1`)-[:ALLOWED_INHERIT]->(`Acme`)," +
            " (`Group2`)-[:ALLOWED_DO_NOT_INHERIT]->(`Acme`), (`Group2`)-[:DENIED]->(`Skunkworkz`)," +
            " (`Group3`)-[:ALLOWED_INHERIT]->(`Startup`)," +
            " (`Group4`)-[:ALLOWED_INHERIT]->(`BigCo`)," +
            " (`Group5`)-[:DENIED]->(`Aquired`)," +
            " (`Group6`)-[:ALLOWED_DO_NOT_INHERIT]->(`OneManShop`)," +
            " (`Group7`)-[:ALLOWED_INHERIT]->(`Subsidry`)");
      cypherCommands.add(groupCompanyRelations.toString());

      final CypherGroup.createRelationshipsST companyCompanyRelations = cypherGroup.newcreateRelationships();
      companyCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Spinoff").setType("CHILD_OF").setDst("Acme"));
      companyCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Skunkworkz").setType("CHILD_OF").setDst("Startup"));
      companyCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Aquired").setType("CHILD_OF").setDst("BigCo"));
      companyCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Subsidry").setType("CHILD_OF").setDst("Aquired"));
      companyCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("DevShop").setType("CHILD_OF").setDst("Subsidry"));
      companyCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("OneManShop").setType("CHILD_OF").setDst("Subsidry"));
      Assert.assertEquals(companyCompanyRelations.toString(), "CREATE (`Spinoff`)-[:CHILD_OF]->(`Acme`)," +
            " (`Skunkworkz`)-[:CHILD_OF]->(`Startup`)," +
            " (`Aquired`)-[:CHILD_OF]->(`BigCo`)," +
            " (`Subsidry`)-[:CHILD_OF]->(`Aquired`)," +
            " (`DevShop`)-[:CHILD_OF]->(`Subsidry`)," +
            " (`OneManShop`)-[:CHILD_OF]->(`Subsidry`)");
      cypherCommands.add(companyCompanyRelations.toString());

      final CypherGroup.createRelationshipsST employeeCompanyRelations = cypherGroup.newcreateRelationships();
      employeeCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Arnold").setType("WORKS_FOR").setDst("Acme"));
      employeeCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Charlie").setType("WORKS_FOR").setDst("Acme"));
      employeeCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Emily").setType("WORKS_FOR").setDst("Spinoff"));
      employeeCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Gordon").setType("WORKS_FOR").setDst("Startup"));
      employeeCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Lucy").setType("WORKS_FOR").setDst("Startup"));
      employeeCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Kate").setType("WORKS_FOR").setDst("Skunkworkz"));
      employeeCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Alister").setType("WORKS_FOR").setDst("BigCo"));
      employeeCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Eve").setType("WORKS_FOR").setDst("Aquired"));
      employeeCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Gary").setType("WORKS_FOR").setDst("Subsidry"));
      employeeCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Bill").setType("WORKS_FOR").setDst("OneManShop"));
      employeeCompanyRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Mary").setType("WORKS_FOR").setDst("DevShop"));
      Assert.assertEquals(employeeCompanyRelations.toString(), "CREATE (`Arnold`)-[:WORKS_FOR]->(`Acme`)," +
            " (`Charlie`)-[:WORKS_FOR]->(`Acme`)," +
            " (`Emily`)-[:WORKS_FOR]->(`Spinoff`)," +
            " (`Gordon`)-[:WORKS_FOR]->(`Startup`)," +
            " (`Lucy`)-[:WORKS_FOR]->(`Startup`)," +
            " (`Kate`)-[:WORKS_FOR]->(`Skunkworkz`)," +
            " (`Alister`)-[:WORKS_FOR]->(`BigCo`)," +
            " (`Eve`)-[:WORKS_FOR]->(`Aquired`)," +
            " (`Gary`)-[:WORKS_FOR]->(`Subsidry`)," +
            " (`Bill`)-[:WORKS_FOR]->(`OneManShop`)," +
            " (`Mary`)-[:WORKS_FOR]->(`DevShop`)");
      cypherCommands.add(employeeCompanyRelations.toString());

      final CypherGroup.createRelationshipsST employeeAccountRelations = cypherGroup.newcreateRelationships();
      employeeAccountRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Arnold").setType("HAS_ACCOUNT").setDst("account1"));
      employeeAccountRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Arnold").setType("HAS_ACCOUNT").setDst("account2"));
      employeeAccountRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Charlie").setType("HAS_ACCOUNT").setDst("account3"));
      employeeAccountRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Emily").setType("HAS_ACCOUNT").setDst("account6"));
      employeeAccountRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Gordon").setType("HAS_ACCOUNT").setDst("account4"));
      employeeAccountRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Lucy").setType("HAS_ACCOUNT").setDst("account5"));
      employeeAccountRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Kate").setType("HAS_ACCOUNT").setDst("account7"));
      employeeAccountRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Alister").setType("HAS_ACCOUNT").setDst("account8"));
      employeeAccountRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Eve").setType("HAS_ACCOUNT").setDst("account9"));
      employeeAccountRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Gary").setType("HAS_ACCOUNT").setDst("account11"));
      employeeAccountRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Bill").setType("HAS_ACCOUNT").setDst("account10"));
      employeeAccountRelations.addRelationshipsValue(cypherGroup.newcreateRelationship().setSrc("Mary").setType("HAS_ACCOUNT").setDst("account12"));
      Assert.assertEquals(employeeAccountRelations.toString(), "CREATE (`Arnold`)-[:HAS_ACCOUNT]->(`account1`), (`Arnold`)-[:HAS_ACCOUNT]->(`account2`)," +
            " (`Charlie`)-[:HAS_ACCOUNT]->(`account3`)," +
            " (`Emily`)-[:HAS_ACCOUNT]->(`account6`)," +
            " (`Gordon`)-[:HAS_ACCOUNT]->(`account4`)," +
            " (`Lucy`)-[:HAS_ACCOUNT]->(`account5`)," +
            " (`Kate`)-[:HAS_ACCOUNT]->(`account7`)," +
            " (`Alister`)-[:HAS_ACCOUNT]->(`account8`)," +
            " (`Eve`)-[:HAS_ACCOUNT]->(`account9`)," +
            " (`Gary`)-[:HAS_ACCOUNT]->(`account11`)," +
            " (`Bill`)-[:HAS_ACCOUNT]->(`account10`)," +
            " (`Mary`)-[:HAS_ACCOUNT]->(`account12`)");
      cypherCommands.add(employeeAccountRelations.toString());

      final GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File(ProjectConstants.TEST_ROOT + "/db"));
      NeoModel model = new NeoModel(db);

      // run once in clean db:
      // must be batch !
//        final StringBuilder batch = new StringBuilder();
//        for (String cypherCommand : cypherCommands) batch.append(cypherCommand);
//        try (Transaction tx = model.beginTx()) {
//            model.query(batch.toString());
//            tx.success();
//        }

      try (Transaction tx = model.beginTx()) {
         for (Node node : model.getAll("administrator"))
            System.out.println(node.getLabels() + " : " + node.getProperty("name"));
         for (Node node : model.getAll("group"))
            System.out.println(node.getLabels() + " : " + node.getProperty("name"));
         for (Node node : model.getAll("company"))
            System.out.println(node.getLabels() + " : " + node.getProperty("name"));
         for (Node node : model.getAll("employee"))
            System.out.println(node.getLabels() + " : " + node.getProperty("name"));
         for (Node node : model.getAll("account"))
            System.out.println(node.getLabels() + " : " + node.getProperty("name"));

         tx.success();
      }

      try (Transaction tx = model.beginTx()) {

         Assert.assertEquals("Admin,Parent Company,Child Company,Employee\nBen,Startup,Startup,Lucy\n" +
               "Ben,Startup,Startup,Gordon\n" +
               "Ben,Startup,Skunkworkz,Kate\n" +
               "Ben,Acme,Acme,Charlie\n" +
               "Ben,Acme,Acme,Arnold\n" +
               "Ben,Acme,Acme,Arnold\n" +
               "Ben,Acme,Spinoff,Emily", query(model, "MATCH paths=(admin:administrator {name:'Ben'})-[:MEMBER_OF]->()-[:ALLOWED_INHERIT]->(c1:company)<-[:CHILD_OF*0..3]-(c2:company)<-[:WORKS_FOR]-(employee)-[:HAS_ACCOUNT]->(account)\n" +
               "RETURN admin.name AS Admin, c1.name AS `Parent Company`, c2.name AS `Child Company`, employee.name AS Employee"));

         Assert.assertEquals("Admin,Parent Company,Child Company,Employee\n" +
               "Sarah,Acme,Spinoff,Emily", query(model, "MATCH paths=(admin:administrator {name:'Sarah'})-[:MEMBER_OF]->()-[:ALLOWED_DO_NOT_INHERIT]->(c1:company)<-[:CHILD_OF*1..3]-(c2:company)<-[:WORKS_FOR]-(employee)-[:HAS_ACCOUNT]->(account)\n" +
               "RETURN admin.name AS Admin, c1.name AS `Parent Company`, c2.name AS `Child Company`, employee.name AS Employee"));

         Assert.assertEquals("Admin,Employee,Accounts\n" +
               "Ben,Charlie,[Acct 3]\n" +
               "Ben,Emily,[Acct 6]\n" +
               "Ben,Gordon,[Acct 4]\n" +
               "Ben,Arnold,[Acct 2, Acct 1]\n" +
               "Ben,Kate,[Acct 7]\n" +
               "Ben,Lucy,[Acct 5]\n" +
               "Liz,Alister,[Acct 8]\n" +
               "Phil,Gary,[Acct 11]\n" +
               "Phil,Bill,[Acct 10]\n" +
               "Phil,Mary,[Acct 12]\n" +
               "Sarah,Lucy,[Acct 5]\n" +
               "Sarah,Gordon,[Acct 4]\n" +
               "Liz,Bill,[Acct 10]\n" +
               "Sarah,Charlie,[Acct 3]\n" +
               "Sarah,Arnold,[Acct 2, Acct 1]", query(model, "MATCH paths=(admin:administrator)-[:MEMBER_OF]->()-[:ALLOWED_INHERIT]->()<-[:CHILD_OF*0..3]-(company)<-[:WORKS_FOR]-(employee)-[:HAS_ACCOUNT]->(account)\n" +
               "WHERE NOT ((admin)-[:MEMBER_OF]->()-[:DENIED]->()<-[:CHILD_OF*0..3]-(company))\n" +
               "RETURN admin.name AS Admin, employee.name AS Employee, collect(account.name) AS Accounts\n" +
               "ORDER BY Admin ASC\n" +
               "UNION\n" +
               "MATCH paths=(admin)-[:MEMBER_OF]->()-[:ALLOWED_DO_NOT_INHERIT]->()<-[:WORKS_FOR]-(employee)-[:HAS_ACCOUNT]->(account)\n" +
               "RETURN admin.name AS Admin, employee.name AS Employee, collect(account.name) AS Accounts\n" +
               "ORDER BY Admin ASC"));

         Assert.assertEquals("Admin,Resource\n" +
               "Phil,[Subsidry, OneManShop, DevShop]\n" +
               "Sarah,[Startup]\n" +
               "Ben,[Startup, Skunkworkz, Acme, Spinoff]\n" +
               "Liz,[BigCo]\n" +
               "Sarah,[Acme]\n" +
               "Liz,[OneManShop]", query(model, "MATCH p=(admin:administrator)-[:MEMBER_OF]->()-[:ALLOWED_INHERIT]->()<-[:CHILD_OF*0..3]-(company:company)\n" +
               "WHERE NOT ((admin)-[:MEMBER_OF]->()-[:DENIED]->()<-[:CHILD_OF*0..3]-(company))\n" +
               "RETURN admin.name AS Admin, collect(company.name) AS Resource\n" +
               "UNION\n" +
               "MATCH p=(admin)-[:MEMBER_OF]->()-[:ALLOWED_DO_NOT_INHERIT]->(company)\n" +
               "RETURN admin.name AS Admin, collect(company.name) AS Resource"));

         Assert.assertEquals("Resource,Admins\n" +
               "Acct 10,[Phil]\n" +
               "Acct 10,[Liz]", query(model, "MATCH p=(resource {name:'Acct 10'})-[:WORKS_FOR|HAS_ACCOUNT*1..2]-(company)-[:CHILD_OF*0..3]->()<-[:ALLOWED_INHERIT]-()<-[:MEMBER_OF]-(admin)\n" +
               "WHERE NOT ((admin)-[:MEMBER_OF]->()-[:DENIED]->()<-[:CHILD_OF*0..3]-(company))\n" +
               "RETURN resource.name AS Resource, collect(admin.name) AS Admins\n" +
               "UNION\n" +
               "MATCH p=(resource {name:'Acct 10'})-[:WORKS_FOR|HAS_ACCOUNT*1..2]-(company)<-[:ALLOWED_DO_NOT_INHERIT]-()<-[:MEMBER_OF]-(admin)\n" +
               "RETURN resource.name AS Resource, collect(admin.name) AS Admins"));

         tx.success();
      }
   }

   private String query(NeoModel model, String query) {
      final StringBuilder out = new StringBuilder();
      final Result result = model.query(query);
      out.append(StringUtil.list(result.columns())).append("\n");
      while (result.hasNext())
         out.append(StringUtil.list(result.columns(), result.next())).append("\n");
      final String res = out.toString().trim();
      System.out.println(res);
      return res;
   }
} 