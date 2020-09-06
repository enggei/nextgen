package nextgen.st;

public class STAppEvents {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STAppEvents.class);

	public static void postNewMetaDomain(nextgen.domains.meta.MetaDomain metaDomain) {
		log.info("post NewMetaDomain");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewMetaDomain(metaDomain));
	}

	public static class NewMetaDomain {

		public final nextgen.domains.meta.MetaDomain metaDomain;

		public NewMetaDomain(nextgen.domains.meta.MetaDomain metaDomain) {
			this.metaDomain = metaDomain;
		}
	}

	public static void postNewMetaEntity(nextgen.domains.meta.MetaEntity metaEntity) {
		log.info("post NewMetaEntity");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewMetaEntity(metaEntity));
	}

	public static class NewMetaEntity {

		public final nextgen.domains.meta.MetaEntity metaEntity;

		public NewMetaEntity(nextgen.domains.meta.MetaEntity metaEntity) {
			this.metaEntity = metaEntity;
		}
	}

	public static void postNewMetaProperty(nextgen.domains.meta.MetaProperty metaProperty) {
		log.info("post NewMetaProperty");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewMetaProperty(metaProperty));
	}

	public static class NewMetaProperty {

		public final nextgen.domains.meta.MetaProperty metaProperty;

		public NewMetaProperty(nextgen.domains.meta.MetaProperty metaProperty) {
			this.metaProperty = metaProperty;
		}
	}

	public static void postNewMetaRelation(nextgen.domains.meta.MetaRelation metaRelation) {
		log.info("post NewMetaRelation");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewMetaRelation(metaRelation));
	}

	public static class NewMetaRelation {

		public final nextgen.domains.meta.MetaRelation metaRelation;

		public NewMetaRelation(nextgen.domains.meta.MetaRelation metaRelation) {
			this.metaRelation = metaRelation;
		}
	}

	public static void postCanvasSTModelClicked(nextgen.st.model.STModel stModel) {
		log.info("post CanvasSTModelClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new CanvasSTModelClicked(stModel));
	}

	public static class CanvasSTModelClicked {

		public final nextgen.st.model.STModel stModel;

		public CanvasSTModelClicked(nextgen.st.model.STModel stModel) {
			this.stModel = stModel;
		}
	}

	public static void postSTModelUpdated() {
		log.info("post STModelUpdated");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelUpdated());
	}

	public static class STModelUpdated {


		public STModelUpdated() {
		}
	}

	public static void postNewDomainEntity(nextgen.domains.meta.DomainEntity domainEntity) {
		log.info("post NewDomainEntity");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewDomainEntity(domainEntity));
	}

	public static class NewDomainEntity {

		public final nextgen.domains.meta.DomainEntity domainEntity;

		public NewDomainEntity(nextgen.domains.meta.DomainEntity domainEntity) {
			this.domainEntity = domainEntity;
		}
	}

	public static void postOpenMetaDomain(nextgen.domains.meta.MetaDomain metaDomain) {
		log.info("post OpenMetaDomain");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenMetaDomain(metaDomain));
	}

	public static class OpenMetaDomain {

		public final nextgen.domains.meta.MetaDomain metaDomain;

		public OpenMetaDomain(nextgen.domains.meta.MetaDomain metaDomain) {
			this.metaDomain = metaDomain;
		}
	}

	public static void postOpenMetaEntity(nextgen.domains.meta.MetaEntity metaEntity) {
		log.info("post OpenMetaEntity");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenMetaEntity(metaEntity));
	}

	public static class OpenMetaEntity {

		public final nextgen.domains.meta.MetaEntity metaEntity;

		public OpenMetaEntity(nextgen.domains.meta.MetaEntity metaEntity) {
			this.metaEntity = metaEntity;
		}
	}

	public static void postOpenMetaProperty(nextgen.domains.meta.MetaProperty metaProperty) {
		log.info("post OpenMetaProperty");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenMetaProperty(metaProperty));
	}

	public static class OpenMetaProperty {

		public final nextgen.domains.meta.MetaProperty metaProperty;

		public OpenMetaProperty(nextgen.domains.meta.MetaProperty metaProperty) {
			this.metaProperty = metaProperty;
		}
	}

	public static void postOpenMetaRelation(nextgen.domains.meta.MetaRelation metaRelation) {
		log.info("post OpenMetaRelation");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenMetaRelation(metaRelation));
	}

	public static class OpenMetaRelation {

		public final nextgen.domains.meta.MetaRelation metaRelation;

		public OpenMetaRelation(nextgen.domains.meta.MetaRelation metaRelation) {
			this.metaRelation = metaRelation;
		}
	}

	public static void postNewDomainVisitor(nextgen.domains.meta.DomainVisitor domainVisitor) {
		log.info("post NewDomainVisitor");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewDomainVisitor(domainVisitor));
	}

	public static void postRemovedDomainVisitor(java.lang.String uuid) {
		log.info("post RemovedDomainVisitor");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedDomainVisitor(uuid));
	}

	public static void postOpenDomainVisitor(nextgen.domains.meta.DomainVisitor domainVisitor) {
		log.info("post OpenDomainVisitor");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenDomainVisitor(domainVisitor));
	}

	public static class NewDomainVisitor {

		public final nextgen.domains.meta.DomainVisitor domainVisitor;

		public NewDomainVisitor(nextgen.domains.meta.DomainVisitor domainVisitor) {
			this.domainVisitor = domainVisitor;
		}
	}

	public static class RemovedDomainVisitor {

		public final java.lang.String uuid;

		public RemovedDomainVisitor(java.lang.String uuid) {
			this.uuid = uuid;
		}
	}

	public static class OpenDomainVisitor {

		public final nextgen.domains.meta.DomainVisitor domainVisitor;

		public OpenDomainVisitor(nextgen.domains.meta.DomainVisitor domainVisitor) {
			this.domainVisitor = domainVisitor;
		}
	}

	public static void postNewProject(nextgen.st.model.Project project) {
		log.info("post NewProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewProject(project));
	}

	public static void postRemovedProject(java.lang.String uuid) {
		log.info("post RemovedProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedProject(uuid));
	}

	public static void postOpenProject(nextgen.st.model.Project project) {
		log.info("post OpenProject");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenProject(project));
	}

	public static class NewProject {

		public final nextgen.st.model.Project project;

		public NewProject(nextgen.st.model.Project project) {
			this.project = project;
		}
	}

	public static class RemovedProject {

		public final java.lang.String uuid;

		public RemovedProject(java.lang.String uuid) {
			this.uuid = uuid;
		}
	}

	public static class OpenProject {

		public final nextgen.st.model.Project project;

		public OpenProject(nextgen.st.model.Project project) {
			this.project = project;
		}
	}

	public static void postNewSTModel(nextgen.st.model.STModel sTModel) {
		log.info("post NewSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTModel(sTModel));
	}

	public static void postRemovedSTModel(java.lang.String uuid) {
		log.info("post RemovedSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedSTModel(uuid));
	}

	public static void postOpenSTModel(nextgen.st.model.STModel sTModel) {
		log.info("post OpenSTModel");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenSTModel(sTModel));
	}

	public static class NewSTModel {

		public final nextgen.st.model.STModel sTModel;

		public NewSTModel(nextgen.st.model.STModel sTModel) {
			this.sTModel = sTModel;
		}
	}

	public static class RemovedSTModel {

		public final java.lang.String uuid;

		public RemovedSTModel(java.lang.String uuid) {
			this.uuid = uuid;
		}
	}

	public static class OpenSTModel {

		public final nextgen.st.model.STModel sTModel;

		public OpenSTModel(nextgen.st.model.STModel sTModel) {
			this.sTModel = sTModel;
		}
	}

	public static void postNewSTValue(nextgen.st.model.STValue sTValue) {
		log.info("post NewSTValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTValue(sTValue));
	}

	public static void postRemovedSTValue(java.lang.String uuid) {
		log.info("post RemovedSTValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedSTValue(uuid));
	}

	public static void postOpenSTValue(nextgen.st.model.STValue sTValue) {
		log.info("post OpenSTValue");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenSTValue(sTValue));
	}

	public static class NewSTValue {

		public final nextgen.st.model.STValue sTValue;

		public NewSTValue(nextgen.st.model.STValue sTValue) {
			this.sTValue = sTValue;
		}
	}

	public static class RemovedSTValue {

		public final java.lang.String uuid;

		public RemovedSTValue(java.lang.String uuid) {
			this.uuid = uuid;
		}
	}

	public static class OpenSTValue {

		public final nextgen.st.model.STValue sTValue;

		public OpenSTValue(nextgen.st.model.STValue sTValue) {
			this.sTValue = sTValue;
		}
	}

	public static void postNewScript(nextgen.st.model.Script script) {
		log.info("post NewScript");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewScript(script));
	}

	public static void postRemovedScript(java.lang.String uuid) {
		log.info("post RemovedScript");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedScript(uuid));
	}

	public static void postOpenScript(nextgen.st.model.Script script) {
		log.info("post OpenScript");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenScript(script));
	}

	public static class NewScript {

		public final nextgen.st.model.Script script;

		public NewScript(nextgen.st.model.Script script) {
			this.script = script;
		}
	}

	public static class RemovedScript {

		public final java.lang.String uuid;

		public RemovedScript(java.lang.String uuid) {
			this.uuid = uuid;
		}
	}

	public static class OpenScript {

		public final nextgen.st.model.Script script;

		public OpenScript(nextgen.st.model.Script script) {
			this.script = script;
		}
	}

	public static void postNewSTTemplate(nextgen.st.domain.STTemplate sTTemplate) {
		log.info("post NewSTTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSTTemplate(sTTemplate));
	}

	public static void postRemovedSTTemplate(java.lang.String uuid) {
		log.info("post RemovedSTTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new RemovedSTTemplate(uuid));
	}

	public static void postOpenSTTemplate(nextgen.st.domain.STTemplate sTTemplate) {
		log.info("post OpenSTTemplate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new OpenSTTemplate(sTTemplate));
	}

	public static class NewSTTemplate {

		public final nextgen.st.domain.STTemplate sTTemplate;

		public NewSTTemplate(nextgen.st.domain.STTemplate sTTemplate) {
			this.sTTemplate = sTTemplate;
		}
	}

	public static class RemovedSTTemplate {

		public final java.lang.String uuid;

		public RemovedSTTemplate(java.lang.String uuid) {
			this.uuid = uuid;
		}
	}

	public static class OpenSTTemplate {

		public final nextgen.st.domain.STTemplate sTTemplate;

		public OpenSTTemplate(nextgen.st.domain.STTemplate sTTemplate) {
			this.sTTemplate = sTTemplate;
		}
	}

	public static void postSTModelTreeNodeClicked(nextgen.st.model.STModel stModel) {
		log.info("post STModelTreeNodeClicked");
		org.greenrobot.eventbus.EventBus.getDefault().post(new STModelTreeNodeClicked(stModel));
	}

	public static class STModelTreeNodeClicked {

		public final nextgen.st.model.STModel stModel;

		public STModelTreeNodeClicked(nextgen.st.model.STModel stModel) {
			this.stModel = stModel;
		}
	}
}