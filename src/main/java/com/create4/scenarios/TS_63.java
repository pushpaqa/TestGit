package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.global.methods.Dashboard_Links;
import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for expedited review type Initial submission when forwarded to Chairperson by MS with valid/invalid data
 */
public class TS_63 {
	
	public TS_63(){
		
		PageFactory.initElements(GlobalMethods.driver, this);
	}
	
	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);
	
	@FindBy(css = "p.error-msg")
	WebElement errormsg;
	
	@FindBy(xpath = "//*[@id='reviewers']/div[2]/div/div[1]/select")
	List<WebElement> memselect;
	@FindBy(xpath = ".//*[@id='ethic_committee_iec_member_id']")
	WebElement memclicking;
	
	public void Cre463() throws Exception{
		
		Dashboard_Links ns = new Dashboard_Links();
				
		ns.EXPNEWSUBMISSION();
		ns.EXPADMINREVIEWINITIAL();
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");
		// MS data
		String Rev_one = r1.getCell(18, 21).getContents();
		String Rev_two = r1.getCell(19, 21).getContents();
		String Rev_three = r1.getCell(20, 21).getContents();
		String Rev_four = r1.getCell(21, 21).getContents();
		String Rev_five = r1.getCell(22, 21).getContents();
		String Rev_six = r1.getCell(23, 21).getContents();
		String Rev_comnts = r1.getCell(24, 21).getContents();
		
			GlobalMethods.MS_Login();

		WebElement exprev =GWait.Wait_GetElementByXpath("//li[2]/a/span");
		exprev.click();

		WebElement Projectoverview1 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview1.click();

		WebElement asignreviewers = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers.click();
		
		WebElement frwdtocp_button = GWait.Wait_GetElementById("forward_chairman");
		frwdtocp_button.click();
		
		Assert.assertEquals(errormsg.getText(), "Please Select atleast one Reviewer");

		WebElement primaryreview_one = GWait.Wait_GetElementById("primary_reviewer");
		Select select1 = new Select(primaryreview_one);
		select1.selectByVisibleText(Rev_one);
		
		WebElement frwdtocp_button1 = GWait.Wait_GetElementById("forward_chairman");
		frwdtocp_button1.click();
		
		Thread.sleep(8000);
		
		WebElement logoutt12 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt12.click();
		
		
		WebElement logo12 = GWait.Wait_GetElementByCSS("img");
		logo12.click();
		
		GlobalMethods.CPLogin();
		
		WebElement exprev1 =GWait.Wait_GetElementByXpath("//li[2]/a/span");
		exprev1.click();

		WebElement Projectoverview11 = GWait.Wait_GetElementByXpath("//td[10]/a/span");
		Projectoverview11.click();

		WebElement asignreviewers1 = GWait.Wait_GetElementByLinkText("Assign Reviewer(s)");
		asignreviewers1.click();
		
		
		
		
		Thread.sleep(1000);
		for (WebElement checkboxDiv : memselect) {
			if (checkboxDiv.getAttribute("selected").equalsIgnoreCase("selected")) {
				System.out.println(checkboxDiv.getAttribute("selected"));
				String value1 = checkboxDiv.getAttribute("selected");
				if (value1.equalsIgnoreCase(Rev_one)) {
					
				}
			}
			
		WebElement primaryreview_one1 = GWait.Wait_GetElementById("primary_reviewer");
			
			WebElement selectDropDown=GlobalMethods.driver.findElement(By.xpath("//*[@id='reviewers']/div[2]/div/div[1]/select"));
			List<WebElement> options=selectDropDown.findElements(By.tagName("option"));
			for(int i=0;i<options.size();i++)
			{
			 try{
			    String isDisabled=options.get(i).getAttribute("disabled");
			    System.out.println(isDisabled);
			     //Write the required code if disabled
			    }
			 catch(Exception ex)
			   {
			    //Write required code if not disabled
				 
				 System.out.println(primaryreview_one1.getAttribute("value"));
			   } 
			}
			String checkboxValue = checkboxDiv.getText().trim();
			System.out.println(checkboxValue);
			System.out.println(checkboxDiv.getTagName());
			if (checkboxValue.equals(Rev_one)) {
				// System.out.println("entered");
				
				WebElement checkbox = checkboxDiv.findElement(By.tagName("input"));
				Assert.assertEquals(checkbox, Rev_one);
			}
		}
		
		

		WebElement nonprimaryreview_one = GWait.Wait_GetElementByName("nontech_primary_reviewer1");
		Select select2 = new Select(nonprimaryreview_one);
		select2.selectByVisibleText(Rev_two);

		WebElement primaryreview_two = GWait.Wait_GetElementByName("tech_primary_reviewer2");
		Select select3 = new Select(primaryreview_two);
		select3.selectByVisibleText(Rev_three);

		WebElement nonprimaryreview_two = GWait.Wait_GetElementByName("nontech_primary_reviewer2");
		Select select4 = new Select(nonprimaryreview_two);
		select4.selectByVisibleText(Rev_four);

		WebElement primaryreview_three = GWait.Wait_GetElementByName("tech_primary_reviewer3");
		Select select5 = new Select(primaryreview_three);
		select5.selectByVisibleText(Rev_five);

		WebElement nonprimaryreview_three = GWait.Wait_GetElementByName("nontech_primary_reviewer3");
		Select select6 = new Select(nonprimaryreview_three);
		select6.selectByVisibleText(Rev_six);

		WebElement assign_comments = GWait.Wait_GetElementById("comments");
		assign_comments.clear();

		WebElement assign_comments1 = GWait.Wait_GetElementById("comments");
		assign_comments1.sendKeys(Rev_comnts);

		WebElement frwdtocp_button2 = GWait.Wait_GetElementById("forward_chairman");
		frwdtocp_button2.click();

		
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();
		
		
	}

}
