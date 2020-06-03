package nextgen.st;

import com.generator.util.FileUtil;
import nextgen.st.domain.*;
import nextgen.st.parser.AstNode;
import nextgen.st.parser.AstNodeType;
import nextgen.st.parser.STParserFactory;
import org.antlr.runtime.tree.Tree;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.misc.STMessage;

import java.io.File;
import java.util.*;

public class STParser {

    public static boolean debug = true;

    public static void main(String[] args) {

        STParser.parse(new File("/home/goe/projects/nextgen/components/core/src/test/java/tmp/st/test/Test.stg"));
//        STParser.parse(new File("/home/goe/projects/nextgen/components/core/src/test/java/tmp/st/java/Java.stg"));
    }

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

        stGroup.getTemplateNames()
                .stream()
                .map(stGroup::getInstanceOf)
                .filter(stTemplate -> !(stTemplate.getName().equals("/eom") || stTemplate.getName().equals("/gt")))
                .filter(st -> !st.isAnonSubtemplate())
                .filter(st -> st.impl.ast != null)
                .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                .forEach(st -> {

                    System.out.println("\n--- " + st.getName());
                    System.out.println(st.impl.template);

                    final TemplateVisitor visitor = new TemplateVisitor();
                    visitor.visit(st);

                    final STTemplate stTemplate = new STTemplate()
                            .setName(st.getName().substring(1))
                            .setText(st.impl.template);

                    final Map<String, STParameter> stParameterMap = new LinkedHashMap<>();
                    visitor.astNodeStack.peek().getChildren().forEach(astNode -> addParameters(stParameterMap, astNode, new Stack<STParameter>()));
                    stParameterMap.values().forEach(stTemplate::addParameters);

                    System.out.println("=== >");
                    stTemplate.getParameters().forEach(stParameter -> {
                        System.out.print("\t" + stParameter.getName() + " " + stParameter.getType());
                        stParameter.getKeys().forEach(stParameterKey -> System.out.print(" ." + stParameterKey.getName()));
                        System.out.println();
                    });

                    stTemplateMap.put(stTemplate.getName(), stTemplate);

                    stGroupModel.addTemplates(stTemplate);
                });

        if (parseResult.getErrors().count() == 0)
            parseResult.setParsed(stGroupModel);

        return parseResult;
    }

    private static void addParameters(Map<String, STParameter> stParameterMap, AstNode astNode, Stack<STParameter> stParameters) {

        switch (astNode.getType()) {
            case Expression:

                final String expressionName = astNode.getChildren().get(0).getAst().toString();

                final boolean inSubtemplate = astNode.getParent().getType().equals(AstNodeType.Subtemplate);
                if (inSubtemplate && expressionName.equals(astNode.getParent().getChildren().get(0).getAst().getChild(0).toString())) {
                    for (AstNode child : astNode.getChildren())
                        addParameters(stParameterMap, child, stParameters);
                } else {

                    if (astNode.getChildren().get(0).getType().equals(AstNodeType.Name)) {

                        stParameterMap.putIfAbsent(expressionName, new STParameter().setName(expressionName).setType(STParameterType.SINGLE));
                        stParameters.push(stParameterMap.get(expressionName));

                        for (AstNode child : astNode.getChildren())
                            addParameters(stParameterMap, child, stParameters);

                        stParameters.pop();
                    } else {
                        for (AstNode child : astNode.getChildren())
                            addParameters(stParameterMap, child, stParameters);
                    }
                }
                break;

            case Prop:
                stParameters.peek().setType(STParameterType.KVLIST);

                final STParameterKey parameterKey = new STParameterKey()
                        .setName(astNode.getChildren().get(1).getAst().toString())
                        .addArgumentTypes("Object");

                final Optional<STParameterKey> exists = stParameters.peek().getKeys()
                        .filter(stParameterKey -> stParameterKey.getName().equals(parameterKey.getName()))
                        .findFirst();

                if (!exists.isPresent())
                    stParameters.peek().addKeys(parameterKey);
                break;

            case ElseIf:
            case If:

                final String ifName = astNode.getChildren().get(0).getAst().toString();
                stParameterMap.putIfAbsent(ifName, new STParameter().setName(ifName).setType(STParameterType.SINGLE));

                stParameters.push(stParameterMap.get(ifName));
                for (AstNode child : astNode.getChildren())
                    addParameters(stParameterMap, child, stParameters);
                stParameters.pop();

                break;

            case Else:
                for (AstNode child : astNode.getChildren())
                    addParameters(stParameterMap, child, stParameters);
                break;

            case Assign:

                final AstNode assignment = astNode.getChildren().get(1);
                if (assignment.getType().equals(AstNodeType.Name)) {
                    final String assignName = assignment.getAst().toString();
                    stParameterMap.putIfAbsent(assignName, new STParameter().setName(assignName).setType(STParameterType.SINGLE));
                }

                for (AstNode child : astNode.getChildren())
                    addParameters(stParameterMap, child, stParameters);

                break;

            case Include:
                final List<AstNode> children = astNode.getChildren();
                for (int i = 1; i < children.size(); i++) {
                    AstNode child = children.get(i);
                    if (child.getType().equals(AstNodeType.Name)) {
                        final String assignName = child.getAst().toString();
                        stParameterMap.putIfAbsent(assignName, new STParameter().setName(assignName).setType(STParameterType.SINGLE));
                    } else
                        addParameters(stParameterMap, child, stParameters);
                }

                break;

            case Subtemplate:
                if (!stParameters.isEmpty()) stParameters.peek().setType(STParameterType.LIST);
                for (AstNode child : astNode.getChildren())
                    addParameters(stParameterMap, child, stParameters);
                break;
        }
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
        out.append(astNode.getType()).append(" \"").append(astNode.getAst().getText()).append("\"");
        astNode.getChildren().forEach(astNode1 -> out.append("\n").append(debug(astNode1, level + 1)));
        return out.toString();
    }

    static final class TemplateVisitor {

        private static final int EXPR = 41;
        private static final int NAME = 25;
        private static final int SUBTEMPLATE = 55;
        private static final int ARGS = 38;
        private static final int PROP = 52;
        private static final int INCLUDE = 42;
        private static final int IF = 4;
        private static final int ELSE = 5;
        private static final int ELSEIF = 6;
        private static final int ASSIGN = 12;

        private final Stack<AstNode> astNodeStack = new Stack<>();

        public void visit(ST st) {
            astNodeStack.push(STParserFactory.newAstNode().setType(AstNodeType.ST));
            visit(st.impl.ast);
        }

        private void visit(Tree ast) {
            switch (ast.getType()) {
                case ARGS:
                    pushAstNode(ast, AstNodeType.Args);
                    break;

                case NAME:
                    pushAstNode(ast, AstNodeType.Name);
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

                case IF:
                    pushAstNode(ast, AstNodeType.If);
                    break;

                case ELSE:
                    pushAstNode(ast, AstNodeType.Else);
                    break;

                case ELSEIF:
                    pushAstNode(ast, AstNodeType.ElseIf);
                    break;

                case ASSIGN:
                    pushAstNode(ast, AstNodeType.Assign);
                    break;

                case 51:
                case 22:
                    break;

                case 0:
                case 26:
                case 31:
                case 32:
                case 47:
                case 49:
                    for (int i = 0; i < ast.getChildCount(); i++)
                        visit(ast.getChild(i));
                    break;

                default:
                    System.out.println("case U" + ast.getType() + ":\npushAstNode(ast, AstNodeType.U" + ast.getType() + ");\nbreak;");
                    System.out.println("private static final int U" + ast.getType() + " = " + ast.getType() + ";");
                    for (int i = 0; i < ast.getChildCount(); i++)
                        visit(ast.getChild(i));
                    break;
            }
        }

        private void pushAstNode(Tree ast, AstNodeType astNodeType) {

            newAstNode(astNodeType, ast);

            for (int i = 0; i < ast.getChildCount(); i++)
                visit(ast.getChild(i));

            astNodeStack.pop();
        }

        private void newAstNode(AstNodeType astNodeType, Tree ast) {

            final AstNode astNode = STParserFactory.newAstNode().setType(astNodeType).setAst(ast);

            System.out.println(debug(astNode, astNodeStack.size()));

            if (!astNodeStack.isEmpty()) {
                astNodeStack.peek().addChildren(astNode);
                astNode.setParent(astNodeStack.peek());
            }

            astNodeStack.push(astNode);
        }
    }
}