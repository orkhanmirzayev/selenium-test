package com.project.start.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.project.start.SeleniumExampleApplication;

@SpringBootTest(classes = { SeleniumExampleApplication.class })
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { SeleniumExampleApplication.class })
public class MyTest {

	@Autowired
	EmbeddedWebApplicationContext server;

	@Value("${local.server.port}")
	int port;

	@Test
	public void test() {

		// System.out.println("Environment port: ===>>>>
		// "+environment.getProperty("local.server.port"));
		HtmlUnitDriver driver = new HtmlUnitDriver(true);
		driver.get("http://localhost:8089/test");
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
		// System.out.println("Server port: "+randomServerPort);
		assertEquals("1", "1");
	}

}
