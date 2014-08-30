/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helpshift;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 *
 * @author Administrator
 */
public class Helpshift {
    
    public static final Logger logger = Logger.getLogger("MyLog");
    private FileHandler fh;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Helpshift objHelpShift = new Helpshift();
        objHelpShift.RunTestCaseoverFireFoxBrowser();
        objHelpShift.RunTestCaseoverChromeBrowser();
        //objHelpShift.RunTestCaseoverIEBrowser();
}
  
    private TestCase objFireFox = null;
    private TestCase objIE = null;
    private TestCase objChorme = null;
    
    public Helpshift()
    { 
        try
        {
            this.fh = new FileHandler("LogFile.log");  
            logger.addHandler(fh);  
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.info("Logging started");
        }
        catch(IOException | SecurityException ex)
        {
            Logger.getLogger(Helpshift.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void RunTestCaseoverFireFoxBrowser()
    {
        objFireFox = new TestCase("firefox");
        objFireFox.VerifyEmptyEmailid();
        objFireFox.VerifyContactUs();
        objFireFox.VerifyEmptyDescriptionEmailid();
        objFireFox.VerifyInvalidEmailid();
        objFireFox.VerifyEmptyDescriptionEmailid();
        
    }
    void RunTestCaseoverIEBrowser()
    {
        objIE = new TestCase("IE");
        objIE.VerifyEmptyEmailid();
        objIE.VerifyContactUs();
        objIE.VerifyEmptyDescriptionEmailid();
        objIE.VerifyInvalidEmailid();
        objIE.VerifyEmptyDescriptionEmailid();

    }
    void RunTestCaseoverChromeBrowser()
    {
        objChorme = new TestCase("chrome");
        objChorme.VerifyEmptyEmailid();
        objChorme.VerifyContactUs();
        objChorme.VerifyEmptyDescription();
        objChorme.VerifyEmptyDescriptionEmailid();
        objChorme.VerifyInvalidEmailid();
        //objChorme.VerifyNotExistEmailid();
    }
    
    }
    
