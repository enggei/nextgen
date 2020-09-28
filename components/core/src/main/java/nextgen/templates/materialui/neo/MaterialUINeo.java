package nextgen.templates.materialui.neo;

import nextgen.st.model.*;
import org.neo4j.graphdb.Node;
import java.util.Optional;
import java.util.stream.Stream;

public class MaterialUINeo {

	private final STModelDB db;

	public MaterialUINeo(STModelDB db) {
		this.db = db;
	}

	public AccordionModel newAccordionModel() {
		return new AccordionModel(db);
	}

	public AccordionModel newAccordionModel(STModel stModel) {
		return new AccordionModel(db, stModel);
	}

	public AccordionModel newAccordionModel(Node node) {
		return new AccordionModel(db, node);
	}

	public Stream<AccordionModel> findAllAccordionModel() {
		return db.findAllSTModelByStTemplate(AccordionModel.stTemplateUuid)
				.map(stModel -> new AccordionModel(db, stModel));
	}

	public AccordionModel findAccordionModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AccordionModel(db, uuid) : new AccordionModel(db, stModel);
	}


	public AccordionImportModel newAccordionImportModel() {
		return new AccordionImportModel(db);
	}

	public AccordionImportModel newAccordionImportModel(STModel stModel) {
		return new AccordionImportModel(db, stModel);
	}

	public AccordionImportModel newAccordionImportModel(Node node) {
		return new AccordionImportModel(db, node);
	}

	public Stream<AccordionImportModel> findAllAccordionImportModel() {
		return db.findAllSTModelByStTemplate(AccordionImportModel.stTemplateUuid)
				.map(stModel -> new AccordionImportModel(db, stModel));
	}

	public AccordionImportModel findAccordionImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AccordionImportModel(db, uuid) : new AccordionImportModel(db, stModel);
	}


	public AccordionElementModel newAccordionElementModel() {
		return new AccordionElementModel(db);
	}

	public AccordionElementModel newAccordionElementModel(STModel stModel) {
		return new AccordionElementModel(db, stModel);
	}

	public AccordionElementModel newAccordionElementModel(Node node) {
		return new AccordionElementModel(db, node);
	}

	public Stream<AccordionElementModel> findAllAccordionElementModel() {
		return db.findAllSTModelByStTemplate(AccordionElementModel.stTemplateUuid)
				.map(stModel -> new AccordionElementModel(db, stModel));
	}

	public AccordionElementModel findAccordionElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AccordionElementModel(db, uuid) : new AccordionElementModel(db, stModel);
	}


	public AccordionActionsModel newAccordionActionsModel() {
		return new AccordionActionsModel(db);
	}

	public AccordionActionsModel newAccordionActionsModel(STModel stModel) {
		return new AccordionActionsModel(db, stModel);
	}

	public AccordionActionsModel newAccordionActionsModel(Node node) {
		return new AccordionActionsModel(db, node);
	}

	public Stream<AccordionActionsModel> findAllAccordionActionsModel() {
		return db.findAllSTModelByStTemplate(AccordionActionsModel.stTemplateUuid)
				.map(stModel -> new AccordionActionsModel(db, stModel));
	}

	public AccordionActionsModel findAccordionActionsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AccordionActionsModel(db, uuid) : new AccordionActionsModel(db, stModel);
	}


	public AccordionActionsImportModel newAccordionActionsImportModel() {
		return new AccordionActionsImportModel(db);
	}

	public AccordionActionsImportModel newAccordionActionsImportModel(STModel stModel) {
		return new AccordionActionsImportModel(db, stModel);
	}

	public AccordionActionsImportModel newAccordionActionsImportModel(Node node) {
		return new AccordionActionsImportModel(db, node);
	}

	public Stream<AccordionActionsImportModel> findAllAccordionActionsImportModel() {
		return db.findAllSTModelByStTemplate(AccordionActionsImportModel.stTemplateUuid)
				.map(stModel -> new AccordionActionsImportModel(db, stModel));
	}

	public AccordionActionsImportModel findAccordionActionsImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AccordionActionsImportModel(db, uuid) : new AccordionActionsImportModel(db, stModel);
	}


	public AccordionActionsElementModel newAccordionActionsElementModel() {
		return new AccordionActionsElementModel(db);
	}

	public AccordionActionsElementModel newAccordionActionsElementModel(STModel stModel) {
		return new AccordionActionsElementModel(db, stModel);
	}

	public AccordionActionsElementModel newAccordionActionsElementModel(Node node) {
		return new AccordionActionsElementModel(db, node);
	}

	public Stream<AccordionActionsElementModel> findAllAccordionActionsElementModel() {
		return db.findAllSTModelByStTemplate(AccordionActionsElementModel.stTemplateUuid)
				.map(stModel -> new AccordionActionsElementModel(db, stModel));
	}

	public AccordionActionsElementModel findAccordionActionsElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AccordionActionsElementModel(db, uuid) : new AccordionActionsElementModel(db, stModel);
	}


	public AccordionDetailsModel newAccordionDetailsModel() {
		return new AccordionDetailsModel(db);
	}

	public AccordionDetailsModel newAccordionDetailsModel(STModel stModel) {
		return new AccordionDetailsModel(db, stModel);
	}

	public AccordionDetailsModel newAccordionDetailsModel(Node node) {
		return new AccordionDetailsModel(db, node);
	}

	public Stream<AccordionDetailsModel> findAllAccordionDetailsModel() {
		return db.findAllSTModelByStTemplate(AccordionDetailsModel.stTemplateUuid)
				.map(stModel -> new AccordionDetailsModel(db, stModel));
	}

	public AccordionDetailsModel findAccordionDetailsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AccordionDetailsModel(db, uuid) : new AccordionDetailsModel(db, stModel);
	}


	public AccordionDetailsImportModel newAccordionDetailsImportModel() {
		return new AccordionDetailsImportModel(db);
	}

	public AccordionDetailsImportModel newAccordionDetailsImportModel(STModel stModel) {
		return new AccordionDetailsImportModel(db, stModel);
	}

	public AccordionDetailsImportModel newAccordionDetailsImportModel(Node node) {
		return new AccordionDetailsImportModel(db, node);
	}

	public Stream<AccordionDetailsImportModel> findAllAccordionDetailsImportModel() {
		return db.findAllSTModelByStTemplate(AccordionDetailsImportModel.stTemplateUuid)
				.map(stModel -> new AccordionDetailsImportModel(db, stModel));
	}

	public AccordionDetailsImportModel findAccordionDetailsImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AccordionDetailsImportModel(db, uuid) : new AccordionDetailsImportModel(db, stModel);
	}


	public AccordionDetailsElementModel newAccordionDetailsElementModel() {
		return new AccordionDetailsElementModel(db);
	}

	public AccordionDetailsElementModel newAccordionDetailsElementModel(STModel stModel) {
		return new AccordionDetailsElementModel(db, stModel);
	}

	public AccordionDetailsElementModel newAccordionDetailsElementModel(Node node) {
		return new AccordionDetailsElementModel(db, node);
	}

	public Stream<AccordionDetailsElementModel> findAllAccordionDetailsElementModel() {
		return db.findAllSTModelByStTemplate(AccordionDetailsElementModel.stTemplateUuid)
				.map(stModel -> new AccordionDetailsElementModel(db, stModel));
	}

	public AccordionDetailsElementModel findAccordionDetailsElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AccordionDetailsElementModel(db, uuid) : new AccordionDetailsElementModel(db, stModel);
	}


	public AccordionSummaryModel newAccordionSummaryModel() {
		return new AccordionSummaryModel(db);
	}

	public AccordionSummaryModel newAccordionSummaryModel(STModel stModel) {
		return new AccordionSummaryModel(db, stModel);
	}

	public AccordionSummaryModel newAccordionSummaryModel(Node node) {
		return new AccordionSummaryModel(db, node);
	}

	public Stream<AccordionSummaryModel> findAllAccordionSummaryModel() {
		return db.findAllSTModelByStTemplate(AccordionSummaryModel.stTemplateUuid)
				.map(stModel -> new AccordionSummaryModel(db, stModel));
	}

	public AccordionSummaryModel findAccordionSummaryModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AccordionSummaryModel(db, uuid) : new AccordionSummaryModel(db, stModel);
	}


	public AccordionSummaryImportModel newAccordionSummaryImportModel() {
		return new AccordionSummaryImportModel(db);
	}

	public AccordionSummaryImportModel newAccordionSummaryImportModel(STModel stModel) {
		return new AccordionSummaryImportModel(db, stModel);
	}

	public AccordionSummaryImportModel newAccordionSummaryImportModel(Node node) {
		return new AccordionSummaryImportModel(db, node);
	}

	public Stream<AccordionSummaryImportModel> findAllAccordionSummaryImportModel() {
		return db.findAllSTModelByStTemplate(AccordionSummaryImportModel.stTemplateUuid)
				.map(stModel -> new AccordionSummaryImportModel(db, stModel));
	}

	public AccordionSummaryImportModel findAccordionSummaryImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AccordionSummaryImportModel(db, uuid) : new AccordionSummaryImportModel(db, stModel);
	}


	public AccordionSummaryElementModel newAccordionSummaryElementModel() {
		return new AccordionSummaryElementModel(db);
	}

	public AccordionSummaryElementModel newAccordionSummaryElementModel(STModel stModel) {
		return new AccordionSummaryElementModel(db, stModel);
	}

	public AccordionSummaryElementModel newAccordionSummaryElementModel(Node node) {
		return new AccordionSummaryElementModel(db, node);
	}

	public Stream<AccordionSummaryElementModel> findAllAccordionSummaryElementModel() {
		return db.findAllSTModelByStTemplate(AccordionSummaryElementModel.stTemplateUuid)
				.map(stModel -> new AccordionSummaryElementModel(db, stModel));
	}

	public AccordionSummaryElementModel findAccordionSummaryElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AccordionSummaryElementModel(db, uuid) : new AccordionSummaryElementModel(db, stModel);
	}


	public AlertModel newAlertModel() {
		return new AlertModel(db);
	}

	public AlertModel newAlertModel(STModel stModel) {
		return new AlertModel(db, stModel);
	}

	public AlertModel newAlertModel(Node node) {
		return new AlertModel(db, node);
	}

	public Stream<AlertModel> findAllAlertModel() {
		return db.findAllSTModelByStTemplate(AlertModel.stTemplateUuid)
				.map(stModel -> new AlertModel(db, stModel));
	}

	public AlertModel findAlertModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AlertModel(db, uuid) : new AlertModel(db, stModel);
	}


	public AlertImportModel newAlertImportModel() {
		return new AlertImportModel(db);
	}

	public AlertImportModel newAlertImportModel(STModel stModel) {
		return new AlertImportModel(db, stModel);
	}

	public AlertImportModel newAlertImportModel(Node node) {
		return new AlertImportModel(db, node);
	}

	public Stream<AlertImportModel> findAllAlertImportModel() {
		return db.findAllSTModelByStTemplate(AlertImportModel.stTemplateUuid)
				.map(stModel -> new AlertImportModel(db, stModel));
	}

	public AlertImportModel findAlertImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AlertImportModel(db, uuid) : new AlertImportModel(db, stModel);
	}


	public AlertElementModel newAlertElementModel() {
		return new AlertElementModel(db);
	}

	public AlertElementModel newAlertElementModel(STModel stModel) {
		return new AlertElementModel(db, stModel);
	}

	public AlertElementModel newAlertElementModel(Node node) {
		return new AlertElementModel(db, node);
	}

	public Stream<AlertElementModel> findAllAlertElementModel() {
		return db.findAllSTModelByStTemplate(AlertElementModel.stTemplateUuid)
				.map(stModel -> new AlertElementModel(db, stModel));
	}

	public AlertElementModel findAlertElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AlertElementModel(db, uuid) : new AlertElementModel(db, stModel);
	}


	public AlertTitleModel newAlertTitleModel() {
		return new AlertTitleModel(db);
	}

	public AlertTitleModel newAlertTitleModel(STModel stModel) {
		return new AlertTitleModel(db, stModel);
	}

	public AlertTitleModel newAlertTitleModel(Node node) {
		return new AlertTitleModel(db, node);
	}

	public Stream<AlertTitleModel> findAllAlertTitleModel() {
		return db.findAllSTModelByStTemplate(AlertTitleModel.stTemplateUuid)
				.map(stModel -> new AlertTitleModel(db, stModel));
	}

	public AlertTitleModel findAlertTitleModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AlertTitleModel(db, uuid) : new AlertTitleModel(db, stModel);
	}


	public AlertTitleImportModel newAlertTitleImportModel() {
		return new AlertTitleImportModel(db);
	}

	public AlertTitleImportModel newAlertTitleImportModel(STModel stModel) {
		return new AlertTitleImportModel(db, stModel);
	}

	public AlertTitleImportModel newAlertTitleImportModel(Node node) {
		return new AlertTitleImportModel(db, node);
	}

	public Stream<AlertTitleImportModel> findAllAlertTitleImportModel() {
		return db.findAllSTModelByStTemplate(AlertTitleImportModel.stTemplateUuid)
				.map(stModel -> new AlertTitleImportModel(db, stModel));
	}

	public AlertTitleImportModel findAlertTitleImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AlertTitleImportModel(db, uuid) : new AlertTitleImportModel(db, stModel);
	}


	public AlertTitleElementModel newAlertTitleElementModel() {
		return new AlertTitleElementModel(db);
	}

	public AlertTitleElementModel newAlertTitleElementModel(STModel stModel) {
		return new AlertTitleElementModel(db, stModel);
	}

	public AlertTitleElementModel newAlertTitleElementModel(Node node) {
		return new AlertTitleElementModel(db, node);
	}

	public Stream<AlertTitleElementModel> findAllAlertTitleElementModel() {
		return db.findAllSTModelByStTemplate(AlertTitleElementModel.stTemplateUuid)
				.map(stModel -> new AlertTitleElementModel(db, stModel));
	}

	public AlertTitleElementModel findAlertTitleElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AlertTitleElementModel(db, uuid) : new AlertTitleElementModel(db, stModel);
	}


	public AppBarModel newAppBarModel() {
		return new AppBarModel(db);
	}

	public AppBarModel newAppBarModel(STModel stModel) {
		return new AppBarModel(db, stModel);
	}

	public AppBarModel newAppBarModel(Node node) {
		return new AppBarModel(db, node);
	}

	public Stream<AppBarModel> findAllAppBarModel() {
		return db.findAllSTModelByStTemplate(AppBarModel.stTemplateUuid)
				.map(stModel -> new AppBarModel(db, stModel));
	}

	public AppBarModel findAppBarModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AppBarModel(db, uuid) : new AppBarModel(db, stModel);
	}


	public AppBarImportModel newAppBarImportModel() {
		return new AppBarImportModel(db);
	}

	public AppBarImportModel newAppBarImportModel(STModel stModel) {
		return new AppBarImportModel(db, stModel);
	}

	public AppBarImportModel newAppBarImportModel(Node node) {
		return new AppBarImportModel(db, node);
	}

	public Stream<AppBarImportModel> findAllAppBarImportModel() {
		return db.findAllSTModelByStTemplate(AppBarImportModel.stTemplateUuid)
				.map(stModel -> new AppBarImportModel(db, stModel));
	}

	public AppBarImportModel findAppBarImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AppBarImportModel(db, uuid) : new AppBarImportModel(db, stModel);
	}


	public AppBarElementModel newAppBarElementModel() {
		return new AppBarElementModel(db);
	}

	public AppBarElementModel newAppBarElementModel(STModel stModel) {
		return new AppBarElementModel(db, stModel);
	}

	public AppBarElementModel newAppBarElementModel(Node node) {
		return new AppBarElementModel(db, node);
	}

	public Stream<AppBarElementModel> findAllAppBarElementModel() {
		return db.findAllSTModelByStTemplate(AppBarElementModel.stTemplateUuid)
				.map(stModel -> new AppBarElementModel(db, stModel));
	}

	public AppBarElementModel findAppBarElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AppBarElementModel(db, uuid) : new AppBarElementModel(db, stModel);
	}


	public AutocompleteModel newAutocompleteModel() {
		return new AutocompleteModel(db);
	}

	public AutocompleteModel newAutocompleteModel(STModel stModel) {
		return new AutocompleteModel(db, stModel);
	}

	public AutocompleteModel newAutocompleteModel(Node node) {
		return new AutocompleteModel(db, node);
	}

	public Stream<AutocompleteModel> findAllAutocompleteModel() {
		return db.findAllSTModelByStTemplate(AutocompleteModel.stTemplateUuid)
				.map(stModel -> new AutocompleteModel(db, stModel));
	}

	public AutocompleteModel findAutocompleteModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AutocompleteModel(db, uuid) : new AutocompleteModel(db, stModel);
	}


	public AutocompleteImportModel newAutocompleteImportModel() {
		return new AutocompleteImportModel(db);
	}

	public AutocompleteImportModel newAutocompleteImportModel(STModel stModel) {
		return new AutocompleteImportModel(db, stModel);
	}

	public AutocompleteImportModel newAutocompleteImportModel(Node node) {
		return new AutocompleteImportModel(db, node);
	}

	public Stream<AutocompleteImportModel> findAllAutocompleteImportModel() {
		return db.findAllSTModelByStTemplate(AutocompleteImportModel.stTemplateUuid)
				.map(stModel -> new AutocompleteImportModel(db, stModel));
	}

	public AutocompleteImportModel findAutocompleteImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AutocompleteImportModel(db, uuid) : new AutocompleteImportModel(db, stModel);
	}


	public AutocompleteElementModel newAutocompleteElementModel() {
		return new AutocompleteElementModel(db);
	}

	public AutocompleteElementModel newAutocompleteElementModel(STModel stModel) {
		return new AutocompleteElementModel(db, stModel);
	}

	public AutocompleteElementModel newAutocompleteElementModel(Node node) {
		return new AutocompleteElementModel(db, node);
	}

	public Stream<AutocompleteElementModel> findAllAutocompleteElementModel() {
		return db.findAllSTModelByStTemplate(AutocompleteElementModel.stTemplateUuid)
				.map(stModel -> new AutocompleteElementModel(db, stModel));
	}

	public AutocompleteElementModel findAutocompleteElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AutocompleteElementModel(db, uuid) : new AutocompleteElementModel(db, stModel);
	}


	public AvatarModel newAvatarModel() {
		return new AvatarModel(db);
	}

	public AvatarModel newAvatarModel(STModel stModel) {
		return new AvatarModel(db, stModel);
	}

	public AvatarModel newAvatarModel(Node node) {
		return new AvatarModel(db, node);
	}

	public Stream<AvatarModel> findAllAvatarModel() {
		return db.findAllSTModelByStTemplate(AvatarModel.stTemplateUuid)
				.map(stModel -> new AvatarModel(db, stModel));
	}

	public AvatarModel findAvatarModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AvatarModel(db, uuid) : new AvatarModel(db, stModel);
	}


	public AvatarImportModel newAvatarImportModel() {
		return new AvatarImportModel(db);
	}

	public AvatarImportModel newAvatarImportModel(STModel stModel) {
		return new AvatarImportModel(db, stModel);
	}

	public AvatarImportModel newAvatarImportModel(Node node) {
		return new AvatarImportModel(db, node);
	}

	public Stream<AvatarImportModel> findAllAvatarImportModel() {
		return db.findAllSTModelByStTemplate(AvatarImportModel.stTemplateUuid)
				.map(stModel -> new AvatarImportModel(db, stModel));
	}

	public AvatarImportModel findAvatarImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AvatarImportModel(db, uuid) : new AvatarImportModel(db, stModel);
	}


	public AvatarElementModel newAvatarElementModel() {
		return new AvatarElementModel(db);
	}

	public AvatarElementModel newAvatarElementModel(STModel stModel) {
		return new AvatarElementModel(db, stModel);
	}

	public AvatarElementModel newAvatarElementModel(Node node) {
		return new AvatarElementModel(db, node);
	}

	public Stream<AvatarElementModel> findAllAvatarElementModel() {
		return db.findAllSTModelByStTemplate(AvatarElementModel.stTemplateUuid)
				.map(stModel -> new AvatarElementModel(db, stModel));
	}

	public AvatarElementModel findAvatarElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AvatarElementModel(db, uuid) : new AvatarElementModel(db, stModel);
	}


	public AvatarGroupModel newAvatarGroupModel() {
		return new AvatarGroupModel(db);
	}

	public AvatarGroupModel newAvatarGroupModel(STModel stModel) {
		return new AvatarGroupModel(db, stModel);
	}

	public AvatarGroupModel newAvatarGroupModel(Node node) {
		return new AvatarGroupModel(db, node);
	}

	public Stream<AvatarGroupModel> findAllAvatarGroupModel() {
		return db.findAllSTModelByStTemplate(AvatarGroupModel.stTemplateUuid)
				.map(stModel -> new AvatarGroupModel(db, stModel));
	}

	public AvatarGroupModel findAvatarGroupModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AvatarGroupModel(db, uuid) : new AvatarGroupModel(db, stModel);
	}


	public AvatarGroupImportModel newAvatarGroupImportModel() {
		return new AvatarGroupImportModel(db);
	}

	public AvatarGroupImportModel newAvatarGroupImportModel(STModel stModel) {
		return new AvatarGroupImportModel(db, stModel);
	}

	public AvatarGroupImportModel newAvatarGroupImportModel(Node node) {
		return new AvatarGroupImportModel(db, node);
	}

	public Stream<AvatarGroupImportModel> findAllAvatarGroupImportModel() {
		return db.findAllSTModelByStTemplate(AvatarGroupImportModel.stTemplateUuid)
				.map(stModel -> new AvatarGroupImportModel(db, stModel));
	}

	public AvatarGroupImportModel findAvatarGroupImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AvatarGroupImportModel(db, uuid) : new AvatarGroupImportModel(db, stModel);
	}


	public AvatarGroupElementModel newAvatarGroupElementModel() {
		return new AvatarGroupElementModel(db);
	}

	public AvatarGroupElementModel newAvatarGroupElementModel(STModel stModel) {
		return new AvatarGroupElementModel(db, stModel);
	}

	public AvatarGroupElementModel newAvatarGroupElementModel(Node node) {
		return new AvatarGroupElementModel(db, node);
	}

	public Stream<AvatarGroupElementModel> findAllAvatarGroupElementModel() {
		return db.findAllSTModelByStTemplate(AvatarGroupElementModel.stTemplateUuid)
				.map(stModel -> new AvatarGroupElementModel(db, stModel));
	}

	public AvatarGroupElementModel findAvatarGroupElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new AvatarGroupElementModel(db, uuid) : new AvatarGroupElementModel(db, stModel);
	}


	public BackdropModel newBackdropModel() {
		return new BackdropModel(db);
	}

	public BackdropModel newBackdropModel(STModel stModel) {
		return new BackdropModel(db, stModel);
	}

	public BackdropModel newBackdropModel(Node node) {
		return new BackdropModel(db, node);
	}

	public Stream<BackdropModel> findAllBackdropModel() {
		return db.findAllSTModelByStTemplate(BackdropModel.stTemplateUuid)
				.map(stModel -> new BackdropModel(db, stModel));
	}

	public BackdropModel findBackdropModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BackdropModel(db, uuid) : new BackdropModel(db, stModel);
	}


	public BackdropImportModel newBackdropImportModel() {
		return new BackdropImportModel(db);
	}

	public BackdropImportModel newBackdropImportModel(STModel stModel) {
		return new BackdropImportModel(db, stModel);
	}

	public BackdropImportModel newBackdropImportModel(Node node) {
		return new BackdropImportModel(db, node);
	}

	public Stream<BackdropImportModel> findAllBackdropImportModel() {
		return db.findAllSTModelByStTemplate(BackdropImportModel.stTemplateUuid)
				.map(stModel -> new BackdropImportModel(db, stModel));
	}

	public BackdropImportModel findBackdropImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BackdropImportModel(db, uuid) : new BackdropImportModel(db, stModel);
	}


	public BackdropElementModel newBackdropElementModel() {
		return new BackdropElementModel(db);
	}

	public BackdropElementModel newBackdropElementModel(STModel stModel) {
		return new BackdropElementModel(db, stModel);
	}

	public BackdropElementModel newBackdropElementModel(Node node) {
		return new BackdropElementModel(db, node);
	}

	public Stream<BackdropElementModel> findAllBackdropElementModel() {
		return db.findAllSTModelByStTemplate(BackdropElementModel.stTemplateUuid)
				.map(stModel -> new BackdropElementModel(db, stModel));
	}

	public BackdropElementModel findBackdropElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BackdropElementModel(db, uuid) : new BackdropElementModel(db, stModel);
	}


	public BadgeModel newBadgeModel() {
		return new BadgeModel(db);
	}

	public BadgeModel newBadgeModel(STModel stModel) {
		return new BadgeModel(db, stModel);
	}

	public BadgeModel newBadgeModel(Node node) {
		return new BadgeModel(db, node);
	}

	public Stream<BadgeModel> findAllBadgeModel() {
		return db.findAllSTModelByStTemplate(BadgeModel.stTemplateUuid)
				.map(stModel -> new BadgeModel(db, stModel));
	}

	public BadgeModel findBadgeModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BadgeModel(db, uuid) : new BadgeModel(db, stModel);
	}


	public BadgeImportModel newBadgeImportModel() {
		return new BadgeImportModel(db);
	}

	public BadgeImportModel newBadgeImportModel(STModel stModel) {
		return new BadgeImportModel(db, stModel);
	}

	public BadgeImportModel newBadgeImportModel(Node node) {
		return new BadgeImportModel(db, node);
	}

	public Stream<BadgeImportModel> findAllBadgeImportModel() {
		return db.findAllSTModelByStTemplate(BadgeImportModel.stTemplateUuid)
				.map(stModel -> new BadgeImportModel(db, stModel));
	}

	public BadgeImportModel findBadgeImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BadgeImportModel(db, uuid) : new BadgeImportModel(db, stModel);
	}


	public BadgeElementModel newBadgeElementModel() {
		return new BadgeElementModel(db);
	}

	public BadgeElementModel newBadgeElementModel(STModel stModel) {
		return new BadgeElementModel(db, stModel);
	}

	public BadgeElementModel newBadgeElementModel(Node node) {
		return new BadgeElementModel(db, node);
	}

	public Stream<BadgeElementModel> findAllBadgeElementModel() {
		return db.findAllSTModelByStTemplate(BadgeElementModel.stTemplateUuid)
				.map(stModel -> new BadgeElementModel(db, stModel));
	}

	public BadgeElementModel findBadgeElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BadgeElementModel(db, uuid) : new BadgeElementModel(db, stModel);
	}


	public BottomNavigationModel newBottomNavigationModel() {
		return new BottomNavigationModel(db);
	}

	public BottomNavigationModel newBottomNavigationModel(STModel stModel) {
		return new BottomNavigationModel(db, stModel);
	}

	public BottomNavigationModel newBottomNavigationModel(Node node) {
		return new BottomNavigationModel(db, node);
	}

	public Stream<BottomNavigationModel> findAllBottomNavigationModel() {
		return db.findAllSTModelByStTemplate(BottomNavigationModel.stTemplateUuid)
				.map(stModel -> new BottomNavigationModel(db, stModel));
	}

	public BottomNavigationModel findBottomNavigationModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BottomNavigationModel(db, uuid) : new BottomNavigationModel(db, stModel);
	}


	public BottomNavigationImportModel newBottomNavigationImportModel() {
		return new BottomNavigationImportModel(db);
	}

	public BottomNavigationImportModel newBottomNavigationImportModel(STModel stModel) {
		return new BottomNavigationImportModel(db, stModel);
	}

	public BottomNavigationImportModel newBottomNavigationImportModel(Node node) {
		return new BottomNavigationImportModel(db, node);
	}

	public Stream<BottomNavigationImportModel> findAllBottomNavigationImportModel() {
		return db.findAllSTModelByStTemplate(BottomNavigationImportModel.stTemplateUuid)
				.map(stModel -> new BottomNavigationImportModel(db, stModel));
	}

	public BottomNavigationImportModel findBottomNavigationImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BottomNavigationImportModel(db, uuid) : new BottomNavigationImportModel(db, stModel);
	}


	public BottomNavigationElementModel newBottomNavigationElementModel() {
		return new BottomNavigationElementModel(db);
	}

	public BottomNavigationElementModel newBottomNavigationElementModel(STModel stModel) {
		return new BottomNavigationElementModel(db, stModel);
	}

	public BottomNavigationElementModel newBottomNavigationElementModel(Node node) {
		return new BottomNavigationElementModel(db, node);
	}

	public Stream<BottomNavigationElementModel> findAllBottomNavigationElementModel() {
		return db.findAllSTModelByStTemplate(BottomNavigationElementModel.stTemplateUuid)
				.map(stModel -> new BottomNavigationElementModel(db, stModel));
	}

	public BottomNavigationElementModel findBottomNavigationElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BottomNavigationElementModel(db, uuid) : new BottomNavigationElementModel(db, stModel);
	}


	public BottomNavigationActionModel newBottomNavigationActionModel() {
		return new BottomNavigationActionModel(db);
	}

	public BottomNavigationActionModel newBottomNavigationActionModel(STModel stModel) {
		return new BottomNavigationActionModel(db, stModel);
	}

	public BottomNavigationActionModel newBottomNavigationActionModel(Node node) {
		return new BottomNavigationActionModel(db, node);
	}

	public Stream<BottomNavigationActionModel> findAllBottomNavigationActionModel() {
		return db.findAllSTModelByStTemplate(BottomNavigationActionModel.stTemplateUuid)
				.map(stModel -> new BottomNavigationActionModel(db, stModel));
	}

	public BottomNavigationActionModel findBottomNavigationActionModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BottomNavigationActionModel(db, uuid) : new BottomNavigationActionModel(db, stModel);
	}


	public BottomNavigationActionImportModel newBottomNavigationActionImportModel() {
		return new BottomNavigationActionImportModel(db);
	}

	public BottomNavigationActionImportModel newBottomNavigationActionImportModel(STModel stModel) {
		return new BottomNavigationActionImportModel(db, stModel);
	}

	public BottomNavigationActionImportModel newBottomNavigationActionImportModel(Node node) {
		return new BottomNavigationActionImportModel(db, node);
	}

	public Stream<BottomNavigationActionImportModel> findAllBottomNavigationActionImportModel() {
		return db.findAllSTModelByStTemplate(BottomNavigationActionImportModel.stTemplateUuid)
				.map(stModel -> new BottomNavigationActionImportModel(db, stModel));
	}

	public BottomNavigationActionImportModel findBottomNavigationActionImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BottomNavigationActionImportModel(db, uuid) : new BottomNavigationActionImportModel(db, stModel);
	}


	public BottomNavigationActionElementModel newBottomNavigationActionElementModel() {
		return new BottomNavigationActionElementModel(db);
	}

	public BottomNavigationActionElementModel newBottomNavigationActionElementModel(STModel stModel) {
		return new BottomNavigationActionElementModel(db, stModel);
	}

	public BottomNavigationActionElementModel newBottomNavigationActionElementModel(Node node) {
		return new BottomNavigationActionElementModel(db, node);
	}

	public Stream<BottomNavigationActionElementModel> findAllBottomNavigationActionElementModel() {
		return db.findAllSTModelByStTemplate(BottomNavigationActionElementModel.stTemplateUuid)
				.map(stModel -> new BottomNavigationActionElementModel(db, stModel));
	}

	public BottomNavigationActionElementModel findBottomNavigationActionElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BottomNavigationActionElementModel(db, uuid) : new BottomNavigationActionElementModel(db, stModel);
	}


	public BreadcrumbsModel newBreadcrumbsModel() {
		return new BreadcrumbsModel(db);
	}

	public BreadcrumbsModel newBreadcrumbsModel(STModel stModel) {
		return new BreadcrumbsModel(db, stModel);
	}

	public BreadcrumbsModel newBreadcrumbsModel(Node node) {
		return new BreadcrumbsModel(db, node);
	}

	public Stream<BreadcrumbsModel> findAllBreadcrumbsModel() {
		return db.findAllSTModelByStTemplate(BreadcrumbsModel.stTemplateUuid)
				.map(stModel -> new BreadcrumbsModel(db, stModel));
	}

	public BreadcrumbsModel findBreadcrumbsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BreadcrumbsModel(db, uuid) : new BreadcrumbsModel(db, stModel);
	}


	public BreadcrumbsImportModel newBreadcrumbsImportModel() {
		return new BreadcrumbsImportModel(db);
	}

	public BreadcrumbsImportModel newBreadcrumbsImportModel(STModel stModel) {
		return new BreadcrumbsImportModel(db, stModel);
	}

	public BreadcrumbsImportModel newBreadcrumbsImportModel(Node node) {
		return new BreadcrumbsImportModel(db, node);
	}

	public Stream<BreadcrumbsImportModel> findAllBreadcrumbsImportModel() {
		return db.findAllSTModelByStTemplate(BreadcrumbsImportModel.stTemplateUuid)
				.map(stModel -> new BreadcrumbsImportModel(db, stModel));
	}

	public BreadcrumbsImportModel findBreadcrumbsImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BreadcrumbsImportModel(db, uuid) : new BreadcrumbsImportModel(db, stModel);
	}


	public BreadcrumbsElementModel newBreadcrumbsElementModel() {
		return new BreadcrumbsElementModel(db);
	}

	public BreadcrumbsElementModel newBreadcrumbsElementModel(STModel stModel) {
		return new BreadcrumbsElementModel(db, stModel);
	}

	public BreadcrumbsElementModel newBreadcrumbsElementModel(Node node) {
		return new BreadcrumbsElementModel(db, node);
	}

	public Stream<BreadcrumbsElementModel> findAllBreadcrumbsElementModel() {
		return db.findAllSTModelByStTemplate(BreadcrumbsElementModel.stTemplateUuid)
				.map(stModel -> new BreadcrumbsElementModel(db, stModel));
	}

	public BreadcrumbsElementModel findBreadcrumbsElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BreadcrumbsElementModel(db, uuid) : new BreadcrumbsElementModel(db, stModel);
	}


	public ButtonModel newButtonModel() {
		return new ButtonModel(db);
	}

	public ButtonModel newButtonModel(STModel stModel) {
		return new ButtonModel(db, stModel);
	}

	public ButtonModel newButtonModel(Node node) {
		return new ButtonModel(db, node);
	}

	public Stream<ButtonModel> findAllButtonModel() {
		return db.findAllSTModelByStTemplate(ButtonModel.stTemplateUuid)
				.map(stModel -> new ButtonModel(db, stModel));
	}

	public ButtonModel findButtonModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ButtonModel(db, uuid) : new ButtonModel(db, stModel);
	}


	public ButtonImportModel newButtonImportModel() {
		return new ButtonImportModel(db);
	}

	public ButtonImportModel newButtonImportModel(STModel stModel) {
		return new ButtonImportModel(db, stModel);
	}

	public ButtonImportModel newButtonImportModel(Node node) {
		return new ButtonImportModel(db, node);
	}

	public Stream<ButtonImportModel> findAllButtonImportModel() {
		return db.findAllSTModelByStTemplate(ButtonImportModel.stTemplateUuid)
				.map(stModel -> new ButtonImportModel(db, stModel));
	}

	public ButtonImportModel findButtonImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ButtonImportModel(db, uuid) : new ButtonImportModel(db, stModel);
	}


	public ButtonElementModel newButtonElementModel() {
		return new ButtonElementModel(db);
	}

	public ButtonElementModel newButtonElementModel(STModel stModel) {
		return new ButtonElementModel(db, stModel);
	}

	public ButtonElementModel newButtonElementModel(Node node) {
		return new ButtonElementModel(db, node);
	}

	public Stream<ButtonElementModel> findAllButtonElementModel() {
		return db.findAllSTModelByStTemplate(ButtonElementModel.stTemplateUuid)
				.map(stModel -> new ButtonElementModel(db, stModel));
	}

	public ButtonElementModel findButtonElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ButtonElementModel(db, uuid) : new ButtonElementModel(db, stModel);
	}


	public ButtonBaseModel newButtonBaseModel() {
		return new ButtonBaseModel(db);
	}

	public ButtonBaseModel newButtonBaseModel(STModel stModel) {
		return new ButtonBaseModel(db, stModel);
	}

	public ButtonBaseModel newButtonBaseModel(Node node) {
		return new ButtonBaseModel(db, node);
	}

	public Stream<ButtonBaseModel> findAllButtonBaseModel() {
		return db.findAllSTModelByStTemplate(ButtonBaseModel.stTemplateUuid)
				.map(stModel -> new ButtonBaseModel(db, stModel));
	}

	public ButtonBaseModel findButtonBaseModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ButtonBaseModel(db, uuid) : new ButtonBaseModel(db, stModel);
	}


	public ButtonBaseImportModel newButtonBaseImportModel() {
		return new ButtonBaseImportModel(db);
	}

	public ButtonBaseImportModel newButtonBaseImportModel(STModel stModel) {
		return new ButtonBaseImportModel(db, stModel);
	}

	public ButtonBaseImportModel newButtonBaseImportModel(Node node) {
		return new ButtonBaseImportModel(db, node);
	}

	public Stream<ButtonBaseImportModel> findAllButtonBaseImportModel() {
		return db.findAllSTModelByStTemplate(ButtonBaseImportModel.stTemplateUuid)
				.map(stModel -> new ButtonBaseImportModel(db, stModel));
	}

	public ButtonBaseImportModel findButtonBaseImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ButtonBaseImportModel(db, uuid) : new ButtonBaseImportModel(db, stModel);
	}


	public ButtonBaseElementModel newButtonBaseElementModel() {
		return new ButtonBaseElementModel(db);
	}

	public ButtonBaseElementModel newButtonBaseElementModel(STModel stModel) {
		return new ButtonBaseElementModel(db, stModel);
	}

	public ButtonBaseElementModel newButtonBaseElementModel(Node node) {
		return new ButtonBaseElementModel(db, node);
	}

	public Stream<ButtonBaseElementModel> findAllButtonBaseElementModel() {
		return db.findAllSTModelByStTemplate(ButtonBaseElementModel.stTemplateUuid)
				.map(stModel -> new ButtonBaseElementModel(db, stModel));
	}

	public ButtonBaseElementModel findButtonBaseElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ButtonBaseElementModel(db, uuid) : new ButtonBaseElementModel(db, stModel);
	}


	public ButtonGroupModel newButtonGroupModel() {
		return new ButtonGroupModel(db);
	}

	public ButtonGroupModel newButtonGroupModel(STModel stModel) {
		return new ButtonGroupModel(db, stModel);
	}

	public ButtonGroupModel newButtonGroupModel(Node node) {
		return new ButtonGroupModel(db, node);
	}

	public Stream<ButtonGroupModel> findAllButtonGroupModel() {
		return db.findAllSTModelByStTemplate(ButtonGroupModel.stTemplateUuid)
				.map(stModel -> new ButtonGroupModel(db, stModel));
	}

	public ButtonGroupModel findButtonGroupModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ButtonGroupModel(db, uuid) : new ButtonGroupModel(db, stModel);
	}


	public ButtonGroupImportModel newButtonGroupImportModel() {
		return new ButtonGroupImportModel(db);
	}

	public ButtonGroupImportModel newButtonGroupImportModel(STModel stModel) {
		return new ButtonGroupImportModel(db, stModel);
	}

	public ButtonGroupImportModel newButtonGroupImportModel(Node node) {
		return new ButtonGroupImportModel(db, node);
	}

	public Stream<ButtonGroupImportModel> findAllButtonGroupImportModel() {
		return db.findAllSTModelByStTemplate(ButtonGroupImportModel.stTemplateUuid)
				.map(stModel -> new ButtonGroupImportModel(db, stModel));
	}

	public ButtonGroupImportModel findButtonGroupImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ButtonGroupImportModel(db, uuid) : new ButtonGroupImportModel(db, stModel);
	}


	public ButtonGroupElementModel newButtonGroupElementModel() {
		return new ButtonGroupElementModel(db);
	}

	public ButtonGroupElementModel newButtonGroupElementModel(STModel stModel) {
		return new ButtonGroupElementModel(db, stModel);
	}

	public ButtonGroupElementModel newButtonGroupElementModel(Node node) {
		return new ButtonGroupElementModel(db, node);
	}

	public Stream<ButtonGroupElementModel> findAllButtonGroupElementModel() {
		return db.findAllSTModelByStTemplate(ButtonGroupElementModel.stTemplateUuid)
				.map(stModel -> new ButtonGroupElementModel(db, stModel));
	}

	public ButtonGroupElementModel findButtonGroupElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ButtonGroupElementModel(db, uuid) : new ButtonGroupElementModel(db, stModel);
	}


	public CardModel newCardModel() {
		return new CardModel(db);
	}

	public CardModel newCardModel(STModel stModel) {
		return new CardModel(db, stModel);
	}

	public CardModel newCardModel(Node node) {
		return new CardModel(db, node);
	}

	public Stream<CardModel> findAllCardModel() {
		return db.findAllSTModelByStTemplate(CardModel.stTemplateUuid)
				.map(stModel -> new CardModel(db, stModel));
	}

	public CardModel findCardModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardModel(db, uuid) : new CardModel(db, stModel);
	}


	public CardImportModel newCardImportModel() {
		return new CardImportModel(db);
	}

	public CardImportModel newCardImportModel(STModel stModel) {
		return new CardImportModel(db, stModel);
	}

	public CardImportModel newCardImportModel(Node node) {
		return new CardImportModel(db, node);
	}

	public Stream<CardImportModel> findAllCardImportModel() {
		return db.findAllSTModelByStTemplate(CardImportModel.stTemplateUuid)
				.map(stModel -> new CardImportModel(db, stModel));
	}

	public CardImportModel findCardImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardImportModel(db, uuid) : new CardImportModel(db, stModel);
	}


	public CardElementModel newCardElementModel() {
		return new CardElementModel(db);
	}

	public CardElementModel newCardElementModel(STModel stModel) {
		return new CardElementModel(db, stModel);
	}

	public CardElementModel newCardElementModel(Node node) {
		return new CardElementModel(db, node);
	}

	public Stream<CardElementModel> findAllCardElementModel() {
		return db.findAllSTModelByStTemplate(CardElementModel.stTemplateUuid)
				.map(stModel -> new CardElementModel(db, stModel));
	}

	public CardElementModel findCardElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardElementModel(db, uuid) : new CardElementModel(db, stModel);
	}


	public CardActionAreaModel newCardActionAreaModel() {
		return new CardActionAreaModel(db);
	}

	public CardActionAreaModel newCardActionAreaModel(STModel stModel) {
		return new CardActionAreaModel(db, stModel);
	}

	public CardActionAreaModel newCardActionAreaModel(Node node) {
		return new CardActionAreaModel(db, node);
	}

	public Stream<CardActionAreaModel> findAllCardActionAreaModel() {
		return db.findAllSTModelByStTemplate(CardActionAreaModel.stTemplateUuid)
				.map(stModel -> new CardActionAreaModel(db, stModel));
	}

	public CardActionAreaModel findCardActionAreaModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardActionAreaModel(db, uuid) : new CardActionAreaModel(db, stModel);
	}


	public CardActionAreaImportModel newCardActionAreaImportModel() {
		return new CardActionAreaImportModel(db);
	}

	public CardActionAreaImportModel newCardActionAreaImportModel(STModel stModel) {
		return new CardActionAreaImportModel(db, stModel);
	}

	public CardActionAreaImportModel newCardActionAreaImportModel(Node node) {
		return new CardActionAreaImportModel(db, node);
	}

	public Stream<CardActionAreaImportModel> findAllCardActionAreaImportModel() {
		return db.findAllSTModelByStTemplate(CardActionAreaImportModel.stTemplateUuid)
				.map(stModel -> new CardActionAreaImportModel(db, stModel));
	}

	public CardActionAreaImportModel findCardActionAreaImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardActionAreaImportModel(db, uuid) : new CardActionAreaImportModel(db, stModel);
	}


	public CardActionAreaElementModel newCardActionAreaElementModel() {
		return new CardActionAreaElementModel(db);
	}

	public CardActionAreaElementModel newCardActionAreaElementModel(STModel stModel) {
		return new CardActionAreaElementModel(db, stModel);
	}

	public CardActionAreaElementModel newCardActionAreaElementModel(Node node) {
		return new CardActionAreaElementModel(db, node);
	}

	public Stream<CardActionAreaElementModel> findAllCardActionAreaElementModel() {
		return db.findAllSTModelByStTemplate(CardActionAreaElementModel.stTemplateUuid)
				.map(stModel -> new CardActionAreaElementModel(db, stModel));
	}

	public CardActionAreaElementModel findCardActionAreaElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardActionAreaElementModel(db, uuid) : new CardActionAreaElementModel(db, stModel);
	}


	public CardActionsModel newCardActionsModel() {
		return new CardActionsModel(db);
	}

	public CardActionsModel newCardActionsModel(STModel stModel) {
		return new CardActionsModel(db, stModel);
	}

	public CardActionsModel newCardActionsModel(Node node) {
		return new CardActionsModel(db, node);
	}

	public Stream<CardActionsModel> findAllCardActionsModel() {
		return db.findAllSTModelByStTemplate(CardActionsModel.stTemplateUuid)
				.map(stModel -> new CardActionsModel(db, stModel));
	}

	public CardActionsModel findCardActionsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardActionsModel(db, uuid) : new CardActionsModel(db, stModel);
	}


	public CardActionsImportModel newCardActionsImportModel() {
		return new CardActionsImportModel(db);
	}

	public CardActionsImportModel newCardActionsImportModel(STModel stModel) {
		return new CardActionsImportModel(db, stModel);
	}

	public CardActionsImportModel newCardActionsImportModel(Node node) {
		return new CardActionsImportModel(db, node);
	}

	public Stream<CardActionsImportModel> findAllCardActionsImportModel() {
		return db.findAllSTModelByStTemplate(CardActionsImportModel.stTemplateUuid)
				.map(stModel -> new CardActionsImportModel(db, stModel));
	}

	public CardActionsImportModel findCardActionsImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardActionsImportModel(db, uuid) : new CardActionsImportModel(db, stModel);
	}


	public CardActionsElementModel newCardActionsElementModel() {
		return new CardActionsElementModel(db);
	}

	public CardActionsElementModel newCardActionsElementModel(STModel stModel) {
		return new CardActionsElementModel(db, stModel);
	}

	public CardActionsElementModel newCardActionsElementModel(Node node) {
		return new CardActionsElementModel(db, node);
	}

	public Stream<CardActionsElementModel> findAllCardActionsElementModel() {
		return db.findAllSTModelByStTemplate(CardActionsElementModel.stTemplateUuid)
				.map(stModel -> new CardActionsElementModel(db, stModel));
	}

	public CardActionsElementModel findCardActionsElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardActionsElementModel(db, uuid) : new CardActionsElementModel(db, stModel);
	}


	public CardContentModel newCardContentModel() {
		return new CardContentModel(db);
	}

	public CardContentModel newCardContentModel(STModel stModel) {
		return new CardContentModel(db, stModel);
	}

	public CardContentModel newCardContentModel(Node node) {
		return new CardContentModel(db, node);
	}

	public Stream<CardContentModel> findAllCardContentModel() {
		return db.findAllSTModelByStTemplate(CardContentModel.stTemplateUuid)
				.map(stModel -> new CardContentModel(db, stModel));
	}

	public CardContentModel findCardContentModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardContentModel(db, uuid) : new CardContentModel(db, stModel);
	}


	public CardContentImportModel newCardContentImportModel() {
		return new CardContentImportModel(db);
	}

	public CardContentImportModel newCardContentImportModel(STModel stModel) {
		return new CardContentImportModel(db, stModel);
	}

	public CardContentImportModel newCardContentImportModel(Node node) {
		return new CardContentImportModel(db, node);
	}

	public Stream<CardContentImportModel> findAllCardContentImportModel() {
		return db.findAllSTModelByStTemplate(CardContentImportModel.stTemplateUuid)
				.map(stModel -> new CardContentImportModel(db, stModel));
	}

	public CardContentImportModel findCardContentImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardContentImportModel(db, uuid) : new CardContentImportModel(db, stModel);
	}


	public CardContentElementModel newCardContentElementModel() {
		return new CardContentElementModel(db);
	}

	public CardContentElementModel newCardContentElementModel(STModel stModel) {
		return new CardContentElementModel(db, stModel);
	}

	public CardContentElementModel newCardContentElementModel(Node node) {
		return new CardContentElementModel(db, node);
	}

	public Stream<CardContentElementModel> findAllCardContentElementModel() {
		return db.findAllSTModelByStTemplate(CardContentElementModel.stTemplateUuid)
				.map(stModel -> new CardContentElementModel(db, stModel));
	}

	public CardContentElementModel findCardContentElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardContentElementModel(db, uuid) : new CardContentElementModel(db, stModel);
	}


	public CardHeaderModel newCardHeaderModel() {
		return new CardHeaderModel(db);
	}

	public CardHeaderModel newCardHeaderModel(STModel stModel) {
		return new CardHeaderModel(db, stModel);
	}

	public CardHeaderModel newCardHeaderModel(Node node) {
		return new CardHeaderModel(db, node);
	}

	public Stream<CardHeaderModel> findAllCardHeaderModel() {
		return db.findAllSTModelByStTemplate(CardHeaderModel.stTemplateUuid)
				.map(stModel -> new CardHeaderModel(db, stModel));
	}

	public CardHeaderModel findCardHeaderModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardHeaderModel(db, uuid) : new CardHeaderModel(db, stModel);
	}


	public CardHeaderImportModel newCardHeaderImportModel() {
		return new CardHeaderImportModel(db);
	}

	public CardHeaderImportModel newCardHeaderImportModel(STModel stModel) {
		return new CardHeaderImportModel(db, stModel);
	}

	public CardHeaderImportModel newCardHeaderImportModel(Node node) {
		return new CardHeaderImportModel(db, node);
	}

	public Stream<CardHeaderImportModel> findAllCardHeaderImportModel() {
		return db.findAllSTModelByStTemplate(CardHeaderImportModel.stTemplateUuid)
				.map(stModel -> new CardHeaderImportModel(db, stModel));
	}

	public CardHeaderImportModel findCardHeaderImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardHeaderImportModel(db, uuid) : new CardHeaderImportModel(db, stModel);
	}


	public CardHeaderElementModel newCardHeaderElementModel() {
		return new CardHeaderElementModel(db);
	}

	public CardHeaderElementModel newCardHeaderElementModel(STModel stModel) {
		return new CardHeaderElementModel(db, stModel);
	}

	public CardHeaderElementModel newCardHeaderElementModel(Node node) {
		return new CardHeaderElementModel(db, node);
	}

	public Stream<CardHeaderElementModel> findAllCardHeaderElementModel() {
		return db.findAllSTModelByStTemplate(CardHeaderElementModel.stTemplateUuid)
				.map(stModel -> new CardHeaderElementModel(db, stModel));
	}

	public CardHeaderElementModel findCardHeaderElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardHeaderElementModel(db, uuid) : new CardHeaderElementModel(db, stModel);
	}


	public CardMediaModel newCardMediaModel() {
		return new CardMediaModel(db);
	}

	public CardMediaModel newCardMediaModel(STModel stModel) {
		return new CardMediaModel(db, stModel);
	}

	public CardMediaModel newCardMediaModel(Node node) {
		return new CardMediaModel(db, node);
	}

	public Stream<CardMediaModel> findAllCardMediaModel() {
		return db.findAllSTModelByStTemplate(CardMediaModel.stTemplateUuid)
				.map(stModel -> new CardMediaModel(db, stModel));
	}

	public CardMediaModel findCardMediaModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardMediaModel(db, uuid) : new CardMediaModel(db, stModel);
	}


	public CardMediaImportModel newCardMediaImportModel() {
		return new CardMediaImportModel(db);
	}

	public CardMediaImportModel newCardMediaImportModel(STModel stModel) {
		return new CardMediaImportModel(db, stModel);
	}

	public CardMediaImportModel newCardMediaImportModel(Node node) {
		return new CardMediaImportModel(db, node);
	}

	public Stream<CardMediaImportModel> findAllCardMediaImportModel() {
		return db.findAllSTModelByStTemplate(CardMediaImportModel.stTemplateUuid)
				.map(stModel -> new CardMediaImportModel(db, stModel));
	}

	public CardMediaImportModel findCardMediaImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardMediaImportModel(db, uuid) : new CardMediaImportModel(db, stModel);
	}


	public CardMediaElementModel newCardMediaElementModel() {
		return new CardMediaElementModel(db);
	}

	public CardMediaElementModel newCardMediaElementModel(STModel stModel) {
		return new CardMediaElementModel(db, stModel);
	}

	public CardMediaElementModel newCardMediaElementModel(Node node) {
		return new CardMediaElementModel(db, node);
	}

	public Stream<CardMediaElementModel> findAllCardMediaElementModel() {
		return db.findAllSTModelByStTemplate(CardMediaElementModel.stTemplateUuid)
				.map(stModel -> new CardMediaElementModel(db, stModel));
	}

	public CardMediaElementModel findCardMediaElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CardMediaElementModel(db, uuid) : new CardMediaElementModel(db, stModel);
	}


	public CheckboxModel newCheckboxModel() {
		return new CheckboxModel(db);
	}

	public CheckboxModel newCheckboxModel(STModel stModel) {
		return new CheckboxModel(db, stModel);
	}

	public CheckboxModel newCheckboxModel(Node node) {
		return new CheckboxModel(db, node);
	}

	public Stream<CheckboxModel> findAllCheckboxModel() {
		return db.findAllSTModelByStTemplate(CheckboxModel.stTemplateUuid)
				.map(stModel -> new CheckboxModel(db, stModel));
	}

	public CheckboxModel findCheckboxModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CheckboxModel(db, uuid) : new CheckboxModel(db, stModel);
	}


	public CheckboxImportModel newCheckboxImportModel() {
		return new CheckboxImportModel(db);
	}

	public CheckboxImportModel newCheckboxImportModel(STModel stModel) {
		return new CheckboxImportModel(db, stModel);
	}

	public CheckboxImportModel newCheckboxImportModel(Node node) {
		return new CheckboxImportModel(db, node);
	}

	public Stream<CheckboxImportModel> findAllCheckboxImportModel() {
		return db.findAllSTModelByStTemplate(CheckboxImportModel.stTemplateUuid)
				.map(stModel -> new CheckboxImportModel(db, stModel));
	}

	public CheckboxImportModel findCheckboxImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CheckboxImportModel(db, uuid) : new CheckboxImportModel(db, stModel);
	}


	public CheckboxElementModel newCheckboxElementModel() {
		return new CheckboxElementModel(db);
	}

	public CheckboxElementModel newCheckboxElementModel(STModel stModel) {
		return new CheckboxElementModel(db, stModel);
	}

	public CheckboxElementModel newCheckboxElementModel(Node node) {
		return new CheckboxElementModel(db, node);
	}

	public Stream<CheckboxElementModel> findAllCheckboxElementModel() {
		return db.findAllSTModelByStTemplate(CheckboxElementModel.stTemplateUuid)
				.map(stModel -> new CheckboxElementModel(db, stModel));
	}

	public CheckboxElementModel findCheckboxElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CheckboxElementModel(db, uuid) : new CheckboxElementModel(db, stModel);
	}


	public ChipModel newChipModel() {
		return new ChipModel(db);
	}

	public ChipModel newChipModel(STModel stModel) {
		return new ChipModel(db, stModel);
	}

	public ChipModel newChipModel(Node node) {
		return new ChipModel(db, node);
	}

	public Stream<ChipModel> findAllChipModel() {
		return db.findAllSTModelByStTemplate(ChipModel.stTemplateUuid)
				.map(stModel -> new ChipModel(db, stModel));
	}

	public ChipModel findChipModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ChipModel(db, uuid) : new ChipModel(db, stModel);
	}


	public ChipImportModel newChipImportModel() {
		return new ChipImportModel(db);
	}

	public ChipImportModel newChipImportModel(STModel stModel) {
		return new ChipImportModel(db, stModel);
	}

	public ChipImportModel newChipImportModel(Node node) {
		return new ChipImportModel(db, node);
	}

	public Stream<ChipImportModel> findAllChipImportModel() {
		return db.findAllSTModelByStTemplate(ChipImportModel.stTemplateUuid)
				.map(stModel -> new ChipImportModel(db, stModel));
	}

	public ChipImportModel findChipImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ChipImportModel(db, uuid) : new ChipImportModel(db, stModel);
	}


	public ChipElementModel newChipElementModel() {
		return new ChipElementModel(db);
	}

	public ChipElementModel newChipElementModel(STModel stModel) {
		return new ChipElementModel(db, stModel);
	}

	public ChipElementModel newChipElementModel(Node node) {
		return new ChipElementModel(db, node);
	}

	public Stream<ChipElementModel> findAllChipElementModel() {
		return db.findAllSTModelByStTemplate(ChipElementModel.stTemplateUuid)
				.map(stModel -> new ChipElementModel(db, stModel));
	}

	public ChipElementModel findChipElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ChipElementModel(db, uuid) : new ChipElementModel(db, stModel);
	}


	public CircularProgressModel newCircularProgressModel() {
		return new CircularProgressModel(db);
	}

	public CircularProgressModel newCircularProgressModel(STModel stModel) {
		return new CircularProgressModel(db, stModel);
	}

	public CircularProgressModel newCircularProgressModel(Node node) {
		return new CircularProgressModel(db, node);
	}

	public Stream<CircularProgressModel> findAllCircularProgressModel() {
		return db.findAllSTModelByStTemplate(CircularProgressModel.stTemplateUuid)
				.map(stModel -> new CircularProgressModel(db, stModel));
	}

	public CircularProgressModel findCircularProgressModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CircularProgressModel(db, uuid) : new CircularProgressModel(db, stModel);
	}


	public CircularProgressImportModel newCircularProgressImportModel() {
		return new CircularProgressImportModel(db);
	}

	public CircularProgressImportModel newCircularProgressImportModel(STModel stModel) {
		return new CircularProgressImportModel(db, stModel);
	}

	public CircularProgressImportModel newCircularProgressImportModel(Node node) {
		return new CircularProgressImportModel(db, node);
	}

	public Stream<CircularProgressImportModel> findAllCircularProgressImportModel() {
		return db.findAllSTModelByStTemplate(CircularProgressImportModel.stTemplateUuid)
				.map(stModel -> new CircularProgressImportModel(db, stModel));
	}

	public CircularProgressImportModel findCircularProgressImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CircularProgressImportModel(db, uuid) : new CircularProgressImportModel(db, stModel);
	}


	public CircularProgressElementModel newCircularProgressElementModel() {
		return new CircularProgressElementModel(db);
	}

	public CircularProgressElementModel newCircularProgressElementModel(STModel stModel) {
		return new CircularProgressElementModel(db, stModel);
	}

	public CircularProgressElementModel newCircularProgressElementModel(Node node) {
		return new CircularProgressElementModel(db, node);
	}

	public Stream<CircularProgressElementModel> findAllCircularProgressElementModel() {
		return db.findAllSTModelByStTemplate(CircularProgressElementModel.stTemplateUuid)
				.map(stModel -> new CircularProgressElementModel(db, stModel));
	}

	public CircularProgressElementModel findCircularProgressElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CircularProgressElementModel(db, uuid) : new CircularProgressElementModel(db, stModel);
	}


	public ClickAwayListenerModel newClickAwayListenerModel() {
		return new ClickAwayListenerModel(db);
	}

	public ClickAwayListenerModel newClickAwayListenerModel(STModel stModel) {
		return new ClickAwayListenerModel(db, stModel);
	}

	public ClickAwayListenerModel newClickAwayListenerModel(Node node) {
		return new ClickAwayListenerModel(db, node);
	}

	public Stream<ClickAwayListenerModel> findAllClickAwayListenerModel() {
		return db.findAllSTModelByStTemplate(ClickAwayListenerModel.stTemplateUuid)
				.map(stModel -> new ClickAwayListenerModel(db, stModel));
	}

	public ClickAwayListenerModel findClickAwayListenerModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ClickAwayListenerModel(db, uuid) : new ClickAwayListenerModel(db, stModel);
	}


	public ClickAwayListenerImportModel newClickAwayListenerImportModel() {
		return new ClickAwayListenerImportModel(db);
	}

	public ClickAwayListenerImportModel newClickAwayListenerImportModel(STModel stModel) {
		return new ClickAwayListenerImportModel(db, stModel);
	}

	public ClickAwayListenerImportModel newClickAwayListenerImportModel(Node node) {
		return new ClickAwayListenerImportModel(db, node);
	}

	public Stream<ClickAwayListenerImportModel> findAllClickAwayListenerImportModel() {
		return db.findAllSTModelByStTemplate(ClickAwayListenerImportModel.stTemplateUuid)
				.map(stModel -> new ClickAwayListenerImportModel(db, stModel));
	}

	public ClickAwayListenerImportModel findClickAwayListenerImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ClickAwayListenerImportModel(db, uuid) : new ClickAwayListenerImportModel(db, stModel);
	}


	public ClickAwayListenerElementModel newClickAwayListenerElementModel() {
		return new ClickAwayListenerElementModel(db);
	}

	public ClickAwayListenerElementModel newClickAwayListenerElementModel(STModel stModel) {
		return new ClickAwayListenerElementModel(db, stModel);
	}

	public ClickAwayListenerElementModel newClickAwayListenerElementModel(Node node) {
		return new ClickAwayListenerElementModel(db, node);
	}

	public Stream<ClickAwayListenerElementModel> findAllClickAwayListenerElementModel() {
		return db.findAllSTModelByStTemplate(ClickAwayListenerElementModel.stTemplateUuid)
				.map(stModel -> new ClickAwayListenerElementModel(db, stModel));
	}

	public ClickAwayListenerElementModel findClickAwayListenerElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ClickAwayListenerElementModel(db, uuid) : new ClickAwayListenerElementModel(db, stModel);
	}


	public CollapseModel newCollapseModel() {
		return new CollapseModel(db);
	}

	public CollapseModel newCollapseModel(STModel stModel) {
		return new CollapseModel(db, stModel);
	}

	public CollapseModel newCollapseModel(Node node) {
		return new CollapseModel(db, node);
	}

	public Stream<CollapseModel> findAllCollapseModel() {
		return db.findAllSTModelByStTemplate(CollapseModel.stTemplateUuid)
				.map(stModel -> new CollapseModel(db, stModel));
	}

	public CollapseModel findCollapseModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CollapseModel(db, uuid) : new CollapseModel(db, stModel);
	}


	public CollapseImportModel newCollapseImportModel() {
		return new CollapseImportModel(db);
	}

	public CollapseImportModel newCollapseImportModel(STModel stModel) {
		return new CollapseImportModel(db, stModel);
	}

	public CollapseImportModel newCollapseImportModel(Node node) {
		return new CollapseImportModel(db, node);
	}

	public Stream<CollapseImportModel> findAllCollapseImportModel() {
		return db.findAllSTModelByStTemplate(CollapseImportModel.stTemplateUuid)
				.map(stModel -> new CollapseImportModel(db, stModel));
	}

	public CollapseImportModel findCollapseImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CollapseImportModel(db, uuid) : new CollapseImportModel(db, stModel);
	}


	public CollapseElementModel newCollapseElementModel() {
		return new CollapseElementModel(db);
	}

	public CollapseElementModel newCollapseElementModel(STModel stModel) {
		return new CollapseElementModel(db, stModel);
	}

	public CollapseElementModel newCollapseElementModel(Node node) {
		return new CollapseElementModel(db, node);
	}

	public Stream<CollapseElementModel> findAllCollapseElementModel() {
		return db.findAllSTModelByStTemplate(CollapseElementModel.stTemplateUuid)
				.map(stModel -> new CollapseElementModel(db, stModel));
	}

	public CollapseElementModel findCollapseElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CollapseElementModel(db, uuid) : new CollapseElementModel(db, stModel);
	}


	public ContainerModel newContainerModel() {
		return new ContainerModel(db);
	}

	public ContainerModel newContainerModel(STModel stModel) {
		return new ContainerModel(db, stModel);
	}

	public ContainerModel newContainerModel(Node node) {
		return new ContainerModel(db, node);
	}

	public Stream<ContainerModel> findAllContainerModel() {
		return db.findAllSTModelByStTemplate(ContainerModel.stTemplateUuid)
				.map(stModel -> new ContainerModel(db, stModel));
	}

	public ContainerModel findContainerModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ContainerModel(db, uuid) : new ContainerModel(db, stModel);
	}


	public ContainerImportModel newContainerImportModel() {
		return new ContainerImportModel(db);
	}

	public ContainerImportModel newContainerImportModel(STModel stModel) {
		return new ContainerImportModel(db, stModel);
	}

	public ContainerImportModel newContainerImportModel(Node node) {
		return new ContainerImportModel(db, node);
	}

	public Stream<ContainerImportModel> findAllContainerImportModel() {
		return db.findAllSTModelByStTemplate(ContainerImportModel.stTemplateUuid)
				.map(stModel -> new ContainerImportModel(db, stModel));
	}

	public ContainerImportModel findContainerImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ContainerImportModel(db, uuid) : new ContainerImportModel(db, stModel);
	}


	public ContainerElementModel newContainerElementModel() {
		return new ContainerElementModel(db);
	}

	public ContainerElementModel newContainerElementModel(STModel stModel) {
		return new ContainerElementModel(db, stModel);
	}

	public ContainerElementModel newContainerElementModel(Node node) {
		return new ContainerElementModel(db, node);
	}

	public Stream<ContainerElementModel> findAllContainerElementModel() {
		return db.findAllSTModelByStTemplate(ContainerElementModel.stTemplateUuid)
				.map(stModel -> new ContainerElementModel(db, stModel));
	}

	public ContainerElementModel findContainerElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ContainerElementModel(db, uuid) : new ContainerElementModel(db, stModel);
	}


	public CssBaselineModel newCssBaselineModel() {
		return new CssBaselineModel(db);
	}

	public CssBaselineModel newCssBaselineModel(STModel stModel) {
		return new CssBaselineModel(db, stModel);
	}

	public CssBaselineModel newCssBaselineModel(Node node) {
		return new CssBaselineModel(db, node);
	}

	public Stream<CssBaselineModel> findAllCssBaselineModel() {
		return db.findAllSTModelByStTemplate(CssBaselineModel.stTemplateUuid)
				.map(stModel -> new CssBaselineModel(db, stModel));
	}

	public CssBaselineModel findCssBaselineModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CssBaselineModel(db, uuid) : new CssBaselineModel(db, stModel);
	}


	public CssBaselineImportModel newCssBaselineImportModel() {
		return new CssBaselineImportModel(db);
	}

	public CssBaselineImportModel newCssBaselineImportModel(STModel stModel) {
		return new CssBaselineImportModel(db, stModel);
	}

	public CssBaselineImportModel newCssBaselineImportModel(Node node) {
		return new CssBaselineImportModel(db, node);
	}

	public Stream<CssBaselineImportModel> findAllCssBaselineImportModel() {
		return db.findAllSTModelByStTemplate(CssBaselineImportModel.stTemplateUuid)
				.map(stModel -> new CssBaselineImportModel(db, stModel));
	}

	public CssBaselineImportModel findCssBaselineImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CssBaselineImportModel(db, uuid) : new CssBaselineImportModel(db, stModel);
	}


	public CssBaselineElementModel newCssBaselineElementModel() {
		return new CssBaselineElementModel(db);
	}

	public CssBaselineElementModel newCssBaselineElementModel(STModel stModel) {
		return new CssBaselineElementModel(db, stModel);
	}

	public CssBaselineElementModel newCssBaselineElementModel(Node node) {
		return new CssBaselineElementModel(db, node);
	}

	public Stream<CssBaselineElementModel> findAllCssBaselineElementModel() {
		return db.findAllSTModelByStTemplate(CssBaselineElementModel.stTemplateUuid)
				.map(stModel -> new CssBaselineElementModel(db, stModel));
	}

	public CssBaselineElementModel findCssBaselineElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new CssBaselineElementModel(db, uuid) : new CssBaselineElementModel(db, stModel);
	}


	public DialogModel newDialogModel() {
		return new DialogModel(db);
	}

	public DialogModel newDialogModel(STModel stModel) {
		return new DialogModel(db, stModel);
	}

	public DialogModel newDialogModel(Node node) {
		return new DialogModel(db, node);
	}

	public Stream<DialogModel> findAllDialogModel() {
		return db.findAllSTModelByStTemplate(DialogModel.stTemplateUuid)
				.map(stModel -> new DialogModel(db, stModel));
	}

	public DialogModel findDialogModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogModel(db, uuid) : new DialogModel(db, stModel);
	}


	public DialogImportModel newDialogImportModel() {
		return new DialogImportModel(db);
	}

	public DialogImportModel newDialogImportModel(STModel stModel) {
		return new DialogImportModel(db, stModel);
	}

	public DialogImportModel newDialogImportModel(Node node) {
		return new DialogImportModel(db, node);
	}

	public Stream<DialogImportModel> findAllDialogImportModel() {
		return db.findAllSTModelByStTemplate(DialogImportModel.stTemplateUuid)
				.map(stModel -> new DialogImportModel(db, stModel));
	}

	public DialogImportModel findDialogImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogImportModel(db, uuid) : new DialogImportModel(db, stModel);
	}


	public DialogElementModel newDialogElementModel() {
		return new DialogElementModel(db);
	}

	public DialogElementModel newDialogElementModel(STModel stModel) {
		return new DialogElementModel(db, stModel);
	}

	public DialogElementModel newDialogElementModel(Node node) {
		return new DialogElementModel(db, node);
	}

	public Stream<DialogElementModel> findAllDialogElementModel() {
		return db.findAllSTModelByStTemplate(DialogElementModel.stTemplateUuid)
				.map(stModel -> new DialogElementModel(db, stModel));
	}

	public DialogElementModel findDialogElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogElementModel(db, uuid) : new DialogElementModel(db, stModel);
	}


	public DialogActionsModel newDialogActionsModel() {
		return new DialogActionsModel(db);
	}

	public DialogActionsModel newDialogActionsModel(STModel stModel) {
		return new DialogActionsModel(db, stModel);
	}

	public DialogActionsModel newDialogActionsModel(Node node) {
		return new DialogActionsModel(db, node);
	}

	public Stream<DialogActionsModel> findAllDialogActionsModel() {
		return db.findAllSTModelByStTemplate(DialogActionsModel.stTemplateUuid)
				.map(stModel -> new DialogActionsModel(db, stModel));
	}

	public DialogActionsModel findDialogActionsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogActionsModel(db, uuid) : new DialogActionsModel(db, stModel);
	}


	public DialogActionsImportModel newDialogActionsImportModel() {
		return new DialogActionsImportModel(db);
	}

	public DialogActionsImportModel newDialogActionsImportModel(STModel stModel) {
		return new DialogActionsImportModel(db, stModel);
	}

	public DialogActionsImportModel newDialogActionsImportModel(Node node) {
		return new DialogActionsImportModel(db, node);
	}

	public Stream<DialogActionsImportModel> findAllDialogActionsImportModel() {
		return db.findAllSTModelByStTemplate(DialogActionsImportModel.stTemplateUuid)
				.map(stModel -> new DialogActionsImportModel(db, stModel));
	}

	public DialogActionsImportModel findDialogActionsImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogActionsImportModel(db, uuid) : new DialogActionsImportModel(db, stModel);
	}


	public DialogActionsElementModel newDialogActionsElementModel() {
		return new DialogActionsElementModel(db);
	}

	public DialogActionsElementModel newDialogActionsElementModel(STModel stModel) {
		return new DialogActionsElementModel(db, stModel);
	}

	public DialogActionsElementModel newDialogActionsElementModel(Node node) {
		return new DialogActionsElementModel(db, node);
	}

	public Stream<DialogActionsElementModel> findAllDialogActionsElementModel() {
		return db.findAllSTModelByStTemplate(DialogActionsElementModel.stTemplateUuid)
				.map(stModel -> new DialogActionsElementModel(db, stModel));
	}

	public DialogActionsElementModel findDialogActionsElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogActionsElementModel(db, uuid) : new DialogActionsElementModel(db, stModel);
	}


	public DialogContentModel newDialogContentModel() {
		return new DialogContentModel(db);
	}

	public DialogContentModel newDialogContentModel(STModel stModel) {
		return new DialogContentModel(db, stModel);
	}

	public DialogContentModel newDialogContentModel(Node node) {
		return new DialogContentModel(db, node);
	}

	public Stream<DialogContentModel> findAllDialogContentModel() {
		return db.findAllSTModelByStTemplate(DialogContentModel.stTemplateUuid)
				.map(stModel -> new DialogContentModel(db, stModel));
	}

	public DialogContentModel findDialogContentModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogContentModel(db, uuid) : new DialogContentModel(db, stModel);
	}


	public DialogContentImportModel newDialogContentImportModel() {
		return new DialogContentImportModel(db);
	}

	public DialogContentImportModel newDialogContentImportModel(STModel stModel) {
		return new DialogContentImportModel(db, stModel);
	}

	public DialogContentImportModel newDialogContentImportModel(Node node) {
		return new DialogContentImportModel(db, node);
	}

	public Stream<DialogContentImportModel> findAllDialogContentImportModel() {
		return db.findAllSTModelByStTemplate(DialogContentImportModel.stTemplateUuid)
				.map(stModel -> new DialogContentImportModel(db, stModel));
	}

	public DialogContentImportModel findDialogContentImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogContentImportModel(db, uuid) : new DialogContentImportModel(db, stModel);
	}


	public DialogContentElementModel newDialogContentElementModel() {
		return new DialogContentElementModel(db);
	}

	public DialogContentElementModel newDialogContentElementModel(STModel stModel) {
		return new DialogContentElementModel(db, stModel);
	}

	public DialogContentElementModel newDialogContentElementModel(Node node) {
		return new DialogContentElementModel(db, node);
	}

	public Stream<DialogContentElementModel> findAllDialogContentElementModel() {
		return db.findAllSTModelByStTemplate(DialogContentElementModel.stTemplateUuid)
				.map(stModel -> new DialogContentElementModel(db, stModel));
	}

	public DialogContentElementModel findDialogContentElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogContentElementModel(db, uuid) : new DialogContentElementModel(db, stModel);
	}


	public DialogContentTextModel newDialogContentTextModel() {
		return new DialogContentTextModel(db);
	}

	public DialogContentTextModel newDialogContentTextModel(STModel stModel) {
		return new DialogContentTextModel(db, stModel);
	}

	public DialogContentTextModel newDialogContentTextModel(Node node) {
		return new DialogContentTextModel(db, node);
	}

	public Stream<DialogContentTextModel> findAllDialogContentTextModel() {
		return db.findAllSTModelByStTemplate(DialogContentTextModel.stTemplateUuid)
				.map(stModel -> new DialogContentTextModel(db, stModel));
	}

	public DialogContentTextModel findDialogContentTextModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogContentTextModel(db, uuid) : new DialogContentTextModel(db, stModel);
	}


	public DialogContentTextImportModel newDialogContentTextImportModel() {
		return new DialogContentTextImportModel(db);
	}

	public DialogContentTextImportModel newDialogContentTextImportModel(STModel stModel) {
		return new DialogContentTextImportModel(db, stModel);
	}

	public DialogContentTextImportModel newDialogContentTextImportModel(Node node) {
		return new DialogContentTextImportModel(db, node);
	}

	public Stream<DialogContentTextImportModel> findAllDialogContentTextImportModel() {
		return db.findAllSTModelByStTemplate(DialogContentTextImportModel.stTemplateUuid)
				.map(stModel -> new DialogContentTextImportModel(db, stModel));
	}

	public DialogContentTextImportModel findDialogContentTextImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogContentTextImportModel(db, uuid) : new DialogContentTextImportModel(db, stModel);
	}


	public DialogContentTextElementModel newDialogContentTextElementModel() {
		return new DialogContentTextElementModel(db);
	}

	public DialogContentTextElementModel newDialogContentTextElementModel(STModel stModel) {
		return new DialogContentTextElementModel(db, stModel);
	}

	public DialogContentTextElementModel newDialogContentTextElementModel(Node node) {
		return new DialogContentTextElementModel(db, node);
	}

	public Stream<DialogContentTextElementModel> findAllDialogContentTextElementModel() {
		return db.findAllSTModelByStTemplate(DialogContentTextElementModel.stTemplateUuid)
				.map(stModel -> new DialogContentTextElementModel(db, stModel));
	}

	public DialogContentTextElementModel findDialogContentTextElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogContentTextElementModel(db, uuid) : new DialogContentTextElementModel(db, stModel);
	}


	public DialogTitleModel newDialogTitleModel() {
		return new DialogTitleModel(db);
	}

	public DialogTitleModel newDialogTitleModel(STModel stModel) {
		return new DialogTitleModel(db, stModel);
	}

	public DialogTitleModel newDialogTitleModel(Node node) {
		return new DialogTitleModel(db, node);
	}

	public Stream<DialogTitleModel> findAllDialogTitleModel() {
		return db.findAllSTModelByStTemplate(DialogTitleModel.stTemplateUuid)
				.map(stModel -> new DialogTitleModel(db, stModel));
	}

	public DialogTitleModel findDialogTitleModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogTitleModel(db, uuid) : new DialogTitleModel(db, stModel);
	}


	public DialogTitleImportModel newDialogTitleImportModel() {
		return new DialogTitleImportModel(db);
	}

	public DialogTitleImportModel newDialogTitleImportModel(STModel stModel) {
		return new DialogTitleImportModel(db, stModel);
	}

	public DialogTitleImportModel newDialogTitleImportModel(Node node) {
		return new DialogTitleImportModel(db, node);
	}

	public Stream<DialogTitleImportModel> findAllDialogTitleImportModel() {
		return db.findAllSTModelByStTemplate(DialogTitleImportModel.stTemplateUuid)
				.map(stModel -> new DialogTitleImportModel(db, stModel));
	}

	public DialogTitleImportModel findDialogTitleImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogTitleImportModel(db, uuid) : new DialogTitleImportModel(db, stModel);
	}


	public DialogTitleElementModel newDialogTitleElementModel() {
		return new DialogTitleElementModel(db);
	}

	public DialogTitleElementModel newDialogTitleElementModel(STModel stModel) {
		return new DialogTitleElementModel(db, stModel);
	}

	public DialogTitleElementModel newDialogTitleElementModel(Node node) {
		return new DialogTitleElementModel(db, node);
	}

	public Stream<DialogTitleElementModel> findAllDialogTitleElementModel() {
		return db.findAllSTModelByStTemplate(DialogTitleElementModel.stTemplateUuid)
				.map(stModel -> new DialogTitleElementModel(db, stModel));
	}

	public DialogTitleElementModel findDialogTitleElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DialogTitleElementModel(db, uuid) : new DialogTitleElementModel(db, stModel);
	}


	public DividerModel newDividerModel() {
		return new DividerModel(db);
	}

	public DividerModel newDividerModel(STModel stModel) {
		return new DividerModel(db, stModel);
	}

	public DividerModel newDividerModel(Node node) {
		return new DividerModel(db, node);
	}

	public Stream<DividerModel> findAllDividerModel() {
		return db.findAllSTModelByStTemplate(DividerModel.stTemplateUuid)
				.map(stModel -> new DividerModel(db, stModel));
	}

	public DividerModel findDividerModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DividerModel(db, uuid) : new DividerModel(db, stModel);
	}


	public DividerImportModel newDividerImportModel() {
		return new DividerImportModel(db);
	}

	public DividerImportModel newDividerImportModel(STModel stModel) {
		return new DividerImportModel(db, stModel);
	}

	public DividerImportModel newDividerImportModel(Node node) {
		return new DividerImportModel(db, node);
	}

	public Stream<DividerImportModel> findAllDividerImportModel() {
		return db.findAllSTModelByStTemplate(DividerImportModel.stTemplateUuid)
				.map(stModel -> new DividerImportModel(db, stModel));
	}

	public DividerImportModel findDividerImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DividerImportModel(db, uuid) : new DividerImportModel(db, stModel);
	}


	public DividerElementModel newDividerElementModel() {
		return new DividerElementModel(db);
	}

	public DividerElementModel newDividerElementModel(STModel stModel) {
		return new DividerElementModel(db, stModel);
	}

	public DividerElementModel newDividerElementModel(Node node) {
		return new DividerElementModel(db, node);
	}

	public Stream<DividerElementModel> findAllDividerElementModel() {
		return db.findAllSTModelByStTemplate(DividerElementModel.stTemplateUuid)
				.map(stModel -> new DividerElementModel(db, stModel));
	}

	public DividerElementModel findDividerElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DividerElementModel(db, uuid) : new DividerElementModel(db, stModel);
	}


	public DrawerModel newDrawerModel() {
		return new DrawerModel(db);
	}

	public DrawerModel newDrawerModel(STModel stModel) {
		return new DrawerModel(db, stModel);
	}

	public DrawerModel newDrawerModel(Node node) {
		return new DrawerModel(db, node);
	}

	public Stream<DrawerModel> findAllDrawerModel() {
		return db.findAllSTModelByStTemplate(DrawerModel.stTemplateUuid)
				.map(stModel -> new DrawerModel(db, stModel));
	}

	public DrawerModel findDrawerModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DrawerModel(db, uuid) : new DrawerModel(db, stModel);
	}


	public DrawerImportModel newDrawerImportModel() {
		return new DrawerImportModel(db);
	}

	public DrawerImportModel newDrawerImportModel(STModel stModel) {
		return new DrawerImportModel(db, stModel);
	}

	public DrawerImportModel newDrawerImportModel(Node node) {
		return new DrawerImportModel(db, node);
	}

	public Stream<DrawerImportModel> findAllDrawerImportModel() {
		return db.findAllSTModelByStTemplate(DrawerImportModel.stTemplateUuid)
				.map(stModel -> new DrawerImportModel(db, stModel));
	}

	public DrawerImportModel findDrawerImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DrawerImportModel(db, uuid) : new DrawerImportModel(db, stModel);
	}


	public DrawerElementModel newDrawerElementModel() {
		return new DrawerElementModel(db);
	}

	public DrawerElementModel newDrawerElementModel(STModel stModel) {
		return new DrawerElementModel(db, stModel);
	}

	public DrawerElementModel newDrawerElementModel(Node node) {
		return new DrawerElementModel(db, node);
	}

	public Stream<DrawerElementModel> findAllDrawerElementModel() {
		return db.findAllSTModelByStTemplate(DrawerElementModel.stTemplateUuid)
				.map(stModel -> new DrawerElementModel(db, stModel));
	}

	public DrawerElementModel findDrawerElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new DrawerElementModel(db, uuid) : new DrawerElementModel(db, stModel);
	}


	public ExpansionPanelModel newExpansionPanelModel() {
		return new ExpansionPanelModel(db);
	}

	public ExpansionPanelModel newExpansionPanelModel(STModel stModel) {
		return new ExpansionPanelModel(db, stModel);
	}

	public ExpansionPanelModel newExpansionPanelModel(Node node) {
		return new ExpansionPanelModel(db, node);
	}

	public Stream<ExpansionPanelModel> findAllExpansionPanelModel() {
		return db.findAllSTModelByStTemplate(ExpansionPanelModel.stTemplateUuid)
				.map(stModel -> new ExpansionPanelModel(db, stModel));
	}

	public ExpansionPanelModel findExpansionPanelModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ExpansionPanelModel(db, uuid) : new ExpansionPanelModel(db, stModel);
	}


	public ExpansionPanelImportModel newExpansionPanelImportModel() {
		return new ExpansionPanelImportModel(db);
	}

	public ExpansionPanelImportModel newExpansionPanelImportModel(STModel stModel) {
		return new ExpansionPanelImportModel(db, stModel);
	}

	public ExpansionPanelImportModel newExpansionPanelImportModel(Node node) {
		return new ExpansionPanelImportModel(db, node);
	}

	public Stream<ExpansionPanelImportModel> findAllExpansionPanelImportModel() {
		return db.findAllSTModelByStTemplate(ExpansionPanelImportModel.stTemplateUuid)
				.map(stModel -> new ExpansionPanelImportModel(db, stModel));
	}

	public ExpansionPanelImportModel findExpansionPanelImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ExpansionPanelImportModel(db, uuid) : new ExpansionPanelImportModel(db, stModel);
	}


	public ExpansionPanelElementModel newExpansionPanelElementModel() {
		return new ExpansionPanelElementModel(db);
	}

	public ExpansionPanelElementModel newExpansionPanelElementModel(STModel stModel) {
		return new ExpansionPanelElementModel(db, stModel);
	}

	public ExpansionPanelElementModel newExpansionPanelElementModel(Node node) {
		return new ExpansionPanelElementModel(db, node);
	}

	public Stream<ExpansionPanelElementModel> findAllExpansionPanelElementModel() {
		return db.findAllSTModelByStTemplate(ExpansionPanelElementModel.stTemplateUuid)
				.map(stModel -> new ExpansionPanelElementModel(db, stModel));
	}

	public ExpansionPanelElementModel findExpansionPanelElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ExpansionPanelElementModel(db, uuid) : new ExpansionPanelElementModel(db, stModel);
	}


	public ExpansionPanelActionsModel newExpansionPanelActionsModel() {
		return new ExpansionPanelActionsModel(db);
	}

	public ExpansionPanelActionsModel newExpansionPanelActionsModel(STModel stModel) {
		return new ExpansionPanelActionsModel(db, stModel);
	}

	public ExpansionPanelActionsModel newExpansionPanelActionsModel(Node node) {
		return new ExpansionPanelActionsModel(db, node);
	}

	public Stream<ExpansionPanelActionsModel> findAllExpansionPanelActionsModel() {
		return db.findAllSTModelByStTemplate(ExpansionPanelActionsModel.stTemplateUuid)
				.map(stModel -> new ExpansionPanelActionsModel(db, stModel));
	}

	public ExpansionPanelActionsModel findExpansionPanelActionsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ExpansionPanelActionsModel(db, uuid) : new ExpansionPanelActionsModel(db, stModel);
	}


	public ExpansionPanelActionsImportModel newExpansionPanelActionsImportModel() {
		return new ExpansionPanelActionsImportModel(db);
	}

	public ExpansionPanelActionsImportModel newExpansionPanelActionsImportModel(STModel stModel) {
		return new ExpansionPanelActionsImportModel(db, stModel);
	}

	public ExpansionPanelActionsImportModel newExpansionPanelActionsImportModel(Node node) {
		return new ExpansionPanelActionsImportModel(db, node);
	}

	public Stream<ExpansionPanelActionsImportModel> findAllExpansionPanelActionsImportModel() {
		return db.findAllSTModelByStTemplate(ExpansionPanelActionsImportModel.stTemplateUuid)
				.map(stModel -> new ExpansionPanelActionsImportModel(db, stModel));
	}

	public ExpansionPanelActionsImportModel findExpansionPanelActionsImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ExpansionPanelActionsImportModel(db, uuid) : new ExpansionPanelActionsImportModel(db, stModel);
	}


	public ExpansionPanelActionsElementModel newExpansionPanelActionsElementModel() {
		return new ExpansionPanelActionsElementModel(db);
	}

	public ExpansionPanelActionsElementModel newExpansionPanelActionsElementModel(STModel stModel) {
		return new ExpansionPanelActionsElementModel(db, stModel);
	}

	public ExpansionPanelActionsElementModel newExpansionPanelActionsElementModel(Node node) {
		return new ExpansionPanelActionsElementModel(db, node);
	}

	public Stream<ExpansionPanelActionsElementModel> findAllExpansionPanelActionsElementModel() {
		return db.findAllSTModelByStTemplate(ExpansionPanelActionsElementModel.stTemplateUuid)
				.map(stModel -> new ExpansionPanelActionsElementModel(db, stModel));
	}

	public ExpansionPanelActionsElementModel findExpansionPanelActionsElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ExpansionPanelActionsElementModel(db, uuid) : new ExpansionPanelActionsElementModel(db, stModel);
	}


	public ExpansionPanelDetailsModel newExpansionPanelDetailsModel() {
		return new ExpansionPanelDetailsModel(db);
	}

	public ExpansionPanelDetailsModel newExpansionPanelDetailsModel(STModel stModel) {
		return new ExpansionPanelDetailsModel(db, stModel);
	}

	public ExpansionPanelDetailsModel newExpansionPanelDetailsModel(Node node) {
		return new ExpansionPanelDetailsModel(db, node);
	}

	public Stream<ExpansionPanelDetailsModel> findAllExpansionPanelDetailsModel() {
		return db.findAllSTModelByStTemplate(ExpansionPanelDetailsModel.stTemplateUuid)
				.map(stModel -> new ExpansionPanelDetailsModel(db, stModel));
	}

	public ExpansionPanelDetailsModel findExpansionPanelDetailsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ExpansionPanelDetailsModel(db, uuid) : new ExpansionPanelDetailsModel(db, stModel);
	}


	public ExpansionPanelDetailsImportModel newExpansionPanelDetailsImportModel() {
		return new ExpansionPanelDetailsImportModel(db);
	}

	public ExpansionPanelDetailsImportModel newExpansionPanelDetailsImportModel(STModel stModel) {
		return new ExpansionPanelDetailsImportModel(db, stModel);
	}

	public ExpansionPanelDetailsImportModel newExpansionPanelDetailsImportModel(Node node) {
		return new ExpansionPanelDetailsImportModel(db, node);
	}

	public Stream<ExpansionPanelDetailsImportModel> findAllExpansionPanelDetailsImportModel() {
		return db.findAllSTModelByStTemplate(ExpansionPanelDetailsImportModel.stTemplateUuid)
				.map(stModel -> new ExpansionPanelDetailsImportModel(db, stModel));
	}

	public ExpansionPanelDetailsImportModel findExpansionPanelDetailsImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ExpansionPanelDetailsImportModel(db, uuid) : new ExpansionPanelDetailsImportModel(db, stModel);
	}


	public ExpansionPanelDetailsElementModel newExpansionPanelDetailsElementModel() {
		return new ExpansionPanelDetailsElementModel(db);
	}

	public ExpansionPanelDetailsElementModel newExpansionPanelDetailsElementModel(STModel stModel) {
		return new ExpansionPanelDetailsElementModel(db, stModel);
	}

	public ExpansionPanelDetailsElementModel newExpansionPanelDetailsElementModel(Node node) {
		return new ExpansionPanelDetailsElementModel(db, node);
	}

	public Stream<ExpansionPanelDetailsElementModel> findAllExpansionPanelDetailsElementModel() {
		return db.findAllSTModelByStTemplate(ExpansionPanelDetailsElementModel.stTemplateUuid)
				.map(stModel -> new ExpansionPanelDetailsElementModel(db, stModel));
	}

	public ExpansionPanelDetailsElementModel findExpansionPanelDetailsElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ExpansionPanelDetailsElementModel(db, uuid) : new ExpansionPanelDetailsElementModel(db, stModel);
	}


	public ExpansionPanelSummaryModel newExpansionPanelSummaryModel() {
		return new ExpansionPanelSummaryModel(db);
	}

	public ExpansionPanelSummaryModel newExpansionPanelSummaryModel(STModel stModel) {
		return new ExpansionPanelSummaryModel(db, stModel);
	}

	public ExpansionPanelSummaryModel newExpansionPanelSummaryModel(Node node) {
		return new ExpansionPanelSummaryModel(db, node);
	}

	public Stream<ExpansionPanelSummaryModel> findAllExpansionPanelSummaryModel() {
		return db.findAllSTModelByStTemplate(ExpansionPanelSummaryModel.stTemplateUuid)
				.map(stModel -> new ExpansionPanelSummaryModel(db, stModel));
	}

	public ExpansionPanelSummaryModel findExpansionPanelSummaryModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ExpansionPanelSummaryModel(db, uuid) : new ExpansionPanelSummaryModel(db, stModel);
	}


	public ExpansionPanelSummaryImportModel newExpansionPanelSummaryImportModel() {
		return new ExpansionPanelSummaryImportModel(db);
	}

	public ExpansionPanelSummaryImportModel newExpansionPanelSummaryImportModel(STModel stModel) {
		return new ExpansionPanelSummaryImportModel(db, stModel);
	}

	public ExpansionPanelSummaryImportModel newExpansionPanelSummaryImportModel(Node node) {
		return new ExpansionPanelSummaryImportModel(db, node);
	}

	public Stream<ExpansionPanelSummaryImportModel> findAllExpansionPanelSummaryImportModel() {
		return db.findAllSTModelByStTemplate(ExpansionPanelSummaryImportModel.stTemplateUuid)
				.map(stModel -> new ExpansionPanelSummaryImportModel(db, stModel));
	}

	public ExpansionPanelSummaryImportModel findExpansionPanelSummaryImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ExpansionPanelSummaryImportModel(db, uuid) : new ExpansionPanelSummaryImportModel(db, stModel);
	}


	public ExpansionPanelSummaryElementModel newExpansionPanelSummaryElementModel() {
		return new ExpansionPanelSummaryElementModel(db);
	}

	public ExpansionPanelSummaryElementModel newExpansionPanelSummaryElementModel(STModel stModel) {
		return new ExpansionPanelSummaryElementModel(db, stModel);
	}

	public ExpansionPanelSummaryElementModel newExpansionPanelSummaryElementModel(Node node) {
		return new ExpansionPanelSummaryElementModel(db, node);
	}

	public Stream<ExpansionPanelSummaryElementModel> findAllExpansionPanelSummaryElementModel() {
		return db.findAllSTModelByStTemplate(ExpansionPanelSummaryElementModel.stTemplateUuid)
				.map(stModel -> new ExpansionPanelSummaryElementModel(db, stModel));
	}

	public ExpansionPanelSummaryElementModel findExpansionPanelSummaryElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ExpansionPanelSummaryElementModel(db, uuid) : new ExpansionPanelSummaryElementModel(db, stModel);
	}


	public FabModel newFabModel() {
		return new FabModel(db);
	}

	public FabModel newFabModel(STModel stModel) {
		return new FabModel(db, stModel);
	}

	public FabModel newFabModel(Node node) {
		return new FabModel(db, node);
	}

	public Stream<FabModel> findAllFabModel() {
		return db.findAllSTModelByStTemplate(FabModel.stTemplateUuid)
				.map(stModel -> new FabModel(db, stModel));
	}

	public FabModel findFabModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FabModel(db, uuid) : new FabModel(db, stModel);
	}


	public FabImportModel newFabImportModel() {
		return new FabImportModel(db);
	}

	public FabImportModel newFabImportModel(STModel stModel) {
		return new FabImportModel(db, stModel);
	}

	public FabImportModel newFabImportModel(Node node) {
		return new FabImportModel(db, node);
	}

	public Stream<FabImportModel> findAllFabImportModel() {
		return db.findAllSTModelByStTemplate(FabImportModel.stTemplateUuid)
				.map(stModel -> new FabImportModel(db, stModel));
	}

	public FabImportModel findFabImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FabImportModel(db, uuid) : new FabImportModel(db, stModel);
	}


	public FabElementModel newFabElementModel() {
		return new FabElementModel(db);
	}

	public FabElementModel newFabElementModel(STModel stModel) {
		return new FabElementModel(db, stModel);
	}

	public FabElementModel newFabElementModel(Node node) {
		return new FabElementModel(db, node);
	}

	public Stream<FabElementModel> findAllFabElementModel() {
		return db.findAllSTModelByStTemplate(FabElementModel.stTemplateUuid)
				.map(stModel -> new FabElementModel(db, stModel));
	}

	public FabElementModel findFabElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FabElementModel(db, uuid) : new FabElementModel(db, stModel);
	}


	public FadeModel newFadeModel() {
		return new FadeModel(db);
	}

	public FadeModel newFadeModel(STModel stModel) {
		return new FadeModel(db, stModel);
	}

	public FadeModel newFadeModel(Node node) {
		return new FadeModel(db, node);
	}

	public Stream<FadeModel> findAllFadeModel() {
		return db.findAllSTModelByStTemplate(FadeModel.stTemplateUuid)
				.map(stModel -> new FadeModel(db, stModel));
	}

	public FadeModel findFadeModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FadeModel(db, uuid) : new FadeModel(db, stModel);
	}


	public FadeImportModel newFadeImportModel() {
		return new FadeImportModel(db);
	}

	public FadeImportModel newFadeImportModel(STModel stModel) {
		return new FadeImportModel(db, stModel);
	}

	public FadeImportModel newFadeImportModel(Node node) {
		return new FadeImportModel(db, node);
	}

	public Stream<FadeImportModel> findAllFadeImportModel() {
		return db.findAllSTModelByStTemplate(FadeImportModel.stTemplateUuid)
				.map(stModel -> new FadeImportModel(db, stModel));
	}

	public FadeImportModel findFadeImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FadeImportModel(db, uuid) : new FadeImportModel(db, stModel);
	}


	public FadeElementModel newFadeElementModel() {
		return new FadeElementModel(db);
	}

	public FadeElementModel newFadeElementModel(STModel stModel) {
		return new FadeElementModel(db, stModel);
	}

	public FadeElementModel newFadeElementModel(Node node) {
		return new FadeElementModel(db, node);
	}

	public Stream<FadeElementModel> findAllFadeElementModel() {
		return db.findAllSTModelByStTemplate(FadeElementModel.stTemplateUuid)
				.map(stModel -> new FadeElementModel(db, stModel));
	}

	public FadeElementModel findFadeElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FadeElementModel(db, uuid) : new FadeElementModel(db, stModel);
	}


	public FilledInputModel newFilledInputModel() {
		return new FilledInputModel(db);
	}

	public FilledInputModel newFilledInputModel(STModel stModel) {
		return new FilledInputModel(db, stModel);
	}

	public FilledInputModel newFilledInputModel(Node node) {
		return new FilledInputModel(db, node);
	}

	public Stream<FilledInputModel> findAllFilledInputModel() {
		return db.findAllSTModelByStTemplate(FilledInputModel.stTemplateUuid)
				.map(stModel -> new FilledInputModel(db, stModel));
	}

	public FilledInputModel findFilledInputModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FilledInputModel(db, uuid) : new FilledInputModel(db, stModel);
	}


	public FilledInputImportModel newFilledInputImportModel() {
		return new FilledInputImportModel(db);
	}

	public FilledInputImportModel newFilledInputImportModel(STModel stModel) {
		return new FilledInputImportModel(db, stModel);
	}

	public FilledInputImportModel newFilledInputImportModel(Node node) {
		return new FilledInputImportModel(db, node);
	}

	public Stream<FilledInputImportModel> findAllFilledInputImportModel() {
		return db.findAllSTModelByStTemplate(FilledInputImportModel.stTemplateUuid)
				.map(stModel -> new FilledInputImportModel(db, stModel));
	}

	public FilledInputImportModel findFilledInputImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FilledInputImportModel(db, uuid) : new FilledInputImportModel(db, stModel);
	}


	public FilledInputElementModel newFilledInputElementModel() {
		return new FilledInputElementModel(db);
	}

	public FilledInputElementModel newFilledInputElementModel(STModel stModel) {
		return new FilledInputElementModel(db, stModel);
	}

	public FilledInputElementModel newFilledInputElementModel(Node node) {
		return new FilledInputElementModel(db, node);
	}

	public Stream<FilledInputElementModel> findAllFilledInputElementModel() {
		return db.findAllSTModelByStTemplate(FilledInputElementModel.stTemplateUuid)
				.map(stModel -> new FilledInputElementModel(db, stModel));
	}

	public FilledInputElementModel findFilledInputElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FilledInputElementModel(db, uuid) : new FilledInputElementModel(db, stModel);
	}


	public FormControlModel newFormControlModel() {
		return new FormControlModel(db);
	}

	public FormControlModel newFormControlModel(STModel stModel) {
		return new FormControlModel(db, stModel);
	}

	public FormControlModel newFormControlModel(Node node) {
		return new FormControlModel(db, node);
	}

	public Stream<FormControlModel> findAllFormControlModel() {
		return db.findAllSTModelByStTemplate(FormControlModel.stTemplateUuid)
				.map(stModel -> new FormControlModel(db, stModel));
	}

	public FormControlModel findFormControlModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormControlModel(db, uuid) : new FormControlModel(db, stModel);
	}


	public FormControlImportModel newFormControlImportModel() {
		return new FormControlImportModel(db);
	}

	public FormControlImportModel newFormControlImportModel(STModel stModel) {
		return new FormControlImportModel(db, stModel);
	}

	public FormControlImportModel newFormControlImportModel(Node node) {
		return new FormControlImportModel(db, node);
	}

	public Stream<FormControlImportModel> findAllFormControlImportModel() {
		return db.findAllSTModelByStTemplate(FormControlImportModel.stTemplateUuid)
				.map(stModel -> new FormControlImportModel(db, stModel));
	}

	public FormControlImportModel findFormControlImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormControlImportModel(db, uuid) : new FormControlImportModel(db, stModel);
	}


	public FormControlElementModel newFormControlElementModel() {
		return new FormControlElementModel(db);
	}

	public FormControlElementModel newFormControlElementModel(STModel stModel) {
		return new FormControlElementModel(db, stModel);
	}

	public FormControlElementModel newFormControlElementModel(Node node) {
		return new FormControlElementModel(db, node);
	}

	public Stream<FormControlElementModel> findAllFormControlElementModel() {
		return db.findAllSTModelByStTemplate(FormControlElementModel.stTemplateUuid)
				.map(stModel -> new FormControlElementModel(db, stModel));
	}

	public FormControlElementModel findFormControlElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormControlElementModel(db, uuid) : new FormControlElementModel(db, stModel);
	}


	public FormControlLabelModel newFormControlLabelModel() {
		return new FormControlLabelModel(db);
	}

	public FormControlLabelModel newFormControlLabelModel(STModel stModel) {
		return new FormControlLabelModel(db, stModel);
	}

	public FormControlLabelModel newFormControlLabelModel(Node node) {
		return new FormControlLabelModel(db, node);
	}

	public Stream<FormControlLabelModel> findAllFormControlLabelModel() {
		return db.findAllSTModelByStTemplate(FormControlLabelModel.stTemplateUuid)
				.map(stModel -> new FormControlLabelModel(db, stModel));
	}

	public FormControlLabelModel findFormControlLabelModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormControlLabelModel(db, uuid) : new FormControlLabelModel(db, stModel);
	}


	public FormControlLabelImportModel newFormControlLabelImportModel() {
		return new FormControlLabelImportModel(db);
	}

	public FormControlLabelImportModel newFormControlLabelImportModel(STModel stModel) {
		return new FormControlLabelImportModel(db, stModel);
	}

	public FormControlLabelImportModel newFormControlLabelImportModel(Node node) {
		return new FormControlLabelImportModel(db, node);
	}

	public Stream<FormControlLabelImportModel> findAllFormControlLabelImportModel() {
		return db.findAllSTModelByStTemplate(FormControlLabelImportModel.stTemplateUuid)
				.map(stModel -> new FormControlLabelImportModel(db, stModel));
	}

	public FormControlLabelImportModel findFormControlLabelImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormControlLabelImportModel(db, uuid) : new FormControlLabelImportModel(db, stModel);
	}


	public FormControlLabelElementModel newFormControlLabelElementModel() {
		return new FormControlLabelElementModel(db);
	}

	public FormControlLabelElementModel newFormControlLabelElementModel(STModel stModel) {
		return new FormControlLabelElementModel(db, stModel);
	}

	public FormControlLabelElementModel newFormControlLabelElementModel(Node node) {
		return new FormControlLabelElementModel(db, node);
	}

	public Stream<FormControlLabelElementModel> findAllFormControlLabelElementModel() {
		return db.findAllSTModelByStTemplate(FormControlLabelElementModel.stTemplateUuid)
				.map(stModel -> new FormControlLabelElementModel(db, stModel));
	}

	public FormControlLabelElementModel findFormControlLabelElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormControlLabelElementModel(db, uuid) : new FormControlLabelElementModel(db, stModel);
	}


	public FormGroupModel newFormGroupModel() {
		return new FormGroupModel(db);
	}

	public FormGroupModel newFormGroupModel(STModel stModel) {
		return new FormGroupModel(db, stModel);
	}

	public FormGroupModel newFormGroupModel(Node node) {
		return new FormGroupModel(db, node);
	}

	public Stream<FormGroupModel> findAllFormGroupModel() {
		return db.findAllSTModelByStTemplate(FormGroupModel.stTemplateUuid)
				.map(stModel -> new FormGroupModel(db, stModel));
	}

	public FormGroupModel findFormGroupModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormGroupModel(db, uuid) : new FormGroupModel(db, stModel);
	}


	public FormGroupImportModel newFormGroupImportModel() {
		return new FormGroupImportModel(db);
	}

	public FormGroupImportModel newFormGroupImportModel(STModel stModel) {
		return new FormGroupImportModel(db, stModel);
	}

	public FormGroupImportModel newFormGroupImportModel(Node node) {
		return new FormGroupImportModel(db, node);
	}

	public Stream<FormGroupImportModel> findAllFormGroupImportModel() {
		return db.findAllSTModelByStTemplate(FormGroupImportModel.stTemplateUuid)
				.map(stModel -> new FormGroupImportModel(db, stModel));
	}

	public FormGroupImportModel findFormGroupImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormGroupImportModel(db, uuid) : new FormGroupImportModel(db, stModel);
	}


	public FormGroupElementModel newFormGroupElementModel() {
		return new FormGroupElementModel(db);
	}

	public FormGroupElementModel newFormGroupElementModel(STModel stModel) {
		return new FormGroupElementModel(db, stModel);
	}

	public FormGroupElementModel newFormGroupElementModel(Node node) {
		return new FormGroupElementModel(db, node);
	}

	public Stream<FormGroupElementModel> findAllFormGroupElementModel() {
		return db.findAllSTModelByStTemplate(FormGroupElementModel.stTemplateUuid)
				.map(stModel -> new FormGroupElementModel(db, stModel));
	}

	public FormGroupElementModel findFormGroupElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormGroupElementModel(db, uuid) : new FormGroupElementModel(db, stModel);
	}


	public FormHelperTextModel newFormHelperTextModel() {
		return new FormHelperTextModel(db);
	}

	public FormHelperTextModel newFormHelperTextModel(STModel stModel) {
		return new FormHelperTextModel(db, stModel);
	}

	public FormHelperTextModel newFormHelperTextModel(Node node) {
		return new FormHelperTextModel(db, node);
	}

	public Stream<FormHelperTextModel> findAllFormHelperTextModel() {
		return db.findAllSTModelByStTemplate(FormHelperTextModel.stTemplateUuid)
				.map(stModel -> new FormHelperTextModel(db, stModel));
	}

	public FormHelperTextModel findFormHelperTextModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormHelperTextModel(db, uuid) : new FormHelperTextModel(db, stModel);
	}


	public FormHelperTextImportModel newFormHelperTextImportModel() {
		return new FormHelperTextImportModel(db);
	}

	public FormHelperTextImportModel newFormHelperTextImportModel(STModel stModel) {
		return new FormHelperTextImportModel(db, stModel);
	}

	public FormHelperTextImportModel newFormHelperTextImportModel(Node node) {
		return new FormHelperTextImportModel(db, node);
	}

	public Stream<FormHelperTextImportModel> findAllFormHelperTextImportModel() {
		return db.findAllSTModelByStTemplate(FormHelperTextImportModel.stTemplateUuid)
				.map(stModel -> new FormHelperTextImportModel(db, stModel));
	}

	public FormHelperTextImportModel findFormHelperTextImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormHelperTextImportModel(db, uuid) : new FormHelperTextImportModel(db, stModel);
	}


	public FormHelperTextElementModel newFormHelperTextElementModel() {
		return new FormHelperTextElementModel(db);
	}

	public FormHelperTextElementModel newFormHelperTextElementModel(STModel stModel) {
		return new FormHelperTextElementModel(db, stModel);
	}

	public FormHelperTextElementModel newFormHelperTextElementModel(Node node) {
		return new FormHelperTextElementModel(db, node);
	}

	public Stream<FormHelperTextElementModel> findAllFormHelperTextElementModel() {
		return db.findAllSTModelByStTemplate(FormHelperTextElementModel.stTemplateUuid)
				.map(stModel -> new FormHelperTextElementModel(db, stModel));
	}

	public FormHelperTextElementModel findFormHelperTextElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormHelperTextElementModel(db, uuid) : new FormHelperTextElementModel(db, stModel);
	}


	public FormLabelModel newFormLabelModel() {
		return new FormLabelModel(db);
	}

	public FormLabelModel newFormLabelModel(STModel stModel) {
		return new FormLabelModel(db, stModel);
	}

	public FormLabelModel newFormLabelModel(Node node) {
		return new FormLabelModel(db, node);
	}

	public Stream<FormLabelModel> findAllFormLabelModel() {
		return db.findAllSTModelByStTemplate(FormLabelModel.stTemplateUuid)
				.map(stModel -> new FormLabelModel(db, stModel));
	}

	public FormLabelModel findFormLabelModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormLabelModel(db, uuid) : new FormLabelModel(db, stModel);
	}


	public FormLabelImportModel newFormLabelImportModel() {
		return new FormLabelImportModel(db);
	}

	public FormLabelImportModel newFormLabelImportModel(STModel stModel) {
		return new FormLabelImportModel(db, stModel);
	}

	public FormLabelImportModel newFormLabelImportModel(Node node) {
		return new FormLabelImportModel(db, node);
	}

	public Stream<FormLabelImportModel> findAllFormLabelImportModel() {
		return db.findAllSTModelByStTemplate(FormLabelImportModel.stTemplateUuid)
				.map(stModel -> new FormLabelImportModel(db, stModel));
	}

	public FormLabelImportModel findFormLabelImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormLabelImportModel(db, uuid) : new FormLabelImportModel(db, stModel);
	}


	public FormLabelElementModel newFormLabelElementModel() {
		return new FormLabelElementModel(db);
	}

	public FormLabelElementModel newFormLabelElementModel(STModel stModel) {
		return new FormLabelElementModel(db, stModel);
	}

	public FormLabelElementModel newFormLabelElementModel(Node node) {
		return new FormLabelElementModel(db, node);
	}

	public Stream<FormLabelElementModel> findAllFormLabelElementModel() {
		return db.findAllSTModelByStTemplate(FormLabelElementModel.stTemplateUuid)
				.map(stModel -> new FormLabelElementModel(db, stModel));
	}

	public FormLabelElementModel findFormLabelElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new FormLabelElementModel(db, uuid) : new FormLabelElementModel(db, stModel);
	}


	public GridModel newGridModel() {
		return new GridModel(db);
	}

	public GridModel newGridModel(STModel stModel) {
		return new GridModel(db, stModel);
	}

	public GridModel newGridModel(Node node) {
		return new GridModel(db, node);
	}

	public Stream<GridModel> findAllGridModel() {
		return db.findAllSTModelByStTemplate(GridModel.stTemplateUuid)
				.map(stModel -> new GridModel(db, stModel));
	}

	public GridModel findGridModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GridModel(db, uuid) : new GridModel(db, stModel);
	}


	public GridImportModel newGridImportModel() {
		return new GridImportModel(db);
	}

	public GridImportModel newGridImportModel(STModel stModel) {
		return new GridImportModel(db, stModel);
	}

	public GridImportModel newGridImportModel(Node node) {
		return new GridImportModel(db, node);
	}

	public Stream<GridImportModel> findAllGridImportModel() {
		return db.findAllSTModelByStTemplate(GridImportModel.stTemplateUuid)
				.map(stModel -> new GridImportModel(db, stModel));
	}

	public GridImportModel findGridImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GridImportModel(db, uuid) : new GridImportModel(db, stModel);
	}


	public GridElementModel newGridElementModel() {
		return new GridElementModel(db);
	}

	public GridElementModel newGridElementModel(STModel stModel) {
		return new GridElementModel(db, stModel);
	}

	public GridElementModel newGridElementModel(Node node) {
		return new GridElementModel(db, node);
	}

	public Stream<GridElementModel> findAllGridElementModel() {
		return db.findAllSTModelByStTemplate(GridElementModel.stTemplateUuid)
				.map(stModel -> new GridElementModel(db, stModel));
	}

	public GridElementModel findGridElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GridElementModel(db, uuid) : new GridElementModel(db, stModel);
	}


	public GridListModel newGridListModel() {
		return new GridListModel(db);
	}

	public GridListModel newGridListModel(STModel stModel) {
		return new GridListModel(db, stModel);
	}

	public GridListModel newGridListModel(Node node) {
		return new GridListModel(db, node);
	}

	public Stream<GridListModel> findAllGridListModel() {
		return db.findAllSTModelByStTemplate(GridListModel.stTemplateUuid)
				.map(stModel -> new GridListModel(db, stModel));
	}

	public GridListModel findGridListModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GridListModel(db, uuid) : new GridListModel(db, stModel);
	}


	public GridListImportModel newGridListImportModel() {
		return new GridListImportModel(db);
	}

	public GridListImportModel newGridListImportModel(STModel stModel) {
		return new GridListImportModel(db, stModel);
	}

	public GridListImportModel newGridListImportModel(Node node) {
		return new GridListImportModel(db, node);
	}

	public Stream<GridListImportModel> findAllGridListImportModel() {
		return db.findAllSTModelByStTemplate(GridListImportModel.stTemplateUuid)
				.map(stModel -> new GridListImportModel(db, stModel));
	}

	public GridListImportModel findGridListImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GridListImportModel(db, uuid) : new GridListImportModel(db, stModel);
	}


	public GridListElementModel newGridListElementModel() {
		return new GridListElementModel(db);
	}

	public GridListElementModel newGridListElementModel(STModel stModel) {
		return new GridListElementModel(db, stModel);
	}

	public GridListElementModel newGridListElementModel(Node node) {
		return new GridListElementModel(db, node);
	}

	public Stream<GridListElementModel> findAllGridListElementModel() {
		return db.findAllSTModelByStTemplate(GridListElementModel.stTemplateUuid)
				.map(stModel -> new GridListElementModel(db, stModel));
	}

	public GridListElementModel findGridListElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GridListElementModel(db, uuid) : new GridListElementModel(db, stModel);
	}


	public GridListTileModel newGridListTileModel() {
		return new GridListTileModel(db);
	}

	public GridListTileModel newGridListTileModel(STModel stModel) {
		return new GridListTileModel(db, stModel);
	}

	public GridListTileModel newGridListTileModel(Node node) {
		return new GridListTileModel(db, node);
	}

	public Stream<GridListTileModel> findAllGridListTileModel() {
		return db.findAllSTModelByStTemplate(GridListTileModel.stTemplateUuid)
				.map(stModel -> new GridListTileModel(db, stModel));
	}

	public GridListTileModel findGridListTileModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GridListTileModel(db, uuid) : new GridListTileModel(db, stModel);
	}


	public GridListTileImportModel newGridListTileImportModel() {
		return new GridListTileImportModel(db);
	}

	public GridListTileImportModel newGridListTileImportModel(STModel stModel) {
		return new GridListTileImportModel(db, stModel);
	}

	public GridListTileImportModel newGridListTileImportModel(Node node) {
		return new GridListTileImportModel(db, node);
	}

	public Stream<GridListTileImportModel> findAllGridListTileImportModel() {
		return db.findAllSTModelByStTemplate(GridListTileImportModel.stTemplateUuid)
				.map(stModel -> new GridListTileImportModel(db, stModel));
	}

	public GridListTileImportModel findGridListTileImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GridListTileImportModel(db, uuid) : new GridListTileImportModel(db, stModel);
	}


	public GridListTileElementModel newGridListTileElementModel() {
		return new GridListTileElementModel(db);
	}

	public GridListTileElementModel newGridListTileElementModel(STModel stModel) {
		return new GridListTileElementModel(db, stModel);
	}

	public GridListTileElementModel newGridListTileElementModel(Node node) {
		return new GridListTileElementModel(db, node);
	}

	public Stream<GridListTileElementModel> findAllGridListTileElementModel() {
		return db.findAllSTModelByStTemplate(GridListTileElementModel.stTemplateUuid)
				.map(stModel -> new GridListTileElementModel(db, stModel));
	}

	public GridListTileElementModel findGridListTileElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GridListTileElementModel(db, uuid) : new GridListTileElementModel(db, stModel);
	}


	public GridListTileBarModel newGridListTileBarModel() {
		return new GridListTileBarModel(db);
	}

	public GridListTileBarModel newGridListTileBarModel(STModel stModel) {
		return new GridListTileBarModel(db, stModel);
	}

	public GridListTileBarModel newGridListTileBarModel(Node node) {
		return new GridListTileBarModel(db, node);
	}

	public Stream<GridListTileBarModel> findAllGridListTileBarModel() {
		return db.findAllSTModelByStTemplate(GridListTileBarModel.stTemplateUuid)
				.map(stModel -> new GridListTileBarModel(db, stModel));
	}

	public GridListTileBarModel findGridListTileBarModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GridListTileBarModel(db, uuid) : new GridListTileBarModel(db, stModel);
	}


	public GridListTileBarImportModel newGridListTileBarImportModel() {
		return new GridListTileBarImportModel(db);
	}

	public GridListTileBarImportModel newGridListTileBarImportModel(STModel stModel) {
		return new GridListTileBarImportModel(db, stModel);
	}

	public GridListTileBarImportModel newGridListTileBarImportModel(Node node) {
		return new GridListTileBarImportModel(db, node);
	}

	public Stream<GridListTileBarImportModel> findAllGridListTileBarImportModel() {
		return db.findAllSTModelByStTemplate(GridListTileBarImportModel.stTemplateUuid)
				.map(stModel -> new GridListTileBarImportModel(db, stModel));
	}

	public GridListTileBarImportModel findGridListTileBarImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GridListTileBarImportModel(db, uuid) : new GridListTileBarImportModel(db, stModel);
	}


	public GridListTileBarElementModel newGridListTileBarElementModel() {
		return new GridListTileBarElementModel(db);
	}

	public GridListTileBarElementModel newGridListTileBarElementModel(STModel stModel) {
		return new GridListTileBarElementModel(db, stModel);
	}

	public GridListTileBarElementModel newGridListTileBarElementModel(Node node) {
		return new GridListTileBarElementModel(db, node);
	}

	public Stream<GridListTileBarElementModel> findAllGridListTileBarElementModel() {
		return db.findAllSTModelByStTemplate(GridListTileBarElementModel.stTemplateUuid)
				.map(stModel -> new GridListTileBarElementModel(db, stModel));
	}

	public GridListTileBarElementModel findGridListTileBarElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GridListTileBarElementModel(db, uuid) : new GridListTileBarElementModel(db, stModel);
	}


	public GrowModel newGrowModel() {
		return new GrowModel(db);
	}

	public GrowModel newGrowModel(STModel stModel) {
		return new GrowModel(db, stModel);
	}

	public GrowModel newGrowModel(Node node) {
		return new GrowModel(db, node);
	}

	public Stream<GrowModel> findAllGrowModel() {
		return db.findAllSTModelByStTemplate(GrowModel.stTemplateUuid)
				.map(stModel -> new GrowModel(db, stModel));
	}

	public GrowModel findGrowModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GrowModel(db, uuid) : new GrowModel(db, stModel);
	}


	public GrowImportModel newGrowImportModel() {
		return new GrowImportModel(db);
	}

	public GrowImportModel newGrowImportModel(STModel stModel) {
		return new GrowImportModel(db, stModel);
	}

	public GrowImportModel newGrowImportModel(Node node) {
		return new GrowImportModel(db, node);
	}

	public Stream<GrowImportModel> findAllGrowImportModel() {
		return db.findAllSTModelByStTemplate(GrowImportModel.stTemplateUuid)
				.map(stModel -> new GrowImportModel(db, stModel));
	}

	public GrowImportModel findGrowImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GrowImportModel(db, uuid) : new GrowImportModel(db, stModel);
	}


	public GrowElementModel newGrowElementModel() {
		return new GrowElementModel(db);
	}

	public GrowElementModel newGrowElementModel(STModel stModel) {
		return new GrowElementModel(db, stModel);
	}

	public GrowElementModel newGrowElementModel(Node node) {
		return new GrowElementModel(db, node);
	}

	public Stream<GrowElementModel> findAllGrowElementModel() {
		return db.findAllSTModelByStTemplate(GrowElementModel.stTemplateUuid)
				.map(stModel -> new GrowElementModel(db, stModel));
	}

	public GrowElementModel findGrowElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new GrowElementModel(db, uuid) : new GrowElementModel(db, stModel);
	}


	public HiddenModel newHiddenModel() {
		return new HiddenModel(db);
	}

	public HiddenModel newHiddenModel(STModel stModel) {
		return new HiddenModel(db, stModel);
	}

	public HiddenModel newHiddenModel(Node node) {
		return new HiddenModel(db, node);
	}

	public Stream<HiddenModel> findAllHiddenModel() {
		return db.findAllSTModelByStTemplate(HiddenModel.stTemplateUuid)
				.map(stModel -> new HiddenModel(db, stModel));
	}

	public HiddenModel findHiddenModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new HiddenModel(db, uuid) : new HiddenModel(db, stModel);
	}


	public HiddenImportModel newHiddenImportModel() {
		return new HiddenImportModel(db);
	}

	public HiddenImportModel newHiddenImportModel(STModel stModel) {
		return new HiddenImportModel(db, stModel);
	}

	public HiddenImportModel newHiddenImportModel(Node node) {
		return new HiddenImportModel(db, node);
	}

	public Stream<HiddenImportModel> findAllHiddenImportModel() {
		return db.findAllSTModelByStTemplate(HiddenImportModel.stTemplateUuid)
				.map(stModel -> new HiddenImportModel(db, stModel));
	}

	public HiddenImportModel findHiddenImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new HiddenImportModel(db, uuid) : new HiddenImportModel(db, stModel);
	}


	public HiddenElementModel newHiddenElementModel() {
		return new HiddenElementModel(db);
	}

	public HiddenElementModel newHiddenElementModel(STModel stModel) {
		return new HiddenElementModel(db, stModel);
	}

	public HiddenElementModel newHiddenElementModel(Node node) {
		return new HiddenElementModel(db, node);
	}

	public Stream<HiddenElementModel> findAllHiddenElementModel() {
		return db.findAllSTModelByStTemplate(HiddenElementModel.stTemplateUuid)
				.map(stModel -> new HiddenElementModel(db, stModel));
	}

	public HiddenElementModel findHiddenElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new HiddenElementModel(db, uuid) : new HiddenElementModel(db, stModel);
	}


	public IconModel newIconModel() {
		return new IconModel(db);
	}

	public IconModel newIconModel(STModel stModel) {
		return new IconModel(db, stModel);
	}

	public IconModel newIconModel(Node node) {
		return new IconModel(db, node);
	}

	public Stream<IconModel> findAllIconModel() {
		return db.findAllSTModelByStTemplate(IconModel.stTemplateUuid)
				.map(stModel -> new IconModel(db, stModel));
	}

	public IconModel findIconModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new IconModel(db, uuid) : new IconModel(db, stModel);
	}


	public IconImportModel newIconImportModel() {
		return new IconImportModel(db);
	}

	public IconImportModel newIconImportModel(STModel stModel) {
		return new IconImportModel(db, stModel);
	}

	public IconImportModel newIconImportModel(Node node) {
		return new IconImportModel(db, node);
	}

	public Stream<IconImportModel> findAllIconImportModel() {
		return db.findAllSTModelByStTemplate(IconImportModel.stTemplateUuid)
				.map(stModel -> new IconImportModel(db, stModel));
	}

	public IconImportModel findIconImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new IconImportModel(db, uuid) : new IconImportModel(db, stModel);
	}


	public IconElementModel newIconElementModel() {
		return new IconElementModel(db);
	}

	public IconElementModel newIconElementModel(STModel stModel) {
		return new IconElementModel(db, stModel);
	}

	public IconElementModel newIconElementModel(Node node) {
		return new IconElementModel(db, node);
	}

	public Stream<IconElementModel> findAllIconElementModel() {
		return db.findAllSTModelByStTemplate(IconElementModel.stTemplateUuid)
				.map(stModel -> new IconElementModel(db, stModel));
	}

	public IconElementModel findIconElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new IconElementModel(db, uuid) : new IconElementModel(db, stModel);
	}


	public IconButtonModel newIconButtonModel() {
		return new IconButtonModel(db);
	}

	public IconButtonModel newIconButtonModel(STModel stModel) {
		return new IconButtonModel(db, stModel);
	}

	public IconButtonModel newIconButtonModel(Node node) {
		return new IconButtonModel(db, node);
	}

	public Stream<IconButtonModel> findAllIconButtonModel() {
		return db.findAllSTModelByStTemplate(IconButtonModel.stTemplateUuid)
				.map(stModel -> new IconButtonModel(db, stModel));
	}

	public IconButtonModel findIconButtonModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new IconButtonModel(db, uuid) : new IconButtonModel(db, stModel);
	}


	public IconButtonImportModel newIconButtonImportModel() {
		return new IconButtonImportModel(db);
	}

	public IconButtonImportModel newIconButtonImportModel(STModel stModel) {
		return new IconButtonImportModel(db, stModel);
	}

	public IconButtonImportModel newIconButtonImportModel(Node node) {
		return new IconButtonImportModel(db, node);
	}

	public Stream<IconButtonImportModel> findAllIconButtonImportModel() {
		return db.findAllSTModelByStTemplate(IconButtonImportModel.stTemplateUuid)
				.map(stModel -> new IconButtonImportModel(db, stModel));
	}

	public IconButtonImportModel findIconButtonImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new IconButtonImportModel(db, uuid) : new IconButtonImportModel(db, stModel);
	}


	public IconButtonElementModel newIconButtonElementModel() {
		return new IconButtonElementModel(db);
	}

	public IconButtonElementModel newIconButtonElementModel(STModel stModel) {
		return new IconButtonElementModel(db, stModel);
	}

	public IconButtonElementModel newIconButtonElementModel(Node node) {
		return new IconButtonElementModel(db, node);
	}

	public Stream<IconButtonElementModel> findAllIconButtonElementModel() {
		return db.findAllSTModelByStTemplate(IconButtonElementModel.stTemplateUuid)
				.map(stModel -> new IconButtonElementModel(db, stModel));
	}

	public IconButtonElementModel findIconButtonElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new IconButtonElementModel(db, uuid) : new IconButtonElementModel(db, stModel);
	}


	public InputModel newInputModel() {
		return new InputModel(db);
	}

	public InputModel newInputModel(STModel stModel) {
		return new InputModel(db, stModel);
	}

	public InputModel newInputModel(Node node) {
		return new InputModel(db, node);
	}

	public Stream<InputModel> findAllInputModel() {
		return db.findAllSTModelByStTemplate(InputModel.stTemplateUuid)
				.map(stModel -> new InputModel(db, stModel));
	}

	public InputModel findInputModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new InputModel(db, uuid) : new InputModel(db, stModel);
	}


	public InputImportModel newInputImportModel() {
		return new InputImportModel(db);
	}

	public InputImportModel newInputImportModel(STModel stModel) {
		return new InputImportModel(db, stModel);
	}

	public InputImportModel newInputImportModel(Node node) {
		return new InputImportModel(db, node);
	}

	public Stream<InputImportModel> findAllInputImportModel() {
		return db.findAllSTModelByStTemplate(InputImportModel.stTemplateUuid)
				.map(stModel -> new InputImportModel(db, stModel));
	}

	public InputImportModel findInputImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new InputImportModel(db, uuid) : new InputImportModel(db, stModel);
	}


	public InputElementModel newInputElementModel() {
		return new InputElementModel(db);
	}

	public InputElementModel newInputElementModel(STModel stModel) {
		return new InputElementModel(db, stModel);
	}

	public InputElementModel newInputElementModel(Node node) {
		return new InputElementModel(db, node);
	}

	public Stream<InputElementModel> findAllInputElementModel() {
		return db.findAllSTModelByStTemplate(InputElementModel.stTemplateUuid)
				.map(stModel -> new InputElementModel(db, stModel));
	}

	public InputElementModel findInputElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new InputElementModel(db, uuid) : new InputElementModel(db, stModel);
	}


	public InputAdornmentModel newInputAdornmentModel() {
		return new InputAdornmentModel(db);
	}

	public InputAdornmentModel newInputAdornmentModel(STModel stModel) {
		return new InputAdornmentModel(db, stModel);
	}

	public InputAdornmentModel newInputAdornmentModel(Node node) {
		return new InputAdornmentModel(db, node);
	}

	public Stream<InputAdornmentModel> findAllInputAdornmentModel() {
		return db.findAllSTModelByStTemplate(InputAdornmentModel.stTemplateUuid)
				.map(stModel -> new InputAdornmentModel(db, stModel));
	}

	public InputAdornmentModel findInputAdornmentModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new InputAdornmentModel(db, uuid) : new InputAdornmentModel(db, stModel);
	}


	public InputAdornmentImportModel newInputAdornmentImportModel() {
		return new InputAdornmentImportModel(db);
	}

	public InputAdornmentImportModel newInputAdornmentImportModel(STModel stModel) {
		return new InputAdornmentImportModel(db, stModel);
	}

	public InputAdornmentImportModel newInputAdornmentImportModel(Node node) {
		return new InputAdornmentImportModel(db, node);
	}

	public Stream<InputAdornmentImportModel> findAllInputAdornmentImportModel() {
		return db.findAllSTModelByStTemplate(InputAdornmentImportModel.stTemplateUuid)
				.map(stModel -> new InputAdornmentImportModel(db, stModel));
	}

	public InputAdornmentImportModel findInputAdornmentImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new InputAdornmentImportModel(db, uuid) : new InputAdornmentImportModel(db, stModel);
	}


	public InputAdornmentElementModel newInputAdornmentElementModel() {
		return new InputAdornmentElementModel(db);
	}

	public InputAdornmentElementModel newInputAdornmentElementModel(STModel stModel) {
		return new InputAdornmentElementModel(db, stModel);
	}

	public InputAdornmentElementModel newInputAdornmentElementModel(Node node) {
		return new InputAdornmentElementModel(db, node);
	}

	public Stream<InputAdornmentElementModel> findAllInputAdornmentElementModel() {
		return db.findAllSTModelByStTemplate(InputAdornmentElementModel.stTemplateUuid)
				.map(stModel -> new InputAdornmentElementModel(db, stModel));
	}

	public InputAdornmentElementModel findInputAdornmentElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new InputAdornmentElementModel(db, uuid) : new InputAdornmentElementModel(db, stModel);
	}


	public InputBaseModel newInputBaseModel() {
		return new InputBaseModel(db);
	}

	public InputBaseModel newInputBaseModel(STModel stModel) {
		return new InputBaseModel(db, stModel);
	}

	public InputBaseModel newInputBaseModel(Node node) {
		return new InputBaseModel(db, node);
	}

	public Stream<InputBaseModel> findAllInputBaseModel() {
		return db.findAllSTModelByStTemplate(InputBaseModel.stTemplateUuid)
				.map(stModel -> new InputBaseModel(db, stModel));
	}

	public InputBaseModel findInputBaseModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new InputBaseModel(db, uuid) : new InputBaseModel(db, stModel);
	}


	public InputBaseImportModel newInputBaseImportModel() {
		return new InputBaseImportModel(db);
	}

	public InputBaseImportModel newInputBaseImportModel(STModel stModel) {
		return new InputBaseImportModel(db, stModel);
	}

	public InputBaseImportModel newInputBaseImportModel(Node node) {
		return new InputBaseImportModel(db, node);
	}

	public Stream<InputBaseImportModel> findAllInputBaseImportModel() {
		return db.findAllSTModelByStTemplate(InputBaseImportModel.stTemplateUuid)
				.map(stModel -> new InputBaseImportModel(db, stModel));
	}

	public InputBaseImportModel findInputBaseImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new InputBaseImportModel(db, uuid) : new InputBaseImportModel(db, stModel);
	}


	public InputBaseElementModel newInputBaseElementModel() {
		return new InputBaseElementModel(db);
	}

	public InputBaseElementModel newInputBaseElementModel(STModel stModel) {
		return new InputBaseElementModel(db, stModel);
	}

	public InputBaseElementModel newInputBaseElementModel(Node node) {
		return new InputBaseElementModel(db, node);
	}

	public Stream<InputBaseElementModel> findAllInputBaseElementModel() {
		return db.findAllSTModelByStTemplate(InputBaseElementModel.stTemplateUuid)
				.map(stModel -> new InputBaseElementModel(db, stModel));
	}

	public InputBaseElementModel findInputBaseElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new InputBaseElementModel(db, uuid) : new InputBaseElementModel(db, stModel);
	}


	public InputLabelModel newInputLabelModel() {
		return new InputLabelModel(db);
	}

	public InputLabelModel newInputLabelModel(STModel stModel) {
		return new InputLabelModel(db, stModel);
	}

	public InputLabelModel newInputLabelModel(Node node) {
		return new InputLabelModel(db, node);
	}

	public Stream<InputLabelModel> findAllInputLabelModel() {
		return db.findAllSTModelByStTemplate(InputLabelModel.stTemplateUuid)
				.map(stModel -> new InputLabelModel(db, stModel));
	}

	public InputLabelModel findInputLabelModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new InputLabelModel(db, uuid) : new InputLabelModel(db, stModel);
	}


	public InputLabelImportModel newInputLabelImportModel() {
		return new InputLabelImportModel(db);
	}

	public InputLabelImportModel newInputLabelImportModel(STModel stModel) {
		return new InputLabelImportModel(db, stModel);
	}

	public InputLabelImportModel newInputLabelImportModel(Node node) {
		return new InputLabelImportModel(db, node);
	}

	public Stream<InputLabelImportModel> findAllInputLabelImportModel() {
		return db.findAllSTModelByStTemplate(InputLabelImportModel.stTemplateUuid)
				.map(stModel -> new InputLabelImportModel(db, stModel));
	}

	public InputLabelImportModel findInputLabelImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new InputLabelImportModel(db, uuid) : new InputLabelImportModel(db, stModel);
	}


	public InputLabelElementModel newInputLabelElementModel() {
		return new InputLabelElementModel(db);
	}

	public InputLabelElementModel newInputLabelElementModel(STModel stModel) {
		return new InputLabelElementModel(db, stModel);
	}

	public InputLabelElementModel newInputLabelElementModel(Node node) {
		return new InputLabelElementModel(db, node);
	}

	public Stream<InputLabelElementModel> findAllInputLabelElementModel() {
		return db.findAllSTModelByStTemplate(InputLabelElementModel.stTemplateUuid)
				.map(stModel -> new InputLabelElementModel(db, stModel));
	}

	public InputLabelElementModel findInputLabelElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new InputLabelElementModel(db, uuid) : new InputLabelElementModel(db, stModel);
	}


	public LinearProgressModel newLinearProgressModel() {
		return new LinearProgressModel(db);
	}

	public LinearProgressModel newLinearProgressModel(STModel stModel) {
		return new LinearProgressModel(db, stModel);
	}

	public LinearProgressModel newLinearProgressModel(Node node) {
		return new LinearProgressModel(db, node);
	}

	public Stream<LinearProgressModel> findAllLinearProgressModel() {
		return db.findAllSTModelByStTemplate(LinearProgressModel.stTemplateUuid)
				.map(stModel -> new LinearProgressModel(db, stModel));
	}

	public LinearProgressModel findLinearProgressModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new LinearProgressModel(db, uuid) : new LinearProgressModel(db, stModel);
	}


	public LinearProgressImportModel newLinearProgressImportModel() {
		return new LinearProgressImportModel(db);
	}

	public LinearProgressImportModel newLinearProgressImportModel(STModel stModel) {
		return new LinearProgressImportModel(db, stModel);
	}

	public LinearProgressImportModel newLinearProgressImportModel(Node node) {
		return new LinearProgressImportModel(db, node);
	}

	public Stream<LinearProgressImportModel> findAllLinearProgressImportModel() {
		return db.findAllSTModelByStTemplate(LinearProgressImportModel.stTemplateUuid)
				.map(stModel -> new LinearProgressImportModel(db, stModel));
	}

	public LinearProgressImportModel findLinearProgressImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new LinearProgressImportModel(db, uuid) : new LinearProgressImportModel(db, stModel);
	}


	public LinearProgressElementModel newLinearProgressElementModel() {
		return new LinearProgressElementModel(db);
	}

	public LinearProgressElementModel newLinearProgressElementModel(STModel stModel) {
		return new LinearProgressElementModel(db, stModel);
	}

	public LinearProgressElementModel newLinearProgressElementModel(Node node) {
		return new LinearProgressElementModel(db, node);
	}

	public Stream<LinearProgressElementModel> findAllLinearProgressElementModel() {
		return db.findAllSTModelByStTemplate(LinearProgressElementModel.stTemplateUuid)
				.map(stModel -> new LinearProgressElementModel(db, stModel));
	}

	public LinearProgressElementModel findLinearProgressElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new LinearProgressElementModel(db, uuid) : new LinearProgressElementModel(db, stModel);
	}


	public LinkModel newLinkModel() {
		return new LinkModel(db);
	}

	public LinkModel newLinkModel(STModel stModel) {
		return new LinkModel(db, stModel);
	}

	public LinkModel newLinkModel(Node node) {
		return new LinkModel(db, node);
	}

	public Stream<LinkModel> findAllLinkModel() {
		return db.findAllSTModelByStTemplate(LinkModel.stTemplateUuid)
				.map(stModel -> new LinkModel(db, stModel));
	}

	public LinkModel findLinkModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new LinkModel(db, uuid) : new LinkModel(db, stModel);
	}


	public LinkImportModel newLinkImportModel() {
		return new LinkImportModel(db);
	}

	public LinkImportModel newLinkImportModel(STModel stModel) {
		return new LinkImportModel(db, stModel);
	}

	public LinkImportModel newLinkImportModel(Node node) {
		return new LinkImportModel(db, node);
	}

	public Stream<LinkImportModel> findAllLinkImportModel() {
		return db.findAllSTModelByStTemplate(LinkImportModel.stTemplateUuid)
				.map(stModel -> new LinkImportModel(db, stModel));
	}

	public LinkImportModel findLinkImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new LinkImportModel(db, uuid) : new LinkImportModel(db, stModel);
	}


	public LinkElementModel newLinkElementModel() {
		return new LinkElementModel(db);
	}

	public LinkElementModel newLinkElementModel(STModel stModel) {
		return new LinkElementModel(db, stModel);
	}

	public LinkElementModel newLinkElementModel(Node node) {
		return new LinkElementModel(db, node);
	}

	public Stream<LinkElementModel> findAllLinkElementModel() {
		return db.findAllSTModelByStTemplate(LinkElementModel.stTemplateUuid)
				.map(stModel -> new LinkElementModel(db, stModel));
	}

	public LinkElementModel findLinkElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new LinkElementModel(db, uuid) : new LinkElementModel(db, stModel);
	}


	public ListModel newListModel() {
		return new ListModel(db);
	}

	public ListModel newListModel(STModel stModel) {
		return new ListModel(db, stModel);
	}

	public ListModel newListModel(Node node) {
		return new ListModel(db, node);
	}

	public Stream<ListModel> findAllListModel() {
		return db.findAllSTModelByStTemplate(ListModel.stTemplateUuid)
				.map(stModel -> new ListModel(db, stModel));
	}

	public ListModel findListModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListModel(db, uuid) : new ListModel(db, stModel);
	}


	public ListImportModel newListImportModel() {
		return new ListImportModel(db);
	}

	public ListImportModel newListImportModel(STModel stModel) {
		return new ListImportModel(db, stModel);
	}

	public ListImportModel newListImportModel(Node node) {
		return new ListImportModel(db, node);
	}

	public Stream<ListImportModel> findAllListImportModel() {
		return db.findAllSTModelByStTemplate(ListImportModel.stTemplateUuid)
				.map(stModel -> new ListImportModel(db, stModel));
	}

	public ListImportModel findListImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListImportModel(db, uuid) : new ListImportModel(db, stModel);
	}


	public ListElementModel newListElementModel() {
		return new ListElementModel(db);
	}

	public ListElementModel newListElementModel(STModel stModel) {
		return new ListElementModel(db, stModel);
	}

	public ListElementModel newListElementModel(Node node) {
		return new ListElementModel(db, node);
	}

	public Stream<ListElementModel> findAllListElementModel() {
		return db.findAllSTModelByStTemplate(ListElementModel.stTemplateUuid)
				.map(stModel -> new ListElementModel(db, stModel));
	}

	public ListElementModel findListElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListElementModel(db, uuid) : new ListElementModel(db, stModel);
	}


	public ListItemModel newListItemModel() {
		return new ListItemModel(db);
	}

	public ListItemModel newListItemModel(STModel stModel) {
		return new ListItemModel(db, stModel);
	}

	public ListItemModel newListItemModel(Node node) {
		return new ListItemModel(db, node);
	}

	public Stream<ListItemModel> findAllListItemModel() {
		return db.findAllSTModelByStTemplate(ListItemModel.stTemplateUuid)
				.map(stModel -> new ListItemModel(db, stModel));
	}

	public ListItemModel findListItemModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemModel(db, uuid) : new ListItemModel(db, stModel);
	}


	public ListItemImportModel newListItemImportModel() {
		return new ListItemImportModel(db);
	}

	public ListItemImportModel newListItemImportModel(STModel stModel) {
		return new ListItemImportModel(db, stModel);
	}

	public ListItemImportModel newListItemImportModel(Node node) {
		return new ListItemImportModel(db, node);
	}

	public Stream<ListItemImportModel> findAllListItemImportModel() {
		return db.findAllSTModelByStTemplate(ListItemImportModel.stTemplateUuid)
				.map(stModel -> new ListItemImportModel(db, stModel));
	}

	public ListItemImportModel findListItemImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemImportModel(db, uuid) : new ListItemImportModel(db, stModel);
	}


	public ListItemElementModel newListItemElementModel() {
		return new ListItemElementModel(db);
	}

	public ListItemElementModel newListItemElementModel(STModel stModel) {
		return new ListItemElementModel(db, stModel);
	}

	public ListItemElementModel newListItemElementModel(Node node) {
		return new ListItemElementModel(db, node);
	}

	public Stream<ListItemElementModel> findAllListItemElementModel() {
		return db.findAllSTModelByStTemplate(ListItemElementModel.stTemplateUuid)
				.map(stModel -> new ListItemElementModel(db, stModel));
	}

	public ListItemElementModel findListItemElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemElementModel(db, uuid) : new ListItemElementModel(db, stModel);
	}


	public ListItemAvatarModel newListItemAvatarModel() {
		return new ListItemAvatarModel(db);
	}

	public ListItemAvatarModel newListItemAvatarModel(STModel stModel) {
		return new ListItemAvatarModel(db, stModel);
	}

	public ListItemAvatarModel newListItemAvatarModel(Node node) {
		return new ListItemAvatarModel(db, node);
	}

	public Stream<ListItemAvatarModel> findAllListItemAvatarModel() {
		return db.findAllSTModelByStTemplate(ListItemAvatarModel.stTemplateUuid)
				.map(stModel -> new ListItemAvatarModel(db, stModel));
	}

	public ListItemAvatarModel findListItemAvatarModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemAvatarModel(db, uuid) : new ListItemAvatarModel(db, stModel);
	}


	public ListItemAvatarImportModel newListItemAvatarImportModel() {
		return new ListItemAvatarImportModel(db);
	}

	public ListItemAvatarImportModel newListItemAvatarImportModel(STModel stModel) {
		return new ListItemAvatarImportModel(db, stModel);
	}

	public ListItemAvatarImportModel newListItemAvatarImportModel(Node node) {
		return new ListItemAvatarImportModel(db, node);
	}

	public Stream<ListItemAvatarImportModel> findAllListItemAvatarImportModel() {
		return db.findAllSTModelByStTemplate(ListItemAvatarImportModel.stTemplateUuid)
				.map(stModel -> new ListItemAvatarImportModel(db, stModel));
	}

	public ListItemAvatarImportModel findListItemAvatarImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemAvatarImportModel(db, uuid) : new ListItemAvatarImportModel(db, stModel);
	}


	public ListItemAvatarElementModel newListItemAvatarElementModel() {
		return new ListItemAvatarElementModel(db);
	}

	public ListItemAvatarElementModel newListItemAvatarElementModel(STModel stModel) {
		return new ListItemAvatarElementModel(db, stModel);
	}

	public ListItemAvatarElementModel newListItemAvatarElementModel(Node node) {
		return new ListItemAvatarElementModel(db, node);
	}

	public Stream<ListItemAvatarElementModel> findAllListItemAvatarElementModel() {
		return db.findAllSTModelByStTemplate(ListItemAvatarElementModel.stTemplateUuid)
				.map(stModel -> new ListItemAvatarElementModel(db, stModel));
	}

	public ListItemAvatarElementModel findListItemAvatarElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemAvatarElementModel(db, uuid) : new ListItemAvatarElementModel(db, stModel);
	}


	public ListItemIconModel newListItemIconModel() {
		return new ListItemIconModel(db);
	}

	public ListItemIconModel newListItemIconModel(STModel stModel) {
		return new ListItemIconModel(db, stModel);
	}

	public ListItemIconModel newListItemIconModel(Node node) {
		return new ListItemIconModel(db, node);
	}

	public Stream<ListItemIconModel> findAllListItemIconModel() {
		return db.findAllSTModelByStTemplate(ListItemIconModel.stTemplateUuid)
				.map(stModel -> new ListItemIconModel(db, stModel));
	}

	public ListItemIconModel findListItemIconModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemIconModel(db, uuid) : new ListItemIconModel(db, stModel);
	}


	public ListItemIconImportModel newListItemIconImportModel() {
		return new ListItemIconImportModel(db);
	}

	public ListItemIconImportModel newListItemIconImportModel(STModel stModel) {
		return new ListItemIconImportModel(db, stModel);
	}

	public ListItemIconImportModel newListItemIconImportModel(Node node) {
		return new ListItemIconImportModel(db, node);
	}

	public Stream<ListItemIconImportModel> findAllListItemIconImportModel() {
		return db.findAllSTModelByStTemplate(ListItemIconImportModel.stTemplateUuid)
				.map(stModel -> new ListItemIconImportModel(db, stModel));
	}

	public ListItemIconImportModel findListItemIconImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemIconImportModel(db, uuid) : new ListItemIconImportModel(db, stModel);
	}


	public ListItemIconElementModel newListItemIconElementModel() {
		return new ListItemIconElementModel(db);
	}

	public ListItemIconElementModel newListItemIconElementModel(STModel stModel) {
		return new ListItemIconElementModel(db, stModel);
	}

	public ListItemIconElementModel newListItemIconElementModel(Node node) {
		return new ListItemIconElementModel(db, node);
	}

	public Stream<ListItemIconElementModel> findAllListItemIconElementModel() {
		return db.findAllSTModelByStTemplate(ListItemIconElementModel.stTemplateUuid)
				.map(stModel -> new ListItemIconElementModel(db, stModel));
	}

	public ListItemIconElementModel findListItemIconElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemIconElementModel(db, uuid) : new ListItemIconElementModel(db, stModel);
	}


	public ListItemSecondaryActionModel newListItemSecondaryActionModel() {
		return new ListItemSecondaryActionModel(db);
	}

	public ListItemSecondaryActionModel newListItemSecondaryActionModel(STModel stModel) {
		return new ListItemSecondaryActionModel(db, stModel);
	}

	public ListItemSecondaryActionModel newListItemSecondaryActionModel(Node node) {
		return new ListItemSecondaryActionModel(db, node);
	}

	public Stream<ListItemSecondaryActionModel> findAllListItemSecondaryActionModel() {
		return db.findAllSTModelByStTemplate(ListItemSecondaryActionModel.stTemplateUuid)
				.map(stModel -> new ListItemSecondaryActionModel(db, stModel));
	}

	public ListItemSecondaryActionModel findListItemSecondaryActionModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemSecondaryActionModel(db, uuid) : new ListItemSecondaryActionModel(db, stModel);
	}


	public ListItemSecondaryActionImportModel newListItemSecondaryActionImportModel() {
		return new ListItemSecondaryActionImportModel(db);
	}

	public ListItemSecondaryActionImportModel newListItemSecondaryActionImportModel(STModel stModel) {
		return new ListItemSecondaryActionImportModel(db, stModel);
	}

	public ListItemSecondaryActionImportModel newListItemSecondaryActionImportModel(Node node) {
		return new ListItemSecondaryActionImportModel(db, node);
	}

	public Stream<ListItemSecondaryActionImportModel> findAllListItemSecondaryActionImportModel() {
		return db.findAllSTModelByStTemplate(ListItemSecondaryActionImportModel.stTemplateUuid)
				.map(stModel -> new ListItemSecondaryActionImportModel(db, stModel));
	}

	public ListItemSecondaryActionImportModel findListItemSecondaryActionImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemSecondaryActionImportModel(db, uuid) : new ListItemSecondaryActionImportModel(db, stModel);
	}


	public ListItemSecondaryActionElementModel newListItemSecondaryActionElementModel() {
		return new ListItemSecondaryActionElementModel(db);
	}

	public ListItemSecondaryActionElementModel newListItemSecondaryActionElementModel(STModel stModel) {
		return new ListItemSecondaryActionElementModel(db, stModel);
	}

	public ListItemSecondaryActionElementModel newListItemSecondaryActionElementModel(Node node) {
		return new ListItemSecondaryActionElementModel(db, node);
	}

	public Stream<ListItemSecondaryActionElementModel> findAllListItemSecondaryActionElementModel() {
		return db.findAllSTModelByStTemplate(ListItemSecondaryActionElementModel.stTemplateUuid)
				.map(stModel -> new ListItemSecondaryActionElementModel(db, stModel));
	}

	public ListItemSecondaryActionElementModel findListItemSecondaryActionElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemSecondaryActionElementModel(db, uuid) : new ListItemSecondaryActionElementModel(db, stModel);
	}


	public ListItemTextModel newListItemTextModel() {
		return new ListItemTextModel(db);
	}

	public ListItemTextModel newListItemTextModel(STModel stModel) {
		return new ListItemTextModel(db, stModel);
	}

	public ListItemTextModel newListItemTextModel(Node node) {
		return new ListItemTextModel(db, node);
	}

	public Stream<ListItemTextModel> findAllListItemTextModel() {
		return db.findAllSTModelByStTemplate(ListItemTextModel.stTemplateUuid)
				.map(stModel -> new ListItemTextModel(db, stModel));
	}

	public ListItemTextModel findListItemTextModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemTextModel(db, uuid) : new ListItemTextModel(db, stModel);
	}


	public ListItemTextImportModel newListItemTextImportModel() {
		return new ListItemTextImportModel(db);
	}

	public ListItemTextImportModel newListItemTextImportModel(STModel stModel) {
		return new ListItemTextImportModel(db, stModel);
	}

	public ListItemTextImportModel newListItemTextImportModel(Node node) {
		return new ListItemTextImportModel(db, node);
	}

	public Stream<ListItemTextImportModel> findAllListItemTextImportModel() {
		return db.findAllSTModelByStTemplate(ListItemTextImportModel.stTemplateUuid)
				.map(stModel -> new ListItemTextImportModel(db, stModel));
	}

	public ListItemTextImportModel findListItemTextImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemTextImportModel(db, uuid) : new ListItemTextImportModel(db, stModel);
	}


	public ListItemTextElementModel newListItemTextElementModel() {
		return new ListItemTextElementModel(db);
	}

	public ListItemTextElementModel newListItemTextElementModel(STModel stModel) {
		return new ListItemTextElementModel(db, stModel);
	}

	public ListItemTextElementModel newListItemTextElementModel(Node node) {
		return new ListItemTextElementModel(db, node);
	}

	public Stream<ListItemTextElementModel> findAllListItemTextElementModel() {
		return db.findAllSTModelByStTemplate(ListItemTextElementModel.stTemplateUuid)
				.map(stModel -> new ListItemTextElementModel(db, stModel));
	}

	public ListItemTextElementModel findListItemTextElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListItemTextElementModel(db, uuid) : new ListItemTextElementModel(db, stModel);
	}


	public ListSubheaderModel newListSubheaderModel() {
		return new ListSubheaderModel(db);
	}

	public ListSubheaderModel newListSubheaderModel(STModel stModel) {
		return new ListSubheaderModel(db, stModel);
	}

	public ListSubheaderModel newListSubheaderModel(Node node) {
		return new ListSubheaderModel(db, node);
	}

	public Stream<ListSubheaderModel> findAllListSubheaderModel() {
		return db.findAllSTModelByStTemplate(ListSubheaderModel.stTemplateUuid)
				.map(stModel -> new ListSubheaderModel(db, stModel));
	}

	public ListSubheaderModel findListSubheaderModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListSubheaderModel(db, uuid) : new ListSubheaderModel(db, stModel);
	}


	public ListSubheaderImportModel newListSubheaderImportModel() {
		return new ListSubheaderImportModel(db);
	}

	public ListSubheaderImportModel newListSubheaderImportModel(STModel stModel) {
		return new ListSubheaderImportModel(db, stModel);
	}

	public ListSubheaderImportModel newListSubheaderImportModel(Node node) {
		return new ListSubheaderImportModel(db, node);
	}

	public Stream<ListSubheaderImportModel> findAllListSubheaderImportModel() {
		return db.findAllSTModelByStTemplate(ListSubheaderImportModel.stTemplateUuid)
				.map(stModel -> new ListSubheaderImportModel(db, stModel));
	}

	public ListSubheaderImportModel findListSubheaderImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListSubheaderImportModel(db, uuid) : new ListSubheaderImportModel(db, stModel);
	}


	public ListSubheaderElementModel newListSubheaderElementModel() {
		return new ListSubheaderElementModel(db);
	}

	public ListSubheaderElementModel newListSubheaderElementModel(STModel stModel) {
		return new ListSubheaderElementModel(db, stModel);
	}

	public ListSubheaderElementModel newListSubheaderElementModel(Node node) {
		return new ListSubheaderElementModel(db, node);
	}

	public Stream<ListSubheaderElementModel> findAllListSubheaderElementModel() {
		return db.findAllSTModelByStTemplate(ListSubheaderElementModel.stTemplateUuid)
				.map(stModel -> new ListSubheaderElementModel(db, stModel));
	}

	public ListSubheaderElementModel findListSubheaderElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ListSubheaderElementModel(db, uuid) : new ListSubheaderElementModel(db, stModel);
	}


	public MaterialUIComponentModel newMaterialUIComponentModel() {
		return new MaterialUIComponentModel(db);
	}

	public MaterialUIComponentModel newMaterialUIComponentModel(STModel stModel) {
		return new MaterialUIComponentModel(db, stModel);
	}

	public MaterialUIComponentModel newMaterialUIComponentModel(Node node) {
		return new MaterialUIComponentModel(db, node);
	}

	public Stream<MaterialUIComponentModel> findAllMaterialUIComponentModel() {
		return db.findAllSTModelByStTemplate(MaterialUIComponentModel.stTemplateUuid)
				.map(stModel -> new MaterialUIComponentModel(db, stModel));
	}

	public MaterialUIComponentModel findMaterialUIComponentModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MaterialUIComponentModel(db, uuid) : new MaterialUIComponentModel(db, stModel);
	}


	public StyleClassModel newStyleClassModel() {
		return new StyleClassModel(db);
	}

	public StyleClassModel newStyleClassModel(STModel stModel) {
		return new StyleClassModel(db, stModel);
	}

	public StyleClassModel newStyleClassModel(Node node) {
		return new StyleClassModel(db, node);
	}

	public Stream<StyleClassModel> findAllStyleClassModel() {
		return db.findAllSTModelByStTemplate(StyleClassModel.stTemplateUuid)
				.map(stModel -> new StyleClassModel(db, stModel));
	}

	public StyleClassModel findStyleClassModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StyleClassModel(db, uuid) : new StyleClassModel(db, stModel);
	}


	public MenuModel newMenuModel() {
		return new MenuModel(db);
	}

	public MenuModel newMenuModel(STModel stModel) {
		return new MenuModel(db, stModel);
	}

	public MenuModel newMenuModel(Node node) {
		return new MenuModel(db, node);
	}

	public Stream<MenuModel> findAllMenuModel() {
		return db.findAllSTModelByStTemplate(MenuModel.stTemplateUuid)
				.map(stModel -> new MenuModel(db, stModel));
	}

	public MenuModel findMenuModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MenuModel(db, uuid) : new MenuModel(db, stModel);
	}


	public MenuImportModel newMenuImportModel() {
		return new MenuImportModel(db);
	}

	public MenuImportModel newMenuImportModel(STModel stModel) {
		return new MenuImportModel(db, stModel);
	}

	public MenuImportModel newMenuImportModel(Node node) {
		return new MenuImportModel(db, node);
	}

	public Stream<MenuImportModel> findAllMenuImportModel() {
		return db.findAllSTModelByStTemplate(MenuImportModel.stTemplateUuid)
				.map(stModel -> new MenuImportModel(db, stModel));
	}

	public MenuImportModel findMenuImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MenuImportModel(db, uuid) : new MenuImportModel(db, stModel);
	}


	public MenuElementModel newMenuElementModel() {
		return new MenuElementModel(db);
	}

	public MenuElementModel newMenuElementModel(STModel stModel) {
		return new MenuElementModel(db, stModel);
	}

	public MenuElementModel newMenuElementModel(Node node) {
		return new MenuElementModel(db, node);
	}

	public Stream<MenuElementModel> findAllMenuElementModel() {
		return db.findAllSTModelByStTemplate(MenuElementModel.stTemplateUuid)
				.map(stModel -> new MenuElementModel(db, stModel));
	}

	public MenuElementModel findMenuElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MenuElementModel(db, uuid) : new MenuElementModel(db, stModel);
	}


	public MenuItemModel newMenuItemModel() {
		return new MenuItemModel(db);
	}

	public MenuItemModel newMenuItemModel(STModel stModel) {
		return new MenuItemModel(db, stModel);
	}

	public MenuItemModel newMenuItemModel(Node node) {
		return new MenuItemModel(db, node);
	}

	public Stream<MenuItemModel> findAllMenuItemModel() {
		return db.findAllSTModelByStTemplate(MenuItemModel.stTemplateUuid)
				.map(stModel -> new MenuItemModel(db, stModel));
	}

	public MenuItemModel findMenuItemModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MenuItemModel(db, uuid) : new MenuItemModel(db, stModel);
	}


	public MenuItemImportModel newMenuItemImportModel() {
		return new MenuItemImportModel(db);
	}

	public MenuItemImportModel newMenuItemImportModel(STModel stModel) {
		return new MenuItemImportModel(db, stModel);
	}

	public MenuItemImportModel newMenuItemImportModel(Node node) {
		return new MenuItemImportModel(db, node);
	}

	public Stream<MenuItemImportModel> findAllMenuItemImportModel() {
		return db.findAllSTModelByStTemplate(MenuItemImportModel.stTemplateUuid)
				.map(stModel -> new MenuItemImportModel(db, stModel));
	}

	public MenuItemImportModel findMenuItemImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MenuItemImportModel(db, uuid) : new MenuItemImportModel(db, stModel);
	}


	public MenuItemElementModel newMenuItemElementModel() {
		return new MenuItemElementModel(db);
	}

	public MenuItemElementModel newMenuItemElementModel(STModel stModel) {
		return new MenuItemElementModel(db, stModel);
	}

	public MenuItemElementModel newMenuItemElementModel(Node node) {
		return new MenuItemElementModel(db, node);
	}

	public Stream<MenuItemElementModel> findAllMenuItemElementModel() {
		return db.findAllSTModelByStTemplate(MenuItemElementModel.stTemplateUuid)
				.map(stModel -> new MenuItemElementModel(db, stModel));
	}

	public MenuItemElementModel findMenuItemElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MenuItemElementModel(db, uuid) : new MenuItemElementModel(db, stModel);
	}


	public MenuListModel newMenuListModel() {
		return new MenuListModel(db);
	}

	public MenuListModel newMenuListModel(STModel stModel) {
		return new MenuListModel(db, stModel);
	}

	public MenuListModel newMenuListModel(Node node) {
		return new MenuListModel(db, node);
	}

	public Stream<MenuListModel> findAllMenuListModel() {
		return db.findAllSTModelByStTemplate(MenuListModel.stTemplateUuid)
				.map(stModel -> new MenuListModel(db, stModel));
	}

	public MenuListModel findMenuListModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MenuListModel(db, uuid) : new MenuListModel(db, stModel);
	}


	public MenuListImportModel newMenuListImportModel() {
		return new MenuListImportModel(db);
	}

	public MenuListImportModel newMenuListImportModel(STModel stModel) {
		return new MenuListImportModel(db, stModel);
	}

	public MenuListImportModel newMenuListImportModel(Node node) {
		return new MenuListImportModel(db, node);
	}

	public Stream<MenuListImportModel> findAllMenuListImportModel() {
		return db.findAllSTModelByStTemplate(MenuListImportModel.stTemplateUuid)
				.map(stModel -> new MenuListImportModel(db, stModel));
	}

	public MenuListImportModel findMenuListImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MenuListImportModel(db, uuid) : new MenuListImportModel(db, stModel);
	}


	public MenuListElementModel newMenuListElementModel() {
		return new MenuListElementModel(db);
	}

	public MenuListElementModel newMenuListElementModel(STModel stModel) {
		return new MenuListElementModel(db, stModel);
	}

	public MenuListElementModel newMenuListElementModel(Node node) {
		return new MenuListElementModel(db, node);
	}

	public Stream<MenuListElementModel> findAllMenuListElementModel() {
		return db.findAllSTModelByStTemplate(MenuListElementModel.stTemplateUuid)
				.map(stModel -> new MenuListElementModel(db, stModel));
	}

	public MenuListElementModel findMenuListElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MenuListElementModel(db, uuid) : new MenuListElementModel(db, stModel);
	}


	public MobileStepperModel newMobileStepperModel() {
		return new MobileStepperModel(db);
	}

	public MobileStepperModel newMobileStepperModel(STModel stModel) {
		return new MobileStepperModel(db, stModel);
	}

	public MobileStepperModel newMobileStepperModel(Node node) {
		return new MobileStepperModel(db, node);
	}

	public Stream<MobileStepperModel> findAllMobileStepperModel() {
		return db.findAllSTModelByStTemplate(MobileStepperModel.stTemplateUuid)
				.map(stModel -> new MobileStepperModel(db, stModel));
	}

	public MobileStepperModel findMobileStepperModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MobileStepperModel(db, uuid) : new MobileStepperModel(db, stModel);
	}


	public MobileStepperImportModel newMobileStepperImportModel() {
		return new MobileStepperImportModel(db);
	}

	public MobileStepperImportModel newMobileStepperImportModel(STModel stModel) {
		return new MobileStepperImportModel(db, stModel);
	}

	public MobileStepperImportModel newMobileStepperImportModel(Node node) {
		return new MobileStepperImportModel(db, node);
	}

	public Stream<MobileStepperImportModel> findAllMobileStepperImportModel() {
		return db.findAllSTModelByStTemplate(MobileStepperImportModel.stTemplateUuid)
				.map(stModel -> new MobileStepperImportModel(db, stModel));
	}

	public MobileStepperImportModel findMobileStepperImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MobileStepperImportModel(db, uuid) : new MobileStepperImportModel(db, stModel);
	}


	public MobileStepperElementModel newMobileStepperElementModel() {
		return new MobileStepperElementModel(db);
	}

	public MobileStepperElementModel newMobileStepperElementModel(STModel stModel) {
		return new MobileStepperElementModel(db, stModel);
	}

	public MobileStepperElementModel newMobileStepperElementModel(Node node) {
		return new MobileStepperElementModel(db, node);
	}

	public Stream<MobileStepperElementModel> findAllMobileStepperElementModel() {
		return db.findAllSTModelByStTemplate(MobileStepperElementModel.stTemplateUuid)
				.map(stModel -> new MobileStepperElementModel(db, stModel));
	}

	public MobileStepperElementModel findMobileStepperElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MobileStepperElementModel(db, uuid) : new MobileStepperElementModel(db, stModel);
	}


	public ModalModel newModalModel() {
		return new ModalModel(db);
	}

	public ModalModel newModalModel(STModel stModel) {
		return new ModalModel(db, stModel);
	}

	public ModalModel newModalModel(Node node) {
		return new ModalModel(db, node);
	}

	public Stream<ModalModel> findAllModalModel() {
		return db.findAllSTModelByStTemplate(ModalModel.stTemplateUuid)
				.map(stModel -> new ModalModel(db, stModel));
	}

	public ModalModel findModalModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ModalModel(db, uuid) : new ModalModel(db, stModel);
	}


	public ModalImportModel newModalImportModel() {
		return new ModalImportModel(db);
	}

	public ModalImportModel newModalImportModel(STModel stModel) {
		return new ModalImportModel(db, stModel);
	}

	public ModalImportModel newModalImportModel(Node node) {
		return new ModalImportModel(db, node);
	}

	public Stream<ModalImportModel> findAllModalImportModel() {
		return db.findAllSTModelByStTemplate(ModalImportModel.stTemplateUuid)
				.map(stModel -> new ModalImportModel(db, stModel));
	}

	public ModalImportModel findModalImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ModalImportModel(db, uuid) : new ModalImportModel(db, stModel);
	}


	public ModalElementModel newModalElementModel() {
		return new ModalElementModel(db);
	}

	public ModalElementModel newModalElementModel(STModel stModel) {
		return new ModalElementModel(db, stModel);
	}

	public ModalElementModel newModalElementModel(Node node) {
		return new ModalElementModel(db, node);
	}

	public Stream<ModalElementModel> findAllModalElementModel() {
		return db.findAllSTModelByStTemplate(ModalElementModel.stTemplateUuid)
				.map(stModel -> new ModalElementModel(db, stModel));
	}

	public ModalElementModel findModalElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ModalElementModel(db, uuid) : new ModalElementModel(db, stModel);
	}


	public NativeSelectModel newNativeSelectModel() {
		return new NativeSelectModel(db);
	}

	public NativeSelectModel newNativeSelectModel(STModel stModel) {
		return new NativeSelectModel(db, stModel);
	}

	public NativeSelectModel newNativeSelectModel(Node node) {
		return new NativeSelectModel(db, node);
	}

	public Stream<NativeSelectModel> findAllNativeSelectModel() {
		return db.findAllSTModelByStTemplate(NativeSelectModel.stTemplateUuid)
				.map(stModel -> new NativeSelectModel(db, stModel));
	}

	public NativeSelectModel findNativeSelectModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NativeSelectModel(db, uuid) : new NativeSelectModel(db, stModel);
	}


	public NativeSelectImportModel newNativeSelectImportModel() {
		return new NativeSelectImportModel(db);
	}

	public NativeSelectImportModel newNativeSelectImportModel(STModel stModel) {
		return new NativeSelectImportModel(db, stModel);
	}

	public NativeSelectImportModel newNativeSelectImportModel(Node node) {
		return new NativeSelectImportModel(db, node);
	}

	public Stream<NativeSelectImportModel> findAllNativeSelectImportModel() {
		return db.findAllSTModelByStTemplate(NativeSelectImportModel.stTemplateUuid)
				.map(stModel -> new NativeSelectImportModel(db, stModel));
	}

	public NativeSelectImportModel findNativeSelectImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NativeSelectImportModel(db, uuid) : new NativeSelectImportModel(db, stModel);
	}


	public NativeSelectElementModel newNativeSelectElementModel() {
		return new NativeSelectElementModel(db);
	}

	public NativeSelectElementModel newNativeSelectElementModel(STModel stModel) {
		return new NativeSelectElementModel(db, stModel);
	}

	public NativeSelectElementModel newNativeSelectElementModel(Node node) {
		return new NativeSelectElementModel(db, node);
	}

	public Stream<NativeSelectElementModel> findAllNativeSelectElementModel() {
		return db.findAllSTModelByStTemplate(NativeSelectElementModel.stTemplateUuid)
				.map(stModel -> new NativeSelectElementModel(db, stModel));
	}

	public NativeSelectElementModel findNativeSelectElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NativeSelectElementModel(db, uuid) : new NativeSelectElementModel(db, stModel);
	}


	public NoSsrModel newNoSsrModel() {
		return new NoSsrModel(db);
	}

	public NoSsrModel newNoSsrModel(STModel stModel) {
		return new NoSsrModel(db, stModel);
	}

	public NoSsrModel newNoSsrModel(Node node) {
		return new NoSsrModel(db, node);
	}

	public Stream<NoSsrModel> findAllNoSsrModel() {
		return db.findAllSTModelByStTemplate(NoSsrModel.stTemplateUuid)
				.map(stModel -> new NoSsrModel(db, stModel));
	}

	public NoSsrModel findNoSsrModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NoSsrModel(db, uuid) : new NoSsrModel(db, stModel);
	}


	public NoSsrImportModel newNoSsrImportModel() {
		return new NoSsrImportModel(db);
	}

	public NoSsrImportModel newNoSsrImportModel(STModel stModel) {
		return new NoSsrImportModel(db, stModel);
	}

	public NoSsrImportModel newNoSsrImportModel(Node node) {
		return new NoSsrImportModel(db, node);
	}

	public Stream<NoSsrImportModel> findAllNoSsrImportModel() {
		return db.findAllSTModelByStTemplate(NoSsrImportModel.stTemplateUuid)
				.map(stModel -> new NoSsrImportModel(db, stModel));
	}

	public NoSsrImportModel findNoSsrImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NoSsrImportModel(db, uuid) : new NoSsrImportModel(db, stModel);
	}


	public NoSsrElementModel newNoSsrElementModel() {
		return new NoSsrElementModel(db);
	}

	public NoSsrElementModel newNoSsrElementModel(STModel stModel) {
		return new NoSsrElementModel(db, stModel);
	}

	public NoSsrElementModel newNoSsrElementModel(Node node) {
		return new NoSsrElementModel(db, node);
	}

	public Stream<NoSsrElementModel> findAllNoSsrElementModel() {
		return db.findAllSTModelByStTemplate(NoSsrElementModel.stTemplateUuid)
				.map(stModel -> new NoSsrElementModel(db, stModel));
	}

	public NoSsrElementModel findNoSsrElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new NoSsrElementModel(db, uuid) : new NoSsrElementModel(db, stModel);
	}


	public OutlinedInputModel newOutlinedInputModel() {
		return new OutlinedInputModel(db);
	}

	public OutlinedInputModel newOutlinedInputModel(STModel stModel) {
		return new OutlinedInputModel(db, stModel);
	}

	public OutlinedInputModel newOutlinedInputModel(Node node) {
		return new OutlinedInputModel(db, node);
	}

	public Stream<OutlinedInputModel> findAllOutlinedInputModel() {
		return db.findAllSTModelByStTemplate(OutlinedInputModel.stTemplateUuid)
				.map(stModel -> new OutlinedInputModel(db, stModel));
	}

	public OutlinedInputModel findOutlinedInputModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new OutlinedInputModel(db, uuid) : new OutlinedInputModel(db, stModel);
	}


	public OutlinedInputImportModel newOutlinedInputImportModel() {
		return new OutlinedInputImportModel(db);
	}

	public OutlinedInputImportModel newOutlinedInputImportModel(STModel stModel) {
		return new OutlinedInputImportModel(db, stModel);
	}

	public OutlinedInputImportModel newOutlinedInputImportModel(Node node) {
		return new OutlinedInputImportModel(db, node);
	}

	public Stream<OutlinedInputImportModel> findAllOutlinedInputImportModel() {
		return db.findAllSTModelByStTemplate(OutlinedInputImportModel.stTemplateUuid)
				.map(stModel -> new OutlinedInputImportModel(db, stModel));
	}

	public OutlinedInputImportModel findOutlinedInputImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new OutlinedInputImportModel(db, uuid) : new OutlinedInputImportModel(db, stModel);
	}


	public OutlinedInputElementModel newOutlinedInputElementModel() {
		return new OutlinedInputElementModel(db);
	}

	public OutlinedInputElementModel newOutlinedInputElementModel(STModel stModel) {
		return new OutlinedInputElementModel(db, stModel);
	}

	public OutlinedInputElementModel newOutlinedInputElementModel(Node node) {
		return new OutlinedInputElementModel(db, node);
	}

	public Stream<OutlinedInputElementModel> findAllOutlinedInputElementModel() {
		return db.findAllSTModelByStTemplate(OutlinedInputElementModel.stTemplateUuid)
				.map(stModel -> new OutlinedInputElementModel(db, stModel));
	}

	public OutlinedInputElementModel findOutlinedInputElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new OutlinedInputElementModel(db, uuid) : new OutlinedInputElementModel(db, stModel);
	}


	public PaginationModel newPaginationModel() {
		return new PaginationModel(db);
	}

	public PaginationModel newPaginationModel(STModel stModel) {
		return new PaginationModel(db, stModel);
	}

	public PaginationModel newPaginationModel(Node node) {
		return new PaginationModel(db, node);
	}

	public Stream<PaginationModel> findAllPaginationModel() {
		return db.findAllSTModelByStTemplate(PaginationModel.stTemplateUuid)
				.map(stModel -> new PaginationModel(db, stModel));
	}

	public PaginationModel findPaginationModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PaginationModel(db, uuid) : new PaginationModel(db, stModel);
	}


	public PaginationImportModel newPaginationImportModel() {
		return new PaginationImportModel(db);
	}

	public PaginationImportModel newPaginationImportModel(STModel stModel) {
		return new PaginationImportModel(db, stModel);
	}

	public PaginationImportModel newPaginationImportModel(Node node) {
		return new PaginationImportModel(db, node);
	}

	public Stream<PaginationImportModel> findAllPaginationImportModel() {
		return db.findAllSTModelByStTemplate(PaginationImportModel.stTemplateUuid)
				.map(stModel -> new PaginationImportModel(db, stModel));
	}

	public PaginationImportModel findPaginationImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PaginationImportModel(db, uuid) : new PaginationImportModel(db, stModel);
	}


	public PaginationElementModel newPaginationElementModel() {
		return new PaginationElementModel(db);
	}

	public PaginationElementModel newPaginationElementModel(STModel stModel) {
		return new PaginationElementModel(db, stModel);
	}

	public PaginationElementModel newPaginationElementModel(Node node) {
		return new PaginationElementModel(db, node);
	}

	public Stream<PaginationElementModel> findAllPaginationElementModel() {
		return db.findAllSTModelByStTemplate(PaginationElementModel.stTemplateUuid)
				.map(stModel -> new PaginationElementModel(db, stModel));
	}

	public PaginationElementModel findPaginationElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PaginationElementModel(db, uuid) : new PaginationElementModel(db, stModel);
	}


	public PaginationItemModel newPaginationItemModel() {
		return new PaginationItemModel(db);
	}

	public PaginationItemModel newPaginationItemModel(STModel stModel) {
		return new PaginationItemModel(db, stModel);
	}

	public PaginationItemModel newPaginationItemModel(Node node) {
		return new PaginationItemModel(db, node);
	}

	public Stream<PaginationItemModel> findAllPaginationItemModel() {
		return db.findAllSTModelByStTemplate(PaginationItemModel.stTemplateUuid)
				.map(stModel -> new PaginationItemModel(db, stModel));
	}

	public PaginationItemModel findPaginationItemModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PaginationItemModel(db, uuid) : new PaginationItemModel(db, stModel);
	}


	public PaginationItemImportModel newPaginationItemImportModel() {
		return new PaginationItemImportModel(db);
	}

	public PaginationItemImportModel newPaginationItemImportModel(STModel stModel) {
		return new PaginationItemImportModel(db, stModel);
	}

	public PaginationItemImportModel newPaginationItemImportModel(Node node) {
		return new PaginationItemImportModel(db, node);
	}

	public Stream<PaginationItemImportModel> findAllPaginationItemImportModel() {
		return db.findAllSTModelByStTemplate(PaginationItemImportModel.stTemplateUuid)
				.map(stModel -> new PaginationItemImportModel(db, stModel));
	}

	public PaginationItemImportModel findPaginationItemImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PaginationItemImportModel(db, uuid) : new PaginationItemImportModel(db, stModel);
	}


	public PaginationItemElementModel newPaginationItemElementModel() {
		return new PaginationItemElementModel(db);
	}

	public PaginationItemElementModel newPaginationItemElementModel(STModel stModel) {
		return new PaginationItemElementModel(db, stModel);
	}

	public PaginationItemElementModel newPaginationItemElementModel(Node node) {
		return new PaginationItemElementModel(db, node);
	}

	public Stream<PaginationItemElementModel> findAllPaginationItemElementModel() {
		return db.findAllSTModelByStTemplate(PaginationItemElementModel.stTemplateUuid)
				.map(stModel -> new PaginationItemElementModel(db, stModel));
	}

	public PaginationItemElementModel findPaginationItemElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PaginationItemElementModel(db, uuid) : new PaginationItemElementModel(db, stModel);
	}


	public PaperModel newPaperModel() {
		return new PaperModel(db);
	}

	public PaperModel newPaperModel(STModel stModel) {
		return new PaperModel(db, stModel);
	}

	public PaperModel newPaperModel(Node node) {
		return new PaperModel(db, node);
	}

	public Stream<PaperModel> findAllPaperModel() {
		return db.findAllSTModelByStTemplate(PaperModel.stTemplateUuid)
				.map(stModel -> new PaperModel(db, stModel));
	}

	public PaperModel findPaperModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PaperModel(db, uuid) : new PaperModel(db, stModel);
	}


	public PaperImportModel newPaperImportModel() {
		return new PaperImportModel(db);
	}

	public PaperImportModel newPaperImportModel(STModel stModel) {
		return new PaperImportModel(db, stModel);
	}

	public PaperImportModel newPaperImportModel(Node node) {
		return new PaperImportModel(db, node);
	}

	public Stream<PaperImportModel> findAllPaperImportModel() {
		return db.findAllSTModelByStTemplate(PaperImportModel.stTemplateUuid)
				.map(stModel -> new PaperImportModel(db, stModel));
	}

	public PaperImportModel findPaperImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PaperImportModel(db, uuid) : new PaperImportModel(db, stModel);
	}


	public PaperElementModel newPaperElementModel() {
		return new PaperElementModel(db);
	}

	public PaperElementModel newPaperElementModel(STModel stModel) {
		return new PaperElementModel(db, stModel);
	}

	public PaperElementModel newPaperElementModel(Node node) {
		return new PaperElementModel(db, node);
	}

	public Stream<PaperElementModel> findAllPaperElementModel() {
		return db.findAllSTModelByStTemplate(PaperElementModel.stTemplateUuid)
				.map(stModel -> new PaperElementModel(db, stModel));
	}

	public PaperElementModel findPaperElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PaperElementModel(db, uuid) : new PaperElementModel(db, stModel);
	}


	public PopoverModel newPopoverModel() {
		return new PopoverModel(db);
	}

	public PopoverModel newPopoverModel(STModel stModel) {
		return new PopoverModel(db, stModel);
	}

	public PopoverModel newPopoverModel(Node node) {
		return new PopoverModel(db, node);
	}

	public Stream<PopoverModel> findAllPopoverModel() {
		return db.findAllSTModelByStTemplate(PopoverModel.stTemplateUuid)
				.map(stModel -> new PopoverModel(db, stModel));
	}

	public PopoverModel findPopoverModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PopoverModel(db, uuid) : new PopoverModel(db, stModel);
	}


	public PopoverImportModel newPopoverImportModel() {
		return new PopoverImportModel(db);
	}

	public PopoverImportModel newPopoverImportModel(STModel stModel) {
		return new PopoverImportModel(db, stModel);
	}

	public PopoverImportModel newPopoverImportModel(Node node) {
		return new PopoverImportModel(db, node);
	}

	public Stream<PopoverImportModel> findAllPopoverImportModel() {
		return db.findAllSTModelByStTemplate(PopoverImportModel.stTemplateUuid)
				.map(stModel -> new PopoverImportModel(db, stModel));
	}

	public PopoverImportModel findPopoverImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PopoverImportModel(db, uuid) : new PopoverImportModel(db, stModel);
	}


	public PopoverElementModel newPopoverElementModel() {
		return new PopoverElementModel(db);
	}

	public PopoverElementModel newPopoverElementModel(STModel stModel) {
		return new PopoverElementModel(db, stModel);
	}

	public PopoverElementModel newPopoverElementModel(Node node) {
		return new PopoverElementModel(db, node);
	}

	public Stream<PopoverElementModel> findAllPopoverElementModel() {
		return db.findAllSTModelByStTemplate(PopoverElementModel.stTemplateUuid)
				.map(stModel -> new PopoverElementModel(db, stModel));
	}

	public PopoverElementModel findPopoverElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PopoverElementModel(db, uuid) : new PopoverElementModel(db, stModel);
	}


	public PopperModel newPopperModel() {
		return new PopperModel(db);
	}

	public PopperModel newPopperModel(STModel stModel) {
		return new PopperModel(db, stModel);
	}

	public PopperModel newPopperModel(Node node) {
		return new PopperModel(db, node);
	}

	public Stream<PopperModel> findAllPopperModel() {
		return db.findAllSTModelByStTemplate(PopperModel.stTemplateUuid)
				.map(stModel -> new PopperModel(db, stModel));
	}

	public PopperModel findPopperModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PopperModel(db, uuid) : new PopperModel(db, stModel);
	}


	public PopperImportModel newPopperImportModel() {
		return new PopperImportModel(db);
	}

	public PopperImportModel newPopperImportModel(STModel stModel) {
		return new PopperImportModel(db, stModel);
	}

	public PopperImportModel newPopperImportModel(Node node) {
		return new PopperImportModel(db, node);
	}

	public Stream<PopperImportModel> findAllPopperImportModel() {
		return db.findAllSTModelByStTemplate(PopperImportModel.stTemplateUuid)
				.map(stModel -> new PopperImportModel(db, stModel));
	}

	public PopperImportModel findPopperImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PopperImportModel(db, uuid) : new PopperImportModel(db, stModel);
	}


	public PopperElementModel newPopperElementModel() {
		return new PopperElementModel(db);
	}

	public PopperElementModel newPopperElementModel(STModel stModel) {
		return new PopperElementModel(db, stModel);
	}

	public PopperElementModel newPopperElementModel(Node node) {
		return new PopperElementModel(db, node);
	}

	public Stream<PopperElementModel> findAllPopperElementModel() {
		return db.findAllSTModelByStTemplate(PopperElementModel.stTemplateUuid)
				.map(stModel -> new PopperElementModel(db, stModel));
	}

	public PopperElementModel findPopperElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PopperElementModel(db, uuid) : new PopperElementModel(db, stModel);
	}


	public PortalModel newPortalModel() {
		return new PortalModel(db);
	}

	public PortalModel newPortalModel(STModel stModel) {
		return new PortalModel(db, stModel);
	}

	public PortalModel newPortalModel(Node node) {
		return new PortalModel(db, node);
	}

	public Stream<PortalModel> findAllPortalModel() {
		return db.findAllSTModelByStTemplate(PortalModel.stTemplateUuid)
				.map(stModel -> new PortalModel(db, stModel));
	}

	public PortalModel findPortalModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PortalModel(db, uuid) : new PortalModel(db, stModel);
	}


	public PortalImportModel newPortalImportModel() {
		return new PortalImportModel(db);
	}

	public PortalImportModel newPortalImportModel(STModel stModel) {
		return new PortalImportModel(db, stModel);
	}

	public PortalImportModel newPortalImportModel(Node node) {
		return new PortalImportModel(db, node);
	}

	public Stream<PortalImportModel> findAllPortalImportModel() {
		return db.findAllSTModelByStTemplate(PortalImportModel.stTemplateUuid)
				.map(stModel -> new PortalImportModel(db, stModel));
	}

	public PortalImportModel findPortalImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PortalImportModel(db, uuid) : new PortalImportModel(db, stModel);
	}


	public PortalElementModel newPortalElementModel() {
		return new PortalElementModel(db);
	}

	public PortalElementModel newPortalElementModel(STModel stModel) {
		return new PortalElementModel(db, stModel);
	}

	public PortalElementModel newPortalElementModel(Node node) {
		return new PortalElementModel(db, node);
	}

	public Stream<PortalElementModel> findAllPortalElementModel() {
		return db.findAllSTModelByStTemplate(PortalElementModel.stTemplateUuid)
				.map(stModel -> new PortalElementModel(db, stModel));
	}

	public PortalElementModel findPortalElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new PortalElementModel(db, uuid) : new PortalElementModel(db, stModel);
	}


	public RadioModel newRadioModel() {
		return new RadioModel(db);
	}

	public RadioModel newRadioModel(STModel stModel) {
		return new RadioModel(db, stModel);
	}

	public RadioModel newRadioModel(Node node) {
		return new RadioModel(db, node);
	}

	public Stream<RadioModel> findAllRadioModel() {
		return db.findAllSTModelByStTemplate(RadioModel.stTemplateUuid)
				.map(stModel -> new RadioModel(db, stModel));
	}

	public RadioModel findRadioModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RadioModel(db, uuid) : new RadioModel(db, stModel);
	}


	public RadioImportModel newRadioImportModel() {
		return new RadioImportModel(db);
	}

	public RadioImportModel newRadioImportModel(STModel stModel) {
		return new RadioImportModel(db, stModel);
	}

	public RadioImportModel newRadioImportModel(Node node) {
		return new RadioImportModel(db, node);
	}

	public Stream<RadioImportModel> findAllRadioImportModel() {
		return db.findAllSTModelByStTemplate(RadioImportModel.stTemplateUuid)
				.map(stModel -> new RadioImportModel(db, stModel));
	}

	public RadioImportModel findRadioImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RadioImportModel(db, uuid) : new RadioImportModel(db, stModel);
	}


	public RadioElementModel newRadioElementModel() {
		return new RadioElementModel(db);
	}

	public RadioElementModel newRadioElementModel(STModel stModel) {
		return new RadioElementModel(db, stModel);
	}

	public RadioElementModel newRadioElementModel(Node node) {
		return new RadioElementModel(db, node);
	}

	public Stream<RadioElementModel> findAllRadioElementModel() {
		return db.findAllSTModelByStTemplate(RadioElementModel.stTemplateUuid)
				.map(stModel -> new RadioElementModel(db, stModel));
	}

	public RadioElementModel findRadioElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RadioElementModel(db, uuid) : new RadioElementModel(db, stModel);
	}


	public RadioGroupModel newRadioGroupModel() {
		return new RadioGroupModel(db);
	}

	public RadioGroupModel newRadioGroupModel(STModel stModel) {
		return new RadioGroupModel(db, stModel);
	}

	public RadioGroupModel newRadioGroupModel(Node node) {
		return new RadioGroupModel(db, node);
	}

	public Stream<RadioGroupModel> findAllRadioGroupModel() {
		return db.findAllSTModelByStTemplate(RadioGroupModel.stTemplateUuid)
				.map(stModel -> new RadioGroupModel(db, stModel));
	}

	public RadioGroupModel findRadioGroupModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RadioGroupModel(db, uuid) : new RadioGroupModel(db, stModel);
	}


	public RadioGroupImportModel newRadioGroupImportModel() {
		return new RadioGroupImportModel(db);
	}

	public RadioGroupImportModel newRadioGroupImportModel(STModel stModel) {
		return new RadioGroupImportModel(db, stModel);
	}

	public RadioGroupImportModel newRadioGroupImportModel(Node node) {
		return new RadioGroupImportModel(db, node);
	}

	public Stream<RadioGroupImportModel> findAllRadioGroupImportModel() {
		return db.findAllSTModelByStTemplate(RadioGroupImportModel.stTemplateUuid)
				.map(stModel -> new RadioGroupImportModel(db, stModel));
	}

	public RadioGroupImportModel findRadioGroupImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RadioGroupImportModel(db, uuid) : new RadioGroupImportModel(db, stModel);
	}


	public RadioGroupElementModel newRadioGroupElementModel() {
		return new RadioGroupElementModel(db);
	}

	public RadioGroupElementModel newRadioGroupElementModel(STModel stModel) {
		return new RadioGroupElementModel(db, stModel);
	}

	public RadioGroupElementModel newRadioGroupElementModel(Node node) {
		return new RadioGroupElementModel(db, node);
	}

	public Stream<RadioGroupElementModel> findAllRadioGroupElementModel() {
		return db.findAllSTModelByStTemplate(RadioGroupElementModel.stTemplateUuid)
				.map(stModel -> new RadioGroupElementModel(db, stModel));
	}

	public RadioGroupElementModel findRadioGroupElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RadioGroupElementModel(db, uuid) : new RadioGroupElementModel(db, stModel);
	}


	public RatingModel newRatingModel() {
		return new RatingModel(db);
	}

	public RatingModel newRatingModel(STModel stModel) {
		return new RatingModel(db, stModel);
	}

	public RatingModel newRatingModel(Node node) {
		return new RatingModel(db, node);
	}

	public Stream<RatingModel> findAllRatingModel() {
		return db.findAllSTModelByStTemplate(RatingModel.stTemplateUuid)
				.map(stModel -> new RatingModel(db, stModel));
	}

	public RatingModel findRatingModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RatingModel(db, uuid) : new RatingModel(db, stModel);
	}


	public RatingImportModel newRatingImportModel() {
		return new RatingImportModel(db);
	}

	public RatingImportModel newRatingImportModel(STModel stModel) {
		return new RatingImportModel(db, stModel);
	}

	public RatingImportModel newRatingImportModel(Node node) {
		return new RatingImportModel(db, node);
	}

	public Stream<RatingImportModel> findAllRatingImportModel() {
		return db.findAllSTModelByStTemplate(RatingImportModel.stTemplateUuid)
				.map(stModel -> new RatingImportModel(db, stModel));
	}

	public RatingImportModel findRatingImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RatingImportModel(db, uuid) : new RatingImportModel(db, stModel);
	}


	public RatingElementModel newRatingElementModel() {
		return new RatingElementModel(db);
	}

	public RatingElementModel newRatingElementModel(STModel stModel) {
		return new RatingElementModel(db, stModel);
	}

	public RatingElementModel newRatingElementModel(Node node) {
		return new RatingElementModel(db, node);
	}

	public Stream<RatingElementModel> findAllRatingElementModel() {
		return db.findAllSTModelByStTemplate(RatingElementModel.stTemplateUuid)
				.map(stModel -> new RatingElementModel(db, stModel));
	}

	public RatingElementModel findRatingElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RatingElementModel(db, uuid) : new RatingElementModel(db, stModel);
	}


	public RootRefModel newRootRefModel() {
		return new RootRefModel(db);
	}

	public RootRefModel newRootRefModel(STModel stModel) {
		return new RootRefModel(db, stModel);
	}

	public RootRefModel newRootRefModel(Node node) {
		return new RootRefModel(db, node);
	}

	public Stream<RootRefModel> findAllRootRefModel() {
		return db.findAllSTModelByStTemplate(RootRefModel.stTemplateUuid)
				.map(stModel -> new RootRefModel(db, stModel));
	}

	public RootRefModel findRootRefModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RootRefModel(db, uuid) : new RootRefModel(db, stModel);
	}


	public RootRefImportModel newRootRefImportModel() {
		return new RootRefImportModel(db);
	}

	public RootRefImportModel newRootRefImportModel(STModel stModel) {
		return new RootRefImportModel(db, stModel);
	}

	public RootRefImportModel newRootRefImportModel(Node node) {
		return new RootRefImportModel(db, node);
	}

	public Stream<RootRefImportModel> findAllRootRefImportModel() {
		return db.findAllSTModelByStTemplate(RootRefImportModel.stTemplateUuid)
				.map(stModel -> new RootRefImportModel(db, stModel));
	}

	public RootRefImportModel findRootRefImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RootRefImportModel(db, uuid) : new RootRefImportModel(db, stModel);
	}


	public RootRefElementModel newRootRefElementModel() {
		return new RootRefElementModel(db);
	}

	public RootRefElementModel newRootRefElementModel(STModel stModel) {
		return new RootRefElementModel(db, stModel);
	}

	public RootRefElementModel newRootRefElementModel(Node node) {
		return new RootRefElementModel(db, node);
	}

	public Stream<RootRefElementModel> findAllRootRefElementModel() {
		return db.findAllSTModelByStTemplate(RootRefElementModel.stTemplateUuid)
				.map(stModel -> new RootRefElementModel(db, stModel));
	}

	public RootRefElementModel findRootRefElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new RootRefElementModel(db, uuid) : new RootRefElementModel(db, stModel);
	}


	public ScopedCssBaselineModel newScopedCssBaselineModel() {
		return new ScopedCssBaselineModel(db);
	}

	public ScopedCssBaselineModel newScopedCssBaselineModel(STModel stModel) {
		return new ScopedCssBaselineModel(db, stModel);
	}

	public ScopedCssBaselineModel newScopedCssBaselineModel(Node node) {
		return new ScopedCssBaselineModel(db, node);
	}

	public Stream<ScopedCssBaselineModel> findAllScopedCssBaselineModel() {
		return db.findAllSTModelByStTemplate(ScopedCssBaselineModel.stTemplateUuid)
				.map(stModel -> new ScopedCssBaselineModel(db, stModel));
	}

	public ScopedCssBaselineModel findScopedCssBaselineModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ScopedCssBaselineModel(db, uuid) : new ScopedCssBaselineModel(db, stModel);
	}


	public ScopedCssBaselineImportModel newScopedCssBaselineImportModel() {
		return new ScopedCssBaselineImportModel(db);
	}

	public ScopedCssBaselineImportModel newScopedCssBaselineImportModel(STModel stModel) {
		return new ScopedCssBaselineImportModel(db, stModel);
	}

	public ScopedCssBaselineImportModel newScopedCssBaselineImportModel(Node node) {
		return new ScopedCssBaselineImportModel(db, node);
	}

	public Stream<ScopedCssBaselineImportModel> findAllScopedCssBaselineImportModel() {
		return db.findAllSTModelByStTemplate(ScopedCssBaselineImportModel.stTemplateUuid)
				.map(stModel -> new ScopedCssBaselineImportModel(db, stModel));
	}

	public ScopedCssBaselineImportModel findScopedCssBaselineImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ScopedCssBaselineImportModel(db, uuid) : new ScopedCssBaselineImportModel(db, stModel);
	}


	public ScopedCssBaselineElementModel newScopedCssBaselineElementModel() {
		return new ScopedCssBaselineElementModel(db);
	}

	public ScopedCssBaselineElementModel newScopedCssBaselineElementModel(STModel stModel) {
		return new ScopedCssBaselineElementModel(db, stModel);
	}

	public ScopedCssBaselineElementModel newScopedCssBaselineElementModel(Node node) {
		return new ScopedCssBaselineElementModel(db, node);
	}

	public Stream<ScopedCssBaselineElementModel> findAllScopedCssBaselineElementModel() {
		return db.findAllSTModelByStTemplate(ScopedCssBaselineElementModel.stTemplateUuid)
				.map(stModel -> new ScopedCssBaselineElementModel(db, stModel));
	}

	public ScopedCssBaselineElementModel findScopedCssBaselineElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ScopedCssBaselineElementModel(db, uuid) : new ScopedCssBaselineElementModel(db, stModel);
	}


	public SelectModel newSelectModel() {
		return new SelectModel(db);
	}

	public SelectModel newSelectModel(STModel stModel) {
		return new SelectModel(db, stModel);
	}

	public SelectModel newSelectModel(Node node) {
		return new SelectModel(db, node);
	}

	public Stream<SelectModel> findAllSelectModel() {
		return db.findAllSTModelByStTemplate(SelectModel.stTemplateUuid)
				.map(stModel -> new SelectModel(db, stModel));
	}

	public SelectModel findSelectModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SelectModel(db, uuid) : new SelectModel(db, stModel);
	}


	public SelectImportModel newSelectImportModel() {
		return new SelectImportModel(db);
	}

	public SelectImportModel newSelectImportModel(STModel stModel) {
		return new SelectImportModel(db, stModel);
	}

	public SelectImportModel newSelectImportModel(Node node) {
		return new SelectImportModel(db, node);
	}

	public Stream<SelectImportModel> findAllSelectImportModel() {
		return db.findAllSTModelByStTemplate(SelectImportModel.stTemplateUuid)
				.map(stModel -> new SelectImportModel(db, stModel));
	}

	public SelectImportModel findSelectImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SelectImportModel(db, uuid) : new SelectImportModel(db, stModel);
	}


	public SelectElementModel newSelectElementModel() {
		return new SelectElementModel(db);
	}

	public SelectElementModel newSelectElementModel(STModel stModel) {
		return new SelectElementModel(db, stModel);
	}

	public SelectElementModel newSelectElementModel(Node node) {
		return new SelectElementModel(db, node);
	}

	public Stream<SelectElementModel> findAllSelectElementModel() {
		return db.findAllSTModelByStTemplate(SelectElementModel.stTemplateUuid)
				.map(stModel -> new SelectElementModel(db, stModel));
	}

	public SelectElementModel findSelectElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SelectElementModel(db, uuid) : new SelectElementModel(db, stModel);
	}


	public SkeletonModel newSkeletonModel() {
		return new SkeletonModel(db);
	}

	public SkeletonModel newSkeletonModel(STModel stModel) {
		return new SkeletonModel(db, stModel);
	}

	public SkeletonModel newSkeletonModel(Node node) {
		return new SkeletonModel(db, node);
	}

	public Stream<SkeletonModel> findAllSkeletonModel() {
		return db.findAllSTModelByStTemplate(SkeletonModel.stTemplateUuid)
				.map(stModel -> new SkeletonModel(db, stModel));
	}

	public SkeletonModel findSkeletonModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SkeletonModel(db, uuid) : new SkeletonModel(db, stModel);
	}


	public SkeletonImportModel newSkeletonImportModel() {
		return new SkeletonImportModel(db);
	}

	public SkeletonImportModel newSkeletonImportModel(STModel stModel) {
		return new SkeletonImportModel(db, stModel);
	}

	public SkeletonImportModel newSkeletonImportModel(Node node) {
		return new SkeletonImportModel(db, node);
	}

	public Stream<SkeletonImportModel> findAllSkeletonImportModel() {
		return db.findAllSTModelByStTemplate(SkeletonImportModel.stTemplateUuid)
				.map(stModel -> new SkeletonImportModel(db, stModel));
	}

	public SkeletonImportModel findSkeletonImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SkeletonImportModel(db, uuid) : new SkeletonImportModel(db, stModel);
	}


	public SkeletonElementModel newSkeletonElementModel() {
		return new SkeletonElementModel(db);
	}

	public SkeletonElementModel newSkeletonElementModel(STModel stModel) {
		return new SkeletonElementModel(db, stModel);
	}

	public SkeletonElementModel newSkeletonElementModel(Node node) {
		return new SkeletonElementModel(db, node);
	}

	public Stream<SkeletonElementModel> findAllSkeletonElementModel() {
		return db.findAllSTModelByStTemplate(SkeletonElementModel.stTemplateUuid)
				.map(stModel -> new SkeletonElementModel(db, stModel));
	}

	public SkeletonElementModel findSkeletonElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SkeletonElementModel(db, uuid) : new SkeletonElementModel(db, stModel);
	}


	public SlideModel newSlideModel() {
		return new SlideModel(db);
	}

	public SlideModel newSlideModel(STModel stModel) {
		return new SlideModel(db, stModel);
	}

	public SlideModel newSlideModel(Node node) {
		return new SlideModel(db, node);
	}

	public Stream<SlideModel> findAllSlideModel() {
		return db.findAllSTModelByStTemplate(SlideModel.stTemplateUuid)
				.map(stModel -> new SlideModel(db, stModel));
	}

	public SlideModel findSlideModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SlideModel(db, uuid) : new SlideModel(db, stModel);
	}


	public SlideImportModel newSlideImportModel() {
		return new SlideImportModel(db);
	}

	public SlideImportModel newSlideImportModel(STModel stModel) {
		return new SlideImportModel(db, stModel);
	}

	public SlideImportModel newSlideImportModel(Node node) {
		return new SlideImportModel(db, node);
	}

	public Stream<SlideImportModel> findAllSlideImportModel() {
		return db.findAllSTModelByStTemplate(SlideImportModel.stTemplateUuid)
				.map(stModel -> new SlideImportModel(db, stModel));
	}

	public SlideImportModel findSlideImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SlideImportModel(db, uuid) : new SlideImportModel(db, stModel);
	}


	public SlideElementModel newSlideElementModel() {
		return new SlideElementModel(db);
	}

	public SlideElementModel newSlideElementModel(STModel stModel) {
		return new SlideElementModel(db, stModel);
	}

	public SlideElementModel newSlideElementModel(Node node) {
		return new SlideElementModel(db, node);
	}

	public Stream<SlideElementModel> findAllSlideElementModel() {
		return db.findAllSTModelByStTemplate(SlideElementModel.stTemplateUuid)
				.map(stModel -> new SlideElementModel(db, stModel));
	}

	public SlideElementModel findSlideElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SlideElementModel(db, uuid) : new SlideElementModel(db, stModel);
	}


	public SliderModel newSliderModel() {
		return new SliderModel(db);
	}

	public SliderModel newSliderModel(STModel stModel) {
		return new SliderModel(db, stModel);
	}

	public SliderModel newSliderModel(Node node) {
		return new SliderModel(db, node);
	}

	public Stream<SliderModel> findAllSliderModel() {
		return db.findAllSTModelByStTemplate(SliderModel.stTemplateUuid)
				.map(stModel -> new SliderModel(db, stModel));
	}

	public SliderModel findSliderModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SliderModel(db, uuid) : new SliderModel(db, stModel);
	}


	public SliderImportModel newSliderImportModel() {
		return new SliderImportModel(db);
	}

	public SliderImportModel newSliderImportModel(STModel stModel) {
		return new SliderImportModel(db, stModel);
	}

	public SliderImportModel newSliderImportModel(Node node) {
		return new SliderImportModel(db, node);
	}

	public Stream<SliderImportModel> findAllSliderImportModel() {
		return db.findAllSTModelByStTemplate(SliderImportModel.stTemplateUuid)
				.map(stModel -> new SliderImportModel(db, stModel));
	}

	public SliderImportModel findSliderImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SliderImportModel(db, uuid) : new SliderImportModel(db, stModel);
	}


	public SliderElementModel newSliderElementModel() {
		return new SliderElementModel(db);
	}

	public SliderElementModel newSliderElementModel(STModel stModel) {
		return new SliderElementModel(db, stModel);
	}

	public SliderElementModel newSliderElementModel(Node node) {
		return new SliderElementModel(db, node);
	}

	public Stream<SliderElementModel> findAllSliderElementModel() {
		return db.findAllSTModelByStTemplate(SliderElementModel.stTemplateUuid)
				.map(stModel -> new SliderElementModel(db, stModel));
	}

	public SliderElementModel findSliderElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SliderElementModel(db, uuid) : new SliderElementModel(db, stModel);
	}


	public SnackbarModel newSnackbarModel() {
		return new SnackbarModel(db);
	}

	public SnackbarModel newSnackbarModel(STModel stModel) {
		return new SnackbarModel(db, stModel);
	}

	public SnackbarModel newSnackbarModel(Node node) {
		return new SnackbarModel(db, node);
	}

	public Stream<SnackbarModel> findAllSnackbarModel() {
		return db.findAllSTModelByStTemplate(SnackbarModel.stTemplateUuid)
				.map(stModel -> new SnackbarModel(db, stModel));
	}

	public SnackbarModel findSnackbarModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SnackbarModel(db, uuid) : new SnackbarModel(db, stModel);
	}


	public SnackbarImportModel newSnackbarImportModel() {
		return new SnackbarImportModel(db);
	}

	public SnackbarImportModel newSnackbarImportModel(STModel stModel) {
		return new SnackbarImportModel(db, stModel);
	}

	public SnackbarImportModel newSnackbarImportModel(Node node) {
		return new SnackbarImportModel(db, node);
	}

	public Stream<SnackbarImportModel> findAllSnackbarImportModel() {
		return db.findAllSTModelByStTemplate(SnackbarImportModel.stTemplateUuid)
				.map(stModel -> new SnackbarImportModel(db, stModel));
	}

	public SnackbarImportModel findSnackbarImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SnackbarImportModel(db, uuid) : new SnackbarImportModel(db, stModel);
	}


	public SnackbarElementModel newSnackbarElementModel() {
		return new SnackbarElementModel(db);
	}

	public SnackbarElementModel newSnackbarElementModel(STModel stModel) {
		return new SnackbarElementModel(db, stModel);
	}

	public SnackbarElementModel newSnackbarElementModel(Node node) {
		return new SnackbarElementModel(db, node);
	}

	public Stream<SnackbarElementModel> findAllSnackbarElementModel() {
		return db.findAllSTModelByStTemplate(SnackbarElementModel.stTemplateUuid)
				.map(stModel -> new SnackbarElementModel(db, stModel));
	}

	public SnackbarElementModel findSnackbarElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SnackbarElementModel(db, uuid) : new SnackbarElementModel(db, stModel);
	}


	public SnackbarContentModel newSnackbarContentModel() {
		return new SnackbarContentModel(db);
	}

	public SnackbarContentModel newSnackbarContentModel(STModel stModel) {
		return new SnackbarContentModel(db, stModel);
	}

	public SnackbarContentModel newSnackbarContentModel(Node node) {
		return new SnackbarContentModel(db, node);
	}

	public Stream<SnackbarContentModel> findAllSnackbarContentModel() {
		return db.findAllSTModelByStTemplate(SnackbarContentModel.stTemplateUuid)
				.map(stModel -> new SnackbarContentModel(db, stModel));
	}

	public SnackbarContentModel findSnackbarContentModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SnackbarContentModel(db, uuid) : new SnackbarContentModel(db, stModel);
	}


	public SnackbarContentImportModel newSnackbarContentImportModel() {
		return new SnackbarContentImportModel(db);
	}

	public SnackbarContentImportModel newSnackbarContentImportModel(STModel stModel) {
		return new SnackbarContentImportModel(db, stModel);
	}

	public SnackbarContentImportModel newSnackbarContentImportModel(Node node) {
		return new SnackbarContentImportModel(db, node);
	}

	public Stream<SnackbarContentImportModel> findAllSnackbarContentImportModel() {
		return db.findAllSTModelByStTemplate(SnackbarContentImportModel.stTemplateUuid)
				.map(stModel -> new SnackbarContentImportModel(db, stModel));
	}

	public SnackbarContentImportModel findSnackbarContentImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SnackbarContentImportModel(db, uuid) : new SnackbarContentImportModel(db, stModel);
	}


	public SnackbarContentElementModel newSnackbarContentElementModel() {
		return new SnackbarContentElementModel(db);
	}

	public SnackbarContentElementModel newSnackbarContentElementModel(STModel stModel) {
		return new SnackbarContentElementModel(db, stModel);
	}

	public SnackbarContentElementModel newSnackbarContentElementModel(Node node) {
		return new SnackbarContentElementModel(db, node);
	}

	public Stream<SnackbarContentElementModel> findAllSnackbarContentElementModel() {
		return db.findAllSTModelByStTemplate(SnackbarContentElementModel.stTemplateUuid)
				.map(stModel -> new SnackbarContentElementModel(db, stModel));
	}

	public SnackbarContentElementModel findSnackbarContentElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SnackbarContentElementModel(db, uuid) : new SnackbarContentElementModel(db, stModel);
	}


	public SpeedDialModel newSpeedDialModel() {
		return new SpeedDialModel(db);
	}

	public SpeedDialModel newSpeedDialModel(STModel stModel) {
		return new SpeedDialModel(db, stModel);
	}

	public SpeedDialModel newSpeedDialModel(Node node) {
		return new SpeedDialModel(db, node);
	}

	public Stream<SpeedDialModel> findAllSpeedDialModel() {
		return db.findAllSTModelByStTemplate(SpeedDialModel.stTemplateUuid)
				.map(stModel -> new SpeedDialModel(db, stModel));
	}

	public SpeedDialModel findSpeedDialModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SpeedDialModel(db, uuid) : new SpeedDialModel(db, stModel);
	}


	public SpeedDialImportModel newSpeedDialImportModel() {
		return new SpeedDialImportModel(db);
	}

	public SpeedDialImportModel newSpeedDialImportModel(STModel stModel) {
		return new SpeedDialImportModel(db, stModel);
	}

	public SpeedDialImportModel newSpeedDialImportModel(Node node) {
		return new SpeedDialImportModel(db, node);
	}

	public Stream<SpeedDialImportModel> findAllSpeedDialImportModel() {
		return db.findAllSTModelByStTemplate(SpeedDialImportModel.stTemplateUuid)
				.map(stModel -> new SpeedDialImportModel(db, stModel));
	}

	public SpeedDialImportModel findSpeedDialImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SpeedDialImportModel(db, uuid) : new SpeedDialImportModel(db, stModel);
	}


	public SpeedDialElementModel newSpeedDialElementModel() {
		return new SpeedDialElementModel(db);
	}

	public SpeedDialElementModel newSpeedDialElementModel(STModel stModel) {
		return new SpeedDialElementModel(db, stModel);
	}

	public SpeedDialElementModel newSpeedDialElementModel(Node node) {
		return new SpeedDialElementModel(db, node);
	}

	public Stream<SpeedDialElementModel> findAllSpeedDialElementModel() {
		return db.findAllSTModelByStTemplate(SpeedDialElementModel.stTemplateUuid)
				.map(stModel -> new SpeedDialElementModel(db, stModel));
	}

	public SpeedDialElementModel findSpeedDialElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SpeedDialElementModel(db, uuid) : new SpeedDialElementModel(db, stModel);
	}


	public SpeedDialActionModel newSpeedDialActionModel() {
		return new SpeedDialActionModel(db);
	}

	public SpeedDialActionModel newSpeedDialActionModel(STModel stModel) {
		return new SpeedDialActionModel(db, stModel);
	}

	public SpeedDialActionModel newSpeedDialActionModel(Node node) {
		return new SpeedDialActionModel(db, node);
	}

	public Stream<SpeedDialActionModel> findAllSpeedDialActionModel() {
		return db.findAllSTModelByStTemplate(SpeedDialActionModel.stTemplateUuid)
				.map(stModel -> new SpeedDialActionModel(db, stModel));
	}

	public SpeedDialActionModel findSpeedDialActionModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SpeedDialActionModel(db, uuid) : new SpeedDialActionModel(db, stModel);
	}


	public SpeedDialActionImportModel newSpeedDialActionImportModel() {
		return new SpeedDialActionImportModel(db);
	}

	public SpeedDialActionImportModel newSpeedDialActionImportModel(STModel stModel) {
		return new SpeedDialActionImportModel(db, stModel);
	}

	public SpeedDialActionImportModel newSpeedDialActionImportModel(Node node) {
		return new SpeedDialActionImportModel(db, node);
	}

	public Stream<SpeedDialActionImportModel> findAllSpeedDialActionImportModel() {
		return db.findAllSTModelByStTemplate(SpeedDialActionImportModel.stTemplateUuid)
				.map(stModel -> new SpeedDialActionImportModel(db, stModel));
	}

	public SpeedDialActionImportModel findSpeedDialActionImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SpeedDialActionImportModel(db, uuid) : new SpeedDialActionImportModel(db, stModel);
	}


	public SpeedDialActionElementModel newSpeedDialActionElementModel() {
		return new SpeedDialActionElementModel(db);
	}

	public SpeedDialActionElementModel newSpeedDialActionElementModel(STModel stModel) {
		return new SpeedDialActionElementModel(db, stModel);
	}

	public SpeedDialActionElementModel newSpeedDialActionElementModel(Node node) {
		return new SpeedDialActionElementModel(db, node);
	}

	public Stream<SpeedDialActionElementModel> findAllSpeedDialActionElementModel() {
		return db.findAllSTModelByStTemplate(SpeedDialActionElementModel.stTemplateUuid)
				.map(stModel -> new SpeedDialActionElementModel(db, stModel));
	}

	public SpeedDialActionElementModel findSpeedDialActionElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SpeedDialActionElementModel(db, uuid) : new SpeedDialActionElementModel(db, stModel);
	}


	public SpeedDialIconModel newSpeedDialIconModel() {
		return new SpeedDialIconModel(db);
	}

	public SpeedDialIconModel newSpeedDialIconModel(STModel stModel) {
		return new SpeedDialIconModel(db, stModel);
	}

	public SpeedDialIconModel newSpeedDialIconModel(Node node) {
		return new SpeedDialIconModel(db, node);
	}

	public Stream<SpeedDialIconModel> findAllSpeedDialIconModel() {
		return db.findAllSTModelByStTemplate(SpeedDialIconModel.stTemplateUuid)
				.map(stModel -> new SpeedDialIconModel(db, stModel));
	}

	public SpeedDialIconModel findSpeedDialIconModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SpeedDialIconModel(db, uuid) : new SpeedDialIconModel(db, stModel);
	}


	public SpeedDialIconImportModel newSpeedDialIconImportModel() {
		return new SpeedDialIconImportModel(db);
	}

	public SpeedDialIconImportModel newSpeedDialIconImportModel(STModel stModel) {
		return new SpeedDialIconImportModel(db, stModel);
	}

	public SpeedDialIconImportModel newSpeedDialIconImportModel(Node node) {
		return new SpeedDialIconImportModel(db, node);
	}

	public Stream<SpeedDialIconImportModel> findAllSpeedDialIconImportModel() {
		return db.findAllSTModelByStTemplate(SpeedDialIconImportModel.stTemplateUuid)
				.map(stModel -> new SpeedDialIconImportModel(db, stModel));
	}

	public SpeedDialIconImportModel findSpeedDialIconImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SpeedDialIconImportModel(db, uuid) : new SpeedDialIconImportModel(db, stModel);
	}


	public SpeedDialIconElementModel newSpeedDialIconElementModel() {
		return new SpeedDialIconElementModel(db);
	}

	public SpeedDialIconElementModel newSpeedDialIconElementModel(STModel stModel) {
		return new SpeedDialIconElementModel(db, stModel);
	}

	public SpeedDialIconElementModel newSpeedDialIconElementModel(Node node) {
		return new SpeedDialIconElementModel(db, node);
	}

	public Stream<SpeedDialIconElementModel> findAllSpeedDialIconElementModel() {
		return db.findAllSTModelByStTemplate(SpeedDialIconElementModel.stTemplateUuid)
				.map(stModel -> new SpeedDialIconElementModel(db, stModel));
	}

	public SpeedDialIconElementModel findSpeedDialIconElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SpeedDialIconElementModel(db, uuid) : new SpeedDialIconElementModel(db, stModel);
	}


	public StepModel newStepModel() {
		return new StepModel(db);
	}

	public StepModel newStepModel(STModel stModel) {
		return new StepModel(db, stModel);
	}

	public StepModel newStepModel(Node node) {
		return new StepModel(db, node);
	}

	public Stream<StepModel> findAllStepModel() {
		return db.findAllSTModelByStTemplate(StepModel.stTemplateUuid)
				.map(stModel -> new StepModel(db, stModel));
	}

	public StepModel findStepModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepModel(db, uuid) : new StepModel(db, stModel);
	}


	public StepImportModel newStepImportModel() {
		return new StepImportModel(db);
	}

	public StepImportModel newStepImportModel(STModel stModel) {
		return new StepImportModel(db, stModel);
	}

	public StepImportModel newStepImportModel(Node node) {
		return new StepImportModel(db, node);
	}

	public Stream<StepImportModel> findAllStepImportModel() {
		return db.findAllSTModelByStTemplate(StepImportModel.stTemplateUuid)
				.map(stModel -> new StepImportModel(db, stModel));
	}

	public StepImportModel findStepImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepImportModel(db, uuid) : new StepImportModel(db, stModel);
	}


	public StepElementModel newStepElementModel() {
		return new StepElementModel(db);
	}

	public StepElementModel newStepElementModel(STModel stModel) {
		return new StepElementModel(db, stModel);
	}

	public StepElementModel newStepElementModel(Node node) {
		return new StepElementModel(db, node);
	}

	public Stream<StepElementModel> findAllStepElementModel() {
		return db.findAllSTModelByStTemplate(StepElementModel.stTemplateUuid)
				.map(stModel -> new StepElementModel(db, stModel));
	}

	public StepElementModel findStepElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepElementModel(db, uuid) : new StepElementModel(db, stModel);
	}


	public StepButtonModel newStepButtonModel() {
		return new StepButtonModel(db);
	}

	public StepButtonModel newStepButtonModel(STModel stModel) {
		return new StepButtonModel(db, stModel);
	}

	public StepButtonModel newStepButtonModel(Node node) {
		return new StepButtonModel(db, node);
	}

	public Stream<StepButtonModel> findAllStepButtonModel() {
		return db.findAllSTModelByStTemplate(StepButtonModel.stTemplateUuid)
				.map(stModel -> new StepButtonModel(db, stModel));
	}

	public StepButtonModel findStepButtonModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepButtonModel(db, uuid) : new StepButtonModel(db, stModel);
	}


	public StepButtonImportModel newStepButtonImportModel() {
		return new StepButtonImportModel(db);
	}

	public StepButtonImportModel newStepButtonImportModel(STModel stModel) {
		return new StepButtonImportModel(db, stModel);
	}

	public StepButtonImportModel newStepButtonImportModel(Node node) {
		return new StepButtonImportModel(db, node);
	}

	public Stream<StepButtonImportModel> findAllStepButtonImportModel() {
		return db.findAllSTModelByStTemplate(StepButtonImportModel.stTemplateUuid)
				.map(stModel -> new StepButtonImportModel(db, stModel));
	}

	public StepButtonImportModel findStepButtonImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepButtonImportModel(db, uuid) : new StepButtonImportModel(db, stModel);
	}


	public StepButtonElementModel newStepButtonElementModel() {
		return new StepButtonElementModel(db);
	}

	public StepButtonElementModel newStepButtonElementModel(STModel stModel) {
		return new StepButtonElementModel(db, stModel);
	}

	public StepButtonElementModel newStepButtonElementModel(Node node) {
		return new StepButtonElementModel(db, node);
	}

	public Stream<StepButtonElementModel> findAllStepButtonElementModel() {
		return db.findAllSTModelByStTemplate(StepButtonElementModel.stTemplateUuid)
				.map(stModel -> new StepButtonElementModel(db, stModel));
	}

	public StepButtonElementModel findStepButtonElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepButtonElementModel(db, uuid) : new StepButtonElementModel(db, stModel);
	}


	public StepConnectorModel newStepConnectorModel() {
		return new StepConnectorModel(db);
	}

	public StepConnectorModel newStepConnectorModel(STModel stModel) {
		return new StepConnectorModel(db, stModel);
	}

	public StepConnectorModel newStepConnectorModel(Node node) {
		return new StepConnectorModel(db, node);
	}

	public Stream<StepConnectorModel> findAllStepConnectorModel() {
		return db.findAllSTModelByStTemplate(StepConnectorModel.stTemplateUuid)
				.map(stModel -> new StepConnectorModel(db, stModel));
	}

	public StepConnectorModel findStepConnectorModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepConnectorModel(db, uuid) : new StepConnectorModel(db, stModel);
	}


	public StepConnectorImportModel newStepConnectorImportModel() {
		return new StepConnectorImportModel(db);
	}

	public StepConnectorImportModel newStepConnectorImportModel(STModel stModel) {
		return new StepConnectorImportModel(db, stModel);
	}

	public StepConnectorImportModel newStepConnectorImportModel(Node node) {
		return new StepConnectorImportModel(db, node);
	}

	public Stream<StepConnectorImportModel> findAllStepConnectorImportModel() {
		return db.findAllSTModelByStTemplate(StepConnectorImportModel.stTemplateUuid)
				.map(stModel -> new StepConnectorImportModel(db, stModel));
	}

	public StepConnectorImportModel findStepConnectorImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepConnectorImportModel(db, uuid) : new StepConnectorImportModel(db, stModel);
	}


	public StepConnectorElementModel newStepConnectorElementModel() {
		return new StepConnectorElementModel(db);
	}

	public StepConnectorElementModel newStepConnectorElementModel(STModel stModel) {
		return new StepConnectorElementModel(db, stModel);
	}

	public StepConnectorElementModel newStepConnectorElementModel(Node node) {
		return new StepConnectorElementModel(db, node);
	}

	public Stream<StepConnectorElementModel> findAllStepConnectorElementModel() {
		return db.findAllSTModelByStTemplate(StepConnectorElementModel.stTemplateUuid)
				.map(stModel -> new StepConnectorElementModel(db, stModel));
	}

	public StepConnectorElementModel findStepConnectorElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepConnectorElementModel(db, uuid) : new StepConnectorElementModel(db, stModel);
	}


	public StepContentModel newStepContentModel() {
		return new StepContentModel(db);
	}

	public StepContentModel newStepContentModel(STModel stModel) {
		return new StepContentModel(db, stModel);
	}

	public StepContentModel newStepContentModel(Node node) {
		return new StepContentModel(db, node);
	}

	public Stream<StepContentModel> findAllStepContentModel() {
		return db.findAllSTModelByStTemplate(StepContentModel.stTemplateUuid)
				.map(stModel -> new StepContentModel(db, stModel));
	}

	public StepContentModel findStepContentModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepContentModel(db, uuid) : new StepContentModel(db, stModel);
	}


	public StepContentImportModel newStepContentImportModel() {
		return new StepContentImportModel(db);
	}

	public StepContentImportModel newStepContentImportModel(STModel stModel) {
		return new StepContentImportModel(db, stModel);
	}

	public StepContentImportModel newStepContentImportModel(Node node) {
		return new StepContentImportModel(db, node);
	}

	public Stream<StepContentImportModel> findAllStepContentImportModel() {
		return db.findAllSTModelByStTemplate(StepContentImportModel.stTemplateUuid)
				.map(stModel -> new StepContentImportModel(db, stModel));
	}

	public StepContentImportModel findStepContentImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepContentImportModel(db, uuid) : new StepContentImportModel(db, stModel);
	}


	public StepContentElementModel newStepContentElementModel() {
		return new StepContentElementModel(db);
	}

	public StepContentElementModel newStepContentElementModel(STModel stModel) {
		return new StepContentElementModel(db, stModel);
	}

	public StepContentElementModel newStepContentElementModel(Node node) {
		return new StepContentElementModel(db, node);
	}

	public Stream<StepContentElementModel> findAllStepContentElementModel() {
		return db.findAllSTModelByStTemplate(StepContentElementModel.stTemplateUuid)
				.map(stModel -> new StepContentElementModel(db, stModel));
	}

	public StepContentElementModel findStepContentElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepContentElementModel(db, uuid) : new StepContentElementModel(db, stModel);
	}


	public StepIconModel newStepIconModel() {
		return new StepIconModel(db);
	}

	public StepIconModel newStepIconModel(STModel stModel) {
		return new StepIconModel(db, stModel);
	}

	public StepIconModel newStepIconModel(Node node) {
		return new StepIconModel(db, node);
	}

	public Stream<StepIconModel> findAllStepIconModel() {
		return db.findAllSTModelByStTemplate(StepIconModel.stTemplateUuid)
				.map(stModel -> new StepIconModel(db, stModel));
	}

	public StepIconModel findStepIconModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepIconModel(db, uuid) : new StepIconModel(db, stModel);
	}


	public StepIconImportModel newStepIconImportModel() {
		return new StepIconImportModel(db);
	}

	public StepIconImportModel newStepIconImportModel(STModel stModel) {
		return new StepIconImportModel(db, stModel);
	}

	public StepIconImportModel newStepIconImportModel(Node node) {
		return new StepIconImportModel(db, node);
	}

	public Stream<StepIconImportModel> findAllStepIconImportModel() {
		return db.findAllSTModelByStTemplate(StepIconImportModel.stTemplateUuid)
				.map(stModel -> new StepIconImportModel(db, stModel));
	}

	public StepIconImportModel findStepIconImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepIconImportModel(db, uuid) : new StepIconImportModel(db, stModel);
	}


	public StepIconElementModel newStepIconElementModel() {
		return new StepIconElementModel(db);
	}

	public StepIconElementModel newStepIconElementModel(STModel stModel) {
		return new StepIconElementModel(db, stModel);
	}

	public StepIconElementModel newStepIconElementModel(Node node) {
		return new StepIconElementModel(db, node);
	}

	public Stream<StepIconElementModel> findAllStepIconElementModel() {
		return db.findAllSTModelByStTemplate(StepIconElementModel.stTemplateUuid)
				.map(stModel -> new StepIconElementModel(db, stModel));
	}

	public StepIconElementModel findStepIconElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepIconElementModel(db, uuid) : new StepIconElementModel(db, stModel);
	}


	public StepLabelModel newStepLabelModel() {
		return new StepLabelModel(db);
	}

	public StepLabelModel newStepLabelModel(STModel stModel) {
		return new StepLabelModel(db, stModel);
	}

	public StepLabelModel newStepLabelModel(Node node) {
		return new StepLabelModel(db, node);
	}

	public Stream<StepLabelModel> findAllStepLabelModel() {
		return db.findAllSTModelByStTemplate(StepLabelModel.stTemplateUuid)
				.map(stModel -> new StepLabelModel(db, stModel));
	}

	public StepLabelModel findStepLabelModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepLabelModel(db, uuid) : new StepLabelModel(db, stModel);
	}


	public StepLabelImportModel newStepLabelImportModel() {
		return new StepLabelImportModel(db);
	}

	public StepLabelImportModel newStepLabelImportModel(STModel stModel) {
		return new StepLabelImportModel(db, stModel);
	}

	public StepLabelImportModel newStepLabelImportModel(Node node) {
		return new StepLabelImportModel(db, node);
	}

	public Stream<StepLabelImportModel> findAllStepLabelImportModel() {
		return db.findAllSTModelByStTemplate(StepLabelImportModel.stTemplateUuid)
				.map(stModel -> new StepLabelImportModel(db, stModel));
	}

	public StepLabelImportModel findStepLabelImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepLabelImportModel(db, uuid) : new StepLabelImportModel(db, stModel);
	}


	public StepLabelElementModel newStepLabelElementModel() {
		return new StepLabelElementModel(db);
	}

	public StepLabelElementModel newStepLabelElementModel(STModel stModel) {
		return new StepLabelElementModel(db, stModel);
	}

	public StepLabelElementModel newStepLabelElementModel(Node node) {
		return new StepLabelElementModel(db, node);
	}

	public Stream<StepLabelElementModel> findAllStepLabelElementModel() {
		return db.findAllSTModelByStTemplate(StepLabelElementModel.stTemplateUuid)
				.map(stModel -> new StepLabelElementModel(db, stModel));
	}

	public StepLabelElementModel findStepLabelElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepLabelElementModel(db, uuid) : new StepLabelElementModel(db, stModel);
	}


	public StepperModel newStepperModel() {
		return new StepperModel(db);
	}

	public StepperModel newStepperModel(STModel stModel) {
		return new StepperModel(db, stModel);
	}

	public StepperModel newStepperModel(Node node) {
		return new StepperModel(db, node);
	}

	public Stream<StepperModel> findAllStepperModel() {
		return db.findAllSTModelByStTemplate(StepperModel.stTemplateUuid)
				.map(stModel -> new StepperModel(db, stModel));
	}

	public StepperModel findStepperModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepperModel(db, uuid) : new StepperModel(db, stModel);
	}


	public StepperImportModel newStepperImportModel() {
		return new StepperImportModel(db);
	}

	public StepperImportModel newStepperImportModel(STModel stModel) {
		return new StepperImportModel(db, stModel);
	}

	public StepperImportModel newStepperImportModel(Node node) {
		return new StepperImportModel(db, node);
	}

	public Stream<StepperImportModel> findAllStepperImportModel() {
		return db.findAllSTModelByStTemplate(StepperImportModel.stTemplateUuid)
				.map(stModel -> new StepperImportModel(db, stModel));
	}

	public StepperImportModel findStepperImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepperImportModel(db, uuid) : new StepperImportModel(db, stModel);
	}


	public StepperElementModel newStepperElementModel() {
		return new StepperElementModel(db);
	}

	public StepperElementModel newStepperElementModel(STModel stModel) {
		return new StepperElementModel(db, stModel);
	}

	public StepperElementModel newStepperElementModel(Node node) {
		return new StepperElementModel(db, node);
	}

	public Stream<StepperElementModel> findAllStepperElementModel() {
		return db.findAllSTModelByStTemplate(StepperElementModel.stTemplateUuid)
				.map(stModel -> new StepperElementModel(db, stModel));
	}

	public StepperElementModel findStepperElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new StepperElementModel(db, uuid) : new StepperElementModel(db, stModel);
	}


	public SvgIconModel newSvgIconModel() {
		return new SvgIconModel(db);
	}

	public SvgIconModel newSvgIconModel(STModel stModel) {
		return new SvgIconModel(db, stModel);
	}

	public SvgIconModel newSvgIconModel(Node node) {
		return new SvgIconModel(db, node);
	}

	public Stream<SvgIconModel> findAllSvgIconModel() {
		return db.findAllSTModelByStTemplate(SvgIconModel.stTemplateUuid)
				.map(stModel -> new SvgIconModel(db, stModel));
	}

	public SvgIconModel findSvgIconModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SvgIconModel(db, uuid) : new SvgIconModel(db, stModel);
	}


	public SvgIconImportModel newSvgIconImportModel() {
		return new SvgIconImportModel(db);
	}

	public SvgIconImportModel newSvgIconImportModel(STModel stModel) {
		return new SvgIconImportModel(db, stModel);
	}

	public SvgIconImportModel newSvgIconImportModel(Node node) {
		return new SvgIconImportModel(db, node);
	}

	public Stream<SvgIconImportModel> findAllSvgIconImportModel() {
		return db.findAllSTModelByStTemplate(SvgIconImportModel.stTemplateUuid)
				.map(stModel -> new SvgIconImportModel(db, stModel));
	}

	public SvgIconImportModel findSvgIconImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SvgIconImportModel(db, uuid) : new SvgIconImportModel(db, stModel);
	}


	public SvgIconElementModel newSvgIconElementModel() {
		return new SvgIconElementModel(db);
	}

	public SvgIconElementModel newSvgIconElementModel(STModel stModel) {
		return new SvgIconElementModel(db, stModel);
	}

	public SvgIconElementModel newSvgIconElementModel(Node node) {
		return new SvgIconElementModel(db, node);
	}

	public Stream<SvgIconElementModel> findAllSvgIconElementModel() {
		return db.findAllSTModelByStTemplate(SvgIconElementModel.stTemplateUuid)
				.map(stModel -> new SvgIconElementModel(db, stModel));
	}

	public SvgIconElementModel findSvgIconElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SvgIconElementModel(db, uuid) : new SvgIconElementModel(db, stModel);
	}


	public SwipeableDrawerModel newSwipeableDrawerModel() {
		return new SwipeableDrawerModel(db);
	}

	public SwipeableDrawerModel newSwipeableDrawerModel(STModel stModel) {
		return new SwipeableDrawerModel(db, stModel);
	}

	public SwipeableDrawerModel newSwipeableDrawerModel(Node node) {
		return new SwipeableDrawerModel(db, node);
	}

	public Stream<SwipeableDrawerModel> findAllSwipeableDrawerModel() {
		return db.findAllSTModelByStTemplate(SwipeableDrawerModel.stTemplateUuid)
				.map(stModel -> new SwipeableDrawerModel(db, stModel));
	}

	public SwipeableDrawerModel findSwipeableDrawerModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SwipeableDrawerModel(db, uuid) : new SwipeableDrawerModel(db, stModel);
	}


	public SwipeableDrawerImportModel newSwipeableDrawerImportModel() {
		return new SwipeableDrawerImportModel(db);
	}

	public SwipeableDrawerImportModel newSwipeableDrawerImportModel(STModel stModel) {
		return new SwipeableDrawerImportModel(db, stModel);
	}

	public SwipeableDrawerImportModel newSwipeableDrawerImportModel(Node node) {
		return new SwipeableDrawerImportModel(db, node);
	}

	public Stream<SwipeableDrawerImportModel> findAllSwipeableDrawerImportModel() {
		return db.findAllSTModelByStTemplate(SwipeableDrawerImportModel.stTemplateUuid)
				.map(stModel -> new SwipeableDrawerImportModel(db, stModel));
	}

	public SwipeableDrawerImportModel findSwipeableDrawerImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SwipeableDrawerImportModel(db, uuid) : new SwipeableDrawerImportModel(db, stModel);
	}


	public SwipeableDrawerElementModel newSwipeableDrawerElementModel() {
		return new SwipeableDrawerElementModel(db);
	}

	public SwipeableDrawerElementModel newSwipeableDrawerElementModel(STModel stModel) {
		return new SwipeableDrawerElementModel(db, stModel);
	}

	public SwipeableDrawerElementModel newSwipeableDrawerElementModel(Node node) {
		return new SwipeableDrawerElementModel(db, node);
	}

	public Stream<SwipeableDrawerElementModel> findAllSwipeableDrawerElementModel() {
		return db.findAllSTModelByStTemplate(SwipeableDrawerElementModel.stTemplateUuid)
				.map(stModel -> new SwipeableDrawerElementModel(db, stModel));
	}

	public SwipeableDrawerElementModel findSwipeableDrawerElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SwipeableDrawerElementModel(db, uuid) : new SwipeableDrawerElementModel(db, stModel);
	}


	public SwitchModel newSwitchModel() {
		return new SwitchModel(db);
	}

	public SwitchModel newSwitchModel(STModel stModel) {
		return new SwitchModel(db, stModel);
	}

	public SwitchModel newSwitchModel(Node node) {
		return new SwitchModel(db, node);
	}

	public Stream<SwitchModel> findAllSwitchModel() {
		return db.findAllSTModelByStTemplate(SwitchModel.stTemplateUuid)
				.map(stModel -> new SwitchModel(db, stModel));
	}

	public SwitchModel findSwitchModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SwitchModel(db, uuid) : new SwitchModel(db, stModel);
	}


	public SwitchImportModel newSwitchImportModel() {
		return new SwitchImportModel(db);
	}

	public SwitchImportModel newSwitchImportModel(STModel stModel) {
		return new SwitchImportModel(db, stModel);
	}

	public SwitchImportModel newSwitchImportModel(Node node) {
		return new SwitchImportModel(db, node);
	}

	public Stream<SwitchImportModel> findAllSwitchImportModel() {
		return db.findAllSTModelByStTemplate(SwitchImportModel.stTemplateUuid)
				.map(stModel -> new SwitchImportModel(db, stModel));
	}

	public SwitchImportModel findSwitchImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SwitchImportModel(db, uuid) : new SwitchImportModel(db, stModel);
	}


	public SwitchElementModel newSwitchElementModel() {
		return new SwitchElementModel(db);
	}

	public SwitchElementModel newSwitchElementModel(STModel stModel) {
		return new SwitchElementModel(db, stModel);
	}

	public SwitchElementModel newSwitchElementModel(Node node) {
		return new SwitchElementModel(db, node);
	}

	public Stream<SwitchElementModel> findAllSwitchElementModel() {
		return db.findAllSTModelByStTemplate(SwitchElementModel.stTemplateUuid)
				.map(stModel -> new SwitchElementModel(db, stModel));
	}

	public SwitchElementModel findSwitchElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new SwitchElementModel(db, uuid) : new SwitchElementModel(db, stModel);
	}


	public TabModel newTabModel() {
		return new TabModel(db);
	}

	public TabModel newTabModel(STModel stModel) {
		return new TabModel(db, stModel);
	}

	public TabModel newTabModel(Node node) {
		return new TabModel(db, node);
	}

	public Stream<TabModel> findAllTabModel() {
		return db.findAllSTModelByStTemplate(TabModel.stTemplateUuid)
				.map(stModel -> new TabModel(db, stModel));
	}

	public TabModel findTabModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabModel(db, uuid) : new TabModel(db, stModel);
	}


	public TabImportModel newTabImportModel() {
		return new TabImportModel(db);
	}

	public TabImportModel newTabImportModel(STModel stModel) {
		return new TabImportModel(db, stModel);
	}

	public TabImportModel newTabImportModel(Node node) {
		return new TabImportModel(db, node);
	}

	public Stream<TabImportModel> findAllTabImportModel() {
		return db.findAllSTModelByStTemplate(TabImportModel.stTemplateUuid)
				.map(stModel -> new TabImportModel(db, stModel));
	}

	public TabImportModel findTabImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabImportModel(db, uuid) : new TabImportModel(db, stModel);
	}


	public TabElementModel newTabElementModel() {
		return new TabElementModel(db);
	}

	public TabElementModel newTabElementModel(STModel stModel) {
		return new TabElementModel(db, stModel);
	}

	public TabElementModel newTabElementModel(Node node) {
		return new TabElementModel(db, node);
	}

	public Stream<TabElementModel> findAllTabElementModel() {
		return db.findAllSTModelByStTemplate(TabElementModel.stTemplateUuid)
				.map(stModel -> new TabElementModel(db, stModel));
	}

	public TabElementModel findTabElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabElementModel(db, uuid) : new TabElementModel(db, stModel);
	}


	public TabContextModel newTabContextModel() {
		return new TabContextModel(db);
	}

	public TabContextModel newTabContextModel(STModel stModel) {
		return new TabContextModel(db, stModel);
	}

	public TabContextModel newTabContextModel(Node node) {
		return new TabContextModel(db, node);
	}

	public Stream<TabContextModel> findAllTabContextModel() {
		return db.findAllSTModelByStTemplate(TabContextModel.stTemplateUuid)
				.map(stModel -> new TabContextModel(db, stModel));
	}

	public TabContextModel findTabContextModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabContextModel(db, uuid) : new TabContextModel(db, stModel);
	}


	public TabContextImportModel newTabContextImportModel() {
		return new TabContextImportModel(db);
	}

	public TabContextImportModel newTabContextImportModel(STModel stModel) {
		return new TabContextImportModel(db, stModel);
	}

	public TabContextImportModel newTabContextImportModel(Node node) {
		return new TabContextImportModel(db, node);
	}

	public Stream<TabContextImportModel> findAllTabContextImportModel() {
		return db.findAllSTModelByStTemplate(TabContextImportModel.stTemplateUuid)
				.map(stModel -> new TabContextImportModel(db, stModel));
	}

	public TabContextImportModel findTabContextImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabContextImportModel(db, uuid) : new TabContextImportModel(db, stModel);
	}


	public TabContextElementModel newTabContextElementModel() {
		return new TabContextElementModel(db);
	}

	public TabContextElementModel newTabContextElementModel(STModel stModel) {
		return new TabContextElementModel(db, stModel);
	}

	public TabContextElementModel newTabContextElementModel(Node node) {
		return new TabContextElementModel(db, node);
	}

	public Stream<TabContextElementModel> findAllTabContextElementModel() {
		return db.findAllSTModelByStTemplate(TabContextElementModel.stTemplateUuid)
				.map(stModel -> new TabContextElementModel(db, stModel));
	}

	public TabContextElementModel findTabContextElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabContextElementModel(db, uuid) : new TabContextElementModel(db, stModel);
	}


	public TableModel newTableModel() {
		return new TableModel(db);
	}

	public TableModel newTableModel(STModel stModel) {
		return new TableModel(db, stModel);
	}

	public TableModel newTableModel(Node node) {
		return new TableModel(db, node);
	}

	public Stream<TableModel> findAllTableModel() {
		return db.findAllSTModelByStTemplate(TableModel.stTemplateUuid)
				.map(stModel -> new TableModel(db, stModel));
	}

	public TableModel findTableModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableModel(db, uuid) : new TableModel(db, stModel);
	}


	public TableImportModel newTableImportModel() {
		return new TableImportModel(db);
	}

	public TableImportModel newTableImportModel(STModel stModel) {
		return new TableImportModel(db, stModel);
	}

	public TableImportModel newTableImportModel(Node node) {
		return new TableImportModel(db, node);
	}

	public Stream<TableImportModel> findAllTableImportModel() {
		return db.findAllSTModelByStTemplate(TableImportModel.stTemplateUuid)
				.map(stModel -> new TableImportModel(db, stModel));
	}

	public TableImportModel findTableImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableImportModel(db, uuid) : new TableImportModel(db, stModel);
	}


	public TableElementModel newTableElementModel() {
		return new TableElementModel(db);
	}

	public TableElementModel newTableElementModel(STModel stModel) {
		return new TableElementModel(db, stModel);
	}

	public TableElementModel newTableElementModel(Node node) {
		return new TableElementModel(db, node);
	}

	public Stream<TableElementModel> findAllTableElementModel() {
		return db.findAllSTModelByStTemplate(TableElementModel.stTemplateUuid)
				.map(stModel -> new TableElementModel(db, stModel));
	}

	public TableElementModel findTableElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableElementModel(db, uuid) : new TableElementModel(db, stModel);
	}


	public TableBodyModel newTableBodyModel() {
		return new TableBodyModel(db);
	}

	public TableBodyModel newTableBodyModel(STModel stModel) {
		return new TableBodyModel(db, stModel);
	}

	public TableBodyModel newTableBodyModel(Node node) {
		return new TableBodyModel(db, node);
	}

	public Stream<TableBodyModel> findAllTableBodyModel() {
		return db.findAllSTModelByStTemplate(TableBodyModel.stTemplateUuid)
				.map(stModel -> new TableBodyModel(db, stModel));
	}

	public TableBodyModel findTableBodyModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableBodyModel(db, uuid) : new TableBodyModel(db, stModel);
	}


	public TableBodyImportModel newTableBodyImportModel() {
		return new TableBodyImportModel(db);
	}

	public TableBodyImportModel newTableBodyImportModel(STModel stModel) {
		return new TableBodyImportModel(db, stModel);
	}

	public TableBodyImportModel newTableBodyImportModel(Node node) {
		return new TableBodyImportModel(db, node);
	}

	public Stream<TableBodyImportModel> findAllTableBodyImportModel() {
		return db.findAllSTModelByStTemplate(TableBodyImportModel.stTemplateUuid)
				.map(stModel -> new TableBodyImportModel(db, stModel));
	}

	public TableBodyImportModel findTableBodyImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableBodyImportModel(db, uuid) : new TableBodyImportModel(db, stModel);
	}


	public TableBodyElementModel newTableBodyElementModel() {
		return new TableBodyElementModel(db);
	}

	public TableBodyElementModel newTableBodyElementModel(STModel stModel) {
		return new TableBodyElementModel(db, stModel);
	}

	public TableBodyElementModel newTableBodyElementModel(Node node) {
		return new TableBodyElementModel(db, node);
	}

	public Stream<TableBodyElementModel> findAllTableBodyElementModel() {
		return db.findAllSTModelByStTemplate(TableBodyElementModel.stTemplateUuid)
				.map(stModel -> new TableBodyElementModel(db, stModel));
	}

	public TableBodyElementModel findTableBodyElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableBodyElementModel(db, uuid) : new TableBodyElementModel(db, stModel);
	}


	public TableCellModel newTableCellModel() {
		return new TableCellModel(db);
	}

	public TableCellModel newTableCellModel(STModel stModel) {
		return new TableCellModel(db, stModel);
	}

	public TableCellModel newTableCellModel(Node node) {
		return new TableCellModel(db, node);
	}

	public Stream<TableCellModel> findAllTableCellModel() {
		return db.findAllSTModelByStTemplate(TableCellModel.stTemplateUuid)
				.map(stModel -> new TableCellModel(db, stModel));
	}

	public TableCellModel findTableCellModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableCellModel(db, uuid) : new TableCellModel(db, stModel);
	}


	public TableCellImportModel newTableCellImportModel() {
		return new TableCellImportModel(db);
	}

	public TableCellImportModel newTableCellImportModel(STModel stModel) {
		return new TableCellImportModel(db, stModel);
	}

	public TableCellImportModel newTableCellImportModel(Node node) {
		return new TableCellImportModel(db, node);
	}

	public Stream<TableCellImportModel> findAllTableCellImportModel() {
		return db.findAllSTModelByStTemplate(TableCellImportModel.stTemplateUuid)
				.map(stModel -> new TableCellImportModel(db, stModel));
	}

	public TableCellImportModel findTableCellImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableCellImportModel(db, uuid) : new TableCellImportModel(db, stModel);
	}


	public TableCellElementModel newTableCellElementModel() {
		return new TableCellElementModel(db);
	}

	public TableCellElementModel newTableCellElementModel(STModel stModel) {
		return new TableCellElementModel(db, stModel);
	}

	public TableCellElementModel newTableCellElementModel(Node node) {
		return new TableCellElementModel(db, node);
	}

	public Stream<TableCellElementModel> findAllTableCellElementModel() {
		return db.findAllSTModelByStTemplate(TableCellElementModel.stTemplateUuid)
				.map(stModel -> new TableCellElementModel(db, stModel));
	}

	public TableCellElementModel findTableCellElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableCellElementModel(db, uuid) : new TableCellElementModel(db, stModel);
	}


	public TableContainerModel newTableContainerModel() {
		return new TableContainerModel(db);
	}

	public TableContainerModel newTableContainerModel(STModel stModel) {
		return new TableContainerModel(db, stModel);
	}

	public TableContainerModel newTableContainerModel(Node node) {
		return new TableContainerModel(db, node);
	}

	public Stream<TableContainerModel> findAllTableContainerModel() {
		return db.findAllSTModelByStTemplate(TableContainerModel.stTemplateUuid)
				.map(stModel -> new TableContainerModel(db, stModel));
	}

	public TableContainerModel findTableContainerModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableContainerModel(db, uuid) : new TableContainerModel(db, stModel);
	}


	public TableContainerImportModel newTableContainerImportModel() {
		return new TableContainerImportModel(db);
	}

	public TableContainerImportModel newTableContainerImportModel(STModel stModel) {
		return new TableContainerImportModel(db, stModel);
	}

	public TableContainerImportModel newTableContainerImportModel(Node node) {
		return new TableContainerImportModel(db, node);
	}

	public Stream<TableContainerImportModel> findAllTableContainerImportModel() {
		return db.findAllSTModelByStTemplate(TableContainerImportModel.stTemplateUuid)
				.map(stModel -> new TableContainerImportModel(db, stModel));
	}

	public TableContainerImportModel findTableContainerImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableContainerImportModel(db, uuid) : new TableContainerImportModel(db, stModel);
	}


	public TableContainerElementModel newTableContainerElementModel() {
		return new TableContainerElementModel(db);
	}

	public TableContainerElementModel newTableContainerElementModel(STModel stModel) {
		return new TableContainerElementModel(db, stModel);
	}

	public TableContainerElementModel newTableContainerElementModel(Node node) {
		return new TableContainerElementModel(db, node);
	}

	public Stream<TableContainerElementModel> findAllTableContainerElementModel() {
		return db.findAllSTModelByStTemplate(TableContainerElementModel.stTemplateUuid)
				.map(stModel -> new TableContainerElementModel(db, stModel));
	}

	public TableContainerElementModel findTableContainerElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableContainerElementModel(db, uuid) : new TableContainerElementModel(db, stModel);
	}


	public TableFooterModel newTableFooterModel() {
		return new TableFooterModel(db);
	}

	public TableFooterModel newTableFooterModel(STModel stModel) {
		return new TableFooterModel(db, stModel);
	}

	public TableFooterModel newTableFooterModel(Node node) {
		return new TableFooterModel(db, node);
	}

	public Stream<TableFooterModel> findAllTableFooterModel() {
		return db.findAllSTModelByStTemplate(TableFooterModel.stTemplateUuid)
				.map(stModel -> new TableFooterModel(db, stModel));
	}

	public TableFooterModel findTableFooterModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableFooterModel(db, uuid) : new TableFooterModel(db, stModel);
	}


	public TableFooterImportModel newTableFooterImportModel() {
		return new TableFooterImportModel(db);
	}

	public TableFooterImportModel newTableFooterImportModel(STModel stModel) {
		return new TableFooterImportModel(db, stModel);
	}

	public TableFooterImportModel newTableFooterImportModel(Node node) {
		return new TableFooterImportModel(db, node);
	}

	public Stream<TableFooterImportModel> findAllTableFooterImportModel() {
		return db.findAllSTModelByStTemplate(TableFooterImportModel.stTemplateUuid)
				.map(stModel -> new TableFooterImportModel(db, stModel));
	}

	public TableFooterImportModel findTableFooterImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableFooterImportModel(db, uuid) : new TableFooterImportModel(db, stModel);
	}


	public TableFooterElementModel newTableFooterElementModel() {
		return new TableFooterElementModel(db);
	}

	public TableFooterElementModel newTableFooterElementModel(STModel stModel) {
		return new TableFooterElementModel(db, stModel);
	}

	public TableFooterElementModel newTableFooterElementModel(Node node) {
		return new TableFooterElementModel(db, node);
	}

	public Stream<TableFooterElementModel> findAllTableFooterElementModel() {
		return db.findAllSTModelByStTemplate(TableFooterElementModel.stTemplateUuid)
				.map(stModel -> new TableFooterElementModel(db, stModel));
	}

	public TableFooterElementModel findTableFooterElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableFooterElementModel(db, uuid) : new TableFooterElementModel(db, stModel);
	}


	public TableHeadModel newTableHeadModel() {
		return new TableHeadModel(db);
	}

	public TableHeadModel newTableHeadModel(STModel stModel) {
		return new TableHeadModel(db, stModel);
	}

	public TableHeadModel newTableHeadModel(Node node) {
		return new TableHeadModel(db, node);
	}

	public Stream<TableHeadModel> findAllTableHeadModel() {
		return db.findAllSTModelByStTemplate(TableHeadModel.stTemplateUuid)
				.map(stModel -> new TableHeadModel(db, stModel));
	}

	public TableHeadModel findTableHeadModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableHeadModel(db, uuid) : new TableHeadModel(db, stModel);
	}


	public TableHeadImportModel newTableHeadImportModel() {
		return new TableHeadImportModel(db);
	}

	public TableHeadImportModel newTableHeadImportModel(STModel stModel) {
		return new TableHeadImportModel(db, stModel);
	}

	public TableHeadImportModel newTableHeadImportModel(Node node) {
		return new TableHeadImportModel(db, node);
	}

	public Stream<TableHeadImportModel> findAllTableHeadImportModel() {
		return db.findAllSTModelByStTemplate(TableHeadImportModel.stTemplateUuid)
				.map(stModel -> new TableHeadImportModel(db, stModel));
	}

	public TableHeadImportModel findTableHeadImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableHeadImportModel(db, uuid) : new TableHeadImportModel(db, stModel);
	}


	public TableHeadElementModel newTableHeadElementModel() {
		return new TableHeadElementModel(db);
	}

	public TableHeadElementModel newTableHeadElementModel(STModel stModel) {
		return new TableHeadElementModel(db, stModel);
	}

	public TableHeadElementModel newTableHeadElementModel(Node node) {
		return new TableHeadElementModel(db, node);
	}

	public Stream<TableHeadElementModel> findAllTableHeadElementModel() {
		return db.findAllSTModelByStTemplate(TableHeadElementModel.stTemplateUuid)
				.map(stModel -> new TableHeadElementModel(db, stModel));
	}

	public TableHeadElementModel findTableHeadElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableHeadElementModel(db, uuid) : new TableHeadElementModel(db, stModel);
	}


	public TablePaginationModel newTablePaginationModel() {
		return new TablePaginationModel(db);
	}

	public TablePaginationModel newTablePaginationModel(STModel stModel) {
		return new TablePaginationModel(db, stModel);
	}

	public TablePaginationModel newTablePaginationModel(Node node) {
		return new TablePaginationModel(db, node);
	}

	public Stream<TablePaginationModel> findAllTablePaginationModel() {
		return db.findAllSTModelByStTemplate(TablePaginationModel.stTemplateUuid)
				.map(stModel -> new TablePaginationModel(db, stModel));
	}

	public TablePaginationModel findTablePaginationModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TablePaginationModel(db, uuid) : new TablePaginationModel(db, stModel);
	}


	public TablePaginationImportModel newTablePaginationImportModel() {
		return new TablePaginationImportModel(db);
	}

	public TablePaginationImportModel newTablePaginationImportModel(STModel stModel) {
		return new TablePaginationImportModel(db, stModel);
	}

	public TablePaginationImportModel newTablePaginationImportModel(Node node) {
		return new TablePaginationImportModel(db, node);
	}

	public Stream<TablePaginationImportModel> findAllTablePaginationImportModel() {
		return db.findAllSTModelByStTemplate(TablePaginationImportModel.stTemplateUuid)
				.map(stModel -> new TablePaginationImportModel(db, stModel));
	}

	public TablePaginationImportModel findTablePaginationImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TablePaginationImportModel(db, uuid) : new TablePaginationImportModel(db, stModel);
	}


	public TablePaginationElementModel newTablePaginationElementModel() {
		return new TablePaginationElementModel(db);
	}

	public TablePaginationElementModel newTablePaginationElementModel(STModel stModel) {
		return new TablePaginationElementModel(db, stModel);
	}

	public TablePaginationElementModel newTablePaginationElementModel(Node node) {
		return new TablePaginationElementModel(db, node);
	}

	public Stream<TablePaginationElementModel> findAllTablePaginationElementModel() {
		return db.findAllSTModelByStTemplate(TablePaginationElementModel.stTemplateUuid)
				.map(stModel -> new TablePaginationElementModel(db, stModel));
	}

	public TablePaginationElementModel findTablePaginationElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TablePaginationElementModel(db, uuid) : new TablePaginationElementModel(db, stModel);
	}


	public TableRowModel newTableRowModel() {
		return new TableRowModel(db);
	}

	public TableRowModel newTableRowModel(STModel stModel) {
		return new TableRowModel(db, stModel);
	}

	public TableRowModel newTableRowModel(Node node) {
		return new TableRowModel(db, node);
	}

	public Stream<TableRowModel> findAllTableRowModel() {
		return db.findAllSTModelByStTemplate(TableRowModel.stTemplateUuid)
				.map(stModel -> new TableRowModel(db, stModel));
	}

	public TableRowModel findTableRowModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableRowModel(db, uuid) : new TableRowModel(db, stModel);
	}


	public TableRowImportModel newTableRowImportModel() {
		return new TableRowImportModel(db);
	}

	public TableRowImportModel newTableRowImportModel(STModel stModel) {
		return new TableRowImportModel(db, stModel);
	}

	public TableRowImportModel newTableRowImportModel(Node node) {
		return new TableRowImportModel(db, node);
	}

	public Stream<TableRowImportModel> findAllTableRowImportModel() {
		return db.findAllSTModelByStTemplate(TableRowImportModel.stTemplateUuid)
				.map(stModel -> new TableRowImportModel(db, stModel));
	}

	public TableRowImportModel findTableRowImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableRowImportModel(db, uuid) : new TableRowImportModel(db, stModel);
	}


	public TableRowElementModel newTableRowElementModel() {
		return new TableRowElementModel(db);
	}

	public TableRowElementModel newTableRowElementModel(STModel stModel) {
		return new TableRowElementModel(db, stModel);
	}

	public TableRowElementModel newTableRowElementModel(Node node) {
		return new TableRowElementModel(db, node);
	}

	public Stream<TableRowElementModel> findAllTableRowElementModel() {
		return db.findAllSTModelByStTemplate(TableRowElementModel.stTemplateUuid)
				.map(stModel -> new TableRowElementModel(db, stModel));
	}

	public TableRowElementModel findTableRowElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableRowElementModel(db, uuid) : new TableRowElementModel(db, stModel);
	}


	public TableSortLabelModel newTableSortLabelModel() {
		return new TableSortLabelModel(db);
	}

	public TableSortLabelModel newTableSortLabelModel(STModel stModel) {
		return new TableSortLabelModel(db, stModel);
	}

	public TableSortLabelModel newTableSortLabelModel(Node node) {
		return new TableSortLabelModel(db, node);
	}

	public Stream<TableSortLabelModel> findAllTableSortLabelModel() {
		return db.findAllSTModelByStTemplate(TableSortLabelModel.stTemplateUuid)
				.map(stModel -> new TableSortLabelModel(db, stModel));
	}

	public TableSortLabelModel findTableSortLabelModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableSortLabelModel(db, uuid) : new TableSortLabelModel(db, stModel);
	}


	public TableSortLabelImportModel newTableSortLabelImportModel() {
		return new TableSortLabelImportModel(db);
	}

	public TableSortLabelImportModel newTableSortLabelImportModel(STModel stModel) {
		return new TableSortLabelImportModel(db, stModel);
	}

	public TableSortLabelImportModel newTableSortLabelImportModel(Node node) {
		return new TableSortLabelImportModel(db, node);
	}

	public Stream<TableSortLabelImportModel> findAllTableSortLabelImportModel() {
		return db.findAllSTModelByStTemplate(TableSortLabelImportModel.stTemplateUuid)
				.map(stModel -> new TableSortLabelImportModel(db, stModel));
	}

	public TableSortLabelImportModel findTableSortLabelImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableSortLabelImportModel(db, uuid) : new TableSortLabelImportModel(db, stModel);
	}


	public TableSortLabelElementModel newTableSortLabelElementModel() {
		return new TableSortLabelElementModel(db);
	}

	public TableSortLabelElementModel newTableSortLabelElementModel(STModel stModel) {
		return new TableSortLabelElementModel(db, stModel);
	}

	public TableSortLabelElementModel newTableSortLabelElementModel(Node node) {
		return new TableSortLabelElementModel(db, node);
	}

	public Stream<TableSortLabelElementModel> findAllTableSortLabelElementModel() {
		return db.findAllSTModelByStTemplate(TableSortLabelElementModel.stTemplateUuid)
				.map(stModel -> new TableSortLabelElementModel(db, stModel));
	}

	public TableSortLabelElementModel findTableSortLabelElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TableSortLabelElementModel(db, uuid) : new TableSortLabelElementModel(db, stModel);
	}


	public TabListModel newTabListModel() {
		return new TabListModel(db);
	}

	public TabListModel newTabListModel(STModel stModel) {
		return new TabListModel(db, stModel);
	}

	public TabListModel newTabListModel(Node node) {
		return new TabListModel(db, node);
	}

	public Stream<TabListModel> findAllTabListModel() {
		return db.findAllSTModelByStTemplate(TabListModel.stTemplateUuid)
				.map(stModel -> new TabListModel(db, stModel));
	}

	public TabListModel findTabListModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabListModel(db, uuid) : new TabListModel(db, stModel);
	}


	public TabListImportModel newTabListImportModel() {
		return new TabListImportModel(db);
	}

	public TabListImportModel newTabListImportModel(STModel stModel) {
		return new TabListImportModel(db, stModel);
	}

	public TabListImportModel newTabListImportModel(Node node) {
		return new TabListImportModel(db, node);
	}

	public Stream<TabListImportModel> findAllTabListImportModel() {
		return db.findAllSTModelByStTemplate(TabListImportModel.stTemplateUuid)
				.map(stModel -> new TabListImportModel(db, stModel));
	}

	public TabListImportModel findTabListImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabListImportModel(db, uuid) : new TabListImportModel(db, stModel);
	}


	public TabListElementModel newTabListElementModel() {
		return new TabListElementModel(db);
	}

	public TabListElementModel newTabListElementModel(STModel stModel) {
		return new TabListElementModel(db, stModel);
	}

	public TabListElementModel newTabListElementModel(Node node) {
		return new TabListElementModel(db, node);
	}

	public Stream<TabListElementModel> findAllTabListElementModel() {
		return db.findAllSTModelByStTemplate(TabListElementModel.stTemplateUuid)
				.map(stModel -> new TabListElementModel(db, stModel));
	}

	public TabListElementModel findTabListElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabListElementModel(db, uuid) : new TabListElementModel(db, stModel);
	}


	public TabPanelModel newTabPanelModel() {
		return new TabPanelModel(db);
	}

	public TabPanelModel newTabPanelModel(STModel stModel) {
		return new TabPanelModel(db, stModel);
	}

	public TabPanelModel newTabPanelModel(Node node) {
		return new TabPanelModel(db, node);
	}

	public Stream<TabPanelModel> findAllTabPanelModel() {
		return db.findAllSTModelByStTemplate(TabPanelModel.stTemplateUuid)
				.map(stModel -> new TabPanelModel(db, stModel));
	}

	public TabPanelModel findTabPanelModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabPanelModel(db, uuid) : new TabPanelModel(db, stModel);
	}


	public TabPanelImportModel newTabPanelImportModel() {
		return new TabPanelImportModel(db);
	}

	public TabPanelImportModel newTabPanelImportModel(STModel stModel) {
		return new TabPanelImportModel(db, stModel);
	}

	public TabPanelImportModel newTabPanelImportModel(Node node) {
		return new TabPanelImportModel(db, node);
	}

	public Stream<TabPanelImportModel> findAllTabPanelImportModel() {
		return db.findAllSTModelByStTemplate(TabPanelImportModel.stTemplateUuid)
				.map(stModel -> new TabPanelImportModel(db, stModel));
	}

	public TabPanelImportModel findTabPanelImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabPanelImportModel(db, uuid) : new TabPanelImportModel(db, stModel);
	}


	public TabPanelElementModel newTabPanelElementModel() {
		return new TabPanelElementModel(db);
	}

	public TabPanelElementModel newTabPanelElementModel(STModel stModel) {
		return new TabPanelElementModel(db, stModel);
	}

	public TabPanelElementModel newTabPanelElementModel(Node node) {
		return new TabPanelElementModel(db, node);
	}

	public Stream<TabPanelElementModel> findAllTabPanelElementModel() {
		return db.findAllSTModelByStTemplate(TabPanelElementModel.stTemplateUuid)
				.map(stModel -> new TabPanelElementModel(db, stModel));
	}

	public TabPanelElementModel findTabPanelElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabPanelElementModel(db, uuid) : new TabPanelElementModel(db, stModel);
	}


	public TabsModel newTabsModel() {
		return new TabsModel(db);
	}

	public TabsModel newTabsModel(STModel stModel) {
		return new TabsModel(db, stModel);
	}

	public TabsModel newTabsModel(Node node) {
		return new TabsModel(db, node);
	}

	public Stream<TabsModel> findAllTabsModel() {
		return db.findAllSTModelByStTemplate(TabsModel.stTemplateUuid)
				.map(stModel -> new TabsModel(db, stModel));
	}

	public TabsModel findTabsModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabsModel(db, uuid) : new TabsModel(db, stModel);
	}


	public TabsImportModel newTabsImportModel() {
		return new TabsImportModel(db);
	}

	public TabsImportModel newTabsImportModel(STModel stModel) {
		return new TabsImportModel(db, stModel);
	}

	public TabsImportModel newTabsImportModel(Node node) {
		return new TabsImportModel(db, node);
	}

	public Stream<TabsImportModel> findAllTabsImportModel() {
		return db.findAllSTModelByStTemplate(TabsImportModel.stTemplateUuid)
				.map(stModel -> new TabsImportModel(db, stModel));
	}

	public TabsImportModel findTabsImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabsImportModel(db, uuid) : new TabsImportModel(db, stModel);
	}


	public TabsElementModel newTabsElementModel() {
		return new TabsElementModel(db);
	}

	public TabsElementModel newTabsElementModel(STModel stModel) {
		return new TabsElementModel(db, stModel);
	}

	public TabsElementModel newTabsElementModel(Node node) {
		return new TabsElementModel(db, node);
	}

	public Stream<TabsElementModel> findAllTabsElementModel() {
		return db.findAllSTModelByStTemplate(TabsElementModel.stTemplateUuid)
				.map(stModel -> new TabsElementModel(db, stModel));
	}

	public TabsElementModel findTabsElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabsElementModel(db, uuid) : new TabsElementModel(db, stModel);
	}


	public TabScrollButtonModel newTabScrollButtonModel() {
		return new TabScrollButtonModel(db);
	}

	public TabScrollButtonModel newTabScrollButtonModel(STModel stModel) {
		return new TabScrollButtonModel(db, stModel);
	}

	public TabScrollButtonModel newTabScrollButtonModel(Node node) {
		return new TabScrollButtonModel(db, node);
	}

	public Stream<TabScrollButtonModel> findAllTabScrollButtonModel() {
		return db.findAllSTModelByStTemplate(TabScrollButtonModel.stTemplateUuid)
				.map(stModel -> new TabScrollButtonModel(db, stModel));
	}

	public TabScrollButtonModel findTabScrollButtonModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabScrollButtonModel(db, uuid) : new TabScrollButtonModel(db, stModel);
	}


	public TabScrollButtonImportModel newTabScrollButtonImportModel() {
		return new TabScrollButtonImportModel(db);
	}

	public TabScrollButtonImportModel newTabScrollButtonImportModel(STModel stModel) {
		return new TabScrollButtonImportModel(db, stModel);
	}

	public TabScrollButtonImportModel newTabScrollButtonImportModel(Node node) {
		return new TabScrollButtonImportModel(db, node);
	}

	public Stream<TabScrollButtonImportModel> findAllTabScrollButtonImportModel() {
		return db.findAllSTModelByStTemplate(TabScrollButtonImportModel.stTemplateUuid)
				.map(stModel -> new TabScrollButtonImportModel(db, stModel));
	}

	public TabScrollButtonImportModel findTabScrollButtonImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabScrollButtonImportModel(db, uuid) : new TabScrollButtonImportModel(db, stModel);
	}


	public TabScrollButtonElementModel newTabScrollButtonElementModel() {
		return new TabScrollButtonElementModel(db);
	}

	public TabScrollButtonElementModel newTabScrollButtonElementModel(STModel stModel) {
		return new TabScrollButtonElementModel(db, stModel);
	}

	public TabScrollButtonElementModel newTabScrollButtonElementModel(Node node) {
		return new TabScrollButtonElementModel(db, node);
	}

	public Stream<TabScrollButtonElementModel> findAllTabScrollButtonElementModel() {
		return db.findAllSTModelByStTemplate(TabScrollButtonElementModel.stTemplateUuid)
				.map(stModel -> new TabScrollButtonElementModel(db, stModel));
	}

	public TabScrollButtonElementModel findTabScrollButtonElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TabScrollButtonElementModel(db, uuid) : new TabScrollButtonElementModel(db, stModel);
	}


	public TextareaAutosizeModel newTextareaAutosizeModel() {
		return new TextareaAutosizeModel(db);
	}

	public TextareaAutosizeModel newTextareaAutosizeModel(STModel stModel) {
		return new TextareaAutosizeModel(db, stModel);
	}

	public TextareaAutosizeModel newTextareaAutosizeModel(Node node) {
		return new TextareaAutosizeModel(db, node);
	}

	public Stream<TextareaAutosizeModel> findAllTextareaAutosizeModel() {
		return db.findAllSTModelByStTemplate(TextareaAutosizeModel.stTemplateUuid)
				.map(stModel -> new TextareaAutosizeModel(db, stModel));
	}

	public TextareaAutosizeModel findTextareaAutosizeModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TextareaAutosizeModel(db, uuid) : new TextareaAutosizeModel(db, stModel);
	}


	public TextareaAutosizeImportModel newTextareaAutosizeImportModel() {
		return new TextareaAutosizeImportModel(db);
	}

	public TextareaAutosizeImportModel newTextareaAutosizeImportModel(STModel stModel) {
		return new TextareaAutosizeImportModel(db, stModel);
	}

	public TextareaAutosizeImportModel newTextareaAutosizeImportModel(Node node) {
		return new TextareaAutosizeImportModel(db, node);
	}

	public Stream<TextareaAutosizeImportModel> findAllTextareaAutosizeImportModel() {
		return db.findAllSTModelByStTemplate(TextareaAutosizeImportModel.stTemplateUuid)
				.map(stModel -> new TextareaAutosizeImportModel(db, stModel));
	}

	public TextareaAutosizeImportModel findTextareaAutosizeImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TextareaAutosizeImportModel(db, uuid) : new TextareaAutosizeImportModel(db, stModel);
	}


	public TextareaAutosizeElementModel newTextareaAutosizeElementModel() {
		return new TextareaAutosizeElementModel(db);
	}

	public TextareaAutosizeElementModel newTextareaAutosizeElementModel(STModel stModel) {
		return new TextareaAutosizeElementModel(db, stModel);
	}

	public TextareaAutosizeElementModel newTextareaAutosizeElementModel(Node node) {
		return new TextareaAutosizeElementModel(db, node);
	}

	public Stream<TextareaAutosizeElementModel> findAllTextareaAutosizeElementModel() {
		return db.findAllSTModelByStTemplate(TextareaAutosizeElementModel.stTemplateUuid)
				.map(stModel -> new TextareaAutosizeElementModel(db, stModel));
	}

	public TextareaAutosizeElementModel findTextareaAutosizeElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TextareaAutosizeElementModel(db, uuid) : new TextareaAutosizeElementModel(db, stModel);
	}


	public TextFieldModel newTextFieldModel() {
		return new TextFieldModel(db);
	}

	public TextFieldModel newTextFieldModel(STModel stModel) {
		return new TextFieldModel(db, stModel);
	}

	public TextFieldModel newTextFieldModel(Node node) {
		return new TextFieldModel(db, node);
	}

	public Stream<TextFieldModel> findAllTextFieldModel() {
		return db.findAllSTModelByStTemplate(TextFieldModel.stTemplateUuid)
				.map(stModel -> new TextFieldModel(db, stModel));
	}

	public TextFieldModel findTextFieldModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TextFieldModel(db, uuid) : new TextFieldModel(db, stModel);
	}


	public TextFieldImportModel newTextFieldImportModel() {
		return new TextFieldImportModel(db);
	}

	public TextFieldImportModel newTextFieldImportModel(STModel stModel) {
		return new TextFieldImportModel(db, stModel);
	}

	public TextFieldImportModel newTextFieldImportModel(Node node) {
		return new TextFieldImportModel(db, node);
	}

	public Stream<TextFieldImportModel> findAllTextFieldImportModel() {
		return db.findAllSTModelByStTemplate(TextFieldImportModel.stTemplateUuid)
				.map(stModel -> new TextFieldImportModel(db, stModel));
	}

	public TextFieldImportModel findTextFieldImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TextFieldImportModel(db, uuid) : new TextFieldImportModel(db, stModel);
	}


	public TextFieldElementModel newTextFieldElementModel() {
		return new TextFieldElementModel(db);
	}

	public TextFieldElementModel newTextFieldElementModel(STModel stModel) {
		return new TextFieldElementModel(db, stModel);
	}

	public TextFieldElementModel newTextFieldElementModel(Node node) {
		return new TextFieldElementModel(db, node);
	}

	public Stream<TextFieldElementModel> findAllTextFieldElementModel() {
		return db.findAllSTModelByStTemplate(TextFieldElementModel.stTemplateUuid)
				.map(stModel -> new TextFieldElementModel(db, stModel));
	}

	public TextFieldElementModel findTextFieldElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TextFieldElementModel(db, uuid) : new TextFieldElementModel(db, stModel);
	}


	public TimelineModel newTimelineModel() {
		return new TimelineModel(db);
	}

	public TimelineModel newTimelineModel(STModel stModel) {
		return new TimelineModel(db, stModel);
	}

	public TimelineModel newTimelineModel(Node node) {
		return new TimelineModel(db, node);
	}

	public Stream<TimelineModel> findAllTimelineModel() {
		return db.findAllSTModelByStTemplate(TimelineModel.stTemplateUuid)
				.map(stModel -> new TimelineModel(db, stModel));
	}

	public TimelineModel findTimelineModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineModel(db, uuid) : new TimelineModel(db, stModel);
	}


	public TimelineImportModel newTimelineImportModel() {
		return new TimelineImportModel(db);
	}

	public TimelineImportModel newTimelineImportModel(STModel stModel) {
		return new TimelineImportModel(db, stModel);
	}

	public TimelineImportModel newTimelineImportModel(Node node) {
		return new TimelineImportModel(db, node);
	}

	public Stream<TimelineImportModel> findAllTimelineImportModel() {
		return db.findAllSTModelByStTemplate(TimelineImportModel.stTemplateUuid)
				.map(stModel -> new TimelineImportModel(db, stModel));
	}

	public TimelineImportModel findTimelineImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineImportModel(db, uuid) : new TimelineImportModel(db, stModel);
	}


	public TimelineElementModel newTimelineElementModel() {
		return new TimelineElementModel(db);
	}

	public TimelineElementModel newTimelineElementModel(STModel stModel) {
		return new TimelineElementModel(db, stModel);
	}

	public TimelineElementModel newTimelineElementModel(Node node) {
		return new TimelineElementModel(db, node);
	}

	public Stream<TimelineElementModel> findAllTimelineElementModel() {
		return db.findAllSTModelByStTemplate(TimelineElementModel.stTemplateUuid)
				.map(stModel -> new TimelineElementModel(db, stModel));
	}

	public TimelineElementModel findTimelineElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineElementModel(db, uuid) : new TimelineElementModel(db, stModel);
	}


	public TimelineConnectorModel newTimelineConnectorModel() {
		return new TimelineConnectorModel(db);
	}

	public TimelineConnectorModel newTimelineConnectorModel(STModel stModel) {
		return new TimelineConnectorModel(db, stModel);
	}

	public TimelineConnectorModel newTimelineConnectorModel(Node node) {
		return new TimelineConnectorModel(db, node);
	}

	public Stream<TimelineConnectorModel> findAllTimelineConnectorModel() {
		return db.findAllSTModelByStTemplate(TimelineConnectorModel.stTemplateUuid)
				.map(stModel -> new TimelineConnectorModel(db, stModel));
	}

	public TimelineConnectorModel findTimelineConnectorModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineConnectorModel(db, uuid) : new TimelineConnectorModel(db, stModel);
	}


	public TimelineConnectorImportModel newTimelineConnectorImportModel() {
		return new TimelineConnectorImportModel(db);
	}

	public TimelineConnectorImportModel newTimelineConnectorImportModel(STModel stModel) {
		return new TimelineConnectorImportModel(db, stModel);
	}

	public TimelineConnectorImportModel newTimelineConnectorImportModel(Node node) {
		return new TimelineConnectorImportModel(db, node);
	}

	public Stream<TimelineConnectorImportModel> findAllTimelineConnectorImportModel() {
		return db.findAllSTModelByStTemplate(TimelineConnectorImportModel.stTemplateUuid)
				.map(stModel -> new TimelineConnectorImportModel(db, stModel));
	}

	public TimelineConnectorImportModel findTimelineConnectorImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineConnectorImportModel(db, uuid) : new TimelineConnectorImportModel(db, stModel);
	}


	public TimelineConnectorElementModel newTimelineConnectorElementModel() {
		return new TimelineConnectorElementModel(db);
	}

	public TimelineConnectorElementModel newTimelineConnectorElementModel(STModel stModel) {
		return new TimelineConnectorElementModel(db, stModel);
	}

	public TimelineConnectorElementModel newTimelineConnectorElementModel(Node node) {
		return new TimelineConnectorElementModel(db, node);
	}

	public Stream<TimelineConnectorElementModel> findAllTimelineConnectorElementModel() {
		return db.findAllSTModelByStTemplate(TimelineConnectorElementModel.stTemplateUuid)
				.map(stModel -> new TimelineConnectorElementModel(db, stModel));
	}

	public TimelineConnectorElementModel findTimelineConnectorElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineConnectorElementModel(db, uuid) : new TimelineConnectorElementModel(db, stModel);
	}


	public TimelineContentModel newTimelineContentModel() {
		return new TimelineContentModel(db);
	}

	public TimelineContentModel newTimelineContentModel(STModel stModel) {
		return new TimelineContentModel(db, stModel);
	}

	public TimelineContentModel newTimelineContentModel(Node node) {
		return new TimelineContentModel(db, node);
	}

	public Stream<TimelineContentModel> findAllTimelineContentModel() {
		return db.findAllSTModelByStTemplate(TimelineContentModel.stTemplateUuid)
				.map(stModel -> new TimelineContentModel(db, stModel));
	}

	public TimelineContentModel findTimelineContentModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineContentModel(db, uuid) : new TimelineContentModel(db, stModel);
	}


	public TimelineContentImportModel newTimelineContentImportModel() {
		return new TimelineContentImportModel(db);
	}

	public TimelineContentImportModel newTimelineContentImportModel(STModel stModel) {
		return new TimelineContentImportModel(db, stModel);
	}

	public TimelineContentImportModel newTimelineContentImportModel(Node node) {
		return new TimelineContentImportModel(db, node);
	}

	public Stream<TimelineContentImportModel> findAllTimelineContentImportModel() {
		return db.findAllSTModelByStTemplate(TimelineContentImportModel.stTemplateUuid)
				.map(stModel -> new TimelineContentImportModel(db, stModel));
	}

	public TimelineContentImportModel findTimelineContentImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineContentImportModel(db, uuid) : new TimelineContentImportModel(db, stModel);
	}


	public TimelineContentElementModel newTimelineContentElementModel() {
		return new TimelineContentElementModel(db);
	}

	public TimelineContentElementModel newTimelineContentElementModel(STModel stModel) {
		return new TimelineContentElementModel(db, stModel);
	}

	public TimelineContentElementModel newTimelineContentElementModel(Node node) {
		return new TimelineContentElementModel(db, node);
	}

	public Stream<TimelineContentElementModel> findAllTimelineContentElementModel() {
		return db.findAllSTModelByStTemplate(TimelineContentElementModel.stTemplateUuid)
				.map(stModel -> new TimelineContentElementModel(db, stModel));
	}

	public TimelineContentElementModel findTimelineContentElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineContentElementModel(db, uuid) : new TimelineContentElementModel(db, stModel);
	}


	public TimelineDotModel newTimelineDotModel() {
		return new TimelineDotModel(db);
	}

	public TimelineDotModel newTimelineDotModel(STModel stModel) {
		return new TimelineDotModel(db, stModel);
	}

	public TimelineDotModel newTimelineDotModel(Node node) {
		return new TimelineDotModel(db, node);
	}

	public Stream<TimelineDotModel> findAllTimelineDotModel() {
		return db.findAllSTModelByStTemplate(TimelineDotModel.stTemplateUuid)
				.map(stModel -> new TimelineDotModel(db, stModel));
	}

	public TimelineDotModel findTimelineDotModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineDotModel(db, uuid) : new TimelineDotModel(db, stModel);
	}


	public TimelineDotImportModel newTimelineDotImportModel() {
		return new TimelineDotImportModel(db);
	}

	public TimelineDotImportModel newTimelineDotImportModel(STModel stModel) {
		return new TimelineDotImportModel(db, stModel);
	}

	public TimelineDotImportModel newTimelineDotImportModel(Node node) {
		return new TimelineDotImportModel(db, node);
	}

	public Stream<TimelineDotImportModel> findAllTimelineDotImportModel() {
		return db.findAllSTModelByStTemplate(TimelineDotImportModel.stTemplateUuid)
				.map(stModel -> new TimelineDotImportModel(db, stModel));
	}

	public TimelineDotImportModel findTimelineDotImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineDotImportModel(db, uuid) : new TimelineDotImportModel(db, stModel);
	}


	public TimelineDotElementModel newTimelineDotElementModel() {
		return new TimelineDotElementModel(db);
	}

	public TimelineDotElementModel newTimelineDotElementModel(STModel stModel) {
		return new TimelineDotElementModel(db, stModel);
	}

	public TimelineDotElementModel newTimelineDotElementModel(Node node) {
		return new TimelineDotElementModel(db, node);
	}

	public Stream<TimelineDotElementModel> findAllTimelineDotElementModel() {
		return db.findAllSTModelByStTemplate(TimelineDotElementModel.stTemplateUuid)
				.map(stModel -> new TimelineDotElementModel(db, stModel));
	}

	public TimelineDotElementModel findTimelineDotElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineDotElementModel(db, uuid) : new TimelineDotElementModel(db, stModel);
	}


	public TimelineItemModel newTimelineItemModel() {
		return new TimelineItemModel(db);
	}

	public TimelineItemModel newTimelineItemModel(STModel stModel) {
		return new TimelineItemModel(db, stModel);
	}

	public TimelineItemModel newTimelineItemModel(Node node) {
		return new TimelineItemModel(db, node);
	}

	public Stream<TimelineItemModel> findAllTimelineItemModel() {
		return db.findAllSTModelByStTemplate(TimelineItemModel.stTemplateUuid)
				.map(stModel -> new TimelineItemModel(db, stModel));
	}

	public TimelineItemModel findTimelineItemModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineItemModel(db, uuid) : new TimelineItemModel(db, stModel);
	}


	public TimelineItemImportModel newTimelineItemImportModel() {
		return new TimelineItemImportModel(db);
	}

	public TimelineItemImportModel newTimelineItemImportModel(STModel stModel) {
		return new TimelineItemImportModel(db, stModel);
	}

	public TimelineItemImportModel newTimelineItemImportModel(Node node) {
		return new TimelineItemImportModel(db, node);
	}

	public Stream<TimelineItemImportModel> findAllTimelineItemImportModel() {
		return db.findAllSTModelByStTemplate(TimelineItemImportModel.stTemplateUuid)
				.map(stModel -> new TimelineItemImportModel(db, stModel));
	}

	public TimelineItemImportModel findTimelineItemImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineItemImportModel(db, uuid) : new TimelineItemImportModel(db, stModel);
	}


	public TimelineItemElementModel newTimelineItemElementModel() {
		return new TimelineItemElementModel(db);
	}

	public TimelineItemElementModel newTimelineItemElementModel(STModel stModel) {
		return new TimelineItemElementModel(db, stModel);
	}

	public TimelineItemElementModel newTimelineItemElementModel(Node node) {
		return new TimelineItemElementModel(db, node);
	}

	public Stream<TimelineItemElementModel> findAllTimelineItemElementModel() {
		return db.findAllSTModelByStTemplate(TimelineItemElementModel.stTemplateUuid)
				.map(stModel -> new TimelineItemElementModel(db, stModel));
	}

	public TimelineItemElementModel findTimelineItemElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineItemElementModel(db, uuid) : new TimelineItemElementModel(db, stModel);
	}


	public TimelineOppositeContentModel newTimelineOppositeContentModel() {
		return new TimelineOppositeContentModel(db);
	}

	public TimelineOppositeContentModel newTimelineOppositeContentModel(STModel stModel) {
		return new TimelineOppositeContentModel(db, stModel);
	}

	public TimelineOppositeContentModel newTimelineOppositeContentModel(Node node) {
		return new TimelineOppositeContentModel(db, node);
	}

	public Stream<TimelineOppositeContentModel> findAllTimelineOppositeContentModel() {
		return db.findAllSTModelByStTemplate(TimelineOppositeContentModel.stTemplateUuid)
				.map(stModel -> new TimelineOppositeContentModel(db, stModel));
	}

	public TimelineOppositeContentModel findTimelineOppositeContentModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineOppositeContentModel(db, uuid) : new TimelineOppositeContentModel(db, stModel);
	}


	public TimelineOppositeContentImportModel newTimelineOppositeContentImportModel() {
		return new TimelineOppositeContentImportModel(db);
	}

	public TimelineOppositeContentImportModel newTimelineOppositeContentImportModel(STModel stModel) {
		return new TimelineOppositeContentImportModel(db, stModel);
	}

	public TimelineOppositeContentImportModel newTimelineOppositeContentImportModel(Node node) {
		return new TimelineOppositeContentImportModel(db, node);
	}

	public Stream<TimelineOppositeContentImportModel> findAllTimelineOppositeContentImportModel() {
		return db.findAllSTModelByStTemplate(TimelineOppositeContentImportModel.stTemplateUuid)
				.map(stModel -> new TimelineOppositeContentImportModel(db, stModel));
	}

	public TimelineOppositeContentImportModel findTimelineOppositeContentImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineOppositeContentImportModel(db, uuid) : new TimelineOppositeContentImportModel(db, stModel);
	}


	public TimelineOppositeContentElementModel newTimelineOppositeContentElementModel() {
		return new TimelineOppositeContentElementModel(db);
	}

	public TimelineOppositeContentElementModel newTimelineOppositeContentElementModel(STModel stModel) {
		return new TimelineOppositeContentElementModel(db, stModel);
	}

	public TimelineOppositeContentElementModel newTimelineOppositeContentElementModel(Node node) {
		return new TimelineOppositeContentElementModel(db, node);
	}

	public Stream<TimelineOppositeContentElementModel> findAllTimelineOppositeContentElementModel() {
		return db.findAllSTModelByStTemplate(TimelineOppositeContentElementModel.stTemplateUuid)
				.map(stModel -> new TimelineOppositeContentElementModel(db, stModel));
	}

	public TimelineOppositeContentElementModel findTimelineOppositeContentElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineOppositeContentElementModel(db, uuid) : new TimelineOppositeContentElementModel(db, stModel);
	}


	public TimelineSeparatorModel newTimelineSeparatorModel() {
		return new TimelineSeparatorModel(db);
	}

	public TimelineSeparatorModel newTimelineSeparatorModel(STModel stModel) {
		return new TimelineSeparatorModel(db, stModel);
	}

	public TimelineSeparatorModel newTimelineSeparatorModel(Node node) {
		return new TimelineSeparatorModel(db, node);
	}

	public Stream<TimelineSeparatorModel> findAllTimelineSeparatorModel() {
		return db.findAllSTModelByStTemplate(TimelineSeparatorModel.stTemplateUuid)
				.map(stModel -> new TimelineSeparatorModel(db, stModel));
	}

	public TimelineSeparatorModel findTimelineSeparatorModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineSeparatorModel(db, uuid) : new TimelineSeparatorModel(db, stModel);
	}


	public TimelineSeparatorImportModel newTimelineSeparatorImportModel() {
		return new TimelineSeparatorImportModel(db);
	}

	public TimelineSeparatorImportModel newTimelineSeparatorImportModel(STModel stModel) {
		return new TimelineSeparatorImportModel(db, stModel);
	}

	public TimelineSeparatorImportModel newTimelineSeparatorImportModel(Node node) {
		return new TimelineSeparatorImportModel(db, node);
	}

	public Stream<TimelineSeparatorImportModel> findAllTimelineSeparatorImportModel() {
		return db.findAllSTModelByStTemplate(TimelineSeparatorImportModel.stTemplateUuid)
				.map(stModel -> new TimelineSeparatorImportModel(db, stModel));
	}

	public TimelineSeparatorImportModel findTimelineSeparatorImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineSeparatorImportModel(db, uuid) : new TimelineSeparatorImportModel(db, stModel);
	}


	public TimelineSeparatorElementModel newTimelineSeparatorElementModel() {
		return new TimelineSeparatorElementModel(db);
	}

	public TimelineSeparatorElementModel newTimelineSeparatorElementModel(STModel stModel) {
		return new TimelineSeparatorElementModel(db, stModel);
	}

	public TimelineSeparatorElementModel newTimelineSeparatorElementModel(Node node) {
		return new TimelineSeparatorElementModel(db, node);
	}

	public Stream<TimelineSeparatorElementModel> findAllTimelineSeparatorElementModel() {
		return db.findAllSTModelByStTemplate(TimelineSeparatorElementModel.stTemplateUuid)
				.map(stModel -> new TimelineSeparatorElementModel(db, stModel));
	}

	public TimelineSeparatorElementModel findTimelineSeparatorElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TimelineSeparatorElementModel(db, uuid) : new TimelineSeparatorElementModel(db, stModel);
	}


	public ToggleButtonModel newToggleButtonModel() {
		return new ToggleButtonModel(db);
	}

	public ToggleButtonModel newToggleButtonModel(STModel stModel) {
		return new ToggleButtonModel(db, stModel);
	}

	public ToggleButtonModel newToggleButtonModel(Node node) {
		return new ToggleButtonModel(db, node);
	}

	public Stream<ToggleButtonModel> findAllToggleButtonModel() {
		return db.findAllSTModelByStTemplate(ToggleButtonModel.stTemplateUuid)
				.map(stModel -> new ToggleButtonModel(db, stModel));
	}

	public ToggleButtonModel findToggleButtonModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ToggleButtonModel(db, uuid) : new ToggleButtonModel(db, stModel);
	}


	public ToggleButtonImportModel newToggleButtonImportModel() {
		return new ToggleButtonImportModel(db);
	}

	public ToggleButtonImportModel newToggleButtonImportModel(STModel stModel) {
		return new ToggleButtonImportModel(db, stModel);
	}

	public ToggleButtonImportModel newToggleButtonImportModel(Node node) {
		return new ToggleButtonImportModel(db, node);
	}

	public Stream<ToggleButtonImportModel> findAllToggleButtonImportModel() {
		return db.findAllSTModelByStTemplate(ToggleButtonImportModel.stTemplateUuid)
				.map(stModel -> new ToggleButtonImportModel(db, stModel));
	}

	public ToggleButtonImportModel findToggleButtonImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ToggleButtonImportModel(db, uuid) : new ToggleButtonImportModel(db, stModel);
	}


	public ToggleButtonElementModel newToggleButtonElementModel() {
		return new ToggleButtonElementModel(db);
	}

	public ToggleButtonElementModel newToggleButtonElementModel(STModel stModel) {
		return new ToggleButtonElementModel(db, stModel);
	}

	public ToggleButtonElementModel newToggleButtonElementModel(Node node) {
		return new ToggleButtonElementModel(db, node);
	}

	public Stream<ToggleButtonElementModel> findAllToggleButtonElementModel() {
		return db.findAllSTModelByStTemplate(ToggleButtonElementModel.stTemplateUuid)
				.map(stModel -> new ToggleButtonElementModel(db, stModel));
	}

	public ToggleButtonElementModel findToggleButtonElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ToggleButtonElementModel(db, uuid) : new ToggleButtonElementModel(db, stModel);
	}


	public ToggleButtonGroupModel newToggleButtonGroupModel() {
		return new ToggleButtonGroupModel(db);
	}

	public ToggleButtonGroupModel newToggleButtonGroupModel(STModel stModel) {
		return new ToggleButtonGroupModel(db, stModel);
	}

	public ToggleButtonGroupModel newToggleButtonGroupModel(Node node) {
		return new ToggleButtonGroupModel(db, node);
	}

	public Stream<ToggleButtonGroupModel> findAllToggleButtonGroupModel() {
		return db.findAllSTModelByStTemplate(ToggleButtonGroupModel.stTemplateUuid)
				.map(stModel -> new ToggleButtonGroupModel(db, stModel));
	}

	public ToggleButtonGroupModel findToggleButtonGroupModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ToggleButtonGroupModel(db, uuid) : new ToggleButtonGroupModel(db, stModel);
	}


	public ToggleButtonGroupImportModel newToggleButtonGroupImportModel() {
		return new ToggleButtonGroupImportModel(db);
	}

	public ToggleButtonGroupImportModel newToggleButtonGroupImportModel(STModel stModel) {
		return new ToggleButtonGroupImportModel(db, stModel);
	}

	public ToggleButtonGroupImportModel newToggleButtonGroupImportModel(Node node) {
		return new ToggleButtonGroupImportModel(db, node);
	}

	public Stream<ToggleButtonGroupImportModel> findAllToggleButtonGroupImportModel() {
		return db.findAllSTModelByStTemplate(ToggleButtonGroupImportModel.stTemplateUuid)
				.map(stModel -> new ToggleButtonGroupImportModel(db, stModel));
	}

	public ToggleButtonGroupImportModel findToggleButtonGroupImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ToggleButtonGroupImportModel(db, uuid) : new ToggleButtonGroupImportModel(db, stModel);
	}


	public ToggleButtonGroupElementModel newToggleButtonGroupElementModel() {
		return new ToggleButtonGroupElementModel(db);
	}

	public ToggleButtonGroupElementModel newToggleButtonGroupElementModel(STModel stModel) {
		return new ToggleButtonGroupElementModel(db, stModel);
	}

	public ToggleButtonGroupElementModel newToggleButtonGroupElementModel(Node node) {
		return new ToggleButtonGroupElementModel(db, node);
	}

	public Stream<ToggleButtonGroupElementModel> findAllToggleButtonGroupElementModel() {
		return db.findAllSTModelByStTemplate(ToggleButtonGroupElementModel.stTemplateUuid)
				.map(stModel -> new ToggleButtonGroupElementModel(db, stModel));
	}

	public ToggleButtonGroupElementModel findToggleButtonGroupElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ToggleButtonGroupElementModel(db, uuid) : new ToggleButtonGroupElementModel(db, stModel);
	}


	public ToolbarModel newToolbarModel() {
		return new ToolbarModel(db);
	}

	public ToolbarModel newToolbarModel(STModel stModel) {
		return new ToolbarModel(db, stModel);
	}

	public ToolbarModel newToolbarModel(Node node) {
		return new ToolbarModel(db, node);
	}

	public Stream<ToolbarModel> findAllToolbarModel() {
		return db.findAllSTModelByStTemplate(ToolbarModel.stTemplateUuid)
				.map(stModel -> new ToolbarModel(db, stModel));
	}

	public ToolbarModel findToolbarModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ToolbarModel(db, uuid) : new ToolbarModel(db, stModel);
	}


	public ToolbarImportModel newToolbarImportModel() {
		return new ToolbarImportModel(db);
	}

	public ToolbarImportModel newToolbarImportModel(STModel stModel) {
		return new ToolbarImportModel(db, stModel);
	}

	public ToolbarImportModel newToolbarImportModel(Node node) {
		return new ToolbarImportModel(db, node);
	}

	public Stream<ToolbarImportModel> findAllToolbarImportModel() {
		return db.findAllSTModelByStTemplate(ToolbarImportModel.stTemplateUuid)
				.map(stModel -> new ToolbarImportModel(db, stModel));
	}

	public ToolbarImportModel findToolbarImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ToolbarImportModel(db, uuid) : new ToolbarImportModel(db, stModel);
	}


	public ToolbarElementModel newToolbarElementModel() {
		return new ToolbarElementModel(db);
	}

	public ToolbarElementModel newToolbarElementModel(STModel stModel) {
		return new ToolbarElementModel(db, stModel);
	}

	public ToolbarElementModel newToolbarElementModel(Node node) {
		return new ToolbarElementModel(db, node);
	}

	public Stream<ToolbarElementModel> findAllToolbarElementModel() {
		return db.findAllSTModelByStTemplate(ToolbarElementModel.stTemplateUuid)
				.map(stModel -> new ToolbarElementModel(db, stModel));
	}

	public ToolbarElementModel findToolbarElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ToolbarElementModel(db, uuid) : new ToolbarElementModel(db, stModel);
	}


	public TooltipModel newTooltipModel() {
		return new TooltipModel(db);
	}

	public TooltipModel newTooltipModel(STModel stModel) {
		return new TooltipModel(db, stModel);
	}

	public TooltipModel newTooltipModel(Node node) {
		return new TooltipModel(db, node);
	}

	public Stream<TooltipModel> findAllTooltipModel() {
		return db.findAllSTModelByStTemplate(TooltipModel.stTemplateUuid)
				.map(stModel -> new TooltipModel(db, stModel));
	}

	public TooltipModel findTooltipModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TooltipModel(db, uuid) : new TooltipModel(db, stModel);
	}


	public TooltipImportModel newTooltipImportModel() {
		return new TooltipImportModel(db);
	}

	public TooltipImportModel newTooltipImportModel(STModel stModel) {
		return new TooltipImportModel(db, stModel);
	}

	public TooltipImportModel newTooltipImportModel(Node node) {
		return new TooltipImportModel(db, node);
	}

	public Stream<TooltipImportModel> findAllTooltipImportModel() {
		return db.findAllSTModelByStTemplate(TooltipImportModel.stTemplateUuid)
				.map(stModel -> new TooltipImportModel(db, stModel));
	}

	public TooltipImportModel findTooltipImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TooltipImportModel(db, uuid) : new TooltipImportModel(db, stModel);
	}


	public TooltipElementModel newTooltipElementModel() {
		return new TooltipElementModel(db);
	}

	public TooltipElementModel newTooltipElementModel(STModel stModel) {
		return new TooltipElementModel(db, stModel);
	}

	public TooltipElementModel newTooltipElementModel(Node node) {
		return new TooltipElementModel(db, node);
	}

	public Stream<TooltipElementModel> findAllTooltipElementModel() {
		return db.findAllSTModelByStTemplate(TooltipElementModel.stTemplateUuid)
				.map(stModel -> new TooltipElementModel(db, stModel));
	}

	public TooltipElementModel findTooltipElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TooltipElementModel(db, uuid) : new TooltipElementModel(db, stModel);
	}


	public TreeItemModel newTreeItemModel() {
		return new TreeItemModel(db);
	}

	public TreeItemModel newTreeItemModel(STModel stModel) {
		return new TreeItemModel(db, stModel);
	}

	public TreeItemModel newTreeItemModel(Node node) {
		return new TreeItemModel(db, node);
	}

	public Stream<TreeItemModel> findAllTreeItemModel() {
		return db.findAllSTModelByStTemplate(TreeItemModel.stTemplateUuid)
				.map(stModel -> new TreeItemModel(db, stModel));
	}

	public TreeItemModel findTreeItemModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TreeItemModel(db, uuid) : new TreeItemModel(db, stModel);
	}


	public TreeItemImportModel newTreeItemImportModel() {
		return new TreeItemImportModel(db);
	}

	public TreeItemImportModel newTreeItemImportModel(STModel stModel) {
		return new TreeItemImportModel(db, stModel);
	}

	public TreeItemImportModel newTreeItemImportModel(Node node) {
		return new TreeItemImportModel(db, node);
	}

	public Stream<TreeItemImportModel> findAllTreeItemImportModel() {
		return db.findAllSTModelByStTemplate(TreeItemImportModel.stTemplateUuid)
				.map(stModel -> new TreeItemImportModel(db, stModel));
	}

	public TreeItemImportModel findTreeItemImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TreeItemImportModel(db, uuid) : new TreeItemImportModel(db, stModel);
	}


	public TreeItemElementModel newTreeItemElementModel() {
		return new TreeItemElementModel(db);
	}

	public TreeItemElementModel newTreeItemElementModel(STModel stModel) {
		return new TreeItemElementModel(db, stModel);
	}

	public TreeItemElementModel newTreeItemElementModel(Node node) {
		return new TreeItemElementModel(db, node);
	}

	public Stream<TreeItemElementModel> findAllTreeItemElementModel() {
		return db.findAllSTModelByStTemplate(TreeItemElementModel.stTemplateUuid)
				.map(stModel -> new TreeItemElementModel(db, stModel));
	}

	public TreeItemElementModel findTreeItemElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TreeItemElementModel(db, uuid) : new TreeItemElementModel(db, stModel);
	}


	public TreeViewModel newTreeViewModel() {
		return new TreeViewModel(db);
	}

	public TreeViewModel newTreeViewModel(STModel stModel) {
		return new TreeViewModel(db, stModel);
	}

	public TreeViewModel newTreeViewModel(Node node) {
		return new TreeViewModel(db, node);
	}

	public Stream<TreeViewModel> findAllTreeViewModel() {
		return db.findAllSTModelByStTemplate(TreeViewModel.stTemplateUuid)
				.map(stModel -> new TreeViewModel(db, stModel));
	}

	public TreeViewModel findTreeViewModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TreeViewModel(db, uuid) : new TreeViewModel(db, stModel);
	}


	public TreeViewImportModel newTreeViewImportModel() {
		return new TreeViewImportModel(db);
	}

	public TreeViewImportModel newTreeViewImportModel(STModel stModel) {
		return new TreeViewImportModel(db, stModel);
	}

	public TreeViewImportModel newTreeViewImportModel(Node node) {
		return new TreeViewImportModel(db, node);
	}

	public Stream<TreeViewImportModel> findAllTreeViewImportModel() {
		return db.findAllSTModelByStTemplate(TreeViewImportModel.stTemplateUuid)
				.map(stModel -> new TreeViewImportModel(db, stModel));
	}

	public TreeViewImportModel findTreeViewImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TreeViewImportModel(db, uuid) : new TreeViewImportModel(db, stModel);
	}


	public TreeViewElementModel newTreeViewElementModel() {
		return new TreeViewElementModel(db);
	}

	public TreeViewElementModel newTreeViewElementModel(STModel stModel) {
		return new TreeViewElementModel(db, stModel);
	}

	public TreeViewElementModel newTreeViewElementModel(Node node) {
		return new TreeViewElementModel(db, node);
	}

	public Stream<TreeViewElementModel> findAllTreeViewElementModel() {
		return db.findAllSTModelByStTemplate(TreeViewElementModel.stTemplateUuid)
				.map(stModel -> new TreeViewElementModel(db, stModel));
	}

	public TreeViewElementModel findTreeViewElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TreeViewElementModel(db, uuid) : new TreeViewElementModel(db, stModel);
	}


	public TypographyModel newTypographyModel() {
		return new TypographyModel(db);
	}

	public TypographyModel newTypographyModel(STModel stModel) {
		return new TypographyModel(db, stModel);
	}

	public TypographyModel newTypographyModel(Node node) {
		return new TypographyModel(db, node);
	}

	public Stream<TypographyModel> findAllTypographyModel() {
		return db.findAllSTModelByStTemplate(TypographyModel.stTemplateUuid)
				.map(stModel -> new TypographyModel(db, stModel));
	}

	public TypographyModel findTypographyModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TypographyModel(db, uuid) : new TypographyModel(db, stModel);
	}


	public TypographyImportModel newTypographyImportModel() {
		return new TypographyImportModel(db);
	}

	public TypographyImportModel newTypographyImportModel(STModel stModel) {
		return new TypographyImportModel(db, stModel);
	}

	public TypographyImportModel newTypographyImportModel(Node node) {
		return new TypographyImportModel(db, node);
	}

	public Stream<TypographyImportModel> findAllTypographyImportModel() {
		return db.findAllSTModelByStTemplate(TypographyImportModel.stTemplateUuid)
				.map(stModel -> new TypographyImportModel(db, stModel));
	}

	public TypographyImportModel findTypographyImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TypographyImportModel(db, uuid) : new TypographyImportModel(db, stModel);
	}


	public TypographyElementModel newTypographyElementModel() {
		return new TypographyElementModel(db);
	}

	public TypographyElementModel newTypographyElementModel(STModel stModel) {
		return new TypographyElementModel(db, stModel);
	}

	public TypographyElementModel newTypographyElementModel(Node node) {
		return new TypographyElementModel(db, node);
	}

	public Stream<TypographyElementModel> findAllTypographyElementModel() {
		return db.findAllSTModelByStTemplate(TypographyElementModel.stTemplateUuid)
				.map(stModel -> new TypographyElementModel(db, stModel));
	}

	public TypographyElementModel findTypographyElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new TypographyElementModel(db, uuid) : new TypographyElementModel(db, stModel);
	}


	public UnstableTrapFocusModel newUnstableTrapFocusModel() {
		return new UnstableTrapFocusModel(db);
	}

	public UnstableTrapFocusModel newUnstableTrapFocusModel(STModel stModel) {
		return new UnstableTrapFocusModel(db, stModel);
	}

	public UnstableTrapFocusModel newUnstableTrapFocusModel(Node node) {
		return new UnstableTrapFocusModel(db, node);
	}

	public Stream<UnstableTrapFocusModel> findAllUnstableTrapFocusModel() {
		return db.findAllSTModelByStTemplate(UnstableTrapFocusModel.stTemplateUuid)
				.map(stModel -> new UnstableTrapFocusModel(db, stModel));
	}

	public UnstableTrapFocusModel findUnstableTrapFocusModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new UnstableTrapFocusModel(db, uuid) : new UnstableTrapFocusModel(db, stModel);
	}


	public UnstableTrapFocusImportModel newUnstableTrapFocusImportModel() {
		return new UnstableTrapFocusImportModel(db);
	}

	public UnstableTrapFocusImportModel newUnstableTrapFocusImportModel(STModel stModel) {
		return new UnstableTrapFocusImportModel(db, stModel);
	}

	public UnstableTrapFocusImportModel newUnstableTrapFocusImportModel(Node node) {
		return new UnstableTrapFocusImportModel(db, node);
	}

	public Stream<UnstableTrapFocusImportModel> findAllUnstableTrapFocusImportModel() {
		return db.findAllSTModelByStTemplate(UnstableTrapFocusImportModel.stTemplateUuid)
				.map(stModel -> new UnstableTrapFocusImportModel(db, stModel));
	}

	public UnstableTrapFocusImportModel findUnstableTrapFocusImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new UnstableTrapFocusImportModel(db, uuid) : new UnstableTrapFocusImportModel(db, stModel);
	}


	public UnstableTrapFocusElementModel newUnstableTrapFocusElementModel() {
		return new UnstableTrapFocusElementModel(db);
	}

	public UnstableTrapFocusElementModel newUnstableTrapFocusElementModel(STModel stModel) {
		return new UnstableTrapFocusElementModel(db, stModel);
	}

	public UnstableTrapFocusElementModel newUnstableTrapFocusElementModel(Node node) {
		return new UnstableTrapFocusElementModel(db, node);
	}

	public Stream<UnstableTrapFocusElementModel> findAllUnstableTrapFocusElementModel() {
		return db.findAllSTModelByStTemplate(UnstableTrapFocusElementModel.stTemplateUuid)
				.map(stModel -> new UnstableTrapFocusElementModel(db, stModel));
	}

	public UnstableTrapFocusElementModel findUnstableTrapFocusElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new UnstableTrapFocusElementModel(db, uuid) : new UnstableTrapFocusElementModel(db, stModel);
	}


	public ZoomModel newZoomModel() {
		return new ZoomModel(db);
	}

	public ZoomModel newZoomModel(STModel stModel) {
		return new ZoomModel(db, stModel);
	}

	public ZoomModel newZoomModel(Node node) {
		return new ZoomModel(db, node);
	}

	public Stream<ZoomModel> findAllZoomModel() {
		return db.findAllSTModelByStTemplate(ZoomModel.stTemplateUuid)
				.map(stModel -> new ZoomModel(db, stModel));
	}

	public ZoomModel findZoomModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ZoomModel(db, uuid) : new ZoomModel(db, stModel);
	}


	public ZoomImportModel newZoomImportModel() {
		return new ZoomImportModel(db);
	}

	public ZoomImportModel newZoomImportModel(STModel stModel) {
		return new ZoomImportModel(db, stModel);
	}

	public ZoomImportModel newZoomImportModel(Node node) {
		return new ZoomImportModel(db, node);
	}

	public Stream<ZoomImportModel> findAllZoomImportModel() {
		return db.findAllSTModelByStTemplate(ZoomImportModel.stTemplateUuid)
				.map(stModel -> new ZoomImportModel(db, stModel));
	}

	public ZoomImportModel findZoomImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ZoomImportModel(db, uuid) : new ZoomImportModel(db, stModel);
	}


	public ZoomElementModel newZoomElementModel() {
		return new ZoomElementModel(db);
	}

	public ZoomElementModel newZoomElementModel(STModel stModel) {
		return new ZoomElementModel(db, stModel);
	}

	public ZoomElementModel newZoomElementModel(Node node) {
		return new ZoomElementModel(db, node);
	}

	public Stream<ZoomElementModel> findAllZoomElementModel() {
		return db.findAllSTModelByStTemplate(ZoomElementModel.stTemplateUuid)
				.map(stModel -> new ZoomElementModel(db, stModel));
	}

	public ZoomElementModel findZoomElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new ZoomElementModel(db, uuid) : new ZoomElementModel(db, stModel);
	}


	public BoxModel newBoxModel() {
		return new BoxModel(db);
	}

	public BoxModel newBoxModel(STModel stModel) {
		return new BoxModel(db, stModel);
	}

	public BoxModel newBoxModel(Node node) {
		return new BoxModel(db, node);
	}

	public Stream<BoxModel> findAllBoxModel() {
		return db.findAllSTModelByStTemplate(BoxModel.stTemplateUuid)
				.map(stModel -> new BoxModel(db, stModel));
	}

	public BoxModel findBoxModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BoxModel(db, uuid) : new BoxModel(db, stModel);
	}


	public BoxImportModel newBoxImportModel() {
		return new BoxImportModel(db);
	}

	public BoxImportModel newBoxImportModel(STModel stModel) {
		return new BoxImportModel(db, stModel);
	}

	public BoxImportModel newBoxImportModel(Node node) {
		return new BoxImportModel(db, node);
	}

	public Stream<BoxImportModel> findAllBoxImportModel() {
		return db.findAllSTModelByStTemplate(BoxImportModel.stTemplateUuid)
				.map(stModel -> new BoxImportModel(db, stModel));
	}

	public BoxImportModel findBoxImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BoxImportModel(db, uuid) : new BoxImportModel(db, stModel);
	}


	public BoxElementModel newBoxElementModel() {
		return new BoxElementModel(db);
	}

	public BoxElementModel newBoxElementModel(STModel stModel) {
		return new BoxElementModel(db, stModel);
	}

	public BoxElementModel newBoxElementModel(Node node) {
		return new BoxElementModel(db, node);
	}

	public Stream<BoxElementModel> findAllBoxElementModel() {
		return db.findAllSTModelByStTemplate(BoxElementModel.stTemplateUuid)
				.map(stModel -> new BoxElementModel(db, stModel));
	}

	public BoxElementModel findBoxElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new BoxElementModel(db, uuid) : new BoxElementModel(db, stModel);
	}


	public LockOutlinedIconModel newLockOutlinedIconModel() {
		return new LockOutlinedIconModel(db);
	}

	public LockOutlinedIconModel newLockOutlinedIconModel(STModel stModel) {
		return new LockOutlinedIconModel(db, stModel);
	}

	public LockOutlinedIconModel newLockOutlinedIconModel(Node node) {
		return new LockOutlinedIconModel(db, node);
	}

	public Stream<LockOutlinedIconModel> findAllLockOutlinedIconModel() {
		return db.findAllSTModelByStTemplate(LockOutlinedIconModel.stTemplateUuid)
				.map(stModel -> new LockOutlinedIconModel(db, stModel));
	}

	public LockOutlinedIconModel findLockOutlinedIconModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new LockOutlinedIconModel(db, uuid) : new LockOutlinedIconModel(db, stModel);
	}


	public LockOutlinedIconImportModel newLockOutlinedIconImportModel() {
		return new LockOutlinedIconImportModel(db);
	}

	public LockOutlinedIconImportModel newLockOutlinedIconImportModel(STModel stModel) {
		return new LockOutlinedIconImportModel(db, stModel);
	}

	public LockOutlinedIconImportModel newLockOutlinedIconImportModel(Node node) {
		return new LockOutlinedIconImportModel(db, node);
	}

	public Stream<LockOutlinedIconImportModel> findAllLockOutlinedIconImportModel() {
		return db.findAllSTModelByStTemplate(LockOutlinedIconImportModel.stTemplateUuid)
				.map(stModel -> new LockOutlinedIconImportModel(db, stModel));
	}

	public LockOutlinedIconImportModel findLockOutlinedIconImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new LockOutlinedIconImportModel(db, uuid) : new LockOutlinedIconImportModel(db, stModel);
	}


	public LockOutlinedIconElementModel newLockOutlinedIconElementModel() {
		return new LockOutlinedIconElementModel(db);
	}

	public LockOutlinedIconElementModel newLockOutlinedIconElementModel(STModel stModel) {
		return new LockOutlinedIconElementModel(db, stModel);
	}

	public LockOutlinedIconElementModel newLockOutlinedIconElementModel(Node node) {
		return new LockOutlinedIconElementModel(db, node);
	}

	public Stream<LockOutlinedIconElementModel> findAllLockOutlinedIconElementModel() {
		return db.findAllSTModelByStTemplate(LockOutlinedIconElementModel.stTemplateUuid)
				.map(stModel -> new LockOutlinedIconElementModel(db, stModel));
	}

	public LockOutlinedIconElementModel findLockOutlinedIconElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new LockOutlinedIconElementModel(db, uuid) : new LockOutlinedIconElementModel(db, stModel);
	}


	public MenuIconModel newMenuIconModel() {
		return new MenuIconModel(db);
	}

	public MenuIconModel newMenuIconModel(STModel stModel) {
		return new MenuIconModel(db, stModel);
	}

	public MenuIconModel newMenuIconModel(Node node) {
		return new MenuIconModel(db, node);
	}

	public Stream<MenuIconModel> findAllMenuIconModel() {
		return db.findAllSTModelByStTemplate(MenuIconModel.stTemplateUuid)
				.map(stModel -> new MenuIconModel(db, stModel));
	}

	public MenuIconModel findMenuIconModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MenuIconModel(db, uuid) : new MenuIconModel(db, stModel);
	}


	public MenuIconImportModel newMenuIconImportModel() {
		return new MenuIconImportModel(db);
	}

	public MenuIconImportModel newMenuIconImportModel(STModel stModel) {
		return new MenuIconImportModel(db, stModel);
	}

	public MenuIconImportModel newMenuIconImportModel(Node node) {
		return new MenuIconImportModel(db, node);
	}

	public Stream<MenuIconImportModel> findAllMenuIconImportModel() {
		return db.findAllSTModelByStTemplate(MenuIconImportModel.stTemplateUuid)
				.map(stModel -> new MenuIconImportModel(db, stModel));
	}

	public MenuIconImportModel findMenuIconImportModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MenuIconImportModel(db, uuid) : new MenuIconImportModel(db, stModel);
	}


	public MenuIconElementModel newMenuIconElementModel() {
		return new MenuIconElementModel(db);
	}

	public MenuIconElementModel newMenuIconElementModel(STModel stModel) {
		return new MenuIconElementModel(db, stModel);
	}

	public MenuIconElementModel newMenuIconElementModel(Node node) {
		return new MenuIconElementModel(db, node);
	}

	public Stream<MenuIconElementModel> findAllMenuIconElementModel() {
		return db.findAllSTModelByStTemplate(MenuIconElementModel.stTemplateUuid)
				.map(stModel -> new MenuIconElementModel(db, stModel));
	}

	public MenuIconElementModel findMenuIconElementModel(String uuid) {
		final STModel stModel = db.findSTModelByUuid(uuid);
		return stModel == null ? new MenuIconElementModel(db, uuid) : new MenuIconElementModel(db, stModel);
	}


	public Optional<AccordionElementModel> findAccordionElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, AccordionElementModel.stTemplateUuid, AccordionElementModel::new));
	}

	public Optional<AccordionElementModel> findAccordionElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, AccordionElementModel.stTemplateUuid, AccordionElementModel::new));
	}

	public Optional<AccordionElementModel> findAccordionElementModelByDefaultExpanded(STValue value) {
		return Optional.ofNullable(db.find("defaultExpanded", value, AccordionElementModel.stTemplateUuid, AccordionElementModel::new));
	}

	public Optional<AccordionElementModel> findAccordionElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, AccordionElementModel.stTemplateUuid, AccordionElementModel::new));
	}

	public Optional<AccordionElementModel> findAccordionElementModelByExpanded(STValue value) {
		return Optional.ofNullable(db.find("expanded", value, AccordionElementModel.stTemplateUuid, AccordionElementModel::new));
	}

	public Optional<AccordionElementModel> findAccordionElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, AccordionElementModel.stTemplateUuid, AccordionElementModel::new));
	}

	public Optional<AccordionElementModel> findAccordionElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, AccordionElementModel.stTemplateUuid, AccordionElementModel::new));
	}

	public Optional<AccordionElementModel> findAccordionElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, AccordionElementModel.stTemplateUuid, AccordionElementModel::new));
	}

	public Optional<AccordionElementModel> findAccordionElementModelBySquare(STValue value) {
		return Optional.ofNullable(db.find("square", value, AccordionElementModel.stTemplateUuid, AccordionElementModel::new));
	}

	public Optional<AccordionElementModel> findAccordionElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, AccordionElementModel.stTemplateUuid, AccordionElementModel::new));
	}

	public Optional<AccordionElementModel> findAccordionElementModelByTransitionComponent(STValue value) {
		return Optional.ofNullable(db.find("TransitionComponent", value, AccordionElementModel.stTemplateUuid, AccordionElementModel::new));
	}

	public Optional<AccordionElementModel> findAccordionElementModelByTransitionProps(STValue value) {
		return Optional.ofNullable(db.find("TransitionProps", value, AccordionElementModel.stTemplateUuid, AccordionElementModel::new));
	}

	public Optional<AccordionActionsElementModel> findAccordionActionsElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, AccordionActionsElementModel.stTemplateUuid, AccordionActionsElementModel::new));
	}

	public Optional<AccordionActionsElementModel> findAccordionActionsElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, AccordionActionsElementModel.stTemplateUuid, AccordionActionsElementModel::new));
	}

	public Optional<AccordionActionsElementModel> findAccordionActionsElementModelByDisableSpacing(STValue value) {
		return Optional.ofNullable(db.find("disableSpacing", value, AccordionActionsElementModel.stTemplateUuid, AccordionActionsElementModel::new));
	}

	public Optional<AccordionActionsElementModel> findAccordionActionsElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, AccordionActionsElementModel.stTemplateUuid, AccordionActionsElementModel::new));
	}

	public Optional<AccordionActionsElementModel> findAccordionActionsElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, AccordionActionsElementModel.stTemplateUuid, AccordionActionsElementModel::new));
	}

	public Optional<AccordionActionsElementModel> findAccordionActionsElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, AccordionActionsElementModel.stTemplateUuid, AccordionActionsElementModel::new));
	}

	public Optional<AccordionDetailsElementModel> findAccordionDetailsElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, AccordionDetailsElementModel.stTemplateUuid, AccordionDetailsElementModel::new));
	}

	public Optional<AccordionDetailsElementModel> findAccordionDetailsElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, AccordionDetailsElementModel.stTemplateUuid, AccordionDetailsElementModel::new));
	}

	public Optional<AccordionDetailsElementModel> findAccordionDetailsElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, AccordionDetailsElementModel.stTemplateUuid, AccordionDetailsElementModel::new));
	}

	public Optional<AccordionDetailsElementModel> findAccordionDetailsElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, AccordionDetailsElementModel.stTemplateUuid, AccordionDetailsElementModel::new));
	}

	public Optional<AccordionDetailsElementModel> findAccordionDetailsElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, AccordionDetailsElementModel.stTemplateUuid, AccordionDetailsElementModel::new));
	}

	public Optional<AccordionSummaryElementModel> findAccordionSummaryElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, AccordionSummaryElementModel.stTemplateUuid, AccordionSummaryElementModel::new));
	}

	public Optional<AccordionSummaryElementModel> findAccordionSummaryElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, AccordionSummaryElementModel.stTemplateUuid, AccordionSummaryElementModel::new));
	}

	public Optional<AccordionSummaryElementModel> findAccordionSummaryElementModelByExpandIcon(STValue value) {
		return Optional.ofNullable(db.find("expandIcon", value, AccordionSummaryElementModel.stTemplateUuid, AccordionSummaryElementModel::new));
	}

	public Optional<AccordionSummaryElementModel> findAccordionSummaryElementModelByIconButtonProps(STValue value) {
		return Optional.ofNullable(db.find("IconButtonProps", value, AccordionSummaryElementModel.stTemplateUuid, AccordionSummaryElementModel::new));
	}

	public Optional<AccordionSummaryElementModel> findAccordionSummaryElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, AccordionSummaryElementModel.stTemplateUuid, AccordionSummaryElementModel::new));
	}

	public Optional<AccordionSummaryElementModel> findAccordionSummaryElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, AccordionSummaryElementModel.stTemplateUuid, AccordionSummaryElementModel::new));
	}

	public Optional<AccordionSummaryElementModel> findAccordionSummaryElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, AccordionSummaryElementModel.stTemplateUuid, AccordionSummaryElementModel::new));
	}

	public Optional<AlertElementModel> findAlertElementModelByAction(STValue value) {
		return Optional.ofNullable(db.find("action", value, AlertElementModel.stTemplateUuid, AlertElementModel::new));
	}

	public Optional<AlertElementModel> findAlertElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, AlertElementModel.stTemplateUuid, AlertElementModel::new));
	}

	public Optional<AlertElementModel> findAlertElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, AlertElementModel.stTemplateUuid, AlertElementModel::new));
	}

	public Optional<AlertElementModel> findAlertElementModelByCloseText(STValue value) {
		return Optional.ofNullable(db.find("closeText", value, AlertElementModel.stTemplateUuid, AlertElementModel::new));
	}

	public Optional<AlertElementModel> findAlertElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, AlertElementModel.stTemplateUuid, AlertElementModel::new));
	}

	public Optional<AlertElementModel> findAlertElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, AlertElementModel.stTemplateUuid, AlertElementModel::new));
	}

	public Optional<AlertElementModel> findAlertElementModelByIconMapping(STValue value) {
		return Optional.ofNullable(db.find("iconMapping", value, AlertElementModel.stTemplateUuid, AlertElementModel::new));
	}

	public Optional<AlertElementModel> findAlertElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, AlertElementModel.stTemplateUuid, AlertElementModel::new));
	}

	public Optional<AlertElementModel> findAlertElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, AlertElementModel.stTemplateUuid, AlertElementModel::new));
	}

	public Optional<AlertElementModel> findAlertElementModelByOnClose(STValue value) {
		return Optional.ofNullable(db.find("onClose", value, AlertElementModel.stTemplateUuid, AlertElementModel::new));
	}

	public Optional<AlertElementModel> findAlertElementModelByRole(STValue value) {
		return Optional.ofNullable(db.find("role", value, AlertElementModel.stTemplateUuid, AlertElementModel::new));
	}

	public Optional<AlertElementModel> findAlertElementModelBySeverity(STValue value) {
		return Optional.ofNullable(db.find("severity", value, AlertElementModel.stTemplateUuid, AlertElementModel::new));
	}

	public Optional<AlertElementModel> findAlertElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, AlertElementModel.stTemplateUuid, AlertElementModel::new));
	}

	public Optional<AlertElementModel> findAlertElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, AlertElementModel.stTemplateUuid, AlertElementModel::new));
	}

	public Optional<AlertTitleElementModel> findAlertTitleElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, AlertTitleElementModel.stTemplateUuid, AlertTitleElementModel::new));
	}

	public Optional<AlertTitleElementModel> findAlertTitleElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, AlertTitleElementModel.stTemplateUuid, AlertTitleElementModel::new));
	}

	public Optional<AlertTitleElementModel> findAlertTitleElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, AlertTitleElementModel.stTemplateUuid, AlertTitleElementModel::new));
	}

	public Optional<AlertTitleElementModel> findAlertTitleElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, AlertTitleElementModel.stTemplateUuid, AlertTitleElementModel::new));
	}

	public Optional<AlertTitleElementModel> findAlertTitleElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, AlertTitleElementModel.stTemplateUuid, AlertTitleElementModel::new));
	}

	public Optional<AppBarElementModel> findAppBarElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, AppBarElementModel.stTemplateUuid, AppBarElementModel::new));
	}

	public Optional<AppBarElementModel> findAppBarElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, AppBarElementModel.stTemplateUuid, AppBarElementModel::new));
	}

	public Optional<AppBarElementModel> findAppBarElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, AppBarElementModel.stTemplateUuid, AppBarElementModel::new));
	}

	public Optional<AppBarElementModel> findAppBarElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, AppBarElementModel.stTemplateUuid, AppBarElementModel::new));
	}

	public Optional<AppBarElementModel> findAppBarElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, AppBarElementModel.stTemplateUuid, AppBarElementModel::new));
	}

	public Optional<AppBarElementModel> findAppBarElementModelByPosition(STValue value) {
		return Optional.ofNullable(db.find("position", value, AppBarElementModel.stTemplateUuid, AppBarElementModel::new));
	}

	public Optional<AppBarElementModel> findAppBarElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, AppBarElementModel.stTemplateUuid, AppBarElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByAutoComplete(STValue value) {
		return Optional.ofNullable(db.find("autoComplete", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByAutoHighlight(STValue value) {
		return Optional.ofNullable(db.find("autoHighlight", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByAutoSelect(STValue value) {
		return Optional.ofNullable(db.find("autoSelect", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByBlurOnSelect(STValue value) {
		return Optional.ofNullable(db.find("blurOnSelect", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByChipProps(STValue value) {
		return Optional.ofNullable(db.find("ChipProps", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByClearOnBlur(STValue value) {
		return Optional.ofNullable(db.find("clearOnBlur", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByClearOnEscape(STValue value) {
		return Optional.ofNullable(db.find("clearOnEscape", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByClearText(STValue value) {
		return Optional.ofNullable(db.find("clearText", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByCloseIcon(STValue value) {
		return Optional.ofNullable(db.find("closeIcon", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByCloseText(STValue value) {
		return Optional.ofNullable(db.find("closeText", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByDebug(STValue value) {
		return Optional.ofNullable(db.find("debug", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByDefaultValue(STValue value) {
		return Optional.ofNullable(db.find("defaultValue", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByDisableClearable(STValue value) {
		return Optional.ofNullable(db.find("disableClearable", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByDisableCloseOnSelect(STValue value) {
		return Optional.ofNullable(db.find("disableCloseOnSelect", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByDisabledItemsFocusable(STValue value) {
		return Optional.ofNullable(db.find("disabledItemsFocusable", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByDisableListWrap(STValue value) {
		return Optional.ofNullable(db.find("disableListWrap", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByDisablePortal(STValue value) {
		return Optional.ofNullable(db.find("disablePortal", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByFilterOptions(STValue value) {
		return Optional.ofNullable(db.find("filterOptions", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByFilterSelectedOptions(STValue value) {
		return Optional.ofNullable(db.find("filterSelectedOptions", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByForcePopupIcon(STValue value) {
		return Optional.ofNullable(db.find("forcePopupIcon", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByFreeSolo(STValue value) {
		return Optional.ofNullable(db.find("freeSolo", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByFullWidth(STValue value) {
		return Optional.ofNullable(db.find("fullWidth", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByGetLimitTagsText(STValue value) {
		return Optional.ofNullable(db.find("getLimitTagsText", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByGetOptionDisabled(STValue value) {
		return Optional.ofNullable(db.find("getOptionDisabled", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByGetOptionLabel(STValue value) {
		return Optional.ofNullable(db.find("getOptionLabel", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByGetOptionSelected(STValue value) {
		return Optional.ofNullable(db.find("getOptionSelected", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByGroupBy(STValue value) {
		return Optional.ofNullable(db.find("groupBy", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByHandleHomeEndKeys(STValue value) {
		return Optional.ofNullable(db.find("handleHomeEndKeys", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByIncludeInputInList(STValue value) {
		return Optional.ofNullable(db.find("includeInputInList", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByInputValue(STValue value) {
		return Optional.ofNullable(db.find("inputValue", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByLimitTags(STValue value) {
		return Optional.ofNullable(db.find("limitTags", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByListboxComponent(STValue value) {
		return Optional.ofNullable(db.find("ListboxComponent", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByListboxProps(STValue value) {
		return Optional.ofNullable(db.find("ListboxProps", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByLoading(STValue value) {
		return Optional.ofNullable(db.find("loading", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByLoadingText(STValue value) {
		return Optional.ofNullable(db.find("loadingText", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByMultiple(STValue value) {
		return Optional.ofNullable(db.find("multiple", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByNoOptionsText(STValue value) {
		return Optional.ofNullable(db.find("noOptionsText", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByOnClose(STValue value) {
		return Optional.ofNullable(db.find("onClose", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByOnHighlightChange(STValue value) {
		return Optional.ofNullable(db.find("onHighlightChange", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByOnInputChange(STValue value) {
		return Optional.ofNullable(db.find("onInputChange", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByOnOpen(STValue value) {
		return Optional.ofNullable(db.find("onOpen", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByOpen(STValue value) {
		return Optional.ofNullable(db.find("open", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByOpenOnFocus(STValue value) {
		return Optional.ofNullable(db.find("openOnFocus", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByOpenText(STValue value) {
		return Optional.ofNullable(db.find("openText", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByOptions(STValue value) {
		return Optional.ofNullable(db.find("options", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByPaperComponent(STValue value) {
		return Optional.ofNullable(db.find("PaperComponent", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByPopperComponent(STValue value) {
		return Optional.ofNullable(db.find("PopperComponent", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByPopupIcon(STValue value) {
		return Optional.ofNullable(db.find("popupIcon", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByRenderGroup(STValue value) {
		return Optional.ofNullable(db.find("renderGroup", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByRenderInput(STValue value) {
		return Optional.ofNullable(db.find("renderInput", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByRenderOption(STValue value) {
		return Optional.ofNullable(db.find("renderOption", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByRenderTags(STValue value) {
		return Optional.ofNullable(db.find("renderTags", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelBySelectOnFocus(STValue value) {
		return Optional.ofNullable(db.find("selectOnFocus", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AutocompleteElementModel> findAutocompleteElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, AutocompleteElementModel.stTemplateUuid, AutocompleteElementModel::new));
	}

	public Optional<AvatarElementModel> findAvatarElementModelByAlt(STValue value) {
		return Optional.ofNullable(db.find("alt", value, AvatarElementModel.stTemplateUuid, AvatarElementModel::new));
	}

	public Optional<AvatarElementModel> findAvatarElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, AvatarElementModel.stTemplateUuid, AvatarElementModel::new));
	}

	public Optional<AvatarElementModel> findAvatarElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, AvatarElementModel.stTemplateUuid, AvatarElementModel::new));
	}

	public Optional<AvatarElementModel> findAvatarElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, AvatarElementModel.stTemplateUuid, AvatarElementModel::new));
	}

	public Optional<AvatarElementModel> findAvatarElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, AvatarElementModel.stTemplateUuid, AvatarElementModel::new));
	}

	public Optional<AvatarElementModel> findAvatarElementModelByImgProps(STValue value) {
		return Optional.ofNullable(db.find("imgProps", value, AvatarElementModel.stTemplateUuid, AvatarElementModel::new));
	}

	public Optional<AvatarElementModel> findAvatarElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, AvatarElementModel.stTemplateUuid, AvatarElementModel::new));
	}

	public Optional<AvatarElementModel> findAvatarElementModelBySizes(STValue value) {
		return Optional.ofNullable(db.find("sizes", value, AvatarElementModel.stTemplateUuid, AvatarElementModel::new));
	}

	public Optional<AvatarElementModel> findAvatarElementModelBySrc(STValue value) {
		return Optional.ofNullable(db.find("src", value, AvatarElementModel.stTemplateUuid, AvatarElementModel::new));
	}

	public Optional<AvatarElementModel> findAvatarElementModelBySrcSet(STValue value) {
		return Optional.ofNullable(db.find("srcSet", value, AvatarElementModel.stTemplateUuid, AvatarElementModel::new));
	}

	public Optional<AvatarElementModel> findAvatarElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, AvatarElementModel.stTemplateUuid, AvatarElementModel::new));
	}

	public Optional<AvatarElementModel> findAvatarElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, AvatarElementModel.stTemplateUuid, AvatarElementModel::new));
	}

	public Optional<AvatarGroupElementModel> findAvatarGroupElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, AvatarGroupElementModel.stTemplateUuid, AvatarGroupElementModel::new));
	}

	public Optional<AvatarGroupElementModel> findAvatarGroupElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, AvatarGroupElementModel.stTemplateUuid, AvatarGroupElementModel::new));
	}

	public Optional<AvatarGroupElementModel> findAvatarGroupElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, AvatarGroupElementModel.stTemplateUuid, AvatarGroupElementModel::new));
	}

	public Optional<AvatarGroupElementModel> findAvatarGroupElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, AvatarGroupElementModel.stTemplateUuid, AvatarGroupElementModel::new));
	}

	public Optional<AvatarGroupElementModel> findAvatarGroupElementModelByMax(STValue value) {
		return Optional.ofNullable(db.find("max", value, AvatarGroupElementModel.stTemplateUuid, AvatarGroupElementModel::new));
	}

	public Optional<AvatarGroupElementModel> findAvatarGroupElementModelBySpacing(STValue value) {
		return Optional.ofNullable(db.find("spacing", value, AvatarGroupElementModel.stTemplateUuid, AvatarGroupElementModel::new));
	}

	public Optional<AvatarGroupElementModel> findAvatarGroupElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, AvatarGroupElementModel.stTemplateUuid, AvatarGroupElementModel::new));
	}

	public Optional<BackdropElementModel> findBackdropElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, BackdropElementModel.stTemplateUuid, BackdropElementModel::new));
	}

	public Optional<BackdropElementModel> findBackdropElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, BackdropElementModel.stTemplateUuid, BackdropElementModel::new));
	}

	public Optional<BackdropElementModel> findBackdropElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, BackdropElementModel.stTemplateUuid, BackdropElementModel::new));
	}

	public Optional<BackdropElementModel> findBackdropElementModelByInvisible(STValue value) {
		return Optional.ofNullable(db.find("invisible", value, BackdropElementModel.stTemplateUuid, BackdropElementModel::new));
	}

	public Optional<BackdropElementModel> findBackdropElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, BackdropElementModel.stTemplateUuid, BackdropElementModel::new));
	}

	public Optional<BackdropElementModel> findBackdropElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, BackdropElementModel.stTemplateUuid, BackdropElementModel::new));
	}

	public Optional<BackdropElementModel> findBackdropElementModelByTransitionDuration(STValue value) {
		return Optional.ofNullable(db.find("transitionDuration", value, BackdropElementModel.stTemplateUuid, BackdropElementModel::new));
	}

	public Optional<BadgeElementModel> findBadgeElementModelByAnchorOrigin(STValue value) {
		return Optional.ofNullable(db.find("anchorOrigin", value, BadgeElementModel.stTemplateUuid, BadgeElementModel::new));
	}

	public Optional<BadgeElementModel> findBadgeElementModelByBadgeContent(STValue value) {
		return Optional.ofNullable(db.find("badgeContent", value, BadgeElementModel.stTemplateUuid, BadgeElementModel::new));
	}

	public Optional<BadgeElementModel> findBadgeElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, BadgeElementModel.stTemplateUuid, BadgeElementModel::new));
	}

	public Optional<BadgeElementModel> findBadgeElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, BadgeElementModel.stTemplateUuid, BadgeElementModel::new));
	}

	public Optional<BadgeElementModel> findBadgeElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, BadgeElementModel.stTemplateUuid, BadgeElementModel::new));
	}

	public Optional<BadgeElementModel> findBadgeElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, BadgeElementModel.stTemplateUuid, BadgeElementModel::new));
	}

	public Optional<BadgeElementModel> findBadgeElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, BadgeElementModel.stTemplateUuid, BadgeElementModel::new));
	}

	public Optional<BadgeElementModel> findBadgeElementModelByInvisible(STValue value) {
		return Optional.ofNullable(db.find("invisible", value, BadgeElementModel.stTemplateUuid, BadgeElementModel::new));
	}

	public Optional<BadgeElementModel> findBadgeElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, BadgeElementModel.stTemplateUuid, BadgeElementModel::new));
	}

	public Optional<BadgeElementModel> findBadgeElementModelByMax(STValue value) {
		return Optional.ofNullable(db.find("max", value, BadgeElementModel.stTemplateUuid, BadgeElementModel::new));
	}

	public Optional<BadgeElementModel> findBadgeElementModelByOverlap(STValue value) {
		return Optional.ofNullable(db.find("overlap", value, BadgeElementModel.stTemplateUuid, BadgeElementModel::new));
	}

	public Optional<BadgeElementModel> findBadgeElementModelByShowZero(STValue value) {
		return Optional.ofNullable(db.find("showZero", value, BadgeElementModel.stTemplateUuid, BadgeElementModel::new));
	}

	public Optional<BadgeElementModel> findBadgeElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, BadgeElementModel.stTemplateUuid, BadgeElementModel::new));
	}

	public Optional<BadgeElementModel> findBadgeElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, BadgeElementModel.stTemplateUuid, BadgeElementModel::new));
	}

	public Optional<BottomNavigationElementModel> findBottomNavigationElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, BottomNavigationElementModel.stTemplateUuid, BottomNavigationElementModel::new));
	}

	public Optional<BottomNavigationElementModel> findBottomNavigationElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, BottomNavigationElementModel.stTemplateUuid, BottomNavigationElementModel::new));
	}

	public Optional<BottomNavigationElementModel> findBottomNavigationElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, BottomNavigationElementModel.stTemplateUuid, BottomNavigationElementModel::new));
	}

	public Optional<BottomNavigationElementModel> findBottomNavigationElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, BottomNavigationElementModel.stTemplateUuid, BottomNavigationElementModel::new));
	}

	public Optional<BottomNavigationElementModel> findBottomNavigationElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, BottomNavigationElementModel.stTemplateUuid, BottomNavigationElementModel::new));
	}

	public Optional<BottomNavigationElementModel> findBottomNavigationElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, BottomNavigationElementModel.stTemplateUuid, BottomNavigationElementModel::new));
	}

	public Optional<BottomNavigationElementModel> findBottomNavigationElementModelByShowLabels(STValue value) {
		return Optional.ofNullable(db.find("showLabels", value, BottomNavigationElementModel.stTemplateUuid, BottomNavigationElementModel::new));
	}

	public Optional<BottomNavigationElementModel> findBottomNavigationElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, BottomNavigationElementModel.stTemplateUuid, BottomNavigationElementModel::new));
	}

	public Optional<BottomNavigationElementModel> findBottomNavigationElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, BottomNavigationElementModel.stTemplateUuid, BottomNavigationElementModel::new));
	}

	public Optional<BottomNavigationActionElementModel> findBottomNavigationActionElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, BottomNavigationActionElementModel.stTemplateUuid, BottomNavigationActionElementModel::new));
	}

	public Optional<BottomNavigationActionElementModel> findBottomNavigationActionElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, BottomNavigationActionElementModel.stTemplateUuid, BottomNavigationActionElementModel::new));
	}

	public Optional<BottomNavigationActionElementModel> findBottomNavigationActionElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, BottomNavigationActionElementModel.stTemplateUuid, BottomNavigationActionElementModel::new));
	}

	public Optional<BottomNavigationActionElementModel> findBottomNavigationActionElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, BottomNavigationActionElementModel.stTemplateUuid, BottomNavigationActionElementModel::new));
	}

	public Optional<BottomNavigationActionElementModel> findBottomNavigationActionElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, BottomNavigationActionElementModel.stTemplateUuid, BottomNavigationActionElementModel::new));
	}

	public Optional<BottomNavigationActionElementModel> findBottomNavigationActionElementModelByLabel(STValue value) {
		return Optional.ofNullable(db.find("label", value, BottomNavigationActionElementModel.stTemplateUuid, BottomNavigationActionElementModel::new));
	}

	public Optional<BottomNavigationActionElementModel> findBottomNavigationActionElementModelByShowLabel(STValue value) {
		return Optional.ofNullable(db.find("showLabel", value, BottomNavigationActionElementModel.stTemplateUuid, BottomNavigationActionElementModel::new));
	}

	public Optional<BottomNavigationActionElementModel> findBottomNavigationActionElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, BottomNavigationActionElementModel.stTemplateUuid, BottomNavigationActionElementModel::new));
	}

	public Optional<BottomNavigationActionElementModel> findBottomNavigationActionElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, BottomNavigationActionElementModel.stTemplateUuid, BottomNavigationActionElementModel::new));
	}

	public Optional<BreadcrumbsElementModel> findBreadcrumbsElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, BreadcrumbsElementModel.stTemplateUuid, BreadcrumbsElementModel::new));
	}

	public Optional<BreadcrumbsElementModel> findBreadcrumbsElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, BreadcrumbsElementModel.stTemplateUuid, BreadcrumbsElementModel::new));
	}

	public Optional<BreadcrumbsElementModel> findBreadcrumbsElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, BreadcrumbsElementModel.stTemplateUuid, BreadcrumbsElementModel::new));
	}

	public Optional<BreadcrumbsElementModel> findBreadcrumbsElementModelByExpandText(STValue value) {
		return Optional.ofNullable(db.find("expandText", value, BreadcrumbsElementModel.stTemplateUuid, BreadcrumbsElementModel::new));
	}

	public Optional<BreadcrumbsElementModel> findBreadcrumbsElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, BreadcrumbsElementModel.stTemplateUuid, BreadcrumbsElementModel::new));
	}

	public Optional<BreadcrumbsElementModel> findBreadcrumbsElementModelByItemsAfterCollapse(STValue value) {
		return Optional.ofNullable(db.find("itemsAfterCollapse", value, BreadcrumbsElementModel.stTemplateUuid, BreadcrumbsElementModel::new));
	}

	public Optional<BreadcrumbsElementModel> findBreadcrumbsElementModelByItemsBeforeCollapse(STValue value) {
		return Optional.ofNullable(db.find("itemsBeforeCollapse", value, BreadcrumbsElementModel.stTemplateUuid, BreadcrumbsElementModel::new));
	}

	public Optional<BreadcrumbsElementModel> findBreadcrumbsElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, BreadcrumbsElementModel.stTemplateUuid, BreadcrumbsElementModel::new));
	}

	public Optional<BreadcrumbsElementModel> findBreadcrumbsElementModelByMaxItems(STValue value) {
		return Optional.ofNullable(db.find("maxItems", value, BreadcrumbsElementModel.stTemplateUuid, BreadcrumbsElementModel::new));
	}

	public Optional<BreadcrumbsElementModel> findBreadcrumbsElementModelBySeparator(STValue value) {
		return Optional.ofNullable(db.find("separator", value, BreadcrumbsElementModel.stTemplateUuid, BreadcrumbsElementModel::new));
	}

	public Optional<BreadcrumbsElementModel> findBreadcrumbsElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, BreadcrumbsElementModel.stTemplateUuid, BreadcrumbsElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByDisableElevation(STValue value) {
		return Optional.ofNullable(db.find("disableElevation", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByDisableFocusRipple(STValue value) {
		return Optional.ofNullable(db.find("disableFocusRipple", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByDisableRipple(STValue value) {
		return Optional.ofNullable(db.find("disableRipple", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByEndIcon(STValue value) {
		return Optional.ofNullable(db.find("endIcon", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByFullWidth(STValue value) {
		return Optional.ofNullable(db.find("fullWidth", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByHref(STValue value) {
		return Optional.ofNullable(db.find("href", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByStartIcon(STValue value) {
		return Optional.ofNullable(db.find("startIcon", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonElementModel> findButtonElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, ButtonElementModel.stTemplateUuid, ButtonElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelByAction(STValue value) {
		return Optional.ofNullable(db.find("action", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelByCenterRipple(STValue value) {
		return Optional.ofNullable(db.find("centerRipple", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelByDisableRipple(STValue value) {
		return Optional.ofNullable(db.find("disableRipple", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelByDisableTouchRipple(STValue value) {
		return Optional.ofNullable(db.find("disableTouchRipple", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelByFocusRipple(STValue value) {
		return Optional.ofNullable(db.find("focusRipple", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelByFocusVisibleClassName(STValue value) {
		return Optional.ofNullable(db.find("focusVisibleClassName", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelByOnFocusVisible(STValue value) {
		return Optional.ofNullable(db.find("onFocusVisible", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonBaseElementModel> findButtonBaseElementModelByTouchRippleProps(STValue value) {
		return Optional.ofNullable(db.find("TouchRippleProps", value, ButtonBaseElementModel.stTemplateUuid, ButtonBaseElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelByDisableElevation(STValue value) {
		return Optional.ofNullable(db.find("disableElevation", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelByDisableFocusRipple(STValue value) {
		return Optional.ofNullable(db.find("disableFocusRipple", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelByDisableRipple(STValue value) {
		return Optional.ofNullable(db.find("disableRipple", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelByFullWidth(STValue value) {
		return Optional.ofNullable(db.find("fullWidth", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelByOrientation(STValue value) {
		return Optional.ofNullable(db.find("orientation", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<ButtonGroupElementModel> findButtonGroupElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, ButtonGroupElementModel.stTemplateUuid, ButtonGroupElementModel::new));
	}

	public Optional<CardElementModel> findCardElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, CardElementModel.stTemplateUuid, CardElementModel::new));
	}

	public Optional<CardElementModel> findCardElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, CardElementModel.stTemplateUuid, CardElementModel::new));
	}

	public Optional<CardElementModel> findCardElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, CardElementModel.stTemplateUuid, CardElementModel::new));
	}

	public Optional<CardElementModel> findCardElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, CardElementModel.stTemplateUuid, CardElementModel::new));
	}

	public Optional<CardElementModel> findCardElementModelByRaised(STValue value) {
		return Optional.ofNullable(db.find("raised", value, CardElementModel.stTemplateUuid, CardElementModel::new));
	}

	public Optional<CardElementModel> findCardElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, CardElementModel.stTemplateUuid, CardElementModel::new));
	}

	public Optional<CardActionAreaElementModel> findCardActionAreaElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, CardActionAreaElementModel.stTemplateUuid, CardActionAreaElementModel::new));
	}

	public Optional<CardActionAreaElementModel> findCardActionAreaElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, CardActionAreaElementModel.stTemplateUuid, CardActionAreaElementModel::new));
	}

	public Optional<CardActionAreaElementModel> findCardActionAreaElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, CardActionAreaElementModel.stTemplateUuid, CardActionAreaElementModel::new));
	}

	public Optional<CardActionAreaElementModel> findCardActionAreaElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, CardActionAreaElementModel.stTemplateUuid, CardActionAreaElementModel::new));
	}

	public Optional<CardActionAreaElementModel> findCardActionAreaElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, CardActionAreaElementModel.stTemplateUuid, CardActionAreaElementModel::new));
	}

	public Optional<CardActionsElementModel> findCardActionsElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, CardActionsElementModel.stTemplateUuid, CardActionsElementModel::new));
	}

	public Optional<CardActionsElementModel> findCardActionsElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, CardActionsElementModel.stTemplateUuid, CardActionsElementModel::new));
	}

	public Optional<CardActionsElementModel> findCardActionsElementModelByDisableSpacing(STValue value) {
		return Optional.ofNullable(db.find("disableSpacing", value, CardActionsElementModel.stTemplateUuid, CardActionsElementModel::new));
	}

	public Optional<CardActionsElementModel> findCardActionsElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, CardActionsElementModel.stTemplateUuid, CardActionsElementModel::new));
	}

	public Optional<CardActionsElementModel> findCardActionsElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, CardActionsElementModel.stTemplateUuid, CardActionsElementModel::new));
	}

	public Optional<CardActionsElementModel> findCardActionsElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, CardActionsElementModel.stTemplateUuid, CardActionsElementModel::new));
	}

	public Optional<CardContentElementModel> findCardContentElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, CardContentElementModel.stTemplateUuid, CardContentElementModel::new));
	}

	public Optional<CardContentElementModel> findCardContentElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, CardContentElementModel.stTemplateUuid, CardContentElementModel::new));
	}

	public Optional<CardContentElementModel> findCardContentElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, CardContentElementModel.stTemplateUuid, CardContentElementModel::new));
	}

	public Optional<CardContentElementModel> findCardContentElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, CardContentElementModel.stTemplateUuid, CardContentElementModel::new));
	}

	public Optional<CardContentElementModel> findCardContentElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, CardContentElementModel.stTemplateUuid, CardContentElementModel::new));
	}

	public Optional<CardContentElementModel> findCardContentElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, CardContentElementModel.stTemplateUuid, CardContentElementModel::new));
	}

	public Optional<CardHeaderElementModel> findCardHeaderElementModelByAction(STValue value) {
		return Optional.ofNullable(db.find("action", value, CardHeaderElementModel.stTemplateUuid, CardHeaderElementModel::new));
	}

	public Optional<CardHeaderElementModel> findCardHeaderElementModelByAvatar(STValue value) {
		return Optional.ofNullable(db.find("avatar", value, CardHeaderElementModel.stTemplateUuid, CardHeaderElementModel::new));
	}

	public Optional<CardHeaderElementModel> findCardHeaderElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, CardHeaderElementModel.stTemplateUuid, CardHeaderElementModel::new));
	}

	public Optional<CardHeaderElementModel> findCardHeaderElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, CardHeaderElementModel.stTemplateUuid, CardHeaderElementModel::new));
	}

	public Optional<CardHeaderElementModel> findCardHeaderElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, CardHeaderElementModel.stTemplateUuid, CardHeaderElementModel::new));
	}

	public Optional<CardHeaderElementModel> findCardHeaderElementModelByDisableTypography(STValue value) {
		return Optional.ofNullable(db.find("disableTypography", value, CardHeaderElementModel.stTemplateUuid, CardHeaderElementModel::new));
	}

	public Optional<CardHeaderElementModel> findCardHeaderElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, CardHeaderElementModel.stTemplateUuid, CardHeaderElementModel::new));
	}

	public Optional<CardHeaderElementModel> findCardHeaderElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, CardHeaderElementModel.stTemplateUuid, CardHeaderElementModel::new));
	}

	public Optional<CardHeaderElementModel> findCardHeaderElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, CardHeaderElementModel.stTemplateUuid, CardHeaderElementModel::new));
	}

	public Optional<CardHeaderElementModel> findCardHeaderElementModelBySubheader(STValue value) {
		return Optional.ofNullable(db.find("subheader", value, CardHeaderElementModel.stTemplateUuid, CardHeaderElementModel::new));
	}

	public Optional<CardHeaderElementModel> findCardHeaderElementModelBySubheaderTypographyProps(STValue value) {
		return Optional.ofNullable(db.find("subheaderTypographyProps", value, CardHeaderElementModel.stTemplateUuid, CardHeaderElementModel::new));
	}

	public Optional<CardHeaderElementModel> findCardHeaderElementModelByTitle(STValue value) {
		return Optional.ofNullable(db.find("title", value, CardHeaderElementModel.stTemplateUuid, CardHeaderElementModel::new));
	}

	public Optional<CardHeaderElementModel> findCardHeaderElementModelByTitleTypographyProps(STValue value) {
		return Optional.ofNullable(db.find("titleTypographyProps", value, CardHeaderElementModel.stTemplateUuid, CardHeaderElementModel::new));
	}

	public Optional<CardMediaElementModel> findCardMediaElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, CardMediaElementModel.stTemplateUuid, CardMediaElementModel::new));
	}

	public Optional<CardMediaElementModel> findCardMediaElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, CardMediaElementModel.stTemplateUuid, CardMediaElementModel::new));
	}

	public Optional<CardMediaElementModel> findCardMediaElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, CardMediaElementModel.stTemplateUuid, CardMediaElementModel::new));
	}

	public Optional<CardMediaElementModel> findCardMediaElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, CardMediaElementModel.stTemplateUuid, CardMediaElementModel::new));
	}

	public Optional<CardMediaElementModel> findCardMediaElementModelByImage(STValue value) {
		return Optional.ofNullable(db.find("image", value, CardMediaElementModel.stTemplateUuid, CardMediaElementModel::new));
	}

	public Optional<CardMediaElementModel> findCardMediaElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, CardMediaElementModel.stTemplateUuid, CardMediaElementModel::new));
	}

	public Optional<CardMediaElementModel> findCardMediaElementModelBySrc(STValue value) {
		return Optional.ofNullable(db.find("src", value, CardMediaElementModel.stTemplateUuid, CardMediaElementModel::new));
	}

	public Optional<CardMediaElementModel> findCardMediaElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, CardMediaElementModel.stTemplateUuid, CardMediaElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByChecked(STValue value) {
		return Optional.ofNullable(db.find("checked", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByCheckedIcon(STValue value) {
		return Optional.ofNullable(db.find("checkedIcon", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByDisableRipple(STValue value) {
		return Optional.ofNullable(db.find("disableRipple", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByIndeterminate(STValue value) {
		return Optional.ofNullable(db.find("indeterminate", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByIndeterminateIcon(STValue value) {
		return Optional.ofNullable(db.find("indeterminateIcon", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByInputProps(STValue value) {
		return Optional.ofNullable(db.find("inputProps", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByInputRef(STValue value) {
		return Optional.ofNullable(db.find("inputRef", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByRequired(STValue value) {
		return Optional.ofNullable(db.find("required", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<CheckboxElementModel> findCheckboxElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, CheckboxElementModel.stTemplateUuid, CheckboxElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelByAvatar(STValue value) {
		return Optional.ofNullable(db.find("avatar", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelByClickable(STValue value) {
		return Optional.ofNullable(db.find("clickable", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelByDeleteIcon(STValue value) {
		return Optional.ofNullable(db.find("deleteIcon", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelByLabel(STValue value) {
		return Optional.ofNullable(db.find("label", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelByOnDelete(STValue value) {
		return Optional.ofNullable(db.find("onDelete", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<ChipElementModel> findChipElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, ChipElementModel.stTemplateUuid, ChipElementModel::new));
	}

	public Optional<CircularProgressElementModel> findCircularProgressElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, CircularProgressElementModel.stTemplateUuid, CircularProgressElementModel::new));
	}

	public Optional<CircularProgressElementModel> findCircularProgressElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, CircularProgressElementModel.stTemplateUuid, CircularProgressElementModel::new));
	}

	public Optional<CircularProgressElementModel> findCircularProgressElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, CircularProgressElementModel.stTemplateUuid, CircularProgressElementModel::new));
	}

	public Optional<CircularProgressElementModel> findCircularProgressElementModelByDisableShrink(STValue value) {
		return Optional.ofNullable(db.find("disableShrink", value, CircularProgressElementModel.stTemplateUuid, CircularProgressElementModel::new));
	}

	public Optional<CircularProgressElementModel> findCircularProgressElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, CircularProgressElementModel.stTemplateUuid, CircularProgressElementModel::new));
	}

	public Optional<CircularProgressElementModel> findCircularProgressElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, CircularProgressElementModel.stTemplateUuid, CircularProgressElementModel::new));
	}

	public Optional<CircularProgressElementModel> findCircularProgressElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, CircularProgressElementModel.stTemplateUuid, CircularProgressElementModel::new));
	}

	public Optional<CircularProgressElementModel> findCircularProgressElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, CircularProgressElementModel.stTemplateUuid, CircularProgressElementModel::new));
	}

	public Optional<CircularProgressElementModel> findCircularProgressElementModelByThickness(STValue value) {
		return Optional.ofNullable(db.find("thickness", value, CircularProgressElementModel.stTemplateUuid, CircularProgressElementModel::new));
	}

	public Optional<CircularProgressElementModel> findCircularProgressElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, CircularProgressElementModel.stTemplateUuid, CircularProgressElementModel::new));
	}

	public Optional<CircularProgressElementModel> findCircularProgressElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, CircularProgressElementModel.stTemplateUuid, CircularProgressElementModel::new));
	}

	public Optional<ClickAwayListenerElementModel> findClickAwayListenerElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ClickAwayListenerElementModel.stTemplateUuid, ClickAwayListenerElementModel::new));
	}

	public Optional<ClickAwayListenerElementModel> findClickAwayListenerElementModelByDisableReactTree(STValue value) {
		return Optional.ofNullable(db.find("disableReactTree", value, ClickAwayListenerElementModel.stTemplateUuid, ClickAwayListenerElementModel::new));
	}

	public Optional<ClickAwayListenerElementModel> findClickAwayListenerElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ClickAwayListenerElementModel.stTemplateUuid, ClickAwayListenerElementModel::new));
	}

	public Optional<ClickAwayListenerElementModel> findClickAwayListenerElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ClickAwayListenerElementModel.stTemplateUuid, ClickAwayListenerElementModel::new));
	}

	public Optional<ClickAwayListenerElementModel> findClickAwayListenerElementModelByMouseEvent(STValue value) {
		return Optional.ofNullable(db.find("mouseEvent", value, ClickAwayListenerElementModel.stTemplateUuid, ClickAwayListenerElementModel::new));
	}

	public Optional<ClickAwayListenerElementModel> findClickAwayListenerElementModelByOnClickAway(STValue value) {
		return Optional.ofNullable(db.find("onClickAway", value, ClickAwayListenerElementModel.stTemplateUuid, ClickAwayListenerElementModel::new));
	}

	public Optional<ClickAwayListenerElementModel> findClickAwayListenerElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ClickAwayListenerElementModel.stTemplateUuid, ClickAwayListenerElementModel::new));
	}

	public Optional<ClickAwayListenerElementModel> findClickAwayListenerElementModelByTouchEvent(STValue value) {
		return Optional.ofNullable(db.find("touchEvent", value, ClickAwayListenerElementModel.stTemplateUuid, ClickAwayListenerElementModel::new));
	}

	public Optional<CollapseElementModel> findCollapseElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, CollapseElementModel.stTemplateUuid, CollapseElementModel::new));
	}

	public Optional<CollapseElementModel> findCollapseElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, CollapseElementModel.stTemplateUuid, CollapseElementModel::new));
	}

	public Optional<CollapseElementModel> findCollapseElementModelByCollapsedHeight(STValue value) {
		return Optional.ofNullable(db.find("collapsedHeight", value, CollapseElementModel.stTemplateUuid, CollapseElementModel::new));
	}

	public Optional<CollapseElementModel> findCollapseElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, CollapseElementModel.stTemplateUuid, CollapseElementModel::new));
	}

	public Optional<CollapseElementModel> findCollapseElementModelByDisableStrictModeCompat(STValue value) {
		return Optional.ofNullable(db.find("disableStrictModeCompat", value, CollapseElementModel.stTemplateUuid, CollapseElementModel::new));
	}

	public Optional<CollapseElementModel> findCollapseElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, CollapseElementModel.stTemplateUuid, CollapseElementModel::new));
	}

	public Optional<CollapseElementModel> findCollapseElementModelByIn(STValue value) {
		return Optional.ofNullable(db.find("in", value, CollapseElementModel.stTemplateUuid, CollapseElementModel::new));
	}

	public Optional<CollapseElementModel> findCollapseElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, CollapseElementModel.stTemplateUuid, CollapseElementModel::new));
	}

	public Optional<CollapseElementModel> findCollapseElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, CollapseElementModel.stTemplateUuid, CollapseElementModel::new));
	}

	public Optional<CollapseElementModel> findCollapseElementModelByTimeout(STValue value) {
		return Optional.ofNullable(db.find("timeout", value, CollapseElementModel.stTemplateUuid, CollapseElementModel::new));
	}

	public Optional<ContainerElementModel> findContainerElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ContainerElementModel.stTemplateUuid, ContainerElementModel::new));
	}

	public Optional<ContainerElementModel> findContainerElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ContainerElementModel.stTemplateUuid, ContainerElementModel::new));
	}

	public Optional<ContainerElementModel> findContainerElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, ContainerElementModel.stTemplateUuid, ContainerElementModel::new));
	}

	public Optional<ContainerElementModel> findContainerElementModelByDisableGutters(STValue value) {
		return Optional.ofNullable(db.find("disableGutters", value, ContainerElementModel.stTemplateUuid, ContainerElementModel::new));
	}

	public Optional<ContainerElementModel> findContainerElementModelByFixed(STValue value) {
		return Optional.ofNullable(db.find("fixed", value, ContainerElementModel.stTemplateUuid, ContainerElementModel::new));
	}

	public Optional<ContainerElementModel> findContainerElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ContainerElementModel.stTemplateUuid, ContainerElementModel::new));
	}

	public Optional<ContainerElementModel> findContainerElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ContainerElementModel.stTemplateUuid, ContainerElementModel::new));
	}

	public Optional<ContainerElementModel> findContainerElementModelByMaxWidth(STValue value) {
		return Optional.ofNullable(db.find("maxWidth", value, ContainerElementModel.stTemplateUuid, ContainerElementModel::new));
	}

	public Optional<ContainerElementModel> findContainerElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ContainerElementModel.stTemplateUuid, ContainerElementModel::new));
	}

	public Optional<CssBaselineElementModel> findCssBaselineElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, CssBaselineElementModel.stTemplateUuid, CssBaselineElementModel::new));
	}

	public Optional<CssBaselineElementModel> findCssBaselineElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, CssBaselineElementModel.stTemplateUuid, CssBaselineElementModel::new));
	}

	public Optional<CssBaselineElementModel> findCssBaselineElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, CssBaselineElementModel.stTemplateUuid, CssBaselineElementModel::new));
	}

	public Optional<CssBaselineElementModel> findCssBaselineElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, CssBaselineElementModel.stTemplateUuid, CssBaselineElementModel::new));
	}

	public Optional<CssBaselineElementModel> findCssBaselineElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, CssBaselineElementModel.stTemplateUuid, CssBaselineElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByAriaDescribedby(STValue value) {
		return Optional.ofNullable(db.find("ariaDescribedby", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByAriaLabelledby(STValue value) {
		return Optional.ofNullable(db.find("ariaLabelledby", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByDisableBackdropClick(STValue value) {
		return Optional.ofNullable(db.find("disableBackdropClick", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByDisableEscapeKeyDown(STValue value) {
		return Optional.ofNullable(db.find("disableEscapeKeyDown", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByFullScreen(STValue value) {
		return Optional.ofNullable(db.find("fullScreen", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByFullWidth(STValue value) {
		return Optional.ofNullable(db.find("fullWidth", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByMaxWidth(STValue value) {
		return Optional.ofNullable(db.find("maxWidth", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByOnBackdropClick(STValue value) {
		return Optional.ofNullable(db.find("onBackdropClick", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByOnClose(STValue value) {
		return Optional.ofNullable(db.find("onClose", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByOnEnter(STValue value) {
		return Optional.ofNullable(db.find("onEnter", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByOnEntered(STValue value) {
		return Optional.ofNullable(db.find("onEntered", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByOnEntering(STValue value) {
		return Optional.ofNullable(db.find("onEntering", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByOnEscapeKeyDown(STValue value) {
		return Optional.ofNullable(db.find("onEscapeKeyDown", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByOnExit(STValue value) {
		return Optional.ofNullable(db.find("onExit", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByOnExited(STValue value) {
		return Optional.ofNullable(db.find("onExited", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByOnExiting(STValue value) {
		return Optional.ofNullable(db.find("onExiting", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByPaperComponent(STValue value) {
		return Optional.ofNullable(db.find("PaperComponent", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByPaperProps(STValue value) {
		return Optional.ofNullable(db.find("PaperProps", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByScroll(STValue value) {
		return Optional.ofNullable(db.find("scroll", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByTransitionComponent(STValue value) {
		return Optional.ofNullable(db.find("TransitionComponent", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByTransitionDuration(STValue value) {
		return Optional.ofNullable(db.find("transitionDuration", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogElementModel> findDialogElementModelByTransitionProps(STValue value) {
		return Optional.ofNullable(db.find("TransitionProps", value, DialogElementModel.stTemplateUuid, DialogElementModel::new));
	}

	public Optional<DialogActionsElementModel> findDialogActionsElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, DialogActionsElementModel.stTemplateUuid, DialogActionsElementModel::new));
	}

	public Optional<DialogActionsElementModel> findDialogActionsElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, DialogActionsElementModel.stTemplateUuid, DialogActionsElementModel::new));
	}

	public Optional<DialogActionsElementModel> findDialogActionsElementModelByDisableSpacing(STValue value) {
		return Optional.ofNullable(db.find("disableSpacing", value, DialogActionsElementModel.stTemplateUuid, DialogActionsElementModel::new));
	}

	public Optional<DialogActionsElementModel> findDialogActionsElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, DialogActionsElementModel.stTemplateUuid, DialogActionsElementModel::new));
	}

	public Optional<DialogActionsElementModel> findDialogActionsElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, DialogActionsElementModel.stTemplateUuid, DialogActionsElementModel::new));
	}

	public Optional<DialogActionsElementModel> findDialogActionsElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, DialogActionsElementModel.stTemplateUuid, DialogActionsElementModel::new));
	}

	public Optional<DialogContentElementModel> findDialogContentElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, DialogContentElementModel.stTemplateUuid, DialogContentElementModel::new));
	}

	public Optional<DialogContentElementModel> findDialogContentElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, DialogContentElementModel.stTemplateUuid, DialogContentElementModel::new));
	}

	public Optional<DialogContentElementModel> findDialogContentElementModelByDividers(STValue value) {
		return Optional.ofNullable(db.find("dividers", value, DialogContentElementModel.stTemplateUuid, DialogContentElementModel::new));
	}

	public Optional<DialogContentElementModel> findDialogContentElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, DialogContentElementModel.stTemplateUuid, DialogContentElementModel::new));
	}

	public Optional<DialogContentElementModel> findDialogContentElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, DialogContentElementModel.stTemplateUuid, DialogContentElementModel::new));
	}

	public Optional<DialogContentElementModel> findDialogContentElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, DialogContentElementModel.stTemplateUuid, DialogContentElementModel::new));
	}

	public Optional<DialogContentTextElementModel> findDialogContentTextElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, DialogContentTextElementModel.stTemplateUuid, DialogContentTextElementModel::new));
	}

	public Optional<DialogContentTextElementModel> findDialogContentTextElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, DialogContentTextElementModel.stTemplateUuid, DialogContentTextElementModel::new));
	}

	public Optional<DialogContentTextElementModel> findDialogContentTextElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, DialogContentTextElementModel.stTemplateUuid, DialogContentTextElementModel::new));
	}

	public Optional<DialogContentTextElementModel> findDialogContentTextElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, DialogContentTextElementModel.stTemplateUuid, DialogContentTextElementModel::new));
	}

	public Optional<DialogContentTextElementModel> findDialogContentTextElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, DialogContentTextElementModel.stTemplateUuid, DialogContentTextElementModel::new));
	}

	public Optional<DialogTitleElementModel> findDialogTitleElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, DialogTitleElementModel.stTemplateUuid, DialogTitleElementModel::new));
	}

	public Optional<DialogTitleElementModel> findDialogTitleElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, DialogTitleElementModel.stTemplateUuid, DialogTitleElementModel::new));
	}

	public Optional<DialogTitleElementModel> findDialogTitleElementModelByDisableTypography(STValue value) {
		return Optional.ofNullable(db.find("disableTypography", value, DialogTitleElementModel.stTemplateUuid, DialogTitleElementModel::new));
	}

	public Optional<DialogTitleElementModel> findDialogTitleElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, DialogTitleElementModel.stTemplateUuid, DialogTitleElementModel::new));
	}

	public Optional<DialogTitleElementModel> findDialogTitleElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, DialogTitleElementModel.stTemplateUuid, DialogTitleElementModel::new));
	}

	public Optional<DialogTitleElementModel> findDialogTitleElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, DialogTitleElementModel.stTemplateUuid, DialogTitleElementModel::new));
	}

	public Optional<DividerElementModel> findDividerElementModelByAbsolute(STValue value) {
		return Optional.ofNullable(db.find("absolute", value, DividerElementModel.stTemplateUuid, DividerElementModel::new));
	}

	public Optional<DividerElementModel> findDividerElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, DividerElementModel.stTemplateUuid, DividerElementModel::new));
	}

	public Optional<DividerElementModel> findDividerElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, DividerElementModel.stTemplateUuid, DividerElementModel::new));
	}

	public Optional<DividerElementModel> findDividerElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, DividerElementModel.stTemplateUuid, DividerElementModel::new));
	}

	public Optional<DividerElementModel> findDividerElementModelByFlexItem(STValue value) {
		return Optional.ofNullable(db.find("flexItem", value, DividerElementModel.stTemplateUuid, DividerElementModel::new));
	}

	public Optional<DividerElementModel> findDividerElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, DividerElementModel.stTemplateUuid, DividerElementModel::new));
	}

	public Optional<DividerElementModel> findDividerElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, DividerElementModel.stTemplateUuid, DividerElementModel::new));
	}

	public Optional<DividerElementModel> findDividerElementModelByLight(STValue value) {
		return Optional.ofNullable(db.find("light", value, DividerElementModel.stTemplateUuid, DividerElementModel::new));
	}

	public Optional<DividerElementModel> findDividerElementModelByOrientation(STValue value) {
		return Optional.ofNullable(db.find("orientation", value, DividerElementModel.stTemplateUuid, DividerElementModel::new));
	}

	public Optional<DividerElementModel> findDividerElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, DividerElementModel.stTemplateUuid, DividerElementModel::new));
	}

	public Optional<DividerElementModel> findDividerElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, DividerElementModel.stTemplateUuid, DividerElementModel::new));
	}

	public Optional<DrawerElementModel> findDrawerElementModelByAnchor(STValue value) {
		return Optional.ofNullable(db.find("anchor", value, DrawerElementModel.stTemplateUuid, DrawerElementModel::new));
	}

	public Optional<DrawerElementModel> findDrawerElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, DrawerElementModel.stTemplateUuid, DrawerElementModel::new));
	}

	public Optional<DrawerElementModel> findDrawerElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, DrawerElementModel.stTemplateUuid, DrawerElementModel::new));
	}

	public Optional<DrawerElementModel> findDrawerElementModelByElevation(STValue value) {
		return Optional.ofNullable(db.find("elevation", value, DrawerElementModel.stTemplateUuid, DrawerElementModel::new));
	}

	public Optional<DrawerElementModel> findDrawerElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, DrawerElementModel.stTemplateUuid, DrawerElementModel::new));
	}

	public Optional<DrawerElementModel> findDrawerElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, DrawerElementModel.stTemplateUuid, DrawerElementModel::new));
	}

	public Optional<DrawerElementModel> findDrawerElementModelByModalProps(STValue value) {
		return Optional.ofNullable(db.find("ModalProps", value, DrawerElementModel.stTemplateUuid, DrawerElementModel::new));
	}

	public Optional<DrawerElementModel> findDrawerElementModelByOnClose(STValue value) {
		return Optional.ofNullable(db.find("onClose", value, DrawerElementModel.stTemplateUuid, DrawerElementModel::new));
	}

	public Optional<DrawerElementModel> findDrawerElementModelByOpen(STValue value) {
		return Optional.ofNullable(db.find("open", value, DrawerElementModel.stTemplateUuid, DrawerElementModel::new));
	}

	public Optional<DrawerElementModel> findDrawerElementModelByPaperProps(STValue value) {
		return Optional.ofNullable(db.find("PaperProps", value, DrawerElementModel.stTemplateUuid, DrawerElementModel::new));
	}

	public Optional<DrawerElementModel> findDrawerElementModelBySlideProps(STValue value) {
		return Optional.ofNullable(db.find("SlideProps", value, DrawerElementModel.stTemplateUuid, DrawerElementModel::new));
	}

	public Optional<DrawerElementModel> findDrawerElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, DrawerElementModel.stTemplateUuid, DrawerElementModel::new));
	}

	public Optional<DrawerElementModel> findDrawerElementModelByTransitionDuration(STValue value) {
		return Optional.ofNullable(db.find("transitionDuration", value, DrawerElementModel.stTemplateUuid, DrawerElementModel::new));
	}

	public Optional<DrawerElementModel> findDrawerElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, DrawerElementModel.stTemplateUuid, DrawerElementModel::new));
	}

	public Optional<ExpansionPanelElementModel> findExpansionPanelElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ExpansionPanelElementModel.stTemplateUuid, ExpansionPanelElementModel::new));
	}

	public Optional<ExpansionPanelElementModel> findExpansionPanelElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ExpansionPanelElementModel.stTemplateUuid, ExpansionPanelElementModel::new));
	}

	public Optional<ExpansionPanelElementModel> findExpansionPanelElementModelByDefaultExpanded(STValue value) {
		return Optional.ofNullable(db.find("defaultExpanded", value, ExpansionPanelElementModel.stTemplateUuid, ExpansionPanelElementModel::new));
	}

	public Optional<ExpansionPanelElementModel> findExpansionPanelElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, ExpansionPanelElementModel.stTemplateUuid, ExpansionPanelElementModel::new));
	}

	public Optional<ExpansionPanelElementModel> findExpansionPanelElementModelByExpanded(STValue value) {
		return Optional.ofNullable(db.find("expanded", value, ExpansionPanelElementModel.stTemplateUuid, ExpansionPanelElementModel::new));
	}

	public Optional<ExpansionPanelElementModel> findExpansionPanelElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ExpansionPanelElementModel.stTemplateUuid, ExpansionPanelElementModel::new));
	}

	public Optional<ExpansionPanelElementModel> findExpansionPanelElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ExpansionPanelElementModel.stTemplateUuid, ExpansionPanelElementModel::new));
	}

	public Optional<ExpansionPanelElementModel> findExpansionPanelElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, ExpansionPanelElementModel.stTemplateUuid, ExpansionPanelElementModel::new));
	}

	public Optional<ExpansionPanelElementModel> findExpansionPanelElementModelBySquare(STValue value) {
		return Optional.ofNullable(db.find("square", value, ExpansionPanelElementModel.stTemplateUuid, ExpansionPanelElementModel::new));
	}

	public Optional<ExpansionPanelElementModel> findExpansionPanelElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ExpansionPanelElementModel.stTemplateUuid, ExpansionPanelElementModel::new));
	}

	public Optional<ExpansionPanelElementModel> findExpansionPanelElementModelByTransitionComponent(STValue value) {
		return Optional.ofNullable(db.find("TransitionComponent", value, ExpansionPanelElementModel.stTemplateUuid, ExpansionPanelElementModel::new));
	}

	public Optional<ExpansionPanelElementModel> findExpansionPanelElementModelByTransitionProps(STValue value) {
		return Optional.ofNullable(db.find("TransitionProps", value, ExpansionPanelElementModel.stTemplateUuid, ExpansionPanelElementModel::new));
	}

	public Optional<ExpansionPanelActionsElementModel> findExpansionPanelActionsElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ExpansionPanelActionsElementModel.stTemplateUuid, ExpansionPanelActionsElementModel::new));
	}

	public Optional<ExpansionPanelActionsElementModel> findExpansionPanelActionsElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ExpansionPanelActionsElementModel.stTemplateUuid, ExpansionPanelActionsElementModel::new));
	}

	public Optional<ExpansionPanelActionsElementModel> findExpansionPanelActionsElementModelByDisableSpacing(STValue value) {
		return Optional.ofNullable(db.find("disableSpacing", value, ExpansionPanelActionsElementModel.stTemplateUuid, ExpansionPanelActionsElementModel::new));
	}

	public Optional<ExpansionPanelActionsElementModel> findExpansionPanelActionsElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ExpansionPanelActionsElementModel.stTemplateUuid, ExpansionPanelActionsElementModel::new));
	}

	public Optional<ExpansionPanelActionsElementModel> findExpansionPanelActionsElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ExpansionPanelActionsElementModel.stTemplateUuid, ExpansionPanelActionsElementModel::new));
	}

	public Optional<ExpansionPanelActionsElementModel> findExpansionPanelActionsElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ExpansionPanelActionsElementModel.stTemplateUuid, ExpansionPanelActionsElementModel::new));
	}

	public Optional<ExpansionPanelDetailsElementModel> findExpansionPanelDetailsElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ExpansionPanelDetailsElementModel.stTemplateUuid, ExpansionPanelDetailsElementModel::new));
	}

	public Optional<ExpansionPanelDetailsElementModel> findExpansionPanelDetailsElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ExpansionPanelDetailsElementModel.stTemplateUuid, ExpansionPanelDetailsElementModel::new));
	}

	public Optional<ExpansionPanelDetailsElementModel> findExpansionPanelDetailsElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ExpansionPanelDetailsElementModel.stTemplateUuid, ExpansionPanelDetailsElementModel::new));
	}

	public Optional<ExpansionPanelDetailsElementModel> findExpansionPanelDetailsElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ExpansionPanelDetailsElementModel.stTemplateUuid, ExpansionPanelDetailsElementModel::new));
	}

	public Optional<ExpansionPanelDetailsElementModel> findExpansionPanelDetailsElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ExpansionPanelDetailsElementModel.stTemplateUuid, ExpansionPanelDetailsElementModel::new));
	}

	public Optional<ExpansionPanelSummaryElementModel> findExpansionPanelSummaryElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ExpansionPanelSummaryElementModel.stTemplateUuid, ExpansionPanelSummaryElementModel::new));
	}

	public Optional<ExpansionPanelSummaryElementModel> findExpansionPanelSummaryElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ExpansionPanelSummaryElementModel.stTemplateUuid, ExpansionPanelSummaryElementModel::new));
	}

	public Optional<ExpansionPanelSummaryElementModel> findExpansionPanelSummaryElementModelByExpandIcon(STValue value) {
		return Optional.ofNullable(db.find("expandIcon", value, ExpansionPanelSummaryElementModel.stTemplateUuid, ExpansionPanelSummaryElementModel::new));
	}

	public Optional<ExpansionPanelSummaryElementModel> findExpansionPanelSummaryElementModelByIconButtonProps(STValue value) {
		return Optional.ofNullable(db.find("IconButtonProps", value, ExpansionPanelSummaryElementModel.stTemplateUuid, ExpansionPanelSummaryElementModel::new));
	}

	public Optional<ExpansionPanelSummaryElementModel> findExpansionPanelSummaryElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ExpansionPanelSummaryElementModel.stTemplateUuid, ExpansionPanelSummaryElementModel::new));
	}

	public Optional<ExpansionPanelSummaryElementModel> findExpansionPanelSummaryElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ExpansionPanelSummaryElementModel.stTemplateUuid, ExpansionPanelSummaryElementModel::new));
	}

	public Optional<ExpansionPanelSummaryElementModel> findExpansionPanelSummaryElementModelByOnFocusVisible(STValue value) {
		return Optional.ofNullable(db.find("onFocusVisible", value, ExpansionPanelSummaryElementModel.stTemplateUuid, ExpansionPanelSummaryElementModel::new));
	}

	public Optional<ExpansionPanelSummaryElementModel> findExpansionPanelSummaryElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ExpansionPanelSummaryElementModel.stTemplateUuid, ExpansionPanelSummaryElementModel::new));
	}

	public Optional<FabElementModel> findFabElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, FabElementModel.stTemplateUuid, FabElementModel::new));
	}

	public Optional<FabElementModel> findFabElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, FabElementModel.stTemplateUuid, FabElementModel::new));
	}

	public Optional<FabElementModel> findFabElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, FabElementModel.stTemplateUuid, FabElementModel::new));
	}

	public Optional<FabElementModel> findFabElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, FabElementModel.stTemplateUuid, FabElementModel::new));
	}

	public Optional<FabElementModel> findFabElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, FabElementModel.stTemplateUuid, FabElementModel::new));
	}

	public Optional<FabElementModel> findFabElementModelByDisableFocusRipple(STValue value) {
		return Optional.ofNullable(db.find("disableFocusRipple", value, FabElementModel.stTemplateUuid, FabElementModel::new));
	}

	public Optional<FabElementModel> findFabElementModelByDisableRipple(STValue value) {
		return Optional.ofNullable(db.find("disableRipple", value, FabElementModel.stTemplateUuid, FabElementModel::new));
	}

	public Optional<FabElementModel> findFabElementModelByHref(STValue value) {
		return Optional.ofNullable(db.find("href", value, FabElementModel.stTemplateUuid, FabElementModel::new));
	}

	public Optional<FabElementModel> findFabElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, FabElementModel.stTemplateUuid, FabElementModel::new));
	}

	public Optional<FabElementModel> findFabElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, FabElementModel.stTemplateUuid, FabElementModel::new));
	}

	public Optional<FabElementModel> findFabElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, FabElementModel.stTemplateUuid, FabElementModel::new));
	}

	public Optional<FabElementModel> findFabElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, FabElementModel.stTemplateUuid, FabElementModel::new));
	}

	public Optional<FabElementModel> findFabElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, FabElementModel.stTemplateUuid, FabElementModel::new));
	}

	public Optional<FadeElementModel> findFadeElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, FadeElementModel.stTemplateUuid, FadeElementModel::new));
	}

	public Optional<FadeElementModel> findFadeElementModelByDisableStrictModeCompat(STValue value) {
		return Optional.ofNullable(db.find("disableStrictModeCompat", value, FadeElementModel.stTemplateUuid, FadeElementModel::new));
	}

	public Optional<FadeElementModel> findFadeElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, FadeElementModel.stTemplateUuid, FadeElementModel::new));
	}

	public Optional<FadeElementModel> findFadeElementModelByIn(STValue value) {
		return Optional.ofNullable(db.find("in", value, FadeElementModel.stTemplateUuid, FadeElementModel::new));
	}

	public Optional<FadeElementModel> findFadeElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, FadeElementModel.stTemplateUuid, FadeElementModel::new));
	}

	public Optional<FadeElementModel> findFadeElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, FadeElementModel.stTemplateUuid, FadeElementModel::new));
	}

	public Optional<FadeElementModel> findFadeElementModelByTimeout(STValue value) {
		return Optional.ofNullable(db.find("timeout", value, FadeElementModel.stTemplateUuid, FadeElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByAutoComplete(STValue value) {
		return Optional.ofNullable(db.find("autoComplete", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByAutoFocus(STValue value) {
		return Optional.ofNullable(db.find("autoFocus", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByDefaultValue(STValue value) {
		return Optional.ofNullable(db.find("defaultValue", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByDisableUnderline(STValue value) {
		return Optional.ofNullable(db.find("disableUnderline", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByEndAdornment(STValue value) {
		return Optional.ofNullable(db.find("endAdornment", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByError(STValue value) {
		return Optional.ofNullable(db.find("error", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByFullWidth(STValue value) {
		return Optional.ofNullable(db.find("fullWidth", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByInputComponent(STValue value) {
		return Optional.ofNullable(db.find("inputComponent", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByInputProps(STValue value) {
		return Optional.ofNullable(db.find("inputProps", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByInputRef(STValue value) {
		return Optional.ofNullable(db.find("inputRef", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByMargin(STValue value) {
		return Optional.ofNullable(db.find("margin", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByMultiline(STValue value) {
		return Optional.ofNullable(db.find("multiline", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByPlaceholder(STValue value) {
		return Optional.ofNullable(db.find("placeholder", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByReadOnly(STValue value) {
		return Optional.ofNullable(db.find("readOnly", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByRequired(STValue value) {
		return Optional.ofNullable(db.find("required", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByRows(STValue value) {
		return Optional.ofNullable(db.find("rows", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByRowsMax(STValue value) {
		return Optional.ofNullable(db.find("rowsMax", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByStartAdornment(STValue value) {
		return Optional.ofNullable(db.find("startAdornment", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FilledInputElementModel> findFilledInputElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, FilledInputElementModel.stTemplateUuid, FilledInputElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelByError(STValue value) {
		return Optional.ofNullable(db.find("error", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelByFocused(STValue value) {
		return Optional.ofNullable(db.find("focused", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelByFullWidth(STValue value) {
		return Optional.ofNullable(db.find("fullWidth", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelByHiddenLabel(STValue value) {
		return Optional.ofNullable(db.find("hiddenLabel", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelByMargin(STValue value) {
		return Optional.ofNullable(db.find("margin", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelByRequired(STValue value) {
		return Optional.ofNullable(db.find("required", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlElementModel> findFormControlElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, FormControlElementModel.stTemplateUuid, FormControlElementModel::new));
	}

	public Optional<FormControlLabelElementModel> findFormControlLabelElementModelByChecked(STValue value) {
		return Optional.ofNullable(db.find("checked", value, FormControlLabelElementModel.stTemplateUuid, FormControlLabelElementModel::new));
	}

	public Optional<FormControlLabelElementModel> findFormControlLabelElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, FormControlLabelElementModel.stTemplateUuid, FormControlLabelElementModel::new));
	}

	public Optional<FormControlLabelElementModel> findFormControlLabelElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, FormControlLabelElementModel.stTemplateUuid, FormControlLabelElementModel::new));
	}

	public Optional<FormControlLabelElementModel> findFormControlLabelElementModelByControl(STValue value) {
		return Optional.ofNullable(db.find("control", value, FormControlLabelElementModel.stTemplateUuid, FormControlLabelElementModel::new));
	}

	public Optional<FormControlLabelElementModel> findFormControlLabelElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, FormControlLabelElementModel.stTemplateUuid, FormControlLabelElementModel::new));
	}

	public Optional<FormControlLabelElementModel> findFormControlLabelElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, FormControlLabelElementModel.stTemplateUuid, FormControlLabelElementModel::new));
	}

	public Optional<FormControlLabelElementModel> findFormControlLabelElementModelByInputRef(STValue value) {
		return Optional.ofNullable(db.find("inputRef", value, FormControlLabelElementModel.stTemplateUuid, FormControlLabelElementModel::new));
	}

	public Optional<FormControlLabelElementModel> findFormControlLabelElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, FormControlLabelElementModel.stTemplateUuid, FormControlLabelElementModel::new));
	}

	public Optional<FormControlLabelElementModel> findFormControlLabelElementModelByLabel(STValue value) {
		return Optional.ofNullable(db.find("label", value, FormControlLabelElementModel.stTemplateUuid, FormControlLabelElementModel::new));
	}

	public Optional<FormControlLabelElementModel> findFormControlLabelElementModelByLabelPlacement(STValue value) {
		return Optional.ofNullable(db.find("labelPlacement", value, FormControlLabelElementModel.stTemplateUuid, FormControlLabelElementModel::new));
	}

	public Optional<FormControlLabelElementModel> findFormControlLabelElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, FormControlLabelElementModel.stTemplateUuid, FormControlLabelElementModel::new));
	}

	public Optional<FormControlLabelElementModel> findFormControlLabelElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, FormControlLabelElementModel.stTemplateUuid, FormControlLabelElementModel::new));
	}

	public Optional<FormControlLabelElementModel> findFormControlLabelElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, FormControlLabelElementModel.stTemplateUuid, FormControlLabelElementModel::new));
	}

	public Optional<FormGroupElementModel> findFormGroupElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, FormGroupElementModel.stTemplateUuid, FormGroupElementModel::new));
	}

	public Optional<FormGroupElementModel> findFormGroupElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, FormGroupElementModel.stTemplateUuid, FormGroupElementModel::new));
	}

	public Optional<FormGroupElementModel> findFormGroupElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, FormGroupElementModel.stTemplateUuid, FormGroupElementModel::new));
	}

	public Optional<FormGroupElementModel> findFormGroupElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, FormGroupElementModel.stTemplateUuid, FormGroupElementModel::new));
	}

	public Optional<FormGroupElementModel> findFormGroupElementModelByRow(STValue value) {
		return Optional.ofNullable(db.find("row", value, FormGroupElementModel.stTemplateUuid, FormGroupElementModel::new));
	}

	public Optional<FormGroupElementModel> findFormGroupElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, FormGroupElementModel.stTemplateUuid, FormGroupElementModel::new));
	}

	public Optional<FormHelperTextElementModel> findFormHelperTextElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, FormHelperTextElementModel.stTemplateUuid, FormHelperTextElementModel::new));
	}

	public Optional<FormHelperTextElementModel> findFormHelperTextElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, FormHelperTextElementModel.stTemplateUuid, FormHelperTextElementModel::new));
	}

	public Optional<FormHelperTextElementModel> findFormHelperTextElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, FormHelperTextElementModel.stTemplateUuid, FormHelperTextElementModel::new));
	}

	public Optional<FormHelperTextElementModel> findFormHelperTextElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, FormHelperTextElementModel.stTemplateUuid, FormHelperTextElementModel::new));
	}

	public Optional<FormHelperTextElementModel> findFormHelperTextElementModelByError(STValue value) {
		return Optional.ofNullable(db.find("error", value, FormHelperTextElementModel.stTemplateUuid, FormHelperTextElementModel::new));
	}

	public Optional<FormHelperTextElementModel> findFormHelperTextElementModelByFilled(STValue value) {
		return Optional.ofNullable(db.find("filled", value, FormHelperTextElementModel.stTemplateUuid, FormHelperTextElementModel::new));
	}

	public Optional<FormHelperTextElementModel> findFormHelperTextElementModelByFocused(STValue value) {
		return Optional.ofNullable(db.find("focused", value, FormHelperTextElementModel.stTemplateUuid, FormHelperTextElementModel::new));
	}

	public Optional<FormHelperTextElementModel> findFormHelperTextElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, FormHelperTextElementModel.stTemplateUuid, FormHelperTextElementModel::new));
	}

	public Optional<FormHelperTextElementModel> findFormHelperTextElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, FormHelperTextElementModel.stTemplateUuid, FormHelperTextElementModel::new));
	}

	public Optional<FormHelperTextElementModel> findFormHelperTextElementModelByMargin(STValue value) {
		return Optional.ofNullable(db.find("margin", value, FormHelperTextElementModel.stTemplateUuid, FormHelperTextElementModel::new));
	}

	public Optional<FormHelperTextElementModel> findFormHelperTextElementModelByRequired(STValue value) {
		return Optional.ofNullable(db.find("required", value, FormHelperTextElementModel.stTemplateUuid, FormHelperTextElementModel::new));
	}

	public Optional<FormHelperTextElementModel> findFormHelperTextElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, FormHelperTextElementModel.stTemplateUuid, FormHelperTextElementModel::new));
	}

	public Optional<FormHelperTextElementModel> findFormHelperTextElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, FormHelperTextElementModel.stTemplateUuid, FormHelperTextElementModel::new));
	}

	public Optional<FormLabelElementModel> findFormLabelElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, FormLabelElementModel.stTemplateUuid, FormLabelElementModel::new));
	}

	public Optional<FormLabelElementModel> findFormLabelElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, FormLabelElementModel.stTemplateUuid, FormLabelElementModel::new));
	}

	public Optional<FormLabelElementModel> findFormLabelElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, FormLabelElementModel.stTemplateUuid, FormLabelElementModel::new));
	}

	public Optional<FormLabelElementModel> findFormLabelElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, FormLabelElementModel.stTemplateUuid, FormLabelElementModel::new));
	}

	public Optional<FormLabelElementModel> findFormLabelElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, FormLabelElementModel.stTemplateUuid, FormLabelElementModel::new));
	}

	public Optional<FormLabelElementModel> findFormLabelElementModelByError(STValue value) {
		return Optional.ofNullable(db.find("error", value, FormLabelElementModel.stTemplateUuid, FormLabelElementModel::new));
	}

	public Optional<FormLabelElementModel> findFormLabelElementModelByFilled(STValue value) {
		return Optional.ofNullable(db.find("filled", value, FormLabelElementModel.stTemplateUuid, FormLabelElementModel::new));
	}

	public Optional<FormLabelElementModel> findFormLabelElementModelByFocused(STValue value) {
		return Optional.ofNullable(db.find("focused", value, FormLabelElementModel.stTemplateUuid, FormLabelElementModel::new));
	}

	public Optional<FormLabelElementModel> findFormLabelElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, FormLabelElementModel.stTemplateUuid, FormLabelElementModel::new));
	}

	public Optional<FormLabelElementModel> findFormLabelElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, FormLabelElementModel.stTemplateUuid, FormLabelElementModel::new));
	}

	public Optional<FormLabelElementModel> findFormLabelElementModelByRequired(STValue value) {
		return Optional.ofNullable(db.find("required", value, FormLabelElementModel.stTemplateUuid, FormLabelElementModel::new));
	}

	public Optional<FormLabelElementModel> findFormLabelElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, FormLabelElementModel.stTemplateUuid, FormLabelElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByAlignContent(STValue value) {
		return Optional.ofNullable(db.find("alignContent", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByAlignItems(STValue value) {
		return Optional.ofNullable(db.find("alignItems", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByContainer(STValue value) {
		return Optional.ofNullable(db.find("container", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByDirection(STValue value) {
		return Optional.ofNullable(db.find("direction", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByItem(STValue value) {
		return Optional.ofNullable(db.find("item", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByJustify(STValue value) {
		return Optional.ofNullable(db.find("justify", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByLg(STValue value) {
		return Optional.ofNullable(db.find("lg", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByMd(STValue value) {
		return Optional.ofNullable(db.find("md", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelBySm(STValue value) {
		return Optional.ofNullable(db.find("sm", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelBySpacing(STValue value) {
		return Optional.ofNullable(db.find("spacing", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByWrap(STValue value) {
		return Optional.ofNullable(db.find("wrap", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByXl(STValue value) {
		return Optional.ofNullable(db.find("xl", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByXs(STValue value) {
		return Optional.ofNullable(db.find("xs", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridElementModel> findGridElementModelByZeroMinWidth(STValue value) {
		return Optional.ofNullable(db.find("zeroMinWidth", value, GridElementModel.stTemplateUuid, GridElementModel::new));
	}

	public Optional<GridListElementModel> findGridListElementModelByCellHeight(STValue value) {
		return Optional.ofNullable(db.find("cellHeight", value, GridListElementModel.stTemplateUuid, GridListElementModel::new));
	}

	public Optional<GridListElementModel> findGridListElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, GridListElementModel.stTemplateUuid, GridListElementModel::new));
	}

	public Optional<GridListElementModel> findGridListElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, GridListElementModel.stTemplateUuid, GridListElementModel::new));
	}

	public Optional<GridListElementModel> findGridListElementModelByCols(STValue value) {
		return Optional.ofNullable(db.find("cols", value, GridListElementModel.stTemplateUuid, GridListElementModel::new));
	}

	public Optional<GridListElementModel> findGridListElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, GridListElementModel.stTemplateUuid, GridListElementModel::new));
	}

	public Optional<GridListElementModel> findGridListElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, GridListElementModel.stTemplateUuid, GridListElementModel::new));
	}

	public Optional<GridListElementModel> findGridListElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, GridListElementModel.stTemplateUuid, GridListElementModel::new));
	}

	public Optional<GridListElementModel> findGridListElementModelBySpacing(STValue value) {
		return Optional.ofNullable(db.find("spacing", value, GridListElementModel.stTemplateUuid, GridListElementModel::new));
	}

	public Optional<GridListElementModel> findGridListElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, GridListElementModel.stTemplateUuid, GridListElementModel::new));
	}

	public Optional<GridListTileElementModel> findGridListTileElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, GridListTileElementModel.stTemplateUuid, GridListTileElementModel::new));
	}

	public Optional<GridListTileElementModel> findGridListTileElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, GridListTileElementModel.stTemplateUuid, GridListTileElementModel::new));
	}

	public Optional<GridListTileElementModel> findGridListTileElementModelByCols(STValue value) {
		return Optional.ofNullable(db.find("cols", value, GridListTileElementModel.stTemplateUuid, GridListTileElementModel::new));
	}

	public Optional<GridListTileElementModel> findGridListTileElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, GridListTileElementModel.stTemplateUuid, GridListTileElementModel::new));
	}

	public Optional<GridListTileElementModel> findGridListTileElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, GridListTileElementModel.stTemplateUuid, GridListTileElementModel::new));
	}

	public Optional<GridListTileElementModel> findGridListTileElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, GridListTileElementModel.stTemplateUuid, GridListTileElementModel::new));
	}

	public Optional<GridListTileElementModel> findGridListTileElementModelByRows(STValue value) {
		return Optional.ofNullable(db.find("rows", value, GridListTileElementModel.stTemplateUuid, GridListTileElementModel::new));
	}

	public Optional<GridListTileElementModel> findGridListTileElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, GridListTileElementModel.stTemplateUuid, GridListTileElementModel::new));
	}

	public Optional<GridListTileBarElementModel> findGridListTileBarElementModelByActionIcon(STValue value) {
		return Optional.ofNullable(db.find("actionIcon", value, GridListTileBarElementModel.stTemplateUuid, GridListTileBarElementModel::new));
	}

	public Optional<GridListTileBarElementModel> findGridListTileBarElementModelByActionPosition(STValue value) {
		return Optional.ofNullable(db.find("actionPosition", value, GridListTileBarElementModel.stTemplateUuid, GridListTileBarElementModel::new));
	}

	public Optional<GridListTileBarElementModel> findGridListTileBarElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, GridListTileBarElementModel.stTemplateUuid, GridListTileBarElementModel::new));
	}

	public Optional<GridListTileBarElementModel> findGridListTileBarElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, GridListTileBarElementModel.stTemplateUuid, GridListTileBarElementModel::new));
	}

	public Optional<GridListTileBarElementModel> findGridListTileBarElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, GridListTileBarElementModel.stTemplateUuid, GridListTileBarElementModel::new));
	}

	public Optional<GridListTileBarElementModel> findGridListTileBarElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, GridListTileBarElementModel.stTemplateUuid, GridListTileBarElementModel::new));
	}

	public Optional<GridListTileBarElementModel> findGridListTileBarElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, GridListTileBarElementModel.stTemplateUuid, GridListTileBarElementModel::new));
	}

	public Optional<GridListTileBarElementModel> findGridListTileBarElementModelBySubtitle(STValue value) {
		return Optional.ofNullable(db.find("subtitle", value, GridListTileBarElementModel.stTemplateUuid, GridListTileBarElementModel::new));
	}

	public Optional<GridListTileBarElementModel> findGridListTileBarElementModelByTitle(STValue value) {
		return Optional.ofNullable(db.find("title", value, GridListTileBarElementModel.stTemplateUuid, GridListTileBarElementModel::new));
	}

	public Optional<GridListTileBarElementModel> findGridListTileBarElementModelByTitlePosition(STValue value) {
		return Optional.ofNullable(db.find("titlePosition", value, GridListTileBarElementModel.stTemplateUuid, GridListTileBarElementModel::new));
	}

	public Optional<GrowElementModel> findGrowElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, GrowElementModel.stTemplateUuid, GrowElementModel::new));
	}

	public Optional<GrowElementModel> findGrowElementModelByDisableStrictModeCompat(STValue value) {
		return Optional.ofNullable(db.find("disableStrictModeCompat", value, GrowElementModel.stTemplateUuid, GrowElementModel::new));
	}

	public Optional<GrowElementModel> findGrowElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, GrowElementModel.stTemplateUuid, GrowElementModel::new));
	}

	public Optional<GrowElementModel> findGrowElementModelByIn(STValue value) {
		return Optional.ofNullable(db.find("in", value, GrowElementModel.stTemplateUuid, GrowElementModel::new));
	}

	public Optional<GrowElementModel> findGrowElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, GrowElementModel.stTemplateUuid, GrowElementModel::new));
	}

	public Optional<GrowElementModel> findGrowElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, GrowElementModel.stTemplateUuid, GrowElementModel::new));
	}

	public Optional<GrowElementModel> findGrowElementModelByTimeout(STValue value) {
		return Optional.ofNullable(db.find("timeout", value, GrowElementModel.stTemplateUuid, GrowElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelByImplementation(STValue value) {
		return Optional.ofNullable(db.find("implementation", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelByInitialWidth(STValue value) {
		return Optional.ofNullable(db.find("initialWidth", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelByLgDown(STValue value) {
		return Optional.ofNullable(db.find("lgDown", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelByLgUp(STValue value) {
		return Optional.ofNullable(db.find("lgUp", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelByMdDown(STValue value) {
		return Optional.ofNullable(db.find("mdDown", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelByMdUp(STValue value) {
		return Optional.ofNullable(db.find("mdUp", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelByOnly(STValue value) {
		return Optional.ofNullable(db.find("only", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelBySmDown(STValue value) {
		return Optional.ofNullable(db.find("smDown", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelBySmUp(STValue value) {
		return Optional.ofNullable(db.find("smUp", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelByXlDown(STValue value) {
		return Optional.ofNullable(db.find("xlDown", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelByXlUp(STValue value) {
		return Optional.ofNullable(db.find("xlUp", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelByXsDown(STValue value) {
		return Optional.ofNullable(db.find("xsDown", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<HiddenElementModel> findHiddenElementModelByXsUp(STValue value) {
		return Optional.ofNullable(db.find("xsUp", value, HiddenElementModel.stTemplateUuid, HiddenElementModel::new));
	}

	public Optional<IconElementModel> findIconElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, IconElementModel.stTemplateUuid, IconElementModel::new));
	}

	public Optional<IconElementModel> findIconElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, IconElementModel.stTemplateUuid, IconElementModel::new));
	}

	public Optional<IconElementModel> findIconElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, IconElementModel.stTemplateUuid, IconElementModel::new));
	}

	public Optional<IconElementModel> findIconElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, IconElementModel.stTemplateUuid, IconElementModel::new));
	}

	public Optional<IconElementModel> findIconElementModelByFontSize(STValue value) {
		return Optional.ofNullable(db.find("fontSize", value, IconElementModel.stTemplateUuid, IconElementModel::new));
	}

	public Optional<IconElementModel> findIconElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, IconElementModel.stTemplateUuid, IconElementModel::new));
	}

	public Optional<IconElementModel> findIconElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, IconElementModel.stTemplateUuid, IconElementModel::new));
	}

	public Optional<IconElementModel> findIconElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, IconElementModel.stTemplateUuid, IconElementModel::new));
	}

	public Optional<IconButtonElementModel> findIconButtonElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, IconButtonElementModel.stTemplateUuid, IconButtonElementModel::new));
	}

	public Optional<IconButtonElementModel> findIconButtonElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, IconButtonElementModel.stTemplateUuid, IconButtonElementModel::new));
	}

	public Optional<IconButtonElementModel> findIconButtonElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, IconButtonElementModel.stTemplateUuid, IconButtonElementModel::new));
	}

	public Optional<IconButtonElementModel> findIconButtonElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, IconButtonElementModel.stTemplateUuid, IconButtonElementModel::new));
	}

	public Optional<IconButtonElementModel> findIconButtonElementModelByDisableFocusRipple(STValue value) {
		return Optional.ofNullable(db.find("disableFocusRipple", value, IconButtonElementModel.stTemplateUuid, IconButtonElementModel::new));
	}

	public Optional<IconButtonElementModel> findIconButtonElementModelByDisableRipple(STValue value) {
		return Optional.ofNullable(db.find("disableRipple", value, IconButtonElementModel.stTemplateUuid, IconButtonElementModel::new));
	}

	public Optional<IconButtonElementModel> findIconButtonElementModelByEdge(STValue value) {
		return Optional.ofNullable(db.find("edge", value, IconButtonElementModel.stTemplateUuid, IconButtonElementModel::new));
	}

	public Optional<IconButtonElementModel> findIconButtonElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, IconButtonElementModel.stTemplateUuid, IconButtonElementModel::new));
	}

	public Optional<IconButtonElementModel> findIconButtonElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, IconButtonElementModel.stTemplateUuid, IconButtonElementModel::new));
	}

	public Optional<IconButtonElementModel> findIconButtonElementModelByOnClick(STValue value) {
		return Optional.ofNullable(db.find("onClick", value, IconButtonElementModel.stTemplateUuid, IconButtonElementModel::new));
	}

	public Optional<IconButtonElementModel> findIconButtonElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, IconButtonElementModel.stTemplateUuid, IconButtonElementModel::new));
	}

	public Optional<IconButtonElementModel> findIconButtonElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, IconButtonElementModel.stTemplateUuid, IconButtonElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByAutoComplete(STValue value) {
		return Optional.ofNullable(db.find("autoComplete", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByAutoFocus(STValue value) {
		return Optional.ofNullable(db.find("autoFocus", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByDefaultValue(STValue value) {
		return Optional.ofNullable(db.find("defaultValue", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByDisableUnderline(STValue value) {
		return Optional.ofNullable(db.find("disableUnderline", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByEndAdornment(STValue value) {
		return Optional.ofNullable(db.find("endAdornment", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByError(STValue value) {
		return Optional.ofNullable(db.find("error", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByFullWidth(STValue value) {
		return Optional.ofNullable(db.find("fullWidth", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByInputComponent(STValue value) {
		return Optional.ofNullable(db.find("inputComponent", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByInputProps(STValue value) {
		return Optional.ofNullable(db.find("inputProps", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByInputRef(STValue value) {
		return Optional.ofNullable(db.find("inputRef", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByMargin(STValue value) {
		return Optional.ofNullable(db.find("margin", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByMultiline(STValue value) {
		return Optional.ofNullable(db.find("multiline", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByPlaceholder(STValue value) {
		return Optional.ofNullable(db.find("placeholder", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByReadOnly(STValue value) {
		return Optional.ofNullable(db.find("readOnly", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByRequired(STValue value) {
		return Optional.ofNullable(db.find("required", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByRows(STValue value) {
		return Optional.ofNullable(db.find("rows", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByRowsMax(STValue value) {
		return Optional.ofNullable(db.find("rowsMax", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByStartAdornment(STValue value) {
		return Optional.ofNullable(db.find("startAdornment", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputElementModel> findInputElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, InputElementModel.stTemplateUuid, InputElementModel::new));
	}

	public Optional<InputAdornmentElementModel> findInputAdornmentElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, InputAdornmentElementModel.stTemplateUuid, InputAdornmentElementModel::new));
	}

	public Optional<InputAdornmentElementModel> findInputAdornmentElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, InputAdornmentElementModel.stTemplateUuid, InputAdornmentElementModel::new));
	}

	public Optional<InputAdornmentElementModel> findInputAdornmentElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, InputAdornmentElementModel.stTemplateUuid, InputAdornmentElementModel::new));
	}

	public Optional<InputAdornmentElementModel> findInputAdornmentElementModelByDisablePointerEvents(STValue value) {
		return Optional.ofNullable(db.find("disablePointerEvents", value, InputAdornmentElementModel.stTemplateUuid, InputAdornmentElementModel::new));
	}

	public Optional<InputAdornmentElementModel> findInputAdornmentElementModelByDisableTypography(STValue value) {
		return Optional.ofNullable(db.find("disableTypography", value, InputAdornmentElementModel.stTemplateUuid, InputAdornmentElementModel::new));
	}

	public Optional<InputAdornmentElementModel> findInputAdornmentElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, InputAdornmentElementModel.stTemplateUuid, InputAdornmentElementModel::new));
	}

	public Optional<InputAdornmentElementModel> findInputAdornmentElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, InputAdornmentElementModel.stTemplateUuid, InputAdornmentElementModel::new));
	}

	public Optional<InputAdornmentElementModel> findInputAdornmentElementModelByPosition(STValue value) {
		return Optional.ofNullable(db.find("position", value, InputAdornmentElementModel.stTemplateUuid, InputAdornmentElementModel::new));
	}

	public Optional<InputAdornmentElementModel> findInputAdornmentElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, InputAdornmentElementModel.stTemplateUuid, InputAdornmentElementModel::new));
	}

	public Optional<InputAdornmentElementModel> findInputAdornmentElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, InputAdornmentElementModel.stTemplateUuid, InputAdornmentElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByAutoComplete(STValue value) {
		return Optional.ofNullable(db.find("autoComplete", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByAutoFocus(STValue value) {
		return Optional.ofNullable(db.find("autoFocus", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByDefaultValue(STValue value) {
		return Optional.ofNullable(db.find("defaultValue", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByEndAdornment(STValue value) {
		return Optional.ofNullable(db.find("endAdornment", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByError(STValue value) {
		return Optional.ofNullable(db.find("error", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByFullWidth(STValue value) {
		return Optional.ofNullable(db.find("fullWidth", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByInputComponent(STValue value) {
		return Optional.ofNullable(db.find("inputComponent", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByInputProps(STValue value) {
		return Optional.ofNullable(db.find("inputProps", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByInputRef(STValue value) {
		return Optional.ofNullable(db.find("inputRef", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByMargin(STValue value) {
		return Optional.ofNullable(db.find("margin", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByMultiline(STValue value) {
		return Optional.ofNullable(db.find("multiline", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByOnBlur(STValue value) {
		return Optional.ofNullable(db.find("onBlur", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByPlaceholder(STValue value) {
		return Optional.ofNullable(db.find("placeholder", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByReadOnly(STValue value) {
		return Optional.ofNullable(db.find("readOnly", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByRequired(STValue value) {
		return Optional.ofNullable(db.find("required", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByRows(STValue value) {
		return Optional.ofNullable(db.find("rows", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByRowsMax(STValue value) {
		return Optional.ofNullable(db.find("rowsMax", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByRowsMin(STValue value) {
		return Optional.ofNullable(db.find("rowsMin", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByStartAdornment(STValue value) {
		return Optional.ofNullable(db.find("startAdornment", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputBaseElementModel> findInputBaseElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, InputBaseElementModel.stTemplateUuid, InputBaseElementModel::new));
	}

	public Optional<InputLabelElementModel> findInputLabelElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, InputLabelElementModel.stTemplateUuid, InputLabelElementModel::new));
	}

	public Optional<InputLabelElementModel> findInputLabelElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, InputLabelElementModel.stTemplateUuid, InputLabelElementModel::new));
	}

	public Optional<InputLabelElementModel> findInputLabelElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, InputLabelElementModel.stTemplateUuid, InputLabelElementModel::new));
	}

	public Optional<InputLabelElementModel> findInputLabelElementModelByDisableAnimation(STValue value) {
		return Optional.ofNullable(db.find("disableAnimation", value, InputLabelElementModel.stTemplateUuid, InputLabelElementModel::new));
	}

	public Optional<InputLabelElementModel> findInputLabelElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, InputLabelElementModel.stTemplateUuid, InputLabelElementModel::new));
	}

	public Optional<InputLabelElementModel> findInputLabelElementModelByError(STValue value) {
		return Optional.ofNullable(db.find("error", value, InputLabelElementModel.stTemplateUuid, InputLabelElementModel::new));
	}

	public Optional<InputLabelElementModel> findInputLabelElementModelByFocused(STValue value) {
		return Optional.ofNullable(db.find("focused", value, InputLabelElementModel.stTemplateUuid, InputLabelElementModel::new));
	}

	public Optional<InputLabelElementModel> findInputLabelElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, InputLabelElementModel.stTemplateUuid, InputLabelElementModel::new));
	}

	public Optional<InputLabelElementModel> findInputLabelElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, InputLabelElementModel.stTemplateUuid, InputLabelElementModel::new));
	}

	public Optional<InputLabelElementModel> findInputLabelElementModelByMargin(STValue value) {
		return Optional.ofNullable(db.find("margin", value, InputLabelElementModel.stTemplateUuid, InputLabelElementModel::new));
	}

	public Optional<InputLabelElementModel> findInputLabelElementModelByRequired(STValue value) {
		return Optional.ofNullable(db.find("required", value, InputLabelElementModel.stTemplateUuid, InputLabelElementModel::new));
	}

	public Optional<InputLabelElementModel> findInputLabelElementModelByShrink(STValue value) {
		return Optional.ofNullable(db.find("shrink", value, InputLabelElementModel.stTemplateUuid, InputLabelElementModel::new));
	}

	public Optional<InputLabelElementModel> findInputLabelElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, InputLabelElementModel.stTemplateUuid, InputLabelElementModel::new));
	}

	public Optional<InputLabelElementModel> findInputLabelElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, InputLabelElementModel.stTemplateUuid, InputLabelElementModel::new));
	}

	public Optional<LinearProgressElementModel> findLinearProgressElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, LinearProgressElementModel.stTemplateUuid, LinearProgressElementModel::new));
	}

	public Optional<LinearProgressElementModel> findLinearProgressElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, LinearProgressElementModel.stTemplateUuid, LinearProgressElementModel::new));
	}

	public Optional<LinearProgressElementModel> findLinearProgressElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, LinearProgressElementModel.stTemplateUuid, LinearProgressElementModel::new));
	}

	public Optional<LinearProgressElementModel> findLinearProgressElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, LinearProgressElementModel.stTemplateUuid, LinearProgressElementModel::new));
	}

	public Optional<LinearProgressElementModel> findLinearProgressElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, LinearProgressElementModel.stTemplateUuid, LinearProgressElementModel::new));
	}

	public Optional<LinearProgressElementModel> findLinearProgressElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, LinearProgressElementModel.stTemplateUuid, LinearProgressElementModel::new));
	}

	public Optional<LinearProgressElementModel> findLinearProgressElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, LinearProgressElementModel.stTemplateUuid, LinearProgressElementModel::new));
	}

	public Optional<LinearProgressElementModel> findLinearProgressElementModelByValueBuffer(STValue value) {
		return Optional.ofNullable(db.find("valueBuffer", value, LinearProgressElementModel.stTemplateUuid, LinearProgressElementModel::new));
	}

	public Optional<LinearProgressElementModel> findLinearProgressElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, LinearProgressElementModel.stTemplateUuid, LinearProgressElementModel::new));
	}

	public Optional<LinkElementModel> findLinkElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, LinkElementModel.stTemplateUuid, LinkElementModel::new));
	}

	public Optional<LinkElementModel> findLinkElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, LinkElementModel.stTemplateUuid, LinkElementModel::new));
	}

	public Optional<LinkElementModel> findLinkElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, LinkElementModel.stTemplateUuid, LinkElementModel::new));
	}

	public Optional<LinkElementModel> findLinkElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, LinkElementModel.stTemplateUuid, LinkElementModel::new));
	}

	public Optional<LinkElementModel> findLinkElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, LinkElementModel.stTemplateUuid, LinkElementModel::new));
	}

	public Optional<LinkElementModel> findLinkElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, LinkElementModel.stTemplateUuid, LinkElementModel::new));
	}

	public Optional<LinkElementModel> findLinkElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, LinkElementModel.stTemplateUuid, LinkElementModel::new));
	}

	public Optional<LinkElementModel> findLinkElementModelByTypographyClasses(STValue value) {
		return Optional.ofNullable(db.find("TypographyClasses", value, LinkElementModel.stTemplateUuid, LinkElementModel::new));
	}

	public Optional<LinkElementModel> findLinkElementModelByUnderline(STValue value) {
		return Optional.ofNullable(db.find("underline", value, LinkElementModel.stTemplateUuid, LinkElementModel::new));
	}

	public Optional<LinkElementModel> findLinkElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, LinkElementModel.stTemplateUuid, LinkElementModel::new));
	}

	public Optional<ListElementModel> findListElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ListElementModel.stTemplateUuid, ListElementModel::new));
	}

	public Optional<ListElementModel> findListElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ListElementModel.stTemplateUuid, ListElementModel::new));
	}

	public Optional<ListElementModel> findListElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, ListElementModel.stTemplateUuid, ListElementModel::new));
	}

	public Optional<ListElementModel> findListElementModelByDense(STValue value) {
		return Optional.ofNullable(db.find("dense", value, ListElementModel.stTemplateUuid, ListElementModel::new));
	}

	public Optional<ListElementModel> findListElementModelByDisablePadding(STValue value) {
		return Optional.ofNullable(db.find("disablePadding", value, ListElementModel.stTemplateUuid, ListElementModel::new));
	}

	public Optional<ListElementModel> findListElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ListElementModel.stTemplateUuid, ListElementModel::new));
	}

	public Optional<ListElementModel> findListElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ListElementModel.stTemplateUuid, ListElementModel::new));
	}

	public Optional<ListElementModel> findListElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ListElementModel.stTemplateUuid, ListElementModel::new));
	}

	public Optional<ListElementModel> findListElementModelBySubheader(STValue value) {
		return Optional.ofNullable(db.find("subheader", value, ListElementModel.stTemplateUuid, ListElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelByAlignItems(STValue value) {
		return Optional.ofNullable(db.find("alignItems", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelByAutoFocus(STValue value) {
		return Optional.ofNullable(db.find("autoFocus", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelByButton(STValue value) {
		return Optional.ofNullable(db.find("button", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelByContainerComponent(STValue value) {
		return Optional.ofNullable(db.find("ContainerComponent", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelByContainerProps(STValue value) {
		return Optional.ofNullable(db.find("ContainerProps", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelByDense(STValue value) {
		return Optional.ofNullable(db.find("dense", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelByDisableGutters(STValue value) {
		return Optional.ofNullable(db.find("disableGutters", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelByDivider(STValue value) {
		return Optional.ofNullable(db.find("divider", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelBySelected(STValue value) {
		return Optional.ofNullable(db.find("selected", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemElementModel> findListItemElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ListItemElementModel.stTemplateUuid, ListItemElementModel::new));
	}

	public Optional<ListItemAvatarElementModel> findListItemAvatarElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ListItemAvatarElementModel.stTemplateUuid, ListItemAvatarElementModel::new));
	}

	public Optional<ListItemAvatarElementModel> findListItemAvatarElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ListItemAvatarElementModel.stTemplateUuid, ListItemAvatarElementModel::new));
	}

	public Optional<ListItemAvatarElementModel> findListItemAvatarElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ListItemAvatarElementModel.stTemplateUuid, ListItemAvatarElementModel::new));
	}

	public Optional<ListItemAvatarElementModel> findListItemAvatarElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ListItemAvatarElementModel.stTemplateUuid, ListItemAvatarElementModel::new));
	}

	public Optional<ListItemAvatarElementModel> findListItemAvatarElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ListItemAvatarElementModel.stTemplateUuid, ListItemAvatarElementModel::new));
	}

	public Optional<ListItemIconElementModel> findListItemIconElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ListItemIconElementModel.stTemplateUuid, ListItemIconElementModel::new));
	}

	public Optional<ListItemIconElementModel> findListItemIconElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ListItemIconElementModel.stTemplateUuid, ListItemIconElementModel::new));
	}

	public Optional<ListItemIconElementModel> findListItemIconElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ListItemIconElementModel.stTemplateUuid, ListItemIconElementModel::new));
	}

	public Optional<ListItemIconElementModel> findListItemIconElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ListItemIconElementModel.stTemplateUuid, ListItemIconElementModel::new));
	}

	public Optional<ListItemIconElementModel> findListItemIconElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ListItemIconElementModel.stTemplateUuid, ListItemIconElementModel::new));
	}

	public Optional<ListItemSecondaryActionElementModel> findListItemSecondaryActionElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ListItemSecondaryActionElementModel.stTemplateUuid, ListItemSecondaryActionElementModel::new));
	}

	public Optional<ListItemSecondaryActionElementModel> findListItemSecondaryActionElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ListItemSecondaryActionElementModel.stTemplateUuid, ListItemSecondaryActionElementModel::new));
	}

	public Optional<ListItemSecondaryActionElementModel> findListItemSecondaryActionElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ListItemSecondaryActionElementModel.stTemplateUuid, ListItemSecondaryActionElementModel::new));
	}

	public Optional<ListItemSecondaryActionElementModel> findListItemSecondaryActionElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ListItemSecondaryActionElementModel.stTemplateUuid, ListItemSecondaryActionElementModel::new));
	}

	public Optional<ListItemSecondaryActionElementModel> findListItemSecondaryActionElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ListItemSecondaryActionElementModel.stTemplateUuid, ListItemSecondaryActionElementModel::new));
	}

	public Optional<ListItemTextElementModel> findListItemTextElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ListItemTextElementModel.stTemplateUuid, ListItemTextElementModel::new));
	}

	public Optional<ListItemTextElementModel> findListItemTextElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ListItemTextElementModel.stTemplateUuid, ListItemTextElementModel::new));
	}

	public Optional<ListItemTextElementModel> findListItemTextElementModelByDisableTypography(STValue value) {
		return Optional.ofNullable(db.find("disableTypography", value, ListItemTextElementModel.stTemplateUuid, ListItemTextElementModel::new));
	}

	public Optional<ListItemTextElementModel> findListItemTextElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ListItemTextElementModel.stTemplateUuid, ListItemTextElementModel::new));
	}

	public Optional<ListItemTextElementModel> findListItemTextElementModelByInset(STValue value) {
		return Optional.ofNullable(db.find("inset", value, ListItemTextElementModel.stTemplateUuid, ListItemTextElementModel::new));
	}

	public Optional<ListItemTextElementModel> findListItemTextElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ListItemTextElementModel.stTemplateUuid, ListItemTextElementModel::new));
	}

	public Optional<ListItemTextElementModel> findListItemTextElementModelByPrimary(STValue value) {
		return Optional.ofNullable(db.find("primary", value, ListItemTextElementModel.stTemplateUuid, ListItemTextElementModel::new));
	}

	public Optional<ListItemTextElementModel> findListItemTextElementModelByPrimaryTypographyProps(STValue value) {
		return Optional.ofNullable(db.find("primaryTypographyProps", value, ListItemTextElementModel.stTemplateUuid, ListItemTextElementModel::new));
	}

	public Optional<ListItemTextElementModel> findListItemTextElementModelBySecondary(STValue value) {
		return Optional.ofNullable(db.find("secondary", value, ListItemTextElementModel.stTemplateUuid, ListItemTextElementModel::new));
	}

	public Optional<ListItemTextElementModel> findListItemTextElementModelBySecondaryTypographyProps(STValue value) {
		return Optional.ofNullable(db.find("secondaryTypographyProps", value, ListItemTextElementModel.stTemplateUuid, ListItemTextElementModel::new));
	}

	public Optional<ListItemTextElementModel> findListItemTextElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ListItemTextElementModel.stTemplateUuid, ListItemTextElementModel::new));
	}

	public Optional<ListSubheaderElementModel> findListSubheaderElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ListSubheaderElementModel.stTemplateUuid, ListSubheaderElementModel::new));
	}

	public Optional<ListSubheaderElementModel> findListSubheaderElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ListSubheaderElementModel.stTemplateUuid, ListSubheaderElementModel::new));
	}

	public Optional<ListSubheaderElementModel> findListSubheaderElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, ListSubheaderElementModel.stTemplateUuid, ListSubheaderElementModel::new));
	}

	public Optional<ListSubheaderElementModel> findListSubheaderElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, ListSubheaderElementModel.stTemplateUuid, ListSubheaderElementModel::new));
	}

	public Optional<ListSubheaderElementModel> findListSubheaderElementModelByDisableGutters(STValue value) {
		return Optional.ofNullable(db.find("disableGutters", value, ListSubheaderElementModel.stTemplateUuid, ListSubheaderElementModel::new));
	}

	public Optional<ListSubheaderElementModel> findListSubheaderElementModelByDisableSticky(STValue value) {
		return Optional.ofNullable(db.find("disableSticky", value, ListSubheaderElementModel.stTemplateUuid, ListSubheaderElementModel::new));
	}

	public Optional<ListSubheaderElementModel> findListSubheaderElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ListSubheaderElementModel.stTemplateUuid, ListSubheaderElementModel::new));
	}

	public Optional<ListSubheaderElementModel> findListSubheaderElementModelByInset(STValue value) {
		return Optional.ofNullable(db.find("inset", value, ListSubheaderElementModel.stTemplateUuid, ListSubheaderElementModel::new));
	}

	public Optional<ListSubheaderElementModel> findListSubheaderElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ListSubheaderElementModel.stTemplateUuid, ListSubheaderElementModel::new));
	}

	public Optional<ListSubheaderElementModel> findListSubheaderElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ListSubheaderElementModel.stTemplateUuid, ListSubheaderElementModel::new));
	}

	public Optional<MaterialUIComponentModel> findMaterialUIComponentModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, MaterialUIComponentModel.stTemplateUuid, MaterialUIComponentModel::new));
	}

	public Optional<MaterialUIComponentModel> findMaterialUIComponentModelByRenderCondition(STValue value) {
		return Optional.ofNullable(db.find("renderCondition", value, MaterialUIComponentModel.stTemplateUuid, MaterialUIComponentModel::new));
	}

	public Optional<MaterialUIComponentModel> findMaterialUIComponentModelByRenderTrue(STValue value) {
		return Optional.ofNullable(db.find("renderTrue", value, MaterialUIComponentModel.stTemplateUuid, MaterialUIComponentModel::new));
	}

	public Optional<MaterialUIComponentModel> findMaterialUIComponentModelByRenderFalse(STValue value) {
		return Optional.ofNullable(db.find("renderFalse", value, MaterialUIComponentModel.stTemplateUuid, MaterialUIComponentModel::new));
	}

	public Optional<MaterialUIComponentModel> findMaterialUIComponentModelByRenderElement(STValue value) {
		return Optional.ofNullable(db.find("renderElement", value, MaterialUIComponentModel.stTemplateUuid, MaterialUIComponentModel::new));
	}

	public Optional<StyleClassModel> findStyleClassModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, StyleClassModel.stTemplateUuid, StyleClassModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByAnchorEl(STValue value) {
		return Optional.ofNullable(db.find("anchorEl", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByAutoFocus(STValue value) {
		return Optional.ofNullable(db.find("autoFocus", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByDisableAutoFocusItem(STValue value) {
		return Optional.ofNullable(db.find("disableAutoFocusItem", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByKeepMounted(STValue value) {
		return Optional.ofNullable(db.find("keepMounted", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByMenuListProps(STValue value) {
		return Optional.ofNullable(db.find("MenuListProps", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByOnClose(STValue value) {
		return Optional.ofNullable(db.find("onClose", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByOnEnter(STValue value) {
		return Optional.ofNullable(db.find("onEnter", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByOnEntered(STValue value) {
		return Optional.ofNullable(db.find("onEntered", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByOnEntering(STValue value) {
		return Optional.ofNullable(db.find("onEntering", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByOnExit(STValue value) {
		return Optional.ofNullable(db.find("onExit", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByOnExited(STValue value) {
		return Optional.ofNullable(db.find("onExited", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByOnExiting(STValue value) {
		return Optional.ofNullable(db.find("onExiting", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByOpen(STValue value) {
		return Optional.ofNullable(db.find("open", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByPopoverClasses(STValue value) {
		return Optional.ofNullable(db.find("PopoverClasses", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByTransitionDuration(STValue value) {
		return Optional.ofNullable(db.find("transitionDuration", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuElementModel> findMenuElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, MenuElementModel.stTemplateUuid, MenuElementModel::new));
	}

	public Optional<MenuItemElementModel> findMenuItemElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, MenuItemElementModel.stTemplateUuid, MenuItemElementModel::new));
	}

	public Optional<MenuItemElementModel> findMenuItemElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, MenuItemElementModel.stTemplateUuid, MenuItemElementModel::new));
	}

	public Optional<MenuItemElementModel> findMenuItemElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, MenuItemElementModel.stTemplateUuid, MenuItemElementModel::new));
	}

	public Optional<MenuItemElementModel> findMenuItemElementModelByDense(STValue value) {
		return Optional.ofNullable(db.find("dense", value, MenuItemElementModel.stTemplateUuid, MenuItemElementModel::new));
	}

	public Optional<MenuItemElementModel> findMenuItemElementModelByDisableGutters(STValue value) {
		return Optional.ofNullable(db.find("disableGutters", value, MenuItemElementModel.stTemplateUuid, MenuItemElementModel::new));
	}

	public Optional<MenuItemElementModel> findMenuItemElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, MenuItemElementModel.stTemplateUuid, MenuItemElementModel::new));
	}

	public Optional<MenuItemElementModel> findMenuItemElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, MenuItemElementModel.stTemplateUuid, MenuItemElementModel::new));
	}

	public Optional<MenuItemElementModel> findMenuItemElementModelByListItemClasses(STValue value) {
		return Optional.ofNullable(db.find("ListItemClasses", value, MenuItemElementModel.stTemplateUuid, MenuItemElementModel::new));
	}

	public Optional<MenuItemElementModel> findMenuItemElementModelByOnClick(STValue value) {
		return Optional.ofNullable(db.find("onClick", value, MenuItemElementModel.stTemplateUuid, MenuItemElementModel::new));
	}

	public Optional<MenuItemElementModel> findMenuItemElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, MenuItemElementModel.stTemplateUuid, MenuItemElementModel::new));
	}

	public Optional<MenuListElementModel> findMenuListElementModelByAutoFocus(STValue value) {
		return Optional.ofNullable(db.find("autoFocus", value, MenuListElementModel.stTemplateUuid, MenuListElementModel::new));
	}

	public Optional<MenuListElementModel> findMenuListElementModelByAutoFocusItem(STValue value) {
		return Optional.ofNullable(db.find("autoFocusItem", value, MenuListElementModel.stTemplateUuid, MenuListElementModel::new));
	}

	public Optional<MenuListElementModel> findMenuListElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, MenuListElementModel.stTemplateUuid, MenuListElementModel::new));
	}

	public Optional<MenuListElementModel> findMenuListElementModelByDisabledItemsFocusable(STValue value) {
		return Optional.ofNullable(db.find("disabledItemsFocusable", value, MenuListElementModel.stTemplateUuid, MenuListElementModel::new));
	}

	public Optional<MenuListElementModel> findMenuListElementModelByDisableListWrap(STValue value) {
		return Optional.ofNullable(db.find("disableListWrap", value, MenuListElementModel.stTemplateUuid, MenuListElementModel::new));
	}

	public Optional<MenuListElementModel> findMenuListElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, MenuListElementModel.stTemplateUuid, MenuListElementModel::new));
	}

	public Optional<MenuListElementModel> findMenuListElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, MenuListElementModel.stTemplateUuid, MenuListElementModel::new));
	}

	public Optional<MenuListElementModel> findMenuListElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, MenuListElementModel.stTemplateUuid, MenuListElementModel::new));
	}

	public Optional<MenuListElementModel> findMenuListElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, MenuListElementModel.stTemplateUuid, MenuListElementModel::new));
	}

	public Optional<MobileStepperElementModel> findMobileStepperElementModelByActiveStep(STValue value) {
		return Optional.ofNullable(db.find("activeStep", value, MobileStepperElementModel.stTemplateUuid, MobileStepperElementModel::new));
	}

	public Optional<MobileStepperElementModel> findMobileStepperElementModelByBackButton(STValue value) {
		return Optional.ofNullable(db.find("backButton", value, MobileStepperElementModel.stTemplateUuid, MobileStepperElementModel::new));
	}

	public Optional<MobileStepperElementModel> findMobileStepperElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, MobileStepperElementModel.stTemplateUuid, MobileStepperElementModel::new));
	}

	public Optional<MobileStepperElementModel> findMobileStepperElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, MobileStepperElementModel.stTemplateUuid, MobileStepperElementModel::new));
	}

	public Optional<MobileStepperElementModel> findMobileStepperElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, MobileStepperElementModel.stTemplateUuid, MobileStepperElementModel::new));
	}

	public Optional<MobileStepperElementModel> findMobileStepperElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, MobileStepperElementModel.stTemplateUuid, MobileStepperElementModel::new));
	}

	public Optional<MobileStepperElementModel> findMobileStepperElementModelByLinearProgressProps(STValue value) {
		return Optional.ofNullable(db.find("LinearProgressProps", value, MobileStepperElementModel.stTemplateUuid, MobileStepperElementModel::new));
	}

	public Optional<MobileStepperElementModel> findMobileStepperElementModelByNextButton(STValue value) {
		return Optional.ofNullable(db.find("nextButton", value, MobileStepperElementModel.stTemplateUuid, MobileStepperElementModel::new));
	}

	public Optional<MobileStepperElementModel> findMobileStepperElementModelByPosition(STValue value) {
		return Optional.ofNullable(db.find("position", value, MobileStepperElementModel.stTemplateUuid, MobileStepperElementModel::new));
	}

	public Optional<MobileStepperElementModel> findMobileStepperElementModelBySteps(STValue value) {
		return Optional.ofNullable(db.find("steps", value, MobileStepperElementModel.stTemplateUuid, MobileStepperElementModel::new));
	}

	public Optional<MobileStepperElementModel> findMobileStepperElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, MobileStepperElementModel.stTemplateUuid, MobileStepperElementModel::new));
	}

	public Optional<MobileStepperElementModel> findMobileStepperElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, MobileStepperElementModel.stTemplateUuid, MobileStepperElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByBackdropComponent(STValue value) {
		return Optional.ofNullable(db.find("BackdropComponent", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByBackdropProps(STValue value) {
		return Optional.ofNullable(db.find("BackdropProps", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByCloseAfterTransition(STValue value) {
		return Optional.ofNullable(db.find("closeAfterTransition", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByContainer(STValue value) {
		return Optional.ofNullable(db.find("container", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByDisableAutoFocus(STValue value) {
		return Optional.ofNullable(db.find("disableAutoFocus", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByDisableBackdropClick(STValue value) {
		return Optional.ofNullable(db.find("disableBackdropClick", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByDisableEnforceFocus(STValue value) {
		return Optional.ofNullable(db.find("disableEnforceFocus", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByDisableEscapeKeyDown(STValue value) {
		return Optional.ofNullable(db.find("disableEscapeKeyDown", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByDisablePortal(STValue value) {
		return Optional.ofNullable(db.find("disablePortal", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByDisableRestoreFocus(STValue value) {
		return Optional.ofNullable(db.find("disableRestoreFocus", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByDisableScrollLock(STValue value) {
		return Optional.ofNullable(db.find("disableScrollLock", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByHideBackdrop(STValue value) {
		return Optional.ofNullable(db.find("hideBackdrop", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByKeepMounted(STValue value) {
		return Optional.ofNullable(db.find("keepMounted", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByOnBackdropClick(STValue value) {
		return Optional.ofNullable(db.find("onBackdropClick", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByOnClose(STValue value) {
		return Optional.ofNullable(db.find("onClose", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByOnEscapeKeyDown(STValue value) {
		return Optional.ofNullable(db.find("onEscapeKeyDown", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByOnRendered(STValue value) {
		return Optional.ofNullable(db.find("onRendered", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<ModalElementModel> findModalElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ModalElementModel.stTemplateUuid, ModalElementModel::new));
	}

	public Optional<NativeSelectElementModel> findNativeSelectElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, NativeSelectElementModel.stTemplateUuid, NativeSelectElementModel::new));
	}

	public Optional<NativeSelectElementModel> findNativeSelectElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, NativeSelectElementModel.stTemplateUuid, NativeSelectElementModel::new));
	}

	public Optional<NativeSelectElementModel> findNativeSelectElementModelByIconComponent(STValue value) {
		return Optional.ofNullable(db.find("IconComponent", value, NativeSelectElementModel.stTemplateUuid, NativeSelectElementModel::new));
	}

	public Optional<NativeSelectElementModel> findNativeSelectElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, NativeSelectElementModel.stTemplateUuid, NativeSelectElementModel::new));
	}

	public Optional<NativeSelectElementModel> findNativeSelectElementModelByInput(STValue value) {
		return Optional.ofNullable(db.find("input", value, NativeSelectElementModel.stTemplateUuid, NativeSelectElementModel::new));
	}

	public Optional<NativeSelectElementModel> findNativeSelectElementModelByInputProps(STValue value) {
		return Optional.ofNullable(db.find("inputProps", value, NativeSelectElementModel.stTemplateUuid, NativeSelectElementModel::new));
	}

	public Optional<NativeSelectElementModel> findNativeSelectElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, NativeSelectElementModel.stTemplateUuid, NativeSelectElementModel::new));
	}

	public Optional<NativeSelectElementModel> findNativeSelectElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, NativeSelectElementModel.stTemplateUuid, NativeSelectElementModel::new));
	}

	public Optional<NativeSelectElementModel> findNativeSelectElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, NativeSelectElementModel.stTemplateUuid, NativeSelectElementModel::new));
	}

	public Optional<NativeSelectElementModel> findNativeSelectElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, NativeSelectElementModel.stTemplateUuid, NativeSelectElementModel::new));
	}

	public Optional<NativeSelectElementModel> findNativeSelectElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, NativeSelectElementModel.stTemplateUuid, NativeSelectElementModel::new));
	}

	public Optional<NoSsrElementModel> findNoSsrElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, NoSsrElementModel.stTemplateUuid, NoSsrElementModel::new));
	}

	public Optional<NoSsrElementModel> findNoSsrElementModelByDefer(STValue value) {
		return Optional.ofNullable(db.find("defer", value, NoSsrElementModel.stTemplateUuid, NoSsrElementModel::new));
	}

	public Optional<NoSsrElementModel> findNoSsrElementModelByFallback(STValue value) {
		return Optional.ofNullable(db.find("fallback", value, NoSsrElementModel.stTemplateUuid, NoSsrElementModel::new));
	}

	public Optional<NoSsrElementModel> findNoSsrElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, NoSsrElementModel.stTemplateUuid, NoSsrElementModel::new));
	}

	public Optional<NoSsrElementModel> findNoSsrElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, NoSsrElementModel.stTemplateUuid, NoSsrElementModel::new));
	}

	public Optional<NoSsrElementModel> findNoSsrElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, NoSsrElementModel.stTemplateUuid, NoSsrElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByAutoComplete(STValue value) {
		return Optional.ofNullable(db.find("autoComplete", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByAutoFocus(STValue value) {
		return Optional.ofNullable(db.find("autoFocus", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByDefaultValue(STValue value) {
		return Optional.ofNullable(db.find("defaultValue", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByEndAdornment(STValue value) {
		return Optional.ofNullable(db.find("endAdornment", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByError(STValue value) {
		return Optional.ofNullable(db.find("error", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByFullWidth(STValue value) {
		return Optional.ofNullable(db.find("fullWidth", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByInputComponent(STValue value) {
		return Optional.ofNullable(db.find("inputComponent", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByInputProps(STValue value) {
		return Optional.ofNullable(db.find("inputProps", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByInputRef(STValue value) {
		return Optional.ofNullable(db.find("inputRef", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByLabel(STValue value) {
		return Optional.ofNullable(db.find("label", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByLabelWidth(STValue value) {
		return Optional.ofNullable(db.find("labelWidth", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByMargin(STValue value) {
		return Optional.ofNullable(db.find("margin", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByMultiline(STValue value) {
		return Optional.ofNullable(db.find("multiline", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByNotched(STValue value) {
		return Optional.ofNullable(db.find("notched", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByPlaceholder(STValue value) {
		return Optional.ofNullable(db.find("placeholder", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByReadOnly(STValue value) {
		return Optional.ofNullable(db.find("readOnly", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByRequired(STValue value) {
		return Optional.ofNullable(db.find("required", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByRows(STValue value) {
		return Optional.ofNullable(db.find("rows", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByRowsMax(STValue value) {
		return Optional.ofNullable(db.find("rowsMax", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByStartAdornment(STValue value) {
		return Optional.ofNullable(db.find("startAdornment", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<OutlinedInputElementModel> findOutlinedInputElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, OutlinedInputElementModel.stTemplateUuid, OutlinedInputElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByBoundaryCount(STValue value) {
		return Optional.ofNullable(db.find("boundaryCount", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByCount(STValue value) {
		return Optional.ofNullable(db.find("count", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByDefaultPage(STValue value) {
		return Optional.ofNullable(db.find("defaultPage", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByGetItemAriaLabel(STValue value) {
		return Optional.ofNullable(db.find("getItemAriaLabel", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByHideNextButton(STValue value) {
		return Optional.ofNullable(db.find("hideNextButton", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByHidePrevButton(STValue value) {
		return Optional.ofNullable(db.find("hidePrevButton", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByPage(STValue value) {
		return Optional.ofNullable(db.find("page", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByRenderItem(STValue value) {
		return Optional.ofNullable(db.find("renderItem", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByShape(STValue value) {
		return Optional.ofNullable(db.find("shape", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByShowFirstButton(STValue value) {
		return Optional.ofNullable(db.find("showFirstButton", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByShowLastButton(STValue value) {
		return Optional.ofNullable(db.find("showLastButton", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelBySiblingCount(STValue value) {
		return Optional.ofNullable(db.find("siblingCount", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationElementModel> findPaginationElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, PaginationElementModel.stTemplateUuid, PaginationElementModel::new));
	}

	public Optional<PaginationItemElementModel> findPaginationItemElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, PaginationItemElementModel.stTemplateUuid, PaginationItemElementModel::new));
	}

	public Optional<PaginationItemElementModel> findPaginationItemElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, PaginationItemElementModel.stTemplateUuid, PaginationItemElementModel::new));
	}

	public Optional<PaginationItemElementModel> findPaginationItemElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, PaginationItemElementModel.stTemplateUuid, PaginationItemElementModel::new));
	}

	public Optional<PaginationItemElementModel> findPaginationItemElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, PaginationItemElementModel.stTemplateUuid, PaginationItemElementModel::new));
	}

	public Optional<PaginationItemElementModel> findPaginationItemElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, PaginationItemElementModel.stTemplateUuid, PaginationItemElementModel::new));
	}

	public Optional<PaginationItemElementModel> findPaginationItemElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, PaginationItemElementModel.stTemplateUuid, PaginationItemElementModel::new));
	}

	public Optional<PaginationItemElementModel> findPaginationItemElementModelByPage(STValue value) {
		return Optional.ofNullable(db.find("page", value, PaginationItemElementModel.stTemplateUuid, PaginationItemElementModel::new));
	}

	public Optional<PaginationItemElementModel> findPaginationItemElementModelBySelected(STValue value) {
		return Optional.ofNullable(db.find("selected", value, PaginationItemElementModel.stTemplateUuid, PaginationItemElementModel::new));
	}

	public Optional<PaginationItemElementModel> findPaginationItemElementModelByShape(STValue value) {
		return Optional.ofNullable(db.find("shape", value, PaginationItemElementModel.stTemplateUuid, PaginationItemElementModel::new));
	}

	public Optional<PaginationItemElementModel> findPaginationItemElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, PaginationItemElementModel.stTemplateUuid, PaginationItemElementModel::new));
	}

	public Optional<PaginationItemElementModel> findPaginationItemElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, PaginationItemElementModel.stTemplateUuid, PaginationItemElementModel::new));
	}

	public Optional<PaginationItemElementModel> findPaginationItemElementModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, PaginationItemElementModel.stTemplateUuid, PaginationItemElementModel::new));
	}

	public Optional<PaginationItemElementModel> findPaginationItemElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, PaginationItemElementModel.stTemplateUuid, PaginationItemElementModel::new));
	}

	public Optional<PaperElementModel> findPaperElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, PaperElementModel.stTemplateUuid, PaperElementModel::new));
	}

	public Optional<PaperElementModel> findPaperElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, PaperElementModel.stTemplateUuid, PaperElementModel::new));
	}

	public Optional<PaperElementModel> findPaperElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, PaperElementModel.stTemplateUuid, PaperElementModel::new));
	}

	public Optional<PaperElementModel> findPaperElementModelByElevation(STValue value) {
		return Optional.ofNullable(db.find("elevation", value, PaperElementModel.stTemplateUuid, PaperElementModel::new));
	}

	public Optional<PaperElementModel> findPaperElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, PaperElementModel.stTemplateUuid, PaperElementModel::new));
	}

	public Optional<PaperElementModel> findPaperElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, PaperElementModel.stTemplateUuid, PaperElementModel::new));
	}

	public Optional<PaperElementModel> findPaperElementModelBySquare(STValue value) {
		return Optional.ofNullable(db.find("square", value, PaperElementModel.stTemplateUuid, PaperElementModel::new));
	}

	public Optional<PaperElementModel> findPaperElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, PaperElementModel.stTemplateUuid, PaperElementModel::new));
	}

	public Optional<PaperElementModel> findPaperElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, PaperElementModel.stTemplateUuid, PaperElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByAction(STValue value) {
		return Optional.ofNullable(db.find("action", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByAnchorEl(STValue value) {
		return Optional.ofNullable(db.find("anchorEl", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByAnchorOrigin(STValue value) {
		return Optional.ofNullable(db.find("anchorOrigin", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByAnchorPosition(STValue value) {
		return Optional.ofNullable(db.find("anchorPosition", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByAnchorReference(STValue value) {
		return Optional.ofNullable(db.find("anchorReference", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByContainer(STValue value) {
		return Optional.ofNullable(db.find("container", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByElevation(STValue value) {
		return Optional.ofNullable(db.find("elevation", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByGetContentAnchorEl(STValue value) {
		return Optional.ofNullable(db.find("getContentAnchorEl", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByMarginThreshold(STValue value) {
		return Optional.ofNullable(db.find("marginThreshold", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByOnClose(STValue value) {
		return Optional.ofNullable(db.find("onClose", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByOnEnter(STValue value) {
		return Optional.ofNullable(db.find("onEnter", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByOnEntered(STValue value) {
		return Optional.ofNullable(db.find("onEntered", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByOnEntering(STValue value) {
		return Optional.ofNullable(db.find("onEntering", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByOnExit(STValue value) {
		return Optional.ofNullable(db.find("onExit", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByOnExited(STValue value) {
		return Optional.ofNullable(db.find("onExited", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByOnExiting(STValue value) {
		return Optional.ofNullable(db.find("onExiting", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByPaperProps(STValue value) {
		return Optional.ofNullable(db.find("PaperProps", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByTransformOrigin(STValue value) {
		return Optional.ofNullable(db.find("transformOrigin", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByTransitionComponent(STValue value) {
		return Optional.ofNullable(db.find("TransitionComponent", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByTransitionDuration(STValue value) {
		return Optional.ofNullable(db.find("transitionDuration", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopoverElementModel> findPopoverElementModelByTransitionProps(STValue value) {
		return Optional.ofNullable(db.find("TransitionProps", value, PopoverElementModel.stTemplateUuid, PopoverElementModel::new));
	}

	public Optional<PopperElementModel> findPopperElementModelByAnchorEl(STValue value) {
		return Optional.ofNullable(db.find("anchorEl", value, PopperElementModel.stTemplateUuid, PopperElementModel::new));
	}

	public Optional<PopperElementModel> findPopperElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, PopperElementModel.stTemplateUuid, PopperElementModel::new));
	}

	public Optional<PopperElementModel> findPopperElementModelByContainer(STValue value) {
		return Optional.ofNullable(db.find("container", value, PopperElementModel.stTemplateUuid, PopperElementModel::new));
	}

	public Optional<PopperElementModel> findPopperElementModelByDisablePortal(STValue value) {
		return Optional.ofNullable(db.find("disablePortal", value, PopperElementModel.stTemplateUuid, PopperElementModel::new));
	}

	public Optional<PopperElementModel> findPopperElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, PopperElementModel.stTemplateUuid, PopperElementModel::new));
	}

	public Optional<PopperElementModel> findPopperElementModelByKeepMounted(STValue value) {
		return Optional.ofNullable(db.find("keepMounted", value, PopperElementModel.stTemplateUuid, PopperElementModel::new));
	}

	public Optional<PopperElementModel> findPopperElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, PopperElementModel.stTemplateUuid, PopperElementModel::new));
	}

	public Optional<PopperElementModel> findPopperElementModelByModifiers(STValue value) {
		return Optional.ofNullable(db.find("modifiers", value, PopperElementModel.stTemplateUuid, PopperElementModel::new));
	}

	public Optional<PopperElementModel> findPopperElementModelByPlacement(STValue value) {
		return Optional.ofNullable(db.find("placement", value, PopperElementModel.stTemplateUuid, PopperElementModel::new));
	}

	public Optional<PopperElementModel> findPopperElementModelByPopperOptions(STValue value) {
		return Optional.ofNullable(db.find("popperOptions", value, PopperElementModel.stTemplateUuid, PopperElementModel::new));
	}

	public Optional<PopperElementModel> findPopperElementModelByPopperRef(STValue value) {
		return Optional.ofNullable(db.find("popperRef", value, PopperElementModel.stTemplateUuid, PopperElementModel::new));
	}

	public Optional<PopperElementModel> findPopperElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, PopperElementModel.stTemplateUuid, PopperElementModel::new));
	}

	public Optional<PopperElementModel> findPopperElementModelByTransition(STValue value) {
		return Optional.ofNullable(db.find("transition", value, PopperElementModel.stTemplateUuid, PopperElementModel::new));
	}

	public Optional<PortalElementModel> findPortalElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, PortalElementModel.stTemplateUuid, PortalElementModel::new));
	}

	public Optional<PortalElementModel> findPortalElementModelByContainer(STValue value) {
		return Optional.ofNullable(db.find("container", value, PortalElementModel.stTemplateUuid, PortalElementModel::new));
	}

	public Optional<PortalElementModel> findPortalElementModelByDisablePortal(STValue value) {
		return Optional.ofNullable(db.find("disablePortal", value, PortalElementModel.stTemplateUuid, PortalElementModel::new));
	}

	public Optional<PortalElementModel> findPortalElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, PortalElementModel.stTemplateUuid, PortalElementModel::new));
	}

	public Optional<PortalElementModel> findPortalElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, PortalElementModel.stTemplateUuid, PortalElementModel::new));
	}

	public Optional<PortalElementModel> findPortalElementModelByOnRendered(STValue value) {
		return Optional.ofNullable(db.find("onRendered", value, PortalElementModel.stTemplateUuid, PortalElementModel::new));
	}

	public Optional<PortalElementModel> findPortalElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, PortalElementModel.stTemplateUuid, PortalElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByChecked(STValue value) {
		return Optional.ofNullable(db.find("checked", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByCheckedIcon(STValue value) {
		return Optional.ofNullable(db.find("checkedIcon", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByDisableRipple(STValue value) {
		return Optional.ofNullable(db.find("disableRipple", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByInputProps(STValue value) {
		return Optional.ofNullable(db.find("inputProps", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByInputRef(STValue value) {
		return Optional.ofNullable(db.find("inputRef", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByRequired(STValue value) {
		return Optional.ofNullable(db.find("required", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioElementModel> findRadioElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, RadioElementModel.stTemplateUuid, RadioElementModel::new));
	}

	public Optional<RadioGroupElementModel> findRadioGroupElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, RadioGroupElementModel.stTemplateUuid, RadioGroupElementModel::new));
	}

	public Optional<RadioGroupElementModel> findRadioGroupElementModelByDefaultValue(STValue value) {
		return Optional.ofNullable(db.find("defaultValue", value, RadioGroupElementModel.stTemplateUuid, RadioGroupElementModel::new));
	}

	public Optional<RadioGroupElementModel> findRadioGroupElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, RadioGroupElementModel.stTemplateUuid, RadioGroupElementModel::new));
	}

	public Optional<RadioGroupElementModel> findRadioGroupElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, RadioGroupElementModel.stTemplateUuid, RadioGroupElementModel::new));
	}

	public Optional<RadioGroupElementModel> findRadioGroupElementModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, RadioGroupElementModel.stTemplateUuid, RadioGroupElementModel::new));
	}

	public Optional<RadioGroupElementModel> findRadioGroupElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, RadioGroupElementModel.stTemplateUuid, RadioGroupElementModel::new));
	}

	public Optional<RadioGroupElementModel> findRadioGroupElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, RadioGroupElementModel.stTemplateUuid, RadioGroupElementModel::new));
	}

	public Optional<RadioGroupElementModel> findRadioGroupElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, RadioGroupElementModel.stTemplateUuid, RadioGroupElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByDefaultValue(STValue value) {
		return Optional.ofNullable(db.find("defaultValue", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByEmptyIcon(STValue value) {
		return Optional.ofNullable(db.find("emptyIcon", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByEmptyLabelText(STValue value) {
		return Optional.ofNullable(db.find("emptyLabelText", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByGetLabelText(STValue value) {
		return Optional.ofNullable(db.find("getLabelText", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByIconContainerComponent(STValue value) {
		return Optional.ofNullable(db.find("IconContainerComponent", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByMax(STValue value) {
		return Optional.ofNullable(db.find("max", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByOnChangeActive(STValue value) {
		return Optional.ofNullable(db.find("onChangeActive", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByPrecision(STValue value) {
		return Optional.ofNullable(db.find("precision", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByReadOnly(STValue value) {
		return Optional.ofNullable(db.find("readOnly", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RatingElementModel> findRatingElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, RatingElementModel.stTemplateUuid, RatingElementModel::new));
	}

	public Optional<RootRefElementModel> findRootRefElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, RootRefElementModel.stTemplateUuid, RootRefElementModel::new));
	}

	public Optional<RootRefElementModel> findRootRefElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, RootRefElementModel.stTemplateUuid, RootRefElementModel::new));
	}

	public Optional<RootRefElementModel> findRootRefElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, RootRefElementModel.stTemplateUuid, RootRefElementModel::new));
	}

	public Optional<RootRefElementModel> findRootRefElementModelByRootRef(STValue value) {
		return Optional.ofNullable(db.find("rootRef", value, RootRefElementModel.stTemplateUuid, RootRefElementModel::new));
	}

	public Optional<RootRefElementModel> findRootRefElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, RootRefElementModel.stTemplateUuid, RootRefElementModel::new));
	}

	public Optional<ScopedCssBaselineElementModel> findScopedCssBaselineElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ScopedCssBaselineElementModel.stTemplateUuid, ScopedCssBaselineElementModel::new));
	}

	public Optional<ScopedCssBaselineElementModel> findScopedCssBaselineElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ScopedCssBaselineElementModel.stTemplateUuid, ScopedCssBaselineElementModel::new));
	}

	public Optional<ScopedCssBaselineElementModel> findScopedCssBaselineElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ScopedCssBaselineElementModel.stTemplateUuid, ScopedCssBaselineElementModel::new));
	}

	public Optional<ScopedCssBaselineElementModel> findScopedCssBaselineElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ScopedCssBaselineElementModel.stTemplateUuid, ScopedCssBaselineElementModel::new));
	}

	public Optional<ScopedCssBaselineElementModel> findScopedCssBaselineElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ScopedCssBaselineElementModel.stTemplateUuid, ScopedCssBaselineElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByAutoWidth(STValue value) {
		return Optional.ofNullable(db.find("autoWidth", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByDefaultValue(STValue value) {
		return Optional.ofNullable(db.find("defaultValue", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByDisplayEmpty(STValue value) {
		return Optional.ofNullable(db.find("displayEmpty", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByIconComponent(STValue value) {
		return Optional.ofNullable(db.find("IconComponent", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByInput(STValue value) {
		return Optional.ofNullable(db.find("input", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByInputProps(STValue value) {
		return Optional.ofNullable(db.find("inputProps", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByLabel(STValue value) {
		return Optional.ofNullable(db.find("label", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByLabelId(STValue value) {
		return Optional.ofNullable(db.find("labelId", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByLabelWidth(STValue value) {
		return Optional.ofNullable(db.find("labelWidth", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByMenuProps(STValue value) {
		return Optional.ofNullable(db.find("MenuProps", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByMultiple(STValue value) {
		return Optional.ofNullable(db.find("multiple", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByNative(STValue value) {
		return Optional.ofNullable(db.find("native", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByOnClose(STValue value) {
		return Optional.ofNullable(db.find("onClose", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByOnOpen(STValue value) {
		return Optional.ofNullable(db.find("onOpen", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByOpen(STValue value) {
		return Optional.ofNullable(db.find("open", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByRenderValue(STValue value) {
		return Optional.ofNullable(db.find("renderValue", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelBySelectDisplayProps(STValue value) {
		return Optional.ofNullable(db.find("SelectDisplayProps", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SelectElementModel> findSelectElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, SelectElementModel.stTemplateUuid, SelectElementModel::new));
	}

	public Optional<SkeletonElementModel> findSkeletonElementModelByAnimation(STValue value) {
		return Optional.ofNullable(db.find("animation", value, SkeletonElementModel.stTemplateUuid, SkeletonElementModel::new));
	}

	public Optional<SkeletonElementModel> findSkeletonElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, SkeletonElementModel.stTemplateUuid, SkeletonElementModel::new));
	}

	public Optional<SkeletonElementModel> findSkeletonElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, SkeletonElementModel.stTemplateUuid, SkeletonElementModel::new));
	}

	public Optional<SkeletonElementModel> findSkeletonElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, SkeletonElementModel.stTemplateUuid, SkeletonElementModel::new));
	}

	public Optional<SkeletonElementModel> findSkeletonElementModelByHeight(STValue value) {
		return Optional.ofNullable(db.find("height", value, SkeletonElementModel.stTemplateUuid, SkeletonElementModel::new));
	}

	public Optional<SkeletonElementModel> findSkeletonElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, SkeletonElementModel.stTemplateUuid, SkeletonElementModel::new));
	}

	public Optional<SkeletonElementModel> findSkeletonElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, SkeletonElementModel.stTemplateUuid, SkeletonElementModel::new));
	}

	public Optional<SkeletonElementModel> findSkeletonElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, SkeletonElementModel.stTemplateUuid, SkeletonElementModel::new));
	}

	public Optional<SkeletonElementModel> findSkeletonElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, SkeletonElementModel.stTemplateUuid, SkeletonElementModel::new));
	}

	public Optional<SkeletonElementModel> findSkeletonElementModelByWidth(STValue value) {
		return Optional.ofNullable(db.find("width", value, SkeletonElementModel.stTemplateUuid, SkeletonElementModel::new));
	}

	public Optional<SlideElementModel> findSlideElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, SlideElementModel.stTemplateUuid, SlideElementModel::new));
	}

	public Optional<SlideElementModel> findSlideElementModelByDirection(STValue value) {
		return Optional.ofNullable(db.find("direction", value, SlideElementModel.stTemplateUuid, SlideElementModel::new));
	}

	public Optional<SlideElementModel> findSlideElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, SlideElementModel.stTemplateUuid, SlideElementModel::new));
	}

	public Optional<SlideElementModel> findSlideElementModelByIn(STValue value) {
		return Optional.ofNullable(db.find("in", value, SlideElementModel.stTemplateUuid, SlideElementModel::new));
	}

	public Optional<SlideElementModel> findSlideElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, SlideElementModel.stTemplateUuid, SlideElementModel::new));
	}

	public Optional<SlideElementModel> findSlideElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, SlideElementModel.stTemplateUuid, SlideElementModel::new));
	}

	public Optional<SlideElementModel> findSlideElementModelByTimeout(STValue value) {
		return Optional.ofNullable(db.find("timeout", value, SlideElementModel.stTemplateUuid, SlideElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByAriaLabel(STValue value) {
		return Optional.ofNullable(db.find("ariaLabel", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByAriaLabelledby(STValue value) {
		return Optional.ofNullable(db.find("ariaLabelledby", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByAriaValuetext(STValue value) {
		return Optional.ofNullable(db.find("ariaValuetext", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByDefaultValue(STValue value) {
		return Optional.ofNullable(db.find("defaultValue", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByGetAriaLabel(STValue value) {
		return Optional.ofNullable(db.find("getAriaLabel", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByGetAriaValueText(STValue value) {
		return Optional.ofNullable(db.find("getAriaValueText", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByMarks(STValue value) {
		return Optional.ofNullable(db.find("marks", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByMax(STValue value) {
		return Optional.ofNullable(db.find("max", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByMin(STValue value) {
		return Optional.ofNullable(db.find("min", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByOnChangeCommitted(STValue value) {
		return Optional.ofNullable(db.find("onChangeCommitted", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByOrientation(STValue value) {
		return Optional.ofNullable(db.find("orientation", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByScale(STValue value) {
		return Optional.ofNullable(db.find("scale", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByStep(STValue value) {
		return Optional.ofNullable(db.find("step", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByThumbComponent(STValue value) {
		return Optional.ofNullable(db.find("ThumbComponent", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByTrack(STValue value) {
		return Optional.ofNullable(db.find("track", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByValueLabelComponent(STValue value) {
		return Optional.ofNullable(db.find("ValueLabelComponent", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByValueLabelDisplay(STValue value) {
		return Optional.ofNullable(db.find("valueLabelDisplay", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SliderElementModel> findSliderElementModelByValueLabelFormat(STValue value) {
		return Optional.ofNullable(db.find("valueLabelFormat", value, SliderElementModel.stTemplateUuid, SliderElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByAction(STValue value) {
		return Optional.ofNullable(db.find("action", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByAnchorOrigin(STValue value) {
		return Optional.ofNullable(db.find("anchorOrigin", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByAutoHideDuration(STValue value) {
		return Optional.ofNullable(db.find("autoHideDuration", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByClickAwayListenerProps(STValue value) {
		return Optional.ofNullable(db.find("ClickAwayListenerProps", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByContentProps(STValue value) {
		return Optional.ofNullable(db.find("ContentProps", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByDisableWindowBlurListener(STValue value) {
		return Optional.ofNullable(db.find("disableWindowBlurListener", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByMessage(STValue value) {
		return Optional.ofNullable(db.find("message", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByOnClose(STValue value) {
		return Optional.ofNullable(db.find("onClose", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByOnEnter(STValue value) {
		return Optional.ofNullable(db.find("onEnter", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByOnEntered(STValue value) {
		return Optional.ofNullable(db.find("onEntered", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByOnEntering(STValue value) {
		return Optional.ofNullable(db.find("onEntering", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByOnExit(STValue value) {
		return Optional.ofNullable(db.find("onExit", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByOnExited(STValue value) {
		return Optional.ofNullable(db.find("onExited", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByOnExiting(STValue value) {
		return Optional.ofNullable(db.find("onExiting", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByOpen(STValue value) {
		return Optional.ofNullable(db.find("open", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByResumeHideDuration(STValue value) {
		return Optional.ofNullable(db.find("resumeHideDuration", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByTransitionComponent(STValue value) {
		return Optional.ofNullable(db.find("TransitionComponent", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByTransitionDuration(STValue value) {
		return Optional.ofNullable(db.find("transitionDuration", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarElementModel> findSnackbarElementModelByTransitionProps(STValue value) {
		return Optional.ofNullable(db.find("TransitionProps", value, SnackbarElementModel.stTemplateUuid, SnackbarElementModel::new));
	}

	public Optional<SnackbarContentElementModel> findSnackbarContentElementModelByAction(STValue value) {
		return Optional.ofNullable(db.find("action", value, SnackbarContentElementModel.stTemplateUuid, SnackbarContentElementModel::new));
	}

	public Optional<SnackbarContentElementModel> findSnackbarContentElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, SnackbarContentElementModel.stTemplateUuid, SnackbarContentElementModel::new));
	}

	public Optional<SnackbarContentElementModel> findSnackbarContentElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, SnackbarContentElementModel.stTemplateUuid, SnackbarContentElementModel::new));
	}

	public Optional<SnackbarContentElementModel> findSnackbarContentElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, SnackbarContentElementModel.stTemplateUuid, SnackbarContentElementModel::new));
	}

	public Optional<SnackbarContentElementModel> findSnackbarContentElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, SnackbarContentElementModel.stTemplateUuid, SnackbarContentElementModel::new));
	}

	public Optional<SnackbarContentElementModel> findSnackbarContentElementModelByMessage(STValue value) {
		return Optional.ofNullable(db.find("message", value, SnackbarContentElementModel.stTemplateUuid, SnackbarContentElementModel::new));
	}

	public Optional<SnackbarContentElementModel> findSnackbarContentElementModelByRole(STValue value) {
		return Optional.ofNullable(db.find("role", value, SnackbarContentElementModel.stTemplateUuid, SnackbarContentElementModel::new));
	}

	public Optional<SnackbarContentElementModel> findSnackbarContentElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, SnackbarContentElementModel.stTemplateUuid, SnackbarContentElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByAriaLabel(STValue value) {
		return Optional.ofNullable(db.find("ariaLabel", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByDirection(STValue value) {
		return Optional.ofNullable(db.find("direction", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByFabProps(STValue value) {
		return Optional.ofNullable(db.find("FabProps", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByHidden(STValue value) {
		return Optional.ofNullable(db.find("hidden", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByOnClose(STValue value) {
		return Optional.ofNullable(db.find("onClose", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByOnOpen(STValue value) {
		return Optional.ofNullable(db.find("onOpen", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByOpenIcon(STValue value) {
		return Optional.ofNullable(db.find("openIcon", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByTransitionComponent(STValue value) {
		return Optional.ofNullable(db.find("TransitionComponent", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByTransitionDuration(STValue value) {
		return Optional.ofNullable(db.find("transitionDuration", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialElementModel> findSpeedDialElementModelByTransitionProps(STValue value) {
		return Optional.ofNullable(db.find("TransitionProps", value, SpeedDialElementModel.stTemplateUuid, SpeedDialElementModel::new));
	}

	public Optional<SpeedDialActionElementModel> findSpeedDialActionElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, SpeedDialActionElementModel.stTemplateUuid, SpeedDialActionElementModel::new));
	}

	public Optional<SpeedDialActionElementModel> findSpeedDialActionElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, SpeedDialActionElementModel.stTemplateUuid, SpeedDialActionElementModel::new));
	}

	public Optional<SpeedDialActionElementModel> findSpeedDialActionElementModelByDelay(STValue value) {
		return Optional.ofNullable(db.find("delay", value, SpeedDialActionElementModel.stTemplateUuid, SpeedDialActionElementModel::new));
	}

	public Optional<SpeedDialActionElementModel> findSpeedDialActionElementModelByFabProps(STValue value) {
		return Optional.ofNullable(db.find("FabProps", value, SpeedDialActionElementModel.stTemplateUuid, SpeedDialActionElementModel::new));
	}

	public Optional<SpeedDialActionElementModel> findSpeedDialActionElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, SpeedDialActionElementModel.stTemplateUuid, SpeedDialActionElementModel::new));
	}

	public Optional<SpeedDialActionElementModel> findSpeedDialActionElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, SpeedDialActionElementModel.stTemplateUuid, SpeedDialActionElementModel::new));
	}

	public Optional<SpeedDialActionElementModel> findSpeedDialActionElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, SpeedDialActionElementModel.stTemplateUuid, SpeedDialActionElementModel::new));
	}

	public Optional<SpeedDialActionElementModel> findSpeedDialActionElementModelByOpen(STValue value) {
		return Optional.ofNullable(db.find("open", value, SpeedDialActionElementModel.stTemplateUuid, SpeedDialActionElementModel::new));
	}

	public Optional<SpeedDialActionElementModel> findSpeedDialActionElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, SpeedDialActionElementModel.stTemplateUuid, SpeedDialActionElementModel::new));
	}

	public Optional<SpeedDialActionElementModel> findSpeedDialActionElementModelByTooltipClasses(STValue value) {
		return Optional.ofNullable(db.find("TooltipClasses", value, SpeedDialActionElementModel.stTemplateUuid, SpeedDialActionElementModel::new));
	}

	public Optional<SpeedDialActionElementModel> findSpeedDialActionElementModelByTooltipOpen(STValue value) {
		return Optional.ofNullable(db.find("tooltipOpen", value, SpeedDialActionElementModel.stTemplateUuid, SpeedDialActionElementModel::new));
	}

	public Optional<SpeedDialActionElementModel> findSpeedDialActionElementModelByTooltipPlacement(STValue value) {
		return Optional.ofNullable(db.find("tooltipPlacement", value, SpeedDialActionElementModel.stTemplateUuid, SpeedDialActionElementModel::new));
	}

	public Optional<SpeedDialActionElementModel> findSpeedDialActionElementModelByTooltipTitle(STValue value) {
		return Optional.ofNullable(db.find("tooltipTitle", value, SpeedDialActionElementModel.stTemplateUuid, SpeedDialActionElementModel::new));
	}

	public Optional<SpeedDialIconElementModel> findSpeedDialIconElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, SpeedDialIconElementModel.stTemplateUuid, SpeedDialIconElementModel::new));
	}

	public Optional<SpeedDialIconElementModel> findSpeedDialIconElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, SpeedDialIconElementModel.stTemplateUuid, SpeedDialIconElementModel::new));
	}

	public Optional<SpeedDialIconElementModel> findSpeedDialIconElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, SpeedDialIconElementModel.stTemplateUuid, SpeedDialIconElementModel::new));
	}

	public Optional<SpeedDialIconElementModel> findSpeedDialIconElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, SpeedDialIconElementModel.stTemplateUuid, SpeedDialIconElementModel::new));
	}

	public Optional<SpeedDialIconElementModel> findSpeedDialIconElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, SpeedDialIconElementModel.stTemplateUuid, SpeedDialIconElementModel::new));
	}

	public Optional<SpeedDialIconElementModel> findSpeedDialIconElementModelByOpenIcon(STValue value) {
		return Optional.ofNullable(db.find("openIcon", value, SpeedDialIconElementModel.stTemplateUuid, SpeedDialIconElementModel::new));
	}

	public Optional<SpeedDialIconElementModel> findSpeedDialIconElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, SpeedDialIconElementModel.stTemplateUuid, SpeedDialIconElementModel::new));
	}

	public Optional<StepElementModel> findStepElementModelByActive(STValue value) {
		return Optional.ofNullable(db.find("active", value, StepElementModel.stTemplateUuid, StepElementModel::new));
	}

	public Optional<StepElementModel> findStepElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, StepElementModel.stTemplateUuid, StepElementModel::new));
	}

	public Optional<StepElementModel> findStepElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, StepElementModel.stTemplateUuid, StepElementModel::new));
	}

	public Optional<StepElementModel> findStepElementModelByCompleted(STValue value) {
		return Optional.ofNullable(db.find("completed", value, StepElementModel.stTemplateUuid, StepElementModel::new));
	}

	public Optional<StepElementModel> findStepElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, StepElementModel.stTemplateUuid, StepElementModel::new));
	}

	public Optional<StepElementModel> findStepElementModelByExpanded(STValue value) {
		return Optional.ofNullable(db.find("expanded", value, StepElementModel.stTemplateUuid, StepElementModel::new));
	}

	public Optional<StepElementModel> findStepElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, StepElementModel.stTemplateUuid, StepElementModel::new));
	}

	public Optional<StepElementModel> findStepElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, StepElementModel.stTemplateUuid, StepElementModel::new));
	}

	public Optional<StepElementModel> findStepElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, StepElementModel.stTemplateUuid, StepElementModel::new));
	}

	public Optional<StepButtonElementModel> findStepButtonElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, StepButtonElementModel.stTemplateUuid, StepButtonElementModel::new));
	}

	public Optional<StepButtonElementModel> findStepButtonElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, StepButtonElementModel.stTemplateUuid, StepButtonElementModel::new));
	}

	public Optional<StepButtonElementModel> findStepButtonElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, StepButtonElementModel.stTemplateUuid, StepButtonElementModel::new));
	}

	public Optional<StepButtonElementModel> findStepButtonElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, StepButtonElementModel.stTemplateUuid, StepButtonElementModel::new));
	}

	public Optional<StepButtonElementModel> findStepButtonElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, StepButtonElementModel.stTemplateUuid, StepButtonElementModel::new));
	}

	public Optional<StepButtonElementModel> findStepButtonElementModelByOptional(STValue value) {
		return Optional.ofNullable(db.find("optional", value, StepButtonElementModel.stTemplateUuid, StepButtonElementModel::new));
	}

	public Optional<StepButtonElementModel> findStepButtonElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, StepButtonElementModel.stTemplateUuid, StepButtonElementModel::new));
	}

	public Optional<StepConnectorElementModel> findStepConnectorElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, StepConnectorElementModel.stTemplateUuid, StepConnectorElementModel::new));
	}

	public Optional<StepConnectorElementModel> findStepConnectorElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, StepConnectorElementModel.stTemplateUuid, StepConnectorElementModel::new));
	}

	public Optional<StepConnectorElementModel> findStepConnectorElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, StepConnectorElementModel.stTemplateUuid, StepConnectorElementModel::new));
	}

	public Optional<StepConnectorElementModel> findStepConnectorElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, StepConnectorElementModel.stTemplateUuid, StepConnectorElementModel::new));
	}

	public Optional<StepConnectorElementModel> findStepConnectorElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, StepConnectorElementModel.stTemplateUuid, StepConnectorElementModel::new));
	}

	public Optional<StepContentElementModel> findStepContentElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, StepContentElementModel.stTemplateUuid, StepContentElementModel::new));
	}

	public Optional<StepContentElementModel> findStepContentElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, StepContentElementModel.stTemplateUuid, StepContentElementModel::new));
	}

	public Optional<StepContentElementModel> findStepContentElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, StepContentElementModel.stTemplateUuid, StepContentElementModel::new));
	}

	public Optional<StepContentElementModel> findStepContentElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, StepContentElementModel.stTemplateUuid, StepContentElementModel::new));
	}

	public Optional<StepContentElementModel> findStepContentElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, StepContentElementModel.stTemplateUuid, StepContentElementModel::new));
	}

	public Optional<StepContentElementModel> findStepContentElementModelByTransitionComponent(STValue value) {
		return Optional.ofNullable(db.find("TransitionComponent", value, StepContentElementModel.stTemplateUuid, StepContentElementModel::new));
	}

	public Optional<StepContentElementModel> findStepContentElementModelByTransitionDuration(STValue value) {
		return Optional.ofNullable(db.find("transitionDuration", value, StepContentElementModel.stTemplateUuid, StepContentElementModel::new));
	}

	public Optional<StepContentElementModel> findStepContentElementModelByTransitionProps(STValue value) {
		return Optional.ofNullable(db.find("TransitionProps", value, StepContentElementModel.stTemplateUuid, StepContentElementModel::new));
	}

	public Optional<StepIconElementModel> findStepIconElementModelByActive(STValue value) {
		return Optional.ofNullable(db.find("active", value, StepIconElementModel.stTemplateUuid, StepIconElementModel::new));
	}

	public Optional<StepIconElementModel> findStepIconElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, StepIconElementModel.stTemplateUuid, StepIconElementModel::new));
	}

	public Optional<StepIconElementModel> findStepIconElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, StepIconElementModel.stTemplateUuid, StepIconElementModel::new));
	}

	public Optional<StepIconElementModel> findStepIconElementModelByCompleted(STValue value) {
		return Optional.ofNullable(db.find("completed", value, StepIconElementModel.stTemplateUuid, StepIconElementModel::new));
	}

	public Optional<StepIconElementModel> findStepIconElementModelByError(STValue value) {
		return Optional.ofNullable(db.find("error", value, StepIconElementModel.stTemplateUuid, StepIconElementModel::new));
	}

	public Optional<StepIconElementModel> findStepIconElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, StepIconElementModel.stTemplateUuid, StepIconElementModel::new));
	}

	public Optional<StepIconElementModel> findStepIconElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, StepIconElementModel.stTemplateUuid, StepIconElementModel::new));
	}

	public Optional<StepIconElementModel> findStepIconElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, StepIconElementModel.stTemplateUuid, StepIconElementModel::new));
	}

	public Optional<StepIconElementModel> findStepIconElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, StepIconElementModel.stTemplateUuid, StepIconElementModel::new));
	}

	public Optional<StepLabelElementModel> findStepLabelElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, StepLabelElementModel.stTemplateUuid, StepLabelElementModel::new));
	}

	public Optional<StepLabelElementModel> findStepLabelElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, StepLabelElementModel.stTemplateUuid, StepLabelElementModel::new));
	}

	public Optional<StepLabelElementModel> findStepLabelElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, StepLabelElementModel.stTemplateUuid, StepLabelElementModel::new));
	}

	public Optional<StepLabelElementModel> findStepLabelElementModelByError(STValue value) {
		return Optional.ofNullable(db.find("error", value, StepLabelElementModel.stTemplateUuid, StepLabelElementModel::new));
	}

	public Optional<StepLabelElementModel> findStepLabelElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, StepLabelElementModel.stTemplateUuid, StepLabelElementModel::new));
	}

	public Optional<StepLabelElementModel> findStepLabelElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, StepLabelElementModel.stTemplateUuid, StepLabelElementModel::new));
	}

	public Optional<StepLabelElementModel> findStepLabelElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, StepLabelElementModel.stTemplateUuid, StepLabelElementModel::new));
	}

	public Optional<StepLabelElementModel> findStepLabelElementModelByOptional(STValue value) {
		return Optional.ofNullable(db.find("optional", value, StepLabelElementModel.stTemplateUuid, StepLabelElementModel::new));
	}

	public Optional<StepLabelElementModel> findStepLabelElementModelByStepIconComponent(STValue value) {
		return Optional.ofNullable(db.find("StepIconComponent", value, StepLabelElementModel.stTemplateUuid, StepLabelElementModel::new));
	}

	public Optional<StepLabelElementModel> findStepLabelElementModelByStepIconProps(STValue value) {
		return Optional.ofNullable(db.find("StepIconProps", value, StepLabelElementModel.stTemplateUuid, StepLabelElementModel::new));
	}

	public Optional<StepLabelElementModel> findStepLabelElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, StepLabelElementModel.stTemplateUuid, StepLabelElementModel::new));
	}

	public Optional<StepperElementModel> findStepperElementModelByActiveStep(STValue value) {
		return Optional.ofNullable(db.find("activeStep", value, StepperElementModel.stTemplateUuid, StepperElementModel::new));
	}

	public Optional<StepperElementModel> findStepperElementModelByAlternativeLabel(STValue value) {
		return Optional.ofNullable(db.find("alternativeLabel", value, StepperElementModel.stTemplateUuid, StepperElementModel::new));
	}

	public Optional<StepperElementModel> findStepperElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, StepperElementModel.stTemplateUuid, StepperElementModel::new));
	}

	public Optional<StepperElementModel> findStepperElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, StepperElementModel.stTemplateUuid, StepperElementModel::new));
	}

	public Optional<StepperElementModel> findStepperElementModelByConnector(STValue value) {
		return Optional.ofNullable(db.find("connector", value, StepperElementModel.stTemplateUuid, StepperElementModel::new));
	}

	public Optional<StepperElementModel> findStepperElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, StepperElementModel.stTemplateUuid, StepperElementModel::new));
	}

	public Optional<StepperElementModel> findStepperElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, StepperElementModel.stTemplateUuid, StepperElementModel::new));
	}

	public Optional<StepperElementModel> findStepperElementModelByNonLinear(STValue value) {
		return Optional.ofNullable(db.find("nonLinear", value, StepperElementModel.stTemplateUuid, StepperElementModel::new));
	}

	public Optional<StepperElementModel> findStepperElementModelByOrientation(STValue value) {
		return Optional.ofNullable(db.find("orientation", value, StepperElementModel.stTemplateUuid, StepperElementModel::new));
	}

	public Optional<StepperElementModel> findStepperElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, StepperElementModel.stTemplateUuid, StepperElementModel::new));
	}

	public Optional<SvgIconElementModel> findSvgIconElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, SvgIconElementModel.stTemplateUuid, SvgIconElementModel::new));
	}

	public Optional<SvgIconElementModel> findSvgIconElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, SvgIconElementModel.stTemplateUuid, SvgIconElementModel::new));
	}

	public Optional<SvgIconElementModel> findSvgIconElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, SvgIconElementModel.stTemplateUuid, SvgIconElementModel::new));
	}

	public Optional<SvgIconElementModel> findSvgIconElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, SvgIconElementModel.stTemplateUuid, SvgIconElementModel::new));
	}

	public Optional<SvgIconElementModel> findSvgIconElementModelByFontSize(STValue value) {
		return Optional.ofNullable(db.find("fontSize", value, SvgIconElementModel.stTemplateUuid, SvgIconElementModel::new));
	}

	public Optional<SvgIconElementModel> findSvgIconElementModelByHtmlColor(STValue value) {
		return Optional.ofNullable(db.find("htmlColor", value, SvgIconElementModel.stTemplateUuid, SvgIconElementModel::new));
	}

	public Optional<SvgIconElementModel> findSvgIconElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, SvgIconElementModel.stTemplateUuid, SvgIconElementModel::new));
	}

	public Optional<SvgIconElementModel> findSvgIconElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, SvgIconElementModel.stTemplateUuid, SvgIconElementModel::new));
	}

	public Optional<SvgIconElementModel> findSvgIconElementModelByShapeRendering(STValue value) {
		return Optional.ofNullable(db.find("shapeRendering", value, SvgIconElementModel.stTemplateUuid, SvgIconElementModel::new));
	}

	public Optional<SvgIconElementModel> findSvgIconElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, SvgIconElementModel.stTemplateUuid, SvgIconElementModel::new));
	}

	public Optional<SvgIconElementModel> findSvgIconElementModelByTitleAccess(STValue value) {
		return Optional.ofNullable(db.find("titleAccess", value, SvgIconElementModel.stTemplateUuid, SvgIconElementModel::new));
	}

	public Optional<SvgIconElementModel> findSvgIconElementModelByViewBox(STValue value) {
		return Optional.ofNullable(db.find("viewBox", value, SvgIconElementModel.stTemplateUuid, SvgIconElementModel::new));
	}

	public Optional<SwipeableDrawerElementModel> findSwipeableDrawerElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, SwipeableDrawerElementModel.stTemplateUuid, SwipeableDrawerElementModel::new));
	}

	public Optional<SwipeableDrawerElementModel> findSwipeableDrawerElementModelByDisableBackdropTransition(STValue value) {
		return Optional.ofNullable(db.find("disableBackdropTransition", value, SwipeableDrawerElementModel.stTemplateUuid, SwipeableDrawerElementModel::new));
	}

	public Optional<SwipeableDrawerElementModel> findSwipeableDrawerElementModelByDisableDiscovery(STValue value) {
		return Optional.ofNullable(db.find("disableDiscovery", value, SwipeableDrawerElementModel.stTemplateUuid, SwipeableDrawerElementModel::new));
	}

	public Optional<SwipeableDrawerElementModel> findSwipeableDrawerElementModelByDisableSwipeToOpen(STValue value) {
		return Optional.ofNullable(db.find("disableSwipeToOpen", value, SwipeableDrawerElementModel.stTemplateUuid, SwipeableDrawerElementModel::new));
	}

	public Optional<SwipeableDrawerElementModel> findSwipeableDrawerElementModelByHysteresis(STValue value) {
		return Optional.ofNullable(db.find("hysteresis", value, SwipeableDrawerElementModel.stTemplateUuid, SwipeableDrawerElementModel::new));
	}

	public Optional<SwipeableDrawerElementModel> findSwipeableDrawerElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, SwipeableDrawerElementModel.stTemplateUuid, SwipeableDrawerElementModel::new));
	}

	public Optional<SwipeableDrawerElementModel> findSwipeableDrawerElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, SwipeableDrawerElementModel.stTemplateUuid, SwipeableDrawerElementModel::new));
	}

	public Optional<SwipeableDrawerElementModel> findSwipeableDrawerElementModelByMinFlingVelocity(STValue value) {
		return Optional.ofNullable(db.find("minFlingVelocity", value, SwipeableDrawerElementModel.stTemplateUuid, SwipeableDrawerElementModel::new));
	}

	public Optional<SwipeableDrawerElementModel> findSwipeableDrawerElementModelByOnClose(STValue value) {
		return Optional.ofNullable(db.find("onClose", value, SwipeableDrawerElementModel.stTemplateUuid, SwipeableDrawerElementModel::new));
	}

	public Optional<SwipeableDrawerElementModel> findSwipeableDrawerElementModelByOnOpen(STValue value) {
		return Optional.ofNullable(db.find("onOpen", value, SwipeableDrawerElementModel.stTemplateUuid, SwipeableDrawerElementModel::new));
	}

	public Optional<SwipeableDrawerElementModel> findSwipeableDrawerElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, SwipeableDrawerElementModel.stTemplateUuid, SwipeableDrawerElementModel::new));
	}

	public Optional<SwipeableDrawerElementModel> findSwipeableDrawerElementModelBySwipeAreaProps(STValue value) {
		return Optional.ofNullable(db.find("SwipeAreaProps", value, SwipeableDrawerElementModel.stTemplateUuid, SwipeableDrawerElementModel::new));
	}

	public Optional<SwipeableDrawerElementModel> findSwipeableDrawerElementModelBySwipeAreaWidth(STValue value) {
		return Optional.ofNullable(db.find("swipeAreaWidth", value, SwipeableDrawerElementModel.stTemplateUuid, SwipeableDrawerElementModel::new));
	}

	public Optional<SwipeableDrawerElementModel> findSwipeableDrawerElementModelByTransitionDuration(STValue value) {
		return Optional.ofNullable(db.find("transitionDuration", value, SwipeableDrawerElementModel.stTemplateUuid, SwipeableDrawerElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByChecked(STValue value) {
		return Optional.ofNullable(db.find("checked", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByCheckedIcon(STValue value) {
		return Optional.ofNullable(db.find("checkedIcon", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByDisableRipple(STValue value) {
		return Optional.ofNullable(db.find("disableRipple", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByEdge(STValue value) {
		return Optional.ofNullable(db.find("edge", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByInputProps(STValue value) {
		return Optional.ofNullable(db.find("inputProps", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByInputRef(STValue value) {
		return Optional.ofNullable(db.find("inputRef", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByRequired(STValue value) {
		return Optional.ofNullable(db.find("required", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<SwitchElementModel> findSwitchElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, SwitchElementModel.stTemplateUuid, SwitchElementModel::new));
	}

	public Optional<TabElementModel> findTabElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TabElementModel.stTemplateUuid, TabElementModel::new));
	}

	public Optional<TabElementModel> findTabElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TabElementModel.stTemplateUuid, TabElementModel::new));
	}

	public Optional<TabElementModel> findTabElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, TabElementModel.stTemplateUuid, TabElementModel::new));
	}

	public Optional<TabElementModel> findTabElementModelByDisableFocusRipple(STValue value) {
		return Optional.ofNullable(db.find("disableFocusRipple", value, TabElementModel.stTemplateUuid, TabElementModel::new));
	}

	public Optional<TabElementModel> findTabElementModelByDisableRipple(STValue value) {
		return Optional.ofNullable(db.find("disableRipple", value, TabElementModel.stTemplateUuid, TabElementModel::new));
	}

	public Optional<TabElementModel> findTabElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, TabElementModel.stTemplateUuid, TabElementModel::new));
	}

	public Optional<TabElementModel> findTabElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TabElementModel.stTemplateUuid, TabElementModel::new));
	}

	public Optional<TabElementModel> findTabElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TabElementModel.stTemplateUuid, TabElementModel::new));
	}

	public Optional<TabElementModel> findTabElementModelByLabel(STValue value) {
		return Optional.ofNullable(db.find("label", value, TabElementModel.stTemplateUuid, TabElementModel::new));
	}

	public Optional<TabElementModel> findTabElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TabElementModel.stTemplateUuid, TabElementModel::new));
	}

	public Optional<TabElementModel> findTabElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, TabElementModel.stTemplateUuid, TabElementModel::new));
	}

	public Optional<TabElementModel> findTabElementModelByWrapped(STValue value) {
		return Optional.ofNullable(db.find("wrapped", value, TabElementModel.stTemplateUuid, TabElementModel::new));
	}

	public Optional<TabContextElementModel> findTabContextElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TabContextElementModel.stTemplateUuid, TabContextElementModel::new));
	}

	public Optional<TabContextElementModel> findTabContextElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TabContextElementModel.stTemplateUuid, TabContextElementModel::new));
	}

	public Optional<TabContextElementModel> findTabContextElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TabContextElementModel.stTemplateUuid, TabContextElementModel::new));
	}

	public Optional<TabContextElementModel> findTabContextElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TabContextElementModel.stTemplateUuid, TabContextElementModel::new));
	}

	public Optional<TabContextElementModel> findTabContextElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, TabContextElementModel.stTemplateUuid, TabContextElementModel::new));
	}

	public Optional<TableElementModel> findTableElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TableElementModel.stTemplateUuid, TableElementModel::new));
	}

	public Optional<TableElementModel> findTableElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TableElementModel.stTemplateUuid, TableElementModel::new));
	}

	public Optional<TableElementModel> findTableElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, TableElementModel.stTemplateUuid, TableElementModel::new));
	}

	public Optional<TableElementModel> findTableElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TableElementModel.stTemplateUuid, TableElementModel::new));
	}

	public Optional<TableElementModel> findTableElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TableElementModel.stTemplateUuid, TableElementModel::new));
	}

	public Optional<TableElementModel> findTableElementModelByPadding(STValue value) {
		return Optional.ofNullable(db.find("padding", value, TableElementModel.stTemplateUuid, TableElementModel::new));
	}

	public Optional<TableElementModel> findTableElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, TableElementModel.stTemplateUuid, TableElementModel::new));
	}

	public Optional<TableElementModel> findTableElementModelByStickyHeader(STValue value) {
		return Optional.ofNullable(db.find("stickyHeader", value, TableElementModel.stTemplateUuid, TableElementModel::new));
	}

	public Optional<TableElementModel> findTableElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TableElementModel.stTemplateUuid, TableElementModel::new));
	}

	public Optional<TableBodyElementModel> findTableBodyElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TableBodyElementModel.stTemplateUuid, TableBodyElementModel::new));
	}

	public Optional<TableBodyElementModel> findTableBodyElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TableBodyElementModel.stTemplateUuid, TableBodyElementModel::new));
	}

	public Optional<TableBodyElementModel> findTableBodyElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, TableBodyElementModel.stTemplateUuid, TableBodyElementModel::new));
	}

	public Optional<TableBodyElementModel> findTableBodyElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TableBodyElementModel.stTemplateUuid, TableBodyElementModel::new));
	}

	public Optional<TableBodyElementModel> findTableBodyElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TableBodyElementModel.stTemplateUuid, TableBodyElementModel::new));
	}

	public Optional<TableBodyElementModel> findTableBodyElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TableBodyElementModel.stTemplateUuid, TableBodyElementModel::new));
	}

	public Optional<TableCellElementModel> findTableCellElementModelByAlign(STValue value) {
		return Optional.ofNullable(db.find("align", value, TableCellElementModel.stTemplateUuid, TableCellElementModel::new));
	}

	public Optional<TableCellElementModel> findTableCellElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TableCellElementModel.stTemplateUuid, TableCellElementModel::new));
	}

	public Optional<TableCellElementModel> findTableCellElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TableCellElementModel.stTemplateUuid, TableCellElementModel::new));
	}

	public Optional<TableCellElementModel> findTableCellElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, TableCellElementModel.stTemplateUuid, TableCellElementModel::new));
	}

	public Optional<TableCellElementModel> findTableCellElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TableCellElementModel.stTemplateUuid, TableCellElementModel::new));
	}

	public Optional<TableCellElementModel> findTableCellElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TableCellElementModel.stTemplateUuid, TableCellElementModel::new));
	}

	public Optional<TableCellElementModel> findTableCellElementModelByPadding(STValue value) {
		return Optional.ofNullable(db.find("padding", value, TableCellElementModel.stTemplateUuid, TableCellElementModel::new));
	}

	public Optional<TableCellElementModel> findTableCellElementModelByScope(STValue value) {
		return Optional.ofNullable(db.find("scope", value, TableCellElementModel.stTemplateUuid, TableCellElementModel::new));
	}

	public Optional<TableCellElementModel> findTableCellElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, TableCellElementModel.stTemplateUuid, TableCellElementModel::new));
	}

	public Optional<TableCellElementModel> findTableCellElementModelBySortDirection(STValue value) {
		return Optional.ofNullable(db.find("sortDirection", value, TableCellElementModel.stTemplateUuid, TableCellElementModel::new));
	}

	public Optional<TableCellElementModel> findTableCellElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TableCellElementModel.stTemplateUuid, TableCellElementModel::new));
	}

	public Optional<TableCellElementModel> findTableCellElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, TableCellElementModel.stTemplateUuid, TableCellElementModel::new));
	}

	public Optional<TableContainerElementModel> findTableContainerElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TableContainerElementModel.stTemplateUuid, TableContainerElementModel::new));
	}

	public Optional<TableContainerElementModel> findTableContainerElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TableContainerElementModel.stTemplateUuid, TableContainerElementModel::new));
	}

	public Optional<TableContainerElementModel> findTableContainerElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, TableContainerElementModel.stTemplateUuid, TableContainerElementModel::new));
	}

	public Optional<TableContainerElementModel> findTableContainerElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TableContainerElementModel.stTemplateUuid, TableContainerElementModel::new));
	}

	public Optional<TableContainerElementModel> findTableContainerElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TableContainerElementModel.stTemplateUuid, TableContainerElementModel::new));
	}

	public Optional<TableContainerElementModel> findTableContainerElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TableContainerElementModel.stTemplateUuid, TableContainerElementModel::new));
	}

	public Optional<TableFooterElementModel> findTableFooterElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TableFooterElementModel.stTemplateUuid, TableFooterElementModel::new));
	}

	public Optional<TableFooterElementModel> findTableFooterElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TableFooterElementModel.stTemplateUuid, TableFooterElementModel::new));
	}

	public Optional<TableFooterElementModel> findTableFooterElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, TableFooterElementModel.stTemplateUuid, TableFooterElementModel::new));
	}

	public Optional<TableFooterElementModel> findTableFooterElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TableFooterElementModel.stTemplateUuid, TableFooterElementModel::new));
	}

	public Optional<TableFooterElementModel> findTableFooterElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TableFooterElementModel.stTemplateUuid, TableFooterElementModel::new));
	}

	public Optional<TableFooterElementModel> findTableFooterElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TableFooterElementModel.stTemplateUuid, TableFooterElementModel::new));
	}

	public Optional<TableHeadElementModel> findTableHeadElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TableHeadElementModel.stTemplateUuid, TableHeadElementModel::new));
	}

	public Optional<TableHeadElementModel> findTableHeadElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TableHeadElementModel.stTemplateUuid, TableHeadElementModel::new));
	}

	public Optional<TableHeadElementModel> findTableHeadElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, TableHeadElementModel.stTemplateUuid, TableHeadElementModel::new));
	}

	public Optional<TableHeadElementModel> findTableHeadElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TableHeadElementModel.stTemplateUuid, TableHeadElementModel::new));
	}

	public Optional<TableHeadElementModel> findTableHeadElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TableHeadElementModel.stTemplateUuid, TableHeadElementModel::new));
	}

	public Optional<TableHeadElementModel> findTableHeadElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TableHeadElementModel.stTemplateUuid, TableHeadElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByActionsComponent(STValue value) {
		return Optional.ofNullable(db.find("ActionsComponent", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByBackIconButtonProps(STValue value) {
		return Optional.ofNullable(db.find("backIconButtonProps", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByBackIconButtonText(STValue value) {
		return Optional.ofNullable(db.find("backIconButtonText", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByCount(STValue value) {
		return Optional.ofNullable(db.find("count", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByLabelDisplayedRows(STValue value) {
		return Optional.ofNullable(db.find("labelDisplayedRows", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByLabelRowsPerPage(STValue value) {
		return Optional.ofNullable(db.find("labelRowsPerPage", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByNextIconButtonProps(STValue value) {
		return Optional.ofNullable(db.find("nextIconButtonProps", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByNextIconButtonText(STValue value) {
		return Optional.ofNullable(db.find("nextIconButtonText", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByOnChangePage(STValue value) {
		return Optional.ofNullable(db.find("onChangePage", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByOnChangeRowsPerPage(STValue value) {
		return Optional.ofNullable(db.find("onChangeRowsPerPage", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByPage(STValue value) {
		return Optional.ofNullable(db.find("page", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByRowsPerPage(STValue value) {
		return Optional.ofNullable(db.find("rowsPerPage", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByRowsPerPageOptions(STValue value) {
		return Optional.ofNullable(db.find("rowsPerPageOptions", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelBySelectProps(STValue value) {
		return Optional.ofNullable(db.find("SelectProps", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TablePaginationElementModel> findTablePaginationElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TablePaginationElementModel.stTemplateUuid, TablePaginationElementModel::new));
	}

	public Optional<TableRowElementModel> findTableRowElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TableRowElementModel.stTemplateUuid, TableRowElementModel::new));
	}

	public Optional<TableRowElementModel> findTableRowElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TableRowElementModel.stTemplateUuid, TableRowElementModel::new));
	}

	public Optional<TableRowElementModel> findTableRowElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, TableRowElementModel.stTemplateUuid, TableRowElementModel::new));
	}

	public Optional<TableRowElementModel> findTableRowElementModelByHover(STValue value) {
		return Optional.ofNullable(db.find("hover", value, TableRowElementModel.stTemplateUuid, TableRowElementModel::new));
	}

	public Optional<TableRowElementModel> findTableRowElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TableRowElementModel.stTemplateUuid, TableRowElementModel::new));
	}

	public Optional<TableRowElementModel> findTableRowElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TableRowElementModel.stTemplateUuid, TableRowElementModel::new));
	}

	public Optional<TableRowElementModel> findTableRowElementModelBySelected(STValue value) {
		return Optional.ofNullable(db.find("selected", value, TableRowElementModel.stTemplateUuid, TableRowElementModel::new));
	}

	public Optional<TableRowElementModel> findTableRowElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TableRowElementModel.stTemplateUuid, TableRowElementModel::new));
	}

	public Optional<TableSortLabelElementModel> findTableSortLabelElementModelByActive(STValue value) {
		return Optional.ofNullable(db.find("active", value, TableSortLabelElementModel.stTemplateUuid, TableSortLabelElementModel::new));
	}

	public Optional<TableSortLabelElementModel> findTableSortLabelElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TableSortLabelElementModel.stTemplateUuid, TableSortLabelElementModel::new));
	}

	public Optional<TableSortLabelElementModel> findTableSortLabelElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TableSortLabelElementModel.stTemplateUuid, TableSortLabelElementModel::new));
	}

	public Optional<TableSortLabelElementModel> findTableSortLabelElementModelByDirection(STValue value) {
		return Optional.ofNullable(db.find("direction", value, TableSortLabelElementModel.stTemplateUuid, TableSortLabelElementModel::new));
	}

	public Optional<TableSortLabelElementModel> findTableSortLabelElementModelByHideSortIcon(STValue value) {
		return Optional.ofNullable(db.find("hideSortIcon", value, TableSortLabelElementModel.stTemplateUuid, TableSortLabelElementModel::new));
	}

	public Optional<TableSortLabelElementModel> findTableSortLabelElementModelByIconComponent(STValue value) {
		return Optional.ofNullable(db.find("IconComponent", value, TableSortLabelElementModel.stTemplateUuid, TableSortLabelElementModel::new));
	}

	public Optional<TableSortLabelElementModel> findTableSortLabelElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TableSortLabelElementModel.stTemplateUuid, TableSortLabelElementModel::new));
	}

	public Optional<TableSortLabelElementModel> findTableSortLabelElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TableSortLabelElementModel.stTemplateUuid, TableSortLabelElementModel::new));
	}

	public Optional<TableSortLabelElementModel> findTableSortLabelElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TableSortLabelElementModel.stTemplateUuid, TableSortLabelElementModel::new));
	}

	public Optional<TabListElementModel> findTabListElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TabListElementModel.stTemplateUuid, TabListElementModel::new));
	}

	public Optional<TabListElementModel> findTabListElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TabListElementModel.stTemplateUuid, TabListElementModel::new));
	}

	public Optional<TabListElementModel> findTabListElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TabListElementModel.stTemplateUuid, TabListElementModel::new));
	}

	public Optional<TabListElementModel> findTabListElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TabListElementModel.stTemplateUuid, TabListElementModel::new));
	}

	public Optional<TabPanelElementModel> findTabPanelElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TabPanelElementModel.stTemplateUuid, TabPanelElementModel::new));
	}

	public Optional<TabPanelElementModel> findTabPanelElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TabPanelElementModel.stTemplateUuid, TabPanelElementModel::new));
	}

	public Optional<TabPanelElementModel> findTabPanelElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TabPanelElementModel.stTemplateUuid, TabPanelElementModel::new));
	}

	public Optional<TabPanelElementModel> findTabPanelElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TabPanelElementModel.stTemplateUuid, TabPanelElementModel::new));
	}

	public Optional<TabPanelElementModel> findTabPanelElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TabPanelElementModel.stTemplateUuid, TabPanelElementModel::new));
	}

	public Optional<TabPanelElementModel> findTabPanelElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, TabPanelElementModel.stTemplateUuid, TabPanelElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByAction(STValue value) {
		return Optional.ofNullable(db.find("action", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByAriaLabel(STValue value) {
		return Optional.ofNullable(db.find("ariaLabel", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByAriaLabelledby(STValue value) {
		return Optional.ofNullable(db.find("ariaLabelledby", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByCentered(STValue value) {
		return Optional.ofNullable(db.find("centered", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByIndicatorColor(STValue value) {
		return Optional.ofNullable(db.find("indicatorColor", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByOrientation(STValue value) {
		return Optional.ofNullable(db.find("orientation", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByScrollButtonComponent(STValue value) {
		return Optional.ofNullable(db.find("ScrollButtonComponent", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByScrollButtons(STValue value) {
		return Optional.ofNullable(db.find("scrollButtons", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelBySelectionFollowsFocus(STValue value) {
		return Optional.ofNullable(db.find("selectionFollowsFocus", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByTabIndicatorProps(STValue value) {
		return Optional.ofNullable(db.find("TabIndicatorProps", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByTabScrollButtonProps(STValue value) {
		return Optional.ofNullable(db.find("TabScrollButtonProps", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByTextColor(STValue value) {
		return Optional.ofNullable(db.find("textColor", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabsElementModel> findTabsElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, TabsElementModel.stTemplateUuid, TabsElementModel::new));
	}

	public Optional<TabScrollButtonElementModel> findTabScrollButtonElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TabScrollButtonElementModel.stTemplateUuid, TabScrollButtonElementModel::new));
	}

	public Optional<TabScrollButtonElementModel> findTabScrollButtonElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TabScrollButtonElementModel.stTemplateUuid, TabScrollButtonElementModel::new));
	}

	public Optional<TabScrollButtonElementModel> findTabScrollButtonElementModelByDirection(STValue value) {
		return Optional.ofNullable(db.find("direction", value, TabScrollButtonElementModel.stTemplateUuid, TabScrollButtonElementModel::new));
	}

	public Optional<TabScrollButtonElementModel> findTabScrollButtonElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, TabScrollButtonElementModel.stTemplateUuid, TabScrollButtonElementModel::new));
	}

	public Optional<TabScrollButtonElementModel> findTabScrollButtonElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TabScrollButtonElementModel.stTemplateUuid, TabScrollButtonElementModel::new));
	}

	public Optional<TabScrollButtonElementModel> findTabScrollButtonElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TabScrollButtonElementModel.stTemplateUuid, TabScrollButtonElementModel::new));
	}

	public Optional<TabScrollButtonElementModel> findTabScrollButtonElementModelByOrientation(STValue value) {
		return Optional.ofNullable(db.find("orientation", value, TabScrollButtonElementModel.stTemplateUuid, TabScrollButtonElementModel::new));
	}

	public Optional<TabScrollButtonElementModel> findTabScrollButtonElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TabScrollButtonElementModel.stTemplateUuid, TabScrollButtonElementModel::new));
	}

	public Optional<TextareaAutosizeElementModel> findTextareaAutosizeElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TextareaAutosizeElementModel.stTemplateUuid, TextareaAutosizeElementModel::new));
	}

	public Optional<TextareaAutosizeElementModel> findTextareaAutosizeElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TextareaAutosizeElementModel.stTemplateUuid, TextareaAutosizeElementModel::new));
	}

	public Optional<TextareaAutosizeElementModel> findTextareaAutosizeElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TextareaAutosizeElementModel.stTemplateUuid, TextareaAutosizeElementModel::new));
	}

	public Optional<TextareaAutosizeElementModel> findTextareaAutosizeElementModelByRows(STValue value) {
		return Optional.ofNullable(db.find("rows", value, TextareaAutosizeElementModel.stTemplateUuid, TextareaAutosizeElementModel::new));
	}

	public Optional<TextareaAutosizeElementModel> findTextareaAutosizeElementModelByRowsMax(STValue value) {
		return Optional.ofNullable(db.find("rowsMax", value, TextareaAutosizeElementModel.stTemplateUuid, TextareaAutosizeElementModel::new));
	}

	public Optional<TextareaAutosizeElementModel> findTextareaAutosizeElementModelByRowsMin(STValue value) {
		return Optional.ofNullable(db.find("rowsMin", value, TextareaAutosizeElementModel.stTemplateUuid, TextareaAutosizeElementModel::new));
	}

	public Optional<TextareaAutosizeElementModel> findTextareaAutosizeElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TextareaAutosizeElementModel.stTemplateUuid, TextareaAutosizeElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByAutoComplete(STValue value) {
		return Optional.ofNullable(db.find("autoComplete", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByAutoFocus(STValue value) {
		return Optional.ofNullable(db.find("autoFocus", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByDefaultValue(STValue value) {
		return Optional.ofNullable(db.find("defaultValue", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByError(STValue value) {
		return Optional.ofNullable(db.find("error", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByFormHelperTextProps(STValue value) {
		return Optional.ofNullable(db.find("FormHelperTextProps", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByFullWidth(STValue value) {
		return Optional.ofNullable(db.find("fullWidth", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByHelperText(STValue value) {
		return Optional.ofNullable(db.find("helperText", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByInputLabelProps(STValue value) {
		return Optional.ofNullable(db.find("InputLabelProps", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByInputProps(STValue value) {
		return Optional.ofNullable(db.find("inputProps", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByInputRef(STValue value) {
		return Optional.ofNullable(db.find("inputRef", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByLabel(STValue value) {
		return Optional.ofNullable(db.find("label", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByMargin(STValue value) {
		return Optional.ofNullable(db.find("margin", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByMultiline(STValue value) {
		return Optional.ofNullable(db.find("multiline", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByName(STValue value) {
		return Optional.ofNullable(db.find("name", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByPlaceholder(STValue value) {
		return Optional.ofNullable(db.find("placeholder", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByRequired(STValue value) {
		return Optional.ofNullable(db.find("required", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByRows(STValue value) {
		return Optional.ofNullable(db.find("rows", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByRowsMax(STValue value) {
		return Optional.ofNullable(db.find("rowsMax", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelBySelect(STValue value) {
		return Optional.ofNullable(db.find("select", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelBySelectProps(STValue value) {
		return Optional.ofNullable(db.find("SelectProps", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByType(STValue value) {
		return Optional.ofNullable(db.find("type", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TextFieldElementModel> findTextFieldElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, TextFieldElementModel.stTemplateUuid, TextFieldElementModel::new));
	}

	public Optional<TimelineElementModel> findTimelineElementModelByAlign(STValue value) {
		return Optional.ofNullable(db.find("align", value, TimelineElementModel.stTemplateUuid, TimelineElementModel::new));
	}

	public Optional<TimelineElementModel> findTimelineElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TimelineElementModel.stTemplateUuid, TimelineElementModel::new));
	}

	public Optional<TimelineElementModel> findTimelineElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TimelineElementModel.stTemplateUuid, TimelineElementModel::new));
	}

	public Optional<TimelineElementModel> findTimelineElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TimelineElementModel.stTemplateUuid, TimelineElementModel::new));
	}

	public Optional<TimelineElementModel> findTimelineElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TimelineElementModel.stTemplateUuid, TimelineElementModel::new));
	}

	public Optional<TimelineElementModel> findTimelineElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TimelineElementModel.stTemplateUuid, TimelineElementModel::new));
	}

	public Optional<TimelineConnectorElementModel> findTimelineConnectorElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TimelineConnectorElementModel.stTemplateUuid, TimelineConnectorElementModel::new));
	}

	public Optional<TimelineConnectorElementModel> findTimelineConnectorElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TimelineConnectorElementModel.stTemplateUuid, TimelineConnectorElementModel::new));
	}

	public Optional<TimelineConnectorElementModel> findTimelineConnectorElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TimelineConnectorElementModel.stTemplateUuid, TimelineConnectorElementModel::new));
	}

	public Optional<TimelineConnectorElementModel> findTimelineConnectorElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TimelineConnectorElementModel.stTemplateUuid, TimelineConnectorElementModel::new));
	}

	public Optional<TimelineConnectorElementModel> findTimelineConnectorElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TimelineConnectorElementModel.stTemplateUuid, TimelineConnectorElementModel::new));
	}

	public Optional<TimelineContentElementModel> findTimelineContentElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TimelineContentElementModel.stTemplateUuid, TimelineContentElementModel::new));
	}

	public Optional<TimelineContentElementModel> findTimelineContentElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TimelineContentElementModel.stTemplateUuid, TimelineContentElementModel::new));
	}

	public Optional<TimelineContentElementModel> findTimelineContentElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TimelineContentElementModel.stTemplateUuid, TimelineContentElementModel::new));
	}

	public Optional<TimelineContentElementModel> findTimelineContentElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TimelineContentElementModel.stTemplateUuid, TimelineContentElementModel::new));
	}

	public Optional<TimelineContentElementModel> findTimelineContentElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TimelineContentElementModel.stTemplateUuid, TimelineContentElementModel::new));
	}

	public Optional<TimelineDotElementModel> findTimelineDotElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TimelineDotElementModel.stTemplateUuid, TimelineDotElementModel::new));
	}

	public Optional<TimelineDotElementModel> findTimelineDotElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TimelineDotElementModel.stTemplateUuid, TimelineDotElementModel::new));
	}

	public Optional<TimelineDotElementModel> findTimelineDotElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, TimelineDotElementModel.stTemplateUuid, TimelineDotElementModel::new));
	}

	public Optional<TimelineDotElementModel> findTimelineDotElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TimelineDotElementModel.stTemplateUuid, TimelineDotElementModel::new));
	}

	public Optional<TimelineDotElementModel> findTimelineDotElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TimelineDotElementModel.stTemplateUuid, TimelineDotElementModel::new));
	}

	public Optional<TimelineDotElementModel> findTimelineDotElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TimelineDotElementModel.stTemplateUuid, TimelineDotElementModel::new));
	}

	public Optional<TimelineDotElementModel> findTimelineDotElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, TimelineDotElementModel.stTemplateUuid, TimelineDotElementModel::new));
	}

	public Optional<TimelineItemElementModel> findTimelineItemElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TimelineItemElementModel.stTemplateUuid, TimelineItemElementModel::new));
	}

	public Optional<TimelineItemElementModel> findTimelineItemElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TimelineItemElementModel.stTemplateUuid, TimelineItemElementModel::new));
	}

	public Optional<TimelineItemElementModel> findTimelineItemElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TimelineItemElementModel.stTemplateUuid, TimelineItemElementModel::new));
	}

	public Optional<TimelineItemElementModel> findTimelineItemElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TimelineItemElementModel.stTemplateUuid, TimelineItemElementModel::new));
	}

	public Optional<TimelineItemElementModel> findTimelineItemElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TimelineItemElementModel.stTemplateUuid, TimelineItemElementModel::new));
	}

	public Optional<TimelineOppositeContentElementModel> findTimelineOppositeContentElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TimelineOppositeContentElementModel.stTemplateUuid, TimelineOppositeContentElementModel::new));
	}

	public Optional<TimelineOppositeContentElementModel> findTimelineOppositeContentElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TimelineOppositeContentElementModel.stTemplateUuid, TimelineOppositeContentElementModel::new));
	}

	public Optional<TimelineOppositeContentElementModel> findTimelineOppositeContentElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TimelineOppositeContentElementModel.stTemplateUuid, TimelineOppositeContentElementModel::new));
	}

	public Optional<TimelineOppositeContentElementModel> findTimelineOppositeContentElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TimelineOppositeContentElementModel.stTemplateUuid, TimelineOppositeContentElementModel::new));
	}

	public Optional<TimelineOppositeContentElementModel> findTimelineOppositeContentElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TimelineOppositeContentElementModel.stTemplateUuid, TimelineOppositeContentElementModel::new));
	}

	public Optional<TimelineSeparatorElementModel> findTimelineSeparatorElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TimelineSeparatorElementModel.stTemplateUuid, TimelineSeparatorElementModel::new));
	}

	public Optional<TimelineSeparatorElementModel> findTimelineSeparatorElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TimelineSeparatorElementModel.stTemplateUuid, TimelineSeparatorElementModel::new));
	}

	public Optional<TimelineSeparatorElementModel> findTimelineSeparatorElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TimelineSeparatorElementModel.stTemplateUuid, TimelineSeparatorElementModel::new));
	}

	public Optional<TimelineSeparatorElementModel> findTimelineSeparatorElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TimelineSeparatorElementModel.stTemplateUuid, TimelineSeparatorElementModel::new));
	}

	public Optional<TimelineSeparatorElementModel> findTimelineSeparatorElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TimelineSeparatorElementModel.stTemplateUuid, TimelineSeparatorElementModel::new));
	}

	public Optional<ToggleButtonElementModel> findToggleButtonElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ToggleButtonElementModel.stTemplateUuid, ToggleButtonElementModel::new));
	}

	public Optional<ToggleButtonElementModel> findToggleButtonElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ToggleButtonElementModel.stTemplateUuid, ToggleButtonElementModel::new));
	}

	public Optional<ToggleButtonElementModel> findToggleButtonElementModelByDisabled(STValue value) {
		return Optional.ofNullable(db.find("disabled", value, ToggleButtonElementModel.stTemplateUuid, ToggleButtonElementModel::new));
	}

	public Optional<ToggleButtonElementModel> findToggleButtonElementModelByDisableFocusRipple(STValue value) {
		return Optional.ofNullable(db.find("disableFocusRipple", value, ToggleButtonElementModel.stTemplateUuid, ToggleButtonElementModel::new));
	}

	public Optional<ToggleButtonElementModel> findToggleButtonElementModelByDisableRipple(STValue value) {
		return Optional.ofNullable(db.find("disableRipple", value, ToggleButtonElementModel.stTemplateUuid, ToggleButtonElementModel::new));
	}

	public Optional<ToggleButtonElementModel> findToggleButtonElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ToggleButtonElementModel.stTemplateUuid, ToggleButtonElementModel::new));
	}

	public Optional<ToggleButtonElementModel> findToggleButtonElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ToggleButtonElementModel.stTemplateUuid, ToggleButtonElementModel::new));
	}

	public Optional<ToggleButtonElementModel> findToggleButtonElementModelBySelected(STValue value) {
		return Optional.ofNullable(db.find("selected", value, ToggleButtonElementModel.stTemplateUuid, ToggleButtonElementModel::new));
	}

	public Optional<ToggleButtonElementModel> findToggleButtonElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ToggleButtonElementModel.stTemplateUuid, ToggleButtonElementModel::new));
	}

	public Optional<ToggleButtonElementModel> findToggleButtonElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, ToggleButtonElementModel.stTemplateUuid, ToggleButtonElementModel::new));
	}

	public Optional<ToggleButtonGroupElementModel> findToggleButtonGroupElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ToggleButtonGroupElementModel.stTemplateUuid, ToggleButtonGroupElementModel::new));
	}

	public Optional<ToggleButtonGroupElementModel> findToggleButtonGroupElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ToggleButtonGroupElementModel.stTemplateUuid, ToggleButtonGroupElementModel::new));
	}

	public Optional<ToggleButtonGroupElementModel> findToggleButtonGroupElementModelByExclusive(STValue value) {
		return Optional.ofNullable(db.find("exclusive", value, ToggleButtonGroupElementModel.stTemplateUuid, ToggleButtonGroupElementModel::new));
	}

	public Optional<ToggleButtonGroupElementModel> findToggleButtonGroupElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ToggleButtonGroupElementModel.stTemplateUuid, ToggleButtonGroupElementModel::new));
	}

	public Optional<ToggleButtonGroupElementModel> findToggleButtonGroupElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ToggleButtonGroupElementModel.stTemplateUuid, ToggleButtonGroupElementModel::new));
	}

	public Optional<ToggleButtonGroupElementModel> findToggleButtonGroupElementModelByOnChange(STValue value) {
		return Optional.ofNullable(db.find("onChange", value, ToggleButtonGroupElementModel.stTemplateUuid, ToggleButtonGroupElementModel::new));
	}

	public Optional<ToggleButtonGroupElementModel> findToggleButtonGroupElementModelByOrientation(STValue value) {
		return Optional.ofNullable(db.find("orientation", value, ToggleButtonGroupElementModel.stTemplateUuid, ToggleButtonGroupElementModel::new));
	}

	public Optional<ToggleButtonGroupElementModel> findToggleButtonGroupElementModelBySize(STValue value) {
		return Optional.ofNullable(db.find("size", value, ToggleButtonGroupElementModel.stTemplateUuid, ToggleButtonGroupElementModel::new));
	}

	public Optional<ToggleButtonGroupElementModel> findToggleButtonGroupElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ToggleButtonGroupElementModel.stTemplateUuid, ToggleButtonGroupElementModel::new));
	}

	public Optional<ToggleButtonGroupElementModel> findToggleButtonGroupElementModelByValue(STValue value) {
		return Optional.ofNullable(db.find("value", value, ToggleButtonGroupElementModel.stTemplateUuid, ToggleButtonGroupElementModel::new));
	}

	public Optional<ToolbarElementModel> findToolbarElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, ToolbarElementModel.stTemplateUuid, ToolbarElementModel::new));
	}

	public Optional<ToolbarElementModel> findToolbarElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ToolbarElementModel.stTemplateUuid, ToolbarElementModel::new));
	}

	public Optional<ToolbarElementModel> findToolbarElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, ToolbarElementModel.stTemplateUuid, ToolbarElementModel::new));
	}

	public Optional<ToolbarElementModel> findToolbarElementModelByDisableGutters(STValue value) {
		return Optional.ofNullable(db.find("disableGutters", value, ToolbarElementModel.stTemplateUuid, ToolbarElementModel::new));
	}

	public Optional<ToolbarElementModel> findToolbarElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ToolbarElementModel.stTemplateUuid, ToolbarElementModel::new));
	}

	public Optional<ToolbarElementModel> findToolbarElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ToolbarElementModel.stTemplateUuid, ToolbarElementModel::new));
	}

	public Optional<ToolbarElementModel> findToolbarElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ToolbarElementModel.stTemplateUuid, ToolbarElementModel::new));
	}

	public Optional<ToolbarElementModel> findToolbarElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, ToolbarElementModel.stTemplateUuid, ToolbarElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByArrow(STValue value) {
		return Optional.ofNullable(db.find("arrow", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByDisableFocusListener(STValue value) {
		return Optional.ofNullable(db.find("disableFocusListener", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByDisableHoverListener(STValue value) {
		return Optional.ofNullable(db.find("disableHoverListener", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByDisableTouchListener(STValue value) {
		return Optional.ofNullable(db.find("disableTouchListener", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByEnterDelay(STValue value) {
		return Optional.ofNullable(db.find("enterDelay", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByEnterNextDelay(STValue value) {
		return Optional.ofNullable(db.find("enterNextDelay", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByEnterTouchDelay(STValue value) {
		return Optional.ofNullable(db.find("enterTouchDelay", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByInteractive(STValue value) {
		return Optional.ofNullable(db.find("interactive", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByLeaveDelay(STValue value) {
		return Optional.ofNullable(db.find("leaveDelay", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByLeaveTouchDelay(STValue value) {
		return Optional.ofNullable(db.find("leaveTouchDelay", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByOnClose(STValue value) {
		return Optional.ofNullable(db.find("onClose", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByOnOpen(STValue value) {
		return Optional.ofNullable(db.find("onOpen", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByOpen(STValue value) {
		return Optional.ofNullable(db.find("open", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByPlacement(STValue value) {
		return Optional.ofNullable(db.find("placement", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByPopperComponent(STValue value) {
		return Optional.ofNullable(db.find("PopperComponent", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByPopperProps(STValue value) {
		return Optional.ofNullable(db.find("PopperProps", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByTitle(STValue value) {
		return Optional.ofNullable(db.find("title", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByTransitionComponent(STValue value) {
		return Optional.ofNullable(db.find("TransitionComponent", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TooltipElementModel> findTooltipElementModelByTransitionProps(STValue value) {
		return Optional.ofNullable(db.find("TransitionProps", value, TooltipElementModel.stTemplateUuid, TooltipElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelByCollapseIcon(STValue value) {
		return Optional.ofNullable(db.find("collapseIcon", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelByEndIcon(STValue value) {
		return Optional.ofNullable(db.find("endIcon", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelByExpandIcon(STValue value) {
		return Optional.ofNullable(db.find("expandIcon", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelByIcon(STValue value) {
		return Optional.ofNullable(db.find("icon", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelByLabel(STValue value) {
		return Optional.ofNullable(db.find("label", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelByNodeId(STValue value) {
		return Optional.ofNullable(db.find("nodeId", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelByOnIconClick(STValue value) {
		return Optional.ofNullable(db.find("onIconClick", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelByOnLabelClick(STValue value) {
		return Optional.ofNullable(db.find("onLabelClick", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelByTransitionComponent(STValue value) {
		return Optional.ofNullable(db.find("TransitionComponent", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeItemElementModel> findTreeItemElementModelByTransitionProps(STValue value) {
		return Optional.ofNullable(db.find("TransitionProps", value, TreeItemElementModel.stTemplateUuid, TreeItemElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByDefaultCollapseIcon(STValue value) {
		return Optional.ofNullable(db.find("defaultCollapseIcon", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByDefaultEndIcon(STValue value) {
		return Optional.ofNullable(db.find("defaultEndIcon", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByDefaultExpanded(STValue value) {
		return Optional.ofNullable(db.find("defaultExpanded", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByDefaultExpandIcon(STValue value) {
		return Optional.ofNullable(db.find("defaultExpandIcon", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByDefaultParentIcon(STValue value) {
		return Optional.ofNullable(db.find("defaultParentIcon", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByDefaultSelected(STValue value) {
		return Optional.ofNullable(db.find("defaultSelected", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByDisableSelection(STValue value) {
		return Optional.ofNullable(db.find("disableSelection", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByExpanded(STValue value) {
		return Optional.ofNullable(db.find("expanded", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByMultiSelect(STValue value) {
		return Optional.ofNullable(db.find("multiSelect", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByOnNodeSelect(STValue value) {
		return Optional.ofNullable(db.find("onNodeSelect", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByOnNodeToggle(STValue value) {
		return Optional.ofNullable(db.find("onNodeToggle", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelBySelected(STValue value) {
		return Optional.ofNullable(db.find("selected", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TreeViewElementModel> findTreeViewElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TreeViewElementModel.stTemplateUuid, TreeViewElementModel::new));
	}

	public Optional<TypographyElementModel> findTypographyElementModelByAlign(STValue value) {
		return Optional.ofNullable(db.find("align", value, TypographyElementModel.stTemplateUuid, TypographyElementModel::new));
	}

	public Optional<TypographyElementModel> findTypographyElementModelByClasses(STValue value) {
		return Optional.ofNullable(db.find("classes", value, TypographyElementModel.stTemplateUuid, TypographyElementModel::new));
	}

	public Optional<TypographyElementModel> findTypographyElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, TypographyElementModel.stTemplateUuid, TypographyElementModel::new));
	}

	public Optional<TypographyElementModel> findTypographyElementModelByColor(STValue value) {
		return Optional.ofNullable(db.find("color", value, TypographyElementModel.stTemplateUuid, TypographyElementModel::new));
	}

	public Optional<TypographyElementModel> findTypographyElementModelByComponent(STValue value) {
		return Optional.ofNullable(db.find("component", value, TypographyElementModel.stTemplateUuid, TypographyElementModel::new));
	}

	public Optional<TypographyElementModel> findTypographyElementModelByDisplay(STValue value) {
		return Optional.ofNullable(db.find("display", value, TypographyElementModel.stTemplateUuid, TypographyElementModel::new));
	}

	public Optional<TypographyElementModel> findTypographyElementModelByGutterBottom(STValue value) {
		return Optional.ofNullable(db.find("gutterBottom", value, TypographyElementModel.stTemplateUuid, TypographyElementModel::new));
	}

	public Optional<TypographyElementModel> findTypographyElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, TypographyElementModel.stTemplateUuid, TypographyElementModel::new));
	}

	public Optional<TypographyElementModel> findTypographyElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, TypographyElementModel.stTemplateUuid, TypographyElementModel::new));
	}

	public Optional<TypographyElementModel> findTypographyElementModelByNoWrap(STValue value) {
		return Optional.ofNullable(db.find("noWrap", value, TypographyElementModel.stTemplateUuid, TypographyElementModel::new));
	}

	public Optional<TypographyElementModel> findTypographyElementModelByParagraph(STValue value) {
		return Optional.ofNullable(db.find("paragraph", value, TypographyElementModel.stTemplateUuid, TypographyElementModel::new));
	}

	public Optional<TypographyElementModel> findTypographyElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, TypographyElementModel.stTemplateUuid, TypographyElementModel::new));
	}

	public Optional<TypographyElementModel> findTypographyElementModelByVariant(STValue value) {
		return Optional.ofNullable(db.find("variant", value, TypographyElementModel.stTemplateUuid, TypographyElementModel::new));
	}

	public Optional<TypographyElementModel> findTypographyElementModelByVariantMapping(STValue value) {
		return Optional.ofNullable(db.find("variantMapping", value, TypographyElementModel.stTemplateUuid, TypographyElementModel::new));
	}

	public Optional<UnstableTrapFocusElementModel> findUnstableTrapFocusElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, UnstableTrapFocusElementModel.stTemplateUuid, UnstableTrapFocusElementModel::new));
	}

	public Optional<UnstableTrapFocusElementModel> findUnstableTrapFocusElementModelByDisableAutoFocus(STValue value) {
		return Optional.ofNullable(db.find("disableAutoFocus", value, UnstableTrapFocusElementModel.stTemplateUuid, UnstableTrapFocusElementModel::new));
	}

	public Optional<UnstableTrapFocusElementModel> findUnstableTrapFocusElementModelByDisableEnforceFocus(STValue value) {
		return Optional.ofNullable(db.find("disableEnforceFocus", value, UnstableTrapFocusElementModel.stTemplateUuid, UnstableTrapFocusElementModel::new));
	}

	public Optional<UnstableTrapFocusElementModel> findUnstableTrapFocusElementModelByDisableRestoreFocus(STValue value) {
		return Optional.ofNullable(db.find("disableRestoreFocus", value, UnstableTrapFocusElementModel.stTemplateUuid, UnstableTrapFocusElementModel::new));
	}

	public Optional<UnstableTrapFocusElementModel> findUnstableTrapFocusElementModelByGetDoc(STValue value) {
		return Optional.ofNullable(db.find("getDoc", value, UnstableTrapFocusElementModel.stTemplateUuid, UnstableTrapFocusElementModel::new));
	}

	public Optional<UnstableTrapFocusElementModel> findUnstableTrapFocusElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, UnstableTrapFocusElementModel.stTemplateUuid, UnstableTrapFocusElementModel::new));
	}

	public Optional<UnstableTrapFocusElementModel> findUnstableTrapFocusElementModelByIsEnabled(STValue value) {
		return Optional.ofNullable(db.find("isEnabled", value, UnstableTrapFocusElementModel.stTemplateUuid, UnstableTrapFocusElementModel::new));
	}

	public Optional<UnstableTrapFocusElementModel> findUnstableTrapFocusElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, UnstableTrapFocusElementModel.stTemplateUuid, UnstableTrapFocusElementModel::new));
	}

	public Optional<UnstableTrapFocusElementModel> findUnstableTrapFocusElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, UnstableTrapFocusElementModel.stTemplateUuid, UnstableTrapFocusElementModel::new));
	}

	public Optional<ZoomElementModel> findZoomElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, ZoomElementModel.stTemplateUuid, ZoomElementModel::new));
	}

	public Optional<ZoomElementModel> findZoomElementModelByDisableStrictModeCompat(STValue value) {
		return Optional.ofNullable(db.find("disableStrictModeCompat", value, ZoomElementModel.stTemplateUuid, ZoomElementModel::new));
	}

	public Optional<ZoomElementModel> findZoomElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, ZoomElementModel.stTemplateUuid, ZoomElementModel::new));
	}

	public Optional<ZoomElementModel> findZoomElementModelByIn(STValue value) {
		return Optional.ofNullable(db.find("in", value, ZoomElementModel.stTemplateUuid, ZoomElementModel::new));
	}

	public Optional<ZoomElementModel> findZoomElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, ZoomElementModel.stTemplateUuid, ZoomElementModel::new));
	}

	public Optional<ZoomElementModel> findZoomElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, ZoomElementModel.stTemplateUuid, ZoomElementModel::new));
	}

	public Optional<ZoomElementModel> findZoomElementModelByTimeout(STValue value) {
		return Optional.ofNullable(db.find("timeout", value, ZoomElementModel.stTemplateUuid, ZoomElementModel::new));
	}

	public Optional<BoxElementModel> findBoxElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, BoxElementModel.stTemplateUuid, BoxElementModel::new));
	}

	public Optional<BoxElementModel> findBoxElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, BoxElementModel.stTemplateUuid, BoxElementModel::new));
	}

	public Optional<BoxElementModel> findBoxElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, BoxElementModel.stTemplateUuid, BoxElementModel::new));
	}

	public Optional<BoxElementModel> findBoxElementModelByMt(STValue value) {
		return Optional.ofNullable(db.find("mt", value, BoxElementModel.stTemplateUuid, BoxElementModel::new));
	}

	public Optional<BoxElementModel> findBoxElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, BoxElementModel.stTemplateUuid, BoxElementModel::new));
	}

	public Optional<LockOutlinedIconElementModel> findLockOutlinedIconElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, LockOutlinedIconElementModel.stTemplateUuid, LockOutlinedIconElementModel::new));
	}

	public Optional<LockOutlinedIconElementModel> findLockOutlinedIconElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, LockOutlinedIconElementModel.stTemplateUuid, LockOutlinedIconElementModel::new));
	}

	public Optional<LockOutlinedIconElementModel> findLockOutlinedIconElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, LockOutlinedIconElementModel.stTemplateUuid, LockOutlinedIconElementModel::new));
	}

	public Optional<LockOutlinedIconElementModel> findLockOutlinedIconElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, LockOutlinedIconElementModel.stTemplateUuid, LockOutlinedIconElementModel::new));
	}

	public Optional<MenuIconElementModel> findMenuIconElementModelByClassName(STValue value) {
		return Optional.ofNullable(db.find("className", value, MenuIconElementModel.stTemplateUuid, MenuIconElementModel::new));
	}

	public Optional<MenuIconElementModel> findMenuIconElementModelById(STValue value) {
		return Optional.ofNullable(db.find("id", value, MenuIconElementModel.stTemplateUuid, MenuIconElementModel::new));
	}

	public Optional<MenuIconElementModel> findMenuIconElementModelByKey(STValue value) {
		return Optional.ofNullable(db.find("key", value, MenuIconElementModel.stTemplateUuid, MenuIconElementModel::new));
	}

	public Optional<MenuIconElementModel> findMenuIconElementModelByStyle(STValue value) {
		return Optional.ofNullable(db.find("style", value, MenuIconElementModel.stTemplateUuid, MenuIconElementModel::new));
	}
}