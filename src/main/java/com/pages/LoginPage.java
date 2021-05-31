package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	private By EmailTextBox = By.xpath("//*[@id='email']");
	private By PasswordTextBox = By.xpath("//*[@id='passwd']");
	private By SigninButton = By.xpath("//*[@class='icon-lock left']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void EnterEmail(String Email){
		driver.findElement(EmailTextBox).sendKeys(Email);
	}
	
	public void EnterPassword(String Password){
		driver.findElement(PasswordTextBox).sendKeys(Password);
	}
	
	public void ClickSigninButton(){
		driver.findElement(SigninButton).click();
	}
		
}
