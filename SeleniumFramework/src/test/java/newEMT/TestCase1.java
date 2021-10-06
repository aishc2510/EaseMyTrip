package newEMT;
//Login with valid credentials
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
import org.testng.annotations.AfterTest;

public class TestCase1 { 
    static WebDriver driver; 
    Properties prop = new Properties();

    @Test (enabled = true, priority= 1)
    public void TestCase1() throws Exception {
        driver.get(prop.getProperty("url"));
        Thread.sleep(10000);
        driver.findElement(By.id("spnMyAcc")).click();
        Thread.sleep(2000);
        //  driver.findElement(By.xpath(prop.getProperty("LoginOrSignUp"))).click();
        driver.findElement(By.id(prop.getProperty("LoginOrSignUp2"))).click();
        driver.findElement(By.id(prop.getProperty("EnterEmail"))).sendKeys(prop.getProperty("signupMail"));
        driver.findElement(By.id(prop.getProperty("Continue"))).click();
        System.out.println("Enter OTP:");



        Scanner sc=new Scanner(System.in);
        int OTP = sc.nextInt();
        driver.findElement(By.id(prop.getProperty("EnterOTP"))).sendKeys(String.valueOf(OTP));
        driver.findElement(By.id(prop.getProperty("CreateMyAccount"))).click();     
    }


    @BeforeTest

    public void beforeTest() throws Exception {

    //    String projectPath = System.getProperty("user.dir");
        InputStream input = new FileInputStream("C:\\Users\\aishw\\eclipse-workspace\\SeleniumFramework\\src\\test\\java\\newEMT\\config.properties");
        prop.load(input);

        //prop.load(new FileInputStream("src/config.properties"));
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aishw\\OneDrive\\Desktop\\Aishwarya\\LTI\\Testing\\chromedriver.exe");
        driver=new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));
        driver.manage().window().maximize();


    }


    @AfterTest

    public void afterTest() throws Exception {
        Thread.sleep(2000);
        driver.quit();

    }

}
