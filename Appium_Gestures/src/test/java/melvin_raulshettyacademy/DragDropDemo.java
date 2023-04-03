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
import io.appium.java_client.AppiumBy.ById;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DragDropDemo extends BaseTest{

	
	@Test
	public void ScrollDemoTest() throws MalformedURLException, InterruptedException 
	{
		
		//Ir a la pantalla de Vistas
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Ir a la pantalla de Drag Drop
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		//Crear webelement con el primer circulo de la pantalla:
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
			
		
		//Código del gesture del Drag
		dragAndDropAction(source, 619, 560);
		
			
		Thread.sleep(3000);
		
		Assert.assertEquals("Dropped!", driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText());
				
	}
	
}
