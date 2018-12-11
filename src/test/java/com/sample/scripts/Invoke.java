package com.sample.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Invoke {
	
	@Test
	public void invokeApp(){
		/*System.setProperty("webdriver.chrome.driver", "E:\\Jenkin_Dec06\\sample\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();*/
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);
		
		driver.navigate().to("https://www.google.com/");
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		
	}

}
