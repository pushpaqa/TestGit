package com.create4.scenarios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.methods.Dashboard_Links;
import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

//Check for all the Subsequent submissions should ask for COI
public class TS_66 {
	
	public TS_66()
	{
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	
	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(linkText = "My Projects")
	WebElement PI_project_menu;

	public void CRe4_66() throws Exception {
		
		Dashboard_Links ds = new Dashboard_Links();
		ds.MSDECISION_LOP();
		
		GlobalMethods.PI_Login();
		
		GlobalMethods.PI_Login();

		WebElement Ongoingprojects1 = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		Ongoingprojects1.click();

		WebElement approvedprojoverview1 = GWait.Wait_GetElementByXpath("//td[9]/a/span");
		approvedprojoverview1.click();

		WebElement newdocuments = GWait.Wait_GetElementByLinkText("Submit New Documents");
		newdocuments.click();
		
	}
}










