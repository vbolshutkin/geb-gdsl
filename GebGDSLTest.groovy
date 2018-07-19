import geb.Page
import geb.junit4.GebReportingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

class FirstPage extends Page {

    static content = {
        testFirstContent { "something" }
        testFrame(page: ThirdPage) { $('iframe') }
        testAutocomplete(required: true, to: FirstPage) {}
    }

    void testFirstMethod() {
        println "something else"
    }

    void testFrame() {
        withFrame($('iframe')) {
            page SecondPage
            println testSecondContent
            testSecondMethod()
        }
    }

    void testFrame2() {
        withFrame(testFrame) {
            println testThirdContent
            testThirdMethod()
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

class ThirdPage extends Page {

    static content = {
        testThirdContent { "something" }
    }

    void testThirdMethod() {
        println "something else"
    }

}

@RunWith(JUnit4)
class GebGDSLTest extends GebReportingTest {

    @Test
    void printsSomething() {

        println testFirstContent // grayed
        testFirstMethod() // grayed

        to FirstPage
        println testContent
        testFirstMethod()

        at SecondPage

        println testFirstContent // grayed
        testFirstMethod() // grayed

        // control structures are transparent for discovered page
        if (2>1) {
            testSecondMethod()
            println testSecondContent
        }

        // as well as closures
        1.times {
            testSecondMethod()
            println testSecondContent
        }


    }

    @Test
    void testPageSwitchedInPreviousMethod() {
        testSecondMethod() // TODO should be grayed
        println testSecondContent // TODO should be grayed
    }

    @Test
    void testImpossiblePageSwitch() {
        to SecondPage


        if (1>2) {
            to FirstPage
        }

        testSecondMethod() // XXX Undefined behavior
        println testSecondContent // XXX Undefined behavior

        testFirstMethod() // XXX Undefined behavior
        println testFirstContent // XXX Undefined behavior
    }

}