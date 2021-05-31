package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
	
	private By SigninButton = By.xpath("//*[@class='login']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPage ClickSigninButton(){
		driver.findElement(SigninButton).click();
		return new LoginPage(driver);
	}

}
