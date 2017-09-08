package com.generator.generators.stringtemplate.parser;

public class STGBaseListener extends STGParserBaseListener {

   public static class Node {

      public final String name;
      public final String value;
      public final String startToken;
      public final java.util.Set<Node> children = new java.util.LinkedHashSet<>();

      public Node(String name, String value, String startToken) {
         this.name = name;
         this.value = value;
			this.startToken = startToken;
      }
   }

   private final java.util.Stack<Node> nodeStack = new java.util.Stack<>();

   void onEnter(Node node) {
      if (!nodeStack.isEmpty()) nodeStack.peek().children.add(node);
      nodeStack.push(node);
   }

   void onExit() {
      if (nodeStack.size() > 1) nodeStack.pop();
   }

   public Node getRoot() {
      return nodeStack.peek();
   }

	@Override
	public void enterTemplate(com.generator.generators.stringtemplate.parser.STGParser.TemplateContext arg) {
		 //System.out.println("Template");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Template", arg.getText(), arg.getStart().getText()));
	}

	public void exitTemplate(com.generator.generators.stringtemplate.parser.STGParser.TemplateContext arg) {
		 onExit();
	}

	@Override
	public void enterGroup(com.generator.generators.stringtemplate.parser.STGParser.GroupContext arg) {
		 //System.out.println("Group");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Group", arg.getText(), arg.getStart().getText()));
	}

	public void exitGroup(com.generator.generators.stringtemplate.parser.STGParser.GroupContext arg) {
		 onExit();
	}

	@Override
	public void enterDelimiters(com.generator.generators.stringtemplate.parser.STGParser.DelimitersContext arg) {
		 //System.out.println("Delimiters");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Delimiters", arg.getText(), arg.getStart().getText()));
	}

	public void exitDelimiters(com.generator.generators.stringtemplate.parser.STGParser.DelimitersContext arg) {
		 onExit();
	}

	@Override
	public void enterImports(com.generator.generators.stringtemplate.parser.STGParser.ImportsContext arg) {
		 //System.out.println("Imports");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Imports", arg.getText(), arg.getStart().getText()));
	}

	public void exitImports(com.generator.generators.stringtemplate.parser.STGParser.ImportsContext arg) {
		 onExit();
	}

	@Override
	public void enterFormalArgs(com.generator.generators.stringtemplate.parser.STGParser.FormalArgsContext arg) {
		 //System.out.println("FormalArgs");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FormalArgs", arg.getText(), arg.getStart().getText()));
	}

	public void exitFormalArgs(com.generator.generators.stringtemplate.parser.STGParser.FormalArgsContext arg) {
		 onExit();
	}

	@Override
	public void enterFormalArg(com.generator.generators.stringtemplate.parser.STGParser.FormalArgContext arg) {
		 //System.out.println("FormalArg");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("FormalArg", arg.getText(), arg.getStart().getText()));
	}

	public void exitFormalArg(com.generator.generators.stringtemplate.parser.STGParser.FormalArgContext arg) {
		 onExit();
	}

	@Override
	public void enterDict(com.generator.generators.stringtemplate.parser.STGParser.DictContext arg) {
		 //System.out.println("Dict");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Dict", arg.getText(), arg.getStart().getText()));
	}

	public void exitDict(com.generator.generators.stringtemplate.parser.STGParser.DictContext arg) {
		 onExit();
	}

	@Override
	public void enterDictPairs(com.generator.generators.stringtemplate.parser.STGParser.DictPairsContext arg) {
		 //System.out.println("DictPairs");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("DictPairs", arg.getText(), arg.getStart().getText()));
	}

	public void exitDictPairs(com.generator.generators.stringtemplate.parser.STGParser.DictPairsContext arg) {
		 onExit();
	}

	@Override
	public void enterKeyValuePair(com.generator.generators.stringtemplate.parser.STGParser.KeyValuePairContext arg) {
		 //System.out.println("KeyValuePair");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("KeyValuePair", arg.getText(), arg.getStart().getText()));
	}

	public void exitKeyValuePair(com.generator.generators.stringtemplate.parser.STGParser.KeyValuePairContext arg) {
		 onExit();
	}

	@Override
	public void enterDefaultValuePair(com.generator.generators.stringtemplate.parser.STGParser.DefaultValuePairContext arg) {
		 //System.out.println("DefaultValuePair");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("DefaultValuePair", arg.getText(), arg.getStart().getText()));
	}

	public void exitDefaultValuePair(com.generator.generators.stringtemplate.parser.STGParser.DefaultValuePairContext arg) {
		 onExit();
	}

	@Override
	public void enterKeyValue(com.generator.generators.stringtemplate.parser.STGParser.KeyValueContext arg) {
		 //System.out.println("KeyValue");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("KeyValue", arg.getText(), arg.getStart().getText()));
	}

	public void exitKeyValue(com.generator.generators.stringtemplate.parser.STGParser.KeyValueContext arg) {
		 onExit();
	}

}