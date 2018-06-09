import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UnreadEmails {

    public static String unread;
    public static void main(String [] args){


        System.setProperty("Webdriver.chrome.driver","chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://www.mail.google.com");

        driver.findElement(By.cssSelector("#identifierId")).sendKeys("*******@gmail.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.id("#someId")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.findElement(By.id("#PasswordId")).sendKeys("Password");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.id("#SendButtonId")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        List<WebElement> UnreadEmail = driver.findElements(By.xpath("Path" ));


        for(int i = 0; i < UnreadEmail.size(); i++){

            if(UnreadEmail.get(i).isDisplayed() == true){
                if (UnreadEmail.get(i).getText().equals(unread))
                {
//                    MyMails = primaryEmail.get(i).getText();
                    System.out.println("Primary Emails are: " + unread);
                }
                break;
            }
        }


        driver.close();
        driver.quit();


    }
}
