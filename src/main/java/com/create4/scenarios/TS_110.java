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
 * Check for 'Ongoing projects' section feature functionality in Admin dashboard
 */
public class TS_110 {

	public TS_110() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "//div[2]/div/div/ul/li/a/span")
	WebElement approved_approved;

	@FindBy(xpath = "//div[2]/div/div/ul/li[2]/a/span")
	WebElement approved_projectcontinous;

	@FindBy(xpath = "//div[2]/div/div/ul/li[3]/a/span")
	WebElement approved_projectcompletion;

	@FindBy(xpath = "//div[2]/div/div/ul/li[4]/a/span")
	WebElement approved_queryreply;

	@FindBy(xpath = "//div[2]/div/div/ul/li[5]/a/span")
	WebElement approved_projecttermination;

	@FindBy(xpath = "//div[2]/div/div/ul/li[6]/a/span")
	WebElement approved_amendments;

	@FindBy(xpath = "//div[2]/div/div/ul/li[7]/a/span")
	WebElement approved_deviation;

	@FindBy(xpath = "//li[8]/a/span")
	WebElement approved_sae;

	@FindBy(xpath = "//li[9]/a/span")
	WebElement approved_othersubmission;

	@FindBy(css = "span.fa.fa-eye")
	WebElement overview;

	@FindBy(xpath = "//div[@id='summary']/div/div[3]/div[2]/p")
	WebElement reviewtype;

	@FindBy(linkText = "Dashboard")
	WebElement dashboardclick;

	@FindBy(xpath = "//span[3]/a")
	WebElement logoutt;

	@FindBy(css = "img")
	WebElement logo;

	// Check for 'Ongoing projects' section features
	public void CRe4_430_to_448() throws Exception {

		GlobalMethods.Admin_Login();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Dashboard");

		String Approved = r1.getCell(2, 9).getContents();
		String Project_Continuous_Request = r1.getCell(3, 9).getContents();
		String Project_Completion_Request = r1.getCell(4, 9).getContents();
		String Queries_Replied = r1.getCell(5, 9).getContents();
		String Projects_Termination = r1.getCell(6, 9).getContents();
		String Amendments = r1.getCell(7, 9).getContents();
		String Deviations = r1.getCell(8, 9).getContents();
		String SAE = r1.getCell(9, 9).getContents();
		String Other_Submissions = r1.getCell(10, 9).getContents();

		Thread.sleep(3000);
		Assert.assertEquals(approved_approved.getText().trim(), Approved);

		Thread.sleep(3000);
		Assert.assertEquals(approved_projectcontinous.getText().trim(), Project_Continuous_Request);

		Thread.sleep(3000);
		Assert.assertEquals(approved_projectcompletion.getText().trim(), Project_Completion_Request);

		Thread.sleep(3000);
		Assert.assertEquals(approved_queryreply.getText().trim(), Queries_Replied);

		Thread.sleep(3000);
		Assert.assertEquals(approved_projecttermination.getText().trim(), Projects_Termination);

		Thread.sleep(3000);
		Assert.assertEquals(approved_amendments.getText().trim(), Amendments);

		Thread.sleep(3000);
		Assert.assertEquals(approved_deviation.getText().trim(), Deviations);

		Thread.sleep(3000);
		Assert.assertEquals(approved_sae.getText().trim(), SAE);

		Thread.sleep(3000);
		Assert.assertEquals(approved_othersubmission.getText().trim(), Other_Submissions);

		// --TAKE COUNT BEFORE FORM "APPROVED"--//

		WebElement countbefore = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li/a/span[2]");

		String myString = countbefore.getText();
		System.out.println(myString);
		int foo = Integer.parseInt(myString);

		int A1 = foo, A2 = 1, SUMA;
		SUMA = A1 + A2;

		System.out.println(SUMA);

		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();

		WebElement logo81 = GWait.Wait_GetElementByCSS("img");
		logo81.click();

		// --PROJECT GETS MS DECISION AS LOP LETTER---//

		Dashboard_Links ns = new Dashboard_Links();
		ns.MSDECISION_LOP();

		GlobalMethods.Admin_Login();

		// --TAKE COUNT AFTER FROM "APPROVED"---//

		WebElement countafter = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li/a/span[2]");

		String myStringb = countafter.getText();
		System.out.println(myStringb);
		int fooB = Integer.parseInt(myStringb);

		Assert.assertEquals(SUMA, fooB);
		System.out.println(fooB);

		// --DASHBOARD REDIRECTION--//

		WebElement approved_approved = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li/a/span");
		approved_approved.click();

		Thread.sleep(4000);
		WebElement table_element1 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows1 = (ArrayList<WebElement>) table_element1.findElements(By.tagName("tr"));
		for (WebElement row : rows1) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[6]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Approved"));
				WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;

			}
			break;

		}
		WebElement dashboardclick = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick.click();

		// --TAKE COUNT BEFORE FROM "PROJECT CONTINOUS"--//

		WebElement countbefore1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[2]/a/span[2]");

		String myStringc = countbefore1.getText();
		System.out.println(myStringc);
		int fooc = Integer.parseInt(myStringc);

		int C1 = fooc, C2 = 1, SUMC;
		SUMC = C1 + C2;

		System.out.println(SUMC);

		WebElement logoutt22 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt22.click();

		WebElement logo811 = GWait.Wait_GetElementByCSS("img");
		logo811.click();

		// --PI SUBMITS CONTINOUS PROJECT TO ADMIN----//

		ns.PROJCONTADMIN();

		GlobalMethods.Admin_Login();

		// --TAKE COUNT AFER FROM "PROJECT CONTINOUS"--//

		WebElement countafter1 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[2]/a/span[2]");

		String myStringd = countafter1.getText();
		System.out.println(myStringd);
		int fooD = Integer.parseInt(myStringd);

		Assert.assertEquals(SUMC, fooD);
		System.out.println(fooD);

		// --DASHBOARD REDIRECTION--//

		WebElement approved_projectcontinous = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[2]/a/span");
		approved_projectcontinous.click();
		Thread.sleep(4000);
		WebElement table_element2 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows2 = (ArrayList<WebElement>) table_element2.findElements(By.tagName("tr"));
		for (WebElement row : rows2) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Forwarded to Chairperson"));
				WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;

			}
			break;
		}

		WebElement dashboardclick1 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick1.click();

		// --TAKE COUNT BEFORE FROM "PROJECT COMPLETION"---//

		WebElement countbefore2 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[3]/a/span[2]");

		String myStringe = countbefore2.getText();
		System.out.println(myStringe);
		int fooE = Integer.parseInt(myStringe);

		int E1 = fooE, E2 = 1, SUME;
		SUME = E1 + E2;

		System.out.println(SUME);

		WebElement logoutt222 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt222.click();

		WebElement logo8111 = GWait.Wait_GetElementByCSS("img");
		logo8111.click();

		// --PI SUBMITS COMPELETION PROJECT TO ADMIN----//

		ns.PROJCOMPADMIN();

		GlobalMethods.Admin_Login();

		// --TAKE COUNT AFTER FORM "PROJECT COMPLETION"--//

		WebElement countafter2 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[3]/a/span[2]");

		String myStringf = countafter2.getText();
		System.out.println(myStringf);
		int fooF = Integer.parseInt(myStringf);

		Assert.assertEquals(SUME, fooF);
		System.out.println(fooF);

		// --DASHBOARD REDIRECTION--//

		WebElement approved_projectcompletion = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[3]/a/span");
		approved_projectcompletion.click();
		Thread.sleep(4000);
		WebElement table_element3 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows3 = (ArrayList<WebElement>) table_element3.findElements(By.tagName("tr"));
		for (WebElement row : rows3) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Forwarded to Chairperson"));
				WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;

			}
			break;
		}

		WebElement dashboardclick2 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick2.click();

		// --TAKE COUNT BEFORE FROM "QUERIES REPLIED"--//
		WebElement countbefore3 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span[2]");

		String myStringg = countbefore3.getText();
		System.out.println(myStringg);
		int fooG = Integer.parseInt(myStringg);

		int G1 = fooG, G2 = 1, SUMG;
		SUMG = G1 + G2;

		System.out.println(SUMG);

		WebElement logoutt2222 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2222.click();

		WebElement logo81111 = GWait.Wait_GetElementByCSS("img");
		logo81111.click();

		// --PR REPLIES CONTIOUS QUERY TO ADMIN--//

		ns.MSDECISION_SUBQUERY();

		GlobalMethods.Admin_Login();

		// --TAKE COUNT AFTER FROM "QUERIES REPLIED"--//

		WebElement countafter3 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span[2]");

		String myStringh = countafter3.getText();
		System.out.println(myStringh);
		int fooH = Integer.parseInt(myStringh);

		Assert.assertEquals(SUMG, fooH);
		System.out.println(fooH);

		// --DASHBOARD REDIRECTION--//

		WebElement approved_queryreply = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[4]/a/span");
		approved_queryreply.click();

		Thread.sleep(4000);
		WebElement table_element4 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows4 = (ArrayList<WebElement>) table_element4.findElements(By.tagName("tr"));
		for (WebElement row1 : rows4) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row1.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Forwarded to Chairperson"));
				WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;

			}
			break;
		}

		WebElement dashboardclick3 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick3.click();

		// --TAKE COUNT BEFORE FROM "PROJECTS TERMINATED"--//
		WebElement countbefore4 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[5]/a/span[2]");

		String myStringI = countbefore4.getText();
		System.out.println(myStringI);
		int fooI = Integer.parseInt(myStringI);

		int I1 = fooI, I2 = 1, SUMI;
		SUMI = I1 + I2;

		System.out.println(SUMI);

		WebElement logoutt2A = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2A.click();

		WebElement logo1A = GWait.Wait_GetElementByCSS("img");
		logo1A.click();

		// --PI SUBMITS TERMINATION PROJECT TO ADMIN----//

		ns.PROJTERMADMIN();

		GlobalMethods.Admin_Login();

		// --TAKE COUNT AFTER FROM "PROJECTS TERMINATED--//

		WebElement countafter4 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[5]/a/span[2]");

		String myStringj = countafter4.getText();
		System.out.println(myStringj);
		int fooj = Integer.parseInt(myStringj);

		Assert.assertEquals(SUMI, fooj);
		System.out.println(fooj);

		// --DASHBOARD REDIRECTION---//

		WebElement approved_projecttermination = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[5]/a/span");
		approved_projecttermination.click();
		Thread.sleep(4000);
		WebElement table_element5 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows5 = (ArrayList<WebElement>) table_element5.findElements(By.tagName("tr"));
		for (WebElement row1 : rows5) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row1.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Forwarded to Chairperson"));
				WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;

			}
			break;
		}

		WebElement dashboardclick4 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick4.click();

		// --TAKE COUNT BEFORE FROM "AMENDMENT"--//
		WebElement countbefore5 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[6]/a/span[2]");

		String myStringJ = countbefore5.getText();
		System.out.println(myStringJ);
		int fooJ = Integer.parseInt(myStringJ);

		int J1 = fooJ, J2 = 1, SUMJ;
		SUMJ = J1 + J2;

		System.out.println(SUMJ);

		WebElement logoutt2J = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2J.click();

		WebElement logo1J = GWait.Wait_GetElementByCSS("img");
		logo1J.click();

		// --PI SUBMITS AMENDMENT PROJECT TO ADMIN----//

		ns.PROJAMENDADMIN();

		GlobalMethods.Admin_Login();

		// --TAKE COUNT AFTER FROM "AMENDMENT--//

		WebElement countafter5 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[6]/a/span[2]");

		String myStringk = countafter5.getText();
		System.out.println(myStringk);
		int fook = Integer.parseInt(myStringk);

		Assert.assertEquals(SUMJ, fook);
		System.out.println(fook);

		// --DASHBOARD REDIRECTION---//

		WebElement approved_amendments = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[6]/a/span");
		approved_amendments.click();
		Thread.sleep(4000);
		WebElement table_element6 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows6 = (ArrayList<WebElement>) table_element6.findElements(By.tagName("tr"));
		for (WebElement row1 : rows6) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row1.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Submitted to IEC"));
				WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;

			}
			break;
		}

		WebElement dashboardclick5 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick5.click();

		// --TAKE COUNT BEFORE FROM "DEVIATION"--//
		WebElement countbefore6 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[7]/a/span[2]");

		String myStringL = countbefore6.getText();
		System.out.println(myStringL);
		int fooL = Integer.parseInt(myStringL);

		int L1 = fooL, L2 = 1, SUML;
		SUML = L1 + L2;

		System.out.println(SUML);

		WebElement logoutt2L = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2L.click();

		WebElement logo1L = GWait.Wait_GetElementByCSS("img");
		logo1L.click();

		// --PI SUBMITS DEVIATION PROJECT TO ADMIN----//

		ns.PROJDEVADMIN();

		GlobalMethods.Admin_Login();

		// --TAKE COUNT AFTER FROM "DEVIATION"--//
		WebElement countafter6 = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[7]/a/span[2]");

		String myStringm = countafter6.getText();
		System.out.println(myStringm);
		int fooM = Integer.parseInt(myStringm);

		Assert.assertEquals(SUML, fooM);
		System.out.println(fooM);

		// --DASHBOARD REDIRECTION---//

		WebElement approved_deviation = GWait.Wait_GetElementByXpath("//div[2]/div/div/ul/li[7]/a/span");
		approved_deviation.click();
		Thread.sleep(4000);
		WebElement table_element7 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows7 = (ArrayList<WebElement>) table_element7.findElements(By.tagName("tr"));
		for (WebElement row1 : rows7) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row1.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Submitted to IEC"));
				WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;

			}
			break;
		}

		WebElement dashboardclick6 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick6.click();

		// --TAKE COUNT BEFORE FROM "SAE"--//
		WebElement countbefore7 = GWait.Wait_GetElementByXpath("//li[8]/a/span[2]");

		String myStringn = countbefore7.getText();
		System.out.println(myStringn);
		int fooN = Integer.parseInt(myStringn);

		int N1 = fooN, N2 = 1, SUMN;
		SUMN = N1 + N2;

		System.out.println(SUMN);

		WebElement logoutt2N = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2N.click();

		WebElement logo1N = GWait.Wait_GetElementByCSS("img");
		logo1N.click();

		// --PI SUBMITS SAE PROJECT TO ADMIN----//

		ns.PROJSAEADMIN();

		GlobalMethods.Admin_Login();

		// --TAKE COUNT AFTER FROM "SAE"--//
		WebElement countafter7 = GWait.Wait_GetElementByXpath("//li[8]/a/span[2]");

		String myStringo = countafter7.getText();
		System.out.println(myStringo);
		int fooO = Integer.parseInt(myStringo);

		Assert.assertEquals(SUMN, fooO);
		System.out.println(fooO);

		// ---DASHBOARD REDIRECTION--//

		WebElement approved_sae = GWait.Wait_GetElementByXpath("//li[8]/a/span");
		approved_sae.click();
		Thread.sleep(4000);
		WebElement table_element8 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows8 = (ArrayList<WebElement>) table_element8.findElements(By.tagName("tr"));
		for (WebElement row1 : rows8) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row1.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Submitted to IEC"));
				WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
				overview.click();
				Thread.sleep(4000);
				System.out.println(reviewtype.getText());
				break;

			}
			break;
		}

		WebElement dashboardclick7 = GWait.Wait_GetElementByLinkText("Dashboard");
		dashboardclick7.click();

		// --TAKE COUNT BEFORE FROM "OTHER"--//
		WebElement countbefore8 = GWait.Wait_GetElementByXpath("//li[9]/a/span[2]");

		String myStringp = countbefore8.getText();
		System.out.println(myStringp);
		int fooP = Integer.parseInt(myStringp);

		int P1 = fooP, P2 = 1, SUMP;
		SUMP = P1 + P2;

		System.out.println(SUMN);

		WebElement logoutt2P = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2P.click();

		WebElement logo1P = GWait.Wait_GetElementByCSS("img");
		logo1P.click();

		// --PI SUBMITS OTHER PROJECT TO ADMIN----//

		ns.PROJOTHERADMIN();
		GlobalMethods.Admin_Login();

		// --TAKE COUNT AFTER FROM "OTHER"--//
		WebElement countafter8 = GWait.Wait_GetElementByXpath("//li[9]/a/span[2]");

		String myStringq = countafter8.getText();
		System.out.println(myStringq);
		int fooQ = Integer.parseInt(myStringq);

		Assert.assertEquals(SUMP, fooQ);
		System.out.println(fooQ);

		// --DASHBOARD REDIRECTION---//

		WebElement approved_othersubmission = GWait.Wait_GetElementByXpath("//li[9]/a/span");
		approved_othersubmission.click();
		Thread.sleep(4000);
		WebElement table_element9 = GlobalMethods.driver.findElement(By.cssSelector(".table.table-striped>tbody"));
		ArrayList<WebElement> rows9 = (ArrayList<WebElement>) table_element9.findElements(By.tagName("tr"));
		for (WebElement row1 : rows9) {
			ArrayList<WebElement> cells = (ArrayList<WebElement>) row1.findElements(By.xpath("//td[9]"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				System.out.println(cell.getText().equalsIgnoreCase("Forwarded to Chairperson"));
				WebElement overview = GWait.Wait_GetElementByCSS("span.fa.fa-eye");
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
