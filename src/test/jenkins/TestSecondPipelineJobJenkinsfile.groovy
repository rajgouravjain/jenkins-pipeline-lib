package jenkins

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test

import com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration
import com.lesfurets.jenkins.unit.global.lib.ProjectSource

class TestSecondPipelineJobJenkinsfile extends BasePipelineTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        //helper.registerAllowedMethod("sh", [Map.class], {c -> "bcc19744"})
        binding.setVariable('scm', {})
        helper.registerAllowedMethod("timeout", [Map.class, Closure.class], null)
        helper.registerAllowedMethod("timestamps", [Closure.class], { it -> it() })
        helper.registerAllowedMethod('checkout', [Closure.class], null)
        helper.registerAllowedMethod('tool', [Map.class], { t -> "${t.name}_HOME" })
        helper.registerAllowedMethod('tool', [String.class], { t -> "${t}_HOME" })
        //helper.registerAllowedMethod("library", [String.class], {String expression ->
        //    helper.getLibLoader().loadLibrary(expression)
        //    println helper.getLibLoader().libRecords
        //    return new LibClassLoader(helper,null)
        //})
        //helper.registerAllowedMethod(method("readFile", String.class), { file ->
        //    return Files.contentOf(new File(file), Charset.forName("UTF-8"))
        //})
        //helper.registerAllowedMethod("customMethodWithArguments", [String, int, Collection], { String stringArg, int intArg, Collection collectionArg ->
        //    return println "executing mock closure with arguments (arguments: '${stringArg}', '${intArg}', '${collectionArg}')"
        //})

        // TODO: Find a better way of getting project root dir
        String dirPath = new File( System.getProperty("user.dir") )
                .getAbsoluteFile()
                .getParentFile()
                .getAbsolutePath()
        def source = ProjectSource.projectSource(dirPath);
        def libDesc = new LibraryConfiguration();
        libDesc.name = 'jenkins-pipeline-lib';
        libDesc.retriever = source;
        //libDesc.defaultVersion = '';
        libDesc.allowOverride = false;
        libDesc.implicit = true;
        helper.registerSharedLibrary(libDesc)

    }
    @Test
    void should_execute_without_errors() throws Exception {

        runScript("src/main/jenkins/SecondPipelineJob/Jenkinsfile")
        printCallStack()
    }
}