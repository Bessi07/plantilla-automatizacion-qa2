package automatizacion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejercicio1 {
//Script para validar Login Page
    WebDriver driver;

//Acciones que se van a ejecutar antes de cada test.
    @BeforeEach 
    public void incializarNavegador() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

//Test 1: Abrir el navegador
    @Test
    public void validarTituloDeLaPagina() {

        driver.get("https://www.automationtesting.co.uk/contactForm.html");

       
    }  
//Test 2: Validar el login exitoso
    @Test
    public void validarLoginExitoso() {

        //Abrir nuestro navegador
        driver.get("https://www.automationtesting.co.uk/contactForm.html");

        //Ingresar las credenciales de autenticación
        driver.findElement(By.cssSelector(".feedback-input:nth-child(1)")).sendKeys("Fran");
        driver.findElement(By.name("last_name")).sendKeys("Artiga");
        driver.findElement(By.name("email")).sendKeys("fran.artiga@test.com");
        driver.findElement(By.name("message")).sendKeys("Hola, este es un mensaje de prueba para validar el formulario de contacto.");
        driver.findElement(By.xpath("//*[@value='SUBMIT']")).click();

        //Validación de URL
        String urlEsperada = "https://www.automationtesting.co.uk/contact-form-thank-you.html";
        Assertions.assertEquals(urlEsperada, driver.getCurrentUrl(), "La URL no es la esperada");
        
        //Validacion de formulario llenado con exito.
        WebElement formularioCompletado = driver.findElement(By.cssSelector("div[class='col-8 col-12-small'] h3"));
        String tituloFormulario = formularioCompletado.getText();


        //Uso de condicional para validar el mensaje de exito del formulario

        if (tituloFormulario.equals("Thank you for your mail!")) {
            System.out.println("Formulario llenado con éxito.");
        } else {
            System.out.println("Formulario no se llenó correctamente.");

            Assertions.fail("No se llenó el formulario correctamente.");
            

        }


    }

    //Acciones que se van a ejecutar después de cada test.
    @AfterEach
    public void cerrarNavegador() {
        driver.quit();
    }
}
    
    

