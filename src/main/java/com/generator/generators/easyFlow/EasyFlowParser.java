package com.generator.generators.easyFlow;

import com.generator.generators.easyFlow.domain.*;
import com.generator.generators.java.parser.JavaParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * goe on 12/29/14.
 */
public class EasyFlowParser extends JavaParser {

	private String targetFile;
	private String fsmPackage;
	private String fsmName;
	private String fsmExtends;
	private String contextName;

	private final List<EasyFlowContextProperty> contextProperties = new ArrayList<>();
	private final Map<String, EasyFlowState> states = new LinkedHashMap<>();
	private final Map<String, EasyFlowEvent> events = new LinkedHashMap<>();

	private final Stack<String> currentStates = new Stack<>();
	private final Stack<String> currentEvents = new Stack<>();
	private final Map<String, Map<EasyFlowEvent, EasyFlowTransition>> transitions = new LinkedHashMap<>();

	private EasyFlowFSM easyFlowFSM = new EasyFlowFSM() {

		private final UUID easyFlowUUID = UUID.randomUUID();

		@Override
		public String getName() {
			return fsmName;
		}

		@Override
		public String getPackage() {
			return fsmPackage;
		}

		@Override
		public String getExtends() {
			return fsmExtends;
		}

		@Override
		public String getTargetFile() {
			return targetFile;
		}

		@Override
		public String getContextName() {
			return contextName;
		}

		@Override
		public List<EasyFlowContextProperty> getContextProperties() {
			return contextProperties;
		}

		@Override
		public Map<String, EasyFlowState> getStates() {
			return states;
		}

		@Override
		public Map<String, EasyFlowEvent> getEvents() {
			return events;
		}

		@Override
		public UUID getUuid() {
			return easyFlowUUID;
		}

		@Override
		public EasyFlowDomain.ENTITIES getDomainType() {
			return EasyFlowDomain.ENTITIES.Flow;
		}
	};

	public EasyFlowParser(File sourceFile) throws IOException {
		super(createLexer(new FileReader(sourceFile)));
		this.targetFile = sourceFile.getAbsolutePath();
		compilationUnit();
	}

	public EasyFlowFSM getEasyFlowFSM() {
		return easyFlowFSM;
	}

	@Override
	public void packageName(String name) {
		this.fsmPackage = name;
	}

	@Override
	public void className(String modifier, String name) {
		if (this.fsmName == null)
			this.fsmName = name;
		else if (this.contextName == null)
			this.contextName = name;
	}

	@Override
	public void classExtends(String name) {
		if (this.fsmExtends == null)
			this.fsmExtends = name;
	}

	@Override
	public void newStatement(String statement) {
		if (statement.contains("from("))
			parseTransitions(statement, statement.indexOf("from("));
	}

	@Override
	public void newField(final String modifier, final String type, final String name, final String initalizer) {
		if ("log".equals(name) && "Logger".equals(type)) return;

		// context-fields:
		final String formattedInitializer = (initalizer == null || !initalizer.startsWith("new")) ? initalizer : ("new " + initalizer.substring(3));

		if (type.contains("<" + contextName + ">")) return;
		if (type.equals(fsmName + "Listener")) return;

		final UUID uuid = UUID.randomUUID();

		contextProperties.add(new EasyFlowContextProperty() {

			@Override
			public UUID getUuid() {
				return uuid;
			}

			@Override
			public EasyFlowDomain.ENTITIES getDomainType() {
				return EasyFlowDomain.ENTITIES.ContextProperty;
			}

			@Override
			public String getName() {
				return name;
			}

			@Override
			public String getModifier() {
				return modifier;
			}

			@Override
			public String getType() {
				return type;
			}

			@Override
			public String getInitializer() {
				return formattedInitializer == null ? null : (formattedInitializer.startsWith("\"") ? ("\\" + formattedInitializer.substring(0, formattedInitializer.length() - 1) + "\\\"") : formattedInitializer);
			}
		});
	}

	private void parseTransitions(String statement, int from) {
		final String[] t = statement.substring(from).replaceAll("[.,]", " ").split("[\\(\\)]");

		for (int i = 0; i < t.length; i++) {
			String s = t[i].trim();
//            System.out.println(s);

			if (s.length() == 0 && !currentStates.empty()) {
				currentStates.pop();

			} else if (s.startsWith("from")) {

				final UUID uuid = UUID.randomUUID();
				final String name = t[++i];

				addState(uuid, name, true);

			} else if (s.startsWith("on")) {

				final UUID uuid = UUID.randomUUID();
				final String eventName = t[++i];

				addEvent(uuid, eventName);

			} else if (s.startsWith("to")) {

				final String src = currentStates.peek();

				final UUID uuid = UUID.randomUUID();
				final String stateName = t[++i];

				addState(uuid, stateName, false);
				final String dst = currentStates.peek();
				final String event = currentEvents.peek();

				addTransition(src, dst, event, false);

				if (!t[i + 1].contains("transit"))
					currentStates.pop();

			} else if (s.startsWith("finish")) {

				final String src = currentStates.peek();

				final UUID uuid = UUID.randomUUID();
				final String stateName = t[++i];

				addState(uuid, stateName, false);
				final String dst = currentStates.peek();
				final String event = currentEvents.peek();

				addTransition(src, dst, event, true);   // make transition

				currentStates.pop();   // last state: pop from stack
			}
		}
	}

	private void addTransition(final String src, final String dst, final String event, final boolean isEndState) {
		transitions.get(src).put(events.get(event), new EasyFlowTransition() {

			@Override
			public boolean isEndState() {
				return isEndState;
			}

			@Override
			public EasyFlowState getStart() {
				return states.get(src);
			}

			@Override
			public EasyFlowState getEnd() {
				return states.get(dst);
			}

			@Override
			public EasyFlowEvent getEvent() {
				return events.get(event);
			}
		});
	}

	private void addEvent(final UUID uuid, final String name) {
//        System.out.println("\t" + states.get(currentStates.peek()) + " -> " + name);

		final EasyFlowEvent event = getEventByName(name);

		final String key = "event_" + (event == null ? uuid : event.getUuid());
		currentEvents.push(key);

		if (event != null) return;

		this.events.put(key, new EasyFlowEvent() {
			@Override
			public String getName() {
				return name;
			}

			@Override
			public UUID getUuid() {
				return uuid;
			}

			@Override
			public EasyFlowDomain.ENTITIES getDomainType() {
				return EasyFlowDomain.ENTITIES.Event;
			}

			@Override
			public String toString() {
				return name;
			}
		});
	}

	private EasyFlowEvent getEventByName(String name) {
		for (EasyFlowEvent event : events.values())
			if (event.getName().equals(name)) return event;
		return null;
	}

	private void addState(final UUID uuid, final String name, final boolean isInitialState) {
//        System.out.println("\t" + name);

		final EasyFlowState state = getStateByName(name);

		final String key = "state_" + (state == null ? uuid : state.getUuid());
		currentStates.push(key);
		if (state != null) return;

		transitions.put(key, new LinkedHashMap<EasyFlowEvent, EasyFlowTransition>());

		this.states.put(key, new EasyFlowState() {
			@Override
			public String getName() {
				return name;
			}

			public boolean isInitialState() {
				return isInitialState;
			}

			@Override
			public Map<EasyFlowEvent, EasyFlowTransition> getTransitions() {
				return transitions.get(key);
			}

			@Override
			public UUID getUuid() {
				return uuid;
			}

			@Override
			public EasyFlowDomain.ENTITIES getDomainType() {
				return EasyFlowDomain.ENTITIES.State;
			}

			@Override
			public String toString() {
				return name;
			}
		});
	}

	private EasyFlowState getStateByName(String name) {
		for (EasyFlowState state : states.values())
			if (state.getName().equals(name)) return state;
		return null;
	}
}