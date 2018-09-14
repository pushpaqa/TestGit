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
 * Check for PI profile view/update with  invalid data in PI login.
 */
public class TS_136 {

	public TS_136() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/ul/li[6]/a")
	WebElement MyAccount;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/ul/li[6]/ul/li[1]/a")
	WebElement MyProfile;

	@FindBy(xpath = "/html/body/div[5]/div/div[1]/div[1]/div[2]/h3")
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
	@FindBy(xpath = "//span/a")
	WebElement logoutt;
	// ----------Check for 'My profile' form fields -------//

	public void CRe4_684() throws Exception {
		try{
		
		// ----------PI Login------------//

		GlobalMethods.PI_Login();

		WebElement MyAccount = GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/a");
		MyAccount.click();

		WebElement MyProfile = GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/ul/li[1]/a");
		MyProfile.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("Projects");

		String MyProfilePageTXT_data = r.getCell(2, 19).getContents();
		String BasicInformationTXT_data = r.getCell(3, 19).getContents();
		String ProfessionalInformationTXT_data = r.getCell(4, 19).getContents();
		String GCPCertificationsTXT_data = r.getCell(5, 19).getContents();
		String UploadCurriculumVitaeTXT_data = r.getCell(6, 19).getContents();
		String UpdateTXT_data = r.getCell(7, 19).getContents();

		// ----MyProfilePage----//
		Thread.sleep(3000);
		System.out.println(MyProfilePageTXT.getText());
		if (MyProfilePageTXT.getText().equalsIgnoreCase(MyProfilePageTXT_data)) {
			System.out.println(MyProfilePageTXT.getText().equalsIgnoreCase(MyProfilePageTXT_data));
		} else {
			System.out.println("Test Fail MyProfilePage");
		}
		// ----BasicInformation----//
		Thread.sleep(3000);
		System.out.println(BasicInformationTXT.getText());
		if (BasicInformationTXT.getText().equalsIgnoreCase(BasicInformationTXT_data)) {
			System.out.println(BasicInformationTXT.getText().equalsIgnoreCase(BasicInformationTXT_data));
		} else {
			System.out.println("Test Fail BasicInformation");
		}
		// ----ProfessionalInformation----//
		Thread.sleep(3000);
		System.out.println(ProfessionalInformationTXT.getText());
		if (ProfessionalInformationTXT.getText().equalsIgnoreCase(ProfessionalInformationTXT_data)) {
			System.out.println(ProfessionalInformationTXT.getText().equalsIgnoreCase(ProfessionalInformationTXT_data));
		} else {
			System.out.println("Test Fail ProfessionalInformation");
		}
		// ----GCPCertifications----//
		Thread.sleep(3000);
		System.out.println(GCPCertificationsTXT.getText());
		if (GCPCertificationsTXT.getText().equalsIgnoreCase(GCPCertificationsTXT_data)) {
			System.out.println(GCPCertificationsTXT.getText().equalsIgnoreCase(GCPCertificationsTXT_data));
		} else {
			System.out.println("Test Fail GCPCertifications");
		}
		// ----UploadCurriculumVitae----//
		Thread.sleep(3000);
		System.out.println(UploadCurriculumVitaeTXT.getText());
		if (UploadCurriculumVitaeTXT.getText().equalsIgnoreCase(UploadCurriculumVitaeTXT_data)) {
			System.out.println(UploadCurriculumVitaeTXT.getText().equalsIgnoreCase(UploadCurriculumVitaeTXT_data));
		} else {
			System.out.println("Test Fail UploadCurriculumVitae");
		}
		// ----Update----//
		Thread.sleep(3000);
		System.out.println(UpdateTXT.getAttribute("type"));
		if (UpdateTXT.getAttribute("type").equalsIgnoreCase(UpdateTXT_data)) {
			System.out.println(UpdateTXT.getAttribute("type").equalsIgnoreCase(UpdateTXT_data));
		} else {
			System.out.println("Test Fail Update");
		}
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
		
		sheet.getRow(97).createCell(4).setCellValue("Pass");
		sheet.getRow(97).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(97).createCell(4).setCellValue("Fail");
			sheet.getRow(97).getCell(4).setCellStyle(style);
			
			sheet.getRow(97).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(97).getCell(5).setCellStyle(style);
			
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
	@FindBy(name = "emp_id")
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

	public void CRe4_686() throws Exception {
		
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

		WebElement MyAccount = GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/a");
		MyAccount.click();

		WebElement MyProfile = GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/ul/li[1]/a");
		MyProfile.click();
		Thread.sleep(2000);
		Assert.assertEquals(FName.getAttribute("value").trim(), PI_firstname);
		Thread.sleep(2000);

		Assert.assertEquals(MName.getAttribute("value").trim(), PI_middlename);
		Thread.sleep(2000);
		Assert.assertEquals(LName.getAttribute("value").trim(), PI_lastname);
		Thread.sleep(2000);
		Assert.assertEquals(EMPID.getAttribute("value").trim(), PI_emdpid);
		Thread.sleep(2000);
		
		System.out.println(DOB.getAttribute("value"));
		System.out.println(PI_dob);
		//Assert.assertEquals(DOB.getAttribute("value").trim(), PI_dob);
		
		Thread.sleep(2000);
		Assert.assertEquals(PhoneNum.getAttribute("value").trim(), PI_phnum);
		Thread.sleep(2000);
		//Assert.assertEquals(Email.getAttribute("value").trim(), PI_email);

		List<WebElement> deptfield = GlobalMethods.driver.findElements(By.id("dept"));
		for (WebElement selectboxDiv : deptfield) {
			String selectboxValue = selectboxDiv.getText().trim();
			if (selectboxValue.equals(PI_dept2)) {
				Assert.assertEquals(selectboxValue, PI_dept2);
				System.out.println(selectboxValue);
			}
		}

		// Assert.assertEquals(Department.getAttribute("value").trim(),
		// PI_dept2);

		List<WebElement> desgfield = GlobalMethods.driver.findElements(By.id("designation"));
		for (WebElement selectboxDiv : desgfield) {
			String selectboxValue = selectboxDiv.getText().trim();
			if (selectboxValue.equals(PI_desg)) {
				Assert.assertEquals(selectboxValue, PI_desg);
				System.out.println(selectboxValue);
			}
		}

		// Assert.assertEquals(Designation.getAttribute("value").trim(),
		// PI_desg);

		//Assert.assertEquals(IssueDate.getAttribute("value").trim(), PI_gcpdate);

		//Assert.assertEquals(DateOfCurrVita.getAttribute("value").trim(), PI_cvdate);

		System.out.println(FName.getAttribute("value"));
		System.out.println(MName.getAttribute("value"));
		System.out.println(LName.getAttribute("value"));
		System.out.println(EMPID.getAttribute("value"));
		System.out.println(DOB.getAttribute("value"));
		System.out.println(PhoneNum.getAttribute("value"));
		// System.out.println(Email.getAttribute("value"));
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
		
		sheet.getRow(98).createCell(4).setCellValue("Pass");
		sheet.getRow(98).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(98).createCell(4).setCellValue("Fail");
			sheet.getRow(98).getCell(4).setCellStyle(style);
			
			sheet.getRow(98).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(98).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	public void CRe4_686_a() throws Exception {
		
		try{

		GlobalMethods.PI_Login();

		WebElement MyAccount = GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/a");
		MyAccount.click();

		WebElement MyProfile = GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/ul/li[1]/a");
		MyProfile.click();

		WebElement UpdateTXT = GWait.Wait_GetElementById("confirmAlert");
		UpdateTXT.click();

		GlobalMethods.alertaccept();

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
		
		sheet.getRow(99).createCell(4).setCellValue("Pass");
		sheet.getRow(99).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(99).createCell(4).setCellValue("Fail");
			sheet.getRow(99).getCell(4).setCellStyle(style);
			
			sheet.getRow(99).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(99).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// -------Check for profile update with blank data----//
	public void CRe4_687() throws Exception {
		
		try{
		
		Thread.sleep(2000);
		GlobalMethods.PI_Login();

		WebElement MyAccount = GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/a");
		MyAccount.click();

		WebElement MyProfile = GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/ul/li[1]/a");
		MyProfile.click();

		Thread.sleep(2000);
		FName.clear();
		Thread.sleep(2000);
		MName.clear();
		Thread.sleep(2000);
		LName.clear();
		Thread.sleep(5000);
		EMPID.clear();
		Thread.sleep(2000);
		DOB.clear();
		Thread.sleep(2000);
		PhoneNum.clear();
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) GlobalMethods.driver;
		executor.executeScript("window.document.getElementById('email').value = ' '");

		IssueDate.clear();
		DateOfCurrVita.clear();
		Thread.sleep(2000);
		UpdateTXT.click();
		GlobalMethods.alertaccept();
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
		
		sheet.getRow(100).createCell(4).setCellValue("Pass");
		sheet.getRow(100).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(100).createCell(4).setCellValue("Fail");
			sheet.getRow(100).getCell(4).setCellStyle(style);
			
			sheet.getRow(100).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(100).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	@FindBy(css = "html/body/div[3]/div/div[2]/ul/li[1]/a")
	WebElement Dashboard;

	public void CRe4_697_698_699_700_701_702_703_704_705() throws Exception {
		
		try{

		GlobalMethods.PI_Login();

		WebElement MyAccount = GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/a");
		MyAccount.click();

		WebElement MyProfile = GWait.Wait_GetElementByXpath("/html/body/div[3]/div/div[2]/ul/li[6]/ul/li[1]/a");
		MyProfile.click();
		
		
		
		
		WebElement i = GWait.Wait_GetElementByXpath("//div[@id='myModal']/div[2]/div/div/button");
		if (i.isDisplayed()) {
			i.click();

		} else {
			System.out.println("Value is inactive");
		}

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Projects");

		String FNameUPD_data = r1.getCell(2, 21).getContents();
		String MNameUPD_data = r1.getCell(3, 21).getContents();
		String LNameUPD_data = r1.getCell(4, 21).getContents();
		String EmpIdUPD_data = r1.getCell(5, 21).getContents();
		String DOBUPD_data = r1.getCell(6, 21).getContents();
		String PNumberUPD_data = r1.getCell(7, 21).getContents();
		String EmailUPD_data = r1.getCell(8, 21).getContents();
		String IssueDateUPD_data = r1.getCell(9, 21).getContents();
		String DateOfCurrVitaUPD_data = r1.getCell(10, 21).getContents();

		String empdata = r1.getCell(11, 21).getContents();
		String phonenumber1 = r1.getCell(12, 21).getContents();
		String phonenumber2 = r1.getCell(13, 21).getContents();
		String email1 = r1.getCell(14, 21).getContents();
		String email2 = r1.getCell(15, 21).getContents();
		String phalert = r1.getCell(16, 21).getContents();
		String emailalert = r1.getCell(17, 21).getContents();
		String dobalert = r1.getCell(18, 21).getContents();
		String frstalert = r1.getCell(19, 21).getContents();
		String middlealert = r1.getCell(20, 21).getContents();
		String lstalert = r1.getCell(21, 21).getContents();

		WebElement FirstName_V = GWait.Wait_GetElementById("firstname");
		FirstName_V.sendKeys("     ");

		WebElement MiddleName_V = GWait.Wait_GetElementById("middlename");
		MiddleName_V.clear();

		WebElement MiddleName_V1 = GWait.Wait_GetElementById("middlename");
		MiddleName_V1.sendKeys("    ");
		
		WebElement LastName_V1 = GWait.Wait_GetElementById("lastname");
		LastName_V1.clear();

		WebElement LastName_V = GWait.Wait_GetElementById("lastname");
		LastName_V.sendKeys("    ");

		WebElement EmpId_V = GWait.Wait_GetElementById("emp_id");
		EmpId_V.clear();

		WebElement EmpId_V4 = GWait.Wait_GetElementById("emp_id");
		EmpId_V4.sendKeys(empdata);

		WebElement PhoneNum_V = GWait.Wait_GetElementById("phno");
		PhoneNum_V.clear();

		WebElement PhoneNum_V1 = GWait.Wait_GetElementById("phno");
		PhoneNum_V1.sendKeys(phonenumber1);

		WebElement EmpId_V1 = GWait.Wait_GetElementById("emp_id");
		EmpId_V1.clear();

		Assert.assertEquals(phmsg.getText().trim(), phalert);

		WebElement PhoneNum_V2 = GWait.Wait_GetElementById("phno");
		PhoneNum_V2.clear();

		WebElement PhoneNum_V3 = GWait.Wait_GetElementById("phno");
		PhoneNum_V3.sendKeys(phonenumber2);

		Thread.sleep(1000);
		Assert.assertEquals(phmsg.getText().trim(), phalert);

		
		WebElement FirstName_V1 = GWait.Wait_GetElementById("firstname");
		FirstName_V1.clear();

		WebElement FirstName_V2 = GWait.Wait_GetElementById("firstname");
		FirstName_V2.sendKeys("     ");
		
		
		
		WebElement SubmitTxt1 = GWait.Wait_GetElementById("confirmAlert");
		SubmitTxt1.click();
		Thread.sleep(2000);
	
		
		Thread.sleep(2000);
		GlobalMethods.alertaccept();
		Thread.sleep(2000);
		
		Assert.assertEquals(phmsg.getText().trim(), "First Name field is required!");
			

		WebElement PhoneNum_V6 = GWait.Wait_GetElementById("phno");
		PhoneNum_V6.clear();

		WebElement SubmitTxt3 = GWait.Wait_GetElementById("confirmAlert");
		SubmitTxt3.click();
		
		Thread.sleep(2000);
		GlobalMethods.alertaccept();
		Thread.sleep(2000);
		
		
		WebElement SubmitTxt2 = GWait.Wait_GetElementById("confirmAlert");
		SubmitTxt2.click();
		
		Thread.sleep(2000);
		GlobalMethods.alertaccept();
		Thread.sleep(2000);

		Assert.assertEquals(phmsg.getText().trim(), frstalert);
		System.out.println(phmsg.getText());
		// Assert.assertEquals(middlenamemsg.getText().trim(), middlealert);
		Assert.assertEquals(lastnamemsg.getText().trim(), lstalert);
		System.out.println(lastnamemsg.getText());

		WebElement FName = GWait.Wait_GetElementById("firstname");
		FName.clear();

		WebElement FName1 = GWait.Wait_GetElementById("firstname");
		FName1.sendKeys(FNameUPD_data);

		WebElement MName = GWait.Wait_GetElementById("middlename");
		MName.clear();

		WebElement MName1 = GWait.Wait_GetElementById("middlename");
		MName1.sendKeys(MNameUPD_data);

		WebElement LName = GWait.Wait_GetElementById("lastname");
		LName.clear();

		WebElement LName1 = GWait.Wait_GetElementById("lastname");
		LName1.sendKeys(LNameUPD_data);

		WebElement EMPID = GWait.Wait_GetElementByName("emp_id");
		EMPID.clear();

		WebElement EMPID1 = GWait.Wait_GetElementByName("emp_id");
		EMPID1.sendKeys(EmpIdUPD_data);

		WebElement DOB = GWait.Wait_GetElementById("dobs");
		DOB.clear();

		WebElement DOB1 = GWait.Wait_GetElementById("dobs");
		DOB1.sendKeys(DOBUPD_data);

		WebElement PhoneNum = GWait.Wait_GetElementById("phno");
		PhoneNum.clear();

		WebElement PhoneNum1 = GWait.Wait_GetElementById("phno");
		PhoneNum1.sendKeys(PNumberUPD_data);

		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) GlobalMethods.driver;
		executor.executeScript("window.document.getElementById('email').value = 'qualeetee112+23@gmail.com'");

		WebElement IssueDate = GWait.Wait_GetElementById("mrvalids");
		IssueDate.clear();

		WebElement IssueDate1 = GWait.Wait_GetElementById("mrvalids");
		IssueDate1.sendKeys(IssueDateUPD_data);

		WebElement DateOfCurrVita = GWait.Wait_GetElementByXpath("//div[2]/div[3]/form/div[4]/div[1]/div/div/input");
		DateOfCurrVita.clear();

		WebElement DateOfCurrVita1 = GWait.Wait_GetElementByXpath("//div[2]/div[3]/form/div[4]/div[1]/div/div/input");
		DateOfCurrVita1.sendKeys(DateOfCurrVitaUPD_data);

		WebElement UpdateTXT = GWait.Wait_GetElementById("confirmAlert");
		UpdateTXT.click();

		
		
		Thread.sleep(2000);
		GlobalMethods.alertaccept();

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
		
		sheet.getRow(101).createCell(4).setCellValue("Pass");
		sheet.getRow(101).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(101).createCell(4).setCellValue("Fail");
			sheet.getRow(101).getCell(4).setCellStyle(style);
			
			sheet.getRow(101).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(101).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// remaining as optional---//

	@FindBy(id = "firstname")
	WebElement FirstName_V;
	@FindBy(id = "middlename")
	WebElement MiddleName_V;
	@FindBy(id = "lastname")
	WebElement LastName_V;
	@FindBy(id = "emp_id")
	WebElement EmpId_V;
	@FindBy(id = "dobs")
	WebElement DOB_V;
	@FindBy(id = "phno")
	WebElement PhoneNum_V;
	@FindBy(id = "email")
	WebElement Email_V;
	@FindBy(id = "photos")
	WebElement Photo_V;

	@FindBy(css = "label.error")
	WebElement phmsg;

	@FindBy(xpath = "//form[@id='registerform']/div/div[7]/div/label")
	WebElement emailmsg;

	@FindBy(css = "div.col-sm-6 > label.error")
	WebElement dobmsg;

	@FindBy(xpath = "//form[@id='registerform']/div/div[2]/div/label")
	WebElement middlenamemsg;

	@FindBy(xpath = "//form[@id='registerform']/div/div[3]/div/label")
	WebElement lastnamemsg;

	@FindBy(id = "field_terms")
	WebElement IAccept_V;

}
