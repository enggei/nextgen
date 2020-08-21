package nextgen.domains.meta;

public class DomainVisitorGenerator extends MetaDomainVisitor {


    final StringBuilder code = new StringBuilder();

    public DomainVisitorGenerator(DomainVisitor visitor) {
        visitor.getIncomingVisitorsMetaDomain().forEach(this::visit);
    }

    @Override
    public void beforeEntity(MetaEntity metaEntity) {
        super.beforeEntity(metaEntity);
        code.append("\"").append(metaEntity.getName()).append("\n");
    }

    @Override
    public void afterEntity(MetaEntity metaEntity) {
        super.afterEntity(metaEntity);
    }

    @Override
    public void beforeRelation(MetaRelation metaRelation) {
        super.beforeRelation(metaRelation);
    }

    @Override
    public void afterRelation(MetaRelation metaRelation) {
        super.afterRelation(metaRelation);
    }

    public String generate() {
        return "System.out.println(\"Hello it works...\");";
    }
}