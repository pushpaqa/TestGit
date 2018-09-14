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
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;
import com.thoughtworks.selenium.webdriven.commands.IsSomethingSelected;

import jxl.Sheet;
import jxl.Workbook;

/*
 * Check for Registration with valid/Invalid data in institution home page(After creation should display in the Manage registration requests/ List in admin page)\
 * 
 */
public class TS_25 {
	public TS_25() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(linkText = "Research approval institute")
	WebElement ResearchAppIns;

	@FindBy(css = ".btn.btn-primary.col-sm-12.register-class")
	WebElement RegisterLink;

	// ---Check for Registration form fields---//
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[1]/div[1]/label")
	WebElement FirstNameTxt;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[1]/div[2]/label")
	WebElement MiddleName;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[1]/div[3]/label")
	WebElement LastNameTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[1]/div[4]/label")
	WebElement EmpTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[1]/div[5]/label")
	WebElement DOBTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[1]/div[6]/label")
	WebElement PhoneNumTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[1]/div[7]/label")
	WebElement EmailTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[1]/div[8]/label")
	WebElement PhotoTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[2]/div[1]/label")
	WebElement DepartmentTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[2]/div[2]/label")
	WebElement DesignationTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[2]/div[3]/label")
	WebElement QualificationTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[3]/div[1]/label")
	WebElement IssueDateTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[3]/div[2]/label")
	WebElement DocumentsTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[4]/div[1]/label")
	WebElement DateOfCurVitTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[4]/div[2]/label")
	WebElement CurrVitaTXT;
	@FindBy(css = ".col-sm-8>p")
	WebElement IAcceptTXT;

	@FindBy(xpath = "//div[5]/div/div/div/div/h3")
	WebElement RegistrationTXT;
	@FindBy(xpath = "//form[@id='registerform']/div/h3")
	WebElement BasicInfoTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[2]/h3")
	WebElement PersonalInfoTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[3]/h3")
	WebElement GCPCerTXT;
	@FindBy(xpath = "//div[5]/div/div/div/div/form/div[4]/h3")
	WebElement UploadCurrVitTXT;

	@FindBy(css = "#registration_submit")
	WebElement SubmitTxt;

	// ---------Alert Prompt-------//
	@FindBy(xpath = "//div/form/div[1]/div[1]/div/label")
	WebElement FName_Alert;
	@FindBy(xpath = "//div/form/div[1]/div[3]/div/label")
	WebElement LName_Alert;
	@FindBy(xpath = "//div/form/div[1]/div[7]/div/label")
	WebElement Email_Alert;
	@FindBy(xpath = "//div/form/div[2]/div[1]/div/label")
	WebElement Department_Alert;
	@FindBy(xpath = "//div/form/div[2]/div[2]/div/label")
	WebElement Designation_Alert;

	// -------LogOUT----------//
	@FindBy(css = ".logout")
	WebElement LogOUT;

	// --------Check for Link Register-------//
	public void Register_CRe4_33_34_35_36() throws Exception {
		
		try{

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("Institute_Logins");
		Sheet r1 = wb.getSheet("Data_Sheet");

		String PI_Reg_Institute = r.getCell(0, 2).getContents();

		WebElement PI_institute = GWait.Wait_GetElementByLinkText(PI_Reg_Institute);
		PI_institute.click();

		String Register_data = r1.getCell(2, 93).getContents();
		String RegistrationTXT_data = r1.getCell(3, 93).getContents();
		String BasiInfoTXT_data = r1.getCell(4, 93).getContents();
		String PersonalInfoTXT_data = r1.getCell(5, 93).getContents();
		String GCPCerTXT_data = r1.getCell(6, 93).getContents();
		String UploadCurrTXT_data = r1.getCell(7, 93).getContents();

		String FirstNameTXT_data = r1.getCell(8, 93).getContents();
		String MiddleNameTXT_data = r1.getCell(9, 93).getContents();
		String LastNameTXT_data = r1.getCell(10, 93).getContents();
		String EmpTXT_data = r1.getCell(11, 93).getContents();
		String DOBTXT_data = r1.getCell(12, 93).getContents();
		String PhoneNumTXT_data = r1.getCell(13, 93).getContents();
		String EmailAddTXT_data = r1.getCell(14, 93).getContents();
		String PhotoTXT_data = r1.getCell(15, 93).getContents();
		String DepartmentTXT_data = r1.getCell(16, 93).getContents();
		String DesignTXT_data = r1.getCell(17, 93).getContents();
		String QualificationTXT_data = r1.getCell(18, 93).getContents();
		String IssueDateTXT_data = r1.getCell(19, 93).getContents();
		String DocumentsTXT_data = r1.getCell(20, 93).getContents();
		String DateCurrTXT_data = r1.getCell(21, 93).getContents();
		String CurrVitTXT_data = r1.getCell(22, 93).getContents();
		String IAcceptTXT_data = r1.getCell(23, 93).getContents();
		String SubmitTXT_data = r1.getCell(24, 93).getContents();

		String FNameAlert_data = r1.getCell(25, 93).getContents();
		String LNameAlert_data = r1.getCell(26, 93).getContents();
		String EmailAlert_data = r1.getCell(27, 93).getContents();
		String DepartmentAlert_data = r1.getCell(28, 93).getContents();
		String DesignationAlert_data = r1.getCell(29, 93).getContents();

		Thread.sleep(1000);
		// ---Register link---//
		System.out.println(RegisterLink.getText());
		if (RegisterLink.getText().equalsIgnoreCase(Register_data)) {
			System.out.println(RegisterLink.getText().equalsIgnoreCase(Register_data));
		} else {
			System.out.println("Test Fail Register");
		}

		WebElement RegisterLink = GWait.Wait_GetElementByCSS(".btn.btn-primary.col-sm-12.register-class");
		RegisterLink.click();

		// ---------Check for Registration form fields---------//
		Thread.sleep(1000);
		// ---Basic Information---//
		System.out.println(BasicInfoTXT.getText());
		if (BasicInfoTXT.getText().equalsIgnoreCase(BasiInfoTXT_data)) {
			System.out.println(BasicInfoTXT.getText().equalsIgnoreCase(BasiInfoTXT_data));
		} else {
			System.out.println("Test Fail Basic Information");
		}
		Thread.sleep(1000);
		// ---First Name---//
		System.out.println(FirstNameTxt.getText());
		if (FirstNameTxt.getText().equalsIgnoreCase(FirstNameTXT_data)) {
			System.out.println(FirstNameTxt.getText().equalsIgnoreCase(FirstNameTXT_data));
		} else {
			System.out.println("Test Fail First Name");
		}
		Thread.sleep(1000);
		// ---Middle Name---//
		System.out.println(MiddleName.getText());
		if (MiddleName.getText().equalsIgnoreCase(MiddleNameTXT_data)) {
			System.out.println(MiddleName.getText().equalsIgnoreCase(MiddleNameTXT_data));
		} else {
			System.out.println("Test Fail Middle Name");
		}
		Thread.sleep(1000);
		// ---Last Name ---//
		System.out.println(LastNameTXT.getText());
		if (LastNameTXT.getText().equalsIgnoreCase(LastNameTXT_data)) {
			System.out.println(LastNameTXT.getText().equalsIgnoreCase(LastNameTXT_data));
		} else {
			System.out.println("Test Fail Last Name ");
		}
		Thread.sleep(1000);
		// ---Employee / Student ID Number ---//
		System.out.println(EmpTXT.getText());
		if (EmpTXT.getText().equalsIgnoreCase(EmpTXT_data)) {
			System.out.println(EmpTXT.getText().equalsIgnoreCase(EmpTXT_data));
		} else {
			System.out.println("Test Fail Employee / Student ID Number");
		}
		Thread.sleep(1000);
		// ---Date of Birth ---//
		System.out.println(DOBTXT.getText());
		if (DOBTXT.getText().equalsIgnoreCase(DOBTXT_data)) {
			System.out.println(DOBTXT.getText().equalsIgnoreCase(DOBTXT_data));
		} else {
			System.out.println("Test Fail Date of Birth");
		}
		Thread.sleep(1000);
		// ---Phone Number ---//
		System.out.println(PhoneNumTXT.getText());
		if (PhoneNumTXT.getText().equalsIgnoreCase(PhoneNumTXT_data)) {
			System.out.println(PhoneNumTXT.getText().equalsIgnoreCase(PhoneNumTXT_data));
		} else {
			System.out.println("Test Fail Phone Number");
		}
		Thread.sleep(1000);
		// ---E-Mail Address---//
		System.out.println(EmailTXT.getText());
		if (EmailTXT.getText().equalsIgnoreCase(EmailAddTXT_data)) {
			System.out.println(EmailTXT.getText().equalsIgnoreCase(EmailAddTXT_data));
		} else {
			System.out.println("Test Fail E-Mail Address");
		}
		// ---Photo---//
		System.out.println(PhotoTXT.getText());
		if (PhotoTXT.getText().equalsIgnoreCase(PhotoTXT_data)) {
			System.out.println(PhotoTXT.getText().equalsIgnoreCase(PhotoTXT_data));
		} else {
			System.out.println("Test Fail Photo");
		}

		// ---Professional Information---//
		System.out.println(PersonalInfoTXT.getText());
		if (PersonalInfoTXT.getText().equalsIgnoreCase(PersonalInfoTXT_data)) {
			System.out.println(PersonalInfoTXT.getText().equalsIgnoreCase(PersonalInfoTXT_data));
		} else {
			System.out.println("Test Fail Professional Information");
		}
		// ---Department ---//
		System.out.println(DepartmentTXT.getText());
		if (DepartmentTXT.getText().equalsIgnoreCase(DepartmentTXT_data)) {
			System.out.println(DepartmentTXT.getText().equalsIgnoreCase(DepartmentTXT_data));
		} else {
			System.out.println("Test Fail Department ");
		}
		// ---Designation---//
		System.out.println(DesignationTXT.getText());
		if (DesignationTXT.getText().equalsIgnoreCase(DesignTXT_data)) {
			System.out.println(DesignationTXT.getText().equalsIgnoreCase(DesignTXT_data));
		} else {
			System.out.println("Test Fail Designation");
		}
		// ---Qualification---//
		System.out.println(QualificationTXT.getText());
		if (QualificationTXT.getText().equalsIgnoreCase(QualificationTXT_data)) {
			System.out.println(QualificationTXT.getText().equalsIgnoreCase(QualificationTXT_data));
		} else {
			System.out.println("Test Fail Qualification");
		}

		// ---GCP Certification---//
		System.out.println(GCPCerTXT.getText());
		if (GCPCerTXT.getText().equalsIgnoreCase(GCPCerTXT_data)) {
			System.out.println(GCPCerTXT.getText().equalsIgnoreCase(GCPCerTXT_data));
		} else {
			System.out.println("Test Fail GCP Certification");
		}
		// ---Issue Date---//
		System.out.println(IssueDateTXT.getText());
		if (IssueDateTXT.getText().equalsIgnoreCase(IssueDateTXT_data)) {
			System.out.println(IssueDateTXT.getText().equalsIgnoreCase(IssueDateTXT_data));
		} else {
			System.out.println("Test Fail Issue Date");
		}
		// ---Documents---//
		System.out.println(DocumentsTXT.getText());
		if (DocumentsTXT.getText().equalsIgnoreCase(DocumentsTXT_data)) {
			System.out.println(DocumentsTXT.getText().equalsIgnoreCase(DocumentsTXT_data));
		} else {
			System.out.println("Test Fail Documents");
		}

		// ---Upload Curriculum Vitae---//
		System.out.println(UploadCurrVitTXT.getText());
		if (UploadCurrVitTXT.getText().equalsIgnoreCase(UploadCurrTXT_data)) {
			System.out.println(UploadCurrVitTXT.getText().equalsIgnoreCase(UploadCurrTXT_data));
		} else {
			System.out.println("Test Fail Upload Curriculum Vitae");
		}
		// ---Date of Curriculum Vitae---//
		System.out.println(DateOfCurVitTXT.getText());
		if (DateOfCurVitTXT.getText().equalsIgnoreCase(DateCurrTXT_data)) {
			System.out.println(DateOfCurVitTXT.getText().equalsIgnoreCase(DateCurrTXT_data));
		} else {
			System.out.println("Test Fail Date of Curriculum Vitae");
		}
		// ---Curriculum Vitae---//
		System.out.println(CurrVitaTXT.getText());
		if (CurrVitaTXT.getText().equalsIgnoreCase(CurrVitTXT_data)) {
			System.out.println(CurrVitaTXT.getText().equalsIgnoreCase(CurrVitTXT_data));
		} else {
			System.out.println("Test Fail Curriculum Vitae");
		}

		// ---I accept the Terms and Conditions---//
		System.out.println(IAcceptTXT.getText());
		if (IAcceptTXT.getText().equalsIgnoreCase(IAcceptTXT_data)) {
			System.out.println(IAcceptTXT.getText().equalsIgnoreCase(IAcceptTXT_data));
		} else {
			System.out.println("Test Fail I accept the Terms and Conditions");
		}

		// ---Submit---//
		if (SubmitTxt.getAttribute("type").equalsIgnoreCase(SubmitTXT_data)) {
			System.out.println(SubmitTxt.getAttribute("type").equalsIgnoreCase(SubmitTXT_data));
		} else {
			System.out.println("Test Fail I accept the Terms and Conditions");
		}

		// ----Check validation for default selected fields in registration
		// form--//
		Thread.sleep(1000);
		System.out.println("Check validation for default selected fields in registration form--Test cases == CRe4_36");

		WebElement SubmitTxt = GWait.Wait_GetElementByCSS("#registration_submit");
		SubmitTxt.click();

		Thread.sleep(1000);
		GlobalMethods.alertaccept();
		// ---Alert In First Name---//
		System.out.println(FName_Alert.getText());
		if (FName_Alert.getText().equalsIgnoreCase(FNameAlert_data)) {
			System.out.println(FName_Alert.getText().equalsIgnoreCase(FNameAlert_data));
		} else {
			System.out.println("Test Fail Alert In First Name");
		}
		// ---Alert In Last Name---//
		System.out.println(LName_Alert.getText());
		if (LName_Alert.getText().equalsIgnoreCase(LNameAlert_data)) {
			System.out.println(LName_Alert.getText().equalsIgnoreCase(LNameAlert_data));
		} else {
			System.out.println("Test Fail Alert In Last Name");
		}
		// ---Alert In Email---//
		System.out.println(Email_Alert.getText());
		if (Email_Alert.getText().equalsIgnoreCase(EmailAlert_data)) {
			System.out.println(Email_Alert.getText().equalsIgnoreCase(EmailAlert_data));
		} else {
			System.out.println("Test Fail Alert In Email");
		}
		
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
		
		sheet.getRow(65).createCell(4).setCellValue("Pass");
		sheet.getRow(65).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(65).createCell(4).setCellValue("Fail");
			sheet.getRow(65).getCell(4).setCellStyle(style);
			
			sheet.getRow(65).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(65).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	// ----Check for only Basic information section fields as mandatory
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

	@FindBy(xpath = "//div/form/div[2]/div[3]/div/div/input[1]")
	WebElement Qualification_V;

	@FindBy(id = "mrvalids")
	WebElement GCPIssueDate_V;
	@FindBy(xpath = "//div/form/div[3]/div[2]/div[2]/span/input")
	WebElement GCPDocument_V;

	@FindBy(xpath = "//div/form/div[4]/div[1]/div/div/input")
	WebElement DateOfCurrVit_V;
	@FindBy(id = "resume")
	WebElement CurrVita_V;

	@FindBy(id = "field_terms")
	WebElement IAccept_V;

	// -----Home------//
	@FindBy(css = ".nav.nav-pills.submenu-main>li>a")
	WebElement HomeMenu;

	// -----Check for only professional information section fields as mandatory
	// remaining as optional---//
	@FindBy(css = ".logo-inner>a>img")
	WebElement Logo;
	@FindBy(css = ".link")
	WebElement SettingLink;
	@FindBy(xpath = "//div[3]/div/div[2]/ul/li[10]/ul/li[4]/a")
	WebElement PIRegistrationLink;

	// -----Basic Information-----//
	@FindBy(xpath = "//div[2]/div[3]/form/div[1]/div[2]/div/input")
	WebElement MiddleName_Select;
	@FindBy(xpath = "//div[2]/div[3]/form/div[1]/div[4]/div/input")
	WebElement EmpID_Select;
	@FindBy(css = ".col-sm-6.input-sm>input")
	WebElement DOB_Select;
	@FindBy(xpath = "//div[2]/div[3]/form/div[1]/div[6]/div/input")
	WebElement PhoneNum_Select;
	@FindBy(xpath = "//div[3]/form/div[1]/div[8]/div/input")
	WebElement Photo_Select;
	@FindBy(id = "regconfiguration")
	WebElement Submit;

	// --------Alert--------//
	@FindBy(xpath = "//form[@id='registerform']/div/div[2]/div/label")
	WebElement MiddleName_Alert;
	@FindBy(xpath = "//div/form/div[1]/div[4]/div/label")
	WebElement EmpID_Alert;
	@FindBy(xpath = "//form[@id='registerform']/div/div[5]/div/label")
	WebElement DOB_Alert;
	@FindBy(xpath = "//div/form/div[1]/div[6]/div/label")
	WebElement PhoneNumber_Alert;
	@FindBy(xpath = "//div/form/div[1]/div[8]/div/label")
	WebElement Photo_Alert;

	// ---Check for only Basic information section fields as mandatory remaining
	// as optional---//

	public void CRe4_37_38_39_40_41_44() throws Exception {
		

		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("Data_Sheet");

		String FNameAlert_data = r1.getCell(2, 95).getContents();
		String LNameAlert_data = r1.getCell(3, 95).getContents();
		String EmailAlert_data = r1.getCell(4, 95).getContents();
		
		String DepartmentAlert_data = r1.getCell(5, 95).getContents();
		String DesignationAlert_data = r1.getCell(6, 95).getContents();
		String MNameAlert_data = r1.getCell(7, 95).getContents();
		String EmpIDAlert_data = r1.getCell(8, 95).getContents();
		String DOBAlert_data = r1.getCell(9, 95).getContents();
		String PhoneNumAlert_data = r1.getCell(10, 95).getContents();
		String PhotoAlert_data = r1.getCell(11, 95).getContents();

		

		WebElement SettingLink = GWait.Wait_GetElementByCSS(".link");
		SettingLink.click();

		WebElement PIRegistrationLink = GWait.Wait_GetElementByXpath("//div[3]/div/div[2]/ul/li[10]/ul/li[4]/a");
		PIRegistrationLink.click();

		Thread.sleep(1000);
		System.out.println(
				"Check for only Basic information section fields as mandatory remaining as optional--Test cases == CRe4_37");

		

		
		/*List<WebElement> check = GlobalMethods.driver.findElements(By.cssSelector(".col-sm-4.input-sm"));
		for (WebElement iterable_element : check) {
			if (!iterable_element.isSelected()) {
				iterable_element.click();

			} else {
				System.out.println("do nothing");
			}
		}
*/
		
		  WebElement MiddleName_Select = GWait.Wait_GetElementByXpath( "//div[2]/div[3]/form/div[1]/div[2]/div/input");
		 MiddleName_Select.click();
		  
		 WebElement EmpID_Select = GWait.Wait_GetElementByXpath( "//div[2]/div[3]/form/div[1]/div[4]/div/input");
		 EmpID_Select.click();
		 
		  WebElement DOB_Select =GWait.Wait_GetElementByCSS(".col-sm-6.input-sm>input");
		 DOB_Select.click();
		 
		  WebElement PhoneNum_Select = GWait.Wait_GetElementByXpath("//div[2]/div[3]/form/div[1]/div[6]/div/input");
		  PhoneNum_Select.click();
		 
		 
		  WebElement Photo_Select = GWait.Wait_GetElementByXpath("//div[3]/form/div[1]/div[8]/div/input");
		  Photo_Select.click();
		 
		 
		 

		WebElement Submit = GWait.Wait_GetElementById("regconfiguration");
		Submit.click();

		Thread.sleep(1000);

		GlobalMethods.alertaccept();

		WebElement logoutt = GWait.Wait_GetElementByXpath("//span/a");
		logoutt.click();

		WebElement RegisterLink = GWait.Wait_GetElementByCSS(".btn.btn-primary.col-sm-12.register-class");
		RegisterLink.click();

		WebElement SubmitTxt = GWait.Wait_GetElementByCSS("#registration_submit");
		SubmitTxt.click();

		Thread.sleep(2000);
		GlobalMethods.alertaccept();

		Thread.sleep(5000);
		// ---Alert In First Name---//

		/*if (FName_Alert.getText().equalsIgnoreCase("First Name field is required!")) {
			System.out.println(FName_Alert.getText().equalsIgnoreCase("First Name field is required!"));
		} else {
			System.out.println("Test Fail Alert In First Name");
		}*/

		if(GlobalMethods.driver.getPageSource().contains("First Name field is required!")){
			System.out.println("Text is present");
			}else{
			System.out.println("Text is absent");
			}
		((JavascriptExecutor) GlobalMethods.driver).executeScript("scroll(250,0);");
		/*
		 * try { if(FName_Alert.isDisplayed()) {
		 * System.out.println(FName_Alert.getText());
		 * System.out.println("Test pass Alert In First Name"); } else {
		 * System.out.println("Test Fail Alert In First Name"); } } catch
		 * (NoAlertPresentException e) { e.getMessage(); }
		 */

		// ---Alert In Last Name---//

	
		if(GlobalMethods.driver.getPageSource().contains("Last Name field is required!")){
			System.out.println("Text is present");
			}else{
			System.out.println("Text is absent");
			}

		// ---Alert In Email---//

		
		if(GlobalMethods.driver.getPageSource().contains("Email field is required!")){
			System.out.println("Text is present");
			}else{
			System.out.println("Text is absent");
			}
	
		// ---Alert In Middle Name---//


		
		if(GlobalMethods.driver.getPageSource().contains("Middle Name field is required!")){
			System.out.println("Text is present");
			}else{
			System.out.println("Text is absent");
			}
		
		
		
		// ---Alert In Employee / Student ID Number---//

		
		 if(GlobalMethods.driver.getPageSource().contains("Employee / Student ID Number field is required!")){
				System.out.println("Text is present");
				}else{
				System.out.println("Text is absent");
				}
		 
					 

		// ---Alert In Date of Birth---//

		
		 if(GlobalMethods.driver.getPageSource().contains("Date of birth field is required!")){
				System.out.println("Text is present");
				}else{
				System.out.println("Text is absent");
				}
		 
			
		

		// ---Alert In Phone Number---//
		 
			if(GlobalMethods.driver.getPageSource().contains("Please give valid phone number!")){
				System.out.println("Text is present");
				}else{
				System.out.println("Text is absent");
				}

		/*if (PhoneNumber_Alert.getText().equalsIgnoreCase("Please give valid phone number!")) {
			System.out.println(PhoneNumber_Alert.getText().equalsIgnoreCase("Please give valid phone number!"));
		} else {
			System.out.println("Test Fail Alert In Phone Number");
		}*/
		

		// ---Alert In Photo---//
			
			if(GlobalMethods.driver.getPageSource().contains("Photo field is required!")){
				System.out.println("Text is present");
				}else{
				System.out.println("Text is absent");
				}

	/*	if (Photo_Alert.getText().equalsIgnoreCase("Photo field is required!")) {
			System.out.println(Photo_Alert.getText().equalsIgnoreCase("Photo field is required!"));
		} else {
			System.out.println("Test Fail Alert In Photo");
		}*/
		
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
			
			sheet.getRow(66).createCell(4).setCellValue("Pass");
			sheet.getRow(66).getCell(4).setCellStyle(style);
			
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
				
				sheet.getRow(66).createCell(4).setCellValue("Fail");
				sheet.getRow(66).getCell(4).setCellStyle(style);
				
				sheet.getRow(66).createCell(5).setCellValue("Report Error: "+ "\n" + e);
				sheet.getRow(66).getCell(5).setCellStyle(style);
				
				FileOutputStream output = new FileOutputStream(source);
				wb11.write(output);
				wb11.close();
				
				throw(e);
		}
	}

	// -------Check by not filling the mandatory fields and clicking submit
	// button---//
	public void RegisterIECadmin_CRe4_46_47() throws Exception {
		
		try{

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("Institute_Logins");
		Sheet r1 = wb.getSheet("Data_Sheet");

		String PI_Reg_Institute = r.getCell(0, 1).getContents();

		WebElement PI_institute = GWait.Wait_GetElementByLinkText(PI_Reg_Institute);
		PI_institute.click();

		WebElement RegisterLink = GWait.Wait_GetElementByCSS(".btn.btn-primary.col-sm-12.register-class");
		RegisterLink.click();

		// String FName_data = r1.getCell(2, 97).getContents();
		String MName_data = r1.getCell(3, 97).getContents();
		// String LName_data = r1.getCell(4, 97).getContents();
		String EmpID_data = r1.getCell(5, 97).getContents();
		String DOB_data = r1.getCell(6, 97).getContents();
		String PhoneNum_data = r1.getCell(7, 97).getContents();
		// String EmailId_data = r1.getCell(8, 97).getContents();
		String Photo_data = r1.getCell(9, 97).getContents();
		// String Department_data = r1.getCell(10, 97).getContents();
		// String Designation_data = r1.getCell(11, 97).getContents();
		String Qualification_data = r1.getCell(12, 97).getContents();
		String IssueDate_data = r1.getCell(13, 97).getContents();
		String GCPDOC_data = r1.getCell(14, 97).getContents();
		String DateOfCurr_data = r1.getCell(15, 97).getContents();
		String CurrvitaDoc_data = r1.getCell(16, 97).getContents();

		System.out.println("Check by not filling the mandatory fields and clicking submit button");

		Thread.sleep(1000);
		MiddleName_V.sendKeys(MName_data);
		Thread.sleep(1000);
		EmpId_V.sendKeys(EmpID_data);
		Thread.sleep(1000);
		DOB_V.sendKeys(DOB_data);
		Thread.sleep(1000);
		PhoneNum_V.sendKeys(PhoneNum_data);
		Photo_V.sendKeys(Photo_data);
		Thread.sleep(1000);
		Qualification_V.click();
		Thread.sleep(1000);
		GCPIssueDate_V.sendKeys(IssueDate_data);
		Thread.sleep(1000);
		GCPDocument_V.sendKeys(GCPDOC_data);
		Thread.sleep(1000);
		DateOfCurrVit_V.sendKeys(DateOfCurr_data);
		Thread.sleep(1000);
		CurrVita_V.sendKeys(CurrvitaDoc_data);
		// IAccept_V.click();
		WebElement SubmitTxt = GWait.Wait_GetElementByCSS("#registration_submit");
		SubmitTxt.click();
		Thread.sleep(2000);
		GlobalMethods.alertaccept();
		Thread.sleep(5000);
		
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
		
		sheet.getRow(67).createCell(4).setCellValue("Pass");
		sheet.getRow(67).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(67).createCell(4).setCellValue("Fail");
			sheet.getRow(67).getCell(4).setCellStyle(style);
			
			sheet.getRow(67).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(67).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	// ----Check that clicking submit button after entering all the required
	// fields, submits the data to the server---//

	@FindBy(id = "dept")
	WebElement Department_V;
	@FindBy(id = "departmenttext")
	WebElement Department_Other;

	@FindBy(id = "designation")
	WebElement Designation_V;

	// ---Check that clicking submit button after entering all the required
	// fields, submits the data to the server--//

	public void RegisterIECadmin_CRe4_45() throws Exception {
		
		try{

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("Institute_Logins");
		Sheet r1 = wb.getSheet("Data_Sheet");

		String PI_Reg_Institute = r.getCell(0, 2).getContents();

		WebElement PI_institute = GWait.Wait_GetElementByLinkText(PI_Reg_Institute);
		PI_institute.click();

		WebElement RegisterLink = GWait.Wait_GetElementByCSS(".btn.btn-primary.col-sm-12.register-class");
		RegisterLink.click();

		String FName_data = r1.getCell(2, 97).getContents();
		String MName_data = r1.getCell(3, 97).getContents();
		String LName_data = r1.getCell(4, 97).getContents();
		String EmpID_data = r1.getCell(5, 97).getContents();
		String DOB_data = r1.getCell(6, 97).getContents();
		String PhoneNum_data = r1.getCell(7, 97).getContents();
		String EmailId_data = r1.getCell(8, 97).getContents();
		String Photo_data = r1.getCell(9, 97).getContents();
		String Department_data = r1.getCell(10, 97).getContents();
		String Designation_data = r1.getCell(11, 97).getContents();
		String Qualification_data = r1.getCell(12, 97).getContents();
		String IssueDate_data = r1.getCell(13, 97).getContents();
		String GCPDOC_data = r1.getCell(14, 97).getContents();
		String DateOfCurr_data = r1.getCell(15, 97).getContents();
		String CurrvitaDoc_data = r1.getCell(16, 97).getContents();

		
		WebElement FirstName_V = GWait.Wait_GetElementById("firstname");
		FirstName_V.sendKeys(FName_data);
		WebElement MiddleName_V = GWait.Wait_GetElementById("middlename");
		MiddleName_V.clear();
		WebElement MiddleName_V1 = GWait.Wait_GetElementById("middlename");
		MiddleName_V1.sendKeys(MName_data);
		WebElement LastName_V = GWait.Wait_GetElementById("lastname");
		LastName_V.sendKeys(LName_data);
		WebElement EmpId_V = GWait.Wait_GetElementById("emp_id");
		EmpId_V.clear();
		WebElement EmpId_V1 = GWait.Wait_GetElementById("emp_id");
		EmpId_V1.sendKeys(EmpID_data);
		Thread.sleep(1000);
		DOB_V.clear();
		DOB_V.sendKeys(DOB_data);
		Thread.sleep(1000);
		PhoneNum_V.clear();
		PhoneNum_V.sendKeys(PhoneNum_data);
		Thread.sleep(1000);
		Email_V.sendKeys(EmailId_data);

		Thread.sleep(2000);
		Select depart = new Select(Department_V);
		depart.selectByVisibleText("Other");
		Thread.sleep(2000);
		Department_Other.sendKeys(Department_data);
		Thread.sleep(2000);
		Select Design = new Select(Designation_V);
		Design.selectByVisibleText(Designation_data);
		Thread.sleep(1000);

		Qualification_V.click();
		Thread.sleep(1000);
		GCPIssueDate_V.clear();
		GCPIssueDate_V.sendKeys(IssueDate_data);

		Thread.sleep(1000);
		DateOfCurrVit_V.clear();
		DateOfCurrVit_V.sendKeys(DateOfCurr_data);

		IAccept_V.click();

		WebElement SubmitTxt = GWait.Wait_GetElementByCSS("#registration_submit");
		SubmitTxt.click();
		
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
		
		sheet.getRow(68).createCell(4).setCellValue("Pass");
		sheet.getRow(68).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(68).createCell(4).setCellValue("Fail");
			sheet.getRow(68).getCell(4).setCellStyle(style);
			
			sheet.getRow(68).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(68).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
		
	}

	// Issue no validation given for middle name field
	public void CRe4_48_49_50_51_52_54_55_55_a() throws Exception {
		
		try{

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("Institute_Logins");
		Sheet r1 = wb.getSheet("Data_Sheet");

		String PI_Reg_Institute = r.getCell(0, 2).getContents();

		String empdata = r1.getCell(2, 99).getContents();
		String phonenumber1 = r1.getCell(3, 99).getContents();
		String phonenumber2 = r1.getCell(4, 99).getContents();
		String email1 = r1.getCell(5, 99).getContents();
		String email2 = r1.getCell(6, 99).getContents();
		String phalert = r1.getCell(7, 99).getContents();
		String emailalert = r1.getCell(8, 99).getContents();
		String dobalert = r1.getCell(9, 99).getContents();
		String frstalert = r1.getCell(10, 99).getContents();
		String middlealert = r1.getCell(11, 99).getContents();
		String lstalert = r1.getCell(12, 99).getContents();

		WebElement PI_institute = GWait.Wait_GetElementByLinkText(PI_Reg_Institute);
		PI_institute.click();

		WebElement RegisterLink = GWait.Wait_GetElementByCSS(".btn.btn-primary.col-sm-12.register-class");
		RegisterLink.click();

		WebElement FirstName_V = GWait.Wait_GetElementById("firstname");
		FirstName_V.sendKeys("     ");

		WebElement MiddleName_V = GWait.Wait_GetElementById("middlename");
		MiddleName_V.clear();

		WebElement MiddleName_V1 = GWait.Wait_GetElementById("middlename");
		MiddleName_V1.sendKeys("    ");

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

		Email_V.clear();
		Assert.assertEquals(phmsg.getText().trim(), phalert);

		WebElement PhoneNum_V2 = GWait.Wait_GetElementById("phno");
		PhoneNum_V2.clear();

		WebElement PhoneNum_V3 = GWait.Wait_GetElementById("phno");
		PhoneNum_V3.sendKeys(phonenumber2);

		Thread.sleep(1000);
		Assert.assertEquals(phmsg.getText().trim(), phalert);

		WebElement PhoneNum_V4 = GWait.Wait_GetElementById("phno");
		PhoneNum_V4.clear();

		WebElement PhoneNum_V5 = GWait.Wait_GetElementById("phno");
		PhoneNum_V5.sendKeys("     ");
		
		WebElement FirstName_V1 = GWait.Wait_GetElementById("firstname");
		FirstName_V1.sendKeys("     ");
		Email_V.clear();
		Thread.sleep(1000);
		//Assert.assertEquals(phmsg.getText().trim(), phalert);
		
		Email_V.clear();
		Email_V.sendKeys(email1);

		WebElement PhoneNum_V6 = GWait.Wait_GetElementById("phno");
		PhoneNum_V6.clear();

		Assert.assertEquals(emailmsg.getText().trim(), emailalert);

		Email_V.clear();
		Email_V.sendKeys(email2);

		WebElement PhoneNum_V7 = GWait.Wait_GetElementById("phno");
		PhoneNum_V7.clear();
		Assert.assertEquals(emailmsg.getText().trim(), emailalert);

		Email_V.clear();
		Email_V.sendKeys("   ");
		WebElement PhoneNum_V8 = GWait.Wait_GetElementById("phno");
		PhoneNum_V8.clear();
		Assert.assertEquals(emailmsg.getText().trim(), emailalert);

		IAccept_V.click();

		WebElement SubmitTxt1 = GWait.Wait_GetElementByCSS("#registration_submit");
		SubmitTxt1.click();

		Assert.assertEquals(phmsg.getText().trim(), frstalert);

		// Assert.assertEquals(middlenamemsg.getText().trim(), middlealert);
		Assert.assertEquals(lastnamemsg.getText().trim(), lstalert);
		//Assert.assertEquals(dobmsg.getText().trim(), dobalert);
		
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
		
		sheet.getRow(69).createCell(4).setCellValue("Pass");
		sheet.getRow(69).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(69).createCell(4).setCellValue("Fail");
			sheet.getRow(69).getCell(4).setCellStyle(style);
			
			sheet.getRow(69).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(69).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	public void CRe4_53() throws Exception {
		
		try{

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("Institute_Logins");

		String PI_Reg_Institute = r.getCell(0, 2).getContents();

		WebElement PI_institute = GWait.Wait_GetElementByLinkText(PI_Reg_Institute);
		PI_institute.click();

		WebElement RegisterLink = GWait.Wait_GetElementByCSS(".btn.btn-primary.col-sm-12.register-class");
		RegisterLink.click();

		WebElement FirstName_V1 = GWait.Wait_GetElementById("firstname");
		FirstName_V1.clear();

		WebElement FirstName_V2 = GWait.Wait_GetElementById("firstname");
		FirstName_V2.sendKeys("Testname ");

		String name = GWait.Wait_GetElementById("firstname").getAttribute("value");
		System.out.println(name);

		Assert.assertEquals(name, "Testname");

		WebElement MiddleName_V = GWait.Wait_GetElementById("middlename");
		MiddleName_V.clear();

		WebElement MiddleName_V3 = GWait.Wait_GetElementById("middlename");
		MiddleName_V3.sendKeys("Testname ");

		String name1 = GWait.Wait_GetElementById("middlename").getAttribute("value");
		System.out.println(name1);

		Assert.assertEquals(name1, "Testname");

		WebElement LastName_V1 = GWait.Wait_GetElementById("lastname");
		LastName_V1.clear();

		WebElement LastName_V2 = GWait.Wait_GetElementById("lastname");
		LastName_V2.sendKeys("Testname ");

		String name2 = GWait.Wait_GetElementById("lastname").getAttribute("value");
		System.out.println(name2);

		Assert.assertEquals(name2, "Testname");

		WebElement EmpId_V = GWait.Wait_GetElementById("emp_id");
		EmpId_V.clear();

		WebElement EmpId_V2 = GWait.Wait_GetElementById("emp_id");
		EmpId_V2.sendKeys("Testname ");

		String name3 = GWait.Wait_GetElementById("emp_id").getAttribute("value");
		System.out.println(name3);

		Assert.assertEquals(name3, "Testname");

		WebElement EmpId_V3 = GWait.Wait_GetElementById("emp_id");
		EmpId_V3.clear();

		WebElement EmpId_V4 = GWait.Wait_GetElementById("emp_id");
		EmpId_V4.sendKeys("Testname ");

		String name4 = GWait.Wait_GetElementById("emp_id").getAttribute("value");
		System.out.println(name4);

		Assert.assertEquals(name4, "Testname");

		WebElement PhoneNum_V = GWait.Wait_GetElementById("phno");
		PhoneNum_V.clear();

		WebElement PhoneNum_V1 = GWait.Wait_GetElementById("phno");
		PhoneNum_V1.sendKeys("1234567891 ");

		String name5 = GWait.Wait_GetElementById("phno").getAttribute("value");
		System.out.println(name5);

		Assert.assertEquals(name5, "1234567891");

		IAccept_V.click();

		WebElement SubmitTxt = GWait.Wait_GetElementByCSS("#registration_submit");
		SubmitTxt.click();
		
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
		
		sheet.getRow(70).createCell(4).setCellValue("Pass");
		sheet.getRow(70).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(70).createCell(4).setCellValue("Fail");
			sheet.getRow(70).getCell(4).setCellStyle(style);
			
			sheet.getRow(70).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(70).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
		
	}

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

}
