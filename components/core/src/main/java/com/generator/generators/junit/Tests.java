package com.generator.generators.junit;

import com.generator.util.FileUtil;

import java.io.File;
import java.io.IOException;

public class Tests {

    public static void main(String[] args) throws IOException {


        new JUnitGroup().toSTGFile(FileUtil.tryToCreateFileIfNotExists(new File("/home/goe/projects/nextgen/components/core/src/main/java/com/generator/generators/junit/")));
    }
}
