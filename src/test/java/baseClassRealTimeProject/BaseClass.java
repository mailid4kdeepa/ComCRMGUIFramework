package baseClassRealTimeProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.Loginpage;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.fileutility.FileUtility;
import com.crm.generic.webdriverutulity.JavaUtility;

public class BaseClass {
	
public FileUtility flib=new FileUtility();
public ExcelUtility elib=new ExcelUtility();
public JavaUtility jlib=new JavaUtility();
 public WebDriver driver=null;

	

@BeforeSuite
	public void configBS()
	{
		System.out.println("=======connect to DB=======");
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("=========close DB==========");
		System.out.println("=========close DB==========");
		System.out.println("=========close DB==========");
		System.out.println("=========close DB==========");
	}

	
	@BeforeClass
	public void configBC() throws Throwable
	{
		System.out.println("===launch the browser======");
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		
		 if(BROWSER.equals("chrome"))
		 {
			 driver=new ChromeDriver();
		 }
		 else if(BROWSER.equals("firefox"))
		 {
			 driver=new FirefoxDriver();
		 }
		 else if(BROWSER.equals("Edge"))
		 {
			 driver=new EdgeDriver();
		 }
		 else
		 {
			 driver=new ChromeDriver();
		 }
		 
	}
	
	@AfterClass
	public void configAC()
	{
		System.out.println("=====close the Browser=====");
		driver.quit();
	}
	@BeforeMethod
	public void configBM() throws Throwable
	{
		System.out.println("====login======");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD= flib.getDataFromPropertiesFile("password");
		Loginpage lp=new Loginpage(driver);
		lp.LoginToappWithUrl(URL, USERNAME, PASSWORD);
	}
	
	@AfterMethod
	public void configAM()
	{
		System.out.println("====logout==========");
		HomePage hp=new HomePage(driver);
		hp.signout();
		
	}
	
	
}
