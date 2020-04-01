package com.nextgen.core.template;

import com.nextgen.core.JsonCanvas;
import com.nextgen.core.NodeCanvas;
import io.vertx.core.http.WebSocket;
import io.vertx.core.http.WebSocketFrame;
import org.piccolo2d.event.PInputEvent;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.*;

public class TemplateRemoteCanvas extends JsonCanvas {

	private final String uuid = UUID.randomUUID().toString();
	private final Vertx vertx;
	private final Integer port;
	private final String host;

	public TemplateRemoteCanvas(Vertx vertx, Integer port, String host) {
		this.vertx = vertx;
		this.port = port;
		this.host = host;
	}

	@Override
	protected void addContextMenuActions(PInputEvent event, JPopupMenu pop, Set<BasePNode> selectedNodes, Point mousePosition, NodeCanvas canvas) {

		final JMenu mnuOpen = new JMenu("Open");
				// default actions 
		pop.add(new SwingAction("New STGroup") {
			@Override
			protected void onActionPerformed(java.awt.event.ActionEvent e) {

				final STGroupForm projectForm = new STGroupForm();
				projectForm.show(canvas, new ConfirmAction() {
					@Override
					public void verifyAndCommit() throws Exception {
						newSTGroup(projectForm.getSTGroup(), new STGroupHandler() {
							@Override
							public void onSuccess(STGroup project) {
								addNode(newSTGroupNode(project.toJson()), new LayoutAtPosition(mousePosition));
							}
						});
					}
				});
			}
		});

		mnuOpen.add(new SwingAction("Open STGroup") {
			@Override
			protected void onActionPerformed(java.awt.event.ActionEvent e) {
				getAllSTGroup();
			}
		});

				pop.add(mnuOpen);

		super.addContextMenuActions(event, pop, selectedNodes, mousePosition, canvas);
	}

	@Override
	protected void onKeyPressed(PInputEvent event) {

		switch (event.getKeyCode()) {
			case KeyEvent.VK_E:
				if (event.isControlDown()) {
					getAllSTGroup();
				}
				return;

		}

		super.onKeyPressed(event);
	}

	// NODES

	public STGroupNode newSTGroupNode(JsonObject jsonObject) {
		return new STGroupNode(jsonObject);
	}

	class STGroupNode extends JsonPNode {

		STGroupNode(JsonObject sTGroup) {
			super(sTGroup, "name", Color.decode("#3690c0"), Color.decode("#e31a1c"), Color.decode("#e31a1c"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final STGroupForm form = new STGroupForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateSTGroup(form.getSTGroup(), new STGroupHandler() {
								@Override
								public void onSuccess(STGroup updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});

			// ONE 'STGroup' (STGroup) -> TEMPLATE -> MANY 'STTemplate' (STTemplate)
			final JMenu TEMPLATEMenu = new JMenu("TEMPLATE");

			TEMPLATEMenu.add(new SwingAction("Get All TEMPLATE") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_STTemplate_TEMPLATE_FOR_STGroup(getUUID(), new ExpandSTTemplate_TEMPLATE_FOR_STGroupHandler(getThis()));
				}
			});

			TEMPLATEMenu.add(new SwingAction("Add STTemplate") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_STTemplate_TEMPLATE_FOR_STGroup(getThis(), canvas);
				}
			});

			if (TEMPLATEMenu.getMenuComponentCount() != 0) pop.add(TEMPLATEMenu);



			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
					// ONE 'STGroup' (STGroup) -> TEMPLATE -> MANY 'STTemplate' (STTemplate)
					if (event.isControlDown()) get_STTemplate_TEMPLATE_FOR_STGroup(getUUID(), new ExpandSTTemplate_TEMPLATE_FOR_STGroupHandler(getThis()));

				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// Template STGroup
	protected final class STGroupForm extends JPanel {

		private final String title = "New STGroup";
		private final PropertyComponent delimiterComponent = new PropertyComponent("String");
		private final PropertyComponent nameComponent = new PropertyComponent("String");
		private String uuid;

		protected STGroupForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu,pref,4dlu");
			form.addLabel(Template.Properties.delimiter.name(), c, r);
			c += 2;
			form.add(delimiterComponent.getComponent(), c, r);

			r +=2;
			c = 1;
			form.addLabel(Template.Properties.name.name(), c, r);
			c += 2;
			form.add(nameComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected STGroupForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			delimiterComponent.setValue(content.getValue("delimiter"));
			nameComponent.setValue(content.getValue("name"));
		}

		public PropertyComponent getDelimiterComponent() {
			return delimiterComponent;
		}

		protected STGroupForm setDelimiterValue(String delimiter) {
			delimiterComponent.setValue(delimiter);
			return this;
		}

		protected <T> T getDelimiterValue() {
			return delimiterComponent.getValue();
		}


		public PropertyComponent getNameComponent() {
			return nameComponent;
		}

		protected STGroupForm setNameValue(String name) {
			nameComponent.setValue(name);
			return this;
		}

		protected <T> T getNameValue() {
			return nameComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("delimiter", (String) getDelimiterValue())
				.put("name", (String) getNameValue());}

		protected STGroup getSTGroup() {
			final JsonObject jsonObject = new JsonObject()
				.put("delimiter", (String) getDelimiterValue())
				.put("name", (String) getNameValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapSTGroup(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void newSTGroup(String delimiter, String name, STGroupHandler handler) {
		final JsonObject parameters = new JsonObject().
			put("delimiter", delimiter).
			put("name", name);
		newSTGroup(mapSTGroup(parameters), handler);
	}

	void newSTGroup(STGroup parameters, STGroupHandler handler) {
		send("template.new.sTGroup", new JsonObject().put("STGroup", parameters.toJson()), handler);
	}


	public STGroup newSTGroup(String delimiter, String name) {
		return newSTGroup(new JsonObject().
			put("delimiter", delimiter).
			put("name", name));
	}

	public STGroup newSTGroup(JsonObject parameters) {
		return mapSTGroup(parameters);
	}

	public void updateSTGroup(STGroup sTGroup, STGroupHandler handler) {
		send("template.update.sTGroup", new JsonObject().put("uuid", sTGroup.getUUID().toString()).put("STGroup", sTGroup.toJson()), handler);
	}

	public void deleteSTGroup(UUID uuid,  DeleteHandler handler) {
		send("template.delete.sTGroup", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getSTGroup(UUID uuid, STGroupHandler handler) {
		send("template.get.sTGroup", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllSTGroup(STGroupListHandler handler) {
		send("template.get.all.sTGroup", new JsonObject(), handler);
	}

	public static abstract class STGroupListHandler extends ListHandler<STGroup> {

		@Override
		protected STGroup map(JsonObject jsonObject) {
			return mapSTGroup(jsonObject);
		}
	}

	public static abstract class STGroupHandler extends MessageHandler {

		public abstract void onSuccess(STGroup sTGroup);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapSTGroup(payload));
		}
	}

	interface STGroup {

		enum Properties {
			delimiter,
			name
		}


		UUID getUUID();

		JsonObject toJson();

		String getDelimiter();

		STGroup setDelimiter(String delimiter);

		String getName();

		STGroup setName(String name);

	}

	private static STGroup mapSTGroup(JsonObject payload) {
		return new STGroup() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public String getDelimiter() {
				return payload.getString("delimiter");
			}

			@Override
			public STGroup setDelimiter(String delimiter) {
				payload.put("delimiter", delimiter);
				return this;
			}

			@Override
			public String getName() {
				return payload.getString("name");
			}

			@Override
			public STGroup setName(String name) {
				payload.put("name", name);
				return this;
			}

		};
	}

	protected void getAllSTGroup() {
		getAllSTGroup(new STGroupListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<STGroup> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newSTGroupNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	public STTemplateNode newSTTemplateNode(JsonObject jsonObject) {
		return new STTemplateNode(jsonObject);
	}

	class STTemplateNode extends JsonPNode {

		STTemplateNode(JsonObject sTTemplate) {
			super(sTTemplate, "name", Color.decode("#3690c0"), Color.decode("#e31a1c"), Color.decode("#e31a1c"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final STTemplateForm form = new STTemplateForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateSTTemplate(form.getSTTemplate(), new STTemplateHandler() {
								@Override
								public void onSuccess(STTemplate updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});

			// ONE 'srcSTTemplate' (STTemplate) -> CHILD_TEMPLATE -> MANY 'STTemplate' (STTemplate)
			final JMenu CHILD_TEMPLATEMenu = new JMenu("CHILD_TEMPLATE");

			CHILD_TEMPLATEMenu.add(new SwingAction("Get All CHILD_TEMPLATE") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_STTemplate_CHILD_TEMPLATE_FOR_SrcSTTemplate(getUUID(), new ExpandSTTemplate_CHILD_TEMPLATE_FOR_SrcSTTemplateHandler(getThis()));
				}
			});

			CHILD_TEMPLATEMenu.add(new SwingAction("Add STTemplate") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_STTemplate_CHILD_TEMPLATE_FOR_SrcSTTemplate(getThis(), canvas);
				}
			});

			if (CHILD_TEMPLATEMenu.getMenuComponentCount() != 0) pop.add(CHILD_TEMPLATEMenu);


			// ONE 'STTemplate' (STTemplate) -> PARAMETER -> MANY 'STTemplateParameter' (STTemplateParameter)
			final JMenu PARAMETERMenu = new JMenu("PARAMETER");

			PARAMETERMenu.add(new SwingAction("Get All PARAMETER") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_STTemplateParameter_PARAMETER_FOR_STTemplate(getUUID(), new ExpandSTTemplateParameter_PARAMETER_FOR_STTemplateHandler(getThis()));
				}
			});

			PARAMETERMenu.add(new SwingAction("Add STTemplateParameter") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_STTemplateParameter_PARAMETER_FOR_STTemplate(getThis(), canvas);
				}
			});

			if (PARAMETERMenu.getMenuComponentCount() != 0) pop.add(PARAMETERMenu);



			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
					// ONE 'srcSTTemplate' (STTemplate) -> CHILD_TEMPLATE -> MANY 'STTemplate' (STTemplate)
					if (event.isControlDown()) get_STTemplate_CHILD_TEMPLATE_FOR_SrcSTTemplate(getUUID(), new ExpandSTTemplate_CHILD_TEMPLATE_FOR_SrcSTTemplateHandler(getThis()));

					// ONE 'STTemplate' (STTemplate) -> PARAMETER -> MANY 'STTemplateParameter' (STTemplateParameter)
					if (event.isControlDown()) get_STTemplateParameter_PARAMETER_FOR_STTemplate(getUUID(), new ExpandSTTemplateParameter_PARAMETER_FOR_STTemplateHandler(getThis()));

				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// Template STTemplate
	protected final class STTemplateForm extends JPanel {

		private final String title = "New STTemplate";
		private final PropertyComponent textComponent = new PropertyComponent("String");
		private final PropertyComponent nameComponent = new PropertyComponent("String");
		private String uuid;

		protected STTemplateForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu,pref,4dlu");
			form.addLabel(Template.Properties.text.name(), c, r);
			c += 2;
			form.add(textComponent.getComponent(), c, r);

			r +=2;
			c = 1;
			form.addLabel(Template.Properties.name.name(), c, r);
			c += 2;
			form.add(nameComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected STTemplateForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			textComponent.setValue(content.getValue("text"));
			nameComponent.setValue(content.getValue("name"));
		}

		public PropertyComponent getTextComponent() {
			return textComponent;
		}

		protected STTemplateForm setTextValue(String text) {
			textComponent.setValue(text);
			return this;
		}

		protected <T> T getTextValue() {
			return textComponent.getValue();
		}


		public PropertyComponent getNameComponent() {
			return nameComponent;
		}

		protected STTemplateForm setNameValue(String name) {
			nameComponent.setValue(name);
			return this;
		}

		protected <T> T getNameValue() {
			return nameComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("text", (String) getTextValue())
				.put("name", (String) getNameValue());}

		protected STTemplate getSTTemplate() {
			final JsonObject jsonObject = new JsonObject()
				.put("text", (String) getTextValue())
				.put("name", (String) getNameValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapSTTemplate(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public STTemplate newSTTemplate(String text, String name) {
		return newSTTemplate(new JsonObject().
			put("text", text).
			put("name", name));
	}

	public STTemplate newSTTemplate(JsonObject parameters) {
		return mapSTTemplate(parameters);
	}

	public void updateSTTemplate(STTemplate sTTemplate, STTemplateHandler handler) {
		send("template.update.sTTemplate", new JsonObject().put("uuid", sTTemplate.getUUID().toString()).put("STTemplate", sTTemplate.toJson()), handler);
	}

	public void deleteSTTemplate(UUID uuid,  DeleteHandler handler) {
		send("template.delete.sTTemplate", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getSTTemplate(UUID uuid, STTemplateHandler handler) {
		send("template.get.sTTemplate", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllSTTemplate(STTemplateListHandler handler) {
		send("template.get.all.sTTemplate", new JsonObject(), handler);
	}

	public static abstract class STTemplateListHandler extends ListHandler<STTemplate> {

		@Override
		protected STTemplate map(JsonObject jsonObject) {
			return mapSTTemplate(jsonObject);
		}
	}

	public static abstract class STTemplateHandler extends MessageHandler {

		public abstract void onSuccess(STTemplate sTTemplate);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapSTTemplate(payload));
		}
	}

	interface STTemplate {

		enum Properties {
			text,
			name
		}


		UUID getUUID();

		JsonObject toJson();

		String getText();

		STTemplate setText(String text);

		String getName();

		STTemplate setName(String name);

	}

	private static STTemplate mapSTTemplate(JsonObject payload) {
		return new STTemplate() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public String getText() {
				return payload.getString("text");
			}

			@Override
			public STTemplate setText(String text) {
				payload.put("text", text);
				return this;
			}

			@Override
			public String getName() {
				return payload.getString("name");
			}

			@Override
			public STTemplate setName(String name) {
				payload.put("name", name);
				return this;
			}

		};
	}

	protected void getAllSTTemplate() {
		getAllSTTemplate(new STTemplateListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<STTemplate> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newSTTemplateNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	public STTemplateParameterNode newSTTemplateParameterNode(JsonObject jsonObject) {
		return new STTemplateParameterNode(jsonObject);
	}

	class STTemplateParameterNode extends JsonPNode {

		STTemplateParameterNode(JsonObject sTTemplateParameter) {
			super(sTTemplateParameter, "name", Color.decode("#3690c0"), Color.decode("#e31a1c"), Color.decode("#e31a1c"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final STTemplateParameterForm form = new STTemplateParameterForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateSTTemplateParameter(form.getSTTemplateParameter(), new STTemplateParameterHandler() {
								@Override
								public void onSuccess(STTemplateParameter updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});

			// ONE 'STTemplateParameter' (STTemplateParameter) -> KEY_VALUE -> MANY 'STKeyValue' (STKeyValue)
			final JMenu KEY_VALUEMenu = new JMenu("KEY_VALUE");

			KEY_VALUEMenu.add(new SwingAction("Get All KEY_VALUE") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_STKeyValue_KEY_VALUE_FOR_STTemplateParameter(getUUID(), new ExpandSTKeyValue_KEY_VALUE_FOR_STTemplateParameterHandler(getThis()));
				}
			});

			KEY_VALUEMenu.add(new SwingAction("Add STKeyValue") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_STKeyValue_KEY_VALUE_FOR_STTemplateParameter(getThis(), canvas);
				}
			});

			if (KEY_VALUEMenu.getMenuComponentCount() != 0) pop.add(KEY_VALUEMenu);



			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
					// ONE 'STTemplateParameter' (STTemplateParameter) -> KEY_VALUE -> MANY 'STKeyValue' (STKeyValue)
					if (event.isControlDown()) get_STKeyValue_KEY_VALUE_FOR_STTemplateParameter(getUUID(), new ExpandSTKeyValue_KEY_VALUE_FOR_STTemplateParameterHandler(getThis()));

				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// Template STTemplateParameter
	protected final class STTemplateParameterForm extends JPanel {

		private final String title = "New STTemplateParameter";
		private final PropertyComponent parameterTypeComponent = new PropertyComponent(STTemplateParameter.ParameterType.values());
		private final PropertyComponent nameComponent = new PropertyComponent("String");
		private String uuid;

		protected STTemplateParameterForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu,pref,4dlu");
			form.addLabel(Template.Properties.parameterType.name(), c, r);
			c += 2;
			form.add(parameterTypeComponent.getComponent(), c, r);

			r +=2;
			c = 1;
			form.addLabel(Template.Properties.name.name(), c, r);
			c += 2;
			form.add(nameComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected STTemplateParameterForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			parameterTypeComponent.setValue(content.getValue("parameterType"));
			nameComponent.setValue(content.getValue("name"));
		}

		public PropertyComponent getParameterTypeComponent() {
			return parameterTypeComponent;
		}

		protected STTemplateParameterForm setParameterTypeValue(STTemplateParameter.ParameterType parameterType) {
			parameterTypeComponent.setValue(parameterType);
			return this;
		}

		protected <T> T getParameterTypeValue() {
			return parameterTypeComponent.getValue();
		}


		public PropertyComponent getNameComponent() {
			return nameComponent;
		}

		protected STTemplateParameterForm setNameValue(String name) {
			nameComponent.setValue(name);
			return this;
		}

		protected <T> T getNameValue() {
			return nameComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("ParameterType", (STTemplateParameter.ParameterType) getParameterTypeValue())
				.put("name", (String) getNameValue());}

		protected STTemplateParameter getSTTemplateParameter() {
			final JsonObject jsonObject = new JsonObject()
				.put("ParameterType", (STTemplateParameter.ParameterType) getParameterTypeValue())
				.put("name", (String) getNameValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapSTTemplateParameter(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public STTemplateParameter newSTTemplateParameter(STTemplateParameter.ParameterType ParameterType, String name) {
		return newSTTemplateParameter(new JsonObject().
			put("ParameterType", ParameterType.name()).
			put("name", name));
	}

	public STTemplateParameter newSTTemplateParameter(JsonObject parameters) {
		return mapSTTemplateParameter(parameters);
	}

	public void updateSTTemplateParameter(STTemplateParameter sTTemplateParameter, STTemplateParameterHandler handler) {
		send("template.update.sTTemplateParameter", new JsonObject().put("uuid", sTTemplateParameter.getUUID().toString()).put("STTemplateParameter", sTTemplateParameter.toJson()), handler);
	}

	public void deleteSTTemplateParameter(UUID uuid,  DeleteHandler handler) {
		send("template.delete.sTTemplateParameter", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getSTTemplateParameter(UUID uuid, STTemplateParameterHandler handler) {
		send("template.get.sTTemplateParameter", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllSTTemplateParameter(STTemplateParameterListHandler handler) {
		send("template.get.all.sTTemplateParameter", new JsonObject(), handler);
	}

	public static abstract class STTemplateParameterListHandler extends ListHandler<STTemplateParameter> {

		@Override
		protected STTemplateParameter map(JsonObject jsonObject) {
			return mapSTTemplateParameter(jsonObject);
		}
	}

	public static abstract class STTemplateParameterHandler extends MessageHandler {

		public abstract void onSuccess(STTemplateParameter sTTemplateParameter);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapSTTemplateParameter(payload));
		}
	}

	interface STTemplateParameter {

		enum Properties {
			parameterType,
			name
		}

		enum ParameterType { KEYVALUELISTPROPERTY, LISTPROPERTY, STRINGPROPERTY } 

		UUID getUUID();

		JsonObject toJson();

		ParameterType getParameterType();

		STTemplateParameter setParameterType(ParameterType parameterType);

		String getName();

		STTemplateParameter setName(String name);

	}

	private static STTemplateParameter mapSTTemplateParameter(JsonObject payload) {
		return new STTemplateParameter() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public ParameterType getParameterType() {
				return ParameterType.valueOf(payload.getString("parameterType"));
			}

			@Override
			public STTemplateParameter setParameterType(ParameterType parameterType) {
				payload.put("ParameterType", parameterType.name());
				return this;
			}

			@Override
			public String getName() {
				return payload.getString("name");
			}

			@Override
			public STTemplateParameter setName(String name) {
				payload.put("name", name);
				return this;
			}

		};
	}

	protected void getAllSTTemplateParameter() {
		getAllSTTemplateParameter(new STTemplateParameterListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<STTemplateParameter> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newSTTemplateParameterNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	public STKeyValueNode newSTKeyValueNode(JsonObject jsonObject) {
		return new STKeyValueNode(jsonObject);
	}

	class STKeyValueNode extends JsonPNode {

		STKeyValueNode(JsonObject sTKeyValue) {
			super(sTKeyValue, "name", Color.decode("#3690c0"), Color.decode("#e31a1c"), Color.decode("#e31a1c"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final STKeyValueForm form = new STKeyValueForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateSTKeyValue(form.getSTKeyValue(), new STKeyValueHandler() {
								@Override
								public void onSuccess(STKeyValue updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});


			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// Template STKeyValue
	protected final class STKeyValueForm extends JPanel {

		private final String title = "New STKeyValue";
		private final PropertyComponent nameComponent = new PropertyComponent("String");
		private String uuid;

		protected STKeyValueForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu");
			form.addLabel(Template.Properties.name.name(), c, r);
			c += 2;
			form.add(nameComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected STKeyValueForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			nameComponent.setValue(content.getValue("name"));
		}

		public PropertyComponent getNameComponent() {
			return nameComponent;
		}

		protected STKeyValueForm setNameValue(String name) {
			nameComponent.setValue(name);
			return this;
		}

		protected <T> T getNameValue() {
			return nameComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("name", (String) getNameValue());}

		protected STKeyValue getSTKeyValue() {
			final JsonObject jsonObject = new JsonObject()
				.put("name", (String) getNameValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapSTKeyValue(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public STKeyValue newSTKeyValue(String name) {
		return newSTKeyValue(new JsonObject().
			put("name", name));
	}

	public STKeyValue newSTKeyValue(JsonObject parameters) {
		return mapSTKeyValue(parameters);
	}

	public void updateSTKeyValue(STKeyValue sTKeyValue, STKeyValueHandler handler) {
		send("template.update.sTKeyValue", new JsonObject().put("uuid", sTKeyValue.getUUID().toString()).put("STKeyValue", sTKeyValue.toJson()), handler);
	}

	public void deleteSTKeyValue(UUID uuid,  DeleteHandler handler) {
		send("template.delete.sTKeyValue", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getSTKeyValue(UUID uuid, STKeyValueHandler handler) {
		send("template.get.sTKeyValue", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllSTKeyValue(STKeyValueListHandler handler) {
		send("template.get.all.sTKeyValue", new JsonObject(), handler);
	}

	public static abstract class STKeyValueListHandler extends ListHandler<STKeyValue> {

		@Override
		protected STKeyValue map(JsonObject jsonObject) {
			return mapSTKeyValue(jsonObject);
		}
	}

	public static abstract class STKeyValueHandler extends MessageHandler {

		public abstract void onSuccess(STKeyValue sTKeyValue);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapSTKeyValue(payload));
		}
	}

	interface STKeyValue {

		enum Properties {
			name
		}


		UUID getUUID();

		JsonObject toJson();

		String getName();

		STKeyValue setName(String name);

	}

	private static STKeyValue mapSTKeyValue(JsonObject payload) {
		return new STKeyValue() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public String getName() {
				return payload.getString("name");
			}

			@Override
			public STKeyValue setName(String name) {
				payload.put("name", name);
				return this;
			}

		};
	}

	protected void getAllSTKeyValue() {
		getAllSTKeyValue(new STKeyValueListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<STKeyValue> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newSTKeyValueNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	public ValueNode newValueNode(JsonObject jsonObject) {
		return new ValueNode(jsonObject);
	}

	class ValueNode extends JsonPNode {

		ValueNode(JsonObject value) {
			super(value, "value", Color.decode("#3690c0"), Color.decode("#e31a1c"), Color.decode("#e31a1c"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final ValueForm form = new ValueForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateValue(form.getValue(), new ValueHandler() {
								@Override
								public void onSuccess(Value updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});

			// MANY 'Value' (Value) -> PARAMETER_REFERENCE -> ONE 'STTemplateParameter' (STTemplateParameter)
			final JMenu PARAMETER_REFERENCEMenu = new JMenu("PARAMETER_REFERENCE");

			PARAMETER_REFERENCEMenu.add(new SwingAction("Get STTemplateParameter") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_STTemplateParameter_PARAMETER_REFERENCE_FOR_Value(getUUID(), new ExpandSTTemplateParameter_PARAMETER_REFERENCE_FOR_ValueHandler(getThis()));
				}
			});

			PARAMETER_REFERENCEMenu.add(new SwingAction("Set STTemplateParameter") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					set_STTemplateParameter_PARAMETER_REFERENCE_FOR_Value(getThis(), canvas);
				}
			});

			if (PARAMETER_REFERENCEMenu.getMenuComponentCount() != 0) pop.add(PARAMETER_REFERENCEMenu);


			// ONE 'srcValue' (Value) -> KV_VALUES -> MANY 'Value' (Value)
			final JMenu KV_VALUESMenu = new JMenu("KV_VALUES");

			KV_VALUESMenu.add(new SwingAction("Get All KV_VALUES") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_Value_KV_VALUES_FOR_SrcValue(getUUID(), new ExpandValue_KV_VALUES_FOR_SrcValueHandler(getThis()));
				}
			});

			KV_VALUESMenu.add(new SwingAction("Add Value") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_Value_KV_VALUES_FOR_SrcValue(getThis(), canvas);
				}
			});

			if (KV_VALUESMenu.getMenuComponentCount() != 0) pop.add(KV_VALUESMenu);


			// MANY 'Value' (Value) -> KEY_REFERENCE -> ONE 'STKeyValue' (STKeyValue)
			final JMenu KEY_REFERENCEMenu = new JMenu("KEY_REFERENCE");

			KEY_REFERENCEMenu.add(new SwingAction("Get STKeyValue") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_STKeyValue_KEY_REFERENCE_FOR_Value(getUUID(), new ExpandSTKeyValue_KEY_REFERENCE_FOR_ValueHandler(getThis()));
				}
			});

			KEY_REFERENCEMenu.add(new SwingAction("Set STKeyValue") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					set_STKeyValue_KEY_REFERENCE_FOR_Value(getThis(), canvas);
				}
			});

			if (KEY_REFERENCEMenu.getMenuComponentCount() != 0) pop.add(KEY_REFERENCEMenu);


			// MANY 'Value' (Value) -> INSTANCE_REFERENCE -> ONE 'STInstance' (STInstance)
			final JMenu INSTANCE_REFERENCEMenu = new JMenu("INSTANCE_REFERENCE");

			INSTANCE_REFERENCEMenu.add(new SwingAction("Get STInstance") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_STInstance_INSTANCE_REFERENCE_FOR_Value(getUUID(), new ExpandSTInstance_INSTANCE_REFERENCE_FOR_ValueHandler(getThis()));
				}
			});

			INSTANCE_REFERENCEMenu.add(new SwingAction("Set STInstance") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					set_STInstance_INSTANCE_REFERENCE_FOR_Value(getThis(), canvas);
				}
			});

			if (INSTANCE_REFERENCEMenu.getMenuComponentCount() != 0) pop.add(INSTANCE_REFERENCEMenu);



			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
					// MANY 'Value' (Value) -> PARAMETER_REFERENCE -> ONE 'STTemplateParameter' (STTemplateParameter)
					if (event.isControlDown()) get_STTemplateParameter_PARAMETER_REFERENCE_FOR_Value(getUUID(), new ExpandSTTemplateParameter_PARAMETER_REFERENCE_FOR_ValueHandler(getThis()));

					// ONE 'srcValue' (Value) -> KV_VALUES -> MANY 'Value' (Value)
					if (event.isControlDown()) get_Value_KV_VALUES_FOR_SrcValue(getUUID(), new ExpandValue_KV_VALUES_FOR_SrcValueHandler(getThis()));

					// MANY 'Value' (Value) -> KEY_REFERENCE -> ONE 'STKeyValue' (STKeyValue)
					if (event.isControlDown()) get_STKeyValue_KEY_REFERENCE_FOR_Value(getUUID(), new ExpandSTKeyValue_KEY_REFERENCE_FOR_ValueHandler(getThis()));

					// MANY 'Value' (Value) -> INSTANCE_REFERENCE -> ONE 'STInstance' (STInstance)
					if (event.isControlDown()) get_STInstance_INSTANCE_REFERENCE_FOR_Value(getUUID(), new ExpandSTInstance_INSTANCE_REFERENCE_FOR_ValueHandler(getThis()));

				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// Template Value
	protected final class ValueForm extends JPanel {

		private final String title = "New Value";
		private final PropertyComponent valueComponent = new PropertyComponent("String");
		private String uuid;

		protected ValueForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu");
			form.addLabel(Template.Properties.value.name(), c, r);
			c += 2;
			form.add(valueComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected ValueForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			valueComponent.setValue(content.getValue("value"));
		}

		public PropertyComponent getValueComponent() {
			return valueComponent;
		}

		protected ValueForm setValueValue(String value) {
			valueComponent.setValue(value);
			return this;
		}

		protected <T> T getValueValue() {
			return valueComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("value", (String) getValueValue());}

		protected Value getValue() {
			final JsonObject jsonObject = new JsonObject()
				.put("value", (String) getValueValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapValue(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public Value newValue(String value) {
		return newValue(new JsonObject().
			put("value", value));
	}

	public Value newValue(JsonObject parameters) {
		return mapValue(parameters);
	}

	public void updateValue(Value value, ValueHandler handler) {
		send("template.update.value", new JsonObject().put("uuid", value.getUUID().toString()).put("Value", value.toJson()), handler);
	}

	public void deleteValue(UUID uuid,  DeleteHandler handler) {
		send("template.delete.value", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getValue(UUID uuid, ValueHandler handler) {
		send("template.get.value", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllValue(ValueListHandler handler) {
		send("template.get.all.value", new JsonObject(), handler);
	}

	public static abstract class ValueListHandler extends ListHandler<Value> {

		@Override
		protected Value map(JsonObject jsonObject) {
			return mapValue(jsonObject);
		}
	}

	public static abstract class ValueHandler extends MessageHandler {

		public abstract void onSuccess(Value value);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapValue(payload));
		}
	}

	interface Value {

		enum Properties {
			value
		}


		UUID getUUID();

		JsonObject toJson();

		String getValue();

		Value setValue(String value);

	}

	private static Value mapValue(JsonObject payload) {
		return new Value() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public String getValue() {
				return payload.getString("value");
			}

			@Override
			public Value setValue(String value) {
				payload.put("value", value);
				return this;
			}

		};
	}

	protected void getAllValue() {
		getAllValue(new ValueListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<Value> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newValueNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	public STInstanceNode newSTInstanceNode(JsonObject jsonObject) {
		return new STInstanceNode(jsonObject);
	}

	class STInstanceNode extends JsonPNode {

		STInstanceNode(JsonObject sTInstance) {
			super(sTInstance, "name", Color.decode("#3690c0"), Color.decode("#e31a1c"), Color.decode("#e31a1c"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final STInstanceForm form = new STInstanceForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateSTInstance(form.getSTInstance(), new STInstanceHandler() {
								@Override
								public void onSuccess(STInstance updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});

			// ONE 'STInstance' (STInstance) -> VALUES -> MANY 'Value' (Value)
			final JMenu VALUESMenu = new JMenu("VALUES");

			VALUESMenu.add(new SwingAction("Get All VALUES") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_Value_VALUES_FOR_STInstance(getUUID(), new ExpandValue_VALUES_FOR_STInstanceHandler(getThis()));
				}
			});

			VALUESMenu.add(new SwingAction("Add Value") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_Value_VALUES_FOR_STInstance(getThis(), canvas);
				}
			});

			if (VALUESMenu.getMenuComponentCount() != 0) pop.add(VALUESMenu);


			// ONE 'STInstance' (STInstance) -> RENDERER -> MANY 'Renderer' (Renderer)
			final JMenu RENDERERMenu = new JMenu("RENDERER");

			RENDERERMenu.add(new SwingAction("Get All RENDERER") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_Renderer_RENDERER_FOR_STInstance(getUUID(), new ExpandRenderer_RENDERER_FOR_STInstanceHandler(getThis()));
				}
			});

			RENDERERMenu.add(new SwingAction("Add Renderer") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					add_Renderer_RENDERER_FOR_STInstance(getThis(), canvas);
				}
			});

			if (RENDERERMenu.getMenuComponentCount() != 0) pop.add(RENDERERMenu);


			// MANY 'STInstance' (STInstance) -> INSTANCE -> ONE 'STTemplate' (STTemplate)
			final JMenu INSTANCEMenu = new JMenu("INSTANCE");

			INSTANCEMenu.add(new SwingAction("Get STTemplate") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_STTemplate_INSTANCE_FOR_STInstance(getUUID(), new ExpandSTTemplate_INSTANCE_FOR_STInstanceHandler(getThis()));
				}
			});

			INSTANCEMenu.add(new SwingAction("Set STTemplate") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					set_STTemplate_INSTANCE_FOR_STInstance(getThis(), canvas);
				}
			});

			if (INSTANCEMenu.getMenuComponentCount() != 0) pop.add(INSTANCEMenu);



			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
					// ONE 'STInstance' (STInstance) -> VALUES -> MANY 'Value' (Value)
					if (event.isControlDown()) get_Value_VALUES_FOR_STInstance(getUUID(), new ExpandValue_VALUES_FOR_STInstanceHandler(getThis()));

					// ONE 'STInstance' (STInstance) -> RENDERER -> MANY 'Renderer' (Renderer)
					if (event.isControlDown()) get_Renderer_RENDERER_FOR_STInstance(getUUID(), new ExpandRenderer_RENDERER_FOR_STInstanceHandler(getThis()));

					// MANY 'STInstance' (STInstance) -> INSTANCE -> ONE 'STTemplate' (STTemplate)
					if (event.isControlDown()) get_STTemplate_INSTANCE_FOR_STInstance(getUUID(), new ExpandSTTemplate_INSTANCE_FOR_STInstanceHandler(getThis()));

				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// Template STInstance
	protected final class STInstanceForm extends JPanel {

		private final String title = "New STInstance";
		private final PropertyComponent nameComponent = new PropertyComponent("String");
		private String uuid;

		protected STInstanceForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu");
			form.addLabel(Template.Properties.name.name(), c, r);
			c += 2;
			form.add(nameComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected STInstanceForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			nameComponent.setValue(content.getValue("name"));
		}

		public PropertyComponent getNameComponent() {
			return nameComponent;
		}

		protected STInstanceForm setNameValue(String name) {
			nameComponent.setValue(name);
			return this;
		}

		protected <T> T getNameValue() {
			return nameComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("name", (String) getNameValue());}

		protected STInstance getSTInstance() {
			final JsonObject jsonObject = new JsonObject()
				.put("name", (String) getNameValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapSTInstance(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public STInstance newSTInstance(String name) {
		return newSTInstance(new JsonObject().
			put("name", name));
	}

	public STInstance newSTInstance(JsonObject parameters) {
		return mapSTInstance(parameters);
	}

	public void updateSTInstance(STInstance sTInstance, STInstanceHandler handler) {
		send("template.update.sTInstance", new JsonObject().put("uuid", sTInstance.getUUID().toString()).put("STInstance", sTInstance.toJson()), handler);
	}

	public void deleteSTInstance(UUID uuid,  DeleteHandler handler) {
		send("template.delete.sTInstance", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getSTInstance(UUID uuid, STInstanceHandler handler) {
		send("template.get.sTInstance", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllSTInstance(STInstanceListHandler handler) {
		send("template.get.all.sTInstance", new JsonObject(), handler);
	}

	public static abstract class STInstanceListHandler extends ListHandler<STInstance> {

		@Override
		protected STInstance map(JsonObject jsonObject) {
			return mapSTInstance(jsonObject);
		}
	}

	public static abstract class STInstanceHandler extends MessageHandler {

		public abstract void onSuccess(STInstance sTInstance);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapSTInstance(payload));
		}
	}

	interface STInstance {

		enum Properties {
			name
		}


		UUID getUUID();

		JsonObject toJson();

		String getName();

		STInstance setName(String name);

	}

	private static STInstance mapSTInstance(JsonObject payload) {
		return new STInstance() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public String getName() {
				return payload.getString("name");
			}

			@Override
			public STInstance setName(String name) {
				payload.put("name", name);
				return this;
			}

		};
	}

	protected void getAllSTInstance() {
		getAllSTInstance(new STInstanceListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<STInstance> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newSTInstanceNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	public RendererNode newRendererNode(JsonObject jsonObject) {
		return new RendererNode(jsonObject);
	}

	class RendererNode extends JsonPNode {

		RendererNode(JsonObject renderer) {
			super(renderer, "path", Color.decode("#3690c0"), Color.decode("#e31a1c"), Color.decode("#e31a1c"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final RendererForm form = new RendererForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateRenderer(form.getRenderer(), new RendererHandler() {
								@Override
								public void onSuccess(Renderer updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});


			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// Template Renderer
	protected final class RendererForm extends JPanel {

		private final String title = "New Renderer";
		private final PropertyComponent renderTypeComponent = new PropertyComponent(Renderer.RenderType.values());
		private final PropertyComponent pathComponent = new PropertyComponent("String");
		private String uuid;

		protected RendererForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu,pref,4dlu");
			form.addLabel(Template.Properties.renderType.name(), c, r);
			c += 2;
			form.add(renderTypeComponent.getComponent(), c, r);

			r +=2;
			c = 1;
			form.addLabel(Template.Properties.path.name(), c, r);
			c += 2;
			form.add(pathComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected RendererForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			renderTypeComponent.setValue(content.getValue("renderType"));
			pathComponent.setValue(content.getValue("path"));
		}

		public PropertyComponent getRenderTypeComponent() {
			return renderTypeComponent;
		}

		protected RendererForm setRenderTypeValue(Renderer.RenderType renderType) {
			renderTypeComponent.setValue(renderType);
			return this;
		}

		protected <T> T getRenderTypeValue() {
			return renderTypeComponent.getValue();
		}


		public PropertyComponent getPathComponent() {
			return pathComponent;
		}

		protected RendererForm setPathValue(String path) {
			pathComponent.setValue(path);
			return this;
		}

		protected <T> T getPathValue() {
			return pathComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("RenderType", (Renderer.RenderType) getRenderTypeValue())
				.put("path", (String) getPathValue());}

		protected Renderer getRenderer() {
			final JsonObject jsonObject = new JsonObject()
				.put("RenderType", (Renderer.RenderType) getRenderTypeValue())
				.put("path", (String) getPathValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapRenderer(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public Renderer newRenderer(Renderer.RenderType RenderType, String path) {
		return newRenderer(new JsonObject().
			put("RenderType", RenderType.name()).
			put("path", path));
	}

	public Renderer newRenderer(JsonObject parameters) {
		return mapRenderer(parameters);
	}

	public void updateRenderer(Renderer renderer, RendererHandler handler) {
		send("template.update.renderer", new JsonObject().put("uuid", renderer.getUUID().toString()).put("Renderer", renderer.toJson()), handler);
	}

	public void deleteRenderer(UUID uuid,  DeleteHandler handler) {
		send("template.delete.renderer", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getRenderer(UUID uuid, RendererHandler handler) {
		send("template.get.renderer", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllRenderer(RendererListHandler handler) {
		send("template.get.all.renderer", new JsonObject(), handler);
	}

	public static abstract class RendererListHandler extends ListHandler<Renderer> {

		@Override
		protected Renderer map(JsonObject jsonObject) {
			return mapRenderer(jsonObject);
		}
	}

	public static abstract class RendererHandler extends MessageHandler {

		public abstract void onSuccess(Renderer renderer);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapRenderer(payload));
		}
	}

	interface Renderer {

		enum Properties {
			renderType,
			path
		}

		enum RenderType { JAVA_FILE, PLAIN_FILE } 

		UUID getUUID();

		JsonObject toJson();

		RenderType getRenderType();

		Renderer setRenderType(RenderType renderType);

		String getPath();

		Renderer setPath(String path);

	}

	private static Renderer mapRenderer(JsonObject payload) {
		return new Renderer() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public RenderType getRenderType() {
				return RenderType.valueOf(payload.getString("renderType"));
			}

			@Override
			public Renderer setRenderType(RenderType renderType) {
				payload.put("RenderType", renderType.name());
				return this;
			}

			@Override
			public String getPath() {
				return payload.getString("path");
			}

			@Override
			public Renderer setPath(String path) {
				payload.put("path", path);
				return this;
			}

		};
	}

	protected void getAllRenderer() {
		getAllRenderer(new RendererListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<Renderer> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newRendererNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	public GroupRendererNode newGroupRendererNode(JsonObject jsonObject) {
		return new GroupRendererNode(jsonObject);
	}

	class GroupRendererNode extends JsonPNode {

		GroupRendererNode(JsonObject groupRenderer) {
			super(groupRenderer, "root", Color.decode("#3690c0"), Color.decode("#e31a1c"), Color.decode("#e31a1c"));
		}

		@Override
		protected void onRightClick(PInputEvent event, JPopupMenu pop, NodeCanvas canvas, Point mousePosition) {

			// default actions 
			pop.add(new SwingAction("Edit") {
				@Override
				protected void onActionPerformed(ActionEvent e) {

					final GroupRendererForm form = new GroupRendererForm(content());
					form.show(canvas, new ConfirmAction() {
						@Override
						public void verifyAndCommit() throws Exception {
							updateGroupRenderer(form.getGroupRenderer(), new GroupRendererHandler() {
								@Override
								public void onSuccess(GroupRenderer updated) {
									setContent(updated.toJson());
									nodeChangeSupport.firePropertyChange(nodeEvent("content"), null, updated.toJson());
								}
							});
						}
					});
				}
			});

			// MANY 'GroupRenderer' (GroupRenderer) -> GROUP_RENDERER -> ONE 'STGroup' (STGroup)
			final JMenu GROUP_RENDERERMenu = new JMenu("GROUP_RENDERER");

			GROUP_RENDERERMenu.add(new SwingAction("Get STGroup") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					get_STGroup_GROUP_RENDERER_FOR_GroupRenderer(getUUID(), new ExpandSTGroup_GROUP_RENDERER_FOR_GroupRendererHandler(getThis()));
				}
			});

			GROUP_RENDERERMenu.add(new SwingAction("Set STGroup") {
				@Override
				protected void onActionPerformed(ActionEvent e) {
					set_STGroup_GROUP_RENDERER_FOR_GroupRenderer(getThis(), canvas);
				}
			});

			if (GROUP_RENDERERMenu.getMenuComponentCount() != 0) pop.add(GROUP_RENDERERMenu);



			super.onRightClick(event, pop, canvas, mousePosition);
		}

		@Override
		protected void onKeyPressed(PInputEvent event, NodeCanvas canvas) {

			switch (event.getKeyCode()) {
				case KeyEvent.VK_E:
					// MANY 'GroupRenderer' (GroupRenderer) -> GROUP_RENDERER -> ONE 'STGroup' (STGroup)
					if (event.isControlDown()) get_STGroup_GROUP_RENDERER_FOR_GroupRenderer(getUUID(), new ExpandSTGroup_GROUP_RENDERER_FOR_GroupRendererHandler(getThis()));

				return;
			}

			super.onKeyPressed(event, canvas);
		}
	}

	// Template GroupRenderer
	protected final class GroupRendererForm extends JPanel {

		private final String title = "New GroupRenderer";
		private final PropertyComponent packageNameComponent = new PropertyComponent("String");
		private final PropertyComponent rootComponent = new PropertyComponent("String");
		private String uuid;

		protected GroupRendererForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "pref,4dlu,pref,4dlu");
			form.addLabel(Template.Properties.packageName.name(), c, r);
			c += 2;
			form.add(packageNameComponent.getComponent(), c, r);

			r +=2;
			c = 1;
			form.addLabel(Template.Properties.root.name(), c, r);
			c += 2;
			form.add(rootComponent.getComponent(), c, r);

			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected GroupRendererForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
			packageNameComponent.setValue(content.getValue("packageName"));
			rootComponent.setValue(content.getValue("root"));
		}

		public PropertyComponent getPackageNameComponent() {
			return packageNameComponent;
		}

		protected GroupRendererForm setPackageNameValue(String packageName) {
			packageNameComponent.setValue(packageName);
			return this;
		}

		protected <T> T getPackageNameValue() {
			return packageNameComponent.getValue();
		}


		public PropertyComponent getRootComponent() {
			return rootComponent;
		}

		protected GroupRendererForm setRootValue(String root) {
			rootComponent.setValue(root);
			return this;
		}

		protected <T> T getRootValue() {
			return rootComponent.getValue();
		}

		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	
				.put("packageName", (String) getPackageNameValue())
				.put("root", (String) getRootValue());}

		protected GroupRenderer getGroupRenderer() {
			final JsonObject jsonObject = new JsonObject()
				.put("packageName", (String) getPackageNameValue())
				.put("root", (String) getRootValue());
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapGroupRenderer(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public GroupRenderer newGroupRenderer(String packageName, String root) {
		return newGroupRenderer(new JsonObject().
			put("packageName", packageName).
			put("root", root));
	}

	public GroupRenderer newGroupRenderer(JsonObject parameters) {
		return mapGroupRenderer(parameters);
	}

	public void updateGroupRenderer(GroupRenderer groupRenderer, GroupRendererHandler handler) {
		send("template.update.groupRenderer", new JsonObject().put("uuid", groupRenderer.getUUID().toString()).put("GroupRenderer", groupRenderer.toJson()), handler);
	}

	public void deleteGroupRenderer(UUID uuid,  DeleteHandler handler) {
		send("template.delete.groupRenderer", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getGroupRenderer(UUID uuid, GroupRendererHandler handler) {
		send("template.get.groupRenderer", new JsonObject().put("uuid", uuid.toString()), handler);
	}

	public void getAllGroupRenderer(GroupRendererListHandler handler) {
		send("template.get.all.groupRenderer", new JsonObject(), handler);
	}

	public static abstract class GroupRendererListHandler extends ListHandler<GroupRenderer> {

		@Override
		protected GroupRenderer map(JsonObject jsonObject) {
			return mapGroupRenderer(jsonObject);
		}
	}

	public static abstract class GroupRendererHandler extends MessageHandler {

		public abstract void onSuccess(GroupRenderer groupRenderer);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapGroupRenderer(payload));
		}
	}

	interface GroupRenderer {

		enum Properties {
			packageName,
			root
		}


		UUID getUUID();

		JsonObject toJson();

		String getPackageName();

		GroupRenderer setPackageName(String packageName);

		String getRoot();

		GroupRenderer setRoot(String root);

	}

	private static GroupRenderer mapGroupRenderer(JsonObject payload) {
		return new GroupRenderer() {

			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}
					@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return payload.encode();
			}

			@Override
			public String getPackageName() {
				return payload.getString("packageName");
			}

			@Override
			public GroupRenderer setPackageName(String packageName) {
				payload.put("packageName", packageName);
				return this;
			}

			@Override
			public String getRoot() {
				return payload.getString("root");
			}

			@Override
			public GroupRenderer setRoot(String root) {
				payload.put("root", root);
				return this;
			}

		};
	}

	protected void getAllGroupRenderer() {
		getAllGroupRenderer(new GroupRendererListHandler() {
			@Override
			public void onSuccess(java.util.Iterator<GroupRenderer> it) {
				final Set<BasePNode> nodes = new LinkedHashSet<>();
				while (it.hasNext()) nodes.add(newGroupRendererNode(it.next().toJson()));
				addNodes(nodes, new LayoutRelativeTo(getMousePosition() == null ? getCenterPosition() : getMousePosition()));
			}
		});
	}


	// RELATIONS

	// ONE 'STGroup' (STGroup) -> TEMPLATE -> MANY 'STTemplate' (STTemplate)

	// 
	protected TEMPLATERelation newTEMPLATERelation(JsonObject relationship, JsonPNode sTGroup, JsonPNode sTTemplate) {
			return new TEMPLATERelation(relationship, sTGroup, sTTemplate);
		}

	class TEMPLATERelation extends JsonRelationship {

		TEMPLATERelation(JsonObject relationship, JsonPNode sTGroup, JsonPNode sTTemplate) {
			super(relationship, "TEMPLATE", sTGroup, sTTemplate, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// Template TEMPLATE
	protected final class TEMPLATEForm extends JPanel {

		private final String title = "New TEMPLATE";
		private String uuid;

		protected TEMPLATEForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected TEMPLATEForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected TEMPLATE getTEMPLATE() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapTEMPLATE(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateSTGroup_TEMPLATE_STTemplate(UUID sTGroup, STTemplate sTTemplate, TEMPLATEHandler handler) {
		final JsonObject parameters = new JsonObject().put("STGroup", sTGroup.toString()).put("STTemplate", sTTemplate.toJson());
		send("template.relate.sTGroup.TEMPLATE.sTTemplate", parameters, handler);
	}

	public static abstract class TEMPLATEHandler extends MessageHandler {

		public abstract void onSuccess(TEMPLATE relation, STTemplate sTTemplate);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapTEMPLATE(payload.getJsonObject("TEMPLATE")), mapSTTemplate(payload.getJsonObject("STTemplate")));
		}
	}

	// MISSING
	// one-to-many
	protected class ExpandSTTemplate_TEMPLATE_FOR_STGroupHandler extends STTemplate_TEMPLATE_FOR_STGroupHandler {

		private final STGroupNode node;

		ExpandSTTemplate_TEMPLATE_FOR_STGroupHandler(STGroupNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<STGroupTEMPLATE> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final STGroupTEMPLATE next = it.next();
				final STTemplateNode entityNode = newSTTemplateNode(next.getSTTemplate().toJson());
				nodes.add(entityNode);
				relations.add(newTEMPLATERelation(next.getTEMPLATE().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_STTemplate_TEMPLATE_FOR_STGroup(final STGroupNode node, NodeCanvas canvas) {

		final STTemplateForm form = new STTemplateForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final STTemplate entity = newSTTemplate(form.toJson());

				relateSTGroup_TEMPLATE_STTemplate(node.getUUID(), entity, new TEMPLATEHandler() {
					@Override
					public void onSuccess(TEMPLATE relation, STTemplate newEntity) {
						final STTemplateNode newNode = newSTTemplateNode(newEntity.toJson());
						addNodeAndRelation(newNode, newTEMPLATERelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	// message support
	public void get_STTemplate_TEMPLATE_FOR_STGroup(UUID sTGroup, STTemplate_TEMPLATE_FOR_STGroupHandler handler) {
		send("template.get.sTTemplate.TEMPLATE.sTGroup", new JsonObject().put("STGroup", sTGroup.toString()), handler);
	}

	public void get_STGroup_TEMPLATE_FOR_STTemplate(UUID sTTemplate, TEMPLATESTGroupHandler handler) {
		send("template.get.sTGroup.TEMPLATE.sTTemplate", new JsonObject().put("STTemplate", sTTemplate.toString()), handler);
	}

	public interface STGroupTEMPLATE {

		public STTemplate getSTTemplate();

		public TEMPLATE getTEMPLATE();
	}

	public static abstract class STTemplate_TEMPLATE_FOR_STGroupHandler extends ListHandler<STGroupTEMPLATE> {

		@Override
		protected STGroupTEMPLATE map(JsonObject payload) {
			return new STGroupTEMPLATE() {
				@Override
				public STTemplate getSTTemplate() {
					return mapSTTemplate(payload.getJsonObject("STTemplate"));
				}

				@Override
				public TEMPLATE getTEMPLATE() {
					return mapTEMPLATE(payload.getJsonObject("TEMPLATE"));
				}
			};
		}
	}

	public static abstract class TEMPLATESTGroupHandler extends MessageHandler {

		public abstract void onSuccess(TEMPLATE TEMPLATE, STGroup sTGroup);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapTEMPLATE(payload.getJsonObject("TEMPLATE")),mapSTGroup(payload.getJsonObject("STGroup")));
		}
	}

	public void updateTEMPLATE(UUID srcNode, TEMPLATE relationship, TEMPLATEHandler handler) {
		send("template.update.TEMPLATE", new JsonObject().put("uuid", srcNode.toString()).put("TEMPLATE", relationship.toJson()), handler);
	}

	private static TEMPLATE mapTEMPLATE(JsonObject payload) {
		return new TEMPLATE() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface TEMPLATE {

		UUID getUUID();

		JsonObject toJson();

	}


	// ONE 'srcSTTemplate' (STTemplate) -> CHILD_TEMPLATE -> MANY 'STTemplate' (STTemplate)

	// 
	protected CHILD_TEMPLATERelation newCHILD_TEMPLATERelation(JsonObject relationship, JsonPNode srcSTTemplate, JsonPNode sTTemplate) {
			return new CHILD_TEMPLATERelation(relationship, srcSTTemplate, sTTemplate);
		}

	class CHILD_TEMPLATERelation extends JsonRelationship {

		CHILD_TEMPLATERelation(JsonObject relationship, JsonPNode srcSTTemplate, JsonPNode sTTemplate) {
			super(relationship, "CHILD_TEMPLATE", srcSTTemplate, sTTemplate, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// Template CHILD_TEMPLATE
	protected final class CHILD_TEMPLATEForm extends JPanel {

		private final String title = "New CHILD_TEMPLATE";
		private String uuid;

		protected CHILD_TEMPLATEForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected CHILD_TEMPLATEForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected CHILD_TEMPLATE getCHILD_TEMPLATE() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapCHILD_TEMPLATE(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateSrcSTTemplate_CHILD_TEMPLATE_STTemplate(UUID srcSTTemplate, STTemplate sTTemplate, CHILD_TEMPLATEHandler handler) {
		final JsonObject parameters = new JsonObject().put("SrcSTTemplate", srcSTTemplate.toString()).put("STTemplate", sTTemplate.toJson());
		send("template.relate.srcSTTemplate.CHILD_TEMPLATE.sTTemplate", parameters, handler);
	}

	public static abstract class CHILD_TEMPLATEHandler extends MessageHandler {

		public abstract void onSuccess(CHILD_TEMPLATE relation, STTemplate sTTemplate);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapCHILD_TEMPLATE(payload.getJsonObject("CHILD_TEMPLATE")), mapSTTemplate(payload.getJsonObject("STTemplate")));
		}
	}

	// MISSING
	// one-to-many
	protected class ExpandSTTemplate_CHILD_TEMPLATE_FOR_SrcSTTemplateHandler extends STTemplate_CHILD_TEMPLATE_FOR_SrcSTTemplateHandler {

		private final STTemplateNode node;

		ExpandSTTemplate_CHILD_TEMPLATE_FOR_SrcSTTemplateHandler(STTemplateNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<SrcSTTemplateCHILD_TEMPLATE> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final SrcSTTemplateCHILD_TEMPLATE next = it.next();
				final STTemplateNode entityNode = newSTTemplateNode(next.getSTTemplate().toJson());
				nodes.add(entityNode);
				relations.add(newCHILD_TEMPLATERelation(next.getCHILD_TEMPLATE().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_STTemplate_CHILD_TEMPLATE_FOR_SrcSTTemplate(final STTemplateNode node, NodeCanvas canvas) {

		final STTemplateForm form = new STTemplateForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final STTemplate entity = newSTTemplate(form.toJson());

				relateSrcSTTemplate_CHILD_TEMPLATE_STTemplate(node.getUUID(), entity, new CHILD_TEMPLATEHandler() {
					@Override
					public void onSuccess(CHILD_TEMPLATE relation, STTemplate newEntity) {
						final STTemplateNode newNode = newSTTemplateNode(newEntity.toJson());
						addNodeAndRelation(newNode, newCHILD_TEMPLATERelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	// message support
	public void get_STTemplate_CHILD_TEMPLATE_FOR_SrcSTTemplate(UUID srcSTTemplate, STTemplate_CHILD_TEMPLATE_FOR_SrcSTTemplateHandler handler) {
		send("template.get.sTTemplate.CHILD_TEMPLATE.srcSTTemplate", new JsonObject().put("SrcSTTemplate", srcSTTemplate.toString()), handler);
	}

	public void get_SrcSTTemplate_CHILD_TEMPLATE_FOR_STTemplate(UUID sTTemplate, CHILD_TEMPLATESrcSTTemplateHandler handler) {
		send("template.get.srcSTTemplate.CHILD_TEMPLATE.sTTemplate", new JsonObject().put("STTemplate", sTTemplate.toString()), handler);
	}

	public interface SrcSTTemplateCHILD_TEMPLATE {

		public STTemplate getSTTemplate();

		public CHILD_TEMPLATE getCHILD_TEMPLATE();
	}

	public static abstract class STTemplate_CHILD_TEMPLATE_FOR_SrcSTTemplateHandler extends ListHandler<SrcSTTemplateCHILD_TEMPLATE> {

		@Override
		protected SrcSTTemplateCHILD_TEMPLATE map(JsonObject payload) {
			return new SrcSTTemplateCHILD_TEMPLATE() {
				@Override
				public STTemplate getSTTemplate() {
					return mapSTTemplate(payload.getJsonObject("STTemplate"));
				}

				@Override
				public CHILD_TEMPLATE getCHILD_TEMPLATE() {
					return mapCHILD_TEMPLATE(payload.getJsonObject("CHILD_TEMPLATE"));
				}
			};
		}
	}

	public static abstract class CHILD_TEMPLATESrcSTTemplateHandler extends MessageHandler {

		public abstract void onSuccess(CHILD_TEMPLATE CHILD_TEMPLATE, STTemplate srcSTTemplate);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapCHILD_TEMPLATE(payload.getJsonObject("CHILD_TEMPLATE")),mapSTTemplate(payload.getJsonObject("SrcSTTemplate")));
		}
	}

	public void updateCHILD_TEMPLATE(UUID srcNode, CHILD_TEMPLATE relationship, CHILD_TEMPLATEHandler handler) {
		send("template.update.CHILD_TEMPLATE", new JsonObject().put("uuid", srcNode.toString()).put("CHILD_TEMPLATE", relationship.toJson()), handler);
	}

	private static CHILD_TEMPLATE mapCHILD_TEMPLATE(JsonObject payload) {
		return new CHILD_TEMPLATE() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface CHILD_TEMPLATE {

		UUID getUUID();

		JsonObject toJson();

	}


	// ONE 'STTemplate' (STTemplate) -> PARAMETER -> MANY 'STTemplateParameter' (STTemplateParameter)

	// 
	protected PARAMETERRelation newPARAMETERRelation(JsonObject relationship, JsonPNode sTTemplate, JsonPNode sTTemplateParameter) {
			return new PARAMETERRelation(relationship, sTTemplate, sTTemplateParameter);
		}

	class PARAMETERRelation extends JsonRelationship {

		PARAMETERRelation(JsonObject relationship, JsonPNode sTTemplate, JsonPNode sTTemplateParameter) {
			super(relationship, "PARAMETER", sTTemplate, sTTemplateParameter, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// Template PARAMETER
	protected final class PARAMETERForm extends JPanel {

		private final String title = "New PARAMETER";
		private String uuid;

		protected PARAMETERForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected PARAMETERForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected PARAMETER getPARAMETER() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapPARAMETER(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateSTTemplate_PARAMETER_STTemplateParameter(UUID sTTemplate, STTemplateParameter sTTemplateParameter, PARAMETERHandler handler) {
		final JsonObject parameters = new JsonObject().put("STTemplate", sTTemplate.toString()).put("STTemplateParameter", sTTemplateParameter.toJson());
		send("template.relate.sTTemplate.PARAMETER.sTTemplateParameter", parameters, handler);
	}

	public static abstract class PARAMETERHandler extends MessageHandler {

		public abstract void onSuccess(PARAMETER relation, STTemplateParameter sTTemplateParameter);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapPARAMETER(payload.getJsonObject("PARAMETER")), mapSTTemplateParameter(payload.getJsonObject("STTemplateParameter")));
		}
	}

	// MISSING
	// one-to-many
	protected class ExpandSTTemplateParameter_PARAMETER_FOR_STTemplateHandler extends STTemplateParameter_PARAMETER_FOR_STTemplateHandler {

		private final STTemplateNode node;

		ExpandSTTemplateParameter_PARAMETER_FOR_STTemplateHandler(STTemplateNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<STTemplatePARAMETER> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final STTemplatePARAMETER next = it.next();
				final STTemplateParameterNode entityNode = newSTTemplateParameterNode(next.getSTTemplateParameter().toJson());
				nodes.add(entityNode);
				relations.add(newPARAMETERRelation(next.getPARAMETER().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_STTemplateParameter_PARAMETER_FOR_STTemplate(final STTemplateNode node, NodeCanvas canvas) {

		final STTemplateParameterForm form = new STTemplateParameterForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final STTemplateParameter entity = newSTTemplateParameter(form.toJson());

				relateSTTemplate_PARAMETER_STTemplateParameter(node.getUUID(), entity, new PARAMETERHandler() {
					@Override
					public void onSuccess(PARAMETER relation, STTemplateParameter newEntity) {
						final STTemplateParameterNode newNode = newSTTemplateParameterNode(newEntity.toJson());
						addNodeAndRelation(newNode, newPARAMETERRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	// message support
	public void get_STTemplateParameter_PARAMETER_FOR_STTemplate(UUID sTTemplate, STTemplateParameter_PARAMETER_FOR_STTemplateHandler handler) {
		send("template.get.sTTemplateParameter.PARAMETER.sTTemplate", new JsonObject().put("STTemplate", sTTemplate.toString()), handler);
	}

	public void get_STTemplate_PARAMETER_FOR_STTemplateParameter(UUID sTTemplateParameter, PARAMETERSTTemplateHandler handler) {
		send("template.get.sTTemplate.PARAMETER.sTTemplateParameter", new JsonObject().put("STTemplateParameter", sTTemplateParameter.toString()), handler);
	}

	public interface STTemplatePARAMETER {

		public STTemplateParameter getSTTemplateParameter();

		public PARAMETER getPARAMETER();
	}

	public static abstract class STTemplateParameter_PARAMETER_FOR_STTemplateHandler extends ListHandler<STTemplatePARAMETER> {

		@Override
		protected STTemplatePARAMETER map(JsonObject payload) {
			return new STTemplatePARAMETER() {
				@Override
				public STTemplateParameter getSTTemplateParameter() {
					return mapSTTemplateParameter(payload.getJsonObject("STTemplateParameter"));
				}

				@Override
				public PARAMETER getPARAMETER() {
					return mapPARAMETER(payload.getJsonObject("PARAMETER"));
				}
			};
		}
	}

	public static abstract class PARAMETERSTTemplateHandler extends MessageHandler {

		public abstract void onSuccess(PARAMETER PARAMETER, STTemplate sTTemplate);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapPARAMETER(payload.getJsonObject("PARAMETER")),mapSTTemplate(payload.getJsonObject("STTemplate")));
		}
	}

	public void updatePARAMETER(UUID srcNode, PARAMETER relationship, PARAMETERHandler handler) {
		send("template.update.PARAMETER", new JsonObject().put("uuid", srcNode.toString()).put("PARAMETER", relationship.toJson()), handler);
	}

	private static PARAMETER mapPARAMETER(JsonObject payload) {
		return new PARAMETER() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface PARAMETER {

		UUID getUUID();

		JsonObject toJson();

	}


	// ONE 'STTemplateParameter' (STTemplateParameter) -> KEY_VALUE -> MANY 'STKeyValue' (STKeyValue)

	// 
	protected KEY_VALUERelation newKEY_VALUERelation(JsonObject relationship, JsonPNode sTTemplateParameter, JsonPNode sTKeyValue) {
			return new KEY_VALUERelation(relationship, sTTemplateParameter, sTKeyValue);
		}

	class KEY_VALUERelation extends JsonRelationship {

		KEY_VALUERelation(JsonObject relationship, JsonPNode sTTemplateParameter, JsonPNode sTKeyValue) {
			super(relationship, "KEY_VALUE", sTTemplateParameter, sTKeyValue, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// Template KEY_VALUE
	protected final class KEY_VALUEForm extends JPanel {

		private final String title = "New KEY_VALUE";
		private String uuid;

		protected KEY_VALUEForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected KEY_VALUEForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected KEY_VALUE getKEY_VALUE() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapKEY_VALUE(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateSTTemplateParameter_KEY_VALUE_STKeyValue(UUID sTTemplateParameter, STKeyValue sTKeyValue, KEY_VALUEHandler handler) {
		final JsonObject parameters = new JsonObject().put("STTemplateParameter", sTTemplateParameter.toString()).put("STKeyValue", sTKeyValue.toJson());
		send("template.relate.sTTemplateParameter.KEY_VALUE.sTKeyValue", parameters, handler);
	}

	public static abstract class KEY_VALUEHandler extends MessageHandler {

		public abstract void onSuccess(KEY_VALUE relation, STKeyValue sTKeyValue);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapKEY_VALUE(payload.getJsonObject("KEY_VALUE")), mapSTKeyValue(payload.getJsonObject("STKeyValue")));
		}
	}

	// MISSING
	// one-to-many
	protected class ExpandSTKeyValue_KEY_VALUE_FOR_STTemplateParameterHandler extends STKeyValue_KEY_VALUE_FOR_STTemplateParameterHandler {

		private final STTemplateParameterNode node;

		ExpandSTKeyValue_KEY_VALUE_FOR_STTemplateParameterHandler(STTemplateParameterNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<STTemplateParameterKEY_VALUE> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final STTemplateParameterKEY_VALUE next = it.next();
				final STKeyValueNode entityNode = newSTKeyValueNode(next.getSTKeyValue().toJson());
				nodes.add(entityNode);
				relations.add(newKEY_VALUERelation(next.getKEY_VALUE().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_STKeyValue_KEY_VALUE_FOR_STTemplateParameter(final STTemplateParameterNode node, NodeCanvas canvas) {

		final STKeyValueForm form = new STKeyValueForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final STKeyValue entity = newSTKeyValue(form.toJson());

				relateSTTemplateParameter_KEY_VALUE_STKeyValue(node.getUUID(), entity, new KEY_VALUEHandler() {
					@Override
					public void onSuccess(KEY_VALUE relation, STKeyValue newEntity) {
						final STKeyValueNode newNode = newSTKeyValueNode(newEntity.toJson());
						addNodeAndRelation(newNode, newKEY_VALUERelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	// message support
	public void get_STKeyValue_KEY_VALUE_FOR_STTemplateParameter(UUID sTTemplateParameter, STKeyValue_KEY_VALUE_FOR_STTemplateParameterHandler handler) {
		send("template.get.sTKeyValue.KEY_VALUE.sTTemplateParameter", new JsonObject().put("STTemplateParameter", sTTemplateParameter.toString()), handler);
	}

	public void get_STTemplateParameter_KEY_VALUE_FOR_STKeyValue(UUID sTKeyValue, KEY_VALUESTTemplateParameterHandler handler) {
		send("template.get.sTTemplateParameter.KEY_VALUE.sTKeyValue", new JsonObject().put("STKeyValue", sTKeyValue.toString()), handler);
	}

	public interface STTemplateParameterKEY_VALUE {

		public STKeyValue getSTKeyValue();

		public KEY_VALUE getKEY_VALUE();
	}

	public static abstract class STKeyValue_KEY_VALUE_FOR_STTemplateParameterHandler extends ListHandler<STTemplateParameterKEY_VALUE> {

		@Override
		protected STTemplateParameterKEY_VALUE map(JsonObject payload) {
			return new STTemplateParameterKEY_VALUE() {
				@Override
				public STKeyValue getSTKeyValue() {
					return mapSTKeyValue(payload.getJsonObject("STKeyValue"));
				}

				@Override
				public KEY_VALUE getKEY_VALUE() {
					return mapKEY_VALUE(payload.getJsonObject("KEY_VALUE"));
				}
			};
		}
	}

	public static abstract class KEY_VALUESTTemplateParameterHandler extends MessageHandler {

		public abstract void onSuccess(KEY_VALUE KEY_VALUE, STTemplateParameter sTTemplateParameter);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapKEY_VALUE(payload.getJsonObject("KEY_VALUE")),mapSTTemplateParameter(payload.getJsonObject("STTemplateParameter")));
		}
	}

	public void updateKEY_VALUE(UUID srcNode, KEY_VALUE relationship, KEY_VALUEHandler handler) {
		send("template.update.KEY_VALUE", new JsonObject().put("uuid", srcNode.toString()).put("KEY_VALUE", relationship.toJson()), handler);
	}

	private static KEY_VALUE mapKEY_VALUE(JsonObject payload) {
		return new KEY_VALUE() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface KEY_VALUE {

		UUID getUUID();

		JsonObject toJson();

	}


	// MANY 'Value' (Value) -> KEY_REFERENCE -> ONE 'STKeyValue' (STKeyValue)

	// 
	protected KEY_REFERENCERelation newKEY_REFERENCERelation(JsonObject relationship, JsonPNode value, JsonPNode sTKeyValue) {
			return new KEY_REFERENCERelation(relationship, value, sTKeyValue);
		}

	class KEY_REFERENCERelation extends JsonRelationship {

		KEY_REFERENCERelation(JsonObject relationship, JsonPNode value, JsonPNode sTKeyValue) {
			super(relationship, "KEY_REFERENCE", value, sTKeyValue, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// Template KEY_REFERENCE
	protected final class KEY_REFERENCEForm extends JPanel {

		private final String title = "New KEY_REFERENCE";
		private String uuid;

		protected KEY_REFERENCEForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected KEY_REFERENCEForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected KEY_REFERENCE getKEY_REFERENCE() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapKEY_REFERENCE(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateValue_KEY_REFERENCE_STKeyValue(UUID value, STKeyValue sTKeyValue, KEY_REFERENCEHandler handler) {
		final JsonObject parameters = new JsonObject().put("Value", value.toString()).put("STKeyValue", sTKeyValue.toJson());
		send("template.relate.value.KEY_REFERENCE.sTKeyValue", parameters, handler);
	}

	public static abstract class KEY_REFERENCEHandler extends MessageHandler {

		public abstract void onSuccess(KEY_REFERENCE relation, STKeyValue sTKeyValue);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapKEY_REFERENCE(payload.getJsonObject("KEY_REFERENCE")), mapSTKeyValue(payload.getJsonObject("STKeyValue")));
		}
	}

	// MISSING
	// many-to-one
	protected class ExpandSTKeyValue_KEY_REFERENCE_FOR_ValueHandler extends KEY_REFERENCESTKeyValueHandler {

		private final ValueNode node;

		ExpandSTKeyValue_KEY_REFERENCE_FOR_ValueHandler(ValueNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(KEY_REFERENCE relation, STKeyValue newEntity) {
			final STKeyValueNode newNode = newSTKeyValueNode(newEntity.toJson());
			addNodeAndRelation(newNode, newKEY_REFERENCERelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
		}
	}

	protected void set_STKeyValue_KEY_REFERENCE_FOR_Value(final ValueNode node, NodeCanvas canvas) {

		final STKeyValueForm form = new STKeyValueForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final STKeyValue entity = newSTKeyValue(form.toJson());
				relateValue_KEY_REFERENCE_STKeyValue(node.getUUID(), entity, new KEY_REFERENCEHandler() {
					@Override
					public void onSuccess(KEY_REFERENCE relation, STKeyValue newEntity) {
						final STKeyValueNode newNode = newSTKeyValueNode(newEntity.toJson());
						addNodeAndRelation(newNode, newKEY_REFERENCERelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	public void get_STKeyValue_KEY_REFERENCE_FOR_Value(UUID value, KEY_REFERENCESTKeyValueHandler handler) {
		send("template.get.sTKeyValue.KEY_REFERENCE.value", new JsonObject().put("Value", value.toString()), handler);
	}

	public void get_Value_KEY_REFERENCE_FOR_STKeyValue(UUID sTKeyValue, Value_KEY_REFERENCE_FOR_STKeyValueHandler handler) {
		send("template.get.value.KEY_REFERENCE.sTKeyValue", new JsonObject().put("STKeyValue", sTKeyValue.toString()), handler);
	}

	public interface ValueKEY_REFERENCE {

		public Value getValue();

		public KEY_REFERENCE getKEY_REFERENCE();
	}

	public static abstract class Value_KEY_REFERENCE_FOR_STKeyValueHandler extends ListHandler<ValueKEY_REFERENCE> {

		@Override
		protected ValueKEY_REFERENCE map(JsonObject payload) {
			return new ValueKEY_REFERENCE() {
				@Override
				public Value getValue() {
					return mapValue(payload.getJsonObject("Value"));
				}

				@Override
				public KEY_REFERENCE getKEY_REFERENCE() {
					return mapKEY_REFERENCE(payload.getJsonObject("KEY_REFERENCE"));
				}
			};
		}
	}

	public static abstract class KEY_REFERENCESTKeyValueHandler extends MessageHandler {

		public abstract void onSuccess(KEY_REFERENCE KEY_REFERENCE, STKeyValue sTKeyValue);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapKEY_REFERENCE(payload.getJsonObject("KEY_REFERENCE")),mapSTKeyValue(payload.getJsonObject("STKeyValue")));
		}
	}

	public void updateKEY_REFERENCE(UUID srcNode, KEY_REFERENCE relationship, KEY_REFERENCEHandler handler) {
		send("template.update.KEY_REFERENCE", new JsonObject().put("uuid", srcNode.toString()).put("KEY_REFERENCE", relationship.toJson()), handler);
	}

	private static KEY_REFERENCE mapKEY_REFERENCE(JsonObject payload) {
		return new KEY_REFERENCE() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface KEY_REFERENCE {

		UUID getUUID();

		JsonObject toJson();

	}


	// MANY 'Value' (Value) -> PARAMETER_REFERENCE -> ONE 'STTemplateParameter' (STTemplateParameter)

	// 
	protected PARAMETER_REFERENCERelation newPARAMETER_REFERENCERelation(JsonObject relationship, JsonPNode value, JsonPNode sTTemplateParameter) {
			return new PARAMETER_REFERENCERelation(relationship, value, sTTemplateParameter);
		}

	class PARAMETER_REFERENCERelation extends JsonRelationship {

		PARAMETER_REFERENCERelation(JsonObject relationship, JsonPNode value, JsonPNode sTTemplateParameter) {
			super(relationship, "PARAMETER_REFERENCE", value, sTTemplateParameter, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// Template PARAMETER_REFERENCE
	protected final class PARAMETER_REFERENCEForm extends JPanel {

		private final String title = "New PARAMETER_REFERENCE";
		private String uuid;

		protected PARAMETER_REFERENCEForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected PARAMETER_REFERENCEForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected PARAMETER_REFERENCE getPARAMETER_REFERENCE() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapPARAMETER_REFERENCE(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateValue_PARAMETER_REFERENCE_STTemplateParameter(UUID value, STTemplateParameter sTTemplateParameter, PARAMETER_REFERENCEHandler handler) {
		final JsonObject parameters = new JsonObject().put("Value", value.toString()).put("STTemplateParameter", sTTemplateParameter.toJson());
		send("template.relate.value.PARAMETER_REFERENCE.sTTemplateParameter", parameters, handler);
	}

	public static abstract class PARAMETER_REFERENCEHandler extends MessageHandler {

		public abstract void onSuccess(PARAMETER_REFERENCE relation, STTemplateParameter sTTemplateParameter);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapPARAMETER_REFERENCE(payload.getJsonObject("PARAMETER_REFERENCE")), mapSTTemplateParameter(payload.getJsonObject("STTemplateParameter")));
		}
	}

	// MISSING
	// many-to-one
	protected class ExpandSTTemplateParameter_PARAMETER_REFERENCE_FOR_ValueHandler extends PARAMETER_REFERENCESTTemplateParameterHandler {

		private final ValueNode node;

		ExpandSTTemplateParameter_PARAMETER_REFERENCE_FOR_ValueHandler(ValueNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(PARAMETER_REFERENCE relation, STTemplateParameter newEntity) {
			final STTemplateParameterNode newNode = newSTTemplateParameterNode(newEntity.toJson());
			addNodeAndRelation(newNode, newPARAMETER_REFERENCERelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
		}
	}

	protected void set_STTemplateParameter_PARAMETER_REFERENCE_FOR_Value(final ValueNode node, NodeCanvas canvas) {

		final STTemplateParameterForm form = new STTemplateParameterForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final STTemplateParameter entity = newSTTemplateParameter(form.toJson());
				relateValue_PARAMETER_REFERENCE_STTemplateParameter(node.getUUID(), entity, new PARAMETER_REFERENCEHandler() {
					@Override
					public void onSuccess(PARAMETER_REFERENCE relation, STTemplateParameter newEntity) {
						final STTemplateParameterNode newNode = newSTTemplateParameterNode(newEntity.toJson());
						addNodeAndRelation(newNode, newPARAMETER_REFERENCERelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	public void get_STTemplateParameter_PARAMETER_REFERENCE_FOR_Value(UUID value, PARAMETER_REFERENCESTTemplateParameterHandler handler) {
		send("template.get.sTTemplateParameter.PARAMETER_REFERENCE.value", new JsonObject().put("Value", value.toString()), handler);
	}

	public void get_Value_PARAMETER_REFERENCE_FOR_STTemplateParameter(UUID sTTemplateParameter, Value_PARAMETER_REFERENCE_FOR_STTemplateParameterHandler handler) {
		send("template.get.value.PARAMETER_REFERENCE.sTTemplateParameter", new JsonObject().put("STTemplateParameter", sTTemplateParameter.toString()), handler);
	}

	public interface ValuePARAMETER_REFERENCE {

		public Value getValue();

		public PARAMETER_REFERENCE getPARAMETER_REFERENCE();
	}

	public static abstract class Value_PARAMETER_REFERENCE_FOR_STTemplateParameterHandler extends ListHandler<ValuePARAMETER_REFERENCE> {

		@Override
		protected ValuePARAMETER_REFERENCE map(JsonObject payload) {
			return new ValuePARAMETER_REFERENCE() {
				@Override
				public Value getValue() {
					return mapValue(payload.getJsonObject("Value"));
				}

				@Override
				public PARAMETER_REFERENCE getPARAMETER_REFERENCE() {
					return mapPARAMETER_REFERENCE(payload.getJsonObject("PARAMETER_REFERENCE"));
				}
			};
		}
	}

	public static abstract class PARAMETER_REFERENCESTTemplateParameterHandler extends MessageHandler {

		public abstract void onSuccess(PARAMETER_REFERENCE PARAMETER_REFERENCE, STTemplateParameter sTTemplateParameter);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapPARAMETER_REFERENCE(payload.getJsonObject("PARAMETER_REFERENCE")),mapSTTemplateParameter(payload.getJsonObject("STTemplateParameter")));
		}
	}

	public void updatePARAMETER_REFERENCE(UUID srcNode, PARAMETER_REFERENCE relationship, PARAMETER_REFERENCEHandler handler) {
		send("template.update.PARAMETER_REFERENCE", new JsonObject().put("uuid", srcNode.toString()).put("PARAMETER_REFERENCE", relationship.toJson()), handler);
	}

	private static PARAMETER_REFERENCE mapPARAMETER_REFERENCE(JsonObject payload) {
		return new PARAMETER_REFERENCE() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface PARAMETER_REFERENCE {

		UUID getUUID();

		JsonObject toJson();

	}


	// ONE 'srcValue' (Value) -> KV_VALUES -> MANY 'Value' (Value)

	// 
	protected KV_VALUESRelation newKV_VALUESRelation(JsonObject relationship, JsonPNode srcValue, JsonPNode value) {
			return new KV_VALUESRelation(relationship, srcValue, value);
		}

	class KV_VALUESRelation extends JsonRelationship {

		KV_VALUESRelation(JsonObject relationship, JsonPNode srcValue, JsonPNode value) {
			super(relationship, "KV_VALUES", srcValue, value, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// Template KV_VALUES
	protected final class KV_VALUESForm extends JPanel {

		private final String title = "New KV_VALUES";
		private String uuid;

		protected KV_VALUESForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected KV_VALUESForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected KV_VALUES getKV_VALUES() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapKV_VALUES(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateSrcValue_KV_VALUES_Value(UUID srcValue, Value value, KV_VALUESHandler handler) {
		final JsonObject parameters = new JsonObject().put("SrcValue", srcValue.toString()).put("Value", value.toJson());
		send("template.relate.srcValue.KV_VALUES.value", parameters, handler);
	}

	public static abstract class KV_VALUESHandler extends MessageHandler {

		public abstract void onSuccess(KV_VALUES relation, Value value);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapKV_VALUES(payload.getJsonObject("KV_VALUES")), mapValue(payload.getJsonObject("Value")));
		}
	}

	// MISSING
	// one-to-many
	protected class ExpandValue_KV_VALUES_FOR_SrcValueHandler extends Value_KV_VALUES_FOR_SrcValueHandler {

		private final ValueNode node;

		ExpandValue_KV_VALUES_FOR_SrcValueHandler(ValueNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<SrcValueKV_VALUES> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final SrcValueKV_VALUES next = it.next();
				final ValueNode entityNode = newValueNode(next.getValue().toJson());
				nodes.add(entityNode);
				relations.add(newKV_VALUESRelation(next.getKV_VALUES().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_Value_KV_VALUES_FOR_SrcValue(final ValueNode node, NodeCanvas canvas) {

		final ValueForm form = new ValueForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final Value entity = newValue(form.toJson());

				relateSrcValue_KV_VALUES_Value(node.getUUID(), entity, new KV_VALUESHandler() {
					@Override
					public void onSuccess(KV_VALUES relation, Value newEntity) {
						final ValueNode newNode = newValueNode(newEntity.toJson());
						addNodeAndRelation(newNode, newKV_VALUESRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	// message support
	public void get_Value_KV_VALUES_FOR_SrcValue(UUID srcValue, Value_KV_VALUES_FOR_SrcValueHandler handler) {
		send("template.get.value.KV_VALUES.srcValue", new JsonObject().put("SrcValue", srcValue.toString()), handler);
	}

	public void get_SrcValue_KV_VALUES_FOR_Value(UUID value, KV_VALUESSrcValueHandler handler) {
		send("template.get.srcValue.KV_VALUES.value", new JsonObject().put("Value", value.toString()), handler);
	}

	public interface SrcValueKV_VALUES {

		public Value getValue();

		public KV_VALUES getKV_VALUES();
	}

	public static abstract class Value_KV_VALUES_FOR_SrcValueHandler extends ListHandler<SrcValueKV_VALUES> {

		@Override
		protected SrcValueKV_VALUES map(JsonObject payload) {
			return new SrcValueKV_VALUES() {
				@Override
				public Value getValue() {
					return mapValue(payload.getJsonObject("Value"));
				}

				@Override
				public KV_VALUES getKV_VALUES() {
					return mapKV_VALUES(payload.getJsonObject("KV_VALUES"));
				}
			};
		}
	}

	public static abstract class KV_VALUESSrcValueHandler extends MessageHandler {

		public abstract void onSuccess(KV_VALUES KV_VALUES, Value srcValue);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapKV_VALUES(payload.getJsonObject("KV_VALUES")),mapValue(payload.getJsonObject("SrcValue")));
		}
	}

	public void updateKV_VALUES(UUID srcNode, KV_VALUES relationship, KV_VALUESHandler handler) {
		send("template.update.KV_VALUES", new JsonObject().put("uuid", srcNode.toString()).put("KV_VALUES", relationship.toJson()), handler);
	}

	private static KV_VALUES mapKV_VALUES(JsonObject payload) {
		return new KV_VALUES() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface KV_VALUES {

		UUID getUUID();

		JsonObject toJson();

	}


	// MANY 'Value' (Value) -> INSTANCE_REFERENCE -> ONE 'STInstance' (STInstance)

	// 
	protected INSTANCE_REFERENCERelation newINSTANCE_REFERENCERelation(JsonObject relationship, JsonPNode value, JsonPNode sTInstance) {
			return new INSTANCE_REFERENCERelation(relationship, value, sTInstance);
		}

	class INSTANCE_REFERENCERelation extends JsonRelationship {

		INSTANCE_REFERENCERelation(JsonObject relationship, JsonPNode value, JsonPNode sTInstance) {
			super(relationship, "INSTANCE_REFERENCE", value, sTInstance, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// Template INSTANCE_REFERENCE
	protected final class INSTANCE_REFERENCEForm extends JPanel {

		private final String title = "New INSTANCE_REFERENCE";
		private String uuid;

		protected INSTANCE_REFERENCEForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected INSTANCE_REFERENCEForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected INSTANCE_REFERENCE getINSTANCE_REFERENCE() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapINSTANCE_REFERENCE(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateValue_INSTANCE_REFERENCE_STInstance(UUID value, STInstance sTInstance, INSTANCE_REFERENCEHandler handler) {
		final JsonObject parameters = new JsonObject().put("Value", value.toString()).put("STInstance", sTInstance.toJson());
		send("template.relate.value.INSTANCE_REFERENCE.sTInstance", parameters, handler);
	}

	public static abstract class INSTANCE_REFERENCEHandler extends MessageHandler {

		public abstract void onSuccess(INSTANCE_REFERENCE relation, STInstance sTInstance);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapINSTANCE_REFERENCE(payload.getJsonObject("INSTANCE_REFERENCE")), mapSTInstance(payload.getJsonObject("STInstance")));
		}
	}

	// MISSING
	// many-to-one
	protected class ExpandSTInstance_INSTANCE_REFERENCE_FOR_ValueHandler extends INSTANCE_REFERENCESTInstanceHandler {

		private final ValueNode node;

		ExpandSTInstance_INSTANCE_REFERENCE_FOR_ValueHandler(ValueNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(INSTANCE_REFERENCE relation, STInstance newEntity) {
			final STInstanceNode newNode = newSTInstanceNode(newEntity.toJson());
			addNodeAndRelation(newNode, newINSTANCE_REFERENCERelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
		}
	}

	protected void set_STInstance_INSTANCE_REFERENCE_FOR_Value(final ValueNode node, NodeCanvas canvas) {

		final STInstanceForm form = new STInstanceForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final STInstance entity = newSTInstance(form.toJson());
				relateValue_INSTANCE_REFERENCE_STInstance(node.getUUID(), entity, new INSTANCE_REFERENCEHandler() {
					@Override
					public void onSuccess(INSTANCE_REFERENCE relation, STInstance newEntity) {
						final STInstanceNode newNode = newSTInstanceNode(newEntity.toJson());
						addNodeAndRelation(newNode, newINSTANCE_REFERENCERelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	public void get_STInstance_INSTANCE_REFERENCE_FOR_Value(UUID value, INSTANCE_REFERENCESTInstanceHandler handler) {
		send("template.get.sTInstance.INSTANCE_REFERENCE.value", new JsonObject().put("Value", value.toString()), handler);
	}

	public void get_Value_INSTANCE_REFERENCE_FOR_STInstance(UUID sTInstance, Value_INSTANCE_REFERENCE_FOR_STInstanceHandler handler) {
		send("template.get.value.INSTANCE_REFERENCE.sTInstance", new JsonObject().put("STInstance", sTInstance.toString()), handler);
	}

	public interface ValueINSTANCE_REFERENCE {

		public Value getValue();

		public INSTANCE_REFERENCE getINSTANCE_REFERENCE();
	}

	public static abstract class Value_INSTANCE_REFERENCE_FOR_STInstanceHandler extends ListHandler<ValueINSTANCE_REFERENCE> {

		@Override
		protected ValueINSTANCE_REFERENCE map(JsonObject payload) {
			return new ValueINSTANCE_REFERENCE() {
				@Override
				public Value getValue() {
					return mapValue(payload.getJsonObject("Value"));
				}

				@Override
				public INSTANCE_REFERENCE getINSTANCE_REFERENCE() {
					return mapINSTANCE_REFERENCE(payload.getJsonObject("INSTANCE_REFERENCE"));
				}
			};
		}
	}

	public static abstract class INSTANCE_REFERENCESTInstanceHandler extends MessageHandler {

		public abstract void onSuccess(INSTANCE_REFERENCE INSTANCE_REFERENCE, STInstance sTInstance);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapINSTANCE_REFERENCE(payload.getJsonObject("INSTANCE_REFERENCE")),mapSTInstance(payload.getJsonObject("STInstance")));
		}
	}

	public void updateINSTANCE_REFERENCE(UUID srcNode, INSTANCE_REFERENCE relationship, INSTANCE_REFERENCEHandler handler) {
		send("template.update.INSTANCE_REFERENCE", new JsonObject().put("uuid", srcNode.toString()).put("INSTANCE_REFERENCE", relationship.toJson()), handler);
	}

	private static INSTANCE_REFERENCE mapINSTANCE_REFERENCE(JsonObject payload) {
		return new INSTANCE_REFERENCE() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface INSTANCE_REFERENCE {

		UUID getUUID();

		JsonObject toJson();

	}


	// ONE 'STInstance' (STInstance) -> VALUES -> MANY 'Value' (Value)

	// 
	protected VALUESRelation newVALUESRelation(JsonObject relationship, JsonPNode sTInstance, JsonPNode value) {
			return new VALUESRelation(relationship, sTInstance, value);
		}

	class VALUESRelation extends JsonRelationship {

		VALUESRelation(JsonObject relationship, JsonPNode sTInstance, JsonPNode value) {
			super(relationship, "VALUES", sTInstance, value, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// Template VALUES
	protected final class VALUESForm extends JPanel {

		private final String title = "New VALUES";
		private String uuid;

		protected VALUESForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected VALUESForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected VALUES getVALUES() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapVALUES(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateSTInstance_VALUES_Value(UUID sTInstance, Value value, VALUESHandler handler) {
		final JsonObject parameters = new JsonObject().put("STInstance", sTInstance.toString()).put("Value", value.toJson());
		send("template.relate.sTInstance.VALUES.value", parameters, handler);
	}

	public static abstract class VALUESHandler extends MessageHandler {

		public abstract void onSuccess(VALUES relation, Value value);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapVALUES(payload.getJsonObject("VALUES")), mapValue(payload.getJsonObject("Value")));
		}
	}

	// MISSING
	// one-to-many
	protected class ExpandValue_VALUES_FOR_STInstanceHandler extends Value_VALUES_FOR_STInstanceHandler {

		private final STInstanceNode node;

		ExpandValue_VALUES_FOR_STInstanceHandler(STInstanceNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<STInstanceVALUES> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final STInstanceVALUES next = it.next();
				final ValueNode entityNode = newValueNode(next.getValue().toJson());
				nodes.add(entityNode);
				relations.add(newVALUESRelation(next.getVALUES().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_Value_VALUES_FOR_STInstance(final STInstanceNode node, NodeCanvas canvas) {

		final ValueForm form = new ValueForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final Value entity = newValue(form.toJson());

				relateSTInstance_VALUES_Value(node.getUUID(), entity, new VALUESHandler() {
					@Override
					public void onSuccess(VALUES relation, Value newEntity) {
						final ValueNode newNode = newValueNode(newEntity.toJson());
						addNodeAndRelation(newNode, newVALUESRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	// message support
	public void get_Value_VALUES_FOR_STInstance(UUID sTInstance, Value_VALUES_FOR_STInstanceHandler handler) {
		send("template.get.value.VALUES.sTInstance", new JsonObject().put("STInstance", sTInstance.toString()), handler);
	}

	public void get_STInstance_VALUES_FOR_Value(UUID value, VALUESSTInstanceHandler handler) {
		send("template.get.sTInstance.VALUES.value", new JsonObject().put("Value", value.toString()), handler);
	}

	public interface STInstanceVALUES {

		public Value getValue();

		public VALUES getVALUES();
	}

	public static abstract class Value_VALUES_FOR_STInstanceHandler extends ListHandler<STInstanceVALUES> {

		@Override
		protected STInstanceVALUES map(JsonObject payload) {
			return new STInstanceVALUES() {
				@Override
				public Value getValue() {
					return mapValue(payload.getJsonObject("Value"));
				}

				@Override
				public VALUES getVALUES() {
					return mapVALUES(payload.getJsonObject("VALUES"));
				}
			};
		}
	}

	public static abstract class VALUESSTInstanceHandler extends MessageHandler {

		public abstract void onSuccess(VALUES VALUES, STInstance sTInstance);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapVALUES(payload.getJsonObject("VALUES")),mapSTInstance(payload.getJsonObject("STInstance")));
		}
	}

	public void updateVALUES(UUID srcNode, VALUES relationship, VALUESHandler handler) {
		send("template.update.VALUES", new JsonObject().put("uuid", srcNode.toString()).put("VALUES", relationship.toJson()), handler);
	}

	private static VALUES mapVALUES(JsonObject payload) {
		return new VALUES() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface VALUES {

		UUID getUUID();

		JsonObject toJson();

	}


	// ONE 'STInstance' (STInstance) -> RENDERER -> MANY 'Renderer' (Renderer)

	// 
	protected RENDERERRelation newRENDERERRelation(JsonObject relationship, JsonPNode sTInstance, JsonPNode renderer) {
			return new RENDERERRelation(relationship, sTInstance, renderer);
		}

	class RENDERERRelation extends JsonRelationship {

		RENDERERRelation(JsonObject relationship, JsonPNode sTInstance, JsonPNode renderer) {
			super(relationship, "RENDERER", sTInstance, renderer, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// Template RENDERER
	protected final class RENDERERForm extends JPanel {

		private final String title = "New RENDERER";
		private String uuid;

		protected RENDERERForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected RENDERERForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected RENDERER getRENDERER() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapRENDERER(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateSTInstance_RENDERER_Renderer(UUID sTInstance, Renderer renderer, RENDERERHandler handler) {
		final JsonObject parameters = new JsonObject().put("STInstance", sTInstance.toString()).put("Renderer", renderer.toJson());
		send("template.relate.sTInstance.RENDERER.renderer", parameters, handler);
	}

	public static abstract class RENDERERHandler extends MessageHandler {

		public abstract void onSuccess(RENDERER relation, Renderer renderer);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapRENDERER(payload.getJsonObject("RENDERER")), mapRenderer(payload.getJsonObject("Renderer")));
		}
	}

	// MISSING
	// one-to-many
	protected class ExpandRenderer_RENDERER_FOR_STInstanceHandler extends Renderer_RENDERER_FOR_STInstanceHandler {

		private final STInstanceNode node;

		ExpandRenderer_RENDERER_FOR_STInstanceHandler(STInstanceNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(Iterator<STInstanceRENDERER> it) {
			final Set<BasePNode> nodes = new LinkedHashSet<>();
			final Set<Relation> relations = new LinkedHashSet<>();
			while(it.hasNext()) {
				final STInstanceRENDERER next = it.next();
				final RendererNode entityNode = newRendererNode(next.getRenderer().toJson());
				nodes.add(entityNode);
				relations.add(newRENDERERRelation(next.getRENDERER().toJson(), node, entityNode));
			}
			addNodesAndRelations(nodes, relations, new LayoutRelativeTo(node));
		}
	}

	protected void add_Renderer_RENDERER_FOR_STInstance(final STInstanceNode node, NodeCanvas canvas) {

		final RendererForm form = new RendererForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final Renderer entity = newRenderer(form.toJson());

				relateSTInstance_RENDERER_Renderer(node.getUUID(), entity, new RENDERERHandler() {
					@Override
					public void onSuccess(RENDERER relation, Renderer newEntity) {
						final RendererNode newNode = newRendererNode(newEntity.toJson());
						addNodeAndRelation(newNode, newRENDERERRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	// message support
	public void get_Renderer_RENDERER_FOR_STInstance(UUID sTInstance, Renderer_RENDERER_FOR_STInstanceHandler handler) {
		send("template.get.renderer.RENDERER.sTInstance", new JsonObject().put("STInstance", sTInstance.toString()), handler);
	}

	public void get_STInstance_RENDERER_FOR_Renderer(UUID renderer, RENDERERSTInstanceHandler handler) {
		send("template.get.sTInstance.RENDERER.renderer", new JsonObject().put("Renderer", renderer.toString()), handler);
	}

	public interface STInstanceRENDERER {

		public Renderer getRenderer();

		public RENDERER getRENDERER();
	}

	public static abstract class Renderer_RENDERER_FOR_STInstanceHandler extends ListHandler<STInstanceRENDERER> {

		@Override
		protected STInstanceRENDERER map(JsonObject payload) {
			return new STInstanceRENDERER() {
				@Override
				public Renderer getRenderer() {
					return mapRenderer(payload.getJsonObject("Renderer"));
				}

				@Override
				public RENDERER getRENDERER() {
					return mapRENDERER(payload.getJsonObject("RENDERER"));
				}
			};
		}
	}

	public static abstract class RENDERERSTInstanceHandler extends MessageHandler {

		public abstract void onSuccess(RENDERER RENDERER, STInstance sTInstance);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapRENDERER(payload.getJsonObject("RENDERER")),mapSTInstance(payload.getJsonObject("STInstance")));
		}
	}

	public void updateRENDERER(UUID srcNode, RENDERER relationship, RENDERERHandler handler) {
		send("template.update.RENDERER", new JsonObject().put("uuid", srcNode.toString()).put("RENDERER", relationship.toJson()), handler);
	}

	private static RENDERER mapRENDERER(JsonObject payload) {
		return new RENDERER() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface RENDERER {

		UUID getUUID();

		JsonObject toJson();

	}


	// MANY 'STInstance' (STInstance) -> INSTANCE -> ONE 'STTemplate' (STTemplate)

	// 
	protected INSTANCERelation newINSTANCERelation(JsonObject relationship, JsonPNode sTInstance, JsonPNode sTTemplate) {
			return new INSTANCERelation(relationship, sTInstance, sTTemplate);
		}

	class INSTANCERelation extends JsonRelationship {

		INSTANCERelation(JsonObject relationship, JsonPNode sTInstance, JsonPNode sTTemplate) {
			super(relationship, "INSTANCE", sTInstance, sTTemplate, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// Template INSTANCE
	protected final class INSTANCEForm extends JPanel {

		private final String title = "New INSTANCE";
		private String uuid;

		protected INSTANCEForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected INSTANCEForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected INSTANCE getINSTANCE() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapINSTANCE(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateSTInstance_INSTANCE_STTemplate(UUID sTInstance, STTemplate sTTemplate, INSTANCEHandler handler) {
		final JsonObject parameters = new JsonObject().put("STInstance", sTInstance.toString()).put("STTemplate", sTTemplate.toJson());
		send("template.relate.sTInstance.INSTANCE.sTTemplate", parameters, handler);
	}

	public static abstract class INSTANCEHandler extends MessageHandler {

		public abstract void onSuccess(INSTANCE relation, STTemplate sTTemplate);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapINSTANCE(payload.getJsonObject("INSTANCE")), mapSTTemplate(payload.getJsonObject("STTemplate")));
		}
	}

	// MISSING
	// many-to-one
	protected class ExpandSTTemplate_INSTANCE_FOR_STInstanceHandler extends INSTANCESTTemplateHandler {

		private final STInstanceNode node;

		ExpandSTTemplate_INSTANCE_FOR_STInstanceHandler(STInstanceNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(INSTANCE relation, STTemplate newEntity) {
			final STTemplateNode newNode = newSTTemplateNode(newEntity.toJson());
			addNodeAndRelation(newNode, newINSTANCERelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
		}
	}

	protected void set_STTemplate_INSTANCE_FOR_STInstance(final STInstanceNode node, NodeCanvas canvas) {

		final STTemplateForm form = new STTemplateForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final STTemplate entity = newSTTemplate(form.toJson());
				relateSTInstance_INSTANCE_STTemplate(node.getUUID(), entity, new INSTANCEHandler() {
					@Override
					public void onSuccess(INSTANCE relation, STTemplate newEntity) {
						final STTemplateNode newNode = newSTTemplateNode(newEntity.toJson());
						addNodeAndRelation(newNode, newINSTANCERelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	public void get_STTemplate_INSTANCE_FOR_STInstance(UUID sTInstance, INSTANCESTTemplateHandler handler) {
		send("template.get.sTTemplate.INSTANCE.sTInstance", new JsonObject().put("STInstance", sTInstance.toString()), handler);
	}

	public void get_STInstance_INSTANCE_FOR_STTemplate(UUID sTTemplate, STInstance_INSTANCE_FOR_STTemplateHandler handler) {
		send("template.get.sTInstance.INSTANCE.sTTemplate", new JsonObject().put("STTemplate", sTTemplate.toString()), handler);
	}

	public interface STInstanceINSTANCE {

		public STInstance getSTInstance();

		public INSTANCE getINSTANCE();
	}

	public static abstract class STInstance_INSTANCE_FOR_STTemplateHandler extends ListHandler<STInstanceINSTANCE> {

		@Override
		protected STInstanceINSTANCE map(JsonObject payload) {
			return new STInstanceINSTANCE() {
				@Override
				public STInstance getSTInstance() {
					return mapSTInstance(payload.getJsonObject("STInstance"));
				}

				@Override
				public INSTANCE getINSTANCE() {
					return mapINSTANCE(payload.getJsonObject("INSTANCE"));
				}
			};
		}
	}

	public static abstract class INSTANCESTTemplateHandler extends MessageHandler {

		public abstract void onSuccess(INSTANCE INSTANCE, STTemplate sTTemplate);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapINSTANCE(payload.getJsonObject("INSTANCE")),mapSTTemplate(payload.getJsonObject("STTemplate")));
		}
	}

	public void updateINSTANCE(UUID srcNode, INSTANCE relationship, INSTANCEHandler handler) {
		send("template.update.INSTANCE", new JsonObject().put("uuid", srcNode.toString()).put("INSTANCE", relationship.toJson()), handler);
	}

	private static INSTANCE mapINSTANCE(JsonObject payload) {
		return new INSTANCE() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface INSTANCE {

		UUID getUUID();

		JsonObject toJson();

	}


	// MANY 'GroupRenderer' (GroupRenderer) -> GROUP_RENDERER -> ONE 'STGroup' (STGroup)

	// 
	protected GROUP_RENDERERRelation newGROUP_RENDERERRelation(JsonObject relationship, JsonPNode groupRenderer, JsonPNode sTGroup) {
			return new GROUP_RENDERERRelation(relationship, groupRenderer, sTGroup);
		}

	class GROUP_RENDERERRelation extends JsonRelationship {

		GROUP_RENDERERRelation(JsonObject relationship, JsonPNode groupRenderer, JsonPNode sTGroup) {
			super(relationship, "GROUP_RENDERER", groupRenderer, sTGroup, Color.decode("#bdbdbd"), Color.decode("#636363"), Color.decode("#e34a33"));
		}

		@Override
		protected void onRightClick(JPopupMenu pop, NodeCanvas canvas) {

			super.onRightClick(pop, canvas);
		}
	}

	// Template GROUP_RENDERER
	protected final class GROUP_RENDERERForm extends JPanel {

		private final String title = "New GROUP_RENDERER";
		private String uuid;

		protected GROUP_RENDERERForm() {
			super(new BorderLayout());
				this.uuid = null;

			int c = 1, r = 1;
			final FormPanel form = new FormPanel("100dlu,4dlu,150dlu", "");
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			add(form.build(), BorderLayout.CENTER);
		}

		protected GROUP_RENDERERForm(JsonObject content) {
			this();
			this.uuid = content.getString("uuid");
		}


		@Deprecated
		protected JsonObject toJson() {
			return new JsonObject()	;}

		protected GROUP_RENDERER getGROUP_RENDERER() {
			final JsonObject jsonObject = new JsonObject();
			if (uuid != null) jsonObject.put("uuid", uuid);
			return mapGROUP_RENDERER(jsonObject);
		}

		protected void show(NodeCanvas canvas, ConfirmAction confirmAction) {
			showDialog(this, canvas, title, confirmAction);
		}
	}

	public void relateGroupRenderer_GROUP_RENDERER_STGroup(UUID groupRenderer, STGroup sTGroup, GROUP_RENDERERHandler handler) {
		final JsonObject parameters = new JsonObject().put("GroupRenderer", groupRenderer.toString()).put("STGroup", sTGroup.toJson());
		send("template.relate.groupRenderer.GROUP_RENDERER.sTGroup", parameters, handler);
	}

	public static abstract class GROUP_RENDERERHandler extends MessageHandler {

		public abstract void onSuccess(GROUP_RENDERER relation, STGroup sTGroup);

		@Override
		protected void handleSuccess(JsonObject payload) {
			onSuccess(mapGROUP_RENDERER(payload.getJsonObject("GROUP_RENDERER")), mapSTGroup(payload.getJsonObject("STGroup")));
		}
	}

	// MISSING
	// many-to-one
	protected class ExpandSTGroup_GROUP_RENDERER_FOR_GroupRendererHandler extends GROUP_RENDERERSTGroupHandler {

		private final GroupRendererNode node;

		ExpandSTGroup_GROUP_RENDERER_FOR_GroupRendererHandler(GroupRendererNode node) {
			this.node = node;
		}

		@Override
		public void onSuccess(GROUP_RENDERER relation, STGroup newEntity) {
			final STGroupNode newNode = newSTGroupNode(newEntity.toJson());
			addNodeAndRelation(newNode, newGROUP_RENDERERRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
		}
	}

	protected void set_STGroup_GROUP_RENDERER_FOR_GroupRenderer(final GroupRendererNode node, NodeCanvas canvas) {

		final STGroupForm form = new STGroupForm();
		form.show(canvas, new ConfirmAction() {
			@Override
			public void verifyAndCommit() throws Exception {
				final STGroup entity = newSTGroup(form.toJson());
				relateGroupRenderer_GROUP_RENDERER_STGroup(node.getUUID(), entity, new GROUP_RENDERERHandler() {
					@Override
					public void onSuccess(GROUP_RENDERER relation, STGroup newEntity) {
						final STGroupNode newNode = newSTGroupNode(newEntity.toJson());
						addNodeAndRelation(newNode, newGROUP_RENDERERRelation(relation.toJson(), node, newNode), new LayoutRelativeTo(node));
					}
				});
			}
		});
	}

	public void get_STGroup_GROUP_RENDERER_FOR_GroupRenderer(UUID groupRenderer, GROUP_RENDERERSTGroupHandler handler) {
		send("template.get.sTGroup.GROUP_RENDERER.groupRenderer", new JsonObject().put("GroupRenderer", groupRenderer.toString()), handler);
	}

	public void get_GroupRenderer_GROUP_RENDERER_FOR_STGroup(UUID sTGroup, GroupRenderer_GROUP_RENDERER_FOR_STGroupHandler handler) {
		send("template.get.groupRenderer.GROUP_RENDERER.sTGroup", new JsonObject().put("STGroup", sTGroup.toString()), handler);
	}

	public interface GroupRendererGROUP_RENDERER {

		public GroupRenderer getGroupRenderer();

		public GROUP_RENDERER getGROUP_RENDERER();
	}

	public static abstract class GroupRenderer_GROUP_RENDERER_FOR_STGroupHandler extends ListHandler<GroupRendererGROUP_RENDERER> {

		@Override
		protected GroupRendererGROUP_RENDERER map(JsonObject payload) {
			return new GroupRendererGROUP_RENDERER() {
				@Override
				public GroupRenderer getGroupRenderer() {
					return mapGroupRenderer(payload.getJsonObject("GroupRenderer"));
				}

				@Override
				public GROUP_RENDERER getGROUP_RENDERER() {
					return mapGROUP_RENDERER(payload.getJsonObject("GROUP_RENDERER"));
				}
			};
		}
	}

	public static abstract class GROUP_RENDERERSTGroupHandler extends MessageHandler {

		public abstract void onSuccess(GROUP_RENDERER GROUP_RENDERER, STGroup sTGroup);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(mapGROUP_RENDERER(payload.getJsonObject("GROUP_RENDERER")),mapSTGroup(payload.getJsonObject("STGroup")));
		}
	}

	public void updateGROUP_RENDERER(UUID srcNode, GROUP_RENDERER relationship, GROUP_RENDERERHandler handler) {
		send("template.update.GROUP_RENDERER", new JsonObject().put("uuid", srcNode.toString()).put("GROUP_RENDERER", relationship.toJson()), handler);
	}

	private static GROUP_RENDERER mapGROUP_RENDERER(JsonObject payload) {
		return new GROUP_RENDERER() {
			@Override
			public UUID getUUID() {
				return UUID.fromString(payload.getString("uuid"));
			}

			@Override
			public JsonObject toJson() {
				return payload;
			}

			@Override
			public String toString() {
				return toJson().encode();
			}
		};
	}

	interface GROUP_RENDERER {

		UUID getUUID();

		JsonObject toJson();

	}


	// VISITORS

	public void renderSTGroup(String packageName, String nodeUUID, RenderSTGroupHandler handler) {
		send("template.renderSTGroup", new JsonObject().put("packageName",packageName).put("nodeUUID",nodeUUID), handler);
	}

	public static abstract class RenderSTGroupHandler extends MessageHandler {

		public abstract void onSuccess();

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess();
		}
	}


	public void importSTG(String name, String text, ImportSTGHandler handler) {
		send("template.importSTG", new JsonObject().put("name",name).put("text",text), handler);
	}

	public static abstract class ImportSTGHandler extends MessageHandler {

		public abstract void onSuccess(String delimiter, String uuid, String name);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(payload.getString("delimiter"), payload.getString("uuid"), payload.getString("name"));
		}
	}


	public void importGroup(JsonArray relations, JsonArray nodes, ImportGroupHandler handler) {
		send("template.importGroup", new JsonObject().put("relations",relations).put("nodes",nodes), handler);
	}

	public static abstract class ImportGroupHandler extends MessageHandler {

		public abstract void onSuccess();

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess();
		}
	}


	public void exportGroup(String stGroup, ExportGroupHandler handler) {
		send("template.exportGroup", new JsonObject().put("stGroup",stGroup), handler);
	}

	public static abstract class ExportGroupHandler extends MessageHandler {

		public abstract void onSuccess(JsonObject result);

		@Override
		protected void handleSuccess(JsonObject payload) {
			if (payload.isEmpty()) return;
			onSuccess(payload.getJsonObject("result"));
		}
	}


	private void send(String address, JsonObject parameters, MessageHandler handler) {

		final JsonObject buffer = new JsonObject().
					put("type", "send").
					put("address", address).
					put("replyAddress", uuid).
					put("body", parameters);

		log.info("sending " + buffer.encode() + " to " + host + ":" + port);

		final HttpClient client = vertx.createHttpClient();
		client.websocket(port, host, "/eventbus/websocket", ws -> {
			ws.handler(handler);
			writeToWS(buffer, ws);
		});
	}

	private void writeToWS(JsonObject buffer, WebSocket ws) {
		final Buffer toBuffer = buffer.toBuffer();
		final int length = toBuffer.length();
		int index = 0;
		boolean first = true;
		while (index < length) {
			final int frameLength = Math.min(65536, length - index);
			final Buffer slice = toBuffer.slice(index, index + frameLength);
			index += frameLength;
			boolean isFinal = index == length;
			if (first)
				ws.writeFrame(WebSocketFrame.binaryFrame(slice, isFinal));
			else
				ws.writeFrame(WebSocketFrame.continuationFrame(slice, isFinal));
			first = false;
		}
	}

	public static abstract class DeleteHandler extends MessageHandler {

		public abstract void onSuccess(UUID deletedUUID);

		@Override
		protected void handleSuccess(String payload) {
			onSuccess(UUID.fromString(payload));
		}
	}

	protected static abstract class ListHandler<T> extends MessageHandler {

		public abstract void onSuccess(java.util.Iterator<T> it);

		@Override
		protected void handleSuccess(JsonArray payload) {
			final java.util.Iterator<Object> iterator = payload.iterator();
			onSuccess(new java.util.Iterator<T>() {
				@Override
				public boolean hasNext() {
					return iterator.hasNext();
				}

				@Override
				public T next() {
					return map((JsonObject) iterator.next());
				}
			});
		}

		protected abstract T map(JsonObject jsonObject);
	}

	protected static class MessageHandler implements Handler<Buffer> {

		enum Type {
			rec, err
		}

		private enum ResponseStatus {
			SUCCESS,
			FAIL
		}

		private enum PayloadType {
			STRING,
			JSONOBJECT,
			JSONARRAY,
			EXCEPTION
		}

		private StringBuilder result;

		@Override
		public void handle(Buffer buffer) {

				final String head = buffer.slice(0, Math.min(7, buffer.length())).toString();
				log.debug(buffer.length() + " : " + head);

				if (head.equals("{\"type\"")) result = new StringBuilder();
				result.append(buffer.toString());
								if (buffer.length() != 65536) {

					final String json = result.toString();
					log.info("handle \"" + json.substring(0, 10) + "\" ... \"" + json.substring(json.length() - 10) + "\"");
					final JsonObject message = new JsonObject(json);

					switch (Type.valueOf(message.getString("type"))) {
						case rec:
								handleResponse(message.getJsonObject("body"));
								break;
						case err:
								handleFail(message.getString("body"));
								break;
					}
				}
		}

		void handleResponse(JsonObject message) {

			switch (ResponseStatus.valueOf(message.getString("status"))) {

				case SUCCESS:
					switch (PayloadType.valueOf(message.getString("payloadType"))) {
						case STRING:
							handleSuccess(message.getString("payload"));
							break;
						case JSONOBJECT:
							handleSuccess(message.getJsonObject("payload"));
							break;
						case JSONARRAY:
							handleSuccess(message.getJsonArray("payload"));
							break;
					}
					break;

				case FAIL:
					switch (PayloadType.valueOf(message.getString("payloadType"))) {
						case STRING:
							handleFail(message.getString("payload"));
							break;
						case JSONOBJECT:
							handleFail(message.getJsonObject("payload"));
							break;
						case JSONARRAY:
							handleFail(message.getJsonArray("payload"));
							break;
						case EXCEPTION:
							final JsonObject payload = message.getJsonObject("payload");
							final JsonArray stackTrace = payload.getJsonArray("stackTrace");
							final StackTraceElement[] stackTraceElements = new StackTraceElement[stackTrace.size()];
							for (int i = 0; i < stackTrace.size(); i++) {
								final JsonObject element = stackTrace.getJsonObject(i);
								stackTraceElements[i] = new StackTraceElement(element.getString("declaringClass"), element.getString("methodName"), element.getString("fileName"), element.getInteger("lineNumber"));
							}

							final Throwable throwable = new Throwable(payload.getString("message"));
							throwable.setStackTrace(stackTraceElements);
							handleException(throwable);
							break;
					}
					break;

				default:
					log.error("unrecognized status '" + message.getString("status") + "'");
					break;
			}
		}

		protected void handleException(Throwable throwable) {
			log.error("unhandled exception " + throwable.getMessage(), throwable);
		}

		protected void handleSuccess(String payload) {
			log.error("unhandled String success " + payload);
		}

		protected void handleSuccess(JsonObject payload) {
			log.error("unhandled JsonObject success " + payload.encode());
		}

		protected void handleSuccess(JsonArray payload) {
			log.error("unhandled JsonArray success " + payload.encode());
		}

		protected void handleFail(JsonArray payload) {
			log.error("unhandled JsonArray fail" + payload.encode());
		}

		protected void handleFail(JsonObject payload) {
			log.error("unhandled JsonObject fail " + payload.encode());
		}

		protected void handleFail(String payload) {
			log.error("unhandled String fail " + payload);
		}
	}

	public static void main(String[] args) {

		setLookAndFeel();

		final Vertx vertx = Vertx.vertx();

		final String host = args.length == 0 ? "127.0.0.1" : args[0];
		final Integer port = args.length == 0 ? 8090 : Integer.valueOf(args[1]);
				if (args.length == 0) {
			TemplateVerticle.runServer(vertx, port, "./db_template", deploymentID -> {
				log.info("TemplateVerticle deploymentId " + deploymentID);
				showCanvas(vertx, host, port);
			});

		} else
			showCanvas(vertx, host, port);
	}

	private static void showCanvas(Vertx vertx, String host, Integer port) {
		final JFrame frame = new JFrame("TemplateRemoteCanvas @ " + host);
		final TemplateRemoteCanvas canvas = new TemplateRemoteCanvasImpl(vertx, port, host);
		final EditorPanel editorPanel = new EditorPanel(canvas);
		frame.getContentPane().add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, canvas, editorPanel), BorderLayout.CENTER);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		SwingUtilities.invokeLater(() -> {
				frame.pack();
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
		});
	}
}