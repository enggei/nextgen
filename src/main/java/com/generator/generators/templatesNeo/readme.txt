goal:

# create cypher- queries (and cypher-query-builder
https://neo4j.com/docs/cypher-refcard/current/

use jgoodies for Forms(FormPanel)
http://manual.openestate.org/extern/forms-1.2.1/tutorial/introduction.html

use graphstream for graph-editor
http://graphstream-project.org/doc/

// for use in browser (graph-editor)
http://bl.ocks.org/rkirsling/5001347 and http://rkirsling.github.io/modallogic/
https://github.com/jimmywarting/StreamSaver.js

DONE:

# changed all dynamic labels and relationships into property Label and RelationshipType

# refactor StringValue and create KeyValues using interfaces

# clean facade over GraphDatabaseService
# only provide thinnest layer with nodes + Labels + relations
# allow to create new template-nodes

# as one does not know if its stringvalues or node to refer to, one should not encapsulate, but rather provide visitors, and static domain-methods ?

# StringProperties as relations to other nodes
# ListProperties as relations to other nodes (value-node has property "value")
# KeyValueProperties as relations with key-values (key-value-node has key-values as property-names, and value-values as values for properties)