package com.generator.generators.json.parser;

public class JSONNodeListener extends JSONBaseListener {

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
	public void enterPair(com.generator.generators.json.parser.JSONParser.PairContext arg) {
		 //System.out.println("Pair");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Pair", arg.getText(), arg.getStart().getText()));
	}

	public void exitPair(com.generator.generators.json.parser.JSONParser.PairContext arg) {
		 onExit();
	}

	@Override
	public void enterArray(com.generator.generators.json.parser.JSONParser.ArrayContext arg) {
		 //System.out.println("Array");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Array", arg.getText(), arg.getStart().getText()));
	}

	public void exitArray(com.generator.generators.json.parser.JSONParser.ArrayContext arg) {
		 onExit();
	}

	@Override
	public void enterValue(com.generator.generators.json.parser.JSONParser.ValueContext arg) {
		 //System.out.println("Value");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Value", arg.getText(), arg.getStart().getText()));
	}

	public void exitValue(com.generator.generators.json.parser.JSONParser.ValueContext arg) {
		 onExit();
	}

	@Override
	public void enterJson(com.generator.generators.json.parser.JSONParser.JsonContext arg) {
		 //System.out.println("Json");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Json", arg.getText(), arg.getStart().getText()));
	}

	public void exitJson(com.generator.generators.json.parser.JSONParser.JsonContext arg) {
		 onExit();
	}

	@Override
	public void enterObj(com.generator.generators.json.parser.JSONParser.ObjContext arg) {
		 //System.out.println("Obj");
		 //System.out.println("\t"+ arg.getText());
		 onEnter(new Node("Obj", arg.getText(), arg.getStart().getText()));
	}

	public void exitObj(com.generator.generators.json.parser.JSONParser.ObjContext arg) {
		 onExit();
	}

}