package automatizacion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC002ValidacionDeLogin {
//Script para validar Login Page
    WebDriver driver;


//Acciones que se van a ejecutar antes de cada test.
    @BeforeEach 
    public void incializarNavegador() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

// Test 1: Validar el titulo de la pagina antes de realizar el login
    @Test
    public void validarTituloDeLaPagina() {

        //Abrir nuestro navegador
        driver.get("https://the-internet.herokuapp.com/login");

        //Obtener titulo del sitio web
       
        String tituloActual = driver.getTitle();
        String tituloEsperado = "The Internet";
        //Validar el titulo del sitio web
        Assertions.assertEquals(tituloEsperado, tituloActual, "El titulo de la pagina no es el esperado");

        System.out.println("Titulo de la pagina validado correctamente");
    }  
    
// Test 2: Validar el login exitoso
    @Test
    public void validarLoginExitoso() {

        //Abrir nuestro navegador
        driver.get("https://the-internet.herokuapp.com/login");

        //Ingresar las credenciales de autenticación
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
  //Validacion de URL
        String urlEsperada = "https://www.automationtesting.co.uk/contact-form-thank-you.html";      
        Assertions.assertEquals(urlEsperada, driver.getCurrentUrl(), "La URL no es la esperada");

        driver.findElement(By.className("radius")).click();

      
        
        //Validacion de mensaje de login exitoso
        WebElement mensajeLoginExitoso = driver.findElement(By.id("flash"));
        String textoMensaje = mensajeLoginExitoso.getText();

        //Uso de condicional para validar el mensaje de login exitoso
        if (textoMensaje.contains("You logged into a secure area!")) {
            System.out.println("Login exitoso y mensaje validado correctamente");
        } else {
            System.out.println("Error en el mensaje de login encontrado");

            Assertions.fail("Se esperaba el mensaje: You logged into a secure area!" + "\n pero se encontró: " + textoMensaje);
        }
    }
//Acciones que se van a ejecutar despues de cada test.
    @AfterEach
    public void cerrarSesion() {
     driver.quit();
        }
    }

