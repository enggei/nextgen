package nextgen.model.workflow;

public class WorkFlowEvents {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(WorkFlowEvents.class);

	public static void postNewWork(nextgen.model.workflow.Work model) {
		log.info("post NewWork");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewWork(model));
	}

	public static void postUpdatedWork(nextgen.model.workflow.Work model) {
		log.info("post UpdatedWork");
		org.greenrobot.eventbus.EventBus.getDefault().post(new UpdatedWork(model));
	}

	public static void postDeletedWork(String model) {
		log.info("post DeletedWork");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DeletedWork(model));
	}

	public static void postSelectedWork(nextgen.model.workflow.Work model) {
		log.info("post SelectedWork");
		org.greenrobot.eventbus.EventBus.getDefault().post(new SelectedWork(model));
	}

	public static void postNewWorkInput(nextgen.model.workflow.WorkInput model) {
		log.info("post NewWorkInput");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewWorkInput(model));
	}

	public static void postUpdatedWorkInput(nextgen.model.workflow.WorkInput model) {
		log.info("post UpdatedWorkInput");
		org.greenrobot.eventbus.EventBus.getDefault().post(new UpdatedWorkInput(model));
	}

	public static void postDeletedWorkInput(String model) {
		log.info("post DeletedWorkInput");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DeletedWorkInput(model));
	}

	public static void postSelectedWorkInput(nextgen.model.workflow.WorkInput model) {
		log.info("post SelectedWorkInput");
		org.greenrobot.eventbus.EventBus.getDefault().post(new SelectedWorkInput(model));
	}

	public static void postNewWorkStatement(nextgen.model.workflow.WorkStatement model) {
		log.info("post NewWorkStatement");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewWorkStatement(model));
	}

	public static void postUpdatedWorkStatement(nextgen.model.workflow.WorkStatement model) {
		log.info("post UpdatedWorkStatement");
		org.greenrobot.eventbus.EventBus.getDefault().post(new UpdatedWorkStatement(model));
	}

	public static void postDeletedWorkStatement(String model) {
		log.info("post DeletedWorkStatement");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DeletedWorkStatement(model));
	}

	public static void postSelectedWorkStatement(nextgen.model.workflow.WorkStatement model) {
		log.info("post SelectedWorkStatement");
		org.greenrobot.eventbus.EventBus.getDefault().post(new SelectedWorkStatement(model));
	}

	public static void postNewWorkInstance(nextgen.model.workflow.WorkInstance model) {
		log.info("post NewWorkInstance");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewWorkInstance(model));
	}

	public static void postUpdatedWorkInstance(nextgen.model.workflow.WorkInstance model) {
		log.info("post UpdatedWorkInstance");
		org.greenrobot.eventbus.EventBus.getDefault().post(new UpdatedWorkInstance(model));
	}

	public static void postDeletedWorkInstance(String model) {
		log.info("post DeletedWorkInstance");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DeletedWorkInstance(model));
	}

	public static void postSelectedWorkInstance(nextgen.model.workflow.WorkInstance model) {
		log.info("post SelectedWorkInstance");
		org.greenrobot.eventbus.EventBus.getDefault().post(new SelectedWorkInstance(model));
	}

	public static void postNewWorkType(nextgen.model.workflow.WorkType model) {
		log.info("post NewWorkType");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewWorkType(model));
	}

	public static void postUpdatedWorkType(nextgen.model.workflow.WorkType model) {
		log.info("post UpdatedWorkType");
		org.greenrobot.eventbus.EventBus.getDefault().post(new UpdatedWorkType(model));
	}

	public static void postDeletedWorkType(String model) {
		log.info("post DeletedWorkType");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DeletedWorkType(model));
	}

	public static void postSelectedWorkType(nextgen.model.workflow.WorkType model) {
		log.info("post SelectedWorkType");
		org.greenrobot.eventbus.EventBus.getDefault().post(new SelectedWorkType(model));
	}

	public static void postNewConditionalFlow(nextgen.model.workflow.ConditionalFlow model) {
		log.info("post NewConditionalFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewConditionalFlow(model));
	}

	public static void postUpdatedConditionalFlow(nextgen.model.workflow.ConditionalFlow model) {
		log.info("post UpdatedConditionalFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new UpdatedConditionalFlow(model));
	}

	public static void postDeletedConditionalFlow(String model) {
		log.info("post DeletedConditionalFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DeletedConditionalFlow(model));
	}

	public static void postSelectedConditionalFlow(nextgen.model.workflow.ConditionalFlow model) {
		log.info("post SelectedConditionalFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new SelectedConditionalFlow(model));
	}

	public static void postNewSequentialFlow(nextgen.model.workflow.SequentialFlow model) {
		log.info("post NewSequentialFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewSequentialFlow(model));
	}

	public static void postUpdatedSequentialFlow(nextgen.model.workflow.SequentialFlow model) {
		log.info("post UpdatedSequentialFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new UpdatedSequentialFlow(model));
	}

	public static void postDeletedSequentialFlow(String model) {
		log.info("post DeletedSequentialFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DeletedSequentialFlow(model));
	}

	public static void postSelectedSequentialFlow(nextgen.model.workflow.SequentialFlow model) {
		log.info("post SelectedSequentialFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new SelectedSequentialFlow(model));
	}

	public static void postNewParallelFlow(nextgen.model.workflow.ParallelFlow model) {
		log.info("post NewParallelFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewParallelFlow(model));
	}

	public static void postUpdatedParallelFlow(nextgen.model.workflow.ParallelFlow model) {
		log.info("post UpdatedParallelFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new UpdatedParallelFlow(model));
	}

	public static void postDeletedParallelFlow(String model) {
		log.info("post DeletedParallelFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DeletedParallelFlow(model));
	}

	public static void postSelectedParallelFlow(nextgen.model.workflow.ParallelFlow model) {
		log.info("post SelectedParallelFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new SelectedParallelFlow(model));
	}

	public static void postNewRepeatFlow(nextgen.model.workflow.RepeatFlow model) {
		log.info("post NewRepeatFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewRepeatFlow(model));
	}

	public static void postUpdatedRepeatFlow(nextgen.model.workflow.RepeatFlow model) {
		log.info("post UpdatedRepeatFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new UpdatedRepeatFlow(model));
	}

	public static void postDeletedRepeatFlow(String model) {
		log.info("post DeletedRepeatFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DeletedRepeatFlow(model));
	}

	public static void postSelectedRepeatFlow(nextgen.model.workflow.RepeatFlow model) {
		log.info("post SelectedRepeatFlow");
		org.greenrobot.eventbus.EventBus.getDefault().post(new SelectedRepeatFlow(model));
	}

	public static void postNewUntilPredicate(nextgen.model.workflow.UntilPredicate model) {
		log.info("post NewUntilPredicate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new NewUntilPredicate(model));
	}

	public static void postUpdatedUntilPredicate(nextgen.model.workflow.UntilPredicate model) {
		log.info("post UpdatedUntilPredicate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new UpdatedUntilPredicate(model));
	}

	public static void postDeletedUntilPredicate(String model) {
		log.info("post DeletedUntilPredicate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new DeletedUntilPredicate(model));
	}

	public static void postSelectedUntilPredicate(nextgen.model.workflow.UntilPredicate model) {
		log.info("post SelectedUntilPredicate");
		org.greenrobot.eventbus.EventBus.getDefault().post(new SelectedUntilPredicate(model));
	}

	public static class NewWork {

		public final nextgen.model.workflow.Work model;

		public NewWork(nextgen.model.workflow.Work model) {
			this.model = model;
		}
	}

	public static class UpdatedWork {

		public final nextgen.model.workflow.Work model;

		public UpdatedWork(nextgen.model.workflow.Work model) {
			this.model = model;
		}
	}

	public static class DeletedWork {

		public final String model;

		public DeletedWork(String model) {
			this.model = model;
		}
	}

	public static class SelectedWork {

		public final nextgen.model.workflow.Work model;

		public SelectedWork(nextgen.model.workflow.Work model) {
			this.model = model;
		}
	}

	public static class NewWorkInput {

		public final nextgen.model.workflow.WorkInput model;

		public NewWorkInput(nextgen.model.workflow.WorkInput model) {
			this.model = model;
		}
	}

	public static class UpdatedWorkInput {

		public final nextgen.model.workflow.WorkInput model;

		public UpdatedWorkInput(nextgen.model.workflow.WorkInput model) {
			this.model = model;
		}
	}

	public static class DeletedWorkInput {

		public final String model;

		public DeletedWorkInput(String model) {
			this.model = model;
		}
	}

	public static class SelectedWorkInput {

		public final nextgen.model.workflow.WorkInput model;

		public SelectedWorkInput(nextgen.model.workflow.WorkInput model) {
			this.model = model;
		}
	}

	public static class NewWorkStatement {

		public final nextgen.model.workflow.WorkStatement model;

		public NewWorkStatement(nextgen.model.workflow.WorkStatement model) {
			this.model = model;
		}
	}

	public static class UpdatedWorkStatement {

		public final nextgen.model.workflow.WorkStatement model;

		public UpdatedWorkStatement(nextgen.model.workflow.WorkStatement model) {
			this.model = model;
		}
	}

	public static class DeletedWorkStatement {

		public final String model;

		public DeletedWorkStatement(String model) {
			this.model = model;
		}
	}

	public static class SelectedWorkStatement {

		public final nextgen.model.workflow.WorkStatement model;

		public SelectedWorkStatement(nextgen.model.workflow.WorkStatement model) {
			this.model = model;
		}
	}

	public static class NewWorkInstance {

		public final nextgen.model.workflow.WorkInstance model;

		public NewWorkInstance(nextgen.model.workflow.WorkInstance model) {
			this.model = model;
		}
	}

	public static class UpdatedWorkInstance {

		public final nextgen.model.workflow.WorkInstance model;

		public UpdatedWorkInstance(nextgen.model.workflow.WorkInstance model) {
			this.model = model;
		}
	}

	public static class DeletedWorkInstance {

		public final String model;

		public DeletedWorkInstance(String model) {
			this.model = model;
		}
	}

	public static class SelectedWorkInstance {

		public final nextgen.model.workflow.WorkInstance model;

		public SelectedWorkInstance(nextgen.model.workflow.WorkInstance model) {
			this.model = model;
		}
	}

	public static class NewWorkType {

		public final nextgen.model.workflow.WorkType model;

		public NewWorkType(nextgen.model.workflow.WorkType model) {
			this.model = model;
		}
	}

	public static class UpdatedWorkType {

		public final nextgen.model.workflow.WorkType model;

		public UpdatedWorkType(nextgen.model.workflow.WorkType model) {
			this.model = model;
		}
	}

	public static class DeletedWorkType {

		public final String model;

		public DeletedWorkType(String model) {
			this.model = model;
		}
	}

	public static class SelectedWorkType {

		public final nextgen.model.workflow.WorkType model;

		public SelectedWorkType(nextgen.model.workflow.WorkType model) {
			this.model = model;
		}
	}

	public static class NewConditionalFlow {

		public final nextgen.model.workflow.ConditionalFlow model;

		public NewConditionalFlow(nextgen.model.workflow.ConditionalFlow model) {
			this.model = model;
		}
	}

	public static class UpdatedConditionalFlow {

		public final nextgen.model.workflow.ConditionalFlow model;

		public UpdatedConditionalFlow(nextgen.model.workflow.ConditionalFlow model) {
			this.model = model;
		}
	}

	public static class DeletedConditionalFlow {

		public final String model;

		public DeletedConditionalFlow(String model) {
			this.model = model;
		}
	}

	public static class SelectedConditionalFlow {

		public final nextgen.model.workflow.ConditionalFlow model;

		public SelectedConditionalFlow(nextgen.model.workflow.ConditionalFlow model) {
			this.model = model;
		}
	}

	public static class NewSequentialFlow {

		public final nextgen.model.workflow.SequentialFlow model;

		public NewSequentialFlow(nextgen.model.workflow.SequentialFlow model) {
			this.model = model;
		}
	}

	public static class UpdatedSequentialFlow {

		public final nextgen.model.workflow.SequentialFlow model;

		public UpdatedSequentialFlow(nextgen.model.workflow.SequentialFlow model) {
			this.model = model;
		}
	}

	public static class DeletedSequentialFlow {

		public final String model;

		public DeletedSequentialFlow(String model) {
			this.model = model;
		}
	}

	public static class SelectedSequentialFlow {

		public final nextgen.model.workflow.SequentialFlow model;

		public SelectedSequentialFlow(nextgen.model.workflow.SequentialFlow model) {
			this.model = model;
		}
	}

	public static class NewParallelFlow {

		public final nextgen.model.workflow.ParallelFlow model;

		public NewParallelFlow(nextgen.model.workflow.ParallelFlow model) {
			this.model = model;
		}
	}

	public static class UpdatedParallelFlow {

		public final nextgen.model.workflow.ParallelFlow model;

		public UpdatedParallelFlow(nextgen.model.workflow.ParallelFlow model) {
			this.model = model;
		}
	}

	public static class DeletedParallelFlow {

		public final String model;

		public DeletedParallelFlow(String model) {
			this.model = model;
		}
	}

	public static class SelectedParallelFlow {

		public final nextgen.model.workflow.ParallelFlow model;

		public SelectedParallelFlow(nextgen.model.workflow.ParallelFlow model) {
			this.model = model;
		}
	}

	public static class NewRepeatFlow {

		public final nextgen.model.workflow.RepeatFlow model;

		public NewRepeatFlow(nextgen.model.workflow.RepeatFlow model) {
			this.model = model;
		}
	}

	public static class UpdatedRepeatFlow {

		public final nextgen.model.workflow.RepeatFlow model;

		public UpdatedRepeatFlow(nextgen.model.workflow.RepeatFlow model) {
			this.model = model;
		}
	}

	public static class DeletedRepeatFlow {

		public final String model;

		public DeletedRepeatFlow(String model) {
			this.model = model;
		}
	}

	public static class SelectedRepeatFlow {

		public final nextgen.model.workflow.RepeatFlow model;

		public SelectedRepeatFlow(nextgen.model.workflow.RepeatFlow model) {
			this.model = model;
		}
	}

	public static class NewUntilPredicate {

		public final nextgen.model.workflow.UntilPredicate model;

		public NewUntilPredicate(nextgen.model.workflow.UntilPredicate model) {
			this.model = model;
		}
	}

	public static class UpdatedUntilPredicate {

		public final nextgen.model.workflow.UntilPredicate model;

		public UpdatedUntilPredicate(nextgen.model.workflow.UntilPredicate model) {
			this.model = model;
		}
	}

	public static class DeletedUntilPredicate {

		public final String model;

		public DeletedUntilPredicate(String model) {
			this.model = model;
		}
	}

	public static class SelectedUntilPredicate {

		public final nextgen.model.workflow.UntilPredicate model;

		public SelectedUntilPredicate(nextgen.model.workflow.UntilPredicate model) {
			this.model = model;
		}
	}
}