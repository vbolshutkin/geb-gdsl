import geb.Page
import geb.junit4.GebReportingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

class MyPage extends Page {

    static content = {
        testContent { "something" }
    }

    void testMethod() {
        println "something else"
    }

    void testFrame() {
        withFrame($('iframe')) {
            page SecondPage
            println testSecondContent
            testSecondMethod()
        }
    }

}

class SecondPage extends Page {

    static content = {
        testSecondContent { "something" }
    }

    void testSecondMethod() {
        println "something else"
    }

}

@RunWith(JUnit4)
class GebGDSLTest extends GebReportingTest {

    @Test
    void printsSomething() {

        println testContent // grayed
        testMethod() // grayed

        to MyPage
        println testContent
        testMethod()

        at SecondPage

        println testContent // grayed
        testMethod() // grayed

    }

}