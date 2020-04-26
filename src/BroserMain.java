import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BroserMain extends CommonMethod4Browser {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = Capabilities(); 
		driver.get(
				"https://www.alaskaair.com/hotels/mp/home/en/?t=1555508931434&utm_source=alaska&utm_medium=partner-page&utm_campaign=alaska-homepage-bookingformlet-hotelstab-Q12019-home-tr");
		//driver.findElement(By.cssSelector("//input[@placeholder='Where do you need a hotel?']")).click();
	
		driver.findElement(By.cssSelector("#recaptcha-checkbox-border")).click();
		driver.findElement(By.xpath("//input[@placeholder='Where do you need a hotel?']")).sendKeys("nyc");
		driver.findElement(By.xpath("//input[@placeholder='Where do you need a hotel?']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@placeholder='Where do you need a hotel?']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Where do you need a hotel?']")).sendKeys(Keys.ENTER);
		
		// AFTER HITTING ENTER IN LINE 22, SELENIUM WILL QUICKLY JUMP TO LINE26, THEN FAIL BECAUSE L26 IS NOT COMPLETELY LOADED. 
		//SO WE NEED TO USE SYNCHRONIZATION TO TELL SELENIUM TO WAIT. IMPLICIT WAIT SHOULD BE JUST AFTER WEBDRIVER INSTANCE. SEE ABOVE

/*Explicit wait*/		WebDriverWait d=new WebDriverWait(driver,15);
						d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#earn-hotel-select-btn")));
		
		driver.findElement(By.cssSelector("#earn-hotel-select-btn")).click();

	}

}
