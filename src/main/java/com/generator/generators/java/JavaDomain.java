package com.generator.generators.java;

import com.generator.editors.domain.MetaDomain;
import com.generator.editors.domain.MetaNode;
import com.generator.editors.domain.MetaProperty;
import com.generator.editors.domain.NeoModel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import java.util.UUID;

import static com.generator.editors.domain.MetaRelation.Cardinality.OneToMany;
import static com.generator.editors.domain.MetaRelation.Cardinality.OneToOne;
import static com.generator.editors.domain.MetaRelation.Direction.OneWay;
import static com.generator.generators.java.JavaDomain.ENTITIES.*;
import static com.generator.generators.java.JavaDomain.RELATIONS.*;

/**
 * Java domain
 */
public class JavaDomain extends MetaDomain<JavaDomain.ENTITIES, JavaDomain.RELATIONS> {

    public enum ENTITIES {
        PACKAGE, CLASS, INTERFACE, METHOD, ENUM_VALUE, ENUM, FILE
    }

    public enum RELATIONS implements RelationshipType {
        MEMBER, IMPLEMENTS, DECLARES, VALUE, FIELD, CONTAINS, RETURNS
    }

    public JavaDomain(final NeoModel model) {
        super(model, "JavaDomain");

        try (Transaction tx = model.beginTx()) {

            addMetaNode(ENTITIES.PACKAGE, UUID.randomUUID())
                    .addProperty(new MetaProperty("templateFile").setType("String"))
                    .addProperty(new MetaProperty("name").setType("String"));
            addMetaNode(ENTITIES.CLASS, UUID.randomUUID())
                    .addProperty(new MetaProperty("name").setType("String"))
                    .addProperty(new MetaProperty("scope","private", "package", "protected", "public").setType("Scope"))
                    .addProperty(new MetaProperty("abstract", "false").setType("boolean"))
                    .addProperty(new MetaProperty("final", "true").setType("boolean"))
                    .addProperty(new MetaProperty("static", "false").setType("boolean"));
            addMetaNode(ENTITIES.INTERFACE, UUID.randomUUID())
                    .addProperty(new MetaProperty("name").setType("String"));
            addMetaNode(ENTITIES.METHOD, UUID.randomUUID())
                    .addProperty(new MetaProperty("name").setType("String"))
                    .addProperty(new MetaProperty("scope","private", "package", "protected", "public").setType("Scope"))
                    .addProperty(new MetaProperty("abstract", "false").setType("boolean"))
                    .addProperty(new MetaProperty("final", "true").setType("boolean"))
                    .addProperty(new MetaProperty("static", "false").setType("boolean"));
            addMetaNode(ENTITIES.ENUM_VALUE, UUID.randomUUID())
                    .addProperty(new MetaProperty("name").setType("String"));
            addMetaNode(ENTITIES.ENUM, UUID.randomUUID())
                    .addProperty(new MetaProperty("name").setType("String"));
            addMetaNode(ENTITIES.FILE, UUID.randomUUID())
                    .addProperty(new MetaProperty("name").setType("String"));

            addMetaRelation(MEMBER, newNodeSet(PACKAGE), newNodeSet(ENUM,INTERFACE,CLASS), OneToMany, OneWay);
            addMetaRelation(IMPLEMENTS, newNodeSet(CLASS), newNodeSet(INTERFACE), OneToMany, OneWay);
            addMetaRelation(DECLARES, newNodeSet(CLASS,INTERFACE), newNodeSet(METHOD), OneToMany, OneWay);
            addMetaRelation(VALUE, newNodeSet(ENUM), newNodeSet(ENUM_VALUE), OneToMany, OneWay);
            addMetaRelation(FIELD, newNodeSet(CLASS), newNodeSet(CLASS,INTERFACE,ENUM), OneToMany, OneWay);
            addMetaRelation(CONTAINS, newNodeSet(FILE), newNodeSet(ENUM,INTERFACE,CLASS,METHOD), OneToMany, OneWay);
            addMetaRelation(RETURNS, newNodeSet(METHOD), newNodeSet(ENUM,INTERFACE,CLASS), OneToOne, OneWay);

            validate();

            tx.success();
        }
    }

    @Override
    protected final ENTITIES entity(String s) {
        return ENTITIES.valueOf(s);
    }

    @Override
    protected final RELATIONS relation(String s) {
        return RELATIONS.valueOf(s);
    }

    @Override
    public final MetaNode<ENTITIES> getRootNode() {
        return getNode(FILE);
    }

    @Override
    public final boolean isConstrained(Node node) {
        return super.isConstrained(node);
    }

    public Node addPACKAGE(UUID uuid, String _templateFile, String _name) {
        return newNode(ENTITIES.PACKAGE, uuid, "templateFile", (_templateFile == null || _templateFile.trim().length()==0) ? "[]" : _templateFile, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name);
    }

    public Node addCLASS(UUID uuid, String _name, String _abstract, String _final, String _static) {
        return newNode(ENTITIES.CLASS, uuid, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name, "abstract", (_abstract == null || _abstract.trim().length()==0) ? "[]" : _abstract, "final", (_final == null || _final.trim().length()==0) ? "[]" : _final, "static", (_static == null || _static.trim().length()==0) ? "[]" : _static);
    }

    public Node addINTERFACE(UUID uuid, String _name) {
        return newNode(ENTITIES.INTERFACE, uuid, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name);
    }

    public Node addMETHOD(UUID uuid, String _name, String _abstract, String _final, String _static) {
        return newNode(ENTITIES.METHOD, uuid, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name, "abstract", (_abstract == null || _abstract.trim().length()==0) ? "[]" : _abstract, "final", (_final == null || _final.trim().length()==0) ? "[]" : _final, "static", (_static == null || _static.trim().length()==0) ? "[]" : _static);
    }

    public Node addENUM_VALUE(UUID uuid, String _name) {
        return newNode(ENTITIES.ENUM_VALUE, uuid, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name);
    }

    public Node addENUM(UUID uuid, String _name) {
        return newNode(ENTITIES.ENUM, uuid, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name);
    }

    public Node addFILE(UUID uuid, String _name) {
        return newNode(ENTITIES.FILE, uuid, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name);
    }

    public JavaDomain relatePACKAGE_MEMBER_CLASS(Node packageSrc, Node classDst) {
        relate(RELATIONS.MEMBER, packageSrc, classDst);
        return this;
    }

    public JavaDomain relatePACKAGE_MEMBER_ENUM(Node packageSrc, Node enumDst) {
        relate(RELATIONS.MEMBER, packageSrc, enumDst);
        return this;
    }

    public JavaDomain relatePACKAGE_MEMBER_INTERFACE(Node packageSrc, Node interfaceDst) {
        relate(RELATIONS.MEMBER, packageSrc, interfaceDst);
        return this;
    }


    public JavaDomain relateCLASS_Implements_INTERFACE(Node classSrc, Node interfaceDst) {
        relate(RELATIONS.IMPLEMENTS, classSrc, interfaceDst);
        return this;
    }


    public JavaDomain relateCLASS_Declares_METHOD(Node classSrc, Node methodDst) {
        relate(RELATIONS.DECLARES, classSrc, methodDst);
        return this;
    }

    public JavaDomain relateINTERFACE_Declares_METHOD(Node interfaceSrc, Node methodDst) {
        relate(RELATIONS.DECLARES, interfaceSrc, methodDst);
        return this;
    }


    public JavaDomain relateENUM_VALUE_ENUM_VALUE(Node enumSrc, Node enum_valueDst) {
        relate(RELATIONS.VALUE, enumSrc, enum_valueDst);
        return this;
    }


    public JavaDomain relateCLASS_FIELD_CLASS(Node classSrc, Node classDst) {
        relate(RELATIONS.FIELD, classSrc, classDst);
        return this;
    }

    public JavaDomain relateCLASS_FIELD_ENUM(Node classSrc, Node enumDst) {
        relate(RELATIONS.FIELD, classSrc, enumDst);
        return this;
    }

    public JavaDomain relateCLASS_FIELD_INTERFACE(Node classSrc, Node interfaceDst) {
        relate(RELATIONS.FIELD, classSrc, interfaceDst);
        return this;
    }


    public JavaDomain relateFILE_Contains_CLASS(Node fileSrc, Node classDst) {
        relate(RELATIONS.CONTAINS, fileSrc, classDst);
        return this;
    }

    public JavaDomain relateFILE_Contains_ENUM(Node fileSrc, Node enumDst) {
        relate(RELATIONS.CONTAINS, fileSrc, enumDst);
        return this;
    }

    public JavaDomain relateFILE_Contains_INTERFACE(Node fileSrc, Node interfaceDst) {
        relate(RELATIONS.CONTAINS, fileSrc, interfaceDst);
        return this;
    }

    public JavaDomain relateFILE_Contains_METHOD(Node fileSrc, Node methodDst) {
        relate(RELATIONS.CONTAINS, fileSrc, methodDst);
        return this;
    }


    public JavaDomain relateMETHOD_Returns_CLASS(Node methodSrc, Node classDst) {
        relate(RELATIONS.RETURNS, methodSrc, classDst);
        return this;
    }

    public JavaDomain relateMETHOD_Returns_ENUM(Node methodSrc, Node enumDst) {
        relate(RELATIONS.RETURNS, methodSrc, enumDst);
        return this;
    }

    public JavaDomain relateMETHOD_Returns_INTERFACE(Node methodSrc, Node interfaceDst) {
        relate(RELATIONS.RETURNS, methodSrc, interfaceDst);
        return this;
    }

}