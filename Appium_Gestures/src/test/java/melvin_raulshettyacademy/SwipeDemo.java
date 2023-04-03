package melvin_raulshettyacademy;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SwipeDemo extends BaseTest{

	
	@Test
	public void ScrollDemoTest() throws MalformedURLException, InterruptedException 
	{
		
		//Ir a la pantalla de Vistas
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Ir a Gallery
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		//Ir a 1. Photos
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]")); 
	
		// Realizar el Swipe Para hacer scroll horizontal.
		//Primero: Ver que la primer imagen tenga el focus True: Que esté seleccionada
		Assert.assertEquals("true", firstImage.getAttribute("focusable"));
		
		//Realizar el Swipe
		swipeAction(firstImage, "left");
		
		//Revisar que la primer imagen tenga el focus False (Porque ya se pasó a otra imagen)
		Assert.assertEquals("false", firstImage.getAttribute("focusable"));
		
	}
	
}
