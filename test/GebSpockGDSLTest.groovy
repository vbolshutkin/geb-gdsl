import geb.spock.GebReportingSpec

class GebSpockGDSLTest extends GebReportingSpec {

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

    void testPageSwitchedInPreviousMethod() {
        testSecondMethod() // TODO should be grayed
        println testSecondContent // TODO should be grayed
    }

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