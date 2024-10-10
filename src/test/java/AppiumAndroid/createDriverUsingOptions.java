package AppiumAndroid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class createDriverUsingOptions {

	static AppiumDriver driver;
	public static void createDriver() throws Exception {
		String appUrl = "/Users/mathumathibalakrishnan/Documents/SampleApps/ApiDemos-debug.apk";
		UiAutomator2Options options = new UiAutomator2Options()
				.setDeviceName("Mathu_Pixel_9")
				.setAutomationName("uiautomator2")
				.setApp(appUrl)
				//.setAppPackage("io.appium.android.apis")
				//.setAppActivity("io.appium.android.apis.animation.AnimatorEvents")  //to navigate to different pages;
				.setAvd("Mathu_Pixel_9")
				.setAvdReadyTimeout(Duration.ofSeconds(1000))
				.setAvdLaunchTimeout(Duration.ofSeconds(2800));
		
		
		URL url = new URL("http://0.0.0.0:4723");
		
		driver = new AndroidDriver(url,options);
		
	}
	
	
	
	public static void actions() {
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Text\")")).click();
	driver.navigate().back();
	driver.findElement(AppiumBy.accessibilityId("Views")).click();
	driver.findElement(AppiumBy.androidUIAutomator(
		    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"TextFields\"));"));

	driver.findElement(AppiumBy.accessibilityId("TextFields")).click();
	WebElement textele = driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit"));
	textele.sendKeys("hi");
	String actualVal = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/edit\")")).getText();
System.out.println("Value entered is " +actualVal);
textele.clear();
driver.navigate().back();
driver.navigate().back();
	
	}
	
	public static void longclickGesture() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement longclickEle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/drag_dot_1\")"));
		driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) longclickEle).getId()
			));
		
		String dragg = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
		System.out.println(dragg);
		
	}
	public static void main(String[] args) throws Exception {
		
		
		
		createDriver();
		
		actions();
		
		longclickGesture();
		
	}
	
	
}
