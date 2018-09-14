package com.global.methods;

import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;


public class GlobalMethods {
	
    static GlobalWait GWait = new GlobalWait(GlobalMethods.driver);
	Actions action = new Actions(GlobalMethods.driver);

	public static WebDriver driver;

	public GlobalMethods() {

		// this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css=".logo-inner>a>img")
	static WebElement logo;
	
	@FindBy(id = "register_email")
	static

	WebElement email;

	@FindBy(id = "register_password")
	static WebElement pwd;

	@FindBy(id = "register_role")
	static WebElement rol;

	@FindBy(id = "login_institute")
	static WebElement login;

	@FindBy(css = ".logout")
	static WebElement logoutt;

	@FindBy(css = "span.fa.fa-eye")
	static WebElement overview;
	
	@FindBy(css = "label.col-sm-4.control-label")
	static WebElement forgotemailaddressfield;
	
	@FindBy(xpath = "//form[@id='invittee_activation']/div/div[2]/label")
	static WebElement forgotpwdfield;
	
	@FindBy(xpath = "//div/div[3]/div/div/div/div/p")
	static WebElement forgotspwdmsg;
	
	@FindBy(css = "span.fontsize-14.clearfix")
	static WebElement Adminloginname;
	
	
	
	
	

	// ---------- Browser Launching Method --------------//

		public static void LaunchBrowser(String browserName, String Url) {
			if (browserName.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\SOFTWARES\\chromedriver.exe");
			  
				driver = new ChromeDriver();
				
			} else if (browserName.equals("IE")) {
				driver = new InternetExplorerDriver();
			}

			driver.manage().window().maximize();
			driver.get(Url);
		}

	// ------------- Super Admin Login Method-----------//

	// This method is to login as Superadmin
	public static void Super_Login() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Institute_Logins");
		
		//----- Super admin Institute click--------//
		
		String Super_Institute = r1.getCell(0, 1).getContents();
		String Superadminemail = r1.getCell(1, 1).getContents();
		String Super_Password = r1.getCell(2, 1).getContents();
		String Super_Role = r1.getCell(3, 1).getContents();
		System.out.println(Super_Institute);
		WebElement SuperInstitute = GWait.Wait_GetElementByLinkText(Super_Institute);
		SuperInstitute.click();
		WebElement Email = GWait.Wait_GetElementById("register_email");
		Email.sendKeys(Superadminemail);
		driver.findElement(By.id("register_password")).sendKeys(Super_Password);
		Select dropdown = new Select(driver.findElement(By.id("register_role")));
		dropdown.selectByValue("8");
		driver.findElement(By.id("login_institute")).click();

	}

	// ------------- Principal Investigator Login Method-----------//

	public static void PI_Login() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Institute_Logins");
		
		
		String PI_Institute = r1.getCell(0, 2).getContents();
		String PIemail = r1.getCell(1, 2).getContents();
		String PI_Password = r1.getCell(2, 2).getContents();
		String PI_Role = r1.getCell(3, 2).getContents();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		WebElement instituteclick = GWait.Wait_GetElementByLinkText(PI_Institute);
		instituteclick.click();

		WebElement email = GWait.Wait_GetElementById("register_email");
		email.sendKeys(PIemail);

		WebElement pwd = GWait.Wait_GetElementById("register_password");
		pwd.sendKeys(PI_Password);

		WebElement role = GWait.Wait_GetElementById("register_role");
		Select dropdown = new Select(role);
		dropdown.selectByValue("1");

		WebElement login = GWait.Wait_GetElementById("login_institute");
		login.click();


	}
	// ------------- IEC Admin Login Method-----------//

	public static void Admin_Login_1() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Institute_Logins");

		String Admin_Institute = r1.getCell(0, 13).getContents();
		String Adminemail = r1.getCell(1, 13).getContents();
		String Admin_Password = r1.getCell(2, 13).getContents();
		String Admin_Role = r1.getCell(3, 13).getContents();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		
		driver.findElement(By.linkText(Admin_Institute)).click();
		Thread.sleep(4000);
		driver.findElement(By.id("register_email")).sendKeys(Adminemail);
		driver.findElement(By.id("register_password")).sendKeys(Admin_Password);
		Select dropdown = new Select(driver.findElement(By.id("register_role")));
		dropdown.selectByValue("3");
		driver.findElement(By.id("login_institute")).click();

	}
	
	public static void Admin_Login() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi);

		Sheet r1 = wb1.getSheet("Institute_Logins");

		String Inst_tite = r1.getCell(0, 3).getContents();
		String admin_email = r1.getCell(1, 3).getContents();
		String Admin_Password = r1.getCell(2, 3).getContents();
		String Admin_Role = r1.getCell(3, 3).getContents();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		WebElement instituteclick = GWait.Wait_GetElementByLinkText(Inst_tite);
		instituteclick.click();

		WebElement email = GWait.Wait_GetElementById("register_email");
		email.sendKeys(admin_email);

		WebElement pwd = GWait.Wait_GetElementById("register_password");
		pwd.sendKeys(Admin_Password);

		WebElement role = GWait.Wait_GetElementById("register_role");
		Select dropdown = new Select(role);
		dropdown.selectByValue("3");

		WebElement login = GWait.Wait_GetElementById("login_institute");
		login.click();

	}
	
	


	// ------------- Member Secretary Login Method-----------//

	public static void MS_Login() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi);

		Sheet r1 = wb1.getSheet("Institute_Logins");

		String Inst_tite = r1.getCell(0, 4).getContents();
		String MS_email = r1.getCell(1, 4).getContents();
		String MS_Password = r1.getCell(2, 4).getContents();
		String MS_Role = r1.getCell(3, 4).getContents();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		WebElement instituteclick = GWait.Wait_GetElementByLinkText(Inst_tite);
		instituteclick.click();

		WebElement email = GWait.Wait_GetElementById("register_email");
		email.sendKeys(MS_email);

		WebElement pwd = GWait.Wait_GetElementById("register_password");
		pwd.sendKeys(MS_Password);

		WebElement role = GWait.Wait_GetElementById("register_role");
		Select dropdown = new Select(role);
		dropdown.selectByValue("5");

		WebElement login = GWait.Wait_GetElementById("login_institute");

		login.click();

	}
	// ------------- Chairperson Login Method-----------//

	public static void CPLogin() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Institute_Logins");

		String CP_Institute = r1.getCell(0, 5).getContents();
		String CPemail = r1.getCell(1, 5).getContents();
		String CP_Password = r1.getCell(2, 5).getContents();
		String CP_Role = r1.getCell(3, 5).getContents();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		WebElement instituteclick = GWait.Wait_GetElementByLinkText(CP_Institute);
		instituteclick.click();

		WebElement email = GWait.Wait_GetElementById("register_email");
		email.sendKeys(CPemail);

		WebElement pwd = GWait.Wait_GetElementById("register_password");
		pwd.sendKeys(CP_Password);

		WebElement role = GWait.Wait_GetElementById("register_role");
		Select dropdown = new Select(role);
		dropdown.selectByValue("6");

		WebElement login = GWait.Wait_GetElementById("login_institute");
		login.click();

	}

	// ------------- Member Login Method-----------//

	public static void Member1Login() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Institute_Logins");

		String Mem1_Institute = r1.getCell(0, 6).getContents();
		String Mem1email = r1.getCell(1, 6).getContents();
		String Mem1_Password = r1.getCell(2, 6).getContents();
		String Mem1_Role = r1.getCell(3, 6).getContents();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

		//driver.findElement(By.linkText("Research approval institute")).click();
		driver.findElement(By.linkText(Mem1_Institute)).click();
		Thread.sleep(4000);
		driver.findElement(By.id("register_email")).sendKeys(Mem1email);
		driver.findElement(By.id("register_password")).sendKeys(Mem1_Password);
		Select dropdown = new Select(driver.findElement(By.id("register_role")));
		dropdown.selectByValue("7");
		driver.findElement(By.id("login_institute")).click();

	}

	public static void Member3Login() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Institute");

		String Mem3_Institute = r1.getCell(0, 10).getContents();
		String Mem3email = r1.getCell(1, 10).getContents();
		String Mem3_Password = r1.getCell(2, 10).getContents();
		String Mem3_Role = r1.getCell(3, 10).getContents();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

		//driver.findElement(By.linkText("Research approval institute")).click();
		driver.findElement(By.linkText(Mem3_Institute)).click();
		Thread.sleep(2000);
		driver.findElement(By.id("register_email")).sendKeys(Mem3email);
		driver.findElement(By.id("register_password")).sendKeys(Mem3_Password);
		Select dropdown = new Select(driver.findElement(By.id("register_role")));
		dropdown.selectByValue("7");
		driver.findElement(By.id("login_institute")).click();

	}

	public static void Member2Login() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Institute");

		String Mem2_Institute = r1.getCell(0, 9).getContents();
		String Mem2email = r1.getCell(1, 9).getContents();
		String Mem2_Password = r1.getCell(2, 9).getContents();
		String Mem2_Role = r1.getCell(3, 9).getContents();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

		//driver.findElement(By.linkText("Research approval institute")).click();
		driver.findElement(By.linkText(Mem2_Institute)).click();
		Thread.sleep(2000);
		driver.findElement(By.id("register_email")).sendKeys(Mem2email);
		driver.findElement(By.id("register_password")).sendKeys(Mem2_Password);
		Select dropdown = new Select(driver.findElement(By.id("register_role")));
		dropdown.selectByValue("7");
		driver.findElement(By.id("login_institute")).click();

	}

	public static void Member4Login() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Institute");

		String Mem4_Institute = r1.getCell(0, 11).getContents();
		String Mem4email = r1.getCell(1, 11).getContents();
		String Mem4_Password = r1.getCell(2, 11).getContents();
		String Mem4_Role = r1.getCell(3, 11).getContents();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

		//driver.findElement(By.linkText("Research approval institute")).click();
		driver.findElement(By.linkText(Mem4_Institute)).click();
		Thread.sleep(2000);
		driver.findElement(By.id("register_email")).sendKeys(Mem4email);
		driver.findElement(By.id("register_password")).sendKeys(Mem4_Password);
		Select dropdown = new Select(driver.findElement(By.id("register_role")));
		dropdown.selectByValue("7");
		driver.findElement(By.id("login_institute")).click();

	}

	// ------------- Alert Accept Method-----------//
//Get text and compare
	public static void alertaccept() throws Exception {

		Alert al = driver.switchTo().alert();
	    String msgalert = al.getText();
		al.accept();

	}
	// ------------- Alert Accept Method with text comparision-----------//
	public static void alertaccept1(String Msg) throws Exception {

		Alert al = driver.switchTo().alert();
	    String msgalert = al.getText();
		al.accept();

	}

	// ------------- Alert decline Method-----------//

	public static void alertdismiss() throws Exception {

		Alert al = driver.switchTo().alert();
		al.dismiss();

	}

	// ------------- Logout Method-----------//

	public static void Logout() throws Exception {

		Thread.sleep(6000);
		logoutt.click();

	}

	// ------------- Window Handler Method-----------//

	public static void Commentswindhandler() throws Exception {
		
		WebElement wb=GWait.Wait_GetElementById("addPopup");
		wb.click();
	     Thread.sleep(3000);
		//driver.findElement(By.id("addPopup")).click();
		String winHandleBefore = driver.getWindowHandle();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
        
		//driver.findElement(By.className("richText-editor")).clear();

		WebElement comments=GWait.Wait_GetElementByClassName("richText-editor");
		comments.sendKeys("Test Comments");
		WebElement submittoIEC=GWait.Wait_GetElementById("submitforIEC");
		submittoIEC.click();
		alertaccept();
		String winHandleBefore1 = "";
		driver.switchTo().window(winHandleBefore1);
	}

	// ------------- Current Page Get URL Method-----------//

	public static void geturl() throws Exception {

		String url = driver.getCurrentUrl();
		System.out.println(url);
		Thread.sleep(2000);
	}

	// ------------- Institute click on home page Method-----------//

	public static void Inst_click() throws Exception {

		// driver.findElement(By.id(id))
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Institute_Creation");

		String Institute_Title_1 = r1.getCell(0, 1).getContents();

		Thread.sleep(2000);

		WebElement i = driver.findElement(By.linkText(Institute_Title_1));
		if (i.isDisplayed()) {
			overview.click();

		} else {
			System.out.println("Value is inactive");
		}

		/*
		 * WebElement myLink =
		 * driver.findElement(By.linkText(Institute_Title_1)); if
		 * (myLink.Exists) { myLink.click(); }
		 */

	}
	

	// ------------- IEC Admin Login Method-----------//

	public static void Admin_Login_update() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		// Sheet r = wb.getSheet("Institute_Logins");

		Sheet r1 = wb.getSheet("Data_Sheet");

		String Inst_tite = r1.getCell(2, 83).getContents();
		String admin_email = r1.getCell(12, 83).getContents();
		String Admin_Role = r1.getCell(21, 83).getContents();
		String Admin_Password = r1.getCell(22, 83).getContents();

		WebElement instituteclick = GWait.Wait_GetElementByLinkText(Inst_tite);
		instituteclick.click();

		WebElement email = GWait.Wait_GetElementById("register_email");
		email.sendKeys(admin_email);

		WebElement pwd = GWait.Wait_GetElementById("register_password");
		pwd.sendKeys(Admin_Password);

		WebElement role = GWait.Wait_GetElementById("register_role");
		Select dropdown = new Select(role);
		dropdown.selectByValue("3");

		WebElement login = GWait.Wait_GetElementById("login_institute");
		login.click();

	}
	
	//---PI login for change password feature
	
		public static void PILogin4changepwd() throws Exception {

			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Institute_Logins");
			
			
			String PI_Institute = r1.getCell(0, 14).getContents();
			String PIemail = r1.getCell(1, 14).getContents();
			String PI_Password = r1.getCell(2, 14).getContents();
			String PI_Role = r1.getCell(3, 14).getContents();

			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	        Thread.sleep(2000);
			WebElement instituteclick = GWait.Wait_GetElementByLinkText(PI_Institute);
			instituteclick.click();

			WebElement email = GWait.Wait_GetElementById("register_email");
			email.sendKeys(PIemail);

			WebElement pwd = GWait.Wait_GetElementById("register_password");
			pwd.sendKeys(PI_Password);

			WebElement role = GWait.Wait_GetElementById("register_role");
			Select dropdown = new Select(role);
			dropdown.selectByValue("1");

			WebElement login = GWait.Wait_GetElementById("login_institute");
			login.click();


		}
		

	public static void AcceptDoenloadPopup() throws Exception {

		Thread.sleep(2000);
		
		Robot r = new Robot();

		// A short pause, just to be sure that OK is selected
		Thread.sleep(3000);

		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_ALT);

		System.out.println("Select Save As Option");

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("Enter Key is pressed");
	}

	// ------------- Investigator login-----------//

	public static void Investigator_Login() throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet r1 = wb.getSheet("Institute_Logins");

		String invest_Institute = r1.getCell(0, 12).getContents();
		String investemail = r1.getCell(1, 12).getContents();
		String invest_Password = r1.getCell(2, 12).getContents();
		String invest_Role = r1.getCell(3, 12).getContents();
		Thread.sleep(4000);

		WebElement instituteclick = GWait.Wait_GetElementByLinkText(invest_Institute);
		instituteclick.click();

		WebElement email = GWait.Wait_GetElementById("register_email");
		email.sendKeys(investemail);

		WebElement pwd = GWait.Wait_GetElementById("register_password");
		pwd.sendKeys(invest_Password);

		WebElement role = GWait.Wait_GetElementById("register_role");
		Select dropdown = new Select(role);
		dropdown.selectByValue("2");

		WebElement login = GWait.Wait_GetElementById("login_institute");
		login.click();

	}

	public static void mail_Login() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"D:\\eclipseProject\\StackOverFlow\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://accounts.google.com");
		// driver.get("https://accounts.google.com/ServiceLogin?");

		// gmail login
		driver.findElement(By.id("identifierId")).clear();
		driver.findElement(By.id("identifierId")).sendKeys("qualeetee112@gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='password']/div/div/div/input")).clear();
		driver.findElement(By.xpath("//div[@id='password']/div/div/div/input")).sendKeys("qa@123456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='passwordNext']/content/span")).click();
		Thread.sleep(6000);

		driver.get("https://mail.google.com/mail/u/0/#inbox");
		

		// now talking un-read email form inbox into a list
		List<WebElement> unreademeil = driver.findElements(By.xpath("//*[@class='zF']"));

		// Mailer name for which i want to check do i have an email in my inbox
		String MyMailer = "e-EC";

		// real logic starts here
		for (int i = 0; i < unreademeil.size(); i++) {
			if (unreademeil.get(i).isDisplayed() == true) {
				// now verify if you have got mail form a specific mailer (Note
				// Un-read mails)
				// for read mails xpath loactor will change but logic will
				// remain same
				if (unreademeil.get(i).getText().equals(MyMailer)) {
					System.out.println("Yes we have got mail form " + MyMailer);
					// also you can perform more actions here
					// like if you want to open email form the mailer
					break;
				} else {
					System.out.println("No mail form " + MyMailer);
				}
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span.gb_bb.gbii")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("gb_71")).click();
		Thread.sleep(2000);
	}
	
	public static void PIMail(String url, String Email, String Password) throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi);

		// Sheet r = wb1.getSheet("Emails_Data");
		Sheet r1 = wb1.getSheet("Data_Sheet");
		Sheet r2 = wb1.getSheet("Login");
		Sheet r3 = wb1.getSheet("Institute_Logins");

		// String Admin_Role = r3.getCell(3, 1).getContents();

		String URL = r2.getCell(1, 0).getContents();

		String PI_Reg_Institute = r3.getCell(0, 2).getContents();

		String PI_email = r1.getCell(24, 103).getContents();
		String pwd = r1.getCell(33, 103).getContents();

		driver.get(url);

		

		/*WebElement email_field1 = GWait.Wait_GetElementById("identifierId");
		email_field1.sendKeys(Email);

		WebElement nextbutton = GWait.Wait_GetElementByXpath(
				"html/body/div[1]/div[1]/div[2]/div[2]/div/div[2]/div/div/div[1]/div/content/span");
		nextbutton.click();

		WebElement pwd_field = GWait.Wait_GetElementByName("password");
		pwd_field.clear();

		WebElement pwd_field1 = GWait.Wait_GetElementByName("password");
		pwd_field1.sendKeys(Password);

		WebElement nextbutton1 = GWait.Wait_GetElementByXpath(
				"html/body/div[1]/div[1]/div[2]/div[2]/div/div[2]/div/div/div[1]/div/content/span");
		nextbutton1.click();
*/
		
		WebElement email_field1 = GWait.Wait_GetElementById("identifierId");
		email_field1.clear();
		Thread.sleep(5000);
		driver.findElement(By.id("identifierId")).sendKeys(Email);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys(Password);
		
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
		Thread.sleep(30000);
		
		
		WebElement link1 = GWait.Wait_GetElementByCSS(".asf.T-I-J3.J-J5-Ji");
		link1.click();

		WebElement link2 = GWait.Wait_GetElementByCSS(".asf.T-I-J3.J-J5-Ji");
		link2.click();
		Thread.sleep(30000);
		System.out.println("Refresh button Clicked");
		Thread.sleep(30000);

		try {

			List<WebElement> a = driver.findElements(
					By.xpath("//span/b[text()='e-EC - Approved: Request to Register as Principal Investigator']"));
			System.out.println(a.size());
			for (int i = 0; i <= a.size(); i++) {
				System.out.println(a.get(i).getText());
				if (a.get(i).getText().equals("e-EC - Approved: Request to Register as Principal Investigator")) {
					a.get(i).click();
					WebElement link4 = GWait.Wait_GetElementByXpath("//div[starts-with(@class,'a3s aXjCH m1')]/a");
					link4.click();

					Thread.sleep(6000);

					Thread.sleep(2000);

					String winHandleBefore = driver.getWindowHandle();

					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}

					WebElement save1 = GWait.Wait_GetElementById("savedoc");
					save1.click();

					WebElement pwdd = GWait.Wait_GetElementByName("password");
					pwdd.sendKeys(pwd);
				

					WebElement save2 = GWait.Wait_GetElementById("savedoc");
					save2.click();
					Thread.sleep(6000);
					// System.out.println(forgotspwdmsg.getText());
					Thread.sleep(2000);

					String winHandleBefore1 = "";
					driver.switchTo().window(winHandleBefore1);

					File source = new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
					FileInputStream input = new FileInputStream(source);
					HSSFWorkbook wb = new HSSFWorkbook(input);

					HSSFSheet sheet = wb.getSheetAt(0);
					sheet.getRow(2).createCell(0).setCellValue(PI_Reg_Institute);
					sheet.getRow(2).createCell(1).setCellValue(PI_email);
					sheet.getRow(2).createCell(2).setCellValue(pwd);

					FileOutputStream output = new FileOutputStream(source);
					wb.write(output);
					wb.close();

				}break;
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public static void AdminMail(String url, String Email, String Password) throws Exception {

		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi);

		Sheet r1 = wb1.getSheet("Data_Sheet");
		Sheet r2 = wb1.getSheet("Login");
		/* Sheet r3 = wb1.getSheet("Institute_Logins"); */

		String URL = r2.getCell(1, 0).getContents();

		String Admin_Role = r1.getCell(21, 59).getContents();
		String Inst_tite = r1.getCell(2, 59).getContents();
		String admin_email = r1.getCell(12, 59).getContents();
		String password = r1.getCell(22, 59).getContents();

		driver.get(url);

			
		
		Thread.sleep(5000);
		driver.findElement(By.id("identifierId")).sendKeys(Email);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys(Password);
		
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
		Thread.sleep(30000);

		WebElement link1 = GWait.Wait_GetElementByCSS(".asf.T-I-J3.J-J5-Ji");
		link1.click();

		WebElement link2 = GWait.Wait_GetElementByCSS(".asf.T-I-J3.J-J5-Ji");
		link2.click();
		Thread.sleep(30000);
		System.out.println("Refresh button Clicked");
		Thread.sleep(30000);
		System.out.println("Refresh button Clicked");
		Thread.sleep(30000);
		WebElement link3 = GWait.Wait_GetElementByXpath("//span/b[text()='e-EC - You have been Registered as IEC Admin by e-EC']");
		link3.click();

		WebElement link4 = GWait.Wait_GetElementByXpath("//div[starts-with(@class,'a3s aXjCH m1')]/a");
		link4.click();

		Thread.sleep(6000);
		Thread.sleep(2000);

		String winHandleBefore = driver.getWindowHandle();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		WebElement passd = GWait.Wait_GetElementByName("activation_password");
		passd.sendKeys(password);

		String Password1 = passd.getAttribute("Value");

		WebElement updatebutton = GWait.Wait_GetElementById("activation_update_id");
		updatebutton.click();
		Thread.sleep(6000);

		Thread.sleep(2000);

		File source = new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb = new HSSFWorkbook(input);

		HSSFSheet sheet = wb.getSheetAt(0);
		sheet.getRow(13).createCell(0).setCellValue(Inst_tite);
		sheet.getRow(13).createCell(1).setCellValue(admin_email);
		sheet.getRow(13).createCell(2).setCellValue(password);

		FileOutputStream output = new FileOutputStream(source);
		wb.write(output);
		wb.close();
		Thread.sleep(1000);

		String winHandleBefore1 = "";
		driver.switchTo().window(winHandleBefore1);

		// After password set login to application

		driver.get(URL);

		WebElement institutelink = GWait.Wait_GetElementByLinkText(Inst_tite);
		institutelink.click();

		WebElement instituteemail = GWait.Wait_GetElementById(("register_email"));
		instituteemail.sendKeys(admin_email);

		WebElement institutepwd = GWait.Wait_GetElementById(("register_password"));
		institutepwd.sendKeys(password);

		WebElement instituterole = GWait.Wait_GetElementById(("register_role"));
		Select dropdown = new Select(instituterole);
		dropdown.selectByValue("3");
		Thread.sleep(6000);

		((JavascriptExecutor) driver).executeScript("scroll(250,0);");

		WebElement institutelogin = GWait.Wait_GetElementById(("login_institute"));
		institutelogin.click();
		
		
		
		

		WebElement institutelogout = GWait.Wait_GetElementByXpath(("//span/a"));
		institutelogout.click();

	}

	
		
	/*public static void AdminMail_04(String url, String Email, String Password) throws InterruptedException, BiffException, IOException {
		 driver.get(url);
		    driver.findElement(By.id("identifierId")).clear();
		    driver.findElement(By.id("identifierId")).sendKeys(Email);
		    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys(Password);
		    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
		    Thread.sleep(60000);
		    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
		    System.out.println("Refresh button Clicked");
		    Thread.sleep(20000);
		   System.out.println("Refresh button Clicked");
		    Thread.sleep(10000);
		    driver.findElement(By.xpath("//span/b[text()='e-EC - You have been Registered as IEC Admin by e-EC']")).click();
		    Thread.sleep(10000);
		    driver.findElement(By.xpath("//div[starts-with(@class,'a3s aXjCH m1')]/a")).click();  
		    Thread.sleep(6000);
		    Thread.sleep(2000);

		    String winHandleBefore = driver.getWindowHandle();

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}


		
            
			Thread.sleep(2000);
			driver.findElement(By.name("activation_password")).sendKeys("123456admin");
			String Password1=driver.findElement(By.name("activation_password")).getAttribute("Value");
			Thread.sleep(2000);
			driver.findElement(By.id("activation_update_id")).click();
			Thread.sleep(6000);
			//System.out.println(forgotspwdmsg.getText());
			Thread.sleep(2000);

			String winHandleBefore1 = "";
			driver.switchTo().window(winHandleBefore1);
			
			
			FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
			Workbook wb = Workbook.getWorkbook(fi);
			Sheet r1 = wb.getSheet("Institute");

			String Admin_Institute = r1.getCell(0, 3).getContents();
			String Adminemail = r1.getCell(1, 3).getContents();
			String Admin_Password = r1.getCell(2, 3).getContents();
			String Admin_Role = r1.getCell(3, 3).getContents();
			Thread.sleep(4000);

			logo.click();
			
			
			driver.findElement(By.linkText(Admin_Institute)).click();
			driver.findElement(By.id("register_email")).sendKeys(Adminemail);
			driver.findElement(By.id("register_password")).sendKeys("123456admin");
			Select dropdown = new Select(driver.findElement(By.id("register_role")));
			dropdown.selectByValue("3");
			driver.findElement(By.id("login_institute")).click();

			String winHandleBefore1 = "";
			driver.switchTo().window(winHandleBefore1);

			
			
		
	}*/
	
	public static void MS_MemMail(String url, String Email, String Password) throws Exception {
		
		FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		Workbook wb1 = Workbook.getWorkbook(fi);

		Sheet r1 = wb1.getSheet("Emails_Data");
		Sheet r2 = wb1.getSheet("Login");
		Sheet r3 = wb1.getSheet("Institute_Logins");
		
		
		String MS_Role = r3.getCell(3, 2).getContents();
		String URL = r2.getCell(1, 0).getContents();
		String Inst_tite = r1.getCell(0, 2).getContents();
		String MS_email = r1.getCell(3, 4).getContents();
		
		driver.get(url);
	    driver.findElement(By.id("identifierId")).clear();
	    driver.findElement(By.id("identifierId")).sendKeys(Email);
	    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(Password);
	    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
	    Thread.sleep(60000);
	    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
	    System.out.println("Refresh button Clicked");
	    Thread.sleep(20000);
	    driver.findElement(By.xpath("//span/b[text()='e-EC - You have been Registered as IEC Member by IEC Admin']")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//div[starts-with(@class,'a3s aXjCH m1')]/a")).click();  
		Thread.sleep(6000);
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Thread.sleep(4000);
		driver.findElement(By.name("activation_password")).sendKeys("123456admin");
		String Password1=driver.findElement(By.name("activation_password")).getAttribute("Value");
		Thread.sleep(2000);
		driver.findElement(By.id("activation_update_id")).click();
		Thread.sleep(6000);
		//System.out.println(forgotspwdmsg.getText());
		Thread.sleep(2000);
		
		/*driver.findElement(By.xpath("//form[@id='activation_user_form']/div/div[2]/div/input")).sendKeys("123456admin");
		String Password1=driver.findElement(By.xpath("//div[starts-with(@class,'a3s aXjCH m15f')]/a")).getAttribute("Value");
		Thread.sleep(2000);
		driver.findElement(By.id("savedoc")).click();*/
		String winHandleBefore1 = "";
		driver.switchTo().window(winHandleBefore1);
		
		File source= new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
		FileInputStream input = new FileInputStream(source);
		HSSFWorkbook wb=new HSSFWorkbook(input);
		
		HSSFSheet sheet=wb.getSheetAt(0);
		sheet.getRow(2).createCell(0).setCellValue(Inst_tite);
		sheet.getRow(2).createCell(1).setCellValue(MS_email);
		sheet.getRow(2).createCell(2).setCellValue("123456admin");
		
		FileOutputStream output = new FileOutputStream(source);
		wb.write(output);
		wb.close();
		Thread.sleep(1000);
		driver.get(URL);
		
		Thread.sleep(1000);
	    MS_Login();
	    Assert.assertEquals(Adminloginname.getText().trim(), MS_Role);
	    Thread.sleep(4000);
	    logoutt.click();
		
		
	}
	

private static void assertEquals(String text, String string) {
	// TODO Auto-generated method stub
	
}

public static void InvestigatorMail(String url, String Email, String Password)
		throws InterruptedException, BiffException, IOException {

	FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
	Workbook wb1 = Workbook.getWorkbook(fi);

	Sheet r1 = wb1.getSheet("Data_Sheet");
	Sheet r2 = wb1.getSheet("Login");
	Sheet r3 = wb1.getSheet("Institute_Logins");

	String URL = r2.getCell(1, 0).getContents();
	String PI_Institute = r3.getCell(0, 2).getContents();
	String studyteammem_email = r1.getCell(3, 119).getContents();
	String studyteammem_pwd = r1.getCell(5, 119).getContents();

	driver.get(url);

	Thread.sleep(5000);
	driver.findElement(By.id("identifierId")).sendKeys(Email);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("password")).sendKeys(Password);
	
	Thread.sleep(10000);
	driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
	Thread.sleep(30000);
	
	WebElement link1 = GWait.Wait_GetElementByCSS(".asf.T-I-J3.J-J5-Ji");
	link1.click();

	WebElement link2 = GWait.Wait_GetElementByCSS(".asf.T-I-J3.J-J5-Ji");
	link2.click();
	Thread.sleep(35000);
	System.out.println("Refresh button Clicked");
	Thread.sleep(35000);
	/*
	 * WebElement link3 = GWait.
	 * Wait_GetElementByXpath1("//span/b[text()='You have been invited for the project']"
	 * ); link3.click();
	 */

	
		List<WebElement> a = driver
				.findElements(By.xpath("//span/b[text()='You have been invited for the project']"));
		System.out.println(a.size());
		for (int i = 0; i <= a.size(); i++) {
			System.out.println(a.get(i).getText());
			if (a.get(i).getText().equals("You have been invited for the project")) {
				a.get(i).click();
				WebElement link4 = GWait.Wait_GetElementByXpath("//div[starts-with(@class,'a3s aXjCH m1')]/a");
				link4.click();

				Thread.sleep(6000);

				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}

				WebElement passd = GWait.Wait_GetElementByName("password");
				passd.sendKeys(studyteammem_pwd);

				String Password1 = passd.getAttribute("Value");

				WebElement updatebutton = GWait.Wait_GetElementById("savedoc");
				updatebutton.click();
				Thread.sleep(6000);

				Thread.sleep(2000);

				/*String winHandleBefore1 = "";
				driver.switchTo().window(winHandleBefore1);*/

				File source = new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				FileInputStream input = new FileInputStream(source);
				HSSFWorkbook wb = new HSSFWorkbook(input);

				HSSFSheet sheet = wb.getSheetAt(0);
				sheet.getRow(12).createCell(0).setCellValue(PI_Institute);
				sheet.getRow(12).createCell(1).setCellValue(studyteammem_email);
				sheet.getRow(12).createCell(2).setCellValue(studyteammem_pwd);

				FileOutputStream output = new FileOutputStream(source);
				wb.write(output);
				wb.close();

			}break;
		}
	

}	
	


public static void meetingMail(String url, String Email, String Password) throws InterruptedException {
	
	driver.get(url);
    driver.findElement(By.id("identifierId")).clear();
    driver.findElement(By.id("identifierId")).sendKeys(Email);
    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
    Thread.sleep(2000);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(Password);
    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
    Thread.sleep(60000);
    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
    Thread.sleep(3000);
    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
    System.out.println("Refresh button Clicked");
    Thread.sleep(20000);
    driver.findElement(By.xpath("//span/b[text()='e-EC - Invitation for Upcoming IEC Meeting']")).click();
    Thread.sleep(6000);
    Thread.sleep(2000);
   /*	driver.findElement(By.cssSelector("span.gb_bb.gbii")).click();
   	Thread.sleep(2000);
   	driver.findElement(By.id("gb_71")).click();
   	Thread.sleep(2000);*/
   
	
	
	
}

public static void remeetingMail(String url, String Email, String Password) throws InterruptedException {
	
	driver.get(url);
    driver.findElement(By.id("identifierId")).clear();
    driver.findElement(By.id("identifierId")).sendKeys(Email);
    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
    Thread.sleep(2000);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(Password);
    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
    Thread.sleep(60000);
    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
    Thread.sleep(3000);
    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
    System.out.println("Refresh button Clicked");
    Thread.sleep(20000);
    driver.findElement(By.xpath("//span/b[text()='e-EC - Update in Invitation for the Upcoming IEC Meeting']")).click();
    Thread.sleep(6000);
    Thread.sleep(2000);
   	/*driver.findElement(By.cssSelector("span.gb_bb.gbii")).click();
   	Thread.sleep(2000);
   	driver.findElement(By.id("gb_71")).click();
   	Thread.sleep(2000);
   
   	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
	}

	
	String winHandleBefore1 = "";
	driver.switchTo().window(winHandleBefore1);*/
	
	
}

public static void msassignreviewerMail(String url, String Email, String Password) throws InterruptedException {
	
	driver.get(url);
    driver.findElement(By.id("identifierId")).clear();
    driver.findElement(By.id("identifierId")).sendKeys(Email);
    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
    Thread.sleep(2000);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(Password);
    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
    Thread.sleep(60000);
    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
    Thread.sleep(3000);
    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
    System.out.println("Refresh button Clicked");
    Thread.sleep(20000);
    driver.findElement(By.xpath("//span/b[text()='e-EC - Project for Review']")).click();
    Thread.sleep(6000);
    Thread.sleep(2000);
	/*driver.findElement(By.cssSelector("span.gb_bb.gbii")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("gb_71")).click();
	Thread.sleep(2000);*/
   
	
	
	
}

public static void msreassignreviewerMail(String url, String Email, String Password) throws InterruptedException {
	
	driver.get(url);
    driver.findElement(By.id("identifierId")).clear();
    driver.findElement(By.id("identifierId")).sendKeys(Email);
    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
    Thread.sleep(2000);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(Password);
    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
    Thread.sleep(60000);
    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
    Thread.sleep(3000);
    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
    System.out.println("Refresh button Clicked");
    Thread.sleep(20000);
    driver.findElement(By.xpath("//span/b[text()='e-EC - Project re-assigned for Review']")).click();
    Thread.sleep(6000);
    Thread.sleep(2000);
	/*driver.findElement(By.cssSelector("span.gb_bb.gbii")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("gb_71")).click();
	Thread.sleep(2000);*/
	

	
	
	
}


public static void MsdecisionrMailLOP(String url, String Email, String Password) throws InterruptedException {
	
	driver.get(url);
    driver.findElement(By.id("identifierId")).clear();
    driver.findElement(By.id("identifierId")).sendKeys(Email);
    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
    Thread.sleep(2000);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(Password);
    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
    Thread.sleep(60000);
    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
    Thread.sleep(3000);
    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
    System.out.println("Refresh button Clicked");
    Thread.sleep(20000);
    driver.findElement(By.xpath("//span/b[text()='Letter of Permission issued by Ethics Committee']")).click();
    Thread.sleep(6000);
    Thread.sleep(2000);
	/*driver.findElement(By.cssSelector("span.gb_bb.gbii")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("gb_71")).click();
	Thread.sleep(2000);
	*/
	
	
}


public static void MsdecisionrMailreturned(String url, String Email, String Password) throws InterruptedException {
	
	driver.get(url);
    driver.findElement(By.id("identifierId")).clear();
    driver.findElement(By.id("identifierId")).sendKeys(Email);
    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
    Thread.sleep(2000);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(Password);
    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
    Thread.sleep(60000);
    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
    Thread.sleep(3000);
    driver.findElement(By.cssSelector(".asf.T-I-J3.J-J5-Ji")).click();
    System.out.println("Refresh button Clicked");
    Thread.sleep(20000);
    driver.findElement(By.xpath("//span/b[text()='e-EC - Project Returned by IEC Admin']")).click();
    Thread.sleep(6000);
    Thread.sleep(2000);
	/*driver.findElement(By.cssSelector("span.gb_bb.gbii")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("gb_71")).click();
	Thread.sleep(2000);*/
	
	
	
}
// ------------- Institute click on home page Method-----------//

public static void ActiveInstitute() throws Exception{
	
	
	FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
	Workbook wb = Workbook.getWorkbook(fi);
	Sheet r1 = wb.getSheet("Data_Sheet");
	
	String Institute_Title_1 = r1.getCell(2,67).getContents();
	
	Thread.sleep(2000);
	
	WebElement i = driver.findElement(By.linkText(Institute_Title_1));
	 if(i.isDisplayed())
	 { 
		 System.out.println("Inside if");
		 Thread.sleep(4000);
		 i.click();
		 
		 
	 }else
	 {
	 Assert.assertEquals("X","Y");
	 }
	 
}



	

public static void DeActiveInstitute() throws Exception{


	FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
	Workbook wb = Workbook.getWorkbook(fi);
	Sheet r1 = wb.getSheet("Data_Sheet");

	String Institute_Title_1 = r1.getCell(2,69).getContents();

	Thread.sleep(2000);
	
	WebElement e = null;
    try {
        e = driver.findElement(By.linkText(Institute_Title_1));
    } catch (NoSuchElementException e1) {
    	
    }
   Assert.assertFalse(e != null);
	
}



public static void Screenshot(String error){

try {
TakesScreenshot st = (TakesScreenshot)driver;
File Source = st.getScreenshotAs(OutputType.FILE);
org.apache.commons.io.FileUtils.copyFile(Source, new File("./ScreenShots/"+error+".png"));
} catch (Exception e) {
// TODO Auto-generated catch block
System.out.println("Exception while taking screen shot"+e.getMessage());
}
}

public static void forgotMail(String url, String Email, String Password)
		throws InterruptedException, BiffException, IOException {

	FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
	Workbook wb = Workbook.getWorkbook(fi);
	Sheet r = wb.getSheet("Institute_Logins");
	Sheet r1 = wb.getSheet("Data_Sheet");
	Sheet r2 = wb.getSheet("Login");

	String Inst = r.getCell(0, 2).getContents();

	String emailvalid = r1.getCell(6, 77).getContents();
	String newpasswd = r1.getCell(8, 77).getContents();

	String urlinst = r2.getCell(1, 0).getContents();

	driver.get(url);

	Thread.sleep(5000);
	driver.findElement(By.id("identifierId")).sendKeys(Email);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("password")).sendKeys(Password);
	
	Thread.sleep(10000);
	driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
	Thread.sleep(30000);

	WebElement link1 = GWait.Wait_GetElementByCSS(".asf.T-I-J3.J-J5-Ji");
	link1.click();

	WebElement link2 = GWait.Wait_GetElementByCSS(".asf.T-I-J3.J-J5-Ji");
	link2.click();
	Thread.sleep(25000);
	System.out.println("Refresh button Clicked");
	Thread.sleep(25000);

	try {
		List<WebElement> a = driver.findElements(By.xpath("//span/b[text()='Your Password Reset Link']"));
		System.out.println(a.size());
		for (int i = 0; i <= a.size(); i++) {
			System.out.println(a.get(i).getText());
			if (a.get(i).getText().equals("You have been invited for the project")) {
				a.get(i).click();
				WebElement link4 = GWait
						.Wait_GetElementByXpath("//div[starts-with(@class,'a3s aXjCH m1')]/div[2]/div[2]/a");
				link4.click();

				// driver.findElement(By.xpath("//div[starts-with(@class,'a3s
				// aXjCH
				// m15f')]div[2]/div[2]/a/a")).click();

				Thread.sleep(20000);

				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				WebElement button = GWait.Wait_GetElementByCSS("button.btn.btn-primary");
				button.click();

				WebElement emailalert = GWait.Wait_GetElementById("processing_fee_paid_error");

				assertEquals(emailalert.getText(), "The email field is required.");
				System.out.println(emailalert);

				WebElement pwdalert = GWait.Wait_GetElementByXpath("//form/div[2]/div");
				assertEquals(pwdalert.getText(), "The password field is required.");
				System.out.println(pwdalert);

				WebElement emailfield = GWait.Wait_GetElementByName("email");
				emailfield.clear();

				WebElement emailfield1 = GWait.Wait_GetElementByName("email");
				emailfield1.sendKeys(emailvalid);

				WebElement pwdfield = GWait.Wait_GetElementByName("password");
				pwdfield.clear();

				WebElement pwdfield1 = GWait.Wait_GetElementByName("password");
				pwdfield1.sendKeys(newpasswd);

				WebElement pwdconfrmfield = GWait.Wait_GetElementByName("password_confirmation");
				pwdconfrmfield.clear();

				WebElement pwdconfrmfield1 = GWait.Wait_GetElementByName("password_confirmation");
				pwdconfrmfield1.sendKeys(newpasswd);

				WebElement button1 = GWait.Wait_GetElementByCSS("button.btn.btn-primary");
				button1.click();
				Thread.sleep(2000);

				// After password set login with that password

				driver.get(urlinst);

				WebElement institutelink = GWait.Wait_GetElementByLinkText(Inst);
				institutelink.click();

				WebElement instituteemail = GWait.Wait_GetElementById(("register_email"));
				instituteemail.sendKeys(emailvalid);

				WebElement institutepwd = GWait.Wait_GetElementById(("register_password"));
				institutepwd.sendKeys(newpasswd);

				WebElement instituterole = GWait.Wait_GetElementById(("register_role"));
				Select dropdown = new Select(instituterole);
				dropdown.selectByValue("1");
				Thread.sleep(6000);

				((JavascriptExecutor) driver).executeScript("scroll(250,0);");

				WebElement institutelogin = GWait.Wait_GetElementById(("login_institute"));
				institutelogin.click();

				WebElement institutelogout = GWait.Wait_GetElementByXpath(("//span/a"));
				institutelogout.click();

				String winHandleBefore1 = "";
				driver.switchTo().window(winHandleBefore1);

			}
		}
	} catch (Exception e) {
		e.getMessage();
	}
	
	
}

public static void PIMail_rej(String url, String Email, String Password) throws InterruptedException {

	driver.get(url);

	Thread.sleep(5000);
	driver.findElement(By.id("identifierId")).sendKeys(Email);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("password")).sendKeys(Password);
	
	Thread.sleep(10000);
	driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
	Thread.sleep(30000);
	
	
	WebElement link1 = GWait.Wait_GetElementByCSS(".asf.T-I-J3.J-J5-Ji");
	link1.click();

	WebElement link2 = GWait.Wait_GetElementByCSS(".asf.T-I-J3.J-J5-Ji");
	link2.click();
	Thread.sleep(20000);
	System.out.println("Refresh button Clicked");
	Thread.sleep(20000);

	WebElement text = GWait.Wait_GetElementByXpath("//span/b[text()='e-EC - You have been Registered as PI']");

	try {
		if (text.isDisplayed()) {

			System.out.println("e-EC - You have been Registered as PI");
		} else {
			System.out.println("No Mail for 'e-EC - You have been Registered as PI'");
		}
	} catch (NoAlertPresentException e) {
		e.getMessage();
	}

	WebElement link3 = GWait.Wait_GetElementByXpath(
			"//span/b[text()='e-EC - Rejected: Request to Register as Principal Investigator']");
	link3.click();

}

public static void AdminMail_update(String url, String Email, String Password) throws Exception {

	FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
	Workbook wb1 = Workbook.getWorkbook(fi);

	Sheet r1 = wb1.getSheet("Data_Sheet");
	Sheet r2 = wb1.getSheet("Login");
	Sheet r3 = wb1.getSheet("Institute_Logins");

	String Admin_Role = r1.getCell(20, 83).getContents();

	String URL = r2.getCell(1, 0).getContents();

	String Inst_tite = r1.getCell(2, 83).getContents();
	String admin_email = r1.getCell(12, 83).getContents();
	String password = r1.getCell(22, 83).getContents();

	driver.get(url);

	Thread.sleep(5000);
	driver.findElement(By.id("identifierId")).sendKeys(Email);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("password")).sendKeys(Password);
	
	Thread.sleep(10000);
	driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
	Thread.sleep(30000);

	WebElement link1 = GWait.Wait_GetElementByCSS(".asf.T-I-J3.J-J5-Ji");
	link1.click();

	WebElement link2 = GWait.Wait_GetElementByCSS(".asf.T-I-J3.J-J5-Ji");
	link2.click();
	Thread.sleep(30000);
	System.out.println("Refresh button Clicked");
	Thread.sleep(30000);

	WebElement link3 = GWait
			.Wait_GetElementByXpath("//span/b[text()='e-EC - You have been Registered as IEC Admin by e-EC']");
	link3.click();

	WebElement link4 = GWait.Wait_GetElementByXpath("//div[starts-with(@class,'a3s aXjCH m1')]/a");
	link4.click();
	Thread.sleep(6000);
	Thread.sleep(2000);

	String winHandleBefore = driver.getWindowHandle();

	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
	}

	WebElement passd = GWait.Wait_GetElementByName("activation_password");
	passd.sendKeys(password);

	String Password1 = passd.getAttribute("Value");

	WebElement updatebutton = GWait.Wait_GetElementById("activation_update_id");
	updatebutton.click();
	Thread.sleep(6000);

	Thread.sleep(2000);

	
	File source = new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
	FileInputStream input = new FileInputStream(source);
	HSSFWorkbook wb = new HSSFWorkbook(input);

	HSSFSheet sheet = wb.getSheetAt(0);
	sheet.getRow(15).createCell(0).setCellValue(Inst_tite);
	sheet.getRow(15).createCell(1).setCellValue(admin_email);
	sheet.getRow(15).createCell(2).setCellValue(password);

	FileOutputStream output = new FileOutputStream(source);
	wb.write(output);
	wb.close();
/*
	String winHandleBefore1 = "";
	driver.switchTo().window(winHandleBefore1);*/

}


public static void PIMail4changepwd(String url, String Email, String Password) throws Exception {

	FileInputStream fi = new FileInputStream("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
	Workbook wb1 = Workbook.getWorkbook(fi);

	// Sheet r = wb1.getSheet("Emails_Data");
	Sheet r1 = wb1.getSheet("Projects");
	Sheet r2 = wb1.getSheet("Login");
	Sheet r3 = wb1.getSheet("Institute_Logins");

	// String Admin_Role = r3.getCell(3, 1).getContents();

	String URL = r2.getCell(1, 0).getContents();

	String PI_Reg_Institute = r3.getCell(0, 2).getContents();

	String PI_email = r1.getCell(8, 23).getContents();
	String pwd = r1.getCell(25, 23).getContents();

	driver.get(url);

	Thread.sleep(5000);
	driver.findElement(By.id("identifierId")).sendKeys(Email);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
	Thread.sleep(3000);
	driver.findElement(By.name("password")).sendKeys(Password);
	
	Thread.sleep(10000);
	driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
	Thread.sleep(30000);

	WebElement link1 = GWait.Wait_GetElementByCSS(".asf.T-I-J3.J-J5-Ji");
	link1.click();

	WebElement link2 = GWait.Wait_GetElementByCSS(".asf.T-I-J3.J-J5-Ji");
	link2.click();
	Thread.sleep(30000);
	System.out.println("Refresh button Clicked");
	Thread.sleep(30000);

	try {
		
		List<WebElement> a = driver.findElements(
				By.xpath("//span/b[text()='e-EC - Approved: Request to Register as Principal Investigator']"));
		System.out.println(a.size());
		for (int i = 0; i <= a.size(); i++) {
			System.out.println(a.get(i).getText());
			if (a.get(i).getText().equals("e-EC - Approved: Request to Register as Principal Investigator")) {
				a.get(i).click();
				WebElement link4 = GWait.Wait_GetElementByXpath("//div[starts-with(@class,'a3s aXjCH m1')]/a");
				link4.click();

				Thread.sleep(6000);

				Thread.sleep(2000);

				String winHandleBefore = driver.getWindowHandle();

				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}

				/*WebElement save1 = GWait.Wait_GetElementById("savedoc");
				save1.click();*/

				WebElement pwdd = GWait.Wait_GetElementByName("password");
				pwdd.sendKeys(pwd);

				String Password1 = pwdd.getAttribute("Value");

				WebElement save2 = GWait.Wait_GetElementById("savedoc");
				save2.click();
				Thread.sleep(6000);
				// System.out.println(forgotspwdmsg.getText());
				Thread.sleep(2000);

				/*String winHandleBefore1 = "";
				driver.switchTo().window(winHandleBefore1);*/

				File source = new File("C:\\Selenium_Files\\Create4_v2\\CReATE4_Data.xls");
				FileInputStream input = new FileInputStream(source);
				HSSFWorkbook wb = new HSSFWorkbook(input);

				HSSFSheet sheet = wb.getSheetAt(0);
				sheet.getRow(14).createCell(0).setCellValue(PI_Reg_Institute);
				sheet.getRow(14).createCell(1).setCellValue(PI_email);
				sheet.getRow(14).createCell(2).setCellValue(pwd);

				FileOutputStream output = new FileOutputStream(source);
				wb.write(output);
				wb.close();

			}break;
		}
		
	} catch (Exception e) {
		e.getMessage();
	}
		
	

}

}