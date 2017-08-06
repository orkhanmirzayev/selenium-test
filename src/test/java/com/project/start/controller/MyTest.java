package com.project.start.controller;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.start.SeleniumExampleApplication;

@SpringBootTest(classes = { SeleniumExampleApplication.class })
@RunWith(SpringRunner.class)
public class MyTest {

	
	private String url = "http://localhost:"+8089;
	@Test
	public void test() {

		HtmlUnitDriver driver = new HtmlUnitDriver(true);
		driver.get(url+"/test");
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("username"))));
		System.out.println("Driverrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr: " + driver.getTitle());
		WebElement usernameInput = driver.findElement(By.id("username"));

		usernameInput.sendKeys("test-user");

		WebElement passwordInput = driver.findElement(By.id("password"));

		passwordInput.sendKeys("123456");

		WebElement loginButton = driver.findElement(By.id("login"));

		loginButton.click();
		System.out.println(
				"===================================================================================================================");
		driver.quit();
		// System.out.println("Server port: "+port);
		assertEquals("1", "1");
	}

}
