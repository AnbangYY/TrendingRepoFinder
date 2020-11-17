package main.java.com.company;


import java.util.ArrayList;


import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WatchRepos {

    private static final String username = "";
    private static final String password = "";


    @Test
    public void watchTrending() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://github.com/login");
        WebElement elemUsername = driver.findElement(By.id("login_field"));
        WebElement elemPassword = driver.findElement(By.id("password"));
        WebElement btn = driver.findElement(By.cssSelector("input[class='btn btn-primary btn-block']"));
        elemUsername.sendKeys(username);
        elemPassword.sendKeys(password);
        btn.submit();



        Scrapper.getTrendingProjects("https://github.com/trending/python?since=monthly&spoken_language_code=en", 15);
        ArrayList<Project> projects = Scrapper.getList();
        driver.get("https://github.com/trending/python?since=monthly&spoken_language_code=en");
        for (Project p:projects
             ) {
            driver.get("https://github.com/"+p.organization.strip()+"/"+p.name.strip());
            JavascriptExecutor jse = (JavascriptExecutor) driver;
           WebElement watchButton = driver.findElement(By.cssSelector("details[class='details-reset details-overlay select-menu hx_rsm']"));
           watchButton.click();
           Thread.sleep(1000);
            WebElement releaseOnlyBtn = driver.findElement(By.xpath("//Button[@value='release_only']"));
            releaseOnlyBtn.click();
            Thread.sleep(1000);
            driver.navigate().back();
        }

    }

}
