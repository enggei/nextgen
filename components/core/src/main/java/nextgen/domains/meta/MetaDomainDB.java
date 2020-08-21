package nextgen.domains.meta;

import nextgen.st.STAppEvents;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

import java.util.UUID;

public class MetaDomainDB extends MetaDomainNeoFactory {

    public MetaDomainDB(String dir) {
        super(dir);
    }

    public MetaDomainDB(GraphDatabaseService db) {
        super(db);
        cleanup();
    }

    public void cleanup() {
        doInTransaction(transaction -> {

            findAllDomainEntity().forEach(metaEntity -> metaEntity.getNode().getRelationships(Direction.OUTGOING).forEach(relationship -> {
                if (relationship.hasProperty("_uuid")) return;
                relationship.setProperty("_uuid", UUID.randomUUID().toString());
            }));


            //findAllMetaRelation().forEach(metaRelation -> metaRelation.setCardinality(Cardinality.ONE_TO_MANY));
        });
    }

    public void newMetaDomain(String name) {
        final MetaDomain metaDomain = newMetaDomain().setName(name).setUuid(UUID.randomUUID().toString());
        STAppEvents.postNewMetaDomain(metaDomain);
    }

    public void newMetaEntity(MetaDomain metaDomain, String name) {
        final MetaEntity metaEntity = newMetaEntity().setName(name).setUuid(UUID.randomUUID().toString());
        metaDomain.addRoots(metaEntity);
        STAppEvents.postNewMetaEntity(metaEntity);
    }

    public void newMetaEntity(MetaRelation metaRelation, String name) {
        final MetaEntity dst = newMetaEntity().setName(name).setUuid(UUID.randomUUID().toString());
        metaRelation.addDst(dst);
        STAppEvents.postNewMetaEntity(dst);
    }

    public void newMetaRelation(MetaEntity src, String name, Cardinality cardinality) {
        final MetaRelation metaRelation = newMetaRelation().setName(name).setUuid(UUID.randomUUID().toString()).setCardinality(cardinality);
        src.addRelations(metaRelation);
        STAppEvents.postNewMetaRelation(metaRelation);
    }

    public DomainEntity newDomainEntity(MetaEntity metaEntity) {
        final DomainEntity domainEntity = newDomainEntity().set_meta(metaEntity).setUuid(UUID.randomUUID().toString());
        STAppEvents.postNewDomainEntity(domainEntity);
        return domainEntity;
    }

    public DomainVisitor newDomainVisitor(MetaDomain model, String name) {
        final DomainVisitor domainVisitor = newDomainVisitor().setName(name).setUuid(UUID.randomUUID().toString());
        model.addVisitors(domainVisitor);
        STAppEvents.postNewDomainVisitor(domainVisitor);
        return domainVisitor;
    }

    public EntityVisitorMethod newEntityVisitorMethod(DomainVisitor model, MetaEntity metaEntity) {
        final EntityVisitorMethod visitorMethod = newEntityVisitorMethod().set_meta(metaEntity).setUuid(UUID.randomUUID().toString()).setStatements("");
        model.addEntityVisitors(visitorMethod);
        return visitorMethod;
    }

    public RelationVisitorMethod newRelationVisitorMethod(DomainVisitor model, MetaRelation metaRelation) {
        final RelationVisitorMethod visitorMethod = newRelationVisitorMethod().set_meta(metaRelation).setUuid(UUID.randomUUID().toString()).setStatements("");
        model.addRelationVisitors(visitorMethod);
        return visitorMethod;
    }

    public void remove(MetaEntity metaEntity) {
        final Node node = metaEntity.getNode();
        node.getRelationships(Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
        node.getRelationships(Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
        node.delete();
    }

    public void remove(MetaProperty metaProperty) {
        final Node node = metaProperty.getNode();
        node.getRelationships(Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
        node.getRelationships(Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
        node.delete();
    }

    public void remove(MetaRelation metaRelation) {
        final Node node = metaRelation.getNode();
        node.getRelationships(Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);
        node.getRelationships(Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);
        node.delete();
    }
}