package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

public class TS_137 {
	public TS_137() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/ul/li[5]/a")
	WebElement MyAccount;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a")
	WebElement MyProfile;

	@FindBy(xpath = "/html/body/div[4]/div/div[1]/div[2]/h3")
	WebElement MyProfilePageTXT;
	@FindBy(xpath = "//div[1]/div[2]/form/div[1]/div/h3")
	WebElement BasicInformationTXT;
	@FindBy(xpath = "//div[1]/div[2]/form/div[2]/div/h3")
	WebElement ProfessionalInformationTXT;
	@FindBy(xpath = "//div[1]/div[2]/form/div[3]/div/h3")
	WebElement SOPTrainingTXT;
	@FindBy(xpath = "//div[1]/div[2]/form/div[3]/div/div[4]/h3")
	WebElement GCPCertificationsTXT;
	@FindBy(xpath = "//div[1]/div[2]/form/div[3]/div/div[4]/div[3]/h3")
	WebElement TrainingOnEthicsTXT;
	@FindBy(id = "add_iec_member_details")
	WebElement UpdateTXT;

	// ----------Check for 'My profile' form fields -------//

	public void CRe4_706_707() throws Exception {
		
		try{
		// ----------IECMember_Login------------//
		GlobalMethods.Member1Login();
		WebElement MyAccount = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/a");
		MyAccount.click();
		WebElement MyProfile = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a");
		MyProfile.click();

		try {
			if (ExpectedConditions.alertIsPresent() != null) {
				GlobalMethods.alertaccept();
			}
		} catch (NoAlertPresentException e) {
			System.out.println("No Alert Present");
		}

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String MyProfilePageTXT_data = r.getCell(2, 186).getContents();
		String BasicInformationTXT_data = r.getCell(3, 186).getContents();
		String ProfessionalInformationTXT_data = r.getCell(4, 186).getContents();
		String SOPTXT_data = r.getCell(5, 186).getContents();
		String GCPCertificationsTXT_data = r.getCell(6, 186).getContents();
		String EthicsTXT_data = r.getCell(7, 186).getContents();
		String UpdateTXT_data = r.getCell(8, 186).getContents();


		// ----MyProfilePage----//

		System.out.println(MyProfilePageTXT.getText());
		Assert.assertEquals(MyProfilePageTXT.getText(), MyProfilePageTXT_data);

		// ----BasicInformation----//
		System.out.println(BasicInformationTXT.getText());
		Assert.assertEquals(BasicInformationTXT.getText(), BasicInformationTXT_data);

		// ----ProfessionalInformation----//
		System.out.println(ProfessionalInformationTXT.getText());
		Assert.assertEquals(ProfessionalInformationTXT.getText(), ProfessionalInformationTXT_data);

		// ----SOPTraining----//
		System.out.println(SOPTrainingTXT.getText());
		Assert.assertEquals(SOPTrainingTXT.getText(), SOPTXT_data);

		// ----GCPCertifications----//
		System.out.println(GCPCertificationsTXT.getText());
		Assert.assertEquals(GCPCertificationsTXT.getText(), GCPCertificationsTXT_data);

		// ----TrainingOnEthics----//
		System.out.println(TrainingOnEthicsTXT.getText());
		Assert.assertEquals(TrainingOnEthicsTXT.getText(), EthicsTXT_data);

		// ----Update----//
		System.out.println(UpdateTXT.getAttribute("type"));
		Assert.assertEquals(UpdateTXT.getAttribute("type"), UpdateTXT_data);

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(151).createCell(4).setCellValue("Pass");
		sheet.getRow(151).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(151).createCell(4).setCellValue("Fail");
			sheet.getRow(151).getCell(4).setCellStyle(style);
			
			sheet.getRow(151).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(151).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	@FindBy(id = "add_iec_member_first_name")
	WebElement FName;
	@FindBy(id = "add_iec_member_middle_name")
	WebElement MName;
	@FindBy(id = "add_iec_member_last_name")
	WebElement LName;
	@FindBy(id = "add_iec_member_emp_id")
	WebElement EMPID;
	@FindBy(id = "add_iec_member_date_of_birth")
	WebElement DOB;
	@FindBy(id = "add_iec_member_contact_number")
	WebElement PhoneNum;
	@FindBy(id = "add_iec_member_email")
	WebElement Email;
	@FindBy(id = "add_iec_member_photo")
	WebElement Photo;

	@FindBy(id = "add_iec_member_department")
	WebElement Department;
	@FindBy(id = "add_iec_member_designation")
	WebElement Designation;
	@FindBy(xpath = "//div[2]/form/div[2]/div/div[3]/div/div/div")
	WebElement Qualification;
	@FindBy(id = "add_iec_member_registration_number")
	WebElement RegstrationNum;
	@FindBy(id = "medvalid")
	WebElement ValidTill;

	// ---SOP---//
	@FindBy(id = "add_iec_member_add_certificate_date_of_training_sop")
	WebElement DateOftrainingSOP;

	// ---GCP---//
	@FindBy(id = "add_iec_member_add_certificate_date_of_gcp")
	WebElement IssueDate;

	// ---Ethics---//
	@FindBy(id = "add_iec_member_add_certificate_title_ethics")
	WebElement title;
	@FindBy(id = "add_iec_member_add_certificate_date_of_training_ethics")
	WebElement DateOfTraningEthics;

	public void CRe4_708() throws Exception {
		
		try{
		GlobalMethods.Member1Login();
		WebElement MyAccount = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/a");
		MyAccount.click();
		WebElement MyProfile = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a");
		MyProfile.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String frstname = r.getCell(2, 188).getContents();
		String lstname = r.getCell(3, 188).getContents();
		String dob = r.getCell(4, 188).getContents();
		String email = r.getCell(5, 188).getContents();
		String emp = r.getCell(6, 188).getContents();
		String ph = r.getCell(7, 188).getContents();

		System.out.println(FName.getAttribute("value"));
		// Assert.assertEquals(FName.getAttribute("value"), frstname);
		System.out.println(MName.getAttribute("value"));
		System.out.println(LName.getAttribute("value"));
		// Assert.assertEquals(LName.getAttribute("value"), lstname);
		System.out.println(EMPID.getAttribute("value"));
		// Assert.assertEquals(EMPID.getAttribute("value"), emp);
		System.out.println(DOB.getAttribute("value"));
		// Assert.assertEquals(DOB.getAttribute("value"), dob);
		System.out.println(PhoneNum.getAttribute("value"));
		// Assert.assertEquals(PhoneNum.getAttribute("value"), ph);
		System.out.println(Email.getAttribute("value"));
		// Assert.assertEquals(Email.getAttribute("value"), email);
		System.out.println(Department.getAttribute("value"));
		System.out.println(Designation.getAttribute("value"));
		System.out.println(RegstrationNum.getAttribute("value"));
		System.out.println(ValidTill.getAttribute("value"));

		System.out.println(IssueDate.getAttribute("value"));
		System.out.println(DateOftrainingSOP.getAttribute("value"));
		System.out.println(title.getAttribute("value"));
		System.out.println(DateOfTraningEthics.getAttribute("value"));

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(152).createCell(4).setCellValue("Pass");
		sheet.getRow(152).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(152).createCell(4).setCellValue("Fail");
			sheet.getRow(152).getCell(4).setCellStyle(style);
			
			sheet.getRow(152).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(152).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// -------Check for profile update with blank data----//
	public void CRe4_709() throws Exception {
		
		try{
		GlobalMethods.Member1Login();
		WebElement MyAccount = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/a");
		MyAccount.click();
		WebElement MyProfile = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a");
		MyProfile.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String FNameALRT_data = r.getCell(2, 190).getContents();
		String LNameALRT_data = r.getCell(3, 190).getContents();

		FName.clear();
		MName.clear();
		LName.clear();
		EMPID.clear();
		DOB.clear();
		PhoneNum.clear();

		IssueDate.clear();
		DateOftrainingSOP.clear();
		DateOfTraningEthics.clear();
		WebElement UpdateTXT = GWait.Wait_GetElementById("add_iec_member_details");
		UpdateTXT.click();
		// -------Verify Alert messages-----//
		// ---First Name---//
		System.out.println(FName_Alert.getText());
		Assert.assertEquals(FName_Alert.getText(), FNameALRT_data);

		// ---Last Name---//
		System.out.println(LName_Alert.getText());
		Assert.assertEquals(LName_Alert.getText(), LNameALRT_data);

		// GlobalMethods.alertaccept();
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(153).createCell(4).setCellValue("Pass");
		sheet.getRow(153).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(153).createCell(4).setCellValue("Fail");
			sheet.getRow(153).getCell(4).setCellStyle(style);
			
			sheet.getRow(153).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(153).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	public void CRe4_710() throws Exception {
		
		try{

		GlobalMethods.Member1Login();
		WebElement MyAccount = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/a");
		MyAccount.click();
		WebElement MyProfile = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a");
		MyProfile.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String FNameUPD_data = r.getCell(2, 192).getContents();
		String MNameUPD_data = r.getCell(3, 192).getContents();
		String LNameUPD_data = r.getCell(4, 192).getContents();
		String EmpIdUPD_data = r.getCell(5, 192).getContents();
		String DOBUPD_data = r.getCell(6, 192).getContents();
		String PNumberUPD_data = r.getCell(7, 192).getContents();
		String PhotoUPD_data = r.getCell(8, 192).getContents();

		FName.clear();
		FName.sendKeys(FNameUPD_data);
		MName.clear();
		MName.sendKeys(MNameUPD_data);
		LName.clear();
		LName.sendKeys(LNameUPD_data);
		EMPID.clear();
		EMPID.sendKeys(EmpIdUPD_data);
		DOB.clear();
		DOB.sendKeys(DOBUPD_data);
		PhoneNum.clear();
		PhoneNum.sendKeys(PNumberUPD_data);

		Photo.sendKeys(PhotoUPD_data);

		WebElement UpdateTXT = GWait.Wait_GetElementById("add_iec_member_details");
		UpdateTXT.click();
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(154).createCell(4).setCellValue("Pass");
		sheet.getRow(154).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(154).createCell(4).setCellValue("Fail");
			sheet.getRow(154).getCell(4).setCellStyle(style);
			
			sheet.getRow(154).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(154).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[5]/div/div/div/label")
	WebElement curriculum_vitaeUPD_Alert;
	@FindBy(xpath = "//div[2]/form/div[2]/div/div[6]/div/div/label")
	WebElement ec_member_invitation_letterUPD_Alert;
	@FindBy(xpath = "//div[2]/form/div[2]/div/div[7]/div/div/label")
	WebElement ec_member_acceptance_letterUPD_Alert;
	@FindBy(xpath = "//div[2]/form/div[2]/div/div[8]/div/div/label")
	WebElement uploadAppointmentUPD_Alert;
	@FindBy(xpath = "//div[2]/form/div[2]/div/div[9]/div/div/label")
	WebElement ec_member_conflict_of_interestUPD_Alert;
	@FindBy(xpath = "//div[2]/form/div[2]/div/div[10]/div/div/label")
	WebElement Confidentiality_agreementUPD_Alert;
	@FindBy(xpath = "//div[2]/form/div[3]/div/div[2]/div/div/div/label")
	WebElement ec_member_upload_document_sopUPD_Alert;
	@FindBy(xpath = "//div[2]/form/div[3]/div/div[4]/div[2]/div/div/div/label")
	WebElement ec_member_upload_document_gcpUPD_Alert;
	@FindBy(xpath = "//div[2]/form/div[3]/div/div[4]/div[3]/div[3]/div/div/div/label")
	WebElement ec_member_upload_document_ethicsUPD_Alert;

	// Check for upload document with maximum size, Invalid formats
	public void CRe4_711_712() throws Exception {
		
		try{

		GlobalMethods.Member1Login();
		WebElement MyAccount = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/a");
		MyAccount.click();
		WebElement MyProfile = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a");
		MyProfile.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");
		String UploadFileTypeAlert_data = r.getCell(6, 194).getContents();

		for (int i = 2; i <= 5; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeInvalid_data = r1.getCell(i, 194).getContents();

			WebElement curriculum_vitaeUPD = GWait.Wait_GetElementById("add_iec_member_curriculum_vitae");
			curriculum_vitaeUPD.sendKeys(UploadFileTypeInvalid_data);

			WebElement ec_member_invitation_letterUPD = GWait.Wait_GetElementById("add_iec_member_invitation_letter");
			ec_member_invitation_letterUPD.sendKeys(UploadFileTypeInvalid_data);

			WebElement ec_member_acceptance_letterUPD = GWait.Wait_GetElementById("add_iec_member_acceptance_letter");
			ec_member_acceptance_letterUPD.sendKeys(UploadFileTypeInvalid_data);

			WebElement uploadAppointmentUPDUPD = GWait.Wait_GetElementById("add_iec_member_appointment_letter");
			uploadAppointmentUPDUPD.sendKeys(UploadFileTypeInvalid_data);

			WebElement ec_member_conflict_of_interestUPD = GWait
					.Wait_GetElementById("add_iec_member_conflict_of_interest");
			ec_member_conflict_of_interestUPD.sendKeys(UploadFileTypeInvalid_data);

			WebElement Confidentiality_agreementUPD = GWait.Wait_GetElementById("add_iec_member_confident");
			Confidentiality_agreementUPD.sendKeys(UploadFileTypeInvalid_data);

			WebElement ec_member_upload_document_sopUPD = GWait
					.Wait_GetElementById("add_iec_member_upload_document_sop");
			ec_member_upload_document_sopUPD.sendKeys(UploadFileTypeInvalid_data);

			WebElement ec_member_upload_document_gcpUPD = GWait
					.Wait_GetElementById("add_iec_member_upload_document_gcp");
			ec_member_upload_document_gcpUPD.sendKeys(UploadFileTypeInvalid_data);

			WebElement ec_member_upload_document_ethicsUPD = GWait
					.Wait_GetElementById("add_iec_member_upload_document_ethics");
			ec_member_upload_document_ethicsUPD.sendKeys(UploadFileTypeInvalid_data);

			WebElement UpdateTXT = GWait.Wait_GetElementById("add_iec_member_details");
			UpdateTXT.click();

			System.out.println(curriculum_vitaeUPD_Alert.getText());
			System.out.println(ec_member_invitation_letterUPD_Alert.getText());
			System.out.println(ec_member_acceptance_letterUPD_Alert.getText());
			System.out.println(uploadAppointmentUPD_Alert.getText());
			System.out.println(ec_member_conflict_of_interestUPD_Alert.getText());
			System.out.println(Confidentiality_agreementUPD_Alert.getText());
			System.out.println(ec_member_upload_document_sopUPD_Alert.getText());
			System.out.println(ec_member_upload_document_gcpUPD_Alert.getText());
			System.out.println(ec_member_upload_document_ethicsUPD_Alert.getText());
			
			Assert.assertEquals(curriculum_vitaeUPD_Alert.getText(), UploadFileTypeAlert_data);
			Assert.assertEquals(ec_member_invitation_letterUPD_Alert.getText(), UploadFileTypeAlert_data);
			Assert.assertEquals(ec_member_acceptance_letterUPD_Alert.getText(), UploadFileTypeAlert_data);
			Assert.assertEquals(uploadAppointmentUPD_Alert.getText(), UploadFileTypeAlert_data);
			Assert.assertEquals(ec_member_conflict_of_interestUPD_Alert.getText(), UploadFileTypeAlert_data);
			Assert.assertEquals(Confidentiality_agreementUPD_Alert.getText(), UploadFileTypeAlert_data);
			Assert.assertEquals(ec_member_upload_document_sopUPD_Alert.getText(), UploadFileTypeAlert_data);
			Assert.assertEquals(ec_member_upload_document_gcpUPD_Alert.getText(), UploadFileTypeAlert_data);
			Assert.assertEquals(ec_member_upload_document_ethicsUPD_Alert.getText(), UploadFileTypeAlert_data);
		}

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(156).createCell(4).setCellValue("Pass");
		sheet.getRow(156).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(156).createCell(4).setCellValue("Fail");
			sheet.getRow(156).getCell(4).setCellStyle(style);
			
			sheet.getRow(156).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(156).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// Check for upload document with valid formats
	public void CRe4_713() throws Exception {
		
		try{

		GlobalMethods.Member1Login();
		WebElement MyAccount = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/a");
		MyAccount.click();
		WebElement MyProfile = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a");
		MyProfile.click();

		for (int i = 2; i <= 6; i++) {

			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r = wb.getSheet("ManageIEC");

			String UploadFileTypeValid_data = r.getCell(i, 196).getContents();

			WebElement curriculum_vitaeUPD = GWait.Wait_GetElementById("add_iec_member_curriculum_vitae");
			curriculum_vitaeUPD.sendKeys(UploadFileTypeValid_data);

			WebElement ec_member_invitation_letterUPD = GWait.Wait_GetElementById("add_iec_member_invitation_letter");
			ec_member_invitation_letterUPD.sendKeys(UploadFileTypeValid_data);

			WebElement ec_member_acceptance_letterUPD = GWait.Wait_GetElementById("add_iec_member_acceptance_letter");
			ec_member_acceptance_letterUPD.sendKeys(UploadFileTypeValid_data);

			WebElement uploadAppointmentUPDUPD = GWait.Wait_GetElementById("add_iec_member_appointment_letter");
			uploadAppointmentUPDUPD.sendKeys(UploadFileTypeValid_data);

			WebElement ec_member_conflict_of_interestUPD = GWait
					.Wait_GetElementById("add_iec_member_conflict_of_interest");
			ec_member_conflict_of_interestUPD.sendKeys(UploadFileTypeValid_data);

			WebElement Confidentiality_agreementUPD = GWait.Wait_GetElementById("add_iec_member_confident");
			Confidentiality_agreementUPD.sendKeys(UploadFileTypeValid_data);

			WebElement ec_member_upload_document_sopUPD = GWait
					.Wait_GetElementById("add_iec_member_upload_document_sop");
			ec_member_upload_document_sopUPD.sendKeys(UploadFileTypeValid_data);

			WebElement ec_member_upload_document_gcpUPD = GWait
					.Wait_GetElementById("add_iec_member_upload_document_gcp");
			ec_member_upload_document_gcpUPD.sendKeys(UploadFileTypeValid_data);

			WebElement ec_member_upload_document_ethicsUPD = GWait
					.Wait_GetElementById("add_iec_member_upload_document_ethics");
			ec_member_upload_document_ethicsUPD.sendKeys(UploadFileTypeValid_data);

			WebElement UpdateTXT = GWait.Wait_GetElementById("add_iec_member_details");
			UpdateTXT.click();

		}

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(157).createCell(4).setCellValue("Pass");
		sheet.getRow(157).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(157).createCell(4).setCellValue("Fail");
			sheet.getRow(157).getCell(4).setCellStyle(style);
			
			sheet.getRow(157).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(157).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[8]/div/div/div/label")
	WebElement PicUPD_Alert;

	// Check for upload Photo with Invalid formats
	public void CRe4_714() throws Exception {
		
		try{

		GlobalMethods.Member1Login();
		WebElement MyAccount = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/a");
		MyAccount.click();
		WebElement MyProfile = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a");
		MyProfile.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");
		String UploadPicTypeAlert_data = r.getCell(6, 198).getContents();

		for (int i = 2; i <= 5; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeInvalid_data = r1.getCell(i, 198).getContents();

			WebElement UploadFileTypeInvalid = GWait.Wait_GetElementById("add_iec_member_photo");
			UploadFileTypeInvalid.sendKeys(UploadFileTypeInvalid_data);
			WebElement UpdateTXT = GWait.Wait_GetElementById("add_iec_member_details");
			UpdateTXT.click();

			System.out.println(PicUPD_Alert.getText());
			Assert.assertEquals(PicUPD_Alert.getText(), UploadPicTypeAlert_data);

		}

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(158).createCell(4).setCellValue("Pass");
		sheet.getRow(158).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(158).createCell(4).setCellValue("Fail");
			sheet.getRow(158).getCell(4).setCellStyle(style);
			
			sheet.getRow(158).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(158).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	// Check for upload Photo with valid formats
	public void CRe4_715() throws Exception {
		
		try{

		GlobalMethods.Member1Login();
		WebElement MyAccount = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/a");
		MyAccount.click();
		WebElement MyProfile = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a");
		MyProfile.click();

		for (int i = 2; i <= 5; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypevalid_data = r1.getCell(i, 200).getContents();

			WebElement UploadFileTypevalid = GWait.Wait_GetElementById("add_iec_member_photo");
			UploadFileTypevalid.sendKeys(UploadFileTypevalid_data);
			WebElement UpdateTXT = GWait.Wait_GetElementById("add_iec_member_details");
			UpdateTXT.click();

		}

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(159).createCell(4).setCellValue("Pass");
		sheet.getRow(159).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(159).createCell(4).setCellValue("Fail");
			sheet.getRow(159).getCell(4).setCellStyle(style);
			
			sheet.getRow(159).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(159).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[8]/div/div/div/label")
	WebElement PicUPDMAX_Alert;

	// Check for upload Photo with Max Size
	public void CRe4_716() throws Exception {
		
		try{

		GlobalMethods.Member1Login();
		WebElement MyAccount = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/a");
		MyAccount.click();
		WebElement MyProfile = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a");
		MyProfile.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");
		String UploadFileTypeMax_data = r1.getCell(2, 202).getContents();
		String UploadPicTypeAlert_data = r1.getCell(3, 202).getContents();

		WebElement UploadFileTypevalid = GWait.Wait_GetElementById("add_iec_member_photo");
		UploadFileTypevalid.sendKeys(UploadFileTypeMax_data);
		WebElement UpdateTXT = GWait.Wait_GetElementById("add_iec_member_details");
		UpdateTXT.click();

//		System.out.println(PicUPDMAX_Alert.getText());
//		Assert.assertEquals(PicUPDMAX_Alert.getText(), UploadPicTypeAlert_data);

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(160).createCell(4).setCellValue("Pass");
		sheet.getRow(160).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(160).createCell(4).setCellValue("Fail");
			sheet.getRow(160).getCell(4).setCellStyle(style);
			
			sheet.getRow(160).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(160).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	@FindBy(id = "iec_member_photo_name")
	WebElement Pic_Download;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[5]/div/div/div/a")
	WebElement UCV_Download;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[6]/div/div/a")
	WebElement EMIL_Download;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[7]/div/div/a")
	WebElement EMAL_Download;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[8]/div/div/div/a")
	WebElement UAL_Download;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[9]/div/div/div/a")
	WebElement CID_Download;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[10]/div/div/a")
	WebElement CA_Download;

	@FindBy(id = "added_iec_member_upload_document_name_sop")
	WebElement SOP_Download;

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[4]/div[2]/div/div/div/div/a")
	WebElement GCP_Download;

	@FindBy(id = "added_iec_member_upload_document_name_ethics")
	WebElement Ethics_Download;

	// Check for file download in update profile form
	public void CRe4_717() throws Exception {
		
		try{

		GlobalMethods.Member1Login();
		WebElement MyAccount = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/a");
		MyAccount.click();
		WebElement MyProfile = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a");
		MyProfile.click();

		try {

			if (Pic_Download.isDisplayed()) {
				WebElement Pic_Download = GWait.Wait_GetElementById("iec_member_photo_name");
				Pic_Download.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (UCV_Download.isDisplayed()) {
				WebElement UCV_Download = GWait.Wait_GetElementByXpath("//div[2]/form/div[2]/div/div[5]/div/div/div/a");
				UCV_Download.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (EMIL_Download.isDisplayed()) {
				WebElement EMIL_Download = GWait.Wait_GetElementByXpath("//div[2]/form/div[2]/div/div[6]/div/div/a");
				EMIL_Download.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (EMAL_Download.isDisplayed()) {
				WebElement EMAL_Download = GWait.Wait_GetElementByXpath("//div[2]/form/div[2]/div/div[7]/div/div/a");
				EMAL_Download.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (UAL_Download.isDisplayed()) {
				WebElement UAL_Download = GWait.Wait_GetElementByXpath("//div[2]/form/div[2]/div/div[8]/div/div/div/a");
				UAL_Download.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (CID_Download.isDisplayed()) {
				WebElement CID_Download = GWait.Wait_GetElementByXpath("//div[2]/form/div[2]/div/div[9]/div/div/div/a");
				CID_Download.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (CA_Download.isDisplayed()) {
				WebElement CA_Download = GWait.Wait_GetElementByXpath("//div[2]/form/div[2]/div/div[10]/div/div/a");
				CA_Download.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (SOP_Download.isDisplayed()) {
				WebElement SOP_Download = GWait.Wait_GetElementById("added_iec_member_upload_document_name_sop");
				SOP_Download.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (GCP_Download.isDisplayed()) {
				WebElement GCP_Download = GWait
						.Wait_GetElementByXpath("//div[2]/form/div[3]/div/div[4]/div[2]/div/div/div/div/a");
				GCP_Download.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (Ethics_Download.isDisplayed()) {
				WebElement Ethics_Download = GWait.Wait_GetElementById("added_iec_member_upload_document_name_ethics");
				Ethics_Download.click();
				GlobalMethods.AcceptDoenloadPopup();
			}

		} catch (Exception e) {
			e.getMessage();
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(161).createCell(4).setCellValue("Pass");
		sheet.getRow(161).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(161).createCell(4).setCellValue("Fail");
			sheet.getRow(161).getCell(4).setCellStyle(style);
			
			sheet.getRow(161).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(161).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	// Check for the file name display at field after upload
	public void CRe4_718() throws Exception {
		
		try{

		GlobalMethods.Member1Login();
		WebElement MyAccount = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/a");
		MyAccount.click();
		WebElement MyProfile = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a");
		MyProfile.click();

		try {

			if (Pic_Download.isDisplayed()) {
				WebElement Pic_Download = GWait.Wait_GetElementById("iec_member_photo_name");
				Pic_Download.getText();
			}
			if (UCV_Download.isDisplayed()) {
				WebElement UCV_Download = GWait.Wait_GetElementByXpath("//div[2]/form/div[2]/div/div[5]/div/div/div/a");
				UCV_Download.getText();
			}
			if (EMIL_Download.isDisplayed()) {
				WebElement EMIL_Download = GWait.Wait_GetElementByXpath("//div[2]/form/div[2]/div/div[6]/div/div/a");
				EMIL_Download.getText();
			}
			if (EMAL_Download.isDisplayed()) {
				WebElement EMAL_Download = GWait.Wait_GetElementByXpath("//div[2]/form/div[2]/div/div[7]/div/div/a");
				EMAL_Download.getText();
			}
			if (UAL_Download.isDisplayed()) {
				WebElement UAL_Download = GWait.Wait_GetElementByXpath("//div[2]/form/div[2]/div/div[8]/div/div/div/a");
				UAL_Download.getText();
			}
			if (CID_Download.isDisplayed()) {
				WebElement CID_Download = GWait.Wait_GetElementByXpath("//div[2]/form/div[2]/div/div[9]/div/div/div/a");
				CID_Download.getText();
			}
			if (CA_Download.isDisplayed()) {
				WebElement CA_Download = GWait.Wait_GetElementByXpath("//div[2]/form/div[2]/div/div[10]/div/div/a");
				CA_Download.getText();
			}
			if (SOP_Download.isDisplayed()) {
				WebElement SOP_Download = GWait.Wait_GetElementById("added_iec_member_upload_document_name_sop");
				SOP_Download.getText();
			}
			if (GCP_Download.isDisplayed()) {
				WebElement GCP_Download = GWait
						.Wait_GetElementByXpath("//div[2]/form/div[3]/div/div[4]/div[2]/div/div/div/div/a");
				GCP_Download.getText();
			}
			if (Ethics_Download.isDisplayed()) {
				WebElement Ethics_Download = GWait.Wait_GetElementById("added_iec_member_upload_document_name_ethics");
				Ethics_Download.getText();
			}

		} catch (Exception e) {
			e.getMessage();
		}
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(162).createCell(4).setCellValue("Pass");
		sheet.getRow(162).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(162).createCell(4).setCellValue("Fail");
			sheet.getRow(162).getCell(4).setCellStyle(style);
			
			sheet.getRow(162).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(162).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}
	
	//Check for basic info form submission with phone field of accepted range
	//Check for basic info form submission with phone field of more than accepted range
	public void CRe4_721_722() throws Exception {
		
		try{
		GlobalMethods.Member1Login();
		WebElement MyAccount = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/a");
		MyAccount.click();
		WebElement MyProfile = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a");
		MyProfile.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String PNumberUPDMAX_data = r.getCell(2, 204).getContents();
		String PNumberUPDMAX_Alert = r.getCell(3, 204).getContents();
		
		String PNumberUPD_data = r.getCell(4, 204).getContents();
		
		PhoneNum.clear();
		PhoneNum.sendKeys(PNumberUPDMAX_data);
		
		WebElement UpdateTXT = GWait.Wait_GetElementById("add_iec_member_details");
		UpdateTXT.click();
		
		WebElement Phone_Alert = GWait.Wait_GetElementByXpath("//div[2]/form/div[1]/div/div[7]/div/div/label");
		System.out.println(Phone_Alert.getText());
		Assert.assertEquals(Phone_Alert.getText(), PNumberUPDMAX_Alert);
		
		PhoneNum.clear();
		PhoneNum.sendKeys(PNumberUPD_data);
		
		WebElement UpdateTXT1 = GWait.Wait_GetElementById("add_iec_member_details");
		UpdateTXT1.click();
		
		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(163).createCell(4).setCellValue("Pass");
		sheet.getRow(163).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(163).createCell(4).setCellValue("Fail");
			sheet.getRow(163).getCell(4).setCellStyle(style);
			
			sheet.getRow(163).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(163).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
		
	}

	// ----Alert message----//
	@FindBy(xpath = "//div[2]/form/div[1]/div/div[1]/div/div/label")
	WebElement FName_Alert;
	@FindBy(xpath = "//div[2]/form/div[1]/div/div[3]/div/div/label")
	WebElement LName_Alert;
	@FindBy(xpath = "//div[2]/form/div[1]/div/div[5]/div/div/div/label")
	WebElement DOB_Alert;
	@FindBy(xpath = "//div[2]/form/div[2]/div/div[4]/div[1]/div/div/label")
	WebElement RegNum_Alert;
	@FindBy(xpath = "//div[2]/form/div[2]/div/div[4]/div[2]/div/div/div/label")
	WebElement ValidTill_Alert;

	@FindBy(css = ".logout")
	WebElement LogOut;

	public void CRe4_724_725_726_727() throws Exception {
		
		try{
		GlobalMethods.Member1Login();
		WebElement MyAccount = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/a");
		MyAccount.click();
		WebElement MyProfile = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[5]/ul/li[1]/a");
		MyProfile.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String FNameUPD_data = r.getCell(2, 206).getContents();
		String MNameUPD_data = r.getCell(3, 206).getContents();
		String LNameUPD_data = r.getCell(4, 206).getContents();
		String EmpIdUPD_data = r.getCell(5, 206).getContents();
		String DOBUPD_data = r.getCell(6, 206).getContents();
		String PNumberUPD_data = r.getCell(7, 206).getContents();
		String PhotoUPD_data = r.getCell(8, 206).getContents();
		String DateOfTrainingSOPUPD_data = r.getCell(9, 206).getContents();
		String IssueDateUPD_data = r.getCell(10, 206).getContents();
		String TitleUPD_data = r.getCell(11, 206).getContents();
		String DateOfTraingEthicsUPD_data = r.getCell(12, 206).getContents();

		FName.clear();
		FName.sendKeys(FNameUPD_data);
		MName.clear();
		MName.sendKeys(MNameUPD_data);
		LName.clear();
		LName.sendKeys(LNameUPD_data);
		EMPID.clear();
		EMPID.sendKeys(EmpIdUPD_data);
		DOB.clear();
		DOB.sendKeys(DOBUPD_data);
		PhoneNum.clear();
		PhoneNum.sendKeys(PNumberUPD_data);
		// JavascriptExecutor executor = (JavascriptExecutor)
		// GlobalMethods.driver;
		// executor.executeScript("window.document.getElementById('email').value
		// = 'qualeetee112+23@gmail.com'");
		IssueDate.clear();
		IssueDate.sendKeys(IssueDateUPD_data);
		DateOftrainingSOP.clear();
		DateOftrainingSOP.sendKeys(DateOfTrainingSOPUPD_data);
		Photo.sendKeys(PhotoUPD_data);
		/*
		 * RegstrationNum.clear(); RegstrationNum.sendKeys(RegNumUPD_data);
		 * ValidTill.clear(); ValidTill.sendKeys(ValidTillUPD_data);
		 */
		IssueDate.clear();
		IssueDate.sendKeys(IssueDateUPD_data);
		title.clear();
		title.sendKeys(TitleUPD_data);
		DateOfTraningEthics.clear();
		DateOfTraningEthics.sendKeys(DateOfTraingEthicsUPD_data);

		WebElement UpdateTXT = GWait.Wait_GetElementById("add_iec_member_details");
		UpdateTXT.click();

		WebElement LogOut = GWait.Wait_GetElementByCSS(".logout");
		LogOut.click();
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb11=new HSSFWorkbook(input);
			
		
		HSSFSheet sheet=wb11.getSheet("Executionfile2");
		HSSFCellStyle style = wb11.createCellStyle();
		HSSFFont font = wb11.createFont();
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor(HSSFColor.GREEN.index);
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		style.setFont(font);
		
		sheet.getRow(164).createCell(4).setCellValue("Pass");
		sheet.getRow(164).getCell(4).setCellStyle(style);
		
		FileOutputStream output = new FileOutputStream(source);
		wb11.write(output);
		wb11.close();
		
	} catch (Throwable e) {
		System.out.println("Report Error: "+ "\n" + e);
		 File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			FileInputStream input = new FileInputStream(source);
			HSSFWorkbook wb11=new HSSFWorkbook(input);
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
			HSSFCellStyle style = wb11.createCellStyle();
			HSSFFont font = wb11.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setColor(HSSFColor.RED.index);
			font.setFontHeightInPoints((short)10);
			font.setBold(true);
			style.setFont(font);
			
			sheet.getRow(164).createCell(4).setCellValue("Fail");
			sheet.getRow(164).getCell(4).setCellStyle(style);
			
			sheet.getRow(164).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(164).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

}
