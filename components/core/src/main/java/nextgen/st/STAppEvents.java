package nextgen.st;

public class STAppEvents {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STAppEvents.class);

   public static void postSTModelEditorTreeNodeClicked(nextgen.st.model.STModel stModel) {
      log.info("post STModelEditorTreeNodeClicked");
      org.greenrobot.eventbus.EventBus.getDefault().post(new STModelEditorTreeNodeClicked(stModel));
   }

   public static class STModelEditorTreeNodeClicked {

      public final nextgen.st.model.STModel stModel;

      public STModelEditorTreeNodeClicked(nextgen.st.model.STModel stModel) {
         this.stModel = stModel;
      }
   }

   public static void postSTArgumentAdded(nextgen.st.model.STModel stModel, nextgen.st.model.STArgument stArgument) {
      log.info("post STArgumentAdded");
      org.greenrobot.eventbus.EventBus.getDefault().post(new STArgumentAdded(stModel, stArgument));
   }

   public static class STArgumentAdded {

      public final nextgen.st.model.STModel stModel;
      public final nextgen.st.model.STArgument stArgument;

      public STArgumentAdded(nextgen.st.model.STModel stModel, nextgen.st.model.STArgument stArgument) {
         this.stModel = stModel;
         this.stArgument = stArgument;
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

   public static void postSTModelUpdated(nextgen.st.model.STModel stModel) {
      log.info("post STModelUpdated");
      org.greenrobot.eventbus.EventBus.getDefault().post(new STModelUpdated(stModel));
   }

   public static class STModelUpdated {

      public final nextgen.st.model.STModel stModel;

      public STModelUpdated(nextgen.st.model.STModel stModel) {
         this.stModel = stModel;
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