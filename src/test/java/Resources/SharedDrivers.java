package Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SharedDrivers {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        ChromeOptions option = new ChromeOptions();
        if(driver==null)
        {
            option.addArguments("--remote-allow-origins=*");
            driver=new ChromeDriver(option);

        }
        return driver;
    }
}
