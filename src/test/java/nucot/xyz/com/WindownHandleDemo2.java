package nucot.xyz.com;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class WindownHandleDemo2 {
    
    
static WebDriver odriver;
    
    @Test
    void windownHandleDemo() throws InterruptedException
    {
    
        odriver=new ChromeDriver();
        odriver.manage().deleteAllCookies();
        odriver.manage().window().maximize();
        
        odriver.get("https://www.naukri.com/nlogin/login");
        Thread.sleep(3000);
        
        
        String parentwindowId=odriver.getWindowHandle();
        System.out.println(parentwindowId);
        
        
        Set<String> allWindowIds=odriver.getWindowHandles();
        
        Iterator<String> it=allWindowIds.iterator();
        while(it.hasNext())
        {
            
            String childWindowId=it.next();
            if(!parentwindowId.equals(childWindowId))
            {
                //parentWindow is not equal child
                odriver.switchTo().window(childWindowId);
                System.out.println(odriver.switchTo().window(childWindowId).getTitle());
                odriver.close();
                
            }
            //switching back to parent window
            odriver.switchTo().window(parentwindowId);
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    }


}
