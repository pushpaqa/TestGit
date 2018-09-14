package com.create4.execution;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class URLCount {
static WebDriver driver;
	public static void main(String[] args) {
		URLCount u=new URLCount();
		driver=new FirefoxDriver();
		driver.get("https://www.askapollo.com/physical-appointment/");
		List<WebElement>l=driver.findElements(By.tagName("a"));
		System.out.println(l.size());
		for(int i=0;i<=l.size();i++)
		{
			WebElement ele=l.get(i);
			String url=ele.getAttribute("href");
			System.out.println(url);
		}
		

	}

}
