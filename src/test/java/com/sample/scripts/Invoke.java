package com.sample.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Invoke {
	
	@Test
	public void invokeApp(){
		System.setProperty("webdriver.chrome.driver", "E:\\Jenkin_Dec06\\sample\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.google.com/");
		System.out.println(driver.getCurrentUrl());
		driver.quit();
		
	}

}
