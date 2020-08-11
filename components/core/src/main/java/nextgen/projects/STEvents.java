package nextgen.projects;

import nextgen.st.STGenerator;
import nextgen.st.STModelCanvas;
import nextgen.templates.greenrobot.Event;
import nextgen.templates.greenrobot.EventManager;
import nextgen.templates.greenrobot.PostEventMethod;
import nextgen.utils.StringUtil;

import java.io.File;

import static nextgen.templates.greenrobot.GreenRobotST.*;

public class STEvents {

    public static void main(String[] args) {

        final EventManager eventManager = newEventManager()
                .setPackage("nextgen.st")
                .setName("STAppEvents");

        final Class<?>[] modelEntities = {
                nextgen.st.model.Project.class,
                nextgen.st.model.STModel.class,
                nextgen.st.model.STValue.class,
                nextgen.st.model.Script.class,
                nextgen.st.domain.STTemplate.class
        };

        for (Class<?> modelEntity : modelEntities) {
            addEvent(eventManager, newEvent()
                    .setName("New" + modelEntity.getSimpleName())
                    .addFields(modelEntity.getCanonicalName(), StringUtil.lowFirst(modelEntity.getSimpleName()))
            );

            addEvent(eventManager, newEvent()
                    .setName("Removed" + modelEntity.getSimpleName())
                    .addFields(String.class.getCanonicalName(), "uuid")
            );

            addEvent(eventManager, newEvent()
                    .setName("Open" + modelEntity.getSimpleName())
                    .addFields(modelEntity.getCanonicalName(), StringUtil.lowFirst(modelEntity.getSimpleName()))
            );
        }

        addEvent(eventManager, newEvent()
                .setName("STModelArgumentRemoved")
                .addFields(nextgen.st.model.STModel.class.getCanonicalName(), "stModel")
                .addFields(nextgen.st.model.STArgument.class.getCanonicalName(), "stArgument")
        );

        final String[] canvasEvents = {
                "NodeAddedToCanvas",
                "NodeClosed"
        };

        for (String canvasEvent : canvasEvents) {
            addEvent(eventManager, newEvent()
                    .setName(canvasEvent)
                    .addFields(STModelCanvas.class.getCanonicalName(), "canvas")
                    .addFields(String.class.getCanonicalName(), "node")
            );
        }

        STGenerator.writeJavaFile(eventManager, eventManager.getPackage(), eventManager.getName(), new File("/home/goe/projects/nextgen/components/core/src/main/java"));
    }

    private static void addEvent(EventManager eventManager, Event event) {

        event.setIsStatic(true);
        final PostEventMethod postMethod = newPostEventMethod().setEventName(event.getName());
        event.streamFields().forEach(event_fields -> postMethod.addParameters(event_fields.getType(), event_fields.getName()));

        eventManager.addEvents(event, postMethod);

        System.out.println(newSubscribe()
                .setEventType(eventManager.getPackage() + "." + eventManager.getName() + "." + event.getName())
                .setEventName(event.getName()));

    }
}