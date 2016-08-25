goal:


# Clean GUI which embedds NeoGenerator, and wraps simple actions around methods.
# view templates in various layouts (flow-left-to-right, flow-top-down, circular etc)
# Allow to attach nodes to properties (string,list,keyValues)
# test Neo on other groups (Protobuf, EasyFlow)

use jgoodies for Forms
http://nd4j.org/getstarted.html
http://graphstream-project.org/doc/


DONE:
# clean facade over GraphDatabaseService
# only provide thinnest layer with nodes + Labels + relations
# allow to create new template-nodes

# as one does not know if its stringvalues or node to refer to, one should not encapsulate, but rather provide visitors, and static domain-methods ?

# StringProperties as relations to other nodes
# ListProperties as relations to other nodes (value-node has property "value")
# KeyValueProperties as relations with key-values (key-value-node has key-values as property-names, and value-values as values for properties)