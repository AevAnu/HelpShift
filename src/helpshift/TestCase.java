

package helpshift;

import static helpshift.Helpshift.logger;
import java.util.List;
import java.util.logging.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestCase {
    
    private String link ;
    private String name;
    private String emailid;
    private String desciption;
    
    //private FileHandler fh;
    private WebDriver _Driver =null;
    private String browser = null; 
    
    public TestCase(String _Browser)
    {
      link = new String();
      link = "http://test.helpshift.com";
      name = new String();
      name = "anuradha";
      emailid = new String();
      emailid = "abc@abc.com";
      desciption = new String();
      desciption = "test description of contact us";
      browser = _Browser;
           
    }
    private void __SetUP()
    {
        if(browser.equalsIgnoreCase("firefox"))
        {
            _Driver = new FirefoxDriver();
            logger.info("SetUP WebDriver for Firefox Browser.");
        }    
        else if(browser.equalsIgnoreCase("IE"))    
        {
            System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
            _Driver = new InternetExplorerDriver();
            logger.info("SetUP WebDriver for IE Browser.");
        }
        else if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            _Driver = new ChromeDriver();
            logger.info("SetUP WebDriver for Chorme Browser.");
        }
        else
        {
            logger.info("NO Valid Browser.");
        }
    }
    
    private void __CleanUP()
    {
        _Driver.quit();
    }
    public void VerifyContactUs()
    {
        logger.info("Test Case : VerifyContactUs started");
        __SetUP();
        _Driver.get(link);
        _Driver.findElement(By.id("new-issue")).click();
        _Driver.findElement(By.id("user-name")).sendKeys(name);
        _Driver.findElement(By.id("user-email")).sendKeys(emailid);
        _Driver.findElement(By.id("user-issue")).sendKeys(desciption);
        _Driver.findElement(By.className("modal-submit-button")).submit();
        //WebDriverWait wait = new WebDriverWait(_Driver, 5);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".content-wrapper .message-wrapper")));
        String receivedMsg = _Driver.findElement(By.cssSelector(".content-wrapper .message-wrapper")).getText();
        String expectedMsg = "Thanks for contacting us. Your message was received.";
        logger.log(Level.INFO, "Received Msg = {0}", receivedMsg);
        logger.log(Level.INFO, "Expected Msg = {0}", expectedMsg);
        try
        {
            assertEquals("Comparision of error msgs :",expectedMsg,receivedMsg);
            logger.info("Test Case : VerifyEmptyEmailid passed");
        }
        catch(org.junit.ComparisonFailure e)
        {
            logger.warning("Test Case : VerifyContactUs Failed");
        }
            logger.info("Test Case : VerifyContactUs end");
        __CleanUP();
}
        
    
    public void VerifyEmptyEmailid()
    {
        logger.info("Test Case : VerifyEmptyEmailid started");
        __SetUP();
        _Driver.get(link);
        logger.info(_Driver.getTitle());
        logger.info(_Driver.getCurrentUrl());
        _Driver.findElement(By.id("new-issue")).click();
        _Driver.findElement(By.id("user-name")).sendKeys(name);       
        _Driver.findElement(By.id("user-issue")).sendKeys(desciption);         
        _Driver.findElement(By.className("modal-submit-button")).submit();
        String actualErrMsg = _Driver.findElement(By.className("error-msg")).getText().trim();
        String expectedErrMsg = "Email is a required field";
        logger.log(Level.INFO, "Actual ErrMsg = {0}", actualErrMsg);
        logger.log(Level.INFO, "Expected ErrMsg = {0}", expectedErrMsg);
        try
        {
            assertEquals("Comparision of error msgs :",expectedErrMsg,actualErrMsg);
            logger.info("Test Case : VerifyEmptyEmailid passed");
        }
        catch(org.junit.ComparisonFailure e)
        {
            logger.warning("Test Case : VerifyEmptyEmailid Failed");
        }
            logger.info("Test Case : VerifyEmptyEmailid end");
        __CleanUP();
    }
    
     public void VerifyEmptyDescription()  
     {
        logger.info("Test Case : VerifyEmptyDescription started");
        __SetUP();
        _Driver.get(link);
        logger.info(_Driver.getTitle());
        logger.info(_Driver.getCurrentUrl());
        _Driver.findElement(By.id("new-issue")).click();
        _Driver.findElement(By.id("user-name")).sendKeys(name);       
        _Driver.findElement(By.id("user-issue")).sendKeys(desciption);        
        _Driver.findElement(By.className("modal-submit-button")).submit();
        String actualErrMsg = _Driver.findElement(By.className("error-msg")).getText().trim();
        String expectedErrMsg = "Problem description is a required field";
        logger.log(Level.INFO, "Actual ErrMsg = {0}", actualErrMsg);
        logger.log(Level.INFO, "Actual ErrMsg = {0}", expectedErrMsg); 
        try
        {
            assertEquals("Comparision of error msgs :",expectedErrMsg,actualErrMsg);
            logger.info("Test Case : VerifyEmptyDescription pased");
        }
        catch(org.junit.ComparisonFailure e)
        {
            logger.warning("Test Case : VerifyEmptyDescription Failed");
        }
        logger.info("Test Case : VerifyEmptyDescription end");
        __CleanUP();
     }
    
      public void VerifyEmptyDescriptionEmailid()
    {
        logger.info("Test Case : VerifyEmptyDescriptionEmailid started");
        __SetUP();
        _Driver.get(link);
        System.out.println(_Driver.getTitle());
        System.out.println(_Driver.getCurrentUrl());
        _Driver.findElement(By.id("new-issue")).click();
        _Driver.findElement(By.id("user-name")).sendKeys(name);       
        _Driver.findElement(By.className("modal-submit-button")).submit();
        List<WebElement> allOptions = _Driver.findElements(By.className("error-msg"));
        boolean flag = true;
        for     (WebElement option : allOptions) {
            String receivedErrMsg = option.getText();
            String expectedErrMsg ;
            if(flag)
            {
                expectedErrMsg = "Email is a required field";
            }
            else
                expectedErrMsg = "Problem description is a required field";
            logger.log(Level.INFO, "Received ErrMsg = {0}", receivedErrMsg);
            logger.log(Level.INFO, "Expected ErrMsg = {0}", expectedErrMsg); 
            try
            {
                assertEquals("Comparision of error msgs :",expectedErrMsg,receivedErrMsg);
                if(!flag)
                    logger.info("Test Case : VerifyEmptyDescriptionEmailid passed");
            
            }
            catch(org.junit.ComparisonFailure e)
            {
                logger.warning("Test Case : VerifyEmptyDescriptionEmailid Failed");
                break;
            }
            flag = false;
        }
        logger.info("Test Case : VerifyEmptyDescriptionEmailid end");
        __CleanUP();
    }
      
       public void VerifyInvalidEmailid()
    {
        logger.info("Test Case : VerifyInvalidEmailid started");
        __SetUP();
        _Driver.get(link);
        _Driver.findElement(By.id("new-issue")).click();
        _Driver.findElement(By.id("user-name")).sendKeys(name);       
        _Driver.findElement(By.id("user-issue")).sendKeys(desciption);  
        _Driver.findElement(By.id("user-email")).sendKeys(name);
        _Driver.findElement(By.className("modal-submit-button")).submit();
        String receivedErrMsg = _Driver.findElement(By.className("error-msg")).getText().trim();
        String expectedErrMsg = "Please enter a valid email";
        logger.log(Level.INFO, "Actual ErrMsg = {0}", receivedErrMsg);
        logger.log(Level.INFO, "Expected ErrMsg = {0}", expectedErrMsg);
        try
        {
            assertEquals("Comparision of error msgs :",expectedErrMsg,receivedErrMsg);
            logger.info("Test Case : VerifyInvalidEmailid passed");
        }
        catch(org.junit.ComparisonFailure e)
        {
            logger.warning("Test Case : VerifyInvalidEmailid Failed");
        }
            logger.info("Test Case : VerifyInvalidEmailid end");
        __CleanUP();
    }
}