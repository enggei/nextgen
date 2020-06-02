package nextgen.st;

import com.generator.util.FileUtil;
import nextgen.st.domain.*;
import nextgen.st.parser.*;
import org.antlr.runtime.tree.Tree;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.misc.STMessage;

import java.io.File;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static nextgen.st.domain.STJsonFactory.newSTParameterKey;

public class STParser {

    public static boolean debug = false;

    public static STGParseResult parse(File stgFile) {
        final char delimiter = loadDelimiter(stgFile);
        final STGParseResult parseResult = parse(new STGroupFile(stgFile.getAbsolutePath(), delimiter, delimiter));
        if (parseResult.getErrors().count() == 0) parseResult.getParsed().setStgFile(stgFile.getPath());
        return parseResult;
    }

    public static STGParseResult parse(STGroup stGroup) {

        final STGParseResult parseResult = new STGParseResult();

        stGroup.setListener(new STErrorListener() {
            @Override
            public void compileTimeError(STMessage stMessage) {
                parseResult.addErrors(new STGError().setMessage(stMessage).setType(STGErrorType.COMPILE));
            }

            @Override
            public void runTimeError(STMessage stMessage) {
                parseResult.addErrors(new STGError().setMessage(stMessage).setType(STGErrorType.RUNTIME));
            }

            @Override
            public void IOError(STMessage stMessage) {
                parseResult.addErrors(new STGError().setMessage(stMessage).setType(STGErrorType.IO));
            }

            @Override
            public void internalError(STMessage stMessage) {
                parseResult.addErrors(new STGError().setMessage(stMessage).setType(STGErrorType.INTERNAL));
            }
        });

        final STGroupModel stGroupModel = new STGroupModel()
                .setName(stGroup.getName())
                .setDelimiter(stGroup.delimiterStartChar + "");

        final Map<String, STTemplate> stTemplateMap = new HashMap<>();
        final Map<STTemplate, Set<MethodCall>> stTemplateMethodCalls = new HashMap<>();

        stGroup.getTemplateNames()
                .stream()
                .map(stGroup::getInstanceOf)
                .filter(stTemplate -> !(stTemplate.getName().equals("/eom") || stTemplate.getName().equals("/gt")))
                .filter(st -> !st.isAnonSubtemplate())
                .filter(st -> st.impl.ast != null)
                .forEach(st -> {

                    final STTemplate stTemplate = new STTemplate()
                            .setName(st.getName().substring(1))
                            .setText(st.impl.template);

                    stTemplateMap.put(stTemplate.getName(), stTemplate);

                    final TemplateVisitor visitor = new TemplateVisitor();
                    visitor.visit(st);

                    final Map<String, STParameter> stParameterMap = new LinkedHashMap<>();
                    for (Expression expression : visitor.getExpressions()) {
                        if (debug) System.out.println(debug(expression.getAst(), 0));

                        if (!expression.getMethodCalls().isEmpty()) {
                            for (MethodCall methodCall : expression.getMethodCalls()) {
                                stTemplateMethodCalls.putIfAbsent(stTemplate, new LinkedHashSet<>());
                                stTemplateMethodCalls.get(stTemplate).add(methodCall);
                            }
                            continue;
                        }

                        final STParameter stParameter = new STParameter().setName(expression.getName()).addArgumentTypes("Object");
                        if (expression.getSubTemplate() == null)
                            stParameter.setType(STParameterType.SINGLE);
                        else if (expression.getSubTemplate().getExpressions().size() == 1)
                            stParameter.setType(STParameterType.LIST);
                        else {
                            stParameter.setType(STParameterType.KVLIST);
                            expression.getSubTemplate()
                                    .getExpressions()
                                    .forEach(kvExpression -> kvExpression.getProps().values().forEach(key -> {
                                        stParameter.getKeys()
                                                .filter(stParameterKey -> stParameterKey.getName().equals(key))
                                                .findFirst()
                                                .orElseGet(() -> {
                                                    final STParameterKey newKey = newSTParameterKey()
                                                            .setName(key)
                                                            .addArgumentTypes("Object");
                                                    stParameter.addKeys(newKey);
                                                    return newKey;
                                                });
                                    }));
                        }
                        stParameterMap.put(expression.getName(), stParameter);
                    }
                    stParameterMap.values().forEach(stTemplate::addParameters);

                    stGroupModel.addTemplates(stTemplate);
                });

        for (Map.Entry<STTemplate, Set<MethodCall>> entry : stTemplateMethodCalls.entrySet()) {
            final STTemplate caller = entry.getKey();
            entry.getValue().forEach(methodCall -> {
                final String methodCallName = methodCall.getName();
                final STTemplate methodCallTemplate = stTemplateMap.get(methodCallName);
                for (String argument : methodCall.getArguments()) {
                    final Optional<STParameter> methodParameter = methodCallTemplate.getParameters().filter(stParameter -> stParameter.getName().equals(argument)).findFirst();
                    final Optional<STParameter> callerArgument = caller.getParameters().filter(stParameter -> stParameter.getName().equals(argument)).findFirst();

                    if (!callerArgument.isPresent() && methodParameter.isPresent())
                        caller.addParameters(methodParameter.get());
                }
            });
        }

        if (parseResult.getErrors().count() == 0)
            parseResult.setParsed(stGroupModel);

        return parseResult;
    }

    private static char loadDelimiter(File stgFile) {
        try {
            final String s = FileUtil.readString(stgFile);
            // delimiters "~", "~"
            final String pattern = "delimiters \"";
            final int start = s.indexOf(pattern) + pattern.length();
            return s.charAt(start);
        } catch (Throwable e) {
            System.out.println("illegal format in file " + stgFile.getAbsolutePath());
            return '~';
        }
    }

    private static String debug(AstNode astNode, int level) {
        final StringBuilder out = new StringBuilder();
        for (int i = 0; i < level; i++)
            out.append("\t");
        out.append(astNode.getType());
        astNode.getChildren().forEach(astNode1 -> out.append("\n").append(debug(astNode1, level + 1)));
        return out.toString();
    }

    static final class TemplateVisitor {

        private static final int EXPR = 41;
        private static final int NAME = 25;
        private static final int SUBTEMPLATE = 55;
        private static final int OPTIONS = 51;
        private static final int ARGS = 38;
        private static final int PROP = 52;
        private static final int INCLUDE = 42;

        private static final int nameIndex = 0;
        private static final int keyNameIndex = 1;

        private final Stack<AstNode> astNodeStack = new Stack<>();
        private final Set<AstNode> rootExpressions = new LinkedHashSet<>();

        public void visit(ST st) {
            visit(st.impl.ast);
        }

        public Set<Expression> getExpressions() {
            return rootExpressions
                    .stream()
                    .map(this::asExpression)
                    .collect(Collectors.toSet());
        }

        private Expression asExpression(AstNode astNode) {

            final Expression expression = new Expression().setAst(astNode);

            astNode.getChildren().forEach(child -> {
                if (child.getType().equals(AstNodeType.Subtemplate))
                    expression.setSubTemplate(asSubtemplate(child));
                else if (child.getType().equals(AstNodeType.Options))
                    expression.setOptions(child.getChildren().get(nameIndex).getAst().getText());
                else if (child.getType().equals(AstNodeType.Name))
                    expression.setName(astNode.getChildren().get(nameIndex).getAst().getText());
                else if (child.getType().equals(AstNodeType.Prop))
                    expression.addProps(child.getChildren().get(nameIndex).getAst().getText(), child.getChildren().get(keyNameIndex).getAst().getText());
                else if (child.getType().equals(AstNodeType.Include)) {

                    final List<AstNode> children = child.getChildren();
                    final MethodCall methodCall = new MethodCall().setName(children.get(0).getAst().getText());
                    expression.addMethodCalls(methodCall);

                    for (int i = 1; i < children.size(); i++) {
                        AstNode node = children.get(i);
                        methodCall.addArguments(node.getAst().getText());
                    }
                } else
                    System.out.println("unhandled expression child " + child.getType());
            });

            return expression;
        }

        private Subtemplate asSubtemplate(AstNode astNode) {

            final Subtemplate subtemplate = new Subtemplate().setAst(astNode);

            astNode.getChildren().forEach(child -> {
                if (child.getType().equals(AstNodeType.Args))
                    subtemplate.addArgs(child.getAst().getText());
                else if (child.getType().equals(AstNodeType.Expression))
                    subtemplate.addExpressions(asExpression(child));
                else if (child.getType().equals(AstNodeType.Prop))
                    subtemplate.addProps(child.getChildren().get(nameIndex).getAst().getText(), child.getChildren().get(keyNameIndex).getAst().getText());
                else {
                    System.out.println(debug(astNode, 0));
                    System.out.println("unhandled subtemplate child " + child.getType());
                }
            });

            return subtemplate;
        }

        private void visit(Tree ast) {
            switch (ast.getType()) {
                case ARGS:
                    pushAstNode(ast, AstNodeType.Args);
                    break;

                case NAME:
                    pushAstNode(ast, AstNodeType.Name);
                    break;

                case OPTIONS:
                    pushAstNode(ast, AstNodeType.Options);
                    break;

                case PROP:
                    pushAstNode(ast, AstNodeType.Prop);
                    break;

                case EXPR:
                    pushAstNode(ast, AstNodeType.Expression);
                    break;

                case SUBTEMPLATE:
                    pushAstNode(ast, AstNodeType.Subtemplate);
                    break;

                case INCLUDE:
                    pushAstNode(ast, AstNodeType.Include);
                    break;

                default:
                    for (int i = 0; i < ast.getChildCount(); i++)
                        visit(ast.getChild(i));
                    break;
            }
        }

        private void pushAstNode(Tree ast, AstNodeType astNodeType) {

            final AstNode astNode = newAstNode(astNodeType, ast);

            for (int i = 0; i < ast.getChildCount(); i++)
                visit(ast.getChild(i));

            astNodeStack.pop();

            if (AstNodeType.Expression.equals(astNodeType) && isRootExpression())
                rootExpressions.add(astNode);
        }

        private boolean isRootExpression() {

            for (AstNode astNode : astNodeStack)
                if (astNode.getType().equals(AstNodeType.Expression))
                    return false;

            return true;
        }

        private AstNode newAstNode(AstNodeType astNodeType, Tree ast) {

            final AstNode astNode = STParserFactory.newAstNode().setType(astNodeType).setAst(ast);

            if (!astNodeStack.isEmpty()) {
                astNodeStack.peek().addChildren(astNode);
                astNode.setParent(astNodeStack.peek());
            }

            astNodeStack.push(astNode);

            return astNode;
        }
    }
}