package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for Profile view/update after PI Login with Valid details.(Data should get from PI registration)
 */
public class TS_29 {
	public TS_29() {
		PageFactory.initElements(GlobalMethods.driver, this);
	}

    GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[6]/a")
	WebElement MyAccount;
	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[6]/ul/li[1]/a")
	WebElement MyProfile;

	@FindBy(xpath = "html/body/div[5]/div/div[1]/div[1]/div[2]/h3")
	WebElement MyProfilePageTXT;
	@FindBy(xpath = "//div[1]/div[1]/div[2]/div[3]/form/div[1]/h3")
	WebElement BasicInformationTXT;
	@FindBy(xpath = "//div[1]/div[1]/div[2]/div[3]/form/div[2]/h3")
	WebElement ProfessionalInformationTXT;
	@FindBy(xpath = "//div[1]/div[1]/div[2]/div[3]/form/div[3]/h3")
	WebElement GCPCertificationsTXT;
	@FindBy(xpath = "//div[1]/div[1]/div[2]/div[3]/form/div[4]/h3")
	WebElement UploadCurriculumVitaeTXT;
	@FindBy(id = "confirmAlert")
	WebElement UpdateTXT;

	// ----------Check for 'My profile' form fields -------//

	public void CRe4_95() throws Exception {
		try{
		
		// ----------PI Login------------//
		
		GlobalMethods.PI_Login();
		
		WebElement MyAccount =GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[6]/a");
		MyAccount.click();
		
		
		WebElement MyProfile =GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[6]/ul/li[1]/a");
		MyProfile.click();
		
		/*WebElement clickpopup =GWait.Wait_GetElementByCSS("div.modal-content.oldResumeModal   > div.modal-header > button.close");
		clickpopup.click();*/

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("Projects");

		String MyProfilePageTXT_data = r.getCell(2, 15).getContents();
		String BasicInformationTXT_data = r.getCell(3, 15).getContents();
		String ProfessionalInformationTXT_data = r.getCell(4, 15).getContents();
		String GCPCertificationsTXT_data = r.getCell(5, 15).getContents();
		String UploadCurriculumVitaeTXT_data = r.getCell(6, 15).getContents();
		String UpdateTXT_data = r.getCell(7, 15).getContents();

		// ----MyProfilePage----//
		Thread.sleep(1000);
		System.out.println(MyProfilePageTXT.getText());
		if (MyProfilePageTXT.getText().equalsIgnoreCase(MyProfilePageTXT_data)) {
			System.out.println(MyProfilePageTXT.getText().equalsIgnoreCase(MyProfilePageTXT_data));
		} else {
			System.out.println("Test Fail MyProfilePage");
		}
		// ----BasicInformation----//
		Thread.sleep(1000);
		System.out.println(BasicInformationTXT.getText());
		if (BasicInformationTXT.getText().equalsIgnoreCase(BasicInformationTXT_data)) {
			System.out.println(BasicInformationTXT.getText().equalsIgnoreCase(BasicInformationTXT_data));
		} else {
			System.out.println("Test Fail BasicInformation");
		}
		// ----ProfessionalInformation----//
		Thread.sleep(1000);
		System.out.println(ProfessionalInformationTXT.getText());
		if (ProfessionalInformationTXT.getText().equalsIgnoreCase(ProfessionalInformationTXT_data)) {
			System.out.println(ProfessionalInformationTXT.getText().equalsIgnoreCase(ProfessionalInformationTXT_data));
		} else {
			System.out.println("Test Fail ProfessionalInformation");
		}
		// ----GCPCertifications----//
		Thread.sleep(1000);
		System.out.println(GCPCertificationsTXT.getText());
		if (GCPCertificationsTXT.getText().equalsIgnoreCase(GCPCertificationsTXT_data)) {
			System.out.println(GCPCertificationsTXT.getText().equalsIgnoreCase(GCPCertificationsTXT_data));
		} else {
			System.out.println("Test Fail GCPCertifications");
		}
		// ----UploadCurriculumVitae----//
		Thread.sleep(1000);
		System.out.println(UploadCurriculumVitaeTXT.getText());
		if (UploadCurriculumVitaeTXT.getText().equalsIgnoreCase(UploadCurriculumVitaeTXT_data)) {
			System.out.println(UploadCurriculumVitaeTXT.getText().equalsIgnoreCase(UploadCurriculumVitaeTXT_data));
		} else {
			System.out.println("Test Fail UploadCurriculumVitae");
		}
		// ----Update----//
		Thread.sleep(1000);
		System.out.println(UpdateTXT.getAttribute("type"));
		if (UpdateTXT.getAttribute("type").equalsIgnoreCase(UpdateTXT_data)) {
			System.out.println(UpdateTXT.getAttribute("type").equalsIgnoreCase(UpdateTXT_data));
		} else {
			System.out.println("Test Fail Update");
		}
		WebElement logoutt2 = GWait.Wait_GetElementByXpath("//span/a");
		logoutt2.click();
		
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile1");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(91).createCell(4).setCellValue("Pass");
		sheet.getRow(91).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile1");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(91).createCell(4).setCellValue("Fail");
			sheet.getRow(91).getCell(4).setCellStyle(style);
			
			sheet.getRow(91).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(91).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	@FindBy(id = "firstname")
	WebElement FName;
	@FindBy(id = "middlename")
	WebElement MName;
	@FindBy(id = "lastname")
	WebElement LName;
	@FindBy(id = "emp_id")
	WebElement EMPID;
	@FindBy(id = "dobs")
	WebElement DOB;
	@FindBy(id = "phno")
	WebElement PhoneNum;
	@FindBy(id = "email")
	WebElement Email;

	@FindBy(id = "dept")
	WebElement Department;
	@FindBy(id = "designation")
	WebElement Designation;

	@FindBy(id = "mrvalids")
	WebElement IssueDate;

	@FindBy(xpath = "//div[2]/div[3]/form/div[4]/div[1]/div/div/input")
	WebElement DateOfCurrVita;

	//---------System should diaplay his/her profile view with all the details entered while registering------//
	
	public void CRe4_96() throws Exception {
		
		try{
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		
		Sheet r1 = wb.getSheet("Data_Sheet");

			
		
		String PI_firstname = r1.getCell(18, 103).getContents();
		String PI_middlename = r1.getCell(19, 103).getContents();
		String PI_lastname = r1.getCell(20, 103).getContents();
		String PI_emdpid = r1.getCell(21, 103).getContents();
		String PI_dob = r1.getCell(22, 103).getContents();
		String PI_phnum = r1.getCell(23, 103).getContents();
		String PI_email = r1.getCell(24, 103).getContents();
		
		String PI_photo = r1.getCell(25, 103).getContents();
		String PI_dept1 = r1.getCell(26, 103).getContents();
		String PI_dept2 = r1.getCell(27, 103).getContents();
		String PI_desg = r1.getCell(28, 103).getContents();
		String PI_gcpdate = r1.getCell(29, 103).getContents();
		String PI_gcpdoc = r1.getCell(30, 103).getContents();
		String PI_cvdate = r1.getCell(31, 103).getContents();
		String PI_cvdoc = r1.getCell(32, 103).getContents();
		
		
		GlobalMethods.PI_Login();
		
		WebElement MyAccount =GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/a");
		MyAccount.click();
		
		
		WebElement MyProfile =GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/ul/li[1]/a");
		MyProfile.click();
		
		/*WebElement clickpopup =GWait.Wait_GetElementByCSS("div.modal-content.oldResumeModal   > div.modal-header > button.close");
		clickpopup.click();*/
		
		Thread.sleep(2000);
		
		Assert.assertEquals(FName.getAttribute("value").trim(), PI_firstname);

		
		Assert.assertEquals(MName.getAttribute("value").trim(), PI_middlename);
		
		Assert.assertEquals(LName.getAttribute("value").trim(), PI_lastname);
		
		Assert.assertEquals(EMPID.getAttribute("value").trim(), PI_emdpid);
		
		//Assert.assertEquals(DOB.getAttribute("value").trim(), PI_dob);
		
		Assert.assertEquals(PhoneNum.getAttribute("value").trim(), PI_phnum);
		
		//Assert.assertEquals(Email.getAttribute("value").trim(), PI_email);
		
		List<WebElement> CPfield=GlobalMethods.driver.findElements(By.id("dept"));
		for (WebElement selectboxDiv : CPfield) {
			String selectboxValue = selectboxDiv.getText().trim();
			System.out.println(selectboxValue);
			if (selectboxValue.equals(PI_dept2)) {
				Assert.assertEquals(selectboxValue, PI_dept2);
				
			}
		}
		
		//Assert.assertEquals(Department.getAttribute("value").trim(), PI_dept2);
		
		List<WebElement> CPfield1=GlobalMethods.driver.findElements(By.id("designation"));
		for (WebElement selectboxDiv : CPfield1) {
			String selectboxValue = selectboxDiv.getText().trim();
			System.out.println(selectboxValue);
			if (selectboxValue.equals(PI_desg)) {
				Assert.assertEquals(selectboxValue, PI_desg);
				
			}
		}
		
		
		
		//Assert.assertEquals(Designation.getAttribute("value").trim(), PI_desg);
		
		Assert.assertEquals(IssueDate.getAttribute("value").trim(), PI_gcpdate);
		
		Assert.assertEquals(DateOfCurrVita.getAttribute("value").trim(), PI_cvdate);

		System.out.println(FName.getAttribute("value"));
		System.out.println(MName.getAttribute("value"));
		System.out.println(LName.getAttribute("value"));
		System.out.println(EMPID.getAttribute("value"));
		System.out.println(DOB.getAttribute("value"));
		System.out.println(PhoneNum.getAttribute("value"));
		System.out.println(Email.getAttribute("value"));
		System.out.println(Department.getAttribute("value"));
		System.out.println(Designation.getAttribute("value"));
		System.out.println(IssueDate.getAttribute("value"));
		System.out.println(DateOfCurrVita.getAttribute("value"));

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile1");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(92).createCell(4).setCellValue("Pass");
		sheet.getRow(92).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile1");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(92).createCell(4).setCellValue("Fail");
			sheet.getRow(92).getCell(4).setCellStyle(style);
			
			sheet.getRow(92).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(92).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}
//---Check for update profile by selecting 'Ok' for action confirmation--//
	
	public void CRe4_97_98() throws Exception {
		
		try{
		
		GlobalMethods.PI_Login();
		
		WebElement MyAccount =GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/a");
		MyAccount.click();
		
		
		WebElement MyProfile =GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/ul/li[1]/a");
		MyProfile.click();
		
		/*WebElement clickpopup =GWait.Wait_GetElementByCSS("div.modal-content.oldResumeModal   > div.modal-header > button.close");
		clickpopup.click();*/
		

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("Projects");

		String FNameUPD_data = r.getCell(2, 17).getContents();
		String MNameUPD_data = r.getCell(3, 17).getContents();
		String LNameUPD_data = r.getCell(4, 17).getContents();
		String EmpIdUPD_data = r.getCell(5, 17).getContents();
		String DOBUPD_data = r.getCell(6, 17).getContents();
		String PNumberUPD_data = r.getCell(7, 17).getContents();
		
		
		WebElement FName =GWait.Wait_GetElementById("firstname");
		FName.clear();
		
		WebElement FName1 =GWait.Wait_GetElementById("firstname");
		FName1.sendKeys(FNameUPD_data);
		
		WebElement MName =GWait.Wait_GetElementById("middlename");
		MName.clear();
		
		WebElement MName1 =GWait.Wait_GetElementById("middlename");
		MName1.sendKeys(MNameUPD_data);
		
		WebElement LName =GWait.Wait_GetElementById("lastname");
		LName.clear();
		
		WebElement LName1 =GWait.Wait_GetElementById("lastname");
		LName1.sendKeys(LNameUPD_data);
		
		WebElement EMPID =GWait.Wait_GetElementByName("emp_id");
		EMPID.clear();
		
		WebElement EMPID1 =GWait.Wait_GetElementByName("emp_id");
		EMPID1.sendKeys(EmpIdUPD_data);
		
		WebElement DOB =GWait.Wait_GetElementById("dobs");
		DOB.clear();
		
		WebElement DOB1 =GWait.Wait_GetElementById("dobs");
		DOB1.sendKeys(DOBUPD_data);
		
		WebElement PhoneNum =GWait.Wait_GetElementById("phno");
		PhoneNum.clear();
		
		WebElement PhoneNum1 =GWait.Wait_GetElementById("phno");
		PhoneNum1.sendKeys(PNumberUPD_data);
		
		WebElement UpdateTXT =GWait.Wait_GetElementById("confirmAlert");
		
		UpdateTXT.click();
		
		/*Thread.sleep(2000);
		GlobalMethods.alertaccept();*/
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile1");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(93).createCell(4).setCellValue("Pass");
		sheet.getRow(93).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile1");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(93).createCell(4).setCellValue("Fail");
			sheet.getRow(93).getCell(4).setCellStyle(style);
			
			sheet.getRow(93).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(93).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// -------Check for profile update with blank data----//
	public void CRe4_99() throws Exception {
		
		try{
		
		
		GlobalMethods.PI_Login();
		
		WebElement MyAccount =GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/a");
		MyAccount.click();
		
		
		WebElement MyProfile =GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/ul/li[1]/a");
		MyProfile.click();
		
		
		/*WebElement clickpopup =GWait.Wait_GetElementByCSS("div.modal-content.oldResumeModal   > div.modal-header > button.close");
		clickpopup.click();*/
		
		
		WebElement FName =GWait.Wait_GetElementById("firstname");
		FName.clear();
		WebElement MName =GWait.Wait_GetElementById("middlename");
		MName.clear();
		WebElement LName =GWait.Wait_GetElementById("lastname");
		LName.clear();
		WebElement EMPID =GWait.Wait_GetElementByName("emp_id");
		EMPID.clear();
		WebElement DOB =GWait.Wait_GetElementById("dobs");
		DOB.clear();
		WebElement PhoneNum =GWait.Wait_GetElementById("phno");
		PhoneNum.clear();
		
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor) GlobalMethods.driver;
		executor.executeScript("window.document.getElementById('email').value = ' '");

		WebElement IssueDate =GWait.Wait_GetElementById("mrvalids");
		IssueDate.clear();
		
		WebElement DateOfCurrVita =GWait.Wait_GetElementByXpath("//div[2]/div[3]/form/div[4]/div[1]/div/div/input");
		DateOfCurrVita.clear();
		
		WebElement UpdateTXT =GWait.Wait_GetElementById("confirmAlert");
		UpdateTXT.click();
		
		
		Thread.sleep(2000);
		GlobalMethods.alertaccept();
		
		Assert.assertEquals(namealert.getText().trim(), "First Name field is required!");
		
		Assert.assertEquals(lastalert.getText().trim(), "Last Name field is required!");
		
		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile1");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(94).createCell(4).setCellValue("Pass");
		sheet.getRow(94).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile1");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(94).createCell(4).setCellValue("Fail");
			sheet.getRow(94).getCell(4).setCellStyle(style);
			
			sheet.getRow(94).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(94).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	@FindBy(xpath = "(//a[contains(@href, 'https://createstagenew.quad1test.com/auth/logout')])[2]")
	WebElement LogOut;
	
	@FindBy(xpath = "//form[@id='registerform']/div/div/div/label")
	WebElement namealert;
	
	@FindBy(xpath = "//form[@id='registerform']/div/div[3]/div/label")
	WebElement lastalert;
	
	

	
}
