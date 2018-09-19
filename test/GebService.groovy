import geb.Browser

class GebService {

    static doSomething() {
        Browser.drive {
            to FirstPage
            println testFirstContent
            testFirstMethod()
        }
    }

}
