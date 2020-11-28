package nextgen.st;

public class STVisitorTest extends STVisitor {

   private static final java.util.concurrent.atomic.AtomicInteger delims = new java.util.concurrent.atomic.AtomicInteger(0);

   public static void main(String[] args) throws java.io.IOException {
      final nextgen.swing.AppModel appModel = nextgen.swing.STApp.loadConfig(args);
      appModel.getSTAppPresentationModel().doInTransaction(transaction -> {
         final nextgen.model.STModel stModelByUuid = appModel.getSTAppPresentationModel().db.findSTModelByUuid("485df1a0-1b9d-4d79-a3d5-881800c035ac");
         final nextgen.st.STVisitorTest test = new nextgen.st.STVisitorTest(appModel.getSTAppPresentationModel());
         test.visit(stModelByUuid);
      });
   }

   private final nextgen.swing.STAppPresentationModel presentationModel;

   public STVisitorTest(nextgen.swing.STAppPresentationModel presentationModel) {
      super(presentationModel.db);
      this.presentationModel = presentationModel;
   }

   @Override
   protected void visitSingleSTModel(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STArgument stArgument, nextgen.model.STModel valueStModel) {
      debug("on" + nextgen.utils.StringUtil.capitalize(stParameter.getName()));
      delims.incrementAndGet();
      new STVisitorTest(presentationModel).visit(valueStModel);
      delims.decrementAndGet();
   }

   @Override
   protected void visitSinglePrimitive(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STArgument stArgument, String value) {
      debug("on" + nextgen.utils.StringUtil.capitalize(stParameter.getName()));
   }

   @Override
   protected void visitSingleEnum(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STArgument stArgument, String value) {
      debug("on" + nextgen.utils.StringUtil.capitalize(stParameter.getName()));
   }

   @Override
   protected void visitListSTModel(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STArgument stArgument, nextgen.model.STModel valueStModel) {
      debug("on" + nextgen.utils.StringUtil.capitalize(stParameter.getName()));
      delims.incrementAndGet();
      new STVisitorTest(presentationModel).visit(valueStModel);
      delims.decrementAndGet();
   }

   @Override
   protected void visitListPrimitive(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STArgument stArgument, String value) {
      debug("on" + nextgen.utils.StringUtil.capitalize(stParameter.getName()));
   }

   @Override
   protected void visitListEnum(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STArgument stArgument, String value) {
      debug("on" + nextgen.utils.StringUtil.capitalize(stParameter.getName()));
   }

   @Override
   protected void visitKVEntrySTModel(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, nextgen.model.STArgumentKV stArgumentKV, nextgen.model.STModel kvSTModel) {
      debug("on" + nextgen.utils.StringUtil.capitalize(stParameter.getName())+ "." + stParameterKey.getName());
      delims.incrementAndGet();
      new STVisitorTest(presentationModel).visit(kvSTModel);
      delims.decrementAndGet();
   }

   @Override
   protected void visitKVEntryPrimitive(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, nextgen.model.STArgumentKV stArgumentKV, String kvValue) {
      debug("on" + nextgen.utils.StringUtil.capitalize(stParameter.getName()) + "." + stParameterKey.getName());
   }

   @Override
   protected void visitKVEntryEnum(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, nextgen.model.STArgumentKV stArgumentKV, String kvValue) {
      debug("on" + nextgen.utils.StringUtil.capitalize(stParameter.getName())+ "." + stParameterKey.getName());
   }

   private void debug(String s) {
      final StringBuilder out = new StringBuilder();
      for (int i = 0; i < delims.get(); i++)
         out.append("\t");
      out.append(s);
      System.out.println(out.toString());
   }
}