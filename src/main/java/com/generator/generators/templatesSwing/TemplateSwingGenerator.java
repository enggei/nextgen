package com.generator.generators.templatesSwing;

import com.generator.generators.templates.TemplateVisitor;
import com.generator.generators.templates.domain.TemplateParameter;
import com.generator.generators.templates.domain.TemplateStatement;
import com.generator.util.FileUtil;
import com.generator.util.StringUtil;

import java.io.File;

import static com.generator.generators.templates.domain.GeneratedFile.packageToPath;

/**
 * goe on 8/25/16.
 */
public class TemplateSwingGenerator implements TemplateVisitor {

	private final String root;
	private final String packageName;
	private final TemplatesSwingGroup group = new TemplatesSwingGroup();

	private File groupTemplateFile;
//	private TemplatesSwingGroup.TemplatesSwingST swingST;
//	private TemplatesSwingGroup.CanvasListenerST canvasListenerST;
//	private TemplatesSwingGroup.statementActionsST canvasActionsST;

	// todo new (remove templates above)
	private TemplatesSwingGroup.TemplateCanvasST templateCanvas;
	private TemplatesSwingGroup.CanvasActionStringPropertyST canvasAction;

	public TemplateSwingGenerator(String root, String packageName) {
		this.root = root;
		this.packageName = packageName;
	}

	@Override
	public void onStartGroupTemplateFile(File groupTemplateFile) {

		this.groupTemplateFile = groupTemplateFile;

//		canvasListenerST = group.newCanvasListener().
//			setGroupName(getGroupName());
//
//		swingST = group.newTemplatesSwing().
//			setPackageName(packageName).
//			setGroupName(getGroupName());

		templateCanvas = group.newTemplateCanvas().
			setName(getGroupName()).
			setPackageName(packageName).
			setGroupName(getGroupName());
	}

	@Override
	public void onStartStatement(TemplateStatement statement) {

//		canvasActionsST = group.newstatementActions().
//			setGroupName(getGroupName()).
//			setName(statement.getName());

		canvasAction = null;
	}

	@Override
	public void onStartTemplateParameter(TemplateParameter parameter, TemplateStatement statement) {
	}

	@Override
	public void onKeyValueTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {

	}

	@Override
	public void onStringTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
//		canvasActionsST.addActionsValue(group.newsetStringAction().setGroupName(getGroupName()).setStatement(statement.getName()).setName(templateParameter.getPropertyName()));

		canvasAction = group.newCanvasActionStringProperty().setName(templateParameter.getPropertyName()).setGroupName(getGroupName());
	}

	@Override
	public void onBooleanTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {

	}

	@Override
	public void onStatementTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {

	}

	@Override
	public void onListTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {
//		canvasActionsST.addActionsValue(group.newaddListAction().setGroupName(getGroupName()).setStatement(statement.getName()).setName(templateParameter.getPropertyName()));
	}

	@Override
	public void onEndTemplateParameter(TemplateParameter templateParameter, TemplateStatement statement) {

	}

	@Override
	public void onEndStatement(TemplateStatement statement) {

//		canvasListenerST.addStatementsValue(canvasActionsST);
//
//		swingST.addStatementsValue(statement.getName(), group.newnewAction().
//			setGroupName(getGroupName()).
//			setName(statement.getName()));


		templateCanvas.addStatementsValue(statement.getName());
	}

	@Override
	public void onEndGroupTemplateFile(File groupTemplateFile) {

//		swingST.setCanvasListener(canvasListenerST);

//		FileUtil.write(swingST, new File(root, packageToPath(packageName, getGroupName() + "Swing.java")));
		FileUtil.write(templateCanvas, new File(root, packageToPath(packageName, getGroupName() + "Canvas.java")));
	}

	private String getGroupName() {
		return StringUtil.capitalize(groupTemplateFile.getName().substring(0, groupTemplateFile.getName().length() - 4));
	}
}