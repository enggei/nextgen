package nextgen.templates;

import nextgen.templates.greenrobot.*;
import nextgen.templates.java.ClassOrInterfaceType;

public class GreenRobotPatterns extends GreenRobotST {

   public static Event newStaticEvent(String name) {
      return newEvent()
            .setIsStatic(true)
            .setName(name);
   }

   public static Subscribe newSubscribe(Event event, ClassOrInterfaceType eventManagerType) {
      return GreenRobotPatterns.newSubscribe()
            .setEventName(event.getName())
            .setEventType(eventManagerType + "." + event.getName());
   }

   public static PostEventMethod newPostEventMethod(Event event) {
      final PostEventMethod postEventMethod = GreenRobotPatterns.newPostEventMethod()
            .setEventName(event.getName());
      event.streamFields().forEach(event_fields ->
            postEventMethod.addParameters(event_fields.getType(), event_fields.getName().toString()));
      return postEventMethod;
   }

   public static CallPostEventMethod newCallPostEventMethod(Event event, ClassOrInterfaceType eventManagerType) {
      return newCallPostEventMethod()
            .setEventManager(eventManagerType.toString())
            .setEvent(event.getName());
   }
}