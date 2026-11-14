package automatizacion;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC003ValidarFormulario {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void incializarNavegador() {
        //Inicializar driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Inicializar wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        

    }

    private void pausa()throws InterruptedException {
        Thread.sleep(5000);
    }

    @Test
    public void CompletarFormularioDeContacto() throws InterruptedException{

        //Abrir el formulario
        driver.get("https://www.automationtesting.co.uk/contactForm.html");

        pausa();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");

        //Completar el nombre
        WebElement nombre = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".feedback-input:nth-child(1)")));nombre.sendKeys("Fran");
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector(".feedback-input:nth-child(1)"), "value", "Fran"));


        js.executeScript("document.body.style.zoom='70%'");

        pausa();
        //Completar el apellido
        WebElement apellido = wait.until(ExpectedConditions.elementToBeClickable(By.name("last_name")));apellido.sendKeys("Artiga");
        wait.until(ExpectedConditions.attributeToBe(By.name("last_name"), "value", "Artiga"));

        js.executeScript("document.body.style.zoom='50%'");

        pausa();

        //Completar el email
        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));email.sendKeys("fran.artiga@example.com");
        wait.until(ExpectedConditions.attributeToBe(By.name("email"), "value", "fran.artiga@example.com"));

        js.executeScript("document.body.style.zoom='30%'");

        pausa();
        //Completar el comentario
        WebElement comentario = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("textarea[placeholder='Comments']")));comentario.sendKeys("Este es un comentario de prueba");
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("textarea[placeholder='Comments']"), "value", "Este es un comentario de prueba"));

       

        //Enviar informacion del formulario
        WebElement botonSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='SUBMIT']")));
        
        js.executeScript("document.body.style.zoom='80%'");

        pausa();
        botonSubmit.click();

        pausa();

        //Validar mensaje de login exitoso
        WebElement mensajeLoginExitoso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='col-8 col-12-small'] h3")));

        Assertions.assertEquals("Thank you for your mail!", mensajeLoginExitoso.getText(), "El mensaje de login exitoso no es el esperado");    

    }


    @AfterEach
    public void cerrarSesion() {
     driver.quit();
        }
}
