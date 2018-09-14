package com.create4.scenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.global.methods.GlobalMethods;
import com.global.methods.GlobalWait;

import jxl.Sheet;
import jxl.Workbook;

public class TS_20 {
	public TS_20() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	// -------Edit Lick-----//

	@FindBy(xpath = "")
	WebElement IECMembers_EditHeader;

	// ------Clear details------//
	@FindBy(id = "add_iec_member_first_name")
	WebElement FirstName_Clear;

	@FindBy(id = "add_iec_member_middle_name")
	WebElement MiddleName_Clear;

	@FindBy(id = "add_iec_member_last_name")
	WebElement LastName_Clear;

	@FindBy(id = "add_iec_member_emp_id")
	WebElement Emp_Clear;

	@FindBy(id = "add_iec_member_date_of_birth")
	WebElement DOB_Clear;

	@FindBy(id = "add_iec_member_email")
	WebElement Email_Clear;

	@FindBy(id = "add_iec_member_contact_number")
	WebElement ConNum_Clear;

	@FindBy(id = "add_iec_member_photo")
	WebElement UpLPhoto_Clear;

	@FindBy(id = "add_iec_member_department")
	WebElement Depart_Clear;

	@FindBy(id = "add_iec_member_designation")
	WebElement Design_Clear;

	@FindBy(className = "qualifyCheckbox")
	WebElement Qualifi_Clear;

	@FindBy(id = "add_iec_member_curriculum_vitae")
	WebElement UpLCurrVit_Clear;

	@FindBy(id = "add_iec_member_invitation_letter")
	WebElement UpLMemInvLetter_Clear;

	@FindBy(id = "add_iec_member_acceptance_letter")
	WebElement UpLMemAccLetter_Clear;

	@FindBy(id = "add_iec_member_appointment_letter")
	WebElement UpLAppoinLetter_Clear;

	@FindBy(id = "add_iec_member_conflict_of_interest")
	WebElement UpLConfilIntDec_Clear;

	@FindBy(id = "add_iec_member_confident")
	WebElement UpLConfidAgree_Clear;

	@FindBy(id = "add_iec_member_add_certificate_date_of_training_sop")
	WebElement DateOfTrainingSOP_Clear;

	@FindBy(id = "add_iec_member_upload_document_sop")
	WebElement UpLAttachSOP_Clear;

	@FindBy(id = "add_iec_member_add_certificate_date_of_gcp")
	WebElement IssueDate_Clear;

	@FindBy(id = "add_iec_member_upload_document_gcp")
	WebElement DocumentGCP_Clear;

	@FindBy(id = "add_iec_member_add_certificate_title_ethics")
	WebElement Title_Clear;

	@FindBy(id = "add_iec_member_add_certificate_date_of_training_ethics")
	WebElement DateOfTraingEthic_Clear;

	@FindBy(id = "add_iec_member_upload_document_ethics")
	WebElement UpLAttachEthic_Clear;

	@FindBy(id = "add_iec_member_details")
	WebElement UpdateBUtton;
	@FindBy(css = ".logout")
	WebElement LogOut;

	// --------Check for Edit link----//
	public void CRe4_987_988() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();
		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");
		String IECMemList_data = r1.getCell(2, 124).getContents();
		String EditIECMemList_data = r1.getCell(3, 124).getContents();
		String AlertFirstName_data = r1.getCell(4, 124).getContents();
		String AlertLastName_data = r1.getCell(5, 124).getContents();

		// ----IEC members List----//
		WebElement IECMembers_Header = GWait.Wait_GetElementByXpath("//div[1]/div/div[2]/div[4]/h3");
		// Assert.assertEquals(IECMembers_Header.getText(), IECMemList_data);
		if (IECMembers_Header.getText().equalsIgnoreCase(IECMemList_data)) {
			System.out.println(IECMembers_Header.getText().equalsIgnoreCase(IECMemList_data));
		} else {
			System.out.println("Test Fail IEC members List");
		}

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		// ----Edit IEC members List----//
		WebElement IECMembers_EditHeader = GWait.Wait_GetElementByXpath("//div[4]/div/div[1]/div[2]/h3");
		Assert.assertEquals(IECMembers_EditHeader.getText().trim(), EditIECMemList_data);

		FirstName_Clear.clear();
		MiddleName_Clear.clear();
		LastName_Clear.clear();
		Emp_Clear.clear();
		DOB_Clear.clear();
		ConNum_Clear.clear();
		Select Rtype = new Select(Depart_Clear);
		Rtype.selectByVisibleText("Select department types");
		Select Rtype1 = new Select(Design_Clear);
		Rtype1.selectByVisibleText("Select designation types");
		DateOfTrainingSOP_Clear.clear();
		IssueDate_Clear.clear();
		DocumentGCP_Clear.clear();
		Title_Clear.clear();
		DateOfTraingEthic_Clear.clear();
		UpdateBUtton.click();

		// ----Check Alert in edit IEC members List----//

		WebElement Alert_FirstName = GWait.Wait_GetElementByXpath("//div[2]/form/div[1]/div/div[1]/div/div/label");
		Assert.assertEquals(Alert_FirstName.getText().trim(), AlertFirstName_data);

		WebElement Alert_LastName = GWait.Wait_GetElementByXpath("//div[2]/form/div[1]/div/div[3]/div/div/label");
		Assert.assertEquals(Alert_LastName.getText().trim(), AlertLastName_data);
		
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
		
		sheet.getRow(118).createCell(4).setCellValue("Pass");
		sheet.getRow(118).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(118).createCell(4).setCellValue("Fail");
			sheet.getRow(118).getCell(4).setCellStyle(style);
			
			sheet.getRow(118).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(118).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// --------Check for cirriculum vitae field with invalid file formats----//
	public void CRe4_989() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 4; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeInvalid_data = r1.getCell(i, 126).getContents();

			WebElement UploadFileTypeInvalid = GWait.Wait_GetElementById("add_iec_member_curriculum_vitae");
			UploadFileTypeInvalid.sendKeys(UploadFileTypeInvalid_data);
			UpdateBUtton.click();

		}
		
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
		
		sheet.getRow(119).createCell(4).setCellValue("Pass");
		sheet.getRow(119).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(119).createCell(4).setCellValue("Fail");
			sheet.getRow(119).getCell(4).setCellStyle(style);
			
			sheet.getRow(119).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(119).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// --------Check for cirriculum vitae field with valid file formats----//
	public void CRe4_990() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 4; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeValid_data = r1.getCell(i, 128).getContents();

			WebElement UploadFileTypeValid = GWait.Wait_GetElementById("add_iec_member_curriculum_vitae");
			UploadFileTypeValid.sendKeys(UploadFileTypeValid_data);
			UpdateBUtton.click();
			WebElement IECMembers_EditLink1 = GWait.Wait_GetElementByCSS(".fa.fa-edit");
			IECMembers_EditLink1.click();

		}
		
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
		
		sheet.getRow(120).createCell(4).setCellValue("Pass");
		sheet.getRow(120).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(120).createCell(4).setCellValue("Fail");
			sheet.getRow(120).getCell(4).setCellStyle(style);
			
			sheet.getRow(120).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(120).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// --------Check for cirriculum vitae field with invalid file formats----//
	public void CRe4_992() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 4; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeInvalid_data = r1.getCell(i, 126).getContents();

			WebElement UploadFileTypeInvalid = GWait.Wait_GetElementById("add_iec_member_invitation_letter");
			UploadFileTypeInvalid.sendKeys(UploadFileTypeInvalid_data);
			UpdateBUtton.click();

		}
		
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
		
		sheet.getRow(121).createCell(4).setCellValue("Pass");
		sheet.getRow(121).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(121).createCell(4).setCellValue("Fail");
			sheet.getRow(121).getCell(4).setCellStyle(style);
			
			sheet.getRow(121).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(121).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// --------Check for cirriculum vitae field with valid file formats----//
	public void CRe4_993() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 4; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeValid_data = r1.getCell(i, 128).getContents();

			WebElement UploadFileTypeValid = GWait.Wait_GetElementById("add_iec_member_invitation_letter");
			UploadFileTypeValid.sendKeys(UploadFileTypeValid_data);
			UpdateBUtton.click();
			WebElement IECMembers_EditLink1 = GWait.Wait_GetElementByCSS(".fa.fa-edit");
			IECMembers_EditLink1.click();

		}
		
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
		
		sheet.getRow(122).createCell(4).setCellValue("Pass");
		sheet.getRow(122).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(122).createCell(4).setCellValue("Fail");
			sheet.getRow(122).getCell(4).setCellStyle(style);
			
			sheet.getRow(122).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(122).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// --------Check for cirriculum vitae field with invalid file formats----//
	public void CRe4_995() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 4; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeInvalid_data = r1.getCell(i, 126).getContents();

			WebElement UploadFileTypeInvalid = GWait.Wait_GetElementById("add_iec_member_acceptance_letter");
			UploadFileTypeInvalid.sendKeys(UploadFileTypeInvalid_data);
			UpdateBUtton.click();

		}
		
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
		
		sheet.getRow(123).createCell(4).setCellValue("Pass");
		sheet.getRow(123).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(123).createCell(4).setCellValue("Fail");
			sheet.getRow(123).getCell(4).setCellStyle(style);
			
			sheet.getRow(123).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(123).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// --------Check for cirriculum vitae field with valid file formats----//
	public void CRe4_996() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 4; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeValid_data = r1.getCell(i, 128).getContents();

			WebElement UploadFileTypeValid = GWait.Wait_GetElementById("add_iec_member_acceptance_letter");
			UploadFileTypeValid.sendKeys(UploadFileTypeValid_data);
			UpdateBUtton.click();
			WebElement IECMembers_EditLink1 = GWait.Wait_GetElementByCSS(".fa.fa-edit");
			IECMembers_EditLink1.click();

		}
		
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
		
		sheet.getRow(124).createCell(4).setCellValue("Pass");
		sheet.getRow(124).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(124).createCell(4).setCellValue("Fail");
			sheet.getRow(124).getCell(4).setCellStyle(style);
			
			sheet.getRow(124).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(124).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// --------Check for cirriculum vitae field with invalid file formats----//
	public void CRe4_998() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 4; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeInvalid_data = r1.getCell(i, 126).getContents();

			WebElement UploadFileTypeInvalid = GWait.Wait_GetElementById("add_iec_member_appointment_letter");
			UploadFileTypeInvalid.sendKeys(UploadFileTypeInvalid_data);
			UpdateBUtton.click();

		}
		
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
		
		sheet.getRow(125).createCell(4).setCellValue("Pass");
		sheet.getRow(125).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(125).createCell(4).setCellValue("Fail");
			sheet.getRow(125).getCell(4).setCellStyle(style);
			
			sheet.getRow(125).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(125).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// --------Check for cirriculum vitae field with valid file formats----//
	public void CRe4_999() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 4; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeValid_data = r1.getCell(i, 128).getContents();

			WebElement UploadFileTypeValid = GWait.Wait_GetElementById("add_iec_member_appointment_letter");
			UploadFileTypeValid.sendKeys(UploadFileTypeValid_data);
			UpdateBUtton.click();
			WebElement IECMembers_EditLink1 = GWait.Wait_GetElementByCSS(".fa.fa-edit");
			IECMembers_EditLink1.click();

		}
		
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
		
		sheet.getRow(126).createCell(4).setCellValue("Pass");
		sheet.getRow(126).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(126).createCell(4).setCellValue("Fail");
			sheet.getRow(126).getCell(4).setCellStyle(style);
			
			sheet.getRow(126).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(126).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// --------Check for cirriculum vitae field with invalid file formats----//
	public void CRe4_1001() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 4; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeInvalid_data = r1.getCell(i, 126).getContents();

			WebElement UploadFileTypeInvalid = GWait.Wait_GetElementById("add_iec_member_conflict_of_interest");
			UploadFileTypeInvalid.sendKeys(UploadFileTypeInvalid_data);
			UpdateBUtton.click();

		}
		
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
		
		sheet.getRow(127).createCell(4).setCellValue("Pass");
		sheet.getRow(127).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(127).createCell(4).setCellValue("Fail");
			sheet.getRow(127).getCell(4).setCellStyle(style);
			
			sheet.getRow(127).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(127).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// --------Check for cirriculum vitae field with valid file formats----//
	public void CRe4_1002() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 4; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeValid_data = r1.getCell(i, 128).getContents();

			WebElement UploadFileTypeValid = GWait.Wait_GetElementById("add_iec_member_conflict_of_interest");
			UploadFileTypeValid.sendKeys(UploadFileTypeValid_data);
			UpdateBUtton.click();
			WebElement IECMembers_EditLink1 = GWait.Wait_GetElementByCSS(".fa.fa-edit");
			IECMembers_EditLink1.click();

		}
		
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
		
		sheet.getRow(128).createCell(4).setCellValue("Pass");
		sheet.getRow(128).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(128).createCell(4).setCellValue("Fail");
			sheet.getRow(128).getCell(4).setCellStyle(style);
			
			sheet.getRow(128).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(128).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// --------Check for cirriculum vitae field with invalid file formats----//
	public void CRe4_1004() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 4; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeInvalid_data = r1.getCell(i, 126).getContents();

			WebElement UploadFileTypeInvalid = GWait.Wait_GetElementById("add_iec_member_confident");
			UploadFileTypeInvalid.sendKeys(UploadFileTypeInvalid_data);
			UpdateBUtton.click();

		}
		
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
		
		sheet.getRow(128).createCell(4).setCellValue("Pass");
		sheet.getRow(128).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(129).createCell(4).setCellValue("Fail");
			sheet.getRow(129).getCell(4).setCellStyle(style);
			
			sheet.getRow(129).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(129).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// --------Check for cirriculum vitae field with valid file formats----//
	public void CRe4_1005() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 4; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeValid_data = r1.getCell(i, 128).getContents();

			WebElement UploadFileTypeValid = GWait.Wait_GetElementById("add_iec_member_confident");
			UploadFileTypeValid.sendKeys(UploadFileTypeValid_data);
			UpdateBUtton.click();
			WebElement IECMembers_EditLink1 = GWait.Wait_GetElementByCSS(".fa.fa-edit");
			IECMembers_EditLink1.click();

		}
		
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
		
		sheet.getRow(130).createCell(4).setCellValue("Pass");
		sheet.getRow(130).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(130).createCell(4).setCellValue("Fail");
			sheet.getRow(130).getCell(4).setCellStyle(style);
			
			sheet.getRow(130).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(130).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// --------Check for cirriculum vitae field with invalid file formats----//
	public void CRe4_1007() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 6; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeInvalid_data = r1.getCell(i, 130).getContents();

			WebElement UploadFileTypeInvalid = GWait.Wait_GetElementById("add_iec_member_photo");
			UploadFileTypeInvalid.sendKeys(UploadFileTypeInvalid_data);
			UpdateBUtton.click();

		}
		
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
		
		sheet.getRow(131).createCell(4).setCellValue("Pass");
		sheet.getRow(131).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(131).createCell(4).setCellValue("Fail");
			sheet.getRow(131).getCell(4).setCellStyle(style);
			
			sheet.getRow(131).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(131).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// --------Check for cirriculum vitae field with valid file formats----//
	public void CRe4_1008() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 5; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeValid_data = r1.getCell(i, 132).getContents();

			WebElement UploadFileTypeValid = GWait.Wait_GetElementById("add_iec_member_photo");
			UploadFileTypeValid.sendKeys(UploadFileTypeValid_data);
			UpdateBUtton.click();
			WebElement IECMembers_EditLink1 = GWait.Wait_GetElementByCSS(".fa.fa-edit");
			IECMembers_EditLink1.click();

		}
		
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
		
		sheet.getRow(132).createCell(4).setCellValue("Pass");
		sheet.getRow(132).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(132).createCell(4).setCellValue("Fail");
			sheet.getRow(132).getCell(4).setCellStyle(style);
			
			sheet.getRow(132).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(132).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// --------Check for cirriculum vitae field with invalid file formats----//
	public void CRe4_1010() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 6; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeInvalid_data = r1.getCell(i, 126).getContents();

			WebElement UploadFileTypeInvalid = GWait.Wait_GetElementById("add_iec_member_upload_document_sop");
			UploadFileTypeInvalid.sendKeys(UploadFileTypeInvalid_data);
			UpdateBUtton.click();

		}
		
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
		
		sheet.getRow(133).createCell(4).setCellValue("Pass");
		sheet.getRow(133).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(133).createCell(4).setCellValue("Fail");
			sheet.getRow(133).getCell(4).setCellStyle(style);
			
			sheet.getRow(133).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(133).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// --------Check for cirriculum vitae field with valid file formats----//
	public void CRe4_1011() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 5; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeValid_data = r1.getCell(i, 128).getContents();

			WebElement UploadFileTypeValid = GWait.Wait_GetElementById("add_iec_member_upload_document_sop");
			UploadFileTypeValid.sendKeys(UploadFileTypeValid_data);
			UpdateBUtton.click();
			WebElement IECMembers_EditLink1 = GWait.Wait_GetElementByCSS(".fa.fa-edit");
			IECMembers_EditLink1.click();

		}
		
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
		
		sheet.getRow(134).createCell(4).setCellValue("Pass");
		sheet.getRow(134).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(134).createCell(4).setCellValue("Fail");
			sheet.getRow(134).getCell(4).setCellStyle(style);
			
			sheet.getRow(134).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(134).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// --------Check for cirriculum vitae field with invalid file formats----//
	public void CRe4_1013() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 6; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeInvalid_data = r1.getCell(i, 126).getContents();

			WebElement UploadFileTypeInvalid = GWait.Wait_GetElementById("add_iec_member_upload_document_gcp");
			UploadFileTypeInvalid.sendKeys(UploadFileTypeInvalid_data);
			UpdateBUtton.click();

		}
		
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
		
		sheet.getRow(135).createCell(4).setCellValue("Pass");
		sheet.getRow(135).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(135).createCell(4).setCellValue("Fail");
			sheet.getRow(135).getCell(4).setCellStyle(style);
			
			sheet.getRow(135).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(135).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// --------Check for cirriculum vitae field with valid file formats----//
	public void CRe4_1014() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 5; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeValid_data = r1.getCell(i, 128).getContents();

			WebElement UploadFileTypeValid = GWait.Wait_GetElementById("add_iec_member_upload_document_gcp");
			UploadFileTypeValid.sendKeys(UploadFileTypeValid_data);
			UpdateBUtton.click();
			WebElement IECMembers_EditLink1 = GWait.Wait_GetElementByCSS(".fa.fa-edit");
			IECMembers_EditLink1.click();

		}
		
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
		
		sheet.getRow(136).createCell(4).setCellValue("Pass");
		sheet.getRow(136).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(136).createCell(4).setCellValue("Fail");
			sheet.getRow(136).getCell(4).setCellStyle(style);
			
			sheet.getRow(136).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(136).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// --------Check for cirriculum vitae field with invalid file formats----//
	public void CRe4_1016() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 6; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeInvalid_data = r1.getCell(i, 126).getContents();

			WebElement UploadFileTypeInvalid = GWait.Wait_GetElementById("add_iec_member_upload_document_ethics");
			UploadFileTypeInvalid.sendKeys(UploadFileTypeInvalid_data);
			UpdateBUtton.click();

		}
		
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
		
		sheet.getRow(137).createCell(4).setCellValue("Pass");
		sheet.getRow(137).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(137).createCell(4).setCellValue("Fail");
			sheet.getRow(137).getCell(4).setCellStyle(style);
			
			sheet.getRow(137).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(137).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// --------Check for cirriculum vitae field with valid file formats----//
	public void CRe4_1017() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		for (int i = 2; i <= 5; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeValid_data = r1.getCell(i, 128).getContents();

			WebElement UploadFileTypeValid = GWait.Wait_GetElementById("add_iec_member_upload_document_ethics");
			UploadFileTypeValid.sendKeys(UploadFileTypeValid_data);
			UpdateBUtton.click();
			WebElement IECMembers_EditLink1 = GWait.Wait_GetElementByCSS(".fa.fa-edit");
			IECMembers_EditLink1.click();

		}
		
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
		
		sheet.getRow(138).createCell(4).setCellValue("Pass");
		sheet.getRow(138).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(138).createCell(4).setCellValue("Fail");
			sheet.getRow(138).getCell(4).setCellStyle(style);
			
			sheet.getRow(138).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(138).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// --------Check for Edit link----//
	public void CRe4_1019() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();
		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");
		String MiddleName_data = r1.getCell(2, 134).getContents();
		String EmpDetails_data = r1.getCell(3, 134).getContents();
		String DOBDetails_data = r1.getCell(4, 134).getContents();
		String ConNum_data = r1.getCell(5, 134).getContents();
		String AlertFirstName_data = r1.getCell(6, 134).getContents();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		FirstName_Clear.clear();
		MiddleName_Clear.clear();
		MiddleName_Clear.sendKeys(MiddleName_data);
		Emp_Clear.clear();
		Emp_Clear.sendKeys(EmpDetails_data);
		DOB_Clear.clear();
		DOB_Clear.sendKeys(DOBDetails_data);
		ConNum_Clear.clear();
		ConNum_Clear.sendKeys(ConNum_data);

		UpdateBUtton.click();

		// ----Check Alert in edit IEC members List----//

		WebElement Alert_FirstName = GWait.Wait_GetElementByXpath("//div[2]/form/div[1]/div/div[1]/div/div/label");
		Assert.assertEquals(Alert_FirstName.getText().trim(), AlertFirstName_data);

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
		
		sheet.getRow(139).createCell(4).setCellValue("Pass");
		sheet.getRow(139).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(139).createCell(4).setCellValue("Fail");
			sheet.getRow(139).getCell(4).setCellStyle(style);
			
			sheet.getRow(139).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(139).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	// --------Check for Edit link----//
	public void CRe4_1020() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();
		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");
		String FirstName_data = r1.getCell(2, 136).getContents();
		String LastName_data = r1.getCell(4, 136).getContents();
		String MiddleName_data = r1.getCell(3, 136).getContents();
		String EmpDetails_data = r1.getCell(3, 136).getContents();
		String DOBDetails_data = r1.getCell(4, 136).getContents();
		String ConNum_data = r1.getCell(5, 136).getContents();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		FirstName_Clear.clear();
		FirstName_Clear.sendKeys(FirstName_data);
		LastName_Clear.clear();
		LastName_Clear.sendKeys(LastName_data);
		WebElement UpdateBUtton = GWait.Wait_GetElementById("add_iec_member_details");
		UpdateBUtton.click();

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
		
		sheet.getRow(140).createCell(4).setCellValue("Pass");
		sheet.getRow(140).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(140).createCell(4).setCellValue("Fail");
			sheet.getRow(140).getCell(4).setCellStyle(style);
			
			sheet.getRow(140).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(140).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

	// --------Check for submit only option fields link----//
	public void CRe4_1021() throws Exception {
		
		try{

		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();
		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		Manage_IEC1.click();

		WebElement Manage_IECMembers1 = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers1.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String MiddleName_data = r1.getCell(3, 138).getContents();
		String EmpDetails_data = r1.getCell(5, 138).getContents();
		String DOBDetails_data = r1.getCell(6, 138).getContents();
		String ConNum_data = r1.getCell(7, 138).getContents();
		
		String AlertFirstName_data = r1.getCell(6, 134).getContents();
		String Alert_LastName_data = r1.getCell(7, 134).getContents();

		WebElement IECMembers_EditLink = GWait.Wait_GetElementByCSS(".fa.fa-edit");
		IECMembers_EditLink.click();

		FirstName_Clear.clear();
		MiddleName_Clear.clear();
		MiddleName_Clear.sendKeys(MiddleName_data);
		LastName_Clear.clear();
		Emp_Clear.clear();
		Emp_Clear.sendKeys(EmpDetails_data);
		DOB_Clear.clear();
		DOB_Clear.sendKeys(DOBDetails_data);
		ConNum_Clear.clear();
		ConNum_Clear.sendKeys(ConNum_data);

		UpdateBUtton.click();
		
		WebElement Alert_FirstName = GWait.Wait_GetElementByXpath("//div[2]/form/div[1]/div/div[1]/div/div/label");
		Assert.assertEquals(Alert_FirstName.getText().trim(), AlertFirstName_data);
		
		WebElement Alert_LastName = GWait.Wait_GetElementByXpath("//div[2]/form/div[1]/div/div[3]/div/div/label");
		Assert.assertEquals(Alert_LastName.getText().trim(), Alert_LastName_data);

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
		
		sheet.getRow(141).createCell(4).setCellValue("Pass");
		sheet.getRow(141).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(141).createCell(4).setCellValue("Fail");
			sheet.getRow(141).getCell(4).setCellStyle(style);
			
			sheet.getRow(141).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(141).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}
	}

}
