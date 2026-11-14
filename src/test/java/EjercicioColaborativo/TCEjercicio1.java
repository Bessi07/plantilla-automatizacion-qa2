package EjercicioColaborativo;

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
import org.openqa.selenium.support.ui.WebDriverWait;

public class TCEjercicio1 {

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
        Thread.sleep(3000);
    }
    @Test 
    public void validarDetalleProducto() throws InterruptedException {

        //Validar URL del detalle del producto
        driver.get("https://teststore.automationtesting.co.uk/index.php");
        pausa();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='70%'");


       //Validar que el nombre del producto no esté vacío - CUADRO
        driver.findElement(By.cssSelector("img[alt='Today is a good day Framed poster']")).click();
      
        
         String nombreDeProductoEsperado = "TODAY IS A GOOD DAY FRAMED POSTER";
         Assertions.assertEquals(nombreDeProductoEsperado, driver.findElement(By.cssSelector(".h1")).getText(), "El nombre del producto no es el esperado");
       
         
        //Validar que el precio sea visible
        WebElement precioDelProducto = driver.findElement(By.cssSelector(".current-price-value"));
        String precioVisible = precioDelProducto.getText();
        Assertions.assertTrue(!precioVisible.isEmpty(), "El precio del producto es visible");


        //Validar que el botón "Add to cart" esté habilitado
        driver.findElement(By.cssSelector(".btn.btn-primary.add-to-cart")).click();
        pausa();

        //Validar que el producto se haya agregado al carrito
        WebElement ProductoAgregado = driver.findElement(By.cssSelector(".cart-products-count"));
        

        //Validar actualización del contador del carrito.
        String cantidadDeProductos = ProductoAgregado.getText();
        Assertions.assertTrue(!cantidadDeProductos.isEmpty(), "El producto se ha agregado al carrito");


        // Validar que el nombre del producto en el carrito sea el mismo que el seleccionado.
        driver.findElement(By.cssSelector(".cart-content .cart-products-count")).click();
        pausa();    

        String nombreProductoEnCarrito = driver.findElement(By.xpath("/html//section[@id='main']//h1[@class='h1']")).getText();
        Assertions.assertEquals(nombreDeProductoEsperado, nombreProductoEnCarrito, "El nombre del producto en el carrito no coincide con el seleccionado"); 
    



    }
    
    @AfterEach 
    public void cerrarNavegador() {
        driver.quit();
    }

}

