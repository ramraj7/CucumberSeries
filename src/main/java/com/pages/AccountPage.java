package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	WebDriver driver;
	
	private By AccountLinksPane = By.xpath("//*[@class='myaccount-link-list']/li");
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
	}

	public String GetPageSource() {
		return driver.getTitle();
	}
	
	public List<String> getAccountLinks() {
		List<String> listedLinks = new ArrayList<String>();
		List<WebElement> links = driver.findElements(AccountLinksPane);
		
		for(int i=0; i<links.size();i++) {
			listedLinks.add(links.get(i).getText());
		}
		return listedLinks;
	}
}
