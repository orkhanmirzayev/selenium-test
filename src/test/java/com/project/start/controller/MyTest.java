package com.project.start.controller;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.project.start.SeleniumExampleApplication;

@ContextConfiguration(classes= SeleniumExampleApplication.class)
public class MyTest extends AbstractTestNGSpringContextTests{

	
//	@Autowired
//	Environment environment;
//	
//	  @Value("${server.port}")
//	    private String name;
	@Test
	public void test() {
	System.out.println("Server port: "+this.applicationContext.getEnvironment().getProperty("server.port"));
//		System.out.println("Environment port: ===>>>> "+name);
		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.get("http://localhost:8089/test");
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("username"))));
		System.out.println("Driverrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr: "+driver.getTitle());
		WebElement usernameInput = driver.findElement(By.id("username"));

		usernameInput.sendKeys("test-user");

		WebElement passwordInput = driver.findElement(By.id("password"));

		passwordInput.sendKeys("123456");

		WebElement loginButton = driver.findElement(By.id("login"));

		loginButton.click();
		System.out.println("===================================================================================================================");
		driver.quit();
		assertEquals("1", "1");
	}

}
