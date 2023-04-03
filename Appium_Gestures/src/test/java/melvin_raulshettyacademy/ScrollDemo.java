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

public class ScrollDemo extends BaseTest{

	
	@Test
	public void ScrollDemoTest() throws MalformedURLException, InterruptedException 
	{
		
		//Ir a la pantalla de Vistas
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Hace scroll en la pantalla hasta encontrar el texto WebView
		//Se sabe donde parar
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		//No se sabe donde parar
		// Lo que hace es solamente un pequeño scroll en la pantalla
		//Si se quiere seguir bajando se puede meter en un ciclo do while
		//La condición es que encuentre algún elemento que se llame  X
		// El booleano va a retornar True mientras pueda seguir el scroll, si ya no puede es false y sale del ciclo
		// Se le puede agregar alguna condición al código para que rompa el ciclo si encuentra algún elemento.. De lo contrario llegará hasta ya no dar scroll
		scrollToEndAction();
		
		
	}
	
}
