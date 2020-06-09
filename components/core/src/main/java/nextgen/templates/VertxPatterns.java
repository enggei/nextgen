package nextgen.templates;

import nextgen.st.STGenerator;
import nextgen.templates.vertx.JsonWrapper;

import java.io.File;

public class VertxPatterns {

    public static void writeJsonWrapper(File root, JsonWrapper jsonWrapper) {
        STGenerator.writeToFile(jsonWrapper, jsonWrapper.getPackage(), jsonWrapper.getName(), "java", root);
    }
}