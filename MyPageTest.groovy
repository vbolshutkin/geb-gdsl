import geb.junit4.GebReportingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class MyPageTest extends GebReportingTest {

    @Test
    void printsSomething() {

        to MyPage
        println testContent
        testMethod()

    }

}