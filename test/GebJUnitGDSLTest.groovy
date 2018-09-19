import geb.junit4.GebReportingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class GebJUnitGDSLTest extends GebReportingTest {

    @Test
    void printsSomething() {

        println testFirstContent // grayed
        testFirstMethod() // grayed

        to FirstPage
        println testFirstContent
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
        testSecondMethod()
        println testSecondContent
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