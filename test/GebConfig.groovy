/*
	This is the Geb configuration file.

	See: http://www.gebish.org/manual/current/#configuration
*/


import geb.Browser
import geb.Page
import geb.navigator.EmptyNavigator
import geb.navigator.NonEmptyNavigator
import geb.report.ScreenshotReporter
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver

driver = { new FirefoxDriver() }
driver = "firefox"

innerNavigatorFactory = { Browser browser, List<WebElement> elements ->
    elements ? new NonEmptyNavigator(browser, elements) : new EmptyNavigator()
}

cacheDriver=true
cacheDriverPerThread=false
quitCachedDriverOnShutdown=true

baseUrl = "http://gebish.org"

waiting {
    timeout = 5
    retryInterval = 0.1
    presets {
        slow {
            timeout = 20
            retryInterval = 1
        }
        quick {
            timeout = 1
        }
    }
    includeCauseInMessage = true
}

atCheckWaiting = true

baseNavigatorWaiting = true

unexpectedPages = [ThirdPage]

reporter = new ScreenshotReporter()


reportsDir = "target/geb-reports"
reportsDir = new File("target/geb-reports")

autoClearCookies = true

environments {

    someEnv {
        driver = { new FirefoxDriver() }
        driver = "firefox"

        innerNavigatorFactory = { Browser browser, List<WebElement> elements ->
            elements ? new NonEmptyNavigator(browser, elements) : new EmptyNavigator()
        }

        cacheDriver=true
        cacheDriverPerThread=false
        quitCachedDriverOnShutdown=true

        baseUrl = "http://gebish.org"

        waiting {
            timeout = 5
            retryInterval = 0.1
            presets {
                slow {
                    timeout = 20
                    retryInterval = 1
                }
                quick {
                    timeout = 1
                }
            }
            includeCauseInMessage = true
        }

        atCheckWaiting = true

        baseNavigatorWaiting = true

        unexpectedPages = [ThirdPage]

        reporter = new ScreenshotReporter()


        reportsDir = "target/geb-reports"
        reportsDir = new File("target/geb-reports")

        autoClearCookies = true
    }
    anotherEnv {

    }
}