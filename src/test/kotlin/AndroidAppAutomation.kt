import io.appium.java_client.AppiumBy as MobileBy
//import io.appium.java_client.MobileElement
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.options.UiAutomator2Options
//import io.appium.java_client.android.AndroidElement as MobileElement
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebElement as MobileElement
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
//import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
class AndroidAppAutomation {

    @Test
    public fun sampletest() {
        val username = System.getenv("LT_USERNAME")    //Add your LambdaTest username here
        val accessKey = System.getenv("LT_ACCESS_KEY")    //Add your LambdaTest accessKey here

//        var driver: AndroidDriver<MobileElement>? = null

        val hub = URL("https://${username}:${accessKey}@mobile-hub.lambdatest.com/wd/hub")
        val options = UiAutomator2Options()
        val caps = DesiredCapabilities()

        options.setCapability("autoAcceptAlerts", true)
        options.setCapability("platformName", "android")
        options.setCapability("deviceName", "Galaxy .*")
        options.setCapability("platformVersion", "11")
        options.setCapability("isRealMobile", true)
        options.setCapability("app", "lt://proverbial-android") // Add the app (.apk) URL here
        options.setCapability("deviceOrientation", "PORTRAIT")
        options.setCapability("build", "Kotlin Vanilla - Android")
        options.setCapability("name", "Sample Test Kotlin")
        options.setCapability("console", true)
        options.setCapability("network", false)
        options.setCapability("visual", true)
        options.setCapability("devicelog", true)
        options.setCapability("w3c", true)

        val app = AndroidDriver(hub, options)

//        val app = AppiumDriver(hub, caps)

        Thread.sleep(4000)

        val color: MobileElement =
            app.findElement(MobileBy.id("com.lambdatest.proverbial:id/color")) as MobileElement
        color.click()

        val text: MobileElement =
            app.findElement(MobileBy.id("com.lambdatest.proverbial:id/Text")) as MobileElement
        text.click()

        val toast: MobileElement =
            app.findElement(MobileBy.id("com.lambdatest.proverbial:id/toast")) as MobileElement
        toast.click()

        val notification: MobileElement =
            app.findElement(MobileBy.id("com.lambdatest.proverbial:id/notification")) as MobileElement
        notification.click()

        val geo: MobileElement =
            app.findElement(MobileBy.id("com.lambdatest.proverbial:id/geoLocation")) as MobileElement
        geo.click()
        Thread.sleep(5000)

//        val el3: MobileElement =
//            app.findElementByAccessibilityId("Home") as MobileElement
//        el3.click()

        app.navigate().back()
        Thread.sleep(2000)

        val speedtest: MobileElement =
            app.findElement(MobileBy.id("com.lambdatest.proverbial:id/speedTest")) as MobileElement
        speedtest.click()
        Thread.sleep(5000)

        app.navigate().back()


//        if (app != null) {
            app.quit()
//        };

    }
}