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

public class LongPress extends BaseTest{

	
	@Test
	public void LongPressGesture() throws MalformedURLException, InterruptedException 
	{
		
		//Ir a la pantalla de Vistas
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Ir a la pantalla de Expandable Lists
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
				
		// Ir a la pantalla "Custom Adapter"
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		//Se crea un webElement con el primer elemento del listado de la pantalla
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		//Se crea el javascript para lograr mantener el click presionado en ese elemento:
		longPressAction(ele); // Se llama de la clase padre BaseTest
		
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		
		Assert.assertEquals(menuText, "Sample menu");
		
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
		
		
	}
	
}
