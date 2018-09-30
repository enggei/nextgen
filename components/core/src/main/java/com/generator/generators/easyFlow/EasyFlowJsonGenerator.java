package com.generator.generators.easyFlow;

import com.generator.util.StringUtil;
import com.nextgen.core.GeneratedFile;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class EasyFlowJsonGenerator {

    private final EasyFlowGroup group = new EasyFlowGroup();

    public static void main(String[] args) throws IOException {

        final JsonObject fsm = new JsonObject().
                put("name", "JsonSchemaFSM").
                put("packageName", "com.generator.generators.jsonschema").
                put("context_properties", new JsonArray().
                        add(new JsonObject().put("name", "uuid").put("type", "java.util.UUID").put("comments", "unique id").put("scope", "public"))).
                put("from", new JsonObject().
                        put("name", "init").
                        put("outgoing", new JsonArray().
                                add(new JsonObject().
                                        put("name", "properties").
                                        put("finish", new JsonObject().put("name", "endState")))));

        new EasyFlowJsonGenerator().generate(fsm, "/home/goe/projects/nextgen/components/core/src/main/java");

    }

    private void generate(JsonObject fsm, String root) throws IOException {

        final Set<String> events = new TreeSet<>();
        final Set<String> states = new TreeSet<>();
        final Map<String, String> stateComments = new LinkedHashMap<>();

        final EasyFlowGroup.transitST transitST = group.newtransit().
                setIsInit("true").
                setIsFinish("false");

        final JsonObject initStateNode = fsm.getJsonObject("from");
        final String initStateName = StringUtil.toUpper(initStateNode.getString("name"));
        expand(initStateNode, transitST.setState(initStateName), group, events, states, stateComments);

        final EasyFlowGroup.eventsST eventsST = group.newevents();
        for (String event : events) eventsST.addEventsValue(event);

        final EasyFlowGroup.statesST statesST = group.newstates();
        for (String state : states)
            statesST.addStatesValue(group.newstateDeclaration().
                    setName(state).
                    setComment(stateComments.getOrDefault(state, null)));

        final EasyFlowGroup.statefulContextST contextST = group.newstatefulContext().
                setName(fsm.getString("name"));

        final JsonArray contextProperties = fsm.getJsonArray("context_properties", new JsonArray());
        for (Object cp : contextProperties) {
            final JsonObject contextProperty = (JsonObject) cp;
            contextST.addPropertiesValue(contextProperty.getString("comment", ""), contextProperty.getString("modifier", ""), contextProperty.getString("name"), contextProperty.getString("type"), formatPropertyValue(contextProperty.getString("value", null)));
        }

        final EasyFlowGroup.easyFlowST easyFlowST = group.neweasyFlow().
                setName(fsm.getString("name")).
                setPackage(fsm.getString("packageName")).
                setContext(contextST).
                setStates(statesST).
                setEvents(eventsST).
                setTransit(transitST);

        group.getSTGroup().getInstanceOf("easyFLow");

        easyFlowST.setExtends(fsm.getString("extends", null));

        for (String state : states) {
            easyFlowST.addBindingsValue(
                    group.newdeclaration().
                            setName(fsm.getString("name")).
                            setState(state),
                    group.newimpl().
                            setName(fsm.getString("name")).
                            setState(state));
        }

        GeneratedFile.newJavaFile(root, fsm.getString("packageName"), fsm.getString("name")).write(easyFlowST);
    }

    private Object formatPropertyValue(Object value) {
        if (value == null) return null;
        // non-null
        final String t = value.toString();
        return t.replaceAll("\\\\", "");
    }

    private void expand(JsonObject state, final EasyFlowGroup.transitST parent, EasyFlowGroup group, Set<String> events, Set<String> states, Map<String, String> stateComments) {

        final String stateName = StringUtil.toUpper(state.getString("name"));
        if (states.contains(stateName)) return;
        states.add(stateName);

        if (state.getString("comments", null) != null)
            stateComments.put(stateName, state.getString("comments"));

        final JsonArray outgoing = state.getJsonArray("outgoing");
        if (outgoing == null) {
            parent.setIsFinish("true");
            return;
        }

        for (Object o : outgoing) {
            final JsonObject event = (JsonObject) o;
            events.add(event.getString("name"));

            JsonObject newState = event.getJsonObject("to");
            if (newState == null) newState = event.getJsonObject("finish");

            final EasyFlowGroup.transitST transit = group.newtransit().
                    setEvent(event.getString("name")).
                    setState(StringUtil.toUpper(newState.getString("name")));
            expand(newState, transit, group, events, states, stateComments);
            parent.addTransitsValue(transit);
        }
    }
}