import geb.Page

class MyPage extends Page {

    static content = {
        testContent { "something" }
    }

    void testMethod() {
        println "something else"
    }
}
