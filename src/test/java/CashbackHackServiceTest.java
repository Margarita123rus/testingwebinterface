import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashbackHackServiceTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {

        System.setProperty("webDriver.chrome.driver", "./driver/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
        void shouldTestSomething() {
        driver.get("http://localhost:9999");
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        elements.get(0).sendKeys("Василий");
        elements.get(1).sendKeys("+79270000000");
        driver.findElement(By.className("checkbox__control")).click();
        driver.findElement(By.className("button")).click();
        String text = driver.findElement(By.className("alert-success")).getText();
        assertEquals("Ваша заявка успешно отправлена!", text.trim());
    }
//    @Test
//    void shouldSubmitRequest(){
//        open("http://localhost:9999");
//        SelenideElement form = $("[data-test-id=callback-form]");
//        form.$("[data-test-id=name]input").setValue("Василий");
//        form.$("[data-test-id=phone]input").setValue("+79270000000");
//        form.$("[data-test-id=agreement]").click();
//        form.$("[data-test-id=submit]").click();
//        $(".alert-success").shouldHave(exactText("Ваша заявка успешно отправлена!"));
//    }
}