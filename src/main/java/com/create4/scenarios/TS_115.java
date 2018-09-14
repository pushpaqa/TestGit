package com.create4.scenarios;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.global.methods.Dashboard_Links;
import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for 'Unapproved projects' section feature functionality in Member Secretary dashboard
 */
public class TS_115 {
	public TS_115() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	// PI submit new project page elements

	@FindBy(css = "h3")
	WebElement unapprovedproject;

	@FindBy(xpath = "//div[2]/div/h3")
	WebElement ongoingprojects;

	@FindBy(xpath = "//div[4]/div/h3")
	WebElement upcomingmeetings;

	@FindBy(xpath = "//div[5]/div/h3")
	WebElement announcement;

	@FindBy(xpath = "//div[7]/div/h3")
	WebElement IECsubmissionsannexures;

	@FindBy(css = "span.pull-left")
	WebElement fb;

	@FindBy(xpath = "//li[2]/a/span")
	WebElement exprev;

	@FindBy(xpath = "//li[3]/a/span")
	WebElement exemrev;

	@FindBy(xpath = "//li[4]/a/span")
	WebElement qry;

	@FindBy(xpath = "//li[5]/a/span")
	WebElement prjtswith;

	@FindBy(xpath = "//li[6]/a/span")
	WebElement prjctsqry;

	@FindBy(xpath = "//ul[2]/li/a/span")
	WebElement resub;

	@FindBy(xpath = "//div[@id='summary']/div/div[3]/div[2]/p")
	WebElement reviewtype;

	@FindBy(xpath = "//html/body/div[4]/div/div/div[2]/div[3]/div/div[1]/div[2]/div/table")
	WebElement table;

	@FindBy(css = "span.fa.fa-eye")
	WebElement overview;

	@FindBy(linkText = "Dashboard")
	WebElement dashboardclick;
	
	@FindBy(xpath = "//span/a")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;
	
	//Check for Dashboard features
	public void CRe4_473_to_486() throws Exception {
		
		GlobalMethods.MS_Login();
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		
		String Full_Board_Review = r1.getCell(2, 19).getContents();
		String Expedited_Review = r1.getCell(3, 19).getContents();
		String Exemption_Review = r1.getCell(4, 19).getContents();
		String Queries_Replied = r1.getCell(5, 19).getContents();
		String Projects_Withdrawn = r1.getCell(6, 19).getContents();
		String Projects_with_Queries = r1.getCell(7, 19).getContents();
		String Resubmission = r1.getCell(8, 19).getContents();
		
		String Unapproved_Projects = r1.getCell(9, 19).getContents();
		String Ongoing_Projects = r1.getCell(10, 19).getContents();
		String Upcoming_Meetings = r1.getCell(11, 19).getContents();
		String Announcements = r1.getCell(12, 19).getContents();
		String IEC_Submissions_Annexures = r1.getCell(13, 19).getContents();


		Thread.sleep(3000);
		System.out.println(unapprovedproject.getText());
		Assert.assertEquals(unapprovedproject.getText().trim(), Unapproved_Projects);
		
		Thread.sleep(3000);
		System.out.println(ongoingprojects.getText());
		Assert.assertEquals(ongoingprojects.getText().trim(), Ongoing_Projects);

		Thread.sleep(3000);
		System.out.println(upcomingmeetings.getText());
		Assert.assertEquals(upcomingmeetings.getText().trim(), Upcoming_Meetings);


		Thread.sleep(3000);
		System.out.println(announcement.getText());
		Assert.assertEquals(announcement.getText().trim(), Announcements);

		Thread.sleep(3000);
		System.out.println(IECsubmissionsannexures.getText());
		Assert.assertEquals(IECsubmissionsannexures.getText().trim(), IEC_Submissions_Annexures);
	
		Thread.sleep(3000);
		System.out.println(fb.getText());
		Assert.assertEquals(fb.getText().trim(), Full_Board_Review);
		
		Thread.sleep(3000);
		System.out.println(exprev.getText());
		Assert.assertEquals(exprev.getText().trim(), Expedited_Review);

		Thread.sleep(3000);
		System.out.println(exemrev.getText());
		Assert.assertEquals(exemrev.getText().trim(), Exemption_Review);

		Thread.sleep(3000);
		System.out.println(qry.getText());
		Assert.assertEquals(qry.getText().trim(), Queries_Replied);

		Thread.sleep(3000);
		System.out.println(prjtswith.getText());
		Assert.assertEquals(prjtswith.getText().trim(), Projects_Withdrawn);

		Thread.sleep(3000);
		System.out.println(prjctsqry.getText());
		Assert.assertEquals(prjctsqry.getText().trim(), Projects_with_Queries);

		Thread.sleep(3000);
		System.out.println(resub.getText());
		Assert.assertEquals(resub.getText().trim(), Resubmission);

	
		// --TAKE INITIAL COUNT OF LINK 'FULL BOARD REVIEW'---//
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
				ns.ADMINREVIEWINITIAL();
		
				GlobalMethods.MS_Login();
		
		
				// ---TAKE COUNT AFTER PI SUBMITTED PROJECT TO IEC---//

				WebElement countafter = GWait.Wait_GetElementByCSS("span.count.pull-right");

				String MyString1 = countafter.getText();
				int foo1 = Integer.parseInt(MyString1);

				Assert.assertEquals(suma3, foo1);
				
				// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
				// DISPLAY---//
		
			
				WebElement fb =GWait.Wait_GetElementByCSS("span.pull-left");
				fb.click();

				Thread.sleep(4000);
				WebElement table_element1 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
				ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
				for (WebElement row : rows1) {
					ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[9]"));
					for (WebElement cell : cells) {
						System.out.println(cell.getText());
						System.out.println(cell.getText().equalsIgnoreCase("MS Review"));
						WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
						overview1.click();
						Thread.sleep(4000);
						System.out.println(reviewtype.getText());
						break;

					}break;
				}
				WebElement dashboardclick = GWait.Wait_GetElementByLinkText("Dashboard");
				dashboardclick.click();
		
		
				//--TAKE INITIAL COUNT FROM 'EXPEDITED REVIEW'---//
				
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
		
		
		     ns.EXPADMINREVIEWINITIAL();
		     GlobalMethods.MS_Login();
		     
		   //--TAKE COUNT AFTER FROM EXPIDETED REVIEW--//
				
				WebElement countafter1 = GWait.Wait_GetElementByXpath("//li[2]/a/span[2]");

				String MyStringc = countafter1.getText();
				int fooc = Integer.parseInt(MyStringc);

				Assert.assertEquals(sumb3, fooc);
				
				// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
				// DISPLAY---//
		     
				
				WebElement exprev =GWait.Wait_GetElementByXpath("//li[2]/a/span");
				exprev.click();

				Thread.sleep(4000);
				WebElement table_element2 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
				ArrayList<WebElement> rows2 = (ArrayList<WebElement>) table_element2.findElements(By.tagName("tr"));
				for (WebElement row1 : rows2) {
					ArrayList<WebElement> cells = (ArrayList<WebElement>) row1.findElements(By.xpath("//td[9]"));
					for (WebElement cell : cells) {
						System.out.println(cell.getText());
						System.out.println(cell.getText().equalsIgnoreCase("MS Review"));
						WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
						overview1.click();
						Thread.sleep(4000);
						System.out.println(reviewtype.getText());
						break;

					}break;
				}
		     
				WebElement dashboardclick1 = GWait.Wait_GetElementByLinkText("Dashboard");
				dashboardclick1.click();
				
				//--TAKE INITIAL COUNT FROM EXEMPT REVIEW'---//
				
				
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
				
		ns.EMADMINREVIEWINITIAL();
		GlobalMethods.MS_Login();
		
		//---TAKE COUNT AFTER FROM EXEMPT REVIEW--//
		
				WebElement countbefore2 = GWait.Wait_GetElementByXpath("//li[3]/a/span[2]");

				String MyStringe = countbefore2.getText();
				int fooe = Integer.parseInt(MyStringe);
				
				Assert.assertEquals(sumd3, fooe);
				
				// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
				// DISPLAY---//
				
				
				WebElement exemrev =GWait.Wait_GetElementByXpath("//li[3]/a/span");
				exemrev.click();

				Thread.sleep(4000);
				WebElement table_element3 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
				ArrayList<WebElement> rows3 = (ArrayList<WebElement>) table_element3.findElements(By.tagName("tr"));
				for (WebElement row2 : rows3) {
					ArrayList<WebElement> cells = (ArrayList<WebElement>) row2.findElements(By.xpath("//td[9]"));
					for (WebElement cell : cells) {
						System.out.println(cell.getText());
						System.out.println(cell.getText().equalsIgnoreCase("MS Review"));
						WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
						overview1.click();
						Thread.sleep(4000);
						System.out.println(reviewtype.getText());
						break;

					}break;
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
		
		ns.ADMINFRWDPIQUERYREPLY();
		GlobalMethods.MS_Login();
		
		//--TAKE COUNT AFTER FROM QUERIES REPLIED---//
		
		
				WebElement countafter3 = GWait.Wait_GetElementByXpath("//li[4]/a/span[2]");

				String MyStringg = countafter3.getText();
				int foog = Integer.parseInt(MyStringg);
				
				Assert.assertEquals(sumf3, foog);
				
				// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
				// DISPLAY---//
				
				
				WebElement qry =GWait.Wait_GetElementByXpath("//li[4]/a/span");
				qry.click();
				Thread.sleep(4000);
				WebElement table_element4 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
				ArrayList<WebElement> rows4 = (ArrayList<WebElement>) table_element4.findElements(By.tagName("tr"));
				for (WebElement row3 : rows4) {
					ArrayList<WebElement> cells = (ArrayList<WebElement>) row3.findElements(By.xpath("//td[9]"));
					for (WebElement cell : cells) {
						System.out.println(cell.getText());
						System.out.println(cell.getText().equalsIgnoreCase("MS Review"));
						WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
						overview1.click();
						Thread.sleep(4000);
						System.out.println(reviewtype.getText());
						break;

					}break;
				}
		
				WebElement dashboardclick3 = GWait.Wait_GetElementByLinkText("Dashboard");
				dashboardclick3.click();
				
				
				//---TAKE COUNT BEFORE FROM PROJECTS WITHDRAWN---//
				
				WebElement countafter4 = GWait.Wait_GetElementByXpath("//li[5]/a/span[2]");

				String MyStringh = countafter4.getText();
				int fooh = Integer.parseInt(MyStringh);

				int h1 = fooh, h2 = 1, sumh3;
				sumh3 = h1 + h2;
				System.out.println(sumh3);
				
				WebElement logoutt4 = GWait.Wait_GetElementByXpath("//span/a");
				logoutt4.click();

				WebElement logo4 = GWait.Wait_GetElementByCSS("img");
				logo4.click();
		
		ns.ADMINFRWDWITHDRWN();
		GlobalMethods.MS_Login();
		
		//---TAKE COUNT AFTER FROM PROJECTS WITHDRAWN---//
		
		WebElement countafter7 = GWait.Wait_GetElementByXpath("//li[5]/a/span[2]");

		String MyStringi = countafter7.getText();
		int fooi = Integer.parseInt(MyStringi);
		
		
		Assert.assertEquals(sumh3, fooi);
		
		// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
		// DISPLAY---//
		
		
		WebElement prjtswith =GWait.Wait_GetElementByXpath("//li[5]/a/span");
		prjtswith.click();
		Thread.sleep(4000);
		WebElement table_element5 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows5 = (ArrayList<WebElement>) table_element5.findElements(By.tagName("tr"));
		for (WebElement row4 : rows5) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row4.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("MS Review"));
				WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview1.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;

			}break;
		}
		
		WebElement dashboardclick5 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick5.click();
		
		//---TAKE COUNT BEFORE FROM PROJECTS WITH QUERIES--//
		
		WebElement countbefore5 = GWait.Wait_GetElementByXpath("//li[6]/a/span[2]");

		String MyStringj = countbefore5.getText();
		int fooj = Integer.parseInt(MyStringj);

		int j1 = fooh, j2 = 1, sumj3;
		sumj3 = j1 + j2;
		System.out.println(sumj3);
		
		WebElement logoutt4j = GWait.Wait_GetElementByXpath("//span/a");
		logoutt4j.click();

		WebElement logo4j = GWait.Wait_GetElementByCSS("img");
		logo4j.click();
		
		
		ns.MSDECISION_QUERY();
		
		GlobalMethods.MS_Login();
		
	//---TAKE COUNT AFTER FROM PROJECTS WITH QUERIES--//
		
		WebElement countafter5 = GWait.Wait_GetElementByXpath("//li[6]/a/span[2]");

		String MyStringk = countafter5.getText();
		int fook = Integer.parseInt(MyStringk);
		
		
		Assert.assertEquals(sumj3, fook);
		// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
				// DISPLAY---//
		
		WebElement prjctsqry =GWait.Wait_GetElementByXpath("//li[6]/a/span");
		prjctsqry.click();
		Thread.sleep(4000);
		WebElement table_element6 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows6 = (ArrayList<WebElement>) table_element6.findElements(By.tagName("tr"));
		for (WebElement row5 : rows6) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row5.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview1.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;

			}break;
		}
		
		WebElement dashboardclick6 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick6.click();
		
	//---TAKE COUNT BEFORE FROM RESUBMISSION--//
		
		WebElement countbefore6 = GWait.Wait_GetElementByXpath("//li[6]/a/span[2]");

		String MyStringl = countbefore6.getText();
		int fool = Integer.parseInt(MyStringl);

		int l1 = fool, l2 = 1, suml3;
		suml3 = l1 + l2;
		System.out.println(suml3);
		
		WebElement logoutt4l = GWait.Wait_GetElementByXpath("//span/a");
		logoutt4l.click();

		WebElement logo4l = GWait.Wait_GetElementByCSS("img");
		logo4l.click();
		
		
		ns.PIRESUBMISSIONFRWDMS();
		
		GlobalMethods.MS_Login();
		
		
		//---TAKE COUNT AFTER FROM RESUBMISSION--//
		
				WebElement countafter6 = GWait.Wait_GetElementByXpath("//li[6]/a/span[2]");

				String MyStringm = countafter6.getText();
				int foom = Integer.parseInt(MyStringm);
		
		
				Assert.assertEquals(suml3, foom);
				
				// --CHECK FOR LINK REDIRECTION TO LIST AND VERIFY THE PROJECT
				// DISPLAY---//
				
			
				WebElement resub =GWait.Wait_GetElementByXpath("//ul[2]/li/a/span");
				resub.click();
				Thread.sleep(4000);
				WebElement table_element7 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
				ArrayList<WebElement> rows7 = (ArrayList<WebElement>) table_element7.findElements(By.tagName("tr"));
				for (WebElement row6 : rows7) {
					ArrayList<WebElement> cells = (ArrayList<WebElement>) row6.findElements(By.xpath("//td[9]"));
					for (WebElement cell : cells) {
						System.out.println(cell.getText());
						System.out.println(cell.getText().equalsIgnoreCase("MS Review"));
						WebElement overview1 = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
						overview1.click();
						Thread.sleep(4000);
						System.out.println(reviewtype.getText());
						break;

					}break;
				}
		
				
				
		
				WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
				logoutt.click();

				WebElement logo = GWait.Wait_GetElementByCSS("img");
				logo.click();
	}
		
	}



