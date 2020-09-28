package nextgen.templates;

import nextgen.templates.mobx.*;

public class MobXPatterns extends MobXST {

   public static Observable newObservable(String name) {
      return newObservable().setName(name);
   }

   public static Observable newObservable(String name, Object initializer) {
      return newObservable().setName(name).setInitializer(initializer);
   }

   public static Action newAction(String name) {
      return newAction().setName(name);
   }

   public static String getName(IStore store) {
      if (store instanceof Store) return ((Store) store).getName();
      return ((BackendStore) store).getName();
   }
}