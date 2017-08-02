Codegen project

Tasks:

* Assign to template in both directions
* index in AppMotif.Properties.name, _Value
* VK_F search for name-property

* implement undo:
class Commit {
               private final Set<Node> deletedNodes;
               private final Set<Relationship> deletedRelations;

               public Commit(Set<Node> deletedNodes, Set<Relationship> deletedRelations) {
                  this.deletedNodes = new LinkedHashSet<>(deletedNodes);
                  this.deletedRelations = new LinkedHashSet<>(deletedRelations);
               }

               void undo() {
                  for (Node deletedNode : deletedNodes) {
                     final Node node = model.graph().getGraphDb().createNode();
                  }
               }
            }

            private final Stack<Commit> history = new Stack<>();



* Create browser-editor (example):
https://github.com/behavior3/behavior3editor

http://www.material-ui.com/#/
http://formidable.com/open-source/victory/
https://material.io/
http://nd4j.org/
https://deeplearning4j.org/gpu

TEST:
* Add constraint på template group som definerer type av parametre
  Ex: Cpp - add public, må ta inn elementer av Method

* Possible bug: labels not updating when set
* Autosave curent layout
* Persist last db path used for auto open in ~/.nextgen/properties.json
* Add PNode label
  - Render custom name as alternative to parameter value