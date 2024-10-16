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
		driver.navigate().back();
		driver.navigate().back();
		
	}
	
	public static void clickGesture() {
		
		WebElement accessibilEle = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
		driver.executeScript("mobile: clickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) accessibilEle).getId()
			));
		driver.findElement(AppiumBy.accessibilityId("Accessibility Node Provider")).click();
		driver.navigate().back();
		driver.navigate().back();
		
	}
	
	public static void dragGesture() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement dragEle = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		driver.executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) dragEle).getId(),
			    "endX", 625,
			    "endY", 567
			));
		String dragAndDrop = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
		System.out.println(dragAndDrop);
		driver.navigate().back();
		driver.navigate().back();
		
	}
	
	public static void swipe() {
		/*
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
		driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
				//using coordinates
		//	    "left", 100, "top", 100, "width", 600, "height", 600,
				//using element
			 "elementId", ((RemoteWebElement)element).getId(),
				"direction", "up", //direction should be up or left or right or down
			    "percent", 0.75
			));
		
		*/
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));
		
		
		driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
			 "elementId", ((RemoteWebElement)element).getId(),
				"direction", "left",
			    "percent", 1.0
			));
		
		WebElement element1 = driver.findElement(AppiumBy.xpath("//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[3]"));
			
		driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
				 "elementId", ((RemoteWebElement)element1).getId(),
					"direction", "right",
				    "percent", 1.0
				));
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
	}
	
	
	public static void scroll() {
		
		// Scroll down first
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		boolean scrollMore = true;
		while (scrollMore) {
		    scrollMore = (boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
		        "left", 100, "top", 100, "width", 600, "height", 600,
		        "direction", "down", // Scroll down
		        "percent", 1.0
		    ));
		}
	
		// Now scroll back up
		boolean scrollMoreUp = true;
		while (scrollMoreUp) {
		    scrollMoreUp = (boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
		        "left", 100, "top", 500, "width", 600, "height", 600,
		        "direction", "up", // Scroll up
		        "percent", 1.0
		    ));
		}
		driver.navigate().back();
	
	}
	public static void main(String[] args) throws Exception {
		
		createDriver();
		actions();
		longclickGesture();
		clickGesture();
		dragGesture();
		swipe();
		scroll();
		
	}
	
	
}
