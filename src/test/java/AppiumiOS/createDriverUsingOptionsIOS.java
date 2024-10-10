package AppiumiOS;

import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;



public class createDriverUsingOptionsIOS {

	
public static void main(String[] args) throws Exception {
		
		String appUrl = "/Users/mathumathibalakrishnan/Documents/SampleApps/UIKitCatalog-iphonesimulator.app";
		XCUITestOptions options = new XCUITestOptions()
				.setDeviceName("iPhone 16 Pro")
				.setAutomationName("XCUITest")
				.setUdid("2F8981DB-1BF1-477A-B9C3-830F6D5F61E5")
				.setBundleId("com.example.apple-samplecode.UICatalog")			
				.setApp(appUrl)
				.setShowXcodeLog(true)
				.setSimulatorStartupTimeout(Duration.ofSeconds(1800));
		
		
		URL url = new URL("http://0.0.0.0:4723");
		
		AppiumDriver driver = new IOSDriver(url,options);
		
		
		
		
		
	}
	


}
