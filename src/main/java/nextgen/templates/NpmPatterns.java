package nextgen.templates;

import nextgen.utils.FileUtil;
import nextgen.templates.npm.*;
import nextgen.templates.npm.WebpackConfig;
import nextgen.templates.npm.Dependency;
import nextgen.templates.npm.NpmST;

import java.io.File;

import static nextgen.utils.FileUtil.tryToCreateDirIfNotExists;

public class NpmPatterns extends NpmST {

    public static void generate(NpmProject project) {

        tryToCreateDirIfNotExists(new File(project.getRoot()));

        writePackageJson(project.getPackageJson(), project.getRoot());
        writeWebpackConfig(project.getWebpackConfig(), project.getRoot());
        writeBabelrc(project.getBabelrc(), project.getRoot());
    }

    private static void writePackageJson(PackageJson packageJson, String root) {
        FileUtil.write(packageJson, new File(root, "package.json"));
    }

    private static void writeWebpackConfig(WebpackConfig webpackConfig, String root) {
        FileUtil.write(webpackConfig, new File(root, "webpack.config.js"));
    }

    private static void writeBabelrc(Babelrc babelrc, String root) {
        FileUtil.write(babelrc, new File(root, ".babelrc"));
    }

    public static Dependency newDependency(String name, String version) {
        return newDependency()
                .setName(name)
                .setVersion(version);
    }
}