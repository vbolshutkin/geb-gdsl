import geb.Page

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

    void testBrowserDrive() {
        browser.drive {
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

class ThirdPage extends Page {

    static content = {
        testThirdContent { "something" }
    }

    void testThirdMethod() {
        println "something else"
    }

}