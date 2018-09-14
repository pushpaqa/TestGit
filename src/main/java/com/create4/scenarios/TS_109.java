package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;
import com.global.methods.Dashboard_Links;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for 'Unapproved projects' section feature functionality in Admin dashboard
 */
public class TS_109 {
	public TS_109() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	// PI submit new project page elements

	@FindBy(css = "h3")
	WebElement unapprovedproject;

	@FindBy(xpath = "//div[2]/div/h3")
	WebElement dashongoing;

	@FindBy(xpath = "//div[4]/div/h3")
	WebElement dashreminder;

	@FindBy(xpath = "//div[5]/div/h3")
	WebElement dashupcoming;

	@FindBy(xpath = "//div[7]/div/h3")
	WebElement dashinvestreg;

	@FindBy(xpath = "//div[8]/div/h3")
	WebElement dashstudyteam;

	@FindBy(xpath = "//div[10]/div/h3")
	WebElement dashannouncement;

	@FindBy(css = "span.pull-left")
	WebElement dashnewsubmission;

	@FindBy(xpath = "//li[2]/a/span")
	WebElement dashresubmission;

	@FindBy(xpath = "//li[3]/a/span")
	WebElement dashwithdrawn;

	@FindBy(xpath = "//li[4]/a/span")
	WebElement dashqueryreply;

	@FindBy(xpath = "//li[5]/a/span")
	WebElement dashprojectsunderreview;

	@FindBy(xpath = "//li[6]/a/span")
	WebElement dashprojectswithquery;

	@FindBy(xpath = "//li[7]/a/span")
	WebElement dashdisposedprojects;

	@FindBy(xpath = "//div[@id='summary']/div/div[3]/div[2]/p")
	WebElement reviewtype;

	@FindBy(css = "span.fa.fa-eye")
	WebElement overview;

	@FindBy(linkText = "Dashboard")
	WebElement dashboardclick;

	@FindBy(xpath = "//span[3]/a")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;

	// Check for the features on Dashboard
	public void CRe4_414_415_416_417_418_419_420_421_422_423_424_425_426_427_428_429() throws Exception {

		GlobalMethods.Admin_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		String Unapproved_Projects = r1.getCell(2, 9).getContents();
		String Ongoing_Projects = r1.getCell(3, 9).getContents();
		String Reminders = r1.getCell(4, 9).getContents();
		String Upcoming_Meetings = r1.getCell(5, 9).getContents();
		String Investigator_Registration_Requests = r1.getCell(6, 9).getContents();
		String Study_Team_Member_Registration_Requests = r1.getCell(7, 9).getContents();
		String Announcements = r1.getCell(8, 9).getContents();

		String New_Submissions = r1.getCell(9, 9).getContents();
		String Resubmission = r1.getCell(10, 9).getContents();
		String Withdrawn_Requested = r1.getCell(11, 9).getContents();
		String Queries_Replied = r1.getCell(12, 9).getContents();
		String Projects_Under_Review = r1.getCell(13, 9).getContents();
		String Projects_with_Queries = r1.getCell(14, 9).getContents();
		String Disposed_Projects = r1.getCell(15, 9).getContents();

		// ---VERIFYING DASHBOARD ELEMENTS
		Thread.sleep(3000);
		System.out.println(unapprovedproject.getText());
		Assert.assertEquals(unapprovedproject.getText().trim(), Unapproved_Projects);

		Thread.sleep(3000);
		System.out.println(dashongoing.getText());
		Assert.assertEquals(dashongoing.getText().trim(), Ongoing_Projects);

		Thread.sleep(3000);
		System.out.println(dashreminder.getText());
		Assert.assertEquals(dashreminder.getText().trim(), Reminders);

		Thread.sleep(3000);
		System.out.println(dashupcoming.getText());
		Assert.assertEquals(dashupcoming.getText().trim(), Upcoming_Meetings);

		Thread.sleep(3000);
		System.out.println(dashinvestreg.getText());
		Assert.assertEquals(dashinvestreg.getText().trim(), Investigator_Registration_Requests);

		Thread.sleep(3000);
		System.out.println(dashstudyteam.getText());
		Assert.assertEquals(dashstudyteam.getText().trim(), Study_Team_Member_Registration_Requests);

		Thread.sleep(3000);
		System.out.println(dashannouncement.getText());
		Assert.assertEquals(dashannouncement.getText().trim(), Announcements);

		Thread.sleep(3000);
		System.out.println(dashnewsubmission.getText());
		Assert.assertEquals(dashnewsubmission.getText().trim(), New_Submissions);

		Thread.sleep(3000);
		System.out.println(dashresubmission.getText());
		Assert.assertEquals(dashresubmission.getText().trim(), Resubmission);

		Thread.sleep(3000);
		System.out.println(dashwithdrawn.getText());
		Assert.assertEquals(dashwithdrawn.getText().trim(), Withdrawn_Requested);

		Thread.sleep(3000);
		System.out.println(dashqueryreply.getText());
		Assert.assertEquals(dashqueryreply.getText().trim(), Queries_Replied);

		Thread.sleep(3000);
		System.out.println(dashprojectsunderreview.getText());
		Assert.assertEquals(dashprojectsunderreview.getText().trim(), Projects_Under_Review);

		Thread.sleep(3000);
		System.out.println(dashprojectswithquery.getText());
		Assert.assertEquals(dashprojectswithquery.getText().trim(), Projects_with_Queries);

		Thread.sleep(3000);
		System.out.println(dashdisposedprojects.getText());
		Assert.assertEquals(dashdisposedprojects.getText().trim(), Disposed_Projects);

		
		// --TAKE INITIAL COUNT OF LINK 'NEW SUBMISSIONS'---//
		WebElement countbefore = GWait.Wait_GetElementByCSS("span.count.pull-right");

		String MyString = countbefore.getText();
		int foo = Integer.parseInt(MyString);

		int a1 = foo, a2 = 1, suma3;
		suma3 = a1 + a2;
		System.out.println(suma3);
		
		WebElement logoutt81 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt81.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();

		Dashboard_Links ns = new Dashboard_Links();
		ns.FBNEWSUBMISSION();
		
		GlobalMethods.Admin_Login();

		// ---TAKE COUNT AFTER PI SUBMITTED PROJECT TO IEC---//

		WebElement countafter = GWait.Wait_GetElementByCSS("span.count.pull-right");

		String MyString1 = countafter.getText();
		int foo1 = Integer.parseInt(MyString1);

		Assert.assertEquals(suma3, foo1);
		
		// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
				// DISPLAY---//
		
		Thread.sleep(4000);
		
		WebElement dashnewsubmission = GWait.Wait_GetElementByCSS("span.pull-left");
		dashnewsubmission.click();
		WebElement table_element1 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Submitted to IEC"));
				WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview1.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;
			}
			break;
		}
		
		WebElement dashboardclick = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick.click();
		
		//--TAKE INITIAL COUNT OF LINK 'RESUBMISSION'---//
		
		WebElement countbefore1 = GWait.Wait_GetElementByXpath("//li[2]/a/span[2]");

		String MyStringb = countbefore1.getText();
		int foob = Integer.parseInt(MyStringb);

		int b1 = foob, b2 = 1, sumb3;
		sumb3 = b1 + b2;
		System.out.println(sumb3);
		
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo2 = GWait.Wait_GetElementByCSS("img");
		logo2.click();
		
		
				
		ns.RESUBMISSION();
		GlobalMethods.Admin_Login();
		
		//--TAKE COUNT AFTER PI RESUBMISSION SUBMITTED TO IEC AMIN--//
		
		WebElement countafter1 = GWait.Wait_GetElementByXpath("//li[2]/a/span[2]");

		String MyStringc = countafter1.getText();
		int fooc = Integer.parseInt(MyStringc);

		Assert.assertEquals(sumb3, fooc);
		
		// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
		// DISPLAY---//
		
		
		WebElement dashresubmission =GWait.Wait_GetElementByXpath("//li[2]/a/span");
		dashresubmission.click();
		Thread.sleep(4000);
		WebElement table_element2 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows2 = (ArrayList<WebElement>) table_element2.findElements(By.tagName("tr"));
		for (WebElement row : rows2) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Submitted to IEC"));
				WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview1.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;
			}
			break;
		}
		
		
		WebElement dashboardclick1 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick1.click();
		
		//--TAKE INITIAL COUNT OF 'WITHDRAWN REQUESTED'---//
		
		
		WebElement countafter2 = GWait.Wait_GetElementByXpath("//li[3]/a/span[2]");

		String MyStringd = countafter2.getText();
		int food = Integer.parseInt(MyStringd);

		int d1 = food, d2 = 1, sumd3;
		sumd3 = d1 + d2;
		System.out.println(sumd3);
		
		WebElement logoutt6 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt6.click();

		WebElement logo6 = GWait.Wait_GetElementByCSS("img");
		logo6.click();
		
				
		ns.WITHDRAWNREQADMIN();
		
		GlobalMethods.Admin_Login();
		
		//---TAKE COUNT AFTER PI SUBMITS WITHDRAWN TO IEC ADMIN--//
		
		WebElement countbefore2 = GWait.Wait_GetElementByXpath("//li[3]/a/span[2]");

		String MyStringe = countbefore2.getText();
		int fooe = Integer.parseInt(MyStringe);
		
		Assert.assertEquals(sumd3, fooe);
		
		// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
				// DISPLAY---//
		
		
		WebElement dashwithdrawn =GWait.Wait_GetElementByXpath("//li[3]/a/span");
		dashwithdrawn.click();
		Thread.sleep(4000);
		WebElement table_element3 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows3 = (ArrayList<WebElement>) table_element3.findElements(By.tagName("tr"));
		for (WebElement row : rows3) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Submitted to IEC"));
				WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview1.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;
			}
			break;
		}
		
		WebElement dashboardclick2 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick2.click();
		
	//--TAKE INITIAL COUNT OF 'QUERIES REPLIED'---//
		
		
		WebElement countbefore3 = GWait.Wait_GetElementByXpath("//li[4]/a/span[2]");

		String MyStringf = countbefore3.getText();
		int foof = Integer.parseInt(MyStringf);

		int f1 = foof, f2 = 1, sumf3;
		sumf3 = f1 + f2;
		System.out.println(sumf3);
		
		WebElement logoutt3 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt3.click();

		WebElement logo3 = GWait.Wait_GetElementByCSS("img");
		logo3.click();
		
		ns.PIQUERYREPLY(); 
		GlobalMethods.Admin_Login();
		
		//--TAKE COUNT AFTER PI REPLY QUERY TO IEC ADMIN---//
		
		
		WebElement countafter3 = GWait.Wait_GetElementByXpath("//li[4]/a/span[2]");

		String MyStringg = countafter3.getText();
		int foog = Integer.parseInt(MyStringg);
		
		Assert.assertEquals(sumf3, foog);
		
		
		
		// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
		// DISPLAY---//
		
		
		WebElement dashqueryreply = GWait.Wait_GetElementByXpath("//li[4]/a/span");
		dashqueryreply.click();
		Thread.sleep(4000);
		WebElement table_element4 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows4 = (ArrayList<WebElement>) table_element4.findElements(By.tagName("tr"));
		for (WebElement row : rows4) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Submitted to IEC"));
				WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview1.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;
			}
			break;
		}
		
		WebElement dashboardclick3 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick3.click();
		
		//---TAKE COUNT OF DISPOSED PROJECTS---//
		
		WebElement countafter4 = GWait.Wait_GetElementByXpath("//li[7]/a/span[2]");

		String MyStringh = countafter4.getText();
		int fooh = Integer.parseInt(MyStringh);

		int h1 = fooh, h2 = 1, sumh3;
		sumh3 = h1 + h2;
		System.out.println(sumh3);
		
		WebElement logoutt4 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt4.click();

		WebElement logo4 = GWait.Wait_GetElementByCSS("img");
		logo4.click();
		
		GlobalMethods.Admin_Login();
		
		//--TAKE COUNT AFTER OF DISPOSED PROJECTS---//
		
		
		WebElement countbefore4 = GWait.Wait_GetElementByXpath("//li[7]/a/span[2]");

		String MyStringi = countbefore4.getText();
		int fooi = Integer.parseInt(MyStringi);
		
		//Assert.assertEquals(sumh3, fooi);
		
		
		WebElement dashdisposedprojects = GWait.Wait_GetElementByXpath("//li[7]/a/span");
		dashdisposedprojects.click();
		Thread.sleep(4000);
		WebElement table_element7 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows7 = (ArrayList<WebElement>) table_element7.findElements(By.tagName("tr"));
		for (WebElement row : rows7) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Submitted to IEC"));
				overview.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;
			}
			break;
		}
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();
		
		
		
		
		
		

	
		
		

	}

}
