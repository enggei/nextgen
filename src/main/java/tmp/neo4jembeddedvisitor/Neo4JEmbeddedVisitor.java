package tmp.neo4jembeddedvisitor;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;
import java.util.stream.Collectors;

public class Neo4JEmbeddedVisitor extends nextgen.actions.TransactionAction {

   private final nextgen.model.Domain domain;
   private final javax.swing.JComponent owner;

	public Neo4JEmbeddedVisitor(nextgen.model.Domain domain, javax.swing.JComponent owner) {
		super("Neo4JEmbeddedVisitor");
		this.domain = domain;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("Neo4JEmbeddedVisitor" + " domain" + " owner");

      final java.util.List<DomainEntity> entities = domain.getEntitiesSorted().collect(Collectors.toList());
      final java.util.List<DomainRelation> relations = domain.getRelationsSorted().collect(Collectors.toList());

      onDomain(domain.getName());

      for (DomainEntity entity : entities)
      	onEntity(entity);

      for (DomainRelation relation : relations)
      	onRelation(relation);

      onComplete();
   }

   final java.util.Map<String, java.util.Map<String, STModel>> stModels = new java.util.HashMap<>();

   public void onDomain(String name) {
   	STModel neoFactory = newModel("neoFactory", "041dcc81-91db-41c1-bacd-ac90f635b371");
   	set(neoFactory, "name", name);
   	set(neoFactory, "package", "tmp");
   }

   public void onEntity(DomainEntity entity) {
   	final String entityName = entity.getName();
   	final String entityUuid = entity.getUuid();
   	STModel nodeWrapper = newModel(entity, "nodeWrapper", "bbe1e861-a07d-4516-ac58-76059fd89ed4");
   	STModel neoFactoryAccessors = newModel(entity, "neoFactoryAccessors", "75d8bdac-df70-443b-8b8a-ce3456b1aae1");
   }

   public void onRelation(DomainRelation relation) {
   	final String relationName = relation.getName();
   	final nextgen.model.DomainRelationType relationType = relation.getType();
   	final nextgen.model.DomainEntity src = relation.getSrc();
   	final String srcName = src.getName();
   	final String srcUuid = src.getUuid();
   	final nextgen.model.DomainEntity dst = relation.getDst();
   	final String dstName = dst.getName();
   	final String dstUuid = dst.getUuid();

   	System.out.println("\ton relation " + relationName + " " + srcName + " " + relationType + " " + dstName);
   	STModel srcnodeWrapper = get(src, "nodeWrapper");
   	STModel dstnodeWrapper = get(dst, "nodeWrapper");
   }

   public void onComplete() {
   	writeModel("neoFactory");
   }

   // utility methods
   private nextgen.model.STModel newModel(String uuid) {
   	return appModel().newSTModel(appModel().db.findSTTemplateByUuid(uuid));
   }

   private nextgen.model.STModel newModel(String key, String uuid) {
   	stModels.putIfAbsent(key, new java.util.TreeMap<>());
   	stModels.get(key).put(key, newModel(uuid));
   	return stModels.get(key).get(key);
   }

   private nextgen.model.STModel newModel(DomainEntity entity, String key, String uuid) {
   	stModels.putIfAbsent(entity.getUuid(), new java.util.TreeMap<>());
   	stModels.get(entity.getUuid()).put(key, newModel(uuid));
   	return stModels.get(entity.getUuid()).get(key);
   }

   private void set(nextgen.model.STModel stModel, String parameterName, String value) {
   	appModel().setArgument(stModel, parameterName, value);
   }

   private nextgen.model.STModel get(nextgen.model.DomainEntity domainEntity, String key) {
   	return stModels.get(domainEntity.getUuid()).get(key);
   }

   private void add(nextgen.model.STModel stModel, String parameterName, String value) {
   	appModel().addArgument(stModel, parameterName, value);
   }

   private void writeModel(String key) {
   	write(stModels.get(key).get(key));
   }

   private void write(STModel stModel) {
   	final java.io.File file = new java.io.File(nextgen.swing.AppModel.getInstance().getOutputPath());
   	nextgen.st.STGenerator.writeJavaFile(appModel().render(stModel), nextgen.swing.STAppPresentationModel.getSTModelPackage(stModel), nextgen.swing.STAppPresentationModel.getSTModelName(stModel), file);
   }
}