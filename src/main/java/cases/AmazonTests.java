package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonTests {

    public WebDriver driver;
    String url = "https://www.amazon.in";

    @BeforeMethod
    public void setupTest(){

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyLG(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("lg washing machine");
        driver.findElement(By.id("twotabsearchtextbox")).submit();
        driver.findElement(By.xpath("//span[text()='LG']")).click();
        List<WebElement> names = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement val: names){
            String str = val.getText();
            System.out.println(str);
        }
        int num;
        List<Integer> intArr = new ArrayList<>();
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        for (WebElement val: prices){
            String str = val.getText();
            String str2 = str.replace(",","");
            num = Integer.parseInt(str2);
            intArr.add(num);
        }

        Collections.sort(intArr, Collections.reverseOrder());

        for (Integer val : intArr) {
            System.out.println("LG Washing Machine Price In Descending Order :- " +val);

        }
    }

    @Test
    public void verifySamsung(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung washing machine");
        driver.findElement(By.id("twotabsearchtextbox")).submit();

        driver.findElement(By.xpath("//span[text()='Samsung']")).click();
        List<WebElement> names = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement val: names){
            String str = val.getText();
            System.out.println(str);
        }
        int num;
        List<Integer> intArr = new ArrayList<>();
        List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        for (WebElement val: prices){
            String str = val.getText();
            String str2 = str.replace(",","");
            num = Integer.parseInt(str2);
            intArr.add(num);
        }

        Collections.sort(intArr, Collections.reverseOrder());
        for (Integer val : intArr) {
            System.out.println("Samsung Washing Machine Price In Descending Order :- " +val);

        }

    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
