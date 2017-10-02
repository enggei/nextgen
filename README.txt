
// todo:
NeoModel - functional comitter
Meny - remote-connection

Neo4J Playground for testing all things Neo.

1) Install neo4j docker
---------------------------------------------------
Ref: http://wiki.itware.no/Docker_(installing)

Ref: http://wiki.itware.no/Docker#Neo4j

sudo mkdir -p /opt/docker/nextgen-neo4j/data
sudo chown -R user:user /opt/docker/nextgen-neo4j

docker run -d --name nextgen-neo4j \
  --publish=7474:7474 --publish=7687:7687 \
  --volume=/opt/docker/nextgen-neo4j/data:/data \
neo4j:latest


2) Logon via web admin and change default password:
---------------------------------------------------
http://localhost:7474

Log in with neo4j/neo4j

Change password on first logon to "gu11/K0de" (ref NeoModelTests.java)

Codegen project

Tasks:

* Assign to template in both directions
* index in AppMotif.Properties.name, _Value

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