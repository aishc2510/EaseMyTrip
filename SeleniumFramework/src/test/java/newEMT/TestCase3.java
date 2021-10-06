package newEMT;
//login with invalid otp
import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCase3 { 
    static WebDriver driver; 
    Properties prop = new Properties();
    @Test
    public void TestCase1() throws Exception {
        driver.get("https://www.easemytrip.com/");
        driver.findElement(By.id("spnMyAcc")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space(🙁'Login or Signup']")).click();
        driver.findElement(By.id("txtEmail")).sendKeys("pfshsuipkemjokpvfm@sdvgeft.com");
        driver.findElement(By.id("shwotp")).click();
        // String error =   driver.findElement(By.id5454("RegValidEmail")).getText();
        // Assert.assertEquals("* Enter a valid Email", error);
        System.out.println("Enter OTP:");
        Scanner sc=new Scanner(System.in);
        int OTP = sc.nextInt();
        driver.findElement(By.id("txtEmail1")).sendKeys(String.valueOf(OTP));
        driver.findElement(By.id("OtpLgnBtn")).click();    
        String error =   driver.findElement(By.id("ValidOtp")).getText();
        Assert.assertEquals("", error);

    }

    @BeforeTest

    public void beforeTest() throws Exception {

        String projectPath = System.getProperty("user.dir");
        InputStream input = new FileInputStream(projectPath+"/src/test/java/newEMT/config.properties");
        prop.load(input);

        //prop.load(new FileInputStream("src/config.properties"));
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aishw\\OneDrive\\Desktop\\Aishwarya\\LTI\\Testing\\chromedriver.exe");
        driver=new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));
        driver.manage().window().maximize();

    }

    @AfterTest

    public void afterTest() throws Exception {
        //Thread.sleep(2000);
        //driver.quit();

    }

}