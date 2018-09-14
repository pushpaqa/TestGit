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

public class TS_19 {
	public TS_19() {
		// this.driver=driver;
		// driver = GlobalMethods.driver;
		PageFactory.initElements(GlobalMethods.driver, this);
	}

	GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	@FindBy(xpath = "//a[contains(text(),'Manage IEC')]")
	WebElement Manage_IEC;

	@FindBy(xpath = "//li[4]/ul/li[7]/a")
	WebElement Manage_IECMembers;

	@FindBy(xpath = "//div[4]/table/thead/tr/th[3]/a/span[2]")
	WebElement TableHeader1;

	@FindBy(xpath = "//div[4]/table/thead/tr/th[4]/a/span[2]")
	WebElement TableHeader2;

	@FindBy(xpath = "//div[4]/table/thead/tr/th[6]/a/span[2]")
	WebElement TableHeader3;

	@FindBy(xpath = "//div[4]/table/thead/tr/th[7]/span")
	WebElement TableHeader4;

	@FindBy(css = ".fa.fa-eye")
	WebElement ViewLink;

	@FindBy(css = ".col-sm-10.col-xs-12.main-right>h3")
	WebElement ViewPage;

	@FindBy(css = ".bgand-border>h3")
	WebElement BasicInfo;

	@FindBy(css = ".col-sm-3.text-right.offset-0.title")
	WebElement BasicName;

	@FindBy(xpath = "//div[2]/div[3]/div[1]/div[2]/div[1]")
	WebElement BasicEmpStuID;

	@FindBy(xpath = "//div[2]/div[3]/div[1]/div[3]/div[1]")
	WebElement BasicDOB;

	@FindBy(xpath = "//div[2]/div[3]/div[1]/div[4]/div[1]")
	WebElement BasicEmail;

	@FindBy(xpath = "//div[2]/div[3]/div[1]/div[5]/div[1]")
	WebElement BasicContactNum;

	@FindBy(xpath = "//div[2]/div[3]/div[1]/div[6]/div[1]")
	WebElement BasicPhoto;

	@FindBy(xpath = "//div[1]/div[1]/div[2]/div[4]/h3")
	WebElement BasicProInfo;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[1]/div[1]")
	WebElement BasicDepart;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[2]/div[1]")
	WebElement BasicDesig;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[3]/div[1]")
	WebElement BasicQualifi;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[4]/div[1]")
	WebElement BasicMCRN;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[5]/div[1]")
	WebElement BasicValidTill;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[6]/div[1]")
	WebElement BasicCurriculumvitae;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[7]/div[1]")
	WebElement BasicInviLetter;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[8]/div[1]")
	WebElement BasicAcceptanceletter;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[9]/div[1]")
	WebElement BasicAppointmentletter;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[10]/div[1]")
	WebElement BasicConfilictIntAgree;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[11]/div[1]")
	WebElement BasicConfidentAgree;

	@FindBy(xpath = "//div[2]/div[4]/div[1]/div[12]/div[1]")
	WebElement BasicStatus;

	@FindBy(xpath = "//div[1]/div[1]/div[2]/div[5]/h3")
	WebElement TrainingSOP;

	@FindBy(xpath = "//div[2]/div[5]/div[2]/div/div[1]")
	WebElement DateOfTraining;

	@FindBy(xpath = "//div[2]/div[5]/div[3]/div/div[1]")
	WebElement AttachmentSOP;

	@FindBy(xpath = "//div[1]/div[1]/div[2]/div[6]/h3")
	WebElement GCPcertifi;

	@FindBy(xpath = "//div[2]/div[6]/div[1]/div/div[1]")
	WebElement IssueDate;

	@FindBy(xpath = "//div[2]/div[6]/div[2]/div/div[1]")
	WebElement AttachmentGCP;

	@FindBy(xpath = "//div[1]/div[1]/div[2]/div[7]/h3")
	WebElement TrainingOnEthic;

	@FindBy(xpath = "//div[2]/div[7]/div[1]/div/div[1]")
	WebElement TitleEthic;

	@FindBy(xpath = "//div[2]/div[7]/div[2]/div/div[1]")
	WebElement DateOfTrainingEthic;

	@FindBy(xpath = "//div[2]/div[7]/div[3]/div/div[1]")
	WebElement AttachmentEthic;

	public void CRe4_979_980_981_982_983_984_985() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r = wb.getSheet("ManageIEC");

		String Header1_data = r.getCell(2, 74).getContents();
		String Header2_data = r.getCell(3, 74).getContents();
		String Header3_data = r.getCell(4, 74).getContents();
		String Header4_data = r.getCell(5, 74).getContents();

		String ViewHeader_data = r.getCell(6, 74).getContents();

		String BasicInfo_data = r.getCell(7, 74).getContents();
		String PersonalInfo_data = r.getCell(8, 74).getContents();
		String SOP_data = r.getCell(9, 74).getContents();
		String GCP_data = r.getCell(10, 74).getContents();
		String Ethic_data = r.getCell(11, 74).getContents();

		String Name_data = r.getCell(12, 74).getContents();
		String Emp_data = r.getCell(13, 74).getContents();
		String DOB_data = r.getCell(14, 74).getContents();
		String Email_data = r.getCell(15, 74).getContents();
		String ContacNum_data = r.getCell(16, 74).getContents();
		String Photo_data = r.getCell(17, 74).getContents();
		String Depart_data = r.getCell(18, 74).getContents();
		String Design_data = r.getCell(19, 74).getContents();
		String Qualifi_data = r.getCell(20, 74).getContents();
		String Medical_data = r.getCell(21, 74).getContents();
		String ValidTill_data = r.getCell(22, 74).getContents();
		String Curriculum_data = r.getCell(23, 74).getContents();
		String Invitaletter_data = r.getCell(24, 74).getContents();
		String Acceptletter_data = r.getCell(25, 74).getContents();
		String AppointLetter_data = r.getCell(26, 74).getContents();
		String Confili_data = r.getCell(27, 74).getContents();
		String Confiden_data = r.getCell(28, 74).getContents();
		String Status_data = r.getCell(29, 74).getContents();
		String DateOfTrainingSOP_data = r.getCell(30, 74).getContents();
		String AttachSOP_data = r.getCell(31, 74).getContents();
		String IssueDate_data = r.getCell(32, 74).getContents();
		String AttachGCP_data = r.getCell(33, 74).getContents();
		String Title_data = r.getCell(34, 74).getContents();
		String DateOfTrainingEthic_data = r.getCell(35, 74).getContents();
		String AttachmentEthic_data = r.getCell(36, 74).getContents();

		// ---System should display fields as Name Email Status Action---//

		// ---Name---//
		Assert.assertEquals(TableHeader1.getText(), Header1_data);

		// ----Email----//
		Assert.assertEquals(TableHeader2.getText(), Header2_data);

		// ----Status----//
		Assert.assertEquals(TableHeader3.getText(), Header3_data);

		// ----Action----//
		Assert.assertEquals(TableHeader4.getText(), Header4_data);

		// ------Check for View link-----Test cases == CRe4_984---//
		System.out.println("Test cases == CRe4_984");
		WebElement ViewLink = GWait.Wait_GetElementByCSS(".fa.fa-eye");
		ViewLink.click();

		System.out.println(ViewPage.getText());
		Assert.assertEquals(ViewPage.getText(), ViewHeader_data);

		// --------Basic Information ------//
		Assert.assertEquals(BasicInfo.getText(), BasicInfo_data);

		// -----Name----//
		Assert.assertEquals(BasicName.getText(), Name_data);

		// -----Employee / Student ID Number----//
		Assert.assertEquals(BasicEmpStuID.getText(), Emp_data);

		// -----Date of birth----//
		Assert.assertEquals(BasicDOB.getText(), DOB_data);

		// -----Email----//
		Assert.assertEquals(BasicEmail.getText(), Email_data);

		// -----Contact Number----//
		Assert.assertEquals(BasicContactNum.getText(), ContacNum_data);

		// -----Photo----//
		Assert.assertEquals(BasicPhoto.getText(), Photo_data);

		// --------Professional Information---------//
		Assert.assertEquals(BasicProInfo.getText(), PersonalInfo_data);

		// -----Department----//
		Assert.assertEquals(BasicDepart.getText(), Depart_data);

		// -----Designation----//
		Assert.assertEquals(BasicDesig.getText(), Design_data);

		// -----Qualifications----//
		Assert.assertEquals(BasicQualifi.getText(), Qualifi_data);

		// -----Medical council registration number----//
		Assert.assertEquals(BasicMCRN.getText(), Medical_data);

		// -----Valid Till----//
		Assert.assertEquals(BasicValidTill.getText(), ValidTill_data);

		// -----Curriculum Vitae----//
		Assert.assertEquals(BasicCurriculumvitae.getText(), Curriculum_data);

		// -----Invitation letter----//
		Assert.assertEquals(BasicInviLetter.getText(), Invitaletter_data);

		// -----Acceptance letter----//
		Assert.assertEquals(BasicAcceptanceletter.getText(), Acceptletter_data);

		// -----Appointment Letter----//
		Assert.assertEquals(BasicAppointmentletter.getText(), AppointLetter_data);

		// -----Conflict of Interest agreement----//
		Assert.assertEquals(BasicConfilictIntAgree.getText(), Confili_data);

		// -----Confidentiality agreement----//
		Assert.assertEquals(BasicConfidentAgree.getText(), Confiden_data);

		// -----Status----//
		Assert.assertEquals(BasicStatus.getText(), Status_data);

		// -----Training On SOP----//
		Assert.assertEquals(TrainingSOP.getText(), SOP_data);

		// -----Date of Training----//
		Assert.assertEquals(DateOfTraining.getText(), DateOfTrainingSOP_data);

		// -----Attachments----//
		Assert.assertEquals(AttachmentSOP.getText(), AttachSOP_data);

		// -----GCP Certification----//
		Assert.assertEquals(GCPcertifi.getText(), GCP_data);

		// -----Issue Date----//
		Assert.assertEquals(IssueDate.getText(), IssueDate_data);

		// -----Attachment----//
		Assert.assertEquals(AttachmentGCP.getText(), AttachGCP_data);

		// -----Training On Ethics In Clinical Research----//
		Assert.assertEquals(TrainingOnEthic.getText(), Ethic_data);

		// -----Title----//
		Assert.assertEquals(TitleEthic.getText(), Title_data);

		// -----Date of Training----//
		Assert.assertEquals(DateOfTrainingEthic.getText(), DateOfTrainingEthic_data);

		// -----Attachment----//
		Assert.assertEquals(AttachmentEthic.getText(), AttachmentEthic_data);

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
		
		sheet.getRow(90).createCell(4).setCellValue("Pass");
		sheet.getRow(90).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(90).createCell(4).setCellValue("Fail");
			sheet.getRow(90).getCell(4).setCellStyle(style);
			
			sheet.getRow(90).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(90).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// ------Download link-----//
	@FindBy(id = "iec_member_photo_name")
	WebElement ViewIEC_ImageLink;

	@FindBy(xpath = "//div[1]/div[2]/div[4]/div[1]/div[6]/div[2]/div/a")
	WebElement ViewIEC_CurriculumVitaeLink;
	@FindBy(xpath = "//div[1]/div[2]/div[4]/div[1]/div[7]/div[2]/div/a")
	WebElement ViewIEC_InvitationletterLink;
	@FindBy(xpath = "//div[1]/div[2]/div[4]/div[1]/div[8]/div[2]/div/a")
	WebElement ViewIEC_AcceptanceletterLink;
	@FindBy(xpath = "//div[1]/div[2]/div[4]/div[1]/div[9]/div[2]/div/a")
	WebElement ViewIEC_AppointmentletterLink;
	@FindBy(xpath = "//div[1]/div[2]/div[4]/div[1]/div[10]/div[2]/div/a")
	WebElement ViewIEC_ConflictofInterestAgreementLink;
	@FindBy(xpath = "//div[1]/div[2]/div[4]/div[1]/div[11]/div[2]/div/a")
	WebElement ViewIEC_ConfidentialityAgreementLink;
	@FindBy(xpath = "//div[1]/div[2]/div[5]/div[3]/div/div[2]/div/a")
	WebElement ViewIEC_SOPAttachmentLink;
	@FindBy(xpath = "//div[1]/div[2]/div[6]/div[2]/div/div[2]/div/a")
	WebElement ViewIEC_GCPAttachmentLink;
	@FindBy(xpath = "//div[1]/div[2]/div[7]/div[3]/div/div[2]/div/a")
	WebElement ViewIEC_EthicsAttachmentLink;

	public void CRe4_986() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();
		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();

		WebElement ViewLink = GWait.Wait_GetElementByCSS(".fa.fa-eye");
		ViewLink.click();

		try {

			if (ViewIEC_ImageLink.isDisplayed()) {
				WebElement ViewIEC_ImageLink = GWait.Wait_GetElementById("iec_member_photo_name");
				ViewIEC_ImageLink.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (ViewIEC_CurriculumVitaeLink.isDisplayed()) {
				WebElement ViewIEC_CurriculumVitaeLink = GWait
						.Wait_GetElementByXpath("//div[1]/div[2]/div[4]/div[1]/div[6]/div[2]/div/a");
				ViewIEC_CurriculumVitaeLink.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (ViewIEC_InvitationletterLink.isDisplayed()) {
				WebElement ViewIEC_InvitationletterLink = GWait
						.Wait_GetElementByXpath("//div[1]/div[2]/div[4]/div[1]/div[7]/div[2]/div/a");
				ViewIEC_InvitationletterLink.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (ViewIEC_AcceptanceletterLink.isDisplayed()) {
				WebElement ViewIEC_AcceptanceletterLink = GWait
						.Wait_GetElementByXpath("//div[1]/div[2]/div[4]/div[1]/div[8]/div[2]/div/a");
				ViewIEC_AcceptanceletterLink.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (ViewIEC_AppointmentletterLink.isDisplayed()) {
				WebElement ViewIEC_AppointmentletterLink = GWait
						.Wait_GetElementByXpath("//div[1]/div[2]/div[4]/div[1]/div[9]/div[2]/div/a");
				ViewIEC_AppointmentletterLink.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (ViewIEC_ConflictofInterestAgreementLink.isDisplayed()) {
				WebElement ViewIEC_ConflictofInterestAgreementLink = GWait
						.Wait_GetElementByXpath("//div[1]/div[2]/div[4]/div[1]/div[10]/div[2]/div/a");
				ViewIEC_ConflictofInterestAgreementLink.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (ViewIEC_ConfidentialityAgreementLink.isDisplayed()) {
				WebElement ViewIEC_ConfidentialityAgreementLink = GWait
						.Wait_GetElementByXpath("//div[1]/div[2]/div[4]/div[1]/div[11]/div[2]/div/a");
				ViewIEC_ConfidentialityAgreementLink.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (ViewIEC_SOPAttachmentLink.isDisplayed()) {
				WebElement ViewIEC_SOPAttachmentLink = GWait
						.Wait_GetElementByXpath("//div[1]/div[2]/div[5]/div[3]/div/div[2]/div/a");
				ViewIEC_SOPAttachmentLink.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (ViewIEC_GCPAttachmentLink.isDisplayed()) {
				WebElement ViewIEC_GCPAttachmentLink = GWait
						.Wait_GetElementByXpath("//div[1]/div[2]/div[6]/div[2]/div/div[2]/div/a");
				ViewIEC_GCPAttachmentLink.click();
				GlobalMethods.AcceptDoenloadPopup();
			}
			if (ViewIEC_EthicsAttachmentLink.isDisplayed()) {
				WebElement ViewIEC_EthicsAttachmentLink = GWait
						.Wait_GetElementByXpath("//div[1]/div[2]/div[7]/div[3]/div/div[2]/div/a");
				ViewIEC_EthicsAttachmentLink.click();
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
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
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

	// ------Add IEC Member link-----//
	@FindBy(xpath = "html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a")
	WebElement AddIECMember_AddIEC;

	// ---Page Header---//
	@FindBy(css = ".col-sm-10.col-xs-12.main-right>h3")
	WebElement AddIECMemPage_AddIEC;

	@FindBy(xpath = "//div[1]/div[2]/form/div[1]/div/h3")
	WebElement BasicInfo_AddIEC;

	@FindBy(css = ".col-sm-3.offset-0.label-text")
	WebElement FirstName_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[2]/div/label")
	WebElement MiddleName_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[3]/div/label")
	WebElement LastName_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[4]/div/label")
	WebElement EmpStdNum_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[5]/div/label")
	WebElement DOB_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[6]/div/label")
	WebElement Email_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[7]/div/label")
	WebElement ContactNum_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[8]/div/div/div/span")
	WebElement UploadPhoto_AddIEC;

	@FindBy(xpath = "//div[1]/div[2]/form/div[2]/div/h3")
	WebElement PersonalInfo_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[1]/div/label")
	WebElement Depart_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[2]/div/label")
	WebElement Design_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[3]/div/label")
	WebElement Qualifi_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[5]/div/div/div/span")
	WebElement Curriculumvitae_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[6]/div/div/span")
	WebElement InviLetter_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[7]/div/div/span")
	WebElement Acceptanceletter_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[8]/div/div/span")
	WebElement Appointmentletter_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[9]/div/div/span")
	WebElement ConfilictIntAgree_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[10]/div/div/span")
	WebElement ConfidentAgree_AddIEC;

	@FindBy(xpath = "//div[1]/div[2]/form/div[3]/div/h3")
	WebElement TrainingSOP_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[1]/div/label")
	WebElement DateOfTraining_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[2]/div/div/div/span[1]")
	WebElement AttachmentSOP_AddIEC;

	@FindBy(xpath = "//div[1]/div[2]/form/div[3]/div/div[4]/h3")
	WebElement GCPCertifi_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[4]/div[1]/div/label")
	WebElement IssueDate_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[4]/div[2]/div/label")
	WebElement DocumentsGCP_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[4]/div[3]/h3")
	WebElement TrainingOnEthic_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[4]/div[3]/div[1]/div/label")
	WebElement TitleEthic_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[4]/div[3]/div[2]/div/label")
	WebElement DateOfTrainingEthic_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[4]/div[3]/div[3]/div/div/div/span[1]")
	WebElement AttachmentEthic_AddIEC;

	@FindBy(id = "add_iec_member_details")
	WebElement Submit_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[1]/div/div/label")
	WebElement AlertPopupFirstName_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[3]/div/div/label")
	WebElement AlertPopupLastName_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[6]/div/div/label")
	WebElement AlertPopupEmail_AddIEC;

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[5]/div/div/div/label")
	WebElement AlertPopupDOB_AddIEC;

	// ----------Setting----------//

	@FindBy(css = ".fa.fa-gear")
	WebElement Setting_AddIEC;

	@FindBy(xpath = "html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a")
	WebElement SettingIECMemConf_AddIEC;

	@FindBy(xpath = "html/body/div[4]/div/div[1]/div[2]/h3")
	WebElement IECMemCofigInHeader_AddIEC;

	@FindBy(xpath = "html/body/div[4]/div/div[1]/div[2]/form/div[1]/div/h3")
	WebElement BasicInfoHeader_AddIEC;

	// ---------Checking mandatory fields-----//
	@FindBy(css = "#add_iec_member_date_of_birth")
	WebElement SelectDOB_AddIEC;

	// ---click Save button-----//
	@FindBy(css = "#iec_add_member_configuration_btn")
	WebElement Save_AddIEC;

	@FindBy(css = ".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a")
	WebElement SettingNavigation_AddIEC;

	// ------Check for Add IEC Member link-----Test cases == CRe4_1022---//
	public void CRe4_1022_1023_1024_1025_1026_1028() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String AddIECMember_data = r1.getCell(2, 76).getContents();

		String BasicInfo_data = r1.getCell(3, 76).getContents();
		String PersonalInfo_data = r1.getCell(4, 76).getContents();
		String SOP_data = r1.getCell(5, 76).getContents();
		String GCP_data = r1.getCell(6, 76).getContents();
		String Ethic_data = r1.getCell(7, 76).getContents();

		String Name_data = r1.getCell(8, 76).getContents();
		String MiddleName_data = r1.getCell(9, 76).getContents();
		String LastName_data = r1.getCell(10, 76).getContents();
		String Emp_data = r1.getCell(11, 76).getContents();
		String DOB_data = r1.getCell(12, 76).getContents();
		String Email_data = r1.getCell(13, 76).getContents();
		String ContactNum_data = r1.getCell(14, 76).getContents();
		String UpPhoto_data = r1.getCell(15, 76).getContents();
		String Depart_data = r1.getCell(16, 76).getContents();
		String Design_data = r1.getCell(17, 76).getContents();
		String Qualifi_data = r1.getCell(18, 76).getContents();
		String UpCurriVite_data = r1.getCell(19, 76).getContents();
		String ECMemberInvLetter_data = r1.getCell(20, 76).getContents();
		String ECMemberAccLetter_data = r1.getCell(21, 76).getContents();
		String UploadAppointLetter_data = r1.getCell(22, 76).getContents();
		String ConfiliIntereDec_data = r1.getCell(23, 76).getContents();
		String ConfidenAggre_data = r1.getCell(24, 76).getContents();
		String DateOfTrainingSOP_data = r1.getCell(25, 76).getContents();
		String AttachSOP_data = r1.getCell(26, 76).getContents();
		String IssueDate_data = r1.getCell(27, 76).getContents();
		String Documents_data = r1.getCell(28, 76).getContents();
		String Title_data = r1.getCell(29, 76).getContents();
		String DateOfTrainingEthic_data = r1.getCell(30, 76).getContents();
		String AttachmentEthic_data = r1.getCell(31, 76).getContents();
		String Submit_data = r1.getCell(32, 76).getContents();

		String Setting_IECMembConfig_data = r1.getCell(33, 76).getContents();
		String Setting_BasicInfo_data = r1.getCell(34, 76).getContents();

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String DOBAlert_data = r1.getCell(38, 76).getContents();

		System.out.println("Test cases == CRe4_1022 & CRe4_1023");
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		// -----Page Header----//
		Assert.assertEquals(AddIECMemPage_AddIEC.getText(), AddIECMember_data);

		// --------Basic Information ------//
		Assert.assertEquals(BasicInfo_AddIEC.getText(), BasicInfo_data);

		// -----First Name----//
		System.out.println(FirstName_AddIEC.getText());
		Assert.assertEquals(FirstName_AddIEC.getText(), Name_data);

		// -----Middle�Name----//
		System.out.println(MiddleName_AddIEC.getText());
		Assert.assertEquals(MiddleName_AddIEC.getText(), MiddleName_data);

		// -----Last�Name�----//
		Assert.assertEquals(LastName_AddIEC.getText(), LastName_data);

		// -----Employee�/�Student�ID�Number----//
		Assert.assertEquals(EmpStdNum_AddIEC.getText(), Emp_data);

		// -----Date�of�birth----//
		System.out.println(DOB_AddIEC.getText());
		System.out.println(Email_AddIEC.getText());
		System.out.println(ContactNum_AddIEC.getText());
		System.out.println(UploadPhoto_AddIEC.getText());
		System.out.println(PersonalInfo_AddIEC.getText());
		System.out.println(Depart_AddIEC.getText());
		System.out.println(Design_AddIEC.getText());
		System.out.println(Qualifi_AddIEC.getText());
		System.out.println(Curriculumvitae_AddIEC.getText());
		System.out.println(InviLetter_AddIEC.getText());
		System.out.println(Acceptanceletter_AddIEC.getText());
		System.out.println(Appointmentletter_AddIEC.getText());
		System.out.println(ConfilictIntAgree_AddIEC.getText());
		System.out.println(ConfidentAgree_AddIEC.getText());
		System.out.println(TrainingSOP_AddIEC.getText());
		System.out.println(DateOfTraining_AddIEC.getText());
		System.out.println(AttachmentSOP_AddIEC.getText());
		System.out.println(GCPCertifi_AddIEC.getText());
		System.out.println(IssueDate_AddIEC.getText());
		System.out.println(DocumentsGCP_AddIEC.getText());
		System.out.println(TrainingOnEthic_AddIEC.getText());
		System.out.println(TitleEthic_AddIEC.getText());
		System.out.println(DateOfTrainingEthic_AddIEC.getText());
		System.out.println(AttachmentEthic_AddIEC.getText());
		System.out.println(Submit_AddIEC.getAttribute("value"));

		Assert.assertEquals(DOB_AddIEC.getText(), DOB_data);

		// -----Email�----//
		Assert.assertEquals(Email_AddIEC.getText(), Email_data);

		// -----Contact�Number----//
		Assert.assertEquals(ContactNum_AddIEC.getText(), ContactNum_data);

		// -----Upload�Photo�----//
		Assert.assertEquals(UploadPhoto_AddIEC.getText(), UpPhoto_data);

		// -----Professional Information----//
		Assert.assertEquals(PersonalInfo_AddIEC.getText(), PersonalInfo_data);

		// -----Department----//
		Assert.assertEquals(Depart_AddIEC.getText(), Depart_data);

		// -----Designation----//
		Assert.assertEquals(Design_AddIEC.getText(), Design_data);

		// -----Qualifications----//
		Assert.assertEquals(Qualifi_AddIEC.getText(), Qualifi_data);

		// -----Upload�Curriculum�Vitaer----//
		Assert.assertEquals(Curriculumvitae_AddIEC.getText(), UpCurriVite_data);

		// -----EC�Membership�Invitation�Letter----//
		Assert.assertEquals(InviLetter_AddIEC.getText(), ECMemberInvLetter_data);

		// -----EC�Membership�Acceptance�letter ----//
		Assert.assertEquals(Acceptanceletter_AddIEC.getText(), ECMemberAccLetter_data);

		// -----Upload�Appointment�Letter----//
		Assert.assertEquals(Appointmentletter_AddIEC.getText(), UploadAppointLetter_data);

		// -----Conflict�of�Interest�declaration----//
		Assert.assertEquals(ConfilictIntAgree_AddIEC.getText(), ConfiliIntereDec_data);

		// -----Confidentiality�agreement----//
		Assert.assertEquals(ConfidentAgree_AddIEC.getText(), ConfidenAggre_data);

		// -----Training On SOP----//
		Assert.assertEquals(TrainingSOP_AddIEC.getText(), SOP_data);

		// -----Date of Training----//
		Assert.assertEquals(DateOfTraining_AddIEC.getText(), DateOfTrainingSOP_data);

		// -----Attach/Upload�Certificate----//
		Assert.assertEquals(AttachmentSOP_AddIEC.getText(), AttachSOP_data);

		// -----GCP Certification----//
		Assert.assertEquals(GCPCertifi_AddIEC.getText(), GCP_data);

		// -----Issue Date----//
		Assert.assertEquals(IssueDate_AddIEC.getText(), IssueDate_data);

		// -----Documents----//
		Assert.assertEquals(DocumentsGCP_AddIEC.getText(), Documents_data);

		// -----Training On Ethics In Clinical Research----//
		Assert.assertEquals(TrainingOnEthic_AddIEC.getText(), Ethic_data);

		// -----Title----//
		Assert.assertEquals(TitleEthic_AddIEC.getText(), Title_data);

		// -----Date of Training----//
		Assert.assertEquals(DateOfTrainingEthic_AddIEC.getText(), DateOfTrainingEthic_data);

		// -----Attachment----//
		Assert.assertEquals(AttachmentEthic_AddIEC.getText(), AttachmentEthic_data);

		// -----Submit----//
		Assert.assertEquals(Submit_AddIEC.getAttribute("value"), Submit_data);

		// -------Check for Add IEC Member form with blank data-------//
		System.out.println("Test cases == CRe4_1024");
		WebElement Submit_AddIEC = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC.click();
		// ----------Check for Mandatory fields--------//
		System.out.println("Check for Add IEC Member form with blank data");
		System.out.println(AlertPopupFirstName_AddIEC.getText());
		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		System.out.println(AlertPopupLastName_AddIEC.getText());
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		System.out.println(AlertPopupEmail_AddIEC.getText());
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);

		// -------Check for admin 'Settings' for add IEC member form-------//
		System.out.println("Test cases == CRe4_1025");
		System.out.println("Check for admin 'Settings' for add IEC member form");
		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// -----IEC Member Configuration Header----//
		Assert.assertEquals(IECMemCofigInHeader_AddIEC.getText(), Setting_IECMembConfig_data);

		// -----Basic Information Header ----//
		Assert.assertEquals(BasicInfoHeader_AddIEC.getText(), Setting_BasicInfo_data);

		// --Select DOB as mandatory field---CRe4_1028-//
		WebElement SelectDOB_AddIEC = GWait.Wait_GetElementByCSS("#add_iec_member_date_of_birth");
		if (SelectDOB_AddIEC.isDisplayed()) {
			if (!SelectDOB_AddIEC.isSelected()) {
				SelectDOB_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertPopupDOB_AddIEC.getText(), DOBAlert_data);

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
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
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

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[4]/div/div/label")
	WebElement AlertPopupEmpId_AddIEC;

	// --Employee/Student ID Number field as mandatory remaining as optional--//
	public void CRe4_1027() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertPopupEmpId_data = r1.getCell(2, 78).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select Employee / Student ID Number as mandatory
		// field----//#add_iec_member_emp_id
		WebElement SelectDOB_AddIEC = GWait.Wait_GetElementByCSS("#add_iec_member_date_of_birth");
		if (SelectDOB_AddIEC.isDisplayed()) {
			if (SelectDOB_AddIEC.isSelected()) {
				SelectDOB_AddIEC.click();
			}
		}
		WebElement SelectEmpId_AddIEC = GWait.Wait_GetElementById("add_iec_member_emp_id");
		if (SelectEmpId_AddIEC.isDisplayed()) {
			if (!SelectEmpId_AddIEC.isSelected()) {
				SelectEmpId_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertPopupEmpId_AddIEC.getText(), AlertPopupEmpId_data);

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
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
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

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[7]/div/div/label")
	WebElement AlertPopupContactNUM_AddIEC;

	// --Contact Number Number field as mandatory remaining as optional--//
	public void CRe4_1029() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertPopupContactNUM_data = r1.getCell(2, 80).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select Contact Number as mandatory field----//
		WebElement SelectEmpId_AddIEC = GWait.Wait_GetElementById("add_iec_member_emp_id");
		if (SelectEmpId_AddIEC.isDisplayed()) {
			if (SelectEmpId_AddIEC.isSelected()) {
				SelectEmpId_AddIEC.click();
			}

		}
		WebElement SelectContactNum_AddIEC = GWait.Wait_GetElementById("add_iec_member_contact_number");
		if (SelectContactNum_AddIEC.isDisplayed()) {
			if (!SelectContactNum_AddIEC.isSelected()) {
				SelectContactNum_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertPopupContactNUM_AddIEC.getText(), AlertPopupContactNUM_data);

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
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
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

	@FindBy(xpath = "//div[2]/form/div[1]/div/div[8]/div/div/div/label")
	WebElement AlertPhoto_AddIEC;

	// --Photo field as mandatory remaining as optional--//
	public void CRe4_1030() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertPhoto_data = r1.getCell(2, 82).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select Photo as mandatory field----//
		WebElement SelectContactNum_AddIEC = GWait.Wait_GetElementById("add_iec_member_contact_number");
		if (SelectContactNum_AddIEC.isDisplayed()) {
			if (SelectContactNum_AddIEC.isSelected()) {
				SelectContactNum_AddIEC.click();
			}

		}
		WebElement SelectPhoto_AddIEC = GWait.Wait_GetElementById("add_iec_member_photo");
		if (SelectPhoto_AddIEC.isDisplayed()) {
			if (!SelectPhoto_AddIEC.isSelected()) {
				SelectPhoto_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertPhoto_AddIEC.getText(), AlertPhoto_data);

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
		
		sheet.getRow(95).createCell(4).setCellValue("Pass");
		sheet.getRow(95).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(95).createCell(4).setCellValue("Fail");
			sheet.getRow(95).getCell(4).setCellStyle(style);
			
			sheet.getRow(95).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(95).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[1]/div/div/label")
	WebElement AlertDepartment_AddIEC;

	// --Department field as mandatory remaining as optional--//
	public void CRe4_1031() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertDepartment_data = r1.getCell(2, 84).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select Department as mandatory field----//
		WebElement SelectPhoto_AddIEC = GWait.Wait_GetElementById("add_iec_member_photo");
		if (SelectPhoto_AddIEC.isDisplayed()) {
			if (SelectPhoto_AddIEC.isSelected()) {
				SelectPhoto_AddIEC.click();
			}

		}
		WebElement SelectDepartment_AddIEC = GWait.Wait_GetElementById("add_iec_member_department");
		if (SelectDepartment_AddIEC.isDisplayed()) {
			if (!SelectDepartment_AddIEC.isSelected()) {
				SelectDepartment_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertDepartment_AddIEC.getText(), AlertDepartment_data);

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
		
		sheet.getRow(96).createCell(4).setCellValue("Pass");
		sheet.getRow(96).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(96).createCell(4).setCellValue("Fail");
			sheet.getRow(96).getCell(4).setCellStyle(style);
			
			sheet.getRow(96).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(96).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[2]/div/div/label")
	WebElement AlertDesignation_AddIEC;

	// --Designation field as mandatory remaining as optional--//
	public void CRe4_1032() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertDesignation_data = r1.getCell(2, 86).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select Designation as mandatory field----//
		WebElement SelectDepartment_AddIEC = GWait.Wait_GetElementById("add_iec_member_department");
		if (SelectDepartment_AddIEC.isDisplayed()) {
			if (SelectDepartment_AddIEC.isSelected()) {
				SelectDepartment_AddIEC.click();
			}

		}
		WebElement SelectDesignation_AddIEC = GWait.Wait_GetElementById("add_iec_member_designation");
		if (SelectDesignation_AddIEC.isDisplayed()) {
			if (!SelectDesignation_AddIEC.isSelected()) {
				SelectDesignation_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertDesignation_AddIEC.getText(), AlertDesignation_data);

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
		
		sheet.getRow(49).createCell(4).setCellValue("Pass");
		sheet.getRow(49).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(49).createCell(4).setCellValue("Fail");
			sheet.getRow(49).getCell(4).setCellStyle(style);
			
			sheet.getRow(49).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(49).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[5]/div/div/div/label")
	WebElement AlertCirriculamVita_AddIEC;

	// --Cirriculam Vitae field as mandatory remaining as optional--//
	public void CRe4_1033() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertCirriculamVita_data = r1.getCell(2, 88).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select Designation as mandatory field----//
		WebElement SelectDesignation_AddIEC = GWait.Wait_GetElementById("add_iec_member_designation");
		if (SelectDesignation_AddIEC.isDisplayed()) {
			if (SelectDesignation_AddIEC.isSelected()) {
				SelectDesignation_AddIEC.click();
			}

		}
		WebElement SelectCirriculamVita_AddIEC = GWait.Wait_GetElementById("add_iec_curriculum_vitae");
		if (SelectCirriculamVita_AddIEC.isDisplayed()) {
			if (!SelectCirriculamVita_AddIEC.isSelected()) {
				SelectCirriculamVita_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertCirriculamVita_AddIEC.getText(), AlertCirriculamVita_data);

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
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
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

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[6]/div/div/label")
	WebElement AlertECMembershipInvitationLetter_AddIEC;

	// --EC Membership Invitation Letter field as mandatory remaining as
	// optional--//
	public void CRe4_1034() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertECMembershipInvitationLetter_data = r1.getCell(2, 90).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select Designation as mandatory field----//
		WebElement SelectCirriculamVita_AddIEC = GWait.Wait_GetElementById("add_iec_curriculum_vitae");
		if (SelectCirriculamVita_AddIEC.isDisplayed()) {
			if (SelectCirriculamVita_AddIEC.isSelected()) {
				SelectCirriculamVita_AddIEC.click();
			}

		}
		WebElement SelectECMembershipInvitationLetter_AddIEC = GWait.Wait_GetElementById("add_iec_invitation_letter");
		if (SelectECMembershipInvitationLetter_AddIEC.isDisplayed()) {
			if (!SelectECMembershipInvitationLetter_AddIEC.isSelected()) {
				SelectECMembershipInvitationLetter_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertECMembershipInvitationLetter_AddIEC.getText(), AlertECMembershipInvitationLetter_data);

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
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
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

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[7]/div/div/label")
	WebElement AlertECMembershipAcceptanceLetter_AddIEC;

	// --EC Membership Invitation Letter field as mandatory remaining as
	// optional--//
	public void CRe4_1035() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertECMembershipAcceptanceLetter_data = r1.getCell(2, 92).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select ECMembershipAcceptanceLetter_data as mandatory field----//
		WebElement SelectECMembershipInvitationLetter_AddIEC = GWait.Wait_GetElementById("add_iec_invitation_letter");
		if (SelectECMembershipInvitationLetter_AddIEC.isDisplayed()) {
			if (SelectECMembershipInvitationLetter_AddIEC.isSelected()) {
				SelectECMembershipInvitationLetter_AddIEC.click();
			}

		}
		WebElement SelectECMembershipAcceptanceLetter_AddIEC = GWait.Wait_GetElementById("add_iec_acceptance_letter");
		if (SelectECMembershipAcceptanceLetter_AddIEC.isDisplayed()) {
			if (!SelectECMembershipAcceptanceLetter_AddIEC.isSelected()) {
				SelectECMembershipAcceptanceLetter_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertECMembershipAcceptanceLetter_AddIEC.getText(), AlertECMembershipAcceptanceLetter_data);

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
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
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

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[8]/div/div/label")
	WebElement AlertAppointmentLetter_AddIEC;

	// --EC Membership Invitation Letter field as mandatory remaining as
	// optional--//
	public void CRe4_1036() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertAppointmentLetter_data = r1.getCell(2, 94).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select AlertAppointmentLetter_AddIEC as mandatory field----//
		WebElement SelectAppointmentLetter_AddIEC = GWait.Wait_GetElementById("add_iec_appointment_letter");
		if (SelectAppointmentLetter_AddIEC.isDisplayed()) {
			if (!SelectAppointmentLetter_AddIEC.isSelected()) {
				SelectAppointmentLetter_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertAppointmentLetter_AddIEC.getText(), AlertAppointmentLetter_data);

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
				
			
			HSSFSheet sheet=wb11.getSheet("Executionfile2");
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

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[9]/div/div/label")
	WebElement AlertConflictOfInterest_AddIEC;

	// --Conflict of Interest Declaration field as mandatory remaining as
	// optional--//
	public void CRe4_1037() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertConflictOfInterest_data = r1.getCell(2, 96).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select AlertConflictOfInterest as mandatory field----//
		WebElement SelectECMembershipAcceptanceLetter_AddIEC = GWait.Wait_GetElementById("add_iec_acceptance_letter");
		if (SelectECMembershipAcceptanceLetter_AddIEC.isDisplayed()) {
			if (SelectECMembershipAcceptanceLetter_AddIEC.isSelected()) {
				SelectECMembershipAcceptanceLetter_AddIEC.click();
			}

		}

		WebElement SelectConflictOfInterest_AddIEC = GWait.Wait_GetElementById("add_iec_conflict_of_interest");
		if (SelectConflictOfInterest_AddIEC.isDisplayed()) {
			if (!SelectConflictOfInterest_AddIEC.isSelected()) {
				SelectConflictOfInterest_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertConflictOfInterest_AddIEC.getText(), AlertConflictOfInterest_data);

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
		
		sheet.getRow(102).createCell(4).setCellValue("Pass");
		sheet.getRow(102).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(102).createCell(4).setCellValue("Fail");
			sheet.getRow(102).getCell(4).setCellStyle(style);
			
			sheet.getRow(102).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(102).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	@FindBy(xpath = "//div[2]/form/div[2]/div/div[10]/div/div/label")
	WebElement AlertConfidentialityagreement_AddIEC;

	// --Confidentiality agreement field as mandatory remaining as optional--//
	public void CRe4_1038() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertConfidentialityagreement_data = r1.getCell(2, 98).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select Confidentiality agreement as mandatory field----//
		WebElement SelectAppointmentLetter_AddIEC = GWait.Wait_GetElementById("add_iec_appointment_letter");
		if (SelectAppointmentLetter_AddIEC.isDisplayed()) {
			if (SelectAppointmentLetter_AddIEC.isSelected()) {
				SelectAppointmentLetter_AddIEC.click();
			}

		}
		WebElement SelectConflictOfInterest_AddIEC = GWait.Wait_GetElementById("add_iec_conflict_of_interest");
		if (SelectConflictOfInterest_AddIEC.isDisplayed()) {
			if (SelectConflictOfInterest_AddIEC.isSelected()) {
				SelectConflictOfInterest_AddIEC.click();
			}

		}
		WebElement SelectConfidentialityagreement_AddIEC = GWait.Wait_GetElementById("add_iec_confident");
		if (SelectConfidentialityagreement_AddIEC.isDisplayed()) {
			if (!SelectConfidentialityagreement_AddIEC.isSelected()) {
				SelectConfidentialityagreement_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertConfidentialityagreement_AddIEC.getText(), AlertConfidentialityagreement_data);

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
		
		sheet.getRow(103).createCell(4).setCellValue("Pass");
		sheet.getRow(103).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(103).createCell(4).setCellValue("Fail");
			sheet.getRow(103).getCell(4).setCellStyle(style);
			
			sheet.getRow(103).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(103).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[1]/div/div/div/label")
	WebElement AlertDateofTraining_AddIEC;

	// --Date of Training field as mandatory remaining as optional--//
	public void CRe4_1039() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertDateofTraining_data = r1.getCell(2, 100).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select DateofTraining as mandatory field----//
		WebElement SelectConfidentialityagreement_AddIEC = GWait.Wait_GetElementById("add_iec_confident");
		if (SelectConfidentialityagreement_AddIEC.isDisplayed()) {
			if (SelectConfidentialityagreement_AddIEC.isSelected()) {
				SelectConfidentialityagreement_AddIEC.click();
			}

		}
		WebElement SelectDateofTraining_AddIEC = GWait
				.Wait_GetElementById("add_iec_member_add_certificate_date_of_training_sop");
		if (SelectDateofTraining_AddIEC.isDisplayed()) {
			if (!SelectDateofTraining_AddIEC.isSelected()) {
				SelectDateofTraining_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertDateofTraining_AddIEC.getText(), AlertDateofTraining_data);

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
		
		sheet.getRow(104).createCell(4).setCellValue("Pass");
		sheet.getRow(104).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(104).createCell(4).setCellValue("Fail");
			sheet.getRow(104).getCell(4).setCellStyle(style);
			
			sheet.getRow(104).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(104).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[2]/div/div/div/label")
	WebElement AlertSOPAttachment_AddIEC;

	// --SOP Attachment field as mandatory remaining as optional--//
	public void CRe4_1040() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertSOPAttachment_data = r1.getCell(2, 102).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select SOP Attachment as mandatory field----//
		WebElement SelectDateofTraining_AddIEC = GWait
				.Wait_GetElementById("add_iec_member_add_certificate_date_of_training_sop");
		if (SelectDateofTraining_AddIEC.isDisplayed()) {
			if (SelectDateofTraining_AddIEC.isSelected()) {
				SelectDateofTraining_AddIEC.click();
			}

		}
		WebElement SelectSOPAttachment_AddIEC = GWait.Wait_GetElementById("add_iec_member_upload_document_sop");
		if (SelectSOPAttachment_AddIEC.isDisplayed()) {
			if (!SelectSOPAttachment_AddIEC.isSelected()) {
				SelectSOPAttachment_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertSOPAttachment_AddIEC.getText(), AlertSOPAttachment_data);

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
		
		sheet.getRow(105).createCell(4).setCellValue("Pass");
		sheet.getRow(105).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(105).createCell(4).setCellValue("Fail");
			sheet.getRow(105).getCell(4).setCellStyle(style);
			
			sheet.getRow(105).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(105).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[4]/div[1]/div/div/div/label")
	WebElement AlertIssueDate_AddIEC;

	// --GCP Issue Date field as mandatory remaining as optional--//
	public void CRe4_1041() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertIssueDate_data = r1.getCell(2, 104).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select IssueDate as mandatory field----//
		WebElement SelectSOPAttachment_AddIEC = GWait.Wait_GetElementById("add_iec_member_upload_document_sop");
		if (SelectSOPAttachment_AddIEC.isDisplayed()) {
			if (SelectSOPAttachment_AddIEC.isSelected()) {
				SelectSOPAttachment_AddIEC.click();
			}

		}
		WebElement SelectIssueDate_AddIEC = GWait.Wait_GetElementById("add_iec_member_add_certificate_date_of_gcp");
		if (SelectIssueDate_AddIEC.isDisplayed()) {
			if (!SelectIssueDate_AddIEC.isSelected()) {
				SelectIssueDate_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertIssueDate_AddIEC.getText(), AlertIssueDate_data);

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
		
		sheet.getRow(106).createCell(4).setCellValue("Pass");
		sheet.getRow(106).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(106).createCell(4).setCellValue("Fail");
			sheet.getRow(106).getCell(4).setCellStyle(style);
			
			sheet.getRow(106).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(106).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[4]/div[2]/div/div/div/label")
	WebElement AlertDocuments_AddIEC;

	// --GCP Documents field as mandatory remaining as optional--//
	public void CRe4_1042() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertDocuments_data = r1.getCell(2, 106).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select Documents as mandatory field----//
		WebElement SelectIssueDate_AddIEC = GWait.Wait_GetElementById("add_iec_member_add_certificate_date_of_gcp");
		if (SelectIssueDate_AddIEC.isDisplayed()) {
			if (SelectIssueDate_AddIEC.isSelected()) {
				SelectIssueDate_AddIEC.click();
			}

		}
		WebElement SelectDocuments_AddIEC = GWait.Wait_GetElementById("add_iec_member_upload_document_gcp");
		if (SelectDocuments_AddIEC.isDisplayed()) {
			if (!SelectDocuments_AddIEC.isSelected()) {
				SelectDocuments_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertDocuments_AddIEC.getText(), AlertDocuments_data);

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
		
		sheet.getRow(107).createCell(4).setCellValue("Pass");
		sheet.getRow(107).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(107).createCell(4).setCellValue("Fail");
			sheet.getRow(107).getCell(4).setCellStyle(style);
			
			sheet.getRow(107).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(107).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[4]/div[3]/div[1]/div/div/label")
	WebElement AlertEthicsTitle_AddIEC;

	// --EthicsTitle field as mandatory remaining as optional--//
	public void CRe4_1043() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertEthicsTitle_data = r1.getCell(2, 108).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select Ethics Title as mandatory field----//
		WebElement SelectDocuments_AddIEC = GWait.Wait_GetElementById("add_iec_member_upload_document_gcp");
		if (SelectDocuments_AddIEC.isDisplayed()) {
			if (SelectDocuments_AddIEC.isSelected()) {
				SelectDocuments_AddIEC.click();
			}

		}
		WebElement SelectEthicsTitle_AddIEC = GWait.Wait_GetElementById("add_iec_member_add_certificate_title_ethic");
		if (SelectEthicsTitle_AddIEC.isDisplayed()) {
			if (!SelectEthicsTitle_AddIEC.isSelected()) {
				SelectEthicsTitle_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertEthicsTitle_AddIEC.getText(), AlertEthicsTitle_data);

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
		
		sheet.getRow(108).createCell(4).setCellValue("Pass");
		sheet.getRow(108).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(108).createCell(4).setCellValue("Fail");
			sheet.getRow(108).getCell(4).setCellStyle(style);
			
			sheet.getRow(108).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(108).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[4]/div[3]/div[2]/div/div/div/label")
	WebElement AlertEthicsDateoftraining_AddIEC;

	// --EthicsDateoftraining field as mandatory remaining as optional--//
	public void CRe4_1044() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertEthicsDateoftraining_data = r1.getCell(2, 110).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select EthicsDateoftraining as mandatory field----//
		WebElement SelectEthicsTitle_AddIEC = GWait.Wait_GetElementById("add_iec_member_add_certificate_title_ethic");
		if (SelectEthicsTitle_AddIEC.isDisplayed()) {
			if (SelectEthicsTitle_AddIEC.isSelected()) {
				SelectEthicsTitle_AddIEC.click();
			}

		}
		WebElement SelectEthicsDateoftraining_AddIEC = GWait
				.Wait_GetElementById("add_iec_member_add_certificate_date_of_training_ethics");
		if (SelectEthicsDateoftraining_AddIEC.isDisplayed()) {
			if (!SelectEthicsDateoftraining_AddIEC.isSelected()) {
				SelectEthicsDateoftraining_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertEthicsDateoftraining_AddIEC.getText(), AlertEthicsDateoftraining_data);

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
		
		sheet.getRow(109).createCell(4).setCellValue("Pass");
		sheet.getRow(109).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(109).createCell(4).setCellValue("Fail");
			sheet.getRow(109).getCell(4).setCellStyle(style);
			
			sheet.getRow(109).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(109).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	@FindBy(xpath = "//div[2]/form/div[3]/div/div[4]/div[3]/div[3]/div/div/div/label")
	WebElement AlertEthicsAttachments_AddIEC;

	// --EthicsAttachments field as mandatory remaining as optional--//
	public void CRe4_1045() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();
		String AlertEthicsAttachments_data = r1.getCell(2, 112).getContents();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select EthicsAttachments as mandatory field----//
		WebElement SelectEthicsDateoftraining_AddIEC = GWait
				.Wait_GetElementById("add_iec_member_add_certificate_date_of_training_ethics");
		if (SelectEthicsDateoftraining_AddIEC.isDisplayed()) {
			if (SelectEthicsDateoftraining_AddIEC.isSelected()) {
				SelectEthicsDateoftraining_AddIEC.click();
			}

		}
		WebElement SelectEthicsAttachments_AddIEC = GWait.Wait_GetElementById("add_iec_member_upload_document_ethics");
		if (SelectEthicsAttachments_AddIEC.isDisplayed()) {
			if (!SelectEthicsAttachments_AddIEC.isSelected()) {
				SelectEthicsAttachments_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();
		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();
		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();

		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		Assert.assertEquals(AlertEthicsAttachments_AddIEC.getText(), AlertEthicsAttachments_data);

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
		
		sheet.getRow(110).createCell(4).setCellValue("Pass");
		sheet.getRow(110).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(110).createCell(4).setCellValue("Fail");
			sheet.getRow(110).getCell(4).setCellStyle(style);
			
			sheet.getRow(110).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(110).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}

	}

	// --------Check by not filling the mandatory fields and clicking submit
	// button----//
	public void CRe4_1047() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		WebElement Setting_AddIEC = GWait.Wait_GetElementByCSS(".fa.fa-gear");
		Setting_AddIEC.click();
		WebElement SettingIECMemConf_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[10]/ul/li[2]/a");
		SettingIECMemConf_AddIEC.click();

		// --Select EthicsAttachments as Unmandatory field----//
		WebElement SelectEthicsAttachments_AddIEC = GWait.Wait_GetElementById("add_iec_member_upload_document_ethics");
		if (SelectEthicsAttachments_AddIEC.isDisplayed()) {
			if (SelectEthicsAttachments_AddIEC.isSelected()) {
				SelectEthicsAttachments_AddIEC.click();
			}

		}

		WebElement Save_AddIEC = GWait.Wait_GetElementByCSS("#iec_add_member_configuration_btn");
		Save_AddIEC.click();
		GlobalMethods.alertaccept();
		WebElement SettingNavigation_AddIEC = GWait
				.Wait_GetElementByCSS(".bread-crumb.col-sm-12.col-xs-12.offset-0>span>a");
		SettingNavigation_AddIEC.click();

		WebElement AddIECMember_AddIEC1 = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC1.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String MiddleNametext_data = r1.getCell(2, 114).getContents();
		String EmpIdtext_data = r1.getCell(3, 114).getContents();
		String DOBtext_data = r1.getCell(4, 114).getContents();
		String ContactNumext_data = r1.getCell(5, 114).getContents();
		String Departmenttext_data = r1.getCell(6, 114).getContents();
		String Designationtext_data = r1.getCell(7, 114).getContents();
		String Qualificationstext_data = r1.getCell(8, 114).getContents();
		String DateofTrainingtext_data = r1.getCell(9, 114).getContents();
		String IssueDatetext_data = r1.getCell(10, 114).getContents();
		String Titletext_data = r1.getCell(11, 114).getContents();
		String EthicsDateofTrainingtxt_data = r1.getCell(12, 114).getContents();

		String FirstNameAlert_data = r1.getCell(35, 76).getContents();
		String LastNameAlert_data = r1.getCell(36, 76).getContents();
		String EmailAlert_data = r1.getCell(37, 76).getContents();

		MiddleName_AddIEC.sendKeys(MiddleNametext_data);
		WebElement EmpIdData_TXTBOX = GWait.Wait_GetElementById("add_iec_member_emp_id");
		EmpIdData_TXTBOX.sendKeys(EmpIdtext_data);
		DOB_TXTBOX.sendKeys(DOBtext_data);
		ContactNum_AddIEC.sendKeys(ContactNumext_data);

		WebElement Depart_AddIEC = GWait.Wait_GetElementById("add_iec_member_department");
		System.out.println(Depart_AddIEC.getText());
		Select RT = new Select(Depart_AddIEC);
		RT.selectByVisibleText(Departmenttext_data);

		WebElement Design_AddIEC = GWait.Wait_GetElementById("add_iec_member_designation");
		System.out.println(Design_AddIEC.getText());
		Select RT1 = new Select(Design_AddIEC);
		RT1.selectByVisibleText(Designationtext_data);

		if (Qualifi_AddIEC.isDisplayed()) {
			WebElement Qualifi_AddIEC = GWait
					.Wait_GetElementByXpath("//div[1]/div[2]/form/div[2]/div/div[3]/div/div/div");
			if (Qualifi_AddIEC.getText().equalsIgnoreCase(Qualificationstext_data)) {
				Qualifi_AddIEC.click();
			}
		}
		WebElement DateOfTrainingSOP = GWait.Wait_GetElementById("add_iec_member_add_certificate_date_of_training_sop");
		DateOfTrainingSOP.sendKeys(DateofTrainingtext_data);
		WebElement IssueDateGCP = GWait.Wait_GetElementById("add_iec_member_add_certificate_date_of_gcp");
		IssueDateGCP.sendKeys(IssueDatetext_data);
		WebElement TitleEthicEthics = GWait.Wait_GetElementById("add_iec_member_add_certificate_title_ethics");
		TitleEthicEthics.sendKeys(Titletext_data);
		WebElement DateOfTrainingEthic = GWait
				.Wait_GetElementById("add_iec_member_add_certificate_date_of_training_ethics");
		DateOfTrainingEthic.sendKeys(EthicsDateofTrainingtxt_data);

		UploadPhoto.sendKeys("C:\\Selenium_Files\\Create Docs\\m1.jpg");

		WebElement Submit_AddIEC = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC.click();

		// --Verify the Mandatory fields
		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);

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
		
		sheet.getRow(111).createCell(4).setCellValue("Pass");
		sheet.getRow(111).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(111).createCell(4).setCellValue("Fail");
			sheet.getRow(111).getCell(4).setCellStyle(style);
			
			sheet.getRow(111).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(111).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	@FindBy(id = "add_iec_member_first_name")
	WebElement FirstName_TXTBOX;

	@FindBy(id = "add_iec_member_last_name")
	WebElement LastName_TXTBOX;

	@FindBy(id = "add_iec_member_date_of_birth")
	WebElement DOB_TXTBOX;

	@FindBy(id = "add_iec_member_email")
	WebElement Email_TXTBOX;

	@FindBy(id = "add_iec_member_photo")
	WebElement UploadPhoto;
	@FindBy(css = ".logout")
	WebElement LogOut;

	// --------Check by not filling the optional fields and clicking submit
	// button----//
	public void CRe4_1048() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();
		WebElement Submit_AddIEC = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNameAlert_data = r1.getCell(2, 116).getContents();
		String LastNameAlert_data = r1.getCell(3, 116).getContents();
		String EmailAlert_data = r1.getCell(4, 116).getContents();

		String FirstNametext_data = r1.getCell(5, 116).getContents();
		String LastNametext_data = r1.getCell(6, 116).getContents();
		String DOBtext_data = r1.getCell(7, 116).getContents();
		String Emailtext_data = r1.getCell(8, 116).getContents();

		System.out.println("Test cases == CRe4_1048");
		Assert.assertEquals(AlertPopupFirstName_AddIEC.getText(), FirstNameAlert_data);
		Assert.assertEquals(AlertPopupLastName_AddIEC.getText(), LastNameAlert_data);
		Assert.assertEquals(AlertPopupEmail_AddIEC.getText(), EmailAlert_data);
		// Assert.assertEquals(AlertPopupDOB_AddIEC.getText(), DOBAlert_data);

		FirstName_TXTBOX.sendKeys(FirstNametext_data);
		LastName_TXTBOX.sendKeys(LastNametext_data);
		DOB_TXTBOX.sendKeys(DOBtext_data);
		Email_TXTBOX.sendKeys(Emailtext_data);
		UploadPhoto.sendKeys("C:\\Selenium_Files\\Create Docs\\m1.jpg");

		WebElement Submit_AddIEC1 = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC1.click();
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
		
		sheet.getRow(112).createCell(4).setCellValue("Pass");
		sheet.getRow(112).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(112).createCell(4).setCellValue("Fail");
			sheet.getRow(112).getCell(4).setCellStyle(style);
			
			sheet.getRow(112).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(112).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	// --Check validation on email fields---//
	public void CRe4_1051() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi1);
		Sheet r1 = wb1.getSheet("ManageIEC");

		String FirstNametext_data = r1.getCell(5, 116).getContents();
		String LastNametext_data = r1.getCell(6, 116).getContents();
		String DOBtext_data = r1.getCell(7, 116).getContents();
		String Emailtext_data = r1.getCell(8, 116).getContents();

		FirstName_TXTBOX.sendKeys(FirstNametext_data);
		LastName_TXTBOX.sendKeys(LastNametext_data);
		DOB_TXTBOX.sendKeys(DOBtext_data);
		Email_TXTBOX.sendKeys(Emailtext_data);
		UploadPhoto.sendKeys("C:\\Selenium_Files\\Create Docs\\17052016.docx");

		WebElement Submit_AddIEC = GWait.Wait_GetElementById("add_iec_member_details");
		Submit_AddIEC.click();
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
		
		sheet.getRow(113).createCell(4).setCellValue("Pass");
		sheet.getRow(113).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(113).createCell(4).setCellValue("Fail");
			sheet.getRow(113).getCell(4).setCellStyle(style);
			
			sheet.getRow(113).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(113).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

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

	@FindBy(id = "add_iec_member_upload_document_sop")
	WebElement UpLAttachSOP_Clear;

	@FindBy(id = "add_iec_member_upload_document_gcp")
	WebElement DocumentGCP_Clear;

	@FindBy(id = "add_iec_member_upload_document_ethics")
	WebElement UpLAttachEthic_Clear;

	// --Check for upload fields formats---//
	public void CRe4_1054() throws Exception {
		
		try{
		// ----------IEC Admin Login------------//
		GlobalMethods.Admin_Login();

		WebElement ManageIECLink = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/a");
		ManageIECLink.click();
		WebElement Manage_IECMembers = GWait.Wait_GetElementByXpath("//li[4]/ul/li[7]/a");
		Manage_IECMembers.click();
		WebElement AddIECMember_AddIEC = GWait
				.Wait_GetElementByXpath("html/body/div[4]/div[1]/div[1]/div[1]/div/li/div/ul/li[2]/div/a");
		AddIECMember_AddIEC.click();

		for (int i = 2; i <= 5; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeInvalid_data = r1.getCell(i, 120).getContents();

			WebElement UploadvalidPhotoType = GWait.Wait_GetElementById("add_iec_member_photo");
			UploadvalidPhotoType.sendKeys(UploadFileTypeInvalid_data);
			WebElement Submit_AddIEC = GWait.Wait_GetElementById("add_iec_member_details");
			Submit_AddIEC.click();

		}

		for (int i = 6; i <= 8; i++) {

			FileInputStream fi1 = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb1 = Workbook.getWorkbook(fi1);
			Sheet r1 = wb1.getSheet("ManageIEC");
			String UploadFileTypeInvalid_data = r1.getCell(i, 144).getContents();

			WebElement UploadFileTypeInvalid = GWait.Wait_GetElementById("add_iec_member_curriculum_vitae");
			UploadFileTypeInvalid.sendKeys(UploadFileTypeInvalid_data);
			WebElement Submit_AddIEC = GWait.Wait_GetElementById("add_iec_member_details");
			Submit_AddIEC.click();

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
		
		sheet.getRow(114).createCell(4).setCellValue("Pass");
		sheet.getRow(114).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(114).createCell(4).setCellValue("Fail");
			sheet.getRow(114).getCell(4).setCellStyle(style);
			
			sheet.getRow(114).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(114).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

	@FindBy(id = "add_iec_member_first_name")
	WebElement add_iec_firstname;

	@FindBy(id = "add_iec_member_last_name")
	WebElement add_iec_lastname;

	@FindBy(id = "add_iec_member_email")
	WebElement add_iec_mail;

	@FindBy(id = "add_iec_member_date_of_birth")
	WebElement add_iec_dob;

	@FindBy(id = "add_iec_member_emp_id")
	WebElement emp_id;

	@FindBy(id = "add_iec_member_contact_number")
	WebElement add_iec_contact_number;

	@FindBy(id = "add_iec_member_details")
	WebElement add_iec_button;

	@FindBy(id = "ethic_committee_title")
	WebElement add_ethic_title;

	@FindBy(id = "ethic_committee_description")
	WebElement add_ethic_desc;

	@FindBy(id = "ethic_committee_type_select")
	WebElement add_ethic_comm;

	@FindBy(id = "ethic_committee_info")
	WebElement add_ethic_info;

	@FindBy(id = "ethic_committee_date")
	WebElement add_ethic_date;

	@FindBy(id = "ethic_committee_chair_person")
	WebElement add_ethic_cp;

	@FindBy(id = "ethic_committee_member_secretary")
	WebElement add_ethic_ms;

	@FindBy(xpath = "//form[@id='ethic_committee_submission']/div/div[8]/div/div[5]/input")
	WebElement add_ethic_button;

	@FindBy(id = "ethic_committee_iec_member_id")
	WebElement add_mem_check;

	@FindBy(xpath = "html/body/div[4]/div[1]/div[1]/div[2]/div[3]/div[1]/form/div[1]/div[8]/div/div")
	List<WebElement> CheckboxCheck;

	public void CRe4_1055() throws Exception {
		
		try{

		GlobalMethods.Admin_Login();

		// ---------Check for creating members------------//
		WebElement Manage_IEC = GWait.Wait_GetElementByXpath("//a[contains(text(),'Manage IEC')]");
		Manage_IEC.click();

		WebElement manage_iec_comm = GWait.Wait_GetElementByXpath("html/body/div[3]/div/div[2]/ul/li[4]/ul/li[7]/a");
		manage_iec_comm.click();

		// creating ten members
		for (int i = 2; i <= 61;) {

			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);

			Sheet r1 = wb.getSheet("ManageIEC");

			String frstname = r1.getCell(i, 122).getContents();
			String lstname = r1.getCell(i + 1, 122).getContents();
			String dob = r1.getCell(i + 2, 122).getContents();
			String email = r1.getCell(i + 3, 122).getContents();
			String emp = r1.getCell(i + 4, 122).getContents();
			String ph = r1.getCell(i + 5, 122).getContents();

			WebElement add_iec_member = GWait.Wait_GetElementByLinkText("Add IEC member");
			add_iec_member.click();

			add_iec_firstname.sendKeys(frstname);
			add_iec_lastname.sendKeys(lstname);
			add_iec_dob.sendKeys(dob);
			add_iec_mail.sendKeys(email);
			emp_id.sendKeys(emp);
			add_iec_contact_number.sendKeys(ph);
			WebElement add_iec_button = GWait.Wait_GetElementById("add_iec_member_details");
			add_iec_button.click();
			i = i + 6;

		}

		// creating ethic committee using above created memebers then mail will
		// be delivered to the users
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("ManageIEC");

		String title = r1.getCell(62, 122).getContents();
		String description = r1.getCell(63, 122).getContents();
		String info = r1.getCell(64, 122).getContents();
		String date = r1.getCell(65, 122).getContents();

		WebElement Manage_IEC1 = GWait.Wait_GetElementByXpath("//a[contains(text(),'Manage IEC')]");
		Manage_IEC1.click();

		WebElement manage_ethic_committee = GWait.Wait_GetElementByLinkText("Manage Ethics Committee");
		manage_ethic_committee.click();

		WebElement ethic_comm_add = GWait.Wait_GetElementByLinkText("Add Ethics Committee");
		ethic_comm_add.click();

		add_ethic_title.sendKeys(title);
		add_ethic_desc.sendKeys(description);

		Select dropdown = new Select(add_ethic_comm);
		dropdown.selectByValue("1");

		add_ethic_info.sendKeys(info);

		add_ethic_date.sendKeys(date);
		// Select dropdown = new Select(add_ethic_info);
		// dropdown.selectByValue("1090");

		// Chairperson
		String frstname = r1.getCell(2, 122).getContents();
		String lstname = r1.getCell(3, 122).getContents();
		String Chairperson = frstname + " " + lstname;
		Select select1 = new Select(add_ethic_cp);
		select1.selectByVisibleText(Chairperson);
		// Member Secretary
		String frstnameMS = r1.getCell(8, 122).getContents();
		String lstnameMS = r1.getCell(9, 122).getContents();
		String MemberSecrtry = frstnameMS + " " + lstnameMS;
		Select select2 = new Select(add_ethic_ms);
		select2.selectByVisibleText(MemberSecrtry);

		for (int j = 14; j <= 57;) {

			String frstname1 = r1.getCell(j, 122).getContents();
			System.out.println(frstname1);
			String lstname1 = r1.getCell(j + 1, 122).getContents();
			System.out.println(lstname1);
			String FullName = frstname1 + " " + lstname1;
			System.out.println("Test Name :" + FullName);
			List<WebElement> elementsList = CheckboxCheck;
			for (WebElement a : elementsList) {
				System.out.println(a.getText());

				if (a.getText().equalsIgnoreCase(FullName)) {
					System.out.println("@#@# " + a.getText().equalsIgnoreCase(FullName));
					WebElement checkBox = a.findElement(By.tagName("input"));
					// WebElement CheckId =
					// a.findElement(By.id("ethic_committee_iec_member_id"));
					checkBox.click();
					break;
				}

			}
			j = j + 6;
		}

		WebElement Submit_Ethi = GWait.Wait_GetElementById("save_ethic_committee_details");
		Submit_Ethi.click();

		WebElement logoutt = GWait.Wait_GetElementByCSS(".logout");
		logoutt.click();

		WebElement logo = GWait.Wait_GetElementByCSS("img");
		logo.click();

		GlobalMethods.MS_MemMail(
				"https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Dwm&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin",
				"qualeetee602@gmail.com", "qa123456");
		
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
		
		sheet.getRow(115).createCell(4).setCellValue("Pass");
		sheet.getRow(115).getCell(4).setCellStyle(style);
		
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
			
			sheet.getRow(115).createCell(4).setCellValue("Fail");
			sheet.getRow(115).getCell(4).setCellStyle(style);
			
			sheet.getRow(115).createCell(5).setCellValue("Report Error: "+ "\n" + e);
			sheet.getRow(115).getCell(5).setCellStyle(style);
			
			FileOutputStream output = new FileOutputStream(source);
			wb11.write(output);
			wb11.close();
			
			throw(e);
	}


	}

}
