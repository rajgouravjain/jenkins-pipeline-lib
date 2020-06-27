import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test


class TestFirstJob extends BasePipelineTest {

    @Override
    @Before
    public void setUp() throws  Exception {
        super.setUp();
    }

    @Test
    void should_execute_without_errors() throws Exception {
        runScript('pipelne_jobs/FirstJob.groovy')
        printCallStack()
    }
}
