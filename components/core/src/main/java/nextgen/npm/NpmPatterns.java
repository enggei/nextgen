package nextgen.npm;

import com.generator.util.FileUtil;
import nextgen.npm.st.*;

import java.io.File;

import static com.generator.util.FileUtil.tryToCreateDirIfNotExists;

public class NpmPatterns extends NpmFactory {

    private static final NpmGenerator npmGenerator = new NpmGenerator();

    public static void generate(NpmProject project) {

        tryToCreateDirIfNotExists(new File(project.getRoot()));

        writePackageJson(project.getPackageJson(), project.getRoot());
        writeWebpackConfig(project.getWebpackConfig(), project.getRoot());
        writeBabelrc(project.getBabelrc(), project.getRoot());
    }

    private static void writePackageJson(packageJson packageJson, String root) {
        FileUtil.write(npmGenerator.generate(packageJson), new File(root, "package.json"));
    }

    private static void writeWebpackConfig(WebpackConfig webpackConfig, String root) {
        FileUtil.write(npmGenerator.generate(webpackConfig), new File(root, "webpack.config.js"));
    }

    private static void writeBabelrc(babelrc babelrc, String root) {
        FileUtil.write(npmGenerator.generate(babelrc), new File(root, ".babelrc"));
    }

    public static dependency newDependency(String name, String version) {
        return newDependency()
                .setName(name)
                .setVersion(version);
    }
}