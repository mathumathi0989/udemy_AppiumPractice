package AppiumiOS;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;



public class createDriverUsingOptionsIOS {

	
	static AppiumDriver driver;
	public static void createDriver() throws Exception {
		String appUrl = "/Users/mathumathibalakrishnan/Documents/SampleApps/UIKitCatalog-iphonesimulator.app";
		XCUITestOptions options = new XCUITestOptions()
				.setDeviceName("iPhone 16 Pro")
				.setAutomationName("XCUITest")
				.setUdid("2F8981DB-1BF1-477A-B9C3-830F6D5F61E5")
				.setBundleId("com.example.apple-samplecode.UICatalog")	
				.setApp(appUrl)
				.setShowXcodeLog(true)
				.setSimulatorStartupTimeout(Duration.ofSeconds(1800));
		//.setBundleId("com.apple.Maps");
		
		URL url = new URL("http://0.0.0.0:4723");
		
	 driver = new IOSDriver(url,options);
	}
	
	
	
	public static void Swipe() {
		WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "up");
		params.put("element", ((RemoteWebElement) element).getId());
		js.executeScript("mobile: swipe", params);
		
	}
	
	
	
	public static void Scroll() {
		WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "up");
		params.put("element", ((RemoteWebElement) element).getId());
		js.executeScript("mobile: scroll", params);
	}
	
	
	
	public static void Tap() {
		WebElement tapEle = driver.findElement(AppiumBy.accessibilityId("Alert Views"));
		 Map<String, Object> params = new HashMap<>();
	        params.put("elementId", ((RemoteWebElement) tapEle).getId());
	        params.put("x", 0);
	        params.put("y", 0);
	        driver.executeScript("mobile: tap", params);
	        driver.navigate().back();
	}
	
	
	public static void selectPickerWheelValue() {
		driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
		boolean flag = false;
		while(!flag) {
	    WebElement redPickerWheel = driver.findElement(AppiumBy.
                iOSNsPredicateString("label == \"Red color component value\""));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String, Object> params = new HashMap<>();
		params.put("order", "next");
		params.put("offset", 0.15);
		params.put("element", ((RemoteWebElement) redPickerWheel).getId());
		js.executeScript("mobile: selectPickerWheelValue", params);
		if(redPickerWheel.getText().equals("100")){
            flag = true;
        }
		}
		driver.navigate().back();
	}
	
	public static void slider() {
		driver.findElement(AppiumBy.iOSNsPredicateString("name == \"Sliders\"")).click();;
		 WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("value == \"42%\""));
	        element.sendKeys("1");
	       element = driver.findElement(AppiumBy.iOSNsPredicateString("value == \"100%\""));
	        element.sendKeys("0.5");
	        element = driver.findElement(AppiumBy.iOSNsPredicateString("value == \"50%\""));
	        element.sendKeys("0");
	        driver.navigate().back();
		
	}
	
    public static void touchAndHold(){
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();

        WebElement element = driver.findElement(AppiumBy
                .iOSClassChain("**/XCUIElementTypeButton[`label == \"Increment\"`][1]"));

        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("duration", 5);
        driver.executeScript("mobile: touchAndHold", params);
        driver.navigate().back();
    }
    public static void dragAndDrop(){
        Map<String, Object> params = new HashMap<>();
        params.put("fromX", 60);
        params.put("fromY", 300);
        params.put("toX", 60);
        params.put("toY", 0);
        params.put("duration", 1);
        driver.executeScript("mobile: dragFromToForDuration", params);
        driver.navigate().back();
    }
    
	public static void pinchGesture() {
     driver.findElement(AppiumBy.
      iOSClassChain("**/XCUIElementTypeButton[`label == \"Continue\"`]")).click();

Map<String, Object> params1 = new HashMap<>();
params1.put("scale", 20);
params1.put("velocity", 2.2);
driver.executeScript("mobile: pinch", params1);

//WebElement element = driver.findElement(AppiumBy.
  //    iOSClassChain("**/XCUIElementTypeOther[`name == \"OverlayView\"`][1]"));
/*
Map<String, Object> params2 = new HashMap<>();
params2.put("elementId", ((RemoteWebElement) element).getId());
params2.put("scale", 0.1);
params2.put("velocity", -2.2);
driver.executeScript("mobile: pinch", params2);
*/
	}
public static void main(String[] args) throws Exception {
		
	createDriver();
		
	Swipe();
		
	Scroll();
	Tap();
	
	selectPickerWheelValue();
	slider();
	
	touchAndHold();
	dragAndDrop();
	
	//pinchGesture();
	}
	


}
