package aoltestngpackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AOLTestNG
	{
        public String baseUrl          = "http://www.aol.com";
        public String txtLine1         = "News";
        public String txtLine2         = "Sports";
        public String txtLine3         = "Entertainment";
        public String txtLine4         = "Mail";
        public String txtLine5         = "Web";
        public String LandingPageTitle = "AOL - News, Sports, Weather, Entertainment, Local & Lifestyle";
        public String SearchPageTitle  = "AOL Autos - AOL Search Results";
        public String searchText       = "AOL Autos";
        public String linkSelect       = "Site Map - AOL Autos - Autoblog";
        public String actualTitle      = "";
		
        public static WebDriver driver = new FirefoxDriver();
        public WebDriverWait wait      = new WebDriverWait(driver, 5);
        
		@BeforeTest
		public void OpenURL()
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.titleContains(LandingPageTitle));
				driver.get(baseUrl);
			}
		
		@Test(priority = 1)
		public void Verify_title()
			{
	        	actualTitle = driver.getTitle();
	        	Assert.assertEquals(actualTitle, LandingPageTitle);
			}
		
		@Test(priority = 2)
		public void News_Link()
			{
	        	if(driver.getPageSource().contains(txtLine1))
	        		{
	        			if (driver.getPageSource().contains(txtLine1))
	        				{
	        					Assert.assertTrue(true);
	        				}
	        		}
	        	else
	        		{
	        			Assert.assertFalse(true);
	        		}
			}
		
		@Test(priority = 3)
		public void Sports_Link()
		{
        	if(driver.getPageSource().contains(txtLine2))
        		{
        			if (driver.getPageSource().contains(txtLine2))
        				{
        					Assert.assertTrue(true);
        				}
        		}
        	else
        		{
        			Assert.assertFalse(true);
        		}
		}	

		@Test(priority = 4)
		public void Entertainment_Link()
		{
        	if(driver.getPageSource().contains(txtLine3))
        		{
        			if (driver.getPageSource().contains(txtLine3))
        				{
        					Assert.assertTrue(true);
        				}
        		}
        	else
        		{
        			Assert.assertFalse(true);
        		}
		}

		@Test(priority = 5)
		public void Web_Search()
		{
	        WebElement element = driver.findElement(By.name("q"));
	        element.sendKeys(searchText);
	        element.submit();
        	
        	if(driver.getTitle().contains(SearchPageTitle))
        		{
        			Assert.assertTrue(true);
        		}
        	else
        		{
        			Assert.assertFalse(true);
        		}
		}
		
		@Test(priority = 6)
		public void Mail_Link()
		{
        	if(driver.getPageSource().contains(txtLine4))
        		{
        			if (driver.getPageSource().contains(txtLine4))
        				{
        					Assert.assertTrue(true);
        				}
        		}
        	else
        		{
        			Assert.assertFalse(true);
        		}
		}

		@Test(priority = 7)
		public void Web_Link()
		{
        	if(driver.getPageSource().contains(txtLine5))
        		{
        			if (driver.getPageSource().contains(txtLine5))
        				{
        					Assert.assertTrue(true);
        				}
        		}
        	else
        		{
        			Assert.assertFalse(true);
        		}
		}

		@Test(priority = 8)
		public void Select_Results()
		{
	        driver.findElement(By.partialLinkText(searchText)).click();
        	
        	if(driver.getTitle().contains(SearchPageTitle))
        		{
        			Assert.assertTrue(true);
        		}
        	else
        		{
        			Assert.assertFalse(true);
        		}
		}
		
		@Test(priority = 9)
		public void AOL_Autos_Logo()
		{
			driver.findElement(By.cssSelector("a[id=\"GH_brand_link\"]"));
        	
        	if(driver.getTitle().contains(SearchPageTitle))
        		{
        			Assert.assertTrue(true);
        		}
        	else
        		{
        			Assert.assertFalse(true);
        		}
		}
		
		@AfterTest
		public void endTest()
			{
				driver.quit();
			}
}
