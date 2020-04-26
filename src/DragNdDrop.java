import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DragNdDrop extends CommonMethod {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		
		
		WebElement drag = driver.findElementsByClassName("android.view.View").get(0);
		WebElement drop = driver.findElementsByClassName("android.view.View").get(2);
		TouchAction t = new TouchAction(driver);
		
		// To be used if you need to longPress with time unit
		t.longPress(longPressOptions().withElement(element(drag)).withDuration(ofSeconds(5))).moveTo(element(drop)).release().perform();
		
		// To be used if you dont need to longPress with time
		t.longPress(element(drag)).moveTo(element(drop)).release().perform();   

	}

}
